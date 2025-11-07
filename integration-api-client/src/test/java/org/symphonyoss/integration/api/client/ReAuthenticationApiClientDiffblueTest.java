package org.symphonyoss.integration.api.client;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import org.mockito.Mockito;
import org.symphonyoss.integration.api.client.trace.TraceLoggingApiClient;
import org.symphonyoss.integration.authentication.AuthenticationProxy;
import org.symphonyoss.integration.exception.RemoteApiException;

public class ReAuthenticationApiClientDiffblueTest {
  /**
   * Method under test:
   * {@link ReAuthenticationApiClient#doGet(String, Map, Map, Class)}
   */
  @Test
  public void testDoGet() throws RemoteApiException {
    // Arrange
    HttpApiClient apiClient = mock(HttpApiClient.class);
    when(apiClient.doGet(Mockito.<String>any(), Mockito.<Map<String, String>>any(), Mockito.<Map<String, String>>any(),
        Mockito.<Class<Object>>any())).thenReturn("Do Get");
    ReAuthenticationApiClient reAuthenticationApiClient = new ReAuthenticationApiClient(mock(AuthenticationProxy.class),
        new HttpApiClientDecorator(new TraceLoggingApiClient(new HttpApiClientDecorator(apiClient))));
    HashMap<String, String> headerParams = new HashMap<>();
    HashMap<String, String> queryParams = new HashMap<>();
    Class<Object> returnType = Object.class;

    // Act
    Object actualDoGetResult = reAuthenticationApiClient.doGet("Path", headerParams, queryParams, returnType);

    // Assert
    verify(apiClient).doGet(Mockito.<String>any(), isA(Map.class), isA(Map.class), isA(Class.class));
    assertEquals("Do Get", actualDoGetResult);
  }

  /**
   * Method under test:
   * {@link ReAuthenticationApiClient#doGet(String, Map, Map, Class)}
   */
  @Test
  public void testDoGet2() throws RemoteApiException {
    // Arrange
    HttpApiClient apiClient = mock(HttpApiClient.class);
    when(apiClient.doGet(Mockito.<String>any(), Mockito.<Map<String, String>>any(), Mockito.<Map<String, String>>any(),
        Mockito.<Class<Object>>any())).thenReturn(true);
    ReAuthenticationApiClient reAuthenticationApiClient = new ReAuthenticationApiClient(mock(AuthenticationProxy.class),
        new HttpApiClientDecorator(new TraceLoggingApiClient(new HttpApiClientDecorator(apiClient))));
    HashMap<String, String> headerParams = new HashMap<>();
    HashMap<String, String> queryParams = new HashMap<>();
    Class<Object> returnType = Object.class;

    // Act
    reAuthenticationApiClient.doGet("Path", headerParams, queryParams, returnType);

    // Assert
    verify(apiClient).doGet(Mockito.<String>any(), isA(Map.class), isA(Map.class), isA(Class.class));
  }

  /**
   * Method under test:
   * {@link ReAuthenticationApiClient#doGet(String, Map, Map, Class)}
   */
  @Test
  public void testDoGet3() throws RemoteApiException {
    // Arrange
    HttpApiClient apiClient = mock(HttpApiClient.class);
    when(apiClient.doGet(Mockito.<String>any(), Mockito.<Map<String, String>>any(), Mockito.<Map<String, String>>any(),
        Mockito.<Class<Object>>any())).thenReturn(false);
    ReAuthenticationApiClient reAuthenticationApiClient = new ReAuthenticationApiClient(mock(AuthenticationProxy.class),
        new HttpApiClientDecorator(new TraceLoggingApiClient(new HttpApiClientDecorator(apiClient))));
    HashMap<String, String> headerParams = new HashMap<>();
    HashMap<String, String> queryParams = new HashMap<>();
    Class<Object> returnType = Object.class;

    // Act
    reAuthenticationApiClient.doGet("Path", headerParams, queryParams, returnType);

    // Assert
    verify(apiClient).doGet(Mockito.<String>any(), isA(Map.class), isA(Map.class), isA(Class.class));
  }

