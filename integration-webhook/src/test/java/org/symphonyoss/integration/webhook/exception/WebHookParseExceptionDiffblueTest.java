package org.symphonyoss.integration.webhook.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;

public class WebHookParseExceptionDiffblueTest {
  /**
   * Test {@link WebHookParseException#WebHookParseException(String, String, Throwable, String[])}.
   * <p>
   * Method under test: {@link WebHookParseException#WebHookParseException(String, String, Throwable, String[])}
   */
  @Test
  @MethodsUnderTest({"void WebHookParseException.<init>(String, String, Throwable, String[])"})
  public void testNewWebHookParseException() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    WebHookParseException actualWebHookParseException = new WebHookParseException("Component", "An error occurred",
        cause, "Solutions");

    // Assert
    assertEquals("\nComponent: Component\nMessage: An error occurred\nSolutions: \nSolutions\nStack trace: \n",
        actualWebHookParseException.getLocalizedMessage());
    assertEquals("\nComponent: Component\nMessage: An error occurred\nSolutions: \nSolutions\nStack trace: \n",
        actualWebHookParseException.getMessage());
    assertSame(cause, actualWebHookParseException.getCause());
  }

  /**
   * Test {@link WebHookParseException#WebHookParseException(String, String, String[])}.
   * <p>
   * Method under test: {@link WebHookParseException#WebHookParseException(String, String, String[])}
   */
  @Test
  @MethodsUnderTest({"void WebHookParseException.<init>(String, String, String[])"})
  public void testNewWebHookParseException2() {
    // Arrange and Act
    WebHookParseException actualWebHookParseException = new WebHookParseException("Component", "An error occurred",
        "Solutions");

    // Assert
    assertEquals("\nComponent: Component\nMessage: An error occurred\nSolutions: \nSolutions\n",
        actualWebHookParseException.getLocalizedMessage());
    assertEquals("\nComponent: Component\nMessage: An error occurred\nSolutions: \nSolutions\n",
        actualWebHookParseException.getMessage());
    assertNull(actualWebHookParseException.getCause());
    assertEquals(0, actualWebHookParseException.getSuppressed().length);
  }

  /**
   * Test {@link WebHookParseException#WebHookParseException(String, String)}.
   * <ul>
   *   <li>When {@code Component}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebHookParseException#WebHookParseException(String, String)}
   */
  @Test
  @MethodsUnderTest({"void WebHookParseException.<init>(String, String)"})
  public void testNewWebHookParseException_whenComponent() {
    // Arrange and Act
    WebHookParseException actualWebHookParseException = new WebHookParseException("Component", "An error occurred");

    // Assert
    assertEquals(
        "\n" + "Component: Component\n" + "Message: An error occurred\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualWebHookParseException.getLocalizedMessage());
    assertEquals(
        "\n" + "Component: Component\n" + "Message: An error occurred\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualWebHookParseException.getMessage());
    assertNull(actualWebHookParseException.getCause());
    assertEquals(0, actualWebHookParseException.getSuppressed().length);
  }

  /**
   * Test {@link WebHookParseException#WebHookParseException(String, String, Throwable)}.
   * <ul>
   *   <li>When {@code Component}.</li>
   *   <li>Then return Cause is {@link Throwable#Throwable()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebHookParseException#WebHookParseException(String, String, Throwable)}
   */
  @Test
  @MethodsUnderTest({"void WebHookParseException.<init>(String, String, Throwable)"})
  public void testNewWebHookParseException_whenComponent_thenReturnCauseIsThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    WebHookParseException actualWebHookParseException = new WebHookParseException("Component", "An error occurred",
        cause);

    // Assert
    assertEquals(
        "\n" + "Component: Component\n" + "Message: An error occurred\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n" + "Stack trace: \n",
        actualWebHookParseException.getLocalizedMessage());
    assertEquals(
        "\n" + "Component: Component\n" + "Message: An error occurred\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n" + "Stack trace: \n",
        actualWebHookParseException.getMessage());
    assertSame(cause, actualWebHookParseException.getCause());
  }

  /**
   * Test {@link WebHookParseException#WebHookParseException(String, String, Throwable, String[])}.
   * <ul>
   *   <li>When {@code Component}.</li>
   *   <li>Then return LocalizedMessage is a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebHookParseException#WebHookParseException(String, String, Throwable, String[])}
   */
  @Test
  @MethodsUnderTest({"void WebHookParseException.<init>(String, String, Throwable, String[])"})
  public void testNewWebHookParseException_whenComponent_thenReturnLocalizedMessageIsAString() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    WebHookParseException actualWebHookParseException = new WebHookParseException("Component", "An error occurred",
        cause, new String[]{});

    // Assert
    assertEquals(
        "\n" + "Component: Component\n" + "Message: An error occurred\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n" + "Stack trace: \n",
        actualWebHookParseException.getLocalizedMessage());
    assertEquals(
        "\n" + "Component: Component\n" + "Message: An error occurred\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n" + "Stack trace: \n",
        actualWebHookParseException.getMessage());
    assertSame(cause, actualWebHookParseException.getCause());
  }

  /**
   * Test {@link WebHookParseException#WebHookParseException(String, String, String[])}.
   * <ul>
   *   <li>When {@code Component}.</li>
   *   <li>Then return LocalizedMessage is a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebHookParseException#WebHookParseException(String, String, String[])}
   */
  @Test
  @MethodsUnderTest({"void WebHookParseException.<init>(String, String, String[])"})
  public void testNewWebHookParseException_whenComponent_thenReturnLocalizedMessageIsAString2() {
    // Arrange and Act
    WebHookParseException actualWebHookParseException = new WebHookParseException("Component", "An error occurred",
        new String[]{});

    // Assert
    assertEquals(
        "\n" + "Component: Component\n" + "Message: An error occurred\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualWebHookParseException.getLocalizedMessage());
    assertEquals(
        "\n" + "Component: Component\n" + "Message: An error occurred\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualWebHookParseException.getMessage());
    assertNull(actualWebHookParseException.getCause());
    assertEquals(0, actualWebHookParseException.getSuppressed().length);
  }

  /**
   * Test {@link WebHookParseException#WebHookParseException(String, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebHookParseException#WebHookParseException(String, String)}
   */
  @Test
  @MethodsUnderTest({"void WebHookParseException.<init>(String, String)"})
  public void testNewWebHookParseException_whenNull() {
    // Arrange and Act
    WebHookParseException actualWebHookParseException = new WebHookParseException(null, null);

    // Assert
    assertEquals(
        "\n" + "Component: Unknown\n" + "Message: None\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualWebHookParseException.getLocalizedMessage());
    assertEquals(
        "\n" + "Component: Unknown\n" + "Message: None\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualWebHookParseException.getMessage());
    assertNull(actualWebHookParseException.getCause());
    assertEquals(0, actualWebHookParseException.getSuppressed().length);
  }

  /**
   * Test {@link WebHookParseException#WebHookParseException(String, String, Throwable)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return Cause is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebHookParseException#WebHookParseException(String, String, Throwable)}
   */
  @Test
  @MethodsUnderTest({"void WebHookParseException.<init>(String, String, Throwable)"})
  public void testNewWebHookParseException_whenNull_thenReturnCauseIsNull() {
    // Arrange and Act
    WebHookParseException actualWebHookParseException = new WebHookParseException(null, null, (Throwable) null);

    // Assert
    assertEquals(
        "\n" + "Component: Unknown\n" + "Message: None\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualWebHookParseException.getLocalizedMessage());
    assertEquals(
        "\n" + "Component: Unknown\n" + "Message: None\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualWebHookParseException.getMessage());
    assertNull(actualWebHookParseException.getCause());
    assertEquals(0, actualWebHookParseException.getSuppressed().length);
  }

  /**
   * Test {@link WebHookParseException#WebHookParseException(String, String, Throwable, String[])}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return Cause is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebHookParseException#WebHookParseException(String, String, Throwable, String[])}
   */
  @Test
  @MethodsUnderTest({"void WebHookParseException.<init>(String, String, Throwable, String[])"})
  public void testNewWebHookParseException_whenNull_thenReturnCauseIsNull2() {
    // Arrange and Act
    WebHookParseException actualWebHookParseException = new WebHookParseException(null, null, null, null);

    // Assert
    assertEquals(
        "\n" + "Component: Unknown\n" + "Message: None\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualWebHookParseException.getLocalizedMessage());
    assertEquals(
        "\n" + "Component: Unknown\n" + "Message: None\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualWebHookParseException.getMessage());
    assertNull(actualWebHookParseException.getCause());
    assertEquals(0, actualWebHookParseException.getSuppressed().length);
  }

  /**
   * Test {@link WebHookParseException#WebHookParseException(String, String, String[])}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return LocalizedMessage is a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebHookParseException#WebHookParseException(String, String, String[])}
   */
  @Test
  @MethodsUnderTest({"void WebHookParseException.<init>(String, String, String[])"})
  public void testNewWebHookParseException_whenNull_thenReturnLocalizedMessageIsAString() {
    // Arrange and Act
    WebHookParseException actualWebHookParseException = new WebHookParseException(null, null, (String[]) null);

    // Assert
    assertEquals(
        "\n" + "Component: Unknown\n" + "Message: None\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualWebHookParseException.getLocalizedMessage());
    assertEquals(
        "\n" + "Component: Unknown\n" + "Message: None\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualWebHookParseException.getMessage());
    assertNull(actualWebHookParseException.getCause());
    assertEquals(0, actualWebHookParseException.getSuppressed().length);
  }
}
