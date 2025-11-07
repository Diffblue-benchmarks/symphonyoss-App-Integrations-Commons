package org.symphonyoss.integration.authorization;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;

public class UserAuthorizationDataDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link UserAuthorizationData#equals(Object)}
   *   <li>{@link UserAuthorizationData#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    UserAuthorizationData userAuthorizationData = new UserAuthorizationData();
    UserAuthorizationData userAuthorizationData2 = new UserAuthorizationData();

    // Act and Assert
    assertEquals(userAuthorizationData, userAuthorizationData2);
    int expectedHashCodeResult = userAuthorizationData.hashCode();
    assertEquals(expectedHashCodeResult, userAuthorizationData2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link UserAuthorizationData#equals(Object)}
   *   <li>{@link UserAuthorizationData#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    UserAuthorizationData userAuthorizationData = new UserAuthorizationData("https://example.org/example", 1L);
    UserAuthorizationData userAuthorizationData2 = new UserAuthorizationData("https://example.org/example", 1L);

    // Act and Assert
    assertEquals(userAuthorizationData, userAuthorizationData2);
    int expectedHashCodeResult = userAuthorizationData.hashCode();
    assertEquals(expectedHashCodeResult, userAuthorizationData2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link UserAuthorizationData#equals(Object)}
   *   <li>{@link UserAuthorizationData#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    UserAuthorizationData userAuthorizationData = new UserAuthorizationData();

    // Act and Assert
    assertEquals(userAuthorizationData, userAuthorizationData);
    int expectedHashCodeResult = userAuthorizationData.hashCode();
    assertEquals(expectedHashCodeResult, userAuthorizationData.hashCode());
  }

  /**
   * Method under test: {@link UserAuthorizationData#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    UserAuthorizationData userAuthorizationData = new UserAuthorizationData("https://example.org/example", 1L);

    // Act and Assert
    assertNotEquals(userAuthorizationData, new UserAuthorizationData());
  }

  /**
   * Method under test: {@link UserAuthorizationData#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    UserAuthorizationData userAuthorizationData = new UserAuthorizationData();

    // Act and Assert
    assertNotEquals(userAuthorizationData, new UserAuthorizationData("https://example.org/example", 1L));
  }

  /**
   * Method under test: {@link UserAuthorizationData#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    UserAuthorizationData userAuthorizationData = new UserAuthorizationData();
    userAuthorizationData.setUserId(1L);

    // Act and Assert
    assertNotEquals(userAuthorizationData, new UserAuthorizationData());
  }

  /**
   * Method under test: {@link UserAuthorizationData#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    UserAuthorizationData userAuthorizationData = new UserAuthorizationData();
    userAuthorizationData.setData("Data");

    // Act and Assert
    assertNotEquals(userAuthorizationData, new UserAuthorizationData());
  }

  /**
   * Method under test: {@link UserAuthorizationData#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    UserAuthorizationData userAuthorizationData = new UserAuthorizationData("https://example.org/example", 1L);

    UserAuthorizationData userAuthorizationData2 = new UserAuthorizationData();
    userAuthorizationData2.setUrl("https://example.org/example");

    // Act and Assert
    assertNotEquals(userAuthorizationData, userAuthorizationData2);
  }

  /**
   * Method under test: {@link UserAuthorizationData#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    UserAuthorizationData userAuthorizationData = new UserAuthorizationData("https://example.org/example", 1L);

    // Act and Assert
    assertNotEquals(userAuthorizationData, new UserAuthorizationData("https://example.org/example", 1L, "Data"));
  }

  /**
   * Method under test: {@link UserAuthorizationData#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    UserAuthorizationData userAuthorizationData = new UserAuthorizationData();

    UserAuthorizationData userAuthorizationData2 = new UserAuthorizationData();
    userAuthorizationData2.setUserId(1L);

    // Act and Assert
    assertNotEquals(userAuthorizationData, userAuthorizationData2);
  }

  /**
   * Method under test: {@link UserAuthorizationData#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    UserAuthorizationData userAuthorizationData = new UserAuthorizationData();
    userAuthorizationData.setData(new UserAuthorizationData());

    // Act and Assert
    assertNotEquals(userAuthorizationData, new UserAuthorizationData());
  }

  /**
   * Method under test: {@link UserAuthorizationData#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new UserAuthorizationData(), null);
  }

  /**
   * Method under test: {@link UserAuthorizationData#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new UserAuthorizationData(), "Different type to UserAuthorizationData");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link UserAuthorizationData#UserAuthorizationData()}
   *   <li>{@link UserAuthorizationData#setData(Object)}
   *   <li>{@link UserAuthorizationData#setUrl(String)}
   *   <li>{@link UserAuthorizationData#setUserId(Long)}
   *   <li>{@link UserAuthorizationData#getData()}
   *   <li>{@link UserAuthorizationData#getUrl()}
   *   <li>{@link UserAuthorizationData#getUserId()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    UserAuthorizationData actualUserAuthorizationData = new UserAuthorizationData();
    actualUserAuthorizationData.setData("Data");
    actualUserAuthorizationData.setUrl("https://example.org/example");
    actualUserAuthorizationData.setUserId(1L);
    Object actualData = actualUserAuthorizationData.getData();
    String actualUrl = actualUserAuthorizationData.getUrl();

    // Assert that nothing has changed
    assertEquals("Data", actualData);
    assertEquals("https://example.org/example", actualUrl);
    assertEquals(1L, actualUserAuthorizationData.getUserId().longValue());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link UserAuthorizationData#UserAuthorizationData(String, Long)}
   *   <li>{@link UserAuthorizationData#setData(Object)}
   *   <li>{@link UserAuthorizationData#setUrl(String)}
   *   <li>{@link UserAuthorizationData#setUserId(Long)}
   *   <li>{@link UserAuthorizationData#getData()}
   *   <li>{@link UserAuthorizationData#getUrl()}
   *   <li>{@link UserAuthorizationData#getUserId()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters2() {
    // Arrange and Act
    UserAuthorizationData actualUserAuthorizationData = new UserAuthorizationData("https://example.org/example", 1L);
    actualUserAuthorizationData.setData("Data");
    actualUserAuthorizationData.setUrl("https://example.org/example");
    actualUserAuthorizationData.setUserId(1L);
    Object actualData = actualUserAuthorizationData.getData();
    String actualUrl = actualUserAuthorizationData.getUrl();

    // Assert that nothing has changed
    assertEquals("Data", actualData);
    assertEquals("https://example.org/example", actualUrl);
    assertEquals(1L, actualUserAuthorizationData.getUserId().longValue());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link UserAuthorizationData#UserAuthorizationData(String, Long, Object)}
   *   <li>{@link UserAuthorizationData#setData(Object)}
   *   <li>{@link UserAuthorizationData#setUrl(String)}
   *   <li>{@link UserAuthorizationData#setUserId(Long)}
   *   <li>{@link UserAuthorizationData#getData()}
   *   <li>{@link UserAuthorizationData#getUrl()}
   *   <li>{@link UserAuthorizationData#getUserId()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters3() {
    // Arrange and Act
    UserAuthorizationData actualUserAuthorizationData = new UserAuthorizationData("https://example.org/example", 1L,
        "Data");
    actualUserAuthorizationData.setData("Data");
    actualUserAuthorizationData.setUrl("https://example.org/example");
    actualUserAuthorizationData.setUserId(1L);
    Object actualData = actualUserAuthorizationData.getData();
    String actualUrl = actualUserAuthorizationData.getUrl();

    // Assert that nothing has changed
    assertEquals("Data", actualData);
    assertEquals("https://example.org/example", actualUrl);
    assertEquals(1L, actualUserAuthorizationData.getUserId().longValue());
  }
}
