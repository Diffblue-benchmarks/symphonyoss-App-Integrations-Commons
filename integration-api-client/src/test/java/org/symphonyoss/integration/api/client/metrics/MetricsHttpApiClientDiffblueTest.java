package org.symphonyoss.integration.api.client.metrics;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.codahale.metrics.Timer;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import org.mockito.Mockito;
import org.symphonyoss.integration.api.client.HttpApiClient;
import org.symphonyoss.integration.api.client.HttpApiClientDecorator;
import org.symphonyoss.integration.exception.RemoteApiException;

public class MetricsHttpApiClientDiffblueTest {
  /**
   * Method under test:
   * {@link MetricsHttpApiClient#doGet(String, Map, Map, Class)}
   */
  @Test
  public void testDoGet() throws RemoteApiException {
    // Arrange
    ApiMetricsController controller = mock(ApiMetricsController.class);
    when(controller.startApiCall(Mockito.<String>any())).thenReturn(null);
    doNothing().when(controller).finishApiCall(Mockito.<Timer.Context>any(), Mockito.<String>any(), anyBoolean());
    HttpApiClient apiClient = mock(HttpApiClient.class);
    when(apiClient.doGet(Mockito.<String>any(), Mockito.<Map<String, String>>any(), Mockito.<Map<String, String>>any(),
        Mockito.<Class<Object>>any())).thenReturn("Do Get");
    MetricsHttpApiClient metricsHttpApiClient = new MetricsHttpApiClient(controller,
        new HttpApiClientDecorator(apiClient));
    HashMap<String, String> headerParams = new HashMap<>();
    HashMap<String, String> queryParams = new HashMap<>();
    Class<Object> returnType = Object.class;

    // Act
    Object actualDoGetResult = metricsHttpApiClient.doGet("https://example.org/example", headerParams, queryParams,
        returnType);

    // Assert
    verify(apiClient).doGet(Mockito.<String>any(), isA(Map.class), isA(Map.class), isA(Class.class));
    verify(controller).finishApiCall(Mockito.<Timer.Context>any(), Mockito.<String>any(), anyBoolean());
    verify(controller).startApiCall(Mockito.<String>any());
    assertEquals("Do Get", actualDoGetResult);
  }

  /**
   * Method under test:
   * {@link MetricsHttpApiClient#doGet(String, Map, Map, Class)}
   */
  @Test
  public void testDoGet2() throws RemoteApiException {
    // Arrange
    ApiMetricsController controller = mock(ApiMetricsController.class);
    when(controller.startApiCall(Mockito.<String>any())).thenReturn(null);
    doNothing().when(controller).finishApiCall(Mockito.<Timer.Context>any(), Mockito.<String>any(), anyBoolean());
    HttpApiClient apiClient = mock(HttpApiClient.class);
    when(apiClient.doGet(Mockito.<String>any(), Mockito.<Map<String, String>>any(), Mockito.<Map<String, String>>any(),
        Mockito.<Class<Object>>any())).thenReturn(true);
    MetricsHttpApiClient metricsHttpApiClient = new MetricsHttpApiClient(controller,
        new HttpApiClientDecorator(apiClient));
    HashMap<String, String> headerParams = new HashMap<>();
    HashMap<String, String> queryParams = new HashMap<>();
    Class<Object> returnType = Object.class;

    // Act
    metricsHttpApiClient.doGet("https://example.org/example", headerParams, queryParams, returnType);

    // Assert
    verify(apiClient).doGet(Mockito.<String>any(), isA(Map.class), isA(Map.class), isA(Class.class));
    verify(controller).finishApiCall(Mockito.<Timer.Context>any(), Mockito.<String>any(), anyBoolean());
    verify(controller).startApiCall(Mockito.<String>any());
  }

