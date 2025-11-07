package org.symphonyoss.integration.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import org.junit.Test;

public class URISyntaxRuntimeExceptionDiffblueTest {
  /**
   * Method under test:
   * {@link URISyntaxRuntimeException#URISyntaxRuntimeException(String)}
   */
  @Test
  public void testNewURISyntaxRuntimeException() {
    // Arrange and Act
    URISyntaxRuntimeException actualUriSyntaxRuntimeException = new URISyntaxRuntimeException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualUriSyntaxRuntimeException.getMessage());
    assertNull(actualUriSyntaxRuntimeException.getCause());
    assertEquals(0, actualUriSyntaxRuntimeException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link URISyntaxRuntimeException#URISyntaxRuntimeException(String, Throwable)}
   */
  @Test
  public void testNewURISyntaxRuntimeException2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    URISyntaxRuntimeException actualUriSyntaxRuntimeException = new URISyntaxRuntimeException("An error occurred",
        cause);

    // Assert
    assertEquals("An error occurred", actualUriSyntaxRuntimeException.getMessage());
    assertEquals(0, actualUriSyntaxRuntimeException.getSuppressed().length);
    assertSame(cause, actualUriSyntaxRuntimeException.getCause());
  }

  /**
   * Method under test:
   * {@link URISyntaxRuntimeException#URISyntaxRuntimeException(Throwable)}
   */
  @Test
  public void testNewURISyntaxRuntimeException3() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    URISyntaxRuntimeException actualUriSyntaxRuntimeException = new URISyntaxRuntimeException(cause);

    // Assert
    assertEquals("java.lang.Throwable", actualUriSyntaxRuntimeException.getMessage());
    assertEquals(0, actualUriSyntaxRuntimeException.getSuppressed().length);
    assertSame(cause, actualUriSyntaxRuntimeException.getCause());
  }
}
