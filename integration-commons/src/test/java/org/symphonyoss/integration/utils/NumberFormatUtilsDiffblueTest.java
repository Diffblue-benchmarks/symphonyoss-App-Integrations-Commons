package org.symphonyoss.integration.utils;

import static org.junit.Assert.assertEquals;
import java.util.Locale;
import org.junit.Test;

public class NumberFormatUtilsDiffblueTest {
  /**
   * Method under test:
   * {@link NumberFormatUtils#formatValueWithLocale(Locale, String)}
   */
  @Test
  public void testFormatValueWithLocale() {
    // Arrange, Act and Assert
    assertEquals("42.00", NumberFormatUtils.formatValueWithLocale(Locale.getDefault(), "42"));
  }
}
