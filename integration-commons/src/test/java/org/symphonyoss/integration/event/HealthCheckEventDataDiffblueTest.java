package org.symphonyoss.integration.event;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class HealthCheckEventDataDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link HealthCheckEventData#HealthCheckEventData(String)}
   *   <li>{@link HealthCheckEventData#getServiceName()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("Service Name", (new HealthCheckEventData("Service Name")).getServiceName());
  }
}
