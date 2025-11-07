package org.symphonyoss.integration;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class IntegrationStatusDiffblueTest {
  /**
   * Method under test: {@link IntegrationStatus#toString()}
   */
  @Test
  public void testToString() {
    // Arrange, Act and Assert
    assertEquals("Inactive", IntegrationStatus.valueOf("INACTIVE").toString());
  }
}
