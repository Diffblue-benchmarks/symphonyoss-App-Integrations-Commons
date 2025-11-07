package org.symphonyoss.integration.webhook.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class WebHookUnprocessableEntityExceptionDiffblueTest {
  /**
   * Method under test:
   * {@link WebHookUnprocessableEntityException#WebHookUnprocessableEntityException(String, String[])}
   */
  @Test
  public void testNewWebHookUnprocessableEntityException() {
    // Arrange and Act
    WebHookUnprocessableEntityException actualWebHookUnprocessableEntityException = new WebHookUnprocessableEntityException(
        "An error occurred", "Solutions");

    // Assert
    assertEquals("\nComponent: Webhook Dispatcher\nMessage: An error occurred\nSolutions: \nSolutions\n",
        actualWebHookUnprocessableEntityException.getLocalizedMessage());
    assertEquals("\nComponent: Webhook Dispatcher\nMessage: An error occurred\nSolutions: \nSolutions\n",
        actualWebHookUnprocessableEntityException.getMessage());
    assertNull(actualWebHookUnprocessableEntityException.getCause());
    assertEquals(0, actualWebHookUnprocessableEntityException.getSuppressed().length);
  }
}
