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
import javax.ws.rs.ProcessingException;
import org.junit.Test;
import org.mockito.Mockito;
import org.symphonyoss.integration.api.client.trace.TraceLoggingApiClient;
import org.symphonyoss.integration.authentication.api.enums.ServiceName;
import org.symphonyoss.integration.exception.RemoteApiException;
import org.symphonyoss.integration.exception.authentication.ConnectivityException;

public class ConnectivityApiClientDecoratorDiffblueTest {
  /**
   * Method under test:
   * {@link ConnectivityApiClientDecorator#doGet(String, Map, Map, Class)}
   */
  @Test
  public void testDoGet() throws RemoteApiException {
    // Arrange
    HttpApiClient apiClient = mock(HttpApiClient.class);
    when(apiClient.doGet(Mockito.<String>any(), Mockito.<Map<String, String>>any(), Mockito.<Map<String, String>>any(),
        Mockito.<Class<Object>>any())).thenReturn("Do Get");
    ConnectivityApiClientDecorator connectivityApiClientDecorator = new ConnectivityApiClientDecorator(
        ServiceName.POD_SESSION_MANAGER,
        new HttpApiClientDecorator(new TraceLoggingApiClient(new HttpApiClientDecorator(apiClient))));
    HashMap<String, String> headerParams = new HashMap<>();
    HashMap<String, String> queryParams = new HashMap<>();
    Class<Object> returnType = Object.class;

    // Act
    Object actualDoGetResult = connectivityApiClientDecorator.doGet("Path", headerParams, queryParams, returnType);

    // Assert
    verify(apiClient).doGet(Mockito.<String>any(), isA(Map.class), isA(Map.class), isA(Class.class));
    assertEquals("Do Get", actualDoGetResult);
  }

  /**
   * Method under test:
   * {@link ConnectivityApiClientDecorator#doGet(String, Map, Map, Class)}
   */
  @Test
  public void testDoGet2() throws RemoteApiException {
    // Arrange
    HttpApiClient apiClient = mock(HttpApiClient.class);
    when(apiClient.doGet(Mockito.<String>any(), Mockito.<Map<String, String>>any(), Mockito.<Map<String, String>>any(),
        Mockito.<Class<Object>>any())).thenReturn(true);
    ConnectivityApiClientDecorator connectivityApiClientDecorator = new ConnectivityApiClientDecorator(
        ServiceName.POD_SESSION_MANAGER,
        new HttpApiClientDecorator(new TraceLoggingApiClient(new HttpApiClientDecorator(apiClient))));
    HashMap<String, String> headerParams = new HashMap<>();
    HashMap<String, String> queryParams = new HashMap<>();
    Class<Object> returnType = Object.class;

    // Act
    connectivityApiClientDecorator.doGet("Path", headerParams, queryParams, returnType);

    // Assert
    verify(apiClient).doGet(Mockito.<String>any(), isA(Map.class), isA(Map.class), isA(Class.class));
  }

  /**
   * Method under test:
   * {@link ConnectivityApiClientDecorator#doGet(String, Map, Map, Class)}
   */
  @Test
  public void testDoGet3() throws RemoteApiException {
    // Arrange
    HttpApiClient apiClient = mock(HttpApiClient.class);
    when(apiClient.doGet(Mockito.<String>any(), Mockito.<Map<String, String>>any(), Mockito.<Map<String, String>>any(),
        Mockito.<Class<Object>>any())).thenReturn(false);
    ConnectivityApiClientDecorator connectivityApiClientDecorator = new ConnectivityApiClientDecorator(
        ServiceName.POD_SESSION_MANAGER,
        new HttpApiClientDecorator(new TraceLoggingApiClient(new HttpApiClientDecorator(apiClient))));
    HashMap<String, String> headerParams = new HashMap<>();
    HashMap<String, String> queryParams = new HashMap<>();
    Class<Object> returnType = Object.class;

    // Act
    connectivityApiClientDecorator.doGet("Path", headerParams, queryParams, returnType);

    // Assert
    verify(apiClient).doGet(Mockito.<String>any(), isA(Map.class), isA(Map.class), isA(Class.class));
  }

