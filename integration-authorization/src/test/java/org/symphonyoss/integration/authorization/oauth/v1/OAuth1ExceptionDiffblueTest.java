package org.symphonyoss.integration.authorization.oauth.v1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import org.junit.Test;

public class OAuth1ExceptionDiffblueTest {
  /**
   * Method under test:
   * {@link OAuth1Exception#OAuth1Exception(String, Throwable, String[])}
   */
  @Test
  public void testNewOAuth1Exception() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    OAuth1Exception actualOAuth1Exception = new OAuth1Exception("An error occurred", cause, "Solutions");

    // Assert
    assertEquals("\n" + "Component: Third-party integration/app authorization.\n" + "Message: An error occurred\n"
        + "Solutions: \n" + "Solutions\n" + "Stack trace: \n", actualOAuth1Exception.getMessage());
    assertEquals(0, actualOAuth1Exception.getSuppressed().length);
    assertSame(cause, actualOAuth1Exception.getCause());
  }

  /**
   * Method under test: {@link OAuth1Exception#OAuth1Exception(String, String[])}
   */
  @Test
  public void testNewOAuth1Exception2() {
    // Arrange and Act
    OAuth1Exception actualOAuth1Exception = new OAuth1Exception("An error occurred", "Solutions");

    // Assert
    assertEquals("\n" + "Component: Third-party integration/app authorization.\n" + "Message: An error occurred\n"
        + "Solutions: \n" + "Solutions\n", actualOAuth1Exception.getMessage());
    assertNull(actualOAuth1Exception.getCause());
    assertEquals(0, actualOAuth1Exception.getSuppressed().length);
  }
}
