package org.symphonyoss.integration.authorization.oauth.v1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import org.junit.Test;

public class OAuth1MissingParametersExceptionDiffblueTest {
  /**
   * Method under test:
   * {@link OAuth1MissingParametersException#OAuth1MissingParametersException(String, Throwable, String[])}
   */
  @Test
  public void testNewOAuth1MissingParametersException() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    OAuth1MissingParametersException actualOAuth1MissingParametersException = new OAuth1MissingParametersException(
        "An error occurred", cause, "Solutions");

    // Assert
    assertEquals("\n" + "Component: Third-party integration/app authorization.\n" + "Message: An error occurred\n"
        + "Solutions: \n" + "Solutions\n" + "Stack trace: \n", actualOAuth1MissingParametersException.getMessage());
    assertEquals(0, actualOAuth1MissingParametersException.getSuppressed().length);
    assertSame(cause, actualOAuth1MissingParametersException.getCause());
  }

  /**
   * Method under test:
   * {@link OAuth1MissingParametersException#OAuth1MissingParametersException(String, String[])}
   */
  @Test
  public void testNewOAuth1MissingParametersException2() {
    // Arrange and Act
    OAuth1MissingParametersException actualOAuth1MissingParametersException = new OAuth1MissingParametersException(
        "An error occurred", "Solutions");

    // Assert
    assertEquals("\n" + "Component: Third-party integration/app authorization.\n" + "Message: An error occurred\n"
        + "Solutions: \n" + "Solutions\n", actualOAuth1MissingParametersException.getMessage());
    assertNull(actualOAuth1MissingParametersException.getCause());
    assertEquals(0, actualOAuth1MissingParametersException.getSuppressed().length);
  }
}
