package org.symphonyoss.integration.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import org.junit.Test;

public class IntegrationExceptionDiffblueTest {
  /**
   * Method under test:
   * {@link IntegrationException#IntegrationException(String, String)}
   */
  @Test
  public void testNewIntegrationException() {
    // Arrange and Act
    IntegrationException actualIntegrationException = new IntegrationException("Component", "An error occurred");

    // Assert
    assertEquals(
        "\n" + "Component: Component\n" + "Message: An error occurred\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualIntegrationException.getLocalizedMessage());
    assertEquals(
        "\n" + "Component: Component\n" + "Message: An error occurred\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualIntegrationException.getMessage());
    assertNull(actualIntegrationException.getCause());
    assertEquals(0, actualIntegrationException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link IntegrationException#IntegrationException(String, String)}
   */
  @Test
  public void testNewIntegrationException2() {
    // Arrange and Act
    IntegrationException actualIntegrationException = new IntegrationException(null, null);

    // Assert
    assertEquals(
        "\n" + "Component: Unknown\n" + "Message: None\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualIntegrationException.getLocalizedMessage());
    assertEquals(
        "\n" + "Component: Unknown\n" + "Message: None\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualIntegrationException.getMessage());
    assertNull(actualIntegrationException.getCause());
    assertEquals(0, actualIntegrationException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link IntegrationException#IntegrationException(String, String)}
   */
  @Test
  public void testNewIntegrationException3() {
    // Arrange and Act
    IntegrationException actualIntegrationException = new IntegrationException("", "An error occurred");

    // Assert
    assertEquals(
        "\n" + "Component: Unknown\n" + "Message: An error occurred\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualIntegrationException.getLocalizedMessage());
    assertEquals(
        "\n" + "Component: Unknown\n" + "Message: An error occurred\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualIntegrationException.getMessage());
    assertNull(actualIntegrationException.getCause());
    assertEquals(0, actualIntegrationException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link IntegrationException#IntegrationException(String, String, Throwable)}
   */
  @Test
  public void testNewIntegrationException4() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    IntegrationException actualIntegrationException = new IntegrationException("Component", "An error occurred", cause);

    // Assert
    assertEquals(
        "\n" + "Component: Component\n" + "Message: An error occurred\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n" + "Stack trace: \n",
        actualIntegrationException.getLocalizedMessage());
    assertEquals(
        "\n" + "Component: Component\n" + "Message: An error occurred\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n" + "Stack trace: \n",
        actualIntegrationException.getMessage());
    assertEquals(0, actualIntegrationException.getSuppressed().length);
    assertSame(cause, actualIntegrationException.getCause());
  }

  /**
   * Method under test:
   * {@link IntegrationException#IntegrationException(String, String, Throwable)}
   */
  @Test
  public void testNewIntegrationException5() {
    // Arrange and Act
    IntegrationException actualIntegrationException = new IntegrationException(null, null, (Throwable) null);

    // Assert
    assertEquals(
        "\n" + "Component: Unknown\n" + "Message: None\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualIntegrationException.getLocalizedMessage());
    assertEquals(
        "\n" + "Component: Unknown\n" + "Message: None\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualIntegrationException.getMessage());
    assertNull(actualIntegrationException.getCause());
    assertEquals(0, actualIntegrationException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link IntegrationException#IntegrationException(String, String, Throwable)}
   */
  @Test
  public void testNewIntegrationException6() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    IntegrationException actualIntegrationException = new IntegrationException("", "An error occurred", cause);

    // Assert
    assertEquals(
        "\n" + "Component: Unknown\n" + "Message: An error occurred\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n" + "Stack trace: \n",
        actualIntegrationException.getLocalizedMessage());
    assertEquals(
        "\n" + "Component: Unknown\n" + "Message: An error occurred\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n" + "Stack trace: \n",
        actualIntegrationException.getMessage());
    assertEquals(0, actualIntegrationException.getSuppressed().length);
    assertSame(cause, actualIntegrationException.getCause());
  }

  /**
   * Method under test:
   * {@link IntegrationException#IntegrationException(String, String, Throwable, String[])}
   */
  @Test
  public void testNewIntegrationException7() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    IntegrationException actualIntegrationException = new IntegrationException("Component", "An error occurred", cause,
        "Solutions");

    // Assert
    assertEquals("\nComponent: Component\nMessage: An error occurred\nSolutions: \nSolutions\nStack trace: \n",
        actualIntegrationException.getLocalizedMessage());
    assertEquals("\nComponent: Component\nMessage: An error occurred\nSolutions: \nSolutions\nStack trace: \n",
        actualIntegrationException.getMessage());
    assertEquals(0, actualIntegrationException.getSuppressed().length);
    assertSame(cause, actualIntegrationException.getCause());
  }

  /**
   * Method under test:
   * {@link IntegrationException#IntegrationException(String, String, Throwable, String[])}
   */
  @Test
  public void testNewIntegrationException8() {
    // Arrange and Act
    IntegrationException actualIntegrationException = new IntegrationException(null, null, null, null);

    // Assert
    assertEquals(
        "\n" + "Component: Unknown\n" + "Message: None\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualIntegrationException.getLocalizedMessage());
    assertEquals(
        "\n" + "Component: Unknown\n" + "Message: None\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualIntegrationException.getMessage());
    assertNull(actualIntegrationException.getCause());
    assertEquals(0, actualIntegrationException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link IntegrationException#IntegrationException(String, String, Throwable, String[])}
   */
  @Test
  public void testNewIntegrationException9() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    IntegrationException actualIntegrationException = new IntegrationException("", "An error occurred", cause,
        "Solutions");

    // Assert
    assertEquals("\nComponent: Unknown\nMessage: An error occurred\nSolutions: \nSolutions\nStack trace: \n",
        actualIntegrationException.getLocalizedMessage());
    assertEquals("\nComponent: Unknown\nMessage: An error occurred\nSolutions: \nSolutions\nStack trace: \n",
        actualIntegrationException.getMessage());
    assertEquals(0, actualIntegrationException.getSuppressed().length);
    assertSame(cause, actualIntegrationException.getCause());
  }

  /**
   * Method under test:
   * {@link IntegrationException#IntegrationException(String, String, Throwable, String[])}
   */
  @Test
  public void testNewIntegrationException10() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    IntegrationException actualIntegrationException = new IntegrationException("Component", "An error occurred", cause,
        "");

    // Assert
    assertEquals("\nComponent: Component\nMessage: An error occurred\nSolutions: \n\nStack trace: \n",
        actualIntegrationException.getLocalizedMessage());
    assertEquals("\nComponent: Component\nMessage: An error occurred\nSolutions: \n\nStack trace: \n",
        actualIntegrationException.getMessage());
    assertEquals(0, actualIntegrationException.getSuppressed().length);
    assertSame(cause, actualIntegrationException.getCause());
  }

  /**
   * Method under test:
   * {@link IntegrationException#IntegrationException(String, String, Throwable, String[])}
   */
  @Test
  public void testNewIntegrationException11() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    IntegrationException actualIntegrationException = new IntegrationException("Component", "An error occurred", cause);

    // Assert
    assertEquals(
        "\n" + "Component: Component\n" + "Message: An error occurred\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n" + "Stack trace: \n",
        actualIntegrationException.getLocalizedMessage());
    assertEquals(
        "\n" + "Component: Component\n" + "Message: An error occurred\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n" + "Stack trace: \n",
        actualIntegrationException.getMessage());
    assertEquals(0, actualIntegrationException.getSuppressed().length);
    assertSame(cause, actualIntegrationException.getCause());
  }

  /**
   * Method under test:
   * {@link IntegrationException#IntegrationException(String, String, Throwable, String[])}
   */
  @Test
  public void testNewIntegrationException12() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    IntegrationException actualIntegrationException = new IntegrationException("Component", "An error occurred", cause,
        "\n", "Component: ");

    // Assert
    assertEquals("\nComponent: Component\nMessage: An error occurred\nSolutions: \n\n\nComponent: \nStack trace: \n",
        actualIntegrationException.getLocalizedMessage());
    assertEquals("\nComponent: Component\nMessage: An error occurred\nSolutions: \n\n\nComponent: \nStack trace: \n",
        actualIntegrationException.getMessage());
    assertEquals(0, actualIntegrationException.getSuppressed().length);
    assertSame(cause, actualIntegrationException.getCause());
  }

  /**
   * Method under test:
   * {@link IntegrationException#IntegrationException(String, String, String[])}
   */
  @Test
  public void testNewIntegrationException13() {
    // Arrange and Act
    IntegrationException actualIntegrationException = new IntegrationException("Component", "An error occurred",
        "Solutions");

    // Assert
    assertEquals("\nComponent: Component\nMessage: An error occurred\nSolutions: \nSolutions\n",
        actualIntegrationException.getLocalizedMessage());
    assertEquals("\nComponent: Component\nMessage: An error occurred\nSolutions: \nSolutions\n",
        actualIntegrationException.getMessage());
    assertNull(actualIntegrationException.getCause());
    assertEquals(0, actualIntegrationException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link IntegrationException#IntegrationException(String, String, String[])}
   */
  @Test
  public void testNewIntegrationException14() {
    // Arrange and Act
    IntegrationException actualIntegrationException = new IntegrationException(null, null, (String[]) null);

    // Assert
    assertEquals(
        "\n" + "Component: Unknown\n" + "Message: None\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualIntegrationException.getLocalizedMessage());
    assertEquals(
        "\n" + "Component: Unknown\n" + "Message: None\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualIntegrationException.getMessage());
    assertNull(actualIntegrationException.getCause());
    assertEquals(0, actualIntegrationException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link IntegrationException#IntegrationException(String, String, String[])}
   */
  @Test
  public void testNewIntegrationException15() {
    // Arrange and Act
    IntegrationException actualIntegrationException = new IntegrationException("", "An error occurred", "Solutions");

    // Assert
    assertEquals("\nComponent: Unknown\nMessage: An error occurred\nSolutions: \nSolutions\n",
        actualIntegrationException.getLocalizedMessage());
    assertEquals("\nComponent: Unknown\nMessage: An error occurred\nSolutions: \nSolutions\n",
        actualIntegrationException.getMessage());
    assertNull(actualIntegrationException.getCause());
    assertEquals(0, actualIntegrationException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link IntegrationException#IntegrationException(String, String, String[])}
   */
  @Test
  public void testNewIntegrationException16() {
    // Arrange and Act
    IntegrationException actualIntegrationException = new IntegrationException("Component", "An error occurred", "");

    // Assert
    assertEquals("\nComponent: Component\nMessage: An error occurred\nSolutions: \n\n",
        actualIntegrationException.getLocalizedMessage());
    assertEquals("\nComponent: Component\nMessage: An error occurred\nSolutions: \n\n",
        actualIntegrationException.getMessage());
    assertNull(actualIntegrationException.getCause());
    assertEquals(0, actualIntegrationException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link IntegrationException#IntegrationException(String, String, String[])}
   */
  @Test
  public void testNewIntegrationException17() {
    // Arrange and Act
    IntegrationException actualIntegrationException = new IntegrationException("Component", "An error occurred");

    // Assert
    assertEquals(
        "\n" + "Component: Component\n" + "Message: An error occurred\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualIntegrationException.getLocalizedMessage());
    assertEquals(
        "\n" + "Component: Component\n" + "Message: An error occurred\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualIntegrationException.getMessage());
    assertNull(actualIntegrationException.getCause());
    assertEquals(0, actualIntegrationException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link IntegrationException#IntegrationException(String, String, String[])}
   */
  @Test
  public void testNewIntegrationException18() {
    // Arrange and Act
    IntegrationException actualIntegrationException = new IntegrationException("Component", "An error occurred", "\n",
        "Component: ");

    // Assert
    assertEquals("\nComponent: Component\nMessage: An error occurred\nSolutions: \n\n\nComponent: \n",
        actualIntegrationException.getLocalizedMessage());
    assertEquals("\nComponent: Component\nMessage: An error occurred\nSolutions: \n\n\nComponent: \n",
        actualIntegrationException.getMessage());
    assertNull(actualIntegrationException.getCause());
    assertEquals(0, actualIntegrationException.getSuppressed().length);
  }
}
