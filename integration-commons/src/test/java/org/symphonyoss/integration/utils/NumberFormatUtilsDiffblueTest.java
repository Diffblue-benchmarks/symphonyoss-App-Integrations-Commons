package org.symphonyoss.integration.utils;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Locale;
import org.junit.Test;

public class NumberFormatUtilsDiffblueTest {
  /**
   * Test {@link NumberFormatUtils#formatValueWithLocale(Locale, String)}.
   * <ul>
   *   <li>When Default.</li>
   *   <li>Then return {@code 42.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NumberFormatUtils#formatValueWithLocale(Locale, String)}
   */
  @Test
  @MethodsUnderTest({"String NumberFormatUtils.formatValueWithLocale(Locale, String)"})
  public void testFormatValueWithLocale_whenDefault_thenReturn4200() {
    // Arrange, Act and Assert
    assertEquals("42.00", NumberFormatUtils.formatValueWithLocale(Locale.getDefault(), "42"));
  }
}
