package org.symphonyoss.integration.webhook.parser.metadata;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Map;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class EntityObjectDiffblueTest {
  /**
   * Test getters and setters.
   * <ul>
   *   <li>Then return Type is {@code null}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityObject#EntityObject()}
   *   <li>{@link EntityObject#getContent()}
   *   <li>{@link EntityObject#getType()}
   *   <li>{@link EntityObject#getVersion()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void EntityObject.<init>()", "void EntityObject.<init>(String, String)",
      "Map EntityObject.getContent()", "String EntityObject.getType()", "String EntityObject.getVersion()"})
  public void testGettersAndSetters_thenReturnTypeIsNull() {
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
   * Test getters and setters.
   * <ul>
   *   <li>When {@code Type}.</li>
   *   <li>Then return Version is {@code 1.0.2}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityObject#EntityObject(String, String)}
   *   <li>{@link EntityObject#getContent()}
   *   <li>{@link EntityObject#getType()}
   *   <li>{@link EntityObject#getVersion()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void EntityObject.<init>()", "void EntityObject.<init>(String, String)",
      "Map EntityObject.getContent()", "String EntityObject.getType()", "String EntityObject.getVersion()"})
  public void testGettersAndSetters_whenType_thenReturnVersionIs102() {
    // Arrange and Act
    EntityObject actualEntityObject = new EntityObject("Type", "1.0.2");
    Map<String, Object> actualContent = actualEntityObject.getContent();
    String actualType = actualEntityObject.getType();

    // Assert
    assertEquals("1.0.2", actualEntityObject.getVersion());
    assertEquals("Type", actualType);
    assertTrue(actualContent.isEmpty());
  }

  /**
   * Test {@link EntityObject#addContent(String, Object)}.
   * <p>
   * Method under test: {@link EntityObject#addContent(String, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void EntityObject.addContent(String, Object)"})
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
}
