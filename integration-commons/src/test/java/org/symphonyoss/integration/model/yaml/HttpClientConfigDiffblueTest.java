package org.symphonyoss.integration.model.yaml;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class HttpClientConfigDiffblueTest {
  /**
   * Methods under test:
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
    assertEquals(HttpClientConfig.DEFAULT_TOTAL_CONNECTIONS_PER_ROUTE, actualMaxConnectionsPerRoute.intValue());
    assertEquals(HttpClientConfig.MIN_CONNECT_TIMEOUT, actualConnectTimeout.intValue());
    assertEquals(HttpClientConfig.MIN_READ_TIMEOUT, actualReadTimeout.intValue());
    assertEquals(HttpClientConfigTest.EXPECTED_DEFAULT_INITIAL_VALUES, actualToStringResult);
  }

  /**
   * Method under test: {@link HttpClientConfig#setConnectTimeout(Integer)}
   */
  @Test
  public void testSetConnectTimeout() {
    // Arrange
    HttpClientConfig httpClientConfig = new HttpClientConfig();

    // Act
    httpClientConfig.setConnectTimeout(10);

    // Assert
    assertEquals(HttpClientConfig.MIN_CONNECT_TIMEOUT, httpClientConfig.getConnectTimeout().intValue());
  }

  /**
   * Method under test: {@link HttpClientConfig#setConnectTimeout(Integer)}
   */
  @Test
  public void testSetConnectTimeout2() {
    // Arrange
    HttpClientConfig httpClientConfig = new HttpClientConfig();

    // Act
    httpClientConfig.setConnectTimeout(HttpClientConfig.MIN_CONNECT_TIMEOUT);

    // Assert
    assertEquals(HttpClientConfig.MIN_CONNECT_TIMEOUT, httpClientConfig.getConnectTimeout().intValue());
  }

  /**
   * Method under test: {@link HttpClientConfig#setConnectTimeout(Integer)}
   */
  @Test
  public void testSetConnectTimeout3() {
    // Arrange
    HttpClientConfig httpClientConfig = new HttpClientConfig();

    // Act
    httpClientConfig.setConnectTimeout(null);

    // Assert
    assertEquals(HttpClientConfig.MIN_CONNECT_TIMEOUT, httpClientConfig.getConnectTimeout().intValue());
  }

  /**
   * Method under test: {@link HttpClientConfig#setConnectTimeout(Integer)}
   */
  @Test
  public void testSetConnectTimeout4() {
    // Arrange
    HttpClientConfig httpClientConfig = new HttpClientConfig();

    // Act
    httpClientConfig.setConnectTimeout(20001);

    // Assert
    assertEquals(HttpClientConfig.MAX_CONNECT_TIMEOUT, httpClientConfig.getConnectTimeout().intValue());
  }

  /**
   * Method under test: {@link HttpClientConfig#setReadTimeout(Integer)}
   */
  @Test
  public void testSetReadTimeout() {
    // Arrange
    HttpClientConfig httpClientConfig = new HttpClientConfig();

    // Act
    httpClientConfig.setReadTimeout(10);

    // Assert
    assertEquals(HttpClientConfig.MIN_READ_TIMEOUT, httpClientConfig.getReadTimeout().intValue());
  }

  /**
   * Method under test: {@link HttpClientConfig#setReadTimeout(Integer)}
   */
  @Test
  public void testSetReadTimeout2() {
    // Arrange
    HttpClientConfig httpClientConfig = new HttpClientConfig();
    httpClientConfig.setConnectTimeout(10);
    httpClientConfig.setMaxConnections(3);
    httpClientConfig.setMaxConnectionsPerRoute(3);
    httpClientConfig.setReadTimeout(10);

    // Act
    httpClientConfig.setReadTimeout(null);

    // Assert
    assertEquals(HttpClientConfig.MIN_READ_TIMEOUT, httpClientConfig.getReadTimeout().intValue());
  }

  /**
   * Method under test: {@link HttpClientConfig#setReadTimeout(Integer)}
   */
  @Test
  public void testSetReadTimeout3() {
    // Arrange
    HttpClientConfig httpClientConfig = new HttpClientConfig();
    httpClientConfig.setConnectTimeout(10);
    httpClientConfig.setMaxConnections(3);
    httpClientConfig.setMaxConnectionsPerRoute(3);
    httpClientConfig.setReadTimeout(10);

    // Act
    httpClientConfig.setReadTimeout(HttpClientConfig.MIN_READ_TIMEOUT);

    // Assert
    assertEquals(HttpClientConfig.MIN_READ_TIMEOUT, httpClientConfig.getReadTimeout().intValue());
  }

  /**
   * Method under test: {@link HttpClientConfig#setReadTimeout(Integer)}
   */
  @Test
  public void testSetReadTimeout4() {
    // Arrange
    HttpClientConfig httpClientConfig = new HttpClientConfig();
    httpClientConfig.setConnectTimeout(10);
    httpClientConfig.setMaxConnections(3);
    httpClientConfig.setMaxConnectionsPerRoute(3);
    httpClientConfig.setReadTimeout(10);

    // Act
    httpClientConfig.setReadTimeout(HttpClientConfig.MAX_READ_TIMEOUT);

    // Assert
    assertEquals(HttpClientConfig.MIN_CONNECT_TIMEOUT, httpClientConfig.getReadTimeout().intValue());
  }

  /**
   * Method under test: {@link HttpClientConfig#setMaxConnections(Integer)}
   */
  @Test
  public void testSetMaxConnections() {
    // Arrange
    HttpClientConfig httpClientConfig = new HttpClientConfig();

    // Act
    httpClientConfig.setMaxConnections(3);

    // Assert
    assertEquals(3, httpClientConfig.getMaxConnections().intValue());
  }

  /**
   * Method under test: {@link HttpClientConfig#setMaxConnections(Integer)}
   */
  @Test
  public void testSetMaxConnections2() {
    // Arrange
    HttpClientConfig httpClientConfig = new HttpClientConfig();
    httpClientConfig.setConnectTimeout(10);
    httpClientConfig.setMaxConnections(3);
    httpClientConfig.setMaxConnectionsPerRoute(3);
    httpClientConfig.setReadTimeout(10);

    // Act
    httpClientConfig.setMaxConnections(null);

    // Assert
    assertEquals(HttpClientConfig.DEFAULT_TOTAL_CONNECTIONS, httpClientConfig.getMaxConnections().intValue());
  }

  /**
   * Method under test: {@link HttpClientConfig#setMaxConnections(Integer)}
   */
  @Test
  public void testSetMaxConnections3() {
    // Arrange
    HttpClientConfig httpClientConfig = new HttpClientConfig();
    httpClientConfig.setConnectTimeout(10);
    httpClientConfig.setMaxConnections(3);
    httpClientConfig.setMaxConnectionsPerRoute(3);
    httpClientConfig.setReadTimeout(10);

    // Act
    httpClientConfig.setMaxConnections(0);

    // Assert
    assertEquals(HttpClientConfig.DEFAULT_TOTAL_CONNECTIONS, httpClientConfig.getMaxConnections().intValue());
  }

  /**
   * Method under test: {@link HttpClientConfig#setMaxConnections(Integer)}
   */
  @Test
  public void testSetMaxConnections4() {
    // Arrange
    HttpClientConfig httpClientConfig = new HttpClientConfig();
    httpClientConfig.setConnectTimeout(10);
    httpClientConfig.setMaxConnections(3);
    httpClientConfig.setMaxConnectionsPerRoute(3);
    httpClientConfig.setReadTimeout(10);

    // Act
    httpClientConfig.setMaxConnections(401);

    // Assert
    assertEquals(HttpClientConfig.MAX_TOTAL_CONNECTIONS, httpClientConfig.getMaxConnections().intValue());
  }

  /**
   * Method under test:
   * {@link HttpClientConfig#setMaxConnectionsPerRoute(Integer)}
   */
  @Test
  public void testSetMaxConnectionsPerRoute() {
    // Arrange
    HttpClientConfig httpClientConfig = new HttpClientConfig();

    // Act
    httpClientConfig.setMaxConnectionsPerRoute(3);

    // Assert
    assertEquals(3, httpClientConfig.getMaxConnectionsPerRoute().intValue());
  }

  /**
   * Method under test:
   * {@link HttpClientConfig#setMaxConnectionsPerRoute(Integer)}
   */
  @Test
  public void testSetMaxConnectionsPerRoute2() {
    // Arrange
    HttpClientConfig httpClientConfig = new HttpClientConfig();
    httpClientConfig.setConnectTimeout(10);
    httpClientConfig.setMaxConnections(3);
    httpClientConfig.setMaxConnectionsPerRoute(3);
    httpClientConfig.setReadTimeout(10);

    // Act
    httpClientConfig.setMaxConnectionsPerRoute(null);

    // Assert
    assertEquals(HttpClientConfig.DEFAULT_TOTAL_CONNECTIONS_PER_ROUTE,
        httpClientConfig.getMaxConnectionsPerRoute().intValue());
  }

  /**
   * Method under test:
   * {@link HttpClientConfig#setMaxConnectionsPerRoute(Integer)}
   */
  @Test
  public void testSetMaxConnectionsPerRoute3() {
    // Arrange
    HttpClientConfig httpClientConfig = new HttpClientConfig();
    httpClientConfig.setConnectTimeout(10);
    httpClientConfig.setMaxConnections(3);
    httpClientConfig.setMaxConnectionsPerRoute(3);
    httpClientConfig.setReadTimeout(10);

    // Act
    httpClientConfig.setMaxConnectionsPerRoute(0);

    // Assert
    assertEquals(HttpClientConfig.DEFAULT_TOTAL_CONNECTIONS_PER_ROUTE,
        httpClientConfig.getMaxConnectionsPerRoute().intValue());
  }

  /**
   * Method under test:
   * {@link HttpClientConfig#setMaxConnectionsPerRoute(Integer)}
   */
  @Test
  public void testSetMaxConnectionsPerRoute4() {
    // Arrange
    HttpClientConfig httpClientConfig = new HttpClientConfig();
    httpClientConfig.setConnectTimeout(10);
    httpClientConfig.setMaxConnections(3);
    httpClientConfig.setMaxConnectionsPerRoute(3);
    httpClientConfig.setReadTimeout(10);

    // Act
    httpClientConfig.setMaxConnectionsPerRoute(201);

    // Assert
    assertEquals(HttpClientConfig.MAX_TOTAL_CONNECTIONS_PER_ROUTE,
        httpClientConfig.getMaxConnectionsPerRoute().intValue());
  }
}