  /**
   * Method under test:
   * {@link MetricsHttpApiClient#doGet(String, Map, Map, Class)}
   */
  @Test
  public void testDoGet3() throws RemoteApiException {
    // Arrange
    ApiMetricsController controller = mock(ApiMetricsController.class);
    when(controller.startApiCall(Mockito.<String>any())).thenReturn(null);
    doNothing().when(controller).finishApiCall(Mockito.<Timer.Context>any(), Mockito.<String>any(), anyBoolean());
    HttpApiClient apiClient = mock(HttpApiClient.class);
    when(apiClient.doGet(Mockito.<String>any(), Mockito.<Map<String, String>>any(), Mockito.<Map<String, String>>any(),
        Mockito.<Class<Object>>any())).thenReturn(false);
    MetricsHttpApiClient metricsHttpApiClient = new MetricsHttpApiClient(controller,
        new HttpApiClientDecorator(apiClient));
    HashMap<String, String> headerParams = new HashMap<>();
    HashMap<String, String> queryParams = new HashMap<>();
    Class<Object> returnType = Object.class;

    // Act
    metricsHttpApiClient.doGet("https://example.org/example", headerParams, queryParams, returnType);

    // Assert
    verify(apiClient).doGet(Mockito.<String>any(), isA(Map.class), isA(Map.class), isA(Class.class));
    verify(controller).finishApiCall(Mockito.<Timer.Context>any(), Mockito.<String>any(), anyBoolean());
    verify(controller).startApiCall(Mockito.<String>any());
  }

  /**
   * Method under test:
   * {@link MetricsHttpApiClient#doPost(String, Map, Map, Object, Class)}
   */
  @Test
  public void testDoPost() throws RemoteApiException {
    // Arrange
    ApiMetricsController controller = mock(ApiMetricsController.class);
    when(controller.startApiCall(Mockito.<String>any())).thenReturn(null);
    doNothing().when(controller).finishApiCall(Mockito.<Timer.Context>any(), Mockito.<String>any(), anyBoolean());
    HttpApiClient apiClient = mock(HttpApiClient.class);
    when(apiClient.doPost(Mockito.<String>any(), Mockito.<Map<String, String>>any(), Mockito.<Map<String, String>>any(),
        Mockito.<Object>any(), Mockito.<Class<Object>>any())).thenReturn("Do Post");
    MetricsHttpApiClient metricsHttpApiClient = new MetricsHttpApiClient(controller,
        new HttpApiClientDecorator(apiClient));
    HashMap<String, String> headerParams = new HashMap<>();
    HashMap<String, String> queryParams = new HashMap<>();
    Class<Object> returnType = Object.class;

    // Act
    Object actualDoPostResult = metricsHttpApiClient.doPost("https://example.org/example", headerParams, queryParams,
        "Payload", returnType);

    // Assert
    verify(apiClient).doPost(Mockito.<String>any(), isA(Map.class), isA(Map.class), isA(Object.class),
        isA(Class.class));
    verify(controller).finishApiCall(Mockito.<Timer.Context>any(), Mockito.<String>any(), anyBoolean());
    verify(controller).startApiCall(Mockito.<String>any());
    assertEquals("Do Post", actualDoPostResult);
  }

  /**
   * Method under test:
   * {@link MetricsHttpApiClient#doPost(String, Map, Map, Object, Class)}
   */
  @Test
  public void testDoPost2() throws RemoteApiException {
    // Arrange
    ApiMetricsController controller = mock(ApiMetricsController.class);
    when(controller.startApiCall(Mockito.<String>any())).thenReturn(null);
    doNothing().when(controller).finishApiCall(Mockito.<Timer.Context>any(), Mockito.<String>any(), anyBoolean());
    HttpApiClient apiClient = mock(HttpApiClient.class);
    when(apiClient.doPost(Mockito.<String>any(), Mockito.<Map<String, String>>any(), Mockito.<Map<String, String>>any(),
        Mockito.<Object>any(), Mockito.<Class<Object>>any())).thenReturn(true);
    MetricsHttpApiClient metricsHttpApiClient = new MetricsHttpApiClient(controller,
        new HttpApiClientDecorator(apiClient));
    HashMap<String, String> headerParams = new HashMap<>();
    HashMap<String, String> queryParams = new HashMap<>();
    Class<Object> returnType = Object.class;

    // Act
    metricsHttpApiClient.doPost("https://example.org/example", headerParams, queryParams, "Payload", returnType);

    // Assert
    verify(apiClient).doPost(Mockito.<String>any(), isA(Map.class), isA(Map.class), isA(Object.class),
        isA(Class.class));
    verify(controller).finishApiCall(Mockito.<Timer.Context>any(), Mockito.<String>any(), anyBoolean());
    verify(controller).startApiCall(Mockito.<String>any());
  }