  /**
   * Method under test:
   * {@link ConnectivityApiClientDecorator#doPost(String, Map, Map, Object, Class)}
   */
  @Test
  public void testDoPost() throws RemoteApiException {
    // Arrange
    HttpApiClient apiClient = mock(HttpApiClient.class);
    when(apiClient.doPost(Mockito.<String>any(), Mockito.<Map<String, String>>any(), Mockito.<Map<String, String>>any(),
        Mockito.<Object>any(), Mockito.<Class<Object>>any())).thenReturn("Do Post");
    ConnectivityApiClientDecorator connectivityApiClientDecorator = new ConnectivityApiClientDecorator(
        ServiceName.POD_SESSION_MANAGER, new TraceLoggingApiClient(new HttpApiClientDecorator(apiClient)));
    HashMap<String, String> headerParams = new HashMap<>();
    HashMap<String, String> queryParams = new HashMap<>();
    Class<Object> returnType = Object.class;

    // Act
    Object actualDoPostResult = connectivityApiClientDecorator.doPost("Path", headerParams, queryParams, "Payload",
        returnType);

    // Assert
    verify(apiClient).doPost(Mockito.<String>any(), isA(Map.class), isA(Map.class), isA(Object.class),
        isA(Class.class));
    assertEquals("Do Post", actualDoPostResult);
  }

  /**
   * Method under test:
   * {@link ConnectivityApiClientDecorator#doPost(String, Map, Map, Object, Class)}
   */
  @Test
  public void testDoPost2() throws RemoteApiException {
    // Arrange
    HttpApiClient apiClient = mock(HttpApiClient.class);
    when(apiClient.doPost(Mockito.<String>any(), Mockito.<Map<String, String>>any(), Mockito.<Map<String, String>>any(),
        Mockito.<Object>any(), Mockito.<Class<Object>>any())).thenReturn(true);
    ConnectivityApiClientDecorator connectivityApiClientDecorator = new ConnectivityApiClientDecorator(
        ServiceName.POD_SESSION_MANAGER, new TraceLoggingApiClient(new HttpApiClientDecorator(apiClient)));
    HashMap<String, String> headerParams = new HashMap<>();
    HashMap<String, String> queryParams = new HashMap<>();
    Class<Object> returnType = Object.class;

    // Act
    connectivityApiClientDecorator.doPost("Path", headerParams, queryParams, "Payload", returnType);

    // Assert
    verify(apiClient).doPost(Mockito.<String>any(), isA(Map.class), isA(Map.class), isA(Object.class),
        isA(Class.class));
  }

  /**
   * Method under test:
   * {@link ConnectivityApiClientDecorator#doPost(String, Map, Map, Object, Class)}
   */
  @Test
  public void testDoPost3() throws RemoteApiException {
    // Arrange
    HttpApiClient apiClient = mock(HttpApiClient.class);
    when(apiClient.doPost(Mockito.<String>any(), Mockito.<Map<String, String>>any(), Mockito.<Map<String, String>>any(),
        Mockito.<Object>any(), Mockito.<Class<Object>>any())).thenReturn(false);
    ConnectivityApiClientDecorator connectivityApiClientDecorator = new ConnectivityApiClientDecorator(
        ServiceName.POD_SESSION_MANAGER, new TraceLoggingApiClient(new HttpApiClientDecorator(apiClient)));
    HashMap<String, String> headerParams = new HashMap<>();
    HashMap<String, String> queryParams = new HashMap<>();
    Class<Object> returnType = Object.class;

    // Act
    connectivityApiClientDecorator.doPost("Path", headerParams, queryParams, "Payload", returnType);

    // Assert
    verify(apiClient).doPost(Mockito.<String>any(), isA(Map.class), isA(Map.class), isA(Object.class),
        isA(Class.class));
  }

