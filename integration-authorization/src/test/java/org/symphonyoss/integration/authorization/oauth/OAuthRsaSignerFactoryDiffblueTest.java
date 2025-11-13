package org.symphonyoss.integration.authorization.oauth;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.api.client.auth.oauth.OAuthRsaSigner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.symphonyoss.integration.utils.RsaKeyUtils;

@ContextConfiguration(classes = {OAuthRsaSignerFactory.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class OAuthRsaSignerFactoryDiffblueTest {
  @Autowired private OAuthRsaSignerFactory oAuthRsaSignerFactory;

  @MockBean private RsaKeyUtils rsaKeyUtils;

  /**
   * Test {@link OAuthRsaSignerFactory#getOAuthRsaSigner(String)}.
   *
   * <p>Method under test: {@link OAuthRsaSignerFactory#getOAuthRsaSigner(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"OAuthRsaSigner OAuthRsaSignerFactory.getOAuthRsaSigner(String)"})
  public void testGetOAuthRsaSigner() {
    // Arrange
    when(rsaKeyUtils.getPrivateKey(Mockito.<String>any())).thenReturn(null);

    // Act
    OAuthRsaSigner actualOAuthRsaSigner = oAuthRsaSignerFactory.getOAuthRsaSigner("Private Key");

    // Assert
    verify(rsaKeyUtils).getPrivateKey(Mockito.<String>any());
    assertEquals("RSA-SHA1", actualOAuthRsaSigner.getSignatureMethod());
    assertNull(actualOAuthRsaSigner.privateKey);
  }
}
