package org.symphonyoss.integration.api.client.form;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Map;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Variant;
import org.junit.Test;
import org.symphonyoss.integration.exception.RemoteApiException;

public class MultiPartEntitySerializerDiffblueTest {
  /**
   * Test {@link MultiPartEntitySerializer#serialize(Object)}.
   *
   * <p>Method under test: {@link MultiPartEntitySerializer#serialize(Object)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity MultiPartEntitySerializer.serialize(Object)"})
  public void testSerialize() throws RemoteApiException {
    // Arrange and Act
    Entity actualSerializeResult = new MultiPartEntitySerializer().serialize("Input");

    // Assert
    assertEquals("Input", actualSerializeResult.getEntity());
    MediaType mediaType = actualSerializeResult.getMediaType();
    assertEquals("form-data", mediaType.getSubtype());
    assertEquals("multipart", mediaType.getType());
    assertNull(actualSerializeResult.getEncoding());
    Variant variant = actualSerializeResult.getVariant();
    assertNull(variant.getEncoding());
    assertNull(variant.getLanguageString());
    assertNull(actualSerializeResult.getLanguage());
    assertNull(variant.getLanguage());
    assertEquals(0, actualSerializeResult.getAnnotations().length);
    Map<String, String> parameters = mediaType.getParameters();
    assertEquals(1, parameters.size());
    assertFalse(mediaType.isWildcardSubtype());
    assertFalse(mediaType.isWildcardType());
    assertTrue(parameters.containsKey("boundary"));
    assertSame(mediaType, variant.getMediaType());
  }
}
