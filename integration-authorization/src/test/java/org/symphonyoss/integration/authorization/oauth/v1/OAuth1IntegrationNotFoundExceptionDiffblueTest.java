package org.symphonyoss.integration.authorization.oauth.v1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import org.junit.Test;

public class OAuth1IntegrationNotFoundExceptionDiffblueTest {
  /**
   * Method under test:
   * {@link OAuth1IntegrationNotFoundException#OAuth1IntegrationNotFoundException(String, Throwable, String[])}
   */
  @Test
  public void testNewOAuth1IntegrationNotFoundException() {
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

  /**
   * Method under test:
   * {@link OAuth1IntegrationNotFoundException#OAuth1IntegrationNotFoundException(String, String[])}
   */
  @Test
  public void testNewOAuth1IntegrationNotFoundException2() {
    // Arrange and Act
    OAuth1IntegrationNotFoundException actualOAuth1IntegrationNotFoundException = new OAuth1IntegrationNotFoundException(
        "An error occurred", "Solutions");

    // Assert
    assertEquals("\n" + "Component: Third-party integration/app authorization.\n" + "Message: An error occurred\n"
        + "Solutions: \n" + "Solutions\n", actualOAuth1IntegrationNotFoundException.getMessage());
    assertNull(actualOAuth1IntegrationNotFoundException.getCause());
    assertEquals(0, actualOAuth1IntegrationNotFoundException.getSuppressed().length);
  }
}
