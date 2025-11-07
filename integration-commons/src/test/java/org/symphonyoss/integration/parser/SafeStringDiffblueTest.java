package org.symphonyoss.integration.parser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class SafeStringDiffblueTest {
  /**
   * Method under test: {@link SafeString#replaceLineBreaks()}
   */
  @Test
  public void testReplaceLineBreaks() {
    // Arrange
    SafeString newSafeStringResult = SafeString.newSafeString("\r\n");

    // Act
    newSafeStringResult.replaceLineBreaks();

    // Assert
    assertEquals(ParserUtils.MESSAGEML_LINEBREAK, newSafeStringResult.toString());
  }

  /**
   * Method under test: {@link SafeString#replaceLineBreaks()}
   */
  @Test
  public void testReplaceLineBreaks2() {
    // Arrange
    SafeString newSafeStringResult = SafeString.newSafeString(ParserUtils.CR_LF_OR_LF);

    // Act
    newSafeStringResult.replaceLineBreaks();

    // Assert
    assertEquals("(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)", newSafeStringResult.toString());
  }

  /**
   * Method under test: {@link SafeString#replaceLineBreaks()}
   */
  @Test
  public void testReplaceLineBreaks3() {
    // Arrange
    SafeString newSafeStringResult = SafeString.newSafeString("\r\n\r\n");

    // Act
    newSafeStringResult.replaceLineBreaks();

    // Assert
    assertEquals("<br/><br/>", newSafeStringResult.toString());
  }

  /**
   * Method under test: {@link SafeString#replaceLineBreaks()}
   */
  @Test
  public void testReplaceLineBreaks4() {
    // Arrange
    SafeString newSafeStringResult = SafeString.newSafeString("\r\n(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)");

    // Act
    newSafeStringResult.replaceLineBreaks();

    // Assert
    assertEquals("<br/>(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)", newSafeStringResult.toString());
  }

  /**
   * Method under test: {@link SafeString#replaceLineBreaks()}
   */
  @Test
  public void testReplaceLineBreaks5() {
    // Arrange
    SafeString newSafeStringResult = SafeString.newSafeString("\r\n<br/>");

    // Act
    newSafeStringResult.replaceLineBreaks();

    // Assert
    assertEquals("<br/><br/>", newSafeStringResult.toString());
  }

  /**
   * Method under test: {@link SafeString#replaceLineBreaks()}
   */
  @Test
  public void testReplaceLineBreaks6() {
    // Arrange
    SafeString newSafeStringResult = SafeString.newSafeString("\r\nString");

    // Act
    newSafeStringResult.replaceLineBreaks();

    // Assert
    assertEquals("<br/>String", newSafeStringResult.toString());
  }

  /**
   * Method under test: {@link SafeString#replaceLineBreaks()}
   */
  @Test
  public void testReplaceLineBreaks7() {
    // Arrange
    SafeString newSafeStringResult = SafeString.newSafeString("\r\n42");

    // Act
    newSafeStringResult.replaceLineBreaks();

    // Assert
    assertEquals("<br/>42", newSafeStringResult.toString());
  }

  /**
   * Method under test: {@link SafeString#replaceLineBreaks()}
   */
  @Test
  public void testReplaceLineBreaks8() {
    // Arrange
    SafeString newSafeStringResult = SafeString.newSafeString("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)\r\n");

    // Act
    newSafeStringResult.replaceLineBreaks();

    // Assert
    assertEquals("(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)<br/>", newSafeStringResult.toString());
  }

  /**
   * Method under test: {@link SafeString#replaceLineBreaks()}
   */
  @Test
  public void testReplaceLineBreaks9() {
    // Arrange
    SafeString newSafeStringResult = SafeString
        .newSafeString("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)");

    // Act
    newSafeStringResult.replaceLineBreaks();

    // Assert
    assertEquals("(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)",
        newSafeStringResult.toString());
  }

  /**
   * Method under test: {@link SafeString#SafeString(String)}
   */
  @Test
  public void testNewSafeString() {
    // Arrange, Act and Assert
    assertEquals("String", (new SafeString("String")).toString());
    assertNull((new SafeString(null)).toString());
    assertEquals("&lt;br/&gt;", (new SafeString(ParserUtils.MESSAGEML_LINEBREAK)).toString());
    assertEquals("String", SafeString.newSafeString("String").toString());
  }

  /**
   * Method under test: {@link SafeString#toString()}
   */
  @Test
  public void testToString() {
    // Arrange, Act and Assert
    assertEquals("String", SafeString.newSafeString("String").toString());
  }
}
