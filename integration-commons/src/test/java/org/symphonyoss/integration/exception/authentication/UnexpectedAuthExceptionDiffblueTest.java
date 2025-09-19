package org.symphonyoss.integration.exception.authentication;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;

public class UnexpectedAuthExceptionDiffblueTest {
  /**
   * Test {@link UnexpectedAuthException#UnexpectedAuthException(String)}.
   *
   * <p>Method under test: {@link UnexpectedAuthException#UnexpectedAuthException(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"void UnexpectedAuthException.<init>(String)"})
  public void testNewUnexpectedAuthException() {
    // Arrange and Act
    UnexpectedAuthException actualUnexpectedAuthException =
        new UnexpectedAuthException("0123456789ABCDEF");

    // Assert
    assertEquals(
        "\n"
            + "Component: Authentication Proxy\n"
            + "Message: 0123456789ABCDEF\n"
            + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualUnexpectedAuthException.getLocalizedMessage());
    assertEquals(
        "\n"
            + "Component: Authentication Proxy\n"
            + "Message: 0123456789ABCDEF\n"
            + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualUnexpectedAuthException.getMessage());
    assertNull(actualUnexpectedAuthException.getCause());
    assertEquals(0, actualUnexpectedAuthException.getSuppressed().length);
  }

  /**
   * Test {@link UnexpectedAuthException#UnexpectedAuthException(String, Throwable)}.
   *
   * <p>Method under test: {@link UnexpectedAuthException#UnexpectedAuthException(String,
   * Throwable)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"void UnexpectedAuthException.<init>(String, Throwable)"})
  public void testNewUnexpectedAuthException2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    UnexpectedAuthException actualUnexpectedAuthException =
        new UnexpectedAuthException("0123456789ABCDEF", cause);

    // Assert
    assertEquals(
        "\n"
            + "Component: Authentication Proxy\n"
            + "Message: 0123456789ABCDEF\n"
            + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n"
            + "Stack trace: \n",
        actualUnexpectedAuthException.getLocalizedMessage());
    assertEquals(
        "\n"
            + "Component: Authentication Proxy\n"
            + "Message: 0123456789ABCDEF\n"
            + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n"
            + "Stack trace: \n",
        actualUnexpectedAuthException.getMessage());
    assertEquals(0, actualUnexpectedAuthException.getSuppressed().length);
    assertSame(cause, actualUnexpectedAuthException.getCause());
  }

  /**
   * Test {@link UnexpectedAuthException#UnexpectedAuthException(String, Throwable, String[])}.
   *
   * <p>Method under test: {@link UnexpectedAuthException#UnexpectedAuthException(String, Throwable,
   * String[])}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"void UnexpectedAuthException.<init>(String, Throwable, String[])"})
  public void testNewUnexpectedAuthException3() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    UnexpectedAuthException actualUnexpectedAuthException =
        new UnexpectedAuthException("0123456789ABCDEF", cause, "0123456789ABCDEF");

    // Assert
    assertEquals(
        "\n"
            + "Component: Authentication Proxy\n"
            + "Message: 0123456789ABCDEF\n"
            + "Solutions: \n"
            + "0123456789ABCDEF\n"
            + "Stack trace: \n",
        actualUnexpectedAuthException.getLocalizedMessage());
    assertEquals(
        "\n"
            + "Component: Authentication Proxy\n"
            + "Message: 0123456789ABCDEF\n"
            + "Solutions: \n"
            + "0123456789ABCDEF\n"
            + "Stack trace: \n",
        actualUnexpectedAuthException.getMessage());
    assertEquals(0, actualUnexpectedAuthException.getSuppressed().length);
    assertSame(cause, actualUnexpectedAuthException.getCause());
  }
}
