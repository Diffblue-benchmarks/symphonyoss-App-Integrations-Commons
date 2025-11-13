package org.symphonyoss.integration.authorization;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;

public class AuthorizationExceptionDiffblueTest {
  /**
   * Test {@link AuthorizationException#AuthorizationException(String, String[])}.
   *
   * <p>Method under test: {@link AuthorizationException#AuthorizationException(String, String[])}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"void AuthorizationException.<init>(String, String[])"})
  public void testNewAuthorizationException() {
    // Arrange and Act
    AuthorizationException actualAuthorizationException =
        new AuthorizationException("", "Solutions");

    // Assert
    assertEquals(
        "\nComponent: Third-party integration/app authorization.\nMessage: None\nSolutions: \nSolutions\n",
        actualAuthorizationException.getLocalizedMessage());
    assertEquals(
        "\nComponent: Third-party integration/app authorization.\nMessage: None\nSolutions: \nSolutions\n",
        actualAuthorizationException.getMessage());
    assertNull(actualAuthorizationException.getCause());
    assertEquals(0, actualAuthorizationException.getSuppressed().length);
  }

  /**
   * Test {@link AuthorizationException#AuthorizationException(String, String[])}.
   *
   * <ul>
   *   <li>Then return LocalizedMessage is a string.
   * </ul>
   *
   * <p>Method under test: {@link AuthorizationException#AuthorizationException(String, String[])}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"void AuthorizationException.<init>(String, String[])"})
  public void testNewAuthorizationException_thenReturnLocalizedMessageIsAString() {
    // Arrange and Act
    AuthorizationException actualAuthorizationException =
        new AuthorizationException("An error occurred", "Solutions");

    // Assert
    assertEquals(
        "\n"
            + "Component: Third-party integration/app authorization.\n"
            + "Message: An error occurred\n"
            + "Solutions: \n"
            + "Solutions\n",
        actualAuthorizationException.getLocalizedMessage());
    assertEquals(
        "\n"
            + "Component: Third-party integration/app authorization.\n"
            + "Message: An error occurred\n"
            + "Solutions: \n"
            + "Solutions\n",
        actualAuthorizationException.getMessage());
    assertNull(actualAuthorizationException.getCause());
    assertEquals(0, actualAuthorizationException.getSuppressed().length);
  }

  /**
   * Test {@link AuthorizationException#AuthorizationException(String, String[])}.
   *
   * <ul>
   *   <li>Then return LocalizedMessage is a string.
   * </ul>
   *
   * <p>Method under test: {@link AuthorizationException#AuthorizationException(String, String[])}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"void AuthorizationException.<init>(String, String[])"})
  public void testNewAuthorizationException_thenReturnLocalizedMessageIsAString2() {
    // Arrange and Act
    AuthorizationException actualAuthorizationException =
        new AuthorizationException("An error occurred");

    // Assert
    assertEquals(
        "\n"
            + "Component: Third-party integration/app authorization.\n"
            + "Message: An error occurred\n"
            + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualAuthorizationException.getLocalizedMessage());
    assertEquals(
        "\n"
            + "Component: Third-party integration/app authorization.\n"
            + "Message: An error occurred\n"
            + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualAuthorizationException.getMessage());
    assertNull(actualAuthorizationException.getCause());
    assertEquals(0, actualAuthorizationException.getSuppressed().length);
  }

  /**
   * Test {@link AuthorizationException#AuthorizationException(String, Throwable, String[])}.
   *
   * <ul>
   *   <li>When {@code An error occurred}.
   *   <li>Then return Cause is {@link Throwable#Throwable()}.
   * </ul>
   *
   * <p>Method under test: {@link AuthorizationException#AuthorizationException(String, Throwable,
   * String[])}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"void AuthorizationException.<init>(String, Throwable, String[])"})
  public void testNewAuthorizationException_whenAnErrorOccurred_thenReturnCauseIsThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    AuthorizationException actualAuthorizationException =
        new AuthorizationException("An error occurred", cause, "Solutions");

    // Assert
    assertEquals(
        "\n"
            + "Component: Third-party integration/app authorization.\n"
            + "Message: An error occurred\n"
            + "Solutions: \n"
            + "Solutions\n"
            + "Stack trace: \n",
        actualAuthorizationException.getLocalizedMessage());
    assertEquals(
        "\n"
            + "Component: Third-party integration/app authorization.\n"
            + "Message: An error occurred\n"
            + "Solutions: \n"
            + "Solutions\n"
            + "Stack trace: \n",
        actualAuthorizationException.getMessage());
    assertSame(cause, actualAuthorizationException.getCause());
  }

  /**
   * Test {@link AuthorizationException#AuthorizationException(String, Throwable, String[])}.
   *
   * <ul>
   *   <li>When {@code An error occurred}.
   *   <li>Then return Cause is {@link Throwable#Throwable()}.
   * </ul>
   *
   * <p>Method under test: {@link AuthorizationException#AuthorizationException(String, Throwable,
   * String[])}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"void AuthorizationException.<init>(String, Throwable, String[])"})
  public void testNewAuthorizationException_whenAnErrorOccurred_thenReturnCauseIsThrowable2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    AuthorizationException actualAuthorizationException =
        new AuthorizationException("An error occurred", cause);

    // Assert
    assertEquals(
        "\n"
            + "Component: Third-party integration/app authorization.\n"
            + "Message: An error occurred\n"
            + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n"
            + "Stack trace: \n",
        actualAuthorizationException.getLocalizedMessage());
    assertEquals(
        "\n"
            + "Component: Third-party integration/app authorization.\n"
            + "Message: An error occurred\n"
            + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n"
            + "Stack trace: \n",
        actualAuthorizationException.getMessage());
    assertSame(cause, actualAuthorizationException.getCause());
  }

  /**
   * Test {@link AuthorizationException#AuthorizationException(String, Throwable, String[])}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return Cause is {@link Throwable#Throwable()}.
   * </ul>
   *
   * <p>Method under test: {@link AuthorizationException#AuthorizationException(String, Throwable,
   * String[])}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"void AuthorizationException.<init>(String, Throwable, String[])"})
  public void testNewAuthorizationException_whenEmptyString_thenReturnCauseIsThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    AuthorizationException actualAuthorizationException =
        new AuthorizationException("", cause, "Solutions");

    // Assert
    assertEquals(
        "\n"
            + "Component: Third-party integration/app authorization.\n"
            + "Message: None\n"
            + "Solutions: \n"
            + "Solutions\n"
            + "Stack trace: \n",
        actualAuthorizationException.getLocalizedMessage());
    assertEquals(
        "\n"
            + "Component: Third-party integration/app authorization.\n"
            + "Message: None\n"
            + "Solutions: \n"
            + "Solutions\n"
            + "Stack trace: \n",
        actualAuthorizationException.getMessage());
    assertSame(cause, actualAuthorizationException.getCause());
  }
}
