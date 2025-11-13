package org.symphonyoss.integration.parser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.net.MalformedURLException;
import java.nio.file.Paths;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.symphonyoss.integration.exception.URISyntaxRuntimeException;
import org.symphonyoss.integration.parser.model.HashTag;

public class ParserUtilsDiffblueTest {
  @Rule public ExpectedException thrown = ExpectedException.none();

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks() {
    // Arrange, Act and Assert
    assertEquals(
        "Not all who wander are lost<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\""
            + "  >xx</a>\"><  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a>",
        ParserUtils.markupLinks(
            "Not all who wander are lost<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks2() {
    // Arrange, Act and Assert
    assertEquals(
        "<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href  = "
            + " \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a>Not all who wander are lost",
        ParserUtils.markupLinks(
            "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>Not all who wander are lost"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks3() {
    // Arrange, Act and Assert
    assertEquals(
        "Not all who wander are lost<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\""
            + "  >xx</a>\"><  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a>42",
        ParserUtils.markupLinks(
            "Not all who wander are lost<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\" "
                + " >xx</a>42"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks4() {
    // Arrange, Act and Assert
    assertEquals(
        "Not all who wander are lost<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\""
            + "  >xx</a>\"><  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a>-",
        ParserUtils.markupLinks(
            "Not all who wander are lost<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\""
                + "  >xx</a>-"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks5() {
    // Arrange, Act and Assert
    assertEquals(
        "Not all who wander are lost<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\""
            + "  >xx</a>\"><  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a>/>",
        ParserUtils.markupLinks(
            "Not all who wander are lost<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\" "
                + " >xx</a>/>"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks6() {
    // Arrange, Act and Assert
    assertEquals(
        "Not all who wander are lost<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\""
            + "  >xx</a>\"><  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a>www",
        ParserUtils.markupLinks(
            "Not all who wander are lost<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\" "
                + " >xx</a>www"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks7() {
    // Arrange, Act and Assert
    assertEquals(
        "Not all who wander are lost42<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\""
            + "  >xx</a>\"><  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a>",
        ParserUtils.markupLinks(
            "Not all who wander are lost42<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\""
                + "  >xx</a>"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks8() {
    // Arrange, Act and Assert
    assertEquals(
        "Not all who wander are lost-<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\""
            + "  >xx</a>\"><  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a>",
        ParserUtils.markupLinks(
            "Not all who wander are lost-<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\""
                + "  >xx</a>"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks9() {
    // Arrange, Act and Assert
    assertEquals(
        "Not all who wander are lost/><a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\""
            + "  >xx</a>\"><  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a>",
        ParserUtils.markupLinks(
            "Not all who wander are lost/><  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\""
                + "  >xx</a>"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks10() {
    // Arrange, Act and Assert
    assertEquals(
        "Not all who wander are lostwww<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\""
            + "  >xx</a>\"><  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a>",
        ParserUtils.markupLinks(
            "Not all who wander are lostwww<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\""
                + "  >xx</a>"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks11() {
    // Arrange, Act and Assert
    assertEquals(
        "<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href  = "
            + " \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a>Not all who wander are lost42",
        ParserUtils.markupLinks(
            "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>Not all who wander"
                + " are lost42"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks12() {
    // Arrange, Act and Assert
    assertEquals(
        "<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href  = "
            + " \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a>Not all who wander are lost-",
        ParserUtils.markupLinks(
            "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>Not all who wander"
                + " are lost-"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks13() {
    // Arrange, Act and Assert
    assertEquals(
        "<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href  = "
            + " \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a>Not all who wander are lost/>",
        ParserUtils.markupLinks(
            "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>Not all who wander"
                + " are lost/>"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks14() {
    // Arrange, Act and Assert
    assertEquals(
        "<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href  = "
            + " \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a>Not all who wander are lostwww",
        ParserUtils.markupLinks(
            "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>Not all who wander are"
                + " lostwww"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks15() {
    // Arrange, Act and Assert
    assertEquals(
        "<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href  = "
            + " \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a>42Not all who wander are lost",
        ParserUtils.markupLinks(
            "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>42Not all who wander"
                + " are lost"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks16() {
    // Arrange, Act and Assert
    assertEquals(
        "<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href  = "
            + " \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a>-Not all who wander are lost",
        ParserUtils.markupLinks(
            "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>-Not all who wander"
                + " are lost"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks17() {
    // Arrange, Act and Assert
    assertEquals(
        "Not all who wander are lost<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\""
            + "  >xx</a>\"><  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a>\">",
        ParserUtils.markupLinks(
            "Not all who wander are lost<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\" "
                + " >xx</a>\">"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks18() {
    // Arrange, Act and Assert
    assertEquals(
        "Not all who wander are lost<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\""
            + "  >xx</a>\"><  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a></a>",
        ParserUtils.markupLinks(
            "Not all who wander are lost<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\" "
                + " >xx</a></a>"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks19() {
    // Arrange, Act and Assert
    assertEquals(
        "<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href  = "
            + " \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a>/>Not all who wander are lost",
        ParserUtils.markupLinks(
            "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>/>Not all who wander"
                + " are lost"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks20() {
    // Arrange, Act and Assert
    assertEquals(
        "<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href  = "
            + " \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a>wwwNot all who wander are lost",
        ParserUtils.markupLinks(
            "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>wwwNot all who wander"
                + " are lost"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks21() {
    // Arrange, Act and Assert
    assertEquals(
        "Not all who wander are lost\"><a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\""
            + "  >xx</a>\"><  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a>",
        ParserUtils.markupLinks(
            "Not all who wander are lost\"><  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\""
                + "  >xx</a>"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks22() {
    // Arrange, Act and Assert
    assertEquals(
        "42Not all who wander are lost<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\""
            + "  >xx</a>\"><  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a>",
        ParserUtils.markupLinks(
            "42Not all who wander are lost<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\""
                + "  >xx</a>"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks23() {
    // Arrange, Act and Assert
    assertEquals(
        "42<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href  = "
            + " \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a>Not all who wander are lost",
        ParserUtils.markupLinks(
            "42<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>Not all who wander"
                + " are lost"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks24() {
    // Arrange, Act and Assert
    assertEquals(
        "Not all who wander are lost</a><a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\""
            + "  >xx</a>\"><  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a>",
        ParserUtils.markupLinks(
            "Not all who wander are lost</a><  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\""
                + "  >xx</a>"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks25() {
    // Arrange, Act and Assert
    assertEquals(
        "<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href  = "
            + " \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a>Not all who wander are lost\">",
        ParserUtils.markupLinks(
            "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>Not all who wander"
                + " are lost\">"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks26() {
    // Arrange, Act and Assert
    assertEquals(
        "<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href  = "
            + " \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a>Not all who wander are lost</a>",
        ParserUtils.markupLinks(
            "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>Not all who wander are"
                + " lost</a>"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <ul>
   *   <li>When {@code 42< a href = "http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;" >xx</a>42}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks_when42AHrefHttpUuuuuuuuuuuuUuAmpAmpUuAmpAmpXxA42() {
    // Arrange, Act and Assert
    assertEquals(
        "42<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href  = "
            + " \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a>42",
        ParserUtils.markupLinks(
            "42<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>42"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <ul>
   *   <li>When {@code 42< a href = "http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;"
   *       >xx</a>Message}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks_when42AHrefHttpUuuuuuuuuuuuUuAmpAmpUuAmpAmpXxAMessage() {
    // Arrange, Act and Assert
    assertEquals(
        "42<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href  = "
            + " \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a>Message",
        ParserUtils.markupLinks(
            "42<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>Message"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <ul>
   *   <li>When {@code 42< a href = "http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;" >xx</a>www}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks_when42AHrefHttpUuuuuuuuuuuuUuAmpAmpUuAmpAmpXxAWww() {
    // Arrange, Act and Assert
    assertEquals(
        "42<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href  = "
            + " \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a>www",
        ParserUtils.markupLinks(
            "42<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>www"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <ul>
   *   <li>When {@code 42< a href = "http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;" >xx</a>}.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks_when42AHrefHttpUuuuuuuuuuuuUuAmpAmpUuAmpAmpXxA_thenReturnAString() {
    // Arrange, Act and Assert
    assertEquals(
        "42<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href  = "
            + " \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a>",
        ParserUtils.markupLinks(
            "42<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <ul>
   *   <li>When {@code 42< a href = "http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;" >xx</a>-}.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks_when42AHrefHttpUuuuuuuuuuuuUuAmpAmpUuAmpAmpXxA_thenReturnAString2() {
    // Arrange, Act and Assert
    assertEquals(
        "42<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href  = "
            + " \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a>-",
        ParserUtils.markupLinks(
            "42<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>-"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <ul>
   *   <li>When {@code 42< a href = "http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;" >xx</a>/>}.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks_when42AHrefHttpUuuuuuuuuuuuUuAmpAmpUuAmpAmpXxA_thenReturnAString3() {
    // Arrange, Act and Assert
    assertEquals(
        "42<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href  = "
            + " \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a>/>",
        ParserUtils.markupLinks(
            "42<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>/>"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <ul>
   *   <li>When {@code 42-< a href = "http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;" >xx</a>}.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks_when42AHrefHttpUuuuuuuuuuuuUuAmpAmpUuAmpAmpXxA_thenReturnAString4() {
    // Arrange, Act and Assert
    assertEquals(
        "42-<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href  ="
            + "  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a>",
        ParserUtils.markupLinks(
            "42-<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <ul>
   *   <li>When {@code 42/>< a href = "http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;" >xx</a>}.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks_when42AHrefHttpUuuuuuuuuuuuUuAmpAmpUuAmpAmpXxA_thenReturnAString5() {
    // Arrange, Act and Assert
    assertEquals(
        "42/><a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href  ="
            + "  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a>",
        ParserUtils.markupLinks(
            "42/><  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <ul>
   *   <li>When {@code 42Message< a href = "http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;"
   *       >xx</a>}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks_when42MessageAHrefHttpUuuuuuuuuuuuUuAmpAmpUuAmpAmpXxA() {
    // Arrange, Act and Assert
    assertEquals(
        "42Message<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a "
            + " href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a>",
        ParserUtils.markupLinks(
            "42Message<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <ul>
   *   <li>When {@code 4242< a href = "http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;" >xx</a>}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks_when4242AHrefHttpUuuuuuuuuuuuUuAmpAmpUuAmpAmpXxA() {
    // Arrange, Act and Assert
    assertEquals(
        "4242<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href  ="
            + "  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a>",
        ParserUtils.markupLinks(
            "4242<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <ul>
   *   <li>When {@code </a>< a href = "http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;" >xx</a>}.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks_whenAAHrefHttpUuuuuuuuuuuuUuAmpAmpUuAmpAmpXxA_thenReturnAString() {
    // Arrange, Act and Assert
    assertEquals(
        "</a><a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href  ="
            + "  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a>",
        ParserUtils.markupLinks(
            "</a><  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <ul>
   *   <li>When {@code <a href=< a href = "http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;"
   *       >xx</a>}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks_whenAHrefAHrefHttpUuuuuuuuuuuuUuAmpAmpUuAmpAmpXxA() {
    // Arrange, Act and Assert
    assertEquals(
        "<a href=<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href"
            + "  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a>",
        ParserUtils.markupLinks(
            "<a href=<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <ul>
   *   <li>When {@code <a href="< a href = "http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;"
   *       >xx</a>}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks_whenAHrefAHrefHttpUuuuuuuuuuuuUuAmpAmpUuAmpAmpXxA2() {
    // Arrange, Act and Assert
    assertEquals(
        "<a href=\"<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a "
            + " href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a>",
        ParserUtils.markupLinks(
            "<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <ul>
   *   <li>When {@code < a href = "http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;"
   *       >xx</a>42Message}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks_whenAHrefHttpUuuuuuuuuuuuUuAmpAmpUuAmpAmpXxA42Message() {
    // Arrange, Act and Assert
    assertEquals(
        "<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href  = "
            + " \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a>42Message",
        ParserUtils.markupLinks(
            "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>42Message"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <ul>
   *   <li>When {@code < a href = "http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;" >xx</a>42}.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks_whenAHrefHttpUuuuuuuuuuuuUuAmpAmpUuAmpAmpXxA42_thenReturnAString() {
    // Arrange, Act and Assert
    assertEquals(
        "<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href  = "
            + " \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a>42",
        ParserUtils.markupLinks(
            "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>42"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <ul>
   *   <li>When {@code < a href = "http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;" >xx</a>42-}.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks_whenAHrefHttpUuuuuuuuuuuuUuAmpAmpUuAmpAmpXxA42_thenReturnAString2() {
    // Arrange, Act and Assert
    assertEquals(
        "<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href  = "
            + " \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a>42-",
        ParserUtils.markupLinks(
            "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>42-"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <ul>
   *   <li>When {@code < a href = "http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;" >xx</a>42/>}.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks_whenAHrefHttpUuuuuuuuuuuuUuAmpAmpUuAmpAmpXxA42_thenReturnAString3() {
    // Arrange, Act and Assert
    assertEquals(
        "<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href  = "
            + " \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a>42/>",
        ParserUtils.markupLinks(
            "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>42/>"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <ul>
   *   <li>When {@code < a href = "http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;" >xx</a>-42}.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks_whenAHrefHttpUuuuuuuuuuuuUuAmpAmpUuAmpAmpXxA42_thenReturnAString4() {
    // Arrange, Act and Assert
    assertEquals(
        "<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href  = "
            + " \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a>-42",
        ParserUtils.markupLinks(
            "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>-42"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <ul>
   *   <li>When {@code < a href = "http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;" >xx</a>/>42}.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks_whenAHrefHttpUuuuuuuuuuuuUuAmpAmpUuAmpAmpXxA42_thenReturnAString5() {
    // Arrange, Act and Assert
    assertEquals(
        "<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href  = "
            + " \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a>/>42",
        ParserUtils.markupLinks(
            "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>/>42"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <ul>
   *   <li>When {@code < a href = "http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;" >xx</a>42www}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks_whenAHrefHttpUuuuuuuuuuuuUuAmpAmpUuAmpAmpXxA42www() {
    // Arrange, Act and Assert
    assertEquals(
        "<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href  = "
            + " \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a>42www",
        ParserUtils.markupLinks(
            "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>42www"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <ul>
   *   <li>When {@code < a href = "http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;" >xx</a>4242}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks_whenAHrefHttpUuuuuuuuuuuuUuAmpAmpUuAmpAmpXxA4242() {
    // Arrange, Act and Assert
    assertEquals(
        "<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href  = "
            + " \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a>4242",
        ParserUtils.markupLinks(
            "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>4242"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <ul>
   *   <li>When {@code < a href = "http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;" >xx</a><a
   *       href=}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks_whenAHrefHttpUuuuuuuuuuuuUuAmpAmpUuAmpAmpXxAAHref() {
    // Arrange, Act and Assert
    assertEquals(
        "<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href  = "
            + " \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a><a href=",
        ParserUtils.markupLinks(
            "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a><a href="));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <ul>
   *   <li>When {@code < a href = "http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;" >xx</a><a
   *       href="}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks_whenAHrefHttpUuuuuuuuuuuuUuAmpAmpUuAmpAmpXxAAHref2() {
    // Arrange, Act and Assert
    assertEquals(
        "<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href  = "
            + " \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a><a href=\"",
        ParserUtils.markupLinks(
            "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a><a href=\""));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <ul>
   *   <li>When {@code < a href = "http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;" >xx</a></a>}.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks_whenAHrefHttpUuuuuuuuuuuuUuAmpAmpUuAmpAmpXxAA_thenReturnAString() {
    // Arrange, Act and Assert
    assertEquals(
        "<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href  = "
            + " \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a></a>",
        ParserUtils.markupLinks(
            "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a>"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <ul>
   *   <li>When {@code < a href = "http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;" >xx</a>Message}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks_whenAHrefHttpUuuuuuuuuuuuUuAmpAmpUuAmpAmpXxAMessage() {
    // Arrange, Act and Assert
    assertEquals(
        "<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href  = "
            + " \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a>Message",
        ParserUtils.markupLinks(
            "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>Message"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <ul>
   *   <li>When {@code < a href = "http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;"
   *       >xx</a>Message-}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks_whenAHrefHttpUuuuuuuuuuuuUuAmpAmpUuAmpAmpXxAMessage2() {
    // Arrange, Act and Assert
    assertEquals(
        "<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href  = "
            + " \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a>Message-",
        ParserUtils.markupLinks(
            "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>Message-"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <ul>
   *   <li>When {@code < a href = "http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;"
   *       >xx</a>Message/>}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks_whenAHrefHttpUuuuuuuuuuuuUuAmpAmpUuAmpAmpXxAMessage3() {
    // Arrange, Act and Assert
    assertEquals(
        "<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href  = "
            + " \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a>Message/>",
        ParserUtils.markupLinks(
            "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>Message/>"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <ul>
   *   <li>When {@code < a href = "http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;"
   *       >xx</a>-Message}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks_whenAHrefHttpUuuuuuuuuuuuUuAmpAmpUuAmpAmpXxAMessage4() {
    // Arrange, Act and Assert
    assertEquals(
        "<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href  = "
            + " \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a>-Message",
        ParserUtils.markupLinks(
            "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>-Message"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <ul>
   *   <li>When {@code < a href = "http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;"
   *       >xx</a>/>Message}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks_whenAHrefHttpUuuuuuuuuuuuUuAmpAmpUuAmpAmpXxAMessage5() {
    // Arrange, Act and Assert
    assertEquals(
        "<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href  = "
            + " \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a>/>Message",
        ParserUtils.markupLinks(
            "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>/>Message"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <ul>
   *   <li>When {@code < a href = "http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;"
   *       >xx</a>Message42}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks_whenAHrefHttpUuuuuuuuuuuuUuAmpAmpUuAmpAmpXxAMessage42() {
    // Arrange, Act and Assert
    assertEquals(
        "<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href  = "
            + " \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a>Message42",
        ParserUtils.markupLinks(
            "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>Message42"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <ul>
   *   <li>When {@code < a href = "http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;"
   *       >xx</a>MessageMessage}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks_whenAHrefHttpUuuuuuuuuuuuUuAmpAmpUuAmpAmpXxAMessageMessage() {
    // Arrange, Act and Assert
    assertEquals(
        "<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href  = "
            + " \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a>MessageMessage",
        ParserUtils.markupLinks(
            "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>MessageMessage"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <ul>
   *   <li>When {@code < a href = "http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;"
   *       >xx</a>Messagewww}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks_whenAHrefHttpUuuuuuuuuuuuUuAmpAmpUuAmpAmpXxAMessagewww() {
    // Arrange, Act and Assert
    assertEquals(
        "<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href  = "
            + " \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a>Messagewww",
        ParserUtils.markupLinks(
            "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>Messagewww"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <ul>
   *   <li>When {@code < a href = "http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;" >xx</a>www}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks_whenAHrefHttpUuuuuuuuuuuuUuAmpAmpUuAmpAmpXxAWww() {
    // Arrange, Act and Assert
    assertEquals(
        "<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href  = "
            + " \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a>www",
        ParserUtils.markupLinks(
            "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>www"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <ul>
   *   <li>When {@code < a href = "http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;" >xx</a>-www}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks_whenAHrefHttpUuuuuuuuuuuuUuAmpAmpUuAmpAmpXxAWww2() {
    // Arrange, Act and Assert
    assertEquals(
        "<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href  = "
            + " \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a>-www",
        ParserUtils.markupLinks(
            "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>-www"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <ul>
   *   <li>When {@code < a href = "http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;" >xx</a>/>www}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks_whenAHrefHttpUuuuuuuuuuuuUuAmpAmpUuAmpAmpXxAWww3() {
    // Arrange, Act and Assert
    assertEquals(
        "<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href  = "
            + " \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a>/>www",
        ParserUtils.markupLinks(
            "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>/>www"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <ul>
   *   <li>When {@code < a href = "http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;" >xx</a>www-}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks_whenAHrefHttpUuuuuuuuuuuuUuAmpAmpUuAmpAmpXxAWww4() {
    // Arrange, Act and Assert
    assertEquals(
        "<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href  = "
            + " \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a>www-",
        ParserUtils.markupLinks(
            "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>www-"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <ul>
   *   <li>When {@code < a href = "http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;" >xx</a>www/>}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks_whenAHrefHttpUuuuuuuuuuuuUuAmpAmpUuAmpAmpXxAWww5() {
    // Arrange, Act and Assert
    assertEquals(
        "<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href  = "
            + " \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a>www/>",
        ParserUtils.markupLinks(
            "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>www/>"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <ul>
   *   <li>When {@code < a href = "http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;" >xx</a>www42}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks_whenAHrefHttpUuuuuuuuuuuuUuAmpAmpUuAmpAmpXxAWww42() {
    // Arrange, Act and Assert
    assertEquals(
        "<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href  = "
            + " \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a>www42",
        ParserUtils.markupLinks(
            "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>www42"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <ul>
   *   <li>When {@code < a href = "http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;"
   *       >xx</a>wwwMessage}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks_whenAHrefHttpUuuuuuuuuuuuUuAmpAmpUuAmpAmpXxAWwwMessage() {
    // Arrange, Act and Assert
    assertEquals(
        "<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href  = "
            + " \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a>wwwMessage",
        ParserUtils.markupLinks(
            "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>wwwMessage"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <ul>
   *   <li>When {@code < a href = "http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;" >xx</a>wwwwww}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks_whenAHrefHttpUuuuuuuuuuuuUuAmpAmpUuAmpAmpXxAWwwwww() {
    // Arrange, Act and Assert
    assertEquals(
        "<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href  = "
            + " \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a>wwwwww",
        ParserUtils.markupLinks(
            "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>wwwwww"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <ul>
   *   <li>When {@code < a href = "http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;" >xx</a>}.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks_whenAHrefHttpUuuuuuuuuuuuUuAmpAmpUuAmpAmpXxA_thenReturnAString() {
    // Arrange, Act and Assert
    assertEquals(
        "<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href  = "
            + " \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a>",
        ParserUtils.markupLinks(
            "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <ul>
   *   <li>When {@code < a href = "http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;" >xx</a>-}.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks_whenAHrefHttpUuuuuuuuuuuuUuAmpAmpUuAmpAmpXxA_thenReturnAString2() {
    // Arrange, Act and Assert
    assertEquals(
        "<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href  = "
            + " \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a>-",
        ParserUtils.markupLinks(
            "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>-"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <ul>
   *   <li>When {@code < a href = "http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;" >xx</a>/>}.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks_whenAHrefHttpUuuuuuuuuuuuUuAmpAmpUuAmpAmpXxA_thenReturnAString3() {
    // Arrange, Act and Assert
    assertEquals(
        "<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href  = "
            + " \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a>/>",
        ParserUtils.markupLinks(
            "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>/>"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <ul>
   *   <li>When {@code < a href = "http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;" >xx</a>">}.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks_whenAHrefHttpUuuuuuuuuuuuUuAmpAmpUuAmpAmpXxA_thenReturnAString4() {
    // Arrange, Act and Assert
    assertEquals(
        "<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href  = "
            + " \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a>\">",
        ParserUtils.markupLinks(
            "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\">"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <ul>
   *   <li>When {@code -< a href = "http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;" >xx</a>}.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks_whenAHrefHttpUuuuuuuuuuuuUuAmpAmpUuAmpAmpXxA_thenReturnAString5() {
    // Arrange, Act and Assert
    assertEquals(
        "-<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href  = "
            + " \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a>",
        ParserUtils.markupLinks(
            "-<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <ul>
   *   <li>When {@code />< a href = "http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;" >xx</a>}.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks_whenAHrefHttpUuuuuuuuuuuuUuAmpAmpUuAmpAmpXxA_thenReturnAString6() {
    // Arrange, Act and Assert
    assertEquals(
        "/><a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href  = "
            + " \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a>",
        ParserUtils.markupLinks(
            "/><  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <ul>
   *   <li>When {@code ">< a href = "http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;" >xx</a>}.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks_whenAHrefHttpUuuuuuuuuuuuUuAmpAmpUuAmpAmpXxA_thenReturnAString7() {
    // Arrange, Act and Assert
    assertEquals(
        "\"><a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href  = "
            + " \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a>",
        ParserUtils.markupLinks(
            "\"><  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <ul>
   *   <li>When {@code < a href = "http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;" >xx</a>--}.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks_whenAHrefHttpUuuuuuuuuuuuUuAmpAmpUuAmpAmpXxA_thenReturnAString8() {
    // Arrange, Act and Assert
    assertEquals(
        "<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href  = "
            + " \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a>--",
        ParserUtils.markupLinks(
            "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>--"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <ul>
   *   <li>When {@code < a href = "http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;" >xx</a>-/>}.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks_whenAHrefHttpUuuuuuuuuuuuUuAmpAmpUuAmpAmpXxA_thenReturnAString9() {
    // Arrange, Act and Assert
    assertEquals(
        "<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href  = "
            + " \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a>-/>",
        ParserUtils.markupLinks(
            "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>-/>"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <ul>
   *   <li>When {@code < a href = "http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;" >xx</a>/>-}.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks_whenAHrefHttpUuuuuuuuuuuuUuAmpAmpUuAmpAmpXxA_thenReturnAString10() {
    // Arrange, Act and Assert
    assertEquals(
        "<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href  = "
            + " \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a>/>-",
        ParserUtils.markupLinks(
            "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>/>-"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <ul>
   *   <li>When {@code < a href = "http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;" >xx</a>/>/>}.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks_whenAHrefHttpUuuuuuuuuuuuUuAmpAmpUuAmpAmpXxA_thenReturnAString11() {
    // Arrange, Act and Assert
    assertEquals(
        "<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href  = "
            + " \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a>/>/>",
        ParserUtils.markupLinks(
            "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>/>/>"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <ul>
   *   <li>When a string.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks_whenAString_thenReturnAString() {
    // Arrange, Act and Assert
    assertEquals(
        "<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href  = "
            + " \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a><a href=\"<  a  href  =  \"http:/"
            + "/UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp"
            + ";//UU&amp;&amp;\"  >xx</a></a>",
        ParserUtils.markupLinks(
            "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a><  a  href  =  \"http:/"
                + "/UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <ul>
   *   <li>When a string.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks_whenAString_thenReturnAString2() {
    // Arrange, Act and Assert
    assertEquals(
        "<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href  = "
            + " \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a><presentationML>(.*?)</presentationML"
            + ">",
        ParserUtils.markupLinks(
            "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a><presentationML>(.*?)<"
                + "/presentationML>"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <ul>
   *   <li>When a string.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks_whenAString_thenReturnAString3() {
    // Arrange, Act and Assert
    assertEquals(
        "<presentationML>(.*?)</presentationML><a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU"
            + "&amp;&amp;\"  >xx</a>\"><  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a>",
        ParserUtils.markupLinks(
            "<presentationML>(.*?)</presentationML><  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\""
                + "  >xx</a>"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <ul>
   *   <li>When a string.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks_whenAString_thenReturnAString4() {
    // Arrange, Act and Assert
    assertEquals(
        "Not all who wander are lostNot all who wander are lost<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU/"
            + "/UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\""
            + "  >xx</a></a>",
        ParserUtils.markupLinks(
            "Not all who wander are lostNot all who wander are lost<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp"
                + ";//UU&amp;&amp;\"  >xx</a>"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <ul>
   *   <li>When a string.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks_whenAString_thenReturnAString5() {
    // Arrange, Act and Assert
    assertEquals(
        "Not all who wander are lost<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\""
            + "  >xx</a>\"><  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a>Not all who"
            + " wander are lost",
        ParserUtils.markupLinks(
            "Not all who wander are lost<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>Not"
                + " all who wander are lost"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <ul>
   *   <li>When a string.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks_whenAString_thenReturnAString6() {
    // Arrange, Act and Assert
    assertEquals(
        "Not all who wander are lost<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\""
            + "  >xx</a>\"><  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a><a href=\"<  a"
            + "  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href  =  \"http://UUUUUUUUUUUU"
            + "//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a>",
        ParserUtils.markupLinks(
            "Not all who wander are lost<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a><"
                + "  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <ul>
   *   <li>When a string.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks_whenAString_thenReturnAString7() {
    // Arrange, Act and Assert
    assertEquals(
        "Not all who wander are lost<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\""
            + "  >xx</a>\"><  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a>Message",
        ParserUtils.markupLinks(
            "Not all who wander are lost<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\" "
                + " >xx</a>Message"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <ul>
   *   <li>When a string.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks_whenAString_thenReturnAString8() {
    // Arrange, Act and Assert
    assertEquals(
        "Not all who wander are lost<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\""
            + "  >xx</a>\"><  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a><presentationML"
            + ">(.*?)</presentationML>",
        ParserUtils.markupLinks(
            "Not all who wander are lost<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\" "
                + " >xx</a><presentationML>(.*?)</presentationML>"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <ul>
   *   <li>When a string.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks_whenAString_thenReturnAString9() {
    // Arrange, Act and Assert
    assertEquals(
        "Not all who wander are lostMessage<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\""
            + "  >xx</a>\"><  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a>",
        ParserUtils.markupLinks(
            "Not all who wander are lostMessage<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\""
                + "  >xx</a>"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <ul>
   *   <li>When a string.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks_whenAString_thenReturnAString10() {
    // Arrange, Act and Assert
    assertEquals(
        "Not all who wander are lost<presentationML>(.*?)</presentationML><a href=\"<  a  href  =  \"http:/"
            + "/UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp"
            + ";//UU&amp;&amp;\"  >xx</a></a>",
        ParserUtils.markupLinks(
            "Not all who wander are lost<presentationML>(.*?)</presentationML><  a  href  =  \"http://UUUUUUUUUUUU"
                + "//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <ul>
   *   <li>When a string.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks_whenAString_thenReturnAString11() {
    // Arrange, Act and Assert
    assertEquals(
        "<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href  = "
            + " \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a>Not all who wander are lostNot all who"
            + " wander are lost",
        ParserUtils.markupLinks(
            "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>Not all who wander are lostNot"
                + " all who wander are lost"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <ul>
   *   <li>When a string.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks_whenAString_thenReturnAString12() {
    // Arrange, Act and Assert
    assertEquals(
        "<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href  = "
            + " \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a>Not all who wander are lost<a href=\"<"
            + "  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href  =  \"http:/"
            + "/UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a>",
        ParserUtils.markupLinks(
            "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>Not all who wander are lost<"
                + "  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <ul>
   *   <li>When a string.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks_whenAString_thenReturnAString13() {
    // Arrange, Act and Assert
    assertEquals(
        "<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href  = "
            + " \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a>Not all who wander are lostMessage",
        ParserUtils.markupLinks(
            "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>Not all who wander are"
                + " lostMessage"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <ul>
   *   <li>When a string.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks_whenAString_thenReturnAString14() {
    // Arrange, Act and Assert
    assertEquals(
        "<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href  = "
            + " \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a>Not all who wander are lost<presentationML"
            + ">(.*?)</presentationML>",
        ParserUtils.markupLinks(
            "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>Not all who wander are"
                + " lost<presentationML>(.*?)</presentationML>"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <ul>
   *   <li>When a string.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks_whenAString_thenReturnAString15() {
    // Arrange, Act and Assert
    assertEquals(
        "<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href  = "
            + " \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a><a href=\"<  a  href  =  \"http:/"
            + "/UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp"
            + ";//UU&amp;&amp;\"  >xx</a></a>Not all who wander are lost",
        ParserUtils.markupLinks(
            "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a><  a  href  =  \"http:/"
                + "/UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>Not all who wander are lost"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <ul>
   *   <li>When a string.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks_whenAString_thenReturnAString16() {
    // Arrange, Act and Assert
    assertEquals(
        "<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href  = "
            + " \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a><a href=\"<  a  href  =  \"http:/"
            + "/UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp"
            + ";//UU&amp;&amp;\"  >xx</a></a><a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\""
            + "  >xx</a>\"><  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a>",
        ParserUtils.markupLinks(
            "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a><  a  href  =  \"http:/"
                + "/UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a><  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;"
                + "//UU&amp;&amp;\"  >xx</a>"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <ul>
   *   <li>When a string.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks_whenAString_thenReturnAString17() {
    // Arrange, Act and Assert
    assertEquals(
        "<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href  = "
            + " \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a><a href=\"<  a  href  =  \"http:/"
            + "/UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp"
            + ";//UU&amp;&amp;\"  >xx</a></a>Message",
        ParserUtils.markupLinks(
            "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a><  a  href  =  \"http:/"
                + "/UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>Message"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <ul>
   *   <li>When a string.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks_whenAString_thenReturnAString18() {
    // Arrange, Act and Assert
    assertEquals(
        "<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href  = "
            + " \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a><a href=\"<  a  href  =  \"http:/"
            + "/UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp"
            + ";//UU&amp;&amp;\"  >xx</a></a>42",
        ParserUtils.markupLinks(
            "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a><  a  href  =  \"http:/"
                + "/UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>42"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <ul>
   *   <li>When a string.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks_whenAString_thenReturnAString19() {
    // Arrange, Act and Assert
    assertEquals(
        "<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href  = "
            + " \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a><a href=\"<  a  href  =  \"http:/"
            + "/UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp"
            + ";//UU&amp;&amp;\"  >xx</a></a>-",
        ParserUtils.markupLinks(
            "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a><  a  href  =  \"http:/"
                + "/UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>-"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <ul>
   *   <li>When a string.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks_whenAString_thenReturnAString20() {
    // Arrange, Act and Assert
    assertEquals(
        "<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href  = "
            + " \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a><a href=\"<  a  href  =  \"http:/"
            + "/UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp"
            + ";//UU&amp;&amp;\"  >xx</a></a>/>",
        ParserUtils.markupLinks(
            "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a><  a  href  =  \"http:/"
                + "/UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>/>"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <ul>
   *   <li>When a string.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks_whenAString_thenReturnAString21() {
    // Arrange, Act and Assert
    assertEquals(
        "<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href  = "
            + " \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a><a href=\"<  a  href  =  \"http:/"
            + "/UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp"
            + ";//UU&amp;&amp;\"  >xx</a></a><presentationML>(.*?)</presentationML>",
        ParserUtils.markupLinks(
            "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a><  a  href  =  \"http:/"
                + "/UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a><presentationML>(.*?)</presentationML>"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <ul>
   *   <li>When a string.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks_whenAString_thenReturnAString22() {
    // Arrange, Act and Assert
    assertEquals(
        "<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href  = "
            + " \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a><a href=\"<  a  href  =  \"http:/"
            + "/UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp"
            + ";//UU&amp;&amp;\"  >xx</a></a>www",
        ParserUtils.markupLinks(
            "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a><  a  href  =  \"http:/"
                + "/UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>www"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <ul>
   *   <li>When a string.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks_whenAString_thenReturnAString23() {
    // Arrange, Act and Assert
    assertEquals(
        "<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href  = "
            + " \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a>MessageNot all who wander are lost",
        ParserUtils.markupLinks(
            "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>MessageNot all who wander"
                + " are lost"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <ul>
   *   <li>When a string.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks_whenAString_thenReturnAString24() {
    // Arrange, Act and Assert
    assertEquals(
        "<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href  = "
            + " \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a>Message<a href=\"<  a  href  = "
            + " \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href  =  \"http://UUUUUUUUUUUU//UU"
            + "&amp;&amp;//UU&amp;&amp;\"  >xx</a></a>",
        ParserUtils.markupLinks(
            "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>Message<  a  href  = "
                + " \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <ul>
   *   <li>When a string.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks_whenAString_thenReturnAString25() {
    // Arrange, Act and Assert
    assertEquals(
        "<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href  = "
            + " \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a>Message<presentationML>(.*?)<"
            + "/presentationML>",
        ParserUtils.markupLinks(
            "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>Message<presentationML>(.*?"
                + ")</presentationML>"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <ul>
   *   <li>When a string.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks_whenAString_thenReturnAString26() {
    // Arrange, Act and Assert
    assertEquals(
        "<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href  = "
            + " \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a>42<a href=\"<  a  href  =  \"http:/"
            + "/UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp"
            + ";//UU&amp;&amp;\"  >xx</a></a>",
        ParserUtils.markupLinks(
            "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>42<  a  href  =  \"http:/"
                + "/UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <ul>
   *   <li>When a string.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks_whenAString_thenReturnAString27() {
    // Arrange, Act and Assert
    assertEquals(
        "<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href "
            + " =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a>42<presentationML>(.*?)<"
            + "/presentationML>",
        ParserUtils.markupLinks(
            "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>42<presentationML>(.*?)<"
                + "/presentationML>"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <ul>
   *   <li>When a string.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks_whenAString_thenReturnAString28() {
    // Arrange, Act and Assert
    assertEquals(
        "Not all who wander are lost<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\""
            + "  >xx</a>\"><  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a><a href=",
        ParserUtils.markupLinks(
            "Not all who wander are lost<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a><a"
                + " href="));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <ul>
   *   <li>When a string.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks_whenAString_thenReturnAString29() {
    // Arrange, Act and Assert
    assertEquals(
        "<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href  = "
            + " \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a>-<a href=\"<  a  href  =  \"http:/"
            + "/UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp"
            + ";//UU&amp;&amp;\"  >xx</a></a>",
        ParserUtils.markupLinks(
            "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>-<  a  href  =  \"http:/"
                + "/UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <ul>
   *   <li>When a string.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks_whenAString_thenReturnAString30() {
    // Arrange, Act and Assert
    assertEquals(
        "Not all who wander are lost<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\""
            + "  >xx</a>\"><  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a><a href=\"",
        ParserUtils.markupLinks(
            "Not all who wander are lost<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a><a"
                + " href=\""));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <ul>
   *   <li>When a string.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks_whenAString_thenReturnAString31() {
    // Arrange, Act and Assert
    assertEquals(
        "<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href "
            + " =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a>-<presentationML>(.*?)<"
            + "/presentationML>",
        ParserUtils.markupLinks(
            "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>-<presentationML>(.*?)<"
                + "/presentationML>"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <ul>
   *   <li>When a string.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks_whenAString_thenReturnAString32() {
    // Arrange, Act and Assert
    assertEquals(
        "<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href  = "
            + " \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a>/><a href=\"<  a  href  =  \"http:/"
            + "/UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp"
            + ";//UU&amp;&amp;\"  >xx</a></a>",
        ParserUtils.markupLinks(
            "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>/><  a  href  =  \"http:/"
                + "/UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <ul>
   *   <li>When a string.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks_whenAString_thenReturnAString33() {
    // Arrange, Act and Assert
    assertEquals(
        "<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href "
            + " =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a>/><presentationML>(.*?)<"
            + "/presentationML>",
        ParserUtils.markupLinks(
            "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>/><presentationML>(.*?)<"
                + "/presentationML>"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <ul>
   *   <li>When a string.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks_whenAString_thenReturnAString34() {
    // Arrange, Act and Assert
    assertEquals(
        "<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href  = "
            + " \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a><presentationML>(.*?)</presentationML>Not"
            + " all who wander are lost",
        ParserUtils.markupLinks(
            "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a><presentationML>(.*?)<"
                + "/presentationML>Not all who wander are lost"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <ul>
   *   <li>When a string.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks_whenAString_thenReturnAString35() {
    // Arrange, Act and Assert
    assertEquals(
        "<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href  = "
            + " \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a><presentationML>(.*?)</presentationML><a"
            + " href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href  = "
            + " \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a>",
        ParserUtils.markupLinks(
            "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a><presentationML>(.*?)<"
                + "/presentationML><  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <ul>
   *   <li>When a string.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks_whenAString_thenReturnAString36() {
    // Arrange, Act and Assert
    assertEquals(
        "<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href  = "
            + " \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a><presentationML>(.*?)</presentationML"
            + ">Message",
        ParserUtils.markupLinks(
            "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a><presentationML>(.*?)<"
                + "/presentationML>Message"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <ul>
   *   <li>When a string.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks_whenAString_thenReturnAString37() {
    // Arrange, Act and Assert
    assertEquals(
        "<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href "
            + " =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a><presentationML>(.*?)<"
            + "/presentationML>42",
        ParserUtils.markupLinks(
            "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a><presentationML>(.*?)<"
                + "/presentationML>42"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <ul>
   *   <li>When a string.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks_whenAString_thenReturnAString38() {
    // Arrange, Act and Assert
    assertEquals(
        "<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href "
            + " =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a><presentationML>(.*?)<"
            + "/presentationML>-",
        ParserUtils.markupLinks(
            "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a><presentationML>(.*?)<"
                + "/presentationML>-"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <ul>
   *   <li>When a string.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks_whenAString_thenReturnAString39() {
    // Arrange, Act and Assert
    assertEquals(
        "<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href "
            + " =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a><presentationML>(.*?)<"
            + "/presentationML>/>",
        ParserUtils.markupLinks(
            "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a><presentationML>(.*?)<"
                + "/presentationML>/>"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <ul>
   *   <li>When a string.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks_whenAString_thenReturnAString40() {
    // Arrange, Act and Assert
    assertEquals(
        "Not all who wander are lost<a href=<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\""
            + "  >xx</a>\"><  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a>",
        ParserUtils.markupLinks(
            "Not all who wander are lost<a href=<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\""
                + "  >xx</a>"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <ul>
   *   <li>When a string.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks_whenAString_thenReturnAString41() {
    // Arrange, Act and Assert
    assertEquals(
        "<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href  = "
            + " \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a><presentationML>(.*?)</presentationML"
            + "><presentationML>(.*?)</presentationML>",
        ParserUtils.markupLinks(
            "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a><presentationML>(.*?)<"
                + "/presentationML><presentationML>(.*?)</presentationML>"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <ul>
   *   <li>When a string.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks_whenAString_thenReturnAString42() {
    // Arrange, Act and Assert
    assertEquals(
        "<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href  ="
            + "  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a><presentationML>(.*?)</presentationML"
            + ">www",
        ParserUtils.markupLinks(
            "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a><presentationML>(.*?)<"
                + "/presentationML>www"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <ul>
   *   <li>When a string.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks_whenAString_thenReturnAString43() {
    // Arrange, Act and Assert
    assertEquals(
        "<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href  = "
            + " \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a>www<a href=\"<  a  href  =  \"http:/"
            + "/UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp"
            + ";//UU&amp;&amp;\"  >xx</a></a>",
        ParserUtils.markupLinks(
            "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>www<  a  href  =  \"http:/"
                + "/UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <ul>
   *   <li>When a string.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks_whenAString_thenReturnAString44() {
    // Arrange, Act and Assert
    assertEquals(
        "<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href  ="
            + "  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a>www<presentationML>(.*?)<"
            + "/presentationML>",
        ParserUtils.markupLinks(
            "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>www<presentationML>(.*?)<"
                + "/presentationML>"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <ul>
   *   <li>When a string.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks_whenAString_thenReturnAString45() {
    // Arrange, Act and Assert
    assertEquals(
        "MessageNot all who wander are lost<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\""
            + "  >xx</a>\"><  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a>",
        ParserUtils.markupLinks(
            "MessageNot all who wander are lost<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\""
                + "  >xx</a>"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <ul>
   *   <li>When a string.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks_whenAString_thenReturnAString46() {
    // Arrange, Act and Assert
    assertEquals(
        "Message<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href"
            + "  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a>Not all who wander are lost",
        ParserUtils.markupLinks(
            "Message<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>Not all who wander"
                + " are lost"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <ul>
   *   <li>When a string.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks_whenAString_thenReturnAString47() {
    // Arrange, Act and Assert
    assertEquals(
        "Message<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href"
            + "  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a><a href=\"<  a  href  =  \"http:/"
            + "/UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp"
            + ";//UU&amp;&amp;\"  >xx</a></a>",
        ParserUtils.markupLinks(
            "Message<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a><  a  href  = "
                + " \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <ul>
   *   <li>When a string.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks_whenAString_thenReturnAString48() {
    // Arrange, Act and Assert
    assertEquals(
        "Message<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a "
            + " href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a><presentationML>(.*?)<"
            + "/presentationML>",
        ParserUtils.markupLinks(
            "Message<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a><presentationML>(.*?"
                + ")</presentationML>"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <ul>
   *   <li>When a string.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks_whenAString_thenReturnAString49() {
    // Arrange, Act and Assert
    assertEquals(
        "Not all who wander are lost<a href=\"<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\""
            + "  >xx</a>\"><  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a>",
        ParserUtils.markupLinks(
            "Not all who wander are lost<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\""
                + "  >xx</a>"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <ul>
   *   <li>When a string.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks_whenAString_thenReturnAString50() {
    // Arrange, Act and Assert
    assertEquals(
        "Message<presentationML>(.*?)</presentationML><a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;"
            + "&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\" "
            + " >xx</a></a>",
        ParserUtils.markupLinks(
            "Message<presentationML>(.*?)</presentationML><  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\""
                + "  >xx</a>"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <ul>
   *   <li>When a string.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks_whenAString_thenReturnAString51() {
    // Arrange, Act and Assert
    assertEquals(
        "42<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href  = "
            + " \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a><a href=\"<  a  href  =  \"http:/"
            + "/UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp"
            + ";//UU&amp;&amp;\"  >xx</a></a>",
        ParserUtils.markupLinks(
            "42<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a><  a  href  =  \"http:/"
                + "/UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <ul>
   *   <li>When a string.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks_whenAString_thenReturnAString52() {
    // Arrange, Act and Assert
    assertEquals(
        "42<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href"
            + "  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a><presentationML>(.*?)<"
            + "/presentationML>",
        ParserUtils.markupLinks(
            "42<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a><presentationML>(.*?)<"
                + "/presentationML>"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <ul>
   *   <li>When a string.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks_whenAString_thenReturnAString53() {
    // Arrange, Act and Assert
    assertEquals(
        "<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href  = "
            + " \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a>Not all who wander are lost<a href=",
        ParserUtils.markupLinks(
            "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>Not all who wander are"
                + " lost<a href="));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <ul>
   *   <li>When a string.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks_whenAString_thenReturnAString54() {
    // Arrange, Act and Assert
    assertEquals(
        "<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href  = "
            + " \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a>Not all who wander are lost<a href=\"",
        ParserUtils.markupLinks(
            "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>Not all who wander are lost<a"
                + " href=\""));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks_whenEmptyString_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", ParserUtils.markupLinks(""));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <ul>
   *   <li>When {@code Message42< a href = "http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;"
   *       >xx</a>}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks_whenMessage42AHrefHttpUuuuuuuuuuuuUuAmpAmpUuAmpAmpXxA() {
    // Arrange, Act and Assert
    assertEquals(
        "Message42<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a "
            + " href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a>",
        ParserUtils.markupLinks(
            "Message42<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <ul>
   *   <li>When {@code Message< a href = "http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;" >xx</a>}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks_whenMessageAHrefHttpUuuuuuuuuuuuUuAmpAmpUuAmpAmpXxA() {
    // Arrange, Act and Assert
    assertEquals(
        "Message<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href"
            + "  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a>",
        ParserUtils.markupLinks(
            "Message<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <ul>
   *   <li>When {@code Message< a href = "http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;"
   *       >xx</a>-}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks_whenMessageAHrefHttpUuuuuuuuuuuuUuAmpAmpUuAmpAmpXxA2() {
    // Arrange, Act and Assert
    assertEquals(
        "Message<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href"
            + "  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a>-",
        ParserUtils.markupLinks(
            "Message<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>-"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <ul>
   *   <li>When {@code Message< a href = "http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;"
   *       >xx</a>/>}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks_whenMessageAHrefHttpUuuuuuuuuuuuUuAmpAmpUuAmpAmpXxA3() {
    // Arrange, Act and Assert
    assertEquals(
        "Message<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href"
            + "  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a>/>",
        ParserUtils.markupLinks(
            "Message<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>/>"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <ul>
   *   <li>When {@code Message-< a href = "http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;"
   *       >xx</a>}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks_whenMessageAHrefHttpUuuuuuuuuuuuUuAmpAmpUuAmpAmpXxA4() {
    // Arrange, Act and Assert
    assertEquals(
        "Message-<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href"
            + "  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a>",
        ParserUtils.markupLinks(
            "Message-<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <ul>
   *   <li>When {@code Message/>< a href = "http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;"
   *       >xx</a>}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks_whenMessageAHrefHttpUuuuuuuuuuuuUuAmpAmpUuAmpAmpXxA5() {
    // Arrange, Act and Assert
    assertEquals(
        "Message/><a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a "
            + " href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a>",
        ParserUtils.markupLinks(
            "Message/><  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <ul>
   *   <li>When {@code Message< a href = "http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;"
   *       >xx</a>42}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks_whenMessageAHrefHttpUuuuuuuuuuuuUuAmpAmpUuAmpAmpXxA42() {
    // Arrange, Act and Assert
    assertEquals(
        "Message<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href"
            + "  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a>42",
        ParserUtils.markupLinks(
            "Message<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>42"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <ul>
   *   <li>When {@code Message< a href = "http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;"
   *       >xx</a>Message}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks_whenMessageAHrefHttpUuuuuuuuuuuuUuAmpAmpUuAmpAmpXxAMessage() {
    // Arrange, Act and Assert
    assertEquals(
        "Message<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href"
            + "  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a>Message",
        ParserUtils.markupLinks(
            "Message<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>Message"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <ul>
   *   <li>When {@code Message< a href = "http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;"
   *       >xx</a>www}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks_whenMessageAHrefHttpUuuuuuuuuuuuUuAmpAmpUuAmpAmpXxAWww() {
    // Arrange, Act and Assert
    assertEquals(
        "Message<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href"
            + "  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a>www",
        ParserUtils.markupLinks(
            "Message<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>www"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <ul>
   *   <li>When {@code MessageMessage< a href = "http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;"
   *       >xx</a>}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks_whenMessageMessageAHrefHttpUuuuuuuuuuuuUuAmpAmpUuAmpAmpXxA() {
    // Arrange, Act and Assert
    assertEquals(
        "MessageMessage<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\">< "
            + " a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a>",
        ParserUtils.markupLinks(
            "MessageMessage<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <ul>
   *   <li>When {@code Messagewww< a href = "http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;"
   *       >xx</a>}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks_whenMessagewwwAHrefHttpUuuuuuuuuuuuUuAmpAmpUuAmpAmpXxA() {
    // Arrange, Act and Assert
    assertEquals(
        "Messagewww<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a "
            + " href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a>",
        ParserUtils.markupLinks(
            "Messagewww<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <ul>
   *   <li>When {@code Not all who wander are lost}.
   *   <li>Then return {@code Not all who wander are lost}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks_whenNotAllWhoWanderAreLost_thenReturnNotAllWhoWanderAreLost() {
    // Arrange, Act and Assert
    assertEquals(
        "Not all who wander are lost", ParserUtils.markupLinks("Not all who wander are lost"));
  }

  /**
   * Test {@link ParserUtils#markupLinks(String)}.
   *
   * <ul>
   *   <li>When {@code www< a href = "http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;" >xx</a>}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.markupLinks(String)"})
  public void testMarkupLinks_whenWwwAHrefHttpUuuuuuuuuuuuUuAmpAmpUuAmpAmpXxA() {
    // Arrange, Act and Assert
    assertEquals(
        "www<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href  ="
            + "  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a>",
        ParserUtils.markupLinks(
            "www<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>"));
  }

  /**
   * Test {@link ParserUtils#buildStringFormatForLinks(String, boolean)}.
   *
   * <ul>
   *   <li>Then return FormatString is {@code Not all who wander are lost}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#buildStringFormatForLinks(String, boolean)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({
    "StringFormatterContainer ParserUtils.buildStringFormatForLinks(String, boolean)"
  })
  public void testBuildStringFormatForLinks_thenReturnFormatStringIsNotAllWhoWanderAreLost() {
    // Arrange and Act
    StringFormatterContainer actualBuildStringFormatForLinksResult =
        ParserUtils.buildStringFormatForLinks("Not all who wander are lost", true);

    // Assert
    assertEquals(
        "Not all who wander are lost", actualBuildStringFormatForLinksResult.getFormatString());
    assertTrue(actualBuildStringFormatForLinksResult.getValues().isEmpty());
  }

  /**
   * Test {@link ParserUtils#buildStringFormatForLinks(String, boolean)}.
   *
   * <ul>
   *   <li>Then return Values size is one.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#buildStringFormatForLinks(String, boolean)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({
    "StringFormatterContainer ParserUtils.buildStringFormatForLinks(String, boolean)"
  })
  public void testBuildStringFormatForLinks_thenReturnValuesSizeIsOne() {
    // Arrange, Act and Assert
    assertEquals(
        1,
        ParserUtils.buildStringFormatForLinks(
                "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>", true)
            .getValues()
            .size());
  }

  /**
   * Test {@link ParserUtils#buildStringFormatForLinks(String, boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then return Values size is one.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#buildStringFormatForLinks(String, boolean)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({
    "StringFormatterContainer ParserUtils.buildStringFormatForLinks(String, boolean)"
  })
  public void testBuildStringFormatForLinks_whenFalse_thenReturnValuesSizeIsOne() {
    // Arrange, Act and Assert
    assertEquals(
        1,
        ParserUtils.buildStringFormatForLinks(
                "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>",
                false)
            .getValues()
            .size());
  }

  /**
   * Test {@link ParserUtils#presentationFormat(String, Object[])}.
   *
   * <p>Method under test: {@link ParserUtils#presentationFormat(String, Object[])}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.presentationFormat(String, Object[])"})
  public void testPresentationFormat() {
    // Arrange and Act
    SafeString actualPresentationFormatResult =
        ParserUtils.presentationFormat(
            "%s", Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri());

    // Assert
    String expectedToStringResult =
        String.join(
            "",
            "<a href=\"",
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toString(),
            "\"/>");
    assertEquals(expectedToStringResult, actualPresentationFormatResult.toString());
  }

  /**
   * Test {@link ParserUtils#presentationFormat(String, Object[])}.
   *
   * <ul>
   *   <li>When {@code Args}.
   *   <li>Then return toString is {@code Args}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#presentationFormat(String, Object[])}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.presentationFormat(String, Object[])"})
  public void testPresentationFormat_whenArgs_thenReturnToStringIsArgs() {
    // Arrange
    Object[] args = new Object[] {"Args"};

    // Act and Assert
    assertEquals("Args", ParserUtils.presentationFormat("%s", args).toString());
    assertEquals("Args", args[0]);
    assertEquals(1, args.length);
  }

  /**
   * Test {@link ParserUtils#presentationFormat(String, Object[])}.
   *
   * <ul>
   *   <li>When cr lf.
   *   <li>Then first element is cr lf.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#presentationFormat(String, Object[])}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.presentationFormat(String, Object[])"})
  public void testPresentationFormat_whenCrLf_thenFirstElementIsCrLf() {
    // Arrange
    Object[] args = new Object[] {"\r\n"};

    // Act
    SafeString actualPresentationFormatResult = ParserUtils.presentationFormat("%s", args);

    // Assert
    assertEquals("\r\n", args[0]);
    assertEquals(1, args.length);
    assertEquals(ParserUtils.MESSAGEML_LINEBREAK, actualPresentationFormatResult.toString());
  }

  /**
   * Test {@link ParserUtils#presentationFormat(String, Object[])}.
   *
   * <ul>
   *   <li>When cr lf.
   *   <li>Then return toString is cr lf.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#presentationFormat(String, Object[])}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.presentationFormat(String, Object[])"})
  public void testPresentationFormat_whenCrLf_thenReturnToStringIsCrLf() {
    // Arrange
    Object[] args = new Object[] {"Args"};

    // Act
    SafeString actualPresentationFormatResult = ParserUtils.presentationFormat("\r\n", args);

    // Assert
    assertEquals("Args", args[0]);
    assertEquals("\r\n", actualPresentationFormatResult.toString());
    assertEquals(1, args.length);
  }

  /**
   * Test {@link ParserUtils#presentationFormat(String, Object[])}.
   *
   * <ul>
   *   <li>When {@link ParserUtils#CR_LF_OR_LF}.
   *   <li>Then return toString is {@code (<br/> )|(<br/> )|(\\r\<br/> )|(\<br/> )}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#presentationFormat(String, Object[])}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.presentationFormat(String, Object[])"})
  public void testPresentationFormat_whenCr_lf_or_lf_thenReturnToStringIsBrBrRBrBr() {
    // Arrange
    Object[] args = new Object[] {ParserUtils.CR_LF_OR_LF};

    // Act and Assert
    assertEquals(
        "(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)",
        ParserUtils.presentationFormat("%s", args).toString());
    assertEquals(1, args.length);
    assertEquals(ParserUtils.CR_LF_OR_LF, args[0]);
  }

  /**
   * Test {@link ParserUtils#presentationFormat(String, Object[])}.
   *
   * <ul>
   *   <li>When {@link SafeString#EMPTY_SAFE_STRING}.
   *   <li>Then first element {@link SafeString}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#presentationFormat(String, Object[])}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.presentationFormat(String, Object[])"})
  public void testPresentationFormat_whenEmpty_safe_string_thenFirstElementSafeString() {
    // Arrange
    Object[] args = new Object[] {SafeString.EMPTY_SAFE_STRING};

    // Act
    SafeString actualPresentationFormatResult = ParserUtils.presentationFormat("%s", args);

    // Assert
    Object object = args[0];
    assertTrue(object instanceof SafeString);
    assertEquals("", actualPresentationFormatResult.toString());
    assertEquals(1, args.length);
    assertSame(SafeString.EMPTY_SAFE_STRING, object);
  }

  /**
   * Test {@link ParserUtils#presentationFormat(String, Object[])}.
   *
   * <ul>
   *   <li>When {@link HashTag#HashTag(String)} with {@code Hashtag}.
   *   <li>Then first element {@link HashTag}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#presentationFormat(String, Object[])}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.presentationFormat(String, Object[])"})
  public void testPresentationFormat_whenHashTagWithHashtag_thenFirstElementHashTag() {
    // Arrange
    HashTag hashTag = new HashTag("Hashtag");
    Object[] args = new Object[] {hashTag};

    // Act
    SafeString actualPresentationFormatResult = ParserUtils.presentationFormat("%s", args);

    // Assert
    Object object = args[0];
    assertTrue(object instanceof HashTag);
    assertEquals("<hash tag=\"Hashtag\"/>", actualPresentationFormatResult.toString());
    assertEquals(1, args.length);
    assertSame(hashTag, object);
  }

  /**
   * Test {@link ParserUtils#presentationFormat(String, Object[])}.
   *
   * <ul>
   *   <li>When {@link ParserUtils#MESSAGEML_LINEBREAK}.
   *   <li>Then return toString is {@code &lt;br/&gt;}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#presentationFormat(String, Object[])}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.presentationFormat(String, Object[])"})
  public void testPresentationFormat_whenMessageml_linebreak_thenReturnToStringIsLtBrGt() {
    // Arrange
    Object[] args = new Object[] {ParserUtils.MESSAGEML_LINEBREAK};

    // Act and Assert
    assertEquals("&lt;br/&gt;", ParserUtils.presentationFormat("%s", args).toString());
    assertEquals(1, args.length);
    assertEquals(ParserUtils.MESSAGEML_LINEBREAK, args[0]);
  }

  /**
   * Test {@link ParserUtils#presentationFormat(String, Object[])}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then first element is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#presentationFormat(String, Object[])}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.presentationFormat(String, Object[])"})
  public void testPresentationFormat_whenNull_thenFirstElementIsNull() {
    // Arrange
    Object[] args = new Object[] {null};

    // Act and Assert
    assertEquals("", ParserUtils.presentationFormat("%s", args).toString());
    assertNull(args[0]);
    assertEquals(1, args.length);
  }

  /**
   * Test {@link ParserUtils#presentationFormat(String, Object[])}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return toString is {@code 1}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#presentationFormat(String, Object[])}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.presentationFormat(String, Object[])"})
  public void testPresentationFormat_whenOne_thenReturnToStringIs1() {
    // Arrange
    Object[] args = new Object[] {1};

    // Act and Assert
    assertEquals("1", ParserUtils.presentationFormat("%s", args).toString());
    assertEquals(1, ((Integer) args[0]).intValue());
    assertEquals(1, args.length);
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks() {
    // Arrange, Act and Assert
    assertEquals(
        "<br/>&lt;presentationML&gt;(.*?)&lt;/presentationML&gt;",
        ParserUtils.escapeAndAddLineBreaks("\r\n<presentationML>(.*?)</presentationML>")
            .toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks2() {
    // Arrange, Act and Assert
    assertEquals(
        "(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)&lt;presentationML&gt;(.*?)&lt;/presentationML&gt;",
        ParserUtils.escapeAndAddLineBreaks(
                "(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)<presentationML>(.*?)</presentationML>")
            .toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks3() {
    // Arrange, Act and Assert
    assertEquals(
        "&lt;presentationML&gt;(.*?)&lt;/presentationML&gt;<br/>",
        ParserUtils.escapeAndAddLineBreaks("<presentationML>(.*?)</presentationML>\r\n")
            .toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks4() {
    // Arrange, Act and Assert
    assertEquals(
        "&lt;presentationML&gt;(.*?)&lt;/presentationML&gt;(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)",
        ParserUtils.escapeAndAddLineBreaks(
                "<presentationML>(.*?)</presentationML>(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)")
            .toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks5() {
    // Arrange, Act and Assert
    assertEquals(
        "<br/><br/>&lt;presentationML&gt;(.*?)&lt;/presentationML&gt;",
        ParserUtils.escapeAndAddLineBreaks("\r\n\r\n<presentationML>(.*?)</presentationML>")
            .toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks6() {
    // Arrange, Act and Assert
    assertEquals(
        "<br/>(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)&lt;presentationML&gt;(.*?)&lt;/presentationML&gt;",
        ParserUtils.escapeAndAddLineBreaks(
                "\r\n(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)<presentationML>(.*?)</presentationML>")
            .toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks7() {
    // Arrange, Act and Assert
    assertEquals(
        "<br/>&lt;br/&gt;&lt;presentationML&gt;(.*?)&lt;/presentationML&gt;",
        ParserUtils.escapeAndAddLineBreaks("\r\n<br/><presentationML>(.*?)</presentationML>")
            .toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks8() {
    // Arrange, Act and Assert
    assertEquals(
        "<br/>String&lt;presentationML&gt;(.*?)&lt;/presentationML&gt;",
        ParserUtils.escapeAndAddLineBreaks("\r\nString<presentationML>(.*?)</presentationML>")
            .toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks9() {
    // Arrange, Act and Assert
    assertEquals(
        "<br/>42&lt;presentationML&gt;(.*?)&lt;/presentationML&gt;",
        ParserUtils.escapeAndAddLineBreaks("\r\n42<presentationML>(.*?)</presentationML>")
            .toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks10() {
    // Arrange, Act and Assert
    assertEquals(
        "<br/>-&lt;presentationML&gt;(.*?)&lt;/presentationML&gt;",
        ParserUtils.escapeAndAddLineBreaks("\r\n-<presentationML>(.*?)</presentationML>")
            .toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks11() {
    // Arrange, Act and Assert
    assertEquals(
        "<br/>/&gt;&lt;presentationML&gt;(.*?)&lt;/presentationML&gt;",
        ParserUtils.escapeAndAddLineBreaks("\r\n/><presentationML>(.*?)</presentationML>")
            .toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks12() {
    // Arrange, Act and Assert
    assertEquals(
        "<br/>&lt;presentationML&gt;(.*?)&lt;/presentationML&gt;<br/>",
        ParserUtils.escapeAndAddLineBreaks("\r\n<presentationML>(.*?)</presentationML>\r\n")
            .toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks13() {
    // Arrange, Act and Assert
    assertEquals(
        "<br/>&lt;presentationML&gt;(.*?)&lt;/presentationML&gt;(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)",
        ParserUtils.escapeAndAddLineBreaks(
                "\r\n<presentationML>(.*?)</presentationML>(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)")
            .toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks14() {
    // Arrange, Act and Assert
    assertEquals(
        "<br/>&lt;presentationML&gt;(.*?)&lt;/presentationML&gt;&lt;br/&gt;",
        ParserUtils.escapeAndAddLineBreaks("\r\n<presentationML>(.*?)</presentationML><br/>")
            .toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks15() {
    // Arrange, Act and Assert
    assertEquals(
        "<br/>&lt;presentationML&gt;(.*?)&lt;/presentationML&gt;String",
        ParserUtils.escapeAndAddLineBreaks("\r\n<presentationML>(.*?)</presentationML>String")
            .toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks16() {
    // Arrange, Act and Assert
    assertEquals(
        "<br/>&lt;presentationML&gt;(.*?)&lt;/presentationML&gt;42",
        ParserUtils.escapeAndAddLineBreaks("\r\n<presentationML>(.*?)</presentationML>42")
            .toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks17() {
    // Arrange, Act and Assert
    assertEquals(
        "<br/>&lt;presentationML&gt;(.*?)&lt;/presentationML&gt;-",
        ParserUtils.escapeAndAddLineBreaks("\r\n<presentationML>(.*?)</presentationML>-")
            .toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks18() {
    // Arrange, Act and Assert
    assertEquals(
        "<br/>&lt;presentationML&gt;(.*?)&lt;/presentationML&gt;/&gt;",
        ParserUtils.escapeAndAddLineBreaks("\r\n<presentationML>(.*?)</presentationML>/>")
            .toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks19() {
    // Arrange, Act and Assert
    assertEquals(
        "<br/>&lt;presentationML&gt;(.*?)&lt;/presentationML&gt;&lt;presentationML&gt;(.*?)&lt;/presentationML"
            + "&gt;",
        ParserUtils.escapeAndAddLineBreaks(
                "\r\n<presentationML>(.*?)</presentationML><presentationML>(.*?)</presentationML>")
            .toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks20() {
    // Arrange, Act and Assert
    assertEquals(
        "<br/>&lt;presentationML&gt;(.*?)&lt;/presentationML&gt;www",
        ParserUtils.escapeAndAddLineBreaks("\r\n<presentationML>(.*?)</presentationML>www")
            .toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks21() {
    // Arrange, Act and Assert
    assertEquals(
        "<br/>www&lt;presentationML&gt;(.*?)&lt;/presentationML&gt;",
        ParserUtils.escapeAndAddLineBreaks("\r\nwww<presentationML>(.*?)</presentationML>")
            .toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks22() {
    // Arrange, Act and Assert
    assertEquals(
        "(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)<br/>&lt;presentationML&gt;(.*?)&lt;/presentationML&gt;",
        ParserUtils.escapeAndAddLineBreaks(
                "(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)\r\n<presentationML>(.*?)</presentationML>")
            .toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks23() {
    // Arrange, Act and Assert
    assertEquals(
        "(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)&lt;br/&gt;&lt;presentationML&gt;(.*?)&lt;/presentationML&gt;",
        ParserUtils.escapeAndAddLineBreaks(
                "(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)<br/><presentationML>(.*?)</presentationML>")
            .toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks24() {
    // Arrange, Act and Assert
    assertEquals(
        "(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)String&lt;presentationML&gt;(.*?)&lt;/presentationML&gt;",
        ParserUtils.escapeAndAddLineBreaks(
                "(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)String<presentationML>(.*?)</presentationML>")
            .toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks25() {
    // Arrange, Act and Assert
    assertEquals(
        "(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)42&lt;presentationML&gt;(.*?)&lt;/presentationML&gt;",
        ParserUtils.escapeAndAddLineBreaks(
                "(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)42<presentationML>(.*?)</presentationML>")
            .toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks26() {
    // Arrange, Act and Assert
    assertEquals(
        "(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)-&lt;presentationML&gt;(.*?)&lt;/presentationML&gt;",
        ParserUtils.escapeAndAddLineBreaks(
                "(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)-<presentationML>(.*?)</presentationML>")
            .toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks27() {
    // Arrange, Act and Assert
    assertEquals(
        "(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)/&gt;&lt;presentationML&gt;(.*?)&lt;/presentationML&gt;",
        ParserUtils.escapeAndAddLineBreaks(
                "(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)/><presentationML>(.*?)</presentationML>")
            .toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks28() {
    // Arrange, Act and Assert
    assertEquals(
        "(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)&lt;presentationML&gt;(.*?)&lt;/presentationML&gt;<br/>",
        ParserUtils.escapeAndAddLineBreaks(
                "(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)<presentationML>(.*?)</presentationML>\r\n")
            .toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks29() {
    // Arrange, Act and Assert
    assertEquals(
        "(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)&lt;presentationML&gt;(.*?)&lt;/presentationML&gt;&lt;br/&gt;",
        ParserUtils.escapeAndAddLineBreaks(
                "(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)<presentationML>(.*?)</presentationML><br/>")
            .toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks30() {
    // Arrange, Act and Assert
    assertEquals(
        "(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)&lt;presentationML&gt;(.*?)&lt;/presentationML&gt;String",
        ParserUtils.escapeAndAddLineBreaks(
                "(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)<presentationML>(.*?)</presentationML>String")
            .toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks31() {
    // Arrange, Act and Assert
    assertEquals(
        "(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)&lt;presentationML&gt;(.*?)&lt;/presentationML&gt;42",
        ParserUtils.escapeAndAddLineBreaks(
                "(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)<presentationML>(.*?)</presentationML>42")
            .toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks32() {
    // Arrange, Act and Assert
    assertEquals(
        "(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)&lt;presentationML&gt;(.*?)&lt;/presentationML&gt;-",
        ParserUtils.escapeAndAddLineBreaks(
                "(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)<presentationML>(.*?)</presentationML>-")
            .toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks33() {
    // Arrange, Act and Assert
    assertEquals(
        "(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)&lt;presentationML&gt;(.*?)&lt;/presentationML&gt;/&gt;",
        ParserUtils.escapeAndAddLineBreaks(
                "(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)<presentationML>(.*?)</presentationML>/>")
            .toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks34() {
    // Arrange, Act and Assert
    assertEquals(
        "(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)&lt;presentationML&gt;(.*?)&lt;/presentationML&gt;www",
        ParserUtils.escapeAndAddLineBreaks(
                "(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)<presentationML>(.*?)</presentationML>www")
            .toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks35() {
    // Arrange, Act and Assert
    assertEquals(
        "(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)www&lt;presentationML&gt;(.*?)&lt;/presentationML&gt;",
        ParserUtils.escapeAndAddLineBreaks(
                "(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)www<presentationML>(.*?)</presentationML>")
            .toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks36() {
    // Arrange, Act and Assert
    assertEquals(
        "&lt;br/&gt;<br/>&lt;presentationML&gt;(.*?)&lt;/presentationML&gt;",
        ParserUtils.escapeAndAddLineBreaks("<br/>\r\n<presentationML>(.*?)</presentationML>")
            .toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks37() {
    // Arrange, Act and Assert
    assertEquals(
        "&lt;br/&gt;(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)&lt;presentationML&gt;(.*?)&lt;/presentationML&gt;",
        ParserUtils.escapeAndAddLineBreaks(
                "<br/>(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)<presentationML>(.*?)</presentationML>")
            .toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>Then return toString is {@code <br/> (<br/> )|(<br/> )|(\\r\<br/> )|(\<br/> )(<br/>
   *       )|(<br/> )|(\\r\<br/> )|(\<br/> )}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_thenReturnToStringIsBrBrBrRBrBrBrBrRBrBr() {
    // Arrange, Act and Assert
    assertEquals(
        "<br/>(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)",
        ParserUtils.escapeAndAddLineBreaks(
                "\r\n(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)")
            .toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>Then return toString is {@code <br/> (<br/> )|(<br/> )|(\\r\<br/> )|(\<br/> )String}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_thenReturnToStringIsBrBrBrRBrBrString() {
    // Arrange, Act and Assert
    assertEquals(
        "<br/>(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)String",
        ParserUtils.escapeAndAddLineBreaks("\r\n(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)String")
            .toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>Then return toString is {@code (<br/> )|(<br/> )|(\\r\<br/> )|(\<br/> )42(<br/> )|(<br/>
   *       )|(\\r\<br/> )|(\<br/> )}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_thenReturnToStringIsBrBrRBrBr42BrBrRBrBr() {
    // Arrange, Act and Assert
    assertEquals(
        "(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)42(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)",
        ParserUtils.escapeAndAddLineBreaks(
                "(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)42(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)")
            .toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>Then return toString is {@code (<br/> )|(<br/> )|(\\r\<br/> )|(\<br/> )42String}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_thenReturnToStringIsBrBrRBrBr42String() {
    // Arrange, Act and Assert
    assertEquals(
        "(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)42String",
        ParserUtils.escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)42String")
            .toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>Then return toString is {@code (<br/> )|(<br/> )|(\\r\<br/> )|(\<br/> )<br/> (<br/>
   *       )|(<br/> )|(\\r\<br/> )|(\<br/> )}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_thenReturnToStringIsBrBrRBrBrBrBrBrRBrBr() {
    // Arrange, Act and Assert
    assertEquals(
        "(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)<br/>(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)",
        ParserUtils.escapeAndAddLineBreaks(
                "(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)\r\n(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)")
            .toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>Then return toString is {@code (<br/> )|(<br/> )|(\\r\<br/> )|(\<br/> )(<br/> )|(<br/>
   *       )|(\\r\<br/> )|(\<br/> )}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_thenReturnToStringIsBrBrRBrBrBrBrRBrBr() {
    // Arrange, Act and Assert
    assertEquals(
        "(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)",
        ParserUtils.escapeAndAddLineBreaks(
                "(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)")
            .toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>Then return toString is {@code (<br/> )|(<br/> )|(\\r\<br/> )|(\<br/> )(<br/> )|(<br/>
   *       )|(\\r\<br/> )|(\<br/> )-}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_thenReturnToStringIsBrBrRBrBrBrBrRBrBr2() {
    // Arrange, Act and Assert
    assertEquals(
        "(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)-",
        ParserUtils.escapeAndAddLineBreaks(
                "(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)-")
            .toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>Then return toString is {@code (<br/> )|(<br/> )|(\\r\<br/> )|(\<br/> )-(<br/> )|(<br/>
   *       )|(\\r\<br/> )|(\<br/> )}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_thenReturnToStringIsBrBrRBrBrBrBrRBrBr3() {
    // Arrange, Act and Assert
    assertEquals(
        "(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)-(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)",
        ParserUtils.escapeAndAddLineBreaks(
                "(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)-(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)")
            .toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>Then return toString is {@code (<br/> )|(<br/> )|(\\r\<br/> )|(\<br/> )(<br/> )|(<br/>
   *       )|(\\r\<br/> )|(\<br/> )42}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_thenReturnToStringIsBrBrRBrBrBrBrRBrBr42() {
    // Arrange, Act and Assert
    assertEquals(
        "(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)42",
        ParserUtils.escapeAndAddLineBreaks(
                "(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)42")
            .toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>Then return toString is {@code (<br/> )|(<br/> )|(\\r\<br/> )|(\<br/> )(<br/> )|(<br/>
   *       )|(\\r\<br/> )|(\<br/> )<br/> }.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_thenReturnToStringIsBrBrRBrBrBrBrRBrBrBr() {
    // Arrange, Act and Assert
    assertEquals(
        "(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)<br/>",
        ParserUtils.escapeAndAddLineBreaks(
                "(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)\r\n")
            .toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>Then return toString is {@code (<br/> )|(<br/> )|(\\r\<br/> )|(\<br/> )(<br/> )|(<br/>
   *       )|(\\r\<br/> )|(\<br/> )/&gt;}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_thenReturnToStringIsBrBrRBrBrBrBrRBrBrGt() {
    // Arrange, Act and Assert
    assertEquals(
        "(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)/&gt;",
        ParserUtils.escapeAndAddLineBreaks(
                "(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)/>")
            .toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>Then return toString is {@code (<br/> )|(<br/> )|(\\r\<br/> )|(\<br/> )(<br/> )|(<br/>
   *       )|(\\r\<br/> )|(\<br/> )&lt;br/&gt;}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_thenReturnToStringIsBrBrRBrBrBrBrRBrBrLtBrGt() {
    // Arrange, Act and Assert
    assertEquals(
        "(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)&lt;br/&gt;",
        ParserUtils.escapeAndAddLineBreaks(
                "(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)<br/>")
            .toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>Then return toString is {@code (<br/> )|(<br/> )|(\\r\<br/> )|(\<br/> )(<br/> )|(<br/>
   *       )|(\\r\<br/> )|(\<br/> )String}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_thenReturnToStringIsBrBrRBrBrBrBrRBrBrString() {
    // Arrange, Act and Assert
    assertEquals(
        "(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)String",
        ParserUtils.escapeAndAddLineBreaks(
                "(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)String")
            .toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>Then return toString is {@code (<br/> )|(<br/> )|(\\r\<br/> )|(\<br/> )(<br/> )|(<br/>
   *       )|(\\r\<br/> )|(\<br/> )www}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_thenReturnToStringIsBrBrRBrBrBrBrRBrBrWww() {
    // Arrange, Act and Assert
    assertEquals(
        "(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)www",
        ParserUtils.escapeAndAddLineBreaks(
                "(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)www")
            .toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>Then return toString is {@code (<br/> )|(<br/> )|(\\r\<br/> )|(\<br/> )<br/> String}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_thenReturnToStringIsBrBrRBrBrBrString() {
    // Arrange, Act and Assert
    assertEquals(
        "(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)<br/>String",
        ParserUtils.escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)\r\nString")
            .toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>Then return toString is {@code (<br/> )|(<br/> )|(\\r\<br/> )|(\<br/> )/&gt;(<br/>
   *       )|(<br/> )|(\\r\<br/> )|(\<br/> )}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_thenReturnToStringIsBrBrRBrBrGtBrBrRBrBr() {
    // Arrange, Act and Assert
    assertEquals(
        "(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)/&gt;(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)",
        ParserUtils.escapeAndAddLineBreaks(
                "(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)/>(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)")
            .toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>Then return toString is {@code (<br/> )|(<br/> )|(\\r\<br/> )|(\<br/> )/&gt;String}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_thenReturnToStringIsBrBrRBrBrGtString() {
    // Arrange, Act and Assert
    assertEquals(
        "(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)/&gt;String",
        ParserUtils.escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)/>String")
            .toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>Then return toString is {@code (<br/> )|(<br/> )|(\\r\<br/> )|(\<br/> )&lt;br/&gt;(<br/>
   *       )|(<br/> )|(\\r\<br/> )|(\<br/> )}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_thenReturnToStringIsBrBrRBrBrLtBrGtBrBrRBrBr() {
    // Arrange, Act and Assert
    assertEquals(
        "(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)&lt;br/&gt;(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)",
        ParserUtils.escapeAndAddLineBreaks(
                "(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)<br/>(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)")
            .toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>Then return toString is {@code (<br/> )|(<br/> )|(\\r\<br/> )|(\<br/>
   *       )&lt;br/&gt;&lt;br/&gt;}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_thenReturnToStringIsBrBrRBrBrLtBrGtLtBrGt() {
    // Arrange, Act and Assert
    assertEquals(
        "(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)&lt;br/&gt;&lt;br/&gt;",
        ParserUtils.escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)<br/><br/>")
            .toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>Then return toString is {@code (<br/> )|(<br/> )|(\\r\<br/> )|(\<br/>
   *       )&lt;br/&gt;String}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_thenReturnToStringIsBrBrRBrBrLtBrGtString() {
    // Arrange, Act and Assert
    assertEquals(
        "(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)&lt;br/&gt;String",
        ParserUtils.escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)<br/>String")
            .toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>Then return toString is {@code (<br/> )|(<br/> )|(\\r\<br/> )|(\<br/> )&lt;br/&gt;www}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_thenReturnToStringIsBrBrRBrBrLtBrGtWww() {
    // Arrange, Act and Assert
    assertEquals(
        "(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)&lt;br/&gt;www",
        ParserUtils.escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)<br/>www")
            .toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>Then return toString is {@code (<br/> )|(<br/> )|(\\r\<br/> )|(\<br/> )String42}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_thenReturnToStringIsBrBrRBrBrString42() {
    // Arrange, Act and Assert
    assertEquals(
        "(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)String42",
        ParserUtils.escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)String42")
            .toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>Then return toString is {@code (<br/> )|(<br/> )|(\\r\<br/> )|(\<br/> )String<br/> }.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_thenReturnToStringIsBrBrRBrBrStringBr() {
    // Arrange, Act and Assert
    assertEquals(
        "(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)String<br/>",
        ParserUtils.escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)String\r\n")
            .toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>Then return toString is {@code (<br/> )|(<br/> )|(\\r\<br/> )|(\<br/> )String(<br/>
   *       )|(<br/> )|(\\r\<br/> )|(\<br/> )}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_thenReturnToStringIsBrBrRBrBrStringBrBrRBrBr() {
    // Arrange, Act and Assert
    assertEquals(
        "(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)String(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)",
        ParserUtils.escapeAndAddLineBreaks(
                "(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)String(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)")
            .toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>Then return toString is {@code (<br/> )|(<br/> )|(\\r\<br/> )|(\<br/> )String/&gt;}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_thenReturnToStringIsBrBrRBrBrStringGt() {
    // Arrange, Act and Assert
    assertEquals(
        "(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)String/&gt;",
        ParserUtils.escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)String/>")
            .toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>Then return toString is {@code (<br/> )|(<br/> )|(\\r\<br/> )|(\<br/>
   *       )String&lt;br/&gt;}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_thenReturnToStringIsBrBrRBrBrStringLtBrGt() {
    // Arrange, Act and Assert
    assertEquals(
        "(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)String&lt;br/&gt;",
        ParserUtils.escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)String<br/>")
            .toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>Then return toString is {@code (<br/> )|(<br/> )|(\\r\<br/> )|(\<br/> )StringString}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_thenReturnToStringIsBrBrRBrBrStringString() {
    // Arrange, Act and Assert
    assertEquals(
        "(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)StringString",
        ParserUtils.escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)StringString")
            .toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>Then return toString is {@code (<br/> )|(<br/> )|(\\r\<br/> )|(\<br/> )Stringwww}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_thenReturnToStringIsBrBrRBrBrStringwww() {
    // Arrange, Act and Assert
    assertEquals(
        "(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)Stringwww",
        ParserUtils.escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)Stringwww")
            .toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>Then return toString is {@code (<br/> )|(<br/> )|(\\r\<br/> )|(\<br/> )www(<br/> )|(<br/>
   *       )|(\\r\<br/> )|(\<br/> )}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_thenReturnToStringIsBrBrRBrBrWwwBrBrRBrBr() {
    // Arrange, Act and Assert
    assertEquals(
        "(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)www(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)",
        ParserUtils.escapeAndAddLineBreaks(
                "(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)www(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)")
            .toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>Then return toString is {@code (<br/> )|(<br/> )|(\\r\<br/> )|(\<br/> )www&lt;br/&gt;}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_thenReturnToStringIsBrBrRBrBrWwwLtBrGt() {
    // Arrange, Act and Assert
    assertEquals(
        "(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)www&lt;br/&gt;",
        ParserUtils.escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)www<br/>")
            .toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>Then return toString is {@code (<br/> )|(<br/> )|(\\r\<br/> )|(\<br/> )wwwString}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_thenReturnToStringIsBrBrRBrBrWwwString() {
    // Arrange, Act and Assert
    assertEquals(
        "(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)wwwString",
        ParserUtils.escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)wwwString")
            .toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>Then return toString is {@code <br/> /&gt;/&gt;}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_thenReturnToStringIsBrGtGt() {
    // Arrange, Act and Assert
    assertEquals("<br/>/&gt;/&gt;", ParserUtils.escapeAndAddLineBreaks("\r\n/>/>").toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>Then return toString is {@code <br/> String(<br/> )|(<br/> )|(\\r\<br/> )|(\<br/> )}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_thenReturnToStringIsBrStringBrBrRBrBr() {
    // Arrange, Act and Assert
    assertEquals(
        "<br/>String(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)",
        ParserUtils.escapeAndAddLineBreaks("\r\nString(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)")
            .toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>Then return toString is {@code &lt;br/&gt;(<br/> )|(<br/> )|(\\r\<br/> )|(\<br/> )(<br/>
   *       )|(<br/> )|(\\r\<br/> )|(\<br/> )}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_thenReturnToStringIsLtBrGtBrBrRBrBrBrBrRBrBr() {
    // Arrange, Act and Assert
    assertEquals(
        "&lt;br/&gt;(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)",
        ParserUtils.escapeAndAddLineBreaks(
                "<br/>(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)")
            .toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>Then return toString is {@code &lt;br/&gt;(<br/> )|(<br/> )|(\\r\<br/> )|(\<br/>
   *       )&lt;br/&gt;}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_thenReturnToStringIsLtBrGtBrBrRBrBrLtBrGt() {
    // Arrange, Act and Assert
    assertEquals(
        "&lt;br/&gt;(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)&lt;br/&gt;",
        ParserUtils.escapeAndAddLineBreaks("<br/>(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)<br/>")
            .toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>Then return toString is {@code &lt;br/&gt;(<br/> )|(<br/> )|(\\r\<br/> )|(\<br/>
   *       )String}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_thenReturnToStringIsLtBrGtBrBrRBrBrString() {
    // Arrange, Act and Assert
    assertEquals(
        "&lt;br/&gt;(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)String",
        ParserUtils.escapeAndAddLineBreaks("<br/>(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)String")
            .toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>Then return toString is {@code &lt;br/&gt;(<br/> )|(<br/> )|(\\r\<br/> )|(\<br/> )www}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_thenReturnToStringIsLtBrGtBrBrRBrBrWww() {
    // Arrange, Act and Assert
    assertEquals(
        "&lt;br/&gt;(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)www",
        ParserUtils.escapeAndAddLineBreaks("<br/>(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)www")
            .toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>Then return toString is {@code &lt;br/&gt;&lt;br/&gt;(<br/> )|(<br/> )|(\\r\<br/>
   *       )|(\<br/> )}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_thenReturnToStringIsLtBrGtLtBrGtBrBrRBrBr() {
    // Arrange, Act and Assert
    assertEquals(
        "&lt;br/&gt;&lt;br/&gt;(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)",
        ParserUtils.escapeAndAddLineBreaks("<br/><br/>(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)")
            .toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>Then return toString is {@code &lt;br/&gt;String(<br/> )|(<br/> )|(\\r\<br/> )|(\<br/>
   *       )}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_thenReturnToStringIsLtBrGtStringBrBrRBrBr() {
    // Arrange, Act and Assert
    assertEquals(
        "&lt;br/&gt;String(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)",
        ParserUtils.escapeAndAddLineBreaks("<br/>String(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)")
            .toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code 42<br/> }.
   *   <li>Then return toString is {@code <br/> 42&lt;br/&gt;}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_when42Br_thenReturnToStringIsBr42LtBrGt() {
    // Arrange, Act and Assert
    assertEquals(
        "<br/>42&lt;br/&gt;", ParserUtils.escapeAndAddLineBreaks("\r\n42<br/>").toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code 42(\r\n)|(\n)|(\\r\\n)|(\\n)}.
   *   <li>Then return toString is {@code 42(<br/> )|(<br/> )|(\\r\<br/> )|(\<br/> )}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_when42RNNRNN_thenReturnToStringIs42BrBrRBrBr() {
    // Arrange, Act and Assert
    assertEquals(
        "42(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)",
        ParserUtils.escapeAndAddLineBreaks("42(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)").toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code 42(\r\n)|(\n)|(\\r\\n)|(\\n)}.
   *   <li>Then return toString is {@code <br/> 42(<br/> )|(<br/> )|(\\r\<br/> )|(\<br/> )}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_when42RNNRNN_thenReturnToStringIsBr42BrBrRBrBr() {
    // Arrange, Act and Assert
    assertEquals(
        "<br/>42(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)",
        ParserUtils.escapeAndAddLineBreaks("\r\n42(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)").toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code 42String}.
   *   <li>Then return toString is {@code <br/> 42String}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_when42String_thenReturnToStringIsBr42String() {
    // Arrange, Act and Assert
    assertEquals("<br/>42String", ParserUtils.escapeAndAddLineBreaks("\r\n42String").toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return toString is {@code 42<br/> }.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_when42_thenReturnToStringIs42Br() {
    // Arrange, Act and Assert
    assertEquals("42<br/>", ParserUtils.escapeAndAddLineBreaks("42\r\n").toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return toString is {@code <br/> 42}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_when42_thenReturnToStringIsBr42() {
    // Arrange, Act and Assert
    assertEquals("<br/>42", ParserUtils.escapeAndAddLineBreaks("\r\n42").toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return toString is {@code <br/> 42<br/> }.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_when42_thenReturnToStringIsBr42Br() {
    // Arrange, Act and Assert
    assertEquals("<br/>42<br/>", ParserUtils.escapeAndAddLineBreaks("\r\n42\r\n").toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code 42/>}.
   *   <li>Then return toString is {@code <br/> 42/&gt;}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_when42_thenReturnToStringIsBr42Gt() {
    // Arrange, Act and Assert
    assertEquals("<br/>42/&gt;", ParserUtils.escapeAndAddLineBreaks("\r\n42/>").toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code 42-}.
   *   <li>Then return toString is {@code <br/> 42-}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_when42_thenReturnToStringIsBr422() {
    // Arrange, Act and Assert
    assertEquals("<br/>42-", ParserUtils.escapeAndAddLineBreaks("\r\n42-").toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code -42}.
   *   <li>Then return toString is {@code <br/> -42}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_when42_thenReturnToStringIsBr423() {
    // Arrange, Act and Assert
    assertEquals("<br/>-42", ParserUtils.escapeAndAddLineBreaks("\r\n-42").toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return toString is {@code <br/> <br/> 42}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_when42_thenReturnToStringIsBrBr42() {
    // Arrange, Act and Assert
    assertEquals("<br/><br/>42", ParserUtils.escapeAndAddLineBreaks("\r\n\r\n42").toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code />42}.
   *   <li>Then return toString is {@code <br/> /&gt;42}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_when42_thenReturnToStringIsBrGt42() {
    // Arrange, Act and Assert
    assertEquals("<br/>/&gt;42", ParserUtils.escapeAndAddLineBreaks("\r\n/>42").toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code 42www}.
   *   <li>Then return toString is {@code <br/> 42www}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_when42www_thenReturnToStringIsBr42www() {
    // Arrange, Act and Assert
    assertEquals("<br/>42www", ParserUtils.escapeAndAddLineBreaks("\r\n42www").toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code 4242}.
   *   <li>Then return toString is {@code <br/> 4242}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_when4242_thenReturnToStringIsBr4242() {
    // Arrange, Act and Assert
    assertEquals("<br/>4242", ParserUtils.escapeAndAddLineBreaks("\r\n4242").toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When a string.
   *   <li>Then return toString is a string.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenAString_thenReturnToStringIsAString() {
    // Arrange, Act and Assert
    assertEquals(
        "(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)&lt;presentationML&gt;(.*?)&lt;/presentationML&gt;&lt;presentationML"
            + "&gt;(.*?)&lt;/presentationML&gt;",
        ParserUtils.escapeAndAddLineBreaks(
                "(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)<presentationML>(.*?)</presentationML><presentationML>(.*?)<"
                    + "/presentationML>")
            .toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code <br/> 42(\r\n)|(\n)|(\\r\\n)|(\\n)}.
   *   <li>Then return toString is {@code &lt;br/&gt;42(<br/> )|(<br/> )|(\\r\<br/> )|(\<br/> )}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenBr42RNNRNN_thenReturnToStringIsLtBrGt42BrBrRBrBr() {
    // Arrange, Act and Assert
    assertEquals(
        "&lt;br/&gt;42(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)",
        ParserUtils.escapeAndAddLineBreaks("<br/>42(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)")
            .toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code <br/> 42}.
   *   <li>Then return toString is {@code <br/> &lt;br/&gt;42}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenBr42_thenReturnToStringIsBrLtBrGt42() {
    // Arrange, Act and Assert
    assertEquals(
        "<br/>&lt;br/&gt;42", ParserUtils.escapeAndAddLineBreaks("\r\n<br/>42").toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code <br/> 42}.
   *   <li>Then return toString is {@code &lt;br/&gt;42<br/> }.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenBr42_thenReturnToStringIsLtBrGt42Br() {
    // Arrange, Act and Assert
    assertEquals(
        "&lt;br/&gt;42<br/>", ParserUtils.escapeAndAddLineBreaks("<br/>42\r\n").toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code <br/> 42}.
   *   <li>Then return toString is {@code &lt;br/&gt;<br/> 42}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenBr42_thenReturnToStringIsLtBrGtBr42() {
    // Arrange, Act and Assert
    assertEquals(
        "&lt;br/&gt;<br/>42", ParserUtils.escapeAndAddLineBreaks("<br/>\r\n42").toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code <br/> <br/> }.
   *   <li>Then return toString is {@code <br/> &lt;br/&gt;&lt;br/&gt;}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenBrBr_thenReturnToStringIsBrLtBrGtLtBrGt() {
    // Arrange, Act and Assert
    assertEquals(
        "<br/>&lt;br/&gt;&lt;br/&gt;",
        ParserUtils.escapeAndAddLineBreaks("\r\n<br/><br/>").toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code <br/> <br/> }.
   *   <li>Then return toString is {@code &lt;br/&gt;<br/> &lt;br/&gt;}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenBrBr_thenReturnToStringIsLtBrGtBrLtBrGt() {
    // Arrange, Act and Assert
    assertEquals(
        "&lt;br/&gt;<br/>&lt;br/&gt;",
        ParserUtils.escapeAndAddLineBreaks("<br/>\r\n<br/>").toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code <br/> <br/> }.
   *   <li>Then return toString is {@code &lt;br/&gt;&lt;br/&gt;<br/> }.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenBrBr_thenReturnToStringIsLtBrGtLtBrGtBr() {
    // Arrange, Act and Assert
    assertEquals(
        "&lt;br/&gt;&lt;br/&gt;<br/>",
        ParserUtils.escapeAndAddLineBreaks("<br/><br/>\r\n").toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code <br/> (\r\n)|(\n)|(\\r\\n)|(\\n)42}.
   *   <li>Then return toString is {@code &lt;br/&gt;(<br/> )|(<br/> )|(\\r\<br/> )|(\<br/> )42}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenBrRNNRNN42_thenReturnToStringIsLtBrGtBrBrRBrBr42() {
    // Arrange, Act and Assert
    assertEquals(
        "&lt;br/&gt;(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)42",
        ParserUtils.escapeAndAddLineBreaks("<br/>(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)42")
            .toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code <br/> (\r\n)|(\n)|(\\r\\n)|(\\n)}.
   *   <li>Then return toString is {@code <br/> &lt;br/&gt;(<br/> )|(<br/> )|(\\r\<br/> )|(\<br/>
   *       )}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenBrRNNRNN_thenReturnToStringIsBrLtBrGtBrBrRBrBr() {
    // Arrange, Act and Assert
    assertEquals(
        "<br/>&lt;br/&gt;(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)",
        ParserUtils.escapeAndAddLineBreaks("\r\n<br/>(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)")
            .toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code <br/> (\r\n)|(\n)|(\\r\\n)|(\\n)}.
   *   <li>Then return toString is {@code &lt;br/&gt;<br/> (<br/> )|(<br/> )|(\\r\<br/> )|(\<br/>
   *       )}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenBrRNNRNN_thenReturnToStringIsLtBrGtBrBrBrRBrBr() {
    // Arrange, Act and Assert
    assertEquals(
        "&lt;br/&gt;<br/>(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)",
        ParserUtils.escapeAndAddLineBreaks("<br/>\r\n(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)")
            .toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code <br/> (\r\n)|(\n)|(\\r\\n)|(\\n)}.
   *   <li>Then return toString is {@code &lt;br/&gt;(<br/> )|(<br/> )|(\\r\<br/> )|(\<br/> )}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenBrRNNRNN_thenReturnToStringIsLtBrGtBrBrRBrBr() {
    // Arrange, Act and Assert
    assertEquals(
        "&lt;br/&gt;(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)",
        ParserUtils.escapeAndAddLineBreaks("<br/>(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)").toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code <br/> (\r\n)|(\n)|(\\r\\n)|(\\n)-}.
   *   <li>Then return toString is {@code &lt;br/&gt;(<br/> )|(<br/> )|(\\r\<br/> )|(\<br/> )-}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenBrRNNRNN_thenReturnToStringIsLtBrGtBrBrRBrBr2() {
    // Arrange, Act and Assert
    assertEquals(
        "&lt;br/&gt;(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)-",
        ParserUtils.escapeAndAddLineBreaks("<br/>(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)-").toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code <br/> -(\r\n)|(\n)|(\\r\\n)|(\\n)}.
   *   <li>Then return toString is {@code &lt;br/&gt;-(<br/> )|(<br/> )|(\\r\<br/> )|(\<br/> )}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenBrRNNRNN_thenReturnToStringIsLtBrGtBrBrRBrBr3() {
    // Arrange, Act and Assert
    assertEquals(
        "&lt;br/&gt;-(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)",
        ParserUtils.escapeAndAddLineBreaks("<br/>-(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)").toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code <br/> (\r\n)|(\n)|(\\r\\n)|(\\n)}.
   *   <li>Then return toString is {@code &lt;br/&gt;(<br/> )|(<br/> )|(\\r\<br/> )|(\<br/> )<br/>
   *       }.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenBrRNNRNN_thenReturnToStringIsLtBrGtBrBrRBrBrBr() {
    // Arrange, Act and Assert
    assertEquals(
        "&lt;br/&gt;(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)<br/>",
        ParserUtils.escapeAndAddLineBreaks("<br/>(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)\r\n")
            .toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code <br/> (\r\n)|(\n)|(\\r\\n)|(\\n)/>}.
   *   <li>Then return toString is {@code &lt;br/&gt;(<br/> )|(<br/> )|(\\r\<br/> )|(\<br/> )/&gt;}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenBrRNNRNN_thenReturnToStringIsLtBrGtBrBrRBrBrGt() {
    // Arrange, Act and Assert
    assertEquals(
        "&lt;br/&gt;(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)/&gt;",
        ParserUtils.escapeAndAddLineBreaks("<br/>(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)/>")
            .toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code <br/> />(\r\n)|(\n)|(\\r\\n)|(\\n)}.
   *   <li>Then return toString is {@code &lt;br/&gt;/&gt;(<br/> )|(<br/> )|(\\r\<br/> )|(\<br/> )}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenBrRNNRNN_thenReturnToStringIsLtBrGtGtBrBrRBrBr() {
    // Arrange, Act and Assert
    assertEquals(
        "&lt;br/&gt;/&gt;(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)",
        ParserUtils.escapeAndAddLineBreaks("<br/>/>(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)")
            .toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code <br/> String}.
   *   <li>Then return toString is {@code <br/> &lt;br/&gt;String}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenBrString_thenReturnToStringIsBrLtBrGtString() {
    // Arrange, Act and Assert
    assertEquals(
        "<br/>&lt;br/&gt;String", ParserUtils.escapeAndAddLineBreaks("\r\n<br/>String").toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code <br/> String}.
   *   <li>Then return toString is {@code &lt;br/&gt;<br/> String}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenBrString_thenReturnToStringIsLtBrGtBrString() {
    // Arrange, Act and Assert
    assertEquals(
        "&lt;br/&gt;<br/>String", ParserUtils.escapeAndAddLineBreaks("<br/>\r\nString").toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code <br/> String}.
   *   <li>Then return toString is {@code &lt;br/&gt;String<br/> }.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenBrString_thenReturnToStringIsLtBrGtStringBr() {
    // Arrange, Act and Assert
    assertEquals(
        "&lt;br/&gt;String<br/>", ParserUtils.escapeAndAddLineBreaks("<br/>String\r\n").toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code <br/> www}.
   *   <li>Then return toString is {@code <br/> &lt;br/&gt;www}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenBrWww_thenReturnToStringIsBrLtBrGtWww() {
    // Arrange, Act and Assert
    assertEquals(
        "<br/>&lt;br/&gt;www", ParserUtils.escapeAndAddLineBreaks("\r\n<br/>www").toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code <br/> www}.
   *   <li>Then return toString is {@code &lt;br/&gt;<br/> www}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenBrWww_thenReturnToStringIsLtBrGtBrWww() {
    // Arrange, Act and Assert
    assertEquals(
        "&lt;br/&gt;<br/>www", ParserUtils.escapeAndAddLineBreaks("<br/>\r\nwww").toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code <br/> }.
   *   <li>Then return toString is {@code <br/> <br/> &lt;br/&gt;}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenBr_thenReturnToStringIsBrBrLtBrGt() {
    // Arrange, Act and Assert
    assertEquals(
        "<br/><br/>&lt;br/&gt;", ParserUtils.escapeAndAddLineBreaks("\r\n\r\n<br/>").toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code /><br/> }.
   *   <li>Then return toString is {@code <br/> /&gt;&lt;br/&gt;}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenBr_thenReturnToStringIsBrGtLtBrGt() {
    // Arrange, Act and Assert
    assertEquals(
        "<br/>/&gt;&lt;br/&gt;", ParserUtils.escapeAndAddLineBreaks("\r\n/><br/>").toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code <br/> }.
   *   <li>Then return toString is {@code <br/> &lt;br/&gt;}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenBr_thenReturnToStringIsBrLtBrGt() {
    // Arrange, Act and Assert
    assertEquals("<br/>&lt;br/&gt;", ParserUtils.escapeAndAddLineBreaks("\r\n<br/>").toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code <br/> -}.
   *   <li>Then return toString is {@code <br/> &lt;br/&gt;-}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenBr_thenReturnToStringIsBrLtBrGt2() {
    // Arrange, Act and Assert
    assertEquals("<br/>&lt;br/&gt;-", ParserUtils.escapeAndAddLineBreaks("\r\n<br/>-").toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code -<br/> }.
   *   <li>Then return toString is {@code <br/> -&lt;br/&gt;}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenBr_thenReturnToStringIsBrLtBrGt3() {
    // Arrange, Act and Assert
    assertEquals("<br/>-&lt;br/&gt;", ParserUtils.escapeAndAddLineBreaks("\r\n-<br/>").toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code <br/> }.
   *   <li>Then return toString is {@code <br/> &lt;br/&gt;<br/> }.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenBr_thenReturnToStringIsBrLtBrGtBr() {
    // Arrange, Act and Assert
    assertEquals(
        "<br/>&lt;br/&gt;<br/>", ParserUtils.escapeAndAddLineBreaks("\r\n<br/>\r\n").toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code <br/> />}.
   *   <li>Then return toString is {@code <br/> &lt;br/&gt;/&gt;}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenBr_thenReturnToStringIsBrLtBrGtGt() {
    // Arrange, Act and Assert
    assertEquals(
        "<br/>&lt;br/&gt;/&gt;", ParserUtils.escapeAndAddLineBreaks("\r\n<br/>/>").toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code <br/> }.
   *   <li>Then return toString is {@code &lt;br/&gt;<br/> }.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenBr_thenReturnToStringIsLtBrGtBr() {
    // Arrange, Act and Assert
    assertEquals("&lt;br/&gt;<br/>", ParserUtils.escapeAndAddLineBreaks("<br/>\r\n").toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code <br/> -}.
   *   <li>Then return toString is {@code &lt;br/&gt;<br/> -}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenBr_thenReturnToStringIsLtBrGtBr2() {
    // Arrange, Act and Assert
    assertEquals("&lt;br/&gt;<br/>-", ParserUtils.escapeAndAddLineBreaks("<br/>\r\n-").toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code <br/> -}.
   *   <li>Then return toString is {@code &lt;br/&gt;-<br/> }.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenBr_thenReturnToStringIsLtBrGtBr3() {
    // Arrange, Act and Assert
    assertEquals("&lt;br/&gt;-<br/>", ParserUtils.escapeAndAddLineBreaks("<br/>-\r\n").toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code <br/> }.
   *   <li>Then return toString is {@code &lt;br/&gt;<br/> <br/> }.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenBr_thenReturnToStringIsLtBrGtBrBr() {
    // Arrange, Act and Assert
    assertEquals(
        "&lt;br/&gt;<br/><br/>", ParserUtils.escapeAndAddLineBreaks("<br/>\r\n\r\n").toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code <br/> />}.
   *   <li>Then return toString is {@code &lt;br/&gt;<br/> /&gt;}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenBr_thenReturnToStringIsLtBrGtBrGt() {
    // Arrange, Act and Assert
    assertEquals(
        "&lt;br/&gt;<br/>/&gt;", ParserUtils.escapeAndAddLineBreaks("<br/>\r\n/>").toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code <br/> />}.
   *   <li>Then return toString is {@code &lt;br/&gt;/&gt;<br/> }.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenBr_thenReturnToStringIsLtBrGtGtBr() {
    // Arrange, Act and Assert
    assertEquals(
        "&lt;br/&gt;/&gt;<br/>", ParserUtils.escapeAndAddLineBreaks("<br/>/>\r\n").toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When cr lf cr lf cr lf.
   *   <li>Then return toString is {@code <br/> <br/> <br/> }.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenCrLfCrLfCrLf_thenReturnToStringIsBrBrBr() {
    // Arrange, Act and Assert
    assertEquals("<br/><br/><br/>", ParserUtils.escapeAndAddLineBreaks("\r\n\r\n\r\n").toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When cr lf cr lf.
   *   <li>Then return toString is {@code <br/> <br/> }.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenCrLfCrLf_thenReturnToStringIsBrBr() {
    // Arrange, Act and Assert
    assertEquals("<br/><br/>", ParserUtils.escapeAndAddLineBreaks("\r\n\r\n").toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When cr lf.
   *   <li>Then return toString is {@link ParserUtils#MESSAGEML_LINEBREAK}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenCrLf_thenReturnToStringIsMessageml_linebreak() {
    // Arrange, Act and Assert
    assertEquals(
        ParserUtils.MESSAGEML_LINEBREAK, ParserUtils.escapeAndAddLineBreaks("\r\n").toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@link ParserUtils#CR_LF_OR_LF}.
   *   <li>Then return toString is {@code (<br/> )|(<br/> )|(\\r\<br/> )|(\<br/> )}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenCr_lf_or_lf_thenReturnToStringIsBrBrRBrBr() {
    // Arrange, Act and Assert
    assertEquals(
        "(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)",
        ParserUtils.escapeAndAddLineBreaks(ParserUtils.CR_LF_OR_LF).toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code --}.
   *   <li>Then return toString is {@code <br/> --}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenDashDash_thenReturnToStringIsBr() {
    // Arrange, Act and Assert
    assertEquals("<br/>--", ParserUtils.escapeAndAddLineBreaks("\r\n--").toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code -/>}.
   *   <li>Then return toString is {@code <br/> -/&gt;}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenDashSlashGreaterThanSign_thenReturnToStringIsBrGt() {
    // Arrange, Act and Assert
    assertEquals("<br/>-/&gt;", ParserUtils.escapeAndAddLineBreaks("\r\n-/>").toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code -}.
   *   <li>Then return toString is {@code <br/> -}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenDash_thenReturnToStringIsBr() {
    // Arrange, Act and Assert
    assertEquals("<br/>-", ParserUtils.escapeAndAddLineBreaks("\r\n-").toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code -}.
   *   <li>Then return toString is {@code -<br/> }.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenDash_thenReturnToStringIsBr2() {
    // Arrange, Act and Assert
    assertEquals("-<br/>", ParserUtils.escapeAndAddLineBreaks("-\r\n").toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code -}.
   *   <li>Then return toString is {@code <br/> <br/> -}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenDash_thenReturnToStringIsBrBr() {
    // Arrange, Act and Assert
    assertEquals("<br/><br/>-", ParserUtils.escapeAndAddLineBreaks("\r\n\r\n-").toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code -}.
   *   <li>Then return toString is {@code <br/> -<br/> }.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenDash_thenReturnToStringIsBrBr2() {
    // Arrange, Act and Assert
    assertEquals("<br/>-<br/>", ParserUtils.escapeAndAddLineBreaks("\r\n-\r\n").toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@link ParserUtils#MESSAGEML_LINEBREAK}.
   *   <li>Then return toString is {@code &lt;br/&gt;}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenMessageml_linebreak_thenReturnToStringIsLtBrGt() {
    // Arrange, Act and Assert
    assertEquals(
        "&lt;br/&gt;",
        ParserUtils.escapeAndAddLineBreaks(ParserUtils.MESSAGEML_LINEBREAK).toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code (\r\n)|(\n)|(\\r\\n)|(\\n)42<br/> }.
   *   <li>Then return toString is {@code (<br/> )|(<br/> )|(\\r\<br/> )|(\<br/> )42&lt;br/&gt;}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenRNNRNN42Br_thenReturnToStringIsBrBrRBrBr42LtBrGt() {
    // Arrange, Act and Assert
    assertEquals(
        "(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)42&lt;br/&gt;",
        ParserUtils.escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)42<br/>")
            .toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code (\r\n)|(\n)|(\\r\\n)|(\\n)42}.
   *   <li>Then return toString is {@code <br/> (<br/> )|(<br/> )|(\\r\<br/> )|(\<br/> )42}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenRNNRNN42_thenReturnToStringIsBrBrBrRBrBr42() {
    // Arrange, Act and Assert
    assertEquals(
        "<br/>(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)42",
        ParserUtils.escapeAndAddLineBreaks("\r\n(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)42").toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code (\r\n)|(\n)|(\\r\\n)|(\\n)42}.
   *   <li>Then return toString is {@code (<br/> )|(<br/> )|(\\r\<br/> )|(\<br/> )42}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenRNNRNN42_thenReturnToStringIsBrBrRBrBr42() {
    // Arrange, Act and Assert
    assertEquals(
        "(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)42",
        ParserUtils.escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)42").toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code (\r\n)|(\n)|(\\r\\n)|(\\n)42}.
   *   <li>Then return toString is {@code (<br/> )|(<br/> )|(\\r\<br/> )|(\<br/> )42<br/> }.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenRNNRNN42_thenReturnToStringIsBrBrRBrBr42Br() {
    // Arrange, Act and Assert
    assertEquals(
        "(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)42<br/>",
        ParserUtils.escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)42\r\n").toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code (\r\n)|(\n)|(\\r\\n)|(\\n)42/>}.
   *   <li>Then return toString is {@code (<br/> )|(<br/> )|(\\r\<br/> )|(\<br/> )42/&gt;}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenRNNRNN42_thenReturnToStringIsBrBrRBrBr42Gt() {
    // Arrange, Act and Assert
    assertEquals(
        "(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)42/&gt;",
        ParserUtils.escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)42/>").toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code (\r\n)|(\n)|(\\r\\n)|(\\n)42-}.
   *   <li>Then return toString is {@code (<br/> )|(<br/> )|(\\r\<br/> )|(\<br/> )42-}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenRNNRNN42_thenReturnToStringIsBrBrRBrBr422() {
    // Arrange, Act and Assert
    assertEquals(
        "(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)42-",
        ParserUtils.escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)42-").toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code (\r\n)|(\n)|(\\r\\n)|(\\n)-42}.
   *   <li>Then return toString is {@code (<br/> )|(<br/> )|(\\r\<br/> )|(\<br/> )-42}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenRNNRNN42_thenReturnToStringIsBrBrRBrBr423() {
    // Arrange, Act and Assert
    assertEquals(
        "(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)-42",
        ParserUtils.escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)-42").toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code (\r\n)|(\n)|(\\r\\n)|(\\n) 42}.
   *   <li>Then return toString is {@code (<br/> )|(<br/> )|(\\r\<br/> )|(\<br/> )<br/> 42}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenRNNRNN42_thenReturnToStringIsBrBrRBrBrBr42() {
    // Arrange, Act and Assert
    assertEquals(
        "(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)<br/>42",
        ParserUtils.escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)\r\n42").toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code (\r\n)|(\n)|(\\r\\n)|(\\n)/>42}.
   *   <li>Then return toString is {@code (<br/> )|(<br/> )|(\\r\<br/> )|(\<br/> )/&gt;42}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenRNNRNN42_thenReturnToStringIsBrBrRBrBrGt42() {
    // Arrange, Act and Assert
    assertEquals(
        "(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)/&gt;42",
        ParserUtils.escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)/>42").toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code (\r\n)|(\n)|(\\r\\n)|(\\n)42www}.
   *   <li>Then return toString is {@code (<br/> )|(<br/> )|(\\r\<br/> )|(\<br/> )42www}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenRNNRNN42www_thenReturnToStringIsBrBrRBrBr42www() {
    // Arrange, Act and Assert
    assertEquals(
        "(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)42www",
        ParserUtils.escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)42www").toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code (\r\n)|(\n)|(\\r\\n)|(\\n)4242}.
   *   <li>Then return toString is {@code (<br/> )|(<br/> )|(\\r\<br/> )|(\<br/> )4242}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenRNNRNN4242_thenReturnToStringIsBrBrRBrBr4242() {
    // Arrange, Act and Assert
    assertEquals(
        "(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)4242",
        ParserUtils.escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)4242").toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code (\r\n)|(\n)|(\\r\\n)|(\\n)<br/> 42}.
   *   <li>Then return toString is {@code (<br/> )|(<br/> )|(\\r\<br/> )|(\<br/> )&lt;br/&gt;42}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenRNNRNNBr42_thenReturnToStringIsBrBrRBrBrLtBrGt42() {
    // Arrange, Act and Assert
    assertEquals(
        "(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)&lt;br/&gt;42",
        ParserUtils.escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)<br/>42")
            .toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code (\r\n)|(\n)|(\\r\\n)|(\\n)<br/> }.
   *   <li>Then return toString is {@code <br/> (<br/> )|(<br/> )|(\\r\<br/> )|(\<br/>
   *       )&lt;br/&gt;}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenRNNRNNBr_thenReturnToStringIsBrBrBrRBrBrLtBrGt() {
    // Arrange, Act and Assert
    assertEquals(
        "<br/>(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)&lt;br/&gt;",
        ParserUtils.escapeAndAddLineBreaks("\r\n(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)<br/>")
            .toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code (\r\n)|(\n)|(\\r\\n)|(\\n) <br/> }.
   *   <li>Then return toString is {@code (<br/> )|(<br/> )|(\\r\<br/> )|(\<br/> )<br/>
   *       &lt;br/&gt;}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenRNNRNNBr_thenReturnToStringIsBrBrRBrBrBrLtBrGt() {
    // Arrange, Act and Assert
    assertEquals(
        "(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)<br/>&lt;br/&gt;",
        ParserUtils.escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)\r\n<br/>")
            .toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code (\r\n)|(\n)|(\\r\\n)|(\\n)/><br/> }.
   *   <li>Then return toString is {@code (<br/> )|(<br/> )|(\\r\<br/> )|(\<br/> )/&gt;&lt;br/&gt;}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenRNNRNNBr_thenReturnToStringIsBrBrRBrBrGtLtBrGt() {
    // Arrange, Act and Assert
    assertEquals(
        "(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)/&gt;&lt;br/&gt;",
        ParserUtils.escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)/><br/>")
            .toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code (\r\n)|(\n)|(\\r\\n)|(\\n)<br/> }.
   *   <li>Then return toString is {@code (<br/> )|(<br/> )|(\\r\<br/> )|(\<br/> )&lt;br/&gt;}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenRNNRNNBr_thenReturnToStringIsBrBrRBrBrLtBrGt() {
    // Arrange, Act and Assert
    assertEquals(
        "(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)&lt;br/&gt;",
        ParserUtils.escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)<br/>").toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code (\r\n)|(\n)|(\\r\\n)|(\\n)<br/> -}.
   *   <li>Then return toString is {@code (<br/> )|(<br/> )|(\\r\<br/> )|(\<br/> )&lt;br/&gt;-}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenRNNRNNBr_thenReturnToStringIsBrBrRBrBrLtBrGt2() {
    // Arrange, Act and Assert
    assertEquals(
        "(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)&lt;br/&gt;-",
        ParserUtils.escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)<br/>-").toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code (\r\n)|(\n)|(\\r\\n)|(\\n)-<br/> }.
   *   <li>Then return toString is {@code (<br/> )|(<br/> )|(\\r\<br/> )|(\<br/> )-&lt;br/&gt;}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenRNNRNNBr_thenReturnToStringIsBrBrRBrBrLtBrGt3() {
    // Arrange, Act and Assert
    assertEquals(
        "(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)-&lt;br/&gt;",
        ParserUtils.escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)-<br/>").toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code (\r\n)|(\n)|(\\r\\n)|(\\n)<br/> }.
   *   <li>Then return toString is {@code (<br/> )|(<br/> )|(\\r\<br/> )|(\<br/> )&lt;br/&gt;<br/>
   *       }.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenRNNRNNBr_thenReturnToStringIsBrBrRBrBrLtBrGtBr() {
    // Arrange, Act and Assert
    assertEquals(
        "(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)&lt;br/&gt;<br/>",
        ParserUtils.escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)<br/>\r\n")
            .toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code (\r\n)|(\n)|(\\r\\n)|(\\n)<br/> />}.
   *   <li>Then return toString is {@code (<br/> )|(<br/> )|(\\r\<br/> )|(\<br/> )&lt;br/&gt;/&gt;}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenRNNRNNBr_thenReturnToStringIsBrBrRBrBrLtBrGtGt() {
    // Arrange, Act and Assert
    assertEquals(
        "(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)&lt;br/&gt;/&gt;",
        ParserUtils.escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)<br/>/>")
            .toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code
   *       (\r\n)|(\n)|(\\r\\n)|(\\n)<presentationML>(.*?)</presentationML>(\r\n)|(\n)|(\\r\\n)|(\\n)}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenRNNRNNPresentationMLPresentationMLRNNRNN() {
    // Arrange, Act and Assert
    assertEquals(
        "(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)&lt;presentationML&gt;(.*?)&lt;/presentationML&gt;(<br/>)|(<br/>"
            + ")|(\\\\r\\<br/>)|(\\<br/>)",
        ParserUtils.escapeAndAddLineBreaks(
                "(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)<presentationML>(.*?)</presentationML>(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)")
            .toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code
   *       (\r\n)|(\n)|(\\r\\n)|(\\n)(\r\n)|(\n)|(\\r\\n)|(\\n)<presentationML>(.*?)</presentationML>}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenRNNRNNRNNRNNPresentationMLPresentationML() {
    // Arrange, Act and Assert
    assertEquals(
        "(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)&lt;presentationML&gt;(.*?)"
            + "&lt;/presentationML&gt;",
        ParserUtils.escapeAndAddLineBreaks(
                "(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)<presentationML>(.*?)</presentationML>")
            .toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code
   *       (\r\n)|(\n)|(\\r\\n)|(\\n)(\r\n)|(\n)|(\\r\\n)|(\\n)(\r\n)|(\n)|(\\r\\n)|(\\n)}.
   *   <li>Then return toString is a string.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenRNNRNNRNNRNNRNNRNN_thenReturnToStringIsAString() {
    // Arrange, Act and Assert
    assertEquals(
        "(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)(<br/>)|(<br/>)|(\\\\r\\<br/>"
            + ")|(\\<br/>)",
        ParserUtils.escapeAndAddLineBreaks(
                "(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)")
            .toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code (\r\n)|(\n)|(\\r\\n)|(\\n)String}.
   *   <li>Then return toString is {@code (<br/> )|(<br/> )|(\\r\<br/> )|(\<br/> )String}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenRNNRNNString_thenReturnToStringIsBrBrRBrBrString() {
    // Arrange, Act and Assert
    assertEquals(
        "(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)String",
        ParserUtils.escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)String").toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code (\r\n)|(\n)|(\\r\\n)|(\\n)String-}.
   *   <li>Then return toString is {@code (<br/> )|(<br/> )|(\\r\<br/> )|(\<br/> )String-}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenRNNRNNString_thenReturnToStringIsBrBrRBrBrString2() {
    // Arrange, Act and Assert
    assertEquals(
        "(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)String-",
        ParserUtils.escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)String-")
            .toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code (\r\n)|(\n)|(\\r\\n)|(\\n)-String}.
   *   <li>Then return toString is {@code (<br/> )|(<br/> )|(\\r\<br/> )|(\<br/> )-String}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenRNNRNNString_thenReturnToStringIsBrBrRBrBrString3() {
    // Arrange, Act and Assert
    assertEquals(
        "(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)-String",
        ParserUtils.escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)-String")
            .toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code (\r\n)|(\n)|(\\r\\n)|(\\n)www42}.
   *   <li>Then return toString is {@code (<br/> )|(<br/> )|(\\r\<br/> )|(\<br/> )www42}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenRNNRNNWww42_thenReturnToStringIsBrBrRBrBrWww42() {
    // Arrange, Act and Assert
    assertEquals(
        "(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)www42",
        ParserUtils.escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)www42").toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code (\r\n)|(\n)|(\\r\\n)|(\\n)www}.
   *   <li>Then return toString is {@code <br/> (<br/> )|(<br/> )|(\\r\<br/> )|(\<br/> )www}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenRNNRNNWww_thenReturnToStringIsBrBrBrRBrBrWww() {
    // Arrange, Act and Assert
    assertEquals(
        "<br/>(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)www",
        ParserUtils.escapeAndAddLineBreaks("\r\n(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)www")
            .toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code (\r\n)|(\n)|(\\r\\n)|(\\n) www}.
   *   <li>Then return toString is {@code (<br/> )|(<br/> )|(\\r\<br/> )|(\<br/> )<br/> www}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenRNNRNNWww_thenReturnToStringIsBrBrRBrBrBrWww() {
    // Arrange, Act and Assert
    assertEquals(
        "(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)<br/>www",
        ParserUtils.escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)\r\nwww")
            .toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code (\r\n)|(\n)|(\\r\\n)|(\\n)/>www}.
   *   <li>Then return toString is {@code (<br/> )|(<br/> )|(\\r\<br/> )|(\<br/> )/&gt;www}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenRNNRNNWww_thenReturnToStringIsBrBrRBrBrGtWww() {
    // Arrange, Act and Assert
    assertEquals(
        "(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)/&gt;www",
        ParserUtils.escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)/>www").toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code (\r\n)|(\n)|(\\r\\n)|(\\n)www}.
   *   <li>Then return toString is {@code (<br/> )|(<br/> )|(\\r\<br/> )|(\<br/> )www}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenRNNRNNWww_thenReturnToStringIsBrBrRBrBrWww() {
    // Arrange, Act and Assert
    assertEquals(
        "(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)www",
        ParserUtils.escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)www").toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code (\r\n)|(\n)|(\\r\\n)|(\\n)-www}.
   *   <li>Then return toString is {@code (<br/> )|(<br/> )|(\\r\<br/> )|(\<br/> )-www}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenRNNRNNWww_thenReturnToStringIsBrBrRBrBrWww2() {
    // Arrange, Act and Assert
    assertEquals(
        "(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)-www",
        ParserUtils.escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)-www").toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code (\r\n)|(\n)|(\\r\\n)|(\\n)www-}.
   *   <li>Then return toString is {@code (<br/> )|(<br/> )|(\\r\<br/> )|(\<br/> )www-}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenRNNRNNWww_thenReturnToStringIsBrBrRBrBrWww3() {
    // Arrange, Act and Assert
    assertEquals(
        "(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)www-",
        ParserUtils.escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)www-").toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code (\r\n)|(\n)|(\\r\\n)|(\\n)www}.
   *   <li>Then return toString is {@code (<br/> )|(<br/> )|(\\r\<br/> )|(\<br/> )www<br/> }.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenRNNRNNWww_thenReturnToStringIsBrBrRBrBrWwwBr() {
    // Arrange, Act and Assert
    assertEquals(
        "(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)www<br/>",
        ParserUtils.escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)www\r\n")
            .toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code (\r\n)|(\n)|(\\r\\n)|(\\n)www/>}.
   *   <li>Then return toString is {@code (<br/> )|(<br/> )|(\\r\<br/> )|(\<br/> )www/&gt;}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenRNNRNNWww_thenReturnToStringIsBrBrRBrBrWwwGt() {
    // Arrange, Act and Assert
    assertEquals(
        "(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)www/&gt;",
        ParserUtils.escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)www/>").toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code (\r\n)|(\n)|(\\r\\n)|(\\n)wwwwww}.
   *   <li>Then return toString is {@code (<br/> )|(<br/> )|(\\r\<br/> )|(\<br/> )wwwwww}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenRNNRNNWwwwww_thenReturnToStringIsBrBrRBrBrWwwwww() {
    // Arrange, Act and Assert
    assertEquals(
        "(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)wwwwww",
        ParserUtils.escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)wwwwww").toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code (\r\n)|(\n)|(\\r\\n)|(\\n)}.
   *   <li>Then return toString is {@code <br/> <br/> (<br/> )|(<br/> )|(\\r\<br/> )|(\<br/> )}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenRNNRNN_thenReturnToStringIsBrBrBrBrRBrBr() {
    // Arrange, Act and Assert
    assertEquals(
        "<br/><br/>(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)",
        ParserUtils.escapeAndAddLineBreaks("\r\n\r\n(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)")
            .toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code (\r\n)|(\n)|(\\r\\n)|(\\n)}.
   *   <li>Then return toString is {@code <br/> (<br/> )|(<br/> )|(\\r\<br/> )|(\<br/> )}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenRNNRNN_thenReturnToStringIsBrBrBrRBrBr() {
    // Arrange, Act and Assert
    assertEquals(
        "<br/>(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)",
        ParserUtils.escapeAndAddLineBreaks("\r\n(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)").toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code (\r\n)|(\n)|(\\r\\n)|(\\n)-}.
   *   <li>Then return toString is {@code <br/> (<br/> )|(<br/> )|(\\r\<br/> )|(\<br/> )-}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenRNNRNN_thenReturnToStringIsBrBrBrRBrBr2() {
    // Arrange, Act and Assert
    assertEquals(
        "<br/>(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)-",
        ParserUtils.escapeAndAddLineBreaks("\r\n(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)-").toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code -(\r\n)|(\n)|(\\r\\n)|(\\n)}.
   *   <li>Then return toString is {@code <br/> -(<br/> )|(<br/> )|(\\r\<br/> )|(\<br/> )}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenRNNRNN_thenReturnToStringIsBrBrBrRBrBr3() {
    // Arrange, Act and Assert
    assertEquals(
        "<br/>-(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)",
        ParserUtils.escapeAndAddLineBreaks("\r\n-(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)").toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code (\r\n)|(\n)|(\\r\\n)|(\\n)}.
   *   <li>Then return toString is {@code <br/> (<br/> )|(<br/> )|(\\r\<br/> )|(\<br/> )<br/> }.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenRNNRNN_thenReturnToStringIsBrBrBrRBrBrBr() {
    // Arrange, Act and Assert
    assertEquals(
        "<br/>(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)<br/>",
        ParserUtils.escapeAndAddLineBreaks("\r\n(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)\r\n")
            .toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code (\r\n)|(\n)|(\\r\\n)|(\\n)/>}.
   *   <li>Then return toString is {@code <br/> (<br/> )|(<br/> )|(\\r\<br/> )|(\<br/> )/&gt;}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenRNNRNN_thenReturnToStringIsBrBrBrRBrBrGt() {
    // Arrange, Act and Assert
    assertEquals(
        "<br/>(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)/&gt;",
        ParserUtils.escapeAndAddLineBreaks("\r\n(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)/>").toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code (\r\n)|(\n)|(\\r\\n)|(\\n)-}.
   *   <li>Then return toString is {@code (<br/> )|(<br/> )|(\\r\<br/> )|(\<br/> )-}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenRNNRNN_thenReturnToStringIsBrBrRBrBr() {
    // Arrange, Act and Assert
    assertEquals(
        "(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)-",
        ParserUtils.escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)-").toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code -(\r\n)|(\n)|(\\r\\n)|(\\n)}.
   *   <li>Then return toString is {@code -(<br/> )|(<br/> )|(\\r\<br/> )|(\<br/> )}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenRNNRNN_thenReturnToStringIsBrBrRBrBr2() {
    // Arrange, Act and Assert
    assertEquals(
        "-(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)",
        ParserUtils.escapeAndAddLineBreaks("-(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)").toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code (\r\n)|(\n)|(\\r\\n)|(\\n)--}.
   *   <li>Then return toString is {@code (<br/> )|(<br/> )|(\\r\<br/> )|(\<br/> )--}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenRNNRNN_thenReturnToStringIsBrBrRBrBr3() {
    // Arrange, Act and Assert
    assertEquals(
        "(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)--",
        ParserUtils.escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)--").toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code (\r\n)|(\n)|(\\r\\n)|(\\n)}.
   *   <li>Then return toString is {@code (<br/> )|(<br/> )|(\\r\<br/> )|(\<br/> )<br/> }.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenRNNRNN_thenReturnToStringIsBrBrRBrBrBr() {
    // Arrange, Act and Assert
    assertEquals(
        "(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)<br/>",
        ParserUtils.escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)\r\n").toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code (\r\n)|(\n)|(\\r\\n)|(\\n) -}.
   *   <li>Then return toString is {@code (<br/> )|(<br/> )|(\\r\<br/> )|(\<br/> )<br/> -}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenRNNRNN_thenReturnToStringIsBrBrRBrBrBr2() {
    // Arrange, Act and Assert
    assertEquals(
        "(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)<br/>-",
        ParserUtils.escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)\r\n-").toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code (\r\n)|(\n)|(\\r\\n)|(\\n)-}.
   *   <li>Then return toString is {@code (<br/> )|(<br/> )|(\\r\<br/> )|(\<br/> )-<br/> }.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenRNNRNN_thenReturnToStringIsBrBrRBrBrBr3() {
    // Arrange, Act and Assert
    assertEquals(
        "(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)-<br/>",
        ParserUtils.escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)-\r\n").toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code (\r\n)|(\n)|(\\r\\n)|(\\n)}.
   *   <li>Then return toString is {@code (<br/> )|(<br/> )|(\\r\<br/> )|(\<br/> )<br/> <br/> }.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenRNNRNN_thenReturnToStringIsBrBrRBrBrBrBr() {
    // Arrange, Act and Assert
    assertEquals(
        "(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)<br/><br/>",
        ParserUtils.escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)\r\n\r\n")
            .toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code (\r\n)|(\n)|(\\r\\n)|(\\n) />}.
   *   <li>Then return toString is {@code (<br/> )|(<br/> )|(\\r\<br/> )|(\<br/> )<br/> /&gt;}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenRNNRNN_thenReturnToStringIsBrBrRBrBrBrGt() {
    // Arrange, Act and Assert
    assertEquals(
        "(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)<br/>/&gt;",
        ParserUtils.escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)\r\n/>").toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code (\r\n)|(\n)|(\\r\\n)|(\\n)/>}.
   *   <li>Then return toString is {@code (<br/> )|(<br/> )|(\\r\<br/> )|(\<br/> )/&gt;}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenRNNRNN_thenReturnToStringIsBrBrRBrBrGt() {
    // Arrange, Act and Assert
    assertEquals(
        "(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)/&gt;",
        ParserUtils.escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)/>").toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code (\r\n)|(\n)|(\\r\\n)|(\\n)-/>}.
   *   <li>Then return toString is {@code (<br/> )|(<br/> )|(\\r\<br/> )|(\<br/> )-/&gt;}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenRNNRNN_thenReturnToStringIsBrBrRBrBrGt2() {
    // Arrange, Act and Assert
    assertEquals(
        "(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)-/&gt;",
        ParserUtils.escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)-/>").toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code (\r\n)|(\n)|(\\r\\n)|(\\n)/>-}.
   *   <li>Then return toString is {@code (<br/> )|(<br/> )|(\\r\<br/> )|(\<br/> )/&gt;-}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenRNNRNN_thenReturnToStringIsBrBrRBrBrGt3() {
    // Arrange, Act and Assert
    assertEquals(
        "(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)/&gt;-",
        ParserUtils.escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)/>-").toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code (\r\n)|(\n)|(\\r\\n)|(\\n)/>}.
   *   <li>Then return toString is {@code (<br/> )|(<br/> )|(\\r\<br/> )|(\<br/> )/&gt;<br/> }.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenRNNRNN_thenReturnToStringIsBrBrRBrBrGtBr() {
    // Arrange, Act and Assert
    assertEquals(
        "(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)/&gt;<br/>",
        ParserUtils.escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)/>\r\n").toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code (\r\n)|(\n)|(\\r\\n)|(\\n)/>/>}.
   *   <li>Then return toString is {@code (<br/> )|(<br/> )|(\\r\<br/> )|(\<br/> )/&gt;/&gt;}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenRNNRNN_thenReturnToStringIsBrBrRBrBrGtGt() {
    // Arrange, Act and Assert
    assertEquals(
        "(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)/&gt;/&gt;",
        ParserUtils.escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)/>/>").toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code />(\r\n)|(\n)|(\\r\\n)|(\\n)}.
   *   <li>Then return toString is {@code <br/> /&gt;(<br/> )|(<br/> )|(\\r\<br/> )|(\<br/> )}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenRNNRNN_thenReturnToStringIsBrGtBrBrRBrBr() {
    // Arrange, Act and Assert
    assertEquals(
        "<br/>/&gt;(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)",
        ParserUtils.escapeAndAddLineBreaks("\r\n/>(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)").toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code />(\r\n)|(\n)|(\\r\\n)|(\\n)}.
   *   <li>Then return toString is {@code /&gt;(<br/> )|(<br/> )|(\\r\<br/> )|(\<br/> )}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenRNNRNN_thenReturnToStringIsGtBrBrRBrBr() {
    // Arrange, Act and Assert
    assertEquals(
        "/&gt;(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)",
        ParserUtils.escapeAndAddLineBreaks("/>(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)").toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code />-}.
   *   <li>Then return toString is {@code <br/> /&gt;-}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenSlashGreaterThanSignDash_thenReturnToStringIsBrGt() {
    // Arrange, Act and Assert
    assertEquals("<br/>/&gt;-", ParserUtils.escapeAndAddLineBreaks("\r\n/>-").toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code />}.
   *   <li>Then return toString is {@code <br/> <br/> /&gt;}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenSlashGreaterThanSign_thenReturnToStringIsBrBrGt() {
    // Arrange, Act and Assert
    assertEquals("<br/><br/>/&gt;", ParserUtils.escapeAndAddLineBreaks("\r\n\r\n/>").toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code />}.
   *   <li>Then return toString is {@code <br/> /&gt;}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenSlashGreaterThanSign_thenReturnToStringIsBrGt() {
    // Arrange, Act and Assert
    assertEquals("<br/>/&gt;", ParserUtils.escapeAndAddLineBreaks("\r\n/>").toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code />}.
   *   <li>Then return toString is {@code <br/> /&gt;<br/> }.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenSlashGreaterThanSign_thenReturnToStringIsBrGtBr() {
    // Arrange, Act and Assert
    assertEquals("<br/>/&gt;<br/>", ParserUtils.escapeAndAddLineBreaks("\r\n/>\r\n").toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code />}.
   *   <li>Then return toString is {@code /&gt;<br/> }.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenSlashGreaterThanSign_thenReturnToStringIsGtBr() {
    // Arrange, Act and Assert
    assertEquals("/&gt;<br/>", ParserUtils.escapeAndAddLineBreaks("/>\r\n").toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code String42}.
   *   <li>Then return toString is {@code <br/> String42}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenString42_thenReturnToStringIsBrString42() {
    // Arrange, Act and Assert
    assertEquals("<br/>String42", ParserUtils.escapeAndAddLineBreaks("\r\nString42").toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code String<br/> }.
   *   <li>Then return toString is {@code <br/> String&lt;br/&gt;}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenStringBr_thenReturnToStringIsBrStringLtBrGt() {
    // Arrange, Act and Assert
    assertEquals(
        "<br/>String&lt;br/&gt;", ParserUtils.escapeAndAddLineBreaks("\r\nString<br/>").toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code String(\r\n)|(\n)|(\\r\\n)|(\\n)}.
   *   <li>Then return toString is {@code String(<br/> )|(<br/> )|(\\r\<br/> )|(\<br/> )}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenStringRNNRNN_thenReturnToStringIsStringBrBrRBrBr() {
    // Arrange, Act and Assert
    assertEquals(
        "String(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)",
        ParserUtils.escapeAndAddLineBreaks("String(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)").toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code StringString}.
   *   <li>Then return toString is {@code <br/> StringString}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenStringString_thenReturnToStringIsBrStringString() {
    // Arrange, Act and Assert
    assertEquals(
        "<br/>StringString", ParserUtils.escapeAndAddLineBreaks("\r\nStringString").toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code String}.
   *   <li>Then return toString is {@code <br/> <br/> String}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenString_thenReturnToStringIsBrBrString() {
    // Arrange, Act and Assert
    assertEquals(
        "<br/><br/>String", ParserUtils.escapeAndAddLineBreaks("\r\n\r\nString").toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code />String}.
   *   <li>Then return toString is {@code <br/> /&gt;String}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenString_thenReturnToStringIsBrGtString() {
    // Arrange, Act and Assert
    assertEquals("<br/>/&gt;String", ParserUtils.escapeAndAddLineBreaks("\r\n/>String").toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code String}.
   *   <li>Then return toString is {@code <br/> String}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenString_thenReturnToStringIsBrString() {
    // Arrange, Act and Assert
    assertEquals("<br/>String", ParserUtils.escapeAndAddLineBreaks("\r\nString").toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code String-}.
   *   <li>Then return toString is {@code <br/> String-}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenString_thenReturnToStringIsBrString2() {
    // Arrange, Act and Assert
    assertEquals("<br/>String-", ParserUtils.escapeAndAddLineBreaks("\r\nString-").toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code -String}.
   *   <li>Then return toString is {@code <br/> -String}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenString_thenReturnToStringIsBrString3() {
    // Arrange, Act and Assert
    assertEquals("<br/>-String", ParserUtils.escapeAndAddLineBreaks("\r\n-String").toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code String}.
   *   <li>Then return toString is {@code <br/> String<br/> }.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenString_thenReturnToStringIsBrStringBr() {
    // Arrange, Act and Assert
    assertEquals(
        "<br/>String<br/>", ParserUtils.escapeAndAddLineBreaks("\r\nString\r\n").toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code String/>}.
   *   <li>Then return toString is {@code <br/> String/&gt;}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenString_thenReturnToStringIsBrStringGt() {
    // Arrange, Act and Assert
    assertEquals("<br/>String/&gt;", ParserUtils.escapeAndAddLineBreaks("\r\nString/>").toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code String}.
   *   <li>Then return toString is {@code String}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenString_thenReturnToStringIsString() {
    // Arrange, Act and Assert
    assertEquals("String", ParserUtils.escapeAndAddLineBreaks("String").toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code String}.
   *   <li>Then return toString is {@code String<br/> }.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenString_thenReturnToStringIsStringBr() {
    // Arrange, Act and Assert
    assertEquals("String<br/>", ParserUtils.escapeAndAddLineBreaks("String\r\n").toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code Stringwww}.
   *   <li>Then return toString is {@code <br/> Stringwww}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenStringwww_thenReturnToStringIsBrStringwww() {
    // Arrange, Act and Assert
    assertEquals("<br/>Stringwww", ParserUtils.escapeAndAddLineBreaks("\r\nStringwww").toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code www42}.
   *   <li>Then return toString is {@code <br/> www42}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenWww42_thenReturnToStringIsBrWww42() {
    // Arrange, Act and Assert
    assertEquals("<br/>www42", ParserUtils.escapeAndAddLineBreaks("\r\nwww42").toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code www<br/> }.
   *   <li>Then return toString is {@code <br/> www&lt;br/&gt;}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenWwwBr_thenReturnToStringIsBrWwwLtBrGt() {
    // Arrange, Act and Assert
    assertEquals(
        "<br/>www&lt;br/&gt;", ParserUtils.escapeAndAddLineBreaks("\r\nwww<br/>").toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code www(\r\n)|(\n)|(\\r\\n)|(\\n)}.
   *   <li>Then return toString is {@code <br/> www(<br/> )|(<br/> )|(\\r\<br/> )|(\<br/> )}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenWwwRNNRNN_thenReturnToStringIsBrWwwBrBrRBrBr() {
    // Arrange, Act and Assert
    assertEquals(
        "<br/>www(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)",
        ParserUtils.escapeAndAddLineBreaks("\r\nwww(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)")
            .toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code www(\r\n)|(\n)|(\\r\\n)|(\\n)}.
   *   <li>Then return toString is {@code www(<br/> )|(<br/> )|(\\r\<br/> )|(\<br/> )}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenWwwRNNRNN_thenReturnToStringIsWwwBrBrRBrBr() {
    // Arrange, Act and Assert
    assertEquals(
        "www(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)",
        ParserUtils.escapeAndAddLineBreaks("www(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)").toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code wwwString}.
   *   <li>Then return toString is {@code <br/> wwwString}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenWwwString_thenReturnToStringIsBrWwwString() {
    // Arrange, Act and Assert
    assertEquals("<br/>wwwString", ParserUtils.escapeAndAddLineBreaks("\r\nwwwString").toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code www}.
   *   <li>Then return toString is {@code <br/> <br/> www}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenWww_thenReturnToStringIsBrBrWww() {
    // Arrange, Act and Assert
    assertEquals("<br/><br/>www", ParserUtils.escapeAndAddLineBreaks("\r\n\r\nwww").toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code />www}.
   *   <li>Then return toString is {@code <br/> /&gt;www}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenWww_thenReturnToStringIsBrGtWww() {
    // Arrange, Act and Assert
    assertEquals("<br/>/&gt;www", ParserUtils.escapeAndAddLineBreaks("\r\n/>www").toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code www}.
   *   <li>Then return toString is {@code <br/> www}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenWww_thenReturnToStringIsBrWww() {
    // Arrange, Act and Assert
    assertEquals("<br/>www", ParserUtils.escapeAndAddLineBreaks("\r\nwww").toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code -www}.
   *   <li>Then return toString is {@code <br/> -www}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenWww_thenReturnToStringIsBrWww2() {
    // Arrange, Act and Assert
    assertEquals("<br/>-www", ParserUtils.escapeAndAddLineBreaks("\r\n-www").toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code www-}.
   *   <li>Then return toString is {@code <br/> www-}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenWww_thenReturnToStringIsBrWww3() {
    // Arrange, Act and Assert
    assertEquals("<br/>www-", ParserUtils.escapeAndAddLineBreaks("\r\nwww-").toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code www}.
   *   <li>Then return toString is {@code <br/> www<br/> }.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenWww_thenReturnToStringIsBrWwwBr() {
    // Arrange, Act and Assert
    assertEquals("<br/>www<br/>", ParserUtils.escapeAndAddLineBreaks("\r\nwww\r\n").toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code www/>}.
   *   <li>Then return toString is {@code <br/> www/&gt;}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenWww_thenReturnToStringIsBrWwwGt() {
    // Arrange, Act and Assert
    assertEquals("<br/>www/&gt;", ParserUtils.escapeAndAddLineBreaks("\r\nwww/>").toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code www}.
   *   <li>Then return toString is {@code www<br/> }.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenWww_thenReturnToStringIsWwwBr() {
    // Arrange, Act and Assert
    assertEquals("www<br/>", ParserUtils.escapeAndAddLineBreaks("www\r\n").toString());
  }

  /**
   * Test {@link ParserUtils#escapeAndAddLineBreaks(String)}.
   *
   * <ul>
   *   <li>When {@code wwwwww}.
   *   <li>Then return toString is {@code <br/> wwwwww}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString ParserUtils.escapeAndAddLineBreaks(String)"})
  public void testEscapeAndAddLineBreaks_whenWwwwww_thenReturnToStringIsBrWwwwww() {
    // Arrange, Act and Assert
    assertEquals("<br/>wwwwww", ParserUtils.escapeAndAddLineBreaks("\r\nwwwwww").toString());
  }

  /**
   * Test {@link ParserUtils#getPresentationMLContent(String)}.
   *
   * <ul>
   *   <li>When {@code Not all who wander are lost}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#getPresentationMLContent(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.getPresentationMLContent(String)"})
  public void testGetPresentationMLContent_whenNotAllWhoWanderAreLost_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", ParserUtils.getPresentationMLContent("Not all who wander are lost"));
  }

  /**
   * Test {@link ParserUtils#getPresentationMLContent(String)}.
   *
   * <ul>
   *   <li>When {@code <presentationML>xx</presentationML>}.
   *   <li>Then return {@code xx}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#getPresentationMLContent(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.getPresentationMLContent(String)"})
  public void testGetPresentationMLContent_whenPresentationMLXxPresentationML_thenReturnXx() {
    // Arrange, Act and Assert
    assertEquals("xx", ParserUtils.getPresentationMLContent("<presentationML>xx</presentationML>"));
  }

  /**
   * Test {@link ParserUtils#unescapePresentationML(String)}.
   *
   * <ul>
   *   <li>Then return {@code Not all who wander are lost}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#unescapePresentationML(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.unescapePresentationML(String)"})
  public void testUnescapePresentationML_thenReturnNotAllWhoWanderAreLost() {
    // Arrange, Act and Assert
    assertEquals(
        "Not all who wander are lost",
        ParserUtils.unescapePresentationML("Not all who wander are lost"));
  }

  /**
   * Test {@link ParserUtils#unescapePresentationML(String)}.
   *
   * <ul>
   *   <li>Then return {@code <presentationML>xx</presentationML>}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#unescapePresentationML(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.unescapePresentationML(String)"})
  public void testUnescapePresentationML_thenReturnPresentationMLXxPresentationML() {
    // Arrange, Act and Assert
    assertEquals(
        "<presentationML>xx</presentationML>",
        ParserUtils.unescapePresentationML("<presentationML>xx</presentationML>"));
  }

  /**
   * Test {@link ParserUtils#newUri(String)}.
   *
   * <ul>
   *   <li>When {@code Base Uri}.
   *   <li>Then throw {@link URISyntaxRuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#newUri(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"java.net.URI ParserUtils.newUri(String)"})
  public void testNewUri_whenBaseUri_thenThrowURISyntaxRuntimeException() {
    // Arrange, Act and Assert
    thrown.expect(URISyntaxRuntimeException.class);
    ParserUtils.newUri("Base Uri");
  }

  /**
   * Test {@link ParserUtils#buildEncodedUrl(String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/example}.
   *   <li>Then return {@code https://example.org/example}.
   * </ul>
   *
   * <p>Method under test: {@link ParserUtils#buildEncodedUrl(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ParserUtils.buildEncodedUrl(String)"})
  public void testBuildEncodedUrl_whenHttpsExampleOrgExample_thenReturnHttpsExampleOrgExample()
      throws MalformedURLException {
    // Arrange, Act and Assert
    assertEquals(
        "https://example.org/example", ParserUtils.buildEncodedUrl("https://example.org/example"));
  }
}
