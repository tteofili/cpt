package cybion.cpt_web.controller.action;

import java.io.InputStream;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.log4j.Logger;
import org.jdom.Document;
import org.jdom.input.SAXBuilder;

import cybion.cpt_web.business.utility.DocumentUtils;
import cybion.cpt_web.model.Fonte;
import cybion.cpt_web.model.Interesse;
import cybion.cpt_web.model.NavXML;
import cybion.cpt_web.persistence.PersistenceBroker;

public class InsertFonteAction implements CybionAction{
	
	private static PersistenceBroker broker; //fornisce i servidi di persistenza
	private DocumentUtils docUtils; //classe che fornisce alcuni metodi di utilità per lavorare sui document
	private Logger logger = Logger.getLogger(this.getClass());


	public boolean doWork(HttpServletRequest request) {
		
		logger.info("START UPLOAD FILE");
		boolean result = false;
		
		/* INIZIO FILE UPLOAD */
		try {
			boolean isMultipart = ServletFileUpload.isMultipartContent(request);		
			if(isMultipart){
				ServletFileUpload upload = new ServletFileUpload(new DiskFileItemFactory());
				List<FileItem> itemList =  upload.parseRequest(request);
				logger.info("LETTURA FILE COMPLETATA");
				String fonteDescription = null;
				NavXML xml = null;
				Document d = null;
				char[] schedulingValues = new char[] {'0','0','0','0','0','0','0'};
				List<Integer>interessiList = new LinkedList<Integer>();
				
				/* Parsing dei parametri della richiesta */
				for(FileItem f : itemList){
					if(f.isFormField()){
						if (f.getFieldName().equalsIgnoreCase("fonteDescription"))
							fonteDescription = f.getString();
						else if(f.getFieldName().equalsIgnoreCase("scheduling")) {
							int value = Integer.parseInt(f.getString());
							schedulingValues[value-1] = '1';
						}
						else if(f.getFieldName().equalsIgnoreCase("interessi")) {
							int interessiValue = Integer.parseInt(f.getString());
							interessiList.add(interessiValue);
						}
					}
					else if(!f.isFormField()){
						InputStream stream = f.getInputStream();
						try{
							//costruisce il document
							d  = new SAXBuilder().build(stream);
							} catch(Exception e){logger.error("ERRORE NELLA COSTRUZIONE DEL DOCUMENTO XML",e);}
					}
				}
				//end parsing
				String message = "Hai appena effettuato l'upload del file relativo a <b>"+fonteDescription+"</b>";
				docUtils.createDirectories(fonteDescription);
				String schedulingDescription = String.copyValueOf(schedulingValues);
				Fonte f = new Fonte();
				f.setLink(docUtils.getUrlFromDocument(d));
				f.setNome(fonteDescription);
				f.setScheduling(schedulingDescription);
				f.setSetInteressi(resolveInteressi(interessiList));
				request.setAttribute("message", message);
				xml = docUtils.modifyXml(d, fonteDescription);
				xml.setDescription(fonteDescription);
				f.setXmlDescriber(xml);
				broker.saveFonte(f);
			}
			result = true;
		}
		catch(Exception e){logger.error("ERRORE"+this.getClass().toString(),e);}
		logger.info("END UPLOADFILE");
		return result;
	}
	
	/*Partendo dall'elenco dei parametri costruisce il set di interessi */
	private Set<Interesse> resolveInteressi(List<Integer> interessiList){
		Set<Interesse> setInteressi = new HashSet<Interesse>();
		for(Integer i : interessiList) {
			Interesse interesse = broker.getInteresse(i);
			setInteressi.add(interesse);
		}
		return setInteressi;
	}
	public PersistenceBroker getBroker() {
		return broker;
	}

	public void setBroker(PersistenceBroker broker) {
		InsertFonteAction.broker = broker;
	}
	
	public DocumentUtils getDocUtils() {
		return docUtils;
	}

	public void setDocUtils(DocumentUtils docUtils) {
		this.docUtils = docUtils;
	}
}