  /**
   * Method under test:
   * {@link ReAuthenticationApiClient#doGet(String, Map, Map, Class)}
   */
  @Test
  public void testDoGet4() throws RemoteApiException {
    // Arrange
    new RemoteApiException(1, "An error occurred");

    HttpApiClient apiClient = mock(HttpApiClient.class);
    when(apiClient.doGet(Mockito.<String>any(), Mockito.<Map<String, String>>any(), Mockito.<Map<String, String>>any(),
        Mockito.<Class<Object>>any())).thenReturn("Do Get");
    ReAuthenticationApiClient reAuthenticationApiClient = new ReAuthenticationApiClient(mock(AuthenticationProxy.class),
        new HttpApiClientDecorator(new TraceLoggingApiClient(
            new TraceLoggingApiClient(new ReAuthenticationApiClient(mock(AuthenticationProxy.class),
                new HttpApiClientDecorator(new TraceLoggingApiClient(new HttpApiClientDecorator(apiClient))))))));
    HashMap<String, String> headerParams = new HashMap<>();
    HashMap<String, String> queryParams = new HashMap<>();
    Class<Object> returnType = Object.class;

    // Act
    Object actualDoGetResult = reAuthenticationApiClient.doGet("Path", headerParams, queryParams, returnType);

    // Assert
    verify(apiClient).doGet(Mockito.<String>any(), isA(Map.class), isA(Map.class), isA(Class.class));
    assertEquals("Do Get", actualDoGetResult);
  }

  /**
   * Method under test:
   * {@link ReAuthenticationApiClient#doPost(String, Map, Map, Object, Class)}
   */
  @Test
  public void testDoPost() throws RemoteApiException {
    // Arrange
    new RemoteApiException(1, "An error occurred");

    HttpApiClient apiClient = mock(HttpApiClient.class);
    when(apiClient.doPost(Mockito.<String>any(), Mockito.<Map<String, String>>any(), Mockito.<Map<String, String>>any(),
        Mockito.<Object>any(), Mockito.<Class<Object>>any())).thenReturn("Do Post");
    ReAuthenticationApiClient reAuthenticationApiClient = new ReAuthenticationApiClient(mock(AuthenticationProxy.class),
        new TraceLoggingApiClient(new HttpApiClientDecorator(apiClient)));
    HashMap<String, String> headerParams = new HashMap<>();
    HashMap<String, String> queryParams = new HashMap<>();
    Class<Object> returnType = Object.class;

    // Act
    Object actualDoPostResult = reAuthenticationApiClient.doPost("Path", headerParams, queryParams, "Payload",
        returnType);

    // Assert
    verify(apiClient).doPost(Mockito.<String>any(), isA(Map.class), isA(Map.class), isA(Object.class),
        isA(Class.class));
    assertEquals("Do Post", actualDoPostResult);
  }

  /**
   * Method under test:
   * {@link ReAuthenticationApiClient#doPost(String, Map, Map, Object, Class)}
   */
  @Test
  public void testDoPost2() throws RemoteApiException {
    // Arrange
    new RemoteApiException(1, "An error occurred");

    HttpApiClient apiClient = mock(HttpApiClient.class);
    when(apiClient.doPost(Mockito.<String>any(), Mockito.<Map<String, String>>any(), Mockito.<Map<String, String>>any(),
        Mockito.<Object>any(), Mockito.<Class<Object>>any())).thenReturn(true);
    ReAuthenticationApiClient reAuthenticationApiClient = new ReAuthenticationApiClient(mock(AuthenticationProxy.class),
        new TraceLoggingApiClient(new HttpApiClientDecorator(apiClient)));
    HashMap<String, String> headerParams = new HashMap<>();
    HashMap<String, String> queryParams = new HashMap<>();
    Class<Object> returnType = Object.class;

    // Act
    reAuthenticationApiClient.doPost("Path", headerParams, queryParams, "Payload", returnType);

    // Assert
    verify(apiClient).doPost(Mockito.<String>any(), isA(Map.class), isA(Map.class), isA(Object.class),
        isA(Class.class));
  }

  /**
   * Method under test:
   * {@link ReAuthenticationApiClient#doPost(String, Map, Map, Object, Class)}
   */
  @Test
  public void testDoPost3() throws RemoteApiException {
    // Arrange
    new RemoteApiException(1, "An error occurred");

    HttpApiClient apiClient = mock(HttpApiClient.class);
    when(apiClient.doPost(Mockito.<String>any(), Mockito.<Map<String, String>>any(), Mockito.<Map<String, String>>any(),
        Mockito.<Object>any(), Mockito.<Class<Object>>any())).thenReturn(false);
    ReAuthenticationApiClient reAuthenticationApiClient = new ReAuthenticationApiClient(mock(AuthenticationProxy.class),
        new TraceLoggingApiClient(new HttpApiClientDecorator(apiClient)));
    HashMap<String, String> headerParams = new HashMap<>();
    HashMap<String, String> queryParams = new HashMap<>();
    Class<Object> returnType = Object.class;

    // Act
    reAuthenticationApiClient.doPost("Path", headerParams, queryParams, "Payload", returnType);

    // Assert
    verify(apiClient).doPost(Mockito.<String>any(), isA(Map.class), isA(Map.class), isA(Object.class),
        isA(Class.class));
  }

