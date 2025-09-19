package org.symphonyoss.integration.authorization.oauth.v1;

import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.api.client.auth.oauth.OAuthRsaSigner;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import org.junit.Test;

public class OAuth1GetTemporaryTokenDiffblueTest {
  /**
   * Test {@link OAuth1GetTemporaryToken#OAuth1GetTemporaryToken(URL, String, OAuthRsaSigner, URL)}.
   *
   * <p>Method under test: {@link OAuth1GetTemporaryToken#OAuth1GetTemporaryToken(URL, String,
   * OAuthRsaSigner, URL)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"void OAuth1GetTemporaryToken.<init>(URL, String, OAuthRsaSigner, URL)"})
  public void testNewOAuth1GetTemporaryToken() throws MalformedURLException {
    // Arrange
    URL requestTemporaryTokenUrl =
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL();
    URL authorizationCallbackUrl =
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL();

    // Act
    OAuth1GetTemporaryToken actualOAuth1GetTemporaryToken =
        new OAuth1GetTemporaryToken(
            requestTemporaryTokenUrl,
            "Consumer Key",
            new OAuthRsaSigner(),
            authorizationCallbackUrl);

    // Assert
    assertTrue(actualOAuth1GetTemporaryToken.isEmpty());
  }
}
