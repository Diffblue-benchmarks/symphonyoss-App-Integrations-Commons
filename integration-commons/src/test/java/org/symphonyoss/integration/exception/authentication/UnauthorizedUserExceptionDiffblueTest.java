package org.symphonyoss.integration.exception.authentication;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import org.junit.Test;

public class UnauthorizedUserExceptionDiffblueTest {
  /**
   * Method under test:
   * {@link UnauthorizedUserException#UnauthorizedUserException(String)}
   */
  @Test
  public void testNewUnauthorizedUserException() {
    // Arrange and Act
    UnauthorizedUserException actualUnauthorizedUserException = new UnauthorizedUserException("An error occurred");

    // Assert
    assertEquals(
        "\n" + "Component: Authentication Proxy\n" + "Message: An error occurred\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualUnauthorizedUserException.getLocalizedMessage());
    assertEquals(
        "\n" + "Component: Authentication Proxy\n" + "Message: An error occurred\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualUnauthorizedUserException.getMessage());
    assertNull(actualUnauthorizedUserException.getCause());
    assertEquals(0, actualUnauthorizedUserException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link UnauthorizedUserException#UnauthorizedUserException(String, Throwable)}
   */
  @Test
  public void testNewUnauthorizedUserException2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    UnauthorizedUserException actualUnauthorizedUserException = new UnauthorizedUserException("An error occurred",
        cause);

    // Assert
    assertEquals(
        "\n" + "Component: Authentication Proxy\n" + "Message: An error occurred\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n" + "Stack trace: \n",
        actualUnauthorizedUserException.getLocalizedMessage());
    assertEquals(
        "\n" + "Component: Authentication Proxy\n" + "Message: An error occurred\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n" + "Stack trace: \n",
        actualUnauthorizedUserException.getMessage());
    assertEquals(0, actualUnauthorizedUserException.getSuppressed().length);
    assertSame(cause, actualUnauthorizedUserException.getCause());
  }

  /**
   * Method under test:
   * {@link UnauthorizedUserException#UnauthorizedUserException(String, Throwable, String[])}
   */
  @Test
  public void testNewUnauthorizedUserException3() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    UnauthorizedUserException actualUnauthorizedUserException = new UnauthorizedUserException("An error occurred",
        cause, "Solutions");

    // Assert
    assertEquals(
        "\nComponent: Authentication Proxy\nMessage: An error occurred\nSolutions: \nSolutions\nStack trace: \n",
        actualUnauthorizedUserException.getLocalizedMessage());
    assertEquals(
        "\nComponent: Authentication Proxy\nMessage: An error occurred\nSolutions: \nSolutions\nStack trace: \n",
        actualUnauthorizedUserException.getMessage());
    assertEquals(0, actualUnauthorizedUserException.getSuppressed().length);
    assertSame(cause, actualUnauthorizedUserException.getCause());
  }

  /**
   * Method under test:
   * {@link UnauthorizedUserException#UnauthorizedUserException(String, String[])}
   */
  @Test
  public void testNewUnauthorizedUserException4() {
    // Arrange and Act
    UnauthorizedUserException actualUnauthorizedUserException = new UnauthorizedUserException("An error occurred",
        "Solutions");

    // Assert
    assertEquals("\nComponent: Authentication Proxy\nMessage: An error occurred\nSolutions: \nSolutions\n",
        actualUnauthorizedUserException.getLocalizedMessage());
    assertEquals("\nComponent: Authentication Proxy\nMessage: An error occurred\nSolutions: \nSolutions\n",
        actualUnauthorizedUserException.getMessage());
    assertNull(actualUnauthorizedUserException.getCause());
    assertEquals(0, actualUnauthorizedUserException.getSuppressed().length);
  }
}
