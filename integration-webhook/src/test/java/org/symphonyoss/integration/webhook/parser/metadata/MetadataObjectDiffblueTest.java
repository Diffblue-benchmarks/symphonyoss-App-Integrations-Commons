package org.symphonyoss.integration.webhook.parser.metadata;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class MetadataObjectDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link MetadataObject}
   *   <li>{@link MetadataObject#setChildren(List)}
   *   <li>{@link MetadataObject#setFields(List)}
   *   <li>{@link MetadataObject#setId(String)}
   *   <li>{@link MetadataObject#setList(boolean)}
   *   <li>{@link MetadataObject#setType(String)}
   *   <li>{@link MetadataObject#setVersion(String)}
   *   <li>{@link MetadataObject#toString()}
   *   <li>{@link MetadataObject#getChildren()}
   *   <li>{@link MetadataObject#getFields()}
   *   <li>{@link MetadataObject#getId()}
   *   <li>{@link MetadataObject#getType()}
   *   <li>{@link MetadataObject#getVersion()}
   *   <li>{@link MetadataObject#isList()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    MetadataObject actualMetadataObject = new MetadataObject();
    ArrayList<MetadataObject> children = new ArrayList<>();
    actualMetadataObject.setChildren(children);
    ArrayList<MetadataField> fields = new ArrayList<>();
    actualMetadataObject.setFields(fields);
    actualMetadataObject.setId("42");
    actualMetadataObject.setList(true);
    actualMetadataObject.setType("Type");
    actualMetadataObject.setVersion("1.0.2");
    String actualToStringResult = actualMetadataObject.toString();
    List<MetadataObject> actualChildren = actualMetadataObject.getChildren();
    List<MetadataField> actualFields = actualMetadataObject.getFields();
    String actualId = actualMetadataObject.getId();
    String actualType = actualMetadataObject.getType();
    String actualVersion = actualMetadataObject.getVersion();
    boolean actualIsListResult = actualMetadataObject.isList();

    // Assert that nothing has changed
    assertEquals("1.0.2", actualVersion);
    assertEquals("42", actualId);
    assertEquals("MetadataObject{id='42', type='Type', version='1.0.2', list='true', fields=[], children=[]}",
        actualToStringResult);
    assertEquals("Type", actualType);
    assertTrue(actualChildren.isEmpty());
    assertTrue(actualFields.isEmpty());
    assertTrue(actualIsListResult);
    assertSame(children, actualChildren);
    assertSame(fields, actualFields);
  }
}