  /**
   * Method under test:
   * {@link ConnectivityApiClientDecorator#doPost(String, Map, Map, Object, Class)}
   */
  @Test
  public void testDoPost4() throws RemoteApiException {
    // Arrange
    new ProcessingException("An error occurred");
    HttpApiClient apiClient = mock(HttpApiClient.class);
    when(apiClient.doPost(Mockito.<String>any(), Mockito.<Map<String, String>>any(), Mockito.<Map<String, String>>any(),
        Mockito.<Object>any(), Mockito.<Class<Object>>any())).thenReturn("Do Post");
    ConnectivityApiClientDecorator connectivityApiClientDecorator = new ConnectivityApiClientDecorator(
        ServiceName.POD_SESSION_MANAGER,
        new TraceLoggingApiClient(new ConnectivityApiClientDecorator(ServiceName.POD_SESSION_MANAGER,
            new TraceLoggingApiClient(new HttpApiClientDecorator(apiClient)))));
    HashMap<String, String> headerParams = new HashMap<>();
    HashMap<String, String> queryParams = new HashMap<>();
    Class<Object> returnType = Object.class;

    // Act
    Object actualDoPostResult = connectivityApiClientDecorator.doPost("Path", headerParams, queryParams, "Payload",
        returnType);

    // Assert
    verify(apiClient).doPost(Mockito.<String>any(), isA(Map.class), isA(Map.class), isA(Object.class),
        isA(Class.class));
    assertEquals("Do Post", actualDoPostResult);
  }

  /**
   * Method under test:
   * {@link ConnectivityApiClientDecorator#doPut(String, Map, Map, Object, Class)}
   */
  @Test
  public void testDoPut() throws RemoteApiException {
    // Arrange
    new ProcessingException("An error occurred");
    HttpApiClient apiClient = mock(HttpApiClient.class);
    when(apiClient.doPut(Mockito.<String>any(), Mockito.<Map<String, String>>any(), Mockito.<Map<String, String>>any(),
        Mockito.<Object>any(), Mockito.<Class<Object>>any())).thenReturn("Do Put");
    ConnectivityApiClientDecorator connectivityApiClientDecorator = new ConnectivityApiClientDecorator(
        ServiceName.POD_SESSION_MANAGER, new TraceLoggingApiClient(new HttpApiClientDecorator(apiClient)));
    HashMap<String, String> headerParams = new HashMap<>();
    HashMap<String, String> queryParams = new HashMap<>();
    Class<Object> returnType = Object.class;

    // Act
    Object actualDoPutResult = connectivityApiClientDecorator.doPut("Path", headerParams, queryParams, "Payload",
        returnType);

    // Assert
    verify(apiClient).doPut(Mockito.<String>any(), isA(Map.class), isA(Map.class), isA(Object.class), isA(Class.class));
    assertEquals("Do Put", actualDoPutResult);
  }

  /**
   * Method under test:
   * {@link ConnectivityApiClientDecorator#doPut(String, Map, Map, Object, Class)}
   */
  @Test
  public void testDoPut2() throws RemoteApiException {
    // Arrange
    new ProcessingException("An error occurred");
    HttpApiClient apiClient = mock(HttpApiClient.class);
    when(apiClient.doPut(Mockito.<String>any(), Mockito.<Map<String, String>>any(), Mockito.<Map<String, String>>any(),
        Mockito.<Object>any(), Mockito.<Class<Object>>any())).thenReturn(true);
    ConnectivityApiClientDecorator connectivityApiClientDecorator = new ConnectivityApiClientDecorator(
        ServiceName.POD_SESSION_MANAGER, new TraceLoggingApiClient(new HttpApiClientDecorator(apiClient)));
    HashMap<String, String> headerParams = new HashMap<>();
    HashMap<String, String> queryParams = new HashMap<>();
    Class<Object> returnType = Object.class;

    // Act
    connectivityApiClientDecorator.doPut("Path", headerParams, queryParams, "Payload", returnType);

    // Assert
    verify(apiClient).doPut(Mockito.<String>any(), isA(Map.class), isA(Map.class), isA(Object.class), isA(Class.class));
  }

