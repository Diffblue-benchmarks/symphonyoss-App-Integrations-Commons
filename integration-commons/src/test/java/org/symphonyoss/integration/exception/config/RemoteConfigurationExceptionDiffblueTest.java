package org.symphonyoss.integration.exception.config;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import org.junit.Test;

public class RemoteConfigurationExceptionDiffblueTest {
  /**
   * Method under test:
   * {@link RemoteConfigurationException#RemoteConfigurationException(String, Throwable, String[])}
   */
  @Test
  public void testNewRemoteConfigurationException() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    RemoteConfigurationException actualRemoteConfigurationException = new RemoteConfigurationException(
        "An error occurred", cause, "Solutions");

    // Assert
    assertEquals(
        "\nComponent: Configuration Service\nMessage: An error occurred\nSolutions: \nSolutions\nStack trace: \n",
        actualRemoteConfigurationException.getLocalizedMessage());
    assertEquals(
        "\nComponent: Configuration Service\nMessage: An error occurred\nSolutions: \nSolutions\nStack trace: \n",
        actualRemoteConfigurationException.getMessage());
    assertEquals(0, actualRemoteConfigurationException.getSuppressed().length);
    assertSame(cause, actualRemoteConfigurationException.getCause());
  }
}
