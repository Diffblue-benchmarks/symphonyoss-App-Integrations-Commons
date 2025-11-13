package org.symphonyoss.integration.parser.model;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;

public class HashTagDiffblueTest {
  /**
   * Test {@link HashTag#HashTag(String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return toString is empty string.
   * </ul>
   *
   * <p>Method under test: {@link HashTag#HashTag(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"void HashTag.<init>(String)"})
  public void testNewHashTag_whenEmptyString_thenReturnToStringIsEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", new HashTag("").toString());
  }

  /**
   * Test {@link HashTag#HashTag(String)}.
   *
   * <ul>
   *   <li>When {@code Hashtag}.
   *   <li>Then return toString is {@code <hash tag="Hashtag"/>}.
   * </ul>
   *
   * <p>Method under test: {@link HashTag#HashTag(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"void HashTag.<init>(String)"})
  public void testNewHashTag_whenHashtag_thenReturnToStringIsHashTagHashtag() {
    // Arrange, Act and Assert
    assertEquals("<hash tag=\"Hashtag\"/>", new HashTag("Hashtag").toString());
  }

  /**
   * Test {@link HashTag#HashTag(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return toString is empty string.
   * </ul>
   *
   * <p>Method under test: {@link HashTag#HashTag(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"void HashTag.<init>(String)"})
  public void testNewHashTag_whenNull_thenReturnToStringIsEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", new HashTag(null).toString());
  }

  /**
   * Test {@link HashTag#HashTag(String)}.
   *
   * <ul>
   *   <li>When space.
   *   <li>Then return toString is empty string.
   * </ul>
   *
   * <p>Method under test: {@link HashTag#HashTag(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"void HashTag.<init>(String)"})
  public void testNewHashTag_whenSpace_thenReturnToStringIsEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", new HashTag(" ").toString());
  }

  /**
   * Test {@link HashTag#toString()}.
   *
   * <p>Method under test: {@link HashTag#toString()}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String HashTag.toString()"})
  public void testToString() {
    // Arrange, Act and Assert
    assertEquals("<hash tag=\"Hashtag\"/>", new HashTag("Hashtag").toString());
  }
}
