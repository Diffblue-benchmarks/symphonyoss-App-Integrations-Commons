package org.symphonyoss.integration.api.client.json;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Variant;
import org.junit.Test;
import org.symphonyoss.integration.exception.RemoteApiException;

public class JsonEntitySerializerDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of
   * {@link JsonEntitySerializer}
   */
  @Test
  public void testNewJsonEntitySerializer() throws RemoteApiException {
    // Arrange and Act
    Entity<String> actualSerializeResult = (new JsonEntitySerializer()).serialize("Input");

    // Assert
    assertEquals("\"Input\"", actualSerializeResult.getEntity());
    MediaType mediaType = actualSerializeResult.getMediaType();
    assertEquals("application", mediaType.getType());
    assertEquals("json", mediaType.getSubtype());
    assertNull(actualSerializeResult.getEncoding());
    Variant variant = actualSerializeResult.getVariant();
    assertNull(variant.getEncoding());
    assertNull(variant.getLanguageString());
    assertNull(actualSerializeResult.getLanguage());
    assertNull(variant.getLanguage());
    assertEquals(0, actualSerializeResult.getAnnotations().length);
    assertFalse(mediaType.isWildcardSubtype());
    assertFalse(mediaType.isWildcardType());
    assertTrue(mediaType.getParameters().isEmpty());
    assertSame(mediaType, variant.getMediaType());
  }

  /**
   * Method under test: {@link JsonEntitySerializer#serialize(Object)}
   */
  @Test
  public void testSerialize() throws RemoteApiException {
    // Arrange and Act
    Entity<String> actualSerializeResult = (new JsonEntitySerializer()).serialize("Input");

    // Assert
    assertEquals("\"Input\"", actualSerializeResult.getEntity());
    MediaType mediaType = actualSerializeResult.getMediaType();
    assertEquals("application", mediaType.getType());
    assertEquals("json", mediaType.getSubtype());
    assertNull(actualSerializeResult.getEncoding());
    Variant variant = actualSerializeResult.getVariant();
    assertNull(variant.getEncoding());
    assertNull(variant.getLanguageString());
    assertNull(actualSerializeResult.getLanguage());
    assertNull(variant.getLanguage());
    assertEquals(0, actualSerializeResult.getAnnotations().length);
    assertFalse(mediaType.isWildcardSubtype());
    assertFalse(mediaType.isWildcardType());
    assertTrue(mediaType.getParameters().isEmpty());
    assertSame(mediaType, variant.getMediaType());
  }

  /**
   * Method under test: {@link JsonEntitySerializer#serialize(Object)}
   */
  @Test
  public void testSerialize2() throws RemoteApiException {
    // Arrange and Act
    Entity<String> actualSerializeResult = (new JsonEntitySerializer()).serialize(null);

    // Assert
    MediaType mediaType = actualSerializeResult.getMediaType();
    assertEquals("application", mediaType.getType());
    assertEquals("json", mediaType.getSubtype());
    assertNull(actualSerializeResult.getEncoding());
    assertNull(actualSerializeResult.getEntity());
    Variant variant = actualSerializeResult.getVariant();
    assertNull(variant.getEncoding());
    assertNull(variant.getLanguageString());
    assertNull(actualSerializeResult.getLanguage());
    assertNull(variant.getLanguage());
    assertEquals(0, actualSerializeResult.getAnnotations().length);
    assertFalse(mediaType.isWildcardSubtype());
    assertFalse(mediaType.isWildcardType());
    assertTrue(mediaType.getParameters().isEmpty());
    assertSame(mediaType, variant.getMediaType());
  }
}
