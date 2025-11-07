package org.symphonyoss.integration.model.healthcheck;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class IntegrationConfiguratorDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link IntegrationConfigurator}
   *   <li>{@link IntegrationConfigurator#getIconUrl()}
   *   <li>{@link IntegrationConfigurator#getLoadUrl()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void IntegrationConfigurator.<init>()", "String IntegrationConfigurator.getIconUrl()",
      "String IntegrationConfigurator.getLoadUrl()"})
  public void testGettersAndSetters() {
    // Arrange and Act
    IntegrationConfigurator actualIntegrationConfigurator = new IntegrationConfigurator();
    String actualIconUrl = actualIntegrationConfigurator.getIconUrl();

    // Assert
    assertEquals("/controller.html", actualIntegrationConfigurator.getLoadUrl());
    assertEquals("/img/appstore-logo.png", actualIconUrl);
  }
}
