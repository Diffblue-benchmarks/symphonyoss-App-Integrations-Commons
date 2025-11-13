package org.symphonyoss.integration.authentication.api.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;

public class JwtPayloadDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link JwtPayload#JwtPayload()}
   *   <li>{@link JwtPayload#setApplicationId(String)}
   *   <li>{@link JwtPayload#setCompanyName(String)}
   *   <li>{@link JwtPayload#setExpirationDateInSeconds(Long)}
   *   <li>{@link JwtPayload#setUser(JwtUser)}
   *   <li>{@link JwtPayload#setUserId(String)}
   *   <li>{@link JwtPayload#getApplicationId()}
   *   <li>{@link JwtPayload#getCompanyName()}
   *   <li>{@link JwtPayload#getExpirationDateInSeconds()}
   *   <li>{@link JwtPayload#getUser()}
   *   <li>{@link JwtPayload#getUserId()}
   * </ul>
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void JwtPayload.<init>()",
    "void JwtPayload.<init>(String, String, String, Long, JwtUser)",
    "String JwtPayload.getApplicationId()",
    "String JwtPayload.getCompanyName()",
    "Long JwtPayload.getExpirationDateInSeconds()",
    "JwtUser JwtPayload.getUser()",
    "String JwtPayload.getUserId()",
    "void JwtPayload.setApplicationId(String)",
    "void JwtPayload.setCompanyName(String)",
    "void JwtPayload.setExpirationDateInSeconds(Long)",
    "void JwtPayload.setUser(JwtUser)",
    "void JwtPayload.setUserId(String)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    JwtPayload actualJwtPayload = new JwtPayload();
    actualJwtPayload.setApplicationId("42");
    actualJwtPayload.setCompanyName("Company Name");
    actualJwtPayload.setExpirationDateInSeconds(1L);
    JwtUser user = new JwtUser();
    user.setAvatarSmallUrl("https://example.org/example");
    user.setAvatarUrl("https://example.org/example");
    user.setCompany("Company");
    user.setCompanyId("42");
    user.setDisplayName("Display Name");
    user.setEmailAddress("42 Main St");
    user.setFirstName("Jane");
    user.setId("42");
    user.setLastName("Doe");
    user.setLocation("Location");
    user.setTitle("Dr");
    user.setUsername("janedoe");
    actualJwtPayload.setUser(user);
    actualJwtPayload.setUserId("42");
    String actualApplicationId = actualJwtPayload.getApplicationId();
    String actualCompanyName = actualJwtPayload.getCompanyName();
    Long actualExpirationDateInSeconds = actualJwtPayload.getExpirationDateInSeconds();
    JwtUser actualUser = actualJwtPayload.getUser();

    // Assert
    assertEquals("42", actualApplicationId);
    assertEquals("42", actualJwtPayload.getUserId());
    assertEquals("Company Name", actualCompanyName);
    assertEquals(1L, actualExpirationDateInSeconds.longValue());
    assertSame(user, actualUser);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>Given {@code https://example.org/example}.
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link JwtPayload#JwtPayload(String, String, String, Long, JwtUser)}
   *   <li>{@link JwtPayload#setApplicationId(String)}
   *   <li>{@link JwtPayload#setCompanyName(String)}
   *   <li>{@link JwtPayload#setExpirationDateInSeconds(Long)}
   *   <li>{@link JwtPayload#setUser(JwtUser)}
   *   <li>{@link JwtPayload#setUserId(String)}
   *   <li>{@link JwtPayload#getApplicationId()}
   *   <li>{@link JwtPayload#getCompanyName()}
   *   <li>{@link JwtPayload#getExpirationDateInSeconds()}
   *   <li>{@link JwtPayload#getUser()}
   *   <li>{@link JwtPayload#getUserId()}
   * </ul>
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void JwtPayload.<init>()",
    "void JwtPayload.<init>(String, String, String, Long, JwtUser)",
    "String JwtPayload.getApplicationId()",
    "String JwtPayload.getCompanyName()",
    "Long JwtPayload.getExpirationDateInSeconds()",
    "JwtUser JwtPayload.getUser()",
    "String JwtPayload.getUserId()",
    "void JwtPayload.setApplicationId(String)",
    "void JwtPayload.setCompanyName(String)",
    "void JwtPayload.setExpirationDateInSeconds(Long)",
    "void JwtPayload.setUser(JwtUser)",
    "void JwtPayload.setUserId(String)"
  })
  public void testGettersAndSetters_givenHttpsExampleOrgExample_when42() {
    // Arrange
    JwtUser user = new JwtUser();
    user.setAvatarSmallUrl("https://example.org/example");
    user.setAvatarUrl("https://example.org/example");
    user.setCompany("Company");
    user.setCompanyId("42");
    user.setDisplayName("Display Name");
    user.setEmailAddress("42 Main St");
    user.setFirstName("Jane");
    user.setId("42");
    user.setLastName("Doe");
    user.setLocation("Location");
    user.setTitle("Dr");
    user.setUsername("janedoe");

    // Act
    JwtPayload actualJwtPayload = new JwtPayload("42", "Company Name", "42", 1L, user);
    actualJwtPayload.setApplicationId("42");
    actualJwtPayload.setCompanyName("Company Name");
    actualJwtPayload.setExpirationDateInSeconds(1L);
    JwtUser user2 = new JwtUser();
    user2.setAvatarSmallUrl("https://example.org/example");
    user2.setAvatarUrl("https://example.org/example");
    user2.setCompany("Company");
    user2.setCompanyId("42");
    user2.setDisplayName("Display Name");
    user2.setEmailAddress("42 Main St");
    user2.setFirstName("Jane");
    user2.setId("42");
    user2.setLastName("Doe");
    user2.setLocation("Location");
    user2.setTitle("Dr");
    user2.setUsername("janedoe");
    actualJwtPayload.setUser(user2);
    actualJwtPayload.setUserId("42");
    String actualApplicationId = actualJwtPayload.getApplicationId();
    String actualCompanyName = actualJwtPayload.getCompanyName();
    Long actualExpirationDateInSeconds = actualJwtPayload.getExpirationDateInSeconds();
    JwtUser actualUser = actualJwtPayload.getUser();

    // Assert
    assertEquals("42", actualApplicationId);
    assertEquals("42", actualJwtPayload.getUserId());
    assertEquals("Company Name", actualCompanyName);
    assertEquals(1L, actualExpirationDateInSeconds.longValue());
    assertSame(user2, actualUser);
  }

  /**
   * Test {@link JwtPayload#getExpirationDate()}.
   *
   * <p>Method under test: {@link JwtPayload#getExpirationDate()}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Date JwtPayload.getExpirationDate()"})
  public void testGetExpirationDate() {
    // Arrange
    JwtUser user = new JwtUser();
    user.setAvatarSmallUrl("https://example.org/example");
    user.setAvatarUrl("https://example.org/example");
    user.setCompany("Company");
    user.setCompanyId("42");
    user.setDisplayName("Display Name");
    user.setEmailAddress("42 Main St");
    user.setFirstName("Jane");
    user.setId("42");
    user.setLastName("Doe");
    user.setLocation("Location");
    user.setTitle("Dr");
    user.setUsername("janedoe");
    JwtPayload jwtPayload = new JwtPayload("42", "Company Name", "42", 0L, user);

    // Act and Assert
    assertNull(jwtPayload.getExpirationDate());
  }

  /**
   * Test {@link JwtPayload#getExpirationDate()}.
   *
   * <ul>
   *   <li>Given {@link JwtPayload#JwtPayload()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JwtPayload#getExpirationDate()}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Date JwtPayload.getExpirationDate()"})
  public void testGetExpirationDate_givenJwtPayload_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new JwtPayload().getExpirationDate());
  }

  /**
   * Test {@link JwtPayload#equals(Object)}, and {@link JwtPayload#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link JwtPayload#equals(Object)}
   *   <li>{@link JwtPayload#hashCode()}
   * </ul>
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JwtPayload.equals(Object)", "int JwtPayload.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    JwtPayload jwtPayload = new JwtPayload();
    JwtPayload jwtPayload2 = new JwtPayload();

    // Act and Assert
    assertEquals(jwtPayload, jwtPayload2);
    assertEquals(jwtPayload.hashCode(), jwtPayload2.hashCode());
  }

  /**
   * Test {@link JwtPayload#equals(Object)}, and {@link JwtPayload#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link JwtPayload#equals(Object)}
   *   <li>{@link JwtPayload#hashCode()}
   * </ul>
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JwtPayload.equals(Object)", "int JwtPayload.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    JwtPayload jwtPayload = new JwtPayload();

    // Act and Assert
    assertEquals(jwtPayload, jwtPayload);
    int expectedHashCodeResult = jwtPayload.hashCode();
    assertEquals(expectedHashCodeResult, jwtPayload.hashCode());
  }

  /**
   * Test {@link JwtPayload#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link JwtPayload#equals(Object)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JwtPayload.equals(Object)", "int JwtPayload.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    JwtUser user = new JwtUser();
    user.setAvatarSmallUrl("https://example.org/example");
    user.setAvatarUrl("https://example.org/example");
    user.setCompany("Company");
    user.setCompanyId("42");
    user.setDisplayName("Display Name");
    user.setEmailAddress("42 Main St");
    user.setFirstName("Jane");
    user.setId("42");
    user.setLastName("Doe");
    user.setLocation("Location");
    user.setTitle("Dr");
    user.setUsername("janedoe");
    JwtPayload jwtPayload = new JwtPayload("42", "Company Name", "42", 1L, user);

    // Act and Assert
    assertNotEquals(jwtPayload, new JwtPayload());
  }

  /**
   * Test {@link JwtPayload#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link JwtPayload#equals(Object)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JwtPayload.equals(Object)", "int JwtPayload.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    JwtPayload jwtPayload = new JwtPayload();
    jwtPayload.setCompanyName("Company Name");

    // Act and Assert
    assertNotEquals(jwtPayload, new JwtPayload());
  }

  /**
   * Test {@link JwtPayload#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link JwtPayload#equals(Object)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JwtPayload.equals(Object)", "int JwtPayload.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    JwtPayload jwtPayload = new JwtPayload();
    jwtPayload.setUserId("42");

    // Act and Assert
    assertNotEquals(jwtPayload, new JwtPayload());
  }

  /**
   * Test {@link JwtPayload#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link JwtPayload#equals(Object)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JwtPayload.equals(Object)", "int JwtPayload.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    JwtPayload jwtPayload = new JwtPayload();
    jwtPayload.setExpirationDateInSeconds(1L);

    // Act and Assert
    assertNotEquals(jwtPayload, new JwtPayload());
  }

  /**
   * Test {@link JwtPayload#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link JwtPayload#equals(Object)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JwtPayload.equals(Object)", "int JwtPayload.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    JwtUser user = new JwtUser();
    user.setAvatarSmallUrl("https://example.org/example");
    user.setAvatarUrl("https://example.org/example");
    user.setCompany("Company");
    user.setCompanyId("42");
    user.setDisplayName("Display Name");
    user.setEmailAddress("42 Main St");
    user.setFirstName("Jane");
    user.setId("42");
    user.setLastName("Doe");
    user.setLocation("Location");
    user.setTitle("Dr");
    user.setUsername("janedoe");

    JwtPayload jwtPayload = new JwtPayload();
    jwtPayload.setUser(user);

    // Act and Assert
    assertNotEquals(jwtPayload, new JwtPayload());
  }

  /**
   * Test {@link JwtPayload#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link JwtPayload#equals(Object)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JwtPayload.equals(Object)", "int JwtPayload.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new JwtPayload(), null);
  }

  /**
   * Test {@link JwtPayload#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link JwtPayload#equals(Object)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JwtPayload.equals(Object)", "int JwtPayload.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new JwtPayload(), "Different type to JwtPayload");
  }
}
