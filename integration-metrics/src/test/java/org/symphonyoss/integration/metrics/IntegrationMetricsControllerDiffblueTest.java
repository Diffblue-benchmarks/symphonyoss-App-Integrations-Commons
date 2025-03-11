package org.symphonyoss.integration.metrics;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class IntegrationMetricsControllerDiffblueTest {
  @InjectMocks
  private IntegrationMetricsController integrationMetricsController;

  @Mock
  private List<IntegrationController> list;

  /**
   * Test {@link IntegrationMetricsController#addIntegrationTimer(String)}.
   * <p>
   * Method under test: {@link IntegrationMetricsController#addIntegrationTimer(String)}
   */
  @Test
  @MethodsUnderTest({"void IntegrationMetricsController.addIntegrationTimer(String)"})
  public void testAddIntegrationTimer() {
    // Arrange
    ArrayList<IntegrationController> integrationControllerList = new ArrayList<>();
    when(list.iterator()).thenReturn(integrationControllerList.iterator());

    // Act
    integrationMetricsController.addIntegrationTimer("Integration");

    // Assert
    verify(list).iterator();
  }

  /**
   * Test {@link IntegrationMetricsController#addIntegrationTimer(String)}.
   * <ul>
   *   <li>Then calls {@link IntegrationController#initController(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IntegrationMetricsController#addIntegrationTimer(String)}
   */
  @Test
  @MethodsUnderTest({"void IntegrationMetricsController.addIntegrationTimer(String)"})
  public void testAddIntegrationTimer_thenCallsInitController() {
    // Arrange
    IntegrationController integrationController = mock(IntegrationController.class);
    doNothing().when(integrationController).initController(Mockito.<String>any());

    ArrayList<IntegrationController> integrationControllerList = new ArrayList<>();
    integrationControllerList.add(integrationController);
    when(list.iterator()).thenReturn(integrationControllerList.iterator());

    // Act
    integrationMetricsController.addIntegrationTimer("Integration");

    // Assert
    verify(list).iterator();
    verify(integrationController).initController(Mockito.<String>any());
  }
}
