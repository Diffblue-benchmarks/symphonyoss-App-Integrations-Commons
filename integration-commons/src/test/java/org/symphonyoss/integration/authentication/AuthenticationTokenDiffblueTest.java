package org.symphonyoss.integration.authentication;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class AuthenticationTokenDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AuthenticationToken#getAuthenticationTime()}
   *   <li>{@link AuthenticationToken#getKeyManagerToken()}
   *   <li>{@link AuthenticationToken#getSessionToken()}
   * </ul>
   */
  @Test
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

  /**
   * Method under test:
   * {@link AuthenticationToken#AuthenticationToken(String, String)}
   */
  @Test
  public void testNewAuthenticationToken() {
    // Arrange and Act
    AuthenticationToken actualAuthenticationToken = new AuthenticationToken("ABC123", "ABC123");

    // Assert
    assertEquals("ABC123", actualAuthenticationToken.getKeyManagerToken());
    assertEquals("ABC123", actualAuthenticationToken.getSessionToken());
  }

  /**
   * Method under test:
   * {@link AuthenticationToken#AuthenticationToken(String, String)}
   */
  @Test
  public void testNewAuthenticationToken2() {
    // Arrange and Act
    AuthenticationToken actualAuthenticationToken = new AuthenticationToken(null, null);

    // Assert
    assertEquals(0L, actualAuthenticationToken.getAuthenticationTime());
    assertEquals(AuthenticationToken.VOID_KM_TOKEN, actualAuthenticationToken.getKeyManagerToken());
    assertEquals(AuthenticationToken.VOID_KM_TOKEN, actualAuthenticationToken.getSessionToken());
  }

  /**
   * Method under test:
   * {@link AuthenticationToken#AuthenticationToken(String, String)}
   */
  @Test
  public void testNewAuthenticationToken3() {
    // Arrange and Act
    AuthenticationToken actualAuthenticationToken = new AuthenticationToken("ABC123", null);

    // Assert
    assertEquals(0L, actualAuthenticationToken.getAuthenticationTime());
    assertEquals(AuthenticationToken.VOID_KM_TOKEN, actualAuthenticationToken.getKeyManagerToken());
    assertEquals(AuthenticationToken.VOID_KM_TOKEN, actualAuthenticationToken.getSessionToken());
  }

  /**
   * Method under test:
   * {@link AuthenticationToken#AuthenticationToken(String, String)}
   */
  @Test
  public void testNewAuthenticationToken4() {
    // Arrange and Act
    AuthenticationToken actualAuthenticationToken = new AuthenticationToken("", "ABC123");

    // Assert
    assertEquals(0L, actualAuthenticationToken.getAuthenticationTime());
    assertEquals(AuthenticationToken.VOID_KM_TOKEN, actualAuthenticationToken.getKeyManagerToken());
    assertEquals(AuthenticationToken.VOID_KM_TOKEN, actualAuthenticationToken.getSessionToken());
  }
}
