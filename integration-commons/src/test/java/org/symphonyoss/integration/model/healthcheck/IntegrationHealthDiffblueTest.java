package org.symphonyoss.integration.model.healthcheck;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.symphonyoss.integration.model.healthcheck.IntegrationFlags.ValueEnum;

public class IntegrationHealthDiffblueTest {
  /**
   * Test {@link IntegrationHealth#getVersion()}.
   *
   * <ul>
   *   <li>Given {@link IntegrationHealth} (default constructor) Version is empty string.
   *   <li>Then return {@code N/A}.
   * </ul>
   *
   * <p>Method under test: {@link IntegrationHealth#getVersion()}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String IntegrationHealth.getVersion()"})
  public void testGetVersion_givenIntegrationHealthVersionIsEmptyString_thenReturnNA() {
    // Arrange
    IntegrationFlags flags = new IntegrationFlags();
    flags.setAppCertificateInstalled(ValueEnum.OK);
    flags.setParserInstalled(ValueEnum.OK);
    flags.setUserAuthenticated(ValueEnum.OK);
    flags.setUserCertificateInstalled(ValueEnum.OK);

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
   * Test {@link IntegrationHealth#getVersion()}.
   *
   * <ul>
   *   <li>Given {@link IntegrationHealth} (default constructor) Version is {@code not empty}.
   *   <li>Then return {@code not empty}.
   * </ul>
   *
   * <p>Method under test: {@link IntegrationHealth#getVersion()}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String IntegrationHealth.getVersion()"})
  public void testGetVersion_givenIntegrationHealthVersionIsNotEmpty_thenReturnNotEmpty() {
    // Arrange
    IntegrationFlags flags = new IntegrationFlags();
    flags.setAppCertificateInstalled(ValueEnum.OK);
    flags.setParserInstalled(ValueEnum.OK);
    flags.setUserAuthenticated(ValueEnum.OK);
    flags.setUserCertificateInstalled(ValueEnum.OK);

    IntegrationHealth integrationHealth = new IntegrationHealth();
    integrationHealth.setConfigurator(new IntegrationConfigurator());
    integrationHealth.setFlags(flags);
    integrationHealth.setLatestPostTimestamp("Latest Post Timestamp");
    integrationHealth.setMessage("Not all who wander are lost");
    integrationHealth.setName("Name");
    integrationHealth.setStatus("Status");
    integrationHealth.setVersion("not empty");

    // Act and Assert
    assertEquals("not empty", integrationHealth.getVersion());
  }

  /**
   * Test {@link IntegrationHealth#getVersion()}.
   *
   * <ul>
   *   <li>Given {@link IntegrationHealth} (default constructor).
   *   <li>Then return {@code N/A}.
   * </ul>
   *
   * <p>Method under test: {@link IntegrationHealth#getVersion()}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String IntegrationHealth.getVersion()"})
  public void testGetVersion_givenIntegrationHealth_thenReturnNA() {
    // Arrange, Act and Assert
    assertEquals("N/A", new IntegrationHealth().getVersion());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void IntegrationHealth.<init>()",
    "IntegrationConfigurator IntegrationHealth.getConfigurator()",
    "IntegrationFlags IntegrationHealth.getFlags()",
    "String IntegrationHealth.getLatestPostTimestamp()",
    "String IntegrationHealth.getMessage()",
    "String IntegrationHealth.getName()",
    "String IntegrationHealth.getStatus()",
    "void IntegrationHealth.setConfigurator(IntegrationConfigurator)",
    "void IntegrationHealth.setFlags(IntegrationFlags)",
    "void IntegrationHealth.setLatestPostTimestamp(String)",
    "void IntegrationHealth.setMessage(String)",
    "void IntegrationHealth.setName(String)",
    "void IntegrationHealth.setStatus(String)",
    "void IntegrationHealth.setVersion(String)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    IntegrationHealth actualIntegrationHealth = new IntegrationHealth();
    IntegrationConfigurator configurator = new IntegrationConfigurator();
    actualIntegrationHealth.setConfigurator(configurator);
    IntegrationFlags flags = new IntegrationFlags();
    flags.setAppCertificateInstalled(ValueEnum.OK);
    flags.setParserInstalled(ValueEnum.OK);
    flags.setUserAuthenticated(ValueEnum.OK);
    flags.setUserCertificateInstalled(ValueEnum.OK);
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

    // Assert
    assertEquals("Latest Post Timestamp", actualLatestPostTimestamp);
    assertEquals("Name", actualName);
    assertEquals("Not all who wander are lost", actualMessage);
    assertEquals("Status", actualIntegrationHealth.getStatus());
    assertSame(configurator, actualConfigurator);
    assertSame(flags, actualFlags);
  }
}
