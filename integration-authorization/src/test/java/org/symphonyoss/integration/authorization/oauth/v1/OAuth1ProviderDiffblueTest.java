package org.symphonyoss.integration.authorization.oauth.v1;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.net.MalformedURLException;
import java.nio.file.Paths;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class OAuth1ProviderDiffblueTest {
  /**
   * Test {@link OAuth1Provider#requestAuthorizationUrl(String)}.
   * <p>
   * Method under test: {@link OAuth1Provider#requestAuthorizationUrl(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String OAuth1Provider.requestAuthorizationUrl(String)"})
  public void testRequestAuthorizationUrl() throws MalformedURLException, OAuth1Exception {
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
   * Test {@link OAuth1Provider#requestAuthorizationUrl(String)}.
   * <p>
   * Method under test: {@link OAuth1Provider#requestAuthorizationUrl(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String OAuth1Provider.requestAuthorizationUrl(String)"})
  public void testRequestAuthorizationUrl2() throws MalformedURLException, OAuth1Exception {
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
