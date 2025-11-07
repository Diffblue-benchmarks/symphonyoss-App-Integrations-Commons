package org.symphonyoss.integration.json;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonStreamContext;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.IntNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import org.junit.Test;
import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties;
import org.symphonyoss.integration.authentication.api.model.JwtPayload;
import org.symphonyoss.integration.authorization.UserAuthorizationData;
import org.symphonyoss.integration.model.healthcheck.IntegrationFlags;

public class JsonUtilsDiffblueTest {
  /**
   * Method under test: {@link JsonUtils#readTree(String)}
   */
  @Test
  public void testReadTree() throws IOException {
    // Arrange and Act
    JsonNode actualReadTreeResult = JsonUtils.readTree("42");

    // Assert
    assertTrue(actualReadTreeResult instanceof IntNode);
    JsonParser traverseResult = actualReadTreeResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    BigInteger bigIntegerValue = traverseResult.getBigIntegerValue();
    assertEquals("42", bigIntegerValue.toString());
    JsonLocation currentLocation = traverseResult.getCurrentLocation();
    assertEquals("N/A", currentLocation.getSourceRef());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    Version versionResult = traverseResult.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.8.6", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult.getValueAsString());
    assertEquals(-1, currentLocation.getColumnNr());
    assertEquals(-1, currentLocation.getLineNr());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, actualReadTreeResult.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble(), 0.0);
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(1, bigIntegerValue.getLowestSetBit());
    assertEquals(1, bigIntegerValue.signum());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(42, traverseResult.getIntValue());
    assertEquals(42.0d, traverseResult.getDoubleValue(), 0.0);
    assertEquals(42.0f, traverseResult.getFloatValue(), 0.0f);
    assertEquals(42L, traverseResult.getLongValue());
    assertEquals((short) 42, traverseResult.getShortValue());
    assertEquals(6, versionResult.getPatchLevel());
    assertEquals(8, versionResult.getMinorVersion());
    assertEquals(JsonParser.NumberType.INT, traverseResult.getNumberType());
    assertEquals(JsonNodeType.NUMBER, actualReadTreeResult.getNodeType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(actualReadTreeResult.isArray());
    assertFalse(actualReadTreeResult.isBigDecimal());
    assertFalse(actualReadTreeResult.isBigInteger());
    assertFalse(actualReadTreeResult.isBinary());
    assertFalse(actualReadTreeResult.isBoolean());
    assertFalse(actualReadTreeResult.isContainerNode());
    assertFalse(actualReadTreeResult.isDouble());
    assertFalse(actualReadTreeResult.isFloat());
    assertFalse(actualReadTreeResult.isFloatingPointNumber());
    assertFalse(actualReadTreeResult.isLong());
    assertFalse(actualReadTreeResult.isMissingNode());
    assertFalse(actualReadTreeResult.isNull());
    assertFalse(actualReadTreeResult.isObject());
    assertFalse(actualReadTreeResult.isPojo());
    assertFalse(actualReadTreeResult.isShort());
    assertFalse(actualReadTreeResult.isTextual());
    assertFalse(actualReadTreeResult.iterator().hasNext());
    assertTrue(actualReadTreeResult.isInt());
    assertTrue(actualReadTreeResult.isIntegralNumber());
    assertTrue(actualReadTreeResult.isNumber());
    assertTrue(actualReadTreeResult.isValueNode());
    BigDecimal expectedDecimalValue = new BigDecimal("42");
    assertEquals(expectedDecimalValue, traverseResult.getDecimalValue());
    assertEquals('*', traverseResult.getByteValue());
    assertSame(currentLocation, traverseResult.getTokenLocation());
    assertArrayEquals(new byte[]{'*'}, bigIntegerValue.toByteArray());
  }

