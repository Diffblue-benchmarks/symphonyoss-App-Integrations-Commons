package org.symphonyoss.integration.model.yaml;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CertificateDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Certificate}
   *   <li>{@link Certificate#setCaCertChainFile(String)}
   *   <li>{@link Certificate#setCaCertFile(String)}
   *   <li>{@link Certificate#setCaKeyFile(String)}
   *   <li>{@link Certificate#setCaKeyPassword(String)}
   *   <li>{@link Certificate#getCaCertChainFile()}
   *   <li>{@link Certificate#getCaCertFile()}
   *   <li>{@link Certificate#getCaKeyFile()}
   *   <li>{@link Certificate#getCaKeyPassword()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    Certificate actualCertificate = new Certificate();
    actualCertificate.setCaCertChainFile("Ca Cert Chain File");
    actualCertificate.setCaCertFile("Ca Cert File");
    actualCertificate.setCaKeyFile("Ca Key File");
    actualCertificate.setCaKeyPassword("iloveyou");
    String actualCaCertChainFile = actualCertificate.getCaCertChainFile();
    String actualCaCertFile = actualCertificate.getCaCertFile();
    String actualCaKeyFile = actualCertificate.getCaKeyFile();

    // Assert that nothing has changed
    assertEquals("Ca Cert Chain File", actualCaCertChainFile);
    assertEquals("Ca Cert File", actualCaCertFile);
    assertEquals("Ca Key File", actualCaKeyFile);
    assertEquals("iloveyou", actualCertificate.getCaKeyPassword());
  }
}
