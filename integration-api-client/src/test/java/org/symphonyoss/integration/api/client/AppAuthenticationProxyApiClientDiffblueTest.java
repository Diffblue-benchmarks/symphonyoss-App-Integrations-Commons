package org.symphonyoss.integration.api.client;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import org.junit.Test;
import org.symphonyoss.integration.authentication.api.AppAuthenticationProxy;
import org.symphonyoss.integration.authentication.api.enums.ServiceName;

public class AppAuthenticationProxyApiClientDiffblueTest {
  /**
   * Method under test:
   * {@link AppAuthenticationProxyApiClient#AppAuthenticationProxyApiClient(EntitySerializer, AppAuthenticationProxy, ServiceName)}
   */
  @Test
  public void testNewAppAuthenticationProxyApiClient() {
    // Arrange, Act and Assert
    assertEquals("https%3A%2F%2Fexample.org%2Fexample",
        (new AppAuthenticationProxyApiClient(mock(EntitySerializer.class), mock(AppAuthenticationProxy.class),
            ServiceName.POD_SESSION_MANAGER)).escapeString("https://example.org/example"));
  }
}
