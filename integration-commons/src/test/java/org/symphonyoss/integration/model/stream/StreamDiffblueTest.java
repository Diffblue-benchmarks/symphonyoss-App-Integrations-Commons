package org.symphonyoss.integration.model.stream;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class StreamDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Stream}
   *   <li>{@link Stream#setId(String)}
   *   <li>{@link Stream#getId()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    Stream actualStream = new Stream();
    actualStream.setId("42");

    // Assert that nothing has changed
    assertEquals("42", actualStream.getId());
  }
}
