package org.symphonyoss.integration.authentication.api.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;

public class AppTokenDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AppToken#AppToken()}
   *   <li>{@link AppToken#setAppId(String)}
   *   <li>{@link AppToken#setAppToken(String)}
   *   <li>{@link AppToken#setSymphonyToken(String)}
   *   <li>{@link AppToken#getAppId()}
   *   <li>{@link AppToken#getAppToken()}
   *   <li>{@link AppToken#getSymphonyToken()}
   * </ul>
   */
  @Test
  @MethodsUnderTest({"void AppToken.<init>()", "void AppToken.<init>(String, String, String)",
      "String AppToken.getAppId()", "String AppToken.getAppToken()", "String AppToken.getSymphonyToken()",
      "void AppToken.setAppId(String)", "void AppToken.setAppToken(String)", "void AppToken.setSymphonyToken(String)"})
  public void testGettersAndSetters() {
    // Arrange and Act
    AppToken actualAppToken = new AppToken();
    actualAppToken.setAppId("42");
    actualAppToken.setAppToken("ABC123");
    actualAppToken.setSymphonyToken("ABC123");
    String actualAppId = actualAppToken.getAppId();
    String actualAppToken2 = actualAppToken.getAppToken();

    // Assert
    assertEquals("42", actualAppId);
    assertEquals("ABC123", actualAppToken2);
    assertEquals("ABC123", actualAppToken.getSymphonyToken());
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@code 42}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AppToken#AppToken(String, String, String)}
   *   <li>{@link AppToken#setAppId(String)}
   *   <li>{@link AppToken#setAppToken(String)}
   *   <li>{@link AppToken#setSymphonyToken(String)}
   *   <li>{@link AppToken#getAppId()}
   *   <li>{@link AppToken#getAppToken()}
   *   <li>{@link AppToken#getSymphonyToken()}
   * </ul>
   */
  @Test
  @MethodsUnderTest({"void AppToken.<init>()", "void AppToken.<init>(String, String, String)",
      "String AppToken.getAppId()", "String AppToken.getAppToken()", "String AppToken.getSymphonyToken()",
      "void AppToken.setAppId(String)", "void AppToken.setAppToken(String)", "void AppToken.setSymphonyToken(String)"})
  public void testGettersAndSetters_when42() {
    // Arrange and Act
    AppToken actualAppToken = new AppToken("42", "ABC123", "ABC123");
    actualAppToken.setAppId("42");
    actualAppToken.setAppToken("ABC123");
    actualAppToken.setSymphonyToken("ABC123");
    String actualAppId = actualAppToken.getAppId();
    String actualAppToken2 = actualAppToken.getAppToken();

    // Assert
    assertEquals("42", actualAppId);
    assertEquals("ABC123", actualAppToken2);
    assertEquals("ABC123", actualAppToken.getSymphonyToken());
  }

  /**
   * Test {@link AppToken#equals(Object)}, and {@link AppToken#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AppToken#equals(Object)}
   *   <li>{@link AppToken#hashCode()}
   * </ul>
   */
  @Test
  @MethodsUnderTest({"boolean AppToken.equals(Object)", "int AppToken.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AppToken appToken = new AppToken("42", "ABC123", "ABC123");
    AppToken appToken2 = new AppToken("42", "ABC123", "ABC123");

    // Act and Assert
    assertEquals(appToken, appToken2);
    int expectedHashCodeResult = appToken.hashCode();
    assertEquals(expectedHashCodeResult, appToken2.hashCode());
  }

  /**
   * Test {@link AppToken#equals(Object)}, and {@link AppToken#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AppToken#equals(Object)}
   *   <li>{@link AppToken#hashCode()}
   * </ul>
   */
  @Test
  @MethodsUnderTest({"boolean AppToken.equals(Object)", "int AppToken.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AppToken appToken = new AppToken("42", "ABC123", "ABC123");

    // Act and Assert
    assertEquals(appToken, appToken);
    int expectedHashCodeResult = appToken.hashCode();
    assertEquals(expectedHashCodeResult, appToken.hashCode());
  }

  /**
   * Test {@link AppToken#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AppToken#equals(Object)}
   */
  @Test
  @MethodsUnderTest({"boolean AppToken.equals(Object)", "int AppToken.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    AppToken appToken = new AppToken("App Id", "ABC123", "ABC123");

    // Act and Assert
    assertNotEquals(appToken, new AppToken("42", "ABC123", "ABC123"));
  }

  /**
   * Test {@link AppToken#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AppToken#equals(Object)}
   */
  @Test
  @MethodsUnderTest({"boolean AppToken.equals(Object)", "int AppToken.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    AppToken appToken = new AppToken("42", "App Token", "ABC123");

    // Act and Assert
    assertNotEquals(appToken, new AppToken("42", "ABC123", "ABC123"));
  }

  /**
   * Test {@link AppToken#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AppToken#equals(Object)}
   */
  @Test
  @MethodsUnderTest({"boolean AppToken.equals(Object)", "int AppToken.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    AppToken appToken = new AppToken("42", "ABC123", "Symphony Token");

    // Act and Assert
    assertNotEquals(appToken, new AppToken("42", "ABC123", "ABC123"));
  }

  /**
   * Test {@link AppToken#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AppToken#equals(Object)}
   */
  @Test
  @MethodsUnderTest({"boolean AppToken.equals(Object)", "int AppToken.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AppToken("42", "ABC123", "ABC123"), null);
  }

  /**
   * Test {@link AppToken#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AppToken#equals(Object)}
   */
  @Test
  @MethodsUnderTest({"boolean AppToken.equals(Object)", "int AppToken.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AppToken("42", "ABC123", "ABC123"), "Different type to AppToken");
  }
}