  /**
   * Method under test:
   * {@link MetricsHttpApiClient#doPost(String, Map, Map, Object, Class)}
   */
  @Test
  public void testDoPost3() throws RemoteApiException {
    // Arrange
    ApiMetricsController controller = mock(ApiMetricsController.class);
    when(controller.startApiCall(Mockito.<String>any())).thenReturn(null);
    doNothing().when(controller).finishApiCall(Mockito.<Timer.Context>any(), Mockito.<String>any(), anyBoolean());
    HttpApiClient apiClient = mock(HttpApiClient.class);
    when(apiClient.doPost(Mockito.<String>any(), Mockito.<Map<String, String>>any(), Mockito.<Map<String, String>>any(),
        Mockito.<Object>any(), Mockito.<Class<Object>>any())).thenReturn(false);
    MetricsHttpApiClient metricsHttpApiClient = new MetricsHttpApiClient(controller,
        new HttpApiClientDecorator(apiClient));
    HashMap<String, String> headerParams = new HashMap<>();
    HashMap<String, String> queryParams = new HashMap<>();
    Class<Object> returnType = Object.class;

    // Act
    metricsHttpApiClient.doPost("https://example.org/example", headerParams, queryParams, "Payload", returnType);

    // Assert
    verify(apiClient).doPost(Mockito.<String>any(), isA(Map.class), isA(Map.class), isA(Object.class),
        isA(Class.class));
    verify(controller).finishApiCall(Mockito.<Timer.Context>any(), Mockito.<String>any(), anyBoolean());
    verify(controller).startApiCall(Mockito.<String>any());
  }

  /**
   * Method under test:
   * {@link MetricsHttpApiClient#doPut(String, Map, Map, Object, Class)}
   */
  @Test
  public void testDoPut() throws RemoteApiException {
    // Arrange
    ApiMetricsController controller = mock(ApiMetricsController.class);
    when(controller.startApiCall(Mockito.<String>any())).thenReturn(null);
    doNothing().when(controller).finishApiCall(Mockito.<Timer.Context>any(), Mockito.<String>any(), anyBoolean());
    HttpApiClient apiClient = mock(HttpApiClient.class);
    when(apiClient.doPut(Mockito.<String>any(), Mockito.<Map<String, String>>any(), Mockito.<Map<String, String>>any(),
        Mockito.<Object>any(), Mockito.<Class<Object>>any())).thenReturn("Do Put");
    MetricsHttpApiClient metricsHttpApiClient = new MetricsHttpApiClient(controller,
        new HttpApiClientDecorator(apiClient));
    HashMap<String, String> headerParams = new HashMap<>();
    HashMap<String, String> queryParams = new HashMap<>();
    Class<Object> returnType = Object.class;

    // Act
    Object actualDoPutResult = metricsHttpApiClient.doPut("https://example.org/example", headerParams, queryParams,
        "Payload", returnType);

    // Assert
    verify(apiClient).doPut(Mockito.<String>any(), isA(Map.class), isA(Map.class), isA(Object.class), isA(Class.class));
    verify(controller).finishApiCall(Mockito.<Timer.Context>any(), Mockito.<String>any(), anyBoolean());
    verify(controller).startApiCall(Mockito.<String>any());
    assertEquals("Do Put", actualDoPutResult);
  }

