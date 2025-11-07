package org.symphonyoss.integration.api.client.trace;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import org.mockito.Mockito;
import org.symphonyoss.integration.api.client.HttpApiClient;
import org.symphonyoss.integration.api.client.HttpApiClientDecorator;
import org.symphonyoss.integration.exception.RemoteApiException;

public class TraceLoggingApiClientDiffblueTest {
  /**
   * Method under test:
   * {@link TraceLoggingApiClient#doGet(String, Map, Map, Class)}
   */
  @Test
  public void testDoGet() throws RemoteApiException {
    // Arrange
    HttpApiClient apiClient = mock(HttpApiClient.class);
    when(apiClient.doGet(Mockito.<String>any(), Mockito.<Map<String, String>>any(), Mockito.<Map<String, String>>any(),
        Mockito.<Class<Object>>any())).thenReturn("Do Get");
    TraceLoggingApiClient traceLoggingApiClient = new TraceLoggingApiClient(
        new HttpApiClientDecorator(new TraceLoggingApiClient(new HttpApiClientDecorator(apiClient))));
    HashMap<String, String> headerParams = new HashMap<>();
    HashMap<String, String> queryParams = new HashMap<>();
    Class<Object> returnType = Object.class;

    // Act
    Object actualDoGetResult = traceLoggingApiClient.doGet("Path", headerParams, queryParams, returnType);

    // Assert
    verify(apiClient).doGet(Mockito.<String>any(), isA(Map.class), isA(Map.class), isA(Class.class));
    assertEquals("Do Get", actualDoGetResult);
  }

  /**
   * Method under test:
   * {@link TraceLoggingApiClient#doGet(String, Map, Map, Class)}
   */
  @Test
  public void testDoGet2() throws RemoteApiException {
    // Arrange
    HttpApiClient apiClient = mock(HttpApiClient.class);
    when(apiClient.doGet(Mockito.<String>any(), Mockito.<Map<String, String>>any(), Mockito.<Map<String, String>>any(),
        Mockito.<Class<Object>>any())).thenReturn(true);
    TraceLoggingApiClient traceLoggingApiClient = new TraceLoggingApiClient(
        new HttpApiClientDecorator(new TraceLoggingApiClient(new HttpApiClientDecorator(apiClient))));
    HashMap<String, String> headerParams = new HashMap<>();
    HashMap<String, String> queryParams = new HashMap<>();
    Class<Object> returnType = Object.class;

    // Act
    traceLoggingApiClient.doGet("Path", headerParams, queryParams, returnType);

    // Assert
    verify(apiClient).doGet(Mockito.<String>any(), isA(Map.class), isA(Map.class), isA(Class.class));
  }

  /**
   * Method under test:
   * {@link TraceLoggingApiClient#doGet(String, Map, Map, Class)}
   */
  @Test
  public void testDoGet3() throws RemoteApiException {
    // Arrange
    HttpApiClient apiClient = mock(HttpApiClient.class);
    when(apiClient.doGet(Mockito.<String>any(), Mockito.<Map<String, String>>any(), Mockito.<Map<String, String>>any(),
        Mockito.<Class<Object>>any())).thenReturn(false);
    TraceLoggingApiClient traceLoggingApiClient = new TraceLoggingApiClient(
        new HttpApiClientDecorator(new TraceLoggingApiClient(new HttpApiClientDecorator(apiClient))));
    HashMap<String, String> headerParams = new HashMap<>();
    HashMap<String, String> queryParams = new HashMap<>();
    Class<Object> returnType = Object.class;

    // Act
    traceLoggingApiClient.doGet("Path", headerParams, queryParams, returnType);

    // Assert
    verify(apiClient).doGet(Mockito.<String>any(), isA(Map.class), isA(Map.class), isA(Class.class));
  }

  /**
   * Method under test:
   * {@link TraceLoggingApiClient#doPost(String, Map, Map, Object, Class)}
   */
  @Test
  public void testDoPost() throws RemoteApiException {
    // Arrange
    HttpApiClient apiClient = mock(HttpApiClient.class);
    when(apiClient.doPost(Mockito.<String>any(), Mockito.<Map<String, String>>any(), Mockito.<Map<String, String>>any(),
        Mockito.<Object>any(), Mockito.<Class<Object>>any())).thenReturn("Do Post");
    TraceLoggingApiClient traceLoggingApiClient = new TraceLoggingApiClient(
        new HttpApiClientDecorator(new TraceLoggingApiClient(new HttpApiClientDecorator(apiClient))));
    HashMap<String, String> headerParams = new HashMap<>();
    HashMap<String, String> queryParams = new HashMap<>();
    Class<Object> returnType = Object.class;

    // Act
    Object actualDoPostResult = traceLoggingApiClient.doPost("Path", headerParams, queryParams, "Payload", returnType);

    // Assert
    verify(apiClient).doPost(Mockito.<String>any(), isA(Map.class), isA(Map.class), isA(Object.class),
        isA(Class.class));
    assertEquals("Do Post", actualDoPostResult);
  }

