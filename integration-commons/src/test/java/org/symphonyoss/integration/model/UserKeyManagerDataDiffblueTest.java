package org.symphonyoss.integration.model;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class UserKeyManagerDataDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link UserKeyManagerData}
   *   <li>{@link UserKeyManagerData#setCertificate(String)}
   *   <li>{@link UserKeyManagerData#setPrivateKey(String)}
   *   <li>{@link UserKeyManagerData#setPrivateKeySignature(String)}
   *   <li>{@link UserKeyManagerData#setPublicKey(String)}
   *   <li>{@link UserKeyManagerData#setPublicKeySignature(String)}
   *   <li>{@link UserKeyManagerData#setStatus(String)}
   *   <li>{@link UserKeyManagerData#setUserId(Long)}
   *   <li>{@link UserKeyManagerData#getCertificate()}
   *   <li>{@link UserKeyManagerData#getPrivateKey()}
   *   <li>{@link UserKeyManagerData#getPrivateKeySignature()}
   *   <li>{@link UserKeyManagerData#getPublicKey()}
   *   <li>{@link UserKeyManagerData#getPublicKeySignature()}
   *   <li>{@link UserKeyManagerData#getStatus()}
   *   <li>{@link UserKeyManagerData#getUserId()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    UserKeyManagerData actualUserKeyManagerData = new UserKeyManagerData();
    actualUserKeyManagerData.setCertificate("Certificate");
    actualUserKeyManagerData.setPrivateKey("Private Key");
    actualUserKeyManagerData.setPrivateKeySignature("Private Key Signature");
    actualUserKeyManagerData.setPublicKey("Public Key");
    actualUserKeyManagerData.setPublicKeySignature("Public Key Signature");
    actualUserKeyManagerData.setStatus("Status");
    actualUserKeyManagerData.setUserId(1L);
    String actualCertificate = actualUserKeyManagerData.getCertificate();
    String actualPrivateKey = actualUserKeyManagerData.getPrivateKey();
    String actualPrivateKeySignature = actualUserKeyManagerData.getPrivateKeySignature();
    String actualPublicKey = actualUserKeyManagerData.getPublicKey();
    String actualPublicKeySignature = actualUserKeyManagerData.getPublicKeySignature();
    String actualStatus = actualUserKeyManagerData.getStatus();

    // Assert that nothing has changed
    assertEquals("Certificate", actualCertificate);
    assertEquals("Private Key Signature", actualPrivateKeySignature);
    assertEquals("Private Key", actualPrivateKey);
    assertEquals("Public Key Signature", actualPublicKeySignature);
    assertEquals("Public Key", actualPublicKey);
    assertEquals("Status", actualStatus);
    assertEquals(1L, actualUserKeyManagerData.getUserId().longValue());
  }
}
