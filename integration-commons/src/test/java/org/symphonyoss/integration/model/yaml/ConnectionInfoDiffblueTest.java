package org.symphonyoss.integration.model.yaml;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ConnectionInfoDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ConnectionInfo#setHost(String)}
   *   <li>{@link ConnectionInfo#setMinVersion(String)}
   *   <li>{@link ConnectionInfo#setPort(String)}
   *   <li>{@link ConnectionInfo#setProxy(ProxyConnectionInfo)}
   *   <li>{@link ConnectionInfo#toString()}
   *   <li>{@link ConnectionInfo#getHost()}
   *   <li>{@link ConnectionInfo#getMinVersion()}
   *   <li>{@link ConnectionInfo#getPort()}
   *   <li>{@link ConnectionInfo#getProxy()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ConnectionInfo.getHost()", "String ConnectionInfo.getMinVersion()",
      "String ConnectionInfo.getPort()", "ProxyConnectionInfo ConnectionInfo.getProxy()",
      "void ConnectionInfo.setHost(String)", "void ConnectionInfo.setMinVersion(String)",
      "void ConnectionInfo.setPort(String)", "void ConnectionInfo.setProxy(ProxyConnectionInfo)",
      "String ConnectionInfo.toString()"})
  public void testGettersAndSetters() {
    // Arrange
    ConnectionInfo connectionInfo = new ConnectionInfo();

    // Act
    connectionInfo.setHost("localhost");
    connectionInfo.setMinVersion("1.0.2");
    connectionInfo.setPort("Port");
    ProxyConnectionInfo proxy = new ProxyConnectionInfo();
    proxy.setPassword("iloveyou");
    proxy.setURI("Uri");
    proxy.setUser("User");
    connectionInfo.setProxy(proxy);
    String actualToStringResult = connectionInfo.toString();
    String actualHost = connectionInfo.getHost();
    String actualMinVersion = connectionInfo.getMinVersion();
    String actualPort = connectionInfo.getPort();

    // Assert
    assertEquals("1.0.2", actualMinVersion);
    assertEquals("ConnectionInfo{host='localhost', port='Port', proxy='ProxyConnectionInfo{uri='Uri', user=User',"
        + " password=iloveyou'}}", actualToStringResult);
    assertEquals("Port", actualPort);
    assertEquals("localhost", actualHost);
    assertSame(proxy, connectionInfo.getProxy());
  }

  /**
   * Test new {@link ConnectionInfo} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link ConnectionInfo}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConnectionInfo.<init>()"})
  public void testNewConnectionInfo() {
    // Arrange and Act
    ConnectionInfo actualConnectionInfo = new ConnectionInfo();

    // Assert
    assertNull(actualConnectionInfo.getHost());
    assertNull(actualConnectionInfo.getMinVersion());
    assertNull(actualConnectionInfo.getPort());
    ProxyConnectionInfo proxy = actualConnectionInfo.getProxy();
    assertNull(proxy.getPassword());
    assertNull(proxy.getURI());
    assertNull(proxy.getUser());
  }
}
