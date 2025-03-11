package org.symphonyoss.integration.parser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;

public class SafeStringDiffblueTest {
  /**
   * Test {@link SafeString#SafeString(String)}.
   * <ul>
   *   <li>When {@link ParserUtils#MESSAGEML_LINEBREAK}.</li>
   *   <li>Then return toString is {@code &lt;br/&gt;}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SafeString#SafeString(String)}
   */
  @Test
  @MethodsUnderTest({"void SafeString.<init>(String)"})
  public void testNewSafeString_whenMessageml_linebreak_thenReturnToStringIsLtBrGt() {
    // Arrange, Act and Assert
    assertEquals("&lt;br/&gt;", (new SafeString(ParserUtils.MESSAGEML_LINEBREAK)).toString());
  }

  /**
   * Test {@link SafeString#SafeString(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return toString is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SafeString#SafeString(String)}
   */
  @Test
  @MethodsUnderTest({"void SafeString.<init>(String)"})
  public void testNewSafeString_whenNull_thenReturnToStringIsNull() {
    // Arrange, Act and Assert
    assertNull((new SafeString(null)).toString());
  }

  /**
   * Test {@link SafeString#SafeString(String)}.
   * <ul>
   *   <li>When {@code String}.</li>
   *   <li>Then return toString is {@code String}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SafeString#SafeString(String)}
   */
  @Test
  @MethodsUnderTest({"void SafeString.<init>(String)"})
  public void testNewSafeString_whenString_thenReturnToStringIsString() {
    // Arrange, Act and Assert
    assertEquals("String", (new SafeString("String")).toString());
  }

  /**
   * Test {@link SafeString#replaceLineBreaks()}.
   * <ul>
   *   <li>Given newSafeString {@code 42}.</li>
   *   <li>Then newSafeString {@code 42} toString is {@code <br/>
   * 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SafeString#replaceLineBreaks()}
   */
  @Test
  @MethodsUnderTest({"void SafeString.replaceLineBreaks()"})
  public void testReplaceLineBreaks_givenNewSafeString42_thenNewSafeString42ToStringIsBr42() {
    // Arrange
    SafeString newSafeStringResult = SafeString.newSafeString("\r\n42");

    // Act
    newSafeStringResult.replaceLineBreaks();

    // Assert
    assertEquals("<br/>42", newSafeStringResult.toString());
  }

  /**
   * Test {@link SafeString#replaceLineBreaks()}.
   * <ul>
   *   <li>Given newSafeString {@code <br/>
   * }.</li>
   *   <li>Then newSafeString {@code <br/>
   * } toString is {@code <br/>
   * <br/>
   * }.</li>
   * </ul>
   * <p>
   * Method under test: {@link SafeString#replaceLineBreaks()}
   */
  @Test
  @MethodsUnderTest({"void SafeString.replaceLineBreaks()"})
  public void testReplaceLineBreaks_givenNewSafeStringBr_thenNewSafeStringBrToStringIsBrBr() {
    // Arrange
    SafeString newSafeStringResult = SafeString.newSafeString("\r\n<br/>");

    // Act
    newSafeStringResult.replaceLineBreaks();

    // Assert
    assertEquals("<br/><br/>", newSafeStringResult.toString());
  }

  /**
   * Test {@link SafeString#replaceLineBreaks()}.
   * <ul>
   *   <li>Given newSafeString cr lf.</li>
   * </ul>
   * <p>
   * Method under test: {@link SafeString#replaceLineBreaks()}
   */
  @Test
  @MethodsUnderTest({"void SafeString.replaceLineBreaks()"})
  public void testReplaceLineBreaks_givenNewSafeStringCrLf() {
    // Arrange
    SafeString newSafeStringResult = SafeString.newSafeString("\r\n");

    // Act
    newSafeStringResult.replaceLineBreaks();

    // Assert
    assertEquals(ParserUtils.MESSAGEML_LINEBREAK, newSafeStringResult.toString());
  }

  /**
   * Test {@link SafeString#replaceLineBreaks()}.
   * <ul>
   *   <li>Then newSafeString cr lf cr lf toString is {@code <br/>
   * <br/>
   * }.</li>
   * </ul>
   * <p>
   * Method under test: {@link SafeString#replaceLineBreaks()}
   */
  @Test
  @MethodsUnderTest({"void SafeString.replaceLineBreaks()"})
  public void testReplaceLineBreaks_thenNewSafeStringCrLfCrLfToStringIsBrBr() {
    // Arrange
    SafeString newSafeStringResult = SafeString.newSafeString("\r\n\r\n");

    // Act
    newSafeStringResult.replaceLineBreaks();

    // Assert
    assertEquals("<br/><br/>", newSafeStringResult.toString());
  }

