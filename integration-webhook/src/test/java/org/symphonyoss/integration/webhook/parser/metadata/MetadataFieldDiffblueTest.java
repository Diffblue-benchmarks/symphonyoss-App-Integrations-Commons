package org.symphonyoss.integration.webhook.parser.metadata;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import java.util.Map;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.symphonyoss.integration.webhook.exception.MetadataParserException;

public class MetadataFieldDiffblueTest {
  @Rule public ExpectedException thrown = ExpectedException.none();

  /**
   * Test {@link MetadataField#process(EntityObject, JsonNode)}.
   *
   * <ul>
   *   <li>Given {@link MetadataField} (default constructor) Type is {@code null}.
   *   <li>Then throw {@link MetadataParserException}.
   * </ul>
   *
   * <p>Method under test: {@link MetadataField#process(EntityObject, JsonNode)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"void MetadataField.process(EntityObject, JsonNode)"})
  public void testProcess_givenMetadataFieldTypeIsNull_thenThrowMetadataParserException() {
    // Arrange
    MetadataField metadataField = new MetadataField();
    metadataField.setType(null);
    metadataField.setValue("\\.");

    // Act and Assert
    thrown.expect(MetadataParserException.class);
    metadataField.process(new EntityObject("Type", "1.0.2"), DoubleNode.valueOf(10.0d));
  }

  /**
   * Test {@link MetadataField#process(EntityObject, JsonNode)}.
   *
   * <ul>
   *   <li>Then {@link EntityObject#EntityObject(String, String)} with {@code Type} and version is
   *       {@code 1.0.2} Content Empty.
   * </ul>
   *
   * <p>Method under test: {@link MetadataField#process(EntityObject, JsonNode)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"void MetadataField.process(EntityObject, JsonNode)"})
  public void testProcess_thenEntityObjectWithTypeAndVersionIs102ContentEmpty() {
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
   * Test {@link MetadataField#process(EntityObject, JsonNode)}.
   *
   * <ul>
   *   <li>Then {@link EntityObject#EntityObject(String, String)} with {@code Type} and version is
   *       {@code 1.0.2} Content Empty.
   * </ul>
   *
   * <p>Method under test: {@link MetadataField#process(EntityObject, JsonNode)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"void MetadataField.process(EntityObject, JsonNode)"})
  public void testProcess_thenEntityObjectWithTypeAndVersionIs102ContentEmpty2() {
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
   * Test {@link MetadataField#process(EntityObject, JsonNode)}.
   *
   * <ul>
   *   <li>Then {@link EntityObject#EntityObject(String, String)} with {@code Type} and version is
   *       {@code 1.0.2} Content {@code null} is empty string.
   * </ul>
   *
   * <p>Method under test: {@link MetadataField#process(EntityObject, JsonNode)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"void MetadataField.process(EntityObject, JsonNode)"})
  public void testProcess_thenEntityObjectWithTypeAndVersionIs102ContentNullIsEmptyString() {
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
}
