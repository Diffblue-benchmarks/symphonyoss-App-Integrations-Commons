package org.symphonyoss.integration.exception.authentication;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;

public class ForbiddenAuthExceptionDiffblueTest {
  /**
   * Test {@link ForbiddenAuthException#ForbiddenAuthException(String)}.
   *
   * <p>Method under test: {@link ForbiddenAuthException#ForbiddenAuthException(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"void ForbiddenAuthException.<init>(String)"})
  public void testNewForbiddenAuthException() {
    // Arrange and Act
    ForbiddenAuthException actualForbiddenAuthException =
        new ForbiddenAuthException("0123456789ABCDEF");

    // Assert
    assertEquals(
        "\n"
            + "Component: Authentication Proxy\n"
            + "Message: 0123456789ABCDEF\n"
            + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualForbiddenAuthException.getLocalizedMessage());
    assertEquals(
        "\n"
            + "Component: Authentication Proxy\n"
            + "Message: 0123456789ABCDEF\n"
            + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualForbiddenAuthException.getMessage());
    assertNull(actualForbiddenAuthException.getCause());
    assertEquals(0, actualForbiddenAuthException.getSuppressed().length);
  }

  /**
   * Test {@link ForbiddenAuthException#ForbiddenAuthException(String, Throwable)}.
   *
   * <p>Method under test: {@link ForbiddenAuthException#ForbiddenAuthException(String, Throwable)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"void ForbiddenAuthException.<init>(String, Throwable)"})
  public void testNewForbiddenAuthException2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    ForbiddenAuthException actualForbiddenAuthException =
        new ForbiddenAuthException("0123456789ABCDEF", cause);

    // Assert
    assertEquals(
        "\n"
            + "Component: Authentication Proxy\n"
            + "Message: 0123456789ABCDEF\n"
            + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n"
            + "Stack trace: \n",
        actualForbiddenAuthException.getLocalizedMessage());
    assertEquals(
        "\n"
            + "Component: Authentication Proxy\n"
            + "Message: 0123456789ABCDEF\n"
            + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n"
            + "Stack trace: \n",
        actualForbiddenAuthException.getMessage());
    assertEquals(0, actualForbiddenAuthException.getSuppressed().length);
    assertSame(cause, actualForbiddenAuthException.getCause());
  }

  /**
   * Test {@link ForbiddenAuthException#ForbiddenAuthException(String, Throwable, String[])}.
   *
   * <p>Method under test: {@link ForbiddenAuthException#ForbiddenAuthException(String, Throwable,
   * String[])}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"void ForbiddenAuthException.<init>(String, Throwable, String[])"})
  public void testNewForbiddenAuthException3() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    ForbiddenAuthException actualForbiddenAuthException =
        new ForbiddenAuthException("0123456789ABCDEF", cause, "0123456789ABCDEF");

    // Assert
    assertEquals(
        "\n"
            + "Component: Authentication Proxy\n"
            + "Message: 0123456789ABCDEF\n"
            + "Solutions: \n"
            + "0123456789ABCDEF\n"
            + "Stack trace: \n",
        actualForbiddenAuthException.getLocalizedMessage());
    assertEquals(
        "\n"
            + "Component: Authentication Proxy\n"
            + "Message: 0123456789ABCDEF\n"
            + "Solutions: \n"
            + "0123456789ABCDEF\n"
            + "Stack trace: \n",
        actualForbiddenAuthException.getMessage());
    assertEquals(0, actualForbiddenAuthException.getSuppressed().length);
    assertSame(cause, actualForbiddenAuthException.getCause());
  }

  /**
   * Test {@link ForbiddenAuthException#ForbiddenAuthException(String, String[])}.
   *
   * <p>Method under test: {@link ForbiddenAuthException#ForbiddenAuthException(String, String[])}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"void ForbiddenAuthException.<init>(String, String[])"})
  public void testNewForbiddenAuthException4() {
    // Arrange and Act
    ForbiddenAuthException actualForbiddenAuthException =
        new ForbiddenAuthException("0123456789ABCDEF", "0123456789ABCDEF");

    // Assert
    assertEquals(
        "\nComponent: Authentication Proxy\nMessage: 0123456789ABCDEF\nSolutions: \n0123456789ABCDEF\n",
        actualForbiddenAuthException.getLocalizedMessage());
    assertEquals(
        "\nComponent: Authentication Proxy\nMessage: 0123456789ABCDEF\nSolutions: \n0123456789ABCDEF\n",
        actualForbiddenAuthException.getMessage());
    assertNull(actualForbiddenAuthException.getCause());
    assertEquals(0, actualForbiddenAuthException.getSuppressed().length);
  }
}
