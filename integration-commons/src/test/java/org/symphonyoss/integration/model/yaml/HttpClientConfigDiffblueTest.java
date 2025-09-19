package org.symphonyoss.integration.model.yaml;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;

public class HttpClientConfigDiffblueTest {
  /**
   * Test {@link HttpClientConfig#setConnectTimeout(Integer)}.
   *
   * <p>Method under test: {@link HttpClientConfig#setConnectTimeout(Integer)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"void HttpClientConfig.setConnectTimeout(Integer)"})
  public void testSetConnectTimeout() {
    // Arrange
    HttpClientConfig httpClientConfig = new HttpClientConfig();
    httpClientConfig.setConnectTimeout(10);
    httpClientConfig.setMaxConnections(3);
    httpClientConfig.setMaxConnectionsPerRoute(3);
    httpClientConfig.setReadTimeout(10);

    // Act
    httpClientConfig.setConnectTimeout(20001);

    // Assert
    assertEquals(
        HttpClientConfig.MAX_CONNECT_TIMEOUT, httpClientConfig.getConnectTimeout().intValue());
  }

  /**
   * Test {@link HttpClientConfig#setConnectTimeout(Integer)}.
   *
   * <ul>
   *   <li>Given {@link HttpClientConfig} (default constructor).
   *   <li>When ten.
   * </ul>
   *
   * <p>Method under test: {@link HttpClientConfig#setConnectTimeout(Integer)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"void HttpClientConfig.setConnectTimeout(Integer)"})
  public void testSetConnectTimeout_givenHttpClientConfig_whenTen() {
    // Arrange
    HttpClientConfig httpClientConfig = new HttpClientConfig();

    // Act
    httpClientConfig.setConnectTimeout(10);

    // Assert that nothing has changed
    assertEquals(
        HttpClientConfig.MIN_CONNECT_TIMEOUT, httpClientConfig.getConnectTimeout().intValue());
  }

  /**
   * Test {@link HttpClientConfig#setConnectTimeout(Integer)}.
   *
   * <ul>
   *   <li>When {@link HttpClientConfig#MIN_CONNECT_TIMEOUT}.
   * </ul>
   *
   * <p>Method under test: {@link HttpClientConfig#setConnectTimeout(Integer)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"void HttpClientConfig.setConnectTimeout(Integer)"})
  public void testSetConnectTimeout_whenMin_connect_timeout() {
    // Arrange
    HttpClientConfig httpClientConfig = new HttpClientConfig();
    httpClientConfig.setConnectTimeout(10);
    httpClientConfig.setMaxConnections(3);
    httpClientConfig.setMaxConnectionsPerRoute(3);
    httpClientConfig.setReadTimeout(10);

    // Act
    httpClientConfig.setConnectTimeout(HttpClientConfig.MIN_CONNECT_TIMEOUT);

    // Assert that nothing has changed
    assertEquals(
        HttpClientConfig.MIN_CONNECT_TIMEOUT, httpClientConfig.getConnectTimeout().intValue());
  }

  /**
   * Test {@link HttpClientConfig#setConnectTimeout(Integer)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link HttpClientConfig#setConnectTimeout(Integer)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"void HttpClientConfig.setConnectTimeout(Integer)"})
  public void testSetConnectTimeout_whenNull() {
    // Arrange
    HttpClientConfig httpClientConfig = new HttpClientConfig();
    httpClientConfig.setConnectTimeout(10);
    httpClientConfig.setMaxConnections(3);
    httpClientConfig.setMaxConnectionsPerRoute(3);
    httpClientConfig.setReadTimeout(10);

    // Act
    httpClientConfig.setConnectTimeout(null);

    // Assert that nothing has changed
    assertEquals(
        HttpClientConfig.MIN_CONNECT_TIMEOUT, httpClientConfig.getConnectTimeout().intValue());
  }

  /**
   * Test {@link HttpClientConfig#setReadTimeout(Integer)}.
   *
   * <ul>
   *   <li>Given {@link HttpClientConfig} (default constructor).
   *   <li>When ten.
   * </ul>
   *
   * <p>Method under test: {@link HttpClientConfig#setReadTimeout(Integer)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"void HttpClientConfig.setReadTimeout(Integer)"})
  public void testSetReadTimeout_givenHttpClientConfig_whenTen() {
    // Arrange
    HttpClientConfig httpClientConfig = new HttpClientConfig();

    // Act
    httpClientConfig.setReadTimeout(10);

    // Assert that nothing has changed
    assertEquals(HttpClientConfig.MIN_READ_TIMEOUT, httpClientConfig.getReadTimeout().intValue());
  }

  /**
   * Test {@link HttpClientConfig#setReadTimeout(Integer)}.
   *
   * <ul>
   *   <li>Then {@link HttpClientConfig} (default constructor) ReadTimeout intValue is {@link
   *       HttpClientConfig#MAX_READ_TIMEOUT}.
   * </ul>
   *
   * <p>Method under test: {@link HttpClientConfig#setReadTimeout(Integer)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"void HttpClientConfig.setReadTimeout(Integer)"})
  public void testSetReadTimeout_thenHttpClientConfigReadTimeoutIntValueIsMax_read_timeout() {
    // Arrange
    HttpClientConfig httpClientConfig = new HttpClientConfig();
    httpClientConfig.setConnectTimeout(HttpClientConfig.MAX_CONNECT_TIMEOUT);
    httpClientConfig.setMaxConnections(3);
    httpClientConfig.setMaxConnectionsPerRoute(3);
    httpClientConfig.setReadTimeout(10);

    // Act
    httpClientConfig.setReadTimeout(HttpClientConfig.MAX_CONNECT_TIMEOUT);

    // Assert
    assertEquals(HttpClientConfig.MAX_READ_TIMEOUT, httpClientConfig.getReadTimeout().intValue());
  }

  /**
   * Test {@link HttpClientConfig#setReadTimeout(Integer)}.
   *
   * <ul>
   *   <li>Then {@link HttpClientConfig} (default constructor) ReadTimeout intValue is {@link
   *       HttpClientConfig#MIN_CONNECT_TIMEOUT}.
   * </ul>
   *
   * <p>Method under test: {@link HttpClientConfig#setReadTimeout(Integer)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"void HttpClientConfig.setReadTimeout(Integer)"})
  public void testSetReadTimeout_thenHttpClientConfigReadTimeoutIntValueIsMin_connect_timeout() {
    // Arrange
    HttpClientConfig httpClientConfig = new HttpClientConfig();
    httpClientConfig.setConnectTimeout(10);
    httpClientConfig.setMaxConnections(3);
    httpClientConfig.setMaxConnectionsPerRoute(3);
    httpClientConfig.setReadTimeout(10);

    // Act
    httpClientConfig.setReadTimeout(HttpClientConfig.MAX_READ_TIMEOUT);

    // Assert
    assertEquals(
        HttpClientConfig.MIN_CONNECT_TIMEOUT, httpClientConfig.getReadTimeout().intValue());
  }

  /**
   * Test {@link HttpClientConfig#setReadTimeout(Integer)}.
   *
   * <ul>
   *   <li>When {@link HttpClientConfig#MIN_READ_TIMEOUT}.
   * </ul>
   *
   * <p>Method under test: {@link HttpClientConfig#setReadTimeout(Integer)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"void HttpClientConfig.setReadTimeout(Integer)"})
  public void testSetReadTimeout_whenMin_read_timeout() {
    // Arrange
    HttpClientConfig httpClientConfig = new HttpClientConfig();
    httpClientConfig.setConnectTimeout(10);
    httpClientConfig.setMaxConnections(3);
    httpClientConfig.setMaxConnectionsPerRoute(3);
    httpClientConfig.setReadTimeout(10);

    // Act
    httpClientConfig.setReadTimeout(HttpClientConfig.MIN_READ_TIMEOUT);

    // Assert that nothing has changed
    assertEquals(HttpClientConfig.MIN_READ_TIMEOUT, httpClientConfig.getReadTimeout().intValue());
  }

  /**
   * Test {@link HttpClientConfig#setReadTimeout(Integer)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link HttpClientConfig#setReadTimeout(Integer)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"void HttpClientConfig.setReadTimeout(Integer)"})
  public void testSetReadTimeout_whenNull() {
    // Arrange
    HttpClientConfig httpClientConfig = new HttpClientConfig();
    httpClientConfig.setConnectTimeout(10);
    httpClientConfig.setMaxConnections(3);
    httpClientConfig.setMaxConnectionsPerRoute(3);
    httpClientConfig.setReadTimeout(10);

    // Act
    httpClientConfig.setReadTimeout(null);

    // Assert that nothing has changed
    assertEquals(HttpClientConfig.MIN_READ_TIMEOUT, httpClientConfig.getReadTimeout().intValue());
  }

  /**
   * Test {@link HttpClientConfig#setMaxConnections(Integer)}.
   *
   * <p>Method under test: {@link HttpClientConfig#setMaxConnections(Integer)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"void HttpClientConfig.setMaxConnections(Integer)"})
  public void testSetMaxConnections() {
    // Arrange
    HttpClientConfig httpClientConfig = new HttpClientConfig();
    httpClientConfig.setConnectTimeout(10);
    httpClientConfig.setMaxConnections(3);
    httpClientConfig.setMaxConnectionsPerRoute(3);
    httpClientConfig.setReadTimeout(10);

    // Act
    httpClientConfig.setMaxConnections(401);

    // Assert
    assertEquals(
        HttpClientConfig.MAX_TOTAL_CONNECTIONS, httpClientConfig.getMaxConnections().intValue());
  }

  /**
   * Test {@link HttpClientConfig#setMaxConnections(Integer)}.
   *
   * <ul>
   *   <li>Then {@link HttpClientConfig} (default constructor) MaxConnections intValue is three.
   * </ul>
   *
   * <p>Method under test: {@link HttpClientConfig#setMaxConnections(Integer)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"void HttpClientConfig.setMaxConnections(Integer)"})
  public void testSetMaxConnections_thenHttpClientConfigMaxConnectionsIntValueIsThree() {
    // Arrange
    HttpClientConfig httpClientConfig = new HttpClientConfig();

    // Act
    httpClientConfig.setMaxConnections(3);

    // Assert
    assertEquals(3, httpClientConfig.getMaxConnections().intValue());
  }

  /**
   * Test {@link HttpClientConfig#setMaxConnections(Integer)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link HttpClientConfig#setMaxConnections(Integer)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"void HttpClientConfig.setMaxConnections(Integer)"})
  public void testSetMaxConnections_whenNull() {
    // Arrange
    HttpClientConfig httpClientConfig = new HttpClientConfig();
    httpClientConfig.setConnectTimeout(10);
    httpClientConfig.setMaxConnections(3);
    httpClientConfig.setMaxConnectionsPerRoute(3);
    httpClientConfig.setReadTimeout(10);

    // Act
    httpClientConfig.setMaxConnections(null);

    // Assert
    assertEquals(
        HttpClientConfig.DEFAULT_TOTAL_CONNECTIONS,
        httpClientConfig.getMaxConnections().intValue());
  }

  /**
   * Test {@link HttpClientConfig#setMaxConnections(Integer)}.
   *
   * <ul>
   *   <li>When zero.
   * </ul>
   *
   * <p>Method under test: {@link HttpClientConfig#setMaxConnections(Integer)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"void HttpClientConfig.setMaxConnections(Integer)"})
  public void testSetMaxConnections_whenZero() {
    // Arrange
    HttpClientConfig httpClientConfig = new HttpClientConfig();
    httpClientConfig.setConnectTimeout(10);
    httpClientConfig.setMaxConnections(3);
    httpClientConfig.setMaxConnectionsPerRoute(3);
    httpClientConfig.setReadTimeout(10);

    // Act
    httpClientConfig.setMaxConnections(0);

    // Assert
    assertEquals(
        HttpClientConfig.DEFAULT_TOTAL_CONNECTIONS,
        httpClientConfig.getMaxConnections().intValue());
  }

  /**
   * Test {@link HttpClientConfig#setMaxConnectionsPerRoute(Integer)}.
   *
   * <p>Method under test: {@link HttpClientConfig#setMaxConnectionsPerRoute(Integer)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"void HttpClientConfig.setMaxConnectionsPerRoute(Integer)"})
  public void testSetMaxConnectionsPerRoute() {
    // Arrange
    HttpClientConfig httpClientConfig = new HttpClientConfig();

    // Act
    httpClientConfig.setMaxConnectionsPerRoute(3);

    // Assert
    assertEquals(3, httpClientConfig.getMaxConnectionsPerRoute().intValue());
  }

  /**
   * Test {@link HttpClientConfig#setMaxConnectionsPerRoute(Integer)}.
   *
   * <p>Method under test: {@link HttpClientConfig#setMaxConnectionsPerRoute(Integer)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"void HttpClientConfig.setMaxConnectionsPerRoute(Integer)"})
  public void testSetMaxConnectionsPerRoute2() {
    // Arrange
    HttpClientConfig httpClientConfig = new HttpClientConfig();
    httpClientConfig.setConnectTimeout(10);
    httpClientConfig.setMaxConnections(3);
    httpClientConfig.setMaxConnectionsPerRoute(3);
    httpClientConfig.setReadTimeout(10);

    // Act
    httpClientConfig.setMaxConnectionsPerRoute(201);

    // Assert
    assertEquals(
        HttpClientConfig.MAX_TOTAL_CONNECTIONS_PER_ROUTE,
        httpClientConfig.getMaxConnectionsPerRoute().intValue());
  }

  /**
   * Test {@link HttpClientConfig#setMaxConnectionsPerRoute(Integer)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link HttpClientConfig#setMaxConnectionsPerRoute(Integer)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"void HttpClientConfig.setMaxConnectionsPerRoute(Integer)"})
  public void testSetMaxConnectionsPerRoute_whenNull() {
    // Arrange
    HttpClientConfig httpClientConfig = new HttpClientConfig();
    httpClientConfig.setConnectTimeout(10);
    httpClientConfig.setMaxConnections(3);
    httpClientConfig.setMaxConnectionsPerRoute(3);
    httpClientConfig.setReadTimeout(10);

    // Act
    httpClientConfig.setMaxConnectionsPerRoute(null);

    // Assert
    assertEquals(
        HttpClientConfig.DEFAULT_TOTAL_CONNECTIONS_PER_ROUTE,
        httpClientConfig.getMaxConnectionsPerRoute().intValue());
  }

  /**
   * Test {@link HttpClientConfig#setMaxConnectionsPerRoute(Integer)}.
   *
   * <ul>
   *   <li>When zero.
   * </ul>
   *
   * <p>Method under test: {@link HttpClientConfig#setMaxConnectionsPerRoute(Integer)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"void HttpClientConfig.setMaxConnectionsPerRoute(Integer)"})
  public void testSetMaxConnectionsPerRoute_whenZero() {
    // Arrange
    HttpClientConfig httpClientConfig = new HttpClientConfig();
    httpClientConfig.setConnectTimeout(10);
    httpClientConfig.setMaxConnections(3);
    httpClientConfig.setMaxConnectionsPerRoute(3);
    httpClientConfig.setReadTimeout(10);

    // Act
    httpClientConfig.setMaxConnectionsPerRoute(0);

    // Assert
    assertEquals(
        HttpClientConfig.DEFAULT_TOTAL_CONNECTIONS_PER_ROUTE,
        httpClientConfig.getMaxConnectionsPerRoute().intValue());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link HttpClientConfig}
   *   <li>{@link HttpClientConfig#toString()}
   *   <li>{@link HttpClientConfig#getConnectTimeout()}
   *   <li>{@link HttpClientConfig#getMaxConnections()}
   *   <li>{@link HttpClientConfig#getMaxConnectionsPerRoute()}
   *   <li>{@link HttpClientConfig#getReadTimeout()}
   * </ul>
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void HttpClientConfig.<init>()",
    "Integer HttpClientConfig.getConnectTimeout()",
    "Integer HttpClientConfig.getMaxConnections()",
    "Integer HttpClientConfig.getMaxConnectionsPerRoute()",
    "Integer HttpClientConfig.getReadTimeout()",
    "String HttpClientConfig.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    HttpClientConfig actualHttpClientConfig = new HttpClientConfig();
    String actualToStringResult = actualHttpClientConfig.toString();
    Integer actualConnectTimeout = actualHttpClientConfig.getConnectTimeout();
    Integer actualMaxConnections = actualHttpClientConfig.getMaxConnections();
    Integer actualMaxConnectionsPerRoute = actualHttpClientConfig.getMaxConnectionsPerRoute();
    Integer actualReadTimeout = actualHttpClientConfig.getReadTimeout();

    // Assert
    assertEquals(HttpClientConfig.DEFAULT_TOTAL_CONNECTIONS, actualMaxConnections.intValue());
    assertEquals(
        HttpClientConfig.DEFAULT_TOTAL_CONNECTIONS_PER_ROUTE,
        actualMaxConnectionsPerRoute.intValue());
    assertEquals(HttpClientConfig.MIN_CONNECT_TIMEOUT, actualConnectTimeout.intValue());
    assertEquals(HttpClientConfig.MIN_READ_TIMEOUT, actualReadTimeout.intValue());
    assertEquals(HttpClientConfigTest.EXPECTED_DEFAULT_INITIAL_VALUES, actualToStringResult);
  }
}
