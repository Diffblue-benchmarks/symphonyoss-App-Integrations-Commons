package org.symphonyoss.integration.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;

public class IntegrationExceptionDiffblueTest {
  /**
   * Test {@link IntegrationException#IntegrationException(String, String, Throwable, String[])}.
   * <p>
   * Method under test: {@link IntegrationException#IntegrationException(String, String, Throwable, String[])}
   */
  @Test
  @MethodsUnderTest({"void IntegrationException.<init>(String, String, Throwable, String[])"})
  public void testNewIntegrationException() {
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
    assertSame(cause, actualIntegrationException.getCause());
  }

  /**
   * Test {@link IntegrationException#IntegrationException(String, String, Throwable, String[])}.
   * <p>
   * Method under test: {@link IntegrationException#IntegrationException(String, String, Throwable, String[])}
   */
  @Test
  @MethodsUnderTest({"void IntegrationException.<init>(String, String, Throwable, String[])"})
  public void testNewIntegrationException2() {
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
    assertSame(cause, actualIntegrationException.getCause());
  }

  /**
   * Test {@link IntegrationException#IntegrationException(String, String, Throwable, String[])}.
   * <p>
   * Method under test: {@link IntegrationException#IntegrationException(String, String, Throwable, String[])}
   */
  @Test
  @MethodsUnderTest({"void IntegrationException.<init>(String, String, Throwable, String[])"})
  public void testNewIntegrationException3() {
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
    assertSame(cause, actualIntegrationException.getCause());
  }

  /**
   * Test {@link IntegrationException#IntegrationException(String, String, Throwable, String[])}.
   * <p>
   * Method under test: {@link IntegrationException#IntegrationException(String, String, Throwable, String[])}
   */
  @Test
  @MethodsUnderTest({"void IntegrationException.<init>(String, String, Throwable, String[])"})
  public void testNewIntegrationException4() {
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
    assertSame(cause, actualIntegrationException.getCause());
  }

