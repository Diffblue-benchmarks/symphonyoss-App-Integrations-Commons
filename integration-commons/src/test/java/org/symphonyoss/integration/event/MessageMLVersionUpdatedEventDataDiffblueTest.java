package org.symphonyoss.integration.event;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.symphonyoss.integration.model.message.MessageMLVersion;

public class MessageMLVersionUpdatedEventDataDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link MessageMLVersionUpdatedEventData#MessageMLVersionUpdatedEventData(MessageMLVersion)}
   *   <li>{@link MessageMLVersionUpdatedEventData#getVersion()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals(MessageMLVersion.V1, (new MessageMLVersionUpdatedEventData(MessageMLVersion.V1)).getVersion());
  }
}
