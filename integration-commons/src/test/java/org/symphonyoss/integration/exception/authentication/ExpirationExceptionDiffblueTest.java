package org.symphonyoss.integration.exception.authentication;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import org.junit.Test;

public class ExpirationExceptionDiffblueTest {
  /**
   * Method under test:
   * {@link ExpirationException#ExpirationException(String, Throwable, String[])}
   */
  @Test
  public void testNewExpirationException() {
    // Arrange
    Throwable e = new Throwable();

    // Act
    ExpirationException actualExpirationException = new ExpirationException("An error occurred", e, "Solutions");

    // Assert
    assertEquals(
        "\nComponent: Authentication Proxy\nMessage: An error occurred\nSolutions: \nSolutions\nStack trace: \n",
        actualExpirationException.getLocalizedMessage());
    assertEquals(
        "\nComponent: Authentication Proxy\nMessage: An error occurred\nSolutions: \nSolutions\nStack trace: \n",
        actualExpirationException.getMessage());
    assertEquals(0, actualExpirationException.getSuppressed().length);
    assertSame(e, actualExpirationException.getCause());
  }
}
