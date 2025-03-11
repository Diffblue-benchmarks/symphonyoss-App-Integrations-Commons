package org.symphonyoss.integration.webhook.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;

public class StreamTypeNotFoundExceptionDiffblueTest {
  /**
   * Test {@link StreamTypeNotFoundException#StreamTypeNotFoundException(String)}.
   * <p>
   * Method under test: {@link StreamTypeNotFoundException#StreamTypeNotFoundException(String)}
   */
  @Test
  @MethodsUnderTest({"void StreamTypeNotFoundException.<init>(String)"})
  public void testNewStreamTypeNotFoundException() {
    // Arrange and Act
    StreamTypeNotFoundException actualStreamTypeNotFoundException = new StreamTypeNotFoundException(
        "An error occurred");

    // Assert
    assertEquals(
        "\n" + "Component: Webhook Dispatcher\n" + "Message: An error occurred\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualStreamTypeNotFoundException.getLocalizedMessage());
    assertEquals(
        "\n" + "Component: Webhook Dispatcher\n" + "Message: An error occurred\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualStreamTypeNotFoundException.getMessage());
    assertNull(actualStreamTypeNotFoundException.getCause());
    assertEquals(0, actualStreamTypeNotFoundException.getSuppressed().length);
  }
}