  /**
   * Method under test: {@link JsonUtils#readTree(String)}
   */
  @Test
  public void testReadTree2() throws IOException {
    // Arrange and Act
    JsonNode actualReadTreeResult = JsonUtils.readTree("4242");

    // Assert
    assertTrue(actualReadTreeResult instanceof IntNode);
    JsonParser traverseResult = actualReadTreeResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    BigInteger bigIntegerValue = traverseResult.getBigIntegerValue();
    assertEquals("4242", bigIntegerValue.toString());
    JsonLocation currentLocation = traverseResult.getCurrentLocation();
    assertEquals("N/A", currentLocation.getSourceRef());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    Version versionResult = traverseResult.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.8.6", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult.getValueAsString());
    assertEquals(-1, currentLocation.getColumnNr());
    assertEquals(-1, currentLocation.getLineNr());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, actualReadTreeResult.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble(), 0.0);
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(1, bigIntegerValue.getLowestSetBit());
    assertEquals(1, bigIntegerValue.signum());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(4242, traverseResult.getIntValue());
    assertEquals(4242.0d, traverseResult.getDoubleValue(), 0.0);
    assertEquals(4242.0f, traverseResult.getFloatValue(), 0.0f);
    assertEquals(4242L, traverseResult.getLongValue());
    assertEquals((short) 4242, traverseResult.getShortValue());
    assertEquals(6, versionResult.getPatchLevel());
    assertEquals(8, versionResult.getMinorVersion());
    assertEquals(JsonParser.NumberType.INT, traverseResult.getNumberType());
    assertEquals(JsonNodeType.NUMBER, actualReadTreeResult.getNodeType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(actualReadTreeResult.isArray());
    assertFalse(actualReadTreeResult.isBigDecimal());
    assertFalse(actualReadTreeResult.isBigInteger());
    assertFalse(actualReadTreeResult.isBinary());
    assertFalse(actualReadTreeResult.isBoolean());
    assertFalse(actualReadTreeResult.isContainerNode());
    assertFalse(actualReadTreeResult.isDouble());
    assertFalse(actualReadTreeResult.isFloat());
    assertFalse(actualReadTreeResult.isFloatingPointNumber());
    assertFalse(actualReadTreeResult.isLong());
    assertFalse(actualReadTreeResult.isMissingNode());
    assertFalse(actualReadTreeResult.isNull());
    assertFalse(actualReadTreeResult.isObject());
    assertFalse(actualReadTreeResult.isPojo());
    assertFalse(actualReadTreeResult.isShort());
    assertFalse(actualReadTreeResult.isTextual());
    assertFalse(actualReadTreeResult.iterator().hasNext());
    assertTrue(actualReadTreeResult.isInt());
    assertTrue(actualReadTreeResult.isIntegralNumber());
    assertTrue(actualReadTreeResult.isNumber());
    assertTrue(actualReadTreeResult.isValueNode());
    BigDecimal expectedDecimalValue = new BigDecimal("4242");
    assertEquals(expectedDecimalValue, traverseResult.getDecimalValue());
    assertSame(currentLocation, traverseResult.getTokenLocation());
    assertArrayEquals(new byte[]{16, -110}, bigIntegerValue.toByteArray());
  }

  /**
   * Method under test: {@link JsonUtils#writeValueAsString(Object)}
   */
  @Test
  public void testWriteValueAsString() throws JsonProcessingException {
    // Arrange, Act and Assert
    assertEquals("null", JsonUtils.writeValueAsString(null));
    assertEquals(
        "{\"serviceId\":\"resource\",\"id\":null,\"userInfoUri\":null,\"tokenInfoUri\":null,\"preferTokenInfo\":true,"
            + "\"tokenType\":\"Bearer\",\"jwt\":{\"keyValue\":null,\"keyUri\":null},\"filterOrder\":2147483639,\"resourceId\":null"
            + "}",
        JsonUtils.writeValueAsString(new ResourceServerProperties()));
    assertEquals("{\"user\":null,\"expirationDate\":null,\"aud\":null,\"iss\":null,\"sub\":null,\"exp\":null}",
        JsonUtils.writeValueAsString(new JwtPayload()));
    assertEquals("{}", JsonUtils.writeValueAsString(new UserAuthorizationData()));
    assertEquals("42", JsonUtils.writeValueAsString(42));
  }

  /**
   * Method under test: {@link JsonUtils#writeValueAsString(Object)}
   */
  @Test
  public void testWriteValueAsString2() throws JsonProcessingException {
    // Arrange
    IntegrationFlags integrationFlags = new IntegrationFlags();
    integrationFlags.setAppCertificateInstalled(IntegrationFlags.ValueEnum.OK);
    integrationFlags.setParserInstalled(IntegrationFlags.ValueEnum.OK);
    integrationFlags.setUserAuthenticated(IntegrationFlags.ValueEnum.OK);
    integrationFlags.setUserCertificateInstalled(IntegrationFlags.ValueEnum.OK);

    // Act and Assert
    assertEquals(
        "{\"parser_installed\":\"OK\",\"user_certificate_installed\":\"OK\",\"app_certificate_installed\":\"OK\",\"user"
            + "_authenticated\":\"OK\"}",
        JsonUtils.writeValueAsString(integrationFlags));
  }

  /**
   * Method under test: {@link JsonUtils#readValue(Object, Class)}
   */
  @Test
  public void testReadValue() throws IOException {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertEquals("Value", JsonUtils.readValue("Value", clazz));
  }

  /**
   * Method under test: {@link JsonUtils#readValue(Object, Class)}
   */
  @Test
  public void testReadValue2() throws IOException {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertEquals("42", JsonUtils.readValue("42", clazz));
  }
}
