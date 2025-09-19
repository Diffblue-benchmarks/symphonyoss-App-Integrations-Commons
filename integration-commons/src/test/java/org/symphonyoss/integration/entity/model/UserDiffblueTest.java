package org.symphonyoss.integration.entity.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import org.junit.Test;
import org.symphonyoss.integration.entity.Attribute;
import org.symphonyoss.integration.entity.Entity;

public class UserDiffblueTest {
  /**
   * Test {@link User#getMentionEntity(String)}.
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) DisplayName is empty string.
   *   <li>Then return Name is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) DisplayName is lf.
   *   <li>Then return Name is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is eight.
   *   <li>Then return Attributes first Value is {@code 8}.
   * </ul>
   *
   * <p>Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsEight_thenReturnAttributesFirstValueIs8() {
    // Arrange
    User user = new User();
    user.setDisplayName(
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
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
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is eight.
   *   <li>Then return Attributes first Value is {@code 8}.
   * </ul>
   *
   * <p>Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsEight_thenReturnAttributesFirstValueIs82() {
    // Arrange
    User user = new User();
    user.setUserName("janedoe");
    user.setDisplayName(
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
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
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is eight.
   *   <li>Then return Attributes first Value is {@code 8}.
   * </ul>
   *
   * <p>Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsEight_thenReturnAttributesFirstValueIs83() {
    // Arrange
    User user = new User();
    user.setEmailAddress("42 Main St");
    user.setDisplayName(
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
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
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is eight.
   *   <li>Then return Attributes first Value is {@code 8}.
   * </ul>
   *
   * <p>Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsEight_thenReturnAttributesFirstValueIs84() {
    // Arrange
    User user = new User();
    user.setEmailAddress("42 Main St");
    user.setUserName("janedoe");
    user.setDisplayName(
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
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
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is eight.
   *   <li>Then return Attributes first Value is {@code 8}.
   * </ul>
   *
   * <p>Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsEight_thenReturnAttributesFirstValueIs85() {
    // Arrange
    User user = new User();
    user.setUserName("janedoe");
    user.setEmailAddress("42 Main St");
    user.setDisplayName(
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
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
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is five.
   *   <li>Then return Attributes first Value is {@code 5}.
   * </ul>
   *
   * <p>Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsFive_thenReturnAttributesFirstValueIs5() {
    // Arrange
    User user = new User();
    user.setDisplayName(
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
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
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is five.
   *   <li>Then return Attributes first Value is {@code 5}.
   * </ul>
   *
   * <p>Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsFive_thenReturnAttributesFirstValueIs52() {
    // Arrange
    User user = new User();
    user.setUserName("janedoe");
    user.setDisplayName(
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
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
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is five.
   *   <li>Then return Attributes first Value is {@code 5}.
   * </ul>
   *
   * <p>Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsFive_thenReturnAttributesFirstValueIs53() {
    // Arrange
    User user = new User();
    user.setEmailAddress("42 Main St");
    user.setDisplayName(
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
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
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is five.
   *   <li>Then return Attributes first Value is {@code 5}.
   * </ul>
   *
   * <p>Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsFive_thenReturnAttributesFirstValueIs54() {
    // Arrange
    User user = new User();
    user.setEmailAddress("42 Main St");
    user.setUserName("janedoe");
    user.setDisplayName(
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
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
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is five.
   *   <li>Then return Attributes first Value is {@code 5}.
   * </ul>
   *
   * <p>Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsFive_thenReturnAttributesFirstValueIs55() {
    // Arrange
    User user = new User();
    user.setUserName("janedoe");
    user.setEmailAddress("42 Main St");
    user.setDisplayName(
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
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
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is four.
   *   <li>Then return Attributes first Value is {@code 4}.
   * </ul>
   *
   * <p>Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsFour_thenReturnAttributesFirstValueIs4() {
    // Arrange
    User user = new User();
    user.setDisplayName(
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
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
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is four.
   *   <li>Then return Attributes first Value is {@code 4}.
   * </ul>
   *
   * <p>Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsFour_thenReturnAttributesFirstValueIs42() {
    // Arrange
    User user = new User();
    user.setUserName("janedoe");
    user.setDisplayName(
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
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
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is four.
   *   <li>Then return Attributes first Value is {@code 4}.
   * </ul>
   *
   * <p>Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsFour_thenReturnAttributesFirstValueIs43() {
    // Arrange
    User user = new User();
    user.setEmailAddress("42 Main St");
    user.setDisplayName(
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
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
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is four.
   *   <li>Then return Attributes first Value is {@code 4}.
   * </ul>
   *
   * <p>Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsFour_thenReturnAttributesFirstValueIs44() {
    // Arrange
    User user = new User();
    user.setEmailAddress("42 Main St");
    user.setUserName("janedoe");
    user.setDisplayName(
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
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
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is four.
   *   <li>Then return Attributes first Value is {@code 4}.
   * </ul>
   *
   * <p>Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsFour_thenReturnAttributesFirstValueIs45() {
    // Arrange
    User user = new User();
    user.setUserName("janedoe");
    user.setEmailAddress("42 Main St");
    user.setDisplayName(
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
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
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is minus one.
   *   <li>Then return Attributes first Value is {@code -1}.
   * </ul>
   *
   * <p>Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsMinusOne_thenReturnAttributesFirstValueIs1() {
    // Arrange
    User user = new User();
    user.setDisplayName(
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
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
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is minus one.
   *   <li>Then return Attributes first Value is {@code -1}.
   * </ul>
   *
   * <p>Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsMinusOne_thenReturnAttributesFirstValueIs12() {
    // Arrange
    User user = new User();
    user.setUserName("janedoe");
    user.setDisplayName(
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
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
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is minus one.
   *   <li>Then return Attributes first Value is {@code -1}.
   * </ul>
   *
   * <p>Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsMinusOne_thenReturnAttributesFirstValueIs13() {
    // Arrange
    User user = new User();
    user.setEmailAddress("42 Main St");
    user.setDisplayName(
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
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
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is minus one.
   *   <li>Then return Attributes first Value is {@code -1}.
   * </ul>
   *
   * <p>Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsMinusOne_thenReturnAttributesFirstValueIs14() {
    // Arrange
    User user = new User();
    user.setEmailAddress("42 Main St");
    user.setUserName("janedoe");
    user.setDisplayName(
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
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
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is minus one.
   *   <li>Then return Attributes first Value is {@code -1}.
   * </ul>
   *
   * <p>Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsMinusOne_thenReturnAttributesFirstValueIs15() {
    // Arrange
    User user = new User();
    user.setUserName("janedoe");
    user.setEmailAddress("42 Main St");
    user.setDisplayName(
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
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
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is nine.
   *   <li>Then return Attributes first Value is {@code 9}.
   * </ul>
   *
   * <p>Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsNine_thenReturnAttributesFirstValueIs9() {
    // Arrange
    User user = new User();
    user.setDisplayName(
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
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
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is nine.
   *   <li>Then return Attributes first Value is {@code 9}.
   * </ul>
   *
   * <p>Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsNine_thenReturnAttributesFirstValueIs92() {
    // Arrange
    User user = new User();
    user.setUserName("janedoe");
    user.setDisplayName(
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
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
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is nine.
   *   <li>Then return Attributes first Value is {@code 9}.
   * </ul>
   *
   * <p>Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsNine_thenReturnAttributesFirstValueIs93() {
    // Arrange
    User user = new User();
    user.setEmailAddress("42 Main St");
    user.setDisplayName(
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
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
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is nine.
   *   <li>Then return Attributes first Value is {@code 9}.
   * </ul>
   *
   * <p>Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsNine_thenReturnAttributesFirstValueIs94() {
    // Arrange
    User user = new User();
    user.setEmailAddress("42 Main St");
    user.setUserName("janedoe");
    user.setDisplayName(
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
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
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is nine.
   *   <li>Then return Attributes first Value is {@code 9}.
   * </ul>
   *
   * <p>Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsNine_thenReturnAttributesFirstValueIs95() {
    // Arrange
    User user = new User();
    user.setUserName("janedoe");
    user.setEmailAddress("42 Main St");
    user.setDisplayName(
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
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
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is one.
   *   <li>Then return Attributes first Value is {@code 1}.
   * </ul>
   *
   * <p>Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsOne_thenReturnAttributesFirstValueIs1() {
    // Arrange
    User user = new User();
    user.setDisplayName(
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
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
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is one.
   *   <li>Then return Attributes first Value is {@code 1}.
   * </ul>
   *
   * <p>Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsOne_thenReturnAttributesFirstValueIs12() {
    // Arrange
    User user = new User();
    user.setUserName("janedoe");
    user.setDisplayName(
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
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
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is one.
   *   <li>Then return Attributes first Value is {@code 1}.
   * </ul>
   *
   * <p>Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsOne_thenReturnAttributesFirstValueIs13() {
    // Arrange
    User user = new User();
    user.setEmailAddress("42 Main St");
    user.setDisplayName(
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
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
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is one.
   *   <li>Then return Attributes first Value is {@code 1}.
   * </ul>
   *
   * <p>Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsOne_thenReturnAttributesFirstValueIs14() {
    // Arrange
    User user = new User();
    user.setEmailAddress("42 Main St");
    user.setUserName("janedoe");
    user.setDisplayName(
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
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
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is one.
   *   <li>Then return Name is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsOne_thenReturnNameIsNull() {
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
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is seven.
   *   <li>Then return Attributes first Value is {@code 7}.
   * </ul>
   *
   * <p>Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsSeven_thenReturnAttributesFirstValueIs7() {
    // Arrange
    User user = new User();
    user.setDisplayName(
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
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
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is seven.
   *   <li>Then return Attributes first Value is {@code 7}.
   * </ul>
   *
   * <p>Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsSeven_thenReturnAttributesFirstValueIs72() {
    // Arrange
    User user = new User();
    user.setUserName("janedoe");
    user.setDisplayName(
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
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
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is seven.
   *   <li>Then return Attributes first Value is {@code 7}.
   * </ul>
   *
   * <p>Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsSeven_thenReturnAttributesFirstValueIs73() {
    // Arrange
    User user = new User();
    user.setEmailAddress("42 Main St");
    user.setDisplayName(
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
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
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is seven.
   *   <li>Then return Attributes first Value is {@code 7}.
   * </ul>
   *
   * <p>Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsSeven_thenReturnAttributesFirstValueIs74() {
    // Arrange
    User user = new User();
    user.setEmailAddress("42 Main St");
    user.setUserName("janedoe");
    user.setDisplayName(
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
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
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is seven.
   *   <li>Then return Attributes first Value is {@code 7}.
   * </ul>
   *
   * <p>Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsSeven_thenReturnAttributesFirstValueIs75() {
    // Arrange
    User user = new User();
    user.setUserName("janedoe");
    user.setEmailAddress("42 Main St");
    user.setDisplayName(
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
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
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is six.
   *   <li>Then return Attributes first Value is {@code 6}.
   * </ul>
   *
   * <p>Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsSix_thenReturnAttributesFirstValueIs6() {
    // Arrange
    User user = new User();
    user.setDisplayName(
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
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
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is six.
   *   <li>Then return Attributes first Value is {@code 6}.
   * </ul>
   *
   * <p>Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsSix_thenReturnAttributesFirstValueIs62() {
    // Arrange
    User user = new User();
    user.setUserName("janedoe");
    user.setDisplayName(
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
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
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is six.
   *   <li>Then return Attributes first Value is {@code 6}.
   * </ul>
   *
   * <p>Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsSix_thenReturnAttributesFirstValueIs63() {
    // Arrange
    User user = new User();
    user.setEmailAddress("42 Main St");
    user.setDisplayName(
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
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
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is six.
   *   <li>Then return Attributes first Value is {@code 6}.
   * </ul>
   *
   * <p>Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsSix_thenReturnAttributesFirstValueIs64() {
    // Arrange
    User user = new User();
    user.setEmailAddress("42 Main St");
    user.setUserName("janedoe");
    user.setDisplayName(
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
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
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is six.
   *   <li>Then return Attributes first Value is {@code 6}.
   * </ul>
   *
   * <p>Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsSix_thenReturnAttributesFirstValueIs65() {
    // Arrange
    User user = new User();
    user.setUserName("janedoe");
    user.setEmailAddress("42 Main St");
    user.setDisplayName(
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
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
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is ten.
   *   <li>Then return Attributes first Value is {@code 10}.
   * </ul>
   *
   * <p>Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsTen_thenReturnAttributesFirstValueIs10() {
    // Arrange
    User user = new User();
    user.setDisplayName(
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
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
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is ten.
   *   <li>Then return Attributes first Value is {@code 10}.
   * </ul>
   *
   * <p>Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsTen_thenReturnAttributesFirstValueIs102() {
    // Arrange
    User user = new User();
    user.setUserName("janedoe");
    user.setDisplayName(
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
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
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is ten.
   *   <li>Then return Attributes first Value is {@code 10}.
   * </ul>
   *
   * <p>Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsTen_thenReturnAttributesFirstValueIs103() {
    // Arrange
    User user = new User();
    user.setEmailAddress("42 Main St");
    user.setDisplayName(
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
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
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is ten.
   *   <li>Then return Attributes first Value is {@code 10}.
   * </ul>
   *
   * <p>Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsTen_thenReturnAttributesFirstValueIs104() {
    // Arrange
    User user = new User();
    user.setEmailAddress("42 Main St");
    user.setUserName("janedoe");
    user.setDisplayName(
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
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
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is ten.
   *   <li>Then return Attributes first Value is {@code 10}.
   * </ul>
   *
   * <p>Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsTen_thenReturnAttributesFirstValueIs105() {
    // Arrange
    User user = new User();
    user.setUserName("janedoe");
    user.setEmailAddress("42 Main St");
    user.setDisplayName(
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
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
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is three.
   *   <li>Then return Attributes first Value is {@code 3}.
   * </ul>
   *
   * <p>Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsThree_thenReturnAttributesFirstValueIs3() {
    // Arrange
    User user = new User();
    user.setDisplayName(
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
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
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is three.
   *   <li>Then return Attributes first Value is {@code 3}.
   * </ul>
   *
   * <p>Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsThree_thenReturnAttributesFirstValueIs32() {
    // Arrange
    User user = new User();
    user.setUserName("janedoe");
    user.setDisplayName(
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
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
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is three.
   *   <li>Then return Attributes first Value is {@code 3}.
   * </ul>
   *
   * <p>Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsThree_thenReturnAttributesFirstValueIs33() {
    // Arrange
    User user = new User();
    user.setEmailAddress("42 Main St");
    user.setDisplayName(
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
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
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is three.
   *   <li>Then return Attributes first Value is {@code 3}.
   * </ul>
   *
   * <p>Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsThree_thenReturnAttributesFirstValueIs34() {
    // Arrange
    User user = new User();
    user.setEmailAddress("42 Main St");
    user.setUserName("janedoe");
    user.setDisplayName(
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
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
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is three.
   *   <li>Then return Attributes first Value is {@code 3}.
   * </ul>
   *
   * <p>Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsThree_thenReturnAttributesFirstValueIs35() {
    // Arrange
    User user = new User();
    user.setUserName("janedoe");
    user.setEmailAddress("42 Main St");
    user.setDisplayName(
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
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
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is two.
   *   <li>Then return Attributes first Value is {@code 2}.
   * </ul>
   *
   * <p>Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsTwo_thenReturnAttributesFirstValueIs2() {
    // Arrange
    User user = new User();
    user.setDisplayName(
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
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
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is two.
   *   <li>Then return Attributes first Value is {@code 2}.
   * </ul>
   *
   * <p>Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsTwo_thenReturnAttributesFirstValueIs22() {
    // Arrange
    User user = new User();
    user.setUserName("janedoe");
    user.setDisplayName(
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
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
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is two.
   *   <li>Then return Attributes first Value is {@code 2}.
   * </ul>
   *
   * <p>Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsTwo_thenReturnAttributesFirstValueIs23() {
    // Arrange
    User user = new User();
    user.setEmailAddress("42 Main St");
    user.setDisplayName(
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
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
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is two.
   *   <li>Then return Attributes first Value is {@code 2}.
   * </ul>
   *
   * <p>Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsTwo_thenReturnAttributesFirstValueIs24() {
    // Arrange
    User user = new User();
    user.setEmailAddress("42 Main St");
    user.setUserName("janedoe");
    user.setDisplayName(
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
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
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is two.
   *   <li>Then return Attributes first Value is {@code 2}.
   * </ul>
   *
   * <p>Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsTwo_thenReturnAttributesFirstValueIs25() {
    // Arrange
    User user = new User();
    user.setUserName("janedoe");
    user.setEmailAddress("42 Main St");
    user.setDisplayName(
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
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
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is zero.
   *   <li>Then return Attributes first Value is {@code 0}.
   * </ul>
   *
   * <p>Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsZero_thenReturnAttributesFirstValueIs0() {
    // Arrange
    User user = new User();
    user.setDisplayName(
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
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
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is zero.
   *   <li>Then return Attributes first Value is {@code 0}.
   * </ul>
   *
   * <p>Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsZero_thenReturnAttributesFirstValueIs02() {
    // Arrange
    User user = new User();
    user.setUserName("janedoe");
    user.setDisplayName(
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
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
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is zero.
   *   <li>Then return Attributes first Value is {@code 0}.
   * </ul>
   *
   * <p>Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsZero_thenReturnAttributesFirstValueIs03() {
    // Arrange
    User user = new User();
    user.setEmailAddress("42 Main St");
    user.setDisplayName(
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
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
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is zero.
   *   <li>Then return Attributes first Value is {@code 0}.
   * </ul>
   *
   * <p>Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsZero_thenReturnAttributesFirstValueIs04() {
    // Arrange
    User user = new User();
    user.setEmailAddress("42 Main St");
    user.setUserName("janedoe");
    user.setDisplayName(
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
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
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is zero.
   *   <li>Then return Attributes first Value is {@code 0}.
   * </ul>
   *
   * <p>Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUserIdIsZero_thenReturnAttributesFirstValueIs05() {
    // Arrange
    User user = new User();
    user.setUserName("janedoe");
    user.setEmailAddress("42 Main St");
    user.setDisplayName(
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
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
   *
   * <ul>
   *   <li>Given {@link User} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_givenUser_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new User().getMentionEntity("Integration Name"));
  }

  /**
   * Test {@link User#getMentionEntity(String)}.
   *
   * <ul>
   *   <li>Then return Attributes first Value is {@code 123}.
   * </ul>
   *
   * <p>Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_thenReturnAttributesFirstValueIs123() {
    // Arrange
    User user = new User();
    user.setDisplayName(
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
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
   *
   * <ul>
   *   <li>Then return Attributes first Value is {@code 123}.
   * </ul>
   *
   * <p>Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_thenReturnAttributesFirstValueIs1232() {
    // Arrange
    User user = new User();
    user.setUserName("janedoe");
    user.setDisplayName(
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
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
   *
   * <ul>
   *   <li>Then return Attributes first Value is {@code 123}.
   * </ul>
   *
   * <p>Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_thenReturnAttributesFirstValueIs1233() {
    // Arrange
    User user = new User();
    user.setEmailAddress("42 Main St");
    user.setDisplayName(
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
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
   *
   * <ul>
   *   <li>Then return Attributes first Value is {@code 123}.
   * </ul>
   *
   * <p>Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_thenReturnAttributesFirstValueIs1234() {
    // Arrange
    User user = new User();
    user.setEmailAddress("42 Main St");
    user.setUserName("janedoe");
    user.setDisplayName(
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
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
   *
   * <ul>
   *   <li>Then return Attributes first Value is {@code 123}.
   * </ul>
   *
   * <p>Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_thenReturnAttributesFirstValueIs1235() {
    // Arrange
    User user = new User();
    user.setUserName("janedoe");
    user.setEmailAddress("42 Main St");
    user.setDisplayName(
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
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
   *
   * <ul>
   *   <li>Then return Attributes first Value is {@code 9223372036854775807}.
   * </ul>
   *
   * <p>Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_thenReturnAttributesFirstValueIs9223372036854775807() {
    // Arrange
    User user = new User();
    user.setDisplayName(
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
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
   *
   * <ul>
   *   <li>Then return Attributes first Value is {@code -9223372036854775808}.
   * </ul>
   *
   * <p>Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_thenReturnAttributesFirstValueIs9223372036854775808() {
    // Arrange
    User user = new User();
    user.setDisplayName(
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
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
   *
   * <ul>
   *   <li>Then return Attributes first Value is {@code 9223372036854775807}.
   * </ul>
   *
   * <p>Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_thenReturnAttributesFirstValueIs92233720368547758072() {
    // Arrange
    User user = new User();
    user.setUserName("janedoe");
    user.setDisplayName(
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
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
   *
   * <ul>
   *   <li>Then return Attributes first Value is {@code 9223372036854775807}.
   * </ul>
   *
   * <p>Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_thenReturnAttributesFirstValueIs92233720368547758073() {
    // Arrange
    User user = new User();
    user.setEmailAddress("42 Main St");
    user.setDisplayName(
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
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
   *
   * <ul>
   *   <li>Then return Attributes first Value is {@code 9223372036854775807}.
   * </ul>
   *
   * <p>Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_thenReturnAttributesFirstValueIs92233720368547758074() {
    // Arrange
    User user = new User();
    user.setEmailAddress("42 Main St");
    user.setUserName("janedoe");
    user.setDisplayName(
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
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
   *
   * <ul>
   *   <li>Then return Attributes first Value is {@code 9223372036854775807}.
   * </ul>
   *
   * <p>Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_thenReturnAttributesFirstValueIs92233720368547758075() {
    // Arrange
    User user = new User();
    user.setUserName("janedoe");
    user.setEmailAddress("42 Main St");
    user.setDisplayName(
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
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
   *
   * <ul>
   *   <li>Then return Attributes first Value is {@code -9223372036854775808}.
   * </ul>
   *
   * <p>Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_thenReturnAttributesFirstValueIs92233720368547758082() {
    // Arrange
    User user = new User();
    user.setUserName("janedoe");
    user.setDisplayName(
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
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
   *
   * <ul>
   *   <li>Then return Attributes first Value is {@code -9223372036854775808}.
   * </ul>
   *
   * <p>Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_thenReturnAttributesFirstValueIs92233720368547758083() {
    // Arrange
    User user = new User();
    user.setEmailAddress("42 Main St");
    user.setDisplayName(
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
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
   *
   * <ul>
   *   <li>Then return Attributes first Value is {@code -9223372036854775808}.
   * </ul>
   *
   * <p>Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_thenReturnAttributesFirstValueIs92233720368547758084() {
    // Arrange
    User user = new User();
    user.setEmailAddress("42 Main St");
    user.setUserName("janedoe");
    user.setDisplayName(
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
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
   *
   * <ul>
   *   <li>Then return Attributes first Value is {@code -9223372036854775808}.
   * </ul>
   *
   * <p>Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.getMentionEntity(String)"})
  public void testGetMentionEntity_thenReturnAttributesFirstValueIs92233720368547758085() {
    // Arrange
    User user = new User();
    user.setUserName("janedoe");
    user.setEmailAddress("42 Main St");
    user.setDisplayName(
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
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
   *
   * <ul>
   *   <li>Then return Attributes second Value is {@link EntityConstants#MENTION_TYPE}.
   * </ul>
   *
   * <p>Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  @ManagedByDiffblue
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
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) DisplayName is {@code 1.0}.
   *   <li>Then return Attributes second Value is {@code 1.0}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
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
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.DISPLAY_NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) DisplayName is {@code 1.0}.
   *   <li>Then return Attributes third Value is {@code 1.0}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserDisplayNameIs10_thenReturnAttributesThirdValueIs10() {
    // Arrange
    User user = new User();
    user.setEmailAddress("42 Main St");
    user.setDisplayName("1.0");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act and Assert
    List<Attribute> attributes = user.toEntity("Integration Name", "Entity Name").getAttributes();
    assertEquals(3, attributes.size());
    Attribute getResult = attributes.get(2);
    assertEquals("1.0", getResult.getValue());
    assertEquals("42 Main St", attributes.get(1).getValue());
    assertEquals(EntityConstants.DISPLAY_NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) DisplayName is {@code 1.0}.
   *   <li>Then return Attributes third Value is {@code 1.0}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserDisplayNameIs10_thenReturnAttributesThirdValueIs102() {
    // Arrange
    User user = new User();
    user.setDisplayName("1.0");
    user.setEmailAddress("17 High St");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act and Assert
    List<Attribute> attributes = user.toEntity("Integration Name", "Entity Name").getAttributes();
    assertEquals(3, attributes.size());
    Attribute getResult = attributes.get(2);
    assertEquals("1.0", getResult.getValue());
    assertEquals("17 High St", attributes.get(1).getValue());
    assertEquals(EntityConstants.DISPLAY_NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) DisplayName is {@code 1.0}.
   *   <li>Then return Attributes third Value is {@code 1.0}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserDisplayNameIs10_thenReturnAttributesThirdValueIs103() {
    // Arrange
    User user = new User();
    user.setDisplayName("1.0");
    user.setEmailAddress("11 Station Rd");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act and Assert
    List<Attribute> attributes = user.toEntity("Integration Name", "Entity Name").getAttributes();
    assertEquals(3, attributes.size());
    Attribute getResult = attributes.get(2);
    assertEquals("1.0", getResult.getValue());
    assertEquals("11 Station Rd", attributes.get(1).getValue());
    assertEquals(EntityConstants.DISPLAY_NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) DisplayName is {@code 42}.
   *   <li>Then return Attributes second Value is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
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
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.DISPLAY_NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) DisplayName is {@code 42}.
   *   <li>Then return Attributes third Value is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserDisplayNameIs42_thenReturnAttributesThirdValueIs42() {
    // Arrange
    User user = new User();
    user.setEmailAddress("42 Main St");
    user.setDisplayName("42");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act and Assert
    List<Attribute> attributes = user.toEntity("Integration Name", "Entity Name").getAttributes();
    assertEquals(3, attributes.size());
    assertEquals("42 Main St", attributes.get(1).getValue());
    Attribute getResult = attributes.get(2);
    assertEquals("42", getResult.getValue());
    assertEquals(EntityConstants.DISPLAY_NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) DisplayName is {@code 42}.
   *   <li>Then return Attributes third Value is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserDisplayNameIs42_thenReturnAttributesThirdValueIs422() {
    // Arrange
    User user = new User();
    user.setDisplayName("42");
    user.setEmailAddress("17 High St");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act and Assert
    List<Attribute> attributes = user.toEntity("Integration Name", "Entity Name").getAttributes();
    assertEquals(3, attributes.size());
    assertEquals("17 High St", attributes.get(1).getValue());
    Attribute getResult = attributes.get(2);
    assertEquals("42", getResult.getValue());
    assertEquals(EntityConstants.DISPLAY_NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) DisplayName is {@code 42}.
   *   <li>Then return Attributes third Value is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserDisplayNameIs42_thenReturnAttributesThirdValueIs423() {
    // Arrange
    User user = new User();
    user.setDisplayName("42");
    user.setEmailAddress("11 Station Rd");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act and Assert
    List<Attribute> attributes = user.toEntity("Integration Name", "Entity Name").getAttributes();
    assertEquals(3, attributes.size());
    assertEquals("11 Station Rd", attributes.get(1).getValue());
    Attribute getResult = attributes.get(2);
    assertEquals("42", getResult.getValue());
    assertEquals(EntityConstants.DISPLAY_NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) DisplayName is {@code < a href =
   *       "http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;" >xx</a>}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserDisplayNameIsAHrefHttpUuuuuuuuuuuuUuAmpAmpUuAmpAmpXxA() {
    // Arrange
    User user = new User();
    user.setDisplayName(
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
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
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.DISPLAY_NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) DisplayName is {@code <a href=}.
   *   <li>Then return Attributes third Value is {@code &lt;a href=}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserDisplayNameIsAHref_thenReturnAttributesThirdValueIsLtAHref() {
    // Arrange
    User user = new User();
    user.setEmailAddress("42 Main St");
    user.setDisplayName("<a href=");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act and Assert
    List<Attribute> attributes = user.toEntity("Integration Name", "Entity Name").getAttributes();
    assertEquals(3, attributes.size());
    Attribute getResult = attributes.get(2);
    assertEquals("&lt;a href=", getResult.getValue());
    assertEquals("42 Main St", attributes.get(1).getValue());
    assertEquals(EntityConstants.DISPLAY_NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) DisplayName is {@code <a href=}.
   *   <li>Then return Attributes third Value is {@code &lt;a href=}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserDisplayNameIsAHref_thenReturnAttributesThirdValueIsLtAHref2() {
    // Arrange
    User user = new User();
    user.setDisplayName("<a href=");
    user.setEmailAddress("17 High St");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act and Assert
    List<Attribute> attributes = user.toEntity("Integration Name", "Entity Name").getAttributes();
    assertEquals(3, attributes.size());
    Attribute getResult = attributes.get(2);
    assertEquals("&lt;a href=", getResult.getValue());
    assertEquals("17 High St", attributes.get(1).getValue());
    assertEquals(EntityConstants.DISPLAY_NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) DisplayName is {@code <a href=}.
   *   <li>Then return Attributes third Value is {@code &lt;a href=}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserDisplayNameIsAHref_thenReturnAttributesThirdValueIsLtAHref3() {
    // Arrange
    User user = new User();
    user.setDisplayName("<a href=");
    user.setEmailAddress("11 Station Rd");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act and Assert
    List<Attribute> attributes = user.toEntity("Integration Name", "Entity Name").getAttributes();
    assertEquals(3, attributes.size());
    Attribute getResult = attributes.get(2);
    assertEquals("&lt;a href=", getResult.getValue());
    assertEquals("11 Station Rd", attributes.get(1).getValue());
    assertEquals(EntityConstants.DISPLAY_NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) DisplayName is {@code <br/> }.
   *   <li>Then return Attributes second Value is {@code &lt;br/&gt;}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
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
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.DISPLAY_NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) DisplayName is {@code <br/> }.
   *   <li>Then return Attributes third Value is {@code &lt;br/&gt;}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserDisplayNameIsBr_thenReturnAttributesThirdValueIsLtBrGt() {
    // Arrange
    User user = new User();
    user.setEmailAddress("42 Main St");
    user.setDisplayName("<br/>");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act and Assert
    List<Attribute> attributes = user.toEntity("Integration Name", "Entity Name").getAttributes();
    assertEquals(3, attributes.size());
    Attribute getResult = attributes.get(2);
    assertEquals("&lt;br/&gt;", getResult.getValue());
    assertEquals("42 Main St", attributes.get(1).getValue());
    assertEquals(EntityConstants.DISPLAY_NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) DisplayName is {@code <br/> }.
   *   <li>Then return Attributes third Value is {@code &lt;br/&gt;}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserDisplayNameIsBr_thenReturnAttributesThirdValueIsLtBrGt2() {
    // Arrange
    User user = new User();
    user.setDisplayName("<br/>");
    user.setEmailAddress("17 High St");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act and Assert
    List<Attribute> attributes = user.toEntity("Integration Name", "Entity Name").getAttributes();
    assertEquals(3, attributes.size());
    Attribute getResult = attributes.get(2);
    assertEquals("&lt;br/&gt;", getResult.getValue());
    assertEquals("17 High St", attributes.get(1).getValue());
    assertEquals(EntityConstants.DISPLAY_NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) DisplayName is {@code <br/> }.
   *   <li>Then return Attributes third Value is {@code &lt;br/&gt;}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserDisplayNameIsBr_thenReturnAttributesThirdValueIsLtBrGt3() {
    // Arrange
    User user = new User();
    user.setDisplayName("<br/>");
    user.setEmailAddress("11 Station Rd");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act and Assert
    List<Attribute> attributes = user.toEntity("Integration Name", "Entity Name").getAttributes();
    assertEquals(3, attributes.size());
    Attribute getResult = attributes.get(2);
    assertEquals("&lt;br/&gt;", getResult.getValue());
    assertEquals("11 Station Rd", attributes.get(1).getValue());
    assertEquals(EntityConstants.DISPLAY_NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) DisplayName is {@code -}.
   *   <li>Then return Attributes second Value is {@code -}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
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
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.DISPLAY_NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) DisplayName is {@code -}.
   *   <li>Then return Attributes third Value is {@code -}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserDisplayNameIsDash_thenReturnAttributesThirdValueIsDash() {
    // Arrange
    User user = new User();
    user.setEmailAddress("42 Main St");
    user.setDisplayName("-");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act and Assert
    List<Attribute> attributes = user.toEntity("Integration Name", "Entity Name").getAttributes();
    assertEquals(3, attributes.size());
    Attribute getResult = attributes.get(2);
    assertEquals("-", getResult.getValue());
    assertEquals("42 Main St", attributes.get(1).getValue());
    assertEquals(EntityConstants.DISPLAY_NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) DisplayName is {@code -}.
   *   <li>Then return Attributes third Value is {@code -}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserDisplayNameIsDash_thenReturnAttributesThirdValueIsDash2() {
    // Arrange
    User user = new User();
    user.setDisplayName("-");
    user.setEmailAddress("17 High St");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act and Assert
    List<Attribute> attributes = user.toEntity("Integration Name", "Entity Name").getAttributes();
    assertEquals(3, attributes.size());
    Attribute getResult = attributes.get(2);
    assertEquals("-", getResult.getValue());
    assertEquals("17 High St", attributes.get(1).getValue());
    assertEquals(EntityConstants.DISPLAY_NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) DisplayName is {@code -}.
   *   <li>Then return Attributes third Value is {@code -}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserDisplayNameIsDash_thenReturnAttributesThirdValueIsDash3() {
    // Arrange
    User user = new User();
    user.setDisplayName("-");
    user.setEmailAddress("11 Station Rd");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act and Assert
    List<Attribute> attributes = user.toEntity("Integration Name", "Entity Name").getAttributes();
    assertEquals(3, attributes.size());
    Attribute getResult = attributes.get(2);
    assertEquals("-", getResult.getValue());
    assertEquals("11 Station Rd", attributes.get(1).getValue());
    assertEquals(EntityConstants.DISPLAY_NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) DisplayName is empty string.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
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
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) DisplayName is empty string.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserDisplayNameIsEmptyString2() {
    // Arrange
    User user = new User();
    user.setEmailAddress("42 Main St");
    user.setDisplayName("");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals("42 Main St", getResult.getValue());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.EMAIL_ADDRESS_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) DisplayName is empty string.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserDisplayNameIsEmptyString3() {
    // Arrange
    User user = new User();
    user.setDisplayName("");
    user.setEmailAddress("17 High St");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals("17 High St", getResult.getValue());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.EMAIL_ADDRESS_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) DisplayName is empty string.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserDisplayNameIsEmptyString4() {
    // Arrange
    User user = new User();
    user.setDisplayName("");
    user.setEmailAddress("11 Station Rd");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals("11 Station Rd", getResult.getValue());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.EMAIL_ADDRESS_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) DisplayName is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
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
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) DisplayName is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserDisplayNameIsNull2() {
    // Arrange
    User user = new User();
    user.setEmailAddress("42 Main St");
    user.setDisplayName(null);
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals("42 Main St", getResult.getValue());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.EMAIL_ADDRESS_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) DisplayName is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserDisplayNameIsNull3() {
    // Arrange
    User user = new User();
    user.setDisplayName(null);
    user.setEmailAddress("17 High St");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals("17 High St", getResult.getValue());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.EMAIL_ADDRESS_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) DisplayName is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserDisplayNameIsNull4() {
    // Arrange
    User user = new User();
    user.setDisplayName(null);
    user.setEmailAddress("11 Station Rd");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals("11 Station Rd", getResult.getValue());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.EMAIL_ADDRESS_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) DisplayName is {@code />}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserDisplayNameIsSlashGreaterThanSign() {
    // Arrange
    User user = new User();
    user.setDisplayName("/>");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals("/&gt;", getResult.getValue());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.DISPLAY_NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) EmailAddress is {@code 1.0}.
   *   <li>Then return Attributes second Value is {@code 1.0}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
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
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.EMAIL_ADDRESS_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) EmailAddress is {@code 1.0}.
   *   <li>Then return Attributes second Value is {@code 1.0}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserEmailAddressIs10_thenReturnAttributesSecondValueIs102() {
    // Arrange
    User user = new User();
    user.setDisplayName("\n");
    user.setEmailAddress("1.0");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals("1.0", getResult.getValue());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.EMAIL_ADDRESS_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) EmailAddress is {@code 42}.
   *   <li>Then return Attributes second Value is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
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
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.EMAIL_ADDRESS_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) EmailAddress is {@code 42}.
   *   <li>Then return Attributes second Value is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserEmailAddressIs42_thenReturnAttributesSecondValueIs422() {
    // Arrange
    User user = new User();
    user.setDisplayName("\n");
    user.setEmailAddress("42");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals("42", getResult.getValue());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.EMAIL_ADDRESS_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) EmailAddress is {@code <a href=}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
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
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.EMAIL_ADDRESS_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) EmailAddress is {@code <a href=}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserEmailAddressIsAHref2() {
    // Arrange
    User user = new User();
    user.setDisplayName("\n");
    user.setEmailAddress("<a href=");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals("&lt;a href=", getResult.getValue());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.EMAIL_ADDRESS_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) EmailAddress is {@code < a href =
   *       "http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;" >xx</a>}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserEmailAddressIsAHrefHttpUuuuuuuuuuuuUuAmpAmpUuAmpAmpXxA() {
    // Arrange
    User user = new User();
    user.setEmailAddress(
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
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
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.EMAIL_ADDRESS_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) EmailAddress is {@code < a href =
   *       "http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;" >xx</a>}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserEmailAddressIsAHrefHttpUuuuuuuuuuuuUuAmpAmpUuAmpAmpXxA2() {
    // Arrange
    User user = new User();
    user.setDisplayName("\n");
    user.setEmailAddress(
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
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
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.EMAIL_ADDRESS_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) EmailAddress is {@code <br/> }.
   *   <li>Then return Attributes second Value is {@code &lt;br/&gt;}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
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
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.EMAIL_ADDRESS_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) EmailAddress is {@code <br/> }.
   *   <li>Then return Attributes second Value is {@code &lt;br/&gt;}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserEmailAddressIsBr_thenReturnAttributesSecondValueIsLtBrGt2() {
    // Arrange
    User user = new User();
    user.setDisplayName("\n");
    user.setEmailAddress("<br/>");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals("&lt;br/&gt;", getResult.getValue());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.EMAIL_ADDRESS_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) EmailAddress is {@code
   *       com.symphony.integration.%s.%s}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserEmailAddressIsComSymphonyIntegrationSS() {
    // Arrange
    User user = new User();
    user.setEmailAddress("com.symphony.integration.%s.%s");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals("com.symphony.integration.%s.%s", getResult.getValue());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.EMAIL_ADDRESS_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) EmailAddress is {@code
   *       com.symphony.integration.%s.%s}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserEmailAddressIsComSymphonyIntegrationSS2() {
    // Arrange
    User user = new User();
    user.setDisplayName("\n");
    user.setEmailAddress("com.symphony.integration.%s.%s");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals("com.symphony.integration.%s.%s", getResult.getValue());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.EMAIL_ADDRESS_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) EmailAddress is {@code -}.
   *   <li>Then return Attributes second Value is {@code -}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
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
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.EMAIL_ADDRESS_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) EmailAddress is {@code -}.
   *   <li>Then return Attributes second Value is {@code -}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserEmailAddressIsDash_thenReturnAttributesSecondValueIsDash2() {
    // Arrange
    User user = new User();
    user.setDisplayName("\n");
    user.setEmailAddress("-");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals("-", getResult.getValue());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.EMAIL_ADDRESS_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) EmailAddress is empty string.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
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
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) EmailAddress is empty string.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserEmailAddressIsEmptyString2() {
    // Arrange
    User user = new User();
    user.setDisplayName("\n");
    user.setEmailAddress("");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) EmailAddress is lf.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
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
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) EmailAddress is lf.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserEmailAddressIsLf2() {
    // Arrange
    User user = new User();
    user.setDisplayName("\n");
    user.setEmailAddress("\n");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) EmailAddress is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
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
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) EmailAddress is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserEmailAddressIsNull2() {
    // Arrange
    User user = new User();
    user.setDisplayName("\n");
    user.setEmailAddress(null);
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) EmailAddress is {@code />}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserEmailAddressIsSlashGreaterThanSign() {
    // Arrange
    User user = new User();
    user.setEmailAddress("/>");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals("/&gt;", getResult.getValue());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.EMAIL_ADDRESS_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) EmailAddress is {@code />}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserEmailAddressIsSlashGreaterThanSign2() {
    // Arrange
    User user = new User();
    user.setDisplayName("\n");
    user.setEmailAddress("/>");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals("/&gt;", getResult.getValue());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.EMAIL_ADDRESS_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) EmailAddress is {@link
   *       EntityConstants#USER_ENTITY_FIELD}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserEmailAddressIsUser_entity_field() {
    // Arrange
    User user = new User();
    user.setEmailAddress(EntityConstants.USER_ENTITY_FIELD);
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    Attribute getResult = attributes.get(1);
    assertEquals(EntityConstants.EMAIL_ADDRESS_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ENTITY_FIELD, getResult.getValue());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) EmailAddress is {@link
   *       EntityConstants#USER_ENTITY_FIELD}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserEmailAddressIsUser_entity_field2() {
    // Arrange
    User user = new User();
    user.setDisplayName("\n");
    user.setEmailAddress(EntityConstants.USER_ENTITY_FIELD);
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    Attribute getResult = attributes.get(1);
    assertEquals(EntityConstants.EMAIL_ADDRESS_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ENTITY_FIELD, getResult.getValue());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) EmailAddress is {@link
   *       EntityConstants#USERNAME_ENTITY_FIELD}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserEmailAddressIsUsername_entity_field() {
    // Arrange
    User user = new User();
    user.setEmailAddress(EntityConstants.USERNAME_ENTITY_FIELD);
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    Attribute getResult = attributes.get(1);
    assertEquals(EntityConstants.EMAIL_ADDRESS_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getValue());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) EmailAddress is {@link
   *       EntityConstants#USERNAME_ENTITY_FIELD}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserEmailAddressIsUsername_entity_field2() {
    // Arrange
    User user = new User();
    user.setDisplayName("\n");
    user.setEmailAddress(EntityConstants.USERNAME_ENTITY_FIELD);
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    Attribute getResult = attributes.get(1);
    assertEquals(EntityConstants.EMAIL_ADDRESS_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getValue());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is eight.
   *   <li>Then return Entities first Attributes first Value is {@code 8}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserIdIsEight_thenReturnEntitiesFirstAttributesFirstValueIs8() {
    // Arrange
    User user = new User();
    user.setId(8L);
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act and Assert
    List<Entity> entities = user.toEntity("Integration Name", "Entity Name").getEntities();
    assertEquals(1, entities.size());
    Entity getResult = entities.get(0);
    List<Attribute> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult2 = attributes.get(0);
    assertEquals("8", getResult2.getValue());
    assertNull(getResult.getName());
    assertNull(getResult.getPresentationML());
    assertTrue(getResult.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, getResult.getType());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is eight.
   *   <li>Then return Entities first Attributes first Value is {@code 8}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserIdIsEight_thenReturnEntitiesFirstAttributesFirstValueIs82() {
    // Arrange
    User user = new User();
    user.setEmailAddress("42 Main St");
    user.setId(8L);
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    assertEquals("42 Main St", attributes.get(1).getValue());
    List<Entity> entities = actualToEntityResult.getEntities();
    assertEquals(1, entities.size());
    Entity getResult = entities.get(0);
    List<Attribute> attributes2 = getResult.getAttributes();
    assertEquals(1, attributes2.size());
    Attribute getResult2 = attributes2.get(0);
    assertEquals("8", getResult2.getValue());
    assertNull(getResult.getName());
    assertNull(getResult.getPresentationML());
    assertTrue(getResult.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, getResult.getType());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is eight.
   *   <li>Then return Entities first Attributes first Value is {@code 8}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserIdIsEight_thenReturnEntitiesFirstAttributesFirstValueIs83() {
    // Arrange
    User user = new User();
    user.setDisplayName("\n");
    user.setId(8L);
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act and Assert
    List<Entity> entities = user.toEntity("Integration Name", "Entity Name").getEntities();
    assertEquals(1, entities.size());
    Entity getResult = entities.get(0);
    List<Attribute> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult2 = attributes.get(0);
    assertEquals("8", getResult2.getValue());
    assertNull(getResult.getName());
    assertNull(getResult.getPresentationML());
    assertTrue(getResult.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, getResult.getType());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is five.
   *   <li>Then return Entities first Attributes first Value is {@code 5}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserIdIsFive_thenReturnEntitiesFirstAttributesFirstValueIs5() {
    // Arrange
    User user = new User();
    user.setId(5L);
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act and Assert
    List<Entity> entities = user.toEntity("Integration Name", "Entity Name").getEntities();
    assertEquals(1, entities.size());
    Entity getResult = entities.get(0);
    List<Attribute> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult2 = attributes.get(0);
    assertEquals("5", getResult2.getValue());
    assertNull(getResult.getName());
    assertNull(getResult.getPresentationML());
    assertTrue(getResult.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, getResult.getType());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is five.
   *   <li>Then return Entities first Attributes first Value is {@code 5}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserIdIsFive_thenReturnEntitiesFirstAttributesFirstValueIs52() {
    // Arrange
    User user = new User();
    user.setEmailAddress("42 Main St");
    user.setId(5L);
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    assertEquals("42 Main St", attributes.get(1).getValue());
    List<Entity> entities = actualToEntityResult.getEntities();
    assertEquals(1, entities.size());
    Entity getResult = entities.get(0);
    List<Attribute> attributes2 = getResult.getAttributes();
    assertEquals(1, attributes2.size());
    Attribute getResult2 = attributes2.get(0);
    assertEquals("5", getResult2.getValue());
    assertNull(getResult.getName());
    assertNull(getResult.getPresentationML());
    assertTrue(getResult.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, getResult.getType());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is five.
   *   <li>Then return Entities first Attributes first Value is {@code 5}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserIdIsFive_thenReturnEntitiesFirstAttributesFirstValueIs53() {
    // Arrange
    User user = new User();
    user.setDisplayName("\n");
    user.setId(5L);
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act and Assert
    List<Entity> entities = user.toEntity("Integration Name", "Entity Name").getEntities();
    assertEquals(1, entities.size());
    Entity getResult = entities.get(0);
    List<Attribute> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult2 = attributes.get(0);
    assertEquals("5", getResult2.getValue());
    assertNull(getResult.getName());
    assertNull(getResult.getPresentationML());
    assertTrue(getResult.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, getResult.getType());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is four.
   *   <li>Then return Entities first Attributes first Value is {@code 4}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserIdIsFour_thenReturnEntitiesFirstAttributesFirstValueIs4() {
    // Arrange
    User user = new User();
    user.setId(4L);
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act and Assert
    List<Entity> entities = user.toEntity("Integration Name", "Entity Name").getEntities();
    assertEquals(1, entities.size());
    Entity getResult = entities.get(0);
    List<Attribute> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult2 = attributes.get(0);
    assertEquals("4", getResult2.getValue());
    assertNull(getResult.getName());
    assertNull(getResult.getPresentationML());
    assertTrue(getResult.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, getResult.getType());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is four.
   *   <li>Then return Entities first Attributes first Value is {@code 4}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserIdIsFour_thenReturnEntitiesFirstAttributesFirstValueIs42() {
    // Arrange
    User user = new User();
    user.setEmailAddress("42 Main St");
    user.setId(4L);
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "Entity Name");

    // Assert
    List<Entity> entities = actualToEntityResult.getEntities();
    assertEquals(1, entities.size());
    Entity getResult = entities.get(0);
    List<Attribute> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult2 = attributes.get(0);
    assertEquals("4", getResult2.getValue());
    List<Attribute> attributes2 = actualToEntityResult.getAttributes();
    assertEquals(2, attributes2.size());
    assertEquals("42 Main St", attributes2.get(1).getValue());
    assertNull(getResult.getName());
    assertNull(getResult.getPresentationML());
    assertTrue(getResult.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, getResult.getType());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is four.
   *   <li>Then return Entities first Attributes first Value is {@code 4}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserIdIsFour_thenReturnEntitiesFirstAttributesFirstValueIs43() {
    // Arrange
    User user = new User();
    user.setDisplayName("\n");
    user.setId(4L);
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act and Assert
    List<Entity> entities = user.toEntity("Integration Name", "Entity Name").getEntities();
    assertEquals(1, entities.size());
    Entity getResult = entities.get(0);
    List<Attribute> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult2 = attributes.get(0);
    assertEquals("4", getResult2.getValue());
    assertNull(getResult.getName());
    assertNull(getResult.getPresentationML());
    assertTrue(getResult.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, getResult.getType());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is nine.
   *   <li>Then return Entities first Attributes first Value is {@code 9}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserIdIsNine_thenReturnEntitiesFirstAttributesFirstValueIs9() {
    // Arrange
    User user = new User();
    user.setId(9L);
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act and Assert
    List<Entity> entities = user.toEntity("Integration Name", "Entity Name").getEntities();
    assertEquals(1, entities.size());
    Entity getResult = entities.get(0);
    List<Attribute> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult2 = attributes.get(0);
    assertEquals("9", getResult2.getValue());
    assertNull(getResult.getName());
    assertNull(getResult.getPresentationML());
    assertTrue(getResult.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, getResult.getType());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is nine.
   *   <li>Then return Entities first Attributes first Value is {@code 9}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserIdIsNine_thenReturnEntitiesFirstAttributesFirstValueIs92() {
    // Arrange
    User user = new User();
    user.setEmailAddress("42 Main St");
    user.setId(9L);
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    assertEquals("42 Main St", attributes.get(1).getValue());
    List<Entity> entities = actualToEntityResult.getEntities();
    assertEquals(1, entities.size());
    Entity getResult = entities.get(0);
    List<Attribute> attributes2 = getResult.getAttributes();
    assertEquals(1, attributes2.size());
    Attribute getResult2 = attributes2.get(0);
    assertEquals("9", getResult2.getValue());
    assertNull(getResult.getName());
    assertNull(getResult.getPresentationML());
    assertTrue(getResult.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, getResult.getType());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is nine.
   *   <li>Then return Entities first Attributes first Value is {@code 9}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserIdIsNine_thenReturnEntitiesFirstAttributesFirstValueIs93() {
    // Arrange
    User user = new User();
    user.setDisplayName("\n");
    user.setId(9L);
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act and Assert
    List<Entity> entities = user.toEntity("Integration Name", "Entity Name").getEntities();
    assertEquals(1, entities.size());
    Entity getResult = entities.get(0);
    List<Attribute> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult2 = attributes.get(0);
    assertEquals("9", getResult2.getValue());
    assertNull(getResult.getName());
    assertNull(getResult.getPresentationML());
    assertTrue(getResult.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, getResult.getType());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserIdIsNull() {
    // Arrange
    User user = new User();
    user.setId(null);
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserIdIsNull2() {
    // Arrange
    User user = new User();
    user.setDisplayName("\n");
    user.setId(null);
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is {@code null}.
   *   <li>Then return Attributes second Value is {@code 42 Main St}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserIdIsNull_thenReturnAttributesSecondValueIs42MainSt() {
    // Arrange
    User user = new User();
    user.setEmailAddress("42 Main St");
    user.setId(null);
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals("42 Main St", getResult.getValue());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.EMAIL_ADDRESS_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is one.
   *   <li>Then return Entities first Attributes first Value is {@code 1}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserIdIsOne_thenReturnEntitiesFirstAttributesFirstValueIs1() {
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
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is one.
   *   <li>Then return Entities first Attributes first Value is {@code 1}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserIdIsOne_thenReturnEntitiesFirstAttributesFirstValueIs12() {
    // Arrange
    User user = new User();
    user.setId(1L);
    user.setEmailAddress("17 High St");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "Entity Name");

    // Assert
    List<Entity> entities = actualToEntityResult.getEntities();
    assertEquals(1, entities.size());
    Entity getResult = entities.get(0);
    List<Attribute> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult2 = attributes.get(0);
    assertEquals("1", getResult2.getValue());
    List<Attribute> attributes2 = actualToEntityResult.getAttributes();
    assertEquals(2, attributes2.size());
    assertEquals("17 High St", attributes2.get(1).getValue());
    assertNull(getResult.getName());
    assertNull(getResult.getPresentationML());
    assertTrue(getResult.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, getResult.getType());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is one.
   *   <li>Then return Entities first Attributes first Value is {@code 1}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserIdIsOne_thenReturnEntitiesFirstAttributesFirstValueIs13() {
    // Arrange
    User user = new User();
    user.setId(1L);
    user.setEmailAddress("11 Station Rd");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "Entity Name");

    // Assert
    List<Entity> entities = actualToEntityResult.getEntities();
    assertEquals(1, entities.size());
    Entity getResult = entities.get(0);
    List<Attribute> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult2 = attributes.get(0);
    assertEquals("1", getResult2.getValue());
    List<Attribute> attributes2 = actualToEntityResult.getAttributes();
    assertEquals(2, attributes2.size());
    assertEquals("11 Station Rd", attributes2.get(1).getValue());
    assertNull(getResult.getName());
    assertNull(getResult.getPresentationML());
    assertTrue(getResult.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, getResult.getType());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is one.
   *   <li>When {@code Integration Name}.
   *   <li>Then return Attributes Empty.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserIdIsOne_whenIntegrationName_thenReturnAttributesEmpty() {
    // Arrange
    User user = new User();
    user.setId(1L);

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "Entity Name");

    // Assert
    List<Entity> entities = actualToEntityResult.getEntities();
    assertEquals(1, entities.size());
    Entity getResult = entities.get(0);
    List<Attribute> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult2 = attributes.get(0);
    assertEquals("1", getResult2.getValue());
    assertNull(getResult.getName());
    assertNull(getResult.getPresentationML());
    assertTrue(actualToEntityResult.getAttributes().isEmpty());
    assertTrue(getResult.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, getResult.getType());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is seven.
   *   <li>Then return Entities first Attributes first Value is {@code 7}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserIdIsSeven_thenReturnEntitiesFirstAttributesFirstValueIs7() {
    // Arrange
    User user = new User();
    user.setId(7L);
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act and Assert
    List<Entity> entities = user.toEntity("Integration Name", "Entity Name").getEntities();
    assertEquals(1, entities.size());
    Entity getResult = entities.get(0);
    List<Attribute> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult2 = attributes.get(0);
    assertEquals("7", getResult2.getValue());
    assertNull(getResult.getName());
    assertNull(getResult.getPresentationML());
    assertTrue(getResult.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, getResult.getType());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is seven.
   *   <li>Then return Entities first Attributes first Value is {@code 7}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserIdIsSeven_thenReturnEntitiesFirstAttributesFirstValueIs72() {
    // Arrange
    User user = new User();
    user.setEmailAddress("42 Main St");
    user.setId(7L);
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    assertEquals("42 Main St", attributes.get(1).getValue());
    List<Entity> entities = actualToEntityResult.getEntities();
    assertEquals(1, entities.size());
    Entity getResult = entities.get(0);
    List<Attribute> attributes2 = getResult.getAttributes();
    assertEquals(1, attributes2.size());
    Attribute getResult2 = attributes2.get(0);
    assertEquals("7", getResult2.getValue());
    assertNull(getResult.getName());
    assertNull(getResult.getPresentationML());
    assertTrue(getResult.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, getResult.getType());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is seven.
   *   <li>Then return Entities first Attributes first Value is {@code 7}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserIdIsSeven_thenReturnEntitiesFirstAttributesFirstValueIs73() {
    // Arrange
    User user = new User();
    user.setDisplayName("\n");
    user.setId(7L);
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act and Assert
    List<Entity> entities = user.toEntity("Integration Name", "Entity Name").getEntities();
    assertEquals(1, entities.size());
    Entity getResult = entities.get(0);
    List<Attribute> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult2 = attributes.get(0);
    assertEquals("7", getResult2.getValue());
    assertNull(getResult.getName());
    assertNull(getResult.getPresentationML());
    assertTrue(getResult.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, getResult.getType());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is six.
   *   <li>Then return Entities first Attributes first Value is {@code 6}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserIdIsSix_thenReturnEntitiesFirstAttributesFirstValueIs6() {
    // Arrange
    User user = new User();
    user.setId(6L);
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act and Assert
    List<Entity> entities = user.toEntity("Integration Name", "Entity Name").getEntities();
    assertEquals(1, entities.size());
    Entity getResult = entities.get(0);
    List<Attribute> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult2 = attributes.get(0);
    assertEquals("6", getResult2.getValue());
    assertNull(getResult.getName());
    assertNull(getResult.getPresentationML());
    assertTrue(getResult.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, getResult.getType());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is six.
   *   <li>Then return Entities first Attributes first Value is {@code 6}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserIdIsSix_thenReturnEntitiesFirstAttributesFirstValueIs62() {
    // Arrange
    User user = new User();
    user.setEmailAddress("42 Main St");
    user.setId(6L);
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    assertEquals("42 Main St", attributes.get(1).getValue());
    List<Entity> entities = actualToEntityResult.getEntities();
    assertEquals(1, entities.size());
    Entity getResult = entities.get(0);
    List<Attribute> attributes2 = getResult.getAttributes();
    assertEquals(1, attributes2.size());
    Attribute getResult2 = attributes2.get(0);
    assertEquals("6", getResult2.getValue());
    assertNull(getResult.getName());
    assertNull(getResult.getPresentationML());
    assertTrue(getResult.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, getResult.getType());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is six.
   *   <li>Then return Entities first Attributes first Value is {@code 6}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserIdIsSix_thenReturnEntitiesFirstAttributesFirstValueIs63() {
    // Arrange
    User user = new User();
    user.setDisplayName("\n");
    user.setId(6L);
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act and Assert
    List<Entity> entities = user.toEntity("Integration Name", "Entity Name").getEntities();
    assertEquals(1, entities.size());
    Entity getResult = entities.get(0);
    List<Attribute> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult2 = attributes.get(0);
    assertEquals("6", getResult2.getValue());
    assertNull(getResult.getName());
    assertNull(getResult.getPresentationML());
    assertTrue(getResult.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, getResult.getType());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is ten.
   *   <li>Then return Entities first Attributes first Value is {@code 10}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserIdIsTen_thenReturnEntitiesFirstAttributesFirstValueIs10() {
    // Arrange
    User user = new User();
    user.setId(10L);
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act and Assert
    List<Entity> entities = user.toEntity("Integration Name", "Entity Name").getEntities();
    assertEquals(1, entities.size());
    Entity getResult = entities.get(0);
    List<Attribute> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult2 = attributes.get(0);
    assertEquals("10", getResult2.getValue());
    assertNull(getResult.getName());
    assertNull(getResult.getPresentationML());
    assertTrue(getResult.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, getResult.getType());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is ten.
   *   <li>Then return Entities first Attributes first Value is {@code 10}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserIdIsTen_thenReturnEntitiesFirstAttributesFirstValueIs102() {
    // Arrange
    User user = new User();
    user.setEmailAddress("42 Main St");
    user.setId(10L);
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "Entity Name");

    // Assert
    List<Entity> entities = actualToEntityResult.getEntities();
    assertEquals(1, entities.size());
    Entity getResult = entities.get(0);
    List<Attribute> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult2 = attributes.get(0);
    assertEquals("10", getResult2.getValue());
    List<Attribute> attributes2 = actualToEntityResult.getAttributes();
    assertEquals(2, attributes2.size());
    assertEquals("42 Main St", attributes2.get(1).getValue());
    assertNull(getResult.getName());
    assertNull(getResult.getPresentationML());
    assertTrue(getResult.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, getResult.getType());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is ten.
   *   <li>Then return Entities first Attributes first Value is {@code 10}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserIdIsTen_thenReturnEntitiesFirstAttributesFirstValueIs103() {
    // Arrange
    User user = new User();
    user.setDisplayName("\n");
    user.setId(10L);
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act and Assert
    List<Entity> entities = user.toEntity("Integration Name", "Entity Name").getEntities();
    assertEquals(1, entities.size());
    Entity getResult = entities.get(0);
    List<Attribute> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult2 = attributes.get(0);
    assertEquals("10", getResult2.getValue());
    assertNull(getResult.getName());
    assertNull(getResult.getPresentationML());
    assertTrue(getResult.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, getResult.getType());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is three.
   *   <li>Then return Entities first Attributes first Value is {@code 3}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserIdIsThree_thenReturnEntitiesFirstAttributesFirstValueIs3() {
    // Arrange
    User user = new User();
    user.setId(3L);
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act and Assert
    List<Entity> entities = user.toEntity("Integration Name", "Entity Name").getEntities();
    assertEquals(1, entities.size());
    Entity getResult = entities.get(0);
    List<Attribute> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult2 = attributes.get(0);
    assertEquals("3", getResult2.getValue());
    assertNull(getResult.getName());
    assertNull(getResult.getPresentationML());
    assertTrue(getResult.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, getResult.getType());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is three.
   *   <li>Then return Entities first Attributes first Value is {@code 3}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserIdIsThree_thenReturnEntitiesFirstAttributesFirstValueIs32() {
    // Arrange
    User user = new User();
    user.setEmailAddress("42 Main St");
    user.setId(3L);
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "Entity Name");

    // Assert
    List<Entity> entities = actualToEntityResult.getEntities();
    assertEquals(1, entities.size());
    Entity getResult = entities.get(0);
    List<Attribute> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult2 = attributes.get(0);
    assertEquals("3", getResult2.getValue());
    List<Attribute> attributes2 = actualToEntityResult.getAttributes();
    assertEquals(2, attributes2.size());
    assertEquals("42 Main St", attributes2.get(1).getValue());
    assertNull(getResult.getName());
    assertNull(getResult.getPresentationML());
    assertTrue(getResult.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, getResult.getType());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is three.
   *   <li>Then return Entities first Attributes first Value is {@code 3}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserIdIsThree_thenReturnEntitiesFirstAttributesFirstValueIs33() {
    // Arrange
    User user = new User();
    user.setDisplayName("\n");
    user.setId(3L);
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act and Assert
    List<Entity> entities = user.toEntity("Integration Name", "Entity Name").getEntities();
    assertEquals(1, entities.size());
    Entity getResult = entities.get(0);
    List<Attribute> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult2 = attributes.get(0);
    assertEquals("3", getResult2.getValue());
    assertNull(getResult.getName());
    assertNull(getResult.getPresentationML());
    assertTrue(getResult.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, getResult.getType());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is two.
   *   <li>Then return Entities first Attributes first Value is {@code 2}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserIdIsTwo_thenReturnEntitiesFirstAttributesFirstValueIs2() {
    // Arrange
    User user = new User();
    user.setId(2L);
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act and Assert
    List<Entity> entities = user.toEntity("Integration Name", "Entity Name").getEntities();
    assertEquals(1, entities.size());
    Entity getResult = entities.get(0);
    List<Attribute> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult2 = attributes.get(0);
    assertEquals("2", getResult2.getValue());
    assertNull(getResult.getName());
    assertNull(getResult.getPresentationML());
    assertTrue(getResult.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, getResult.getType());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is two.
   *   <li>Then return Entities first Attributes first Value is {@code 2}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserIdIsTwo_thenReturnEntitiesFirstAttributesFirstValueIs22() {
    // Arrange
    User user = new User();
    user.setEmailAddress("42 Main St");
    user.setId(2L);
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "Entity Name");

    // Assert
    List<Entity> entities = actualToEntityResult.getEntities();
    assertEquals(1, entities.size());
    Entity getResult = entities.get(0);
    List<Attribute> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult2 = attributes.get(0);
    assertEquals("2", getResult2.getValue());
    List<Attribute> attributes2 = actualToEntityResult.getAttributes();
    assertEquals(2, attributes2.size());
    assertEquals("42 Main St", attributes2.get(1).getValue());
    assertNull(getResult.getName());
    assertNull(getResult.getPresentationML());
    assertTrue(getResult.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, getResult.getType());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is two.
   *   <li>Then return Entities first Attributes first Value is {@code 2}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserIdIsTwo_thenReturnEntitiesFirstAttributesFirstValueIs23() {
    // Arrange
    User user = new User();
    user.setDisplayName("\n");
    user.setId(2L);
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act and Assert
    List<Entity> entities = user.toEntity("Integration Name", "Entity Name").getEntities();
    assertEquals(1, entities.size());
    Entity getResult = entities.get(0);
    List<Attribute> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult2 = attributes.get(0);
    assertEquals("2", getResult2.getValue());
    assertNull(getResult.getName());
    assertNull(getResult.getPresentationML());
    assertTrue(getResult.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, getResult.getType());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is zero.
   *   <li>Then return Entities first Attributes first Value is {@code 0}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserIdIsZero_thenReturnEntitiesFirstAttributesFirstValueIs0() {
    // Arrange
    User user = new User();
    user.setId(0L);
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act and Assert
    List<Entity> entities = user.toEntity("Integration Name", "Entity Name").getEntities();
    assertEquals(1, entities.size());
    Entity getResult = entities.get(0);
    List<Attribute> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult2 = attributes.get(0);
    assertEquals("0", getResult2.getValue());
    assertNull(getResult.getName());
    assertNull(getResult.getPresentationML());
    assertTrue(getResult.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, getResult.getType());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is zero.
   *   <li>Then return Entities first Attributes first Value is {@code 0}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserIdIsZero_thenReturnEntitiesFirstAttributesFirstValueIs02() {
    // Arrange
    User user = new User();
    user.setEmailAddress("42 Main St");
    user.setId(0L);
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "Entity Name");

    // Assert
    List<Entity> entities = actualToEntityResult.getEntities();
    assertEquals(1, entities.size());
    Entity getResult = entities.get(0);
    List<Attribute> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult2 = attributes.get(0);
    assertEquals("0", getResult2.getValue());
    List<Attribute> attributes2 = actualToEntityResult.getAttributes();
    assertEquals(2, attributes2.size());
    assertEquals("42 Main St", attributes2.get(1).getValue());
    assertNull(getResult.getName());
    assertNull(getResult.getPresentationML());
    assertTrue(getResult.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, getResult.getType());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is zero.
   *   <li>Then return Entities first Attributes first Value is {@code 0}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserIdIsZero_thenReturnEntitiesFirstAttributesFirstValueIs03() {
    // Arrange
    User user = new User();
    user.setDisplayName("\n");
    user.setId(0L);
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act and Assert
    List<Entity> entities = user.toEntity("Integration Name", "Entity Name").getEntities();
    assertEquals(1, entities.size());
    Entity getResult = entities.get(0);
    List<Attribute> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult2 = attributes.get(0);
    assertEquals("0", getResult2.getValue());
    assertNull(getResult.getName());
    assertNull(getResult.getPresentationML());
    assertTrue(getResult.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, getResult.getType());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) UserName is {@code 1.0}.
   *   <li>Then return Attributes first Value is {@code 1.0}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserUserNameIs10_thenReturnAttributesFirstValueIs10() {
    // Arrange
    User user = new User();
    user.setEmailAddress(
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setUserName("1.0");

    // Act and Assert
    List<Attribute> attributes = user.toEntity("Integration Name", "Entity Name").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("1.0", attributes.get(0).getValue());
    assertEquals(EntityConstants.EMAIL_ADDRESS_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) UserName is {@code 1.0}.
   *   <li>Then return Attributes first Value is {@code 1.0}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserUserNameIs10_thenReturnAttributesFirstValueIs102() {
    // Arrange
    User user = new User();
    user.setDisplayName(
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setUserName("1.0");

    // Act and Assert
    List<Attribute> attributes = user.toEntity("Integration Name", "Entity Name").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("1.0", attributes.get(0).getValue());
    assertEquals(EntityConstants.DISPLAY_NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) UserName is {@code 42}.
   *   <li>Then return Attributes first Value is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserUserNameIs42_thenReturnAttributesFirstValueIs42() {
    // Arrange
    User user = new User();
    user.setEmailAddress(
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setUserName("42");

    // Act and Assert
    List<Attribute> attributes = user.toEntity("Integration Name", "Entity Name").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("42", attributes.get(0).getValue());
    assertEquals(EntityConstants.EMAIL_ADDRESS_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) UserName is {@code 42}.
   *   <li>Then return Attributes first Value is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserUserNameIs42_thenReturnAttributesFirstValueIs422() {
    // Arrange
    User user = new User();
    user.setDisplayName(
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setUserName("42");

    // Act and Assert
    List<Attribute> attributes = user.toEntity("Integration Name", "Entity Name").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("42", attributes.get(0).getValue());
    assertEquals(EntityConstants.DISPLAY_NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) UserName is {@code <a href=}.
   *   <li>Then return Attributes first Value is {@code &lt;a href=}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserUserNameIsAHref_thenReturnAttributesFirstValueIsLtAHref() {
    // Arrange
    User user = new User();
    user.setEmailAddress(
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setUserName("<a href=");

    // Act and Assert
    List<Attribute> attributes = user.toEntity("Integration Name", "Entity Name").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("&lt;a href=", attributes.get(0).getValue());
    assertEquals(EntityConstants.EMAIL_ADDRESS_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) UserName is {@code <a href=}.
   *   <li>Then return Attributes first Value is {@code &lt;a href=}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserUserNameIsAHref_thenReturnAttributesFirstValueIsLtAHref2() {
    // Arrange
    User user = new User();
    user.setDisplayName(
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setUserName("<a href=");

    // Act and Assert
    List<Attribute> attributes = user.toEntity("Integration Name", "Entity Name").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("&lt;a href=", attributes.get(0).getValue());
    assertEquals(EntityConstants.DISPLAY_NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) UserName is {@code <br/> }.
   *   <li>Then return Attributes first Value is {@code &lt;br/&gt;}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserUserNameIsBr_thenReturnAttributesFirstValueIsLtBrGt() {
    // Arrange
    User user = new User();
    user.setEmailAddress(
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setUserName("<br/>");

    // Act and Assert
    List<Attribute> attributes = user.toEntity("Integration Name", "Entity Name").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("&lt;br/&gt;", attributes.get(0).getValue());
    assertEquals(EntityConstants.EMAIL_ADDRESS_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) UserName is {@code <br/> }.
   *   <li>Then return Attributes first Value is {@code &lt;br/&gt;}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserUserNameIsBr_thenReturnAttributesFirstValueIsLtBrGt2() {
    // Arrange
    User user = new User();
    user.setDisplayName(
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setUserName("<br/>");

    // Act and Assert
    List<Attribute> attributes = user.toEntity("Integration Name", "Entity Name").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("&lt;br/&gt;", attributes.get(0).getValue());
    assertEquals(EntityConstants.DISPLAY_NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) UserName is {@code -}.
   *   <li>Then return Attributes first Value is {@code -}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserUserNameIsDash_thenReturnAttributesFirstValueIsDash() {
    // Arrange
    User user = new User();
    user.setEmailAddress(
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setUserName("-");

    // Act and Assert
    List<Attribute> attributes = user.toEntity("Integration Name", "Entity Name").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("-", attributes.get(0).getValue());
    assertEquals(EntityConstants.EMAIL_ADDRESS_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) UserName is {@code -}.
   *   <li>Then return Attributes first Value is {@code -}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserUserNameIsDash_thenReturnAttributesFirstValueIsDash2() {
    // Arrange
    User user = new User();
    user.setDisplayName(
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setUserName("-");

    // Act and Assert
    List<Attribute> attributes = user.toEntity("Integration Name", "Entity Name").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("-", attributes.get(0).getValue());
    assertEquals(EntityConstants.DISPLAY_NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) UserName is empty string.
   *   <li>Then return Name is {@code Entity Name}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserUserNameIsEmptyString_thenReturnNameIsEntityName() {
    // Arrange
    User user = new User();
    user.setUserName("");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "Entity Name");

    // Assert
    assertEquals("Entity Name", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.Integration Name.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getAttributes().isEmpty());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) UserName is {@code janedoe}.
   *   <li>Then return Attributes first Value is {@code janedoe}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserUserNameIsJanedoe_thenReturnAttributesFirstValueIsJanedoe() {
    // Arrange
    User user = new User();
    user.setUserName("janedoe");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals("janedoe", getResult.getValue());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) UserName is {@code janedoe}.
   *   <li>Then return Attributes first Value is {@code janedoe}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserUserNameIsJanedoe_thenReturnAttributesFirstValueIsJanedoe2() {
    // Arrange
    User user = new User();
    user.setEmailAddress(
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setUserName("janedoe");

    // Act and Assert
    List<Attribute> attributes = user.toEntity("Integration Name", "Entity Name").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("janedoe", attributes.get(0).getValue());
    assertEquals(EntityConstants.EMAIL_ADDRESS_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) UserName is {@code janedoe}.
   *   <li>Then return Attributes first Value is {@code janedoe}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserUserNameIsJanedoe_thenReturnAttributesFirstValueIsJanedoe3() {
    // Arrange
    User user = new User();
    user.setDisplayName(
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setUserName("janedoe");

    // Act and Assert
    List<Attribute> attributes = user.toEntity("Integration Name", "Entity Name").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("janedoe", attributes.get(0).getValue());
    assertEquals(EntityConstants.DISPLAY_NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) UserName is lf.
   *   <li>Then return Name is {@code Entity Name}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserUserNameIsLf_thenReturnNameIsEntityName() {
    // Arrange
    User user = new User();
    user.setUserName("\n");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "Entity Name");

    // Assert
    assertEquals("Entity Name", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.Integration Name.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getAttributes().isEmpty());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) UserName is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserUserNameIsNull() {
    // Arrange
    User user = new User();
    user.setEmailAddress(
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setUserName(null);

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.EMAIL_ADDRESS_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) UserName is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUserUserNameIsNull2() {
    // Arrange
    User user = new User();
    user.setDisplayName(
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setUserName(null);

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.DISPLAY_NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Given {@link User} (default constructor).
   *   <li>When {@code Integration Name}.
   *   <li>Then return Name is {@code Entity Name}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_givenUser_whenIntegrationName_thenReturnNameIsEntityName() {
    // Arrange and Act
    Entity actualToEntityResult = new User().toEntity("Integration Name", "Entity Name");

    // Assert
    assertEquals("Entity Name", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.Integration Name.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getAttributes().isEmpty());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Then return Attributes first Name is {@link EntityConstants#DISPLAY_NAME_ENTITY_FIELD}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_thenReturnAttributesFirstNameIsDisplay_name_entity_field() {
    // Arrange
    User user = new User();
    user.setDisplayName(
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setUserName("\n");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.DISPLAY_NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Then return Attributes first Name is {@link EntityConstants#DISPLAY_NAME_ENTITY_FIELD}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_thenReturnAttributesFirstNameIsDisplay_name_entity_field2() {
    // Arrange
    User user = new User();
    user.setDisplayName(
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setUserName("");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.DISPLAY_NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Then return Attributes first Name is {@link EntityConstants#EMAIL_ADDRESS_ENTITY_FIELD}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_thenReturnAttributesFirstNameIsEmail_address_entity_field() {
    // Arrange
    User user = new User();
    user.setEmailAddress(
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setUserName("\n");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.EMAIL_ADDRESS_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Then return Attributes first Name is {@link EntityConstants#EMAIL_ADDRESS_ENTITY_FIELD}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_thenReturnAttributesFirstNameIsEmail_address_entity_field2() {
    // Arrange
    User user = new User();
    user.setEmailAddress(
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setUserName("");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.EMAIL_ADDRESS_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Then return Attributes first Name is {@link EntityConstants#USERNAME_ENTITY_FIELD}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_thenReturnAttributesFirstNameIsUsername_entity_field() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Then return Attributes first Name is {@link EntityConstants#USERNAME_ENTITY_FIELD}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_thenReturnAttributesFirstNameIsUsername_entity_field2() {
    // Arrange
    User user = new User();
    user.setDisplayName("\n");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Then return Attributes first Value is {@code com.symphony.integration.%s.%s}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_thenReturnAttributesFirstValueIsComSymphonyIntegrationSS() {
    // Arrange
    User user = new User();
    user.setEmailAddress(
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setUserName("com.symphony.integration.%s.%s");

    // Act and Assert
    List<Attribute> attributes = user.toEntity("Integration Name", "Entity Name").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("com.symphony.integration.%s.%s", attributes.get(0).getValue());
    assertEquals(EntityConstants.EMAIL_ADDRESS_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Then return Attributes first Value is {@code com.symphony.integration.%s.%s}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_thenReturnAttributesFirstValueIsComSymphonyIntegrationSS2() {
    // Arrange
    User user = new User();
    user.setDisplayName(
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setUserName("com.symphony.integration.%s.%s");

    // Act and Assert
    List<Attribute> attributes = user.toEntity("Integration Name", "Entity Name").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("com.symphony.integration.%s.%s", attributes.get(0).getValue());
    assertEquals(EntityConstants.DISPLAY_NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Then return Attributes first Value is {@code User Name}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_thenReturnAttributesFirstValueIsUserName() {
    // Arrange
    User user = new User();
    user.setEmailAddress(
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setUserName("User Name");

    // Act and Assert
    List<Attribute> attributes = user.toEntity("Integration Name", "Entity Name").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("User Name", attributes.get(0).getValue());
    assertEquals(EntityConstants.EMAIL_ADDRESS_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Then return Attributes first Value is {@code User Name}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_thenReturnAttributesFirstValueIsUserName2() {
    // Arrange
    User user = new User();
    user.setDisplayName(
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setUserName("User Name");

    // Act and Assert
    List<Attribute> attributes = user.toEntity("Integration Name", "Entity Name").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("User Name", attributes.get(0).getValue());
    assertEquals(EntityConstants.DISPLAY_NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Then return Attributes first Value is {@link EntityConstants#USER_ENTITY_FIELD}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_thenReturnAttributesFirstValueIsUser_entity_field() {
    // Arrange
    User user = new User();
    user.setEmailAddress(
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setUserName(EntityConstants.USER_ENTITY_FIELD);

    // Act and Assert
    List<Attribute> attributes = user.toEntity("Integration Name", "Entity Name").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals(EntityConstants.EMAIL_ADDRESS_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ENTITY_FIELD, attributes.get(0).getValue());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Then return Attributes first Value is {@link EntityConstants#USER_ENTITY_FIELD}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_thenReturnAttributesFirstValueIsUser_entity_field2() {
    // Arrange
    User user = new User();
    user.setDisplayName(
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setUserName(EntityConstants.USER_ENTITY_FIELD);

    // Act and Assert
    List<Attribute> attributes = user.toEntity("Integration Name", "Entity Name").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals(EntityConstants.DISPLAY_NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ENTITY_FIELD, attributes.get(0).getValue());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Then return Attributes first Value is {@link EntityConstants#USERNAME_ENTITY_FIELD}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_thenReturnAttributesFirstValueIsUsername_entity_field() {
    // Arrange
    User user = new User();
    user.setEmailAddress(
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setUserName(EntityConstants.USERNAME_ENTITY_FIELD);

    // Act and Assert
    List<Attribute> attributes = user.toEntity("Integration Name", "Entity Name").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals(EntityConstants.EMAIL_ADDRESS_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, attributes.get(0).getValue());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Then return Attributes first Value is {@link EntityConstants#USERNAME_ENTITY_FIELD}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_thenReturnAttributesFirstValueIsUsername_entity_field2() {
    // Arrange
    User user = new User();
    user.setDisplayName(
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setUserName(EntityConstants.USERNAME_ENTITY_FIELD);

    // Act and Assert
    List<Attribute> attributes = user.toEntity("Integration Name", "Entity Name").getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals(EntityConstants.DISPLAY_NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, attributes.get(0).getValue());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Then return Attributes second Value is {@code 11 Station Rd}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
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
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.EMAIL_ADDRESS_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Then return Attributes second Value is {@code 11 Station Rd}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_thenReturnAttributesSecondValueIs11StationRd2() {
    // Arrange
    User user = new User();
    user.setDisplayName("\n");
    user.setEmailAddress("11 Station Rd");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals("11 Station Rd", getResult.getValue());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.EMAIL_ADDRESS_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Then return Attributes second Value is {@code 17 High St}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
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
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.EMAIL_ADDRESS_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Then return Attributes second Value is {@code 17 High St}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_thenReturnAttributesSecondValueIs17HighSt2() {
    // Arrange
    User user = new User();
    user.setDisplayName("\n");
    user.setEmailAddress("17 High St");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals("17 High St", getResult.getValue());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.EMAIL_ADDRESS_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Then return Attributes second Value is {@code 42 Main St}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
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
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.EMAIL_ADDRESS_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Then return Attributes second Value is {@code 42 Main St}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_thenReturnAttributesSecondValueIs42MainSt2() {
    // Arrange
    User user = new User();
    user.setDisplayName("\n");
    user.setEmailAddress("42 Main St");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals("42 Main St", getResult.getValue());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.EMAIL_ADDRESS_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Then return Attributes second Value is {@code com.symphony.integration.%s.%s}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_thenReturnAttributesSecondValueIsComSymphonyIntegrationSS() {
    // Arrange
    User user = new User();
    user.setDisplayName("com.symphony.integration.%s.%s");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals("com.symphony.integration.%s.%s", getResult.getValue());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.DISPLAY_NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Then return Attributes second Value is {@code Display Name}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
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
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.DISPLAY_NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Then return Attributes second Value is {@code Email Address}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
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
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.EMAIL_ADDRESS_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Then return Attributes second Value is {@code Email Address}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_thenReturnAttributesSecondValueIsEmailAddress2() {
    // Arrange
    User user = new User();
    user.setDisplayName("\n");
    user.setEmailAddress("Email Address");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals("Email Address", getResult.getValue());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.EMAIL_ADDRESS_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Then return Attributes second Value is {@code jane.doe@example.org}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_thenReturnAttributesSecondValueIsJaneDoeExampleOrg() {
    // Arrange
    User user = new User();
    user.setEmailAddress("jane.doe@example.org");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals("jane.doe@example.org", getResult.getValue());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.EMAIL_ADDRESS_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Then return Attributes second Value is {@code jane.doe@example.org}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_thenReturnAttributesSecondValueIsJaneDoeExampleOrg2() {
    // Arrange
    User user = new User();
    user.setDisplayName("\n");
    user.setEmailAddress("jane.doe@example.org");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals("jane.doe@example.org", getResult.getValue());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.EMAIL_ADDRESS_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Then return Attributes second Value is {@code jane.doe@example.org}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_thenReturnAttributesSecondValueIsJaneDoeExampleOrg3() {
    // Arrange
    User user = new User();
    user.setId(1L);
    user.setEmailAddress("jane.doe@example.org");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "Entity Name");

    // Assert
    List<Entity> entities = actualToEntityResult.getEntities();
    assertEquals(1, entities.size());
    Entity getResult = entities.get(0);
    List<Attribute> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult2 = attributes.get(0);
    assertEquals("1", getResult2.getValue());
    List<Attribute> attributes2 = actualToEntityResult.getAttributes();
    assertEquals(2, attributes2.size());
    assertEquals("jane.doe@example.org", attributes2.get(1).getValue());
    assertNull(getResult.getName());
    assertNull(getResult.getPresentationML());
    assertTrue(getResult.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, getResult.getType());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Then return Attributes second Value is {@code john.smith@example.org}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_thenReturnAttributesSecondValueIsJohnSmithExampleOrg() {
    // Arrange
    User user = new User();
    user.setEmailAddress("john.smith@example.org");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals("john.smith@example.org", getResult.getValue());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.EMAIL_ADDRESS_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Then return Attributes second Value is {@code john.smith@example.org}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_thenReturnAttributesSecondValueIsJohnSmithExampleOrg2() {
    // Arrange
    User user = new User();
    user.setDisplayName("\n");
    user.setEmailAddress("john.smith@example.org");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals("john.smith@example.org", getResult.getValue());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.EMAIL_ADDRESS_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Then return Attributes second Value is {@code &lt;a href=}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_thenReturnAttributesSecondValueIsLtAHref() {
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
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.DISPLAY_NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Then return Attributes second Value is {@code prof.einstein@example.org}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_thenReturnAttributesSecondValueIsProfEinsteinExampleOrg() {
    // Arrange
    User user = new User();
    user.setEmailAddress("prof.einstein@example.org");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals("prof.einstein@example.org", getResult.getValue());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.EMAIL_ADDRESS_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Then return Attributes second Value is {@code prof.einstein@example.org}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_thenReturnAttributesSecondValueIsProfEinsteinExampleOrg2() {
    // Arrange
    User user = new User();
    user.setDisplayName("\n");
    user.setEmailAddress("prof.einstein@example.org");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals("prof.einstein@example.org", getResult.getValue());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.EMAIL_ADDRESS_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Then return Attributes second Value is {@link EntityConstants#USER_ENTITY_FIELD}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_thenReturnAttributesSecondValueIsUser_entity_field() {
    // Arrange
    User user = new User();
    user.setDisplayName(EntityConstants.USER_ENTITY_FIELD);
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    Attribute getResult = attributes.get(1);
    assertEquals(EntityConstants.DISPLAY_NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ENTITY_FIELD, getResult.getValue());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Then return Attributes second Value is {@link EntityConstants#USERNAME_ENTITY_FIELD}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_thenReturnAttributesSecondValueIsUsername_entity_field() {
    // Arrange
    User user = new User();
    user.setDisplayName(EntityConstants.USERNAME_ENTITY_FIELD);
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    Attribute getResult = attributes.get(1);
    assertEquals(EntityConstants.DISPLAY_NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getValue());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Then return Attributes third Value is a string.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_thenReturnAttributesThirdValueIsAString() {
    // Arrange
    User user = new User();
    user.setEmailAddress("42 Main St");
    user.setDisplayName(
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act and Assert
    List<Attribute> attributes = user.toEntity("Integration Name", "Entity Name").getAttributes();
    assertEquals(3, attributes.size());
    Attribute getResult = attributes.get(2);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("42 Main St", attributes.get(1).getValue());
    assertEquals(EntityConstants.DISPLAY_NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Then return Attributes third Value is a string.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_thenReturnAttributesThirdValueIsAString2() {
    // Arrange
    User user = new User();
    user.setDisplayName(
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setEmailAddress("17 High St");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act and Assert
    List<Attribute> attributes = user.toEntity("Integration Name", "Entity Name").getAttributes();
    assertEquals(3, attributes.size());
    Attribute getResult = attributes.get(2);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("17 High St", attributes.get(1).getValue());
    assertEquals(EntityConstants.DISPLAY_NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Then return Attributes third Value is a string.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_thenReturnAttributesThirdValueIsAString3() {
    // Arrange
    User user = new User();
    user.setDisplayName(
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setEmailAddress("11 Station Rd");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act and Assert
    List<Attribute> attributes = user.toEntity("Integration Name", "Entity Name").getAttributes();
    assertEquals(3, attributes.size());
    Attribute getResult = attributes.get(2);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("11 Station Rd", attributes.get(1).getValue());
    assertEquals(EntityConstants.DISPLAY_NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Then return Attributes third Value is {@code com.symphony.integration.%s.%s}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_thenReturnAttributesThirdValueIsComSymphonyIntegrationSS() {
    // Arrange
    User user = new User();
    user.setEmailAddress("42 Main St");
    user.setDisplayName("com.symphony.integration.%s.%s");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act and Assert
    List<Attribute> attributes = user.toEntity("Integration Name", "Entity Name").getAttributes();
    assertEquals(3, attributes.size());
    assertEquals("42 Main St", attributes.get(1).getValue());
    Attribute getResult = attributes.get(2);
    assertEquals("com.symphony.integration.%s.%s", getResult.getValue());
    assertEquals(EntityConstants.DISPLAY_NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Then return Attributes third Value is {@code com.symphony.integration.%s.%s}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_thenReturnAttributesThirdValueIsComSymphonyIntegrationSS2() {
    // Arrange
    User user = new User();
    user.setDisplayName("com.symphony.integration.%s.%s");
    user.setEmailAddress("17 High St");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act and Assert
    List<Attribute> attributes = user.toEntity("Integration Name", "Entity Name").getAttributes();
    assertEquals(3, attributes.size());
    assertEquals("17 High St", attributes.get(1).getValue());
    Attribute getResult = attributes.get(2);
    assertEquals("com.symphony.integration.%s.%s", getResult.getValue());
    assertEquals(EntityConstants.DISPLAY_NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Then return Attributes third Value is {@code com.symphony.integration.%s.%s}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_thenReturnAttributesThirdValueIsComSymphonyIntegrationSS3() {
    // Arrange
    User user = new User();
    user.setDisplayName("com.symphony.integration.%s.%s");
    user.setEmailAddress("11 Station Rd");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act and Assert
    List<Attribute> attributes = user.toEntity("Integration Name", "Entity Name").getAttributes();
    assertEquals(3, attributes.size());
    assertEquals("11 Station Rd", attributes.get(1).getValue());
    Attribute getResult = attributes.get(2);
    assertEquals("com.symphony.integration.%s.%s", getResult.getValue());
    assertEquals(EntityConstants.DISPLAY_NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Then return Attributes third Value is {@code Display Name}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_thenReturnAttributesThirdValueIsDisplayName() {
    // Arrange
    User user = new User();
    user.setEmailAddress("42 Main St");
    user.setDisplayName("Display Name");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act and Assert
    List<Attribute> attributes = user.toEntity("Integration Name", "Entity Name").getAttributes();
    assertEquals(3, attributes.size());
    assertEquals("42 Main St", attributes.get(1).getValue());
    Attribute getResult = attributes.get(2);
    assertEquals("Display Name", getResult.getValue());
    assertEquals(EntityConstants.DISPLAY_NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Then return Attributes third Value is {@code Display Name}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_thenReturnAttributesThirdValueIsDisplayName2() {
    // Arrange
    User user = new User();
    user.setDisplayName("Display Name");
    user.setEmailAddress("17 High St");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act and Assert
    List<Attribute> attributes = user.toEntity("Integration Name", "Entity Name").getAttributes();
    assertEquals(3, attributes.size());
    assertEquals("17 High St", attributes.get(1).getValue());
    Attribute getResult = attributes.get(2);
    assertEquals("Display Name", getResult.getValue());
    assertEquals(EntityConstants.DISPLAY_NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Then return Attributes third Value is {@code Display Name}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_thenReturnAttributesThirdValueIsDisplayName3() {
    // Arrange
    User user = new User();
    user.setDisplayName("Display Name");
    user.setEmailAddress("11 Station Rd");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act and Assert
    List<Attribute> attributes = user.toEntity("Integration Name", "Entity Name").getAttributes();
    assertEquals(3, attributes.size());
    assertEquals("11 Station Rd", attributes.get(1).getValue());
    Attribute getResult = attributes.get(2);
    assertEquals("Display Name", getResult.getValue());
    assertEquals(EntityConstants.DISPLAY_NAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Then return Attributes third Value is {@link EntityConstants#USER_ENTITY_FIELD}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_thenReturnAttributesThirdValueIsUser_entity_field() {
    // Arrange
    User user = new User();
    user.setEmailAddress("42 Main St");
    user.setDisplayName(EntityConstants.USER_ENTITY_FIELD);
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act and Assert
    List<Attribute> attributes = user.toEntity("Integration Name", "Entity Name").getAttributes();
    assertEquals(3, attributes.size());
    assertEquals("42 Main St", attributes.get(1).getValue());
    Attribute getResult = attributes.get(2);
    assertEquals(EntityConstants.DISPLAY_NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ENTITY_FIELD, getResult.getValue());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Then return Attributes third Value is {@link EntityConstants#USER_ENTITY_FIELD}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_thenReturnAttributesThirdValueIsUser_entity_field2() {
    // Arrange
    User user = new User();
    user.setDisplayName(EntityConstants.USER_ENTITY_FIELD);
    user.setEmailAddress("17 High St");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act and Assert
    List<Attribute> attributes = user.toEntity("Integration Name", "Entity Name").getAttributes();
    assertEquals(3, attributes.size());
    assertEquals("17 High St", attributes.get(1).getValue());
    Attribute getResult = attributes.get(2);
    assertEquals(EntityConstants.DISPLAY_NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ENTITY_FIELD, getResult.getValue());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Then return Attributes third Value is {@link EntityConstants#USER_ENTITY_FIELD}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_thenReturnAttributesThirdValueIsUser_entity_field3() {
    // Arrange
    User user = new User();
    user.setDisplayName(EntityConstants.USER_ENTITY_FIELD);
    user.setEmailAddress("11 Station Rd");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act and Assert
    List<Attribute> attributes = user.toEntity("Integration Name", "Entity Name").getAttributes();
    assertEquals(3, attributes.size());
    assertEquals("11 Station Rd", attributes.get(1).getValue());
    Attribute getResult = attributes.get(2);
    assertEquals(EntityConstants.DISPLAY_NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ENTITY_FIELD, getResult.getValue());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Then return Attributes third Value is {@link EntityConstants#USERNAME_ENTITY_FIELD}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_thenReturnAttributesThirdValueIsUsername_entity_field() {
    // Arrange
    User user = new User();
    user.setEmailAddress("42 Main St");
    user.setDisplayName(EntityConstants.USERNAME_ENTITY_FIELD);
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act and Assert
    List<Attribute> attributes = user.toEntity("Integration Name", "Entity Name").getAttributes();
    assertEquals(3, attributes.size());
    assertEquals("42 Main St", attributes.get(1).getValue());
    Attribute getResult = attributes.get(2);
    assertEquals(EntityConstants.DISPLAY_NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getValue());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Then return Attributes third Value is {@link EntityConstants#USERNAME_ENTITY_FIELD}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_thenReturnAttributesThirdValueIsUsername_entity_field2() {
    // Arrange
    User user = new User();
    user.setDisplayName(EntityConstants.USERNAME_ENTITY_FIELD);
    user.setEmailAddress("17 High St");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act and Assert
    List<Attribute> attributes = user.toEntity("Integration Name", "Entity Name").getAttributes();
    assertEquals(3, attributes.size());
    assertEquals("17 High St", attributes.get(1).getValue());
    Attribute getResult = attributes.get(2);
    assertEquals(EntityConstants.DISPLAY_NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getValue());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Then return Attributes third Value is {@link EntityConstants#USERNAME_ENTITY_FIELD}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_thenReturnAttributesThirdValueIsUsername_entity_field3() {
    // Arrange
    User user = new User();
    user.setDisplayName(EntityConstants.USERNAME_ENTITY_FIELD);
    user.setEmailAddress("11 Station Rd");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act and Assert
    List<Attribute> attributes = user.toEntity("Integration Name", "Entity Name").getAttributes();
    assertEquals(3, attributes.size());
    assertEquals("11 Station Rd", attributes.get(1).getValue());
    Attribute getResult = attributes.get(2);
    assertEquals(EntityConstants.DISPLAY_NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getValue());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Then return Entities first Attributes first Value is {@code -1}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_thenReturnEntitiesFirstAttributesFirstValueIs1() {
    // Arrange
    User user = new User();
    user.setId(-1L);
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act and Assert
    List<Entity> entities = user.toEntity("Integration Name", "Entity Name").getEntities();
    assertEquals(1, entities.size());
    Entity getResult = entities.get(0);
    List<Attribute> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult2 = attributes.get(0);
    assertEquals("-1", getResult2.getValue());
    assertNull(getResult.getName());
    assertNull(getResult.getPresentationML());
    assertTrue(getResult.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, getResult.getType());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Then return Entities first Attributes first Value is {@code -1}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_thenReturnEntitiesFirstAttributesFirstValueIs12() {
    // Arrange
    User user = new User();
    user.setEmailAddress("42 Main St");
    user.setId(-1L);
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "Entity Name");

    // Assert
    List<Entity> entities = actualToEntityResult.getEntities();
    assertEquals(1, entities.size());
    Entity getResult = entities.get(0);
    List<Attribute> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult2 = attributes.get(0);
    assertEquals("-1", getResult2.getValue());
    List<Attribute> attributes2 = actualToEntityResult.getAttributes();
    assertEquals(2, attributes2.size());
    assertEquals("42 Main St", attributes2.get(1).getValue());
    assertNull(getResult.getName());
    assertNull(getResult.getPresentationML());
    assertTrue(getResult.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, getResult.getType());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Then return Entities first Attributes first Value is {@code -1}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_thenReturnEntitiesFirstAttributesFirstValueIs13() {
    // Arrange
    User user = new User();
    user.setDisplayName("\n");
    user.setId(-1L);
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act and Assert
    List<Entity> entities = user.toEntity("Integration Name", "Entity Name").getEntities();
    assertEquals(1, entities.size());
    Entity getResult = entities.get(0);
    List<Attribute> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult2 = attributes.get(0);
    assertEquals("-1", getResult2.getValue());
    assertNull(getResult.getName());
    assertNull(getResult.getPresentationML());
    assertTrue(getResult.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, getResult.getType());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Then return Entities first Attributes first Value is {@code 123}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_thenReturnEntitiesFirstAttributesFirstValueIs123() {
    // Arrange
    User user = new User();
    user.setId(123L);
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act and Assert
    List<Entity> entities = user.toEntity("Integration Name", "Entity Name").getEntities();
    assertEquals(1, entities.size());
    Entity getResult = entities.get(0);
    List<Attribute> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult2 = attributes.get(0);
    assertEquals("123", getResult2.getValue());
    assertNull(getResult.getName());
    assertNull(getResult.getPresentationML());
    assertTrue(getResult.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, getResult.getType());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Then return Entities first Attributes first Value is {@code 123}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_thenReturnEntitiesFirstAttributesFirstValueIs1232() {
    // Arrange
    User user = new User();
    user.setEmailAddress("42 Main St");
    user.setId(123L);
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "Entity Name");

    // Assert
    List<Entity> entities = actualToEntityResult.getEntities();
    assertEquals(1, entities.size());
    Entity getResult = entities.get(0);
    List<Attribute> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult2 = attributes.get(0);
    assertEquals("123", getResult2.getValue());
    List<Attribute> attributes2 = actualToEntityResult.getAttributes();
    assertEquals(2, attributes2.size());
    assertEquals("42 Main St", attributes2.get(1).getValue());
    assertNull(getResult.getName());
    assertNull(getResult.getPresentationML());
    assertTrue(getResult.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, getResult.getType());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Then return Entities first Attributes first Value is {@code 123}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_thenReturnEntitiesFirstAttributesFirstValueIs1233() {
    // Arrange
    User user = new User();
    user.setDisplayName("\n");
    user.setId(123L);
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act and Assert
    List<Entity> entities = user.toEntity("Integration Name", "Entity Name").getEntities();
    assertEquals(1, entities.size());
    Entity getResult = entities.get(0);
    List<Attribute> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult2 = attributes.get(0);
    assertEquals("123", getResult2.getValue());
    assertNull(getResult.getName());
    assertNull(getResult.getPresentationML());
    assertTrue(getResult.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, getResult.getType());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Then return Entities first Attributes first Value is {@code 9223372036854775807}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_thenReturnEntitiesFirstAttributesFirstValueIs9223372036854775807() {
    // Arrange
    User user = new User();
    user.setId(Long.MAX_VALUE);
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act and Assert
    List<Entity> entities = user.toEntity("Integration Name", "Entity Name").getEntities();
    assertEquals(1, entities.size());
    Entity getResult = entities.get(0);
    List<Attribute> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult2 = attributes.get(0);
    assertEquals("9223372036854775807", getResult2.getValue());
    assertNull(getResult.getName());
    assertNull(getResult.getPresentationML());
    assertTrue(getResult.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, getResult.getType());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Then return Entities first Attributes first Value is {@code -9223372036854775808}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_thenReturnEntitiesFirstAttributesFirstValueIs9223372036854775808() {
    // Arrange
    User user = new User();
    user.setId(Long.MIN_VALUE);
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act and Assert
    List<Entity> entities = user.toEntity("Integration Name", "Entity Name").getEntities();
    assertEquals(1, entities.size());
    Entity getResult = entities.get(0);
    List<Attribute> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult2 = attributes.get(0);
    assertEquals("-9223372036854775808", getResult2.getValue());
    assertNull(getResult.getName());
    assertNull(getResult.getPresentationML());
    assertTrue(getResult.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, getResult.getType());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Then return Entities first Attributes first Value is {@code 9223372036854775807}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_thenReturnEntitiesFirstAttributesFirstValueIs92233720368547758072() {
    // Arrange
    User user = new User();
    user.setEmailAddress("42 Main St");
    user.setId(Long.MAX_VALUE);
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    assertEquals("42 Main St", attributes.get(1).getValue());
    List<Entity> entities = actualToEntityResult.getEntities();
    assertEquals(1, entities.size());
    Entity getResult = entities.get(0);
    List<Attribute> attributes2 = getResult.getAttributes();
    assertEquals(1, attributes2.size());
    Attribute getResult2 = attributes2.get(0);
    assertEquals("9223372036854775807", getResult2.getValue());
    assertNull(getResult.getName());
    assertNull(getResult.getPresentationML());
    assertTrue(getResult.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, getResult.getType());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Then return Entities first Attributes first Value is {@code 9223372036854775807}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_thenReturnEntitiesFirstAttributesFirstValueIs92233720368547758073() {
    // Arrange
    User user = new User();
    user.setDisplayName("\n");
    user.setId(Long.MAX_VALUE);
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act and Assert
    List<Entity> entities = user.toEntity("Integration Name", "Entity Name").getEntities();
    assertEquals(1, entities.size());
    Entity getResult = entities.get(0);
    List<Attribute> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult2 = attributes.get(0);
    assertEquals("9223372036854775807", getResult2.getValue());
    assertNull(getResult.getName());
    assertNull(getResult.getPresentationML());
    assertTrue(getResult.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, getResult.getType());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Then return Entities first Attributes first Value is {@code -9223372036854775808}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_thenReturnEntitiesFirstAttributesFirstValueIs92233720368547758082() {
    // Arrange
    User user = new User();
    user.setEmailAddress("42 Main St");
    user.setId(Long.MIN_VALUE);
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "Entity Name");

    // Assert
    List<Entity> entities = actualToEntityResult.getEntities();
    assertEquals(1, entities.size());
    Entity getResult = entities.get(0);
    List<Attribute> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult2 = attributes.get(0);
    assertEquals("-9223372036854775808", getResult2.getValue());
    List<Attribute> attributes2 = actualToEntityResult.getAttributes();
    assertEquals(2, attributes2.size());
    assertEquals("42 Main St", attributes2.get(1).getValue());
    assertNull(getResult.getName());
    assertNull(getResult.getPresentationML());
    assertTrue(getResult.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, getResult.getType());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Test {@link User#toEntity(String, String)}.
   *
   * <ul>
   *   <li>Then return Entities first Attributes first Value is {@code -9223372036854775808}.
   * </ul>
   *
   * <p>Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity User.toEntity(String, String)"})
  public void testToEntity_thenReturnEntitiesFirstAttributesFirstValueIs92233720368547758083() {
    // Arrange
    User user = new User();
    user.setDisplayName("\n");
    user.setId(Long.MIN_VALUE);
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act and Assert
    List<Entity> entities = user.toEntity("Integration Name", "Entity Name").getEntities();
    assertEquals(1, entities.size());
    Entity getResult = entities.get(0);
    List<Attribute> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult2 = attributes.get(0);
    assertEquals("-9223372036854775808", getResult2.getValue());
    assertNull(getResult.getName());
    assertNull(getResult.getPresentationML());
    assertTrue(getResult.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, getResult.getType());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void User.<init>()",
    "String User.getDisplayName()",
    "String User.getEmailAddress()",
    "Long User.getId()",
    "String User.getUsername()",
    "void User.setDisplayName(String)",
    "void User.setEmailAddress(String)",
    "void User.setId(Long)",
    "void User.setUserName(String)"
  })
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
