package org.symphonyoss.integration.event;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.symphonyoss.integration.model.message.MessageMLVersion;

public class MessageMLVersionUpdatedEventDataDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MessageMLVersionUpdatedEventData#MessageMLVersionUpdatedEventData(MessageMLVersion)}
   *   <li>{@link MessageMLVersionUpdatedEventData#getVersion()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MessageMLVersionUpdatedEventData.<init>(MessageMLVersion)",
      "MessageMLVersion MessageMLVersionUpdatedEventData.getVersion()"})
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals(MessageMLVersion.V1, (new MessageMLVersionUpdatedEventData(MessageMLVersion.V1)).getVersion());
  }
}
