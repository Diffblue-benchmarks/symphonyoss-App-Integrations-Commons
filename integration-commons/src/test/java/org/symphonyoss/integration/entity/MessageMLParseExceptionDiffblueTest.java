package org.symphonyoss.integration.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;

public class MessageMLParseExceptionDiffblueTest {
  /**
   * Test {@link MessageMLParseException#MessageMLParseException(String)}.
   *
   * <ul>
   *   <li>When {@code An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link MessageMLParseException#MessageMLParseException(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"void MessageMLParseException.<init>(String)"})
  public void testNewMessageMLParseException_whenAnErrorOccurred() {
    // Arrange and Act
    MessageMLParseException actualMessageMLParseException =
        new MessageMLParseException("An error occurred");

    // Assert
    assertEquals(
        "\n"
            + "Component: MessageML Parser\n"
            + "Message: An error occurred\n"
            + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualMessageMLParseException.getLocalizedMessage());
    assertEquals(
        "\n"
            + "Component: MessageML Parser\n"
            + "Message: An error occurred\n"
            + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualMessageMLParseException.getMessage());
    assertNull(actualMessageMLParseException.getCause());
    assertEquals(0, actualMessageMLParseException.getSuppressed().length);
  }

  /**
   * Test {@link MessageMLParseException#MessageMLParseException(String)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link MessageMLParseException#MessageMLParseException(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"void MessageMLParseException.<init>(String)"})
  public void testNewMessageMLParseException_whenEmptyString() {
    // Arrange and Act
    MessageMLParseException actualMessageMLParseException = new MessageMLParseException("");

    // Assert
    assertEquals(
        "\n"
            + "Component: MessageML Parser\n"
            + "Message: None\n"
            + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualMessageMLParseException.getLocalizedMessage());
    assertEquals(
        "\n"
            + "Component: MessageML Parser\n"
            + "Message: None\n"
            + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualMessageMLParseException.getMessage());
    assertNull(actualMessageMLParseException.getCause());
    assertEquals(0, actualMessageMLParseException.getSuppressed().length);
  }
}