  /**
   * Test {@link IntegrationException#IntegrationException(String, String, String[])}.
   * <p>
   * Method under test: {@link IntegrationException#IntegrationException(String, String, String[])}
   */
  @Test
  @MethodsUnderTest({"void IntegrationException.<init>(String, String, String[])"})
  public void testNewIntegrationException5() {
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
   * Test {@link IntegrationException#IntegrationException(String, String, String[])}.
   * <p>
   * Method under test: {@link IntegrationException#IntegrationException(String, String, String[])}
   */
  @Test
  @MethodsUnderTest({"void IntegrationException.<init>(String, String, String[])"})
  public void testNewIntegrationException6() {
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
   * Test {@link IntegrationException#IntegrationException(String, String, String[])}.
   * <p>
   * Method under test: {@link IntegrationException#IntegrationException(String, String, String[])}
   */
  @Test
  @MethodsUnderTest({"void IntegrationException.<init>(String, String, String[])"})
  public void testNewIntegrationException7() {
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
   * Test {@link IntegrationException#IntegrationException(String, String, String[])}.
   * <p>
   * Method under test: {@link IntegrationException#IntegrationException(String, String, String[])}
   */
  @Test
  @MethodsUnderTest({"void IntegrationException.<init>(String, String, String[])"})
  public void testNewIntegrationException8() {
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

  /**
   * Test {@link IntegrationException#IntegrationException(String, String)}.
   * <ul>
   *   <li>When {@code Component}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IntegrationException#IntegrationException(String, String)}
   */
  @Test
  @MethodsUnderTest({"void IntegrationException.<init>(String, String)"})
  public void testNewIntegrationException_whenComponent() {
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
   * Test {@link IntegrationException#IntegrationException(String, String, Throwable)}.
   * <ul>
   *   <li>When {@code Component}.</li>
   *   <li>Then return Cause is {@link Throwable#Throwable()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IntegrationException#IntegrationException(String, String, Throwable)}
   */
  @Test
  @MethodsUnderTest({"void IntegrationException.<init>(String, String, Throwable)"})
  public void testNewIntegrationException_whenComponent_thenReturnCauseIsThrowable() {
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
    assertSame(cause, actualIntegrationException.getCause());
  }

  /**
   * Test {@link IntegrationException#IntegrationException(String, String, Throwable, String[])}.
   * <ul>
   *   <li>When {@code Component}.</li>
   *   <li>Then return LocalizedMessage is a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link IntegrationException#IntegrationException(String, String, Throwable, String[])}
   */
  @Test
  @MethodsUnderTest({"void IntegrationException.<init>(String, String, Throwable, String[])"})
  public void testNewIntegrationException_whenComponent_thenReturnLocalizedMessageIsAString() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    IntegrationException actualIntegrationException = new IntegrationException("Component", "An error occurred", cause,
        new String[]{});

    // Assert
    assertEquals(
        "\n" + "Component: Component\n" + "Message: An error occurred\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n" + "Stack trace: \n",
        actualIntegrationException.getLocalizedMessage());
    assertEquals(
        "\n" + "Component: Component\n" + "Message: An error occurred\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n" + "Stack trace: \n",
        actualIntegrationException.getMessage());
    assertSame(cause, actualIntegrationException.getCause());
  }

  /**
   * Test {@link IntegrationException#IntegrationException(String, String, String[])}.
   * <ul>
   *   <li>When {@code Component}.</li>
   *   <li>Then return LocalizedMessage is a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link IntegrationException#IntegrationException(String, String, String[])}
   */
  @Test
  @MethodsUnderTest({"void IntegrationException.<init>(String, String, String[])"})
  public void testNewIntegrationException_whenComponent_thenReturnLocalizedMessageIsAString2() {
    // Arrange and Act
    IntegrationException actualIntegrationException = new IntegrationException("Component", "An error occurred",
        new String[]{});

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
   * Test {@link IntegrationException#IntegrationException(String, String)}.
   * <ul>
   *   <li>When empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link IntegrationException#IntegrationException(String, String)}
   */
  @Test
  @MethodsUnderTest({"void IntegrationException.<init>(String, String)"})
  public void testNewIntegrationException_whenEmptyString() {
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
   * Test {@link IntegrationException#IntegrationException(String, String, Throwable)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return Cause is {@link Throwable#Throwable()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IntegrationException#IntegrationException(String, String, Throwable)}
   */
  @Test
  @MethodsUnderTest({"void IntegrationException.<init>(String, String, Throwable)"})
  public void testNewIntegrationException_whenEmptyString_thenReturnCauseIsThrowable() {
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
    assertSame(cause, actualIntegrationException.getCause());
  }

  /**
   * Test {@link IntegrationException#IntegrationException(String, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IntegrationException#IntegrationException(String, String)}
   */
  @Test
  @MethodsUnderTest({"void IntegrationException.<init>(String, String)"})
  public void testNewIntegrationException_whenNull() {
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
   * Test {@link IntegrationException#IntegrationException(String, String, Throwable)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return Cause is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IntegrationException#IntegrationException(String, String, Throwable)}
   */
  @Test
  @MethodsUnderTest({"void IntegrationException.<init>(String, String, Throwable)"})
  public void testNewIntegrationException_whenNull_thenReturnCauseIsNull() {
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
   * Test {@link IntegrationException#IntegrationException(String, String, Throwable, String[])}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return Cause is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IntegrationException#IntegrationException(String, String, Throwable, String[])}
   */
  @Test
  @MethodsUnderTest({"void IntegrationException.<init>(String, String, Throwable, String[])"})
  public void testNewIntegrationException_whenNull_thenReturnCauseIsNull2() {
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
   * Test {@link IntegrationException#IntegrationException(String, String, String[])}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return LocalizedMessage is a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link IntegrationException#IntegrationException(String, String, String[])}
   */
  @Test
  @MethodsUnderTest({"void IntegrationException.<init>(String, String, String[])"})
  public void testNewIntegrationException_whenNull_thenReturnLocalizedMessageIsAString() {
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
}
