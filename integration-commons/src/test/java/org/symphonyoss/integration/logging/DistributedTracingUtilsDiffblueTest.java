package org.symphonyoss.integration.logging;

import static org.junit.Assert.assertNull;
import org.junit.Test;

public class DistributedTracingUtilsDiffblueTest {
  /**
   * Method under test: {@link DistributedTracingUtils#getMDC()}
   */
  @Test
  public void testGetMDC() {
    // Arrange, Act and Assert
    assertNull(DistributedTracingUtils.getMDC());
  }
}
