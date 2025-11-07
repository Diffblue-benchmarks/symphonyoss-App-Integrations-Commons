package org.symphonyoss.integration.entity.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import java.util.List;
import org.junit.Test;
import org.symphonyoss.integration.entity.Attribute;
import org.symphonyoss.integration.entity.Entity;

public class UserDiffblueTest {
  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity() {
    // Arrange, Act and Assert
    assertNull((new User()).getMentionEntity("Integration Name"));
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity2() {
    // Arrange
    User user = new User();
    user.setId(1L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity("Integration Name");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals("1", getResult.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.USER_ID, getResult.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity3() {
    // Arrange
    User user = new User();
    user.setDisplayName(EntityConstants.MENTION_TYPE);
    user.setId(1L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity("Integration Name");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals("1", getResult.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    Attribute getResult2 = attributes.get(1);
    assertEquals(EntityConstants.MENTION_TYPE, getResult2.getValue());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult2.getName());
    assertEquals(EntityConstants.USER_ID, getResult.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity4() {
    // Arrange
    User user = new User();
    user.setDisplayName("\n");
    user.setId(1L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity("Integration Name");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals("1", getResult.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.USER_ID, getResult.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity5() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(1L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity("Integration Name");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("1", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity6() {
    // Arrange
    User user = new User();
    user.setDisplayName("");
    user.setId(1L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity("Integration Name");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals("1", getResult.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.USER_ID, getResult.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity7() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(2L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity("Integration Name");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("2", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity8() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(3L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity("Integration Name");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("3", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity9() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(4L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity("Integration Name");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("4", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity10() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(5L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity("Integration Name");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("5", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity11() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(6L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity("Integration Name");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("6", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity12() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(7L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity("Integration Name");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("7", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity13() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(8L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity("Integration Name");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("8", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity14() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(9L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity("Integration Name");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("9", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity15() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(10L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity("Integration Name");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("10", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity16() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(123L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity("Integration Name");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("123", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity17() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(0L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity("Integration Name");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("0", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity18() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(-1L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity("Integration Name");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("-1", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity19() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(Long.MAX_VALUE);

    // Act
    Entity actualMentionEntity = user.getMentionEntity("Integration Name");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("9223372036854775807", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity20() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(Long.MIN_VALUE);

    // Act
    Entity actualMentionEntity = user.getMentionEntity("Integration Name");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("-9223372036854775808", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity21() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(1L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity("\n");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("1", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity22() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(1L);

    // Act
    Entity actualMentionEntity = user
        .getMentionEntity("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("1", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity23() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(1L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity("-");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("1", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity24() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(1L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity(EntityConstants.MENTION_TYPE);

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("1", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity25() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(1L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity("1.0");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("1", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity26() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(1L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity(EntityConstants.USER_ID);

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("1", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity27() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(1L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity("org.symphony.oss.number.long");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("1", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity28() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(1L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity(null);

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("1", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity29() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(1L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity("42");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("1", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity30() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(1L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity(EntityConstants.NAME_ENTITY_FIELD);

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("1", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity31() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(1L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity("");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("1", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity32() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(1L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity("<br/>");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("1", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity33() {
    // Arrange
    User user = new User();
    user.setUserName("janedoe");
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(1L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity("Integration Name");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("1", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity34() {
    // Arrange
    User user = new User();
    user.setEmailAddress("42 Main St");
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(1L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity("Integration Name");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("1", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity35() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(2L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity("\n");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("2", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity36() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(2L);

    // Act
    Entity actualMentionEntity = user
        .getMentionEntity("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("2", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity37() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(2L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity("-");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("2", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity38() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(2L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity(EntityConstants.MENTION_TYPE);

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("2", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity39() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(2L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity("1.0");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("2", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity40() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(2L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity(EntityConstants.USER_ID);

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("2", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity41() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(2L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity("org.symphony.oss.number.long");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("2", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity42() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(2L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity(null);

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("2", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity43() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(2L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity("42");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("2", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity44() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(2L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity(EntityConstants.NAME_ENTITY_FIELD);

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("2", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity45() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(2L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity("");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("2", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity46() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(2L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity("<br/>");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("2", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity47() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(3L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity("\n");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("3", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity48() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(3L);

    // Act
    Entity actualMentionEntity = user
        .getMentionEntity("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("3", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity49() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(3L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity("-");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("3", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity50() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(3L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity(EntityConstants.MENTION_TYPE);

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("3", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity51() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(3L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity("1.0");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("3", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity52() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(3L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity(EntityConstants.USER_ID);

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("3", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity53() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(3L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity("org.symphony.oss.number.long");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("3", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity54() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(3L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity(null);

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("3", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity55() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(3L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity("42");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("3", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity56() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(3L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity(EntityConstants.NAME_ENTITY_FIELD);

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("3", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity57() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(3L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity("");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("3", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity58() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(3L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity("<br/>");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("3", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity59() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(4L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity("\n");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("4", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity60() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(4L);

    // Act
    Entity actualMentionEntity = user
        .getMentionEntity("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("4", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity61() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(4L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity("-");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("4", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity62() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(4L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity(EntityConstants.MENTION_TYPE);

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("4", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity63() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(4L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity("1.0");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("4", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity64() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(4L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity(EntityConstants.USER_ID);

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("4", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity65() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(4L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity("org.symphony.oss.number.long");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("4", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity66() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(4L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity(null);

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("4", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity67() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(4L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity("42");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("4", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity68() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(4L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity(EntityConstants.NAME_ENTITY_FIELD);

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("4", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity69() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(4L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity("");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("4", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity70() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(4L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity("<br/>");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("4", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity71() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(5L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity("\n");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("5", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity72() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(5L);

    // Act
    Entity actualMentionEntity = user
        .getMentionEntity("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("5", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity73() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(5L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity("-");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("5", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity74() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(5L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity(EntityConstants.MENTION_TYPE);

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("5", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity75() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(5L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity("1.0");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("5", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity76() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(5L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity(EntityConstants.USER_ID);

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("5", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity77() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(5L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity("org.symphony.oss.number.long");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("5", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity78() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(5L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity(null);

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("5", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity79() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(5L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity("42");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("5", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity80() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(5L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity(EntityConstants.NAME_ENTITY_FIELD);

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("5", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity81() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(5L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity("");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("5", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity82() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(5L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity("<br/>");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("5", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity83() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(6L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity("\n");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("6", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity84() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(6L);

    // Act
    Entity actualMentionEntity = user
        .getMentionEntity("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("6", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity85() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(6L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity("-");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("6", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity86() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(6L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity(EntityConstants.MENTION_TYPE);

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("6", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity87() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(6L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity("1.0");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("6", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity88() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(6L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity(EntityConstants.USER_ID);

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("6", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity89() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(6L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity("org.symphony.oss.number.long");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("6", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity90() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(6L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity(null);

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("6", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity91() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(6L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity("42");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("6", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity92() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(6L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity(EntityConstants.NAME_ENTITY_FIELD);

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("6", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity93() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(6L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity("");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("6", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity94() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(6L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity("<br/>");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("6", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity95() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(7L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity("\n");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("7", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity96() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(7L);

    // Act
    Entity actualMentionEntity = user
        .getMentionEntity("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("7", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity97() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(7L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity("-");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("7", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity98() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(7L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity(EntityConstants.MENTION_TYPE);

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("7", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity99() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(7L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity("1.0");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("7", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity100() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(7L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity(EntityConstants.USER_ID);

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("7", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity101() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(7L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity("org.symphony.oss.number.long");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("7", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity102() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(7L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity(null);

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("7", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity103() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(7L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity("42");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("7", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity104() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(7L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity(EntityConstants.NAME_ENTITY_FIELD);

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("7", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity105() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(7L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity("");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("7", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity106() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(7L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity("<br/>");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("7", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity107() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(8L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity("\n");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("8", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity108() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(8L);

    // Act
    Entity actualMentionEntity = user
        .getMentionEntity("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("8", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity109() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(8L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity("-");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("8", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity110() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(8L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity(EntityConstants.MENTION_TYPE);

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("8", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity111() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(8L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity("1.0");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("8", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity112() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(8L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity(EntityConstants.USER_ID);

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("8", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity113() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(8L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity("org.symphony.oss.number.long");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("8", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity114() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(8L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity(null);

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("8", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity115() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(8L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity("42");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("8", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity116() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(8L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity(EntityConstants.NAME_ENTITY_FIELD);

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("8", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity117() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(8L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity("");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("8", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity118() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(8L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity("<br/>");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("8", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity119() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(9L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity("\n");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("9", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity120() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(9L);

    // Act
    Entity actualMentionEntity = user
        .getMentionEntity("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("9", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity121() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(9L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity("-");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("9", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity122() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(9L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity(EntityConstants.MENTION_TYPE);

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("9", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity123() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(9L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity("1.0");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("9", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity124() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(9L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity(EntityConstants.USER_ID);

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("9", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity125() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(9L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity("org.symphony.oss.number.long");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("9", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity126() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(9L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity(null);

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("9", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity127() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(9L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity("42");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("9", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity128() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(9L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity(EntityConstants.NAME_ENTITY_FIELD);

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("9", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity129() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(9L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity("");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("9", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity130() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(9L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity("<br/>");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("9", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity131() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(10L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity("\n");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("10", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity132() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(10L);

    // Act
    Entity actualMentionEntity = user
        .getMentionEntity("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("10", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity133() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(10L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity("-");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("10", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity134() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(10L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity(EntityConstants.MENTION_TYPE);

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("10", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity135() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(10L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity("1.0");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("10", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity136() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(10L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity(EntityConstants.USER_ID);

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("10", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity137() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(10L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity("org.symphony.oss.number.long");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("10", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity138() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(10L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity(null);

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("10", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity139() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(10L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity("42");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("10", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity140() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(10L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity(EntityConstants.NAME_ENTITY_FIELD);

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("10", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity141() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(10L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity("");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("10", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity142() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(10L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity("<br/>");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("10", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity143() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(123L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity("\n");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("123", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity144() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(123L);

    // Act
    Entity actualMentionEntity = user
        .getMentionEntity("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("123", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity145() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(123L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity("-");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("123", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity146() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(123L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity(EntityConstants.MENTION_TYPE);

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("123", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity147() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(123L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity("1.0");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("123", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity148() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(123L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity(EntityConstants.USER_ID);

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("123", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity149() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(123L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity("org.symphony.oss.number.long");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("123", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity150() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(123L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity(null);

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("123", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity151() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(123L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity("42");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("123", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity152() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(123L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity(EntityConstants.NAME_ENTITY_FIELD);

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("123", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity153() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(123L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity("");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("123", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity154() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(123L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity("<br/>");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("123", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity155() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(0L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity("\n");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("0", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity156() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(0L);

    // Act
    Entity actualMentionEntity = user
        .getMentionEntity("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("0", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity157() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(0L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity("-");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("0", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity158() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(0L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity(EntityConstants.MENTION_TYPE);

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("0", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity159() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(0L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity("1.0");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("0", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity160() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(0L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity(EntityConstants.USER_ID);

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("0", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity161() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(0L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity("org.symphony.oss.number.long");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("0", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity162() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(0L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity(null);

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("0", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity163() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(0L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity("42");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("0", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity164() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(0L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity(EntityConstants.NAME_ENTITY_FIELD);

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("0", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity165() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(0L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity("");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("0", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity166() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(0L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity("<br/>");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("0", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity167() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(-1L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity("\n");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("-1", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity168() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(-1L);

    // Act
    Entity actualMentionEntity = user
        .getMentionEntity("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("-1", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity169() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(-1L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity("-");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("-1", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity170() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(-1L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity(EntityConstants.MENTION_TYPE);

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("-1", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity171() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(-1L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity("1.0");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("-1", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity172() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(-1L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity(EntityConstants.USER_ID);

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("-1", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity173() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(-1L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity("org.symphony.oss.number.long");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("-1", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity174() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(-1L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity(null);

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("-1", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity175() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(-1L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity("42");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("-1", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity176() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(-1L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity(EntityConstants.NAME_ENTITY_FIELD);

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("-1", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity177() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(-1L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity("");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("-1", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity178() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(-1L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity("<br/>");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("-1", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity179() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(Long.MAX_VALUE);

    // Act
    Entity actualMentionEntity = user.getMentionEntity("\n");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("9223372036854775807", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity180() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(Long.MAX_VALUE);

    // Act
    Entity actualMentionEntity = user
        .getMentionEntity("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("9223372036854775807", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity181() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(Long.MAX_VALUE);

    // Act
    Entity actualMentionEntity = user.getMentionEntity("-");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("9223372036854775807", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity182() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(Long.MAX_VALUE);

    // Act
    Entity actualMentionEntity = user.getMentionEntity(EntityConstants.MENTION_TYPE);

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("9223372036854775807", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity183() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(Long.MAX_VALUE);

    // Act
    Entity actualMentionEntity = user.getMentionEntity("1.0");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("9223372036854775807", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity184() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(Long.MAX_VALUE);

    // Act
    Entity actualMentionEntity = user.getMentionEntity(EntityConstants.USER_ID);

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("9223372036854775807", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity185() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(Long.MAX_VALUE);

    // Act
    Entity actualMentionEntity = user.getMentionEntity("org.symphony.oss.number.long");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("9223372036854775807", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity186() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(Long.MAX_VALUE);

    // Act
    Entity actualMentionEntity = user.getMentionEntity(null);

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("9223372036854775807", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity187() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(Long.MAX_VALUE);

    // Act
    Entity actualMentionEntity = user.getMentionEntity("42");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("9223372036854775807", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity188() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(Long.MAX_VALUE);

    // Act
    Entity actualMentionEntity = user.getMentionEntity(EntityConstants.NAME_ENTITY_FIELD);

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("9223372036854775807", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity189() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(Long.MAX_VALUE);

    // Act
    Entity actualMentionEntity = user.getMentionEntity("");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("9223372036854775807", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity190() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(Long.MAX_VALUE);

    // Act
    Entity actualMentionEntity = user.getMentionEntity("<br/>");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("9223372036854775807", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity191() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(Long.MIN_VALUE);

    // Act
    Entity actualMentionEntity = user.getMentionEntity("\n");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("-9223372036854775808", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity192() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(Long.MIN_VALUE);

    // Act
    Entity actualMentionEntity = user
        .getMentionEntity("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("-9223372036854775808", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity193() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(Long.MIN_VALUE);

    // Act
    Entity actualMentionEntity = user.getMentionEntity("-");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("-9223372036854775808", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity194() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(Long.MIN_VALUE);

    // Act
    Entity actualMentionEntity = user.getMentionEntity(EntityConstants.MENTION_TYPE);

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("-9223372036854775808", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity195() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(Long.MIN_VALUE);

    // Act
    Entity actualMentionEntity = user.getMentionEntity("1.0");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("-9223372036854775808", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity196() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(Long.MIN_VALUE);

    // Act
    Entity actualMentionEntity = user.getMentionEntity(EntityConstants.USER_ID);

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("-9223372036854775808", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity197() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(Long.MIN_VALUE);

    // Act
    Entity actualMentionEntity = user.getMentionEntity("org.symphony.oss.number.long");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("-9223372036854775808", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity198() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(Long.MIN_VALUE);

    // Act
    Entity actualMentionEntity = user.getMentionEntity(null);

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("-9223372036854775808", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity199() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(Long.MIN_VALUE);

    // Act
    Entity actualMentionEntity = user.getMentionEntity("42");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("-9223372036854775808", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity200() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(Long.MIN_VALUE);

    // Act
    Entity actualMentionEntity = user.getMentionEntity(EntityConstants.NAME_ENTITY_FIELD);

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("-9223372036854775808", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity201() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(Long.MIN_VALUE);

    // Act
    Entity actualMentionEntity = user.getMentionEntity("");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("-9223372036854775808", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity202() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(Long.MIN_VALUE);

    // Act
    Entity actualMentionEntity = user.getMentionEntity("<br/>");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("-9223372036854775808", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#getMentionEntity(String)}
   */
  @Test
  public void testGetMentionEntity203() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setId(1L);

    // Act
    Entity actualMentionEntity = user.getMentionEntity("<a href=");

    // Assert
    List<Attribute> attributes = actualMentionEntity.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(0);
    assertEquals("1", getResult2.getValue());
    assertNull(actualMentionEntity.getName());
    assertNull(actualMentionEntity.getPresentationML());
    assertTrue(actualMentionEntity.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, actualMentionEntity.getType());
    assertEquals(EntityConstants.NAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity() {
    // Arrange and Act
    Entity actualToEntityResult = (new User()).toEntity("Integration Name", "Entity Name");

    // Assert
    assertEquals("Entity Name", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.Integration Name.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getAttributes().isEmpty());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity2() {
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
    assertEquals("Entity Name", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.Integration Name.user", actualToEntityResult.getType());
    assertNull(getResult.getName());
    assertNull(getResult.getPresentationML());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getAttributes().isEmpty());
    assertTrue(getResult.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, getResult.getType());
    assertEquals(EntityConstants.USER_ID, getResult2.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity3() {
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
    Attribute getResult = attributes.get(0);
    assertEquals("janedoe", getResult.getValue());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity4() {
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
    assertTrue(actualToEntityResult.getEntities().isEmpty());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity5() {
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
    assertEquals("Entity Name", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.Integration Name.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity6() {
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
    assertTrue(actualToEntityResult.getEntities().isEmpty());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity7() {
    // Arrange
    User user = new User();
    user.setEmailAddress("42 Main St");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(1);
    assertEquals("42 Main St", getResult2.getValue());
    assertEquals("Entity Name", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.Integration Name.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.EMAIL_ADDRESS_ENTITY_FIELD, getResult2.getName());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity8() {
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
    assertEquals("Entity Name", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.Integration Name.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity9() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("\n", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("Entity Name", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.\n.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity10() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user
        .toEntity("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("Entity Name", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\" "
        + " >xx</a>.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity11() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("-", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("Entity Name", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.-.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity12() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity(EntityConstants.USER_ENTITY_FIELD, "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("Entity Name", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.user.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity13() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("com.symphony.integration.%s.%s", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("Entity Name", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.com.symphony.integration.%s.%s.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity14() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("1.0", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("Entity Name", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.1.0.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity15() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity(EntityConstants.USERNAME_ENTITY_FIELD, "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("Entity Name", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.username.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity16() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("42", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("Entity Name", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.42.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity17() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("<br/>", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("Entity Name", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.<br/>.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity18() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("<a href=", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("Entity Name", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.<a href=.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity19() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "\n");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("\n", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.Integration Name.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity20() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name",
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>",
        actualToEntityResult.getName());
    assertEquals("com.symphony.integration.Integration Name.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity21() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "-");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("-", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.Integration Name.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity22() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", EntityConstants.USER_ENTITY_FIELD);

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("com.symphony.integration.Integration Name.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ENTITY_FIELD, actualToEntityResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity23() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "com.symphony.integration.%s.%s");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("com.symphony.integration.%s.%s", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.Integration Name.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity24() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "1.0");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("1.0", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.Integration Name.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity25() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", EntityConstants.USERNAME_ENTITY_FIELD);

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("com.symphony.integration.Integration Name.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, actualToEntityResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity26() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", null);

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("com.symphony.integration.Integration Name.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getName());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity27() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "42");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("42", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.Integration Name.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity28() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "<br/>");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("<br/>", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.Integration Name.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity29() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "");

    // Assert
    assertEquals("", actualToEntityResult.getName());
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("com.symphony.integration.Integration Name.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity30() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "<a href=");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("<a href=", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.Integration Name.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity31() {
    // Arrange
    User user = new User();
    user.setId(1L);
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
    List<Entity> entities = actualToEntityResult.getEntities();
    assertEquals(1, entities.size());
    Entity getResult2 = entities.get(0);
    List<Attribute> attributes2 = getResult2.getAttributes();
    assertEquals(1, attributes2.size());
    Attribute getResult3 = attributes2.get(0);
    assertEquals("1", getResult3.getValue());
    assertEquals("Entity Name", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.Integration Name.user", actualToEntityResult.getType());
    assertNull(getResult2.getName());
    assertNull(getResult2.getPresentationML());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(getResult2.getEntities().isEmpty());
    assertEquals(EntityConstants.MENTION_TYPE, getResult2.getType());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ID, getResult3.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity32() {
    // Arrange
    User user = new User();
    user.setEmailAddress("17 High St");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(1);
    assertEquals("17 High St", getResult2.getValue());
    assertEquals("Entity Name", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.Integration Name.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.EMAIL_ADDRESS_ENTITY_FIELD, getResult2.getName());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity33() {
    // Arrange
    User user = new User();
    user.setEmailAddress("11 Station Rd");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(1);
    assertEquals("11 Station Rd", getResult2.getValue());
    assertEquals("Entity Name", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.Integration Name.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.EMAIL_ADDRESS_ENTITY_FIELD, getResult2.getName());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity34() {
    // Arrange
    User user = new User();
    user.setEmailAddress("jane.doe@example.org");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("Entity Name", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.Integration Name.user", actualToEntityResult.getType());
    Attribute getResult2 = attributes.get(1);
    assertEquals("jane.doe@example.org", getResult2.getValue());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.EMAIL_ADDRESS_ENTITY_FIELD, getResult2.getName());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity35() {
    // Arrange
    User user = new User();
    user.setEmailAddress("john.smith@example.org");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("Entity Name", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.Integration Name.user", actualToEntityResult.getType());
    Attribute getResult2 = attributes.get(1);
    assertEquals("john.smith@example.org", getResult2.getValue());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.EMAIL_ADDRESS_ENTITY_FIELD, getResult2.getName());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity36() {
    // Arrange
    User user = new User();
    user.setEmailAddress("prof.einstein@example.org");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("Entity Name", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.Integration Name.user", actualToEntityResult.getType());
    Attribute getResult2 = attributes.get(1);
    assertEquals("prof.einstein@example.org", getResult2.getValue());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.EMAIL_ADDRESS_ENTITY_FIELD, getResult2.getName());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity37() {
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
    assertEquals("Entity Name", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.Integration Name.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity38() {
    // Arrange
    User user = new User();
    user.setEmailAddress("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult2.getValue());
    assertEquals("Entity Name", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.Integration Name.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.EMAIL_ADDRESS_ENTITY_FIELD, getResult2.getName());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity39() {
    // Arrange
    User user = new User();
    user.setEmailAddress("-");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(1);
    assertEquals("-", getResult2.getValue());
    assertEquals("Entity Name", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.Integration Name.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.EMAIL_ADDRESS_ENTITY_FIELD, getResult2.getName());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity40() {
    // Arrange
    User user = new User();
    user.setEmailAddress(EntityConstants.USER_ENTITY_FIELD);
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("Entity Name", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.Integration Name.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    Attribute getResult2 = attributes.get(1);
    assertEquals(EntityConstants.EMAIL_ADDRESS_ENTITY_FIELD, getResult2.getName());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ENTITY_FIELD, getResult2.getValue());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity41() {
    // Arrange
    User user = new User();
    user.setEmailAddress("com.symphony.integration.%s.%s");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("Entity Name", actualToEntityResult.getName());
    Attribute getResult2 = attributes.get(1);
    assertEquals("com.symphony.integration.%s.%s", getResult2.getValue());
    assertEquals("com.symphony.integration.Integration Name.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.EMAIL_ADDRESS_ENTITY_FIELD, getResult2.getName());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity42() {
    // Arrange
    User user = new User();
    user.setEmailAddress("1.0");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(1);
    assertEquals("1.0", getResult2.getValue());
    assertEquals("Entity Name", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.Integration Name.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.EMAIL_ADDRESS_ENTITY_FIELD, getResult2.getName());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity43() {
    // Arrange
    User user = new User();
    user.setEmailAddress("Email Address");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(1);
    assertEquals("Email Address", getResult2.getValue());
    assertEquals("Entity Name", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.Integration Name.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.EMAIL_ADDRESS_ENTITY_FIELD, getResult2.getName());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity44() {
    // Arrange
    User user = new User();
    user.setEmailAddress(EntityConstants.USERNAME_ENTITY_FIELD);
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("Entity Name", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.Integration Name.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    Attribute getResult2 = attributes.get(1);
    assertEquals(EntityConstants.EMAIL_ADDRESS_ENTITY_FIELD, getResult2.getName());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult2.getValue());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity45() {
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
    assertEquals("Entity Name", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.Integration Name.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity46() {
    // Arrange
    User user = new User();
    user.setEmailAddress("42");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(1);
    assertEquals("42", getResult2.getValue());
    assertEquals("Entity Name", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.Integration Name.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.EMAIL_ADDRESS_ENTITY_FIELD, getResult2.getName());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity47() {
    // Arrange
    User user = new User();
    user.setEmailAddress("<br/>");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(1);
    assertEquals("&lt;br/&gt;", getResult2.getValue());
    assertEquals("Entity Name", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.Integration Name.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.EMAIL_ADDRESS_ENTITY_FIELD, getResult2.getName());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity48() {
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
    assertEquals("Entity Name", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.Integration Name.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity49() {
    // Arrange
    User user = new User();
    user.setEmailAddress("<a href=");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(1);
    assertEquals("&lt;a href=", getResult2.getValue());
    assertEquals("Entity Name", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.Integration Name.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.EMAIL_ADDRESS_ENTITY_FIELD, getResult2.getName());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity50() {
    // Arrange
    User user = new User();
    user.setEmailAddress("42 Main St");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("\n", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(1);
    assertEquals("42 Main St", getResult2.getValue());
    assertEquals("Entity Name", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.\n.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.EMAIL_ADDRESS_ENTITY_FIELD, getResult2.getName());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity51() {
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
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(1);
    assertEquals("42 Main St", getResult2.getValue());
    assertEquals("Entity Name", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\" "
        + " >xx</a>.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.EMAIL_ADDRESS_ENTITY_FIELD, getResult2.getName());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity52() {
    // Arrange
    User user = new User();
    user.setEmailAddress("42 Main St");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("-", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(1);
    assertEquals("42 Main St", getResult2.getValue());
    assertEquals("Entity Name", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.-.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.EMAIL_ADDRESS_ENTITY_FIELD, getResult2.getName());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity53() {
    // Arrange
    User user = new User();
    user.setEmailAddress("42 Main St");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity(EntityConstants.USER_ENTITY_FIELD, "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(1);
    assertEquals("42 Main St", getResult2.getValue());
    assertEquals("Entity Name", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.user.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.EMAIL_ADDRESS_ENTITY_FIELD, getResult2.getName());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity54() {
    // Arrange
    User user = new User();
    user.setEmailAddress("42 Main St");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("com.symphony.integration.%s.%s", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(1);
    assertEquals("42 Main St", getResult2.getValue());
    assertEquals("Entity Name", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.com.symphony.integration.%s.%s.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.EMAIL_ADDRESS_ENTITY_FIELD, getResult2.getName());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity55() {
    // Arrange
    User user = new User();
    user.setEmailAddress("42 Main St");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("1.0", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(1);
    assertEquals("42 Main St", getResult2.getValue());
    assertEquals("Entity Name", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.1.0.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.EMAIL_ADDRESS_ENTITY_FIELD, getResult2.getName());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity56() {
    // Arrange
    User user = new User();
    user.setEmailAddress("42 Main St");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity(EntityConstants.USERNAME_ENTITY_FIELD, "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(1);
    assertEquals("42 Main St", getResult2.getValue());
    assertEquals("Entity Name", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.username.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.EMAIL_ADDRESS_ENTITY_FIELD, getResult2.getName());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity57() {
    // Arrange
    User user = new User();
    user.setEmailAddress("42 Main St");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("42", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(1);
    assertEquals("42 Main St", getResult2.getValue());
    assertEquals("Entity Name", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.42.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.EMAIL_ADDRESS_ENTITY_FIELD, getResult2.getName());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity58() {
    // Arrange
    User user = new User();
    user.setEmailAddress("42 Main St");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("<br/>", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(1);
    assertEquals("42 Main St", getResult2.getValue());
    assertEquals("Entity Name", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.<br/>.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.EMAIL_ADDRESS_ENTITY_FIELD, getResult2.getName());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity59() {
    // Arrange
    User user = new User();
    user.setEmailAddress("42 Main St");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("<a href=", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(1);
    assertEquals("42 Main St", getResult2.getValue());
    assertEquals("Entity Name", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.<a href=.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.EMAIL_ADDRESS_ENTITY_FIELD, getResult2.getName());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity60() {
    // Arrange
    User user = new User();
    user.setEmailAddress("42 Main St");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "\n");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(1);
    assertEquals("42 Main St", getResult2.getValue());
    assertEquals("\n", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.Integration Name.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.EMAIL_ADDRESS_ENTITY_FIELD, getResult2.getName());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity61() {
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
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(1);
    assertEquals("42 Main St", getResult2.getValue());
    assertEquals("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>",
        actualToEntityResult.getName());
    assertEquals("com.symphony.integration.Integration Name.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.EMAIL_ADDRESS_ENTITY_FIELD, getResult2.getName());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity62() {
    // Arrange
    User user = new User();
    user.setEmailAddress("42 Main St");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "-");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("-", actualToEntityResult.getName());
    Attribute getResult2 = attributes.get(1);
    assertEquals("42 Main St", getResult2.getValue());
    assertEquals("com.symphony.integration.Integration Name.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.EMAIL_ADDRESS_ENTITY_FIELD, getResult2.getName());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity63() {
    // Arrange
    User user = new User();
    user.setEmailAddress("42 Main St");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", EntityConstants.USER_ENTITY_FIELD);

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(1);
    assertEquals("42 Main St", getResult2.getValue());
    assertEquals("com.symphony.integration.Integration Name.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.EMAIL_ADDRESS_ENTITY_FIELD, getResult2.getName());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ENTITY_FIELD, actualToEntityResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity64() {
    // Arrange
    User user = new User();
    user.setEmailAddress("42 Main St");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "com.symphony.integration.%s.%s");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(1);
    assertEquals("42 Main St", getResult2.getValue());
    assertEquals("com.symphony.integration.%s.%s", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.Integration Name.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.EMAIL_ADDRESS_ENTITY_FIELD, getResult2.getName());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity65() {
    // Arrange
    User user = new User();
    user.setEmailAddress("42 Main St");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "1.0");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("1.0", actualToEntityResult.getName());
    Attribute getResult2 = attributes.get(1);
    assertEquals("42 Main St", getResult2.getValue());
    assertEquals("com.symphony.integration.Integration Name.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.EMAIL_ADDRESS_ENTITY_FIELD, getResult2.getName());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity66() {
    // Arrange
    User user = new User();
    user.setEmailAddress("42 Main St");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", EntityConstants.USERNAME_ENTITY_FIELD);

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(1);
    assertEquals("42 Main St", getResult2.getValue());
    assertEquals("com.symphony.integration.Integration Name.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.EMAIL_ADDRESS_ENTITY_FIELD, getResult2.getName());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, actualToEntityResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity67() {
    // Arrange
    User user = new User();
    user.setEmailAddress("42 Main St");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", null);

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(1);
    assertEquals("42 Main St", getResult2.getValue());
    assertEquals("com.symphony.integration.Integration Name.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getName());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.EMAIL_ADDRESS_ENTITY_FIELD, getResult2.getName());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity68() {
    // Arrange
    User user = new User();
    user.setEmailAddress("42 Main St");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "42");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(1);
    assertEquals("42 Main St", getResult2.getValue());
    assertEquals("42", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.Integration Name.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.EMAIL_ADDRESS_ENTITY_FIELD, getResult2.getName());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity69() {
    // Arrange
    User user = new User();
    user.setEmailAddress("42 Main St");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "<br/>");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(1);
    assertEquals("42 Main St", getResult2.getValue());
    assertEquals("<br/>", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.Integration Name.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.EMAIL_ADDRESS_ENTITY_FIELD, getResult2.getName());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity70() {
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
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(1);
    assertEquals("42 Main St", getResult2.getValue());
    assertEquals("com.symphony.integration.Integration Name.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.EMAIL_ADDRESS_ENTITY_FIELD, getResult2.getName());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity71() {
    // Arrange
    User user = new User();
    user.setEmailAddress("42 Main St");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "<a href=");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(1);
    assertEquals("42 Main St", getResult2.getValue());
    assertEquals("<a href=", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.Integration Name.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.EMAIL_ADDRESS_ENTITY_FIELD, getResult2.getName());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity72() {
    // Arrange
    User user = new User();
    user.setDisplayName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(1);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult2.getValue());
    assertEquals("Entity Name", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.Integration Name.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.DISPLAY_NAME_ENTITY_FIELD, getResult2.getName());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity73() {
    // Arrange
    User user = new User();
    user.setDisplayName("-");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(1);
    assertEquals("-", getResult2.getValue());
    assertEquals("Entity Name", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.Integration Name.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.DISPLAY_NAME_ENTITY_FIELD, getResult2.getName());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity74() {
    // Arrange
    User user = new User();
    user.setDisplayName(EntityConstants.USER_ENTITY_FIELD);
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("Entity Name", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.Integration Name.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    Attribute getResult2 = attributes.get(1);
    assertEquals(EntityConstants.DISPLAY_NAME_ENTITY_FIELD, getResult2.getName());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ENTITY_FIELD, getResult2.getValue());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity75() {
    // Arrange
    User user = new User();
    user.setDisplayName("com.symphony.integration.%s.%s");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("Entity Name", actualToEntityResult.getName());
    Attribute getResult2 = attributes.get(1);
    assertEquals("com.symphony.integration.%s.%s", getResult2.getValue());
    assertEquals("com.symphony.integration.Integration Name.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.DISPLAY_NAME_ENTITY_FIELD, getResult2.getName());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity76() {
    // Arrange
    User user = new User();
    user.setDisplayName("1.0");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(1);
    assertEquals("1.0", getResult2.getValue());
    assertEquals("Entity Name", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.Integration Name.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.DISPLAY_NAME_ENTITY_FIELD, getResult2.getName());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity77() {
    // Arrange
    User user = new User();
    user.setDisplayName("Display Name");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(1);
    assertEquals("Display Name", getResult2.getValue());
    assertEquals("Entity Name", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.Integration Name.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.DISPLAY_NAME_ENTITY_FIELD, getResult2.getName());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity78() {
    // Arrange
    User user = new User();
    user.setDisplayName(EntityConstants.USERNAME_ENTITY_FIELD);
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("Entity Name", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.Integration Name.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    Attribute getResult2 = attributes.get(1);
    assertEquals(EntityConstants.DISPLAY_NAME_ENTITY_FIELD, getResult2.getName());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult2.getValue());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity79() {
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
    assertEquals("Entity Name", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.Integration Name.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity80() {
    // Arrange
    User user = new User();
    user.setDisplayName("42");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(1);
    assertEquals("42", getResult2.getValue());
    assertEquals("Entity Name", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.Integration Name.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.DISPLAY_NAME_ENTITY_FIELD, getResult2.getName());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity81() {
    // Arrange
    User user = new User();
    user.setDisplayName("<br/>");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(1);
    assertEquals("&lt;br/&gt;", getResult2.getValue());
    assertEquals("Entity Name", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.Integration Name.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.DISPLAY_NAME_ENTITY_FIELD, getResult2.getName());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity82() {
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
    assertEquals("Entity Name", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.Integration Name.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity83() {
    // Arrange
    User user = new User();
    user.setDisplayName("<a href=");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(2, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    Attribute getResult2 = attributes.get(1);
    assertEquals("&lt;a href=", getResult2.getValue());
    assertEquals("Entity Name", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.Integration Name.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.DISPLAY_NAME_ENTITY_FIELD, getResult2.getName());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity84() {
    // Arrange
    User user = new User();
    user.setDisplayName("\n");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("\n", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("Entity Name", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.\n.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity85() {
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
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("Entity Name", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\" "
        + " >xx</a>.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity86() {
    // Arrange
    User user = new User();
    user.setDisplayName("\n");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("-", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("Entity Name", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.-.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity87() {
    // Arrange
    User user = new User();
    user.setDisplayName("\n");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity(EntityConstants.USER_ENTITY_FIELD, "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("Entity Name", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.user.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity88() {
    // Arrange
    User user = new User();
    user.setDisplayName("\n");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("com.symphony.integration.%s.%s", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("Entity Name", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.com.symphony.integration.%s.%s.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity89() {
    // Arrange
    User user = new User();
    user.setDisplayName("\n");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("1.0", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("Entity Name", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.1.0.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity90() {
    // Arrange
    User user = new User();
    user.setDisplayName("\n");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity(EntityConstants.USERNAME_ENTITY_FIELD, "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("Entity Name", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.username.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity91() {
    // Arrange
    User user = new User();
    user.setDisplayName("\n");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("42", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("Entity Name", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.42.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity92() {
    // Arrange
    User user = new User();
    user.setDisplayName("\n");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("<br/>", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("Entity Name", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.<br/>.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity93() {
    // Arrange
    User user = new User();
    user.setDisplayName("\n");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("<a href=", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("Entity Name", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.<a href=.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity94() {
    // Arrange
    User user = new User();
    user.setDisplayName("\n");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "\n");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("\n", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.Integration Name.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity95() {
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
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>",
        actualToEntityResult.getName());
    assertEquals("com.symphony.integration.Integration Name.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity96() {
    // Arrange
    User user = new User();
    user.setDisplayName("\n");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "-");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("-", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.Integration Name.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity97() {
    // Arrange
    User user = new User();
    user.setDisplayName("\n");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", EntityConstants.USER_ENTITY_FIELD);

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("com.symphony.integration.Integration Name.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ENTITY_FIELD, actualToEntityResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity98() {
    // Arrange
    User user = new User();
    user.setDisplayName("\n");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "com.symphony.integration.%s.%s");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("com.symphony.integration.%s.%s", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.Integration Name.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity99() {
    // Arrange
    User user = new User();
    user.setDisplayName("\n");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "1.0");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("1.0", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.Integration Name.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity100() {
    // Arrange
    User user = new User();
    user.setDisplayName("\n");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", EntityConstants.USERNAME_ENTITY_FIELD);

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("com.symphony.integration.Integration Name.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, actualToEntityResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity101() {
    // Arrange
    User user = new User();
    user.setDisplayName("\n");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", null);

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("com.symphony.integration.Integration Name.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getName());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity102() {
    // Arrange
    User user = new User();
    user.setDisplayName("\n");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "42");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("42", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.Integration Name.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity103() {
    // Arrange
    User user = new User();
    user.setDisplayName("\n");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "<br/>");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("<br/>", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.Integration Name.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity104() {
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
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("com.symphony.integration.Integration Name.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity105() {
    // Arrange
    User user = new User();
    user.setDisplayName("\n");
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "<a href=");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("<a href=", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.Integration Name.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity106() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("/>", "Entity Name");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("Entity Name", actualToEntityResult.getName());
    assertEquals("com.symphony.integration./>.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity107() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("\n", "\n");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("\n", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.\n.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity108() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("\n",
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>",
        actualToEntityResult.getName());
    assertEquals("com.symphony.integration.\n.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity109() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("\n", "-");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("-", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.\n.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity110() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("\n", EntityConstants.USER_ENTITY_FIELD);

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("com.symphony.integration.\n.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ENTITY_FIELD, actualToEntityResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity111() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("\n", "com.symphony.integration.%s.%s");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("com.symphony.integration.%s.%s", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.\n.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity112() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("\n", "1.0");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("1.0", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.\n.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity113() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("\n", EntityConstants.USERNAME_ENTITY_FIELD);

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("com.symphony.integration.\n.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, actualToEntityResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity114() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("\n", null);

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("com.symphony.integration.\n.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getName());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity115() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("\n", "42");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("42", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.\n.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity116() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("\n", "<br/>");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("<br/>", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.\n.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity117() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("\n", "");

    // Assert
    assertEquals("", actualToEntityResult.getName());
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("com.symphony.integration.\n.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity118() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("\n", "<a href=");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("<a href=", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.\n.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity119() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user
        .toEntity("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>", "\n");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("\n", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\" "
        + " >xx</a>.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity120() {
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
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>",
        actualToEntityResult.getName());
    assertEquals("com.symphony.integration.<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\" "
        + " >xx</a>.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity121() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user
        .toEntity("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>", "-");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("-", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\" "
        + " >xx</a>.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity122() {
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
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("com.symphony.integration.<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\" "
        + " >xx</a>.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ENTITY_FIELD, actualToEntityResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity123() {
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
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("com.symphony.integration.%s.%s", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\" "
        + " >xx</a>.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity124() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user
        .toEntity("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>", "1.0");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("1.0", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\" "
        + " >xx</a>.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity125() {
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
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("com.symphony.integration.<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\" "
        + " >xx</a>.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, actualToEntityResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity126() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user
        .toEntity("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>", null);

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("com.symphony.integration.<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\" "
        + " >xx</a>.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getName());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity127() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user
        .toEntity("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>", "42");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("42", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\" "
        + " >xx</a>.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity128() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user
        .toEntity("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>", "<br/>");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("<br/>", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\" "
        + " >xx</a>.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity129() {
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
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("com.symphony.integration.<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\" "
        + " >xx</a>.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity130() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user
        .toEntity("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>", "<a href=");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("<a href=", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\" "
        + " >xx</a>.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity131() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("-", "\n");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("\n", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.-.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity132() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("-",
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>",
        actualToEntityResult.getName());
    assertEquals("com.symphony.integration.-.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity133() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("-", "-");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("-", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.-.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity134() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("-", EntityConstants.USER_ENTITY_FIELD);

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("com.symphony.integration.-.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ENTITY_FIELD, actualToEntityResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity135() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("-", "com.symphony.integration.%s.%s");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("com.symphony.integration.%s.%s", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.-.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity136() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("-", "1.0");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("1.0", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.-.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity137() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("-", EntityConstants.USERNAME_ENTITY_FIELD);

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("com.symphony.integration.-.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, actualToEntityResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity138() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("-", null);

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("com.symphony.integration.-.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getName());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity139() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("-", "42");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("42", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.-.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity140() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("-", "<br/>");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("<br/>", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.-.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity141() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("-", "");

    // Assert
    assertEquals("", actualToEntityResult.getName());
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("com.symphony.integration.-.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity142() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("-", "<a href=");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("<a href=", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.-.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity143() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity(EntityConstants.USER_ENTITY_FIELD, "\n");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("\n", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.user.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity144() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity(EntityConstants.USER_ENTITY_FIELD,
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>",
        actualToEntityResult.getName());
    assertEquals("com.symphony.integration.user.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity145() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity(EntityConstants.USER_ENTITY_FIELD, "-");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("-", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.user.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity146() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity(EntityConstants.USER_ENTITY_FIELD, EntityConstants.USER_ENTITY_FIELD);

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("com.symphony.integration.user.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ENTITY_FIELD, actualToEntityResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity147() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity(EntityConstants.USER_ENTITY_FIELD, "com.symphony.integration.%s.%s");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("com.symphony.integration.%s.%s", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.user.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity148() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity(EntityConstants.USER_ENTITY_FIELD, "1.0");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("1.0", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.user.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity149() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity(EntityConstants.USER_ENTITY_FIELD,
        EntityConstants.USERNAME_ENTITY_FIELD);

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("com.symphony.integration.user.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, actualToEntityResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity150() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity(EntityConstants.USER_ENTITY_FIELD, null);

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("com.symphony.integration.user.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getName());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity151() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity(EntityConstants.USER_ENTITY_FIELD, "42");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("42", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.user.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity152() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity(EntityConstants.USER_ENTITY_FIELD, "<br/>");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("<br/>", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.user.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity153() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity(EntityConstants.USER_ENTITY_FIELD, "");

    // Assert
    assertEquals("", actualToEntityResult.getName());
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("com.symphony.integration.user.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity154() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity(EntityConstants.USER_ENTITY_FIELD, "<a href=");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("<a href=", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.user.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity155() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("com.symphony.integration.%s.%s", "\n");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("\n", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.com.symphony.integration.%s.%s.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity156() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("com.symphony.integration.%s.%s",
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>",
        actualToEntityResult.getName());
    assertEquals("com.symphony.integration.com.symphony.integration.%s.%s.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity157() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("com.symphony.integration.%s.%s", "-");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("-", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.com.symphony.integration.%s.%s.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity158() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("com.symphony.integration.%s.%s", EntityConstants.USER_ENTITY_FIELD);

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("com.symphony.integration.com.symphony.integration.%s.%s.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ENTITY_FIELD, actualToEntityResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity159() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("com.symphony.integration.%s.%s", "com.symphony.integration.%s.%s");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("com.symphony.integration.%s.%s", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.com.symphony.integration.%s.%s.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity160() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("com.symphony.integration.%s.%s", "1.0");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("1.0", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.com.symphony.integration.%s.%s.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity161() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("com.symphony.integration.%s.%s",
        EntityConstants.USERNAME_ENTITY_FIELD);

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("com.symphony.integration.com.symphony.integration.%s.%s.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, actualToEntityResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity162() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("com.symphony.integration.%s.%s", null);

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("com.symphony.integration.com.symphony.integration.%s.%s.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getName());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity163() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("com.symphony.integration.%s.%s", "42");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("42", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.com.symphony.integration.%s.%s.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity164() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("com.symphony.integration.%s.%s", "<br/>");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("<br/>", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.com.symphony.integration.%s.%s.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity165() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("com.symphony.integration.%s.%s", "");

    // Assert
    assertEquals("", actualToEntityResult.getName());
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("com.symphony.integration.com.symphony.integration.%s.%s.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity166() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("com.symphony.integration.%s.%s", "<a href=");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("<a href=", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.com.symphony.integration.%s.%s.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity167() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("1.0", "\n");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("\n", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.1.0.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity168() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("1.0",
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>",
        actualToEntityResult.getName());
    assertEquals("com.symphony.integration.1.0.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity169() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("1.0", "-");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("-", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.1.0.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity170() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("1.0", EntityConstants.USER_ENTITY_FIELD);

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("com.symphony.integration.1.0.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ENTITY_FIELD, actualToEntityResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity171() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("1.0", "com.symphony.integration.%s.%s");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("com.symphony.integration.%s.%s", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.1.0.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity172() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("1.0", "1.0");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("1.0", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.1.0.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity173() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("1.0", EntityConstants.USERNAME_ENTITY_FIELD);

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("com.symphony.integration.1.0.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, actualToEntityResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity174() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("1.0", null);

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("com.symphony.integration.1.0.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getName());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity175() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("1.0", "42");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("42", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.1.0.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity176() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("1.0", "<br/>");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("<br/>", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.1.0.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity177() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("1.0", "");

    // Assert
    assertEquals("", actualToEntityResult.getName());
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("com.symphony.integration.1.0.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity178() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("1.0", "<a href=");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("<a href=", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.1.0.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity179() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity(EntityConstants.USERNAME_ENTITY_FIELD, "\n");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("\n", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.username.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity180() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity(EntityConstants.USERNAME_ENTITY_FIELD,
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>",
        actualToEntityResult.getName());
    assertEquals("com.symphony.integration.username.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity181() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity(EntityConstants.USERNAME_ENTITY_FIELD, "-");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("-", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.username.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity182() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity(EntityConstants.USERNAME_ENTITY_FIELD,
        EntityConstants.USER_ENTITY_FIELD);

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("com.symphony.integration.username.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ENTITY_FIELD, actualToEntityResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity183() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity(EntityConstants.USERNAME_ENTITY_FIELD,
        "com.symphony.integration.%s.%s");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("com.symphony.integration.%s.%s", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.username.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity184() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity(EntityConstants.USERNAME_ENTITY_FIELD, "1.0");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("1.0", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.username.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity185() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity(EntityConstants.USERNAME_ENTITY_FIELD,
        EntityConstants.USERNAME_ENTITY_FIELD);

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("com.symphony.integration.username.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, actualToEntityResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity186() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity(EntityConstants.USERNAME_ENTITY_FIELD, null);

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("com.symphony.integration.username.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getName());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity187() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity(EntityConstants.USERNAME_ENTITY_FIELD, "42");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("42", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.username.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity188() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity(EntityConstants.USERNAME_ENTITY_FIELD, "<br/>");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("<br/>", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.username.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity189() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity(EntityConstants.USERNAME_ENTITY_FIELD, "");

    // Assert
    assertEquals("", actualToEntityResult.getName());
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("com.symphony.integration.username.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity190() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity(EntityConstants.USERNAME_ENTITY_FIELD, "<a href=");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("<a href=", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.username.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity191() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("42", "\n");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("\n", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.42.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity192() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("42",
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>",
        actualToEntityResult.getName());
    assertEquals("com.symphony.integration.42.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity193() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("42", "-");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("-", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.42.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity194() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("42", EntityConstants.USER_ENTITY_FIELD);

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("com.symphony.integration.42.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ENTITY_FIELD, actualToEntityResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity195() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("42", "com.symphony.integration.%s.%s");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("com.symphony.integration.%s.%s", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.42.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity196() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("42", "1.0");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("1.0", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.42.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity197() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("42", EntityConstants.USERNAME_ENTITY_FIELD);

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("com.symphony.integration.42.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, actualToEntityResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity198() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("42", null);

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("com.symphony.integration.42.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getName());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity199() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("42", "42");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("42", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.42.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity200() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("42", "<br/>");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("<br/>", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.42.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity201() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("42", "");

    // Assert
    assertEquals("", actualToEntityResult.getName());
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("com.symphony.integration.42.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity202() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("42", "<a href=");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("<a href=", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.42.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity203() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("<br/>", "\n");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("\n", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.<br/>.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity204() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("<br/>",
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>",
        actualToEntityResult.getName());
    assertEquals("com.symphony.integration.<br/>.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity205() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("<br/>", "-");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("-", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.<br/>.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity206() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("<br/>", EntityConstants.USER_ENTITY_FIELD);

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("com.symphony.integration.<br/>.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ENTITY_FIELD, actualToEntityResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity207() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("<br/>", "com.symphony.integration.%s.%s");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("com.symphony.integration.%s.%s", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.<br/>.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity208() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("<br/>", "1.0");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("1.0", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.<br/>.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity209() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("<br/>", EntityConstants.USERNAME_ENTITY_FIELD);

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("com.symphony.integration.<br/>.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, actualToEntityResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity210() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("<br/>", null);

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("com.symphony.integration.<br/>.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getName());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity211() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("<br/>", "42");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("42", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.<br/>.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity212() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("<br/>", "<br/>");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("<br/>", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.<br/>.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity213() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("<br/>", "");

    // Assert
    assertEquals("", actualToEntityResult.getName());
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("com.symphony.integration.<br/>.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity214() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("<br/>", "<a href=");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("<a href=", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.<br/>.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity215() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("<a href=", "\n");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("\n", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.<a href=.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity216() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("<a href=",
        "<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>",
        actualToEntityResult.getName());
    assertEquals("com.symphony.integration.<a href=.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity217() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("<a href=", "-");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("-", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.<a href=.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity218() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("<a href=", EntityConstants.USER_ENTITY_FIELD);

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("com.symphony.integration.<a href=.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USER_ENTITY_FIELD, actualToEntityResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity219() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("<a href=", "com.symphony.integration.%s.%s");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("com.symphony.integration.%s.%s", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.<a href=.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity220() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("<a href=", "1.0");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("1.0", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.<a href=.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity221() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("<a href=", EntityConstants.USERNAME_ENTITY_FIELD);

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("com.symphony.integration.<a href=.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, actualToEntityResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity222() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("<a href=", null);

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("com.symphony.integration.<a href=.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getName());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity223() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("<a href=", "42");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("42", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.<a href=.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity224() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("<a href=", "<br/>");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("<br/>", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.<a href=.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity225() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("<a href=", "");

    // Assert
    assertEquals("", actualToEntityResult.getName());
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("com.symphony.integration.<a href=.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity226() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("<a href=", "<a href=");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("<a href=", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.<a href=.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
   * Method under test: {@link User#toEntity(String, String)}
   */
  @Test
  public void testToEntity227() {
    // Arrange
    User user = new User();
    user.setUserName("<  a  href  =  \"http://UUUUUUUUUUUU//UU&amp;&amp;//UU&amp;&amp;\"  >xx</a>");

    // Act
    Entity actualToEntityResult = user.toEntity("Integration Name", "/>");

    // Assert
    List<Attribute> attributes = actualToEntityResult.getAttributes();
    assertEquals(1, attributes.size());
    Attribute getResult = attributes.get(0);
    assertEquals(
        "&lt;  a  href  =  &quot;<a href=\"http://UUUUUUUUUUUU//UU&amp;amp\">http://UUUUUUUUUUUU//UU&amp;amp</a"
            + ">;&amp;amp;//UU&amp;amp;&amp;amp;&quot;  &gt;xx&lt;/a&gt;",
        getResult.getValue());
    assertEquals("/>", actualToEntityResult.getName());
    assertEquals("com.symphony.integration.Integration Name.user", actualToEntityResult.getType());
    assertNull(actualToEntityResult.getPresentationML());
    assertTrue(actualToEntityResult.getEntities().isEmpty());
    assertEquals(EntityConstants.USERNAME_ENTITY_FIELD, getResult.getName());
  }

  /**
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

    // Assert that nothing has changed
    assertEquals("42 Main St", actualEmailAddress);
    assertEquals("Display Name", actualDisplayName);
    assertEquals("janedoe", actualUser.getUsername());
    assertEquals(1L, actualId.longValue());
  }
}
