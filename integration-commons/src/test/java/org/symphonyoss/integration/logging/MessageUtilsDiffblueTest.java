package org.symphonyoss.integration.logging;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class MessageUtilsDiffblueTest {
  /**
   * Method under test: {@link MessageUtils#getMessage(String, String[])}
   */
  @Test
  public void testGetMessage() {
    // Arrange, Act and Assert
    assertEquals("Message not found for resource 42.", (new MessageUtils("foo.txt")).getMessage("42", "Args"));
  }

  /**
   * Method under test: {@link MessageUtils#MessageUtils(String)}
   */
  @Test
  public void testNewMessageUtils() {
    // Arrange, Act and Assert
    assertEquals("Message not found for resource 42.", (new MessageUtils("foo.txt")).getMessage("42", null));
  }
}
