package org.symphonyoss.integration.authentication.api.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;

public class JwtUserDiffblueTest {
  /**
   * Test {@link JwtUser#equals(Object)}, and {@link JwtUser#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JwtUser#equals(Object)}
   *   <li>{@link JwtUser#hashCode()}
   * </ul>
   */
  @Test
  @MethodsUnderTest({"boolean JwtUser.equals(Object)", "int JwtUser.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    JwtUser jwtUser = new JwtUser();
    jwtUser.setAvatarSmallUrl("https://example.org/example");
    jwtUser.setAvatarUrl("https://example.org/example");
    jwtUser.setCompany("Company");
    jwtUser.setCompanyId("42");
    jwtUser.setDisplayName("Display Name");
    jwtUser.setEmailAddress("42 Main St");
    jwtUser.setFirstName("Jane");
    jwtUser.setId("42");
    jwtUser.setLastName("Doe");
    jwtUser.setLocation("Location");
    jwtUser.setTitle("Dr");
    jwtUser.setUsername("janedoe");

    JwtUser jwtUser2 = new JwtUser();
    jwtUser2.setAvatarSmallUrl("https://example.org/example");
    jwtUser2.setAvatarUrl("https://example.org/example");
    jwtUser2.setCompany("Company");
    jwtUser2.setCompanyId("42");
    jwtUser2.setDisplayName("Display Name");
    jwtUser2.setEmailAddress("42 Main St");
    jwtUser2.setFirstName("Jane");
    jwtUser2.setId("42");
    jwtUser2.setLastName("Doe");
    jwtUser2.setLocation("Location");
    jwtUser2.setTitle("Dr");
    jwtUser2.setUsername("janedoe");

    // Act and Assert
    assertEquals(jwtUser, jwtUser2);
    int expectedHashCodeResult = jwtUser.hashCode();
    assertEquals(expectedHashCodeResult, jwtUser2.hashCode());
  }

  /**
   * Test {@link JwtUser#equals(Object)}, and {@link JwtUser#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JwtUser#equals(Object)}
   *   <li>{@link JwtUser#hashCode()}
   * </ul>
   */
  @Test
  @MethodsUnderTest({"boolean JwtUser.equals(Object)", "int JwtUser.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    JwtUser jwtUser = new JwtUser();
    jwtUser.setAvatarSmallUrl("https://example.org/example");
    jwtUser.setAvatarUrl("https://example.org/example");
    jwtUser.setCompany("Company");
    jwtUser.setCompanyId("42");
    jwtUser.setDisplayName("Display Name");
    jwtUser.setEmailAddress("42 Main St");
    jwtUser.setFirstName("Jane");
    jwtUser.setId("42");
    jwtUser.setLastName("Doe");
    jwtUser.setLocation("Location");
    jwtUser.setTitle("Dr");
    jwtUser.setUsername("janedoe");

    // Act and Assert
    assertEquals(jwtUser, jwtUser);
    int expectedHashCodeResult = jwtUser.hashCode();
    assertEquals(expectedHashCodeResult, jwtUser.hashCode());
  }

  /**
   * Test {@link JwtUser#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link JwtUser#equals(Object)}
   */
  @Test
  @MethodsUnderTest({"boolean JwtUser.equals(Object)", "int JwtUser.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    JwtUser jwtUser = new JwtUser();
    jwtUser.setAvatarSmallUrl("Avatar Small Url");
    jwtUser.setAvatarUrl("https://example.org/example");
    jwtUser.setCompany("Company");
    jwtUser.setCompanyId("42");
    jwtUser.setDisplayName("Display Name");
    jwtUser.setEmailAddress("42 Main St");
    jwtUser.setFirstName("Jane");
    jwtUser.setId("42");
    jwtUser.setLastName("Doe");
    jwtUser.setLocation("Location");
    jwtUser.setTitle("Dr");
    jwtUser.setUsername("janedoe");

    JwtUser jwtUser2 = new JwtUser();
    jwtUser2.setAvatarSmallUrl("https://example.org/example");
    jwtUser2.setAvatarUrl("https://example.org/example");
    jwtUser2.setCompany("Company");
    jwtUser2.setCompanyId("42");
    jwtUser2.setDisplayName("Display Name");
    jwtUser2.setEmailAddress("42 Main St");
    jwtUser2.setFirstName("Jane");
    jwtUser2.setId("42");
    jwtUser2.setLastName("Doe");
    jwtUser2.setLocation("Location");
    jwtUser2.setTitle("Dr");
    jwtUser2.setUsername("janedoe");

    // Act and Assert
    assertNotEquals(jwtUser, jwtUser2);
  }

  /**
   * Test {@link JwtUser#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link JwtUser#equals(Object)}
   */
  @Test
  @MethodsUnderTest({"boolean JwtUser.equals(Object)", "int JwtUser.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    JwtUser jwtUser = new JwtUser();
    jwtUser.setAvatarSmallUrl("https://example.org/example");
    jwtUser.setAvatarUrl("Avatar Url");
    jwtUser.setCompany("Company");
    jwtUser.setCompanyId("42");
    jwtUser.setDisplayName("Display Name");
    jwtUser.setEmailAddress("42 Main St");
    jwtUser.setFirstName("Jane");
    jwtUser.setId("42");
    jwtUser.setLastName("Doe");
    jwtUser.setLocation("Location");
    jwtUser.setTitle("Dr");
    jwtUser.setUsername("janedoe");

    JwtUser jwtUser2 = new JwtUser();
    jwtUser2.setAvatarSmallUrl("https://example.org/example");
    jwtUser2.setAvatarUrl("https://example.org/example");
    jwtUser2.setCompany("Company");
    jwtUser2.setCompanyId("42");
    jwtUser2.setDisplayName("Display Name");
    jwtUser2.setEmailAddress("42 Main St");
    jwtUser2.setFirstName("Jane");
    jwtUser2.setId("42");
    jwtUser2.setLastName("Doe");
    jwtUser2.setLocation("Location");
    jwtUser2.setTitle("Dr");
    jwtUser2.setUsername("janedoe");

    // Act and Assert
    assertNotEquals(jwtUser, jwtUser2);
  }

  /**
   * Test {@link JwtUser#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link JwtUser#equals(Object)}
   */
  @Test
  @MethodsUnderTest({"boolean JwtUser.equals(Object)", "int JwtUser.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    JwtUser jwtUser = new JwtUser();
    jwtUser.setAvatarSmallUrl("https://example.org/example");
    jwtUser.setAvatarUrl("https://example.org/example");
    jwtUser.setCompany(null);
    jwtUser.setCompanyId("42");
    jwtUser.setDisplayName("Display Name");
    jwtUser.setEmailAddress("42 Main St");
    jwtUser.setFirstName("Jane");
    jwtUser.setId("42");
    jwtUser.setLastName("Doe");
    jwtUser.setLocation("Location");
    jwtUser.setTitle("Dr");
    jwtUser.setUsername("janedoe");

    JwtUser jwtUser2 = new JwtUser();
    jwtUser2.setAvatarSmallUrl("https://example.org/example");
    jwtUser2.setAvatarUrl("https://example.org/example");
    jwtUser2.setCompany("Company");
    jwtUser2.setCompanyId("42");
    jwtUser2.setDisplayName("Display Name");
    jwtUser2.setEmailAddress("42 Main St");
    jwtUser2.setFirstName("Jane");
    jwtUser2.setId("42");
    jwtUser2.setLastName("Doe");
    jwtUser2.setLocation("Location");
    jwtUser2.setTitle("Dr");
    jwtUser2.setUsername("janedoe");

    // Act and Assert
    assertNotEquals(jwtUser, jwtUser2);
  }

  /**
   * Test {@link JwtUser#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link JwtUser#equals(Object)}
   */
  @Test
  @MethodsUnderTest({"boolean JwtUser.equals(Object)", "int JwtUser.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    JwtUser jwtUser = new JwtUser();
    jwtUser.setAvatarSmallUrl("https://example.org/example");
    jwtUser.setAvatarUrl("https://example.org/example");
    jwtUser.setCompany("Company");
    jwtUser.setCompanyId("Company Id");
    jwtUser.setDisplayName("Display Name");
    jwtUser.setEmailAddress("42 Main St");
    jwtUser.setFirstName("Jane");
    jwtUser.setId("42");
    jwtUser.setLastName("Doe");
    jwtUser.setLocation("Location");
    jwtUser.setTitle("Dr");
    jwtUser.setUsername("janedoe");

    JwtUser jwtUser2 = new JwtUser();
    jwtUser2.setAvatarSmallUrl("https://example.org/example");
    jwtUser2.setAvatarUrl("https://example.org/example");
    jwtUser2.setCompany("Company");
    jwtUser2.setCompanyId("42");
    jwtUser2.setDisplayName("Display Name");
    jwtUser2.setEmailAddress("42 Main St");
    jwtUser2.setFirstName("Jane");
    jwtUser2.setId("42");
    jwtUser2.setLastName("Doe");
    jwtUser2.setLocation("Location");
    jwtUser2.setTitle("Dr");
    jwtUser2.setUsername("janedoe");

    // Act and Assert
    assertNotEquals(jwtUser, jwtUser2);
  }

  /**
   * Test {@link JwtUser#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link JwtUser#equals(Object)}
   */
  @Test
  @MethodsUnderTest({"boolean JwtUser.equals(Object)", "int JwtUser.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    JwtUser jwtUser = new JwtUser();
    jwtUser.setAvatarSmallUrl("https://example.org/example");
    jwtUser.setAvatarUrl("https://example.org/example");
    jwtUser.setCompany("Company");
    jwtUser.setCompanyId("42");
    jwtUser.setDisplayName(null);
    jwtUser.setEmailAddress("42 Main St");
    jwtUser.setFirstName("Jane");
    jwtUser.setId("42");
    jwtUser.setLastName("Doe");
    jwtUser.setLocation("Location");
    jwtUser.setTitle("Dr");
    jwtUser.setUsername("janedoe");

    JwtUser jwtUser2 = new JwtUser();
    jwtUser2.setAvatarSmallUrl("https://example.org/example");
    jwtUser2.setAvatarUrl("https://example.org/example");
    jwtUser2.setCompany("Company");
    jwtUser2.setCompanyId("42");
    jwtUser2.setDisplayName("Display Name");
    jwtUser2.setEmailAddress("42 Main St");
    jwtUser2.setFirstName("Jane");
    jwtUser2.setId("42");
    jwtUser2.setLastName("Doe");
    jwtUser2.setLocation("Location");
    jwtUser2.setTitle("Dr");
    jwtUser2.setUsername("janedoe");

    // Act and Assert
    assertNotEquals(jwtUser, jwtUser2);
  }

  /**
   * Test {@link JwtUser#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link JwtUser#equals(Object)}
   */
  @Test
  @MethodsUnderTest({"boolean JwtUser.equals(Object)", "int JwtUser.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    JwtUser jwtUser = new JwtUser();
    jwtUser.setAvatarSmallUrl("https://example.org/example");
    jwtUser.setAvatarUrl("https://example.org/example");
    jwtUser.setCompany("Company");
    jwtUser.setCompanyId("42");
    jwtUser.setDisplayName("Display Name");
    jwtUser.setEmailAddress("17 High St");
    jwtUser.setFirstName("Jane");
    jwtUser.setId("42");
    jwtUser.setLastName("Doe");
    jwtUser.setLocation("Location");
    jwtUser.setTitle("Dr");
    jwtUser.setUsername("janedoe");

    JwtUser jwtUser2 = new JwtUser();
    jwtUser2.setAvatarSmallUrl("https://example.org/example");
    jwtUser2.setAvatarUrl("https://example.org/example");
    jwtUser2.setCompany("Company");
    jwtUser2.setCompanyId("42");
    jwtUser2.setDisplayName("Display Name");
    jwtUser2.setEmailAddress("42 Main St");
    jwtUser2.setFirstName("Jane");
    jwtUser2.setId("42");
    jwtUser2.setLastName("Doe");
    jwtUser2.setLocation("Location");
    jwtUser2.setTitle("Dr");
    jwtUser2.setUsername("janedoe");

    // Act and Assert
    assertNotEquals(jwtUser, jwtUser2);
  }

  /**
   * Test {@link JwtUser#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link JwtUser#equals(Object)}
   */
  @Test
  @MethodsUnderTest({"boolean JwtUser.equals(Object)", "int JwtUser.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    JwtUser jwtUser = new JwtUser();
    jwtUser.setAvatarSmallUrl("https://example.org/example");
    jwtUser.setAvatarUrl("https://example.org/example");
    jwtUser.setCompany("Company");
    jwtUser.setCompanyId("42");
    jwtUser.setDisplayName("Display Name");
    jwtUser.setEmailAddress("42 Main St");
    jwtUser.setFirstName("John");
    jwtUser.setId("42");
    jwtUser.setLastName("Doe");
    jwtUser.setLocation("Location");
    jwtUser.setTitle("Dr");
    jwtUser.setUsername("janedoe");

    JwtUser jwtUser2 = new JwtUser();
    jwtUser2.setAvatarSmallUrl("https://example.org/example");
    jwtUser2.setAvatarUrl("https://example.org/example");
    jwtUser2.setCompany("Company");
    jwtUser2.setCompanyId("42");
    jwtUser2.setDisplayName("Display Name");
    jwtUser2.setEmailAddress("42 Main St");
    jwtUser2.setFirstName("Jane");
    jwtUser2.setId("42");
    jwtUser2.setLastName("Doe");
    jwtUser2.setLocation("Location");
    jwtUser2.setTitle("Dr");
    jwtUser2.setUsername("janedoe");

    // Act and Assert
    assertNotEquals(jwtUser, jwtUser2);
  }

  /**
   * Test {@link JwtUser#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link JwtUser#equals(Object)}
   */
  @Test
  @MethodsUnderTest({"boolean JwtUser.equals(Object)", "int JwtUser.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    JwtUser jwtUser = new JwtUser();
    jwtUser.setAvatarSmallUrl("https://example.org/example");
    jwtUser.setAvatarUrl("https://example.org/example");
    jwtUser.setCompany("Company");
    jwtUser.setCompanyId("42");
    jwtUser.setDisplayName("Display Name");
    jwtUser.setEmailAddress("42 Main St");
    jwtUser.setFirstName("Jane");
    jwtUser.setId("Id");
    jwtUser.setLastName("Doe");
    jwtUser.setLocation("Location");
    jwtUser.setTitle("Dr");
    jwtUser.setUsername("janedoe");

    JwtUser jwtUser2 = new JwtUser();
    jwtUser2.setAvatarSmallUrl("https://example.org/example");
    jwtUser2.setAvatarUrl("https://example.org/example");
    jwtUser2.setCompany("Company");
    jwtUser2.setCompanyId("42");
    jwtUser2.setDisplayName("Display Name");
    jwtUser2.setEmailAddress("42 Main St");
    jwtUser2.setFirstName("Jane");
    jwtUser2.setId("42");
    jwtUser2.setLastName("Doe");
    jwtUser2.setLocation("Location");
    jwtUser2.setTitle("Dr");
    jwtUser2.setUsername("janedoe");

    // Act and Assert
    assertNotEquals(jwtUser, jwtUser2);
  }

  /**
   * Test {@link JwtUser#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link JwtUser#equals(Object)}
   */
  @Test
  @MethodsUnderTest({"boolean JwtUser.equals(Object)", "int JwtUser.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    JwtUser jwtUser = new JwtUser();
    jwtUser.setAvatarSmallUrl("https://example.org/example");
    jwtUser.setAvatarUrl("https://example.org/example");
    jwtUser.setCompany("Company");
    jwtUser.setCompanyId("42");
    jwtUser.setDisplayName("Display Name");
    jwtUser.setEmailAddress("42 Main St");
    jwtUser.setFirstName("Jane");
    jwtUser.setId("42");
    jwtUser.setLastName("Smith");
    jwtUser.setLocation("Location");
    jwtUser.setTitle("Dr");
    jwtUser.setUsername("janedoe");

    JwtUser jwtUser2 = new JwtUser();
    jwtUser2.setAvatarSmallUrl("https://example.org/example");
    jwtUser2.setAvatarUrl("https://example.org/example");
    jwtUser2.setCompany("Company");
    jwtUser2.setCompanyId("42");
    jwtUser2.setDisplayName("Display Name");
    jwtUser2.setEmailAddress("42 Main St");
    jwtUser2.setFirstName("Jane");
    jwtUser2.setId("42");
    jwtUser2.setLastName("Doe");
    jwtUser2.setLocation("Location");
    jwtUser2.setTitle("Dr");
    jwtUser2.setUsername("janedoe");

    // Act and Assert
    assertNotEquals(jwtUser, jwtUser2);
  }

  /**
   * Test {@link JwtUser#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link JwtUser#equals(Object)}
   */
  @Test
  @MethodsUnderTest({"boolean JwtUser.equals(Object)", "int JwtUser.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    JwtUser jwtUser = new JwtUser();
    jwtUser.setAvatarSmallUrl("https://example.org/example");
    jwtUser.setAvatarUrl("https://example.org/example");
    jwtUser.setCompany("Company");
    jwtUser.setCompanyId("42");
    jwtUser.setDisplayName("Display Name");
    jwtUser.setEmailAddress("42 Main St");
    jwtUser.setFirstName("Jane");
    jwtUser.setId("42");
    jwtUser.setLastName("Doe");
    jwtUser.setLocation(null);
    jwtUser.setTitle("Dr");
    jwtUser.setUsername("janedoe");

    JwtUser jwtUser2 = new JwtUser();
    jwtUser2.setAvatarSmallUrl("https://example.org/example");
    jwtUser2.setAvatarUrl("https://example.org/example");
    jwtUser2.setCompany("Company");
    jwtUser2.setCompanyId("42");
    jwtUser2.setDisplayName("Display Name");
    jwtUser2.setEmailAddress("42 Main St");
    jwtUser2.setFirstName("Jane");
    jwtUser2.setId("42");
    jwtUser2.setLastName("Doe");
    jwtUser2.setLocation("Location");
    jwtUser2.setTitle("Dr");
    jwtUser2.setUsername("janedoe");

    // Act and Assert
    assertNotEquals(jwtUser, jwtUser2);
  }

  /**
   * Test {@link JwtUser#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link JwtUser#equals(Object)}
   */
  @Test
  @MethodsUnderTest({"boolean JwtUser.equals(Object)", "int JwtUser.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    JwtUser jwtUser = new JwtUser();
    jwtUser.setAvatarSmallUrl("https://example.org/example");
    jwtUser.setAvatarUrl("https://example.org/example");
    jwtUser.setCompany("Company");
    jwtUser.setCompanyId("42");
    jwtUser.setDisplayName("Display Name");
    jwtUser.setEmailAddress("42 Main St");
    jwtUser.setFirstName("Jane");
    jwtUser.setId("42");
    jwtUser.setLastName("Doe");
    jwtUser.setLocation("Location");
    jwtUser.setTitle("Mr");
    jwtUser.setUsername("janedoe");

    JwtUser jwtUser2 = new JwtUser();
    jwtUser2.setAvatarSmallUrl("https://example.org/example");
    jwtUser2.setAvatarUrl("https://example.org/example");
    jwtUser2.setCompany("Company");
    jwtUser2.setCompanyId("42");
    jwtUser2.setDisplayName("Display Name");
    jwtUser2.setEmailAddress("42 Main St");
    jwtUser2.setFirstName("Jane");
    jwtUser2.setId("42");
    jwtUser2.setLastName("Doe");
    jwtUser2.setLocation("Location");
    jwtUser2.setTitle("Dr");
    jwtUser2.setUsername("janedoe");

    // Act and Assert
    assertNotEquals(jwtUser, jwtUser2);
  }

  /**
   * Test {@link JwtUser#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link JwtUser#equals(Object)}
   */
  @Test
  @MethodsUnderTest({"boolean JwtUser.equals(Object)", "int JwtUser.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    JwtUser jwtUser = new JwtUser();
    jwtUser.setAvatarSmallUrl("https://example.org/example");
    jwtUser.setAvatarUrl("https://example.org/example");
    jwtUser.setCompany("Company");
    jwtUser.setCompanyId("42");
    jwtUser.setDisplayName("Display Name");
    jwtUser.setEmailAddress("42 Main St");
    jwtUser.setFirstName("Jane");
    jwtUser.setId("42");
    jwtUser.setLastName("Doe");
    jwtUser.setLocation("Location");
    jwtUser.setTitle("Dr");
    jwtUser.setUsername("Username");

    JwtUser jwtUser2 = new JwtUser();
    jwtUser2.setAvatarSmallUrl("https://example.org/example");
    jwtUser2.setAvatarUrl("https://example.org/example");
    jwtUser2.setCompany("Company");
    jwtUser2.setCompanyId("42");
    jwtUser2.setDisplayName("Display Name");
    jwtUser2.setEmailAddress("42 Main St");
    jwtUser2.setFirstName("Jane");
    jwtUser2.setId("42");
    jwtUser2.setLastName("Doe");
    jwtUser2.setLocation("Location");
    jwtUser2.setTitle("Dr");
    jwtUser2.setUsername("janedoe");

    // Act and Assert
    assertNotEquals(jwtUser, jwtUser2);
  }

  /**
   * Test {@link JwtUser#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link JwtUser#equals(Object)}
   */
  @Test
  @MethodsUnderTest({"boolean JwtUser.equals(Object)", "int JwtUser.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    JwtUser jwtUser = new JwtUser();
    jwtUser.setAvatarSmallUrl("https://example.org/example");
    jwtUser.setAvatarUrl("https://example.org/example");
    jwtUser.setCompany("Company");
    jwtUser.setCompanyId("42");
    jwtUser.setDisplayName("Display Name");
    jwtUser.setEmailAddress("42 Main St");
    jwtUser.setFirstName("Jane");
    jwtUser.setId("42");
    jwtUser.setLastName("Doe");
    jwtUser.setLocation("Location");
    jwtUser.setTitle("Dr");
    jwtUser.setUsername("janedoe");

    // Act and Assert
    assertNotEquals(jwtUser, null);
  }

  /**
   * Test {@link JwtUser#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link JwtUser#equals(Object)}
   */
  @Test
  @MethodsUnderTest({"boolean JwtUser.equals(Object)", "int JwtUser.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    JwtUser jwtUser = new JwtUser();
    jwtUser.setAvatarSmallUrl("https://example.org/example");
    jwtUser.setAvatarUrl("https://example.org/example");
    jwtUser.setCompany("Company");
    jwtUser.setCompanyId("42");
    jwtUser.setDisplayName("Display Name");
    jwtUser.setEmailAddress("42 Main St");
    jwtUser.setFirstName("Jane");
    jwtUser.setId("42");
    jwtUser.setLastName("Doe");
    jwtUser.setLocation("Location");
    jwtUser.setTitle("Dr");
    jwtUser.setUsername("janedoe");

    // Act and Assert
    assertNotEquals(jwtUser, "Different type to JwtUser");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link JwtUser}
   *   <li>{@link JwtUser#setAvatarSmallUrl(String)}
   *   <li>{@link JwtUser#setAvatarUrl(String)}
   *   <li>{@link JwtUser#setCompany(String)}
   *   <li>{@link JwtUser#setCompanyId(String)}
   *   <li>{@link JwtUser#setDisplayName(String)}
   *   <li>{@link JwtUser#setEmailAddress(String)}
   *   <li>{@link JwtUser#setFirstName(String)}
   *   <li>{@link JwtUser#setId(String)}
   *   <li>{@link JwtUser#setLastName(String)}
   *   <li>{@link JwtUser#setLocation(String)}
   *   <li>{@link JwtUser#setTitle(String)}
   *   <li>{@link JwtUser#setUsername(String)}
   *   <li>{@link JwtUser#getAvatarSmallUrl()}
   *   <li>{@link JwtUser#getAvatarUrl()}
   *   <li>{@link JwtUser#getCompany()}
   *   <li>{@link JwtUser#getCompanyId()}
   *   <li>{@link JwtUser#getDisplayName()}
   *   <li>{@link JwtUser#getEmailAddress()}
   *   <li>{@link JwtUser#getFirstName()}
   *   <li>{@link JwtUser#getId()}
   *   <li>{@link JwtUser#getLastName()}
   *   <li>{@link JwtUser#getLocation()}
   *   <li>{@link JwtUser#getTitle()}
   *   <li>{@link JwtUser#getUsername()}
   * </ul>
   */
  @Test
  @MethodsUnderTest({"void JwtUser.<init>()", "String JwtUser.getAvatarSmallUrl()", "String JwtUser.getAvatarUrl()",
      "String JwtUser.getCompany()", "String JwtUser.getCompanyId()", "String JwtUser.getDisplayName()",
      "String JwtUser.getEmailAddress()", "String JwtUser.getFirstName()", "String JwtUser.getId()",
      "String JwtUser.getLastName()", "String JwtUser.getLocation()", "String JwtUser.getTitle()",
      "String JwtUser.getUsername()", "void JwtUser.setAvatarSmallUrl(String)", "void JwtUser.setAvatarUrl(String)",
      "void JwtUser.setCompany(String)", "void JwtUser.setCompanyId(String)", "void JwtUser.setDisplayName(String)",
      "void JwtUser.setEmailAddress(String)", "void JwtUser.setFirstName(String)", "void JwtUser.setId(String)",
      "void JwtUser.setLastName(String)", "void JwtUser.setLocation(String)", "void JwtUser.setTitle(String)",
      "void JwtUser.setUsername(String)"})
  public void testGettersAndSetters() {
    // Arrange and Act
    JwtUser actualJwtUser = new JwtUser();
    actualJwtUser.setAvatarSmallUrl("https://example.org/example");
    actualJwtUser.setAvatarUrl("https://example.org/example");
    actualJwtUser.setCompany("Company");
    actualJwtUser.setCompanyId("42");
    actualJwtUser.setDisplayName("Display Name");
    actualJwtUser.setEmailAddress("42 Main St");
    actualJwtUser.setFirstName("Jane");
    actualJwtUser.setId("42");
    actualJwtUser.setLastName("Doe");
    actualJwtUser.setLocation("Location");
    actualJwtUser.setTitle("Dr");
    actualJwtUser.setUsername("janedoe");
    String actualAvatarSmallUrl = actualJwtUser.getAvatarSmallUrl();
    String actualAvatarUrl = actualJwtUser.getAvatarUrl();
    String actualCompany = actualJwtUser.getCompany();
    String actualCompanyId = actualJwtUser.getCompanyId();
    String actualDisplayName = actualJwtUser.getDisplayName();
    String actualEmailAddress = actualJwtUser.getEmailAddress();
    String actualFirstName = actualJwtUser.getFirstName();
    String actualId = actualJwtUser.getId();
    String actualLastName = actualJwtUser.getLastName();
    String actualLocation = actualJwtUser.getLocation();
    String actualTitle = actualJwtUser.getTitle();

    // Assert
    assertEquals("42 Main St", actualEmailAddress);
    assertEquals("42", actualCompanyId);
    assertEquals("42", actualId);
    assertEquals("Company", actualCompany);
    assertEquals("Display Name", actualDisplayName);
    assertEquals("Doe", actualLastName);
    assertEquals("Dr", actualTitle);
    assertEquals("Jane", actualFirstName);
    assertEquals("Location", actualLocation);
    assertEquals("https://example.org/example", actualAvatarSmallUrl);
    assertEquals("https://example.org/example", actualAvatarUrl);
    assertEquals("janedoe", actualJwtUser.getUsername());
  }
}
