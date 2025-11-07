package org.symphonyoss.integration.api.client.json;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.symphonyoss.integration.exception.RemoteApiException;

public class JsonUtilsDiffblueTest {
  @Rule
  public ExpectedException thrown = ExpectedException.none();

  /**
   * Method under test: {@link JsonUtils#serialize(Object)}
   */
  @Test
  public void testSerialize() throws RemoteApiException {
    // Arrange, Act and Assert
    assertEquals("\"Obj\"", (new JsonUtils()).serialize("Obj"));
    assertNull((new JsonUtils()).serialize(null));
    assertEquals("42", (new JsonUtils()).serialize(42));
  }

  /**
   * Method under test: {@link JsonUtils#deserialize(String, Class)}
   */
  @Test
  public void testDeserialize() throws RemoteApiException {
    // Arrange
    JsonUtils jsonUtils = new JsonUtils();
    Class<Object> returnType = Object.class;

    // Act and Assert
    thrown.expect(RemoteApiException.class);
    jsonUtils.deserialize("Not all who wander are lost", returnType);
  }

  /**
   * Method under test: {@link JsonUtils#deserialize(String, Class)}
   */
  @Test
  public void testDeserialize2() throws RemoteApiException {
    // Arrange
    JsonUtils jsonUtils = new JsonUtils();
    Class<Object> returnType = Object.class;

    // Act and Assert
    thrown.expect(RemoteApiException.class);
    jsonUtils.deserialize("\n", returnType);
  }

  /**
   * Method under test: {@link JsonUtils#deserialize(String, Class)}
   */
  @Test
  public void testDeserialize3() throws RemoteApiException {
    // Arrange
    JsonUtils jsonUtils = new JsonUtils();
    Class<String> returnType = String.class;

    // Act and Assert
    assertEquals("Not all who wander are lost", jsonUtils.deserialize("Not all who wander are lost", returnType));
  }

  /**
   * Method under test: {@link JsonUtils#deserialize(String, Class)}
   */
  @Test
  public void testDeserialize4() throws RemoteApiException {
    // Arrange
    JsonUtils jsonUtils = new JsonUtils();
    Class<String> returnType = String.class;

    // Act and Assert
    assertEquals("42", jsonUtils.deserialize("42", returnType));
  }

  /**
   * Method under test: default or parameterless constructor of {@link JsonUtils}
   */
  @Test
  public void testNewJsonUtils() throws RemoteApiException {
    // Arrange, Act and Assert
    assertEquals("\"Obj\"", (new JsonUtils()).serialize("Obj"));
  }
}
