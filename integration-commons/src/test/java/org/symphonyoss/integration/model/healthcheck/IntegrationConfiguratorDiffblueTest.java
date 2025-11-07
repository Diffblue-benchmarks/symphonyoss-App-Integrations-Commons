package org.symphonyoss.integration.model.healthcheck;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class IntegrationConfiguratorDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link IntegrationConfigurator}
   *   <li>{@link IntegrationConfigurator#getIconUrl()}
   *   <li>{@link IntegrationConfigurator#getLoadUrl()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    IntegrationConfigurator actualIntegrationConfigurator = new IntegrationConfigurator();
    String actualIconUrl = actualIntegrationConfigurator.getIconUrl();

    // Assert
    assertEquals("/controller.html", actualIntegrationConfigurator.getLoadUrl());
    assertEquals("/img/appstore-logo.png", actualIconUrl);
  }
}
