package org.symphonyoss.integration.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;

public class AttributeDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>Then return Name is {@code null}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Attribute#Attribute()}
   *   <li>{@link Attribute#getName()}
   *   <li>{@link Attribute#getValue()}
   * </ul>
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Attribute.<init>()",
    "void Attribute.<init>(String, String, String)",
    "String Attribute.getName()",
    "String Attribute.getValue()"
  })
  public void testGettersAndSetters_thenReturnNameIsNull() {
    // Arrange and Act
    Attribute actualAttribute = new Attribute();
    String actualName = actualAttribute.getName();

    // Assert
    assertNull(actualName);
    assertNull(actualAttribute.getValue());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code Name}.
   *   <li>Then return Value is {@code 42}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Attribute#Attribute(String, String, String)}
   *   <li>{@link Attribute#getName()}
   *   <li>{@link Attribute#getValue()}
   * </ul>
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Attribute.<init>()",
    "void Attribute.<init>(String, String, String)",
    "String Attribute.getName()",
    "String Attribute.getValue()"
  })
  public void testGettersAndSetters_whenName_thenReturnValueIs42() {
    // Arrange and Act
    Attribute actualAttribute = new Attribute("Name", "Type", "42");
    String actualName = actualAttribute.getName();

    // Assert
    assertEquals("42", actualAttribute.getValue());
    assertEquals("Name", actualName);
  }
}
