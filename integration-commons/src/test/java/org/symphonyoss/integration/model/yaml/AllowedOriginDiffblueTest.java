package org.symphonyoss.integration.model.yaml;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;

public class AllowedOriginDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link AllowedOrigin}
   *   <li>{@link AllowedOrigin#setAddress(String)}
   *   <li>{@link AllowedOrigin#setHost(String)}
   *   <li>{@link AllowedOrigin#getAddress()}
   *   <li>{@link AllowedOrigin#getHost()}
   * </ul>
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AllowedOrigin.<init>()",
    "String AllowedOrigin.getAddress()",
    "String AllowedOrigin.getHost()",
    "void AllowedOrigin.setAddress(String)",
    "void AllowedOrigin.setHost(String)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    AllowedOrigin actualAllowedOrigin = new AllowedOrigin();
    actualAllowedOrigin.setAddress("42 Main St");
    actualAllowedOrigin.setHost("localhost");
    String actualAddress = actualAllowedOrigin.getAddress();

    // Assert
    assertEquals("42 Main St", actualAddress);
    assertEquals("localhost", actualAllowedOrigin.getHost());
  }
}
