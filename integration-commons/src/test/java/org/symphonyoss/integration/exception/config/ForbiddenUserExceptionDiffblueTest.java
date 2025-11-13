package org.symphonyoss.integration.exception.config;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;

public class ForbiddenUserExceptionDiffblueTest {
  /**
   * Test {@link ForbiddenUserException#ForbiddenUserException(String, Throwable, String[])}.
   *
   * <p>Method under test: {@link ForbiddenUserException#ForbiddenUserException(String, Throwable,
   * String[])}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"void ForbiddenUserException.<init>(String, Throwable, String[])"})
  public void testNewForbiddenUserException() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    ForbiddenUserException actualForbiddenUserException =
        new ForbiddenUserException("An error occurred", cause, "Solutions");

    // Assert
    assertEquals(
        "\nComponent: Configuration Service\nMessage: An error occurred\nSolutions: \nSolutions\nStack trace: \n",
        actualForbiddenUserException.getMessage());
    assertEquals(0, actualForbiddenUserException.getSuppressed().length);
    assertSame(cause, actualForbiddenUserException.getCause());
  }
}
