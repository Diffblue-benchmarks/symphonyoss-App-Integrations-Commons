package org.symphonyoss.integration.logging;

import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class DistributedTracingUtilsDiffblueTest {
  /**
   * Test {@link DistributedTracingUtils#getMDC()}.
   * <p>
   * Method under test: {@link DistributedTracingUtils#getMDC()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String DistributedTracingUtils.getMDC()"})
  public void testGetMDC() {
    // Arrange, Act and Assert
    assertNull(DistributedTracingUtils.getMDC());
  }
}