  /**
   * Method under test:
   * {@link ConnectivityApiClientDecorator#doPut(String, Map, Map, Object, Class)}
   */
  @Test
  public void testDoPut3() throws RemoteApiException {
    // Arrange
    new ProcessingException("An error occurred");
    HttpApiClient apiClient = mock(HttpApiClient.class);
    when(apiClient.doPut(Mockito.<String>any(), Mockito.<Map<String, String>>any(), Mockito.<Map<String, String>>any(),
        Mockito.<Object>any(), Mockito.<Class<Object>>any())).thenReturn(false);
    ConnectivityApiClientDecorator connectivityApiClientDecorator = new ConnectivityApiClientDecorator(
        ServiceName.POD_SESSION_MANAGER, new TraceLoggingApiClient(new HttpApiClientDecorator(apiClient)));
    HashMap<String, String> headerParams = new HashMap<>();
    HashMap<String, String> queryParams = new HashMap<>();
    Class<Object> returnType = Object.class;

    // Act
    connectivityApiClientDecorator.doPut("Path", headerParams, queryParams, "Payload", returnType);

    // Assert
    verify(apiClient).doPut(Mockito.<String>any(), isA(Map.class), isA(Map.class), isA(Object.class), isA(Class.class));
  }

  /**
   * Method under test:
   * {@link ConnectivityApiClientDecorator#doPut(String, Map, Map, Object, Class)}
   */
  @Test
  public void testDoPut4() throws RemoteApiException {
    // Arrange
    new ProcessingException("An error occurred");
    new ProcessingException("An error occurred");
    new ProcessingException("An error occurred");
    HttpApiClient apiClient = mock(HttpApiClient.class);
    when(apiClient.doPut(Mockito.<String>any(), Mockito.<Map<String, String>>any(), Mockito.<Map<String, String>>any(),
        Mockito.<Object>any(), Mockito.<Class<Object>>any())).thenReturn("Do Put");
    ConnectivityApiClientDecorator connectivityApiClientDecorator = new ConnectivityApiClientDecorator(
        ServiceName.POD_SESSION_MANAGER,
        new TraceLoggingApiClient(new ConnectivityApiClientDecorator(ServiceName.POD_SESSION_MANAGER,
            new TraceLoggingApiClient(new HttpApiClientDecorator(apiClient)))));
    HashMap<String, String> headerParams = new HashMap<>();
    HashMap<String, String> queryParams = new HashMap<>();
    Class<Object> returnType = Object.class;

    // Act
    Object actualDoPutResult = connectivityApiClientDecorator.doPut("Path", headerParams, queryParams, "Payload",
        returnType);

    // Assert
    verify(apiClient).doPut(Mockito.<String>any(), isA(Map.class), isA(Map.class), isA(Object.class), isA(Class.class));
    assertEquals("Do Put", actualDoPutResult);
  }

  /**
   * Method under test:
   * {@link ConnectivityApiClientDecorator#doDelete(String, Map, Map, Class)}
   */
  @Test
  public void testDoDelete() throws RemoteApiException {
    // Arrange
    HttpApiClient apiClient = mock(HttpApiClient.class);
    when(apiClient.doDelete(Mockito.<String>any(), Mockito.<Map<String, String>>any(),
        Mockito.<Map<String, String>>any(), Mockito.<Class<Object>>any())).thenReturn("Do Delete");
    ConnectivityApiClientDecorator connectivityApiClientDecorator = new ConnectivityApiClientDecorator(
        ServiceName.POD_SESSION_MANAGER,
        new HttpApiClientDecorator(new TraceLoggingApiClient(new HttpApiClientDecorator(apiClient))));
    HashMap<String, String> headerParams = new HashMap<>();
    HashMap<String, String> queryParams = new HashMap<>();
    Class<Object> returnType = Object.class;

    // Act
    Object actualDoDeleteResult = connectivityApiClientDecorator.doDelete("Path", headerParams, queryParams,
        returnType);

    // Assert
    verify(apiClient).doDelete(Mockito.<String>any(), isA(Map.class), isA(Map.class), isA(Class.class));
    assertEquals("Do Delete", actualDoDeleteResult);
  }