  /**
   * Method under test:
   * {@link ReAuthenticationApiClient#doPost(String, Map, Map, Object, Class)}
   */
  @Test
  public void testDoPost4() throws RemoteApiException {
    // Arrange
    new RemoteApiException(1, "An error occurred");

    new RemoteApiException(5, "An error occurred");

    new RemoteApiException(1, "An error occurred");

    HttpApiClient apiClient = mock(HttpApiClient.class);
    when(apiClient.doPost(Mockito.<String>any(), Mockito.<Map<String, String>>any(), Mockito.<Map<String, String>>any(),
        Mockito.<Object>any(), Mockito.<Class<Object>>any())).thenReturn("Do Post");
    ReAuthenticationApiClient reAuthenticationApiClient = new ReAuthenticationApiClient(mock(AuthenticationProxy.class),
        new TraceLoggingApiClient(new ReAuthenticationApiClient(mock(AuthenticationProxy.class),
            new TraceLoggingApiClient(new HttpApiClientDecorator(apiClient)))));
    HashMap<String, String> headerParams = new HashMap<>();
    HashMap<String, String> queryParams = new HashMap<>();
    Class<Object> returnType = Object.class;

    // Act
    Object actualDoPostResult = reAuthenticationApiClient.doPost("Path", headerParams, queryParams, "Payload",
        returnType);

    // Assert
    verify(apiClient).doPost(Mockito.<String>any(), isA(Map.class), isA(Map.class), isA(Object.class),
        isA(Class.class));
    assertEquals("Do Post", actualDoPostResult);
  }

  /**
   * Method under test:
   * {@link ReAuthenticationApiClient#doPut(String, Map, Map, Object, Class)}
   */
  @Test
  public void testDoPut() throws RemoteApiException {
    // Arrange
    new RemoteApiException(1, "An error occurred");

    HttpApiClient apiClient = mock(HttpApiClient.class);
    when(apiClient.doPut(Mockito.<String>any(), Mockito.<Map<String, String>>any(), Mockito.<Map<String, String>>any(),
        Mockito.<Object>any(), Mockito.<Class<Object>>any())).thenReturn("Do Put");
    ReAuthenticationApiClient reAuthenticationApiClient = new ReAuthenticationApiClient(mock(AuthenticationProxy.class),
        new TraceLoggingApiClient(new HttpApiClientDecorator(apiClient)));
    HashMap<String, String> headerParams = new HashMap<>();
    HashMap<String, String> queryParams = new HashMap<>();
    Class<Object> returnType = Object.class;

    // Act
    Object actualDoPutResult = reAuthenticationApiClient.doPut("Path", headerParams, queryParams, "Payload",
        returnType);

    // Assert
    verify(apiClient).doPut(Mockito.<String>any(), isA(Map.class), isA(Map.class), isA(Object.class), isA(Class.class));
    assertEquals("Do Put", actualDoPutResult);
  }

  /**
   * Method under test:
   * {@link ReAuthenticationApiClient#doPut(String, Map, Map, Object, Class)}
   */
  @Test
  public void testDoPut2() throws RemoteApiException {
    // Arrange
    new RemoteApiException(1, "An error occurred");

    HttpApiClient apiClient = mock(HttpApiClient.class);
    when(apiClient.doPut(Mockito.<String>any(), Mockito.<Map<String, String>>any(), Mockito.<Map<String, String>>any(),
        Mockito.<Object>any(), Mockito.<Class<Object>>any())).thenReturn(true);
    ReAuthenticationApiClient reAuthenticationApiClient = new ReAuthenticationApiClient(mock(AuthenticationProxy.class),
        new TraceLoggingApiClient(new HttpApiClientDecorator(apiClient)));
    HashMap<String, String> headerParams = new HashMap<>();
    HashMap<String, String> queryParams = new HashMap<>();
    Class<Object> returnType = Object.class;

    // Act
    reAuthenticationApiClient.doPut("Path", headerParams, queryParams, "Payload", returnType);

    // Assert
    verify(apiClient).doPut(Mockito.<String>any(), isA(Map.class), isA(Map.class), isA(Object.class), isA(Class.class));
  }

