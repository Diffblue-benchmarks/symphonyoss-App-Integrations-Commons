package org.symphonyoss.integration.exception;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ExceptionHandlerDiffblueTest {
  /**
   * Test {@link ExceptionHandler#unauthorizedError(int)}.
   * <ul>
   *   <li>When four hundred one.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExceptionHandler#unauthorizedError(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ExceptionHandler.unauthorizedError(int)"})
  public void testUnauthorizedError_whenFourHundredOne_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new ExceptionHandlerTest()).unauthorizedError(401));
  }

  /**
   * Test {@link ExceptionHandler#unauthorizedError(int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExceptionHandler#unauthorizedError(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ExceptionHandler.unauthorizedError(int)"})
  public void testUnauthorizedError_whenOne_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new ExceptionHandlerTest()).unauthorizedError(1));
  }

  /**
   * Test {@link ExceptionHandler#forbiddenError(int)}.
   * <ul>
   *   <li>When four hundred three.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExceptionHandler#forbiddenError(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ExceptionHandler.forbiddenError(int)"})
  public void testForbiddenError_whenFourHundredThree_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new ExceptionHandlerTest()).forbiddenError(403));
  }

  /**
   * Test {@link ExceptionHandler#forbiddenError(int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExceptionHandler#forbiddenError(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ExceptionHandler.forbiddenError(int)"})
  public void testForbiddenError_whenOne_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new ExceptionHandlerTest()).forbiddenError(1));
  }
}
