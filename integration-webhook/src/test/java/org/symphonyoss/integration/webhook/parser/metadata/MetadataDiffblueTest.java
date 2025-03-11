package org.symphonyoss.integration.webhook.parser.metadata;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class MetadataDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Metadata}
   *   <li>{@link Metadata#setFields(List)}
   *   <li>{@link Metadata#setName(String)}
   *   <li>{@link Metadata#setObjects(List)}
   *   <li>{@link Metadata#setType(String)}
   *   <li>{@link Metadata#setVersion(String)}
   *   <li>{@link Metadata#toString()}
   *   <li>{@link Metadata#getFields()}
   *   <li>{@link Metadata#getName()}
   *   <li>{@link Metadata#getObjects()}
   *   <li>{@link Metadata#getType()}
   *   <li>{@link Metadata#getVersion()}
   * </ul>
   */
  @Test
  @MethodsUnderTest({"void Metadata.<init>()", "List Metadata.getFields()", "String Metadata.getName()",
      "List Metadata.getObjects()", "String Metadata.getType()", "String Metadata.getVersion()",
      "void Metadata.setFields(List)", "void Metadata.setName(String)", "void Metadata.setObjects(List)",
      "void Metadata.setType(String)", "void Metadata.setVersion(String)", "String Metadata.toString()"})
  public void testGettersAndSetters() {
    // Arrange and Act
    Metadata actualMetadata = new Metadata();
    ArrayList<MetadataField> fields = new ArrayList<>();
    actualMetadata.setFields(fields);
    actualMetadata.setName("Name");
    ArrayList<MetadataObject> objects = new ArrayList<>();
    actualMetadata.setObjects(objects);
    actualMetadata.setType("Type");
    actualMetadata.setVersion("1.0.2");
    String actualToStringResult = actualMetadata.toString();
    List<MetadataField> actualFields = actualMetadata.getFields();
    String actualName = actualMetadata.getName();
    List<MetadataObject> actualObjects = actualMetadata.getObjects();
    String actualType = actualMetadata.getType();

    // Assert
    assertEquals("1.0.2", actualMetadata.getVersion());
    assertEquals("Metadata{name='Name', type='Type', version='1.0.2', objects=[], fields=[]}", actualToStringResult);
    assertEquals("Name", actualName);
    assertEquals("Type", actualType);
    assertTrue(actualFields.isEmpty());
    assertTrue(actualObjects.isEmpty());
    assertSame(fields, actualFields);
    assertSame(objects, actualObjects);
  }
}