  /**
   * Method under test:
   * {@link ReAuthenticationApiClient#doPut(String, Map, Map, Object, Class)}
   */
  @Test
  public void testDoPut3() throws RemoteApiException {
    // Arrange
    new RemoteApiException(1, "An error occurred");

    HttpApiClient apiClient = mock(HttpApiClient.class);
    when(apiClient.doPut(Mockito.<String>any(), Mockito.<Map<String, String>>any(), Mockito.<Map<String, String>>any(),
        Mockito.<Object>any(), Mockito.<Class<Object>>any())).thenReturn(false);
    ReAuthenticationApiClient reAuthenticationApiClient = new ReAuthenticationApiClient(mock(AuthenticationProxy.class),
        new TraceLoggingApiClient(new HttpApiClientDecorator(apiClient)));
    HashMap<String, String> headerParams = new HashMap<>();
    HashMap<String, String> queryParams = new HashMap<>();
    Class<Object> returnType = Object.class;

    // Act
    reAuthenticationApiClient.doPut("Path", headerParams, queryParams, "Payload", returnType);

    // Assert
    verify(apiClient).doPut(Mockito.<String>any(), isA(Map.class), isA(Map.class), isA(Object.class), isA(Class.class));
  }

  /**
   * Method under test:
   * {@link ReAuthenticationApiClient#doPut(String, Map, Map, Object, Class)}
   */
  @Test
  public void testDoPut4() throws RemoteApiException {
    // Arrange
    new RemoteApiException(1, "An error occurred");

    new RemoteApiException(5, "An error occurred");

    new RemoteApiException(1, "An error occurred");

    HttpApiClient apiClient = mock(HttpApiClient.class);
    when(apiClient.doPut(Mockito.<String>any(), Mockito.<Map<String, String>>any(), Mockito.<Map<String, String>>any(),
        Mockito.<Object>any(), Mockito.<Class<Object>>any())).thenReturn("Do Put");
    ReAuthenticationApiClient reAuthenticationApiClient = new ReAuthenticationApiClient(mock(AuthenticationProxy.class),
        new TraceLoggingApiClient(new ReAuthenticationApiClient(mock(AuthenticationProxy.class),
            new TraceLoggingApiClient(new HttpApiClientDecorator(apiClient)))));
    HashMap<String, String> headerParams = new HashMap<>();
    HashMap<String, String> queryParams = new HashMap<>();
    Class<Object> returnType = Object.class;

    // Act
    Object actualDoPutResult = reAuthenticationApiClient.doPut("Path", headerParams, queryParams, "Payload",
        returnType);

    // Assert
    verify(apiClient).doPut(Mockito.<String>any(), isA(Map.class), isA(Map.class), isA(Object.class), isA(Class.class));
    assertEquals("Do Put", actualDoPutResult);
  }

  /**
   * Method under test:
   * {@link ReAuthenticationApiClient#doDelete(String, Map, Map, Class)}
   */
  @Test
  public void testDoDelete() throws RemoteApiException {
    // Arrange
    HttpApiClient apiClient = mock(HttpApiClient.class);
    when(apiClient.doDelete(Mockito.<String>any(), Mockito.<Map<String, String>>any(),
        Mockito.<Map<String, String>>any(), Mockito.<Class<Object>>any())).thenReturn("Do Delete");
    ReAuthenticationApiClient reAuthenticationApiClient = new ReAuthenticationApiClient(mock(AuthenticationProxy.class),
        new HttpApiClientDecorator(new TraceLoggingApiClient(new HttpApiClientDecorator(apiClient))));
    HashMap<String, String> headerParams = new HashMap<>();
    HashMap<String, String> queryParams = new HashMap<>();
    Class<Object> returnType = Object.class;

    // Act
    Object actualDoDeleteResult = reAuthenticationApiClient.doDelete("Path", headerParams, queryParams, returnType);

    // Assert
    verify(apiClient).doDelete(Mockito.<String>any(), isA(Map.class), isA(Map.class), isA(Class.class));
    assertEquals("Do Delete", actualDoDeleteResult);
  }

