package org.symphonyoss.integration.webhook.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;

public class WebHookParseExceptionDiffblueTest {
  /**
   * Test {@link WebHookParseException#WebHookParseException(String, String, Throwable, String[])}.
   *
   * <p>Method under test: {@link WebHookParseException#WebHookParseException(String, String,
   * Throwable, String[])}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"void WebHookParseException.<init>(String, String, Throwable, String[])"})
  public void testNewWebHookParseException() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    WebHookParseException actualWebHookParseException =
        new WebHookParseException("Component", "An error occurred", cause, "Solutions");

    // Assert
    assertEquals(
        "\nComponent: Component\nMessage: An error occurred\nSolutions: \nSolutions\nStack trace: \n",
        actualWebHookParseException.getLocalizedMessage());
    assertEquals(
        "\nComponent: Component\nMessage: An error occurred\nSolutions: \nSolutions\nStack trace: \n",
        actualWebHookParseException.getMessage());
    assertSame(cause, actualWebHookParseException.getCause());
  }

  /**
   * Test {@link WebHookParseException#WebHookParseException(String, String, Throwable, String[])}.
   *
   * <p>Method under test: {@link WebHookParseException#WebHookParseException(String, String,
   * Throwable, String[])}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"void WebHookParseException.<init>(String, String, Throwable, String[])"})
  public void testNewWebHookParseException2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    WebHookParseException actualWebHookParseException =
        new WebHookParseException("", "An error occurred", cause, "Solutions");

    // Assert
    assertEquals(
        "\nComponent: Unknown\nMessage: An error occurred\nSolutions: \nSolutions\nStack trace: \n",
        actualWebHookParseException.getLocalizedMessage());
    assertEquals(
        "\nComponent: Unknown\nMessage: An error occurred\nSolutions: \nSolutions\nStack trace: \n",
        actualWebHookParseException.getMessage());
    assertSame(cause, actualWebHookParseException.getCause());
  }

  /**
   * Test {@link WebHookParseException#WebHookParseException(String, String, Throwable, String[])}.
   *
   * <p>Method under test: {@link WebHookParseException#WebHookParseException(String, String,
   * Throwable, String[])}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"void WebHookParseException.<init>(String, String, Throwable, String[])"})
  public void testNewWebHookParseException3() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    WebHookParseException actualWebHookParseException =
        new WebHookParseException("Component", "", cause, "Solutions");

    // Assert
    assertEquals(
        "\nComponent: Component\nMessage: None\nSolutions: \nSolutions\nStack trace: \n",
        actualWebHookParseException.getLocalizedMessage());
    assertEquals(
        "\nComponent: Component\nMessage: None\nSolutions: \nSolutions\nStack trace: \n",
        actualWebHookParseException.getMessage());
    assertSame(cause, actualWebHookParseException.getCause());
  }

  /**
   * Test {@link WebHookParseException#WebHookParseException(String, String, String[])}.
   *
   * <p>Method under test: {@link WebHookParseException#WebHookParseException(String, String,
   * String[])}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"void WebHookParseException.<init>(String, String, String[])"})
  public void testNewWebHookParseException4() {
    // Arrange and Act
    WebHookParseException actualWebHookParseException =
        new WebHookParseException("Component", "An error occurred", "Solutions");

    // Assert
    assertEquals(
        "\nComponent: Component\nMessage: An error occurred\nSolutions: \nSolutions\n",
        actualWebHookParseException.getLocalizedMessage());
    assertEquals(
        "\nComponent: Component\nMessage: An error occurred\nSolutions: \nSolutions\n",
        actualWebHookParseException.getMessage());
    assertNull(actualWebHookParseException.getCause());
    assertEquals(0, actualWebHookParseException.getSuppressed().length);
  }

  /**
   * Test {@link WebHookParseException#WebHookParseException(String, String, String[])}.
   *
   * <p>Method under test: {@link WebHookParseException#WebHookParseException(String, String,
   * String[])}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"void WebHookParseException.<init>(String, String, String[])"})
  public void testNewWebHookParseException5() {
    // Arrange and Act
    WebHookParseException actualWebHookParseException =
        new WebHookParseException("", "An error occurred", "Solutions");

    // Assert
    assertEquals(
        "\nComponent: Unknown\nMessage: An error occurred\nSolutions: \nSolutions\n",
        actualWebHookParseException.getLocalizedMessage());
    assertEquals(
        "\nComponent: Unknown\nMessage: An error occurred\nSolutions: \nSolutions\n",
        actualWebHookParseException.getMessage());
    assertNull(actualWebHookParseException.getCause());
    assertEquals(0, actualWebHookParseException.getSuppressed().length);
  }

  /**
   * Test {@link WebHookParseException#WebHookParseException(String, String, String[])}.
   *
   * <p>Method under test: {@link WebHookParseException#WebHookParseException(String, String,
   * String[])}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"void WebHookParseException.<init>(String, String, String[])"})
  public void testNewWebHookParseException6() {
    // Arrange and Act
    WebHookParseException actualWebHookParseException =
        new WebHookParseException("Component", "", "Solutions");

    // Assert
    assertEquals(
        "\nComponent: Component\nMessage: None\nSolutions: \nSolutions\n",
        actualWebHookParseException.getLocalizedMessage());
    assertEquals(
        "\nComponent: Component\nMessage: None\nSolutions: \nSolutions\n",
        actualWebHookParseException.getMessage());
    assertNull(actualWebHookParseException.getCause());
    assertEquals(0, actualWebHookParseException.getSuppressed().length);
  }

  /**
   * Test {@link WebHookParseException#WebHookParseException(String, String)}.
   *
   * <ul>
   *   <li>When {@code Component}.
   * </ul>
   *
   * <p>Method under test: {@link WebHookParseException#WebHookParseException(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"void WebHookParseException.<init>(String, String)"})
  public void testNewWebHookParseException_whenComponent() {
    // Arrange and Act
    WebHookParseException actualWebHookParseException =
        new WebHookParseException("Component", "An error occurred");

    // Assert
    assertEquals(
        "\n"
            + "Component: Component\n"
            + "Message: An error occurred\n"
            + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualWebHookParseException.getLocalizedMessage());
    assertEquals(
        "\n"
            + "Component: Component\n"
            + "Message: An error occurred\n"
            + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualWebHookParseException.getMessage());
    assertNull(actualWebHookParseException.getCause());
    assertEquals(0, actualWebHookParseException.getSuppressed().length);
  }

  /**
   * Test {@link WebHookParseException#WebHookParseException(String, String)}.
   *
   * <ul>
   *   <li>When {@code Component}.
   * </ul>
   *
   * <p>Method under test: {@link WebHookParseException#WebHookParseException(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"void WebHookParseException.<init>(String, String)"})
  public void testNewWebHookParseException_whenComponent2() {
    // Arrange and Act
    WebHookParseException actualWebHookParseException = new WebHookParseException("Component", "");

    // Assert
    assertEquals(
        "\n"
            + "Component: Component\n"
            + "Message: None\n"
            + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualWebHookParseException.getLocalizedMessage());
    assertEquals(
        "\n"
            + "Component: Component\n"
            + "Message: None\n"
            + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualWebHookParseException.getMessage());
    assertNull(actualWebHookParseException.getCause());
    assertEquals(0, actualWebHookParseException.getSuppressed().length);
  }

  /**
   * Test {@link WebHookParseException#WebHookParseException(String, String, Throwable)}.
   *
   * <ul>
   *   <li>When {@code Component}.
   *   <li>Then return Cause is {@link Throwable#Throwable()}.
   * </ul>
   *
   * <p>Method under test: {@link WebHookParseException#WebHookParseException(String, String,
   * Throwable)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"void WebHookParseException.<init>(String, String, Throwable)"})
  public void testNewWebHookParseException_whenComponent_thenReturnCauseIsThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    WebHookParseException actualWebHookParseException =
        new WebHookParseException("Component", "An error occurred", cause);

    // Assert
    assertEquals(
        "\n"
            + "Component: Component\n"
            + "Message: An error occurred\n"
            + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n"
            + "Stack trace: \n",
        actualWebHookParseException.getLocalizedMessage());
    assertEquals(
        "\n"
            + "Component: Component\n"
            + "Message: An error occurred\n"
            + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n"
            + "Stack trace: \n",
        actualWebHookParseException.getMessage());
    assertSame(cause, actualWebHookParseException.getCause());
  }

  /**
   * Test {@link WebHookParseException#WebHookParseException(String, String, Throwable, String[])}.
   *
   * <ul>
   *   <li>When {@code Component}.
   *   <li>Then return LocalizedMessage is a string.
   * </ul>
   *
   * <p>Method under test: {@link WebHookParseException#WebHookParseException(String, String,
   * Throwable, String[])}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"void WebHookParseException.<init>(String, String, Throwable, String[])"})
  public void testNewWebHookParseException_whenComponent_thenReturnLocalizedMessageIsAString() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    WebHookParseException actualWebHookParseException =
        new WebHookParseException("Component", "An error occurred", cause, new String[] {});

    // Assert
    assertEquals(
        "\n"
            + "Component: Component\n"
            + "Message: An error occurred\n"
            + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n"
            + "Stack trace: \n",
        actualWebHookParseException.getLocalizedMessage());
    assertEquals(
        "\n"
            + "Component: Component\n"
            + "Message: An error occurred\n"
            + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n"
            + "Stack trace: \n",
        actualWebHookParseException.getMessage());
    assertSame(cause, actualWebHookParseException.getCause());
  }

  /**
   * Test {@link WebHookParseException#WebHookParseException(String, String, String[])}.
   *
   * <ul>
   *   <li>When {@code Component}.
   *   <li>Then return LocalizedMessage is a string.
   * </ul>
   *
   * <p>Method under test: {@link WebHookParseException#WebHookParseException(String, String,
   * String[])}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"void WebHookParseException.<init>(String, String, String[])"})
  public void testNewWebHookParseException_whenComponent_thenReturnLocalizedMessageIsAString2() {
    // Arrange and Act
    WebHookParseException actualWebHookParseException =
        new WebHookParseException("Component", "An error occurred", new String[] {});

    // Assert
    assertEquals(
        "\n"
            + "Component: Component\n"
            + "Message: An error occurred\n"
            + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualWebHookParseException.getLocalizedMessage());
    assertEquals(
        "\n"
            + "Component: Component\n"
            + "Message: An error occurred\n"
            + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualWebHookParseException.getMessage());
    assertNull(actualWebHookParseException.getCause());
    assertEquals(0, actualWebHookParseException.getSuppressed().length);
  }

  /**
   * Test {@link WebHookParseException#WebHookParseException(String, String)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link WebHookParseException#WebHookParseException(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"void WebHookParseException.<init>(String, String)"})
  public void testNewWebHookParseException_whenEmptyString() {
    // Arrange and Act
    WebHookParseException actualWebHookParseException =
        new WebHookParseException("", "An error occurred");

    // Assert
    assertEquals(
        "\n"
            + "Component: Unknown\n"
            + "Message: An error occurred\n"
            + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualWebHookParseException.getLocalizedMessage());
    assertEquals(
        "\n"
            + "Component: Unknown\n"
            + "Message: An error occurred\n"
            + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualWebHookParseException.getMessage());
    assertNull(actualWebHookParseException.getCause());
    assertEquals(0, actualWebHookParseException.getSuppressed().length);
  }

  /**
   * Test {@link WebHookParseException#WebHookParseException(String, String, Throwable)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return Cause is {@link Throwable#Throwable()}.
   * </ul>
   *
   * <p>Method under test: {@link WebHookParseException#WebHookParseException(String, String,
   * Throwable)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"void WebHookParseException.<init>(String, String, Throwable)"})
  public void testNewWebHookParseException_whenEmptyString_thenReturnCauseIsThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    WebHookParseException actualWebHookParseException =
        new WebHookParseException("", "An error occurred", cause);

    // Assert
    assertEquals(
        "\n"
            + "Component: Unknown\n"
            + "Message: An error occurred\n"
            + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n"
            + "Stack trace: \n",
        actualWebHookParseException.getLocalizedMessage());
    assertEquals(
        "\n"
            + "Component: Unknown\n"
            + "Message: An error occurred\n"
            + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n"
            + "Stack trace: \n",
        actualWebHookParseException.getMessage());
    assertSame(cause, actualWebHookParseException.getCause());
  }

  /**
   * Test {@link WebHookParseException#WebHookParseException(String, String, Throwable)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return Cause is {@link Throwable#Throwable()}.
   * </ul>
   *
   * <p>Method under test: {@link WebHookParseException#WebHookParseException(String, String,
   * Throwable)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"void WebHookParseException.<init>(String, String, Throwable)"})
  public void testNewWebHookParseException_whenEmptyString_thenReturnCauseIsThrowable2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    WebHookParseException actualWebHookParseException =
        new WebHookParseException("Component", "", cause);

    // Assert
    assertEquals(
        "\n"
            + "Component: Component\n"
            + "Message: None\n"
            + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n"
            + "Stack trace: \n",
        actualWebHookParseException.getLocalizedMessage());
    assertEquals(
        "\n"
            + "Component: Component\n"
            + "Message: None\n"
            + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n"
            + "Stack trace: \n",
        actualWebHookParseException.getMessage());
    assertSame(cause, actualWebHookParseException.getCause());
  }

  /**
   * Test {@link WebHookParseException#WebHookParseException(String, String, Throwable)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return Cause is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link WebHookParseException#WebHookParseException(String, String,
   * Throwable)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"void WebHookParseException.<init>(String, String, Throwable)"})
  public void testNewWebHookParseException_whenNull_thenReturnCauseIsNull() {
    // Arrange and Act
    WebHookParseException actualWebHookParseException =
        new WebHookParseException("Component", "An error occurred", (Throwable) null);

    // Assert
    assertEquals(
        "\n"
            + "Component: Component\n"
            + "Message: An error occurred\n"
            + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualWebHookParseException.getLocalizedMessage());
    assertEquals(
        "\n"
            + "Component: Component\n"
            + "Message: An error occurred\n"
            + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualWebHookParseException.getMessage());
    assertNull(actualWebHookParseException.getCause());
    assertEquals(0, actualWebHookParseException.getSuppressed().length);
  }
}
