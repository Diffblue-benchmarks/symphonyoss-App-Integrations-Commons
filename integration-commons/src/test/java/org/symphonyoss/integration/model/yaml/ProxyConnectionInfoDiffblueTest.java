package org.symphonyoss.integration.model.yaml;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;

public class ProxyConnectionInfoDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ProxyConnectionInfo.<init>()",
    "String ProxyConnectionInfo.getPassword()",
    "String ProxyConnectionInfo.getURI()",
    "String ProxyConnectionInfo.getUser()",
    "void ProxyConnectionInfo.setPassword(String)",
    "void ProxyConnectionInfo.setURI(String)",
    "void ProxyConnectionInfo.setUser(String)",
    "String ProxyConnectionInfo.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    ProxyConnectionInfo actualProxyConnectionInfo = new ProxyConnectionInfo();
    actualProxyConnectionInfo.setPassword("iloveyou");
    actualProxyConnectionInfo.setURI("Uri");
    actualProxyConnectionInfo.setUser("User");
    String actualToStringResult = actualProxyConnectionInfo.toString();
    String actualPassword = actualProxyConnectionInfo.getPassword();
    String actualURI = actualProxyConnectionInfo.getURI();

    // Assert
    assertEquals(
        "ProxyConnectionInfo{uri='Uri', user=User', password=iloveyou'}", actualToStringResult);
    assertEquals("Uri", actualURI);
    assertEquals("User", actualProxyConnectionInfo.getUser());
    assertEquals("iloveyou", actualPassword);
  }
}
