package org.symphonyoss.integration.authorization;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class AuthorizationExceptionDiffblueTest {
  /**
   * Test {@link AuthorizationException#AuthorizationException(String, String[])}.
   * <ul>
   *   <li>When {@code An error occurred}.</li>
   *   <li>Then return Cause is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AuthorizationException#AuthorizationException(String, String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AuthorizationException.<init>(String, Throwable, String[])",
      "void AuthorizationException.<init>(String, String[])"})
  public void testNewAuthorizationException_whenAnErrorOccurred_thenReturnCauseIsNull() {
    // Arrange and Act
    AuthorizationException actualAuthorizationException = new AuthorizationException("An error occurred", "Solutions");

    // Assert
    assertEquals("\n" + "Component: Third-party integration/app authorization.\n" + "Message: An error occurred\n"
        + "Solutions: \n" + "Solutions\n", actualAuthorizationException.getMessage());
    assertNull(actualAuthorizationException.getCause());
    assertEquals(0, actualAuthorizationException.getSuppressed().length);
  }

  /**
   * Test {@link AuthorizationException#AuthorizationException(String, Throwable, String[])}.
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.</li>
   *   <li>Then return Cause is {@link Throwable#Throwable()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AuthorizationException#AuthorizationException(String, Throwable, String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AuthorizationException.<init>(String, Throwable, String[])",
      "void AuthorizationException.<init>(String, String[])"})
  public void testNewAuthorizationException_whenThrowable_thenReturnCauseIsThrowable() {
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
}
