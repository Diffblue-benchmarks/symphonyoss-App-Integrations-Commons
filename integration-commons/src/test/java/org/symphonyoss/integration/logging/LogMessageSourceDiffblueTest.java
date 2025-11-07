package org.symphonyoss.integration.logging;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {LogMessageSource.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class LogMessageSourceDiffblueTest {
  @Autowired
  private LogMessageSource logMessageSource;

  /**
   * Test {@link LogMessageSource#getMessage(String, String[])}.
   * <p>
   * Method under test: {@link LogMessageSource#getMessage(String, String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String LogMessageSource.getMessage(String, String[])"})
  public void testGetMessage() {
    // Arrange, Act and Assert
    assertEquals("Unable to record log information. Log message not found for resource id 42.",
        logMessageSource.getMessage("42", "Args"));
  }
}
