package org.symphonyoss.integration.exception.authentication;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;

public class UnauthorizedUserExceptionDiffblueTest {
  /**
   * Test {@link UnauthorizedUserException#UnauthorizedUserException(String)}.
   *
   * <p>Method under test: {@link UnauthorizedUserException#UnauthorizedUserException(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"void UnauthorizedUserException.<init>(String)"})
  public void testNewUnauthorizedUserException() {
    // Arrange and Act
    UnauthorizedUserException actualUnauthorizedUserException =
        new UnauthorizedUserException("An error occurred");

    // Assert
    assertEquals(
        "\n"
            + "Component: Authentication Proxy\n"
            + "Message: An error occurred\n"
            + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualUnauthorizedUserException.getLocalizedMessage());
    assertEquals(
        "\n"
            + "Component: Authentication Proxy\n"
            + "Message: An error occurred\n"
            + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualUnauthorizedUserException.getMessage());
    assertNull(actualUnauthorizedUserException.getCause());
    assertEquals(0, actualUnauthorizedUserException.getSuppressed().length);
  }

  /**
   * Test {@link UnauthorizedUserException#UnauthorizedUserException(String, Throwable)}.
   *
   * <p>Method under test: {@link UnauthorizedUserException#UnauthorizedUserException(String,
   * Throwable)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"void UnauthorizedUserException.<init>(String, Throwable)"})
  public void testNewUnauthorizedUserException2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    UnauthorizedUserException actualUnauthorizedUserException =
        new UnauthorizedUserException("An error occurred", cause);

    // Assert
    assertEquals(
        "\n"
            + "Component: Authentication Proxy\n"
            + "Message: An error occurred\n"
            + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n"
            + "Stack trace: \n",
        actualUnauthorizedUserException.getLocalizedMessage());
    assertEquals(
        "\n"
            + "Component: Authentication Proxy\n"
            + "Message: An error occurred\n"
            + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n"
            + "Stack trace: \n",
        actualUnauthorizedUserException.getMessage());
    assertEquals(0, actualUnauthorizedUserException.getSuppressed().length);
    assertSame(cause, actualUnauthorizedUserException.getCause());
  }

  /**
   * Test {@link UnauthorizedUserException#UnauthorizedUserException(String, Throwable, String[])}.
   *
   * <p>Method under test: {@link UnauthorizedUserException#UnauthorizedUserException(String,
   * Throwable, String[])}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"void UnauthorizedUserException.<init>(String, Throwable, String[])"})
  public void testNewUnauthorizedUserException3() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    UnauthorizedUserException actualUnauthorizedUserException =
        new UnauthorizedUserException("An error occurred", cause, "Solutions");

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
   * Test {@link UnauthorizedUserException#UnauthorizedUserException(String, String[])}.
   *
   * <p>Method under test: {@link UnauthorizedUserException#UnauthorizedUserException(String,
   * String[])}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"void UnauthorizedUserException.<init>(String, String[])"})
  public void testNewUnauthorizedUserException4() {
    // Arrange and Act
    UnauthorizedUserException actualUnauthorizedUserException =
        new UnauthorizedUserException("An error occurred", "Solutions");

    // Assert
    assertEquals(
        "\nComponent: Authentication Proxy\nMessage: An error occurred\nSolutions: \nSolutions\n",
        actualUnauthorizedUserException.getLocalizedMessage());
    assertEquals(
        "\nComponent: Authentication Proxy\nMessage: An error occurred\nSolutions: \nSolutions\n",
        actualUnauthorizedUserException.getMessage());
    assertNull(actualUnauthorizedUserException.getCause());
    assertEquals(0, actualUnauthorizedUserException.getSuppressed().length);
  }
}
