package org.symphonyoss.integration.logging;

import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;

public class DistributedTracingUtilsDiffblueTest {
  /**
   * Test {@link DistributedTracingUtils#getMDC()}.
   *
   * <p>Method under test: {@link DistributedTracingUtils#getMDC()}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String DistributedTracingUtils.getMDC()"})
  public void testGetMDC() {
    // Arrange, Act and Assert
    assertNull(DistributedTracingUtils.getMDC());
  }
}
