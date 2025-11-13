package org.symphonyoss.integration.api.client.json;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Variant;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.symphonyoss.integration.exception.RemoteApiException;

@RunWith(MockitoJUnitRunner.class)
public class JsonEntitySerializerDiffblueTest {
  @InjectMocks private JsonEntitySerializer jsonEntitySerializer;

  @Mock private JsonUtils jsonUtils;

  @Rule public ExpectedException thrown = ExpectedException.none();

  /**
   * Test {@link JsonEntitySerializer#serialize(Object)}.
   *
   * <ul>
   *   <li>Given {@link JsonEntitySerializer} (default constructor).
   *   <li>Then return Entity is {@code "Input"}.
   * </ul>
   *
   * <p>Method under test: {@link JsonEntitySerializer#serialize(Object)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity JsonEntitySerializer.serialize(Object)"})
  public void testSerialize_givenJsonEntitySerializer_thenReturnEntityIsInput()
      throws RemoteApiException {
    // Arrange and Act
    Entity<String> actualSerializeResult = new JsonEntitySerializer().serialize("Input");

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
   * Test {@link JsonEntitySerializer#serialize(Object)}.
   *
   * <ul>
   *   <li>Given {@link JsonUtils} {@link JsonUtils#serialize(Object)} return {@code Serialize}.
   *   <li>Then return Entity is {@code Serialize}.
   * </ul>
   *
   * <p>Method under test: {@link JsonEntitySerializer#serialize(Object)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity JsonEntitySerializer.serialize(Object)"})
  public void testSerialize_givenJsonUtilsSerializeReturnSerialize_thenReturnEntityIsSerialize()
      throws RemoteApiException {
    // Arrange
    when(jsonUtils.serialize(Mockito.<Object>any())).thenReturn("Serialize");

    // Act
    Entity<String> actualSerializeResult = jsonEntitySerializer.serialize("Input");

    // Assert
    verify(jsonUtils).serialize(isA(Object.class));
    assertEquals("Serialize", actualSerializeResult.getEntity());
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
   * Test {@link JsonEntitySerializer#serialize(Object)}.
   *
   * <ul>
   *   <li>Then throw {@link RemoteApiException}.
   * </ul>
   *
   * <p>Method under test: {@link JsonEntitySerializer#serialize(Object)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity JsonEntitySerializer.serialize(Object)"})
  public void testSerialize_thenThrowRemoteApiException() throws RemoteApiException {
    // Arrange
    when(jsonUtils.serialize(Mockito.<Object>any()))
        .thenThrow(new RemoteApiException(1, "An error occurred"));

    // Act and Assert
    thrown.expect(RemoteApiException.class);
    jsonEntitySerializer.serialize("Input");
    verify(jsonUtils).serialize(isA(Object.class));
  }

  /**
   * Test new {@link JsonEntitySerializer} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link JsonEntitySerializer}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonEntitySerializer.<init>()"})
  public void testNewJsonEntitySerializer() throws RemoteApiException {
    // Arrange and Act
    Entity<String> actualSerializeResult = new JsonEntitySerializer().serialize("Input");

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
}
