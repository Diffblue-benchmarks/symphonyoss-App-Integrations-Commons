package org.symphonyoss.integration.json;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.IntNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties;
import org.symphonyoss.integration.authentication.api.model.JwtPayload;
import org.symphonyoss.integration.authorization.UserAuthorizationData;
import org.symphonyoss.integration.model.healthcheck.IntegrationFlags;
import org.symphonyoss.integration.model.healthcheck.IntegrationFlags.ValueEnum;

public class JsonUtilsDiffblueTest {
  /**
   * Test {@link JsonUtils#readTree(String)} with {@code String}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return traverse IntValue is forty-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonUtils#readTree(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"JsonNode JsonUtils.readTree(String)"})
  public void testReadTreeWithString_when42_thenReturnTraverseIntValueIsFortyTwo() throws IOException {
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
    BigDecimal expectedDecimalValue = new BigDecimal("42");
    assertEquals(expectedDecimalValue, traverseResult.getDecimalValue());
    assertEquals('*', traverseResult.getByteValue());
  }

  /**
   * Test {@link JsonUtils#readTree(String)} with {@code String}.
   * <ul>
   *   <li>When {@code 4242}.</li>
   *   <li>Then return traverse BigIntegerValue toString is {@code 4242}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonUtils#readTree(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"JsonNode JsonUtils.readTree(String)"})
  public void testReadTreeWithString_when4242_thenReturnTraverseBigIntegerValueToStringIs4242() throws IOException {
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
    BigDecimal expectedDecimalValue = new BigDecimal("4242");
    assertEquals(expectedDecimalValue, traverseResult.getDecimalValue());
    assertArrayEquals(new byte[]{16, -110}, bigIntegerValue.toByteArray());
  }

  /**
   * Test {@link JsonUtils#writeValueAsString(Object)}.
   * <p>
   * Method under test: {@link JsonUtils#writeValueAsString(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String JsonUtils.writeValueAsString(Object)"})
  public void testWriteValueAsString() throws JsonProcessingException {
    // Arrange, Act and Assert
    assertEquals("{\"user\":null,\"expirationDate\":null,\"aud\":null,\"iss\":null,\"sub\":null,\"exp\":null}",
        JsonUtils.writeValueAsString(new JwtPayload()));
  }

  /**
   * Test {@link JsonUtils#writeValueAsString(Object)}.
   * <ul>
   *   <li>Given {@code OK}.</li>
   *   <li>When {@link IntegrationFlags} (default constructor) AppCertificateInstalled is {@code OK}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonUtils#writeValueAsString(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <ul>
   *   <li>Then return {@code {}}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonUtils#writeValueAsString(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String JsonUtils.writeValueAsString(Object)"})
  public void testWriteValueAsString_thenReturnLeftCurlyBracketRightCurlyBracket() throws JsonProcessingException {
    // Arrange, Act and Assert
    assertEquals("{}", JsonUtils.writeValueAsString(new UserAuthorizationData()));
  }

  /**
   * Test {@link JsonUtils#writeValueAsString(Object)}.
   * <ul>
   *   <li>When forty-two.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonUtils#writeValueAsString(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String JsonUtils.writeValueAsString(Object)"})
  public void testWriteValueAsString_whenFortyTwo_thenReturn42() throws JsonProcessingException {
    // Arrange, Act and Assert
    assertEquals("42", JsonUtils.writeValueAsString(42));
  }

  /**
   * Test {@link JsonUtils#writeValueAsString(Object)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonUtils#writeValueAsString(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String JsonUtils.writeValueAsString(Object)"})
  public void testWriteValueAsString_whenNull_thenReturnNull() throws JsonProcessingException {
    // Arrange, Act and Assert
    assertEquals("null", JsonUtils.writeValueAsString(null));
  }

  /**
   * Test {@link JsonUtils#writeValueAsString(Object)}.
   * <ul>
   *   <li>When {@link ResourceServerProperties#ResourceServerProperties()}.</li>
   *   <li>Then return a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonUtils#writeValueAsString(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String JsonUtils.writeValueAsString(Object)"})
  public void testWriteValueAsString_whenResourceServerProperties_thenReturnAString() throws JsonProcessingException {
    // Arrange, Act and Assert
    assertEquals(
        "{\"serviceId\":\"resource\",\"id\":null,\"userInfoUri\":null,\"tokenInfoUri\":null,\"preferTokenInfo\":true,"
            + "\"tokenType\":\"Bearer\",\"jwt\":{\"keyValue\":null,\"keyUri\":null},\"filterOrder\":2147483639,\"resourceId\":null"
            + "}",
        JsonUtils.writeValueAsString(new ResourceServerProperties()));
  }

  /**
   * Test {@link JsonUtils#readValue(Object, Class)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonUtils#readValue(Object, Class)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object JsonUtils.readValue(Object, Class)"})
  public void testReadValue_when42_thenReturn42() throws IOException {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertEquals("42", JsonUtils.readValue("42", clazz));
  }

  /**
   * Test {@link JsonUtils#readValue(Object, Class)}.
   * <ul>
   *   <li>When forty-two.</li>
   *   <li>Then return intValue is forty-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonUtils#readValue(Object, Class)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object JsonUtils.readValue(Object, Class)"})
  public void testReadValue_whenFortyTwo_thenReturnIntValueIsFortyTwo() throws IOException {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertEquals(42, ((Integer) JsonUtils.readValue(42, clazz)).intValue());
  }

  /**
   * Test {@link JsonUtils#readValue(Object, Class)}.
   * <ul>
   *   <li>When {@code Value}.</li>
   *   <li>Then return {@code Value}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonUtils#readValue(Object, Class)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object JsonUtils.readValue(Object, Class)"})
  public void testReadValue_whenValue_thenReturnValue() throws IOException {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertEquals("Value", JsonUtils.readValue("Value", clazz));
  }
}
