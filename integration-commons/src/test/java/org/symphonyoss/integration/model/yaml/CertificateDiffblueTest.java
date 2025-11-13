package org.symphonyoss.integration.model.yaml;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;

public class CertificateDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Certificate.<init>()",
    "String Certificate.getCaCertChainFile()",
    "String Certificate.getCaCertFile()",
    "String Certificate.getCaKeyFile()",
    "String Certificate.getCaKeyPassword()",
    "void Certificate.setCaCertChainFile(String)",
    "void Certificate.setCaCertFile(String)",
    "void Certificate.setCaKeyFile(String)",
    "void Certificate.setCaKeyPassword(String)"
  })
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

    // Assert
    assertEquals("Ca Cert Chain File", actualCaCertChainFile);
    assertEquals("Ca Cert File", actualCaCertFile);
    assertEquals("Ca Key File", actualCaKeyFile);
    assertEquals("iloveyou", actualCertificate.getCaKeyPassword());
  }
}
