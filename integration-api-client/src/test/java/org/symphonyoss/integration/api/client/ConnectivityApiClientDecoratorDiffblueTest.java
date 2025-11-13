package org.symphonyoss.integration.api.client;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.ProcessingException;
import org.junit.Test;
import org.mockito.Mockito;
import org.symphonyoss.integration.api.client.trace.TraceLoggingApiClient;
import org.symphonyoss.integration.authentication.api.enums.ServiceName;
import org.symphonyoss.integration.exception.RemoteApiException;
import org.symphonyoss.integration.exception.authentication.ConnectivityException;

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

  /**
   * Test {@link ConnectivityApiClientDecorator#doGet(String, Map, Map, Class)}.
   *
   * <ul>
   *   <li>Given {@link HttpApiClient} {@link HttpApiClient#doGet(String, Map, Map, Class)} return
   *       {@code Do Get}.
   *   <li>Then return {@code Do Get}.
   * </ul>
   *
   * <p>Method under test: {@link ConnectivityApiClientDecorator#doGet(String, Map, Map, Class)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Object ConnectivityApiClientDecorator.doGet(String, Map, Map, Class)"})
  public void testDoGet_givenHttpApiClientDoGetReturnDoGet_thenReturnDoGet()
      throws RemoteApiException {
    // Arrange
    HttpApiClient apiClient = mock(HttpApiClient.class);
    when(apiClient.doGet(
            Mockito.<String>any(),
            Mockito.<Map<String, String>>any(),
            Mockito.<Map<String, String>>any(),
            Mockito.<Class<Object>>any()))
        .thenReturn("Do Get");
    HttpApiClientDecorator apiClient2 = new HttpApiClientDecorator(apiClient);
    TraceLoggingApiClient apiClient3 = new TraceLoggingApiClient(apiClient2);
    HttpApiClientDecorator apiClient4 = new HttpApiClientDecorator(apiClient3);
    ConnectivityApiClientDecorator connectivityApiClientDecorator =
        new ConnectivityApiClientDecorator(ServiceName.POD_SESSION_MANAGER, apiClient4);
    HashMap<String, String> headerParams = new HashMap<>();
    HashMap<String, String> queryParams = new HashMap<>();
    Class<Object> returnType = Object.class;

    // Act
    Object actualDoGetResult =
        connectivityApiClientDecorator.doGet("Path", headerParams, queryParams, returnType);

    // Assert
    verify(apiClient)
        .doGet(Mockito.<String>any(), isA(Map.class), isA(Map.class), isA(Class.class));
    assertEquals("Do Get", actualDoGetResult);
  }

  /**
   * Test {@link ConnectivityApiClientDecorator#doGet(String, Map, Map, Class)}.
   *
   * <ul>
   *   <li>Given {@link HttpApiClient} {@link HttpApiClient#doGet(String, Map, Map, Class)} return
   *       {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ConnectivityApiClientDecorator#doGet(String, Map, Map, Class)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Object ConnectivityApiClientDecorator.doGet(String, Map, Map, Class)"})
  public void testDoGet_givenHttpApiClientDoGetReturnFalse_thenReturnFalse()
      throws RemoteApiException {
    // Arrange
    HttpApiClient apiClient = mock(HttpApiClient.class);
    when(apiClient.doGet(
            Mockito.<String>any(),
            Mockito.<Map<String, String>>any(),
            Mockito.<Map<String, String>>any(),
            Mockito.<Class<Object>>any()))
        .thenReturn(false);
    HttpApiClientDecorator apiClient2 = new HttpApiClientDecorator(apiClient);
    TraceLoggingApiClient apiClient3 = new TraceLoggingApiClient(apiClient2);
    HttpApiClientDecorator apiClient4 = new HttpApiClientDecorator(apiClient3);
    ConnectivityApiClientDecorator connectivityApiClientDecorator =
        new ConnectivityApiClientDecorator(ServiceName.POD_SESSION_MANAGER, apiClient4);
    HashMap<String, String> headerParams = new HashMap<>();
    HashMap<String, String> queryParams = new HashMap<>();
    Class<Object> returnType = Object.class;

    // Act
    Object actualDoGetResult =
        connectivityApiClientDecorator.doGet("Path", headerParams, queryParams, returnType);

    // Assert
    verify(apiClient)
        .doGet(Mockito.<String>any(), isA(Map.class), isA(Map.class), isA(Class.class));
    assertFalse((Boolean) actualDoGetResult);
  }

  /**
   * Test {@link ConnectivityApiClientDecorator#doGet(String, Map, Map, Class)}.
   *
   * <ul>
   *   <li>Given {@link HttpApiClient} {@link HttpApiClient#doGet(String, Map, Map, Class)} return
   *       {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ConnectivityApiClientDecorator#doGet(String, Map, Map, Class)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Object ConnectivityApiClientDecorator.doGet(String, Map, Map, Class)"})
  public void testDoGet_givenHttpApiClientDoGetReturnTrue_thenReturnTrue()
      throws RemoteApiException {
    // Arrange
    HttpApiClient apiClient = mock(HttpApiClient.class);
    when(apiClient.doGet(
            Mockito.<String>any(),
            Mockito.<Map<String, String>>any(),
            Mockito.<Map<String, String>>any(),
            Mockito.<Class<Object>>any()))
        .thenReturn(true);
    HttpApiClientDecorator apiClient2 = new HttpApiClientDecorator(apiClient);
    TraceLoggingApiClient apiClient3 = new TraceLoggingApiClient(apiClient2);
    HttpApiClientDecorator apiClient4 = new HttpApiClientDecorator(apiClient3);
    ConnectivityApiClientDecorator connectivityApiClientDecorator =
        new ConnectivityApiClientDecorator(ServiceName.POD_SESSION_MANAGER, apiClient4);
    HashMap<String, String> headerParams = new HashMap<>();
    HashMap<String, String> queryParams = new HashMap<>();
    Class<Object> returnType = Object.class;

    // Act
    Object actualDoGetResult =
        connectivityApiClientDecorator.doGet("Path", headerParams, queryParams, returnType);

    // Assert
    verify(apiClient)
        .doGet(Mockito.<String>any(), isA(Map.class), isA(Map.class), isA(Class.class));
    assertTrue((Boolean) actualDoGetResult);
  }

  /**
   * Test {@link ConnectivityApiClientDecorator#doPost(String, Map, Map, Object, Class)}.
   *
   * <ul>
   *   <li>Given {@link HttpApiClient} {@link HttpApiClient#doPost(String, Map, Map, Object, Class)}
   *       return {@code Do Post}.
   *   <li>Then return {@code Do Post}.
   * </ul>
   *
   * <p>Method under test: {@link ConnectivityApiClientDecorator#doPost(String, Map, Map, Object,
   * Class)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object ConnectivityApiClientDecorator.doPost(String, Map, Map, Object, Class)"
  })
  public void testDoPost_givenHttpApiClientDoPostReturnDoPost_thenReturnDoPost()
      throws RemoteApiException {
    // Arrange
    HttpApiClient apiClient = mock(HttpApiClient.class);
    when(apiClient.doPost(
            Mockito.<String>any(),
            Mockito.<Map<String, String>>any(),
            Mockito.<Map<String, String>>any(),
            Mockito.<Object>any(),
            Mockito.<Class<Object>>any()))
        .thenReturn("Do Post");
    HttpApiClientDecorator apiClient2 = new HttpApiClientDecorator(apiClient);
    TraceLoggingApiClient apiClient3 = new TraceLoggingApiClient(apiClient2);
    ConnectivityApiClientDecorator connectivityApiClientDecorator =
        new ConnectivityApiClientDecorator(ServiceName.POD_SESSION_MANAGER, apiClient3);
    HashMap<String, String> headerParams = new HashMap<>();
    HashMap<String, String> queryParams = new HashMap<>();
    Class<Object> returnType = Object.class;

    // Act
    Object actualDoPostResult =
        connectivityApiClientDecorator.doPost(
            "Path", headerParams, queryParams, "Payload", returnType);

    // Assert
    verify(apiClient)
        .doPost(
            Mockito.<String>any(),
            isA(Map.class),
            isA(Map.class),
            isA(Object.class),
            isA(Class.class));
    assertEquals("Do Post", actualDoPostResult);
  }

  /**
   * Test {@link ConnectivityApiClientDecorator#doPost(String, Map, Map, Object, Class)}.
   *
   * <ul>
   *   <li>Given {@link HttpApiClient} {@link HttpApiClient#doPost(String, Map, Map, Object, Class)}
   *       return {@code Do Post}.
   *   <li>Then return {@code Do Post}.
   * </ul>
   *
   * <p>Method under test: {@link ConnectivityApiClientDecorator#doPost(String, Map, Map, Object,
   * Class)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object ConnectivityApiClientDecorator.doPost(String, Map, Map, Object, Class)"
  })
  public void testDoPost_givenHttpApiClientDoPostReturnDoPost_thenReturnDoPost2()
      throws RemoteApiException {
    // Arrange
    HttpApiClient apiClient = mock(HttpApiClient.class);
    when(apiClient.doPost(
            Mockito.<String>any(),
            Mockito.<Map<String, String>>any(),
            Mockito.<Map<String, String>>any(),
            Mockito.<Object>any(),
            Mockito.<Class<Object>>any()))
        .thenReturn("Do Post");
    HttpApiClientDecorator apiClient2 = new HttpApiClientDecorator(apiClient);
    TraceLoggingApiClient apiClient3 = new TraceLoggingApiClient(apiClient2);
    ConnectivityApiClientDecorator apiClient4 =
        new ConnectivityApiClientDecorator(ServiceName.POD_SESSION_MANAGER, apiClient3);
    ConnectivityApiClientDecorator connectivityApiClientDecorator =
        new ConnectivityApiClientDecorator(
            ServiceName.POD_SESSION_MANAGER, new TraceLoggingApiClient(apiClient4));
    HashMap<String, String> headerParams = new HashMap<>();
    HashMap<String, String> queryParams = new HashMap<>();
    Class<Object> returnType = Object.class;

    // Act
    Object actualDoPostResult =
        connectivityApiClientDecorator.doPost(
            "Path", headerParams, queryParams, "Payload", returnType);

    // Assert
    verify(apiClient)
        .doPost(
            Mockito.<String>any(),
            isA(Map.class),
            isA(Map.class),
            isA(Object.class),
            isA(Class.class));
    assertEquals("Do Post", actualDoPostResult);
  }

  /**
   * Test {@link ConnectivityApiClientDecorator#doPost(String, Map, Map, Object, Class)}.
   *
   * <ul>
   *   <li>Given {@link HttpApiClient} {@link HttpApiClient#doPost(String, Map, Map, Object, Class)}
   *       return {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ConnectivityApiClientDecorator#doPost(String, Map, Map, Object,
   * Class)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object ConnectivityApiClientDecorator.doPost(String, Map, Map, Object, Class)"
  })
  public void testDoPost_givenHttpApiClientDoPostReturnFalse_thenReturnFalse()
      throws RemoteApiException {
    // Arrange
    HttpApiClient apiClient = mock(HttpApiClient.class);
    when(apiClient.doPost(
            Mockito.<String>any(),
            Mockito.<Map<String, String>>any(),
            Mockito.<Map<String, String>>any(),
            Mockito.<Object>any(),
            Mockito.<Class<Object>>any()))
        .thenReturn(false);
    HttpApiClientDecorator apiClient2 = new HttpApiClientDecorator(apiClient);
    TraceLoggingApiClient apiClient3 = new TraceLoggingApiClient(apiClient2);
    ConnectivityApiClientDecorator connectivityApiClientDecorator =
        new ConnectivityApiClientDecorator(ServiceName.POD_SESSION_MANAGER, apiClient3);
    HashMap<String, String> headerParams = new HashMap<>();
    HashMap<String, String> queryParams = new HashMap<>();
    Class<Object> returnType = Object.class;

    // Act
    Object actualDoPostResult =
        connectivityApiClientDecorator.doPost(
            "Path", headerParams, queryParams, "Payload", returnType);

    // Assert
    verify(apiClient)
        .doPost(
            Mockito.<String>any(),
            isA(Map.class),
            isA(Map.class),
            isA(Object.class),
            isA(Class.class));
    assertFalse((Boolean) actualDoPostResult);
  }

  /**
   * Test {@link ConnectivityApiClientDecorator#doPost(String, Map, Map, Object, Class)}.
   *
   * <ul>
   *   <li>Given {@link HttpApiClient} {@link HttpApiClient#doPost(String, Map, Map, Object, Class)}
   *       return {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ConnectivityApiClientDecorator#doPost(String, Map, Map, Object,
   * Class)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object ConnectivityApiClientDecorator.doPost(String, Map, Map, Object, Class)"
  })
  public void testDoPost_givenHttpApiClientDoPostReturnTrue_thenReturnTrue()
      throws RemoteApiException {
    // Arrange
    HttpApiClient apiClient = mock(HttpApiClient.class);
    when(apiClient.doPost(
            Mockito.<String>any(),
            Mockito.<Map<String, String>>any(),
            Mockito.<Map<String, String>>any(),
            Mockito.<Object>any(),
            Mockito.<Class<Object>>any()))
        .thenReturn(true);
    HttpApiClientDecorator apiClient2 = new HttpApiClientDecorator(apiClient);
    TraceLoggingApiClient apiClient3 = new TraceLoggingApiClient(apiClient2);
    ConnectivityApiClientDecorator connectivityApiClientDecorator =
        new ConnectivityApiClientDecorator(ServiceName.POD_SESSION_MANAGER, apiClient3);
    HashMap<String, String> headerParams = new HashMap<>();
    HashMap<String, String> queryParams = new HashMap<>();
    Class<Object> returnType = Object.class;

    // Act
    Object actualDoPostResult =
        connectivityApiClientDecorator.doPost(
            "Path", headerParams, queryParams, "Payload", returnType);

    // Assert
    verify(apiClient)
        .doPost(
            Mockito.<String>any(),
            isA(Map.class),
            isA(Map.class),
            isA(Object.class),
            isA(Class.class));
    assertTrue((Boolean) actualDoPostResult);
  }

  /**
   * Test {@link ConnectivityApiClientDecorator#doPut(String, Map, Map, Object, Class)}.
   *
   * <ul>
   *   <li>Given {@link HttpApiClient} {@link HttpApiClient#doPut(String, Map, Map, Object, Class)}
   *       return {@code Do Put}.
   *   <li>Then return {@code Do Put}.
   * </ul>
   *
   * <p>Method under test: {@link ConnectivityApiClientDecorator#doPut(String, Map, Map, Object,
   * Class)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object ConnectivityApiClientDecorator.doPut(String, Map, Map, Object, Class)"
  })
  public void testDoPut_givenHttpApiClientDoPutReturnDoPut_thenReturnDoPut()
      throws RemoteApiException {
    // Arrange
    HttpApiClient apiClient = mock(HttpApiClient.class);
    when(apiClient.doPut(
            Mockito.<String>any(),
            Mockito.<Map<String, String>>any(),
            Mockito.<Map<String, String>>any(),
            Mockito.<Object>any(),
            Mockito.<Class<Object>>any()))
        .thenReturn("Do Put");
    HttpApiClientDecorator apiClient2 = new HttpApiClientDecorator(apiClient);
    TraceLoggingApiClient apiClient3 = new TraceLoggingApiClient(apiClient2);
    ConnectivityApiClientDecorator connectivityApiClientDecorator =
        new ConnectivityApiClientDecorator(ServiceName.POD_SESSION_MANAGER, apiClient3);
    HashMap<String, String> headerParams = new HashMap<>();
    HashMap<String, String> queryParams = new HashMap<>();
    Class<Object> returnType = Object.class;

    // Act
    Object actualDoPutResult =
        connectivityApiClientDecorator.doPut(
            "Path", headerParams, queryParams, "Payload", returnType);

    // Assert
    verify(apiClient)
        .doPut(
            Mockito.<String>any(),
            isA(Map.class),
            isA(Map.class),
            isA(Object.class),
            isA(Class.class));
    assertEquals("Do Put", actualDoPutResult);
  }

  /**
   * Test {@link ConnectivityApiClientDecorator#doPut(String, Map, Map, Object, Class)}.
   *
   * <ul>
   *   <li>Given {@link HttpApiClient} {@link HttpApiClient#doPut(String, Map, Map, Object, Class)}
   *       return {@code Do Put}.
   *   <li>Then return {@code Do Put}.
   * </ul>
   *
   * <p>Method under test: {@link ConnectivityApiClientDecorator#doPut(String, Map, Map, Object,
   * Class)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object ConnectivityApiClientDecorator.doPut(String, Map, Map, Object, Class)"
  })
  public void testDoPut_givenHttpApiClientDoPutReturnDoPut_thenReturnDoPut2()
      throws RemoteApiException {
    // Arrange
    HttpApiClient apiClient = mock(HttpApiClient.class);
    when(apiClient.doPut(
            Mockito.<String>any(),
            Mockito.<Map<String, String>>any(),
            Mockito.<Map<String, String>>any(),
            Mockito.<Object>any(),
            Mockito.<Class<Object>>any()))
        .thenReturn("Do Put");
    HttpApiClientDecorator apiClient2 = new HttpApiClientDecorator(apiClient);
    TraceLoggingApiClient apiClient3 = new TraceLoggingApiClient(apiClient2);
    ConnectivityApiClientDecorator apiClient4 =
        new ConnectivityApiClientDecorator(ServiceName.POD_SESSION_MANAGER, apiClient3);
    ConnectivityApiClientDecorator connectivityApiClientDecorator =
        new ConnectivityApiClientDecorator(
            ServiceName.POD_SESSION_MANAGER, new TraceLoggingApiClient(apiClient4));
    HashMap<String, String> headerParams = new HashMap<>();
    HashMap<String, String> queryParams = new HashMap<>();
    Class<Object> returnType = Object.class;

    // Act
    Object actualDoPutResult =
        connectivityApiClientDecorator.doPut(
            "Path", headerParams, queryParams, "Payload", returnType);

    // Assert
    verify(apiClient)
        .doPut(
            Mockito.<String>any(),
            isA(Map.class),
            isA(Map.class),
            isA(Object.class),
            isA(Class.class));
    assertEquals("Do Put", actualDoPutResult);
  }

  /**
   * Test {@link ConnectivityApiClientDecorator#doPut(String, Map, Map, Object, Class)}.
   *
   * <ul>
   *   <li>Given {@link HttpApiClient} {@link HttpApiClient#doPut(String, Map, Map, Object, Class)}
   *       return {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ConnectivityApiClientDecorator#doPut(String, Map, Map, Object,
   * Class)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object ConnectivityApiClientDecorator.doPut(String, Map, Map, Object, Class)"
  })
  public void testDoPut_givenHttpApiClientDoPutReturnFalse_thenReturnFalse()
      throws RemoteApiException {
    // Arrange
    HttpApiClient apiClient = mock(HttpApiClient.class);
    when(apiClient.doPut(
            Mockito.<String>any(),
            Mockito.<Map<String, String>>any(),
            Mockito.<Map<String, String>>any(),
            Mockito.<Object>any(),
            Mockito.<Class<Object>>any()))
        .thenReturn(false);
    HttpApiClientDecorator apiClient2 = new HttpApiClientDecorator(apiClient);
    TraceLoggingApiClient apiClient3 = new TraceLoggingApiClient(apiClient2);
    ConnectivityApiClientDecorator connectivityApiClientDecorator =
        new ConnectivityApiClientDecorator(ServiceName.POD_SESSION_MANAGER, apiClient3);
    HashMap<String, String> headerParams = new HashMap<>();
    HashMap<String, String> queryParams = new HashMap<>();
    Class<Object> returnType = Object.class;

    // Act
    Object actualDoPutResult =
        connectivityApiClientDecorator.doPut(
            "Path", headerParams, queryParams, "Payload", returnType);

    // Assert
    verify(apiClient)
        .doPut(
            Mockito.<String>any(),
            isA(Map.class),
            isA(Map.class),
            isA(Object.class),
            isA(Class.class));
    assertFalse((Boolean) actualDoPutResult);
  }

  /**
   * Test {@link ConnectivityApiClientDecorator#doPut(String, Map, Map, Object, Class)}.
   *
   * <ul>
   *   <li>Given {@link HttpApiClient} {@link HttpApiClient#doPut(String, Map, Map, Object, Class)}
   *       return {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ConnectivityApiClientDecorator#doPut(String, Map, Map, Object,
   * Class)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object ConnectivityApiClientDecorator.doPut(String, Map, Map, Object, Class)"
  })
  public void testDoPut_givenHttpApiClientDoPutReturnTrue_thenReturnTrue()
      throws RemoteApiException {
    // Arrange
    HttpApiClient apiClient = mock(HttpApiClient.class);
    when(apiClient.doPut(
            Mockito.<String>any(),
            Mockito.<Map<String, String>>any(),
            Mockito.<Map<String, String>>any(),
            Mockito.<Object>any(),
            Mockito.<Class<Object>>any()))
        .thenReturn(true);
    HttpApiClientDecorator apiClient2 = new HttpApiClientDecorator(apiClient);
    TraceLoggingApiClient apiClient3 = new TraceLoggingApiClient(apiClient2);
    ConnectivityApiClientDecorator connectivityApiClientDecorator =
        new ConnectivityApiClientDecorator(ServiceName.POD_SESSION_MANAGER, apiClient3);
    HashMap<String, String> headerParams = new HashMap<>();
    HashMap<String, String> queryParams = new HashMap<>();
    Class<Object> returnType = Object.class;

    // Act
    Object actualDoPutResult =
        connectivityApiClientDecorator.doPut(
            "Path", headerParams, queryParams, "Payload", returnType);

    // Assert
    verify(apiClient)
        .doPut(
            Mockito.<String>any(),
            isA(Map.class),
            isA(Map.class),
            isA(Object.class),
            isA(Class.class));
    assertTrue((Boolean) actualDoPutResult);
  }

  /**
   * Test {@link ConnectivityApiClientDecorator#doDelete(String, Map, Map, Class)}.
   *
   * <ul>
   *   <li>Given {@link HttpApiClient} {@link HttpApiClient#doDelete(String, Map, Map, Class)}
   *       return {@code Do Delete}.
   *   <li>Then return {@code Do Delete}.
   * </ul>
   *
   * <p>Method under test: {@link ConnectivityApiClientDecorator#doDelete(String, Map, Map, Class)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Object ConnectivityApiClientDecorator.doDelete(String, Map, Map, Class)"})
  public void testDoDelete_givenHttpApiClientDoDeleteReturnDoDelete_thenReturnDoDelete()
      throws RemoteApiException {
    // Arrange
    HttpApiClient apiClient = mock(HttpApiClient.class);
    when(apiClient.doDelete(
            Mockito.<String>any(),
            Mockito.<Map<String, String>>any(),
            Mockito.<Map<String, String>>any(),
            Mockito.<Class<Object>>any()))
        .thenReturn("Do Delete");
    HttpApiClientDecorator apiClient2 = new HttpApiClientDecorator(apiClient);
    TraceLoggingApiClient apiClient3 = new TraceLoggingApiClient(apiClient2);
    HttpApiClientDecorator apiClient4 = new HttpApiClientDecorator(apiClient3);
    ConnectivityApiClientDecorator connectivityApiClientDecorator =
        new ConnectivityApiClientDecorator(ServiceName.POD_SESSION_MANAGER, apiClient4);
    HashMap<String, String> headerParams = new HashMap<>();
    HashMap<String, String> queryParams = new HashMap<>();
    Class<Object> returnType = Object.class;

    // Act
    Object actualDoDeleteResult =
        connectivityApiClientDecorator.doDelete("Path", headerParams, queryParams, returnType);

    // Assert
    verify(apiClient)
        .doDelete(Mockito.<String>any(), isA(Map.class), isA(Map.class), isA(Class.class));
    assertEquals("Do Delete", actualDoDeleteResult);
  }

  /**
   * Test {@link ConnectivityApiClientDecorator#doDelete(String, Map, Map, Class)}.
   *
   * <ul>
   *   <li>Given {@link HttpApiClient} {@link HttpApiClient#doDelete(String, Map, Map, Class)}
   *       return {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ConnectivityApiClientDecorator#doDelete(String, Map, Map, Class)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Object ConnectivityApiClientDecorator.doDelete(String, Map, Map, Class)"})
  public void testDoDelete_givenHttpApiClientDoDeleteReturnFalse_thenReturnFalse()
      throws RemoteApiException {
    // Arrange
    HttpApiClient apiClient = mock(HttpApiClient.class);
    when(apiClient.doDelete(
            Mockito.<String>any(),
            Mockito.<Map<String, String>>any(),
            Mockito.<Map<String, String>>any(),
            Mockito.<Class<Object>>any()))
        .thenReturn(false);
    HttpApiClientDecorator apiClient2 = new HttpApiClientDecorator(apiClient);
    TraceLoggingApiClient apiClient3 = new TraceLoggingApiClient(apiClient2);
    HttpApiClientDecorator apiClient4 = new HttpApiClientDecorator(apiClient3);
    ConnectivityApiClientDecorator connectivityApiClientDecorator =
        new ConnectivityApiClientDecorator(ServiceName.POD_SESSION_MANAGER, apiClient4);
    HashMap<String, String> headerParams = new HashMap<>();
    HashMap<String, String> queryParams = new HashMap<>();
    Class<Object> returnType = Object.class;

    // Act
    Object actualDoDeleteResult =
        connectivityApiClientDecorator.doDelete("Path", headerParams, queryParams, returnType);

    // Assert
    verify(apiClient)
        .doDelete(Mockito.<String>any(), isA(Map.class), isA(Map.class), isA(Class.class));
    assertFalse((Boolean) actualDoDeleteResult);
  }

  /**
   * Test {@link ConnectivityApiClientDecorator#doDelete(String, Map, Map, Class)}.
   *
   * <ul>
   *   <li>Given {@link HttpApiClient} {@link HttpApiClient#doDelete(String, Map, Map, Class)}
   *       return {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ConnectivityApiClientDecorator#doDelete(String, Map, Map, Class)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Object ConnectivityApiClientDecorator.doDelete(String, Map, Map, Class)"})
  public void testDoDelete_givenHttpApiClientDoDeleteReturnTrue_thenReturnTrue()
      throws RemoteApiException {
    // Arrange
    HttpApiClient apiClient = mock(HttpApiClient.class);
    when(apiClient.doDelete(
            Mockito.<String>any(),
            Mockito.<Map<String, String>>any(),
            Mockito.<Map<String, String>>any(),
            Mockito.<Class<Object>>any()))
        .thenReturn(true);
    HttpApiClientDecorator apiClient2 = new HttpApiClientDecorator(apiClient);
    TraceLoggingApiClient apiClient3 = new TraceLoggingApiClient(apiClient2);
    HttpApiClientDecorator apiClient4 = new HttpApiClientDecorator(apiClient3);
    ConnectivityApiClientDecorator connectivityApiClientDecorator =
        new ConnectivityApiClientDecorator(ServiceName.POD_SESSION_MANAGER, apiClient4);
    HashMap<String, String> headerParams = new HashMap<>();
    HashMap<String, String> queryParams = new HashMap<>();
    Class<Object> returnType = Object.class;

    // Act
    Object actualDoDeleteResult =
        connectivityApiClientDecorator.doDelete("Path", headerParams, queryParams, returnType);

    // Assert
    verify(apiClient)
        .doDelete(Mockito.<String>any(), isA(Map.class), isA(Map.class), isA(Class.class));
    assertTrue((Boolean) actualDoDeleteResult);
  }

  /**
   * Test {@link ConnectivityApiClientDecorator#getConnectivityException(ProcessingException)}.
   *
   * <p>Method under test: {@link
   * ConnectivityApiClientDecorator#getConnectivityException(ProcessingException)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ConnectivityException ConnectivityApiClientDecorator.getConnectivityException(ProcessingException)"
  })
  public void testGetConnectivityException() {
    // Arrange
    SimpleHttpApiClient apiClient = new SimpleHttpApiClient(mock(EntitySerializer.class));
    HttpApiClientDecorator apiClient2 = new HttpApiClientDecorator(apiClient);
    ConnectivityApiClientDecorator connectivityApiClientDecorator =
        new ConnectivityApiClientDecorator(ServiceName.POD_SESSION_MANAGER, apiClient2);
    ProcessingException e = new ProcessingException("An error occurred");

    // Act
    ConnectivityException actualConnectivityException =
        connectivityApiClientDecorator.getConnectivityException(e);

    // Assert
    assertEquals(
        "\n"
            + "Component: Connectivity Api Client\n"
            + "Message: Integration Bridge can't reach POD_SESSION_MANAGER service!\n"
            + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n"
            + "Stack trace: An error occurred\n",
        actualConnectivityException.getLocalizedMessage());
    assertEquals(
        "\n"
            + "Component: Connectivity Api Client\n"
            + "Message: Integration Bridge can't reach POD_SESSION_MANAGER service!\n"
            + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n"
            + "Stack trace: An error occurred\n",
        actualConnectivityException.getMessage());
    assertEquals(0, actualConnectivityException.getSuppressed().length);
    assertSame(e, actualConnectivityException.getCause());
  }
}
