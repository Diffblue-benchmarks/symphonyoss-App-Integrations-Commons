package org.symphonyoss.integration.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class AttributeDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Attribute#Attribute()}
   *   <li>{@link Attribute#getName()}
   *   <li>{@link Attribute#getValue()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    Attribute actualAttribute = new Attribute();
    String actualName = actualAttribute.getName();

    // Assert
    assertNull(actualName);
    assertNull(actualAttribute.getValue());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Attribute#Attribute(String, String, String)}
   *   <li>{@link Attribute#getName()}
   *   <li>{@link Attribute#getValue()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters2() {
    // Arrange and Act
    Attribute actualAttribute = new Attribute("Name", "Type", "42");
    String actualName = actualAttribute.getName();

    // Assert
    assertEquals("42", actualAttribute.getValue());
    assertEquals("Name", actualName);
  }
}
