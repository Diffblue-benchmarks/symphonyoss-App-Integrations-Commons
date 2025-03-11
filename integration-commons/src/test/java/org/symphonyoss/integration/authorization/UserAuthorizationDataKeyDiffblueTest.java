package org.symphonyoss.integration.authorization;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;

public class UserAuthorizationDataKeyDiffblueTest {
  /**
   * Test {@link UserAuthorizationDataKey#equals(Object)}, and {@link UserAuthorizationDataKey#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link UserAuthorizationDataKey#equals(Object)}
   *   <li>{@link UserAuthorizationDataKey#hashCode()}
   * </ul>
   */
  @Test
  @MethodsUnderTest({"boolean UserAuthorizationDataKey.equals(Object)", "int UserAuthorizationDataKey.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    UserAuthorizationDataKey userAuthorizationDataKey = new UserAuthorizationDataKey("42",
        "https://example.org/example", 1L);
    UserAuthorizationDataKey userAuthorizationDataKey2 = new UserAuthorizationDataKey("42",
        "https://example.org/example", 1L);

    // Act and Assert
    assertEquals(userAuthorizationDataKey, userAuthorizationDataKey2);
    int expectedHashCodeResult = userAuthorizationDataKey.hashCode();
    assertEquals(expectedHashCodeResult, userAuthorizationDataKey2.hashCode());
  }

  /**
   * Test {@link UserAuthorizationDataKey#equals(Object)}, and {@link UserAuthorizationDataKey#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link UserAuthorizationDataKey#equals(Object)}
   *   <li>{@link UserAuthorizationDataKey#hashCode()}
   * </ul>
   */
  @Test
  @MethodsUnderTest({"boolean UserAuthorizationDataKey.equals(Object)", "int UserAuthorizationDataKey.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    UserAuthorizationDataKey userAuthorizationDataKey = new UserAuthorizationDataKey(null,
        "https://example.org/example", 1L);
    UserAuthorizationDataKey userAuthorizationDataKey2 = new UserAuthorizationDataKey(null,
        "https://example.org/example", 1L);

    // Act and Assert
    assertEquals(userAuthorizationDataKey, userAuthorizationDataKey2);
    int expectedHashCodeResult = userAuthorizationDataKey.hashCode();
    assertEquals(expectedHashCodeResult, userAuthorizationDataKey2.hashCode());
  }

