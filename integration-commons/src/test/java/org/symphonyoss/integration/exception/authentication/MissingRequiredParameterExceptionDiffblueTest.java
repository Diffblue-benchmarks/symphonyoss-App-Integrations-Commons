package org.symphonyoss.integration.exception.authentication;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class MissingRequiredParameterExceptionDiffblueTest {
  /**
   * Method under test:
   * {@link MissingRequiredParameterException#MissingRequiredParameterException(String, String[])}
   */
  @Test
  public void testNewMissingRequiredParameterException() {
    // Arrange and Act
    MissingRequiredParameterException actualMissingRequiredParameterException = new MissingRequiredParameterException(
        "An error occurred", "Solutions");

    // Assert
    assertEquals("\nComponent: Authentication Proxy\nMessage: An error occurred\nSolutions: \nSolutions\n",
        actualMissingRequiredParameterException.getLocalizedMessage());
    assertEquals("\nComponent: Authentication Proxy\nMessage: An error occurred\nSolutions: \nSolutions\n",
        actualMissingRequiredParameterException.getMessage());
    assertNull(actualMissingRequiredParameterException.getCause());
    assertEquals(0, actualMissingRequiredParameterException.getSuppressed().length);
  }
}
