/* First created by JCasGen Fri Feb 26 16:49:34 CET 2010 */
package org.apache.uima;

import org.apache.uima.cas.FeatureStructure;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.impl.CASImpl;
import org.apache.uima.cas.impl.FSGenerator;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.tcas.Annotation_Type;

/**
 * Updated by JCasGen Sun May 16 14:13:04 CEST 2010
 *
 * @generated
 */
public class TitleDictionaryAnnotation_Type extends Annotation_Type {
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
              if (TitleDictionaryAnnotation_Type.this.useExistingInstance) {
                // Return eq fs instance if already created
                FeatureStructure fs = TitleDictionaryAnnotation_Type.this.jcas.getJfsFromCaddr(addr);
                if (null == fs) {
                  fs = new TitleDictionaryAnnotation(addr, TitleDictionaryAnnotation_Type.this);
                  TitleDictionaryAnnotation_Type.this.jcas.putJfsFromCaddr(addr, fs);
                  return fs;
                }
                return fs;
              } else return new TitleDictionaryAnnotation(addr, TitleDictionaryAnnotation_Type.this);
            }
          };
  /**
   * @generated
   */
  public final static int typeIndexID = TitleDictionaryAnnotation.typeIndexID;
  /**
   * @generated
   * @modifiable
   */
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("org.apache.uima.TitleDictionaryAnnotation");


  /**
   * initialize variables to correspond with Cas Type and Features
   *
   * @generated
   */
  public TitleDictionaryAnnotation_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl) this.casType, getFSGenerator());

  }
}



    