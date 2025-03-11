package org.symphonyoss.integration.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;

public class MessageMLParseExceptionDiffblueTest {
  /**
   * Test {@link MessageMLParseException#MessageMLParseException(String)}.
   * <ul>
   *   <li>When {@code An error occurred}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MessageMLParseException#MessageMLParseException(String)}
   */
  @Test
  @MethodsUnderTest({"void MessageMLParseException.<init>(String)"})
  public void testNewMessageMLParseException_whenAnErrorOccurred() {
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
   * Test {@link MessageMLParseException#MessageMLParseException(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MessageMLParseException#MessageMLParseException(String)}
   */
  @Test
  @MethodsUnderTest({"void MessageMLParseException.<init>(String)"})
  public void testNewMessageMLParseException_whenNull() {
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
