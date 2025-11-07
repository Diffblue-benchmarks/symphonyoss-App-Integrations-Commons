package org.symphonyoss.integration.webhook.parser.metadata;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import java.util.Map;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.symphonyoss.integration.webhook.exception.MetadataParserException;

public class MetadataFieldDiffblueTest {
  @Rule
  public ExpectedException thrown = ExpectedException.none();

  /**
   * Method under test: {@link MetadataField#process(EntityObject, JsonNode)}
   */
  @Test
  public void testProcess() {
    // Arrange
    MetadataField metadataField = new MetadataField();
    metadataField.setValue("42");
    EntityObject root = new EntityObject("Type", "1.0.2");

    // Act
    metadataField.process(root, DoubleNode.valueOf(10.0d));

    // Assert that nothing has changed
    assertTrue(root.getContent().isEmpty());
  }

  /**
   * Method under test: {@link MetadataField#process(EntityObject, JsonNode)}
   */
  @Test
  public void testProcess2() {
    // Arrange
    MetadataField metadataField = new MetadataField();
    metadataField.setValue("\\.");
    EntityObject root = new EntityObject("Type", "1.0.2");

    // Act
    metadataField.process(root, DoubleNode.valueOf(10.0d));

    // Assert that nothing has changed
    assertTrue(root.getContent().isEmpty());
  }

  /**
   * Method under test: {@link MetadataField#process(EntityObject, JsonNode)}
   */
  @Test
  public void testProcess3() {
    // Arrange
    MetadataField metadataField = new MetadataField();
    metadataField.setBlank(true);
    metadataField.setValue("\\.");
    EntityObject root = new EntityObject("Type", "1.0.2");

    // Act
    metadataField.process(root, DoubleNode.valueOf(10.0d));

    // Assert
    Map<String, Object> content = root.getContent();
    assertEquals(1, content.size());
    assertEquals("", content.get(null));
  }

  /**
   * Method under test: {@link MetadataField#process(EntityObject, JsonNode)}
   */
  @Test
  public void testProcess4() {
    // Arrange
    MetadataField metadataField = new MetadataField();
    metadataField.setType(null);
    metadataField.setValue("\\.");
    EntityObject root = new EntityObject("Type", "1.0.2");

    // Act and Assert
    thrown.expect(MetadataParserException.class);
    metadataField.process(root, DoubleNode.valueOf(10.0d));
  }
}
