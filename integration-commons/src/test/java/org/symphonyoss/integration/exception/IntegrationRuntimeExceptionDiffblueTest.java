package org.symphonyoss.integration.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class IntegrationRuntimeExceptionDiffblueTest {
  /**
   * Test {@link IntegrationRuntimeException#IntegrationRuntimeException(String, String, Throwable, String[])}.
   * <p>
   * Method under test: {@link IntegrationRuntimeException#IntegrationRuntimeException(String, String, Throwable, String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void IntegrationRuntimeException.<init>(String, String, Throwable, String[])"})
  public void testNewIntegrationRuntimeException() {
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
    assertSame(cause, actualIntegrationRuntimeException.getCause());
  }

  /**
   * Test {@link IntegrationRuntimeException#IntegrationRuntimeException(String, String, Throwable, String[])}.
   * <p>
   * Method under test: {@link IntegrationRuntimeException#IntegrationRuntimeException(String, String, Throwable, String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void IntegrationRuntimeException.<init>(String, String, Throwable, String[])"})
  public void testNewIntegrationRuntimeException2() {
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
    assertSame(cause, actualIntegrationRuntimeException.getCause());
  }

  /**
   * Test {@link IntegrationRuntimeException#IntegrationRuntimeException(String, String, Throwable, String[])}.
   * <p>
   * Method under test: {@link IntegrationRuntimeException#IntegrationRuntimeException(String, String, Throwable, String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void IntegrationRuntimeException.<init>(String, String, Throwable, String[])"})
  public void testNewIntegrationRuntimeException3() {
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
    assertSame(cause, actualIntegrationRuntimeException.getCause());
  }

  /**
   * Test {@link IntegrationRuntimeException#IntegrationRuntimeException(String, String, Throwable, String[])}.
   * <p>
   * Method under test: {@link IntegrationRuntimeException#IntegrationRuntimeException(String, String, Throwable, String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void IntegrationRuntimeException.<init>(String, String, Throwable, String[])"})
  public void testNewIntegrationRuntimeException4() {
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
    assertSame(cause, actualIntegrationRuntimeException.getCause());
  }

  /**
   * Test {@link IntegrationRuntimeException#IntegrationRuntimeException(String, String, String[])}.
   * <p>
   * Method under test: {@link IntegrationRuntimeException#IntegrationRuntimeException(String, String, String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void IntegrationRuntimeException.<init>(String, String, String[])"})
  public void testNewIntegrationRuntimeException5() {
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
   * Test {@link IntegrationRuntimeException#IntegrationRuntimeException(String, String, String[])}.
   * <p>
   * Method under test: {@link IntegrationRuntimeException#IntegrationRuntimeException(String, String, String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void IntegrationRuntimeException.<init>(String, String, String[])"})
  public void testNewIntegrationRuntimeException6() {
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
   * Test {@link IntegrationRuntimeException#IntegrationRuntimeException(String, String, String[])}.
   * <p>
   * Method under test: {@link IntegrationRuntimeException#IntegrationRuntimeException(String, String, String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void IntegrationRuntimeException.<init>(String, String, String[])"})
  public void testNewIntegrationRuntimeException7() {
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
   * Test {@link IntegrationRuntimeException#IntegrationRuntimeException(String, String, String[])}.
   * <p>
   * Method under test: {@link IntegrationRuntimeException#IntegrationRuntimeException(String, String, String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void IntegrationRuntimeException.<init>(String, String, String[])"})
  public void testNewIntegrationRuntimeException8() {
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

  /**
   * Test {@link IntegrationRuntimeException#IntegrationRuntimeException(String, String, Throwable, String[])}.
   * <ul>
   *   <li>Then return LocalizedMessage is a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link IntegrationRuntimeException#IntegrationRuntimeException(String, String, Throwable, String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void IntegrationRuntimeException.<init>(String, String, Throwable, String[])"})
  public void testNewIntegrationRuntimeException_thenReturnLocalizedMessageIsAString() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    IntegrationRuntimeException actualIntegrationRuntimeException = new IntegrationRuntimeException("Component",
        "An error occurred", cause, new String[]{});

    // Assert
    assertEquals(
        "\n" + "Component: Component\n" + "Message: An error occurred\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n" + "Stack trace: \n",
        actualIntegrationRuntimeException.getLocalizedMessage());
    assertEquals(
        "\n" + "Component: Component\n" + "Message: An error occurred\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n" + "Stack trace: \n",
        actualIntegrationRuntimeException.getMessage());
    assertSame(cause, actualIntegrationRuntimeException.getCause());
  }

  /**
   * Test {@link IntegrationRuntimeException#IntegrationRuntimeException(String, String, String[])}.
   * <ul>
   *   <li>Then return LocalizedMessage is a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link IntegrationRuntimeException#IntegrationRuntimeException(String, String, String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void IntegrationRuntimeException.<init>(String, String, String[])"})
  public void testNewIntegrationRuntimeException_thenReturnLocalizedMessageIsAString2() {
    // Arrange and Act
    IntegrationRuntimeException actualIntegrationRuntimeException = new IntegrationRuntimeException("Component",
        "An error occurred", new String[]{});

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
   * Test {@link IntegrationRuntimeException#IntegrationRuntimeException(String, String)}.
   * <ul>
   *   <li>When {@code Component}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IntegrationRuntimeException#IntegrationRuntimeException(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void IntegrationRuntimeException.<init>(String, String)"})
  public void testNewIntegrationRuntimeException_whenComponent() {
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
   * Test {@link IntegrationRuntimeException#IntegrationRuntimeException(String, String, Throwable)}.
   * <ul>
   *   <li>When {@code Component}.</li>
   *   <li>Then return Cause is {@link Throwable#Throwable()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IntegrationRuntimeException#IntegrationRuntimeException(String, String, Throwable)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void IntegrationRuntimeException.<init>(String, String, Throwable)"})
  public void testNewIntegrationRuntimeException_whenComponent_thenReturnCauseIsThrowable() {
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
    assertSame(cause, actualIntegrationRuntimeException.getCause());
  }

  /**
   * Test {@link IntegrationRuntimeException#IntegrationRuntimeException(String, String)}.
   * <ul>
   *   <li>When empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link IntegrationRuntimeException#IntegrationRuntimeException(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void IntegrationRuntimeException.<init>(String, String)"})
  public void testNewIntegrationRuntimeException_whenEmptyString() {
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
   * Test {@link IntegrationRuntimeException#IntegrationRuntimeException(String, String, Throwable)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return Cause is {@link Throwable#Throwable()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IntegrationRuntimeException#IntegrationRuntimeException(String, String, Throwable)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void IntegrationRuntimeException.<init>(String, String, Throwable)"})
  public void testNewIntegrationRuntimeException_whenEmptyString_thenReturnCauseIsThrowable() {
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
    assertSame(cause, actualIntegrationRuntimeException.getCause());
  }

  /**
   * Test {@link IntegrationRuntimeException#IntegrationRuntimeException(String, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IntegrationRuntimeException#IntegrationRuntimeException(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void IntegrationRuntimeException.<init>(String, String)"})
  public void testNewIntegrationRuntimeException_whenNull() {
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
   * Test {@link IntegrationRuntimeException#IntegrationRuntimeException(String, String, Throwable)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return Cause is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IntegrationRuntimeException#IntegrationRuntimeException(String, String, Throwable)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void IntegrationRuntimeException.<init>(String, String, Throwable)"})
  public void testNewIntegrationRuntimeException_whenNull_thenReturnCauseIsNull() {
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
   * Test {@link IntegrationRuntimeException#IntegrationRuntimeException(String, String, Throwable, String[])}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return Cause is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IntegrationRuntimeException#IntegrationRuntimeException(String, String, Throwable, String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void IntegrationRuntimeException.<init>(String, String, Throwable, String[])"})
  public void testNewIntegrationRuntimeException_whenNull_thenReturnCauseIsNull2() {
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
   * Test {@link IntegrationRuntimeException#IntegrationRuntimeException(String, String, String[])}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return LocalizedMessage is a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link IntegrationRuntimeException#IntegrationRuntimeException(String, String, String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void IntegrationRuntimeException.<init>(String, String, String[])"})
  public void testNewIntegrationRuntimeException_whenNull_thenReturnLocalizedMessageIsAString() {
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
}
