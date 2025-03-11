package org.symphonyoss.integration.authentication;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;

public class AuthenticationTokenDiffblueTest {
  /**
   * Test {@link AuthenticationToken#AuthenticationToken(String, String)}.
   * <ul>
   *   <li>When {@code ABC123}.</li>
   *   <li>Then return KeyManagerToken is {@code ABC123}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AuthenticationToken#AuthenticationToken(String, String)}
   */
  @Test
  @MethodsUnderTest({"void AuthenticationToken.<init>(String, String)"})
  public void testNewAuthenticationToken_whenAbc123_thenReturnKeyManagerTokenIsAbc123() {
    // Arrange and Act
    AuthenticationToken actualAuthenticationToken = new AuthenticationToken("ABC123", "ABC123");

    // Assert
    assertEquals("ABC123", actualAuthenticationToken.getKeyManagerToken());
    assertEquals("ABC123", actualAuthenticationToken.getSessionToken());
  }

  /**
   * Test {@link AuthenticationToken#AuthenticationToken(String, String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return AuthenticationTime is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link AuthenticationToken#AuthenticationToken(String, String)}
   */
  @Test
  @MethodsUnderTest({"void AuthenticationToken.<init>(String, String)"})
  public void testNewAuthenticationToken_whenEmptyString_thenReturnAuthenticationTimeIsZero() {
    // Arrange and Act
    AuthenticationToken actualAuthenticationToken = new AuthenticationToken("", "ABC123");

    // Assert
    assertEquals(0L, actualAuthenticationToken.getAuthenticationTime());
    assertEquals(AuthenticationToken.VOID_KM_TOKEN, actualAuthenticationToken.getKeyManagerToken());
    assertEquals(AuthenticationToken.VOID_KM_TOKEN, actualAuthenticationToken.getSessionToken());
  }

  /**
   * Test {@link AuthenticationToken#AuthenticationToken(String, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return AuthenticationTime is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link AuthenticationToken#AuthenticationToken(String, String)}
   */
  @Test
  @MethodsUnderTest({"void AuthenticationToken.<init>(String, String)"})
  public void testNewAuthenticationToken_whenNull_thenReturnAuthenticationTimeIsZero() {
    // Arrange and Act
    AuthenticationToken actualAuthenticationToken = new AuthenticationToken(null, null);

    // Assert
    assertEquals(0L, actualAuthenticationToken.getAuthenticationTime());
    assertEquals(AuthenticationToken.VOID_KM_TOKEN, actualAuthenticationToken.getKeyManagerToken());
    assertEquals(AuthenticationToken.VOID_KM_TOKEN, actualAuthenticationToken.getSessionToken());
  }

  /**
   * Test {@link AuthenticationToken#AuthenticationToken(String, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return AuthenticationTime is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link AuthenticationToken#AuthenticationToken(String, String)}
   */
  @Test
  @MethodsUnderTest({"void AuthenticationToken.<init>(String, String)"})
  public void testNewAuthenticationToken_whenNull_thenReturnAuthenticationTimeIsZero2() {
    // Arrange and Act
    AuthenticationToken actualAuthenticationToken = new AuthenticationToken("ABC123", null);

    // Assert
    assertEquals(0L, actualAuthenticationToken.getAuthenticationTime());
    assertEquals(AuthenticationToken.VOID_KM_TOKEN, actualAuthenticationToken.getKeyManagerToken());
    assertEquals(AuthenticationToken.VOID_KM_TOKEN, actualAuthenticationToken.getSessionToken());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AuthenticationToken#getAuthenticationTime()}
   *   <li>{@link AuthenticationToken#getKeyManagerToken()}
   *   <li>{@link AuthenticationToken#getSessionToken()}
   * </ul>
   */
  @Test
  @MethodsUnderTest({"long AuthenticationToken.getAuthenticationTime()",
      "String AuthenticationToken.getKeyManagerToken()", "String AuthenticationToken.getSessionToken()"})
  public void testGettersAndSetters() {
    // Arrange
    AuthenticationToken authenticationToken = new AuthenticationToken("ABC123", "ABC123");

    // Act
    authenticationToken.getAuthenticationTime();
    String actualKeyManagerToken = authenticationToken.getKeyManagerToken();

    // Assert
    assertEquals("ABC123", actualKeyManagerToken);
    assertEquals("ABC123", authenticationToken.getSessionToken());
  }
}
