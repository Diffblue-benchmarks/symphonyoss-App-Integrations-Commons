package org.symphonyoss.integration.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import org.junit.Test;

public class RemoteApiExceptionDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RemoteApiException#getCode()}
   *   <li>{@link RemoteApiException#getResponseMessage()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    RemoteApiException remoteApiException = new RemoteApiException(1, "An error occurred");

    // Act
    int actualCode = remoteApiException.getCode();

    // Assert
    assertEquals("An error occurred", remoteApiException.getResponseMessage());
    assertEquals(1, actualCode);
  }

  /**
   * Method under test:
   * {@link RemoteApiException#RemoteApiException(int, Exception)}
   */
  @Test
  public void testNewRemoteApiException() {
    // Arrange
    Exception e = new Exception("foo");

    // Act
    RemoteApiException actualRemoteApiException = new RemoteApiException(1, e);

    // Assert
    assertEquals(
        "\n" + "Component: Commons\n" + "Message: foo\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n" + "Stack trace: foo\n",
        actualRemoteApiException.getLocalizedMessage());
    assertEquals(
        "\n" + "Component: Commons\n" + "Message: foo\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n" + "Stack trace: foo\n",
        actualRemoteApiException.getMessage());
    assertNull(actualRemoteApiException.getResponseMessage());
    assertEquals(0, actualRemoteApiException.getSuppressed().length);
    assertEquals(1, actualRemoteApiException.getCode());
    assertSame(e, actualRemoteApiException.getCause());
  }

  /**
   * Method under test:
   * {@link RemoteApiException#RemoteApiException(int, Exception)}
   */
  @Test
  public void testNewRemoteApiException2() {
    // Arrange
    Exception e = new Exception("");

    // Act
    RemoteApiException actualRemoteApiException = new RemoteApiException(1, e);

    // Assert
    assertEquals(
        "\n" + "Component: Commons\n" + "Message: None\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n" + "Stack trace: \n",
        actualRemoteApiException.getLocalizedMessage());
    assertEquals(
        "\n" + "Component: Commons\n" + "Message: None\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n" + "Stack trace: \n",
        actualRemoteApiException.getMessage());
    assertNull(actualRemoteApiException.getResponseMessage());
    assertEquals(0, actualRemoteApiException.getSuppressed().length);
    assertEquals(1, actualRemoteApiException.getCode());
    assertSame(e, actualRemoteApiException.getCause());
  }

  /**
   * Method under test:
   * {@link RemoteApiException#RemoteApiException(int, Exception, String[])}
   */
  @Test
  public void testNewRemoteApiException3() {
    // Arrange
    Exception e = new Exception("foo");

    // Act
    RemoteApiException actualRemoteApiException = new RemoteApiException(1, e, "Solutions");

    // Assert
    assertEquals("\nComponent: Commons\nMessage: foo\nSolutions: \nSolutions\nStack trace: foo\n",
        actualRemoteApiException.getLocalizedMessage());
    assertEquals("\nComponent: Commons\nMessage: foo\nSolutions: \nSolutions\nStack trace: foo\n",
        actualRemoteApiException.getMessage());
    assertNull(actualRemoteApiException.getResponseMessage());
    assertEquals(0, actualRemoteApiException.getSuppressed().length);
    assertEquals(1, actualRemoteApiException.getCode());
    assertSame(e, actualRemoteApiException.getCause());
  }

  /**
   * Method under test:
   * {@link RemoteApiException#RemoteApiException(int, Exception, String[])}
   */
  @Test
  public void testNewRemoteApiException4() {
    // Arrange
    Exception e = new Exception("foo");

    // Act
    RemoteApiException actualRemoteApiException = new RemoteApiException(1, e, null);

    // Assert
    assertEquals(
        "\n" + "Component: Commons\n" + "Message: foo\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n" + "Stack trace: foo\n",
        actualRemoteApiException.getLocalizedMessage());
    assertEquals(
        "\n" + "Component: Commons\n" + "Message: foo\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n" + "Stack trace: foo\n",
        actualRemoteApiException.getMessage());
    assertNull(actualRemoteApiException.getResponseMessage());
    assertEquals(0, actualRemoteApiException.getSuppressed().length);
    assertEquals(1, actualRemoteApiException.getCode());
    assertSame(e, actualRemoteApiException.getCause());
  }

  /**
   * Method under test:
   * {@link RemoteApiException#RemoteApiException(int, Exception, String[])}
   */
  @Test
  public void testNewRemoteApiException5() {
    // Arrange
    Exception e = new Exception("");

    // Act
    RemoteApiException actualRemoteApiException = new RemoteApiException(1, e, "Solutions");

    // Assert
    assertEquals("\nComponent: Commons\nMessage: None\nSolutions: \nSolutions\nStack trace: \n",
        actualRemoteApiException.getLocalizedMessage());
    assertEquals("\nComponent: Commons\nMessage: None\nSolutions: \nSolutions\nStack trace: \n",
        actualRemoteApiException.getMessage());
    assertNull(actualRemoteApiException.getResponseMessage());
    assertEquals(0, actualRemoteApiException.getSuppressed().length);
    assertEquals(1, actualRemoteApiException.getCode());
    assertSame(e, actualRemoteApiException.getCause());
  }

  /**
   * Method under test:
   * {@link RemoteApiException#RemoteApiException(int, Exception, String[])}
   */
  @Test
  public void testNewRemoteApiException6() {
    // Arrange
    Exception e = new Exception("foo");

    // Act
    RemoteApiException actualRemoteApiException = new RemoteApiException(1, e);

    // Assert
    assertEquals(
        "\n" + "Component: Commons\n" + "Message: foo\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n" + "Stack trace: foo\n",
        actualRemoteApiException.getLocalizedMessage());
    assertEquals(
        "\n" + "Component: Commons\n" + "Message: foo\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n" + "Stack trace: foo\n",
        actualRemoteApiException.getMessage());
    assertNull(actualRemoteApiException.getResponseMessage());
    assertEquals(0, actualRemoteApiException.getSuppressed().length);
    assertEquals(1, actualRemoteApiException.getCode());
    assertSame(e, actualRemoteApiException.getCause());
  }

  /**
   * Method under test: {@link RemoteApiException#RemoteApiException(int, String)}
   */
  @Test
  public void testNewRemoteApiException7() {
    // Arrange and Act
    RemoteApiException actualRemoteApiException = new RemoteApiException(1, "An error occurred");

    // Assert
    assertEquals("An error occurred", actualRemoteApiException.getResponseMessage());
    assertEquals(
        "\n" + "Component: Commons\n" + "Message: An error occurred\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualRemoteApiException.getLocalizedMessage());
    assertEquals(
        "\n" + "Component: Commons\n" + "Message: An error occurred\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualRemoteApiException.getMessage());
    assertNull(actualRemoteApiException.getCause());
    assertEquals(0, actualRemoteApiException.getSuppressed().length);
    assertEquals(1, actualRemoteApiException.getCode());
  }

  /**
   * Method under test: {@link RemoteApiException#RemoteApiException(int, String)}
   */
  @Test
  public void testNewRemoteApiException8() {
    // Arrange and Act
    RemoteApiException actualRemoteApiException = new RemoteApiException(1, (String) null);

    // Assert
    assertEquals(
        "\n" + "Component: Commons\n" + "Message: None\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualRemoteApiException.getLocalizedMessage());
    assertEquals(
        "\n" + "Component: Commons\n" + "Message: None\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualRemoteApiException.getMessage());
    assertNull(actualRemoteApiException.getResponseMessage());
    assertNull(actualRemoteApiException.getCause());
    assertEquals(0, actualRemoteApiException.getSuppressed().length);
    assertEquals(1, actualRemoteApiException.getCode());
  }

  /**
   * Method under test:
   * {@link RemoteApiException#RemoteApiException(int, String, Exception)}
   */
  @Test
  public void testNewRemoteApiException9() {
    // Arrange
    Exception e = new Exception("foo");

    // Act
    RemoteApiException actualRemoteApiException = new RemoteApiException(1, "An error occurred", e);

    // Assert
    assertEquals("An error occurred", actualRemoteApiException.getResponseMessage());
    assertEquals(
        "\n" + "Component: Commons\n" + "Message: An error occurred\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n" + "Stack trace: foo\n",
        actualRemoteApiException.getLocalizedMessage());
    assertEquals(
        "\n" + "Component: Commons\n" + "Message: An error occurred\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n" + "Stack trace: foo\n",
        actualRemoteApiException.getMessage());
    assertEquals(0, actualRemoteApiException.getSuppressed().length);
    assertEquals(1, actualRemoteApiException.getCode());
    assertSame(e, actualRemoteApiException.getCause());
  }

  /**
   * Method under test:
   * {@link RemoteApiException#RemoteApiException(int, String, Exception)}
   */
  @Test
  public void testNewRemoteApiException10() {
    // Arrange and Act
    RemoteApiException actualRemoteApiException = new RemoteApiException(1, (String) null, (Exception) null);

    // Assert
    assertEquals(
        "\n" + "Component: Commons\n" + "Message: None\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualRemoteApiException.getLocalizedMessage());
    assertEquals(
        "\n" + "Component: Commons\n" + "Message: None\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualRemoteApiException.getMessage());
    assertNull(actualRemoteApiException.getResponseMessage());
    assertNull(actualRemoteApiException.getCause());
    assertEquals(0, actualRemoteApiException.getSuppressed().length);
    assertEquals(1, actualRemoteApiException.getCode());
  }

  /**
   * Method under test:
   * {@link RemoteApiException#RemoteApiException(int, String, Exception, String[])}
   */
  @Test
  public void testNewRemoteApiException11() {
    // Arrange
    Exception e = new Exception("foo");

    // Act
    RemoteApiException actualRemoteApiException = new RemoteApiException(1, "An error occurred", e, "Solutions");

    // Assert
    assertEquals("An error occurred", actualRemoteApiException.getResponseMessage());
    assertEquals("\nComponent: Commons\nMessage: An error occurred\nSolutions: \nSolutions\nStack trace: foo\n",
        actualRemoteApiException.getLocalizedMessage());
    assertEquals("\nComponent: Commons\nMessage: An error occurred\nSolutions: \nSolutions\nStack trace: foo\n",
        actualRemoteApiException.getMessage());
    assertEquals(0, actualRemoteApiException.getSuppressed().length);
    assertEquals(1, actualRemoteApiException.getCode());
    assertSame(e, actualRemoteApiException.getCause());
  }

  /**
   * Method under test:
   * {@link RemoteApiException#RemoteApiException(int, String, Exception, String[])}
   */
  @Test
  public void testNewRemoteApiException12() {
    // Arrange and Act
    RemoteApiException actualRemoteApiException = new RemoteApiException(1, null, null, null);

    // Assert
    assertEquals(
        "\n" + "Component: Commons\n" + "Message: None\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualRemoteApiException.getLocalizedMessage());
    assertEquals(
        "\n" + "Component: Commons\n" + "Message: None\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualRemoteApiException.getMessage());
    assertNull(actualRemoteApiException.getResponseMessage());
    assertNull(actualRemoteApiException.getCause());
    assertEquals(0, actualRemoteApiException.getSuppressed().length);
    assertEquals(1, actualRemoteApiException.getCode());
  }

  /**
   * Method under test:
   * {@link RemoteApiException#RemoteApiException(int, String, Exception, String[])}
   */
  @Test
  public void testNewRemoteApiException13() {
    // Arrange
    Exception e = new Exception("foo");

    // Act
    RemoteApiException actualRemoteApiException = new RemoteApiException(1, "An error occurred", e);

    // Assert
    assertEquals("An error occurred", actualRemoteApiException.getResponseMessage());
    assertEquals(
        "\n" + "Component: Commons\n" + "Message: An error occurred\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n" + "Stack trace: foo\n",
        actualRemoteApiException.getLocalizedMessage());
    assertEquals(
        "\n" + "Component: Commons\n" + "Message: An error occurred\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n" + "Stack trace: foo\n",
        actualRemoteApiException.getMessage());
    assertEquals(0, actualRemoteApiException.getSuppressed().length);
    assertEquals(1, actualRemoteApiException.getCode());
    assertSame(e, actualRemoteApiException.getCause());
  }

  /**
   * Method under test:
   * {@link RemoteApiException#RemoteApiException(int, String, String[])}
   */
  @Test
  public void testNewRemoteApiException14() {
    // Arrange and Act
    RemoteApiException actualRemoteApiException = new RemoteApiException(1, "An error occurred", "Solutions");

    // Assert
    assertEquals("An error occurred", actualRemoteApiException.getResponseMessage());
    assertEquals("\nComponent: Commons\nMessage: An error occurred\nSolutions: \nSolutions\n",
        actualRemoteApiException.getLocalizedMessage());
    assertEquals("\nComponent: Commons\nMessage: An error occurred\nSolutions: \nSolutions\n",
        actualRemoteApiException.getMessage());
    assertNull(actualRemoteApiException.getCause());
    assertEquals(0, actualRemoteApiException.getSuppressed().length);
    assertEquals(1, actualRemoteApiException.getCode());
  }

  /**
   * Method under test:
   * {@link RemoteApiException#RemoteApiException(int, String, String[])}
   */
  @Test
  public void testNewRemoteApiException15() {
    // Arrange and Act
    RemoteApiException actualRemoteApiException = new RemoteApiException(1, (String) null, (String[]) null);

    // Assert
    assertEquals(
        "\n" + "Component: Commons\n" + "Message: None\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualRemoteApiException.getLocalizedMessage());
    assertEquals(
        "\n" + "Component: Commons\n" + "Message: None\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualRemoteApiException.getMessage());
    assertNull(actualRemoteApiException.getResponseMessage());
    assertNull(actualRemoteApiException.getCause());
    assertEquals(0, actualRemoteApiException.getSuppressed().length);
    assertEquals(1, actualRemoteApiException.getCode());
  }

  /**
   * Method under test:
   * {@link RemoteApiException#RemoteApiException(int, String, String[])}
   */
  @Test
  public void testNewRemoteApiException16() {
    // Arrange and Act
    RemoteApiException actualRemoteApiException = new RemoteApiException(1, "An error occurred");

    // Assert
    assertEquals("An error occurred", actualRemoteApiException.getResponseMessage());
    assertEquals(
        "\n" + "Component: Commons\n" + "Message: An error occurred\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualRemoteApiException.getLocalizedMessage());
    assertEquals(
        "\n" + "Component: Commons\n" + "Message: An error occurred\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualRemoteApiException.getMessage());
    assertNull(actualRemoteApiException.getCause());
    assertEquals(0, actualRemoteApiException.getSuppressed().length);
    assertEquals(1, actualRemoteApiException.getCode());
  }
}
