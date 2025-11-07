package org.symphonyoss.integration.parser.model;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class HashTagDiffblueTest {
  /**
   * Method under test: {@link HashTag#HashTag(String)}
   */
  @Test
  public void testNewHashTag() {
    // Arrange, Act and Assert
    assertEquals("<hash tag=\"Hashtag\"/>", (new HashTag("Hashtag")).toString());
    assertEquals("", (new HashTag(null)).toString());
    assertEquals("", (new HashTag("")).toString());
  }

  /**
   * Method under test: {@link HashTag#toString()}
   */
  @Test
  public void testToString() {
    // Arrange, Act and Assert
    assertEquals("<hash tag=\"Hashtag\"/>", (new HashTag("Hashtag")).toString());
  }
}
