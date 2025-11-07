package org.symphonyoss.integration.parser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.net.MalformedURLException;
import java.nio.file.Paths;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.symphonyoss.integration.exception.URISyntaxRuntimeException;
import org.symphonyoss.integration.parser.model.HashTag;

public class ParserUtilsDiffblueTest {
  @Rule
  public ExpectedException thrown = ExpectedException.none();

  /**
   * Method under test: {@link ParserUtils#markupLinks(String)}
   */
  @Test
  public void testMarkupLinks() {
    // Arrange, Act and Assert
    assertEquals("Not all who wander are lost", ParserUtils.markupLinks("Not all who wander are lost"));
    assertEquals(
        "<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href  = "
            + " \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a>",
        ParserUtils.markupLinks("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>"));
    assertEquals("", ParserUtils.markupLinks(""));
    assertEquals(
        "Not all who wander are lost<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\""
            + "  >xx</a>\"><  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a>",
        ParserUtils.markupLinks(
            "Not all who wander are lost<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>"));
    assertEquals(
        "<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href  = "
            + " \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a>Not all who wander are lost",
        ParserUtils.markupLinks(
            "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>Not all who wander are lost"));
    assertEquals(
        "<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href  = "
            + " \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a><a href=\"<  a  href  =  \"http:/"
            + "/UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp"
            + ";//UU&amp;&amp;\"  >xx</a></a>",
        ParserUtils.markupLinks(
            "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a><  a  href  =  \"http:/"
                + "/UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>"));
    assertEquals(
        "<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href  = "
            + " \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a>Message",
        ParserUtils.markupLinks("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>Message"));
    assertEquals(
        "<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href  = "
            + " \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a>42",
        ParserUtils.markupLinks("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>42"));
    assertEquals(
        "<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href  = "
            + " \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a>-",
        ParserUtils.markupLinks("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>-"));
    assertEquals(
        "<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href  = "
            + " \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a>/>",
        ParserUtils.markupLinks("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>/>"));
    assertEquals(
        "<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href  = "
            + " \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a><presentationML>(.*?)</presentationML"
            + ">",
        ParserUtils.markupLinks(
            "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a><presentationML>(.*?)<"
                + "/presentationML>"));
    assertEquals(
        "<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href  = "
            + " \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a>www",
        ParserUtils.markupLinks("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>www"));
    assertEquals(
        "<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href  = "
            + " \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a><a href=",
        ParserUtils.markupLinks("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a><a href="));
    assertEquals(
        "Message<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href"
            + "  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a>",
        ParserUtils.markupLinks("Message<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>"));
    assertEquals(
        "<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href  = "
            + " \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a><a href=\"",
        ParserUtils
            .markupLinks("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a><a href=\""));
    assertEquals(
        "<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href  = "
            + " \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a>\">",
        ParserUtils.markupLinks("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\">"));
    assertEquals(
        "<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href  = "
            + " \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a></a>",
        ParserUtils.markupLinks("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a>"));
    assertEquals(
        "42<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href  = "
            + " \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a>",
        ParserUtils.markupLinks("42<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>"));
    assertEquals(
        "-<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href  = "
            + " \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a>",
        ParserUtils.markupLinks("-<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>"));
    assertEquals(
        "<a href=<a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href"
            + "  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a>",
        ParserUtils.markupLinks("<a href=<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>"));
    assertEquals(
        "/><a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>\"><  a  href  = "
            + " \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a>",
        ParserUtils.markupLinks("/><  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>"));
    assertEquals(
        "<presentationML>(.*?)</presentationML><a href=\"<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU"
            + "&amp;&amp;\"  >xx</a>\"><  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a></a>",
        ParserUtils.markupLinks(
            "<presentationML>(.*?)</presentationML><  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\""
                + "  >xx</a>"));
  }

  /**
   * Method under test:
   * {@link ParserUtils#buildStringFormatForLinks(String, boolean)}
   */
  @Test
  public void testBuildStringFormatForLinks() {
    // Arrange and Act
    StringFormatterContainer actualBuildStringFormatForLinksResult = ParserUtils
        .buildStringFormatForLinks("Not all who wander are lost", true);

    // Assert
    assertEquals("Not all who wander are lost", actualBuildStringFormatForLinksResult.getFormatString());
    assertTrue(actualBuildStringFormatForLinksResult.getValues().isEmpty());
  }

  /**
   * Method under test:
   * {@link ParserUtils#buildStringFormatForLinks(String, boolean)}
   */
  @Test
  public void testBuildStringFormatForLinks2() {
    // Arrange, Act and Assert
    assertEquals(1, ParserUtils
        .buildStringFormatForLinks("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>", true)
        .getValues()
        .size());
  }

  /**
   * Method under test:
   * {@link ParserUtils#buildStringFormatForLinks(String, boolean)}
   */
  @Test
  public void testBuildStringFormatForLinks3() {
    // Arrange, Act and Assert
    assertEquals(1, ParserUtils
        .buildStringFormatForLinks("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>", false)
        .getValues()
        .size());
  }

