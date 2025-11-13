package org.symphonyoss.integration.api.client.trace;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import org.mockito.Mockito;
import org.symphonyoss.integration.api.client.HttpApiClient;
import org.symphonyoss.integration.api.client.HttpApiClientDecorator;
import org.symphonyoss.integration.exception.RemoteApiException;

public class TraceLoggingApiClientDiffblueTest {
  /**
   * Test {@link TraceLoggingApiClient#doGet(String, Map, Map, Class)}.
   *
   * <ul>
   *   <li>Given {@link HttpApiClient} {@link HttpApiClient#doGet(String, Map, Map, Class)} return
   *       {@code Do Get}.
   *   <li>Then return {@code Do Get}.
   * </ul>
   *
   * <p>Method under test: {@link TraceLoggingApiClient#doGet(String, Map, Map, Class)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Object TraceLoggingApiClient.doGet(String, Map, Map, Class)"})
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
    TraceLoggingApiClient traceLoggingApiClient = new TraceLoggingApiClient(apiClient4);
    HashMap<String, String> headerParams = new HashMap<>();
    HashMap<String, String> queryParams = new HashMap<>();
    Class<Object> returnType = Object.class;

    // Act
    Object actualDoGetResult =
        traceLoggingApiClient.doGet("Path", headerParams, queryParams, returnType);

    // Assert
    verify(apiClient)
        .doGet(Mockito.<String>any(), isA(Map.class), isA(Map.class), isA(Class.class));
    assertEquals("Do Get", actualDoGetResult);
  }

  /**
   * Test {@link TraceLoggingApiClient#doGet(String, Map, Map, Class)}.
   *
   * <ul>
   *   <li>Given {@link HttpApiClient} {@link HttpApiClient#doGet(String, Map, Map, Class)} return
   *       {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TraceLoggingApiClient#doGet(String, Map, Map, Class)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Object TraceLoggingApiClient.doGet(String, Map, Map, Class)"})
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
    TraceLoggingApiClient traceLoggingApiClient = new TraceLoggingApiClient(apiClient4);
    HashMap<String, String> headerParams = new HashMap<>();
    HashMap<String, String> queryParams = new HashMap<>();
    Class<Object> returnType = Object.class;

    // Act
    Object actualDoGetResult =
        traceLoggingApiClient.doGet("Path", headerParams, queryParams, returnType);

    // Assert
    verify(apiClient)
        .doGet(Mockito.<String>any(), isA(Map.class), isA(Map.class), isA(Class.class));
    assertFalse((Boolean) actualDoGetResult);
  }

  /**
   * Test {@link TraceLoggingApiClient#doGet(String, Map, Map, Class)}.
   *
   * <ul>
   *   <li>Given {@link HttpApiClient} {@link HttpApiClient#doGet(String, Map, Map, Class)} return
   *       {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TraceLoggingApiClient#doGet(String, Map, Map, Class)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Object TraceLoggingApiClient.doGet(String, Map, Map, Class)"})
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
    TraceLoggingApiClient traceLoggingApiClient = new TraceLoggingApiClient(apiClient4);
    HashMap<String, String> headerParams = new HashMap<>();
    HashMap<String, String> queryParams = new HashMap<>();
    Class<Object> returnType = Object.class;

    // Act
    Object actualDoGetResult =
        traceLoggingApiClient.doGet("Path", headerParams, queryParams, returnType);

    // Assert
    verify(apiClient)
        .doGet(Mockito.<String>any(), isA(Map.class), isA(Map.class), isA(Class.class));
    assertTrue((Boolean) actualDoGetResult);
  }

  /**
   * Test {@link TraceLoggingApiClient#doPost(String, Map, Map, Object, Class)}.
   *
   * <ul>
   *   <li>Given {@link HttpApiClient} {@link HttpApiClient#doPost(String, Map, Map, Object, Class)}
   *       return {@code Do Post}.
   *   <li>Then return {@code Do Post}.
   * </ul>
   *
   * <p>Method under test: {@link TraceLoggingApiClient#doPost(String, Map, Map, Object, Class)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Object TraceLoggingApiClient.doPost(String, Map, Map, Object, Class)"})
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
    HttpApiClientDecorator apiClient4 = new HttpApiClientDecorator(apiClient3);
    TraceLoggingApiClient traceLoggingApiClient = new TraceLoggingApiClient(apiClient4);
    HashMap<String, String> headerParams = new HashMap<>();
    HashMap<String, String> queryParams = new HashMap<>();
    Class<Object> returnType = Object.class;

    // Act
    Object actualDoPostResult =
        traceLoggingApiClient.doPost("Path", headerParams, queryParams, "Payload", returnType);

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
   * Test {@link TraceLoggingApiClient#doPost(String, Map, Map, Object, Class)}.
   *
   * <ul>
   *   <li>Given {@link HttpApiClient} {@link HttpApiClient#doPost(String, Map, Map, Object, Class)}
   *       return {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TraceLoggingApiClient#doPost(String, Map, Map, Object, Class)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Object TraceLoggingApiClient.doPost(String, Map, Map, Object, Class)"})
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
    HttpApiClientDecorator apiClient4 = new HttpApiClientDecorator(apiClient3);
    TraceLoggingApiClient traceLoggingApiClient = new TraceLoggingApiClient(apiClient4);
    HashMap<String, String> headerParams = new HashMap<>();
    HashMap<String, String> queryParams = new HashMap<>();
    Class<Object> returnType = Object.class;

    // Act
    Object actualDoPostResult =
        traceLoggingApiClient.doPost("Path", headerParams, queryParams, "Payload", returnType);

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
   * Test {@link TraceLoggingApiClient#doPost(String, Map, Map, Object, Class)}.
   *
   * <ul>
   *   <li>Given {@link HttpApiClient} {@link HttpApiClient#doPost(String, Map, Map, Object, Class)}
   *       return {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TraceLoggingApiClient#doPost(String, Map, Map, Object, Class)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Object TraceLoggingApiClient.doPost(String, Map, Map, Object, Class)"})
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
    HttpApiClientDecorator apiClient4 = new HttpApiClientDecorator(apiClient3);
    TraceLoggingApiClient traceLoggingApiClient = new TraceLoggingApiClient(apiClient4);
    HashMap<String, String> headerParams = new HashMap<>();
    HashMap<String, String> queryParams = new HashMap<>();
    Class<Object> returnType = Object.class;

    // Act
    Object actualDoPostResult =
        traceLoggingApiClient.doPost("Path", headerParams, queryParams, "Payload", returnType);

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
   * Test {@link TraceLoggingApiClient#doPut(String, Map, Map, Object, Class)}.
   *
   * <ul>
   *   <li>Given {@link HttpApiClient} {@link HttpApiClient#doPut(String, Map, Map, Object, Class)}
   *       return {@code Do Put}.
   *   <li>Then return {@code Do Put}.
   * </ul>
   *
   * <p>Method under test: {@link TraceLoggingApiClient#doPut(String, Map, Map, Object, Class)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Object TraceLoggingApiClient.doPut(String, Map, Map, Object, Class)"})
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
    HttpApiClientDecorator apiClient4 = new HttpApiClientDecorator(apiClient3);
    TraceLoggingApiClient traceLoggingApiClient = new TraceLoggingApiClient(apiClient4);
    HashMap<String, String> headerParams = new HashMap<>();
    HashMap<String, String> queryParams = new HashMap<>();
    Class<Object> returnType = Object.class;

    // Act
    Object actualDoPutResult =
        traceLoggingApiClient.doPut("Path", headerParams, queryParams, "Payload", returnType);

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
   * Test {@link TraceLoggingApiClient#doPut(String, Map, Map, Object, Class)}.
   *
   * <ul>
   *   <li>Given {@link HttpApiClient} {@link HttpApiClient#doPut(String, Map, Map, Object, Class)}
   *       return {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TraceLoggingApiClient#doPut(String, Map, Map, Object, Class)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Object TraceLoggingApiClient.doPut(String, Map, Map, Object, Class)"})
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
    HttpApiClientDecorator apiClient4 = new HttpApiClientDecorator(apiClient3);
    TraceLoggingApiClient traceLoggingApiClient = new TraceLoggingApiClient(apiClient4);
    HashMap<String, String> headerParams = new HashMap<>();
    HashMap<String, String> queryParams = new HashMap<>();
    Class<Object> returnType = Object.class;

    // Act
    Object actualDoPutResult =
        traceLoggingApiClient.doPut("Path", headerParams, queryParams, "Payload", returnType);

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
   * Test {@link TraceLoggingApiClient#doPut(String, Map, Map, Object, Class)}.
   *
   * <ul>
   *   <li>Given {@link HttpApiClient} {@link HttpApiClient#doPut(String, Map, Map, Object, Class)}
   *       return {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TraceLoggingApiClient#doPut(String, Map, Map, Object, Class)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Object TraceLoggingApiClient.doPut(String, Map, Map, Object, Class)"})
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
    HttpApiClientDecorator apiClient4 = new HttpApiClientDecorator(apiClient3);
    TraceLoggingApiClient traceLoggingApiClient = new TraceLoggingApiClient(apiClient4);
    HashMap<String, String> headerParams = new HashMap<>();
    HashMap<String, String> queryParams = new HashMap<>();
    Class<Object> returnType = Object.class;

    // Act
    Object actualDoPutResult =
        traceLoggingApiClient.doPut("Path", headerParams, queryParams, "Payload", returnType);

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
   * Test {@link TraceLoggingApiClient#doDelete(String, Map, Map, Class)}.
   *
   * <ul>
   *   <li>Given {@link HttpApiClient} {@link HttpApiClient#doDelete(String, Map, Map, Class)}
   *       return {@code Do Delete}.
   *   <li>Then return {@code Do Delete}.
   * </ul>
   *
   * <p>Method under test: {@link TraceLoggingApiClient#doDelete(String, Map, Map, Class)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Object TraceLoggingApiClient.doDelete(String, Map, Map, Class)"})
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
    TraceLoggingApiClient traceLoggingApiClient = new TraceLoggingApiClient(apiClient4);
    HashMap<String, String> headerParams = new HashMap<>();
    HashMap<String, String> queryParams = new HashMap<>();
    Class<Object> returnType = Object.class;

    // Act
    Object actualDoDeleteResult =
        traceLoggingApiClient.doDelete("Path", headerParams, queryParams, returnType);

    // Assert
    verify(apiClient)
        .doDelete(Mockito.<String>any(), isA(Map.class), isA(Map.class), isA(Class.class));
    assertEquals("Do Delete", actualDoDeleteResult);
  }

  /**
   * Test {@link TraceLoggingApiClient#doDelete(String, Map, Map, Class)}.
   *
   * <ul>
   *   <li>Given {@link HttpApiClient} {@link HttpApiClient#doDelete(String, Map, Map, Class)}
   *       return {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TraceLoggingApiClient#doDelete(String, Map, Map, Class)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Object TraceLoggingApiClient.doDelete(String, Map, Map, Class)"})
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
    TraceLoggingApiClient traceLoggingApiClient = new TraceLoggingApiClient(apiClient4);
    HashMap<String, String> headerParams = new HashMap<>();
    HashMap<String, String> queryParams = new HashMap<>();
    Class<Object> returnType = Object.class;

    // Act
    Object actualDoDeleteResult =
        traceLoggingApiClient.doDelete("Path", headerParams, queryParams, returnType);

    // Assert
    verify(apiClient)
        .doDelete(Mockito.<String>any(), isA(Map.class), isA(Map.class), isA(Class.class));
    assertFalse((Boolean) actualDoDeleteResult);
  }

  /**
   * Test {@link TraceLoggingApiClient#doDelete(String, Map, Map, Class)}.
   *
   * <ul>
   *   <li>Given {@link HttpApiClient} {@link HttpApiClient#doDelete(String, Map, Map, Class)}
   *       return {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TraceLoggingApiClient#doDelete(String, Map, Map, Class)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Object TraceLoggingApiClient.doDelete(String, Map, Map, Class)"})
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
    TraceLoggingApiClient traceLoggingApiClient = new TraceLoggingApiClient(apiClient4);
    HashMap<String, String> headerParams = new HashMap<>();
    HashMap<String, String> queryParams = new HashMap<>();
    Class<Object> returnType = Object.class;

    // Act
    Object actualDoDeleteResult =
        traceLoggingApiClient.doDelete("Path", headerParams, queryParams, returnType);

    // Assert
    verify(apiClient)
        .doDelete(Mockito.<String>any(), isA(Map.class), isA(Map.class), isA(Class.class));
    assertTrue((Boolean) actualDoDeleteResult);
  }
}
