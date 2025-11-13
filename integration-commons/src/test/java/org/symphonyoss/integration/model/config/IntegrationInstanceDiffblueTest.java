package org.symphonyoss.integration.model.config;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;

public class IntegrationInstanceDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link IntegrationInstance}
   *   <li>{@link IntegrationInstance#setActive(Boolean)}
   *   <li>{@link IntegrationInstance#setConfigurationId(String)}
   *   <li>{@link IntegrationInstance#setCreatedDate(Long)}
   *   <li>{@link IntegrationInstance#setCreatorId(String)}
   *   <li>{@link IntegrationInstance#setCreatorName(String)}
   *   <li>{@link IntegrationInstance#setInstanceId(String)}
   *   <li>{@link IntegrationInstance#setLastModifiedDate(Long)}
   *   <li>{@link IntegrationInstance#setName(String)}
   *   <li>{@link IntegrationInstance#setOptionalProperties(String)}
   *   <li>{@link IntegrationInstance#getActive()}
   *   <li>{@link IntegrationInstance#getConfigurationId()}
   *   <li>{@link IntegrationInstance#getCreatedDate()}
   *   <li>{@link IntegrationInstance#getCreatorId()}
   *   <li>{@link IntegrationInstance#getCreatorName()}
   *   <li>{@link IntegrationInstance#getInstanceId()}
   *   <li>{@link IntegrationInstance#getLastModifiedDate()}
   *   <li>{@link IntegrationInstance#getName()}
   *   <li>{@link IntegrationInstance#getOptionalProperties()}
   * </ul>
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void IntegrationInstance.<init>()",
    "Boolean IntegrationInstance.getActive()",
    "String IntegrationInstance.getConfigurationId()",
    "Long IntegrationInstance.getCreatedDate()",
    "String IntegrationInstance.getCreatorId()",
    "String IntegrationInstance.getCreatorName()",
    "String IntegrationInstance.getInstanceId()",
    "Long IntegrationInstance.getLastModifiedDate()",
    "String IntegrationInstance.getName()",
    "String IntegrationInstance.getOptionalProperties()",
    "void IntegrationInstance.setActive(Boolean)",
    "void IntegrationInstance.setConfigurationId(String)",
    "void IntegrationInstance.setCreatedDate(Long)",
    "void IntegrationInstance.setCreatorId(String)",
    "void IntegrationInstance.setCreatorName(String)",
    "void IntegrationInstance.setInstanceId(String)",
    "void IntegrationInstance.setLastModifiedDate(Long)",
    "void IntegrationInstance.setName(String)",
    "void IntegrationInstance.setOptionalProperties(String)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    IntegrationInstance actualIntegrationInstance = new IntegrationInstance();
    actualIntegrationInstance.setActive(true);
    actualIntegrationInstance.setConfigurationId("42");
    actualIntegrationInstance.setCreatedDate(1L);
    actualIntegrationInstance.setCreatorId("42");
    actualIntegrationInstance.setCreatorName("Creator Name");
    actualIntegrationInstance.setInstanceId("42");
    actualIntegrationInstance.setLastModifiedDate(1L);
    actualIntegrationInstance.setName("Name");
    actualIntegrationInstance.setOptionalProperties("Optional Properties");
    Boolean actualActive = actualIntegrationInstance.getActive();
    String actualConfigurationId = actualIntegrationInstance.getConfigurationId();
    Long actualCreatedDate = actualIntegrationInstance.getCreatedDate();
    String actualCreatorId = actualIntegrationInstance.getCreatorId();
    String actualCreatorName = actualIntegrationInstance.getCreatorName();
    String actualInstanceId = actualIntegrationInstance.getInstanceId();
    Long actualLastModifiedDate = actualIntegrationInstance.getLastModifiedDate();
    String actualName = actualIntegrationInstance.getName();

    // Assert
    assertEquals("42", actualConfigurationId);
    assertEquals("42", actualCreatorId);
    assertEquals("42", actualInstanceId);
    assertEquals("Creator Name", actualCreatorName);
    assertEquals("Name", actualName);
    assertEquals("Optional Properties", actualIntegrationInstance.getOptionalProperties());
    assertEquals(1L, actualCreatedDate.longValue());
    assertEquals(1L, actualLastModifiedDate.longValue());
    assertTrue(actualActive);
  }
}
