package org.symphonyoss.integration.utils;

import static org.junit.Assert.assertFalse;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class IpAddressUtilsDiffblueTest {
  @Rule public ExpectedException thrown = ExpectedException.none();

  /**
   * Test {@link IpAddressUtils#getIpRange(String)}.
   *
   * <ul>
   *   <li>When {@code /42}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link IpAddressUtils#getIpRange(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set IpAddressUtils.getIpRange(String)"})
  public void testGetIpRange_when42_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    thrown.expect(IllegalArgumentException.class);
    IpAddressUtils.getIpRange("/42");
  }

  /**
   * Test {@link IpAddressUtils#getIpRange(String)}.
   *
   * <ul>
   *   <li>When {@code 999.999.999.999}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link IpAddressUtils#getIpRange(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set IpAddressUtils.getIpRange(String)"})
  public void testGetIpRange_when999999999999_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    thrown.expect(IllegalArgumentException.class);
    IpAddressUtils.getIpRange("999.999.999.999");
  }

  /**
   * Test {@link IpAddressUtils#getIpRange(String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link IpAddressUtils#getIpRange(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set IpAddressUtils.getIpRange(String)"})
  public void testGetIpRange_whenEmptyString_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    thrown.expect(IllegalArgumentException.class);
    IpAddressUtils.getIpRange("");
  }

  /**
   * Test {@link IpAddressUtils#getIpRange(String)}.
   *
   * <ul>
   *   <li>When {@code Input}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link IpAddressUtils#getIpRange(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set IpAddressUtils.getIpRange(String)"})
  public void testGetIpRange_whenInput_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    thrown.expect(IllegalArgumentException.class);
    IpAddressUtils.getIpRange("Input");
  }

  /**
   * Test {@link IpAddressUtils#getIpRange(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link IpAddressUtils#getIpRange(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set IpAddressUtils.getIpRange(String)"})
  public void testGetIpRange_whenNull_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    thrown.expect(IllegalArgumentException.class);
    IpAddressUtils.getIpRange(null);
  }

  /**
   * Test {@link IpAddressUtils#isIpRange(String)}.
   *
   * <ul>
   *   <li>When {@code 999.999.999.999/}.
   * </ul>
   *
   * <p>Method under test: {@link IpAddressUtils#isIpRange(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean IpAddressUtils.isIpRange(String)"})
  public void testIsIpRange_when999999999999() {
    // Arrange, Act and Assert
    assertFalse(IpAddressUtils.isIpRange("999.999.999.999/"));
  }

  /**
   * Test {@link IpAddressUtils#isIpRange(String)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link IpAddressUtils#isIpRange(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean IpAddressUtils.isIpRange(String)"})
  public void testIsIpRange_whenEmptyString() {
    // Arrange, Act and Assert
    assertFalse(IpAddressUtils.isIpRange(""));
  }

  /**
   * Test {@link IpAddressUtils#isIpRange(String)}.
   *
   * <ul>
   *   <li>When {@code Input}.
   * </ul>
   *
   * <p>Method under test: {@link IpAddressUtils#isIpRange(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean IpAddressUtils.isIpRange(String)"})
  public void testIsIpRange_whenInput() {
    // Arrange, Act and Assert
    assertFalse(IpAddressUtils.isIpRange("Input"));
  }

  /**
   * Test {@link IpAddressUtils#isIpRange(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link IpAddressUtils#isIpRange(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean IpAddressUtils.isIpRange(String)"})
  public void testIsIpRange_whenNull() {
    // Arrange, Act and Assert
    assertFalse(IpAddressUtils.isIpRange(null));
  }

  /**
   * Test {@link IpAddressUtils#isIpRange(String)}.
   *
   * <ul>
   *   <li>When {@code /}.
   * </ul>
   *
   * <p>Method under test: {@link IpAddressUtils#isIpRange(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean IpAddressUtils.isIpRange(String)"})
  public void testIsIpRange_whenSlash() {
    // Arrange, Act and Assert
    assertFalse(IpAddressUtils.isIpRange("/"));
  }
}