  /**
   * Method under test:
   * {@link ConnectivityApiClientDecorator#doDelete(String, Map, Map, Class)}
   */
  @Test
  public void testDoDelete2() throws RemoteApiException {
    // Arrange
    HttpApiClient apiClient = mock(HttpApiClient.class);
    when(apiClient.doDelete(Mockito.<String>any(), Mockito.<Map<String, String>>any(),
        Mockito.<Map<String, String>>any(), Mockito.<Class<Object>>any())).thenReturn(true);
    ConnectivityApiClientDecorator connectivityApiClientDecorator = new ConnectivityApiClientDecorator(
        ServiceName.POD_SESSION_MANAGER,
        new HttpApiClientDecorator(new TraceLoggingApiClient(new HttpApiClientDecorator(apiClient))));
    HashMap<String, String> headerParams = new HashMap<>();
    HashMap<String, String> queryParams = new HashMap<>();
    Class<Object> returnType = Object.class;

    // Act
    connectivityApiClientDecorator.doDelete("Path", headerParams, queryParams, returnType);

    // Assert
    verify(apiClient).doDelete(Mockito.<String>any(), isA(Map.class), isA(Map.class), isA(Class.class));
  }

  /**
   * Method under test:
   * {@link ConnectivityApiClientDecorator#doDelete(String, Map, Map, Class)}
   */
  @Test
  public void testDoDelete3() throws RemoteApiException {
    // Arrange
    HttpApiClient apiClient = mock(HttpApiClient.class);
    when(apiClient.doDelete(Mockito.<String>any(), Mockito.<Map<String, String>>any(),
        Mockito.<Map<String, String>>any(), Mockito.<Class<Object>>any())).thenReturn(false);
    ConnectivityApiClientDecorator connectivityApiClientDecorator = new ConnectivityApiClientDecorator(
        ServiceName.POD_SESSION_MANAGER,
        new HttpApiClientDecorator(new TraceLoggingApiClient(new HttpApiClientDecorator(apiClient))));
    HashMap<String, String> headerParams = new HashMap<>();
    HashMap<String, String> queryParams = new HashMap<>();
    Class<Object> returnType = Object.class;

    // Act
    connectivityApiClientDecorator.doDelete("Path", headerParams, queryParams, returnType);

    // Assert
    verify(apiClient).doDelete(Mockito.<String>any(), isA(Map.class), isA(Map.class), isA(Class.class));
  }

  /**
   * Method under test:
   * {@link ConnectivityApiClientDecorator#getConnectivityException(ProcessingException)}
   */
  @Test
  public void testGetConnectivityException() {
    // Arrange
    ConnectivityApiClientDecorator connectivityApiClientDecorator = new ConnectivityApiClientDecorator(
        ServiceName.POD_SESSION_MANAGER,
        new HttpApiClientDecorator(new SimpleHttpApiClient(mock(EntitySerializer.class))));
    ProcessingException e = new ProcessingException("An error occurred");

    // Act
    ConnectivityException actualConnectivityException = connectivityApiClientDecorator.getConnectivityException(e);

    // Assert
    assertEquals(
        "\n" + "Component: Connectivity Api Client\n"
            + "Message: Integration Bridge can't reach POD_SESSION_MANAGER service!\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n" + "Stack trace: An error occurred\n",
        actualConnectivityException.getLocalizedMessage());
    assertEquals(
        "\n" + "Component: Connectivity Api Client\n"
            + "Message: Integration Bridge can't reach POD_SESSION_MANAGER service!\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n" + "Stack trace: An error occurred\n",
        actualConnectivityException.getMessage());
    assertEquals(0, actualConnectivityException.getSuppressed().length);
    assertSame(e, actualConnectivityException.getCause());
  }

  /**
   * Method under test:
   * {@link ConnectivityApiClientDecorator#ConnectivityApiClientDecorator(ServiceName, HttpApiClient)}
   */
  @Test
  public void testNewConnectivityApiClientDecorator() {
    // Arrange
    HttpApiClientDecorator apiClient = new HttpApiClientDecorator(
        new SimpleHttpApiClient(mock(EntitySerializer.class)));

    // Act and Assert
    HttpApiClient httpApiClient = (new ConnectivityApiClientDecorator(ServiceName.POD_SESSION_MANAGER,
        apiClient)).apiClient;
    assertTrue(httpApiClient instanceof HttpApiClientDecorator);
    HttpApiClient httpApiClient2 = ((HttpApiClientDecorator) httpApiClient).apiClient;
    assertTrue(httpApiClient2 instanceof SimpleHttpApiClient);
    assertSame(apiClient.apiClient, httpApiClient2);
  }
}