  /**
   * Method under test: {@link ParserUtils#presentationFormat(String, Object[])}
   */
  @Test
  public void testPresentationFormat() {
    // Arrange, Act and Assert
    assertEquals("Args", ParserUtils.presentationFormat("%s", "Args").toString());
    assertEquals("\r\n", ParserUtils.presentationFormat("\r\n", "Args").toString());
    assertEquals(ParserUtils.MESSAGEML_LINEBREAK, ParserUtils.presentationFormat("%s", "\r\n").toString());
    assertEquals("(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)",
        ParserUtils.presentationFormat("%s", ParserUtils.CR_LF_OR_LF).toString());
    assertEquals("&lt;br/&gt;", ParserUtils.presentationFormat("%s", ParserUtils.MESSAGEML_LINEBREAK).toString());
    assertEquals("1", ParserUtils.presentationFormat("%s", 1).toString());
    assertEquals("<hash tag=\"Hashtag\"/>", ParserUtils.presentationFormat("%s", new HashTag("Hashtag")).toString());
  }

  /**
   * Method under test: {@link ParserUtils#presentationFormat(String, Object[])}
   */
  @Test
  public void testPresentationFormat2() {
    // Arrange
    Object[] args = new Object[]{SafeString.EMPTY_SAFE_STRING};

    // Act
    SafeString actualPresentationFormatResult = ParserUtils.presentationFormat("%s", args);

    // Assert
    Object object = args[0];
    assertTrue(object instanceof SafeString);
    assertEquals("", actualPresentationFormatResult.toString());
    assertEquals(1, args.length);
    assertSame(actualPresentationFormatResult.EMPTY_SAFE_STRING, object);
  }

  /**
   * Method under test: {@link ParserUtils#presentationFormat(String, Object[])}
   */
  @Test
  public void testPresentationFormat3() {
    // Arrange and Act
    SafeString actualPresentationFormatResult = ParserUtils.presentationFormat("%s",
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri());

    // Assert
    String expectedToStringResult = String.join("", "<a href=\"",
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toString(), "\"/>");
    assertEquals(expectedToStringResult, actualPresentationFormatResult.toString());
  }

