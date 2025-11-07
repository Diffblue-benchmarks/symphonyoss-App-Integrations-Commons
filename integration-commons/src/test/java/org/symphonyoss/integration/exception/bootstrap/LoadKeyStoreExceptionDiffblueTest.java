package org.symphonyoss.integration.exception.bootstrap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import org.junit.Test;

public class LoadKeyStoreExceptionDiffblueTest {
  /**
   * Method under test:
   * {@link LoadKeyStoreException#LoadKeyStoreException(String)}
   */
  @Test
  public void testNewLoadKeyStoreException() {
    // Arrange and Act
    LoadKeyStoreException actualLoadKeyStoreException = new LoadKeyStoreException("An error occurred");

    // Assert
    assertEquals(
        "\n" + "Component: Integration Bootstrap\n" + "Message: An error occurred\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualLoadKeyStoreException.getLocalizedMessage());
    assertEquals(
        "\n" + "Component: Integration Bootstrap\n" + "Message: An error occurred\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualLoadKeyStoreException.getMessage());
    assertNull(actualLoadKeyStoreException.getCause());
    assertEquals(0, actualLoadKeyStoreException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link LoadKeyStoreException#LoadKeyStoreException(String, Exception)}
   */
  @Test
  public void testNewLoadKeyStoreException2() {
    // Arrange
    Exception cause = new Exception("foo");

    // Act
    LoadKeyStoreException actualLoadKeyStoreException = new LoadKeyStoreException("An error occurred", cause);

    // Assert
    assertEquals(
        "\n" + "Component: Integration Bootstrap\n" + "Message: An error occurred\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n" + "Stack trace: foo\n",
        actualLoadKeyStoreException.getLocalizedMessage());
    assertEquals(
        "\n" + "Component: Integration Bootstrap\n" + "Message: An error occurred\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n" + "Stack trace: foo\n",
        actualLoadKeyStoreException.getMessage());
    assertEquals(0, actualLoadKeyStoreException.getSuppressed().length);
    assertSame(cause, actualLoadKeyStoreException.getCause());
  }

  /**
   * Method under test:
   * {@link LoadKeyStoreException#LoadKeyStoreException(String, Exception, String[])}
   */
  @Test
  public void testNewLoadKeyStoreException3() {
    // Arrange
    Exception cause = new Exception("foo");

    // Act
    LoadKeyStoreException actualLoadKeyStoreException = new LoadKeyStoreException("An error occurred", cause,
        "Solutions");

    // Assert
    assertEquals(
        "\nComponent: Integration Bootstrap\nMessage: An error occurred\nSolutions: \nSolutions\nStack trace: foo\n",
        actualLoadKeyStoreException.getLocalizedMessage());
    assertEquals(
        "\nComponent: Integration Bootstrap\nMessage: An error occurred\nSolutions: \nSolutions\nStack trace: foo\n",
        actualLoadKeyStoreException.getMessage());
    assertEquals(0, actualLoadKeyStoreException.getSuppressed().length);
    assertSame(cause, actualLoadKeyStoreException.getCause());
  }

  /**
   * Method under test:
   * {@link LoadKeyStoreException#LoadKeyStoreException(String, String[])}
   */
  @Test
  public void testNewLoadKeyStoreException4() {
    // Arrange and Act
    LoadKeyStoreException actualLoadKeyStoreException = new LoadKeyStoreException("An error occurred", "Solutions");

    // Assert
    assertEquals("\nComponent: Integration Bootstrap\nMessage: An error occurred\nSolutions: \nSolutions\n",
        actualLoadKeyStoreException.getLocalizedMessage());
    assertEquals("\nComponent: Integration Bootstrap\nMessage: An error occurred\nSolutions: \nSolutions\n",
        actualLoadKeyStoreException.getMessage());
    assertNull(actualLoadKeyStoreException.getCause());
    assertEquals(0, actualLoadKeyStoreException.getSuppressed().length);
  }
}
