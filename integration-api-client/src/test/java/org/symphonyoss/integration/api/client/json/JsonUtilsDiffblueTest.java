package org.symphonyoss.integration.api.client.json;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
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
public class JsonUtilsDiffblueTest {
  @InjectMocks private JsonUtils jsonUtils;

  @Mock private ObjectMapper objectMapper;

  @Rule public ExpectedException thrown = ExpectedException.none();

  /**
   * Test new {@link JsonUtils} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link JsonUtils}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonUtils.<init>()"})
  public void testNewJsonUtils() throws RemoteApiException {
    // Arrange, Act and Assert
    assertEquals("\"Obj\"", new JsonUtils().serialize("Obj"));
  }

  /**
   * Test {@link JsonUtils#serialize(Object)}.
   *
   * <ul>
   *   <li>Given {@link JsonUtils} (default constructor).
   *   <li>When forty-two.
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link JsonUtils#serialize(Object)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonUtils.serialize(Object)"})
  public void testSerialize_givenJsonUtils_whenFortyTwo_thenReturn42() throws RemoteApiException {
    // Arrange, Act and Assert
    assertEquals("42", new JsonUtils().serialize(42));
  }

  /**
   * Test {@link JsonUtils#serialize(Object)}.
   *
   * <ul>
   *   <li>Given {@link JsonUtils} (default constructor).
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JsonUtils#serialize(Object)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonUtils.serialize(Object)"})
  public void testSerialize_givenJsonUtils_whenNull_thenReturnNull() throws RemoteApiException {
    // Arrange, Act and Assert
    assertNull(new JsonUtils().serialize(null));
  }

  /**
   * Test {@link JsonUtils#serialize(Object)}.
   *
   * <ul>
   *   <li>Given {@link JsonUtils} (default constructor).
   *   <li>When {@code Obj}.
   *   <li>Then return {@code "Obj"}.
   * </ul>
   *
   * <p>Method under test: {@link JsonUtils#serialize(Object)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonUtils.serialize(Object)"})
  public void testSerialize_givenJsonUtils_whenObj_thenReturnObj() throws RemoteApiException {
    // Arrange, Act and Assert
    assertEquals("\"Obj\"", new JsonUtils().serialize("Obj"));
  }

  /**
   * Test {@link JsonUtils#serialize(Object)}.
   *
   * <ul>
   *   <li>Then calls {@link ObjectMapper#writeValueAsString(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link JsonUtils#serialize(Object)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonUtils.serialize(Object)"})
  public void testSerialize_thenCallsWriteValueAsString()
      throws JsonProcessingException, RemoteApiException {
    // Arrange
    when(objectMapper.writeValueAsString(Mockito.<Object>any())).thenReturn("42");

    // Act
    String actualSerializeResult = jsonUtils.serialize("Obj");

    // Assert
    verify(objectMapper).writeValueAsString(isA(Object.class));
    assertEquals("42", actualSerializeResult);
  }

  /**
   * Test {@link JsonUtils#deserialize(String, Class)}.
   *
   * <ul>
   *   <li>Given {@link JsonUtils} (default constructor).
   *   <li>When {@code 42}.
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link JsonUtils#deserialize(String, Class)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonUtils.deserialize(String, Class)"})
  public void testDeserialize_givenJsonUtils_when42_thenReturn42() throws RemoteApiException {
    // Arrange
    JsonUtils jsonUtils = new JsonUtils();
    Class<String> returnType = String.class;

    // Act and Assert
    assertEquals("42", jsonUtils.deserialize("42", returnType));
  }

  /**
   * Test {@link JsonUtils#deserialize(String, Class)}.
   *
   * <ul>
   *   <li>Given {@link JsonUtils} (default constructor).
   *   <li>When {@code 42}.
   *   <li>Then return intValue is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link JsonUtils#deserialize(String, Class)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonUtils.deserialize(String, Class)"})
  public void testDeserialize_givenJsonUtils_when42_thenReturnIntValueIsFortyTwo()
      throws RemoteApiException {
    // Arrange
    JsonUtils jsonUtils = new JsonUtils();
    Class<Object> returnType = Object.class;

    // Act and Assert
    assertEquals(42, ((Integer) jsonUtils.deserialize("42", returnType)).intValue());
  }

  /**
   * Test {@link JsonUtils#deserialize(String, Class)}.
   *
   * <ul>
   *   <li>Given {@link JsonUtils} (default constructor).
   *   <li>When lf.
   *   <li>Then throw {@link RemoteApiException}.
   * </ul>
   *
   * <p>Method under test: {@link JsonUtils#deserialize(String, Class)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonUtils.deserialize(String, Class)"})
  public void testDeserialize_givenJsonUtils_whenLf_thenThrowRemoteApiException()
      throws RemoteApiException {
    // Arrange
    JsonUtils jsonUtils = new JsonUtils();
    Class<Object> returnType = Object.class;

    // Act and Assert
    thrown.expect(RemoteApiException.class);
    jsonUtils.deserialize("\n", returnType);
  }

  /**
   * Test {@link JsonUtils#deserialize(String, Class)}.
   *
   * <ul>
   *   <li>Given {@link ObjectMapper} {@link ObjectMapper#readValue(String, Class)} return {@code
   *       Value}.
   *   <li>Then return {@code Value}.
   * </ul>
   *
   * <p>Method under test: {@link JsonUtils#deserialize(String, Class)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonUtils.deserialize(String, Class)"})
  public void testDeserialize_givenObjectMapperReadValueReturnValue_thenReturnValue()
      throws IOException, RemoteApiException {
    // Arrange
    when(objectMapper.readValue(Mockito.<String>any(), Mockito.<Class<Object>>any()))
        .thenReturn("Value");
    Class<Object> returnType = Object.class;

    // Act
    Object actualDeserializeResult =
        jsonUtils.deserialize("Not all who wander are lost", returnType);

    // Assert
    verify(objectMapper).readValue(Mockito.<String>any(), isA(Class.class));
    assertEquals("Value", actualDeserializeResult);
  }

  /**
   * Test {@link JsonUtils#deserialize(String, Class)}.
   *
   * <ul>
   *   <li>Given {@link ObjectMapper} {@link ObjectMapper#readValue(String, Class)} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link JsonUtils#deserialize(String, Class)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonUtils.deserialize(String, Class)"})
  public void testDeserialize_givenObjectMapperReadValueThrowRuntimeException()
      throws IOException, RemoteApiException {
    // Arrange
    when(objectMapper.readValue(Mockito.<String>any(), Mockito.<Class<Object>>any()))
        .thenThrow(new RuntimeException());
    Class<Object> returnType = Object.class;

    // Act and Assert
    thrown.expect(RemoteApiException.class);
    jsonUtils.deserialize("Not all who wander are lost", returnType);
    verify(objectMapper).readValue(Mockito.<String>any(), isA(Class.class));
  }

  /**
   * Test {@link JsonUtils#deserialize(String, Class)}.
   *
   * <ul>
   *   <li>When {@code String}.
   *   <li>Then return {@code Not all who wander are lost}.
   * </ul>
   *
   * <p>Method under test: {@link JsonUtils#deserialize(String, Class)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonUtils.deserialize(String, Class)"})
  public void testDeserialize_whenJavaLangString_thenReturnNotAllWhoWanderAreLost()
      throws RemoteApiException {
    // Arrange
    JsonUtils jsonUtils = new JsonUtils();
    Class<String> returnType = String.class;

    // Act and Assert
    assertEquals(
        "Not all who wander are lost",
        jsonUtils.deserialize("Not all who wander are lost", returnType));
  }

  /**
   * Test {@link JsonUtils#deserialize(String, Class)}.
   *
   * <ul>
   *   <li>When {@code Not all who wander are lost}.
   *   <li>Then throw {@link RemoteApiException}.
   * </ul>
   *
   * <p>Method under test: {@link JsonUtils#deserialize(String, Class)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonUtils.deserialize(String, Class)"})
  public void testDeserialize_whenNotAllWhoWanderAreLost_thenThrowRemoteApiException()
      throws RemoteApiException {
    // Arrange
    JsonUtils jsonUtils = new JsonUtils();
    Class<Object> returnType = Object.class;

    // Act and Assert
    thrown.expect(RemoteApiException.class);
    jsonUtils.deserialize("Not all who wander are lost", returnType);
  }
}
