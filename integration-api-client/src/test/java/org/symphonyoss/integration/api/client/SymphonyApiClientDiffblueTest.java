package org.symphonyoss.integration.api.client;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.symphonyoss.integration.api.client.metrics.MetricsHttpApiClient;
import org.symphonyoss.integration.api.client.trace.TraceLoggingApiClient;
import org.symphonyoss.integration.authentication.api.enums.ServiceName;

public class SymphonyApiClientDiffblueTest {
  /**
   * Test {@link SymphonyApiClient#init()}.
   * <p>
   * Method under test: {@link SymphonyApiClient#init()}
   */
  @Test
  @MethodsUnderTest({"void SymphonyApiClient.init()"})
  public void testInit() {
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
   * Test {@link SymphonyApiClient#buildHttpClient(String)}.
   * <p>
   * Method under test: {@link SymphonyApiClient#buildHttpClient(String)}
   */
  @Test
  @MethodsUnderTest({"HttpApiClient SymphonyApiClient.buildHttpClient(String)"})
  public void testBuildHttpClient() {
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
   * Test {@link SymphonyApiClient#getClient()}.
   * <p>
   * Method under test: {@link SymphonyApiClient#getClient()}
   */
  @Test
  @MethodsUnderTest({"HttpApiClient SymphonyApiClient.getClient()"})
  public void testGetClient() {
    // Arrange, Act and Assert
    assertNull((new MockSymphonyApiClient(ServiceName.POD_SESSION_MANAGER)).getClient());
  }
}
