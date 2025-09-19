package org.symphonyoss.integration.utils;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.symphonyoss.integration.exception.bootstrap.CertificateNotFoundException;

public class IntegrationUtilsDiffblueTest {
  @Rule public ExpectedException thrown = ExpectedException.none();

  /**
   * Test {@link IntegrationUtils#getCertsDirectory()}.
   *
   * <ul>
   *   <li>Given {@link IntegrationUtils#IntegrationUtils(String)} with webServerBaseDir is empty
   *       string.
   * </ul>
   *
   * <p>Method under test: {@link IntegrationUtils#getCertsDirectory()}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String IntegrationUtils.getCertsDirectory()"})
  public void testGetCertsDirectory_givenIntegrationUtilsWithWebServerBaseDirIsEmptyString() {
    // Arrange, Act and Assert
    thrown.expect(CertificateNotFoundException.class);
    new IntegrationUtils("").getCertsDirectory();
  }

  /**
   * Test {@link IntegrationUtils#getCertsDirectory()}.
   *
   * <ul>
   *   <li>Given {@link IntegrationUtils#IntegrationUtils(String)} with webServerBaseDir is {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link IntegrationUtils#getCertsDirectory()}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String IntegrationUtils.getCertsDirectory()"})
  public void testGetCertsDirectory_givenIntegrationUtilsWithWebServerBaseDirIsNull() {
    // Arrange, Act and Assert
    thrown.expect(CertificateNotFoundException.class);
    new IntegrationUtils(null).getCertsDirectory();
  }

  /**
   * Test {@link IntegrationUtils#getCertsDirectory()}.
   *
   * <ul>
   *   <li>Given {@link IntegrationUtils#IntegrationUtils(String)} with webServerBaseDir is space.
   * </ul>
   *
   * <p>Method under test: {@link IntegrationUtils#getCertsDirectory()}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String IntegrationUtils.getCertsDirectory()"})
  public void testGetCertsDirectory_givenIntegrationUtilsWithWebServerBaseDirIsSpace() {
    // Arrange, Act and Assert
    thrown.expect(CertificateNotFoundException.class);
    new IntegrationUtils(" ").getCertsDirectory();
  }
}
