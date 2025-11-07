package org.symphonyoss.integration.parser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class SafeStringUtilsDiffblueTest {
  /**
   * Method under test: {@link SafeStringUtils#escapeAmpersand(String)}
   */
  @Test
  public void testEscapeAmpersand() {
    // Arrange, Act and Assert
    assertEquals("String", SafeStringUtils.escapeAmpersand("String"));
    assertNull(SafeStringUtils.escapeAmpersand(null));
    assertEquals("&amp;", SafeStringUtils.escapeAmpersand("&"));
    assertEquals("&amp;(?!.{2,4};)", SafeStringUtils.escapeAmpersand("&(?!.{2,4};)"));
    assertEquals("&amp;&amp;", SafeStringUtils.escapeAmpersand("&&"));
    assertEquals("&amp;&amp;(?!.{2,4};)", SafeStringUtils.escapeAmpersand("&&(?!.{2,4};)"));
    assertEquals("&amp;String", SafeStringUtils.escapeAmpersand("&String"));
    assertEquals("&amp;42", SafeStringUtils.escapeAmpersand("&42"));
    assertEquals("&amp;(?!.{2,4};)&amp;", SafeStringUtils.escapeAmpersand("&(?!.{2,4};)&"));
    assertEquals("&amp;(?!.{2,4};)&amp;(?!.{2,4};)", SafeStringUtils.escapeAmpersand("&(?!.{2,4};)&(?!.{2,4};)"));
    assertEquals("&amp;(?!.{2,4};)&amp;", SafeStringUtils.escapeAmpersand("&(?!.{2,4};)&amp;"));
    assertEquals("&amp;(?!.{2,4};)String", SafeStringUtils.escapeAmpersand("&(?!.{2,4};)String"));
    assertEquals("&amp;(?!.{2,4};)42", SafeStringUtils.escapeAmpersand("&(?!.{2,4};)42"));
    assertEquals("&amp;&amp;", SafeStringUtils.escapeAmpersand("&amp;&"));
    assertEquals("&amp;&amp;(?!.{2,4};)", SafeStringUtils.escapeAmpersand("&amp;&(?!.{2,4};)"));
    assertEquals("String&amp;", SafeStringUtils.escapeAmpersand("String&"));
    assertEquals("String&amp;(?!.{2,4};)", SafeStringUtils.escapeAmpersand("String&(?!.{2,4};)"));
    assertEquals("42&amp;", SafeStringUtils.escapeAmpersand("42&"));
    assertEquals("42&amp;(?!.{2,4};)", SafeStringUtils.escapeAmpersand("42&(?!.{2,4};)"));
    assertEquals("&amp;&amp;&amp;", SafeStringUtils.escapeAmpersand("&&&"));
    assertEquals("&amp;&amp;&amp;(?!.{2,4};)", SafeStringUtils.escapeAmpersand("&&&(?!.{2,4};)"));
    assertEquals("&amp;&&amp;", SafeStringUtils.escapeAmpersand("&&&amp;"));
    assertEquals("&amp;&amp;String", SafeStringUtils.escapeAmpersand("&&String"));
    assertEquals("&amp;&amp;42", SafeStringUtils.escapeAmpersand("&&42"));
    assertEquals("&amp;&amp;(?!.{2,4};)&amp;", SafeStringUtils.escapeAmpersand("&&(?!.{2,4};)&"));
    assertEquals("&amp;&amp;(?!.{2,4};)&amp;(?!.{2,4};)", SafeStringUtils.escapeAmpersand("&&(?!.{2,4};)&(?!.{2,4};)"));
    assertEquals("&amp;&amp;(?!.{2,4};)&amp;", SafeStringUtils.escapeAmpersand("&&(?!.{2,4};)&amp;"));
    assertEquals("&amp;&amp;(?!.{2,4};)String", SafeStringUtils.escapeAmpersand("&&(?!.{2,4};)String"));
    assertEquals("&amp;&amp;(?!.{2,4};)42", SafeStringUtils.escapeAmpersand("&&(?!.{2,4};)42"));
    assertEquals("&&amp;&amp;", SafeStringUtils.escapeAmpersand("&&amp;&"));
    assertEquals("&&amp;&amp;(?!.{2,4};)", SafeStringUtils.escapeAmpersand("&&amp;&(?!.{2,4};)"));
    assertEquals("&amp;String&amp;", SafeStringUtils.escapeAmpersand("&String&"));
    assertEquals("&amp;String&amp;(?!.{2,4};)", SafeStringUtils.escapeAmpersand("&String&(?!.{2,4};)"));
    assertEquals("&amp;String&amp;", SafeStringUtils.escapeAmpersand("&String&amp;"));
    assertEquals("&amp;StringString", SafeStringUtils.escapeAmpersand("&StringString"));
    assertEquals("&amp;String42", SafeStringUtils.escapeAmpersand("&String42"));
    assertEquals("&amp;42&amp;", SafeStringUtils.escapeAmpersand("&42&"));
    assertEquals("&amp;42&amp;(?!.{2,4};)", SafeStringUtils.escapeAmpersand("&42&(?!.{2,4};)"));
    assertEquals("&amp;42&amp;", SafeStringUtils.escapeAmpersand("&42&amp;"));
    assertEquals("&amp;42String", SafeStringUtils.escapeAmpersand("&42String"));
    assertEquals("&amp;4242", SafeStringUtils.escapeAmpersand("&4242"));
    assertEquals("&amp;(?!.{2,4};)&amp;&amp;", SafeStringUtils.escapeAmpersand("&(?!.{2,4};)&&"));
    assertEquals("&amp;(?!.{2,4};)&amp;&amp;(?!.{2,4};)", SafeStringUtils.escapeAmpersand("&(?!.{2,4};)&&(?!.{2,4};)"));
    assertEquals("&amp;(?!.{2,4};)&&amp;", SafeStringUtils.escapeAmpersand("&(?!.{2,4};)&&amp;"));
    assertEquals("&amp;(?!.{2,4};)&amp;String", SafeStringUtils.escapeAmpersand("&(?!.{2,4};)&String"));
    assertEquals("&amp;(?!.{2,4};)&amp;42", SafeStringUtils.escapeAmpersand("&(?!.{2,4};)&42"));
    assertEquals("&amp;(?!.{2,4};)&amp;(?!.{2,4};)&amp;", SafeStringUtils.escapeAmpersand("&(?!.{2,4};)&(?!.{2,4};)&"));
    assertEquals("&amp;(?!.{2,4};)&amp;(?!.{2,4};)&amp;(?!.{2,4};)",
        SafeStringUtils.escapeAmpersand("&(?!.{2,4};)&(?!.{2,4};)&(?!.{2,4};)"));
    assertEquals("&amp;(?!.{2,4};)&amp;(?!.{2,4};)&amp;",
        SafeStringUtils.escapeAmpersand("&(?!.{2,4};)&(?!.{2,4};)&amp;"));
    assertEquals("&amp;(?!.{2,4};)&amp;(?!.{2,4};)String",
        SafeStringUtils.escapeAmpersand("&(?!.{2,4};)&(?!.{2,4};)String"));
    assertEquals("&amp;(?!.{2,4};)&amp;(?!.{2,4};)42", SafeStringUtils.escapeAmpersand("&(?!.{2,4};)&(?!.{2,4};)42"));
    assertEquals("&amp;(?!.{2,4};)&amp;&amp;", SafeStringUtils.escapeAmpersand("&(?!.{2,4};)&amp;&"));
    assertEquals("&amp;(?!.{2,4};)&amp;&amp;(?!.{2,4};)",
        SafeStringUtils.escapeAmpersand("&(?!.{2,4};)&amp;&(?!.{2,4};)"));
    assertEquals("&amp;(?!.{2,4};)&amp;&amp;", SafeStringUtils.escapeAmpersand("&(?!.{2,4};)&amp;&amp;"));
    assertEquals("&amp;(?!.{2,4};)&amp;String", SafeStringUtils.escapeAmpersand("&(?!.{2,4};)&amp;String"));
    assertEquals("&amp;(?!.{2,4};)&amp;42", SafeStringUtils.escapeAmpersand("&(?!.{2,4};)&amp;42"));
    assertEquals("&amp;(?!.{2,4};)String&amp;", SafeStringUtils.escapeAmpersand("&(?!.{2,4};)String&"));
    assertEquals("&amp;(?!.{2,4};)String&amp;(?!.{2,4};)",
        SafeStringUtils.escapeAmpersand("&(?!.{2,4};)String&(?!.{2,4};)"));
    assertEquals("&amp;(?!.{2,4};)String&amp;", SafeStringUtils.escapeAmpersand("&(?!.{2,4};)String&amp;"));
    assertEquals("&amp;(?!.{2,4};)StringString", SafeStringUtils.escapeAmpersand("&(?!.{2,4};)StringString"));
    assertEquals("&amp;(?!.{2,4};)String42", SafeStringUtils.escapeAmpersand("&(?!.{2,4};)String42"));
    assertEquals("&amp;(?!.{2,4};)42&amp;", SafeStringUtils.escapeAmpersand("&(?!.{2,4};)42&"));
    assertEquals("&amp;(?!.{2,4};)42&amp;(?!.{2,4};)", SafeStringUtils.escapeAmpersand("&(?!.{2,4};)42&(?!.{2,4};)"));
    assertEquals("&amp;(?!.{2,4};)42&amp;", SafeStringUtils.escapeAmpersand("&(?!.{2,4};)42&amp;"));
    assertEquals("&amp;(?!.{2,4};)42String", SafeStringUtils.escapeAmpersand("&(?!.{2,4};)42String"));
    assertEquals("&amp;(?!.{2,4};)4242", SafeStringUtils.escapeAmpersand("&(?!.{2,4};)4242"));
    assertEquals("&amp;&amp;&amp;", SafeStringUtils.escapeAmpersand("&amp;&&"));
    assertEquals("&amp;&amp;&amp;(?!.{2,4};)", SafeStringUtils.escapeAmpersand("&amp;&&(?!.{2,4};)"));
    assertEquals("&amp;&amp;String", SafeStringUtils.escapeAmpersand("&amp;&String"));
    assertEquals("&amp;&amp;42", SafeStringUtils.escapeAmpersand("&amp;&42"));
    assertEquals("&amp;&amp;(?!.{2,4};)&amp;", SafeStringUtils.escapeAmpersand("&amp;&(?!.{2,4};)&"));
    assertEquals("&amp;&amp;(?!.{2,4};)&amp;(?!.{2,4};)",
        SafeStringUtils.escapeAmpersand("&amp;&(?!.{2,4};)&(?!.{2,4};)"));
    assertEquals("&amp;&amp;(?!.{2,4};)&amp;", SafeStringUtils.escapeAmpersand("&amp;&(?!.{2,4};)&amp;"));
    assertEquals("&amp;&amp;(?!.{2,4};)String", SafeStringUtils.escapeAmpersand("&amp;&(?!.{2,4};)String"));
    assertEquals("&amp;&amp;(?!.{2,4};)42", SafeStringUtils.escapeAmpersand("&amp;&(?!.{2,4};)42"));
    assertEquals("&amp;&amp;&amp;", SafeStringUtils.escapeAmpersand("&amp;&amp;&"));
    assertEquals("&amp;&amp;&amp;(?!.{2,4};)", SafeStringUtils.escapeAmpersand("&amp;&amp;&(?!.{2,4};)"));
    assertEquals("&amp;String&amp;", SafeStringUtils.escapeAmpersand("&amp;String&"));
    assertEquals("&amp;String&amp;(?!.{2,4};)", SafeStringUtils.escapeAmpersand("&amp;String&(?!.{2,4};)"));
    assertEquals("&amp;42&amp;", SafeStringUtils.escapeAmpersand("&amp;42&"));
    assertEquals("&amp;42&amp;(?!.{2,4};)", SafeStringUtils.escapeAmpersand("&amp;42&(?!.{2,4};)"));
    assertEquals("String&amp;&amp;", SafeStringUtils.escapeAmpersand("String&&"));
    assertEquals("String&amp;&amp;(?!.{2,4};)", SafeStringUtils.escapeAmpersand("String&&(?!.{2,4};)"));
    assertEquals("String&amp;String", SafeStringUtils.escapeAmpersand("String&String"));
    assertEquals("String&amp;42", SafeStringUtils.escapeAmpersand("String&42"));
    assertEquals("String&amp;(?!.{2,4};)&amp;", SafeStringUtils.escapeAmpersand("String&(?!.{2,4};)&"));
    assertEquals("String&amp;(?!.{2,4};)&amp;(?!.{2,4};)",
        SafeStringUtils.escapeAmpersand("String&(?!.{2,4};)&(?!.{2,4};)"));
    assertEquals("String&amp;(?!.{2,4};)&amp;", SafeStringUtils.escapeAmpersand("String&(?!.{2,4};)&amp;"));
    assertEquals("String&amp;(?!.{2,4};)String", SafeStringUtils.escapeAmpersand("String&(?!.{2,4};)String"));
    assertEquals("String&amp;(?!.{2,4};)42", SafeStringUtils.escapeAmpersand("String&(?!.{2,4};)42"));
    assertEquals("String&amp;&amp;", SafeStringUtils.escapeAmpersand("String&amp;&"));
    assertEquals("String&amp;&amp;(?!.{2,4};)", SafeStringUtils.escapeAmpersand("String&amp;&(?!.{2,4};)"));
    assertEquals("StringString&amp;", SafeStringUtils.escapeAmpersand("StringString&"));
    assertEquals("StringString&amp;(?!.{2,4};)", SafeStringUtils.escapeAmpersand("StringString&(?!.{2,4};)"));
    assertEquals("String42&amp;", SafeStringUtils.escapeAmpersand("String42&"));
    assertEquals("String42&amp;(?!.{2,4};)", SafeStringUtils.escapeAmpersand("String42&(?!.{2,4};)"));
    assertEquals("42&amp;&amp;", SafeStringUtils.escapeAmpersand("42&&"));
    assertEquals("42&amp;&amp;(?!.{2,4};)", SafeStringUtils.escapeAmpersand("42&&(?!.{2,4};)"));
    assertEquals("42&amp;String", SafeStringUtils.escapeAmpersand("42&String"));
    assertEquals("42&amp;42", SafeStringUtils.escapeAmpersand("42&42"));
    assertEquals("42&amp;(?!.{2,4};)&amp;", SafeStringUtils.escapeAmpersand("42&(?!.{2,4};)&"));
    assertEquals("42&amp;(?!.{2,4};)&amp;(?!.{2,4};)", SafeStringUtils.escapeAmpersand("42&(?!.{2,4};)&(?!.{2,4};)"));
    assertEquals("42&amp;(?!.{2,4};)&amp;", SafeStringUtils.escapeAmpersand("42&(?!.{2,4};)&amp;"));
    assertEquals("42&amp;(?!.{2,4};)String", SafeStringUtils.escapeAmpersand("42&(?!.{2,4};)String"));
    assertEquals("42&amp;(?!.{2,4};)42", SafeStringUtils.escapeAmpersand("42&(?!.{2,4};)42"));
    assertEquals("42&amp;&amp;", SafeStringUtils.escapeAmpersand("42&amp;&"));
    assertEquals("42&amp;&amp;(?!.{2,4};)", SafeStringUtils.escapeAmpersand("42&amp;&(?!.{2,4};)"));
    assertEquals("42String&amp;", SafeStringUtils.escapeAmpersand("42String&"));
    assertEquals("42String&amp;(?!.{2,4};)", SafeStringUtils.escapeAmpersand("42String&(?!.{2,4};)"));
    assertEquals("4242&amp;", SafeStringUtils.escapeAmpersand("4242&"));
    assertEquals("4242&amp;(?!.{2,4};)", SafeStringUtils.escapeAmpersand("4242&(?!.{2,4};)"));
  }

  /**
   * Method under test: {@link SafeStringUtils#stringValueOf(SafeString)}
   */
  @Test
  public void testStringValueOf() {
    // Arrange, Act and Assert
    assertNull(SafeStringUtils.stringValueOf(null));
  }

  /**
   * Method under test: {@link SafeStringUtils#isEmpty(SafeString)}
   */
  @Test
  public void testIsEmpty() {
    // Arrange, Act and Assert
    assertTrue(SafeStringUtils.isEmpty(null));
    assertTrue(SafeStringUtils.isEmpty(ParserUtils.escapeAndAddLineBreaks("")));
  }

  /**
   * Method under test: {@link SafeStringUtils#isBlank(SafeString)}
   */
  @Test
  public void testIsBlank() {
    // Arrange, Act and Assert
    assertTrue(SafeStringUtils.isBlank(null));
    assertTrue(SafeStringUtils.isBlank(ParserUtils.escapeAndAddLineBreaks("")));
  }

  /**
   * Method under test: {@link SafeStringUtils#isAnyBlank(SafeString[])}
   */
  @Test
  public void testIsAnyBlank() {
    // Arrange, Act and Assert
    assertTrue(SafeStringUtils.isAnyBlank(null));
    assertTrue(SafeStringUtils.isAnyBlank(null));
    assertTrue(SafeStringUtils.isAnyBlank());
    assertTrue(SafeStringUtils.isAnyBlank(ParserUtils.escapeAndAddLineBreaks("")));
  }

  /**
   * Method under test: {@link SafeStringUtils#concat(SafeString[])}
   */
  @Test
  public void testConcat() {
    // Arrange, Act and Assert
    assertEquals("", SafeStringUtils.concat(null).toString());
    assertEquals("", SafeStringUtils.concat(null).toString());
  }
}
