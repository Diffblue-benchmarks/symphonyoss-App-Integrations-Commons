package org.symphonyoss.integration.api.client;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.symphonyoss.integration.api.client.metrics.MetricsHttpApiClient;
import org.symphonyoss.integration.api.client.trace.TraceLoggingApiClient;
import org.symphonyoss.integration.authentication.api.enums.ServiceName;

public class SymphonyApiClientDiffblueTest {
  /**
   * Method under test: {@link SymphonyApiClient#init()}
   */
  @Test
  public void testInit() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MockSymphonyApiClient mockSymphonyApiClient = new MockSymphonyApiClient(ServiceName.POD_SESSION_MANAGER);

    // Act
    mockSymphonyApiClient.init();

    // Assert
    HttpApiClient client = mockSymphonyApiClient.getClient();
    HttpApiClient httpApiClient = ((MetricsHttpApiClient) client).apiClient;
    HttpApiClient httpApiClient2 = ((TraceLoggingApiClient) httpApiClient).apiClient;
    HttpApiClient httpApiClient3 = ((ReAuthenticationApiClient) httpApiClient2).apiClient;
    assertTrue(((ConnectivityApiClientDecorator) httpApiClient3).apiClient instanceof AuthenticationProxyApiClient);
    assertTrue(httpApiClient3 instanceof ConnectivityApiClientDecorator);
    assertTrue(httpApiClient2 instanceof ReAuthenticationApiClient);
    assertTrue(client instanceof MetricsHttpApiClient);
    assertTrue(httpApiClient instanceof TraceLoggingApiClient);
  }

  /**
   * Method under test: {@link SymphonyApiClient#buildHttpClient(String)}
   */
  @Test
  public void testBuildHttpClient() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    HttpApiClient actualBuildHttpClientResult = (new MockSymphonyApiClient(ServiceName.POD_SESSION_MANAGER))
        .buildHttpClient("https://example.org/example");

    // Assert
    HttpApiClient httpApiClient = ((MetricsHttpApiClient) actualBuildHttpClientResult).apiClient;
    HttpApiClient httpApiClient2 = ((TraceLoggingApiClient) httpApiClient).apiClient;
    HttpApiClient httpApiClient3 = ((ReAuthenticationApiClient) httpApiClient2).apiClient;
    assertTrue(((ConnectivityApiClientDecorator) httpApiClient3).apiClient instanceof AuthenticationProxyApiClient);
    assertTrue(httpApiClient3 instanceof ConnectivityApiClientDecorator);
    assertTrue(httpApiClient2 instanceof ReAuthenticationApiClient);
    assertTrue(actualBuildHttpClientResult instanceof MetricsHttpApiClient);
    assertTrue(httpApiClient instanceof TraceLoggingApiClient);
  }

  /**
   * Method under test: {@link SymphonyApiClient#getClient()}
   */
  @Test
  public void testGetClient() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new MockSymphonyApiClient(ServiceName.POD_SESSION_MANAGER)).getClient());
  }
}