  /**
   * Method under test:
   * {@link ReAuthenticationApiClient#doDelete(String, Map, Map, Class)}
   */
  @Test
  public void testDoDelete2() throws RemoteApiException {
    // Arrange
    HttpApiClient apiClient = mock(HttpApiClient.class);
    when(apiClient.doDelete(Mockito.<String>any(), Mockito.<Map<String, String>>any(),
        Mockito.<Map<String, String>>any(), Mockito.<Class<Object>>any())).thenReturn(true);
    ReAuthenticationApiClient reAuthenticationApiClient = new ReAuthenticationApiClient(mock(AuthenticationProxy.class),
        new HttpApiClientDecorator(new TraceLoggingApiClient(new HttpApiClientDecorator(apiClient))));
    HashMap<String, String> headerParams = new HashMap<>();
    HashMap<String, String> queryParams = new HashMap<>();
    Class<Object> returnType = Object.class;

    // Act
    reAuthenticationApiClient.doDelete("Path", headerParams, queryParams, returnType);

    // Assert
    verify(apiClient).doDelete(Mockito.<String>any(), isA(Map.class), isA(Map.class), isA(Class.class));
  }

  /**
   * Method under test:
   * {@link ReAuthenticationApiClient#doDelete(String, Map, Map, Class)}
   */
  @Test
  public void testDoDelete3() throws RemoteApiException {
    // Arrange
    HttpApiClient apiClient = mock(HttpApiClient.class);
    when(apiClient.doDelete(Mockito.<String>any(), Mockito.<Map<String, String>>any(),
        Mockito.<Map<String, String>>any(), Mockito.<Class<Object>>any())).thenReturn(false);
    ReAuthenticationApiClient reAuthenticationApiClient = new ReAuthenticationApiClient(mock(AuthenticationProxy.class),
        new HttpApiClientDecorator(new TraceLoggingApiClient(new HttpApiClientDecorator(apiClient))));
    HashMap<String, String> headerParams = new HashMap<>();
    HashMap<String, String> queryParams = new HashMap<>();
    Class<Object> returnType = Object.class;

    // Act
    reAuthenticationApiClient.doDelete("Path", headerParams, queryParams, returnType);

    // Assert
    verify(apiClient).doDelete(Mockito.<String>any(), isA(Map.class), isA(Map.class), isA(Class.class));
  }

  /**
   * Method under test:
   * {@link ReAuthenticationApiClient#doDelete(String, Map, Map, Class)}
   */
  @Test
  public void testDoDelete4() throws RemoteApiException {
    // Arrange
    new RemoteApiException(1, "An error occurred");

    HttpApiClient apiClient = mock(HttpApiClient.class);
    when(apiClient.doDelete(Mockito.<String>any(), Mockito.<Map<String, String>>any(),
        Mockito.<Map<String, String>>any(), Mockito.<Class<Object>>any())).thenReturn("Do Delete");
    ReAuthenticationApiClient reAuthenticationApiClient = new ReAuthenticationApiClient(mock(AuthenticationProxy.class),
        new HttpApiClientDecorator(new TraceLoggingApiClient(
            new TraceLoggingApiClient(new ReAuthenticationApiClient(mock(AuthenticationProxy.class),
                new HttpApiClientDecorator(new TraceLoggingApiClient(new HttpApiClientDecorator(apiClient))))))));
    HashMap<String, String> headerParams = new HashMap<>();
    HashMap<String, String> queryParams = new HashMap<>();
    Class<Object> returnType = Object.class;

    // Act
    Object actualDoDeleteResult = reAuthenticationApiClient.doDelete("Path", headerParams, queryParams, returnType);

    // Assert
    verify(apiClient).doDelete(Mockito.<String>any(), isA(Map.class), isA(Map.class), isA(Class.class));
    assertEquals("Do Delete", actualDoDeleteResult);
  }

  /**
   * Method under test:
   * {@link ReAuthenticationApiClient#ReAuthenticationApiClient(AuthenticationProxy, HttpApiClient)}
   */
  @Test
  public void testNewReAuthenticationApiClient() {
    // Arrange
    AuthenticationProxy proxy = mock(AuthenticationProxy.class);
    HttpApiClientDecorator apiClient = new HttpApiClientDecorator(
        new SimpleHttpApiClient(mock(EntitySerializer.class)));

    // Act and Assert
    HttpApiClient httpApiClient = (new ReAuthenticationApiClient(proxy, apiClient)).apiClient;
    assertTrue(httpApiClient instanceof HttpApiClientDecorator);
    HttpApiClient httpApiClient2 = ((HttpApiClientDecorator) httpApiClient).apiClient;
    assertTrue(httpApiClient2 instanceof SimpleHttpApiClient);
    assertSame(apiClient.apiClient, httpApiClient2);
  }
}
