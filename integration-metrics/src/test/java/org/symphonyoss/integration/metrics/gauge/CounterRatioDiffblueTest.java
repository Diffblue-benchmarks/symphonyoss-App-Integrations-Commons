package org.symphonyoss.integration.metrics.gauge;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.codahale.metrics.Counting;
import com.codahale.metrics.RatioGauge;
import com.codahale.metrics.RatioGauge.Ratio;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;

public class CounterRatioDiffblueTest {
  /**
   * Test {@link CounterRatio#CounterRatio(Counting, Counting)}.
   *
   * <p>Method under test: {@link CounterRatio#CounterRatio(Counting, Counting)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"void CounterRatio.<init>(Counting, Counting)"})
  public void testNewCounterRatio() {
    // Arrange and Act
    CounterRatio actualCounterRatio = new CounterRatio(mock(Counting.class), mock(Counting.class));

    // Assert
    assertEquals(Double.NaN, actualCounterRatio.getRatio().getValue(), 0.0);
    assertEquals(Double.NaN, actualCounterRatio.getValue().doubleValue(), 0.0);
  }

  /**
   * Test {@link CounterRatio#getRatio()}.
   *
   * <p>Method under test: {@link CounterRatio#getRatio()}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"RatioGauge.Ratio CounterRatio.getRatio()"})
  public void testGetRatio() {
    // Arrange
    Counting numeratorMeter = mock(Counting.class);
    when(numeratorMeter.getCount()).thenReturn(3L);

    Counting denominatorMeter = mock(Counting.class);
    when(denominatorMeter.getCount()).thenReturn(3L);

    CounterRatio counterRatio = new CounterRatio(numeratorMeter, denominatorMeter);

    // Act
    Ratio actualRatio = counterRatio.getRatio();

    // Assert
    verify(numeratorMeter).getCount();
    verify(denominatorMeter).getCount();
    assertEquals(1.0d, actualRatio.getValue(), 0.0);
  }
}