  /**
   * Test {@link UserAuthorizationDataKey#equals(Object)}, and {@link UserAuthorizationDataKey#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link UserAuthorizationDataKey#equals(Object)}
   *   <li>{@link UserAuthorizationDataKey#hashCode()}
   * </ul>
   */
  @Test
  @MethodsUnderTest({"boolean UserAuthorizationDataKey.equals(Object)", "int UserAuthorizationDataKey.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    UserAuthorizationDataKey userAuthorizationDataKey = new UserAuthorizationDataKey("42", null, 1L);
    UserAuthorizationDataKey userAuthorizationDataKey2 = new UserAuthorizationDataKey("42", null, 1L);

    // Act and Assert
    assertEquals(userAuthorizationDataKey, userAuthorizationDataKey2);
    int expectedHashCodeResult = userAuthorizationDataKey.hashCode();
    assertEquals(expectedHashCodeResult, userAuthorizationDataKey2.hashCode());
  }

  /**
   * Test {@link UserAuthorizationDataKey#equals(Object)}, and {@link UserAuthorizationDataKey#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link UserAuthorizationDataKey#equals(Object)}
   *   <li>{@link UserAuthorizationDataKey#hashCode()}
   * </ul>
   */
  @Test
  @MethodsUnderTest({"boolean UserAuthorizationDataKey.equals(Object)", "int UserAuthorizationDataKey.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    UserAuthorizationDataKey userAuthorizationDataKey = new UserAuthorizationDataKey("42",
        "https://example.org/example", null);
    UserAuthorizationDataKey userAuthorizationDataKey2 = new UserAuthorizationDataKey("42",
        "https://example.org/example", null);

    // Act and Assert
    assertEquals(userAuthorizationDataKey, userAuthorizationDataKey2);
    int expectedHashCodeResult = userAuthorizationDataKey.hashCode();
    assertEquals(expectedHashCodeResult, userAuthorizationDataKey2.hashCode());
  }

  /**
   * Test {@link UserAuthorizationDataKey#equals(Object)}, and {@link UserAuthorizationDataKey#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link UserAuthorizationDataKey#equals(Object)}
   *   <li>{@link UserAuthorizationDataKey#hashCode()}
   * </ul>
   */
  @Test
  @MethodsUnderTest({"boolean UserAuthorizationDataKey.equals(Object)", "int UserAuthorizationDataKey.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    UserAuthorizationDataKey userAuthorizationDataKey = new UserAuthorizationDataKey("42",
        "https://example.org/example", 1L);

    // Act and Assert
    assertEquals(userAuthorizationDataKey, userAuthorizationDataKey);
    int expectedHashCodeResult = userAuthorizationDataKey.hashCode();
    assertEquals(expectedHashCodeResult, userAuthorizationDataKey.hashCode());
  }

  /**
   * Test {@link UserAuthorizationDataKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserAuthorizationDataKey#equals(Object)}
   */
  @Test
  @MethodsUnderTest({"boolean UserAuthorizationDataKey.equals(Object)", "int UserAuthorizationDataKey.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    UserAuthorizationDataKey userAuthorizationDataKey = new UserAuthorizationDataKey("https://example.org/example",
        "https://example.org/example", 1L);

    // Act and Assert
    assertNotEquals(userAuthorizationDataKey, new UserAuthorizationDataKey("42", "https://example.org/example", 1L));
  }

  /**
   * Test {@link UserAuthorizationDataKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserAuthorizationDataKey#equals(Object)}
   */
  @Test
  @MethodsUnderTest({"boolean UserAuthorizationDataKey.equals(Object)", "int UserAuthorizationDataKey.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    UserAuthorizationDataKey userAuthorizationDataKey = new UserAuthorizationDataKey(null,
        "https://example.org/example", 1L);

    // Act and Assert
    assertNotEquals(userAuthorizationDataKey, new UserAuthorizationDataKey("42", "https://example.org/example", 1L));
  }

  /**
   * Test {@link UserAuthorizationDataKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserAuthorizationDataKey#equals(Object)}
   */
  @Test
  @MethodsUnderTest({"boolean UserAuthorizationDataKey.equals(Object)", "int UserAuthorizationDataKey.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    UserAuthorizationDataKey userAuthorizationDataKey = new UserAuthorizationDataKey("42", "42", 1L);

    // Act and Assert
    assertNotEquals(userAuthorizationDataKey, new UserAuthorizationDataKey("42", "https://example.org/example", 1L));
  }

  /**
   * Test {@link UserAuthorizationDataKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserAuthorizationDataKey#equals(Object)}
   */
  @Test
  @MethodsUnderTest({"boolean UserAuthorizationDataKey.equals(Object)", "int UserAuthorizationDataKey.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    UserAuthorizationDataKey userAuthorizationDataKey = new UserAuthorizationDataKey("42", null, 1L);

    // Act and Assert
    assertNotEquals(userAuthorizationDataKey, new UserAuthorizationDataKey("42", "https://example.org/example", 1L));
  }

  /**
   * Test {@link UserAuthorizationDataKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserAuthorizationDataKey#equals(Object)}
   */
  @Test
  @MethodsUnderTest({"boolean UserAuthorizationDataKey.equals(Object)", "int UserAuthorizationDataKey.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    UserAuthorizationDataKey userAuthorizationDataKey = new UserAuthorizationDataKey("42",
        "https://example.org/example", null);

    // Act and Assert
    assertNotEquals(userAuthorizationDataKey, new UserAuthorizationDataKey("42", "https://example.org/example", 1L));
  }

  /**
   * Test {@link UserAuthorizationDataKey#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserAuthorizationDataKey#equals(Object)}
   */
  @Test
  @MethodsUnderTest({"boolean UserAuthorizationDataKey.equals(Object)", "int UserAuthorizationDataKey.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new UserAuthorizationDataKey("42", "https://example.org/example", 1L), null);
  }

  /**
   * Test {@link UserAuthorizationDataKey#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserAuthorizationDataKey#equals(Object)}
   */
  @Test
  @MethodsUnderTest({"boolean UserAuthorizationDataKey.equals(Object)", "int UserAuthorizationDataKey.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new UserAuthorizationDataKey("42", "https://example.org/example", 1L),
        "Different type to UserAuthorizationDataKey");
  }
}
