package org.symphonyoss.integration.api.client;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.client.Client;
import org.junit.Test;
import org.mockito.Mockito;
import org.symphonyoss.integration.authentication.AuthenticationProxy;
import org.symphonyoss.integration.authentication.api.enums.ServiceName;

public class AuthenticationProxyApiClientDiffblueTest {
  /**
   * Test {@link AuthenticationProxyApiClient#AuthenticationProxyApiClient(EntitySerializer,
   * AuthenticationProxy, ServiceName)}.
   *
   * <p>Method under test: {@link
   * AuthenticationProxyApiClient#AuthenticationProxyApiClient(EntitySerializer,
   * AuthenticationProxy, ServiceName)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AuthenticationProxyApiClient.<init>(EntitySerializer, AuthenticationProxy, ServiceName)"
  })
  public void testNewAuthenticationProxyApiClient() {
    // Arrange and Act
    AuthenticationProxyApiClient actualAuthenticationProxyApiClient =
        new AuthenticationProxyApiClient(
            mock(EntitySerializer.class),
            mock(AuthenticationProxy.class),
            ServiceName.POD_SESSION_MANAGER);

    // Assert
    assertEquals(
        "https%3A%2F%2Fexample.org%2Fexample",
        actualAuthenticationProxyApiClient.escapeString("https://example.org/example"));
  }

  /**
   * Test {@link AuthenticationProxyApiClient#getClientForContext(Map, Map)}.
   *
   * <ul>
   *   <li>Then calls {@link AuthenticationProxy#httpClientForSessionToken(String, ServiceName)}.
   * </ul>
   *
   * <p>Method under test: {@link AuthenticationProxyApiClient#getClientForContext(Map, Map)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Client AuthenticationProxyApiClient.getClientForContext(Map, Map)"})
  public void testGetClientForContext_thenCallsHttpClientForSessionToken() {
    // Arrange
    AuthenticationProxy proxy = mock(AuthenticationProxy.class);
    when(proxy.httpClientForSessionToken(Mockito.<String>any(), Mockito.<ServiceName>any()))
        .thenReturn(null);
    AuthenticationProxyApiClient authenticationProxyApiClient =
        new AuthenticationProxyApiClient(
            mock(EntitySerializer.class), proxy, ServiceName.POD_SESSION_MANAGER);
    HashMap<String, String> queryParams = new HashMap<>();

    HashMap<String, String> headerParams = new HashMap<>();
    headerParams.put("sessionToken", "sessionToken");

    // Act
    Client actualClientForContext =
        authenticationProxyApiClient.getClientForContext(queryParams, headerParams);

    // Assert
    verify(proxy).httpClientForSessionToken(Mockito.<String>any(), Mockito.<ServiceName>any());
    assertNull(actualClientForContext);
  }
}
