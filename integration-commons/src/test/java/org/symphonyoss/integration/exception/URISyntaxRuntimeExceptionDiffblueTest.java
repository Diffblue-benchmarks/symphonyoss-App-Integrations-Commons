package org.symphonyoss.integration.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;

public class URISyntaxRuntimeExceptionDiffblueTest {
  /**
   * Test {@link URISyntaxRuntimeException#URISyntaxRuntimeException(String, Throwable)}.
   *
   * <ul>
   *   <li>Then return Message is {@code An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link URISyntaxRuntimeException#URISyntaxRuntimeException(String,
   * Throwable)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void URISyntaxRuntimeException.<init>(String)",
    "void URISyntaxRuntimeException.<init>(String, Throwable)",
    "void URISyntaxRuntimeException.<init>(Throwable)"
  })
  public void testNewURISyntaxRuntimeException_thenReturnMessageIsAnErrorOccurred() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    URISyntaxRuntimeException actualUriSyntaxRuntimeException =
        new URISyntaxRuntimeException("An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualUriSyntaxRuntimeException.getMessage());
    assertEquals(0, actualUriSyntaxRuntimeException.getSuppressed().length);
    assertSame(cause, actualUriSyntaxRuntimeException.getCause());
  }

  /**
   * Test {@link URISyntaxRuntimeException#URISyntaxRuntimeException(Throwable)}.
   *
   * <ul>
   *   <li>Then return Message is {@code Throwable}.
   * </ul>
   *
   * <p>Method under test: {@link URISyntaxRuntimeException#URISyntaxRuntimeException(Throwable)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void URISyntaxRuntimeException.<init>(String)",
    "void URISyntaxRuntimeException.<init>(String, Throwable)",
    "void URISyntaxRuntimeException.<init>(Throwable)"
  })
  public void testNewURISyntaxRuntimeException_thenReturnMessageIsJavaLangThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    URISyntaxRuntimeException actualUriSyntaxRuntimeException =
        new URISyntaxRuntimeException(cause);

    // Assert
    assertEquals("java.lang.Throwable", actualUriSyntaxRuntimeException.getMessage());
    assertEquals(0, actualUriSyntaxRuntimeException.getSuppressed().length);
    assertSame(cause, actualUriSyntaxRuntimeException.getCause());
  }

  /**
   * Test {@link URISyntaxRuntimeException#URISyntaxRuntimeException(String)}.
   *
   * <ul>
   *   <li>When {@code An error occurred}.
   *   <li>Then return Cause is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link URISyntaxRuntimeException#URISyntaxRuntimeException(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void URISyntaxRuntimeException.<init>(String)",
    "void URISyntaxRuntimeException.<init>(String, Throwable)",
    "void URISyntaxRuntimeException.<init>(Throwable)"
  })
  public void testNewURISyntaxRuntimeException_whenAnErrorOccurred_thenReturnCauseIsNull() {
    // Arrange and Act
    URISyntaxRuntimeException actualUriSyntaxRuntimeException =
        new URISyntaxRuntimeException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualUriSyntaxRuntimeException.getMessage());
    assertNull(actualUriSyntaxRuntimeException.getCause());
    assertEquals(0, actualUriSyntaxRuntimeException.getSuppressed().length);
  }
}
