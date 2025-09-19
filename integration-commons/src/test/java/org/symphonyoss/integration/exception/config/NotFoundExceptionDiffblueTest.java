package org.symphonyoss.integration.exception.config;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;

public class NotFoundExceptionDiffblueTest {
  /**
   * Test {@link NotFoundException#NotFoundException(String, Throwable, String[])}.
   *
   * <p>Method under test: {@link NotFoundException#NotFoundException(String, Throwable, String[])}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"void NotFoundException.<init>(String, Throwable, String[])"})
  public void testNewNotFoundException() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    NotFoundException actualNotFoundException =
        new NotFoundException("An error occurred", cause, "Solutions");

    // Assert
    assertEquals(
        "\nComponent: Configuration Service\nMessage: An error occurred\nSolutions: \nSolutions\nStack trace: \n",
        actualNotFoundException.getLocalizedMessage());
    assertEquals(
        "\nComponent: Configuration Service\nMessage: An error occurred\nSolutions: \nSolutions\nStack trace: \n",
        actualNotFoundException.getMessage());
    assertEquals(0, actualNotFoundException.getSuppressed().length);
    assertSame(cause, actualNotFoundException.getCause());
  }
}
