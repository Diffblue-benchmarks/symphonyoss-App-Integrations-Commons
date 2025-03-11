package org.symphonyoss.integration.event;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;

public class HealthCheckEventDataDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link HealthCheckEventData#HealthCheckEventData(String)}
   *   <li>{@link HealthCheckEventData#getServiceName()}
   * </ul>
   */
  @Test
  @MethodsUnderTest({"void HealthCheckEventData.<init>(String)", "String HealthCheckEventData.getServiceName()"})
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("Service Name", (new HealthCheckEventData("Service Name")).getServiceName());
  }
}
