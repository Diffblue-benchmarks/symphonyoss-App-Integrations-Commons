package org.symphonyoss.integration;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class IntegrationStatusDiffblueTest {
  /**
   * Test {@link IntegrationStatus#toString()}.
   * <p>
   * Method under test: {@link IntegrationStatus#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String IntegrationStatus.toString()"})
  public void testToString() {
    // Arrange, Act and Assert
    assertEquals("Inactive", IntegrationStatus.valueOf("INACTIVE").toString());
  }
}
