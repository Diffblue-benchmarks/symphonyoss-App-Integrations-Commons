package org.symphonyoss.integration.utils;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.BinaryNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.junit.Test;
import org.symphonyoss.integration.model.stream.StreamType;

public class WebHookConfigurationUtilsDiffblueTest {
  /**
   * Test {@link WebHookConfigurationUtils#getStreams(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link WebHookConfigurationUtils#getStreams(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"List WebHookConfigurationUtils.getStreams(String)"})
  public void testGetStreams_when42_thenReturnEmpty() throws IOException {
    // Arrange and Act
    List<String> actualStreams = WebHookConfigurationUtils.getStreams("42");

    // Assert
    assertTrue(actualStreams.isEmpty());
  }

  /**
   * Test {@link WebHookConfigurationUtils#getStreams(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link WebHookConfigurationUtils#getStreams(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"List WebHookConfigurationUtils.getStreams(String)"})
  public void testGetStreams_whenNull_thenReturnEmpty() throws IOException {
    // Arrange and Act
    List<String> actualStreams = WebHookConfigurationUtils.getStreams(null);

    // Assert
    assertTrue(actualStreams.isEmpty());
  }

  /**
   * Test {@link WebHookConfigurationUtils#setRemovedStreams(JsonNode, List)}.
   *
   * <p>Method under test: {@link WebHookConfigurationUtils#setRemovedStreams(JsonNode, List)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"ObjectNode WebHookConfigurationUtils.setRemovedStreams(JsonNode, List)"})
  public void testSetRemovedStreams() throws IOException {
    // Arrange
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);

    ObjectNode optionalProperties = new ObjectNode(nc);
    optionalProperties.put(WebHookConfigurationUtils.REMOVED_STREAMS, DoubleNode.valueOf(10.0d));

    ArrayList<String> streams = new ArrayList<>();
    streams.add("");

    // Act and Assert
    Iterator<JsonNode> iteratorResult =
        WebHookConfigurationUtils.setRemovedStreams(optionalProperties, streams).iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof ArrayNode);
    Iterator<JsonNode> elementsResult = nextResult.elements();
    JsonNode nextResult2 = elementsResult.next();
    assertTrue(nextResult2 instanceof TextNode);
    JsonParser traverseResult = nextResult2.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    assertEquals(JsonNodeType.STRING, nextResult2.getNodeType());
    assertFalse(nextResult2.isNull());
    assertFalse(elementsResult.hasNext());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult2.isTextual());
    assertArrayEquals(new byte[] {}, traverseResult.getBinaryValue());
  }

  /**
   * Test {@link WebHookConfigurationUtils#setRemovedStreams(JsonNode, List)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>Then iterator next elements next return {@link NullNode}.
   * </ul>
   *
   * <p>Method under test: {@link WebHookConfigurationUtils#setRemovedStreams(JsonNode, List)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"ObjectNode WebHookConfigurationUtils.setRemovedStreams(JsonNode, List)"})
  public void testSetRemovedStreams_givenNull_thenIteratorNextElementsNextReturnNullNode()
      throws IOException {
    // Arrange
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);

    ObjectNode optionalProperties = new ObjectNode(nc);
    optionalProperties.put(WebHookConfigurationUtils.REMOVED_STREAMS, DoubleNode.valueOf(10.0d));

    ArrayList<String> streams = new ArrayList<>();
    streams.add(null);

    // Act and Assert
    Iterator<JsonNode> iteratorResult =
        WebHookConfigurationUtils.setRemovedStreams(optionalProperties, streams).iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof ArrayNode);
    Iterator<JsonNode> elementsResult = nextResult.elements();
    JsonNode nextResult2 = elementsResult.next();
    assertTrue(nextResult2 instanceof NullNode);
    JsonParser traverseResult = nextResult2.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    assertNull(traverseResult.getBinaryValue());
    assertEquals(JsonNodeType.NULL, nextResult2.getNodeType());
    assertFalse(nextResult2.isTextual());
    assertFalse(elementsResult.hasNext());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult2.isNull());
  }

  /**
   * Test {@link WebHookConfigurationUtils#setRemovedStreams(JsonNode, List)}.
   *
   * <ul>
   *   <li>Given {@code Streams}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code Streams}.
   * </ul>
   *
   * <p>Method under test: {@link WebHookConfigurationUtils#setRemovedStreams(JsonNode, List)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"ObjectNode WebHookConfigurationUtils.setRemovedStreams(JsonNode, List)"})
  public void testSetRemovedStreams_givenStreams_whenArrayListAddStreams() throws IOException {
    // Arrange
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);

    ObjectNode optionalProperties = new ObjectNode(nc);
    optionalProperties.put(WebHookConfigurationUtils.REMOVED_STREAMS, DoubleNode.valueOf(10.0d));

    ArrayList<String> streams = new ArrayList<>();
    streams.add("Streams");

    // Act and Assert
    Iterator<JsonNode> iteratorResult =
        WebHookConfigurationUtils.setRemovedStreams(optionalProperties, streams).iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof ArrayNode);
    Iterator<JsonNode> elementsResult = nextResult.elements();
    JsonNode nextResult2 = elementsResult.next();
    assertTrue(nextResult2 instanceof TextNode);
    assertEquals(JsonNodeType.STRING, nextResult2.getNodeType());
    assertFalse(nextResult2.isNull());
    assertFalse(elementsResult.hasNext());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult2.isTextual());
  }

  /**
   * Test {@link WebHookConfigurationUtils#getStreamType(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@code NONE}.
   * </ul>
   *
   * <p>Method under test: {@link WebHookConfigurationUtils#getStreamType(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"StreamType WebHookConfigurationUtils.getStreamType(String)"})
  public void testGetStreamType_when42_thenReturnNone() throws IOException {
    // Arrange, Act and Assert
    assertEquals(StreamType.NONE, WebHookConfigurationUtils.getStreamType("42"));
  }

  /**
   * Test {@link WebHookConfigurationUtils#getStreamType(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code NONE}.
   * </ul>
   *
   * <p>Method under test: {@link WebHookConfigurationUtils#getStreamType(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"StreamType WebHookConfigurationUtils.getStreamType(String)"})
  public void testGetStreamType_whenNull_thenReturnNone() throws IOException {
    // Arrange, Act and Assert
    assertEquals(StreamType.NONE, WebHookConfigurationUtils.getStreamType(null));
  }

  /**
   * Test {@link WebHookConfigurationUtils#getOwner(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return longValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link WebHookConfigurationUtils#getOwner(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Long WebHookConfigurationUtils.getOwner(String)"})
  public void testGetOwner_when42_thenReturnLongValueIsZero() throws IOException {
    // Arrange, Act and Assert
    assertEquals(0L, WebHookConfigurationUtils.getOwner("42").longValue());
  }

  /**
   * Test {@link WebHookConfigurationUtils#getOwner(String)}.
   *
   * <ul>
   *   <li>When {@code 4242}.
   *   <li>Then return longValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link WebHookConfigurationUtils#getOwner(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Long WebHookConfigurationUtils.getOwner(String)"})
  public void testGetOwner_when4242_thenReturnLongValueIsZero() throws IOException {
    // Arrange, Act and Assert
    assertEquals(0L, WebHookConfigurationUtils.getOwner("4242").longValue());
  }

  /**
   * Test {@link WebHookConfigurationUtils#getOwner(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link WebHookConfigurationUtils#getOwner(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Long WebHookConfigurationUtils.getOwner(String)"})
  public void testGetOwner_whenNull_thenReturnNull() throws IOException {
    // Arrange, Act and Assert
    assertNull(WebHookConfigurationUtils.getOwner(null));
  }

  /**
   * Test {@link WebHookConfigurationUtils#getSupportedNotifications(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link WebHookConfigurationUtils#getSupportedNotifications(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"List WebHookConfigurationUtils.getSupportedNotifications(String)"})
  public void testGetSupportedNotifications_when42_thenReturnEmpty() throws IOException {
    // Arrange and Act
    List<String> actualSupportedNotifications =
        WebHookConfigurationUtils.getSupportedNotifications("42");

    // Assert
    assertTrue(actualSupportedNotifications.isEmpty());
  }

  /**
   * Test {@link WebHookConfigurationUtils#getSupportedNotifications(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link WebHookConfigurationUtils#getSupportedNotifications(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"List WebHookConfigurationUtils.getSupportedNotifications(String)"})
  public void testGetSupportedNotifications_whenNull_thenReturnEmpty() throws IOException {
    // Arrange and Act
    List<String> actualSupportedNotifications =
        WebHookConfigurationUtils.getSupportedNotifications(null);

    // Assert
    assertTrue(actualSupportedNotifications.isEmpty());
  }

  /**
   * Test {@link WebHookConfigurationUtils#toJsonString(JsonNode)}.
   *
   * <p>Method under test: {@link WebHookConfigurationUtils#toJsonString(JsonNode)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebHookConfigurationUtils.toJsonString(JsonNode)"})
  public void testToJsonString() throws JsonProcessingException {
    // Arrange
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);

    ArrayNode jsonCandidate = new ArrayNode(nf);
    jsonCandidate.addArray();

    // Act and Assert
    assertEquals("[[]]", WebHookConfigurationUtils.toJsonString(jsonCandidate));
  }

  /**
   * Test {@link WebHookConfigurationUtils#toJsonString(JsonNode)}.
   *
   * <p>Method under test: {@link WebHookConfigurationUtils#toJsonString(JsonNode)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebHookConfigurationUtils.toJsonString(JsonNode)"})
  public void testToJsonString2() throws JsonProcessingException {
    // Arrange
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);

    ArrayNode jsonCandidate = new ArrayNode(nf);
    jsonCandidate.addObject();

    // Act and Assert
    assertEquals("[{}]", WebHookConfigurationUtils.toJsonString(jsonCandidate));
  }

  /**
   * Test {@link WebHookConfigurationUtils#toJsonString(JsonNode)}.
   *
   * <ul>
   *   <li>Given forty-two.
   *   <li>Then return {@code [42]}.
   * </ul>
   *
   * <p>Method under test: {@link WebHookConfigurationUtils#toJsonString(JsonNode)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebHookConfigurationUtils.toJsonString(JsonNode)"})
  public void testToJsonString_givenFortyTwo_thenReturn42() throws JsonProcessingException {
    // Arrange
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);

    ArrayNode jsonCandidate = new ArrayNode(nf);
    jsonCandidate.addPOJO(42);

    // Act and Assert
    assertEquals("[42]", WebHookConfigurationUtils.toJsonString(jsonCandidate));
  }

  /**
   * Test {@link WebHookConfigurationUtils#toJsonString(JsonNode)}.
   *
   * <ul>
   *   <li>Given {@code Value}.
   *   <li>Then return {@code ["Value"]}.
   * </ul>
   *
   * <p>Method under test: {@link WebHookConfigurationUtils#toJsonString(JsonNode)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebHookConfigurationUtils.toJsonString(JsonNode)"})
  public void testToJsonString_givenValue_thenReturnValue() throws JsonProcessingException {
    // Arrange
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);

    ArrayNode jsonCandidate = new ArrayNode(nf);
    jsonCandidate.addPOJO("Value");

    // Act and Assert
    assertEquals("[\"Value\"]", WebHookConfigurationUtils.toJsonString(jsonCandidate));
  }

  /**
   * Test {@link WebHookConfigurationUtils#toJsonString(JsonNode)}.
   *
   * <ul>
   *   <li>Then return {@code [null]}.
   * </ul>
   *
   * <p>Method under test: {@link WebHookConfigurationUtils#toJsonString(JsonNode)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebHookConfigurationUtils.toJsonString(JsonNode)"})
  public void testToJsonString_thenReturnNull() throws JsonProcessingException {
    // Arrange
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);

    ArrayNode jsonCandidate = new ArrayNode(nf);
    jsonCandidate.addNull();

    // Act and Assert
    assertEquals("[null]", WebHookConfigurationUtils.toJsonString(jsonCandidate));
  }

  /**
   * Test {@link WebHookConfigurationUtils#toJsonString(JsonNode)}.
   *
   * <ul>
   *   <li>Then return {@code "QVhBWEFYQVg="}.
   * </ul>
   *
   * <p>Method under test: {@link WebHookConfigurationUtils#toJsonString(JsonNode)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebHookConfigurationUtils.toJsonString(JsonNode)"})
  public void testToJsonString_thenReturnQVhBWEFYQVg()
      throws JsonProcessingException, UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(
        "\"QVhBWEFYQVg=\"",
        WebHookConfigurationUtils.toJsonString(new BinaryNode("AXAXAXAX".getBytes("UTF-8"))));
  }

  /**
   * Test {@link WebHookConfigurationUtils#toJsonString(JsonNode)}.
   *
   * <ul>
   *   <li>When {@link ArrayNode#ArrayNode(JsonNodeFactory)} with nf is withExactBigDecimals {@code
   *       true}.
   * </ul>
   *
   * <p>Method under test: {@link WebHookConfigurationUtils#toJsonString(JsonNode)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebHookConfigurationUtils.toJsonString(JsonNode)"})
  public void testToJsonString_whenArrayNodeWithNfIsWithExactBigDecimalsTrue()
      throws JsonProcessingException {
    // Arrange
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);

    // Act and Assert
    assertEquals("[]", WebHookConfigurationUtils.toJsonString(new ArrayNode(nf)));
  }

  /**
   * Test {@link WebHookConfigurationUtils#toJsonString(JsonNode)}.
   *
   * <ul>
   *   <li>When {@link ArrayNode#ArrayNode(JsonNodeFactory, int)} with nf is withExactBigDecimals
   *       {@code true} and capacity is three.
   * </ul>
   *
   * <p>Method under test: {@link WebHookConfigurationUtils#toJsonString(JsonNode)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebHookConfigurationUtils.toJsonString(JsonNode)"})
  public void testToJsonString_whenArrayNodeWithNfIsWithExactBigDecimalsTrueAndCapacityIsThree()
      throws JsonProcessingException {
    // Arrange
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);

    // Act and Assert
    assertEquals("[]", WebHookConfigurationUtils.toJsonString(new ArrayNode(nf, 3)));
  }

  /**
   * Test {@link WebHookConfigurationUtils#toJsonString(JsonNode)}.
   *
   * <ul>
   *   <li>When Instance.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link WebHookConfigurationUtils#toJsonString(JsonNode)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebHookConfigurationUtils.toJsonString(JsonNode)"})
  public void testToJsonString_whenInstance_thenReturnNull() throws JsonProcessingException {
    // Arrange, Act and Assert
    assertEquals("null", WebHookConfigurationUtils.toJsonString(MissingNode.getInstance()));
  }

  /**
   * Test {@link WebHookConfigurationUtils#toJsonString(JsonNode)}.
   *
   * <ul>
   *   <li>When Instance.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link WebHookConfigurationUtils#toJsonString(JsonNode)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebHookConfigurationUtils.toJsonString(JsonNode)"})
  public void testToJsonString_whenInstance_thenReturnNull2() throws JsonProcessingException {
    // Arrange, Act and Assert
    assertEquals("null", WebHookConfigurationUtils.toJsonString(NullNode.getInstance()));
  }

  /**
   * Test {@link WebHookConfigurationUtils#toJsonString(JsonNode)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link WebHookConfigurationUtils#toJsonString(JsonNode)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebHookConfigurationUtils.toJsonString(JsonNode)"})
  public void testToJsonString_whenNull_thenReturnNull() throws JsonProcessingException {
    // Arrange, Act and Assert
    assertEquals("null", WebHookConfigurationUtils.toJsonString(null));
  }

  /**
   * Test {@link WebHookConfigurationUtils#toJsonString(JsonNode)}.
   *
   * <ul>
   *   <li>When valueOf ten.
   *   <li>Then return {@code 10.0}.
   * </ul>
   *
   * <p>Method under test: {@link WebHookConfigurationUtils#toJsonString(JsonNode)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebHookConfigurationUtils.toJsonString(JsonNode)"})
  public void testToJsonString_whenValueOfTen_thenReturn100() throws JsonProcessingException {
    // Arrange, Act and Assert
    assertEquals("10.0", WebHookConfigurationUtils.toJsonString(DoubleNode.valueOf(10.0d)));
  }
}
