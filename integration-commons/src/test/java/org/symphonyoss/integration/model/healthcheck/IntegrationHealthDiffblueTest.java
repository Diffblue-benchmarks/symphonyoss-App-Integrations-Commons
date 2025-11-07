package org.symphonyoss.integration.model.healthcheck;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import org.junit.Test;

public class IntegrationHealthDiffblueTest {
  /**
   * Method under test: {@link IntegrationHealth#getVersion()}
   */
  @Test
  public void testGetVersion() {
    // Arrange, Act and Assert
    assertEquals("N/A", (new IntegrationHealth()).getVersion());
  }

  /**
   * Method under test: {@link IntegrationHealth#getVersion()}
   */
  @Test
  public void testGetVersion2() {
    // Arrange
    IntegrationFlags flags = new IntegrationFlags();
    flags.setAppCertificateInstalled(IntegrationFlags.ValueEnum.OK);
    flags.setParserInstalled(IntegrationFlags.ValueEnum.OK);
    flags.setUserAuthenticated(IntegrationFlags.ValueEnum.OK);
    flags.setUserCertificateInstalled(IntegrationFlags.ValueEnum.OK);

    IntegrationHealth integrationHealth = new IntegrationHealth();
    integrationHealth.setConfigurator(new IntegrationConfigurator());
    integrationHealth.setFlags(flags);
    integrationHealth.setLatestPostTimestamp("Latest Post Timestamp");
    integrationHealth.setMessage("Not all who wander are lost");
    integrationHealth.setName("Name");
    integrationHealth.setStatus("Status");
    integrationHealth.setVersion("foo");

    // Act and Assert
    assertEquals("foo", integrationHealth.getVersion());
  }

  /**
   * Method under test: {@link IntegrationHealth#getVersion()}
   */
  @Test
  public void testGetVersion3() {
    // Arrange
    IntegrationFlags flags = new IntegrationFlags();
    flags.setAppCertificateInstalled(IntegrationFlags.ValueEnum.OK);
    flags.setParserInstalled(IntegrationFlags.ValueEnum.OK);
    flags.setUserAuthenticated(IntegrationFlags.ValueEnum.OK);
    flags.setUserCertificateInstalled(IntegrationFlags.ValueEnum.OK);

    IntegrationHealth integrationHealth = new IntegrationHealth();
    integrationHealth.setConfigurator(new IntegrationConfigurator());
    integrationHealth.setFlags(flags);
    integrationHealth.setLatestPostTimestamp("Latest Post Timestamp");
    integrationHealth.setMessage("Not all who wander are lost");
    integrationHealth.setName("Name");
    integrationHealth.setStatus("Status");
    integrationHealth.setVersion("");

    // Act and Assert
    assertEquals("N/A", integrationHealth.getVersion());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link IntegrationHealth}
   *   <li>{@link IntegrationHealth#setConfigurator(IntegrationConfigurator)}
   *   <li>{@link IntegrationHealth#setFlags(IntegrationFlags)}
   *   <li>{@link IntegrationHealth#setLatestPostTimestamp(String)}
   *   <li>{@link IntegrationHealth#setMessage(String)}
   *   <li>{@link IntegrationHealth#setName(String)}
   *   <li>{@link IntegrationHealth#setStatus(String)}
   *   <li>{@link IntegrationHealth#setVersion(String)}
   *   <li>{@link IntegrationHealth#getConfigurator()}
   *   <li>{@link IntegrationHealth#getFlags()}
   *   <li>{@link IntegrationHealth#getLatestPostTimestamp()}
   *   <li>{@link IntegrationHealth#getMessage()}
   *   <li>{@link IntegrationHealth#getName()}
   *   <li>{@link IntegrationHealth#getStatus()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    IntegrationHealth actualIntegrationHealth = new IntegrationHealth();
    IntegrationConfigurator configurator = new IntegrationConfigurator();
    actualIntegrationHealth.setConfigurator(configurator);
    IntegrationFlags flags = new IntegrationFlags();
    flags.setAppCertificateInstalled(IntegrationFlags.ValueEnum.OK);
    flags.setParserInstalled(IntegrationFlags.ValueEnum.OK);
    flags.setUserAuthenticated(IntegrationFlags.ValueEnum.OK);
    flags.setUserCertificateInstalled(IntegrationFlags.ValueEnum.OK);
    actualIntegrationHealth.setFlags(flags);
    actualIntegrationHealth.setLatestPostTimestamp("Latest Post Timestamp");
    actualIntegrationHealth.setMessage("Not all who wander are lost");
    actualIntegrationHealth.setName("Name");
    actualIntegrationHealth.setStatus("Status");
    actualIntegrationHealth.setVersion("1.0.2");
    IntegrationConfigurator actualConfigurator = actualIntegrationHealth.getConfigurator();
    IntegrationFlags actualFlags = actualIntegrationHealth.getFlags();
    String actualLatestPostTimestamp = actualIntegrationHealth.getLatestPostTimestamp();
    String actualMessage = actualIntegrationHealth.getMessage();
    String actualName = actualIntegrationHealth.getName();

    // Assert that nothing has changed
    assertEquals("Latest Post Timestamp", actualLatestPostTimestamp);
    assertEquals("Name", actualName);
    assertEquals("Not all who wander are lost", actualMessage);
    assertEquals("Status", actualIntegrationHealth.getStatus());
    assertSame(configurator, actualConfigurator);
    assertSame(flags, actualFlags);
  }
}
