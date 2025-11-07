package org.symphonyoss.integration.model.healthcheck;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class IntegrationFlagsDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link IntegrationFlags}
   *   <li>
   * {@link IntegrationFlags#setAppCertificateInstalled(IntegrationFlags.ValueEnum)}
   *   <li>{@link IntegrationFlags#setParserInstalled(IntegrationFlags.ValueEnum)}
   *   <li>{@link IntegrationFlags#setUserAuthenticated(IntegrationFlags.ValueEnum)}
   *   <li>
   * {@link IntegrationFlags#setUserCertificateInstalled(IntegrationFlags.ValueEnum)}
   *   <li>{@link IntegrationFlags#getAppCertificateInstalled()}
   *   <li>{@link IntegrationFlags#getParserInstalled()}
   *   <li>{@link IntegrationFlags#getUserAuthenticated()}
   *   <li>{@link IntegrationFlags#getUserCertificateInstalled()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    IntegrationFlags actualIntegrationFlags = new IntegrationFlags();
    actualIntegrationFlags.setAppCertificateInstalled(IntegrationFlags.ValueEnum.OK);
    actualIntegrationFlags.setParserInstalled(IntegrationFlags.ValueEnum.OK);
    actualIntegrationFlags.setUserAuthenticated(IntegrationFlags.ValueEnum.OK);
    actualIntegrationFlags.setUserCertificateInstalled(IntegrationFlags.ValueEnum.OK);
    IntegrationFlags.ValueEnum actualAppCertificateInstalled = actualIntegrationFlags.getAppCertificateInstalled();
    IntegrationFlags.ValueEnum actualParserInstalled = actualIntegrationFlags.getParserInstalled();
    IntegrationFlags.ValueEnum actualUserAuthenticated = actualIntegrationFlags.getUserAuthenticated();

    // Assert that nothing has changed
    assertEquals(IntegrationFlags.ValueEnum.OK, actualAppCertificateInstalled);
    assertEquals(IntegrationFlags.ValueEnum.OK, actualParserInstalled);
    assertEquals(IntegrationFlags.ValueEnum.OK, actualUserAuthenticated);
    assertEquals(IntegrationFlags.ValueEnum.OK, actualIntegrationFlags.getUserCertificateInstalled());
  }

  /**
   * Method under test: {@link IntegrationFlags#isUp()}
   */
  @Test
  public void testIsUp() {
    // Arrange, Act and Assert
    assertFalse((new IntegrationFlags()).isUp());
  }

  /**
   * Method under test: {@link IntegrationFlags#isUp()}
   */
  @Test
  public void testIsUp2() {
    // Arrange
    IntegrationFlags integrationFlags = new IntegrationFlags();
    integrationFlags.setParserInstalled(IntegrationFlags.ValueEnum.OK);
    integrationFlags.setUserCertificateInstalled(IntegrationFlags.ValueEnum.OK);
    integrationFlags.setUserAuthenticated(IntegrationFlags.ValueEnum.OK);
    integrationFlags.setAppCertificateInstalled(IntegrationFlags.ValueEnum.OK);

    // Act and Assert
    assertTrue(integrationFlags.isUp());
  }

  /**
   * Method under test: {@link IntegrationFlags#isUp()}
   */
  @Test
  public void testIsUp3() {
    // Arrange
    IntegrationFlags integrationFlags = new IntegrationFlags();
    integrationFlags.setParserInstalled(IntegrationFlags.ValueEnum.OK);
    integrationFlags.setUserCertificateInstalled(IntegrationFlags.ValueEnum.OK);
    integrationFlags.setUserAuthenticated(IntegrationFlags.ValueEnum.OK);
    integrationFlags.setAppCertificateInstalled(IntegrationFlags.ValueEnum.NOT_APPLICABLE);

    // Act and Assert
    assertTrue(integrationFlags.isUp());
  }

  /**
   * Method under test: {@link IntegrationFlags#isUp()}
   */
  @Test
  public void testIsUp4() {
    // Arrange
    IntegrationFlags integrationFlags = new IntegrationFlags();
    integrationFlags.setParserInstalled(IntegrationFlags.ValueEnum.OK);

    // Act and Assert
    assertFalse(integrationFlags.isUp());
  }

  /**
   * Method under test: {@link IntegrationFlags#isUp()}
   */
  @Test
  public void testIsUp5() {
    // Arrange
    IntegrationFlags integrationFlags = new IntegrationFlags();
    integrationFlags.setParserInstalled(IntegrationFlags.ValueEnum.OK);
    integrationFlags.setUserCertificateInstalled(IntegrationFlags.ValueEnum.OK);
    integrationFlags.setUserAuthenticated(IntegrationFlags.ValueEnum.NOK);
    integrationFlags.setAppCertificateInstalled(IntegrationFlags.ValueEnum.OK);

    // Act and Assert
    assertFalse(integrationFlags.isUp());
  }

  /**
   * Method under test: {@link IntegrationFlags#isUp()}
   */
  @Test
  public void testIsUp6() {
    // Arrange
    IntegrationFlags integrationFlags = new IntegrationFlags();
    integrationFlags.setParserInstalled(IntegrationFlags.ValueEnum.OK);
    integrationFlags.setUserCertificateInstalled(IntegrationFlags.ValueEnum.OK);
    integrationFlags.setUserAuthenticated(IntegrationFlags.ValueEnum.OK);
    integrationFlags.setAppCertificateInstalled(IntegrationFlags.ValueEnum.NOK);

    // Act and Assert
    assertFalse(integrationFlags.isUp());
  }
}
