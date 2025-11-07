package org.symphonyoss.integration.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import org.junit.Test;

public class IntegrationRuntimeExceptionDiffblueTest {
  /**
   * Method under test:
   * {@link IntegrationRuntimeException#IntegrationRuntimeException(String, String)}
   */
  @Test
  public void testNewIntegrationRuntimeException() {
    // Arrange and Act
    IntegrationRuntimeException actualIntegrationRuntimeException = new IntegrationRuntimeException("Component",
        "An error occurred");

    // Assert
    assertEquals(
        "\n" + "Component: Component\n" + "Message: An error occurred\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualIntegrationRuntimeException.getLocalizedMessage());
    assertEquals(
        "\n" + "Component: Component\n" + "Message: An error occurred\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualIntegrationRuntimeException.getMessage());
    assertNull(actualIntegrationRuntimeException.getCause());
    assertEquals(0, actualIntegrationRuntimeException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link IntegrationRuntimeException#IntegrationRuntimeException(String, String)}
   */
  @Test
  public void testNewIntegrationRuntimeException2() {
    // Arrange and Act
    IntegrationRuntimeException actualIntegrationRuntimeException = new IntegrationRuntimeException(null, null);

    // Assert
    assertEquals(
        "\n" + "Component: Unknown\n" + "Message: None\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualIntegrationRuntimeException.getLocalizedMessage());
    assertEquals(
        "\n" + "Component: Unknown\n" + "Message: None\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualIntegrationRuntimeException.getMessage());
    assertNull(actualIntegrationRuntimeException.getCause());
    assertEquals(0, actualIntegrationRuntimeException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link IntegrationRuntimeException#IntegrationRuntimeException(String, String)}
   */
  @Test
  public void testNewIntegrationRuntimeException3() {
    // Arrange and Act
    IntegrationRuntimeException actualIntegrationRuntimeException = new IntegrationRuntimeException("",
        "An error occurred");

    // Assert
    assertEquals(
        "\n" + "Component: Unknown\n" + "Message: An error occurred\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualIntegrationRuntimeException.getLocalizedMessage());
    assertEquals(
        "\n" + "Component: Unknown\n" + "Message: An error occurred\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualIntegrationRuntimeException.getMessage());
    assertNull(actualIntegrationRuntimeException.getCause());
    assertEquals(0, actualIntegrationRuntimeException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link IntegrationRuntimeException#IntegrationRuntimeException(String, String, Throwable)}
   */
  @Test
  public void testNewIntegrationRuntimeException4() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    IntegrationRuntimeException actualIntegrationRuntimeException = new IntegrationRuntimeException("Component",
        "An error occurred", cause);

    // Assert
    assertEquals(
        "\n" + "Component: Component\n" + "Message: An error occurred\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n" + "Stack trace: \n",
        actualIntegrationRuntimeException.getLocalizedMessage());
    assertEquals(
        "\n" + "Component: Component\n" + "Message: An error occurred\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n" + "Stack trace: \n",
        actualIntegrationRuntimeException.getMessage());
    assertEquals(0, actualIntegrationRuntimeException.getSuppressed().length);
    assertSame(cause, actualIntegrationRuntimeException.getCause());
  }

  /**
   * Method under test:
   * {@link IntegrationRuntimeException#IntegrationRuntimeException(String, String, Throwable)}
   */
  @Test
  public void testNewIntegrationRuntimeException5() {
    // Arrange and Act
    IntegrationRuntimeException actualIntegrationRuntimeException = new IntegrationRuntimeException(null, null,
        (Throwable) null);

    // Assert
    assertEquals(
        "\n" + "Component: Unknown\n" + "Message: None\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualIntegrationRuntimeException.getLocalizedMessage());
    assertEquals(
        "\n" + "Component: Unknown\n" + "Message: None\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualIntegrationRuntimeException.getMessage());
    assertNull(actualIntegrationRuntimeException.getCause());
    assertEquals(0, actualIntegrationRuntimeException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link IntegrationRuntimeException#IntegrationRuntimeException(String, String, Throwable)}
   */
  @Test
  public void testNewIntegrationRuntimeException6() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    IntegrationRuntimeException actualIntegrationRuntimeException = new IntegrationRuntimeException("",
        "An error occurred", cause);

    // Assert
    assertEquals(
        "\n" + "Component: Unknown\n" + "Message: An error occurred\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n" + "Stack trace: \n",
        actualIntegrationRuntimeException.getLocalizedMessage());
    assertEquals(
        "\n" + "Component: Unknown\n" + "Message: An error occurred\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n" + "Stack trace: \n",
        actualIntegrationRuntimeException.getMessage());
    assertEquals(0, actualIntegrationRuntimeException.getSuppressed().length);
    assertSame(cause, actualIntegrationRuntimeException.getCause());
  }

  /**
   * Method under test:
   * {@link IntegrationRuntimeException#IntegrationRuntimeException(String, String, Throwable, String[])}
   */
  @Test
  public void testNewIntegrationRuntimeException7() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    IntegrationRuntimeException actualIntegrationRuntimeException = new IntegrationRuntimeException("Component",
        "An error occurred", cause, "Solutions");

    // Assert
    assertEquals("\nComponent: Component\nMessage: An error occurred\nSolutions: \nSolutions\nStack trace: \n",
        actualIntegrationRuntimeException.getLocalizedMessage());
    assertEquals("\nComponent: Component\nMessage: An error occurred\nSolutions: \nSolutions\nStack trace: \n",
        actualIntegrationRuntimeException.getMessage());
    assertEquals(0, actualIntegrationRuntimeException.getSuppressed().length);
    assertSame(cause, actualIntegrationRuntimeException.getCause());
  }

  /**
   * Method under test:
   * {@link IntegrationRuntimeException#IntegrationRuntimeException(String, String, Throwable, String[])}
   */
  @Test
  public void testNewIntegrationRuntimeException8() {
    // Arrange and Act
    IntegrationRuntimeException actualIntegrationRuntimeException = new IntegrationRuntimeException(null, null, null,
        null);

    // Assert
    assertEquals(
        "\n" + "Component: Unknown\n" + "Message: None\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualIntegrationRuntimeException.getLocalizedMessage());
    assertEquals(
        "\n" + "Component: Unknown\n" + "Message: None\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualIntegrationRuntimeException.getMessage());
    assertNull(actualIntegrationRuntimeException.getCause());
    assertEquals(0, actualIntegrationRuntimeException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link IntegrationRuntimeException#IntegrationRuntimeException(String, String, Throwable, String[])}
   */
  @Test
  public void testNewIntegrationRuntimeException9() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    IntegrationRuntimeException actualIntegrationRuntimeException = new IntegrationRuntimeException("",
        "An error occurred", cause, "Solutions");

    // Assert
    assertEquals("\nComponent: Unknown\nMessage: An error occurred\nSolutions: \nSolutions\nStack trace: \n",
        actualIntegrationRuntimeException.getLocalizedMessage());
    assertEquals("\nComponent: Unknown\nMessage: An error occurred\nSolutions: \nSolutions\nStack trace: \n",
        actualIntegrationRuntimeException.getMessage());
    assertEquals(0, actualIntegrationRuntimeException.getSuppressed().length);
    assertSame(cause, actualIntegrationRuntimeException.getCause());
  }

  /**
   * Method under test:
   * {@link IntegrationRuntimeException#IntegrationRuntimeException(String, String, Throwable, String[])}
   */
  @Test
  public void testNewIntegrationRuntimeException10() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    IntegrationRuntimeException actualIntegrationRuntimeException = new IntegrationRuntimeException("Component",
        "An error occurred", cause, "");

    // Assert
    assertEquals("\nComponent: Component\nMessage: An error occurred\nSolutions: \n\nStack trace: \n",
        actualIntegrationRuntimeException.getLocalizedMessage());
    assertEquals("\nComponent: Component\nMessage: An error occurred\nSolutions: \n\nStack trace: \n",
        actualIntegrationRuntimeException.getMessage());
    assertEquals(0, actualIntegrationRuntimeException.getSuppressed().length);
    assertSame(cause, actualIntegrationRuntimeException.getCause());
  }

  /**
   * Method under test:
   * {@link IntegrationRuntimeException#IntegrationRuntimeException(String, String, Throwable, String[])}
   */
  @Test
  public void testNewIntegrationRuntimeException11() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    IntegrationRuntimeException actualIntegrationRuntimeException = new IntegrationRuntimeException("Component",
        "An error occurred", cause);

    // Assert
    assertEquals(
        "\n" + "Component: Component\n" + "Message: An error occurred\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n" + "Stack trace: \n",
        actualIntegrationRuntimeException.getLocalizedMessage());
    assertEquals(
        "\n" + "Component: Component\n" + "Message: An error occurred\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n" + "Stack trace: \n",
        actualIntegrationRuntimeException.getMessage());
    assertEquals(0, actualIntegrationRuntimeException.getSuppressed().length);
    assertSame(cause, actualIntegrationRuntimeException.getCause());
  }

  /**
   * Method under test:
   * {@link IntegrationRuntimeException#IntegrationRuntimeException(String, String, Throwable, String[])}
   */
  @Test
  public void testNewIntegrationRuntimeException12() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    IntegrationRuntimeException actualIntegrationRuntimeException = new IntegrationRuntimeException("Component",
        "An error occurred", cause, "\n", "Component: ");

    // Assert
    assertEquals("\nComponent: Component\nMessage: An error occurred\nSolutions: \n\n\nComponent: \nStack trace: \n",
        actualIntegrationRuntimeException.getLocalizedMessage());
    assertEquals("\nComponent: Component\nMessage: An error occurred\nSolutions: \n\n\nComponent: \nStack trace: \n",
        actualIntegrationRuntimeException.getMessage());
    assertEquals(0, actualIntegrationRuntimeException.getSuppressed().length);
    assertSame(cause, actualIntegrationRuntimeException.getCause());
  }

  /**
   * Method under test:
   * {@link IntegrationRuntimeException#IntegrationRuntimeException(String, String, String[])}
   */
  @Test
  public void testNewIntegrationRuntimeException13() {
    // Arrange and Act
    IntegrationRuntimeException actualIntegrationRuntimeException = new IntegrationRuntimeException("Component",
        "An error occurred", "Solutions");

    // Assert
    assertEquals("\nComponent: Component\nMessage: An error occurred\nSolutions: \nSolutions\n",
        actualIntegrationRuntimeException.getLocalizedMessage());
    assertEquals("\nComponent: Component\nMessage: An error occurred\nSolutions: \nSolutions\n",
        actualIntegrationRuntimeException.getMessage());
    assertNull(actualIntegrationRuntimeException.getCause());
    assertEquals(0, actualIntegrationRuntimeException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link IntegrationRuntimeException#IntegrationRuntimeException(String, String, String[])}
   */
  @Test
  public void testNewIntegrationRuntimeException14() {
    // Arrange and Act
    IntegrationRuntimeException actualIntegrationRuntimeException = new IntegrationRuntimeException(null, null,
        (String[]) null);

    // Assert
    assertEquals(
        "\n" + "Component: Unknown\n" + "Message: None\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualIntegrationRuntimeException.getLocalizedMessage());
    assertEquals(
        "\n" + "Component: Unknown\n" + "Message: None\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualIntegrationRuntimeException.getMessage());
    assertNull(actualIntegrationRuntimeException.getCause());
    assertEquals(0, actualIntegrationRuntimeException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link IntegrationRuntimeException#IntegrationRuntimeException(String, String, String[])}
   */
  @Test
  public void testNewIntegrationRuntimeException15() {
    // Arrange and Act
    IntegrationRuntimeException actualIntegrationRuntimeException = new IntegrationRuntimeException("",
        "An error occurred", "Solutions");

    // Assert
    assertEquals("\nComponent: Unknown\nMessage: An error occurred\nSolutions: \nSolutions\n",
        actualIntegrationRuntimeException.getLocalizedMessage());
    assertEquals("\nComponent: Unknown\nMessage: An error occurred\nSolutions: \nSolutions\n",
        actualIntegrationRuntimeException.getMessage());
    assertNull(actualIntegrationRuntimeException.getCause());
    assertEquals(0, actualIntegrationRuntimeException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link IntegrationRuntimeException#IntegrationRuntimeException(String, String, String[])}
   */
  @Test
  public void testNewIntegrationRuntimeException16() {
    // Arrange and Act
    IntegrationRuntimeException actualIntegrationRuntimeException = new IntegrationRuntimeException("Component",
        "An error occurred", "");

    // Assert
    assertEquals("\nComponent: Component\nMessage: An error occurred\nSolutions: \n\n",
        actualIntegrationRuntimeException.getLocalizedMessage());
    assertEquals("\nComponent: Component\nMessage: An error occurred\nSolutions: \n\n",
        actualIntegrationRuntimeException.getMessage());
    assertNull(actualIntegrationRuntimeException.getCause());
    assertEquals(0, actualIntegrationRuntimeException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link IntegrationRuntimeException#IntegrationRuntimeException(String, String, String[])}
   */
  @Test
  public void testNewIntegrationRuntimeException17() {
    // Arrange and Act
    IntegrationRuntimeException actualIntegrationRuntimeException = new IntegrationRuntimeException("Component",
        "An error occurred");

    // Assert
    assertEquals(
        "\n" + "Component: Component\n" + "Message: An error occurred\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualIntegrationRuntimeException.getLocalizedMessage());
    assertEquals(
        "\n" + "Component: Component\n" + "Message: An error occurred\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualIntegrationRuntimeException.getMessage());
    assertNull(actualIntegrationRuntimeException.getCause());
    assertEquals(0, actualIntegrationRuntimeException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link IntegrationRuntimeException#IntegrationRuntimeException(String, String, String[])}
   */
  @Test
  public void testNewIntegrationRuntimeException18() {
    // Arrange and Act
    IntegrationRuntimeException actualIntegrationRuntimeException = new IntegrationRuntimeException("Component",
        "An error occurred", "\n", "Component: ");

    // Assert
    assertEquals("\nComponent: Component\nMessage: An error occurred\nSolutions: \n\n\nComponent: \n",
        actualIntegrationRuntimeException.getLocalizedMessage());
    assertEquals("\nComponent: Component\nMessage: An error occurred\nSolutions: \n\n\nComponent: \n",
        actualIntegrationRuntimeException.getMessage());
    assertNull(actualIntegrationRuntimeException.getCause());
    assertEquals(0, actualIntegrationRuntimeException.getSuppressed().length);
  }
}
