package org.symphonyoss.integration.webhook.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;

public class WebHookUnprocessableEntityExceptionDiffblueTest {
  /**
   * Test {@link WebHookUnprocessableEntityException#WebHookUnprocessableEntityException(String,
   * String[])}.
   *
   * <p>Method under test: {@link
   * WebHookUnprocessableEntityException#WebHookUnprocessableEntityException(String, String[])}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"void WebHookUnprocessableEntityException.<init>(String, String[])"})
  public void testNewWebHookUnprocessableEntityException() {
    // Arrange and Act
    WebHookUnprocessableEntityException actualWebHookUnprocessableEntityException =
        new WebHookUnprocessableEntityException("An error occurred", "Solutions");

    // Assert
    assertEquals(
        "\nComponent: Webhook Dispatcher\nMessage: An error occurred\nSolutions: \nSolutions\n",
        actualWebHookUnprocessableEntityException.getLocalizedMessage());
    assertEquals(
        "\nComponent: Webhook Dispatcher\nMessage: An error occurred\nSolutions: \nSolutions\n",
        actualWebHookUnprocessableEntityException.getMessage());
    assertNull(actualWebHookUnprocessableEntityException.getCause());
    assertEquals(0, actualWebHookUnprocessableEntityException.getSuppressed().length);
  }
}
