package org.symphonyoss.integration.model.config;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class IntegrationSettingsDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link IntegrationSettings}
   *   <li>{@link IntegrationSettings#setActive(Boolean)}
   *   <li>{@link IntegrationSettings#setConfigurationId(String)}
   *   <li>{@link IntegrationSettings#setData(Map)}
   *   <li>{@link IntegrationSettings#setDescription(String)}
   *   <li>{@link IntegrationSettings#setEnabled(Boolean)}
   *   <li>{@link IntegrationSettings#setName(String)}
   *   <li>{@link IntegrationSettings#setOwner(Long)}
   *   <li>{@link IntegrationSettings#setType(String)}
   *   <li>{@link IntegrationSettings#setUsername(String)}
   *   <li>{@link IntegrationSettings#setVisible(Boolean)}
   *   <li>{@link IntegrationSettings#getActive()}
   *   <li>{@link IntegrationSettings#getConfigurationId()}
   *   <li>{@link IntegrationSettings#getData()}
   *   <li>{@link IntegrationSettings#getDescription()}
   *   <li>{@link IntegrationSettings#getEnabled()}
   *   <li>{@link IntegrationSettings#getName()}
   *   <li>{@link IntegrationSettings#getOwner()}
   *   <li>{@link IntegrationSettings#getType()}
   *   <li>{@link IntegrationSettings#getUsername()}
   *   <li>{@link IntegrationSettings#getVisible()}
   * </ul>
   */
  @Test
  @MethodsUnderTest({"void IntegrationSettings.<init>()", "Boolean IntegrationSettings.getActive()",
      "String IntegrationSettings.getConfigurationId()", "Map IntegrationSettings.getData()",
      "String IntegrationSettings.getDescription()", "Boolean IntegrationSettings.getEnabled()",
      "String IntegrationSettings.getName()", "Long IntegrationSettings.getOwner()",
      "String IntegrationSettings.getType()", "String IntegrationSettings.getUsername()",
      "Boolean IntegrationSettings.getVisible()", "void IntegrationSettings.setActive(Boolean)",
      "void IntegrationSettings.setConfigurationId(String)", "void IntegrationSettings.setData(Map)",
      "void IntegrationSettings.setDescription(String)", "void IntegrationSettings.setEnabled(Boolean)",
      "void IntegrationSettings.setName(String)", "void IntegrationSettings.setOwner(Long)",
      "void IntegrationSettings.setType(String)", "void IntegrationSettings.setUsername(String)",
      "void IntegrationSettings.setVisible(Boolean)"})
  public void testGettersAndSetters() {
    // Arrange and Act
    IntegrationSettings actualIntegrationSettings = new IntegrationSettings();
    actualIntegrationSettings.setActive(true);
    actualIntegrationSettings.setConfigurationId("42");
    HashMap<String, Object> data = new HashMap<>();
    actualIntegrationSettings.setData(data);
    actualIntegrationSettings.setDescription("The characteristics of someone or something");
    actualIntegrationSettings.setEnabled(true);
    actualIntegrationSettings.setName("Name");
    actualIntegrationSettings.setOwner(1L);
    actualIntegrationSettings.setType("Type");
    actualIntegrationSettings.setUsername("janedoe");
    actualIntegrationSettings.setVisible(true);
    Boolean actualActive = actualIntegrationSettings.getActive();
    String actualConfigurationId = actualIntegrationSettings.getConfigurationId();
    Map<String, Object> actualData = actualIntegrationSettings.getData();
    String actualDescription = actualIntegrationSettings.getDescription();
    Boolean actualEnabled = actualIntegrationSettings.getEnabled();
    String actualName = actualIntegrationSettings.getName();
    Long actualOwner = actualIntegrationSettings.getOwner();
    String actualType = actualIntegrationSettings.getType();
    String actualUsername = actualIntegrationSettings.getUsername();
    Boolean actualVisible = actualIntegrationSettings.getVisible();

    // Assert
    assertEquals("42", actualConfigurationId);
    assertEquals("Name", actualName);
    assertEquals("The characteristics of someone or something", actualDescription);
    assertEquals("Type", actualType);
    assertEquals("janedoe", actualUsername);
    assertEquals(1L, actualOwner.longValue());
    assertTrue(actualData.isEmpty());
    assertTrue(actualActive);
    assertTrue(actualEnabled);
    assertTrue(actualVisible);
    assertSame(data, actualData);
  }
}
