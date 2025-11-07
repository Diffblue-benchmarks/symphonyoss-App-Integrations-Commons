package org.symphonyoss.integration.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.List;
import org.junit.Test;

public class EntityDiffblueTest {
  /**
   * Method under test: {@link Entity#addAttribute(Attribute)}
   */
  @Test
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
   * Method under test: {@link Entity#addEntity(Entity)}
   */
  @Test
  public void testAddEntity() {
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
   * Method under test: {@link Entity#getEntityByType(String)}
   */
  @Test
  public void testGetEntityByType() {
    // Arrange, Act and Assert
    assertNull((new Entity("Type")).getEntityByType("Type"));
    assertNull((new Entity()).getEntityByType("Type"));
    assertNull((new Entity("Type")).getEntityByType(null));
    assertNull((new Entity("Type")).getEntityByType(""));
  }

  /**
   * Method under test: {@link Entity#getEntityByType(String)}
   */
  @Test
  public void testGetEntityByType2() {
    // Arrange
    Entity entity = new Entity("Type");
    Entity entity2 = new Entity("Type");
    entity.addEntity(entity2);

    // Act and Assert
    assertSame(entity2, entity.getEntityByType("Type"));
  }

  /**
   * Method under test: {@link Entity#getEntityByType(String)}
   */
  @Test
  public void testGetEntityByType3() {
    // Arrange
    Entity entity = new Entity("Type");
    entity.addEntity(new Entity("1.0"));

    // Act and Assert
    assertNull(entity.getEntityByType("Type"));
  }

  /**
   * Method under test: {@link Entity#getEntityByName(String)}
   */
  @Test
  public void testGetEntityByName() {
    // Arrange, Act and Assert
    assertNull((new Entity("Type")).getEntityByName("Name"));
    assertNull((new Entity()).getEntityByName("Name"));
    assertNull((new Entity("Type")).getEntityByName(null));
    assertNull((new Entity("Type")).getEntityByName(""));
  }

  /**
   * Method under test: {@link Entity#getEntityByName(String)}
   */
  @Test
  public void testGetEntityByName2() {
    // Arrange
    Entity entity = new Entity("Type");
    entity.addEntity(new Entity("Type"));

    // Act and Assert
    assertNull(entity.getEntityByName("Name"));
  }

  /**
   * Method under test: {@link Entity#getEntityByName(String)}
   */
  @Test
  public void testGetEntityByName3() {
    // Arrange
    Entity entity = new Entity("Type");
    Entity entity2 = new Entity("Name", "Type");

    entity.addEntity(entity2);

    // Act and Assert
    assertSame(entity2, entity.getEntityByName("Name"));
  }

  /**
   * Method under test: {@link Entity#getAttributeValue(String)}
   */
  @Test
  public void testGetAttributeValue() {
    // Arrange, Act and Assert
    assertNull((new Entity("Type")).getAttributeValue("Name"));
    assertNull((new Entity()).getAttributeValue("Name"));
    assertNull((new Entity("Type")).getAttributeValue(null));
    assertNull((new Entity("Type")).getAttributeValue(""));
  }

  /**
   * Method under test: {@link Entity#getAttributeValue(String)}
   */
  @Test
  public void testGetAttributeValue2() {
    // Arrange
    Entity entity = new Entity("Type");
    entity.addAttribute(new Attribute("Name", "Type", "42"));

    // Act and Assert
    assertEquals("42", entity.getAttributeValue("Name"));
  }

  /**
   * Method under test: {@link Entity#getAttributeValue(String)}
   */
  @Test
  public void testGetAttributeValue3() {
    // Arrange
    Entity entity = new Entity("Type");
    entity.addAttribute(new Attribute(null, "Type", "42"));

    // Act and Assert
    assertNull(entity.getAttributeValue("Name"));
  }

  /**
   * Methods under test:
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
  public void testGettersAndSetters() {
    // Arrange and Act
    Entity actualEntity = new Entity();
    actualEntity.setPresentationML("Presentation ML");
    actualEntity.getAttributes();
    actualEntity.getEntities();
    actualEntity.getName();
    String actualPresentationML = actualEntity.getPresentationML();
    actualEntity.getType();

    // Assert that nothing has changed
    assertEquals("Presentation ML", actualPresentationML);
  }

  /**
   * Methods under test:
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
  public void testGettersAndSetters2() {
    // Arrange and Act
    Entity actualEntity = new Entity("Type");
    actualEntity.setPresentationML("Presentation ML");
    List<Attribute> actualAttributes = actualEntity.getAttributes();
    List<Entity> actualEntities = actualEntity.getEntities();
    actualEntity.getName();
    String actualPresentationML = actualEntity.getPresentationML();

    // Assert that nothing has changed
    assertEquals("Presentation ML", actualPresentationML);
    assertEquals("Type", actualEntity.getType());
    assertTrue(actualAttributes.isEmpty());
    assertTrue(actualEntities.isEmpty());
  }

  /**
   * Methods under test:
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
  public void testGettersAndSetters3() {
    // Arrange and Act
    Entity actualEntity = new Entity("Name", "Type");
    actualEntity.setPresentationML("Presentation ML");
    List<Attribute> actualAttributes = actualEntity.getAttributes();
    List<Entity> actualEntities = actualEntity.getEntities();
    String actualName = actualEntity.getName();
    String actualPresentationML = actualEntity.getPresentationML();

    // Assert that nothing has changed
    assertEquals("Name", actualName);
    assertEquals("Presentation ML", actualPresentationML);
    assertEquals("Type", actualEntity.getType());
    assertTrue(actualAttributes.isEmpty());
    assertTrue(actualEntities.isEmpty());
  }
}
