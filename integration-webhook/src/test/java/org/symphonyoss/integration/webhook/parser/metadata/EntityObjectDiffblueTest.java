package org.symphonyoss.integration.webhook.parser.metadata;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import java.util.Map;
import org.junit.Test;

public class EntityObjectDiffblueTest {
  /**
   * Method under test: {@link EntityObject#addContent(String, Object)}
   */
  @Test
  public void testAddContent() {
    // Arrange
    EntityObject entityObject = new EntityObject("Type", "1.0.2");

    // Act
    entityObject.addContent("Key", "Content");

    // Assert
    Map<String, Object> content = entityObject.getContent();
    assertEquals(1, content.size());
    assertEquals("Content", content.get("Key"));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EntityObject#EntityObject()}
   *   <li>{@link EntityObject#getContent()}
   *   <li>{@link EntityObject#getType()}
   *   <li>{@link EntityObject#getVersion()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    EntityObject actualEntityObject = new EntityObject();
    Map<String, Object> actualContent = actualEntityObject.getContent();
    String actualType = actualEntityObject.getType();

    // Assert
    assertNull(actualType);
    assertNull(actualEntityObject.getVersion());
    assertTrue(actualContent.isEmpty());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EntityObject#EntityObject(String, String)}
   *   <li>{@link EntityObject#getContent()}
   *   <li>{@link EntityObject#getType()}
   *   <li>{@link EntityObject#getVersion()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters2() {
    // Arrange and Act
    EntityObject actualEntityObject = new EntityObject("Type", "1.0.2");
    Map<String, Object> actualContent = actualEntityObject.getContent();
    String actualType = actualEntityObject.getType();

    // Assert
    assertEquals("1.0.2", actualEntityObject.getVersion());
    assertEquals("Type", actualType);
    assertTrue(actualContent.isEmpty());
  }
}
