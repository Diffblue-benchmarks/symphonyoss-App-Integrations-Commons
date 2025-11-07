package org.symphonyoss.integration.utils;

import static org.junit.Assert.assertFalse;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class IpAddressUtilsDiffblueTest {
  @Rule
  public ExpectedException thrown = ExpectedException.none();

  /**
   * Method under test: {@link IpAddressUtils#getIpRange(String)}
   */
  @Test
  public void testGetIpRange() {
    // Arrange, Act and Assert
    thrown.expect(IllegalArgumentException.class);
    IpAddressUtils.getIpRange("Input");
  }

  /**
   * Method under test: {@link IpAddressUtils#getIpRange(String)}
   */
  @Test
  public void testGetIpRange2() {
    // Arrange, Act and Assert
    thrown.expect(IllegalArgumentException.class);
    IpAddressUtils.getIpRange(null);
  }

  /**
   * Method under test: {@link IpAddressUtils#getIpRange(String)}
   */
  @Test
  public void testGetIpRange3() {
    // Arrange, Act and Assert
    thrown.expect(IllegalArgumentException.class);
    IpAddressUtils.getIpRange("999.999.999.999");
  }

  /**
   * Method under test: {@link IpAddressUtils#getIpRange(String)}
   */
  @Test
  public void testGetIpRange4() {
    // Arrange, Act and Assert
    thrown.expect(IllegalArgumentException.class);
    IpAddressUtils.getIpRange("");
  }

  /**
   * Method under test: {@link IpAddressUtils#getIpRange(String)}
   */
  @Test
  public void testGetIpRange5() {
    // Arrange, Act and Assert
    thrown.expect(IllegalArgumentException.class);
    IpAddressUtils.getIpRange("/42");
  }

  /**
   * Method under test: {@link IpAddressUtils#isIpRange(String)}
   */
  @Test
  public void testIsIpRange() {
    // Arrange, Act and Assert
    assertFalse(IpAddressUtils.isIpRange("Input"));
    assertFalse(IpAddressUtils.isIpRange(null));
    assertFalse(IpAddressUtils.isIpRange("/"));
    assertFalse(IpAddressUtils.isIpRange(""));
  }
}