  /**
   * Method under test:
   * {@link MetricsHttpApiClient#doPut(String, Map, Map, Object, Class)}
   */
  @Test
  public void testDoPut2() throws RemoteApiException {
    // Arrange
    ApiMetricsController controller = mock(ApiMetricsController.class);
    when(controller.startApiCall(Mockito.<String>any())).thenReturn(null);
    doNothing().when(controller).finishApiCall(Mockito.<Timer.Context>any(), Mockito.<String>any(), anyBoolean());
    HttpApiClient apiClient = mock(HttpApiClient.class);
    when(apiClient.doPut(Mockito.<String>any(), Mockito.<Map<String, String>>any(), Mockito.<Map<String, String>>any(),
        Mockito.<Object>any(), Mockito.<Class<Object>>any())).thenReturn(true);
    MetricsHttpApiClient metricsHttpApiClient = new MetricsHttpApiClient(controller,
        new HttpApiClientDecorator(apiClient));
    HashMap<String, String> headerParams = new HashMap<>();
    HashMap<String, String> queryParams = new HashMap<>();
    Class<Object> returnType = Object.class;

    // Act
    metricsHttpApiClient.doPut("https://example.org/example", headerParams, queryParams, "Payload", returnType);

    // Assert
    verify(apiClient).doPut(Mockito.<String>any(), isA(Map.class), isA(Map.class), isA(Object.class), isA(Class.class));
    verify(controller).finishApiCall(Mockito.<Timer.Context>any(), Mockito.<String>any(), anyBoolean());
    verify(controller).startApiCall(Mockito.<String>any());
  }

  /**
   * Method under test:
   * {@link MetricsHttpApiClient#doPut(String, Map, Map, Object, Class)}
   */
  @Test
  public void testDoPut3() throws RemoteApiException {
    // Arrange
    ApiMetricsController controller = mock(ApiMetricsController.class);
    when(controller.startApiCall(Mockito.<String>any())).thenReturn(null);
    doNothing().when(controller).finishApiCall(Mockito.<Timer.Context>any(), Mockito.<String>any(), anyBoolean());
    HttpApiClient apiClient = mock(HttpApiClient.class);
    when(apiClient.doPut(Mockito.<String>any(), Mockito.<Map<String, String>>any(), Mockito.<Map<String, String>>any(),
        Mockito.<Object>any(), Mockito.<Class<Object>>any())).thenReturn(false);
    MetricsHttpApiClient metricsHttpApiClient = new MetricsHttpApiClient(controller,
        new HttpApiClientDecorator(apiClient));
    HashMap<String, String> headerParams = new HashMap<>();
    HashMap<String, String> queryParams = new HashMap<>();
    Class<Object> returnType = Object.class;

    // Act
    metricsHttpApiClient.doPut("https://example.org/example", headerParams, queryParams, "Payload", returnType);

    // Assert
    verify(apiClient).doPut(Mockito.<String>any(), isA(Map.class), isA(Map.class), isA(Object.class), isA(Class.class));
    verify(controller).finishApiCall(Mockito.<Timer.Context>any(), Mockito.<String>any(), anyBoolean());
    verify(controller).startApiCall(Mockito.<String>any());
  }

