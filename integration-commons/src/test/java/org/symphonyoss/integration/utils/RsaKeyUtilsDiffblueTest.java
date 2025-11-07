package org.symphonyoss.integration.utils;

import static org.junit.Assert.assertEquals;
import java.security.PublicKey;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.symphonyoss.integration.exception.authentication.UnexpectedAuthException;
import org.symphonyoss.integration.logging.LogMessageSource;

@ContextConfiguration(classes = {RsaKeyUtils.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class RsaKeyUtilsDiffblueTest {
  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @MockBean
  private LogMessageSource logMessageSource;

  @Autowired
  private RsaKeyUtils rsaKeyUtils;

  /**
   * Method under test: {@link RsaKeyUtils#getPrivateKey(String)}
   */
  @Test
  public void testGetPrivateKey() {
    // Arrange, Act and Assert
    thrown.expect(UnexpectedAuthException.class);
    rsaKeyUtils.getPrivateKey("Private Key");
  }

  /**
   * Method under test: {@link RsaKeyUtils#getPrivateKey(String)}
   */
  @Test
  public void testGetPrivateKey2() {
    // Arrange, Act and Assert
    thrown.expect(UnexpectedAuthException.class);
    rsaKeyUtils.getPrivateKey("RSA");
  }

  /**
   * Method under test: {@link RsaKeyUtils#getPrivateKey(String)}
   */
  @Test
  public void testGetPrivateKey3() {
    // Arrange, Act and Assert
    thrown.expect(UnexpectedAuthException.class);
    rsaKeyUtils.getPrivateKey("integration.authorization.invalid.privatekey");
  }

  /**
   * Method under test: {@link RsaKeyUtils#getPrivateKey(String)}
   */
  @Test
  public void testGetPrivateKey4() {
    // Arrange, Act and Assert
    thrown.expect(UnexpectedAuthException.class);
    rsaKeyUtils.getPrivateKey("\n");
  }

  /**
   * Method under test: {@link RsaKeyUtils#getPrivateKey(String)}
   */
  @Test
  public void testGetPrivateKey5() {
    // Arrange, Act and Assert
    thrown.expect(UnexpectedAuthException.class);
    rsaKeyUtils.getPrivateKey("");
  }

  /**
   * Method under test: {@link RsaKeyUtils#getPublicKey(String)}
   */
  @Test
  public void testGetPublicKey() {
    // Arrange, Act and Assert
    thrown.expect(UnexpectedAuthException.class);
    rsaKeyUtils.getPublicKey("Public Key");
  }

  /**
   * Method under test: {@link RsaKeyUtils#getPublicKey(String)}
   */
  @Test
  public void testGetPublicKey2() {
    // Arrange, Act and Assert
    thrown.expect(UnexpectedAuthException.class);
    rsaKeyUtils.getPublicKey("RSA");
  }

  /**
   * Method under test: {@link RsaKeyUtils#getPublicKey(String)}
   */
  @Test
  public void testGetPublicKey3() {
    // Arrange, Act and Assert
    thrown.expect(UnexpectedAuthException.class);
    rsaKeyUtils.getPublicKey("integration.authorization.invalid.publickey");
  }

  /**
   * Method under test: {@link RsaKeyUtils#getPublicKey(String)}
   */
  @Test
  public void testGetPublicKey4() {
    // Arrange, Act and Assert
    thrown.expect(UnexpectedAuthException.class);
    rsaKeyUtils.getPublicKey("42");
  }

  /**
   * Method under test: {@link RsaKeyUtils#getPublicKey(String)}
   */
  @Test
  public void testGetPublicKey5() {
    // Arrange, Act and Assert
    thrown.expect(UnexpectedAuthException.class);
    rsaKeyUtils.getPublicKey("");
  }

  /**
   * Method under test: {@link RsaKeyUtils#trimPrivateKey(String)}
   */
  @Test
  public void testTrimPrivateKey() {
    // Arrange, Act and Assert
    assertEquals("Private Key", rsaKeyUtils.trimPrivateKey("Private Key"));
  }

  /**
   * Method under test: {@link RsaKeyUtils#trimPublicKey(String)}
   */
  @Test
  public void testTrimPublicKey() {
    // Arrange, Act and Assert
    assertEquals("Public Key", rsaKeyUtils.trimPublicKey("Public Key"));
  }

  /**
   * Method under test: {@link RsaKeyUtils#getPublicKeyFromCertificate(String)}
   */
  @Test
  public void testGetPublicKeyFromCertificate() {
    // Arrange, Act and Assert
    thrown.expect(UnexpectedAuthException.class);
    rsaKeyUtils.getPublicKeyFromCertificate("Certificate");
  }

  /**
   * Method under test: {@link RsaKeyUtils#getPublicKeyFromCertificate(String)}
   */
  @Test
  public void testGetPublicKeyFromCertificate2() {
    // Arrange, Act and Assert
    thrown.expect(UnexpectedAuthException.class);
    rsaKeyUtils.getPublicKeyFromCertificate("-----BEGIN CERTIFICATE-----");
  }

  /**
   * Method under test: {@link RsaKeyUtils#getPublicKeyFromCertificate(String)}
   */
  @Test
  public void testGetPublicKeyFromCertificate3() {
    // Arrange, Act and Assert
    thrown.expect(UnexpectedAuthException.class);
    rsaKeyUtils.getPublicKeyFromCertificate("X.509");
  }

  /**
   * Method under test: {@link RsaKeyUtils#getPublicKeyFromCertificate(String)}
   */
  @Test
  public void testGetPublicKeyFromCertificate4() {
    // Arrange, Act and Assert
    thrown.expect(UnexpectedAuthException.class);
    rsaKeyUtils.getPublicKeyFromCertificate("integration.authorization.invalid.certificate");
  }

  /**
   * Method under test: {@link RsaKeyUtils#getPublicKeyFromCertificate(String)}
   */
  @Test
  public void testGetPublicKeyFromCertificate5() {
    // Arrange, Act and Assert
    thrown.expect(UnexpectedAuthException.class);
    rsaKeyUtils.getPublicKeyFromCertificate("Component: ");
  }

  /**
   * Method under test: {@link RsaKeyUtils#parsePublicKey(PublicKey)}
   */
  @Test
  public void testParsePublicKey() {
    // Arrange, Act and Assert
    thrown.expect(UnexpectedAuthException.class);
    rsaKeyUtils.parsePublicKey(null);
  }
}
