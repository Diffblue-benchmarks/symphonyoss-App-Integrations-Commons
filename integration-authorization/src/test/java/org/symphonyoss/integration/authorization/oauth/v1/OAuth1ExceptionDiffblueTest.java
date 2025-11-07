package org.symphonyoss.integration.authorization.oauth.v1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class OAuth1ExceptionDiffblueTest {
  /**
   * Test {@link OAuth1Exception#OAuth1Exception(String, String[])}.
   * <ul>
   *   <li>When {@code An error occurred}.</li>
   *   <li>Then return Cause is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OAuth1Exception#OAuth1Exception(String, String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OAuth1Exception.<init>(String, Throwable, String[])",
      "void OAuth1Exception.<init>(String, String[])"})
  public void testNewOAuth1Exception_whenAnErrorOccurred_thenReturnCauseIsNull() {
    // Arrange and Act
    OAuth1Exception actualOAuth1Exception = new OAuth1Exception("An error occurred", "Solutions");

    // Assert
    assertEquals("\n" + "Component: Third-party integration/app authorization.\n" + "Message: An error occurred\n"
        + "Solutions: \n" + "Solutions\n", actualOAuth1Exception.getMessage());
    assertNull(actualOAuth1Exception.getCause());
    assertEquals(0, actualOAuth1Exception.getSuppressed().length);
  }

  /**
   * Test {@link OAuth1Exception#OAuth1Exception(String, Throwable, String[])}.
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.</li>
   *   <li>Then return Cause is {@link Throwable#Throwable()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OAuth1Exception#OAuth1Exception(String, Throwable, String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OAuth1Exception.<init>(String, Throwable, String[])",
      "void OAuth1Exception.<init>(String, String[])"})
  public void testNewOAuth1Exception_whenThrowable_thenReturnCauseIsThrowable() {
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
}
