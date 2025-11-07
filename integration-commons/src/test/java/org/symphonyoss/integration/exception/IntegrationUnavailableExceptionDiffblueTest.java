package org.symphonyoss.integration.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class IntegrationUnavailableExceptionDiffblueTest {
  /**
   * Method under test:
   * {@link IntegrationUnavailableException#IntegrationUnavailableException(String)}
   */
  @Test
  public void testNewIntegrationUnavailableException() {
    // Arrange and Act
    IntegrationUnavailableException actualIntegrationUnavailableException = new IntegrationUnavailableException(
        "Configuration Type");

    // Assert
    assertEquals(
        "\n" + "Component: Webhook Dispatcher\n" + "Message: Configuration Configuration Type unavailable\n"
            + "Solutions: \n" + "No solution has been cataloged for troubleshooting this problem.\n",
        actualIntegrationUnavailableException.getLocalizedMessage());
    assertEquals(
        "\n" + "Component: Webhook Dispatcher\n" + "Message: Configuration Configuration Type unavailable\n"
            + "Solutions: \n" + "No solution has been cataloged for troubleshooting this problem.\n",
        actualIntegrationUnavailableException.getMessage());
    assertNull(actualIntegrationUnavailableException.getCause());
    assertEquals(0, actualIntegrationUnavailableException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link IntegrationUnavailableException#IntegrationUnavailableException(String, String, String[])}
   */
  @Test
  public void testNewIntegrationUnavailableException2() {
    // Arrange and Act
    IntegrationUnavailableException actualIntegrationUnavailableException = new IntegrationUnavailableException(
        "Component", "An error occurred", "Solutions");

    // Assert
    assertEquals("\nComponent: Component\nMessage: An error occurred\nSolutions: \nSolutions\n",
        actualIntegrationUnavailableException.getLocalizedMessage());
    assertEquals("\nComponent: Component\nMessage: An error occurred\nSolutions: \nSolutions\n",
        actualIntegrationUnavailableException.getMessage());
    assertNull(actualIntegrationUnavailableException.getCause());
    assertEquals(0, actualIntegrationUnavailableException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link IntegrationUnavailableException#IntegrationUnavailableException(String, String, String[])}
   */
  @Test
  public void testNewIntegrationUnavailableException3() {
    // Arrange and Act
    IntegrationUnavailableException actualIntegrationUnavailableException = new IntegrationUnavailableException(null,
        null, null);

    // Assert
    assertEquals(
        "\n" + "Component: Unknown\n" + "Message: None\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualIntegrationUnavailableException.getLocalizedMessage());
    assertEquals(
        "\n" + "Component: Unknown\n" + "Message: None\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualIntegrationUnavailableException.getMessage());
    assertNull(actualIntegrationUnavailableException.getCause());
    assertEquals(0, actualIntegrationUnavailableException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link IntegrationUnavailableException#IntegrationUnavailableException(String, String, String[])}
   */
  @Test
  public void testNewIntegrationUnavailableException4() {
    // Arrange and Act
    IntegrationUnavailableException actualIntegrationUnavailableException = new IntegrationUnavailableException(
        "Component", "An error occurred");

    // Assert
    assertEquals(
        "\n" + "Component: Component\n" + "Message: An error occurred\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualIntegrationUnavailableException.getLocalizedMessage());
    assertEquals(
        "\n" + "Component: Component\n" + "Message: An error occurred\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualIntegrationUnavailableException.getMessage());
    assertNull(actualIntegrationUnavailableException.getCause());
    assertEquals(0, actualIntegrationUnavailableException.getSuppressed().length);
  }
}
