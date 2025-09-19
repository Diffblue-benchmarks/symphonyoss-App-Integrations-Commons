package org.symphonyoss.integration.model.stream;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;

public class StreamDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Stream}
   *   <li>{@link Stream#setId(String)}
   *   <li>{@link Stream#getId()}
   * </ul>
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"void Stream.<init>()", "String Stream.getId()", "void Stream.setId(String)"})
  public void testGettersAndSetters() {
    // Arrange and Act
    Stream actualStream = new Stream();
    actualStream.setId("42");

    // Assert
    assertEquals("42", actualStream.getId());
  }
}
