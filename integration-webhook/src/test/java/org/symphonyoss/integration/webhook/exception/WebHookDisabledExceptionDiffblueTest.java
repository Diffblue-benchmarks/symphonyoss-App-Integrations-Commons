package org.symphonyoss.integration.webhook.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class WebHookDisabledExceptionDiffblueTest {
  /**
   * Method under test:
   * {@link WebHookDisabledException#WebHookDisabledException(String)}
   */
  @Test
  public void testNewWebHookDisabledException() {
    // Arrange and Act
    WebHookDisabledException actualWebHookDisabledException = new WebHookDisabledException("Configuration Type");

    // Assert
    assertEquals(
        "\n" + "Component: Webhook Dispatcher\n" + "Message: Webhook Configuration Type disabled!\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualWebHookDisabledException.getLocalizedMessage());
    assertEquals(
        "\n" + "Component: Webhook Dispatcher\n" + "Message: Webhook Configuration Type disabled!\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualWebHookDisabledException.getMessage());
    assertNull(actualWebHookDisabledException.getCause());
    assertEquals(0, actualWebHookDisabledException.getSuppressed().length);
  }
}
