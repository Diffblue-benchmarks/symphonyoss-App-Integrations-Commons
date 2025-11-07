package org.symphonyoss.integration.exception.bootstrap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import org.junit.Test;

public class CertificateNotFoundExceptionDiffblueTest {
  /**
   * Method under test:
   * {@link CertificateNotFoundException#CertificateNotFoundException()}
   */
  @Test
  public void testNewCertificateNotFoundException() {
    // Arrange and Act
    CertificateNotFoundException actualCertificateNotFoundException = new CertificateNotFoundException();

    // Assert
    assertEquals(
        "\n" + "Component: Integration Bootstrap\n" + "Message: Certificate folder not found\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualCertificateNotFoundException.getLocalizedMessage());
    assertEquals(
        "\n" + "Component: Integration Bootstrap\n" + "Message: Certificate folder not found\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualCertificateNotFoundException.getMessage());
    assertNull(actualCertificateNotFoundException.getCause());
    assertEquals(0, actualCertificateNotFoundException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link CertificateNotFoundException#CertificateNotFoundException(String)}
   */
  @Test
  public void testNewCertificateNotFoundException2() {
    // Arrange and Act
    CertificateNotFoundException actualCertificateNotFoundException = new CertificateNotFoundException(
        "An error occurred");

    // Assert
    assertEquals(
        "\n" + "Component: Integration Bootstrap\n" + "Message: An error occurred\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualCertificateNotFoundException.getLocalizedMessage());
    assertEquals(
        "\n" + "Component: Integration Bootstrap\n" + "Message: An error occurred\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualCertificateNotFoundException.getMessage());
    assertNull(actualCertificateNotFoundException.getCause());
    assertEquals(0, actualCertificateNotFoundException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link CertificateNotFoundException#CertificateNotFoundException(String, Exception)}
   */
  @Test
  public void testNewCertificateNotFoundException3() {
    // Arrange
    Exception cause = new Exception("foo");

    // Act
    CertificateNotFoundException actualCertificateNotFoundException = new CertificateNotFoundException(
        "An error occurred", cause);

    // Assert
    assertEquals(
        "\n" + "Component: Integration Bootstrap\n" + "Message: An error occurred\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n" + "Stack trace: foo\n",
        actualCertificateNotFoundException.getLocalizedMessage());
    assertEquals(
        "\n" + "Component: Integration Bootstrap\n" + "Message: An error occurred\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n" + "Stack trace: foo\n",
        actualCertificateNotFoundException.getMessage());
    assertEquals(0, actualCertificateNotFoundException.getSuppressed().length);
    assertSame(cause, actualCertificateNotFoundException.getCause());
  }
}
