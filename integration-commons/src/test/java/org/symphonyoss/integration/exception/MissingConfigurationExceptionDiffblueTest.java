package org.symphonyoss.integration.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;

public class MissingConfigurationExceptionDiffblueTest {
  /**
   * Test {@link MissingConfigurationException#MissingConfigurationException(String, String, String[])}.
   * <p>
   * Method under test: {@link MissingConfigurationException#MissingConfigurationException(String, String, String[])}
   */
  @Test
  @MethodsUnderTest({"void MissingConfigurationException.<init>(String, String, String[])"})
  public void testNewMissingConfigurationException() {
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
   * Test {@link MissingConfigurationException#MissingConfigurationException(String, String, String[])}.
   * <ul>
   *   <li>Then return LocalizedMessage is a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link MissingConfigurationException#MissingConfigurationException(String, String, String[])}
   */
  @Test
  @MethodsUnderTest({"void MissingConfigurationException.<init>(String, String, String[])"})
  public void testNewMissingConfigurationException_thenReturnLocalizedMessageIsAString() {
    // Arrange and Act
    MissingConfigurationException actualMissingConfigurationException = new MissingConfigurationException("Component",
        "An error occurred", new String[]{});

    // Assert
    assertEquals(
        "\n" + "Component: Component\n" + "Message: An error occurred\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualMissingConfigurationException.getLocalizedMessage());
    assertEquals(
        "\n" + "Component: Component\n" + "Message: An error occurred\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualMissingConfigurationException.getMessage());
    assertNull(actualMissingConfigurationException.getCause());
    assertEquals(0, actualMissingConfigurationException.getSuppressed().length);
  }

  /**
   * Test {@link MissingConfigurationException#MissingConfigurationException(String, String)}.
   * <ul>
   *   <li>When {@code Component}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MissingConfigurationException#MissingConfigurationException(String, String)}
   */
  @Test
  @MethodsUnderTest({"void MissingConfigurationException.<init>(String, String)"})
  public void testNewMissingConfigurationException_whenComponent() {
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
   * Test {@link MissingConfigurationException#MissingConfigurationException(String, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MissingConfigurationException#MissingConfigurationException(String, String)}
   */
  @Test
  @MethodsUnderTest({"void MissingConfigurationException.<init>(String, String)"})
  public void testNewMissingConfigurationException_whenNull() {
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
   * Test {@link MissingConfigurationException#MissingConfigurationException(String, String, String[])}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MissingConfigurationException#MissingConfigurationException(String, String, String[])}
   */
  @Test
  @MethodsUnderTest({"void MissingConfigurationException.<init>(String, String, String[])"})
  public void testNewMissingConfigurationException_whenNull2() {
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
