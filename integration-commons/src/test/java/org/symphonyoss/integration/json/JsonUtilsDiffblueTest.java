package org.symphonyoss.integration.json;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.IntNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Map;
import org.junit.Test;
import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties;
import org.symphonyoss.integration.authentication.api.model.JwtPayload;
import org.symphonyoss.integration.model.healthcheck.IntegrationFlags;
import org.symphonyoss.integration.model.healthcheck.IntegrationFlags.ValueEnum;

public class JsonUtilsDiffblueTest {
  /**
   * Test {@link JsonUtils#readTree(String)} with {@code String}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return traverse IntValue is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link JsonUtils#readTree(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonNode JsonUtils.readTree(String)"})
  public void testReadTreeWithString_when42_thenReturnTraverseIntValueIsFortyTwo()
      throws IOException {
    // Arrange and Act
    JsonNode actualReadTreeResult = JsonUtils.readTree("42");

    // Assert
    assertTrue(actualReadTreeResult instanceof IntNode);
    JsonParser traverseResult = actualReadTreeResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    assertEquals(42, traverseResult.getIntValue());
    assertEquals(42, traverseResult.getNumberValue().intValue());
    assertEquals(42.0d, traverseResult.getDoubleValue(), 0.0);
    assertEquals(42.0f, traverseResult.getFloatValue(), 0.0f);
    assertEquals(42L, traverseResult.getLongValue());
    assertEquals((short) 42, traverseResult.getShortValue());
    assertEquals(new BigDecimal("42"), traverseResult.getDecimalValue());
    assertEquals('*', traverseResult.getByteValue());
  }

  /**
   * Test {@link JsonUtils#readTree(String)} with {@code String}.
   *
   * <ul>
   *   <li>When {@code 4242}.
   *   <li>Then return traverse BigIntegerValue toString is {@code 4242}.
   * </ul>
   *
   * <p>Method under test: {@link JsonUtils#readTree(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonNode JsonUtils.readTree(String)"})
  public void testReadTreeWithString_when4242_thenReturnTraverseBigIntegerValueToStringIs4242()
      throws IOException {
    // Arrange and Act
    JsonNode actualReadTreeResult = JsonUtils.readTree("4242");

    // Assert
    assertTrue(actualReadTreeResult instanceof IntNode);
    JsonParser traverseResult = actualReadTreeResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    BigInteger bigIntegerValue = traverseResult.getBigIntegerValue();
    assertEquals("4242", bigIntegerValue.toString());
    assertEquals(4242, traverseResult.getIntValue());
    assertEquals(4242, traverseResult.getNumberValue().intValue());
    assertEquals(4242.0d, traverseResult.getDoubleValue(), 0.0);
    assertEquals(4242.0f, traverseResult.getFloatValue(), 0.0f);
    assertEquals(4242L, traverseResult.getLongValue());
    assertEquals((short) 4242, traverseResult.getShortValue());
    assertEquals(new BigDecimal("4242"), traverseResult.getDecimalValue());
    assertArrayEquals(new byte[] {16, -110}, bigIntegerValue.toByteArray());
  }

  /**
   * Test {@link JsonUtils#writeValueAsString(Object)}.
   *
   * <ul>
   *   <li>Given {@code OK}.
   *   <li>When {@link IntegrationFlags} (default constructor) AppCertificateInstalled is {@code
   *       OK}.
   * </ul>
   *
   * <p>Method under test: {@link JsonUtils#writeValueAsString(Object)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonUtils.writeValueAsString(Object)"})
  public void testWriteValueAsString_givenOk_whenIntegrationFlagsAppCertificateInstalledIsOk()
      throws JsonProcessingException {
    // Arrange
    IntegrationFlags integrationFlags = new IntegrationFlags();
    integrationFlags.setAppCertificateInstalled(ValueEnum.OK);
    integrationFlags.setParserInstalled(ValueEnum.OK);
    integrationFlags.setUserAuthenticated(ValueEnum.OK);
    integrationFlags.setUserCertificateInstalled(ValueEnum.OK);

    // Act and Assert
    assertEquals(
        "{\"parser_installed\":\"OK\",\"user_certificate_installed\":\"OK\",\"app_certificate_installed\":\"OK\",\"user"
            + "_authenticated\":\"OK\"}",
        JsonUtils.writeValueAsString(integrationFlags));
  }

  /**
   * Test {@link JsonUtils#writeValueAsString(Object)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JsonUtils#writeValueAsString(Object)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonUtils.writeValueAsString(Object)"})
  public void testWriteValueAsString_whenNull_thenReturnNull() throws JsonProcessingException {
    // Arrange, Act and Assert
    assertEquals("null", JsonUtils.writeValueAsString(null));
  }

  /**
   * Test {@link JsonUtils#writeValueAsString(Object)}.
   *
   * <ul>
   *   <li>When {@link ResourceServerProperties#ResourceServerProperties()}.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link JsonUtils#writeValueAsString(Object)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonUtils.writeValueAsString(Object)"})
  public void testWriteValueAsString_whenResourceServerProperties_thenReturnAString()
      throws JsonProcessingException {
    // Arrange, Act and Assert
    assertEquals(
        "{\"serviceId\":\"resource\",\"id\":null,\"userInfoUri\":null,\"tokenInfoUri\":null,\"preferTokenInfo\":true,"
            + "\"tokenType\":\"Bearer\",\"jwt\":{\"keyValue\":null,\"keyUri\":null},\"filterOrder\":2147483639,\"resourceId\":null"
            + "}",
        JsonUtils.writeValueAsString(new ResourceServerProperties()));
  }

  /**
   * Test {@link JsonUtils#readValue(Object, Class)}.
   *
   * <ul>
   *   <li>Given {@code OK}.
   *   <li>Then return size is four.
   * </ul>
   *
   * <p>Method under test: {@link JsonUtils#readValue(Object, Class)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonUtils.readValue(Object, Class)"})
  public void testReadValue_givenOk_thenReturnSizeIsFour() throws IOException {
    // Arrange
    IntegrationFlags integrationFlags = new IntegrationFlags();
    integrationFlags.setAppCertificateInstalled(ValueEnum.OK);
    integrationFlags.setParserInstalled(ValueEnum.OK);
    integrationFlags.setUserAuthenticated(ValueEnum.OK);
    integrationFlags.setUserCertificateInstalled(ValueEnum.OK);
    Class<Object> clazz = Object.class;

    // Act
    Object actualReadValueResult = JsonUtils.readValue(integrationFlags, clazz);

    // Assert
    assertTrue(actualReadValueResult instanceof Map);
    assertEquals(4, ((Map<String, String>) actualReadValueResult).size());
    assertEquals(
        "OK", ((Map<String, String>) actualReadValueResult).get("app_certificate_installed"));
    assertEquals("OK", ((Map<String, String>) actualReadValueResult).get("parser_installed"));
    assertEquals("OK", ((Map<String, String>) actualReadValueResult).get("user_authenticated"));
    assertEquals(
        "OK", ((Map<String, String>) actualReadValueResult).get("user_certificate_installed"));
  }

  /**
   * Test {@link JsonUtils#readValue(Object, Class)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link JsonUtils#readValue(Object, Class)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonUtils.readValue(Object, Class)"})
  public void testReadValue_when42_thenReturn42() throws IOException {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertEquals("42", JsonUtils.readValue("42", clazz));
  }

  /**
   * Test {@link JsonUtils#readValue(Object, Class)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return intValue is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link JsonUtils#readValue(Object, Class)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonUtils.readValue(Object, Class)"})
  public void testReadValue_whenFortyTwo_thenReturnIntValueIsFortyTwo() throws IOException {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act
    Object actualReadValueResult = JsonUtils.readValue(42, clazz);

    // Assert
    assertEquals(42, ((Integer) actualReadValueResult).intValue());
  }

  /**
   * Test {@link JsonUtils#readValue(Object, Class)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JsonUtils#readValue(Object, Class)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonUtils.readValue(Object, Class)"})
  public void testReadValue_whenJavaLangObject_thenReturnNull() throws IOException {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertNull(JsonUtils.readValue(null, clazz));
  }

  /**
   * Test {@link JsonUtils#readValue(Object, Class)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JsonUtils#readValue(Object, Class)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonUtils.readValue(Object, Class)"})
  public void testReadValue_whenJavaLangObject_thenReturnNull2() throws IOException {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertNull(JsonUtils.readValue(null, clazz));
  }

  /**
   * Test {@link JsonUtils#readValue(Object, Class)}.
   *
   * <ul>
   *   <li>When {@link JwtPayload#JwtPayload()}.
   *   <li>Then return size is six.
   * </ul>
   *
   * <p>Method under test: {@link JsonUtils#readValue(Object, Class)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonUtils.readValue(Object, Class)"})
  public void testReadValue_whenJwtPayload_thenReturnSizeIsSix() throws IOException {
    // Arrange
    JwtPayload jwtPayload = new JwtPayload();
    Class<Object> clazz = Object.class;

    // Act
    Object actualReadValueResult = JsonUtils.readValue(jwtPayload, clazz);

    // Assert
    assertTrue(actualReadValueResult instanceof Map);
    assertEquals(6, ((Map<String, Object>) actualReadValueResult).size());
    assertNull(((Map<String, Object>) actualReadValueResult).get("aud"));
    assertNull(((Map<String, Object>) actualReadValueResult).get("exp"));
    assertNull(((Map<String, Object>) actualReadValueResult).get("expirationDate"));
    assertNull(((Map<String, Object>) actualReadValueResult).get("iss"));
    assertNull(((Map<String, Object>) actualReadValueResult).get("sub"));
    assertNull(((Map<String, Object>) actualReadValueResult).get("user"));
  }

  /**
   * Test {@link JsonUtils#readValue(Object, Class)}.
   *
   * <ul>
   *   <li>When {@link ResourceServerProperties#ResourceServerProperties()}.
   *   <li>Then return size is nine.
   * </ul>
   *
   * <p>Method under test: {@link JsonUtils#readValue(Object, Class)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonUtils.readValue(Object, Class)"})
  public void testReadValue_whenResourceServerProperties_thenReturnSizeIsNine() throws IOException {
    // Arrange
    ResourceServerProperties resourceServerProperties = new ResourceServerProperties();
    Class<Object> clazz = Object.class;

    // Act
    Object actualReadValueResult = JsonUtils.readValue(resourceServerProperties, clazz);

    // Assert
    assertEquals(9, ((Map<String, Object>) actualReadValueResult).size());
    Object getResult = ((Map<String, Object>) actualReadValueResult).get("jwt");
    assertTrue(getResult instanceof Map);
    assertTrue(actualReadValueResult instanceof Map);
    assertEquals("Bearer", ((Map<String, Object>) actualReadValueResult).get("tokenType"));
    assertEquals("resource", ((Map<String, Object>) actualReadValueResult).get("serviceId"));
    assertEquals(2, ((Map<String, Object>) getResult).size());
    assertNull(((Map<String, Object>) getResult).get("keyUri"));
    assertNull(((Map<String, Object>) getResult).get("keyValue"));
    assertNull(((Map<String, Object>) actualReadValueResult).get("id"));
    assertNull(((Map<String, Object>) actualReadValueResult).get("resourceId"));
    assertNull(((Map<String, Object>) actualReadValueResult).get("tokenInfoUri"));
    assertNull(((Map<String, Object>) actualReadValueResult).get("userInfoUri"));
    assertEquals(
        2147483639,
        ((Integer) ((Map<String, Object>) actualReadValueResult).get("filterOrder")).intValue());
    assertTrue((Boolean) ((Map<String, Object>) actualReadValueResult).get("preferTokenInfo"));
  }
}