  /**
   * Method under test:
   * {@link TraceLoggingApiClient#doPost(String, Map, Map, Object, Class)}
   */
  @Test
  public void testDoPost2() throws RemoteApiException {
    // Arrange
    HttpApiClient apiClient = mock(HttpApiClient.class);
    when(apiClient.doPost(Mockito.<String>any(), Mockito.<Map<String, String>>any(), Mockito.<Map<String, String>>any(),
        Mockito.<Object>any(), Mockito.<Class<Object>>any())).thenReturn(true);
    TraceLoggingApiClient traceLoggingApiClient = new TraceLoggingApiClient(
        new HttpApiClientDecorator(new TraceLoggingApiClient(new HttpApiClientDecorator(apiClient))));
    HashMap<String, String> headerParams = new HashMap<>();
    HashMap<String, String> queryParams = new HashMap<>();
    Class<Object> returnType = Object.class;

    // Act
    traceLoggingApiClient.doPost("Path", headerParams, queryParams, "Payload", returnType);

    // Assert
    verify(apiClient).doPost(Mockito.<String>any(), isA(Map.class), isA(Map.class), isA(Object.class),
        isA(Class.class));
  }

  /**
   * Method under test:
   * {@link TraceLoggingApiClient#doPost(String, Map, Map, Object, Class)}
   */
  @Test
  public void testDoPost3() throws RemoteApiException {
    // Arrange
    HttpApiClient apiClient = mock(HttpApiClient.class);
    when(apiClient.doPost(Mockito.<String>any(), Mockito.<Map<String, String>>any(), Mockito.<Map<String, String>>any(),
        Mockito.<Object>any(), Mockito.<Class<Object>>any())).thenReturn(false);
    TraceLoggingApiClient traceLoggingApiClient = new TraceLoggingApiClient(
        new HttpApiClientDecorator(new TraceLoggingApiClient(new HttpApiClientDecorator(apiClient))));
    HashMap<String, String> headerParams = new HashMap<>();
    HashMap<String, String> queryParams = new HashMap<>();
    Class<Object> returnType = Object.class;

    // Act
    traceLoggingApiClient.doPost("Path", headerParams, queryParams, "Payload", returnType);

    // Assert
    verify(apiClient).doPost(Mockito.<String>any(), isA(Map.class), isA(Map.class), isA(Object.class),
        isA(Class.class));
  }

  /**
   * Method under test:
   * {@link TraceLoggingApiClient#doPut(String, Map, Map, Object, Class)}
   */
  @Test
  public void testDoPut() throws RemoteApiException {
    // Arrange
    HttpApiClient apiClient = mock(HttpApiClient.class);
    when(apiClient.doPut(Mockito.<String>any(), Mockito.<Map<String, String>>any(), Mockito.<Map<String, String>>any(),
        Mockito.<Object>any(), Mockito.<Class<Object>>any())).thenReturn("Do Put");
    TraceLoggingApiClient traceLoggingApiClient = new TraceLoggingApiClient(
        new HttpApiClientDecorator(new TraceLoggingApiClient(new HttpApiClientDecorator(apiClient))));
    HashMap<String, String> headerParams = new HashMap<>();
    HashMap<String, String> queryParams = new HashMap<>();
    Class<Object> returnType = Object.class;

    // Act
    Object actualDoPutResult = traceLoggingApiClient.doPut("Path", headerParams, queryParams, "Payload", returnType);

    // Assert
    verify(apiClient).doPut(Mockito.<String>any(), isA(Map.class), isA(Map.class), isA(Object.class), isA(Class.class));
    assertEquals("Do Put", actualDoPutResult);
  }

  /**
   * Method under test:
   * {@link TraceLoggingApiClient#doPut(String, Map, Map, Object, Class)}
   */
  @Test
  public void testDoPut2() throws RemoteApiException {
    // Arrange
    HttpApiClient apiClient = mock(HttpApiClient.class);
    when(apiClient.doPut(Mockito.<String>any(), Mockito.<Map<String, String>>any(), Mockito.<Map<String, String>>any(),
        Mockito.<Object>any(), Mockito.<Class<Object>>any())).thenReturn(true);
    TraceLoggingApiClient traceLoggingApiClient = new TraceLoggingApiClient(
        new HttpApiClientDecorator(new TraceLoggingApiClient(new HttpApiClientDecorator(apiClient))));
    HashMap<String, String> headerParams = new HashMap<>();
    HashMap<String, String> queryParams = new HashMap<>();
    Class<Object> returnType = Object.class;

    // Act
    traceLoggingApiClient.doPut("Path", headerParams, queryParams, "Payload", returnType);

    // Assert
    verify(apiClient).doPut(Mockito.<String>any(), isA(Map.class), isA(Map.class), isA(Object.class), isA(Class.class));
  }

