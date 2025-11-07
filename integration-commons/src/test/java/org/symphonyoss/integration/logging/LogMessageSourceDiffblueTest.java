package org.symphonyoss.integration.logging;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.io.ResourceLoader;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {LogMessageSource.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class LogMessageSourceDiffblueTest {
  @Autowired
  private LogMessageSource logMessageSource;

  @MockBean
  private ResourceLoader resourceLoader;

  /**
   * Method under test: {@link LogMessageSource#getMessage(String, String[])}
   */
  @Test
  public void testGetMessage() {
    // Arrange, Act and Assert
    assertEquals("Unable to record log information. Log message not found for resource id 42.",
        logMessageSource.getMessage("42", "Args"));
  }
}
