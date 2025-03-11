package org.symphonyoss.integration.authorization.oauth.v1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;

public class OAuth1MissingParametersExceptionDiffblueTest {
  /**
   * Test {@link OAuth1MissingParametersException#OAuth1MissingParametersException(String, String[])}.
   * <ul>
   *   <li>Then return Cause is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OAuth1MissingParametersException#OAuth1MissingParametersException(String, String[])}
   */
  @Test
  @MethodsUnderTest({"void OAuth1MissingParametersException.<init>(String, Throwable, String[])",
      "void OAuth1MissingParametersException.<init>(String, String[])"})
  public void testNewOAuth1MissingParametersException_thenReturnCauseIsNull() {
    // Arrange and Act
    OAuth1MissingParametersException actualOAuth1MissingParametersException = new OAuth1MissingParametersException(
        "An error occurred", "Solutions");

    // Assert
    assertEquals("\n" + "Component: Third-party integration/app authorization.\n" + "Message: An error occurred\n"
        + "Solutions: \n" + "Solutions\n", actualOAuth1MissingParametersException.getMessage());
    assertNull(actualOAuth1MissingParametersException.getCause());
    assertEquals(0, actualOAuth1MissingParametersException.getSuppressed().length);
  }

  /**
   * Test {@link OAuth1MissingParametersException#OAuth1MissingParametersException(String, Throwable, String[])}.
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.</li>
   *   <li>Then return Cause is {@link Throwable#Throwable()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OAuth1MissingParametersException#OAuth1MissingParametersException(String, Throwable, String[])}
   */
  @Test
  @MethodsUnderTest({"void OAuth1MissingParametersException.<init>(String, Throwable, String[])",
      "void OAuth1MissingParametersException.<init>(String, String[])"})
  public void testNewOAuth1MissingParametersException_whenThrowable_thenReturnCauseIsThrowable() {
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
}
