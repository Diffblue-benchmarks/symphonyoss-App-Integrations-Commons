package org.symphonyoss.integration.model.yaml;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ProxyConnectionInfoDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link ProxyConnectionInfo}
   *   <li>{@link ProxyConnectionInfo#setPassword(String)}
   *   <li>{@link ProxyConnectionInfo#setURI(String)}
   *   <li>{@link ProxyConnectionInfo#setUser(String)}
   *   <li>{@link ProxyConnectionInfo#toString()}
   *   <li>{@link ProxyConnectionInfo#getPassword()}
   *   <li>{@link ProxyConnectionInfo#getURI()}
   *   <li>{@link ProxyConnectionInfo#getUser()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    ProxyConnectionInfo actualProxyConnectionInfo = new ProxyConnectionInfo();
    actualProxyConnectionInfo.setPassword("iloveyou");
    actualProxyConnectionInfo.setURI("Uri");
    actualProxyConnectionInfo.setUser("User");
    String actualToStringResult = actualProxyConnectionInfo.toString();
    String actualPassword = actualProxyConnectionInfo.getPassword();
    String actualURI = actualProxyConnectionInfo.getURI();

    // Assert that nothing has changed
    assertEquals("ProxyConnectionInfo{uri='Uri', user=User', password=iloveyou'}", actualToStringResult);
    assertEquals("Uri", actualURI);
    assertEquals("User", actualProxyConnectionInfo.getUser());
    assertEquals("iloveyou", actualPassword);
  }
}
