package org.symphonyoss.integration.exception.bootstrap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import org.junit.Test;

public class RetryLifecycleExceptionDiffblueTest {
  /**
   * Method under test:
   * {@link RetryLifecycleException#RetryLifecycleException(String, Throwable)}
   */
  @Test
  public void testNewRetryLifecycleException() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    RetryLifecycleException actualRetryLifecycleException = new RetryLifecycleException("An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualRetryLifecycleException.getMessage());
    assertEquals(0, actualRetryLifecycleException.getSuppressed().length);
    assertSame(cause, actualRetryLifecycleException.getCause());
  }
}
