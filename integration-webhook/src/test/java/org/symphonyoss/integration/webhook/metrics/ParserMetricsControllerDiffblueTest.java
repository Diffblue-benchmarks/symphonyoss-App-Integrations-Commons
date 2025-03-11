package org.symphonyoss.integration.webhook.metrics;

import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.Timer;
import com.codahale.metrics.Timer.Context;
import com.diffblue.cover.annotations.MethodsUnderTest;
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
   * Test {@link ParserMetricsController#startParserExecution(String)}.
   * <ul>
   *   <li>When {@code Integration}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ParserMetricsController#startParserExecution(String)}
   */
  @Test
  @MethodsUnderTest({"Context ParserMetricsController.startParserExecution(String)"})
  public void testStartParserExecution_whenIntegration_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(parserMetricsController.startParserExecution("Integration"));
  }

  /**
   * Test {@link ParserMetricsController#finishParserExecution(Context, String, boolean)}.
   * <ul>
   *   <li>When {@code false}.</li>
   *   <li>Then calls {@link Context#close()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ParserMetricsController#finishParserExecution(Context, String, boolean)}
   */
  @Test
  @MethodsUnderTest({"void ParserMetricsController.finishParserExecution(Context, String, boolean)"})
  public void testFinishParserExecution_whenFalse_thenCallsClose() {
    // Arrange
    Context context = mock(Context.class);
    doNothing().when(context).close();

    // Act
    parserMetricsController.finishParserExecution(context, "Integration", false);

    // Assert
    verify(context).close();
  }

  /**
   * Test {@link ParserMetricsController#finishParserExecution(Context, String, boolean)}.
   * <ul>
   *   <li>When {@code Integration}.</li>
   *   <li>Then calls {@link Context#close()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ParserMetricsController#finishParserExecution(Context, String, boolean)}
   */
  @Test
  @MethodsUnderTest({"void ParserMetricsController.finishParserExecution(Context, String, boolean)"})
  public void testFinishParserExecution_whenIntegration_thenCallsClose() {
    // Arrange
    Context context = mock(Context.class);
    doNothing().when(context).close();

    // Act
    parserMetricsController.finishParserExecution(context, "Integration", true);

    // Assert
    verify(context).close();
  }
}
