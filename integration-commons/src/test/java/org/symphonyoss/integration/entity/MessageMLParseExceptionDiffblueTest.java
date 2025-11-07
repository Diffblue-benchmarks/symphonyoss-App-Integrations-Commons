package org.symphonyoss.integration.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class MessageMLParseExceptionDiffblueTest {
  /**
   * Method under test:
   * {@link MessageMLParseException#MessageMLParseException(String)}
   */
  @Test
  public void testNewMessageMLParseException() {
    // Arrange and Act
    MessageMLParseException actualMessageMLParseException = new MessageMLParseException("An error occurred");

    // Assert
    assertEquals(
        "\n" + "Component: MessageML Parser\n" + "Message: An error occurred\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualMessageMLParseException.getLocalizedMessage());
    assertEquals(
        "\n" + "Component: MessageML Parser\n" + "Message: An error occurred\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualMessageMLParseException.getMessage());
    assertNull(actualMessageMLParseException.getCause());
    assertEquals(0, actualMessageMLParseException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link MessageMLParseException#MessageMLParseException(String)}
   */
  @Test
  public void testNewMessageMLParseException2() {
    // Arrange and Act
    MessageMLParseException actualMessageMLParseException = new MessageMLParseException(null);

    // Assert
    assertEquals(
        "\n" + "Component: MessageML Parser\n" + "Message: None\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualMessageMLParseException.getLocalizedMessage());
    assertEquals(
        "\n" + "Component: MessageML Parser\n" + "Message: None\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualMessageMLParseException.getMessage());
    assertNull(actualMessageMLParseException.getCause());
    assertEquals(0, actualMessageMLParseException.getSuppressed().length);
  }
}
