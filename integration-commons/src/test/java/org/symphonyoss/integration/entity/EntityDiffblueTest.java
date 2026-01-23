package org.symphonyoss.integration.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import org.junit.Test;

public class EntityDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>Then return Type is {@code null}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Entity#Entity()}
   *   <li>{@link Entity#setPresentationML(String)}
   *   <li>{@link Entity#getAttributes()}
   *   <li>{@link Entity#getEntities()}
   *   <li>{@link Entity#getName()}
   *   <li>{@link Entity#getPresentationML()}
   *   <li>{@link Entity#getType()}
   * </ul>
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Entity.<init>()",
    "void Entity.<init>(String)",
    "void Entity.<init>(String, String)",
    "List Entity.getAttributes()",
    "List Entity.getEntities()",
    "String Entity.getName()",
    "String Entity.getPresentationML()",
    "String Entity.getType()",
    "void Entity.setPresentationML(String)"
  })
  public void testGettersAndSetters_thenReturnTypeIsNull() {
    // Arrange and Act
    Entity actualEntity = new Entity();
    actualEntity.setPresentationML("Presentation ML");
    List<Attribute> actualAttributes = actualEntity.getAttributes();
    List<Entity> actualEntities = actualEntity.getEntities();
    String actualName = actualEntity.getName();
    String actualPresentationML = actualEntity.getPresentationML();

    // Assert
    assertEquals("Presentation ML", actualPresentationML);
    assertNull(actualName);
    assertNull(actualEntity.getType());
    assertNull(actualAttributes);
    assertNull(actualEntities);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code Name}.
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Entity#Entity(String, String)}
   *   <li>{@link Entity#setPresentationML(String)}
   *   <li>{@link Entity#getAttributes()}
   *   <li>{@link Entity#getEntities()}
   *   <li>{@link Entity#getName()}
   *   <li>{@link Entity#getPresentationML()}
   *   <li>{@link Entity#getType()}
   * </ul>
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Entity.<init>()",
    "void Entity.<init>(String)",
    "void Entity.<init>(String, String)",
    "List Entity.getAttributes()",
    "List Entity.getEntities()",
    "String Entity.getName()",
    "String Entity.getPresentationML()",
    "String Entity.getType()",
    "void Entity.setPresentationML(String)"
  })
  public void testGettersAndSetters_whenName_thenReturnName() {
    // Arrange and Act
    Entity actualEntity = new Entity("Name", "Type");
    actualEntity.setPresentationML("Presentation ML");
    List<Attribute> actualAttributes = actualEntity.getAttributes();
    List<Entity> actualEntities = actualEntity.getEntities();
    String actualName = actualEntity.getName();
    String actualPresentationML = actualEntity.getPresentationML();

    // Assert
    assertEquals("Name", actualName);
    assertEquals("Presentation ML", actualPresentationML);
    assertEquals("Type", actualEntity.getType());
    assertTrue(actualAttributes.isEmpty());
    assertTrue(actualEntities.isEmpty());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code Type}.
   *   <li>Then return {@code Type}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Entity#Entity(String)}
   *   <li>{@link Entity#setPresentationML(String)}
   *   <li>{@link Entity#getAttributes()}
   *   <li>{@link Entity#getEntities()}
   *   <li>{@link Entity#getName()}
   *   <li>{@link Entity#getPresentationML()}
   *   <li>{@link Entity#getType()}
   * </ul>
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Entity.<init>()",
    "void Entity.<init>(String)",
    "void Entity.<init>(String, String)",
    "List Entity.getAttributes()",
    "List Entity.getEntities()",
    "String Entity.getName()",
    "String Entity.getPresentationML()",
    "String Entity.getType()",
    "void Entity.setPresentationML(String)"
  })
  public void testGettersAndSetters_whenType_thenReturnType() {
    // Arrange and Act
    Entity actualEntity = new Entity("Type");
    actualEntity.setPresentationML("Presentation ML");
    List<Attribute> actualAttributes = actualEntity.getAttributes();
    List<Entity> actualEntities = actualEntity.getEntities();
    String actualName = actualEntity.getName();
    String actualPresentationML = actualEntity.getPresentationML();

    // Assert
    assertEquals("Presentation ML", actualPresentationML);
    assertEquals("Type", actualEntity.getType());
    assertNull(actualName);
    assertTrue(actualAttributes.isEmpty());
    assertTrue(actualEntities.isEmpty());
  }

  /**
   * Test {@link Entity#addAttribute(Attribute)}.
   *
   * <p>Method under test: {@link Entity#addAttribute(Attribute)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"void Entity.addAttribute(Attribute)"})
  public void testAddAttribute() {
    // Arrange
    Entity entity = new Entity("Type");
    Attribute attribute = new Attribute("Name", "Type", "42");

    // Act
    entity.addAttribute(attribute);

    // Assert
    List<Attribute> attributes = entity.getAttributes();
    assertEquals(1, attributes.size());
    assertSame(attribute, attributes.get(0));
  }

  /**
   * Test {@link Entity#addEntity(Entity)}.
   *
   * <ul>
   *   <li>Given {@link Entity#Entity(String)} with {@code Type}.
   *   <li>Then {@link Entity#Entity(String)} with {@code Type} Entities Empty.
   * </ul>
   *
   * <p>Method under test: {@link Entity#addEntity(Entity)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"void Entity.addEntity(Entity)"})
  public void testAddEntity_givenEntityWithType_thenEntityWithTypeEntitiesEmpty() {
    // Arrange
    Entity entity = new Entity("Type");
    Entity entity2 = new Entity("Type");

    // Act
    entity.addEntity(entity2);

    // Assert that nothing has changed
    assertTrue(entity2.getEntities().isEmpty());
  }

  /**
   * Test {@link Entity#addEntity(Entity)}.
   *
   * <ul>
   *   <li>Given {@link Entity#Entity()}.
   *   <li>Then {@link Entity#Entity()} Entities size is one.
   * </ul>
   *
   * <p>Method under test: {@link Entity#addEntity(Entity)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"void Entity.addEntity(Entity)"})
  public void testAddEntity_givenEntity_thenEntityEntitiesSizeIsOne() {
    // Arrange
    Entity entity = new Entity();
    Entity entity2 = new Entity("Type");

    // Act
    entity.addEntity(entity2);

    // Assert
    List<Entity> entities = entity.getEntities();
    assertEquals(1, entities.size());
    assertSame(entity2, entities.get(0));
  }

  /**
   * Test {@link Entity#getEntityByType(String)}.
   *
   * <ul>
   *   <li>Given {@link Entity#Entity(String)} with {@code Type} addEntity {@link
   *       Entity#Entity(String)} with type is {@code 1.0}.
   *   <li>When {@code Type}.
   * </ul>
   *
   * <p>Method under test: {@link Entity#getEntityByType(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity Entity.getEntityByType(String)"})
  public void testGetEntityByType_givenEntityWithTypeAddEntityEntityWithTypeIs10_whenType() {
    // Arrange
    Entity entity = new Entity("Type");
    entity.addEntity(new Entity("1.0"));

    // Act and Assert
    assertNull(entity.getEntityByType("Type"));
  }

  /**
   * Test {@link Entity#getEntityByType(String)}.
   *
   * <ul>
   *   <li>Given {@link Entity#Entity(String)} with {@code Type} addEntity {@link
   *       Entity#Entity(String)} with {@code Type}.
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link Entity#getEntityByType(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity Entity.getEntityByType(String)"})
  public void testGetEntityByType_givenEntityWithTypeAddEntityEntityWithType_whenEmptyString() {
    // Arrange
    Entity entity = new Entity("Type");
    entity.addEntity(new Entity("Type"));

    // Act and Assert
    assertNull(entity.getEntityByType(""));
  }

  /**
   * Test {@link Entity#getEntityByType(String)}.
   *
   * <ul>
   *   <li>Given {@link Entity#Entity(String)} with {@code Type} addEntity {@link
   *       Entity#Entity(String)} with {@code Type}.
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Entity#getEntityByType(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity Entity.getEntityByType(String)"})
  public void testGetEntityByType_givenEntityWithTypeAddEntityEntityWithType_whenNull() {
    // Arrange
    Entity entity = new Entity("Type");
    entity.addEntity(new Entity("Type"));

    // Act and Assert
    assertNull(entity.getEntityByType(null));
  }

  /**
   * Test {@link Entity#getEntityByType(String)}.
   *
   * <ul>
   *   <li>Given {@link Entity#Entity(String)} with {@code Type}.
   *   <li>When {@code Type}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Entity#getEntityByType(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity Entity.getEntityByType(String)"})
  public void testGetEntityByType_givenEntityWithType_whenType_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new Entity("Type").getEntityByType("Type"));
  }

  /**
   * Test {@link Entity#getEntityByType(String)}.
   *
   * <ul>
   *   <li>Given {@link Entity#Entity()}.
   *   <li>When {@code Type}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Entity#getEntityByType(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity Entity.getEntityByType(String)"})
  public void testGetEntityByType_givenEntity_whenType_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new Entity().getEntityByType("Type"));
  }

  /**
   * Test {@link Entity#getEntityByType(String)}.
   *
   * <ul>
   *   <li>Then return {@link Entity#Entity(String)} with {@code Type}.
   * </ul>
   *
   * <p>Method under test: {@link Entity#getEntityByType(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity Entity.getEntityByType(String)"})
  public void testGetEntityByType_thenReturnEntityWithType() {
    // Arrange
    Entity entity = new Entity("Type");
    Entity entity2 = new Entity("Type");
    entity.addEntity(entity2);

    // Act and Assert
    assertSame(entity2, entity.getEntityByType("Type"));
  }

  /**
   * Test {@link Entity#getEntityByName(String)}.
   *
   * <ul>
   *   <li>Given {@link Entity#Entity(String)} with {@code Type} addEntity {@link
   *       Entity#Entity(String)} with {@code Type}.
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link Entity#getEntityByName(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity Entity.getEntityByName(String)"})
  public void testGetEntityByName_givenEntityWithTypeAddEntityEntityWithType_whenEmptyString() {
    // Arrange
    Entity entity = new Entity("Type");
    entity.addEntity(new Entity("Type"));

    // Act and Assert
    assertNull(entity.getEntityByName(""));
  }

  /**
   * Test {@link Entity#getEntityByName(String)}.
   *
   * <ul>
   *   <li>Given {@link Entity#Entity(String)} with {@code Type} addEntity {@link
   *       Entity#Entity(String)} with {@code Type}.
   *   <li>When {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link Entity#getEntityByName(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity Entity.getEntityByName(String)"})
  public void testGetEntityByName_givenEntityWithTypeAddEntityEntityWithType_whenName() {
    // Arrange
    Entity entity = new Entity("Type");
    entity.addEntity(new Entity("Type"));

    // Act and Assert
    assertNull(entity.getEntityByName("Name"));
  }

  /**
   * Test {@link Entity#getEntityByName(String)}.
   *
   * <ul>
   *   <li>Given {@link Entity#Entity(String)} with {@code Type} addEntity {@link
   *       Entity#Entity(String)} with {@code Type}.
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Entity#getEntityByName(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity Entity.getEntityByName(String)"})
  public void testGetEntityByName_givenEntityWithTypeAddEntityEntityWithType_whenNull() {
    // Arrange
    Entity entity = new Entity("Type");
    entity.addEntity(new Entity("Type"));

    // Act and Assert
    assertNull(entity.getEntityByName(null));
  }

  /**
   * Test {@link Entity#getEntityByName(String)}.
   *
   * <ul>
   *   <li>Given {@link Entity#Entity(String)} with {@code Type}.
   *   <li>When {@code Name}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Entity#getEntityByName(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity Entity.getEntityByName(String)"})
  public void testGetEntityByName_givenEntityWithType_whenName_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new Entity("Type").getEntityByName("Name"));
  }

  /**
   * Test {@link Entity#getEntityByName(String)}.
   *
   * <ul>
   *   <li>Given {@link Entity#Entity()}.
   *   <li>When {@code Name}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Entity#getEntityByName(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity Entity.getEntityByName(String)"})
  public void testGetEntityByName_givenEntity_whenName_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new Entity().getEntityByName("Name"));
  }

  /**
   * Test {@link Entity#getEntityByName(String)}.
   *
   * <ul>
   *   <li>Then return {@link Entity#Entity(String, String)} with {@code Name} and {@code Type}.
   * </ul>
   *
   * <p>Method under test: {@link Entity#getEntityByName(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity Entity.getEntityByName(String)"})
  public void testGetEntityByName_thenReturnEntityWithNameAndType() {
    // Arrange
    Entity entity = new Entity("Type");
    Entity entity2 = new Entity("Name", "Type");
    entity.addEntity(entity2);

    // Act and Assert
    assertSame(entity2, entity.getEntityByName("Name"));
  }

  /**
   * Test {@link Entity#getAttributeValue(String)}.
   *
   * <p>Method under test: {@link Entity#getAttributeValue(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String Entity.getAttributeValue(String)"})
  public void testGetAttributeValue() {
    // Arrange
    Entity entity = new Entity("Type");
    Attribute attribute = new Attribute(null, "Type", "42");
    entity.addAttribute(attribute);

    // Act and Assert
    assertNull(entity.getAttributeValue("Name"));
  }

  /**
   * Test {@link Entity#getAttributeValue(String)}.
   *
   * <ul>
   *   <li>Given {@link Entity#Entity(String)} with {@code Type}.
   *   <li>When {@code Name}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Entity#getAttributeValue(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String Entity.getAttributeValue(String)"})
  public void testGetAttributeValue_givenEntityWithType_whenName_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new Entity("Type").getAttributeValue("Name"));
  }

  /**
   * Test {@link Entity#getAttributeValue(String)}.
   *
   * <ul>
   *   <li>Given {@link Entity#Entity()}.
   *   <li>When {@code Name}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Entity#getAttributeValue(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String Entity.getAttributeValue(String)"})
  public void testGetAttributeValue_givenEntity_whenName_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new Entity().getAttributeValue("Name"));
  }

  /**
   * Test {@link Entity#getAttributeValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link Entity#getAttributeValue(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String Entity.getAttributeValue(String)"})
  public void testGetAttributeValue_thenReturn42() {
    // Arrange
    Entity entity = new Entity("Type");
    Attribute attribute = new Attribute("Name", "Type", "42");
    entity.addAttribute(attribute);

    // Act and Assert
    assertEquals("42", entity.getAttributeValue("Name"));
  }

  /**
   * Test {@link Entity#getAttributeValue(String)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link Entity#getAttributeValue(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String Entity.getAttributeValue(String)"})
  public void testGetAttributeValue_whenEmptyString() {
    // Arrange
    Entity entity = new Entity("Type");
    Attribute attribute = new Attribute("Name", "Type", "42");
    entity.addAttribute(attribute);

    // Act and Assert
    assertNull(entity.getAttributeValue(""));
  }

  /**
   * Test {@link Entity#getAttributeValue(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Entity#getAttributeValue(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String Entity.getAttributeValue(String)"})
  public void testGetAttributeValue_whenNull() {
    // Arrange
    Entity entity = new Entity("Type");
    Attribute attribute = new Attribute("Name", "Type", "42");
    entity.addAttribute(attribute);

    // Act and Assert
    assertNull(entity.getAttributeValue(null));
  }
}
