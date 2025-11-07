package org.symphonyoss.integration.exception.bootstrap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import org.junit.Test;

public class UnexpectedBootstrapExceptionDiffblueTest {
  /**
   * Method under test:
   * {@link UnexpectedBootstrapException#UnexpectedBootstrapException(String, Exception)}
   */
  @Test
  public void testNewUnexpectedBootstrapException() {
    // Arrange
    Exception cause = new Exception("foo");

    // Act
    UnexpectedBootstrapException actualUnexpectedBootstrapException = new UnexpectedBootstrapException(
        "An error occurred", cause);

    // Assert
    assertEquals(
        "\n" + "Component: Integration Bootstrap\n" + "Message: An error occurred\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n" + "Stack trace: foo\n",
        actualUnexpectedBootstrapException.getLocalizedMessage());
    assertEquals(
        "\n" + "Component: Integration Bootstrap\n" + "Message: An error occurred\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n" + "Stack trace: foo\n",
        actualUnexpectedBootstrapException.getMessage());
    assertEquals(0, actualUnexpectedBootstrapException.getSuppressed().length);
    assertSame(cause, actualUnexpectedBootstrapException.getCause());
  }

  /**
   * Method under test:
   * {@link UnexpectedBootstrapException#UnexpectedBootstrapException(String, String[])}
   */
  @Test
  public void testNewUnexpectedBootstrapException2() {
    // Arrange and Act
    UnexpectedBootstrapException actualUnexpectedBootstrapException = new UnexpectedBootstrapException(
        "An error occurred", "Solutions");

    // Assert
    assertEquals("\nComponent: Integration Bootstrap\nMessage: An error occurred\nSolutions: \nSolutions\n",
        actualUnexpectedBootstrapException.getLocalizedMessage());
    assertEquals("\nComponent: Integration Bootstrap\nMessage: An error occurred\nSolutions: \nSolutions\n",
        actualUnexpectedBootstrapException.getMessage());
    assertNull(actualUnexpectedBootstrapException.getCause());
    assertEquals(0, actualUnexpectedBootstrapException.getSuppressed().length);
  }
}
