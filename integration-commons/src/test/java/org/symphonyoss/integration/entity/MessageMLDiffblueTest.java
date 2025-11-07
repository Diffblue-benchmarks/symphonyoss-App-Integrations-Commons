package org.symphonyoss.integration.entity;

import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class MessageMLDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link MessageML}
   *   <li>{@link MessageML#getEntity()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MessageML.<init>()", "org.symphonyoss.integration.entity.Entity MessageML.getEntity()"})
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertNull((new MessageML()).getEntity());
  }
}
