package org.symphonyoss.integration.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class MissingConfigurationExceptionDiffblueTest {
  /**
   * Method under test:
   * {@link MissingConfigurationException#MissingConfigurationException(String, String)}
   */
  @Test
  public void testNewMissingConfigurationException() {
    // Arrange and Act
    MissingConfigurationException actualMissingConfigurationException = new MissingConfigurationException("Component",
        "Key");

    // Assert
    assertEquals(
        "\n" + "Component: Component\n"
            + "Message: Verify the YAML configuration file. No configuration found to the key Key\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualMissingConfigurationException.getLocalizedMessage());
    assertEquals(
        "\n" + "Component: Component\n"
            + "Message: Verify the YAML configuration file. No configuration found to the key Key\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualMissingConfigurationException.getMessage());
    assertNull(actualMissingConfigurationException.getCause());
    assertEquals(0, actualMissingConfigurationException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link MissingConfigurationException#MissingConfigurationException(String, String)}
   */
  @Test
  public void testNewMissingConfigurationException2() {
    // Arrange and Act
    MissingConfigurationException actualMissingConfigurationException = new MissingConfigurationException(null, "Key");

    // Assert
    assertEquals(
        "\n" + "Component: Unknown\n"
            + "Message: Verify the YAML configuration file. No configuration found to the key Key\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualMissingConfigurationException.getLocalizedMessage());
    assertEquals(
        "\n" + "Component: Unknown\n"
            + "Message: Verify the YAML configuration file. No configuration found to the key Key\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualMissingConfigurationException.getMessage());
    assertNull(actualMissingConfigurationException.getCause());
    assertEquals(0, actualMissingConfigurationException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link MissingConfigurationException#MissingConfigurationException(String, String, String[])}
   */
  @Test
  public void testNewMissingConfigurationException3() {
    // Arrange and Act
    MissingConfigurationException actualMissingConfigurationException = new MissingConfigurationException("Component",
        "An error occurred", "Solutions");

    // Assert
    assertEquals("\nComponent: Component\nMessage: An error occurred\nSolutions: \nSolutions\n",
        actualMissingConfigurationException.getLocalizedMessage());
    assertEquals("\nComponent: Component\nMessage: An error occurred\nSolutions: \nSolutions\n",
        actualMissingConfigurationException.getMessage());
    assertNull(actualMissingConfigurationException.getCause());
    assertEquals(0, actualMissingConfigurationException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link MissingConfigurationException#MissingConfigurationException(String, String, String[])}
   */
  @Test
  public void testNewMissingConfigurationException4() {
    // Arrange and Act
    MissingConfigurationException actualMissingConfigurationException = new MissingConfigurationException(null, null,
        null);

    // Assert
    assertEquals(
        "\n" + "Component: Unknown\n" + "Message: None\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualMissingConfigurationException.getLocalizedMessage());
    assertEquals(
        "\n" + "Component: Unknown\n" + "Message: None\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualMissingConfigurationException.getMessage());
    assertNull(actualMissingConfigurationException.getCause());
    assertEquals(0, actualMissingConfigurationException.getSuppressed().length);
  }
}
