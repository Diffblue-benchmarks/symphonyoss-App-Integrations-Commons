package org.symphonyoss.integration.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import org.junit.Test;

public class CryptoExceptionDiffblueTest {
  /**
   * Method under test:
   * {@link CryptoException#CryptoException(String, Throwable, String[])}
   */
  @Test
  public void testNewCryptoException() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    CryptoException actualCryptoException = new CryptoException("An error occurred", cause, "Solutions");

    // Assert
    assertEquals(
        "\nComponent: Cryptography service\nMessage: An error occurred\nSolutions: \nSolutions\nStack trace: \n",
        actualCryptoException.getLocalizedMessage());
    assertEquals(
        "\nComponent: Cryptography service\nMessage: An error occurred\nSolutions: \nSolutions\nStack trace: \n",
        actualCryptoException.getMessage());
    assertEquals(0, actualCryptoException.getSuppressed().length);
    assertSame(cause, actualCryptoException.getCause());
  }

  /**
   * Method under test:
   * {@link CryptoException#CryptoException(String, Throwable, String[])}
   */
  @Test
  public void testNewCryptoException2() {
    // Arrange and Act
    CryptoException actualCryptoException = new CryptoException(null, null, null);

    // Assert
    assertEquals(
        "\n" + "Component: Cryptography service\n" + "Message: None\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualCryptoException.getLocalizedMessage());
    assertEquals("\n" + "Component: Cryptography service\n" + "Message: None\n" + "Solutions: \n"
        + "No solution has been cataloged for troubleshooting this problem.\n", actualCryptoException.getMessage());
    assertNull(actualCryptoException.getCause());
    assertEquals(0, actualCryptoException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link CryptoException#CryptoException(String, Throwable, String[])}
   */
  @Test
  public void testNewCryptoException3() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    CryptoException actualCryptoException = new CryptoException("An error occurred", cause);

    // Assert
    assertEquals(
        "\n" + "Component: Cryptography service\n" + "Message: An error occurred\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n" + "Stack trace: \n",
        actualCryptoException.getLocalizedMessage());
    assertEquals(
        "\n" + "Component: Cryptography service\n" + "Message: An error occurred\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n" + "Stack trace: \n",
        actualCryptoException.getMessage());
    assertEquals(0, actualCryptoException.getSuppressed().length);
    assertSame(cause, actualCryptoException.getCause());
  }

  /**
   * Method under test: {@link CryptoException#CryptoException(String, String[])}
   */
  @Test
  public void testNewCryptoException4() {
    // Arrange and Act
    CryptoException actualCryptoException = new CryptoException("An error occurred", "Solutions");

    // Assert
    assertEquals("\nComponent: Cryptography service\nMessage: An error occurred\nSolutions: \nSolutions\n",
        actualCryptoException.getLocalizedMessage());
    assertEquals("\nComponent: Cryptography service\nMessage: An error occurred\nSolutions: \nSolutions\n",
        actualCryptoException.getMessage());
    assertNull(actualCryptoException.getCause());
    assertEquals(0, actualCryptoException.getSuppressed().length);
  }

  /**
   * Method under test: {@link CryptoException#CryptoException(String, String[])}
   */
  @Test
  public void testNewCryptoException5() {
    // Arrange and Act
    CryptoException actualCryptoException = new CryptoException(null, null);

    // Assert
    assertEquals(
        "\n" + "Component: Cryptography service\n" + "Message: None\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualCryptoException.getLocalizedMessage());
    assertEquals("\n" + "Component: Cryptography service\n" + "Message: None\n" + "Solutions: \n"
        + "No solution has been cataloged for troubleshooting this problem.\n", actualCryptoException.getMessage());
    assertNull(actualCryptoException.getCause());
    assertEquals(0, actualCryptoException.getSuppressed().length);
  }

  /**
   * Method under test: {@link CryptoException#CryptoException(String, String[])}
   */
  @Test
  public void testNewCryptoException6() {
    // Arrange and Act
    CryptoException actualCryptoException = new CryptoException("An error occurred");

    // Assert
    assertEquals(
        "\n" + "Component: Cryptography service\n" + "Message: An error occurred\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualCryptoException.getLocalizedMessage());
    assertEquals("\n" + "Component: Cryptography service\n" + "Message: An error occurred\n" + "Solutions: \n"
        + "No solution has been cataloged for troubleshooting this problem.\n", actualCryptoException.getMessage());
    assertNull(actualCryptoException.getCause());
    assertEquals(0, actualCryptoException.getSuppressed().length);
  }
}
