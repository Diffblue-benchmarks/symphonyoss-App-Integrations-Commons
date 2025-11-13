package org.symphonyoss.integration.authorization.oauth.v1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;

public class OAuth1HttpRequestExceptionDiffblueTest {
  /**
   * Test {@link OAuth1HttpRequestException#OAuth1HttpRequestException(String, int)}.
   *
   * <p>Method under test: {@link OAuth1HttpRequestException#OAuth1HttpRequestException(String,
   * int)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"void OAuth1HttpRequestException.<init>(String, int)"})
  public void testNewOAuth1HttpRequestException() {
    // Arrange and Act
    OAuth1HttpRequestException actualOAuth1HttpRequestException =
        new OAuth1HttpRequestException("https://example.org/example", 1);

    // Assert
    assertEquals(
        "\n"
            + "Component: Third-party integration/app authorization.\n"
            + "Message: https://example.org/example\n"
            + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualOAuth1HttpRequestException.getLocalizedMessage());
    assertEquals(
        "\n"
            + "Component: Third-party integration/app authorization.\n"
            + "Message: https://example.org/example\n"
            + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualOAuth1HttpRequestException.getMessage());
    assertNull(actualOAuth1HttpRequestException.getCause());
    assertEquals(0, actualOAuth1HttpRequestException.getSuppressed().length);
    assertEquals(1, actualOAuth1HttpRequestException.getCode());
  }

  /**
   * Test {@link OAuth1HttpRequestException#getCode()}.
   *
   * <p>Method under test: {@link OAuth1HttpRequestException#getCode()}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"int OAuth1HttpRequestException.getCode()"})
  public void testGetCode() {
    // Arrange, Act and Assert
    assertEquals(1, new OAuth1HttpRequestException("https://example.org/example", 1).getCode());
  }
}
