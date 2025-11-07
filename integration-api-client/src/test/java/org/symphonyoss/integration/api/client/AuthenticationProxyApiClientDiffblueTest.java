package org.symphonyoss.integration.api.client;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.client.Client;
import org.junit.Test;
import org.mockito.Mockito;
import org.symphonyoss.integration.authentication.AuthenticationProxy;
import org.symphonyoss.integration.authentication.api.enums.ServiceName;

public class AuthenticationProxyApiClientDiffblueTest {
  /**
   * Method under test:
   * {@link AuthenticationProxyApiClient#getClientForContext(Map, Map)}
   */
  @Test
  public void testGetClientForContext() {
    // Arrange
    AuthenticationProxy proxy = mock(AuthenticationProxy.class);
    when(proxy.httpClientForSessionToken(Mockito.<String>any(), Mockito.<ServiceName>any())).thenReturn(null);
    AuthenticationProxyApiClient authenticationProxyApiClient = new AuthenticationProxyApiClient(
        mock(EntitySerializer.class), proxy, ServiceName.POD_SESSION_MANAGER);
    HashMap<String, String> queryParams = new HashMap<>();

    HashMap<String, String> headerParams = new HashMap<>();
    headerParams.put("sessionToken", "sessionToken");

    // Act
    Client actualClientForContext = authenticationProxyApiClient.getClientForContext(queryParams, headerParams);

    // Assert
    verify(proxy).httpClientForSessionToken(Mockito.<String>any(), Mockito.<ServiceName>any());
    assertNull(actualClientForContext);
  }

  /**
   * Method under test:
   * {@link AuthenticationProxyApiClient#AuthenticationProxyApiClient(EntitySerializer, AuthenticationProxy, ServiceName)}
   */
  @Test
  public void testNewAuthenticationProxyApiClient() {
    // Arrange, Act and Assert
    assertEquals("https%3A%2F%2Fexample.org%2Fexample", (new AuthenticationProxyApiClient(mock(EntitySerializer.class),
        mock(AuthenticationProxy.class), ServiceName.POD_SESSION_MANAGER)).escapeString("https://example.org/example"));
  }
}
