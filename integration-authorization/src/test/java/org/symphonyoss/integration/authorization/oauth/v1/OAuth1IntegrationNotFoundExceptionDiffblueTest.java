package org.symphonyoss.integration.authorization.oauth.v1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;

public class OAuth1IntegrationNotFoundExceptionDiffblueTest {
  /**
   * Test {@link OAuth1IntegrationNotFoundException#OAuth1IntegrationNotFoundException(String, String[])}.
   * <ul>
   *   <li>Then return Cause is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OAuth1IntegrationNotFoundException#OAuth1IntegrationNotFoundException(String, String[])}
   */
  @Test
  @MethodsUnderTest({"void OAuth1IntegrationNotFoundException.<init>(String, Throwable, String[])",
      "void OAuth1IntegrationNotFoundException.<init>(String, String[])"})
  public void testNewOAuth1IntegrationNotFoundException_thenReturnCauseIsNull() {
    // Arrange and Act
    OAuth1IntegrationNotFoundException actualOAuth1IntegrationNotFoundException = new OAuth1IntegrationNotFoundException(
        "An error occurred", "Solutions");

    // Assert
    assertEquals("\n" + "Component: Third-party integration/app authorization.\n" + "Message: An error occurred\n"
        + "Solutions: \n" + "Solutions\n", actualOAuth1IntegrationNotFoundException.getMessage());
    assertNull(actualOAuth1IntegrationNotFoundException.getCause());
    assertEquals(0, actualOAuth1IntegrationNotFoundException.getSuppressed().length);
  }

  /**
   * Test {@link OAuth1IntegrationNotFoundException#OAuth1IntegrationNotFoundException(String, Throwable, String[])}.
   * <ul>
   *   <li>Then return Cause is {@link Throwable#Throwable()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OAuth1IntegrationNotFoundException#OAuth1IntegrationNotFoundException(String, Throwable, String[])}
   */
  @Test
  @MethodsUnderTest({"void OAuth1IntegrationNotFoundException.<init>(String, Throwable, String[])",
      "void OAuth1IntegrationNotFoundException.<init>(String, String[])"})
  public void testNewOAuth1IntegrationNotFoundException_thenReturnCauseIsThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    OAuth1IntegrationNotFoundException actualOAuth1IntegrationNotFoundException = new OAuth1IntegrationNotFoundException(
        "An error occurred", cause, "Solutions");

    // Assert
    assertEquals(
        "\n" + "Component: Third-party integration/app authorization.\n" + "Message: An error occurred\n"
            + "Solutions: \n" + "Solutions\n" + "Stack trace: \n",
        actualOAuth1IntegrationNotFoundException.getMessage());
    assertEquals(0, actualOAuth1IntegrationNotFoundException.getSuppressed().length);
    assertSame(cause, actualOAuth1IntegrationNotFoundException.getCause());
  }
}
