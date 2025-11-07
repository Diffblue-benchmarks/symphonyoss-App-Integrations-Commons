package org.symphonyoss.integration.webhook.metrics;

import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.Timer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {ParserMetricsController.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class ParserMetricsControllerDiffblueTest {
  @MockBean
  private MetricRegistry metricRegistry;

  @Autowired
  private ParserMetricsController parserMetricsController;

  /**
   * Method under test:
   * {@link ParserMetricsController#startParserExecution(String)}
   */
  @Test
  public void testStartParserExecution() {
    // Arrange, Act and Assert
    assertNull(parserMetricsController.startParserExecution("Integration"));
  }

  /**
   * Method under test:
   * {@link ParserMetricsController#finishParserExecution(Timer.Context, String, boolean)}
   */
  @Test
  public void testFinishParserExecution() {
    // Arrange
    Timer.Context context = mock(Timer.Context.class);
    doNothing().when(context).close();

    // Act
    parserMetricsController.finishParserExecution(context, "Integration", true);

    // Assert
    verify(context).close();
  }

  /**
   * Method under test:
   * {@link ParserMetricsController#finishParserExecution(Timer.Context, String, boolean)}
   */
  @Test
  public void testFinishParserExecution2() {
    // Arrange
    Timer.Context context = mock(Timer.Context.class);
    doNothing().when(context).close();

    // Act
    parserMetricsController.finishParserExecution(context, "Integration", false);

    // Assert
    verify(context).close();
  }
}