  /**
   * Method under test:
   * {@link TraceLoggingApiClient#doPut(String, Map, Map, Object, Class)}
   */
  @Test
  public void testDoPut3() throws RemoteApiException {
    // Arrange
    HttpApiClient apiClient = mock(HttpApiClient.class);
    when(apiClient.doPut(Mockito.<String>any(), Mockito.<Map<String, String>>any(), Mockito.<Map<String, String>>any(),
        Mockito.<Object>any(), Mockito.<Class<Object>>any())).thenReturn(false);
    TraceLoggingApiClient traceLoggingApiClient = new TraceLoggingApiClient(
        new HttpApiClientDecorator(new TraceLoggingApiClient(new HttpApiClientDecorator(apiClient))));
    HashMap<String, String> headerParams = new HashMap<>();
    HashMap<String, String> queryParams = new HashMap<>();
    Class<Object> returnType = Object.class;

    // Act
    traceLoggingApiClient.doPut("Path", headerParams, queryParams, "Payload", returnType);

    // Assert
    verify(apiClient).doPut(Mockito.<String>any(), isA(Map.class), isA(Map.class), isA(Object.class), isA(Class.class));
  }

  /**
   * Method under test:
   * {@link TraceLoggingApiClient#doDelete(String, Map, Map, Class)}
   */
  @Test
  public void testDoDelete() throws RemoteApiException {
    // Arrange
    HttpApiClient apiClient = mock(HttpApiClient.class);
    when(apiClient.doDelete(Mockito.<String>any(), Mockito.<Map<String, String>>any(),
        Mockito.<Map<String, String>>any(), Mockito.<Class<Object>>any())).thenReturn("Do Delete");
    TraceLoggingApiClient traceLoggingApiClient = new TraceLoggingApiClient(
        new HttpApiClientDecorator(new TraceLoggingApiClient(new HttpApiClientDecorator(apiClient))));
    HashMap<String, String> headerParams = new HashMap<>();
    HashMap<String, String> queryParams = new HashMap<>();
    Class<Object> returnType = Object.class;

    // Act
    Object actualDoDeleteResult = traceLoggingApiClient.doDelete("Path", headerParams, queryParams, returnType);

    // Assert
    verify(apiClient).doDelete(Mockito.<String>any(), isA(Map.class), isA(Map.class), isA(Class.class));
    assertEquals("Do Delete", actualDoDeleteResult);
  }

  /**
   * Method under test:
   * {@link TraceLoggingApiClient#doDelete(String, Map, Map, Class)}
   */
  @Test
  public void testDoDelete2() throws RemoteApiException {
    // Arrange
    HttpApiClient apiClient = mock(HttpApiClient.class);
    when(apiClient.doDelete(Mockito.<String>any(), Mockito.<Map<String, String>>any(),
        Mockito.<Map<String, String>>any(), Mockito.<Class<Object>>any())).thenReturn(true);
    TraceLoggingApiClient traceLoggingApiClient = new TraceLoggingApiClient(
        new HttpApiClientDecorator(new TraceLoggingApiClient(new HttpApiClientDecorator(apiClient))));
    HashMap<String, String> headerParams = new HashMap<>();
    HashMap<String, String> queryParams = new HashMap<>();
    Class<Object> returnType = Object.class;

    // Act
    traceLoggingApiClient.doDelete("Path", headerParams, queryParams, returnType);

    // Assert
    verify(apiClient).doDelete(Mockito.<String>any(), isA(Map.class), isA(Map.class), isA(Class.class));
  }

  /**
   * Method under test:
   * {@link TraceLoggingApiClient#doDelete(String, Map, Map, Class)}
   */
  @Test
  public void testDoDelete3() throws RemoteApiException {
    // Arrange
    HttpApiClient apiClient = mock(HttpApiClient.class);
    when(apiClient.doDelete(Mockito.<String>any(), Mockito.<Map<String, String>>any(),
        Mockito.<Map<String, String>>any(), Mockito.<Class<Object>>any())).thenReturn(false);
    TraceLoggingApiClient traceLoggingApiClient = new TraceLoggingApiClient(
        new HttpApiClientDecorator(new TraceLoggingApiClient(new HttpApiClientDecorator(apiClient))));
    HashMap<String, String> headerParams = new HashMap<>();
    HashMap<String, String> queryParams = new HashMap<>();
    Class<Object> returnType = Object.class;

    // Act
    traceLoggingApiClient.doDelete("Path", headerParams, queryParams, returnType);

    // Assert
    verify(apiClient).doDelete(Mockito.<String>any(), isA(Map.class), isA(Map.class), isA(Class.class));
  }
}
