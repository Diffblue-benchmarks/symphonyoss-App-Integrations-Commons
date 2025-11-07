package org.symphonyoss.integration.exception.bootstrap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class CertificateNotFoundExceptionDiffblueTest {
  /**
   * Test {@link CertificateNotFoundException#CertificateNotFoundException()}.
   * <p>
   * Method under test: {@link CertificateNotFoundException#CertificateNotFoundException()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CertificateNotFoundException.<init>()"})
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
   * Test {@link CertificateNotFoundException#CertificateNotFoundException(String)}.
   * <p>
   * Method under test: {@link CertificateNotFoundException#CertificateNotFoundException(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CertificateNotFoundException.<init>(String)"})
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
   * Test {@link CertificateNotFoundException#CertificateNotFoundException(String, Exception)}.
   * <p>
   * Method under test: {@link CertificateNotFoundException#CertificateNotFoundException(String, Exception)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CertificateNotFoundException.<init>(String, Exception)"})
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
