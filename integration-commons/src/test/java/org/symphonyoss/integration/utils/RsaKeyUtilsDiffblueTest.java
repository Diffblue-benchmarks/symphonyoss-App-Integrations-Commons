package org.symphonyoss.integration.utils;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
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
  @MockBean private LogMessageSource logMessageSource;

  @Autowired private RsaKeyUtils rsaKeyUtils;

  @Rule public ExpectedException thrown = ExpectedException.none();

  /**
   * Test {@link RsaKeyUtils#getPrivateKey(String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then throw {@link UnexpectedAuthException}.
   * </ul>
   *
   * <p>Method under test: {@link RsaKeyUtils#getPrivateKey(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"java.security.PrivateKey RsaKeyUtils.getPrivateKey(String)"})
  public void testGetPrivateKey_whenEmptyString_thenThrowUnexpectedAuthException() {
    // Arrange, Act and Assert
    thrown.expect(UnexpectedAuthException.class);
    rsaKeyUtils.getPrivateKey("");
  }

  /**
   * Test {@link RsaKeyUtils#getPrivateKey(String)}.
   *
   * <ul>
   *   <li>When {@code integration.authorization.invalid.privatekey}.
   * </ul>
   *
   * <p>Method under test: {@link RsaKeyUtils#getPrivateKey(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"java.security.PrivateKey RsaKeyUtils.getPrivateKey(String)"})
  public void testGetPrivateKey_whenIntegrationAuthorizationInvalidPrivatekey() {
    // Arrange, Act and Assert
    thrown.expect(UnexpectedAuthException.class);
    rsaKeyUtils.getPrivateKey("integration.authorization.invalid.privatekey");
  }

  /**
   * Test {@link RsaKeyUtils#getPrivateKey(String)}.
   *
   * <ul>
   *   <li>When lf.
   *   <li>Then throw {@link UnexpectedAuthException}.
   * </ul>
   *
   * <p>Method under test: {@link RsaKeyUtils#getPrivateKey(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"java.security.PrivateKey RsaKeyUtils.getPrivateKey(String)"})
  public void testGetPrivateKey_whenLf_thenThrowUnexpectedAuthException() {
    // Arrange, Act and Assert
    thrown.expect(UnexpectedAuthException.class);
    rsaKeyUtils.getPrivateKey("\n");
  }

  /**
   * Test {@link RsaKeyUtils#getPrivateKey(String)}.
   *
   * <ul>
   *   <li>When {@code Private Key}.
   *   <li>Then throw {@link UnexpectedAuthException}.
   * </ul>
   *
   * <p>Method under test: {@link RsaKeyUtils#getPrivateKey(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"java.security.PrivateKey RsaKeyUtils.getPrivateKey(String)"})
  public void testGetPrivateKey_whenPrivateKey_thenThrowUnexpectedAuthException() {
    // Arrange, Act and Assert
    thrown.expect(UnexpectedAuthException.class);
    rsaKeyUtils.getPrivateKey("Private Key");
  }

  /**
   * Test {@link RsaKeyUtils#getPrivateKey(String)}.
   *
   * <ul>
   *   <li>When {@code RSA}.
   *   <li>Then throw {@link UnexpectedAuthException}.
   * </ul>
   *
   * <p>Method under test: {@link RsaKeyUtils#getPrivateKey(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"java.security.PrivateKey RsaKeyUtils.getPrivateKey(String)"})
  public void testGetPrivateKey_whenRsa_thenThrowUnexpectedAuthException() {
    // Arrange, Act and Assert
    thrown.expect(UnexpectedAuthException.class);
    rsaKeyUtils.getPrivateKey("RSA");
  }

  /**
   * Test {@link RsaKeyUtils#getPublicKey(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then throw {@link UnexpectedAuthException}.
   * </ul>
   *
   * <p>Method under test: {@link RsaKeyUtils#getPublicKey(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"PublicKey RsaKeyUtils.getPublicKey(String)"})
  public void testGetPublicKey_when42_thenThrowUnexpectedAuthException() {
    // Arrange, Act and Assert
    thrown.expect(UnexpectedAuthException.class);
    rsaKeyUtils.getPublicKey("42");
  }

  /**
   * Test {@link RsaKeyUtils#getPublicKey(String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then throw {@link UnexpectedAuthException}.
   * </ul>
   *
   * <p>Method under test: {@link RsaKeyUtils#getPublicKey(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"PublicKey RsaKeyUtils.getPublicKey(String)"})
  public void testGetPublicKey_whenEmptyString_thenThrowUnexpectedAuthException() {
    // Arrange, Act and Assert
    thrown.expect(UnexpectedAuthException.class);
    rsaKeyUtils.getPublicKey("");
  }

  /**
   * Test {@link RsaKeyUtils#getPublicKey(String)}.
   *
   * <ul>
   *   <li>When {@code integration.authorization.invalid.publickey}.
   * </ul>
   *
   * <p>Method under test: {@link RsaKeyUtils#getPublicKey(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"PublicKey RsaKeyUtils.getPublicKey(String)"})
  public void testGetPublicKey_whenIntegrationAuthorizationInvalidPublickey() {
    // Arrange, Act and Assert
    thrown.expect(UnexpectedAuthException.class);
    rsaKeyUtils.getPublicKey("integration.authorization.invalid.publickey");
  }

  /**
   * Test {@link RsaKeyUtils#getPublicKey(String)}.
   *
   * <ul>
   *   <li>When {@code Public Key}.
   *   <li>Then throw {@link UnexpectedAuthException}.
   * </ul>
   *
   * <p>Method under test: {@link RsaKeyUtils#getPublicKey(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"PublicKey RsaKeyUtils.getPublicKey(String)"})
  public void testGetPublicKey_whenPublicKey_thenThrowUnexpectedAuthException() {
    // Arrange, Act and Assert
    thrown.expect(UnexpectedAuthException.class);
    rsaKeyUtils.getPublicKey("Public Key");
  }

  /**
   * Test {@link RsaKeyUtils#getPublicKey(String)}.
   *
   * <ul>
   *   <li>When {@code RSA}.
   *   <li>Then throw {@link UnexpectedAuthException}.
   * </ul>
   *
   * <p>Method under test: {@link RsaKeyUtils#getPublicKey(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"PublicKey RsaKeyUtils.getPublicKey(String)"})
  public void testGetPublicKey_whenRsa_thenThrowUnexpectedAuthException() {
    // Arrange, Act and Assert
    thrown.expect(UnexpectedAuthException.class);
    rsaKeyUtils.getPublicKey("RSA");
  }

  /**
   * Test {@link RsaKeyUtils#trimPrivateKey(String)}.
   *
   * <p>Method under test: {@link RsaKeyUtils#trimPrivateKey(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String RsaKeyUtils.trimPrivateKey(String)"})
  public void testTrimPrivateKey() {
    // Arrange, Act and Assert
    assertEquals("Private Key", rsaKeyUtils.trimPrivateKey("Private Key"));
  }

  /**
   * Test {@link RsaKeyUtils#trimPublicKey(String)}.
   *
   * <p>Method under test: {@link RsaKeyUtils#trimPublicKey(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String RsaKeyUtils.trimPublicKey(String)"})
  public void testTrimPublicKey() {
    // Arrange, Act and Assert
    assertEquals("Public Key", rsaKeyUtils.trimPublicKey("Public Key"));
  }

  /**
   * Test {@link RsaKeyUtils#getPublicKeyFromCertificate(String)}.
   *
   * <ul>
   *   <li>When {@code -----BEGIN CERTIFICATE-----}.
   * </ul>
   *
   * <p>Method under test: {@link RsaKeyUtils#getPublicKeyFromCertificate(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"PublicKey RsaKeyUtils.getPublicKeyFromCertificate(String)"})
  public void testGetPublicKeyFromCertificate_whenBeginCertificate() {
    // Arrange, Act and Assert
    thrown.expect(UnexpectedAuthException.class);
    rsaKeyUtils.getPublicKeyFromCertificate("-----BEGIN CERTIFICATE-----");
  }

  /**
   * Test {@link RsaKeyUtils#getPublicKeyFromCertificate(String)}.
   *
   * <ul>
   *   <li>When {@code Certificate}.
   * </ul>
   *
   * <p>Method under test: {@link RsaKeyUtils#getPublicKeyFromCertificate(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"PublicKey RsaKeyUtils.getPublicKeyFromCertificate(String)"})
  public void testGetPublicKeyFromCertificate_whenCertificate() {
    // Arrange, Act and Assert
    thrown.expect(UnexpectedAuthException.class);
    rsaKeyUtils.getPublicKeyFromCertificate("Certificate");
  }

  /**
   * Test {@link RsaKeyUtils#getPublicKeyFromCertificate(String)}.
   *
   * <ul>
   *   <li>When {@code Component:}.
   * </ul>
   *
   * <p>Method under test: {@link RsaKeyUtils#getPublicKeyFromCertificate(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"PublicKey RsaKeyUtils.getPublicKeyFromCertificate(String)"})
  public void testGetPublicKeyFromCertificate_whenComponent() {
    // Arrange, Act and Assert
    thrown.expect(UnexpectedAuthException.class);
    rsaKeyUtils.getPublicKeyFromCertificate("Component: ");
  }

  /**
   * Test {@link RsaKeyUtils#getPublicKeyFromCertificate(String)}.
   *
   * <ul>
   *   <li>When {@code integration.authorization.invalid.certificate}.
   * </ul>
   *
   * <p>Method under test: {@link RsaKeyUtils#getPublicKeyFromCertificate(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"PublicKey RsaKeyUtils.getPublicKeyFromCertificate(String)"})
  public void testGetPublicKeyFromCertificate_whenIntegrationAuthorizationInvalidCertificate() {
    // Arrange, Act and Assert
    thrown.expect(UnexpectedAuthException.class);
    rsaKeyUtils.getPublicKeyFromCertificate("integration.authorization.invalid.certificate");
  }

  /**
   * Test {@link RsaKeyUtils#getPublicKeyFromCertificate(String)}.
   *
   * <ul>
   *   <li>When {@code X.509}.
   * </ul>
   *
   * <p>Method under test: {@link RsaKeyUtils#getPublicKeyFromCertificate(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"PublicKey RsaKeyUtils.getPublicKeyFromCertificate(String)"})
  public void testGetPublicKeyFromCertificate_whenX509() {
    // Arrange, Act and Assert
    thrown.expect(UnexpectedAuthException.class);
    rsaKeyUtils.getPublicKeyFromCertificate("X.509");
  }

  /**
   * Test {@link RsaKeyUtils#parsePublicKey(PublicKey)}.
   *
   * <p>Method under test: {@link RsaKeyUtils#parsePublicKey(PublicKey)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String RsaKeyUtils.parsePublicKey(PublicKey)"})
  public void testParsePublicKey() {
    // Arrange, Act and Assert
    thrown.expect(UnexpectedAuthException.class);
    rsaKeyUtils.parsePublicKey(null);
  }
}