  /**
   * Method under test:
   * {@link MetricsHttpApiClient#doDelete(String, Map, Map, Class)}
   */
  @Test
  public void testDoDelete() throws RemoteApiException {
    // Arrange
    ApiMetricsController controller = mock(ApiMetricsController.class);
    when(controller.startApiCall(Mockito.<String>any())).thenReturn(null);
    doNothing().when(controller).finishApiCall(Mockito.<Timer.Context>any(), Mockito.<String>any(), anyBoolean());
    HttpApiClient apiClient = mock(HttpApiClient.class);
    when(apiClient.doDelete(Mockito.<String>any(), Mockito.<Map<String, String>>any(),
        Mockito.<Map<String, String>>any(), Mockito.<Class<Object>>any())).thenReturn("Do Delete");
    MetricsHttpApiClient metricsHttpApiClient = new MetricsHttpApiClient(controller,
        new HttpApiClientDecorator(apiClient));
    HashMap<String, String> headerParams = new HashMap<>();
    HashMap<String, String> queryParams = new HashMap<>();
    Class<Object> returnType = Object.class;

    // Act
    Object actualDoDeleteResult = metricsHttpApiClient.doDelete("https://example.org/example", headerParams,
        queryParams, returnType);

    // Assert
    verify(apiClient).doDelete(Mockito.<String>any(), isA(Map.class), isA(Map.class), isA(Class.class));
    verify(controller).finishApiCall(Mockito.<Timer.Context>any(), Mockito.<String>any(), anyBoolean());
    verify(controller).startApiCall(Mockito.<String>any());
    assertEquals("Do Delete", actualDoDeleteResult);
  }

  /**
   * Method under test:
   * {@link MetricsHttpApiClient#doDelete(String, Map, Map, Class)}
   */
  @Test
  public void testDoDelete2() throws RemoteApiException {
    // Arrange
    ApiMetricsController controller = mock(ApiMetricsController.class);
    when(controller.startApiCall(Mockito.<String>any())).thenReturn(null);
    doNothing().when(controller).finishApiCall(Mockito.<Timer.Context>any(), Mockito.<String>any(), anyBoolean());
    HttpApiClient apiClient = mock(HttpApiClient.class);
    when(apiClient.doDelete(Mockito.<String>any(), Mockito.<Map<String, String>>any(),
        Mockito.<Map<String, String>>any(), Mockito.<Class<Object>>any())).thenReturn(true);
    MetricsHttpApiClient metricsHttpApiClient = new MetricsHttpApiClient(controller,
        new HttpApiClientDecorator(apiClient));
    HashMap<String, String> headerParams = new HashMap<>();
    HashMap<String, String> queryParams = new HashMap<>();
    Class<Object> returnType = Object.class;

    // Act
    metricsHttpApiClient.doDelete("https://example.org/example", headerParams, queryParams, returnType);

    // Assert
    verify(apiClient).doDelete(Mockito.<String>any(), isA(Map.class), isA(Map.class), isA(Class.class));
    verify(controller).finishApiCall(Mockito.<Timer.Context>any(), Mockito.<String>any(), anyBoolean());
    verify(controller).startApiCall(Mockito.<String>any());
  }

  /**
   * Method under test:
   * {@link MetricsHttpApiClient#doDelete(String, Map, Map, Class)}
   */
  @Test
  public void testDoDelete3() throws RemoteApiException {
    // Arrange
    ApiMetricsController controller = mock(ApiMetricsController.class);
    when(controller.startApiCall(Mockito.<String>any())).thenReturn(null);
    doNothing().when(controller).finishApiCall(Mockito.<Timer.Context>any(), Mockito.<String>any(), anyBoolean());
    HttpApiClient apiClient = mock(HttpApiClient.class);
    when(apiClient.doDelete(Mockito.<String>any(), Mockito.<Map<String, String>>any(),
        Mockito.<Map<String, String>>any(), Mockito.<Class<Object>>any())).thenReturn(false);
    MetricsHttpApiClient metricsHttpApiClient = new MetricsHttpApiClient(controller,
        new HttpApiClientDecorator(apiClient));
    HashMap<String, String> headerParams = new HashMap<>();
    HashMap<String, String> queryParams = new HashMap<>();
    Class<Object> returnType = Object.class;

    // Act
    metricsHttpApiClient.doDelete("https://example.org/example", headerParams, queryParams, returnType);

    // Assert
    verify(apiClient).doDelete(Mockito.<String>any(), isA(Map.class), isA(Map.class), isA(Class.class));
    verify(controller).finishApiCall(Mockito.<Timer.Context>any(), Mockito.<String>any(), anyBoolean());
    verify(controller).startApiCall(Mockito.<String>any());
  }
}
