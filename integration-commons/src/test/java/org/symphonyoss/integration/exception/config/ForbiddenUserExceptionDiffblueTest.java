package org.symphonyoss.integration.exception.config;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import org.junit.Test;

public class ForbiddenUserExceptionDiffblueTest {
  /**
   * Method under test:
   * {@link ForbiddenUserException#ForbiddenUserException(String, Throwable, String[])}
   */
  @Test
  public void testNewForbiddenUserException() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    ForbiddenUserException actualForbiddenUserException = new ForbiddenUserException("An error occurred", cause,
        "Solutions");

    // Assert
    assertEquals(
        "\nComponent: Configuration Service\nMessage: An error occurred\nSolutions: \nSolutions\nStack trace: \n",
        actualForbiddenUserException.getLocalizedMessage());
    assertEquals(
        "\nComponent: Configuration Service\nMessage: An error occurred\nSolutions: \nSolutions\nStack trace: \n",
        actualForbiddenUserException.getMessage());
    assertEquals(0, actualForbiddenUserException.getSuppressed().length);
    assertSame(cause, actualForbiddenUserException.getCause());
  }
}