  /**
   * Test {@link SafeString#replaceLineBreaks()}.
   * <ul>
   *   <li>Then newSafeString {@link ParserUtils#CR_LF_OR_LF} toString is {@code (<br/>
   * )|(<br/>
   * )|(\\r\<br/>
   * )|(\<br/>
   * )}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SafeString#replaceLineBreaks()}
   */
  @Test
  @MethodsUnderTest({"void SafeString.replaceLineBreaks()"})
  public void testReplaceLineBreaks_thenNewSafeStringCr_lf_or_lfToStringIsBrBrRBrBr() {
    // Arrange
    SafeString newSafeStringResult = SafeString.newSafeString(ParserUtils.CR_LF_OR_LF);

    // Act
    newSafeStringResult.replaceLineBreaks();

    // Assert
    assertEquals("(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)", newSafeStringResult.toString());
  }

  /**
   * Test {@link SafeString#replaceLineBreaks()}.
   * <ul>
   *   <li>Then newSafeString {@code (\r\n)|(\n)|(\\r\\n)|(\\n)(\r\n)|(\n)|(\\r\\n)|(\\n)} toString is {@code (<br/>
   * )|(<br/>
   * )|(\\r\<br/>
   * )|(\<br/>
   * )(<br/>
   * )|(<br/>
   * )|(\\r\<br/>
   * )|(\<br/>
   * )}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SafeString#replaceLineBreaks()}
   */
  @Test
  @MethodsUnderTest({"void SafeString.replaceLineBreaks()"})
  public void testReplaceLineBreaks_thenNewSafeStringRNNRNNRNNRNNToStringIsBrBrRBrBrBrBrRBrBr() {
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
   * Test {@link SafeString#replaceLineBreaks()}.
   * <ul>
   *   <li>Then newSafeString {@code (\r\n)|(\n)|(\\r\\n)|(\\n)} toString is {@code <br/>
   * (<br/>
   * )|(<br/>
   * )|(\\r\<br/>
   * )|(\<br/>
   * )}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SafeString#replaceLineBreaks()}
   */
  @Test
  @MethodsUnderTest({"void SafeString.replaceLineBreaks()"})
  public void testReplaceLineBreaks_thenNewSafeStringRNNRNNToStringIsBrBrBrRBrBr() {
    // Arrange
    SafeString newSafeStringResult = SafeString.newSafeString("\r\n(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)");

    // Act
    newSafeStringResult.replaceLineBreaks();

    // Assert
    assertEquals("<br/>(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)", newSafeStringResult.toString());
  }

  /**
   * Test {@link SafeString#replaceLineBreaks()}.
   * <ul>
   *   <li>Then newSafeString {@code (\r\n)|(\n)|(\\r\\n)|(\\n)} toString is {@code (<br/>
   * )|(<br/>
   * )|(\\r\<br/>
   * )|(\<br/>
   * )<br/>
   * }.</li>
   * </ul>
   * <p>
   * Method under test: {@link SafeString#replaceLineBreaks()}
   */
  @Test
  @MethodsUnderTest({"void SafeString.replaceLineBreaks()"})
  public void testReplaceLineBreaks_thenNewSafeStringRNNRNNToStringIsBrBrRBrBrBr() {
    // Arrange
    SafeString newSafeStringResult = SafeString.newSafeString("(\\r\\n)|(\\n)|(\\\\r\\\\n)|(\\\\n)\r\n");

    // Act
    newSafeStringResult.replaceLineBreaks();

    // Assert
    assertEquals("(<br/>)|(<br/>)|(\\\\r\\<br/>)|(\\<br/>)<br/>", newSafeStringResult.toString());
  }

  /**
   * Test {@link SafeString#replaceLineBreaks()}.
   * <ul>
   *   <li>Then newSafeString {@code String} toString is {@code <br/>
   * String}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SafeString#replaceLineBreaks()}
   */
  @Test
  @MethodsUnderTest({"void SafeString.replaceLineBreaks()"})
  public void testReplaceLineBreaks_thenNewSafeStringStringToStringIsBrString() {
    // Arrange
    SafeString newSafeStringResult = SafeString.newSafeString("\r\nString");

    // Act
    newSafeStringResult.replaceLineBreaks();

    // Assert
    assertEquals("<br/>String", newSafeStringResult.toString());
  }

  /**
   * Test {@link SafeString#toString()}.
   * <p>
   * Method under test: {@link SafeString#toString()}
   */
  @Test
  @MethodsUnderTest({"String SafeString.toString()"})
  public void testToString() {
    // Arrange, Act and Assert
    assertEquals("String", SafeString.newSafeString("String").toString());
  }

  /**
   * Test {@link SafeString#newSafeString(String)}.
   * <p>
   * Method under test: {@link SafeString#newSafeString(String)}
   */
  @Test
  @MethodsUnderTest({"SafeString SafeString.newSafeString(String)"})
  public void testNewSafeString() {
    // Arrange, Act and Assert
    assertEquals("String", SafeString.newSafeString("String").toString());
  }
}
