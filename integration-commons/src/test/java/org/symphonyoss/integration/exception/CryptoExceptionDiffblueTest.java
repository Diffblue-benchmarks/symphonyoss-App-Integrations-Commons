package org.symphonyoss.integration.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class CryptoExceptionDiffblueTest {
  /**
   * Test {@link CryptoException#CryptoException(String, Throwable, String[])}.
   * <p>
   * Method under test: {@link CryptoException#CryptoException(String, Throwable, String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CryptoException.<init>(String, Throwable, String[])"})
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
    assertSame(cause, actualCryptoException.getCause());
  }

  /**
   * Test {@link CryptoException#CryptoException(String, String[])}.
   * <p>
   * Method under test: {@link CryptoException#CryptoException(String, String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CryptoException.<init>(String, String[])"})
  public void testNewCryptoException2() {
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
   * Test {@link CryptoException#CryptoException(String, Throwable, String[])}.
   * <ul>
   *   <li>When {@code An error occurred}.</li>
   *   <li>Then return LocalizedMessage is a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link CryptoException#CryptoException(String, Throwable, String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CryptoException.<init>(String, Throwable, String[])"})
  public void testNewCryptoException_whenAnErrorOccurred_thenReturnLocalizedMessageIsAString() {
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
    assertSame(cause, actualCryptoException.getCause());
  }

  /**
   * Test {@link CryptoException#CryptoException(String, String[])}.
   * <ul>
   *   <li>When {@code An error occurred}.</li>
   *   <li>Then return LocalizedMessage is a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link CryptoException#CryptoException(String, String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CryptoException.<init>(String, String[])"})
  public void testNewCryptoException_whenAnErrorOccurred_thenReturnLocalizedMessageIsAString2() {
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

  /**
   * Test {@link CryptoException#CryptoException(String, Throwable, String[])}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return Cause is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CryptoException#CryptoException(String, Throwable, String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CryptoException.<init>(String, Throwable, String[])"})
  public void testNewCryptoException_whenNull_thenReturnCauseIsNull() {
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
   * Test {@link CryptoException#CryptoException(String, String[])}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return LocalizedMessage is a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link CryptoException#CryptoException(String, String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CryptoException.<init>(String, String[])"})
  public void testNewCryptoException_whenNull_thenReturnLocalizedMessageIsAString() {
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
}
