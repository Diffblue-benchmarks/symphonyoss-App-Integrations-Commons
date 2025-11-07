package org.symphonyoss.integration.model.yaml;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class AllowedOriginDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link AllowedOrigin}
   *   <li>{@link AllowedOrigin#setAddress(String)}
   *   <li>{@link AllowedOrigin#setHost(String)}
   *   <li>{@link AllowedOrigin#getAddress()}
   *   <li>{@link AllowedOrigin#getHost()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    AllowedOrigin actualAllowedOrigin = new AllowedOrigin();
    actualAllowedOrigin.setAddress("42 Main St");
    actualAllowedOrigin.setHost("localhost");
    String actualAddress = actualAllowedOrigin.getAddress();

    // Assert that nothing has changed
    assertEquals("42 Main St", actualAddress);
    assertEquals("localhost", actualAllowedOrigin.getHost());
  }
}
