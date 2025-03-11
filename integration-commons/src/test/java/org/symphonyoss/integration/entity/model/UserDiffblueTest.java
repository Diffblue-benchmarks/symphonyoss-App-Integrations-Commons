package org.symphonyoss.integration.entity.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import org.junit.Test;
import org.symphonyoss.integration.entity.Attribute;
import org.symphonyoss.integration.entity.Entity;

public class UserDiffblueTest {
  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) DisplayName is empty string.</li>
   *   <li>Then return Name is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserDisplayNameIsEmptyString_thenReturnNameIsNull() {
    // Arrange
    User user = new User();
    user.setDisplayName("");
    user.setId(1L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity("Integration Name");

    // Assert
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(1, attributes.size());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.USER_ID, attributes.get(0).getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) DisplayName is lf.</li>
   *   <li>Then return Name is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserDisplayNameIsLf_thenReturnNameIsNull() {
    // Arrange
    User user = new User();
    user.setDisplayName("\n");
    user.setId(1L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity("Integration Name");

    // Assert
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(1, attributes.size());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.USER_ID, attributes.get(0).getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) EmailAddress is {@code 42 Main St}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserEmailAddressIs42MainSt() {
    // Arrange
    User user = new User();
    user.setEmailAddress("42 Main St");
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(1L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity("Integration Name").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("1", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is eight.</li>
   *   <li>Then return Attributes first Value is {@code 8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsEight_thenReturnAttributesFirstValueIs8() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(8L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity("Integration Name").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("8", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is eight.</li>
   *   <li>Then return Attributes first Value is {@code 8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsEight_thenReturnAttributesFirstValueIs82() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(8L);

    // Act and Assert
    List<Attribute> attributes = user
        .getMentionEntity("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>")
        .getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("8", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is eight.</li>
   *   <li>Then return Attributes first Value is {@code 8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsEight_thenReturnAttributesFirstValueIs83() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(8L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity("-").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("8", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is eight.</li>
   *   <li>Then return Attributes first Value is {@code 8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsEight_thenReturnAttributesFirstValueIs84() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(8L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity(EntityConstants.MENTION_TYPE).getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("8", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is eight.</li>
   *   <li>Then return Attributes first Value is {@code 8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsEight_thenReturnAttributesFirstValueIs85() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(8L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity(EntityConstants.USER_ID).getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("8", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is eight.</li>
   *   <li>Then return Attributes first Value is {@code 8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsEight_thenReturnAttributesFirstValueIs86() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(8L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity("org.symphony.oss.number.long").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("8", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is eight.</li>
   *   <li>Then return Attributes first Value is {@code 8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsEight_thenReturnAttributesFirstValueIs87() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(8L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity(null).getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("8", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is eight.</li>
   *   <li>Then return Attributes first Value is {@code 8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsEight_thenReturnAttributesFirstValueIs88() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(8L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity(EntityConstants.NAME_ENTITY_FIELD).getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("8", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is eight.</li>
   *   <li>Then return Attributes first Value is {@code 8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsEight_thenReturnAttributesFirstValueIs89() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(8L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity("").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("8", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is eight.</li>
   *   <li>When {@code 1.0}.</li>
   *   <li>Then return Attributes first Value is {@code 8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsEight_when10_thenReturnAttributesFirstValueIs8() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(8L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity("1.0").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("8", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is eight.</li>
   *   <li>When {@code 42}.</li>
   *   <li>Then return Attributes first Value is {@code 8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsEight_when42_thenReturnAttributesFirstValueIs8() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(8L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity("42").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("8", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is eight.</li>
   *   <li>When {@code <br/>
   * }.</li>
   *   <li>Then return Attributes first Value is {@code 8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsEight_whenBr_thenReturnAttributesFirstValueIs8() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(8L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity("<br/>").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("8", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is eight.</li>
   *   <li>When lf.</li>
   *   <li>Then return Attributes first Value is {@code 8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsEight_whenLf_thenReturnAttributesFirstValueIs8() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(8L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity("\n").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("8", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is five.</li>
   *   <li>Then return Attributes first Value is {@code 5}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsFive_thenReturnAttributesFirstValueIs5() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(5L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity("Integration Name").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("5", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is five.</li>
   *   <li>Then return Attributes first Value is {@code 5}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsFive_thenReturnAttributesFirstValueIs52() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(5L);

    // Act and Assert
    List<Attribute> attributes = user
        .getMentionEntity("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>")
        .getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("5", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is five.</li>
   *   <li>Then return Attributes first Value is {@code 5}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsFive_thenReturnAttributesFirstValueIs53() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(5L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity("-").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("5", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is five.</li>
   *   <li>Then return Attributes first Value is {@code 5}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsFive_thenReturnAttributesFirstValueIs54() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(5L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity(EntityConstants.MENTION_TYPE).getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("5", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is five.</li>
   *   <li>Then return Attributes first Value is {@code 5}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsFive_thenReturnAttributesFirstValueIs55() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(5L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity(EntityConstants.USER_ID).getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("5", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is five.</li>
   *   <li>Then return Attributes first Value is {@code 5}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsFive_thenReturnAttributesFirstValueIs56() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(5L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity("org.symphony.oss.number.long").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("5", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is five.</li>
   *   <li>Then return Attributes first Value is {@code 5}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsFive_thenReturnAttributesFirstValueIs57() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(5L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity(null).getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("5", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is five.</li>
   *   <li>Then return Attributes first Value is {@code 5}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsFive_thenReturnAttributesFirstValueIs58() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(5L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity(EntityConstants.NAME_ENTITY_FIELD).getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("5", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is five.</li>
   *   <li>Then return Attributes first Value is {@code 5}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsFive_thenReturnAttributesFirstValueIs59() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(5L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity("").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("5", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is five.</li>
   *   <li>When {@code 1.0}.</li>
   *   <li>Then return Attributes first Value is {@code 5}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsFive_when10_thenReturnAttributesFirstValueIs5() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(5L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity("1.0").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("5", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is five.</li>
   *   <li>When {@code 42}.</li>
   *   <li>Then return Attributes first Value is {@code 5}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsFive_when42_thenReturnAttributesFirstValueIs5() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(5L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity("42").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("5", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is five.</li>
   *   <li>When {@code <br/>
   * }.</li>
   *   <li>Then return Attributes first Value is {@code 5}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsFive_whenBr_thenReturnAttributesFirstValueIs5() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(5L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity("<br/>").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("5", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is five.</li>
   *   <li>When lf.</li>
   *   <li>Then return Attributes first Value is {@code 5}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsFive_whenLf_thenReturnAttributesFirstValueIs5() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(5L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity("\n").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("5", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is four.</li>
   *   <li>Then return Attributes first Value is {@code 4}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsFour_thenReturnAttributesFirstValueIs4() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(4L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity("Integration Name").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("4", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is four.</li>
   *   <li>Then return Attributes first Value is {@code 4}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsFour_thenReturnAttributesFirstValueIs42() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(4L);

    // Act and Assert
    List<Attribute> attributes = user
        .getMentionEntity("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>")
        .getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("4", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is four.</li>
   *   <li>Then return Attributes first Value is {@code 4}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsFour_thenReturnAttributesFirstValueIs43() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(4L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity("-").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("4", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is four.</li>
   *   <li>Then return Attributes first Value is {@code 4}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsFour_thenReturnAttributesFirstValueIs44() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(4L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity(EntityConstants.MENTION_TYPE).getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("4", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is four.</li>
   *   <li>Then return Attributes first Value is {@code 4}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsFour_thenReturnAttributesFirstValueIs45() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(4L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity(EntityConstants.USER_ID).getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("4", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is four.</li>
   *   <li>Then return Attributes first Value is {@code 4}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsFour_thenReturnAttributesFirstValueIs46() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(4L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity("org.symphony.oss.number.long").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("4", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is four.</li>
   *   <li>Then return Attributes first Value is {@code 4}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsFour_thenReturnAttributesFirstValueIs47() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(4L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity(null).getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("4", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is four.</li>
   *   <li>Then return Attributes first Value is {@code 4}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsFour_thenReturnAttributesFirstValueIs48() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(4L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity(EntityConstants.NAME_ENTITY_FIELD).getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("4", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is four.</li>
   *   <li>Then return Attributes first Value is {@code 4}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsFour_thenReturnAttributesFirstValueIs49() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(4L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity("").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("4", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is four.</li>
   *   <li>When {@code 1.0}.</li>
   *   <li>Then return Attributes first Value is {@code 4}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsFour_when10_thenReturnAttributesFirstValueIs4() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(4L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity("1.0").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("4", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is four.</li>
   *   <li>When {@code 42}.</li>
   *   <li>Then return Attributes first Value is {@code 4}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsFour_when42_thenReturnAttributesFirstValueIs4() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(4L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity("42").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("4", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is four.</li>
   *   <li>When {@code <br/>
   * }.</li>
   *   <li>Then return Attributes first Value is {@code 4}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsFour_whenBr_thenReturnAttributesFirstValueIs4() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(4L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity("<br/>").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("4", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is four.</li>
   *   <li>When lf.</li>
   *   <li>Then return Attributes first Value is {@code 4}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsFour_whenLf_thenReturnAttributesFirstValueIs4() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(4L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity("\n").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("4", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is minus one.</li>
   *   <li>Then return Attributes first Value is {@code -1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsMinusOne_thenReturnAttributesFirstValueIs1() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(-1L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity("Integration Name").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("-1", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is minus one.</li>
   *   <li>Then return Attributes first Value is {@code -1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsMinusOne_thenReturnAttributesFirstValueIs12() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(-1L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity("\n").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("-1", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is minus one.</li>
   *   <li>Then return Attributes first Value is {@code -1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsMinusOne_thenReturnAttributesFirstValueIs13() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(-1L);

    // Act and Assert
    List<Attribute> attributes = user
        .getMentionEntity("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>")
        .getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("-1", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is minus one.</li>
   *   <li>Then return Attributes first Value is {@code -1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsMinusOne_thenReturnAttributesFirstValueIs14() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(-1L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity("-").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("-1", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is minus one.</li>
   *   <li>Then return Attributes first Value is {@code -1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsMinusOne_thenReturnAttributesFirstValueIs15() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(-1L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity(EntityConstants.MENTION_TYPE).getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("-1", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is minus one.</li>
   *   <li>Then return Attributes first Value is {@code -1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsMinusOne_thenReturnAttributesFirstValueIs16() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(-1L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity("1.0").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("-1", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is minus one.</li>
   *   <li>Then return Attributes first Value is {@code -1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsMinusOne_thenReturnAttributesFirstValueIs17() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(-1L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity(EntityConstants.USER_ID).getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("-1", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is minus one.</li>
   *   <li>Then return Attributes first Value is {@code -1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsMinusOne_thenReturnAttributesFirstValueIs18() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(-1L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity("org.symphony.oss.number.long").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("-1", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is minus one.</li>
   *   <li>Then return Attributes first Value is {@code -1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsMinusOne_thenReturnAttributesFirstValueIs19() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(-1L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity(null).getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("-1", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is minus one.</li>
   *   <li>Then return Attributes first Value is {@code -1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsMinusOne_thenReturnAttributesFirstValueIs110() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(-1L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity("42").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("-1", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is minus one.</li>
   *   <li>Then return Attributes first Value is {@code -1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsMinusOne_thenReturnAttributesFirstValueIs111() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(-1L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity(EntityConstants.NAME_ENTITY_FIELD).getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("-1", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is minus one.</li>
   *   <li>Then return Attributes first Value is {@code -1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsMinusOne_thenReturnAttributesFirstValueIs112() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(-1L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity("").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("-1", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is minus one.</li>
   *   <li>Then return Attributes first Value is {@code -1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsMinusOne_thenReturnAttributesFirstValueIs113() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(-1L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity("<br/>").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("-1", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is nine.</li>
   *   <li>Then return Attributes first Value is {@code 9}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsNine_thenReturnAttributesFirstValueIs9() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(9L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity("Integration Name").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("9", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is nine.</li>
   *   <li>Then return Attributes first Value is {@code 9}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsNine_thenReturnAttributesFirstValueIs92() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(9L);

    // Act and Assert
    List<Attribute> attributes = user
        .getMentionEntity("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>")
        .getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("9", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is nine.</li>
   *   <li>Then return Attributes first Value is {@code 9}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsNine_thenReturnAttributesFirstValueIs93() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(9L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity("-").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("9", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is nine.</li>
   *   <li>Then return Attributes first Value is {@code 9}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsNine_thenReturnAttributesFirstValueIs94() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(9L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity(EntityConstants.MENTION_TYPE).getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("9", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is nine.</li>
   *   <li>Then return Attributes first Value is {@code 9}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsNine_thenReturnAttributesFirstValueIs95() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(9L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity(EntityConstants.USER_ID).getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("9", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is nine.</li>
   *   <li>Then return Attributes first Value is {@code 9}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsNine_thenReturnAttributesFirstValueIs96() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(9L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity("org.symphony.oss.number.long").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("9", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is nine.</li>
   *   <li>Then return Attributes first Value is {@code 9}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsNine_thenReturnAttributesFirstValueIs97() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(9L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity(null).getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("9", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is nine.</li>
   *   <li>Then return Attributes first Value is {@code 9}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsNine_thenReturnAttributesFirstValueIs98() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(9L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity(EntityConstants.NAME_ENTITY_FIELD).getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("9", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is nine.</li>
   *   <li>Then return Attributes first Value is {@code 9}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsNine_thenReturnAttributesFirstValueIs99() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(9L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity("").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("9", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is nine.</li>
   *   <li>When {@code 1.0}.</li>
   *   <li>Then return Attributes first Value is {@code 9}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsNine_when10_thenReturnAttributesFirstValueIs9() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(9L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity("1.0").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("9", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is nine.</li>
   *   <li>When {@code 42}.</li>
   *   <li>Then return Attributes first Value is {@code 9}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsNine_when42_thenReturnAttributesFirstValueIs9() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(9L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity("42").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("9", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is nine.</li>
   *   <li>When {@code <br/>
   * }.</li>
   *   <li>Then return Attributes first Value is {@code 9}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsNine_whenBr_thenReturnAttributesFirstValueIs9() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(9L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity("<br/>").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("9", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is nine.</li>
   *   <li>When lf.</li>
   *   <li>Then return Attributes first Value is {@code 9}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsNine_whenLf_thenReturnAttributesFirstValueIs9() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(9L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity("\n").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("9", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is one.</li>
   *   <li>Then return Attributes first Value is {@code 1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsOne_thenReturnAttributesFirstValueIs1() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(1L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity("Integration Name").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("1", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is one.</li>
   *   <li>When {@code 1.0}.</li>
   *   <li>Then return Attributes first Value is {@code 1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsOne_when10_thenReturnAttributesFirstValueIs1() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(1L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity("1.0").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("1", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is one.</li>
   *   <li>When {@code 42}.</li>
   *   <li>Then return Attributes first Value is {@code 1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsOne_when42_thenReturnAttributesFirstValueIs1() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(1L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity("42").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("1", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is one.</li>
   *   <li>When {@code <br/>
   * }.</li>
   *   <li>Then return Attributes first Value is {@code 1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsOne_whenBr_thenReturnAttributesFirstValueIs1() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(1L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity("<br/>").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("1", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is one.</li>
   *   <li>When {@code -}.</li>
   *   <li>Then return Attributes first Value is {@code 1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsOne_whenDash_thenReturnAttributesFirstValueIs1() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(1L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity("-").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("1", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is one.</li>
   *   <li>When {@code Integration Name}.</li>
   *   <li>Then return Name is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsOne_whenIntegrationName_thenReturnNameIsNull() {
    // Arrange
    User user = new User();
    user.setId(1L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity("Integration Name");

    // Assert
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(1, attributes.size());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.USER_ID, attributes.get(0).getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is one.</li>
   *   <li>When lf.</li>
   *   <li>Then return Attributes first Value is {@code 1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsOne_whenLf_thenReturnAttributesFirstValueIs1() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(1L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity("\n").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("1", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is one.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then return Attributes first Value is {@code 1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsOne_whenNull_thenReturnAttributesFirstValueIs1() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(1L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity(null).getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("1", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is seven.</li>
   *   <li>Then return Attributes first Value is {@code 7}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsSeven_thenReturnAttributesFirstValueIs7() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(7L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity("Integration Name").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("7", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is seven.</li>
   *   <li>Then return Attributes first Value is {@code 7}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsSeven_thenReturnAttributesFirstValueIs72() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(7L);

    // Act and Assert
    List<Attribute> attributes = user
        .getMentionEntity("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>")
        .getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("7", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is seven.</li>
   *   <li>Then return Attributes first Value is {@code 7}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsSeven_thenReturnAttributesFirstValueIs73() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(7L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity("-").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("7", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is seven.</li>
   *   <li>Then return Attributes first Value is {@code 7}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsSeven_thenReturnAttributesFirstValueIs74() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(7L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity(EntityConstants.MENTION_TYPE).getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("7", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is seven.</li>
   *   <li>Then return Attributes first Value is {@code 7}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsSeven_thenReturnAttributesFirstValueIs75() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(7L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity(EntityConstants.USER_ID).getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("7", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is seven.</li>
   *   <li>Then return Attributes first Value is {@code 7}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsSeven_thenReturnAttributesFirstValueIs76() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(7L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity("org.symphony.oss.number.long").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("7", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is seven.</li>
   *   <li>Then return Attributes first Value is {@code 7}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsSeven_thenReturnAttributesFirstValueIs77() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(7L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity(null).getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("7", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is seven.</li>
   *   <li>Then return Attributes first Value is {@code 7}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsSeven_thenReturnAttributesFirstValueIs78() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(7L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity(EntityConstants.NAME_ENTITY_FIELD).getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("7", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is seven.</li>
   *   <li>Then return Attributes first Value is {@code 7}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsSeven_thenReturnAttributesFirstValueIs79() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(7L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity("").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("7", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is seven.</li>
   *   <li>When {@code 1.0}.</li>
   *   <li>Then return Attributes first Value is {@code 7}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsSeven_when10_thenReturnAttributesFirstValueIs7() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(7L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity("1.0").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("7", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is seven.</li>
   *   <li>When {@code 42}.</li>
   *   <li>Then return Attributes first Value is {@code 7}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsSeven_when42_thenReturnAttributesFirstValueIs7() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(7L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity("42").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("7", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is seven.</li>
   *   <li>When {@code <br/>
   * }.</li>
   *   <li>Then return Attributes first Value is {@code 7}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsSeven_whenBr_thenReturnAttributesFirstValueIs7() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(7L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity("<br/>").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("7", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is seven.</li>
   *   <li>When lf.</li>
   *   <li>Then return Attributes first Value is {@code 7}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsSeven_whenLf_thenReturnAttributesFirstValueIs7() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(7L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity("\n").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("7", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is six.</li>
   *   <li>Then return Attributes first Value is {@code 6}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsSix_thenReturnAttributesFirstValueIs6() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(6L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity("Integration Name").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("6", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is six.</li>
   *   <li>Then return Attributes first Value is {@code 6}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsSix_thenReturnAttributesFirstValueIs62() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(6L);

    // Act and Assert
    List<Attribute> attributes = user
        .getMentionEntity("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>")
        .getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("6", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is six.</li>
   *   <li>Then return Attributes first Value is {@code 6}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsSix_thenReturnAttributesFirstValueIs63() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(6L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity(EntityConstants.MENTION_TYPE).getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("6", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is six.</li>
   *   <li>Then return Attributes first Value is {@code 6}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsSix_thenReturnAttributesFirstValueIs64() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(6L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity(EntityConstants.USER_ID).getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("6", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is six.</li>
   *   <li>Then return Attributes first Value is {@code 6}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsSix_thenReturnAttributesFirstValueIs65() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(6L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity("org.symphony.oss.number.long").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("6", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is six.</li>
   *   <li>Then return Attributes first Value is {@code 6}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsSix_thenReturnAttributesFirstValueIs66() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(6L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity(EntityConstants.NAME_ENTITY_FIELD).getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("6", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is six.</li>
   *   <li>Then return Attributes first Value is {@code 6}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsSix_thenReturnAttributesFirstValueIs67() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(6L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity("").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("6", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is six.</li>
   *   <li>When {@code 1.0}.</li>
   *   <li>Then return Attributes first Value is {@code 6}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsSix_when10_thenReturnAttributesFirstValueIs6() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(6L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity("1.0").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("6", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is six.</li>
   *   <li>When {@code 42}.</li>
   *   <li>Then return Attributes first Value is {@code 6}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsSix_when42_thenReturnAttributesFirstValueIs6() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(6L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity("42").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("6", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is six.</li>
   *   <li>When {@code <br/>
   * }.</li>
   *   <li>Then return Attributes first Value is {@code 6}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsSix_whenBr_thenReturnAttributesFirstValueIs6() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(6L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity("<br/>").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("6", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is six.</li>
   *   <li>When {@code -}.</li>
   *   <li>Then return Attributes first Value is {@code 6}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsSix_whenDash_thenReturnAttributesFirstValueIs6() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(6L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity("-").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("6", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is six.</li>
   *   <li>When lf.</li>
   *   <li>Then return Attributes first Value is {@code 6}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsSix_whenLf_thenReturnAttributesFirstValueIs6() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(6L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity("\n").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("6", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is six.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then return Attributes first Value is {@code 6}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsSix_whenNull_thenReturnAttributesFirstValueIs6() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(6L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity(null).getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("6", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is ten.</li>
   *   <li>Then return Attributes first Value is {@code 10}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsTen_thenReturnAttributesFirstValueIs10() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(10L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity("Integration Name").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("10", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is ten.</li>
   *   <li>Then return Attributes first Value is {@code 10}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsTen_thenReturnAttributesFirstValueIs102() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(10L);

    // Act and Assert
    List<Attribute> attributes = user
        .getMentionEntity("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>")
        .getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("10", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is ten.</li>
   *   <li>Then return Attributes first Value is {@code 10}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsTen_thenReturnAttributesFirstValueIs103() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(10L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity("-").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("10", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is ten.</li>
   *   <li>Then return Attributes first Value is {@code 10}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsTen_thenReturnAttributesFirstValueIs104() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(10L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity(EntityConstants.MENTION_TYPE).getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("10", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is ten.</li>
   *   <li>Then return Attributes first Value is {@code 10}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsTen_thenReturnAttributesFirstValueIs105() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(10L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity(EntityConstants.USER_ID).getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("10", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is ten.</li>
   *   <li>Then return Attributes first Value is {@code 10}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsTen_thenReturnAttributesFirstValueIs106() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(10L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity("org.symphony.oss.number.long").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("10", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is ten.</li>
   *   <li>Then return Attributes first Value is {@code 10}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsTen_thenReturnAttributesFirstValueIs107() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(10L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity(null).getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("10", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is ten.</li>
   *   <li>Then return Attributes first Value is {@code 10}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsTen_thenReturnAttributesFirstValueIs108() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(10L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity(EntityConstants.NAME_ENTITY_FIELD).getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("10", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is ten.</li>
   *   <li>Then return Attributes first Value is {@code 10}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsTen_thenReturnAttributesFirstValueIs109() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(10L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity("").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("10", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is ten.</li>
   *   <li>When {@code 1.0}.</li>
   *   <li>Then return Attributes first Value is {@code 10}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsTen_when10_thenReturnAttributesFirstValueIs10() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(10L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity("1.0").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("10", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is ten.</li>
   *   <li>When {@code 42}.</li>
   *   <li>Then return Attributes first Value is {@code 10}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsTen_when42_thenReturnAttributesFirstValueIs10() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(10L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity("42").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("10", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is ten.</li>
   *   <li>When {@code <br/>
   * }.</li>
   *   <li>Then return Attributes first Value is {@code 10}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsTen_whenBr_thenReturnAttributesFirstValueIs10() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(10L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity("<br/>").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("10", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is ten.</li>
   *   <li>When lf.</li>
   *   <li>Then return Attributes first Value is {@code 10}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsTen_whenLf_thenReturnAttributesFirstValueIs10() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(10L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity("\n").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("10", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is three.</li>
   *   <li>Then return Attributes first Value is {@code 3}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsThree_thenReturnAttributesFirstValueIs3() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(3L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity("Integration Name").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("3", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is three.</li>
   *   <li>Then return Attributes first Value is {@code 3}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsThree_thenReturnAttributesFirstValueIs32() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(3L);

    // Act and Assert
    List<Attribute> attributes = user
        .getMentionEntity("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>")
        .getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("3", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is three.</li>
   *   <li>Then return Attributes first Value is {@code 3}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsThree_thenReturnAttributesFirstValueIs33() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(3L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity("-").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("3", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is three.</li>
   *   <li>Then return Attributes first Value is {@code 3}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsThree_thenReturnAttributesFirstValueIs34() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(3L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity(EntityConstants.MENTION_TYPE).getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("3", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is three.</li>
   *   <li>Then return Attributes first Value is {@code 3}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsThree_thenReturnAttributesFirstValueIs35() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(3L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity(EntityConstants.USER_ID).getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("3", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is three.</li>
   *   <li>Then return Attributes first Value is {@code 3}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsThree_thenReturnAttributesFirstValueIs36() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(3L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity("org.symphony.oss.number.long").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("3", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is three.</li>
   *   <li>Then return Attributes first Value is {@code 3}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsThree_thenReturnAttributesFirstValueIs37() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(3L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity(null).getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("3", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is three.</li>
   *   <li>Then return Attributes first Value is {@code 3}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsThree_thenReturnAttributesFirstValueIs38() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(3L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity(EntityConstants.NAME_ENTITY_FIELD).getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("3", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is three.</li>
   *   <li>Then return Attributes first Value is {@code 3}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsThree_thenReturnAttributesFirstValueIs39() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(3L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity("").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("3", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is three.</li>
   *   <li>When {@code 1.0}.</li>
   *   <li>Then return Attributes first Value is {@code 3}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsThree_when10_thenReturnAttributesFirstValueIs3() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(3L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity("1.0").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("3", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is three.</li>
   *   <li>When {@code 42}.</li>
   *   <li>Then return Attributes first Value is {@code 3}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsThree_when42_thenReturnAttributesFirstValueIs3() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(3L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity("42").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("3", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is three.</li>
   *   <li>When {@code <br/>
   * }.</li>
   *   <li>Then return Attributes first Value is {@code 3}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsThree_whenBr_thenReturnAttributesFirstValueIs3() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(3L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity("<br/>").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("3", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is three.</li>
   *   <li>When lf.</li>
   *   <li>Then return Attributes first Value is {@code 3}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsThree_whenLf_thenReturnAttributesFirstValueIs3() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(3L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity("\n").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("3", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is two.</li>
   *   <li>Then return Attributes first Value is {@code 2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsTwo_thenReturnAttributesFirstValueIs2() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(2L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity("Integration Name").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("2", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is two.</li>
   *   <li>Then return Attributes first Value is {@code 2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsTwo_thenReturnAttributesFirstValueIs22() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(2L);

    // Act and Assert
    List<Attribute> attributes = user
        .getMentionEntity("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>")
        .getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("2", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is two.</li>
   *   <li>Then return Attributes first Value is {@code 2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsTwo_thenReturnAttributesFirstValueIs23() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(2L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity(EntityConstants.MENTION_TYPE).getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("2", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is two.</li>
   *   <li>Then return Attributes first Value is {@code 2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsTwo_thenReturnAttributesFirstValueIs24() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(2L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity(EntityConstants.USER_ID).getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("2", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is two.</li>
   *   <li>Then return Attributes first Value is {@code 2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsTwo_thenReturnAttributesFirstValueIs25() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(2L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity("org.symphony.oss.number.long").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("2", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is two.</li>
   *   <li>Then return Attributes first Value is {@code 2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsTwo_thenReturnAttributesFirstValueIs26() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(2L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity(EntityConstants.NAME_ENTITY_FIELD).getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("2", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is two.</li>
   *   <li>Then return Attributes first Value is {@code 2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsTwo_thenReturnAttributesFirstValueIs27() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(2L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity("").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("2", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is two.</li>
   *   <li>When {@code 1.0}.</li>
   *   <li>Then return Attributes first Value is {@code 2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsTwo_when10_thenReturnAttributesFirstValueIs2() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(2L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity("1.0").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("2", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is two.</li>
   *   <li>When {@code 42}.</li>
   *   <li>Then return Attributes first Value is {@code 2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsTwo_when42_thenReturnAttributesFirstValueIs2() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(2L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity("42").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("2", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is two.</li>
   *   <li>When {@code <br/>
   * }.</li>
   *   <li>Then return Attributes first Value is {@code 2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsTwo_whenBr_thenReturnAttributesFirstValueIs2() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(2L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity("<br/>").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("2", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is two.</li>
   *   <li>When {@code -}.</li>
   *   <li>Then return Attributes first Value is {@code 2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsTwo_whenDash_thenReturnAttributesFirstValueIs2() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(2L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity("-").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("2", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is two.</li>
   *   <li>When lf.</li>
   *   <li>Then return Attributes first Value is {@code 2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsTwo_whenLf_thenReturnAttributesFirstValueIs2() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(2L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity("\n").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("2", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is two.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then return Attributes first Value is {@code 2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsTwo_whenNull_thenReturnAttributesFirstValueIs2() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(2L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity(null).getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("2", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is zero.</li>
   *   <li>Then return Attributes first Value is {@code 0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsZero_thenReturnAttributesFirstValueIs0() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(0L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity("Integration Name").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("0", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is zero.</li>
   *   <li>Then return Attributes first Value is {@code 0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsZero_thenReturnAttributesFirstValueIs02() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(0L);

    // Act and Assert
    List<Attribute> attributes = user
        .getMentionEntity("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>")
        .getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("0", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is zero.</li>
   *   <li>Then return Attributes first Value is {@code 0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsZero_thenReturnAttributesFirstValueIs03() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(0L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity("-").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("0", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is zero.</li>
   *   <li>Then return Attributes first Value is {@code 0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsZero_thenReturnAttributesFirstValueIs04() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(0L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity(EntityConstants.MENTION_TYPE).getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("0", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is zero.</li>
   *   <li>Then return Attributes first Value is {@code 0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsZero_thenReturnAttributesFirstValueIs05() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(0L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity(EntityConstants.USER_ID).getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("0", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is zero.</li>
   *   <li>Then return Attributes first Value is {@code 0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsZero_thenReturnAttributesFirstValueIs06() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(0L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity("org.symphony.oss.number.long").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("0", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is zero.</li>
   *   <li>Then return Attributes first Value is {@code 0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsZero_thenReturnAttributesFirstValueIs07() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(0L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity(null).getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("0", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is zero.</li>
   *   <li>Then return Attributes first Value is {@code 0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsZero_thenReturnAttributesFirstValueIs08() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(0L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity(EntityConstants.NAME_ENTITY_FIELD).getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("0", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is zero.</li>
   *   <li>Then return Attributes first Value is {@code 0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsZero_thenReturnAttributesFirstValueIs09() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(0L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity("").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("0", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is zero.</li>
   *   <li>When {@code 1.0}.</li>
   *   <li>Then return Attributes first Value is {@code 0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsZero_when10_thenReturnAttributesFirstValueIs0() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(0L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity("1.0").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("0", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is zero.</li>
   *   <li>When {@code 42}.</li>
   *   <li>Then return Attributes first Value is {@code 0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsZero_when42_thenReturnAttributesFirstValueIs0() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(0L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity("42").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("0", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is zero.</li>
   *   <li>When {@code <br/>
   * }.</li>
   *   <li>Then return Attributes first Value is {@code 0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsZero_whenBr_thenReturnAttributesFirstValueIs0() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(0L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity("<br/>").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("0", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is zero.</li>
   *   <li>When lf.</li>
   *   <li>Then return Attributes first Value is {@code 0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsZero_whenLf_thenReturnAttributesFirstValueIs0() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(0L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity("\n").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("0", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) UserName is {@code janedoe}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserUserNameIsJanedoe() {
    // Arrange
    User user = new User();
    user.setUserName("janedoe");
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(1L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity("Integration Name").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("1", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor).</li>
   *   <li>When {@code Integration Name}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUser_whenIntegrationName_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new User()).getMentionEntity("Integration Name"));
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Then return Attributes first Value is {@code 123}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_thenReturnAttributesFirstValueIs123() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(123L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity("Integration Name").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("123", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Then return Attributes first Value is {@code 123}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_thenReturnAttributesFirstValueIs1232() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(123L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity("\n").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("123", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Then return Attributes first Value is {@code 123}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_thenReturnAttributesFirstValueIs1233() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(123L);

    // Act and Assert
    List<Attribute> attributes = user
        .getMentionEntity("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>")
        .getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("123", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Then return Attributes first Value is {@code 123}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_thenReturnAttributesFirstValueIs1234() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(123L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity("-").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("123", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Then return Attributes first Value is {@code 123}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_thenReturnAttributesFirstValueIs1235() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(123L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity(EntityConstants.MENTION_TYPE).getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("123", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Then return Attributes first Value is {@code 123}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_thenReturnAttributesFirstValueIs1236() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(123L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity("1.0").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("123", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Then return Attributes first Value is {@code 123}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_thenReturnAttributesFirstValueIs1237() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(123L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity(EntityConstants.USER_ID).getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("123", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Then return Attributes first Value is {@code 123}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_thenReturnAttributesFirstValueIs1238() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(123L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity("org.symphony.oss.number.long").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("123", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Then return Attributes first Value is {@code 123}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_thenReturnAttributesFirstValueIs1239() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(123L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity(null).getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("123", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Then return Attributes first Value is {@code 123}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_thenReturnAttributesFirstValueIs12310() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(123L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity("42").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("123", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Then return Attributes first Value is {@code 123}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_thenReturnAttributesFirstValueIs12311() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(123L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity(EntityConstants.NAME_ENTITY_FIELD).getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("123", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Then return Attributes first Value is {@code 123}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_thenReturnAttributesFirstValueIs12312() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(123L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity("").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("123", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Then return Attributes first Value is {@code 123}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_thenReturnAttributesFirstValueIs12313() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(123L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity("<br/>").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("123", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Then return Attributes first Value is {@code 9223372036854775807}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_thenReturnAttributesFirstValueIs9223372036854775807() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(Long.MAX_VALUE);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity("Integration Name").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("9223372036854775807", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Then return Attributes first Value is {@code -9223372036854775808}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_thenReturnAttributesFirstValueIs9223372036854775808() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(Long.MIN_VALUE);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity("Integration Name").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("-9223372036854775808", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Then return Attributes first Value is {@code 9223372036854775807}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_thenReturnAttributesFirstValueIs92233720368547758072() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(Long.MAX_VALUE);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity("\n").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("9223372036854775807", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Then return Attributes first Value is {@code 9223372036854775807}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_thenReturnAttributesFirstValueIs92233720368547758073() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(Long.MAX_VALUE);

    // Act and Assert
    List<Attribute> attributes = user
        .getMentionEntity("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>")
        .getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("9223372036854775807", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Then return Attributes first Value is {@code 9223372036854775807}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_thenReturnAttributesFirstValueIs92233720368547758074() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(Long.MAX_VALUE);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity("-").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("9223372036854775807", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Then return Attributes first Value is {@code 9223372036854775807}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_thenReturnAttributesFirstValueIs92233720368547758075() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(Long.MAX_VALUE);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity(EntityConstants.MENTION_TYPE).getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("9223372036854775807", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Then return Attributes first Value is {@code 9223372036854775807}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_thenReturnAttributesFirstValueIs92233720368547758076() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(Long.MAX_VALUE);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity("1.0").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("9223372036854775807", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Then return Attributes first Value is {@code 9223372036854775807}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_thenReturnAttributesFirstValueIs92233720368547758077() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(Long.MAX_VALUE);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity(EntityConstants.USER_ID).getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("9223372036854775807", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Then return Attributes first Value is {@code 9223372036854775807}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_thenReturnAttributesFirstValueIs92233720368547758078() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(Long.MAX_VALUE);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity("org.symphony.oss.number.long").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("9223372036854775807", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Then return Attributes first Value is {@code 9223372036854775807}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_thenReturnAttributesFirstValueIs92233720368547758079() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(Long.MAX_VALUE);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity(null).getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("9223372036854775807", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Then return Attributes first Value is {@code -9223372036854775808}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_thenReturnAttributesFirstValueIs92233720368547758082() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(Long.MIN_VALUE);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity("\n").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("-9223372036854775808", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Then return Attributes first Value is {@code -9223372036854775808}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_thenReturnAttributesFirstValueIs92233720368547758083() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(Long.MIN_VALUE);

    // Act and Assert
    List<Attribute> attributes = user
        .getMentionEntity("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>")
        .getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("-9223372036854775808", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Then return Attributes first Value is {@code -9223372036854775808}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_thenReturnAttributesFirstValueIs92233720368547758084() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(Long.MIN_VALUE);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity("-").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("-9223372036854775808", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Then return Attributes first Value is {@code -9223372036854775808}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_thenReturnAttributesFirstValueIs92233720368547758085() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(Long.MIN_VALUE);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity(EntityConstants.MENTION_TYPE).getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("-9223372036854775808", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Then return Attributes first Value is {@code -9223372036854775808}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_thenReturnAttributesFirstValueIs92233720368547758086() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(Long.MIN_VALUE);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity("1.0").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("-9223372036854775808", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Then return Attributes first Value is {@code -9223372036854775808}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_thenReturnAttributesFirstValueIs92233720368547758087() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(Long.MIN_VALUE);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity(EntityConstants.USER_ID).getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("-9223372036854775808", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Then return Attributes first Value is {@code -9223372036854775808}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_thenReturnAttributesFirstValueIs92233720368547758088() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(Long.MIN_VALUE);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity("org.symphony.oss.number.long").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("-9223372036854775808", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Then return Attributes first Value is {@code -9223372036854775808}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_thenReturnAttributesFirstValueIs92233720368547758089() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(Long.MIN_VALUE);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity(null).getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("-9223372036854775808", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Then return Attributes first Value is {@code 9223372036854775807}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_thenReturnAttributesFirstValueIs922337203685477580710() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(Long.MAX_VALUE);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity("42").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("9223372036854775807", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Then return Attributes first Value is {@code 9223372036854775807}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_thenReturnAttributesFirstValueIs922337203685477580711() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(Long.MAX_VALUE);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity(EntityConstants.NAME_ENTITY_FIELD).getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("9223372036854775807", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Then return Attributes first Value is {@code 9223372036854775807}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_thenReturnAttributesFirstValueIs922337203685477580712() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(Long.MAX_VALUE);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity("").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("9223372036854775807", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Then return Attributes first Value is {@code 9223372036854775807}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_thenReturnAttributesFirstValueIs922337203685477580713() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(Long.MAX_VALUE);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity("<br/>").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("9223372036854775807", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Then return Attributes first Value is {@code -9223372036854775808}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_thenReturnAttributesFirstValueIs922337203685477580810() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(Long.MIN_VALUE);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity("42").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("-9223372036854775808", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Then return Attributes first Value is {@code -9223372036854775808}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_thenReturnAttributesFirstValueIs922337203685477580811() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(Long.MIN_VALUE);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity(EntityConstants.NAME_ENTITY_FIELD).getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("-9223372036854775808", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Then return Attributes first Value is {@code -9223372036854775808}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_thenReturnAttributesFirstValueIs922337203685477580812() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(Long.MIN_VALUE);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity("").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("-9223372036854775808", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Then return Attributes first Value is {@code -9223372036854775808}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_thenReturnAttributesFirstValueIs922337203685477580813() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(Long.MIN_VALUE);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity("<br/>").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("-9223372036854775808", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>Then return Attributes second Value is {@link EntityConstants#MENTION_TYPE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_thenReturnAttributesSecondValueIsMention_type() {
    // Arrange
    User user = new User();
    user.setDisplayName(EntityConstants.MENTION_TYPE);
    user.setId(1L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity("Integration Name").getAttributes();
    assertEquals(2, attributes.size());
    assertEquals("1", attributes.get(0).getValue());
    Attribute getResult = attributes.get(1);
    assertEquals(EntityConstants.MENTION_TYPE, getResult.getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>When {@code < a href = "http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;" >xx</a>}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_whenAHrefHttpUuuuuuuuuuuuUuAmpAmpUuAmpAmpXxA() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(1L);

    // Act and Assert
    List<Attribute> attributes = user
        .getMentionEntity("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>")
        .getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("1", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>When {@code <a href=}.</li>
   *   <li>Then return Attributes first Value is {@code 1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_whenAHref_thenReturnAttributesFirstValueIs1() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(1L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity("<a href=").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("1", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return Attributes first Value is {@code 1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_whenEmptyString_thenReturnAttributesFirstValueIs1() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(1L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity("").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("1", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>When {@link EntityConstants#MENTION_TYPE}.</li>
   *   <li>Then return Attributes first Value is {@code 1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_whenMention_type_thenReturnAttributesFirstValueIs1() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(1L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity(EntityConstants.MENTION_TYPE).getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("1", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>When {@link EntityConstants#NAME_ENTITY_FIELD}.</li>
   *   <li>Then return Attributes first Value is {@code 1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_whenName_entity_field_thenReturnAttributesFirstValueIs1() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(1L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity(EntityConstants.NAME_ENTITY_FIELD).getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("1", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>When {@code org.symphony.oss.number.long}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_whenOrgSymphonyOssNumberLong() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(1L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity("org.symphony.oss.number.long").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("1", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   * <ul>
   *   <li>When {@link EntityConstants#USER_ID}.</li>
   *   <li>Then return Attributes first Value is {@code 1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_whenUser_id_thenReturnAttributesFirstValueIs1() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(1L);

    // Act and Assert
    List<Attribute> attributes = user.getMentionEntity(EntityConstants.USER_ID).getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("1", attributes.get(0).getValue());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user
        .toEntity("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("Entity Name", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\" "
        + " >xx</a>.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity2() {
    // Arrange
    User user = new User();
    user.setEmailAddress("42 Main St");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user
        .toEntity("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals("42 Main St", getResult.getValue());
    assertEquals("com.symphony.integration.<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\" "
        + " >xx</a>.user", actualToEntityResult.getType());
    assertEquals(EntityConstants.EMAIL_ADDRESS_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity3() {
    // Arrange
    User user = new User();
    user.setDisplayName("\n");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user
        .toEntity("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("Entity Name", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\" "
        + " >xx</a>.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) DisplayName is {@code 1.0}.</li>
   *   <li>Then return Attributes second Value is {@code 1.0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserDisplayNameIs10_thenReturnAttributesSecondValueIs10() {
    // Arrange
    User user = new User();
    user.setDisplayName("1.0");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals("1.0", getResult.getValue());
    assertEquals("Entity Name", actualToEntityResult.getName());
    assertEquals(EntityConstants.DISPLAY_NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) DisplayName is {@code 42}.</li>
   *   <li>Then return Attributes second Value is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserDisplayNameIs42_thenReturnAttributesSecondValueIs42() {
    // Arrange
    User user = new User();
    user.setDisplayName("42");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals("42", getResult.getValue());
    assertEquals("Entity Name", actualToEntityResult.getName());
    assertEquals(EntityConstants.DISPLAY_NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) DisplayName is {@code <a href=}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserDisplayNameIsAHref() {
    // Arrange
    User user = new User();
    user.setDisplayName("<a href=");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals("&lt;a href=", getResult.getValue());
    assertEquals("Entity Name", actualToEntityResult.getName());
    assertEquals(EntityConstants.DISPLAY_NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) DisplayName is {@code < a href = "http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;" >xx</a>}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserDisplayNameIsAHrefHttpUuuuuuuuuuuuUuAmpAmpUuAmpAmpXxA() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("Entity Name", actualToEntityResult.getName());
    assertEquals(EntityConstants.DISPLAY_NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) DisplayName is {@code <br/>
   * }.</li>
   *   <li>Then return Attributes second Value is {@code &lt;br/&gt;}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserDisplayNameIsBr_thenReturnAttributesSecondValueIsLtBrGt() {
    // Arrange
    User user = new User();
    user.setDisplayName("<br/>");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals("&lt;br/&gt;", getResult.getValue());
    assertEquals("Entity Name", actualToEntityResult.getName());
    assertEquals(EntityConstants.DISPLAY_NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) DisplayName is {@code com.symphony.integration.%s.%s}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserDisplayNameIsComSymphonyIntegrationSS() {
    // Arrange
    User user = new User();
    user.setDisplayName("com.symphony.integration.%s.%s");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "Entity Name");

    // Assert
    assertEquals("Entity Name", actualToEntityResult.getName());
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals("com.symphony.integration.%s.%s", getResult.getValue());
    assertEquals(EntityConstants.DISPLAY_NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) DisplayName is {@code -}.</li>
   *   <li>Then return Attributes second Value is {@code -}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserDisplayNameIsDash_thenReturnAttributesSecondValueIsDash() {
    // Arrange
    User user = new User();
    user.setDisplayName("-");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals("-", getResult.getValue());
    assertEquals("Entity Name", actualToEntityResult.getName());
    assertEquals(EntityConstants.DISPLAY_NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) DisplayName is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserDisplayNameIsEmptyString() {
    // Arrange
    User user = new User();
    user.setDisplayName("");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("Entity Name", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.Integration Name.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) DisplayName is lf.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserDisplayNameIsLf() {
    // Arrange
    User user = new User();
    user.setDisplayName("\n");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("Entity Name", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.Integration Name.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) DisplayName is lf.</li>
   *   <li>Then return Name is {@code com.symphony.integration.%s.%s}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserDisplayNameIsLf_thenReturnNameIsComSymphonyIntegrationSS() {
    // Arrange
    User user = new User();
    user.setDisplayName("\n");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "com.symphony.integration.%s.%s");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("com.symphony.integration.%s.%s", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.Integration Name.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) DisplayName is lf.</li>
   *   <li>Then return Name is {@link EntityConstants#USER_ENTITY_FIELD}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserDisplayNameIsLf_thenReturnNameIsUser_entity_field() {
    // Arrange
    User user = new User();
    user.setDisplayName("\n");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", EntityConstants.USER_ENTITY_FIELD);

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("com.symphony.integration.Integration Name.user", actualToEntityResult.getType());
    assertEquals(EntityConstants.USER_ENTITY_FIELD, actualToEntityResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) DisplayName is lf.</li>
   *   <li>Then return Name is {@link EntityConstants#USERNAME_ENTITY_FIELD}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserDisplayNameIsLf_thenReturnNameIsUsername_entity_field() {
    // Arrange
    User user = new User();
    user.setDisplayName("\n");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", EntityConstants.USERNAME_ENTITY_FIELD);

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("com.symphony.integration.Integration Name.user", actualToEntityResult.getType());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, actualToEntityResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) DisplayName is lf.</li>
   *   <li>Then return Type is {@code com.symphony.integration. .user}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserDisplayNameIsLf_thenReturnTypeIsComSymphonyIntegrationUser() {
    // Arrange
    User user = new User();
    user.setDisplayName("\n");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("\n", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("Entity Name", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.\n.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) DisplayName is lf.</li>
   *   <li>Then return Type is {@code com.symphony.integration.-.user}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserDisplayNameIsLf_thenReturnTypeIsComSymphonyIntegrationUser2() {
    // Arrange
    User user = new User();
    user.setDisplayName("\n");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("-", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("Entity Name", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.-.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) DisplayName is lf.</li>
   *   <li>When {@code 1.0}.</li>
   *   <li>Then return Name is {@code 1.0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserDisplayNameIsLf_when10_thenReturnNameIs10() {
    // Arrange
    User user = new User();
    user.setDisplayName("\n");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "1.0");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("1.0", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.Integration Name.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) DisplayName is lf.</li>
   *   <li>When {@code 42}.</li>
   *   <li>Then return Name is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserDisplayNameIsLf_when42_thenReturnNameIs42() {
    // Arrange
    User user = new User();
    user.setDisplayName("\n");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "42");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("42", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.Integration Name.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) DisplayName is lf.</li>
   *   <li>When {@code <a href=}.</li>
   *   <li>Then return Name is {@code <a href=}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserDisplayNameIsLf_whenAHref_thenReturnNameIsAHref() {
    // Arrange
    User user = new User();
    user.setDisplayName("\n");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "<a href=");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("<a href=", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.Integration Name.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) DisplayName is lf.</li>
   *   <li>When {@code <br/>
   * }.</li>
   *   <li>Then return Name is {@code <br/>
   * }.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserDisplayNameIsLf_whenBr_thenReturnNameIsBr() {
    // Arrange
    User user = new User();
    user.setDisplayName("\n");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "<br/>");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("<br/>", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.Integration Name.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) DisplayName is lf.</li>
   *   <li>When {@code -}.</li>
   *   <li>Then return Name is {@code -}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserDisplayNameIsLf_whenDash_thenReturnNameIsDash() {
    // Arrange
    User user = new User();
    user.setDisplayName("\n");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "-");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("-", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.Integration Name.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) DisplayName is lf.</li>
   *   <li>When lf.</li>
   *   <li>Then return Name is lf.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserDisplayNameIsLf_whenLf_thenReturnNameIsLf() {
    // Arrange
    User user = new User();
    user.setDisplayName("\n");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "\n");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("\n", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.Integration Name.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) DisplayName is lf.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then return Name is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserDisplayNameIsLf_whenNull_thenReturnNameIsNull() {
    // Arrange
    User user = new User();
    user.setDisplayName("\n");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", null);

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("com.symphony.integration.Integration Name.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) DisplayName is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserDisplayNameIsNull() {
    // Arrange
    User user = new User();
    user.setDisplayName(null);
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("Entity Name", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.Integration Name.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) DisplayName is {@link EntityConstants#USER_ENTITY_FIELD}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserDisplayNameIsUser_entity_field() {
    // Arrange
    User user = new User();
    user.setDisplayName(EntityConstants.USER_ENTITY_FIELD);
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "Entity Name");

    // Assert
    assertEquals("Entity Name", actualToEntityResult.getName());
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(EntityConstants.DISPLAY_NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ENTITY_FIELD, getResult.getValue());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) DisplayName is {@link EntityConstants#USERNAME_ENTITY_FIELD}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserDisplayNameIsUsername_entity_field() {
    // Arrange
    User user = new User();
    user.setDisplayName(EntityConstants.USERNAME_ENTITY_FIELD);
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "Entity Name");

    // Assert
    assertEquals("Entity Name", actualToEntityResult.getName());
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(EntityConstants.DISPLAY_NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getValue());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) EmailAddress is {@code 1.0}.</li>
   *   <li>Then return Attributes second Value is {@code 1.0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserEmailAddressIs10_thenReturnAttributesSecondValueIs10() {
    // Arrange
    User user = new User();
    user.setEmailAddress("1.0");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals("1.0", getResult.getValue());
    assertEquals("Entity Name", actualToEntityResult.getName());
    assertEquals(EntityConstants.EMAIL_ADDRESS_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) EmailAddress is {@code 42 Main St}.</li>
   *   <li>Then return Name is {@link EntityConstants#USER_ENTITY_FIELD}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserEmailAddressIs42MainSt_thenReturnNameIsUser_entity_field() {
    // Arrange
    User user = new User();
    user.setEmailAddress("42 Main St");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", EntityConstants.USER_ENTITY_FIELD);

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals("42 Main St", getResult.getValue());
    assertEquals(EntityConstants.EMAIL_ADDRESS_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ENTITY_FIELD, actualToEntityResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) EmailAddress is {@code 42 Main St}.</li>
   *   <li>When {@code 1.0}.</li>
   *   <li>Then return Name is {@code 1.0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserEmailAddressIs42MainSt_when10_thenReturnNameIs10() {
    // Arrange
    User user = new User();
    user.setEmailAddress("42 Main St");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "1.0");

    // Assert
    assertEquals("1.0", actualToEntityResult.getName());
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals("42 Main St", getResult.getValue());
    assertEquals(EntityConstants.EMAIL_ADDRESS_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) EmailAddress is {@code 42 Main St}.</li>
   *   <li>When {@code 42}.</li>
   *   <li>Then return Name is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserEmailAddressIs42MainSt_when42_thenReturnNameIs42() {
    // Arrange
    User user = new User();
    user.setEmailAddress("42 Main St");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "42");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals("42 Main St", getResult.getValue());
    assertEquals("42", actualToEntityResult.getName());
    assertEquals(EntityConstants.EMAIL_ADDRESS_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) EmailAddress is {@code 42 Main St}.</li>
   *   <li>When {@code <a href=}.</li>
   *   <li>Then return Name is {@code <a href=}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserEmailAddressIs42MainSt_whenAHref_thenReturnNameIsAHref() {
    // Arrange
    User user = new User();
    user.setEmailAddress("42 Main St");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "<a href=");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals("42 Main St", getResult.getValue());
    assertEquals("<a href=", actualToEntityResult.getName());
    assertEquals(EntityConstants.EMAIL_ADDRESS_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) EmailAddress is {@code 42 Main St}.</li>
   *   <li>When {@code <br/>
   * }.</li>
   *   <li>Then return Name is {@code <br/>
   * }.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserEmailAddressIs42MainSt_whenBr_thenReturnNameIsBr() {
    // Arrange
    User user = new User();
    user.setEmailAddress("42 Main St");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "<br/>");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals("42 Main St", getResult.getValue());
    assertEquals("<br/>", actualToEntityResult.getName());
    assertEquals(EntityConstants.EMAIL_ADDRESS_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) EmailAddress is {@code 42 Main St}.</li>
   *   <li>When {@code -}.</li>
   *   <li>Then return Name is {@code -}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserEmailAddressIs42MainSt_whenDash_thenReturnNameIsDash() {
    // Arrange
    User user = new User();
    user.setEmailAddress("42 Main St");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "-");

    // Assert
    assertEquals("-", actualToEntityResult.getName());
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals("42 Main St", getResult.getValue());
    assertEquals(EntityConstants.EMAIL_ADDRESS_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) EmailAddress is {@code 42 Main St}.</li>
   *   <li>When lf.</li>
   *   <li>Then return Name is lf.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserEmailAddressIs42MainSt_whenLf_thenReturnNameIsLf() {
    // Arrange
    User user = new User();
    user.setEmailAddress("42 Main St");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "\n");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals("42 Main St", getResult.getValue());
    assertEquals("\n", actualToEntityResult.getName());
    assertEquals(EntityConstants.EMAIL_ADDRESS_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) EmailAddress is {@code 42 Main St}.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then return Name is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserEmailAddressIs42MainSt_whenNull_thenReturnNameIsNull() {
    // Arrange
    User user = new User();
    user.setEmailAddress("42 Main St");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", null);

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals("42 Main St", getResult.getValue());
    assertNull(actualToEntityResult.getName());
    assertEquals(EntityConstants.EMAIL_ADDRESS_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) EmailAddress is {@code 42}.</li>
   *   <li>Then return Attributes second Value is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserEmailAddressIs42_thenReturnAttributesSecondValueIs42() {
    // Arrange
    User user = new User();
    user.setEmailAddress("42");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals("42", getResult.getValue());
    assertEquals("Entity Name", actualToEntityResult.getName());
    assertEquals(EntityConstants.EMAIL_ADDRESS_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) EmailAddress is {@code <a href=}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserEmailAddressIsAHref() {
    // Arrange
    User user = new User();
    user.setEmailAddress("<a href=");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals("&lt;a href=", getResult.getValue());
    assertEquals("Entity Name", actualToEntityResult.getName());
    assertEquals(EntityConstants.EMAIL_ADDRESS_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) EmailAddress is {@code < a href = "http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;" >xx</a>}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserEmailAddressIsAHrefHttpUuuuuuuuuuuuUuAmpAmpUuAmpAmpXxA() {
    // Arrange
    User user = new User();
    user.setEmailAddress("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("Entity Name", actualToEntityResult.getName());
    assertEquals(EntityConstants.EMAIL_ADDRESS_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) EmailAddress is {@code <br/>
   * }.</li>
   *   <li>Then return Attributes second Value is {@code &lt;br/&gt;}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserEmailAddressIsBr_thenReturnAttributesSecondValueIsLtBrGt() {
    // Arrange
    User user = new User();
    user.setEmailAddress("<br/>");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals("&lt;br/&gt;", getResult.getValue());
    assertEquals("Entity Name", actualToEntityResult.getName());
    assertEquals(EntityConstants.EMAIL_ADDRESS_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) EmailAddress is {@code com.symphony.integration.%s.%s}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserEmailAddressIsComSymphonyIntegrationSS() {
    // Arrange
    User user = new User();
    user.setEmailAddress("com.symphony.integration.%s.%s");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "Entity Name");

    // Assert
    assertEquals("Entity Name", actualToEntityResult.getName());
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals("com.symphony.integration.%s.%s", getResult.getValue());
    assertEquals(EntityConstants.EMAIL_ADDRESS_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) EmailAddress is {@code -}.</li>
   *   <li>Then return Attributes second Value is {@code -}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserEmailAddressIsDash_thenReturnAttributesSecondValueIsDash() {
    // Arrange
    User user = new User();
    user.setEmailAddress("-");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals("-", getResult.getValue());
    assertEquals("Entity Name", actualToEntityResult.getName());
    assertEquals(EntityConstants.EMAIL_ADDRESS_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) EmailAddress is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserEmailAddressIsEmptyString() {
    // Arrange
    User user = new User();
    user.setEmailAddress("");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("Entity Name", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.Integration Name.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) EmailAddress is lf.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserEmailAddressIsLf() {
    // Arrange
    User user = new User();
    user.setEmailAddress("\n");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("Entity Name", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.Integration Name.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) EmailAddress is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserEmailAddressIsNull() {
    // Arrange
    User user = new User();
    user.setEmailAddress(null);
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("Entity Name", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.Integration Name.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) EmailAddress is {@link EntityConstants#USER_ENTITY_FIELD}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserEmailAddressIsUser_entity_field() {
    // Arrange
    User user = new User();
    user.setEmailAddress(EntityConstants.USER_ENTITY_FIELD);
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "Entity Name");

    // Assert
    assertEquals("Entity Name", actualToEntityResult.getName());
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(EntityConstants.EMAIL_ADDRESS_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ENTITY_FIELD, getResult.getValue());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) EmailAddress is {@link EntityConstants#USERNAME_ENTITY_FIELD}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserEmailAddressIsUsername_entity_field() {
    // Arrange
    User user = new User();
    user.setEmailAddress(EntityConstants.USERNAME_ENTITY_FIELD);
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "Entity Name");

    // Assert
    assertEquals("Entity Name", actualToEntityResult.getName());
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(EntityConstants.EMAIL_ADDRESS_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getValue());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is one.</li>
   *   <li>When {@code Entity Name}.</li>
   *   <li>Then return Entities size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserIdIsOne_whenEntityName_thenReturnEntitiesSizeIsOne() {
    // Arrange
    User user = new User();
    user.setId(1L);

    // Act and Assert
    List<Entity> entities = user.toEntity("Integration Name", "Entity Name").getEntities();
    assertEquals(1, entities.size());
    Entity getResult = entities.get(0);
    List<Attribute> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult2 = attributes.get(0);
    assertEquals("1", getResult2.getValue());
    assertNull(getResult.getName());
    assertNull(getResult.getPresentationML());
    assertTrue(getResult.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, getResult.getType());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is one.</li>
   *   <li>When {@code Entity Name}.</li>
   *   <li>Then return Entities size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserIdIsOne_whenEntityName_thenReturnEntitiesSizeIsOne2() {
    // Arrange
    User user = new User();
    user.setId(1L);
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act and Assert
    List<Entity> entities = user.toEntity("Integration Name", "Entity Name").getEntities();
    assertEquals(1, entities.size());
    Entity getResult = entities.get(0);
    List<Attribute> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult2 = attributes.get(0);
    assertEquals("1", getResult2.getValue());
    assertNull(getResult.getName());
    assertNull(getResult.getPresentationML());
    assertTrue(getResult.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, getResult.getType());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) UserName is empty string.</li>
   *   <li>Then return Attributes Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserUserNameIsEmptyString_thenReturnAttributesEmpty() {
    // Arrange
    User user = new User();
    user.setUserName("");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "Entity Name");

    // Assert
    assertEquals("Entity Name", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.Integration Name.user", actualToEntityResult.getType());
    assertTrue(actualToEntityResult.getAttributes().isEmpty());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) UserName is {@code janedoe}.</li>
   *   <li>Then return Attributes first Value is {@code janedoe}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserUserNameIsJanedoe_thenReturnAttributesFirstValueIsJanedoe() {
    // Arrange
    User user = new User();
    user.setUserName("janedoe");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "Entity Name");

    // Assert
    assertEquals("Entity Name", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.Integration Name.user", actualToEntityResult.getType());
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals("janedoe", attributes.get(0).getValue());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) UserName is lf.</li>
   *   <li>When {@code Entity Name}.</li>
   *   <li>Then return Attributes Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserUserNameIsLf_whenEntityName_thenReturnAttributesEmpty() {
    // Arrange
    User user = new User();
    user.setUserName("\n");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "Entity Name");

    // Assert
    assertEquals("Entity Name", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.Integration Name.user", actualToEntityResult.getType());
    assertTrue(actualToEntityResult.getAttributes().isEmpty());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor).</li>
   *   <li>When {@code Entity Name}.</li>
   *   <li>Then return Attributes Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUser_whenEntityName_thenReturnAttributesEmpty() {
    // Arrange and Act
    Entity actualToEntityResult = (new User()).toEntity("Integration Name", "Entity Name");

    // Assert
    assertEquals("Entity Name", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.Integration Name.user", actualToEntityResult.getType());
    assertTrue(actualToEntityResult.getAttributes().isEmpty());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>Then return Attributes second Value is {@code 11 Station Rd}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_thenReturnAttributesSecondValueIs11StationRd() {
    // Arrange
    User user = new User();
    user.setEmailAddress("11 Station Rd");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals("11 Station Rd", getResult.getValue());
    assertEquals("Entity Name", actualToEntityResult.getName());
    assertEquals(EntityConstants.EMAIL_ADDRESS_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>Then return Attributes second Value is {@code 17 High St}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_thenReturnAttributesSecondValueIs17HighSt() {
    // Arrange
    User user = new User();
    user.setEmailAddress("17 High St");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals("17 High St", getResult.getValue());
    assertEquals("Entity Name", actualToEntityResult.getName());
    assertEquals(EntityConstants.EMAIL_ADDRESS_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>Then return Attributes second Value is {@code 42 Main St}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_thenReturnAttributesSecondValueIs42MainSt() {
    // Arrange
    User user = new User();
    user.setEmailAddress("42 Main St");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals("42 Main St", getResult.getValue());
    assertEquals("Entity Name", actualToEntityResult.getName());
    assertEquals(EntityConstants.EMAIL_ADDRESS_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>Then return Attributes second Value is {@code Display Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_thenReturnAttributesSecondValueIsDisplayName() {
    // Arrange
    User user = new User();
    user.setDisplayName("Display Name");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals("Display Name", getResult.getValue());
    assertEquals("Entity Name", actualToEntityResult.getName());
    assertEquals(EntityConstants.DISPLAY_NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>Then return Attributes second Value is {@code Email Address}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_thenReturnAttributesSecondValueIsEmailAddress() {
    // Arrange
    User user = new User();
    user.setEmailAddress("Email Address");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals("Email Address", getResult.getValue());
    assertEquals("Entity Name", actualToEntityResult.getName());
    assertEquals(EntityConstants.EMAIL_ADDRESS_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>Then return Attributes second Value is {@code jane.doe@example.org}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_thenReturnAttributesSecondValueIsJaneDoeExampleOrg() {
    // Arrange
    User user = new User();
    user.setEmailAddress("jane.doe@example.org");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "Entity Name");

    // Assert
    assertEquals("Entity Name", actualToEntityResult.getName());
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals("jane.doe@example.org", getResult.getValue());
    assertEquals(EntityConstants.EMAIL_ADDRESS_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>Then return Attributes second Value is {@code john.smith@example.org}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_thenReturnAttributesSecondValueIsJohnSmithExampleOrg() {
    // Arrange
    User user = new User();
    user.setEmailAddress("john.smith@example.org");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "Entity Name");

    // Assert
    assertEquals("Entity Name", actualToEntityResult.getName());
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals("john.smith@example.org", getResult.getValue());
    assertEquals(EntityConstants.EMAIL_ADDRESS_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>Then return Attributes second Value is {@code prof.einstein@example.org}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_thenReturnAttributesSecondValueIsProfEinsteinExampleOrg() {
    // Arrange
    User user = new User();
    user.setEmailAddress("prof.einstein@example.org");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "Entity Name");

    // Assert
    assertEquals("Entity Name", actualToEntityResult.getName());
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals("prof.einstein@example.org", getResult.getValue());
    assertEquals(EntityConstants.EMAIL_ADDRESS_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>Then return Name is {@code < a href = "http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;" >xx</a>}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_thenReturnNameIsAHrefHttpUuuuuuuuuuuuUuAmpAmpUuAmpAmpXxA() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name",
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>",
        actualToEntityResult.getName());
    assertEquals("com.symphony.integration.Integration Name.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>Then return Name is {@code < a href = "http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;" >xx</a>}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_thenReturnNameIsAHrefHttpUuuuuuuuuuuuUuAmpAmpUuAmpAmpXxA2() {
    // Arrange
    User user = new User();
    user.setEmailAddress("42 Main St");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name",
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals("42 Main St", getResult.getValue());
    assertEquals("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>",
        actualToEntityResult.getName());
    assertEquals(EntityConstants.EMAIL_ADDRESS_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>Then return Name is {@code < a href = "http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;" >xx</a>}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_thenReturnNameIsAHrefHttpUuuuuuuuuuuuUuAmpAmpUuAmpAmpXxA3() {
    // Arrange
    User user = new User();
    user.setDisplayName("\n");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name",
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>",
        actualToEntityResult.getName());
    assertEquals("com.symphony.integration.Integration Name.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>Then return Name is {@code < a href = "http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;" >xx</a>}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_thenReturnNameIsAHrefHttpUuuuuuuuuuuuUuAmpAmpUuAmpAmpXxA4() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity(
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>",
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>",
        actualToEntityResult.getName());
    assertEquals("com.symphony.integration.<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\" "
        + " >xx</a>.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>Then return Name is {@code < a href = "http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;" >xx</a>}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_thenReturnNameIsAHrefHttpUuuuuuuuuuuuUuAmpAmpUuAmpAmpXxA5() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity(EntityConstants.USER_ENTITY_FIELD,
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>",
        actualToEntityResult.getName());
    assertEquals("com.symphony.integration.user.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>Then return Name is {@code < a href = "http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;" >xx</a>}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_thenReturnNameIsAHrefHttpUuuuuuuuuuuuUuAmpAmpUuAmpAmpXxA6() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("com.symphony.integration.%s.%s",
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>",
        actualToEntityResult.getName());
    assertEquals("com.symphony.integration.com.symphony.integration.%s.%s.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>Then return Name is {@code < a href = "http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;" >xx</a>}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_thenReturnNameIsAHrefHttpUuuuuuuuuuuuUuAmpAmpUuAmpAmpXxA7() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity(EntityConstants.USERNAME_ENTITY_FIELD,
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>",
        actualToEntityResult.getName());
    assertEquals("com.symphony.integration.username.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>Then return Name is {@code com.symphony.integration.%s.%s}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_thenReturnNameIsComSymphonyIntegrationSS() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "com.symphony.integration.%s.%s");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("com.symphony.integration.%s.%s", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.Integration Name.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>Then return Name is {@code com.symphony.integration.%s.%s}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_thenReturnNameIsComSymphonyIntegrationSS2() {
    // Arrange
    User user = new User();
    user.setEmailAddress("42 Main St");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "com.symphony.integration.%s.%s");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals("42 Main St", getResult.getValue());
    assertEquals("com.symphony.integration.%s.%s", actualToEntityResult.getName());
    assertEquals(EntityConstants.EMAIL_ADDRESS_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>Then return Name is {@code com.symphony.integration.%s.%s}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_thenReturnNameIsComSymphonyIntegrationSS3() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity(
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>",
        "com.symphony.integration.%s.%s");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("com.symphony.integration.%s.%s", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\" "
        + " >xx</a>.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>Then return Name is {@code com.symphony.integration.%s.%s}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_thenReturnNameIsComSymphonyIntegrationSS4() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("com.symphony.integration.%s.%s", "com.symphony.integration.%s.%s");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("com.symphony.integration.%s.%s", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.com.symphony.integration.%s.%s.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>Then return Name is {@link EntityConstants#USER_ENTITY_FIELD}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_thenReturnNameIsUser_entity_field() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity(
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>",
        EntityConstants.USER_ENTITY_FIELD);

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("com.symphony.integration.<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\" "
        + " >xx</a>.user", actualToEntityResult.getType());
    assertEquals(EntityConstants.USER_ENTITY_FIELD, actualToEntityResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>Then return Name is {@link EntityConstants#USERNAME_ENTITY_FIELD}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_thenReturnNameIsUsername_entity_field() {
    // Arrange
    User user = new User();
    user.setEmailAddress("42 Main St");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", EntityConstants.USERNAME_ENTITY_FIELD);

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals("42 Main St", getResult.getValue());
    assertEquals(EntityConstants.EMAIL_ADDRESS_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, actualToEntityResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>Then return Name is {@link EntityConstants#USERNAME_ENTITY_FIELD}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_thenReturnNameIsUsername_entity_field2() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity(
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>",
        EntityConstants.USERNAME_ENTITY_FIELD);

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("com.symphony.integration.<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\" "
        + " >xx</a>.user", actualToEntityResult.getType());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, actualToEntityResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>Then return Type is {@code com.symphony.integration.1.0.user}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_thenReturnTypeIsComSymphonyIntegration10User() {
    // Arrange
    User user = new User();
    user.setEmailAddress("42 Main St");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("1.0", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals("42 Main St", getResult.getValue());
    assertEquals("com.symphony.integration.1.0.user", actualToEntityResult.getType());
    assertEquals(EntityConstants.EMAIL_ADDRESS_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>Then return Type is {@code com.symphony.integration.1.0.user}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_thenReturnTypeIsComSymphonyIntegration10User2() {
    // Arrange
    User user = new User();
    user.setDisplayName("\n");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("1.0", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("Entity Name", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.1.0.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>Then return Type is {@code com.symphony.integration.42.user}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_thenReturnTypeIsComSymphonyIntegration42User() {
    // Arrange
    User user = new User();
    user.setEmailAddress("42 Main St");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("42", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals("42 Main St", getResult.getValue());
    assertEquals("com.symphony.integration.42.user", actualToEntityResult.getType());
    assertEquals(EntityConstants.EMAIL_ADDRESS_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>Then return Type is {@code com.symphony.integration.42.user}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_thenReturnTypeIsComSymphonyIntegration42User2() {
    // Arrange
    User user = new User();
    user.setDisplayName("\n");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("42", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("Entity Name", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.42.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>Then return Type is {@code com.symphony.integration.<a href=.user}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_thenReturnTypeIsComSymphonyIntegrationAHrefUser() {
    // Arrange
    User user = new User();
    user.setEmailAddress("42 Main St");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("<a href=", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals("42 Main St", getResult.getValue());
    assertEquals("com.symphony.integration.<a href=.user", actualToEntityResult.getType());
    assertEquals(EntityConstants.EMAIL_ADDRESS_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>Then return Type is {@code com.symphony.integration.<a href=.user}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_thenReturnTypeIsComSymphonyIntegrationAHrefUser2() {
    // Arrange
    User user = new User();
    user.setDisplayName("\n");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("<a href=", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("Entity Name", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.<a href=.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>Then return Type is {@code com.symphony.integration.<br/>
   * .user}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_thenReturnTypeIsComSymphonyIntegrationBrUser() {
    // Arrange
    User user = new User();
    user.setEmailAddress("42 Main St");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("<br/>", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals("42 Main St", getResult.getValue());
    assertEquals("com.symphony.integration.<br/>.user", actualToEntityResult.getType());
    assertEquals(EntityConstants.EMAIL_ADDRESS_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>Then return Type is {@code com.symphony.integration.<br/>
   * .user}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_thenReturnTypeIsComSymphonyIntegrationBrUser2() {
    // Arrange
    User user = new User();
    user.setDisplayName("\n");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("<br/>", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("Entity Name", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.<br/>.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>Then return Type is {@code com.symphony.integration.com.symphony.integration.%s.%s.user}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_thenReturnTypeIsComSymphonyIntegrationComSymphonyIntegrationSSUser() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("com.symphony.integration.%s.%s", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("Entity Name", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.com.symphony.integration.%s.%s.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>Then return Type is {@code com.symphony.integration.com.symphony.integration.%s.%s.user}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_thenReturnTypeIsComSymphonyIntegrationComSymphonyIntegrationSSUser2() {
    // Arrange
    User user = new User();
    user.setEmailAddress("42 Main St");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("com.symphony.integration.%s.%s", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals("42 Main St", getResult.getValue());
    assertEquals("com.symphony.integration.com.symphony.integration.%s.%s.user", actualToEntityResult.getType());
    assertEquals(EntityConstants.EMAIL_ADDRESS_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>Then return Type is {@code com.symphony.integration.com.symphony.integration.%s.%s.user}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_thenReturnTypeIsComSymphonyIntegrationComSymphonyIntegrationSSUser3() {
    // Arrange
    User user = new User();
    user.setDisplayName("\n");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("com.symphony.integration.%s.%s", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("Entity Name", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.com.symphony.integration.%s.%s.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>Then return Type is {@code com.symphony.integration.Integration Name.user}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_thenReturnTypeIsComSymphonyIntegrationIntegrationNameUser() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("Entity Name", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.Integration Name.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>Then return Type is {@code com.symphony.integration. .user}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_thenReturnTypeIsComSymphonyIntegrationUser() {
    // Arrange
    User user = new User();
    user.setEmailAddress("42 Main St");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("\n", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals("42 Main St", getResult.getValue());
    assertEquals("com.symphony.integration.\n.user", actualToEntityResult.getType());
    assertEquals(EntityConstants.EMAIL_ADDRESS_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>Then return Type is {@code com.symphony.integration.-.user}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_thenReturnTypeIsComSymphonyIntegrationUser2() {
    // Arrange
    User user = new User();
    user.setEmailAddress("42 Main St");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("-", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals("42 Main St", getResult.getValue());
    assertEquals("com.symphony.integration.-.user", actualToEntityResult.getType());
    assertEquals(EntityConstants.EMAIL_ADDRESS_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>Then return Type is {@code com.symphony.integration.user.user}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_thenReturnTypeIsComSymphonyIntegrationUserUser() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity(EntityConstants.USER_ENTITY_FIELD, "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("Entity Name", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.user.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>Then return Type is {@code com.symphony.integration.user.user}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_thenReturnTypeIsComSymphonyIntegrationUserUser2() {
    // Arrange
    User user = new User();
    user.setEmailAddress("42 Main St");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity(EntityConstants.USER_ENTITY_FIELD, "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals("42 Main St", getResult.getValue());
    assertEquals("com.symphony.integration.user.user", actualToEntityResult.getType());
    assertEquals(EntityConstants.EMAIL_ADDRESS_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>Then return Type is {@code com.symphony.integration.user.user}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_thenReturnTypeIsComSymphonyIntegrationUserUser3() {
    // Arrange
    User user = new User();
    user.setDisplayName("\n");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity(EntityConstants.USER_ENTITY_FIELD, "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("Entity Name", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.user.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>Then return Type is {@code com.symphony.integration.username.user}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_thenReturnTypeIsComSymphonyIntegrationUsernameUser() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity(EntityConstants.USERNAME_ENTITY_FIELD, "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("Entity Name", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.username.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>Then return Type is {@code com.symphony.integration.username.user}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_thenReturnTypeIsComSymphonyIntegrationUsernameUser2() {
    // Arrange
    User user = new User();
    user.setEmailAddress("42 Main St");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity(EntityConstants.USERNAME_ENTITY_FIELD, "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals("42 Main St", getResult.getValue());
    assertEquals("com.symphony.integration.username.user", actualToEntityResult.getType());
    assertEquals(EntityConstants.EMAIL_ADDRESS_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>Then return Type is {@code com.symphony.integration.username.user}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_thenReturnTypeIsComSymphonyIntegrationUsernameUser3() {
    // Arrange
    User user = new User();
    user.setDisplayName("\n");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity(EntityConstants.USERNAME_ENTITY_FIELD, "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("Entity Name", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.username.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>When {@code 1.0}.</li>
   *   <li>Then return Name is {@code 1.0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_when10_thenReturnNameIs10() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "1.0");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("1.0", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.Integration Name.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>When {@code 1.0}.</li>
   *   <li>Then return Name is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_when10_thenReturnNameIs42() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("1.0", "42");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("42", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.1.0.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>When {@code 1.0}.</li>
   *   <li>Then return Name is {@code 1.0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_when10_thenReturnNameIs102() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("1.0", "1.0");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("1.0", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.1.0.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>When {@code 1.0}.</li>
   *   <li>Then return Name is {@code <a href=}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_when10_thenReturnNameIsAHref() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("1.0", "<a href=");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("<a href=", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.1.0.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>When {@code 1.0}.</li>
   *   <li>Then return Name is {@code < a href = "http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;" >xx</a>}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_when10_thenReturnNameIsAHrefHttpUuuuuuuuuuuuUuAmpAmpUuAmpAmpXxA() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("1.0",
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>",
        actualToEntityResult.getName());
    assertEquals("com.symphony.integration.1.0.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>When {@code 1.0}.</li>
   *   <li>Then return Name is {@code <br/>
   * }.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_when10_thenReturnNameIsBr() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("1.0", "<br/>");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("<br/>", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.1.0.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>When {@code 1.0}.</li>
   *   <li>Then return Name is {@code com.symphony.integration.%s.%s}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_when10_thenReturnNameIsComSymphonyIntegrationSS() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("1.0", "com.symphony.integration.%s.%s");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("com.symphony.integration.%s.%s", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.1.0.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>When {@code 1.0}.</li>
   *   <li>Then return Name is {@code -}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_when10_thenReturnNameIsDash() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("1.0", "-");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("-", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.1.0.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>When {@code 1.0}.</li>
   *   <li>Then return Name is lf.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_when10_thenReturnNameIsLf() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("1.0", "\n");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("\n", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.1.0.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>When {@code 1.0}.</li>
   *   <li>Then return Name is {@link EntityConstants#USER_ENTITY_FIELD}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_when10_thenReturnNameIsUser_entity_field() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("1.0", EntityConstants.USER_ENTITY_FIELD);

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("com.symphony.integration.1.0.user", actualToEntityResult.getType());
    assertEquals(EntityConstants.USER_ENTITY_FIELD, actualToEntityResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>When {@code 1.0}.</li>
   *   <li>Then return Name is {@link EntityConstants#USERNAME_ENTITY_FIELD}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_when10_thenReturnNameIsUsername_entity_field() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("1.0", EntityConstants.USERNAME_ENTITY_FIELD);

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("com.symphony.integration.1.0.user", actualToEntityResult.getType());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, actualToEntityResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>When {@code 1.0}.</li>
   *   <li>Then return Type is {@code com.symphony.integration.1.0.user}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_when10_thenReturnTypeIsComSymphonyIntegration10User() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("1.0", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("Entity Name", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.1.0.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return Name is {@code 1.0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_when42_thenReturnNameIs10() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("42", "1.0");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("1.0", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.42.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return Name is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_when42_thenReturnNameIs42() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "42");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("42", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.Integration Name.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return Name is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_when42_thenReturnNameIs422() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("42", "42");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("42", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.42.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return Name is {@code <a href=}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_when42_thenReturnNameIsAHref() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("42", "<a href=");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("<a href=", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.42.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return Name is {@code < a href = "http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;" >xx</a>}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_when42_thenReturnNameIsAHrefHttpUuuuuuuuuuuuUuAmpAmpUuAmpAmpXxA() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("42",
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>",
        actualToEntityResult.getName());
    assertEquals("com.symphony.integration.42.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return Name is {@code <br/>
   * }.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_when42_thenReturnNameIsBr() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("42", "<br/>");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("<br/>", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.42.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return Name is {@code com.symphony.integration.%s.%s}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_when42_thenReturnNameIsComSymphonyIntegrationSS() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("42", "com.symphony.integration.%s.%s");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("com.symphony.integration.%s.%s", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.42.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return Name is {@code -}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_when42_thenReturnNameIsDash() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("42", "-");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("-", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.42.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return Name is lf.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_when42_thenReturnNameIsLf() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("42", "\n");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("\n", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.42.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return Name is {@link EntityConstants#USER_ENTITY_FIELD}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_when42_thenReturnNameIsUser_entity_field() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("42", EntityConstants.USER_ENTITY_FIELD);

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("com.symphony.integration.42.user", actualToEntityResult.getType());
    assertEquals(EntityConstants.USER_ENTITY_FIELD, actualToEntityResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return Name is {@link EntityConstants#USERNAME_ENTITY_FIELD}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_when42_thenReturnNameIsUsername_entity_field() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("42", EntityConstants.USERNAME_ENTITY_FIELD);

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("com.symphony.integration.42.user", actualToEntityResult.getType());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, actualToEntityResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return Type is {@code com.symphony.integration.42.user}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_when42_thenReturnTypeIsComSymphonyIntegration42User() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("42", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("Entity Name", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.42.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>When {@code < a href = "http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;" >xx</a>}.</li>
   *   <li>Then return Name is {@code 1.0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_whenAHrefHttpUuuuuuuuuuuuUuAmpAmpUuAmpAmpXxA_thenReturnNameIs10() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user
        .toEntity("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>", "1.0");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("1.0", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\" "
        + " >xx</a>.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>When {@code < a href = "http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;" >xx</a>}.</li>
   *   <li>Then return Name is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_whenAHrefHttpUuuuuuuuuuuuUuAmpAmpUuAmpAmpXxA_thenReturnNameIs42() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user
        .toEntity("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>", "42");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("42", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\" "
        + " >xx</a>.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>When {@code < a href = "http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;" >xx</a>}.</li>
   *   <li>Then return Name is {@code <a href=}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_whenAHrefHttpUuuuuuuuuuuuUuAmpAmpUuAmpAmpXxA_thenReturnNameIsAHref() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user
        .toEntity("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>", "<a href=");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("<a href=", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\" "
        + " >xx</a>.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>When {@code < a href = "http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;" >xx</a>}.</li>
   *   <li>Then return Name is {@code <br/>
   * }.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_whenAHrefHttpUuuuuuuuuuuuUuAmpAmpUuAmpAmpXxA_thenReturnNameIsBr() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user
        .toEntity("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>", "<br/>");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("<br/>", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\" "
        + " >xx</a>.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>When {@code < a href = "http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;" >xx</a>}.</li>
   *   <li>Then return Name is {@code -}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_whenAHrefHttpUuuuuuuuuuuuUuAmpAmpUuAmpAmpXxA_thenReturnNameIsDash() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user
        .toEntity("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>", "-");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("-", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\" "
        + " >xx</a>.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>When {@code < a href = "http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;" >xx</a>}.</li>
   *   <li>Then return Name is lf.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_whenAHrefHttpUuuuuuuuuuuuUuAmpAmpUuAmpAmpXxA_thenReturnNameIsLf() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user
        .toEntity("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>", "\n");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("\n", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\" "
        + " >xx</a>.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>When {@code <a href=}.</li>
   *   <li>Then return Name is {@code 1.0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_whenAHref_thenReturnNameIs10() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("<a href=", "1.0");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("1.0", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.<a href=.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>When {@code <a href=}.</li>
   *   <li>Then return Name is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_whenAHref_thenReturnNameIs42() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("<a href=", "42");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("42", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.<a href=.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>When {@code <a href=}.</li>
   *   <li>Then return Name is {@code <a href=}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_whenAHref_thenReturnNameIsAHref() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "<a href=");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("<a href=", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.Integration Name.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>When {@code <a href=}.</li>
   *   <li>Then return Name is {@code <a href=}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_whenAHref_thenReturnNameIsAHref2() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("<a href=", "<a href=");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("<a href=", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.<a href=.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>When {@code <a href=}.</li>
   *   <li>Then return Name is {@code < a href = "http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;" >xx</a>}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_whenAHref_thenReturnNameIsAHrefHttpUuuuuuuuuuuuUuAmpAmpUuAmpAmpXxA() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("<a href=",
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>",
        actualToEntityResult.getName());
    assertEquals("com.symphony.integration.<a href=.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>When {@code <a href=}.</li>
   *   <li>Then return Name is {@code <br/>
   * }.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_whenAHref_thenReturnNameIsBr() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("<a href=", "<br/>");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("<br/>", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.<a href=.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>When {@code <a href=}.</li>
   *   <li>Then return Name is {@code com.symphony.integration.%s.%s}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_whenAHref_thenReturnNameIsComSymphonyIntegrationSS() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("<a href=", "com.symphony.integration.%s.%s");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("com.symphony.integration.%s.%s", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.<a href=.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>When {@code <a href=}.</li>
   *   <li>Then return Name is {@code -}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_whenAHref_thenReturnNameIsDash() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("<a href=", "-");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("-", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.<a href=.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>When {@code <a href=}.</li>
   *   <li>Then return Name is lf.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_whenAHref_thenReturnNameIsLf() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("<a href=", "\n");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("\n", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.<a href=.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>When {@code <a href=}.</li>
   *   <li>Then return Name is {@link EntityConstants#USER_ENTITY_FIELD}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_whenAHref_thenReturnNameIsUser_entity_field() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("<a href=", EntityConstants.USER_ENTITY_FIELD);

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("com.symphony.integration.<a href=.user", actualToEntityResult.getType());
    assertEquals(EntityConstants.USER_ENTITY_FIELD, actualToEntityResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>When {@code <a href=}.</li>
   *   <li>Then return Name is {@link EntityConstants#USERNAME_ENTITY_FIELD}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_whenAHref_thenReturnNameIsUsername_entity_field() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("<a href=", EntityConstants.USERNAME_ENTITY_FIELD);

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("com.symphony.integration.<a href=.user", actualToEntityResult.getType());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, actualToEntityResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>When {@code <a href=}.</li>
   *   <li>Then return Type is {@code com.symphony.integration.<a href=.user}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_whenAHref_thenReturnTypeIsComSymphonyIntegrationAHrefUser() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("<a href=", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("Entity Name", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.<a href=.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>When {@code <br/>
   * }.</li>
   *   <li>Then return Name is {@code 1.0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_whenBr_thenReturnNameIs10() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("<br/>", "1.0");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("1.0", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.<br/>.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>When {@code <br/>
   * }.</li>
   *   <li>Then return Name is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_whenBr_thenReturnNameIs42() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("<br/>", "42");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("42", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.<br/>.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>When {@code <br/>
   * }.</li>
   *   <li>Then return Name is {@code <a href=}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_whenBr_thenReturnNameIsAHref() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("<br/>", "<a href=");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("<a href=", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.<br/>.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>When {@code <br/>
   * }.</li>
   *   <li>Then return Name is {@code < a href = "http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;" >xx</a>}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_whenBr_thenReturnNameIsAHrefHttpUuuuuuuuuuuuUuAmpAmpUuAmpAmpXxA() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("<br/>",
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>",
        actualToEntityResult.getName());
    assertEquals("com.symphony.integration.<br/>.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>When {@code <br/>
   * }.</li>
   *   <li>Then return Name is {@code <br/>
   * }.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_whenBr_thenReturnNameIsBr() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "<br/>");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("<br/>", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.Integration Name.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>When {@code <br/>
   * }.</li>
   *   <li>Then return Name is {@code <br/>
   * }.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_whenBr_thenReturnNameIsBr2() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("<br/>", "<br/>");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("<br/>", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.<br/>.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>When {@code <br/>
   * }.</li>
   *   <li>Then return Name is {@code com.symphony.integration.%s.%s}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_whenBr_thenReturnNameIsComSymphonyIntegrationSS() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("<br/>", "com.symphony.integration.%s.%s");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("com.symphony.integration.%s.%s", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.<br/>.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>When {@code <br/>
   * }.</li>
   *   <li>Then return Name is {@code -}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_whenBr_thenReturnNameIsDash() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("<br/>", "-");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("-", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.<br/>.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>When {@code <br/>
   * }.</li>
   *   <li>Then return Name is lf.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_whenBr_thenReturnNameIsLf() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("<br/>", "\n");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("\n", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.<br/>.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>When {@code <br/>
   * }.</li>
   *   <li>Then return Name is {@link EntityConstants#USER_ENTITY_FIELD}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_whenBr_thenReturnNameIsUser_entity_field() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("<br/>", EntityConstants.USER_ENTITY_FIELD);

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("com.symphony.integration.<br/>.user", actualToEntityResult.getType());
    assertEquals(EntityConstants.USER_ENTITY_FIELD, actualToEntityResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>When {@code <br/>
   * }.</li>
   *   <li>Then return Name is {@link EntityConstants#USERNAME_ENTITY_FIELD}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_whenBr_thenReturnNameIsUsername_entity_field() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("<br/>", EntityConstants.USERNAME_ENTITY_FIELD);

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("com.symphony.integration.<br/>.user", actualToEntityResult.getType());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, actualToEntityResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>When {@code <br/>
   * }.</li>
   *   <li>Then return Type is {@code com.symphony.integration.<br/>
   * .user}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_whenBr_thenReturnTypeIsComSymphonyIntegrationBrUser() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("<br/>", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("Entity Name", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.<br/>.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>When {@code com.symphony.integration.%s.%s}.</li>
   *   <li>Then return Name is {@code 1.0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_whenComSymphonyIntegrationSS_thenReturnNameIs10() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("com.symphony.integration.%s.%s", "1.0");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("1.0", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.com.symphony.integration.%s.%s.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>When {@code com.symphony.integration.%s.%s}.</li>
   *   <li>Then return Name is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_whenComSymphonyIntegrationSS_thenReturnNameIs42() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("com.symphony.integration.%s.%s", "42");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("42", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.com.symphony.integration.%s.%s.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>When {@code com.symphony.integration.%s.%s}.</li>
   *   <li>Then return Name is {@code <a href=}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_whenComSymphonyIntegrationSS_thenReturnNameIsAHref() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("com.symphony.integration.%s.%s", "<a href=");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("<a href=", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.com.symphony.integration.%s.%s.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>When {@code com.symphony.integration.%s.%s}.</li>
   *   <li>Then return Name is {@code <br/>
   * }.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_whenComSymphonyIntegrationSS_thenReturnNameIsBr() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("com.symphony.integration.%s.%s", "<br/>");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("<br/>", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.com.symphony.integration.%s.%s.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>When {@code com.symphony.integration.%s.%s}.</li>
   *   <li>Then return Name is {@code -}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_whenComSymphonyIntegrationSS_thenReturnNameIsDash() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("com.symphony.integration.%s.%s", "-");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("-", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.com.symphony.integration.%s.%s.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>When {@code com.symphony.integration.%s.%s}.</li>
   *   <li>Then return Name is lf.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_whenComSymphonyIntegrationSS_thenReturnNameIsLf() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("com.symphony.integration.%s.%s", "\n");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("\n", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.com.symphony.integration.%s.%s.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>When {@code com.symphony.integration.%s.%s}.</li>
   *   <li>Then return Name is {@link EntityConstants#USER_ENTITY_FIELD}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_whenComSymphonyIntegrationSS_thenReturnNameIsUser_entity_field() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("com.symphony.integration.%s.%s", EntityConstants.USER_ENTITY_FIELD);

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("com.symphony.integration.com.symphony.integration.%s.%s.user", actualToEntityResult.getType());
    assertEquals(EntityConstants.USER_ENTITY_FIELD, actualToEntityResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>When {@code com.symphony.integration.%s.%s}.</li>
   *   <li>Then return Name is {@link EntityConstants#USERNAME_ENTITY_FIELD}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_whenComSymphonyIntegrationSS_thenReturnNameIsUsername_entity_field() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("com.symphony.integration.%s.%s",
        EntityConstants.USERNAME_ENTITY_FIELD);

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("com.symphony.integration.com.symphony.integration.%s.%s.user", actualToEntityResult.getType());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, actualToEntityResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>When {@code -}.</li>
   *   <li>Then return Name is {@code 1.0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_whenDash_thenReturnNameIs10() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("-", "1.0");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("1.0", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.-.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>When {@code -}.</li>
   *   <li>Then return Name is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_whenDash_thenReturnNameIs42() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("-", "42");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("42", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.-.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>When {@code -}.</li>
   *   <li>Then return Name is {@code <a href=}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_whenDash_thenReturnNameIsAHref() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("-", "<a href=");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("<a href=", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.-.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>When {@code -}.</li>
   *   <li>Then return Name is {@code < a href = "http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;" >xx</a>}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_whenDash_thenReturnNameIsAHrefHttpUuuuuuuuuuuuUuAmpAmpUuAmpAmpXxA() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("-",
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>",
        actualToEntityResult.getName());
    assertEquals("com.symphony.integration.-.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>When {@code -}.</li>
   *   <li>Then return Name is {@code <br/>
   * }.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_whenDash_thenReturnNameIsBr() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("-", "<br/>");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("<br/>", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.-.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>When {@code -}.</li>
   *   <li>Then return Name is {@code com.symphony.integration.%s.%s}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_whenDash_thenReturnNameIsComSymphonyIntegrationSS() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("-", "com.symphony.integration.%s.%s");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("com.symphony.integration.%s.%s", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.-.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>When {@code -}.</li>
   *   <li>Then return Name is {@code -}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_whenDash_thenReturnNameIsDash() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "-");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("-", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.Integration Name.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>When {@code -}.</li>
   *   <li>Then return Name is {@code -}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_whenDash_thenReturnNameIsDash2() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("-", "-");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("-", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.-.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>When {@code -}.</li>
   *   <li>Then return Name is lf.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_whenDash_thenReturnNameIsLf() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("-", "\n");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("\n", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.-.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>When {@code -}.</li>
   *   <li>Then return Name is {@link EntityConstants#USER_ENTITY_FIELD}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_whenDash_thenReturnNameIsUser_entity_field() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("-", EntityConstants.USER_ENTITY_FIELD);

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("com.symphony.integration.-.user", actualToEntityResult.getType());
    assertEquals(EntityConstants.USER_ENTITY_FIELD, actualToEntityResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>When {@code -}.</li>
   *   <li>Then return Name is {@link EntityConstants#USERNAME_ENTITY_FIELD}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_whenDash_thenReturnNameIsUsername_entity_field() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("-", EntityConstants.USERNAME_ENTITY_FIELD);

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("com.symphony.integration.-.user", actualToEntityResult.getType());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, actualToEntityResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>When {@code -}.</li>
   *   <li>Then return Type is {@code com.symphony.integration.-.user}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_whenDash_thenReturnTypeIsComSymphonyIntegrationUser() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("-", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("Entity Name", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.-.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return Name is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_whenEmptyString_thenReturnNameIsEmptyString() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "");

    // Assert
    assertEquals("", actualToEntityResult.getName());
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("com.symphony.integration.Integration Name.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return Name is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_whenEmptyString_thenReturnNameIsEmptyString2() {
    // Arrange
    User user = new User();
    user.setEmailAddress("42 Main St");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "");

    // Assert
    assertEquals("", actualToEntityResult.getName());
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals("42 Main St", getResult.getValue());
    assertEquals(EntityConstants.EMAIL_ADDRESS_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return Name is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_whenEmptyString_thenReturnNameIsEmptyString3() {
    // Arrange
    User user = new User();
    user.setDisplayName("\n");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "");

    // Assert
    assertEquals("", actualToEntityResult.getName());
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("com.symphony.integration.Integration Name.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return Name is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_whenEmptyString_thenReturnNameIsEmptyString4() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("\n", "");

    // Assert
    assertEquals("", actualToEntityResult.getName());
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("com.symphony.integration.\n.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return Name is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_whenEmptyString_thenReturnNameIsEmptyString5() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user
        .toEntity("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>", "");

    // Assert
    assertEquals("", actualToEntityResult.getName());
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("com.symphony.integration.<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\" "
        + " >xx</a>.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return Name is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_whenEmptyString_thenReturnNameIsEmptyString6() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("-", "");

    // Assert
    assertEquals("", actualToEntityResult.getName());
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("com.symphony.integration.-.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return Name is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_whenEmptyString_thenReturnNameIsEmptyString7() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity(EntityConstants.USER_ENTITY_FIELD, "");

    // Assert
    assertEquals("", actualToEntityResult.getName());
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("com.symphony.integration.user.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return Name is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_whenEmptyString_thenReturnNameIsEmptyString8() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("com.symphony.integration.%s.%s", "");

    // Assert
    assertEquals("", actualToEntityResult.getName());
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("com.symphony.integration.com.symphony.integration.%s.%s.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return Name is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_whenEmptyString_thenReturnNameIsEmptyString9() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("1.0", "");

    // Assert
    assertEquals("", actualToEntityResult.getName());
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("com.symphony.integration.1.0.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return Name is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_whenEmptyString_thenReturnNameIsEmptyString10() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity(EntityConstants.USERNAME_ENTITY_FIELD, "");

    // Assert
    assertEquals("", actualToEntityResult.getName());
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("com.symphony.integration.username.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return Name is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_whenEmptyString_thenReturnNameIsEmptyString11() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("42", "");

    // Assert
    assertEquals("", actualToEntityResult.getName());
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("com.symphony.integration.42.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return Name is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_whenEmptyString_thenReturnNameIsEmptyString12() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("<br/>", "");

    // Assert
    assertEquals("", actualToEntityResult.getName());
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("com.symphony.integration.<br/>.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return Name is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_whenEmptyString_thenReturnNameIsEmptyString13() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("<a href=", "");

    // Assert
    assertEquals("", actualToEntityResult.getName());
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("com.symphony.integration.<a href=.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>When lf.</li>
   *   <li>Then return Name is {@code 1.0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_whenLf_thenReturnNameIs10() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("\n", "1.0");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("1.0", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.\n.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>When lf.</li>
   *   <li>Then return Name is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_whenLf_thenReturnNameIs42() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("\n", "42");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("42", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.\n.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>When lf.</li>
   *   <li>Then return Name is {@code <a href=}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_whenLf_thenReturnNameIsAHref() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("\n", "<a href=");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("<a href=", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.\n.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>When lf.</li>
   *   <li>Then return Name is {@code < a href = "http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;" >xx</a>}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_whenLf_thenReturnNameIsAHrefHttpUuuuuuuuuuuuUuAmpAmpUuAmpAmpXxA() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("\n",
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>",
        actualToEntityResult.getName());
    assertEquals("com.symphony.integration.\n.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>When lf.</li>
   *   <li>Then return Name is {@code <br/>
   * }.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_whenLf_thenReturnNameIsBr() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("\n", "<br/>");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("<br/>", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.\n.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>When lf.</li>
   *   <li>Then return Name is {@code com.symphony.integration.%s.%s}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_whenLf_thenReturnNameIsComSymphonyIntegrationSS() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("\n", "com.symphony.integration.%s.%s");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("com.symphony.integration.%s.%s", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.\n.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>When lf.</li>
   *   <li>Then return Name is {@code -}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_whenLf_thenReturnNameIsDash() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("\n", "-");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("-", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.\n.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>When lf.</li>
   *   <li>Then return Name is lf.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_whenLf_thenReturnNameIsLf() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "\n");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("\n", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.Integration Name.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>When lf.</li>
   *   <li>Then return Name is lf.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_whenLf_thenReturnNameIsLf2() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("\n", "\n");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("\n", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.\n.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>When lf.</li>
   *   <li>Then return Name is {@link EntityConstants#USER_ENTITY_FIELD}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_whenLf_thenReturnNameIsUser_entity_field() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("\n", EntityConstants.USER_ENTITY_FIELD);

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("com.symphony.integration.\n.user", actualToEntityResult.getType());
    assertEquals(EntityConstants.USER_ENTITY_FIELD, actualToEntityResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>When lf.</li>
   *   <li>Then return Name is {@link EntityConstants#USERNAME_ENTITY_FIELD}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_whenLf_thenReturnNameIsUsername_entity_field() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("\n", EntityConstants.USERNAME_ENTITY_FIELD);

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("com.symphony.integration.\n.user", actualToEntityResult.getType());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, actualToEntityResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>When lf.</li>
   *   <li>Then return Type is {@code com.symphony.integration. .user}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_whenLf_thenReturnTypeIsComSymphonyIntegrationUser() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("\n", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("Entity Name", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.\n.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return Name is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_whenNull_thenReturnNameIsNull() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", null);

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("com.symphony.integration.Integration Name.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return Name is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_whenNull_thenReturnNameIsNull2() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("\n", null);

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("com.symphony.integration.\n.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return Name is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_whenNull_thenReturnNameIsNull3() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user
        .toEntity("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>", null);

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("com.symphony.integration.<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\" "
        + " >xx</a>.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return Name is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_whenNull_thenReturnNameIsNull4() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("-", null);

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("com.symphony.integration.-.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return Name is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_whenNull_thenReturnNameIsNull5() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity(EntityConstants.USER_ENTITY_FIELD, null);

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("com.symphony.integration.user.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return Name is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_whenNull_thenReturnNameIsNull6() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("com.symphony.integration.%s.%s", null);

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("com.symphony.integration.com.symphony.integration.%s.%s.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return Name is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_whenNull_thenReturnNameIsNull7() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("1.0", null);

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("com.symphony.integration.1.0.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return Name is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_whenNull_thenReturnNameIsNull8() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity(EntityConstants.USERNAME_ENTITY_FIELD, null);

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("com.symphony.integration.username.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return Name is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_whenNull_thenReturnNameIsNull9() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("42", null);

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("com.symphony.integration.42.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return Name is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_whenNull_thenReturnNameIsNull10() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("<br/>", null);

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("com.symphony.integration.<br/>.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return Name is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_whenNull_thenReturnNameIsNull11() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("<a href=", null);

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("com.symphony.integration.<a href=.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>When {@code />}.</li>
   *   <li>Then return Name is {@code />}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_whenSlashGreaterThanSign_thenReturnNameIsSlashGreaterThanSign() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "/>");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("/>", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.Integration Name.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>When {@code />}.</li>
   *   <li>Then return Type is {@code com.symphony.integration./>.user}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_whenSlashGreaterThanSign_thenReturnTypeIsComSymphonyIntegrationUser() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("/>", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("Entity Name", actualToEntityResult.getName());
    assertEquals("com.symphony.integration./>.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>When {@link EntityConstants#USER_ENTITY_FIELD}.</li>
   *   <li>Then return Name is {@code 1.0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_whenUser_entity_field_thenReturnNameIs10() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity(EntityConstants.USER_ENTITY_FIELD, "1.0");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("1.0", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.user.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>When {@link EntityConstants#USER_ENTITY_FIELD}.</li>
   *   <li>Then return Name is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_whenUser_entity_field_thenReturnNameIs42() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity(EntityConstants.USER_ENTITY_FIELD, "42");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("42", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.user.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>When {@link EntityConstants#USER_ENTITY_FIELD}.</li>
   *   <li>Then return Name is {@code <a href=}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_whenUser_entity_field_thenReturnNameIsAHref() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity(EntityConstants.USER_ENTITY_FIELD, "<a href=");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("<a href=", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.user.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>When {@link EntityConstants#USER_ENTITY_FIELD}.</li>
   *   <li>Then return Name is {@code <br/>
   * }.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_whenUser_entity_field_thenReturnNameIsBr() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity(EntityConstants.USER_ENTITY_FIELD, "<br/>");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("<br/>", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.user.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>When {@link EntityConstants#USER_ENTITY_FIELD}.</li>
   *   <li>Then return Name is {@code com.symphony.integration.%s.%s}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_whenUser_entity_field_thenReturnNameIsComSymphonyIntegrationSS() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity(EntityConstants.USER_ENTITY_FIELD, "com.symphony.integration.%s.%s");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("com.symphony.integration.%s.%s", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.user.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>When {@link EntityConstants#USER_ENTITY_FIELD}.</li>
   *   <li>Then return Name is {@code -}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_whenUser_entity_field_thenReturnNameIsDash() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity(EntityConstants.USER_ENTITY_FIELD, "-");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("-", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.user.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>When {@link EntityConstants#USER_ENTITY_FIELD}.</li>
   *   <li>Then return Name is lf.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_whenUser_entity_field_thenReturnNameIsLf() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity(EntityConstants.USER_ENTITY_FIELD, "\n");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("\n", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.user.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>When {@link EntityConstants#USER_ENTITY_FIELD}.</li>
   *   <li>Then return Name is {@link EntityConstants#USER_ENTITY_FIELD}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_whenUser_entity_field_thenReturnNameIsUser_entity_field() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", EntityConstants.USER_ENTITY_FIELD);

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("com.symphony.integration.Integration Name.user", actualToEntityResult.getType());
    assertEquals(EntityConstants.USER_ENTITY_FIELD, actualToEntityResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>When {@link EntityConstants#USER_ENTITY_FIELD}.</li>
   *   <li>Then return Name is {@link EntityConstants#USER_ENTITY_FIELD}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_whenUser_entity_field_thenReturnNameIsUser_entity_field2() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity(EntityConstants.USER_ENTITY_FIELD, EntityConstants.USER_ENTITY_FIELD);

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("com.symphony.integration.user.user", actualToEntityResult.getType());
    assertEquals(EntityConstants.USER_ENTITY_FIELD, actualToEntityResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>When {@link EntityConstants#USER_ENTITY_FIELD}.</li>
   *   <li>Then return Name is {@link EntityConstants#USERNAME_ENTITY_FIELD}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_whenUser_entity_field_thenReturnNameIsUsername_entity_field() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity(EntityConstants.USER_ENTITY_FIELD,
        EntityConstants.USERNAME_ENTITY_FIELD);

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("com.symphony.integration.user.user", actualToEntityResult.getType());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, actualToEntityResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>When {@link EntityConstants#USERNAME_ENTITY_FIELD}.</li>
   *   <li>Then return Name is {@code 1.0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_whenUsername_entity_field_thenReturnNameIs10() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity(EntityConstants.USERNAME_ENTITY_FIELD, "1.0");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("1.0", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.username.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>When {@link EntityConstants#USERNAME_ENTITY_FIELD}.</li>
   *   <li>Then return Name is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_whenUsername_entity_field_thenReturnNameIs42() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity(EntityConstants.USERNAME_ENTITY_FIELD, "42");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("42", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.username.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>When {@link EntityConstants#USERNAME_ENTITY_FIELD}.</li>
   *   <li>Then return Name is {@code <a href=}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_whenUsername_entity_field_thenReturnNameIsAHref() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity(EntityConstants.USERNAME_ENTITY_FIELD, "<a href=");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("<a href=", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.username.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>When {@link EntityConstants#USERNAME_ENTITY_FIELD}.</li>
   *   <li>Then return Name is {@code <br/>
   * }.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_whenUsername_entity_field_thenReturnNameIsBr() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity(EntityConstants.USERNAME_ENTITY_FIELD, "<br/>");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("<br/>", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.username.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>When {@link EntityConstants#USERNAME_ENTITY_FIELD}.</li>
   *   <li>Then return Name is {@code com.symphony.integration.%s.%s}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_whenUsername_entity_field_thenReturnNameIsComSymphonyIntegrationSS() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity(EntityConstants.USERNAME_ENTITY_FIELD,
        "com.symphony.integration.%s.%s");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("com.symphony.integration.%s.%s", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.username.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>When {@link EntityConstants#USERNAME_ENTITY_FIELD}.</li>
   *   <li>Then return Name is {@code -}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_whenUsername_entity_field_thenReturnNameIsDash() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity(EntityConstants.USERNAME_ENTITY_FIELD, "-");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("-", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.username.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>When {@link EntityConstants#USERNAME_ENTITY_FIELD}.</li>
   *   <li>Then return Name is lf.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_whenUsername_entity_field_thenReturnNameIsLf() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity(EntityConstants.USERNAME_ENTITY_FIELD, "\n");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("\n", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.username.user", actualToEntityResult.getType());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>When {@link EntityConstants#USERNAME_ENTITY_FIELD}.</li>
   *   <li>Then return Name is {@link EntityConstants#USER_ENTITY_FIELD}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_whenUsername_entity_field_thenReturnNameIsUser_entity_field() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity(EntityConstants.USERNAME_ENTITY_FIELD,
        EntityConstants.USER_ENTITY_FIELD);

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("com.symphony.integration.username.user", actualToEntityResult.getType());
    assertEquals(EntityConstants.USER_ENTITY_FIELD, actualToEntityResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>When {@link EntityConstants#USERNAME_ENTITY_FIELD}.</li>
   *   <li>Then return Name is {@link EntityConstants#USERNAME_ENTITY_FIELD}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_whenUsername_entity_field_thenReturnNameIsUsername_entity_field() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", EntityConstants.USERNAME_ENTITY_FIELD);

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("com.symphony.integration.Integration Name.user", actualToEntityResult.getType());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, actualToEntityResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   * <ul>
   *   <li>When {@link EntityConstants#USERNAME_ENTITY_FIELD}.</li>
   *   <li>Then return Name is {@link EntityConstants#USERNAME_ENTITY_FIELD}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_whenUsername_entity_field_thenReturnNameIsUsername_entity_field2() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity(EntityConstants.USERNAME_ENTITY_FIELD,
        EntityConstants.USERNAME_ENTITY_FIELD);

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        attributes.get(0).getValue());
    assertEquals("com.symphony.integration.username.user", actualToEntityResult.getType());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, actualToEntityResult.getName());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link User}
   *   <li>{@link User#setDisplayName(String)}
   *   <li>{@link User#setEmailAddress(String)}
   *   <li>{@link User#setId(Long)}
   *   <li>{@link User#setUserName(String)}
   *   <li>{@link User#getDisplayName()}
   *   <li>{@link User#getEmailAddress()}
   *   <li>{@link User#getId()}
   *   <li>{@link User#getUsername()}
   * </ul>
   */
  @Test
  @MethodsUnderTest({"void User.<init>()", "String User.getDisplayName()", "String User.getEmailAddress()",
      "Long User.getId()", "String User.getUsername()", "void User.setDisplayName(String)",
      "void User.setEmailAddress(String)", "void User.setId(Long)", "void User.setUserName(String)"})
  public void testGettersAndSetters() {
    // Arrange and Act
    User actualUser = new User();
    actualUser.setDisplayName("Display Name");
    actualUser.setEmailAddress("42 Main St");
    actualUser.setId(1L);
    actualUser.setUserName("janedoe");
    String actualDisplayName = actualUser.getDisplayName();
    String actualEmailAddress = actualUser.getEmailAddress();
    Long actualId = actualUser.getId();

    // Assert
    assertEquals("42 Main St", actualEmailAddress);
    assertEquals("Display Name", actualDisplayName);
    assertEquals("janedoe", actualUser.getUsername());
    assertEquals(1L, actualId.longValue());
  }
}
