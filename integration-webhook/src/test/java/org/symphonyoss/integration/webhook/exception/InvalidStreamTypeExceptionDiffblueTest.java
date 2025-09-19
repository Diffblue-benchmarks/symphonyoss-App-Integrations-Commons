package org.symphonyoss.integration.webhook.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;

public class InvalidStreamTypeExceptionDiffblueTest {
  /**
   * Test {@link InvalidStreamTypeException#InvalidStreamTypeException(String)}.
   *
   * <p>Method under test: {@link InvalidStreamTypeException#InvalidStreamTypeException(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"void InvalidStreamTypeException.<init>(String)"})
  public void testNewInvalidStreamTypeException() {
    // Arrange and Act
    InvalidStreamTypeException actualInvalidStreamTypeException =
        new InvalidStreamTypeException("An error occurred");

    // Assert
    assertEquals(
        "\n"
            + "Component: Webhook Dispatcher\n"
            + "Message: An error occurred\n"
            + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualInvalidStreamTypeException.getLocalizedMessage());
    assertEquals(
        "\n"
            + "Component: Webhook Dispatcher\n"
            + "Message: An error occurred\n"
            + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualInvalidStreamTypeException.getMessage());
    assertNull(actualInvalidStreamTypeException.getCause());
    assertEquals(0, actualInvalidStreamTypeException.getSuppressed().length);
  }
}
