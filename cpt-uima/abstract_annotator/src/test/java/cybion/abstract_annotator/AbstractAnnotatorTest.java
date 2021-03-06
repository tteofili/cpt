package cybion.abstract_annotator;

import cybion.annotator_utils.test.TestUtils;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class AbstractAnnotatorTest {

  private static final String FEATURE_NAME = "abstract";

  private static final String ANNOTATOR_DESCRIPTOR = "desc/AggregateAbstractDescriptor.xml";

  @Test
  public void test1() {
    try {
      String abstractText = TestUtils.testWithFileAndCache(ANNOTATOR_DESCRIPTOR, "bandi/b3.txt",
              FEATURE_NAME);
      assertNotNull(abstractText);
    } catch (Exception e) {
      e.printStackTrace();
      fail(e.getLocalizedMessage());
    }
  }

  @Test
  public void test2() {
    try {
      String abstractText = TestUtils.testWithFileAndCache(ANNOTATOR_DESCRIPTOR, "bandi/EID.txt",
              FEATURE_NAME);
      assertNotNull(abstractText);
    } catch (Exception e) {
      e.printStackTrace();
      fail(e.getLocalizedMessage());
    }
  }

  @Test
  public void test3() {
    try {
      String abstractText = TestUtils.testWithFileAndCache(ANNOTATOR_DESCRIPTOR, "bandi/EuropeAid.txt",
              FEATURE_NAME);
      assertTrue("found abstract '" + abstractText + "'", abstractText == null);
    } catch (Exception e) {
      e.printStackTrace();
      fail(e.getLocalizedMessage());
    }
  }

  @Test
  public void test4() {
    try {
      String abstractText = TestUtils.testWithFileAndCache(ANNOTATOR_DESCRIPTOR, "bandi/FP7.txt",
              FEATURE_NAME);
      assertNotNull(abstractText);
    } catch (Exception e) {
      e.printStackTrace();
      fail(e.getLocalizedMessage());
    }
  }

  @Test
  public void test5() {
    try {
      String abstractText = TestUtils.testWithFileAndCache(ANNOTATOR_DESCRIPTOR, "bandi/IARC.txt",
              FEATURE_NAME);
      assertNotNull(abstractText);
    } catch (Exception e) {
      e.printStackTrace();
      fail(e.getLocalizedMessage());
    }
  }

  @Test
  public void test6() {
    try {
      String abstractText = TestUtils.testWithFileAndCache(ANNOTATOR_DESCRIPTOR, "bandi/OJS62.txt",
              FEATURE_NAME);
      assertNotNull(abstractText);
    } catch (Exception e) {
      e.printStackTrace();
      fail(e.getLocalizedMessage());
    }
  }

  @Test
  public void test7() {
    try {
      String abstractText = TestUtils.testWithFileAndCache(ANNOTATOR_DESCRIPTOR, "bandi/fvg.txt",
              FEATURE_NAME);
      assertNotNull(abstractText);
    } catch (Exception e) {
      e.printStackTrace();
      fail(e.getLocalizedMessage());
    }
  }

  @Test
  public void testBur() {
    try {
      String abstractText = TestUtils.testWithFileAndCache(ANNOTATOR_DESCRIPTOR, "bandi/bur.txt",
              FEATURE_NAME);
      assertNotNull(abstractText);
    } catch (Exception e) {
      e.printStackTrace();
      fail(e.getLocalizedMessage());
    }
  }

}
