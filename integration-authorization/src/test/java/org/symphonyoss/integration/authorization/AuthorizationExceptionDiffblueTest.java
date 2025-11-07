package org.symphonyoss.integration.authorization;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import org.junit.Test;

public class AuthorizationExceptionDiffblueTest {
  /**
   * Method under test:
   * {@link AuthorizationException#AuthorizationException(String, Throwable, String[])}
   */
  @Test
  public void testNewAuthorizationException() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    AuthorizationException actualAuthorizationException = new AuthorizationException("An error occurred", cause,
        "Solutions");

    // Assert
    assertEquals("\n" + "Component: Third-party integration/app authorization.\n" + "Message: An error occurred\n"
        + "Solutions: \n" + "Solutions\n" + "Stack trace: \n", actualAuthorizationException.getMessage());
    assertEquals(0, actualAuthorizationException.getSuppressed().length);
    assertSame(cause, actualAuthorizationException.getCause());
  }

  /**
   * Method under test:
   * {@link AuthorizationException#AuthorizationException(String, String[])}
   */
  @Test
  public void testNewAuthorizationException2() {
    // Arrange and Act
    AuthorizationException actualAuthorizationException = new AuthorizationException("An error occurred", "Solutions");

    // Assert
    assertEquals("\n" + "Component: Third-party integration/app authorization.\n" + "Message: An error occurred\n"
        + "Solutions: \n" + "Solutions\n", actualAuthorizationException.getMessage());
    assertNull(actualAuthorizationException.getCause());
    assertEquals(0, actualAuthorizationException.getSuppressed().length);
  }
}
