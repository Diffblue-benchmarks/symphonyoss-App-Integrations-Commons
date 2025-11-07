package org.symphonyoss.integration.exception;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class ExceptionHandlerDiffblueTest {
  /**
   * Method under test: {@link ExceptionHandler#unauthorizedError(int)}
   */
  @Test
  public void testUnauthorizedError() {
    // Arrange, Act and Assert
    assertFalse((new ExceptionHandlerTest()).unauthorizedError(1));
    assertTrue((new ExceptionHandlerTest()).unauthorizedError(401));
  }

  /**
   * Method under test: {@link ExceptionHandler#forbiddenError(int)}
   */
  @Test
  public void testForbiddenError() {
    // Arrange, Act and Assert
    assertFalse((new ExceptionHandlerTest()).forbiddenError(1));
    assertTrue((new ExceptionHandlerTest()).forbiddenError(403));
  }
}
