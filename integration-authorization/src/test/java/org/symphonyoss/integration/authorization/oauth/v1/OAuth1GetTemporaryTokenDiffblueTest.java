package org.symphonyoss.integration.authorization.oauth.v1;

import static org.junit.Assert.assertTrue;
import com.google.api.client.auth.oauth.OAuthRsaSigner;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import org.junit.Test;

public class OAuth1GetTemporaryTokenDiffblueTest {
  /**
   * Method under test:
   * {@link OAuth1GetTemporaryToken#OAuth1GetTemporaryToken(URL, String, OAuthRsaSigner, URL)}
   */
  @Test
  public void testNewOAuth1GetTemporaryToken() throws MalformedURLException {
    // Arrange
    URL requestTemporaryTokenUrl = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL();

    // Act and Assert
    assertTrue((new OAuth1GetTemporaryToken(requestTemporaryTokenUrl, "Consumer Key", new OAuthRsaSigner(),
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL())).isEmpty());
  }
}
