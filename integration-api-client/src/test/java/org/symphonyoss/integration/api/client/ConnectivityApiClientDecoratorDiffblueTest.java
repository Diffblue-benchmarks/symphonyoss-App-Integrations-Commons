package org.symphonyoss.integration.api.client;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.symphonyoss.integration.authentication.api.enums.ServiceName;

public class ConnectivityApiClientDecoratorDiffblueTest {
  /**
   * Test {@link ConnectivityApiClientDecorator#ConnectivityApiClientDecorator(ServiceName,
   * HttpApiClient)}.
   *
   * <p>Method under test: {@link
   * ConnectivityApiClientDecorator#ConnectivityApiClientDecorator(ServiceName, HttpApiClient)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConnectivityApiClientDecorator.<init>(ServiceName, HttpApiClient)"})
  public void testNewConnectivityApiClientDecorator() {
    // Arrange
    SimpleHttpApiClient apiClient = new SimpleHttpApiClient(mock(EntitySerializer.class));
    HttpApiClientDecorator apiClient2 = new HttpApiClientDecorator(apiClient);

    // Act and Assert
    HttpApiClient httpApiClient =
        new ConnectivityApiClientDecorator(ServiceName.POD_SESSION_MANAGER, apiClient2).apiClient;
    assertTrue(httpApiClient instanceof HttpApiClientDecorator);
    HttpApiClient httpApiClient2 = ((HttpApiClientDecorator) httpApiClient).apiClient;
    assertTrue(httpApiClient2 instanceof SimpleHttpApiClient);
    assertSame(apiClient2.apiClient, httpApiClient2);
  }
}