  /**
   * Method under test: {@link ParserUtils#escapeAndAddLineBreaks(String)}
   */
  @Test
  public void testEscapeAndAddLineBreaks() {
    // Arrange, Act and Assert
    assertEquals("String", ParserUtils.escapeAndAddLineBreaks("String").toString());
    assertEquals(ParserUtils.MESSAGEML_LINEBREAK, ParserUtils.escapeAndAddLineBreaks("\r\n").toString());
    assertEquals("(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)",
        ParserUtils.escapeAndAddLineBreaks(ParserUtils.CR_LF_OR_LF).toString());
    assertEquals("&lt;br/&gt;", ParserUtils.escapeAndAddLineBreaks(ParserUtils.MESSAGEML_LINEBREAK).toString());
    assertEquals("<br/><br/>", ParserUtils.escapeAndAddLineBreaks("\r\n\r\n").toString());
    assertEquals("<br/>(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)",
        ParserUtils.escapeAndAddLineBreaks("\r\n(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)").toString());
    assertEquals("<br/>&lt;br/&gt;", ParserUtils.escapeAndAddLineBreaks("\r\n<br/>").toString());
    assertEquals("<br/>String", ParserUtils.escapeAndAddLineBreaks("\r\nString").toString());
    assertEquals("<br/>42", ParserUtils.escapeAndAddLineBreaks("\r\n42").toString());
    assertEquals("<br/>-", ParserUtils.escapeAndAddLineBreaks("\r\n-").toString());
    assertEquals("<br/>/&gt;", ParserUtils.escapeAndAddLineBreaks("\r\n/>").toString());
    assertEquals("<br/>&lt;presentationML&gt;(.*?)&lt;/presentationML&gt;",
        ParserUtils.escapeAndAddLineBreaks("\r\n<presentationML>(.*?)</presentationML>").toString());
    assertEquals("<br/>www", ParserUtils.escapeAndAddLineBreaks("\r\nwww").toString());
    assertEquals("(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)<br/>",
        ParserUtils.escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)\r\n").toString());
    assertEquals("(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)",
        ParserUtils.escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)")
            .toString());
    assertEquals("(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)&lt;br/&gt;",
        ParserUtils.escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)<br/>").toString());
    assertEquals("(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)String",
        ParserUtils.escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)String").toString());
    assertEquals("(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)42",
        ParserUtils.escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)42").toString());
    assertEquals("(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)-",
        ParserUtils.escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)-").toString());
    assertEquals("(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)/&gt;",
        ParserUtils.escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)/>").toString());
    assertEquals("(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)&lt;presentationML&gt;(.*?)&lt;/presentationML&gt;",
        ParserUtils.escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)<presentationML>(.*?)</presentationML>")
            .toString());
    assertEquals("(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)www",
        ParserUtils.escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)www").toString());
    assertEquals("&lt;br/&gt;<br/>", ParserUtils.escapeAndAddLineBreaks("<br/>\r\n").toString());
    assertEquals("&lt;br/&gt;(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)",
        ParserUtils.escapeAndAddLineBreaks("<br/>(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)").toString());
    assertEquals("String<br/>", ParserUtils.escapeAndAddLineBreaks("String\r\n").toString());
    assertEquals("String(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)",
        ParserUtils.escapeAndAddLineBreaks("String(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)").toString());
    assertEquals("42<br/>", ParserUtils.escapeAndAddLineBreaks("42\r\n").toString());
    assertEquals("42(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)",
        ParserUtils.escapeAndAddLineBreaks("42(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)").toString());
    assertEquals("-<br/>", ParserUtils.escapeAndAddLineBreaks("-\r\n").toString());
    assertEquals("-(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)",
        ParserUtils.escapeAndAddLineBreaks("-(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)").toString());
    assertEquals("/&gt;<br/>", ParserUtils.escapeAndAddLineBreaks("/>\r\n").toString());
    assertEquals("/&gt;(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)",
        ParserUtils.escapeAndAddLineBreaks("/>(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)").toString());
    assertEquals("&lt;presentationML&gt;(.*?)&lt;/presentationML&gt;<br/>",
        ParserUtils.escapeAndAddLineBreaks("<presentationML>(.*?)</presentationML>\r\n").toString());
    assertEquals("&lt;presentationML&gt;(.*?)&lt;/presentationML&gt;(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)",
        ParserUtils.escapeAndAddLineBreaks("<presentationML>(.*?)</presentationML>(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)")
            .toString());
    assertEquals("www<br/>", ParserUtils.escapeAndAddLineBreaks("www\r\n").toString());
    assertEquals("www(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)",
        ParserUtils.escapeAndAddLineBreaks("www(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)").toString());
    assertEquals("<br/><br/><br/>", ParserUtils.escapeAndAddLineBreaks("\r\n\r\n\r\n").toString());
    assertEquals("<br/><br/>(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)",
        ParserUtils.escapeAndAddLineBreaks("\r\n\r\n(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)").toString());
    assertEquals("<br/><br/>&lt;br/&gt;", ParserUtils.escapeAndAddLineBreaks("\r\n\r\n<br/>").toString());
    assertEquals("<br/><br/>String", ParserUtils.escapeAndAddLineBreaks("\r\n\r\nString").toString());
    assertEquals("<br/><br/>42", ParserUtils.escapeAndAddLineBreaks("\r\n\r\n42").toString());
    assertEquals("<br/><br/>-", ParserUtils.escapeAndAddLineBreaks("\r\n\r\n-").toString());
    assertEquals("<br/><br/>/&gt;", ParserUtils.escapeAndAddLineBreaks("\r\n\r\n/>").toString());
    assertEquals("<br/><br/>&lt;presentationML&gt;(.*?)&lt;/presentationML&gt;",
        ParserUtils.escapeAndAddLineBreaks("\r\n\r\n<presentationML>(.*?)</presentationML>").toString());
    assertEquals("<br/><br/>www", ParserUtils.escapeAndAddLineBreaks("\r\n\r\nwww").toString());
    assertEquals("<br/>(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)<br/>",
        ParserUtils.escapeAndAddLineBreaks("\r\n(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)\r\n").toString());
    assertEquals("<br/>(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)",
        ParserUtils.escapeAndAddLineBreaks("\r\n(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)")
            .toString());
    assertEquals("<br/>(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)&lt;br/&gt;",
        ParserUtils.escapeAndAddLineBreaks("\r\n(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)<br/>").toString());
    assertEquals("<br/>(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)String",
        ParserUtils.escapeAndAddLineBreaks("\r\n(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)String").toString());
    assertEquals("<br/>(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)42",
        ParserUtils.escapeAndAddLineBreaks("\r\n(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)42").toString());
    assertEquals("<br/>(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)-",
        ParserUtils.escapeAndAddLineBreaks("\r\n(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)-").toString());
    assertEquals("<br/>(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)/&gt;",
        ParserUtils.escapeAndAddLineBreaks("\r\n(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)/>").toString());
    assertEquals("<br/>(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)&lt;presentationML&gt;(.*?)&lt;/presentationML&gt;",
        ParserUtils
            .escapeAndAddLineBreaks("\r\n(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)<presentationML>(.*?)</presentationML>")
            .toString());
    assertEquals("<br/>(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)www",
        ParserUtils.escapeAndAddLineBreaks("\r\n(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)www").toString());
    assertEquals("<br/>&lt;br/&gt;<br/>", ParserUtils.escapeAndAddLineBreaks("\r\n<br/>\r\n").toString());
    assertEquals("<br/>&lt;br/&gt;(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)",
        ParserUtils.escapeAndAddLineBreaks("\r\n<br/>(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)").toString());
    assertEquals("<br/>&lt;br/&gt;&lt;br/&gt;", ParserUtils.escapeAndAddLineBreaks("\r\n<br/><br/>").toString());
    assertEquals("<br/>&lt;br/&gt;String", ParserUtils.escapeAndAddLineBreaks("\r\n<br/>String").toString());
    assertEquals("<br/>&lt;br/&gt;42", ParserUtils.escapeAndAddLineBreaks("\r\n<br/>42").toString());
    assertEquals("<br/>&lt;br/&gt;-", ParserUtils.escapeAndAddLineBreaks("\r\n<br/>-").toString());
    assertEquals("<br/>&lt;br/&gt;/&gt;", ParserUtils.escapeAndAddLineBreaks("\r\n<br/>/>").toString());
    assertEquals("<br/>&lt;br/&gt;&lt;presentationML&gt;(.*?)&lt;/presentationML&gt;",
        ParserUtils.escapeAndAddLineBreaks("\r\n<br/><presentationML>(.*?)</presentationML>").toString());
    assertEquals("<br/>&lt;br/&gt;www", ParserUtils.escapeAndAddLineBreaks("\r\n<br/>www").toString());
    assertEquals("<br/>String<br/>", ParserUtils.escapeAndAddLineBreaks("\r\nString\r\n").toString());
    assertEquals("<br/>String(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)",
        ParserUtils.escapeAndAddLineBreaks("\r\nString(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)").toString());
    assertEquals("<br/>String&lt;br/&gt;", ParserUtils.escapeAndAddLineBreaks("\r\nString<br/>").toString());
    assertEquals("<br/>StringString", ParserUtils.escapeAndAddLineBreaks("\r\nStringString").toString());
    assertEquals("<br/>String42", ParserUtils.escapeAndAddLineBreaks("\r\nString42").toString());
    assertEquals("<br/>String-", ParserUtils.escapeAndAddLineBreaks("\r\nString-").toString());
    assertEquals("<br/>String/&gt;", ParserUtils.escapeAndAddLineBreaks("\r\nString/>").toString());
    assertEquals("<br/>String&lt;presentationML&gt;(.*?)&lt;/presentationML&gt;",
        ParserUtils.escapeAndAddLineBreaks("\r\nString<presentationML>(.*?)</presentationML>").toString());
    assertEquals("<br/>Stringwww", ParserUtils.escapeAndAddLineBreaks("\r\nStringwww").toString());
    assertEquals("<br/>42<br/>", ParserUtils.escapeAndAddLineBreaks("\r\n42\r\n").toString());
    assertEquals("<br/>42(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)",
        ParserUtils.escapeAndAddLineBreaks("\r\n42(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)").toString());
    assertEquals("<br/>42&lt;br/&gt;", ParserUtils.escapeAndAddLineBreaks("\r\n42<br/>").toString());
    assertEquals("<br/>42String", ParserUtils.escapeAndAddLineBreaks("\r\n42String").toString());
    assertEquals("<br/>4242", ParserUtils.escapeAndAddLineBreaks("\r\n4242").toString());
    assertEquals("<br/>42-", ParserUtils.escapeAndAddLineBreaks("\r\n42-").toString());
    assertEquals("<br/>42/&gt;", ParserUtils.escapeAndAddLineBreaks("\r\n42/>").toString());
    assertEquals("<br/>42&lt;presentationML&gt;(.*?)&lt;/presentationML&gt;",
        ParserUtils.escapeAndAddLineBreaks("\r\n42<presentationML>(.*?)</presentationML>").toString());
    assertEquals("<br/>42www", ParserUtils.escapeAndAddLineBreaks("\r\n42www").toString());
    assertEquals("<br/>-<br/>", ParserUtils.escapeAndAddLineBreaks("\r\n-\r\n").toString());
    assertEquals("<br/>-(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)",
        ParserUtils.escapeAndAddLineBreaks("\r\n-(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)").toString());
    assertEquals("<br/>-&lt;br/&gt;", ParserUtils.escapeAndAddLineBreaks("\r\n-<br/>").toString());
    assertEquals("<br/>-String", ParserUtils.escapeAndAddLineBreaks("\r\n-String").toString());
    assertEquals("<br/>-42", ParserUtils.escapeAndAddLineBreaks("\r\n-42").toString());
    assertEquals("<br/>--", ParserUtils.escapeAndAddLineBreaks("\r\n--").toString());
    assertEquals("<br/>-/&gt;", ParserUtils.escapeAndAddLineBreaks("\r\n-/>").toString());
    assertEquals("<br/>-&lt;presentationML&gt;(.*?)&lt;/presentationML&gt;",
        ParserUtils.escapeAndAddLineBreaks("\r\n-<presentationML>(.*?)</presentationML>").toString());
    assertEquals("<br/>-www", ParserUtils.escapeAndAddLineBreaks("\r\n-www").toString());
    assertEquals("<br/>/&gt;<br/>", ParserUtils.escapeAndAddLineBreaks("\r\n/>\r\n").toString());
    assertEquals("<br/>/&gt;(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)",
        ParserUtils.escapeAndAddLineBreaks("\r\n/>(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)").toString());
    assertEquals("<br/>/&gt;&lt;br/&gt;", ParserUtils.escapeAndAddLineBreaks("\r\n/><br/>").toString());
    assertEquals("<br/>/&gt;String", ParserUtils.escapeAndAddLineBreaks("\r\n/>String").toString());
    assertEquals("<br/>/&gt;42", ParserUtils.escapeAndAddLineBreaks("\r\n/>42").toString());
    assertEquals("<br/>/&gt;-", ParserUtils.escapeAndAddLineBreaks("\r\n/>-").toString());
    assertEquals("<br/>/&gt;/&gt;", ParserUtils.escapeAndAddLineBreaks("\r\n/>/>").toString());
    assertEquals("<br/>/&gt;&lt;presentationML&gt;(.*?)&lt;/presentationML&gt;",
        ParserUtils.escapeAndAddLineBreaks("\r\n/><presentationML>(.*?)</presentationML>").toString());
    assertEquals("<br/>/&gt;www", ParserUtils.escapeAndAddLineBreaks("\r\n/>www").toString());
    assertEquals("<br/>&lt;presentationML&gt;(.*?)&lt;/presentationML&gt;<br/>",
        ParserUtils.escapeAndAddLineBreaks("\r\n<presentationML>(.*?)</presentationML>\r\n").toString());
    assertEquals("<br/>&lt;presentationML&gt;(.*?)&lt;/presentationML&gt;(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)",
        ParserUtils
            .escapeAndAddLineBreaks("\r\n<presentationML>(.*?)</presentationML>(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)")
            .toString());
    assertEquals("<br/>&lt;presentationML&gt;(.*?)&lt;/presentationML&gt;&lt;br/&gt;",
        ParserUtils.escapeAndAddLineBreaks("\r\n<presentationML>(.*?)</presentationML><br/>").toString());
    assertEquals("<br/>&lt;presentationML&gt;(.*?)&lt;/presentationML&gt;String",
        ParserUtils.escapeAndAddLineBreaks("\r\n<presentationML>(.*?)</presentationML>String").toString());
    assertEquals("<br/>&lt;presentationML&gt;(.*?)&lt;/presentationML&gt;42",
        ParserUtils.escapeAndAddLineBreaks("\r\n<presentationML>(.*?)</presentationML>42").toString());
    assertEquals("<br/>&lt;presentationML&gt;(.*?)&lt;/presentationML&gt;-",
        ParserUtils.escapeAndAddLineBreaks("\r\n<presentationML>(.*?)</presentationML>-").toString());
    assertEquals("<br/>&lt;presentationML&gt;(.*?)&lt;/presentationML&gt;/&gt;",
        ParserUtils.escapeAndAddLineBreaks("\r\n<presentationML>(.*?)</presentationML>/>").toString());
    assertEquals(
        "<br/>&lt;presentationML&gt;(.*?)&lt;/presentationML&gt;&lt;presentationML&gt;(.*?)&lt;/presentationML"
            + "&gt;",
        ParserUtils
            .escapeAndAddLineBreaks("\r\n<presentationML>(.*?)</presentationML><presentationML>(.*?)</presentationML>")
            .toString());
    assertEquals("<br/>&lt;presentationML&gt;(.*?)&lt;/presentationML&gt;www",
        ParserUtils.escapeAndAddLineBreaks("\r\n<presentationML>(.*?)</presentationML>www").toString());
    assertEquals("<br/>www<br/>", ParserUtils.escapeAndAddLineBreaks("\r\nwww\r\n").toString());
    assertEquals("<br/>www(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)",
        ParserUtils.escapeAndAddLineBreaks("\r\nwww(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)").toString());
    assertEquals("<br/>www&lt;br/&gt;", ParserUtils.escapeAndAddLineBreaks("\r\nwww<br/>").toString());
    assertEquals("<br/>wwwString", ParserUtils.escapeAndAddLineBreaks("\r\nwwwString").toString());
    assertEquals("<br/>www42", ParserUtils.escapeAndAddLineBreaks("\r\nwww42").toString());
    assertEquals("<br/>www-", ParserUtils.escapeAndAddLineBreaks("\r\nwww-").toString());
    assertEquals("<br/>www/&gt;", ParserUtils.escapeAndAddLineBreaks("\r\nwww/>").toString());
    assertEquals("<br/>www&lt;presentationML&gt;(.*?)&lt;/presentationML&gt;",
        ParserUtils.escapeAndAddLineBreaks("\r\nwww<presentationML>(.*?)</presentationML>").toString());
    assertEquals("<br/>wwwwww", ParserUtils.escapeAndAddLineBreaks("\r\nwwwwww").toString());
    assertEquals("(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)<br/><br/>",
        ParserUtils.escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)\r\n\r\n").toString());
    assertEquals("(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)<br/>(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)",
        ParserUtils.escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)\r\n(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)")
            .toString());
    assertEquals("(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)<br/>&lt;br/&gt;",
        ParserUtils.escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)\r\n<br/>").toString());
    assertEquals("(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)<br/>String",
        ParserUtils.escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)\r\nString").toString());
    assertEquals("(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)<br/>42",
        ParserUtils.escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)\r\n42").toString());
    assertEquals("(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)<br/>-",
        ParserUtils.escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)\r\n-").toString());
    assertEquals("(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)<br/>/&gt;",
        ParserUtils.escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)\r\n/>").toString());
    assertEquals("(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)<br/>&lt;presentationML&gt;(.*?)&lt;/presentationML&gt;",
        ParserUtils
            .escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)\r\n<presentationML>(.*?)</presentationML>")
            .toString());
    assertEquals("(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)<br/>www",
        ParserUtils.escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)\r\nwww").toString());
    assertEquals("(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)<br/>",
        ParserUtils.escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)\r\n")
            .toString());
    assertEquals(
        "(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)(<br/>)|(<br/>)|(\\\\r\\<br/>"
            + ")|(\\<br/>)",
        ParserUtils.escapeAndAddLineBreaks(
            "(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)")
            .toString());
    assertEquals("(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)&lt;br/&gt;",
        ParserUtils
            .escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)<br/>")
            .toString());
    assertEquals("(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)String",
        ParserUtils
            .escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)String")
            .toString());
    assertEquals("(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)42",
        ParserUtils.escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)42")
            .toString());
    assertEquals("(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)-",
        ParserUtils.escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)-")
            .toString());
    assertEquals("(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)/&gt;",
        ParserUtils.escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)/>")
            .toString());
    assertEquals(
        "(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)&lt;presentationML&gt;(.*?)"
            + "&lt;/presentationML&gt;",
        ParserUtils.escapeAndAddLineBreaks(
            "(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)<presentationML>(.*?)</presentationML>")
            .toString());
    assertEquals("(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)www",
        ParserUtils.escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)www")
            .toString());
    assertEquals("(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)&lt;br/&gt;<br/>",
        ParserUtils.escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)<br/>\r\n").toString());
    assertEquals("(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)&lt;br/&gt;(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)",
        ParserUtils
            .escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)<br/>(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)")
            .toString());
    assertEquals("(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)&lt;br/&gt;&lt;br/&gt;",
        ParserUtils.escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)<br/><br/>").toString());
    assertEquals("(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)&lt;br/&gt;String",
        ParserUtils.escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)<br/>String").toString());
    assertEquals("(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)&lt;br/&gt;42",
        ParserUtils.escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)<br/>42").toString());
    assertEquals("(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)&lt;br/&gt;-",
        ParserUtils.escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)<br/>-").toString());
    assertEquals("(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)&lt;br/&gt;/&gt;",
        ParserUtils.escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)<br/>/>").toString());
    assertEquals(
        "(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)&lt;br/&gt;&lt;presentationML&gt;(.*?)&lt;/presentationML&gt;",
        ParserUtils
            .escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)<br/><presentationML>(.*?)</presentationML>")
            .toString());
    assertEquals("(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)&lt;br/&gt;www",
        ParserUtils.escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)<br/>www").toString());
    assertEquals("(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)String<br/>",
        ParserUtils.escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)String\r\n").toString());
    assertEquals("(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)String(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)",
        ParserUtils
            .escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)String(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)")
            .toString());
    assertEquals("(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)String&lt;br/&gt;",
        ParserUtils.escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)String<br/>").toString());
    assertEquals("(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)StringString",
        ParserUtils.escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)StringString").toString());
    assertEquals("(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)String42",
        ParserUtils.escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)String42").toString());
    assertEquals("(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)String-",
        ParserUtils.escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)String-").toString());
    assertEquals("(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)String/&gt;",
        ParserUtils.escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)String/>").toString());
    assertEquals("(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)String&lt;presentationML&gt;(.*?)&lt;/presentationML&gt;",
        ParserUtils
            .escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)String<presentationML>(.*?)</presentationML>")
            .toString());
    assertEquals("(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)Stringwww",
        ParserUtils.escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)Stringwww").toString());
    assertEquals("(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)42<br/>",
        ParserUtils.escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)42\r\n").toString());
    assertEquals("(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)42(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)",
        ParserUtils.escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)42(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)")
            .toString());
    assertEquals("(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)42&lt;br/&gt;",
        ParserUtils.escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)42<br/>").toString());
    assertEquals("(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)42String",
        ParserUtils.escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)42String").toString());
    assertEquals("(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)4242",
        ParserUtils.escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)4242").toString());
    assertEquals("(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)42-",
        ParserUtils.escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)42-").toString());
    assertEquals("(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)42/&gt;",
        ParserUtils.escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)42/>").toString());
    assertEquals("(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)42&lt;presentationML&gt;(.*?)&lt;/presentationML&gt;",
        ParserUtils
            .escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)42<presentationML>(.*?)</presentationML>")
            .toString());
    assertEquals("(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)42www",
        ParserUtils.escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)42www").toString());
    assertEquals("(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)-<br/>",
        ParserUtils.escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)-\r\n").toString());
    assertEquals("(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)-(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)",
        ParserUtils.escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)-(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)")
            .toString());
    assertEquals("(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)-&lt;br/&gt;",
        ParserUtils.escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)-<br/>").toString());
    assertEquals("(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)-String",
        ParserUtils.escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)-String").toString());
    assertEquals("(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)-42",
        ParserUtils.escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)-42").toString());
    assertEquals("(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)--",
        ParserUtils.escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)--").toString());
    assertEquals("(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)-/&gt;",
        ParserUtils.escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)-/>").toString());
    assertEquals("(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)-&lt;presentationML&gt;(.*?)&lt;/presentationML&gt;",
        ParserUtils.escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)-<presentationML>(.*?)</presentationML>")
            .toString());
    assertEquals("(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)-www",
        ParserUtils.escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)-www").toString());
    assertEquals("(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)/&gt;<br/>",
        ParserUtils.escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)/>\r\n").toString());
    assertEquals("(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)/&gt;(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)",
        ParserUtils.escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)/>(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)")
            .toString());
    assertEquals("(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)/&gt;&lt;br/&gt;",
        ParserUtils.escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)/><br/>").toString());
    assertEquals("(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)/&gt;String",
        ParserUtils.escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)/>String").toString());
    assertEquals("(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)/&gt;42",
        ParserUtils.escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)/>42").toString());
    assertEquals("(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)/&gt;-",
        ParserUtils.escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)/>-").toString());
    assertEquals("(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)/&gt;/&gt;",
        ParserUtils.escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)/>/>").toString());
    assertEquals("(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)/&gt;&lt;presentationML&gt;(.*?)&lt;/presentationML&gt;",
        ParserUtils
            .escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)/><presentationML>(.*?)</presentationML>")
            .toString());
    assertEquals("(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)/&gt;www",
        ParserUtils.escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)/>www").toString());
    assertEquals("(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)&lt;presentationML&gt;(.*?)&lt;/presentationML&gt;<br/>",
        ParserUtils
            .escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)<presentationML>(.*?)</presentationML>\r\n")
            .toString());
    assertEquals(
        "(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)&lt;presentationML&gt;(.*?)&lt;/presentationML&gt;(<br/>)|(<br/>"
            + ")|(\\\\r\\<br/>)|(\\<br/>)",
        ParserUtils.escapeAndAddLineBreaks(
            "(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)<presentationML>(.*?)</presentationML>(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)")
            .toString());
    assertEquals(
        "(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)&lt;presentationML&gt;(.*?)&lt;/presentationML&gt;&lt;br/&gt;",
        ParserUtils
            .escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)<presentationML>(.*?)</presentationML><br/>")
            .toString());
    assertEquals("(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)&lt;presentationML&gt;(.*?)&lt;/presentationML&gt;String",
        ParserUtils
            .escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)<presentationML>(.*?)</presentationML>String")
            .toString());
    assertEquals("(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)&lt;presentationML&gt;(.*?)&lt;/presentationML&gt;42",
        ParserUtils
            .escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)<presentationML>(.*?)</presentationML>42")
            .toString());
    assertEquals("(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)&lt;presentationML&gt;(.*?)&lt;/presentationML&gt;-",
        ParserUtils.escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)<presentationML>(.*?)</presentationML>-")
            .toString());
    assertEquals("(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)&lt;presentationML&gt;(.*?)&lt;/presentationML&gt;/&gt;",
        ParserUtils
            .escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)<presentationML>(.*?)</presentationML>/>")
            .toString());
    assertEquals(
        "(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)&lt;presentationML&gt;(.*?)&lt;/presentationML&gt;&lt;presentationML"
            + "&gt;(.*?)&lt;/presentationML&gt;",
        ParserUtils
            .escapeAndAddLineBreaks(
                "(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)<presentationML>(.*?)</presentationML><presentationML>(.*?)<"
                    + "/presentationML>")
            .toString());
    assertEquals("(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)&lt;presentationML&gt;(.*?)&lt;/presentationML&gt;www",
        ParserUtils
            .escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)<presentationML>(.*?)</presentationML>www")
            .toString());
    assertEquals("(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)www<br/>",
        ParserUtils.escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)www\r\n").toString());
    assertEquals("(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)www(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)",
        ParserUtils.escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)www(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)")
            .toString());
    assertEquals("(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)www&lt;br/&gt;",
        ParserUtils.escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)www<br/>").toString());
    assertEquals("(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)wwwString",
        ParserUtils.escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)wwwString").toString());
    assertEquals("(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)www42",
        ParserUtils.escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)www42").toString());
    assertEquals("(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)www-",
        ParserUtils.escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)www-").toString());
    assertEquals("(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)www/&gt;",
        ParserUtils.escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)www/>").toString());
    assertEquals("(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)www&lt;presentationML&gt;(.*?)&lt;/presentationML&gt;",
        ParserUtils
            .escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)www<presentationML>(.*?)</presentationML>")
            .toString());
    assertEquals("(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)wwwwww",
        ParserUtils.escapeAndAddLineBreaks("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)wwwwww").toString());
    assertEquals("&lt;br/&gt;<br/><br/>", ParserUtils.escapeAndAddLineBreaks("<br/>\r\n\r\n").toString());
    assertEquals("&lt;br/&gt;<br/>(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)",
        ParserUtils.escapeAndAddLineBreaks("<br/>\r\n(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)").toString());
    assertEquals("&lt;br/&gt;<br/>&lt;br/&gt;", ParserUtils.escapeAndAddLineBreaks("<br/>\r\n<br/>").toString());
    assertEquals("&lt;br/&gt;<br/>String", ParserUtils.escapeAndAddLineBreaks("<br/>\r\nString").toString());
    assertEquals("&lt;br/&gt;<br/>42", ParserUtils.escapeAndAddLineBreaks("<br/>\r\n42").toString());
    assertEquals("&lt;br/&gt;<br/>-", ParserUtils.escapeAndAddLineBreaks("<br/>\r\n-").toString());
    assertEquals("&lt;br/&gt;<br/>/&gt;", ParserUtils.escapeAndAddLineBreaks("<br/>\r\n/>").toString());
    assertEquals("&lt;br/&gt;<br/>&lt;presentationML&gt;(.*?)&lt;/presentationML&gt;",
        ParserUtils.escapeAndAddLineBreaks("<br/>\r\n<presentationML>(.*?)</presentationML>").toString());
    assertEquals("&lt;br/&gt;<br/>www", ParserUtils.escapeAndAddLineBreaks("<br/>\r\nwww").toString());
    assertEquals("&lt;br/&gt;(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)<br/>",
        ParserUtils.escapeAndAddLineBreaks("<br/>(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)\r\n").toString());
    assertEquals("&lt;br/&gt;(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)",
        ParserUtils
            .escapeAndAddLineBreaks("<br/>(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)")
            .toString());
    assertEquals("&lt;br/&gt;(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)&lt;br/&gt;",
        ParserUtils.escapeAndAddLineBreaks("<br/>(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)<br/>").toString());
    assertEquals("&lt;br/&gt;(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)String",
        ParserUtils.escapeAndAddLineBreaks("<br/>(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)String").toString());
    assertEquals("&lt;br/&gt;(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)42",
        ParserUtils.escapeAndAddLineBreaks("<br/>(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)42").toString());
    assertEquals("&lt;br/&gt;(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)-",
        ParserUtils.escapeAndAddLineBreaks("<br/>(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)-").toString());
    assertEquals("&lt;br/&gt;(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)/&gt;",
        ParserUtils.escapeAndAddLineBreaks("<br/>(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)/>").toString());
    assertEquals(
        "&lt;br/&gt;(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)&lt;presentationML&gt;(.*?)&lt;/presentationML&gt;",
        ParserUtils
            .escapeAndAddLineBreaks("<br/>(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)<presentationML>(.*?)</presentationML>")
            .toString());
    assertEquals("&lt;br/&gt;(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)www",
        ParserUtils.escapeAndAddLineBreaks("<br/>(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)www").toString());
    assertEquals("&lt;br/&gt;&lt;br/&gt;<br/>", ParserUtils.escapeAndAddLineBreaks("<br/><br/>\r\n").toString());
    assertEquals("&lt;br/&gt;&lt;br/&gt;(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)",
        ParserUtils.escapeAndAddLineBreaks("<br/><br/>(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)").toString());
    assertEquals("&lt;br/&gt;String<br/>", ParserUtils.escapeAndAddLineBreaks("<br/>String\r\n").toString());
    assertEquals("&lt;br/&gt;String(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)",
        ParserUtils.escapeAndAddLineBreaks("<br/>String(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)").toString());
    assertEquals("&lt;br/&gt;42<br/>", ParserUtils.escapeAndAddLineBreaks("<br/>42\r\n").toString());
    assertEquals("&lt;br/&gt;42(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)",
        ParserUtils.escapeAndAddLineBreaks("<br/>42(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)").toString());
    assertEquals("&lt;br/&gt;-<br/>", ParserUtils.escapeAndAddLineBreaks("<br/>-\r\n").toString());
    assertEquals("&lt;br/&gt;-(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)",
        ParserUtils.escapeAndAddLineBreaks("<br/>-(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)").toString());
    assertEquals("&lt;br/&gt;/&gt;<br/>", ParserUtils.escapeAndAddLineBreaks("<br/>/>\r\n").toString());
    assertEquals("&lt;br/&gt;/&gt;(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)",
        ParserUtils.escapeAndAddLineBreaks("<br/>/>(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)").toString());
  }

  /**
   * Method under test: {@link ParserUtils#getPresentationMLContent(String)}
   */
  @Test
  public void testGetPresentationMLContent() {
    // Arrange, Act and Assert
    assertEquals("", ParserUtils.getPresentationMLContent("Not all who wander are lost"));
    assertEquals("xx", ParserUtils.getPresentationMLContent("<presentationML>xx</presentationML>"));
  }

  /**
   * Method under test: {@link ParserUtils#unescapePresentationML(String)}
   */
  @Test
  public void testUnescapePresentationML() {
    // Arrange, Act and Assert
    assertEquals("Not all who wander are lost", ParserUtils.unescapePresentationML("Not all who wander are lost"));
    assertEquals("<presentationML>xx</presentationML>",
        ParserUtils.unescapePresentationML("<presentationML>xx</presentationML>"));
  }

  /**
   * Method under test: {@link ParserUtils#newUri(String)}
   */
  @Test
  public void testNewUri() {
    // Arrange, Act and Assert
    thrown.expect(URISyntaxRuntimeException.class);
    ParserUtils.newUri("Base Uri");
  }

  /**
   * Method under test: {@link ParserUtils#buildEncodedUrl(String)}
   */
  @Test
  public void testBuildEncodedUrl() throws MalformedURLException {
    // Arrange, Act and Assert
    assertEquals("https://example.org/example", ParserUtils.buildEncodedUrl("https://example.org/example"));
  }
}
