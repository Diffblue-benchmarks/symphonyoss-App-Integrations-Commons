package org.symphonyoss.integration.authorization.oauth.v1;

import static org.junit.Assert.assertEquals;
import java.net.MalformedURLException;
import java.nio.file.Paths;
import org.junit.Test;

public class OAuth1ProviderDiffblueTest {
  /**
   * Method under test: {@link OAuth1Provider#requestAuthorizationUrl(String)}
   */
  @Test
  public void testRequestAuthorizationUrl() throws MalformedURLException, OAuth1Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    String actualRequestAuthorizationUrlResult = (new OAuth1ProviderMock("Consumer Key", "Private Key",
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL(),
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL(),
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL(),
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL()))
            .requestAuthorizationUrl("https://example.org/example");

    // Assert
    assertEquals(String.join("", Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toString(),
        "?oauth_token=https://example.org/example"), actualRequestAuthorizationUrlResult);
  }

  /**
   * Method under test: {@link OAuth1Provider#requestAuthorizationUrl(String)}
   */
  @Test
  public void testRequestAuthorizationUrl2() throws MalformedURLException, OAuth1Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    String actualRequestAuthorizationUrlResult = (new OAuth1ProviderMock("Consumer Key", "Private Key",
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL(),
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL(),
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL(),
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL())).requestAuthorizationUrl("");

    // Assert
    assertEquals(
        String.join("", Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toString(), "?oauth_token"),
        actualRequestAuthorizationUrlResult);
  }
}
