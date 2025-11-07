package org.symphonyoss.integration.authorization.oauth.v1;

import static org.junit.Assert.assertTrue;
import com.google.api.client.auth.oauth.OAuthRsaSigner;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import org.junit.Test;

public class OAuth1GetAccessTokenDiffblueTest {
  /**
   * Method under test:
   * {@link OAuth1GetAccessToken#OAuth1GetAccessToken(URL, String, OAuthRsaSigner, String, String)}
   */
  @Test
  public void testNewOAuth1GetAccessToken() throws MalformedURLException {
    // Arrange
    URL requestAccessTokenUrl = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL();

    // Act and Assert
    assertTrue(
        (new OAuth1GetAccessToken(requestAccessTokenUrl, "Consumer Key", new OAuthRsaSigner(), "ABC123", "Verifier"))
            .isEmpty());
  }
}
