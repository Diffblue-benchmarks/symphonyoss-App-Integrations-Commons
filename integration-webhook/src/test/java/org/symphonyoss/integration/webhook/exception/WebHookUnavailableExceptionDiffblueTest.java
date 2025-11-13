package org.symphonyoss.integration.webhook.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;

public class WebHookUnavailableExceptionDiffblueTest {
  /**
   * Test {@link WebHookUnavailableException#WebHookUnavailableException(String, String)}.
   *
   * <p>Method under test: {@link WebHookUnavailableException#WebHookUnavailableException(String,
   * String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"void WebHookUnavailableException.<init>(String, String)"})
  public void testNewWebHookUnavailableException() {
    // Arrange and Act
    WebHookUnavailableException actualWebHookUnavailableException =
        new WebHookUnavailableException("Configuration Type", "An error occurred");

    // Assert
    assertEquals(
        "\n"
            + "Component: Webhook Dispatcher\n"
            + "Message: Configuration Configuration Type unavailable! An error occurred\n"
            + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualWebHookUnavailableException.getLocalizedMessage());
    assertEquals(
        "\n"
            + "Component: Webhook Dispatcher\n"
            + "Message: Configuration Configuration Type unavailable! An error occurred\n"
            + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualWebHookUnavailableException.getMessage());
    assertNull(actualWebHookUnavailableException.getCause());
    assertEquals(0, actualWebHookUnavailableException.getSuppressed().length);
  }
}
