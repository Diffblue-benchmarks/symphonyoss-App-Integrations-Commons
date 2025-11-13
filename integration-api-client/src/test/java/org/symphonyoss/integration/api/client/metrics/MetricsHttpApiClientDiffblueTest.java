package org.symphonyoss.integration.api.client.metrics;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.codahale.metrics.Timer;
import com.codahale.metrics.Timer.Context;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import org.mockito.Mockito;
import org.symphonyoss.integration.api.client.HttpApiClient;
import org.symphonyoss.integration.api.client.HttpApiClientDecorator;
import org.symphonyoss.integration.exception.RemoteApiException;

public class MetricsHttpApiClientDiffblueTest {
  /**
   * Test {@link MetricsHttpApiClient#doGet(String, Map, Map, Class)}.
   *
   * <ul>
   *   <li>Given {@link HttpApiClient} {@link HttpApiClient#doGet(String, Map, Map, Class)} return
   *       {@code Do Get}.
   *   <li>Then return {@code Do Get}.
   * </ul>
   *
   * <p>Method under test: {@link MetricsHttpApiClient#doGet(String, Map, Map, Class)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Object MetricsHttpApiClient.doGet(String, Map, Map, Class)"})
  public void testDoGet_givenHttpApiClientDoGetReturnDoGet_thenReturnDoGet()
      throws RemoteApiException {
    // Arrange
    ApiMetricsController controller = mock(ApiMetricsController.class);
    when(controller.startApiCall(Mockito.<String>any())).thenReturn(null);
    doNothing()
        .when(controller)
        .finishApiCall(Mockito.<Context>any(), Mockito.<String>any(), anyBoolean());

    HttpApiClient apiClient = mock(HttpApiClient.class);
    when(apiClient.doGet(
            Mockito.<String>any(),
            Mockito.<Map<String, String>>any(),
            Mockito.<Map<String, String>>any(),
            Mockito.<Class<Object>>any()))
        .thenReturn("Do Get");
    HttpApiClientDecorator apiClient2 = new HttpApiClientDecorator(apiClient);

    MetricsHttpApiClient metricsHttpApiClient = new MetricsHttpApiClient(controller, apiClient2);
    HashMap<String, String> headerParams = new HashMap<>();
    HashMap<String, String> queryParams = new HashMap<>();
    Class<Object> returnType = Object.class;

    // Act
    Object actualDoGetResult =
        metricsHttpApiClient.doGet(
            "https://example.org/example", headerParams, queryParams, returnType);

    // Assert
    verify(apiClient)
        .doGet(Mockito.<String>any(), isA(Map.class), isA(Map.class), isA(Class.class));
    verify(controller).finishApiCall(Mockito.<Context>any(), Mockito.<String>any(), anyBoolean());
    verify(controller).startApiCall(Mockito.<String>any());
    assertEquals("Do Get", actualDoGetResult);
  }

  /**
   * Test {@link MetricsHttpApiClient#doGet(String, Map, Map, Class)}.
   *
   * <ul>
   *   <li>Given {@link HttpApiClient} {@link HttpApiClient#doGet(String, Map, Map, Class)} return
   *       {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MetricsHttpApiClient#doGet(String, Map, Map, Class)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Object MetricsHttpApiClient.doGet(String, Map, Map, Class)"})
  public void testDoGet_givenHttpApiClientDoGetReturnFalse_thenReturnFalse()
      throws RemoteApiException {
    // Arrange
    ApiMetricsController controller = mock(ApiMetricsController.class);
    when(controller.startApiCall(Mockito.<String>any())).thenReturn(null);
    doNothing()
        .when(controller)
        .finishApiCall(Mockito.<Context>any(), Mockito.<String>any(), anyBoolean());

    HttpApiClient apiClient = mock(HttpApiClient.class);
    when(apiClient.doGet(
            Mockito.<String>any(),
            Mockito.<Map<String, String>>any(),
            Mockito.<Map<String, String>>any(),
            Mockito.<Class<Object>>any()))
        .thenReturn(false);
    HttpApiClientDecorator apiClient2 = new HttpApiClientDecorator(apiClient);

    MetricsHttpApiClient metricsHttpApiClient = new MetricsHttpApiClient(controller, apiClient2);
    HashMap<String, String> headerParams = new HashMap<>();
    HashMap<String, String> queryParams = new HashMap<>();
    Class<Object> returnType = Object.class;

    // Act
    Object actualDoGetResult =
        metricsHttpApiClient.doGet(
            "https://example.org/example", headerParams, queryParams, returnType);

    // Assert
    verify(apiClient)
        .doGet(Mockito.<String>any(), isA(Map.class), isA(Map.class), isA(Class.class));
    verify(controller).finishApiCall(Mockito.<Context>any(), Mockito.<String>any(), anyBoolean());
    verify(controller).startApiCall(Mockito.<String>any());
    assertFalse((Boolean) actualDoGetResult);
  }

  /**
   * Test {@link MetricsHttpApiClient#doGet(String, Map, Map, Class)}.
   *
   * <ul>
   *   <li>Given {@link HttpApiClient} {@link HttpApiClient#doGet(String, Map, Map, Class)} return
   *       {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MetricsHttpApiClient#doGet(String, Map, Map, Class)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Object MetricsHttpApiClient.doGet(String, Map, Map, Class)"})
  public void testDoGet_givenHttpApiClientDoGetReturnTrue_thenReturnTrue()
      throws RemoteApiException {
    // Arrange
    ApiMetricsController controller = mock(ApiMetricsController.class);
    when(controller.startApiCall(Mockito.<String>any())).thenReturn(null);
    doNothing()
        .when(controller)
        .finishApiCall(Mockito.<Context>any(), Mockito.<String>any(), anyBoolean());

    HttpApiClient apiClient = mock(HttpApiClient.class);
    when(apiClient.doGet(
            Mockito.<String>any(),
            Mockito.<Map<String, String>>any(),
            Mockito.<Map<String, String>>any(),
            Mockito.<Class<Object>>any()))
        .thenReturn(true);
    HttpApiClientDecorator apiClient2 = new HttpApiClientDecorator(apiClient);

    MetricsHttpApiClient metricsHttpApiClient = new MetricsHttpApiClient(controller, apiClient2);
    HashMap<String, String> headerParams = new HashMap<>();
    HashMap<String, String> queryParams = new HashMap<>();
    Class<Object> returnType = Object.class;

    // Act
    Object actualDoGetResult =
        metricsHttpApiClient.doGet(
            "https://example.org/example", headerParams, queryParams, returnType);

    // Assert
    verify(apiClient)
        .doGet(Mockito.<String>any(), isA(Map.class), isA(Map.class), isA(Class.class));
    verify(controller).finishApiCall(Mockito.<Context>any(), Mockito.<String>any(), anyBoolean());
    verify(controller).startApiCall(Mockito.<String>any());
    assertTrue((Boolean) actualDoGetResult);
  }

  /**
   * Test {@link MetricsHttpApiClient#doPost(String, Map, Map, Object, Class)}.
   *
   * <ul>
   *   <li>Given {@link HttpApiClient} {@link HttpApiClient#doPost(String, Map, Map, Object, Class)}
   *       return {@code Do Post}.
   *   <li>Then return {@code Do Post}.
   * </ul>
   *
   * <p>Method under test: {@link MetricsHttpApiClient#doPost(String, Map, Map, Object, Class)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Object MetricsHttpApiClient.doPost(String, Map, Map, Object, Class)"})
  public void testDoPost_givenHttpApiClientDoPostReturnDoPost_thenReturnDoPost()
      throws RemoteApiException {
    // Arrange
    ApiMetricsController controller = mock(ApiMetricsController.class);
    when(controller.startApiCall(Mockito.<String>any())).thenReturn(null);
    doNothing()
        .when(controller)
        .finishApiCall(Mockito.<Context>any(), Mockito.<String>any(), anyBoolean());

    HttpApiClient apiClient = mock(HttpApiClient.class);
    when(apiClient.doPost(
            Mockito.<String>any(),
            Mockito.<Map<String, String>>any(),
            Mockito.<Map<String, String>>any(),
            Mockito.<Object>any(),
            Mockito.<Class<Object>>any()))
        .thenReturn("Do Post");
    HttpApiClientDecorator apiClient2 = new HttpApiClientDecorator(apiClient);

    MetricsHttpApiClient metricsHttpApiClient = new MetricsHttpApiClient(controller, apiClient2);
    HashMap<String, String> headerParams = new HashMap<>();
    HashMap<String, String> queryParams = new HashMap<>();
    Class<Object> returnType = Object.class;

    // Act
    Object actualDoPostResult =
        metricsHttpApiClient.doPost(
            "https://example.org/example", headerParams, queryParams, "Payload", returnType);

    // Assert
    verify(apiClient)
        .doPost(
            Mockito.<String>any(),
            isA(Map.class),
            isA(Map.class),
            isA(Object.class),
            isA(Class.class));
    verify(controller).finishApiCall(Mockito.<Context>any(), Mockito.<String>any(), anyBoolean());
    verify(controller).startApiCall(Mockito.<String>any());
    assertEquals("Do Post", actualDoPostResult);
  }

  /**
   * Test {@link MetricsHttpApiClient#doPost(String, Map, Map, Object, Class)}.
   *
   * <ul>
   *   <li>Given {@link HttpApiClient} {@link HttpApiClient#doPost(String, Map, Map, Object, Class)}
   *       return {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MetricsHttpApiClient#doPost(String, Map, Map, Object, Class)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Object MetricsHttpApiClient.doPost(String, Map, Map, Object, Class)"})
  public void testDoPost_givenHttpApiClientDoPostReturnFalse_thenReturnFalse()
      throws RemoteApiException {
    // Arrange
    ApiMetricsController controller = mock(ApiMetricsController.class);
    when(controller.startApiCall(Mockito.<String>any())).thenReturn(null);
    doNothing()
        .when(controller)
        .finishApiCall(Mockito.<Context>any(), Mockito.<String>any(), anyBoolean());

    HttpApiClient apiClient = mock(HttpApiClient.class);
    when(apiClient.doPost(
            Mockito.<String>any(),
            Mockito.<Map<String, String>>any(),
            Mockito.<Map<String, String>>any(),
            Mockito.<Object>any(),
            Mockito.<Class<Object>>any()))
        .thenReturn(false);
    HttpApiClientDecorator apiClient2 = new HttpApiClientDecorator(apiClient);

    MetricsHttpApiClient metricsHttpApiClient = new MetricsHttpApiClient(controller, apiClient2);
    HashMap<String, String> headerParams = new HashMap<>();
    HashMap<String, String> queryParams = new HashMap<>();
    Class<Object> returnType = Object.class;

    // Act
    Object actualDoPostResult =
        metricsHttpApiClient.doPost(
            "https://example.org/example", headerParams, queryParams, "Payload", returnType);

    // Assert
    verify(apiClient)
        .doPost(
            Mockito.<String>any(),
            isA(Map.class),
            isA(Map.class),
            isA(Object.class),
            isA(Class.class));
    verify(controller).finishApiCall(Mockito.<Context>any(), Mockito.<String>any(), anyBoolean());
    verify(controller).startApiCall(Mockito.<String>any());
    assertFalse((Boolean) actualDoPostResult);
  }

  /**
   * Test {@link MetricsHttpApiClient#doPost(String, Map, Map, Object, Class)}.
   *
   * <ul>
   *   <li>Given {@link HttpApiClient} {@link HttpApiClient#doPost(String, Map, Map, Object, Class)}
   *       return {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MetricsHttpApiClient#doPost(String, Map, Map, Object, Class)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Object MetricsHttpApiClient.doPost(String, Map, Map, Object, Class)"})
  public void testDoPost_givenHttpApiClientDoPostReturnTrue_thenReturnTrue()
      throws RemoteApiException {
    // Arrange
    ApiMetricsController controller = mock(ApiMetricsController.class);
    when(controller.startApiCall(Mockito.<String>any())).thenReturn(null);
    doNothing()
        .when(controller)
        .finishApiCall(Mockito.<Context>any(), Mockito.<String>any(), anyBoolean());

    HttpApiClient apiClient = mock(HttpApiClient.class);
    when(apiClient.doPost(
            Mockito.<String>any(),
            Mockito.<Map<String, String>>any(),
            Mockito.<Map<String, String>>any(),
            Mockito.<Object>any(),
            Mockito.<Class<Object>>any()))
        .thenReturn(true);
    HttpApiClientDecorator apiClient2 = new HttpApiClientDecorator(apiClient);

    MetricsHttpApiClient metricsHttpApiClient = new MetricsHttpApiClient(controller, apiClient2);
    HashMap<String, String> headerParams = new HashMap<>();
    HashMap<String, String> queryParams = new HashMap<>();
    Class<Object> returnType = Object.class;

    // Act
    Object actualDoPostResult =
        metricsHttpApiClient.doPost(
            "https://example.org/example", headerParams, queryParams, "Payload", returnType);

    // Assert
    verify(apiClient)
        .doPost(
            Mockito.<String>any(),
            isA(Map.class),
            isA(Map.class),
            isA(Object.class),
            isA(Class.class));
    verify(controller).finishApiCall(Mockito.<Context>any(), Mockito.<String>any(), anyBoolean());
    verify(controller).startApiCall(Mockito.<String>any());
    assertTrue((Boolean) actualDoPostResult);
  }

  /**
   * Test {@link MetricsHttpApiClient#doPut(String, Map, Map, Object, Class)}.
   *
   * <ul>
   *   <li>Given {@link HttpApiClient} {@link HttpApiClient#doPut(String, Map, Map, Object, Class)}
   *       return {@code Do Put}.
   *   <li>Then return {@code Do Put}.
   * </ul>
   *
   * <p>Method under test: {@link MetricsHttpApiClient#doPut(String, Map, Map, Object, Class)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Object MetricsHttpApiClient.doPut(String, Map, Map, Object, Class)"})
  public void testDoPut_givenHttpApiClientDoPutReturnDoPut_thenReturnDoPut()
      throws RemoteApiException {
    // Arrange
    ApiMetricsController controller = mock(ApiMetricsController.class);
    when(controller.startApiCall(Mockito.<String>any())).thenReturn(null);
    doNothing()
        .when(controller)
        .finishApiCall(Mockito.<Context>any(), Mockito.<String>any(), anyBoolean());

    HttpApiClient apiClient = mock(HttpApiClient.class);
    when(apiClient.doPut(
            Mockito.<String>any(),
            Mockito.<Map<String, String>>any(),
            Mockito.<Map<String, String>>any(),
            Mockito.<Object>any(),
            Mockito.<Class<Object>>any()))
        .thenReturn("Do Put");
    HttpApiClientDecorator apiClient2 = new HttpApiClientDecorator(apiClient);

    MetricsHttpApiClient metricsHttpApiClient = new MetricsHttpApiClient(controller, apiClient2);
    HashMap<String, String> headerParams = new HashMap<>();
    HashMap<String, String> queryParams = new HashMap<>();
    Class<Object> returnType = Object.class;

    // Act
    Object actualDoPutResult =
        metricsHttpApiClient.doPut(
            "https://example.org/example", headerParams, queryParams, "Payload", returnType);

    // Assert
    verify(apiClient)
        .doPut(
            Mockito.<String>any(),
            isA(Map.class),
            isA(Map.class),
            isA(Object.class),
            isA(Class.class));
    verify(controller).finishApiCall(Mockito.<Context>any(), Mockito.<String>any(), anyBoolean());
    verify(controller).startApiCall(Mockito.<String>any());
    assertEquals("Do Put", actualDoPutResult);
  }

  /**
   * Test {@link MetricsHttpApiClient#doPut(String, Map, Map, Object, Class)}.
   *
   * <ul>
   *   <li>Given {@link HttpApiClient} {@link HttpApiClient#doPut(String, Map, Map, Object, Class)}
   *       return {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MetricsHttpApiClient#doPut(String, Map, Map, Object, Class)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Object MetricsHttpApiClient.doPut(String, Map, Map, Object, Class)"})
  public void testDoPut_givenHttpApiClientDoPutReturnFalse_thenReturnFalse()
      throws RemoteApiException {
    // Arrange
    ApiMetricsController controller = mock(ApiMetricsController.class);
    when(controller.startApiCall(Mockito.<String>any())).thenReturn(null);
    doNothing()
        .when(controller)
        .finishApiCall(Mockito.<Context>any(), Mockito.<String>any(), anyBoolean());

    HttpApiClient apiClient = mock(HttpApiClient.class);
    when(apiClient.doPut(
            Mockito.<String>any(),
            Mockito.<Map<String, String>>any(),
            Mockito.<Map<String, String>>any(),
            Mockito.<Object>any(),
            Mockito.<Class<Object>>any()))
        .thenReturn(false);
    HttpApiClientDecorator apiClient2 = new HttpApiClientDecorator(apiClient);

    MetricsHttpApiClient metricsHttpApiClient = new MetricsHttpApiClient(controller, apiClient2);
    HashMap<String, String> headerParams = new HashMap<>();
    HashMap<String, String> queryParams = new HashMap<>();
    Class<Object> returnType = Object.class;

    // Act
    Object actualDoPutResult =
        metricsHttpApiClient.doPut(
            "https://example.org/example", headerParams, queryParams, "Payload", returnType);

    // Assert
    verify(apiClient)
        .doPut(
            Mockito.<String>any(),
            isA(Map.class),
            isA(Map.class),
            isA(Object.class),
            isA(Class.class));
    verify(controller).finishApiCall(Mockito.<Context>any(), Mockito.<String>any(), anyBoolean());
    verify(controller).startApiCall(Mockito.<String>any());
    assertFalse((Boolean) actualDoPutResult);
  }

  /**
   * Test {@link MetricsHttpApiClient#doPut(String, Map, Map, Object, Class)}.
   *
   * <ul>
   *   <li>Given {@link HttpApiClient} {@link HttpApiClient#doPut(String, Map, Map, Object, Class)}
   *       return {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MetricsHttpApiClient#doPut(String, Map, Map, Object, Class)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Object MetricsHttpApiClient.doPut(String, Map, Map, Object, Class)"})
  public void testDoPut_givenHttpApiClientDoPutReturnTrue_thenReturnTrue()
      throws RemoteApiException {
    // Arrange
    ApiMetricsController controller = mock(ApiMetricsController.class);
    when(controller.startApiCall(Mockito.<String>any())).thenReturn(null);
    doNothing()
        .when(controller)
        .finishApiCall(Mockito.<Context>any(), Mockito.<String>any(), anyBoolean());

    HttpApiClient apiClient = mock(HttpApiClient.class);
    when(apiClient.doPut(
            Mockito.<String>any(),
            Mockito.<Map<String, String>>any(),
            Mockito.<Map<String, String>>any(),
            Mockito.<Object>any(),
            Mockito.<Class<Object>>any()))
        .thenReturn(true);
    HttpApiClientDecorator apiClient2 = new HttpApiClientDecorator(apiClient);

    MetricsHttpApiClient metricsHttpApiClient = new MetricsHttpApiClient(controller, apiClient2);
    HashMap<String, String> headerParams = new HashMap<>();
    HashMap<String, String> queryParams = new HashMap<>();
    Class<Object> returnType = Object.class;

    // Act
    Object actualDoPutResult =
        metricsHttpApiClient.doPut(
            "https://example.org/example", headerParams, queryParams, "Payload", returnType);

    // Assert
    verify(apiClient)
        .doPut(
            Mockito.<String>any(),
            isA(Map.class),
            isA(Map.class),
            isA(Object.class),
            isA(Class.class));
    verify(controller).finishApiCall(Mockito.<Context>any(), Mockito.<String>any(), anyBoolean());
    verify(controller).startApiCall(Mockito.<String>any());
    assertTrue((Boolean) actualDoPutResult);
  }

  /**
   * Test {@link MetricsHttpApiClient#doDelete(String, Map, Map, Class)}.
   *
   * <ul>
   *   <li>Given {@link HttpApiClient} {@link HttpApiClient#doDelete(String, Map, Map, Class)}
   *       return {@code Do Delete}.
   *   <li>Then return {@code Do Delete}.
   * </ul>
   *
   * <p>Method under test: {@link MetricsHttpApiClient#doDelete(String, Map, Map, Class)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Object MetricsHttpApiClient.doDelete(String, Map, Map, Class)"})
  public void testDoDelete_givenHttpApiClientDoDeleteReturnDoDelete_thenReturnDoDelete()
      throws RemoteApiException {
    // Arrange
    ApiMetricsController controller = mock(ApiMetricsController.class);
    when(controller.startApiCall(Mockito.<String>any())).thenReturn(null);
    doNothing()
        .when(controller)
        .finishApiCall(Mockito.<Context>any(), Mockito.<String>any(), anyBoolean());

    HttpApiClient apiClient = mock(HttpApiClient.class);
    when(apiClient.doDelete(
            Mockito.<String>any(),
            Mockito.<Map<String, String>>any(),
            Mockito.<Map<String, String>>any(),
            Mockito.<Class<Object>>any()))
        .thenReturn("Do Delete");
    HttpApiClientDecorator apiClient2 = new HttpApiClientDecorator(apiClient);

    MetricsHttpApiClient metricsHttpApiClient = new MetricsHttpApiClient(controller, apiClient2);
    HashMap<String, String> headerParams = new HashMap<>();
    HashMap<String, String> queryParams = new HashMap<>();
    Class<Object> returnType = Object.class;

    // Act
    Object actualDoDeleteResult =
        metricsHttpApiClient.doDelete(
            "https://example.org/example", headerParams, queryParams, returnType);

    // Assert
    verify(apiClient)
        .doDelete(Mockito.<String>any(), isA(Map.class), isA(Map.class), isA(Class.class));
    verify(controller).finishApiCall(Mockito.<Context>any(), Mockito.<String>any(), anyBoolean());
    verify(controller).startApiCall(Mockito.<String>any());
    assertEquals("Do Delete", actualDoDeleteResult);
  }

  /**
   * Test {@link MetricsHttpApiClient#doDelete(String, Map, Map, Class)}.
   *
   * <ul>
   *   <li>Given {@link HttpApiClient} {@link HttpApiClient#doDelete(String, Map, Map, Class)}
   *       return {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MetricsHttpApiClient#doDelete(String, Map, Map, Class)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Object MetricsHttpApiClient.doDelete(String, Map, Map, Class)"})
  public void testDoDelete_givenHttpApiClientDoDeleteReturnFalse_thenReturnFalse()
      throws RemoteApiException {
    // Arrange
    ApiMetricsController controller = mock(ApiMetricsController.class);
    when(controller.startApiCall(Mockito.<String>any())).thenReturn(null);
    doNothing()
        .when(controller)
        .finishApiCall(Mockito.<Context>any(), Mockito.<String>any(), anyBoolean());

    HttpApiClient apiClient = mock(HttpApiClient.class);
    when(apiClient.doDelete(
            Mockito.<String>any(),
            Mockito.<Map<String, String>>any(),
            Mockito.<Map<String, String>>any(),
            Mockito.<Class<Object>>any()))
        .thenReturn(false);
    HttpApiClientDecorator apiClient2 = new HttpApiClientDecorator(apiClient);

    MetricsHttpApiClient metricsHttpApiClient = new MetricsHttpApiClient(controller, apiClient2);
    HashMap<String, String> headerParams = new HashMap<>();
    HashMap<String, String> queryParams = new HashMap<>();
    Class<Object> returnType = Object.class;

    // Act
    Object actualDoDeleteResult =
        metricsHttpApiClient.doDelete(
            "https://example.org/example", headerParams, queryParams, returnType);

    // Assert
    verify(apiClient)
        .doDelete(Mockito.<String>any(), isA(Map.class), isA(Map.class), isA(Class.class));
    verify(controller).finishApiCall(Mockito.<Context>any(), Mockito.<String>any(), anyBoolean());
    verify(controller).startApiCall(Mockito.<String>any());
    assertFalse((Boolean) actualDoDeleteResult);
  }

  /**
   * Test {@link MetricsHttpApiClient#doDelete(String, Map, Map, Class)}.
   *
   * <ul>
   *   <li>Given {@link HttpApiClient} {@link HttpApiClient#doDelete(String, Map, Map, Class)}
   *       return {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MetricsHttpApiClient#doDelete(String, Map, Map, Class)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Object MetricsHttpApiClient.doDelete(String, Map, Map, Class)"})
  public void testDoDelete_givenHttpApiClientDoDeleteReturnTrue_thenReturnTrue()
      throws RemoteApiException {
    // Arrange
    ApiMetricsController controller = mock(ApiMetricsController.class);
    when(controller.startApiCall(Mockito.<String>any())).thenReturn(null);
    doNothing()
        .when(controller)
        .finishApiCall(Mockito.<Context>any(), Mockito.<String>any(), anyBoolean());

    HttpApiClient apiClient = mock(HttpApiClient.class);
    when(apiClient.doDelete(
            Mockito.<String>any(),
            Mockito.<Map<String, String>>any(),
            Mockito.<Map<String, String>>any(),
            Mockito.<Class<Object>>any()))
        .thenReturn(true);
    HttpApiClientDecorator apiClient2 = new HttpApiClientDecorator(apiClient);

    MetricsHttpApiClient metricsHttpApiClient = new MetricsHttpApiClient(controller, apiClient2);
    HashMap<String, String> headerParams = new HashMap<>();
    HashMap<String, String> queryParams = new HashMap<>();
    Class<Object> returnType = Object.class;

    // Act
    Object actualDoDeleteResult =
        metricsHttpApiClient.doDelete(
            "https://example.org/example", headerParams, queryParams, returnType);

    // Assert
    verify(apiClient)
        .doDelete(Mockito.<String>any(), isA(Map.class), isA(Map.class), isA(Class.class));
    verify(controller).finishApiCall(Mockito.<Context>any(), Mockito.<String>any(), anyBoolean());
    verify(controller).startApiCall(Mockito.<String>any());
    assertTrue((Boolean) actualDoDeleteResult);
  }
}
