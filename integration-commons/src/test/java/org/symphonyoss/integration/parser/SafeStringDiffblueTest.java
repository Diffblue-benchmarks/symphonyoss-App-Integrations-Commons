package org.symphonyoss.integration.parser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;

public class SafeStringDiffblueTest {
  /**
   * Test {@link SafeString#SafeString(String)}.
   *
   * <ul>
   *   <li>When {@link ParserUtils#MESSAGEML_LINEBREAK}.
   *   <li>Then return toString is {@code &lt;br/&gt;}.
   * </ul>
   *
   * <p>Method under test: {@link SafeString#SafeString(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"void SafeString.<init>(String)"})
  public void testNewSafeString_whenMessageml_linebreak_thenReturnToStringIsLtBrGt() {
    // Arrange, Act and Assert
    assertEquals("&lt;br/&gt;", new SafeString(ParserUtils.MESSAGEML_LINEBREAK).toString());
  }

  /**
   * Test {@link SafeString#SafeString(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return toString is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SafeString#SafeString(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"void SafeString.<init>(String)"})
  public void testNewSafeString_whenNull_thenReturnToStringIsNull() {
    // Arrange, Act and Assert
    assertNull(new SafeString(null).toString());
  }

  /**
   * Test {@link SafeString#SafeString(String)}.
   *
   * <ul>
   *   <li>When {@code String}.
   *   <li>Then return toString is {@code String}.
   * </ul>
   *
   * <p>Method under test: {@link SafeString#SafeString(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"void SafeString.<init>(String)"})
  public void testNewSafeString_whenString_thenReturnToStringIsString() {
    // Arrange, Act and Assert
    assertEquals("String", new SafeString("String").toString());
  }

  /**
   * Test {@link SafeString#toString()}.
   *
   * <p>Method under test: {@link SafeString#toString()}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String SafeString.toString()"})
  public void testToString() {
    // Arrange, Act and Assert
    assertEquals("String", SafeString.newSafeString("String").toString());
  }

  /**
   * Test {@link SafeString#newSafeString(String)}.
   *
   * <p>Method under test: {@link SafeString#newSafeString(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString SafeString.newSafeString(String)"})
  public void testNewSafeString() {
    // Arrange, Act and Assert
    assertEquals("String", SafeString.newSafeString("String").toString());
  }
}
