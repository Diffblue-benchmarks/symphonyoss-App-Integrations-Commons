package org.symphonyoss.integration.authorization;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;

public class UserAuthorizationDataDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void UserAuthorizationData.<init>()",
    "void UserAuthorizationData.<init>(String, Long)",
    "void UserAuthorizationData.<init>(String, Long, Object)",
    "Object UserAuthorizationData.getData()",
    "String UserAuthorizationData.getUrl()",
    "Long UserAuthorizationData.getUserId()",
    "void UserAuthorizationData.setData(Object)",
    "void UserAuthorizationData.setUrl(String)",
    "void UserAuthorizationData.setUserId(Long)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    UserAuthorizationData actualUserAuthorizationData = new UserAuthorizationData();
    actualUserAuthorizationData.setData("Data");
    actualUserAuthorizationData.setUrl("https://example.org/example");
    actualUserAuthorizationData.setUserId(1L);
    Object actualData = actualUserAuthorizationData.getData();
    String actualUrl = actualUserAuthorizationData.getUrl();

    // Assert
    assertEquals("Data", actualData);
    assertEquals("https://example.org/example", actualUrl);
    assertEquals(1L, actualUserAuthorizationData.getUserId().longValue());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code Data}.
   * </ul>
   *
   * <p>Methods under test:
   *
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
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void UserAuthorizationData.<init>()",
    "void UserAuthorizationData.<init>(String, Long)",
    "void UserAuthorizationData.<init>(String, Long, Object)",
    "Object UserAuthorizationData.getData()",
    "String UserAuthorizationData.getUrl()",
    "Long UserAuthorizationData.getUserId()",
    "void UserAuthorizationData.setData(Object)",
    "void UserAuthorizationData.setUrl(String)",
    "void UserAuthorizationData.setUserId(Long)"
  })
  public void testGettersAndSetters_whenData() {
    // Arrange and Act
    UserAuthorizationData actualUserAuthorizationData =
        new UserAuthorizationData("https://example.org/example", 1L, "Data");
    actualUserAuthorizationData.setData("Data");
    actualUserAuthorizationData.setUrl("https://example.org/example");
    actualUserAuthorizationData.setUserId(1L);
    Object actualData = actualUserAuthorizationData.getData();
    String actualUrl = actualUserAuthorizationData.getUrl();

    // Assert
    assertEquals("Data", actualData);
    assertEquals("https://example.org/example", actualUrl);
    assertEquals(1L, actualUserAuthorizationData.getUserId().longValue());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code https://example.org/example}.
   * </ul>
   *
   * <p>Methods under test:
   *
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
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void UserAuthorizationData.<init>()",
    "void UserAuthorizationData.<init>(String, Long)",
    "void UserAuthorizationData.<init>(String, Long, Object)",
    "Object UserAuthorizationData.getData()",
    "String UserAuthorizationData.getUrl()",
    "Long UserAuthorizationData.getUserId()",
    "void UserAuthorizationData.setData(Object)",
    "void UserAuthorizationData.setUrl(String)",
    "void UserAuthorizationData.setUserId(Long)"
  })
  public void testGettersAndSetters_whenHttpsExampleOrgExample() {
    // Arrange and Act
    UserAuthorizationData actualUserAuthorizationData =
        new UserAuthorizationData("https://example.org/example", 1L);
    actualUserAuthorizationData.setData("Data");
    actualUserAuthorizationData.setUrl("https://example.org/example");
    actualUserAuthorizationData.setUserId(1L);
    Object actualData = actualUserAuthorizationData.getData();
    String actualUrl = actualUserAuthorizationData.getUrl();

    // Assert
    assertEquals("Data", actualData);
    assertEquals("https://example.org/example", actualUrl);
    assertEquals(1L, actualUserAuthorizationData.getUserId().longValue());
  }

  /**
   * Test {@link UserAuthorizationData#equals(Object)}, and {@link
   * UserAuthorizationData#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link UserAuthorizationData#equals(Object)}
   *   <li>{@link UserAuthorizationData#hashCode()}
   * </ul>
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean UserAuthorizationData.equals(Object)",
    "int UserAuthorizationData.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    UserAuthorizationData userAuthorizationData = new UserAuthorizationData();
    UserAuthorizationData userAuthorizationData2 = new UserAuthorizationData();

    // Act and Assert
    assertEquals(userAuthorizationData, userAuthorizationData2);
    assertEquals(userAuthorizationData.hashCode(), userAuthorizationData2.hashCode());
  }

  /**
   * Test {@link UserAuthorizationData#equals(Object)}, and {@link
   * UserAuthorizationData#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link UserAuthorizationData#equals(Object)}
   *   <li>{@link UserAuthorizationData#hashCode()}
   * </ul>
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean UserAuthorizationData.equals(Object)",
    "int UserAuthorizationData.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    UserAuthorizationData userAuthorizationData =
        new UserAuthorizationData("https://example.org/example", 1L);
    UserAuthorizationData userAuthorizationData2 =
        new UserAuthorizationData("https://example.org/example", 1L);

    // Act and Assert
    assertEquals(userAuthorizationData, userAuthorizationData2);
    assertEquals(userAuthorizationData.hashCode(), userAuthorizationData2.hashCode());
  }

  /**
   * Test {@link UserAuthorizationData#equals(Object)}, and {@link
   * UserAuthorizationData#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link UserAuthorizationData#equals(Object)}
   *   <li>{@link UserAuthorizationData#hashCode()}
   * </ul>
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean UserAuthorizationData.equals(Object)",
    "int UserAuthorizationData.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    UserAuthorizationData userAuthorizationData = new UserAuthorizationData();

    // Act and Assert
    assertEquals(userAuthorizationData, userAuthorizationData);
    int expectedHashCodeResult = userAuthorizationData.hashCode();
    assertEquals(expectedHashCodeResult, userAuthorizationData.hashCode());
  }

  /**
   * Test {@link UserAuthorizationData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UserAuthorizationData#equals(Object)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean UserAuthorizationData.equals(Object)",
    "int UserAuthorizationData.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    UserAuthorizationData userAuthorizationData =
        new UserAuthorizationData("https://example.org/example", 1L);

    // Act and Assert
    assertNotEquals(userAuthorizationData, new UserAuthorizationData());
  }

  /**
   * Test {@link UserAuthorizationData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UserAuthorizationData#equals(Object)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean UserAuthorizationData.equals(Object)",
    "int UserAuthorizationData.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    UserAuthorizationData userAuthorizationData = new UserAuthorizationData();

    // Act and Assert
    assertNotEquals(
        userAuthorizationData, new UserAuthorizationData("https://example.org/example", 1L));
  }

  /**
   * Test {@link UserAuthorizationData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UserAuthorizationData#equals(Object)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean UserAuthorizationData.equals(Object)",
    "int UserAuthorizationData.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    UserAuthorizationData userAuthorizationData = new UserAuthorizationData();
    userAuthorizationData.setUserId(1L);

    // Act and Assert
    assertNotEquals(userAuthorizationData, new UserAuthorizationData());
  }

  /**
   * Test {@link UserAuthorizationData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UserAuthorizationData#equals(Object)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean UserAuthorizationData.equals(Object)",
    "int UserAuthorizationData.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    UserAuthorizationData userAuthorizationData = new UserAuthorizationData();
    userAuthorizationData.setData("Data");

    // Act and Assert
    assertNotEquals(userAuthorizationData, new UserAuthorizationData());
  }

  /**
   * Test {@link UserAuthorizationData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UserAuthorizationData#equals(Object)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean UserAuthorizationData.equals(Object)",
    "int UserAuthorizationData.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    UserAuthorizationData userAuthorizationData =
        new UserAuthorizationData("https://example.org/example", 1L);

    UserAuthorizationData userAuthorizationData2 = new UserAuthorizationData();
    userAuthorizationData2.setUrl("https://example.org/example");

    // Act and Assert
    assertNotEquals(userAuthorizationData, userAuthorizationData2);
  }

  /**
   * Test {@link UserAuthorizationData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UserAuthorizationData#equals(Object)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean UserAuthorizationData.equals(Object)",
    "int UserAuthorizationData.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    UserAuthorizationData userAuthorizationData =
        new UserAuthorizationData("https://example.org/example", 1L);

    // Act and Assert
    assertNotEquals(
        userAuthorizationData,
        new UserAuthorizationData("https://example.org/example", 1L, "Data"));
  }

  /**
   * Test {@link UserAuthorizationData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UserAuthorizationData#equals(Object)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean UserAuthorizationData.equals(Object)",
    "int UserAuthorizationData.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    UserAuthorizationData userAuthorizationData = new UserAuthorizationData();

    UserAuthorizationData userAuthorizationData2 = new UserAuthorizationData();
    userAuthorizationData2.setUserId(1L);

    // Act and Assert
    assertNotEquals(userAuthorizationData, userAuthorizationData2);
  }

  /**
   * Test {@link UserAuthorizationData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UserAuthorizationData#equals(Object)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean UserAuthorizationData.equals(Object)",
    "int UserAuthorizationData.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    UserAuthorizationData userAuthorizationData = new UserAuthorizationData();
    userAuthorizationData.setData(new UserAuthorizationData());

    // Act and Assert
    assertNotEquals(userAuthorizationData, new UserAuthorizationData());
  }

  /**
   * Test {@link UserAuthorizationData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UserAuthorizationData#equals(Object)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean UserAuthorizationData.equals(Object)",
    "int UserAuthorizationData.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new UserAuthorizationData(), null);
  }

  /**
   * Test {@link UserAuthorizationData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UserAuthorizationData#equals(Object)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean UserAuthorizationData.equals(Object)",
    "int UserAuthorizationData.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new UserAuthorizationData(), "Different type to UserAuthorizationData");
  }
}
