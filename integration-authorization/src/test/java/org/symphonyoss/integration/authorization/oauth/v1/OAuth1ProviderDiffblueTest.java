package org.symphonyoss.integration.authorization.oauth.v1;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import org.junit.Test;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class OAuth1ProviderDiffblueTest {
  /**
   * Test {@link OAuth1Provider#requestAuthorizationUrl(String)}.
   *
   * <p>Method under test: {@link OAuth1Provider#requestAuthorizationUrl(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String OAuth1Provider.requestAuthorizationUrl(String)"})
  public void testRequestAuthorizationUrl() throws MalformedURLException, OAuth1Exception {
    // Arrange
    URL requestTemporaryTokenUrl =
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL();
    URL authorizationCallbackUrl =
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL();
    URL authorizeTemporaryTokenUrl =
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL();
    URL requestAccessTokenUrl =
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL();

    OAuth1ProviderMock oAuth1ProviderMock =
        new OAuth1ProviderMock(
            "Consumer Key",
            "Private Key",
            requestTemporaryTokenUrl,
            authorizationCallbackUrl,
            authorizeTemporaryTokenUrl,
            requestAccessTokenUrl);

    // Act
    String actualRequestAuthorizationUrlResult =
        oAuth1ProviderMock.requestAuthorizationUrl("https://example.org/example");

    // Assert
    String expectedRequestAuthorizationUrlResult =
        String.join(
            "",
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toString(),
            "?oauth_token=https://example.org/example");
    assertEquals(expectedRequestAuthorizationUrlResult, actualRequestAuthorizationUrlResult);
  }

  /**
   * Test {@link OAuth1Provider#requestAuthorizationUrl(String)}.
   *
   * <p>Method under test: {@link OAuth1Provider#requestAuthorizationUrl(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String OAuth1Provider.requestAuthorizationUrl(String)"})
  public void testRequestAuthorizationUrl2() throws MalformedURLException, OAuth1Exception {
    // Arrange
    URL requestTemporaryTokenUrl =
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL();
    URL authorizationCallbackUrl =
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL();
    URL authorizeTemporaryTokenUrl =
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL();
    URL requestAccessTokenUrl =
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL();

    OAuth1ProviderMock oAuth1ProviderMock =
        new OAuth1ProviderMock(
            "Consumer Key",
            "Private Key",
            requestTemporaryTokenUrl,
            authorizationCallbackUrl,
            authorizeTemporaryTokenUrl,
            requestAccessTokenUrl);

    // Act
    String actualRequestAuthorizationUrlResult =
        oAuth1ProviderMock.requestAuthorizationUrl("Temporary Token");

    // Assert
    String expectedRequestAuthorizationUrlResult =
        String.join(
            "",
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toString(),
            "?oauth_token=Temporary%20Token");
    assertEquals(expectedRequestAuthorizationUrlResult, actualRequestAuthorizationUrlResult);
  }

  /**
   * Test {@link OAuth1Provider#requestAuthorizationUrl(String)}.
   *
   * <p>Method under test: {@link OAuth1Provider#requestAuthorizationUrl(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String OAuth1Provider.requestAuthorizationUrl(String)"})
  public void testRequestAuthorizationUrl3() throws MalformedURLException, OAuth1Exception {
    // Arrange
    URL requestTemporaryTokenUrl =
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL();
    URL authorizationCallbackUrl =
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL();
    URL authorizeTemporaryTokenUrl =
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL();
    URL requestAccessTokenUrl =
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL();

    OAuth1ProviderMock oAuth1ProviderMock =
        new OAuth1ProviderMock(
            "Consumer Key",
            "Private Key",
            requestTemporaryTokenUrl,
            authorizationCallbackUrl,
            authorizeTemporaryTokenUrl,
            requestAccessTokenUrl);

    // Act
    String actualRequestAuthorizationUrlResult = oAuth1ProviderMock.requestAuthorizationUrl("");

    // Assert
    String expectedRequestAuthorizationUrlResult =
        String.join(
            "",
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toString(),
            "?oauth_token");
    assertEquals(expectedRequestAuthorizationUrlResult, actualRequestAuthorizationUrlResult);
  }
}
