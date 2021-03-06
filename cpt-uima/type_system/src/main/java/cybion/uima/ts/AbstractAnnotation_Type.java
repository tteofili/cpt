/* First created by JCasGen Sun Dec 06 17:19:58 CET 2009 */
package cybion.uima.ts;

import org.apache.uima.cas.FeatureStructure;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.impl.CASImpl;
import org.apache.uima.cas.impl.FSGenerator;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.tcas.Annotation_Type;

/**
 * Updated by JCasGen Sun May 16 14:12:55 CEST 2010
 *
 * @generated
 */
public class AbstractAnnotation_Type extends Annotation_Type {
  /**
   * @generated
   */
  protected FSGenerator getFSGenerator() {
    return fsGenerator;
  }

  /**
   * @generated
   */
  private final FSGenerator fsGenerator =
          new FSGenerator() {
            public FeatureStructure createFS(int addr, CASImpl cas) {
              if (AbstractAnnotation_Type.this.useExistingInstance) {
                // Return eq fs instance if already created
                FeatureStructure fs = AbstractAnnotation_Type.this.jcas.getJfsFromCaddr(addr);
                if (null == fs) {
                  fs = new AbstractAnnotation(addr, AbstractAnnotation_Type.this);
                  AbstractAnnotation_Type.this.jcas.putJfsFromCaddr(addr, fs);
                  return fs;
                }
                return fs;
              } else return new AbstractAnnotation(addr, AbstractAnnotation_Type.this);
            }
          };

  /**
   * @generated
   */
  public final static int typeIndexID = AbstractAnnotation.typeIndexID;

  /**
   * @generated
   * @modifiable
   */
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("cybion.uima.ts.AbstractAnnotation");

  /**
   * initialize variables to correspond with Cas Type and Features
   *
   * @generated
   */
  public AbstractAnnotation_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl) this.casType, getFSGenerator());

  }
}
