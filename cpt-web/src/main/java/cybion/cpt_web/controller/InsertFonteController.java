package cybion.cpt_web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.springframework.web.servlet.mvc.Controller;

import cybion.cpt_web.controller.action.CybionAction;

public class InsertFonteController extends AbstractController implements Controller{
	
	private CybionAction action;


	@Override
  public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
		
		String result = "insertFonte";
		try {
			if(action.doWork(request));
				result = "success";
			
		}catch(Throwable t){}
		String s = (String)request.getAttribute("message");
		ModelAndView m = new ModelAndView(result);
		m.addObject("message", s);
		return m;
	}
	
	
	public CybionAction getAction() {
		return action;
	}


	public void setAction(CybionAction action) {
		this.action = action;
	}
}
