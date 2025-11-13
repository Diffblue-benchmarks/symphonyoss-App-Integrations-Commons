package org.symphonyoss.integration.healthcheck;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.symphonyoss.integration.model.healthcheck.IntegrationFlags;
import org.symphonyoss.integration.model.healthcheck.IntegrationFlags.ValueEnum;
import org.symphonyoss.integration.model.healthcheck.IntegrationHealth;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class IntegrationHealthManagerDiffblueTest {
  /**
   * Test {@link IntegrationHealthManager#setName(String)}.
   *
   * <p>Method under test: {@link IntegrationHealthManager#setName(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"void IntegrationHealthManager.setName(String)"})
  public void testSetName() {
    // Arrange
    IntegrationHealthManager integrationHealthManager = new IntegrationHealthManager();

    // Act
    integrationHealthManager.setName("Name");

    // Assert
    assertEquals("Name", integrationHealthManager.getHealth().getName());
  }

  /**
   * Test {@link IntegrationHealthManager#setVersion(String)}.
   *
   * <p>Method under test: {@link IntegrationHealthManager#setVersion(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"void IntegrationHealthManager.setVersion(String)"})
  public void testSetVersion() {
    // Arrange
    IntegrationHealthManager integrationHealthManager = new IntegrationHealthManager();

    // Act
    integrationHealthManager.setVersion("1.0.2");

    // Assert
    assertEquals("1.0.2", integrationHealthManager.getHealth().getVersion());
  }

  /**
   * Test {@link IntegrationHealthManager#getHealth()}.
   *
   * <p>Method under test: {@link IntegrationHealthManager#getHealth()}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegrationHealth IntegrationHealthManager.getHealth()"})
  public void testGetHealth() {
    // Arrange and Act
    IntegrationHealth actualHealth = new IntegrationHealthManager().getHealth();

    // Assert
    assertEquals("INACTIVE", actualHealth.getStatus());
    assertEquals("N/A", actualHealth.getVersion());
    assertNull(actualHealth.getLatestPostTimestamp());
    assertNull(actualHealth.getMessage());
    assertNull(actualHealth.getName());
    assertNull(actualHealth.getConfigurator());
    IntegrationFlags flags = actualHealth.getFlags();
    assertEquals(ValueEnum.NOK, flags.getUserAuthenticated());
    assertEquals(ValueEnum.NOK, flags.getUserCertificateInstalled());
    assertEquals(ValueEnum.NOT_APPLICABLE, flags.getAppCertificateInstalled());
    assertEquals(ValueEnum.OK, flags.getParserInstalled());
    assertFalse(flags.isUp());
  }

  /**
   * Test {@link IntegrationHealthManager#retry(String)}.
   *
   * <ul>
   *   <li>Then {@link IntegrationHealthManager} (default constructor) Health Status is {@code
   *       FAILED_BOOTSTRAP}.
   * </ul>
   *
   * <p>Method under test: {@link IntegrationHealthManager#retry(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"void IntegrationHealthManager.retry(String)"})
  public void testRetry_thenIntegrationHealthManagerHealthStatusIsFailedBootstrap() {
    // Arrange
    IntegrationHealthManager integrationHealthManager = new IntegrationHealthManager();
    integrationHealthManager.failBootstrap("Not all who wander are lost");

    // Act
    integrationHealthManager.retry("Not all who wander are lost");

    // Assert that nothing has changed
    IntegrationHealth health = integrationHealthManager.getHealth();
    assertEquals("FAILED_BOOTSTRAP", health.getStatus());
    assertEquals("Not all who wander are lost", health.getMessage());
  }

  /**
   * Test {@link IntegrationHealthManager#retry(String)}.
   *
   * <ul>
   *   <li>Then {@link IntegrationHealthManager} (default constructor) Health Status is {@code
   *       RETRYING_BOOTSTRAP}.
   * </ul>
   *
   * <p>Method under test: {@link IntegrationHealthManager#retry(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"void IntegrationHealthManager.retry(String)"})
  public void testRetry_thenIntegrationHealthManagerHealthStatusIsRetryingBootstrap() {
    // Arrange
    IntegrationHealthManager integrationHealthManager = new IntegrationHealthManager();

    // Act
    integrationHealthManager.retry("Not all who wander are lost");

    // Assert
    IntegrationHealth health = integrationHealthManager.getHealth();
    assertEquals("Not all who wander are lost", health.getMessage());
    assertEquals("RETRYING_BOOTSTRAP", health.getStatus());
  }

  /**
   * Test {@link IntegrationHealthManager#failBootstrap(String)}.
   *
   * <ul>
   *   <li>Then {@link IntegrationHealthManager} (default constructor) Health Status is {@code
   *       FAILED_BOOTSTRAP}.
   * </ul>
   *
   * <p>Method under test: {@link IntegrationHealthManager#failBootstrap(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"void IntegrationHealthManager.failBootstrap(String)"})
  public void testFailBootstrap_thenIntegrationHealthManagerHealthStatusIsFailedBootstrap() {
    // Arrange
    IntegrationHealthManager integrationHealthManager = new IntegrationHealthManager();

    // Act
    integrationHealthManager.failBootstrap("Not all who wander are lost");

    // Assert
    IntegrationHealth health = integrationHealthManager.getHealth();
    assertEquals("FAILED_BOOTSTRAP", health.getStatus());
    assertEquals("Not all who wander are lost", health.getMessage());
  }

  /**
   * Test {@link IntegrationHealthManager#failBootstrap(String)}.
   *
   * <ul>
   *   <li>Then {@link IntegrationHealthManager} (default constructor) Health Status is {@code
   *       RETRYING_BOOTSTRAP}.
   * </ul>
   *
   * <p>Method under test: {@link IntegrationHealthManager#failBootstrap(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"void IntegrationHealthManager.failBootstrap(String)"})
  public void testFailBootstrap_thenIntegrationHealthManagerHealthStatusIsRetryingBootstrap() {
    // Arrange
    IntegrationHealthManager integrationHealthManager = new IntegrationHealthManager();
    integrationHealthManager.retry("Not all who wander are lost");

    // Act
    integrationHealthManager.failBootstrap("Not all who wander are lost");

    // Assert that nothing has changed
    IntegrationHealth health = integrationHealthManager.getHealth();
    assertEquals("Not all who wander are lost", health.getMessage());
    assertEquals("RETRYING_BOOTSTRAP", health.getStatus());
  }

  /**
   * Test {@link IntegrationHealthManager#updateFlags()}.
   *
   * <p>Method under test: {@link IntegrationHealthManager#updateFlags()}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegrationHealth IntegrationHealthManager.updateFlags()"})
  public void testUpdateFlags() {
    // Arrange and Act
    IntegrationHealth actualUpdateFlagsResult = new IntegrationHealthManager().updateFlags();

    // Assert
    assertEquals("INACTIVE", actualUpdateFlagsResult.getStatus());
    assertEquals("N/A", actualUpdateFlagsResult.getVersion());
    assertNull(actualUpdateFlagsResult.getLatestPostTimestamp());
    assertNull(actualUpdateFlagsResult.getMessage());
    assertNull(actualUpdateFlagsResult.getName());
    assertNull(actualUpdateFlagsResult.getConfigurator());
    IntegrationFlags flags = actualUpdateFlagsResult.getFlags();
    assertEquals(ValueEnum.NOK, flags.getUserAuthenticated());
    assertEquals(ValueEnum.NOK, flags.getUserCertificateInstalled());
    assertEquals(ValueEnum.NOT_APPLICABLE, flags.getAppCertificateInstalled());
    assertEquals(ValueEnum.OK, flags.getParserInstalled());
    assertFalse(flags.isUp());
  }

  /**
   * Test {@link IntegrationHealthManager#userCertificateInstalled(ValueEnum)}.
   *
   * <p>Method under test: {@link IntegrationHealthManager#userCertificateInstalled(ValueEnum)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"void IntegrationHealthManager.userCertificateInstalled(ValueEnum)"})
  public void testUserCertificateInstalled() {
    // Arrange
    IntegrationHealthManager integrationHealthManager = new IntegrationHealthManager();

    // Act
    integrationHealthManager.userCertificateInstalled(ValueEnum.OK);

    // Assert
    assertEquals(
        ValueEnum.OK,
        integrationHealthManager.getHealth().getFlags().getUserCertificateInstalled());
  }

  /**
   * Test {@link IntegrationHealthManager#appCertificateInstalled(ValueEnum)}.
   *
   * <p>Method under test: {@link IntegrationHealthManager#appCertificateInstalled(ValueEnum)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"void IntegrationHealthManager.appCertificateInstalled(ValueEnum)"})
  public void testAppCertificateInstalled() {
    // Arrange
    IntegrationHealthManager integrationHealthManager = new IntegrationHealthManager();

    // Act
    integrationHealthManager.appCertificateInstalled(ValueEnum.OK);

    // Assert
    assertEquals(
        ValueEnum.OK, integrationHealthManager.getHealth().getFlags().getAppCertificateInstalled());
  }

  /**
   * Test {@link IntegrationHealthManager#userAuthenticated(ValueEnum)}.
   *
   * <p>Method under test: {@link IntegrationHealthManager#userAuthenticated(ValueEnum)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"void IntegrationHealthManager.userAuthenticated(ValueEnum)"})
  public void testUserAuthenticated() {
    // Arrange
    IntegrationHealthManager integrationHealthManager = new IntegrationHealthManager();

    // Act
    integrationHealthManager.userAuthenticated(ValueEnum.OK);

    // Assert
    assertEquals(
        ValueEnum.OK, integrationHealthManager.getHealth().getFlags().getUserAuthenticated());
  }
}
