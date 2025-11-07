package org.symphonyoss.integration.entity;

import static org.junit.Assert.assertNull;
import org.junit.Test;

public class MessageMLDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link MessageML}
   *   <li>{@link MessageML#getEntity()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertNull((new MessageML()).getEntity());
  }
}
