package org.symphonyoss.integration.webhook.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import org.junit.Test;

public class WebHookParseExceptionDiffblueTest {
  /**
   * Method under test:
   * {@link WebHookParseException#WebHookParseException(String, String)}
   */
  @Test
  public void testNewWebHookParseException() {
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
   * Method under test:
   * {@link WebHookParseException#WebHookParseException(String, String)}
   */
  @Test
  public void testNewWebHookParseException2() {
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
   * Method under test:
   * {@link WebHookParseException#WebHookParseException(String, String, Throwable)}
   */
  @Test
  public void testNewWebHookParseException3() {
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
    assertEquals(0, actualWebHookParseException.getSuppressed().length);
    assertSame(cause, actualWebHookParseException.getCause());
  }

  /**
   * Method under test:
   * {@link WebHookParseException#WebHookParseException(String, String, Throwable)}
   */
  @Test
  public void testNewWebHookParseException4() {
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
   * Method under test:
   * {@link WebHookParseException#WebHookParseException(String, String, Throwable, String[])}
   */
  @Test
  public void testNewWebHookParseException5() {
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
    assertEquals(0, actualWebHookParseException.getSuppressed().length);
    assertSame(cause, actualWebHookParseException.getCause());
  }

  /**
   * Method under test:
   * {@link WebHookParseException#WebHookParseException(String, String, Throwable, String[])}
   */
  @Test
  public void testNewWebHookParseException6() {
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
   * Method under test:
   * {@link WebHookParseException#WebHookParseException(String, String, Throwable, String[])}
   */
  @Test
  public void testNewWebHookParseException7() {
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
    assertEquals(0, actualWebHookParseException.getSuppressed().length);
    assertSame(cause, actualWebHookParseException.getCause());
  }

  /**
   * Method under test:
   * {@link WebHookParseException#WebHookParseException(String, String, String[])}
   */
  @Test
  public void testNewWebHookParseException8() {
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
   * Method under test:
   * {@link WebHookParseException#WebHookParseException(String, String, String[])}
   */
  @Test
  public void testNewWebHookParseException9() {
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

  /**
   * Method under test:
   * {@link WebHookParseException#WebHookParseException(String, String, String[])}
   */
  @Test
  public void testNewWebHookParseException10() {
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
}
