package org.symphonyoss.integration.model.yaml;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class AppAuthorizationModelDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link AppAuthorizationModel}
   *   <li>{@link AppAuthorizationModel#setApplicationName(String)}
   *   <li>{@link AppAuthorizationModel#setApplicationURL(String)}
   *   <li>{@link AppAuthorizationModel#setProperties(Map)}
   *   <li>{@link AppAuthorizationModel#getApplicationName()}
   *   <li>{@link AppAuthorizationModel#getApplicationURL()}
   *   <li>{@link AppAuthorizationModel#getProperties()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    AppAuthorizationModel actualAppAuthorizationModel = new AppAuthorizationModel();
    actualAppAuthorizationModel.setApplicationName("Application Name");
    actualAppAuthorizationModel.setApplicationURL("https://example.org/example");
    HashMap<String, Object> properties = new HashMap<>();
    actualAppAuthorizationModel.setProperties(properties);
    String actualApplicationName = actualAppAuthorizationModel.getApplicationName();
    String actualApplicationURL = actualAppAuthorizationModel.getApplicationURL();
    Map<String, Object> actualProperties = actualAppAuthorizationModel.getProperties();

    // Assert that nothing has changed
    assertEquals("Application Name", actualApplicationName);
    assertEquals("https://example.org/example", actualApplicationURL);
    assertTrue(actualProperties.isEmpty());
    assertSame(properties, actualProperties);
  }
}
