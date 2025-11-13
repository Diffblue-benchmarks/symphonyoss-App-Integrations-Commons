package org.symphonyoss.integration.parser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;

public class SafeStringUtilsDiffblueTest {
  /**
   * Test {@link SafeStringUtils#escapeAmpersand(String)}.
   *
   * <ul>
   *   <li>When {@code &(?!.{2,4};)&amp;&(?!.{2,4};)}.
   *   <li>Then return {@code &amp;(?!.{2,4};)&amp;&amp;(?!.{2,4};)}.
   * </ul>
   *
   * <p>Method under test: {@link SafeStringUtils#escapeAmpersand(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String SafeStringUtils.escapeAmpersand(String)"})
  public void testEscapeAmpersand_when24Amp24_thenReturnAmp24AmpAmp24() {
    // Arrange, Act and Assert
    assertEquals(
        "&amp;(?!.{2,4};)&amp;&amp;(?!.{2,4};)",
        SafeStringUtils.escapeAmpersand("&(?!.{2,4};)&amp;&(?!.{2,4};)"));
  }

  /**
   * Test {@link SafeStringUtils#escapeAmpersand(String)}.
   *
   * <ul>
   *   <li>When {@code &(?!.{2,4};)&amp;42}.
   *   <li>Then return {@code &amp;(?!.{2,4};)&amp;42}.
   * </ul>
   *
   * <p>Method under test: {@link SafeStringUtils#escapeAmpersand(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String SafeStringUtils.escapeAmpersand(String)"})
  public void testEscapeAmpersand_when24Amp42_thenReturnAmp24Amp42() {
    // Arrange, Act and Assert
    assertEquals("&amp;(?!.{2,4};)&amp;42", SafeStringUtils.escapeAmpersand("&(?!.{2,4};)&amp;42"));
  }

  /**
   * Test {@link SafeStringUtils#escapeAmpersand(String)}.
   *
   * <ul>
   *   <li>When {@code &(?!.{2,4};)&amp;&amp;}.
   *   <li>Then return {@code &amp;(?!.{2,4};)&amp;&amp;}.
   * </ul>
   *
   * <p>Method under test: {@link SafeStringUtils#escapeAmpersand(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String SafeStringUtils.escapeAmpersand(String)"})
  public void testEscapeAmpersand_when24AmpAmp_thenReturnAmp24AmpAmp() {
    // Arrange, Act and Assert
    assertEquals(
        "&amp;(?!.{2,4};)&amp;&amp;", SafeStringUtils.escapeAmpersand("&(?!.{2,4};)&amp;&amp;"));
  }

  /**
   * Test {@link SafeStringUtils#escapeAmpersand(String)}.
   *
   * <ul>
   *   <li>When {@code &(?!.{2,4};)&amp;String}.
   *   <li>Then return {@code &amp;(?!.{2,4};)&amp;String}.
   * </ul>
   *
   * <p>Method under test: {@link SafeStringUtils#escapeAmpersand(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String SafeStringUtils.escapeAmpersand(String)"})
  public void testEscapeAmpersand_when24AmpString_thenReturnAmp24AmpString() {
    // Arrange, Act and Assert
    assertEquals(
        "&amp;(?!.{2,4};)&amp;String", SafeStringUtils.escapeAmpersand("&(?!.{2,4};)&amp;String"));
  }

  /**
   * Test {@link SafeStringUtils#escapeAmpersand(String)}.
   *
   * <ul>
   *   <li>When {@code &(?!.{2,4};)&amp;}.
   *   <li>Then return {@code &amp;(?!.{2,4};)&amp;}.
   * </ul>
   *
   * <p>Method under test: {@link SafeStringUtils#escapeAmpersand(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String SafeStringUtils.escapeAmpersand(String)"})
  public void testEscapeAmpersand_when24Amp_thenReturnAmp24Amp() {
    // Arrange, Act and Assert
    assertEquals("&amp;(?!.{2,4};)&amp;", SafeStringUtils.escapeAmpersand("&(?!.{2,4};)&amp;"));
  }

  /**
   * Test {@link SafeStringUtils#escapeAmpersand(String)}.
   *
   * <ul>
   *   <li>When {@code &(?!.{2,4};)&&amp;}.
   *   <li>Then return {@code &amp;(?!.{2,4};)&&amp;}.
   * </ul>
   *
   * <p>Method under test: {@link SafeStringUtils#escapeAmpersand(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String SafeStringUtils.escapeAmpersand(String)"})
  public void testEscapeAmpersand_when24Amp_thenReturnAmp24Amp2() {
    // Arrange, Act and Assert
    assertEquals("&amp;(?!.{2,4};)&&amp;", SafeStringUtils.escapeAmpersand("&(?!.{2,4};)&&amp;"));
  }

  /**
   * Test {@link SafeStringUtils#escapeAmpersand(String)}.
   *
   * <ul>
   *   <li>When {@code &(?!.{2,4};)&amp;&}.
   *   <li>Then return {@code &amp;(?!.{2,4};)&amp;&amp;}.
   * </ul>
   *
   * <p>Method under test: {@link SafeStringUtils#escapeAmpersand(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String SafeStringUtils.escapeAmpersand(String)"})
  public void testEscapeAmpersand_when24Amp_thenReturnAmp24AmpAmp() {
    // Arrange, Act and Assert
    assertEquals(
        "&amp;(?!.{2,4};)&amp;&amp;", SafeStringUtils.escapeAmpersand("&(?!.{2,4};)&amp;&"));
  }

  /**
   * Test {@link SafeStringUtils#escapeAmpersand(String)}.
   *
   * <ul>
   *   <li>When {@code &&(?!.{2,4};)&amp;}.
   *   <li>Then return {@code &amp;&amp;(?!.{2,4};)&amp;}.
   * </ul>
   *
   * <p>Method under test: {@link SafeStringUtils#escapeAmpersand(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String SafeStringUtils.escapeAmpersand(String)"})
  public void testEscapeAmpersand_when24Amp_thenReturnAmpAmp24Amp() {
    // Arrange, Act and Assert
    assertEquals(
        "&amp;&amp;(?!.{2,4};)&amp;", SafeStringUtils.escapeAmpersand("&&(?!.{2,4};)&amp;"));
  }

  /**
   * Test {@link SafeStringUtils#escapeAmpersand(String)}.
   *
   * <ul>
   *   <li>When {@code &(?!.{2,4};)String&(?!.{2,4};)}.
   *   <li>Then return {@code &amp;(?!.{2,4};)String&amp;(?!.{2,4};)}.
   * </ul>
   *
   * <p>Method under test: {@link SafeStringUtils#escapeAmpersand(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String SafeStringUtils.escapeAmpersand(String)"})
  public void testEscapeAmpersand_when24String24_thenReturnAmp24StringAmp24() {
    // Arrange, Act and Assert
    assertEquals(
        "&amp;(?!.{2,4};)String&amp;(?!.{2,4};)",
        SafeStringUtils.escapeAmpersand("&(?!.{2,4};)String&(?!.{2,4};)"));
  }

  /**
   * Test {@link SafeStringUtils#escapeAmpersand(String)}.
   *
   * <ul>
   *   <li>When {@code &(?!.{2,4};)String42}.
   *   <li>Then return {@code &amp;(?!.{2,4};)String42}.
   * </ul>
   *
   * <p>Method under test: {@link SafeStringUtils#escapeAmpersand(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String SafeStringUtils.escapeAmpersand(String)"})
  public void testEscapeAmpersand_when24String42_thenReturnAmp24String42() {
    // Arrange, Act and Assert
    assertEquals(
        "&amp;(?!.{2,4};)String42", SafeStringUtils.escapeAmpersand("&(?!.{2,4};)String42"));
  }

  /**
   * Test {@link SafeStringUtils#escapeAmpersand(String)}.
   *
   * <ul>
   *   <li>When {@code &(?!.{2,4};)String&amp;}.
   *   <li>Then return {@code &amp;(?!.{2,4};)String&amp;}.
   * </ul>
   *
   * <p>Method under test: {@link SafeStringUtils#escapeAmpersand(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String SafeStringUtils.escapeAmpersand(String)"})
  public void testEscapeAmpersand_when24StringAmp_thenReturnAmp24StringAmp() {
    // Arrange, Act and Assert
    assertEquals(
        "&amp;(?!.{2,4};)String&amp;", SafeStringUtils.escapeAmpersand("&(?!.{2,4};)String&amp;"));
  }

  /**
   * Test {@link SafeStringUtils#escapeAmpersand(String)}.
   *
   * <ul>
   *   <li>When {@code &(?!.{2,4};)StringString}.
   *   <li>Then return {@code &amp;(?!.{2,4};)StringString}.
   * </ul>
   *
   * <p>Method under test: {@link SafeStringUtils#escapeAmpersand(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String SafeStringUtils.escapeAmpersand(String)"})
  public void testEscapeAmpersand_when24StringString_thenReturnAmp24StringString() {
    // Arrange, Act and Assert
    assertEquals(
        "&amp;(?!.{2,4};)StringString",
        SafeStringUtils.escapeAmpersand("&(?!.{2,4};)StringString"));
  }

  /**
   * Test {@link SafeStringUtils#escapeAmpersand(String)}.
   *
   * <ul>
   *   <li>When {@code &(?!.{2,4};)&String}.
   *   <li>Then return {@code &amp;(?!.{2,4};)&amp;String}.
   * </ul>
   *
   * <p>Method under test: {@link SafeStringUtils#escapeAmpersand(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String SafeStringUtils.escapeAmpersand(String)"})
  public void testEscapeAmpersand_when24String_thenReturnAmp24AmpString() {
    // Arrange, Act and Assert
    assertEquals(
        "&amp;(?!.{2,4};)&amp;String", SafeStringUtils.escapeAmpersand("&(?!.{2,4};)&String"));
  }

  /**
   * Test {@link SafeStringUtils#escapeAmpersand(String)}.
   *
   * <ul>
   *   <li>When {@code &(?!.{2,4};)String}.
   *   <li>Then return {@code &amp;(?!.{2,4};)String}.
   * </ul>
   *
   * <p>Method under test: {@link SafeStringUtils#escapeAmpersand(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String SafeStringUtils.escapeAmpersand(String)"})
  public void testEscapeAmpersand_when24String_thenReturnAmp24String() {
    // Arrange, Act and Assert
    assertEquals("&amp;(?!.{2,4};)String", SafeStringUtils.escapeAmpersand("&(?!.{2,4};)String"));
  }

  /**
   * Test {@link SafeStringUtils#escapeAmpersand(String)}.
   *
   * <ul>
   *   <li>When {@code &(?!.{2,4};)String&}.
   *   <li>Then return {@code &amp;(?!.{2,4};)String&amp;}.
   * </ul>
   *
   * <p>Method under test: {@link SafeStringUtils#escapeAmpersand(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String SafeStringUtils.escapeAmpersand(String)"})
  public void testEscapeAmpersand_when24String_thenReturnAmp24StringAmp() {
    // Arrange, Act and Assert
    assertEquals(
        "&amp;(?!.{2,4};)String&amp;", SafeStringUtils.escapeAmpersand("&(?!.{2,4};)String&"));
  }

  /**
   * Test {@link SafeStringUtils#escapeAmpersand(String)}.
   *
   * <ul>
   *   <li>When {@code &&(?!.{2,4};)String}.
   *   <li>Then return {@code &amp;&amp;(?!.{2,4};)String}.
   * </ul>
   *
   * <p>Method under test: {@link SafeStringUtils#escapeAmpersand(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String SafeStringUtils.escapeAmpersand(String)"})
  public void testEscapeAmpersand_when24String_thenReturnAmpAmp24String() {
    // Arrange, Act and Assert
    assertEquals(
        "&amp;&amp;(?!.{2,4};)String", SafeStringUtils.escapeAmpersand("&&(?!.{2,4};)String"));
  }

  /**
   * Test {@link SafeStringUtils#escapeAmpersand(String)}.
   *
   * <ul>
   *   <li>When {@code &(?!.{2,4};)}.
   *   <li>Then return {@code &amp;(?!.{2,4};)}.
   * </ul>
   *
   * <p>Method under test: {@link SafeStringUtils#escapeAmpersand(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String SafeStringUtils.escapeAmpersand(String)"})
  public void testEscapeAmpersand_when24_thenReturnAmp24() {
    // Arrange, Act and Assert
    assertEquals("&amp;(?!.{2,4};)", SafeStringUtils.escapeAmpersand("&(?!.{2,4};)"));
  }

  /**
   * Test {@link SafeStringUtils#escapeAmpersand(String)}.
   *
   * <ul>
   *   <li>When {@code &(?!.{2,4};)&}.
   *   <li>Then return {@code &amp;(?!.{2,4};)&amp;}.
   * </ul>
   *
   * <p>Method under test: {@link SafeStringUtils#escapeAmpersand(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String SafeStringUtils.escapeAmpersand(String)"})
  public void testEscapeAmpersand_when24_thenReturnAmp24Amp() {
    // Arrange, Act and Assert
    assertEquals("&amp;(?!.{2,4};)&amp;", SafeStringUtils.escapeAmpersand("&(?!.{2,4};)&"));
  }

  /**
   * Test {@link SafeStringUtils#escapeAmpersand(String)}.
   *
   * <ul>
   *   <li>When {@code &(?!.{2,4};)&&}.
   *   <li>Then return {@code &amp;(?!.{2,4};)&amp;&amp;}.
   * </ul>
   *
   * <p>Method under test: {@link SafeStringUtils#escapeAmpersand(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String SafeStringUtils.escapeAmpersand(String)"})
  public void testEscapeAmpersand_when24_thenReturnAmp24AmpAmp() {
    // Arrange, Act and Assert
    assertEquals("&amp;(?!.{2,4};)&amp;&amp;", SafeStringUtils.escapeAmpersand("&(?!.{2,4};)&&"));
  }

  /**
   * Test {@link SafeStringUtils#escapeAmpersand(String)}.
   *
   * <ul>
   *   <li>When {@code &&(?!.{2,4};)}.
   *   <li>Then return {@code &amp;&amp;(?!.{2,4};)}.
   * </ul>
   *
   * <p>Method under test: {@link SafeStringUtils#escapeAmpersand(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String SafeStringUtils.escapeAmpersand(String)"})
  public void testEscapeAmpersand_when24_thenReturnAmpAmp24() {
    // Arrange, Act and Assert
    assertEquals("&amp;&amp;(?!.{2,4};)", SafeStringUtils.escapeAmpersand("&&(?!.{2,4};)"));
  }

  /**
   * Test {@link SafeStringUtils#escapeAmpersand(String)}.
   *
   * <ul>
   *   <li>When {@code &&(?!.{2,4};)&}.
   *   <li>Then return {@code &amp;&amp;(?!.{2,4};)&amp;}.
   * </ul>
   *
   * <p>Method under test: {@link SafeStringUtils#escapeAmpersand(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String SafeStringUtils.escapeAmpersand(String)"})
  public void testEscapeAmpersand_when24_thenReturnAmpAmp24Amp() {
    // Arrange, Act and Assert
    assertEquals("&amp;&amp;(?!.{2,4};)&amp;", SafeStringUtils.escapeAmpersand("&&(?!.{2,4};)&"));
  }

  /**
   * Test {@link SafeStringUtils#escapeAmpersand(String)}.
   *
   * <ul>
   *   <li>When {@code &&&(?!.{2,4};)}.
   *   <li>Then return {@code &amp;&amp;&amp;(?!.{2,4};)}.
   * </ul>
   *
   * <p>Method under test: {@link SafeStringUtils#escapeAmpersand(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String SafeStringUtils.escapeAmpersand(String)"})
  public void testEscapeAmpersand_when24_thenReturnAmpAmpAmp24() {
    // Arrange, Act and Assert
    assertEquals("&amp;&amp;&amp;(?!.{2,4};)", SafeStringUtils.escapeAmpersand("&&&(?!.{2,4};)"));
  }

  /**
   * Test {@link SafeStringUtils#escapeAmpersand(String)}.
   *
   * <ul>
   *   <li>When {@code 42&amp;&(?!.{2,4};)}.
   *   <li>Then return {@code 42&amp;&amp;(?!.{2,4};)}.
   * </ul>
   *
   * <p>Method under test: {@link SafeStringUtils#escapeAmpersand(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String SafeStringUtils.escapeAmpersand(String)"})
  public void testEscapeAmpersand_when42Amp24_thenReturn42AmpAmp24() {
    // Arrange, Act and Assert
    assertEquals("42&amp;&amp;(?!.{2,4};)", SafeStringUtils.escapeAmpersand("42&amp;&(?!.{2,4};)"));
  }

  /**
   * Test {@link SafeStringUtils#escapeAmpersand(String)}.
   *
   * <ul>
   *   <li>When {@code 42&amp;&}.
   *   <li>Then return {@code 42&amp;&amp;}.
   * </ul>
   *
   * <p>Method under test: {@link SafeStringUtils#escapeAmpersand(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String SafeStringUtils.escapeAmpersand(String)"})
  public void testEscapeAmpersand_when42Amp_thenReturn42AmpAmp() {
    // Arrange, Act and Assert
    assertEquals("42&amp;&amp;", SafeStringUtils.escapeAmpersand("42&amp;&"));
  }

  /**
   * Test {@link SafeStringUtils#escapeAmpersand(String)}.
   *
   * <ul>
   *   <li>When {@code &42&amp;}.
   *   <li>Then return {@code &amp;42&amp;}.
   * </ul>
   *
   * <p>Method under test: {@link SafeStringUtils#escapeAmpersand(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String SafeStringUtils.escapeAmpersand(String)"})
  public void testEscapeAmpersand_when42Amp_thenReturnAmp42Amp() {
    // Arrange, Act and Assert
    assertEquals("&amp;42&amp;", SafeStringUtils.escapeAmpersand("&42&amp;"));
  }

  /**
   * Test {@link SafeStringUtils#escapeAmpersand(String)}.
   *
   * <ul>
   *   <li>When {@code 42String&(?!.{2,4};)}.
   *   <li>Then return {@code 42String&amp;(?!.{2,4};)}.
   * </ul>
   *
   * <p>Method under test: {@link SafeStringUtils#escapeAmpersand(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String SafeStringUtils.escapeAmpersand(String)"})
  public void testEscapeAmpersand_when42String24_thenReturn42StringAmp24() {
    // Arrange, Act and Assert
    assertEquals(
        "42String&amp;(?!.{2,4};)", SafeStringUtils.escapeAmpersand("42String&(?!.{2,4};)"));
  }

  /**
   * Test {@link SafeStringUtils#escapeAmpersand(String)}.
   *
   * <ul>
   *   <li>When {@code 42&String}.
   *   <li>Then return {@code 42&amp;String}.
   * </ul>
   *
   * <p>Method under test: {@link SafeStringUtils#escapeAmpersand(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String SafeStringUtils.escapeAmpersand(String)"})
  public void testEscapeAmpersand_when42String_thenReturn42AmpString() {
    // Arrange, Act and Assert
    assertEquals("42&amp;String", SafeStringUtils.escapeAmpersand("42&String"));
  }

  /**
   * Test {@link SafeStringUtils#escapeAmpersand(String)}.
   *
   * <ul>
   *   <li>When {@code 42String&}.
   *   <li>Then return {@code 42String&amp;}.
   * </ul>
   *
   * <p>Method under test: {@link SafeStringUtils#escapeAmpersand(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String SafeStringUtils.escapeAmpersand(String)"})
  public void testEscapeAmpersand_when42String_thenReturn42StringAmp() {
    // Arrange, Act and Assert
    assertEquals("42String&amp;", SafeStringUtils.escapeAmpersand("42String&"));
  }

  /**
   * Test {@link SafeStringUtils#escapeAmpersand(String)}.
   *
   * <ul>
   *   <li>When {@code &42String}.
   *   <li>Then return {@code &amp;42String}.
   * </ul>
   *
   * <p>Method under test: {@link SafeStringUtils#escapeAmpersand(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String SafeStringUtils.escapeAmpersand(String)"})
  public void testEscapeAmpersand_when42String_thenReturnAmp42String() {
    // Arrange, Act and Assert
    assertEquals("&amp;42String", SafeStringUtils.escapeAmpersand("&42String"));
  }

  /**
   * Test {@link SafeStringUtils#escapeAmpersand(String)}.
   *
   * <ul>
   *   <li>When {@code 42&}.
   *   <li>Then return {@code 42&amp;}.
   * </ul>
   *
   * <p>Method under test: {@link SafeStringUtils#escapeAmpersand(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String SafeStringUtils.escapeAmpersand(String)"})
  public void testEscapeAmpersand_when42_thenReturn42Amp() {
    // Arrange, Act and Assert
    assertEquals("42&amp;", SafeStringUtils.escapeAmpersand("42&"));
  }

  /**
   * Test {@link SafeStringUtils#escapeAmpersand(String)}.
   *
   * <ul>
   *   <li>When {@code 42&&}.
   *   <li>Then return {@code 42&amp;&amp;}.
   * </ul>
   *
   * <p>Method under test: {@link SafeStringUtils#escapeAmpersand(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String SafeStringUtils.escapeAmpersand(String)"})
  public void testEscapeAmpersand_when42_thenReturn42AmpAmp() {
    // Arrange, Act and Assert
    assertEquals("42&amp;&amp;", SafeStringUtils.escapeAmpersand("42&&"));
  }

  /**
   * Test {@link SafeStringUtils#escapeAmpersand(String)}.
   *
   * <ul>
   *   <li>When {@code &42}.
   *   <li>Then return {@code &amp;42}.
   * </ul>
   *
   * <p>Method under test: {@link SafeStringUtils#escapeAmpersand(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String SafeStringUtils.escapeAmpersand(String)"})
  public void testEscapeAmpersand_when42_thenReturnAmp42() {
    // Arrange, Act and Assert
    assertEquals("&amp;42", SafeStringUtils.escapeAmpersand("&42"));
  }

  /**
   * Test {@link SafeStringUtils#escapeAmpersand(String)}.
   *
   * <ul>
   *   <li>When {@code &42&}.
   *   <li>Then return {@code &amp;42&amp;}.
   * </ul>
   *
   * <p>Method under test: {@link SafeStringUtils#escapeAmpersand(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String SafeStringUtils.escapeAmpersand(String)"})
  public void testEscapeAmpersand_when42_thenReturnAmp42Amp() {
    // Arrange, Act and Assert
    assertEquals("&amp;42&amp;", SafeStringUtils.escapeAmpersand("&42&"));
  }

  /**
   * Test {@link SafeStringUtils#escapeAmpersand(String)}.
   *
   * <ul>
   *   <li>When {@code &&42}.
   *   <li>Then return {@code &amp;&amp;42}.
   * </ul>
   *
   * <p>Method under test: {@link SafeStringUtils#escapeAmpersand(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String SafeStringUtils.escapeAmpersand(String)"})
  public void testEscapeAmpersand_when42_thenReturnAmpAmp42() {
    // Arrange, Act and Assert
    assertEquals("&amp;&amp;42", SafeStringUtils.escapeAmpersand("&&42"));
  }

  /**
   * Test {@link SafeStringUtils#escapeAmpersand(String)}.
   *
   * <ul>
   *   <li>When {@code &(?!.{2,4};)&(?!.{2,4};)&amp;}.
   *   <li>Then return {@code &amp;(?!.{2,4};)&amp;(?!.{2,4};)&amp;}.
   * </ul>
   *
   * <p>Method under test: {@link SafeStringUtils#escapeAmpersand(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String SafeStringUtils.escapeAmpersand(String)"})
  public void testEscapeAmpersand_when2424Amp_thenReturnAmp24Amp24Amp() {
    // Arrange, Act and Assert
    assertEquals(
        "&amp;(?!.{2,4};)&amp;(?!.{2,4};)&amp;",
        SafeStringUtils.escapeAmpersand("&(?!.{2,4};)&(?!.{2,4};)&amp;"));
  }

  /**
   * Test {@link SafeStringUtils#escapeAmpersand(String)}.
   *
   * <ul>
   *   <li>When {@code &(?!.{2,4};)&(?!.{2,4};)String}.
   *   <li>Then return {@code &amp;(?!.{2,4};)&amp;(?!.{2,4};)String}.
   * </ul>
   *
   * <p>Method under test: {@link SafeStringUtils#escapeAmpersand(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String SafeStringUtils.escapeAmpersand(String)"})
  public void testEscapeAmpersand_when2424String_thenReturnAmp24Amp24String() {
    // Arrange, Act and Assert
    assertEquals(
        "&amp;(?!.{2,4};)&amp;(?!.{2,4};)String",
        SafeStringUtils.escapeAmpersand("&(?!.{2,4};)&(?!.{2,4};)String"));
  }

  /**
   * Test {@link SafeStringUtils#escapeAmpersand(String)}.
   *
   * <ul>
   *   <li>When {@code &(?!.{2,4};)&(?!.{2,4};)}.
   *   <li>Then return {@code &amp;(?!.{2,4};)&amp;(?!.{2,4};)}.
   * </ul>
   *
   * <p>Method under test: {@link SafeStringUtils#escapeAmpersand(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String SafeStringUtils.escapeAmpersand(String)"})
  public void testEscapeAmpersand_when2424_thenReturnAmp24Amp24() {
    // Arrange, Act and Assert
    assertEquals(
        "&amp;(?!.{2,4};)&amp;(?!.{2,4};)",
        SafeStringUtils.escapeAmpersand("&(?!.{2,4};)&(?!.{2,4};)"));
  }

  /**
   * Test {@link SafeStringUtils#escapeAmpersand(String)}.
   *
   * <ul>
   *   <li>When {@code &(?!.{2,4};)&(?!.{2,4};)&}.
   *   <li>Then return {@code &amp;(?!.{2,4};)&amp;(?!.{2,4};)&amp;}.
   * </ul>
   *
   * <p>Method under test: {@link SafeStringUtils#escapeAmpersand(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String SafeStringUtils.escapeAmpersand(String)"})
  public void testEscapeAmpersand_when2424_thenReturnAmp24Amp24Amp() {
    // Arrange, Act and Assert
    assertEquals(
        "&amp;(?!.{2,4};)&amp;(?!.{2,4};)&amp;",
        SafeStringUtils.escapeAmpersand("&(?!.{2,4};)&(?!.{2,4};)&"));
  }

  /**
   * Test {@link SafeStringUtils#escapeAmpersand(String)}.
   *
   * <ul>
   *   <li>When {@code &(?!.{2,4};)&&(?!.{2,4};)}.
   *   <li>Then return {@code &amp;(?!.{2,4};)&amp;&amp;(?!.{2,4};)}.
   * </ul>
   *
   * <p>Method under test: {@link SafeStringUtils#escapeAmpersand(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String SafeStringUtils.escapeAmpersand(String)"})
  public void testEscapeAmpersand_when2424_thenReturnAmp24AmpAmp24() {
    // Arrange, Act and Assert
    assertEquals(
        "&amp;(?!.{2,4};)&amp;&amp;(?!.{2,4};)",
        SafeStringUtils.escapeAmpersand("&(?!.{2,4};)&&(?!.{2,4};)"));
  }

  /**
   * Test {@link SafeStringUtils#escapeAmpersand(String)}.
   *
   * <ul>
   *   <li>When {@code &&(?!.{2,4};)&(?!.{2,4};)}.
   *   <li>Then return {@code &amp;&amp;(?!.{2,4};)&amp;(?!.{2,4};)}.
   * </ul>
   *
   * <p>Method under test: {@link SafeStringUtils#escapeAmpersand(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String SafeStringUtils.escapeAmpersand(String)"})
  public void testEscapeAmpersand_when2424_thenReturnAmpAmp24Amp24() {
    // Arrange, Act and Assert
    assertEquals(
        "&amp;&amp;(?!.{2,4};)&amp;(?!.{2,4};)",
        SafeStringUtils.escapeAmpersand("&&(?!.{2,4};)&(?!.{2,4};)"));
  }

  /**
   * Test {@link SafeStringUtils#escapeAmpersand(String)}.
   *
   * <ul>
   *   <li>When {@code &(?!.{2,4};)42&amp;}.
   *   <li>Then return {@code &amp;(?!.{2,4};)42&amp;}.
   * </ul>
   *
   * <p>Method under test: {@link SafeStringUtils#escapeAmpersand(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String SafeStringUtils.escapeAmpersand(String)"})
  public void testEscapeAmpersand_when2442Amp_thenReturnAmp2442Amp() {
    // Arrange, Act and Assert
    assertEquals("&amp;(?!.{2,4};)42&amp;", SafeStringUtils.escapeAmpersand("&(?!.{2,4};)42&amp;"));
  }

  /**
   * Test {@link SafeStringUtils#escapeAmpersand(String)}.
   *
   * <ul>
   *   <li>When {@code &(?!.{2,4};)42String}.
   *   <li>Then return {@code &amp;(?!.{2,4};)42String}.
   * </ul>
   *
   * <p>Method under test: {@link SafeStringUtils#escapeAmpersand(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String SafeStringUtils.escapeAmpersand(String)"})
  public void testEscapeAmpersand_when2442String_thenReturnAmp2442String() {
    // Arrange, Act and Assert
    assertEquals(
        "&amp;(?!.{2,4};)42String", SafeStringUtils.escapeAmpersand("&(?!.{2,4};)42String"));
  }

  /**
   * Test {@link SafeStringUtils#escapeAmpersand(String)}.
   *
   * <ul>
   *   <li>When {@code &(?!.{2,4};)&42}.
   *   <li>Then return {@code &amp;(?!.{2,4};)&amp;42}.
   * </ul>
   *
   * <p>Method under test: {@link SafeStringUtils#escapeAmpersand(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String SafeStringUtils.escapeAmpersand(String)"})
  public void testEscapeAmpersand_when2442_thenReturnAmp24Amp42() {
    // Arrange, Act and Assert
    assertEquals("&amp;(?!.{2,4};)&amp;42", SafeStringUtils.escapeAmpersand("&(?!.{2,4};)&42"));
  }

  /**
   * Test {@link SafeStringUtils#escapeAmpersand(String)}.
   *
   * <ul>
   *   <li>When {@code &(?!.{2,4};)42}.
   *   <li>Then return {@code &amp;(?!.{2,4};)42}.
   * </ul>
   *
   * <p>Method under test: {@link SafeStringUtils#escapeAmpersand(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String SafeStringUtils.escapeAmpersand(String)"})
  public void testEscapeAmpersand_when2442_thenReturnAmp2442() {
    // Arrange, Act and Assert
    assertEquals("&amp;(?!.{2,4};)42", SafeStringUtils.escapeAmpersand("&(?!.{2,4};)42"));
  }

  /**
   * Test {@link SafeStringUtils#escapeAmpersand(String)}.
   *
   * <ul>
   *   <li>When {@code &(?!.{2,4};)42&}.
   *   <li>Then return {@code &amp;(?!.{2,4};)42&amp;}.
   * </ul>
   *
   * <p>Method under test: {@link SafeStringUtils#escapeAmpersand(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String SafeStringUtils.escapeAmpersand(String)"})
  public void testEscapeAmpersand_when2442_thenReturnAmp2442Amp() {
    // Arrange, Act and Assert
    assertEquals("&amp;(?!.{2,4};)42&amp;", SafeStringUtils.escapeAmpersand("&(?!.{2,4};)42&"));
  }

  /**
   * Test {@link SafeStringUtils#escapeAmpersand(String)}.
   *
   * <ul>
   *   <li>When {@code &&(?!.{2,4};)42}.
   *   <li>Then return {@code &amp;&amp;(?!.{2,4};)42}.
   * </ul>
   *
   * <p>Method under test: {@link SafeStringUtils#escapeAmpersand(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String SafeStringUtils.escapeAmpersand(String)"})
  public void testEscapeAmpersand_when2442_thenReturnAmpAmp2442() {
    // Arrange, Act and Assert
    assertEquals("&amp;&amp;(?!.{2,4};)42", SafeStringUtils.escapeAmpersand("&&(?!.{2,4};)42"));
  }

  /**
   * Test {@link SafeStringUtils#escapeAmpersand(String)}.
   *
   * <ul>
   *   <li>When {@code 42&(?!.{2,4};)&amp;}.
   *   <li>Then return {@code 42&amp;(?!.{2,4};)&amp;}.
   * </ul>
   *
   * <p>Method under test: {@link SafeStringUtils#escapeAmpersand(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String SafeStringUtils.escapeAmpersand(String)"})
  public void testEscapeAmpersand_when4224Amp_thenReturn42Amp24Amp() {
    // Arrange, Act and Assert
    assertEquals("42&amp;(?!.{2,4};)&amp;", SafeStringUtils.escapeAmpersand("42&(?!.{2,4};)&amp;"));
  }

  /**
   * Test {@link SafeStringUtils#escapeAmpersand(String)}.
   *
   * <ul>
   *   <li>When {@code 42&(?!.{2,4};)String}.
   *   <li>Then return {@code 42&amp;(?!.{2,4};)String}.
   * </ul>
   *
   * <p>Method under test: {@link SafeStringUtils#escapeAmpersand(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String SafeStringUtils.escapeAmpersand(String)"})
  public void testEscapeAmpersand_when4224String_thenReturn42Amp24String() {
    // Arrange, Act and Assert
    assertEquals(
        "42&amp;(?!.{2,4};)String", SafeStringUtils.escapeAmpersand("42&(?!.{2,4};)String"));
  }

  /**
   * Test {@link SafeStringUtils#escapeAmpersand(String)}.
   *
   * <ul>
   *   <li>When {@code 42&(?!.{2,4};)}.
   *   <li>Then return {@code 42&amp;(?!.{2,4};)}.
   * </ul>
   *
   * <p>Method under test: {@link SafeStringUtils#escapeAmpersand(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String SafeStringUtils.escapeAmpersand(String)"})
  public void testEscapeAmpersand_when4224_thenReturn42Amp24() {
    // Arrange, Act and Assert
    assertEquals("42&amp;(?!.{2,4};)", SafeStringUtils.escapeAmpersand("42&(?!.{2,4};)"));
  }

  /**
   * Test {@link SafeStringUtils#escapeAmpersand(String)}.
   *
   * <ul>
   *   <li>When {@code 42&(?!.{2,4};)&}.
   *   <li>Then return {@code 42&amp;(?!.{2,4};)&amp;}.
   * </ul>
   *
   * <p>Method under test: {@link SafeStringUtils#escapeAmpersand(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String SafeStringUtils.escapeAmpersand(String)"})
  public void testEscapeAmpersand_when4224_thenReturn42Amp24Amp() {
    // Arrange, Act and Assert
    assertEquals("42&amp;(?!.{2,4};)&amp;", SafeStringUtils.escapeAmpersand("42&(?!.{2,4};)&"));
  }

  /**
   * Test {@link SafeStringUtils#escapeAmpersand(String)}.
   *
   * <ul>
   *   <li>When {@code 42&&(?!.{2,4};)}.
   *   <li>Then return {@code 42&amp;&amp;(?!.{2,4};)}.
   * </ul>
   *
   * <p>Method under test: {@link SafeStringUtils#escapeAmpersand(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String SafeStringUtils.escapeAmpersand(String)"})
  public void testEscapeAmpersand_when4224_thenReturn42AmpAmp24() {
    // Arrange, Act and Assert
    assertEquals("42&amp;&amp;(?!.{2,4};)", SafeStringUtils.escapeAmpersand("42&&(?!.{2,4};)"));
  }

  /**
   * Test {@link SafeStringUtils#escapeAmpersand(String)}.
   *
   * <ul>
   *   <li>When {@code &42&(?!.{2,4};)}.
   *   <li>Then return {@code &amp;42&amp;(?!.{2,4};)}.
   * </ul>
   *
   * <p>Method under test: {@link SafeStringUtils#escapeAmpersand(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String SafeStringUtils.escapeAmpersand(String)"})
  public void testEscapeAmpersand_when4224_thenReturnAmp42Amp24() {
    // Arrange, Act and Assert
    assertEquals("&amp;42&amp;(?!.{2,4};)", SafeStringUtils.escapeAmpersand("&42&(?!.{2,4};)"));
  }

  /**
   * Test {@link SafeStringUtils#escapeAmpersand(String)}.
   *
   * <ul>
   *   <li>When {@code 42&42}.
   *   <li>Then return {@code 42&amp;42}.
   * </ul>
   *
   * <p>Method under test: {@link SafeStringUtils#escapeAmpersand(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String SafeStringUtils.escapeAmpersand(String)"})
  public void testEscapeAmpersand_when4242_thenReturn42Amp42() {
    // Arrange, Act and Assert
    assertEquals("42&amp;42", SafeStringUtils.escapeAmpersand("42&42"));
  }

  /**
   * Test {@link SafeStringUtils#escapeAmpersand(String)}.
   *
   * <ul>
   *   <li>When {@code 4242&}.
   *   <li>Then return {@code 4242&amp;}.
   * </ul>
   *
   * <p>Method under test: {@link SafeStringUtils#escapeAmpersand(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String SafeStringUtils.escapeAmpersand(String)"})
  public void testEscapeAmpersand_when4242_thenReturn4242Amp() {
    // Arrange, Act and Assert
    assertEquals("4242&amp;", SafeStringUtils.escapeAmpersand("4242&"));
  }

  /**
   * Test {@link SafeStringUtils#escapeAmpersand(String)}.
   *
   * <ul>
   *   <li>When {@code &4242}.
   *   <li>Then return {@code &amp;4242}.
   * </ul>
   *
   * <p>Method under test: {@link SafeStringUtils#escapeAmpersand(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String SafeStringUtils.escapeAmpersand(String)"})
  public void testEscapeAmpersand_when4242_thenReturnAmp4242() {
    // Arrange, Act and Assert
    assertEquals("&amp;4242", SafeStringUtils.escapeAmpersand("&4242"));
  }

  /**
   * Test {@link SafeStringUtils#escapeAmpersand(String)}.
   *
   * <ul>
   *   <li>When {@code &(?!.{2,4};)&(?!.{2,4};)&(?!.{2,4};)}.
   *   <li>Then return {@code &amp;(?!.{2,4};)&amp;(?!.{2,4};)&amp;(?!.{2,4};)}.
   * </ul>
   *
   * <p>Method under test: {@link SafeStringUtils#escapeAmpersand(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String SafeStringUtils.escapeAmpersand(String)"})
  public void testEscapeAmpersand_when242424_thenReturnAmp24Amp24Amp24() {
    // Arrange, Act and Assert
    assertEquals(
        "&amp;(?!.{2,4};)&amp;(?!.{2,4};)&amp;(?!.{2,4};)",
        SafeStringUtils.escapeAmpersand("&(?!.{2,4};)&(?!.{2,4};)&(?!.{2,4};)"));
  }

  /**
   * Test {@link SafeStringUtils#escapeAmpersand(String)}.
   *
   * <ul>
   *   <li>When {@code &(?!.{2,4};)&(?!.{2,4};)42}.
   *   <li>Then return {@code &amp;(?!.{2,4};)&amp;(?!.{2,4};)42}.
   * </ul>
   *
   * <p>Method under test: {@link SafeStringUtils#escapeAmpersand(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String SafeStringUtils.escapeAmpersand(String)"})
  public void testEscapeAmpersand_when242442_thenReturnAmp24Amp2442() {
    // Arrange, Act and Assert
    assertEquals(
        "&amp;(?!.{2,4};)&amp;(?!.{2,4};)42",
        SafeStringUtils.escapeAmpersand("&(?!.{2,4};)&(?!.{2,4};)42"));
  }

  /**
   * Test {@link SafeStringUtils#escapeAmpersand(String)}.
   *
   * <ul>
   *   <li>When {@code &(?!.{2,4};)42&(?!.{2,4};)}.
   *   <li>Then return {@code &amp;(?!.{2,4};)42&amp;(?!.{2,4};)}.
   * </ul>
   *
   * <p>Method under test: {@link SafeStringUtils#escapeAmpersand(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String SafeStringUtils.escapeAmpersand(String)"})
  public void testEscapeAmpersand_when244224_thenReturnAmp2442Amp24() {
    // Arrange, Act and Assert
    assertEquals(
        "&amp;(?!.{2,4};)42&amp;(?!.{2,4};)",
        SafeStringUtils.escapeAmpersand("&(?!.{2,4};)42&(?!.{2,4};)"));
  }

  /**
   * Test {@link SafeStringUtils#escapeAmpersand(String)}.
   *
   * <ul>
   *   <li>When {@code &(?!.{2,4};)4242}.
   *   <li>Then return {@code &amp;(?!.{2,4};)4242}.
   * </ul>
   *
   * <p>Method under test: {@link SafeStringUtils#escapeAmpersand(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String SafeStringUtils.escapeAmpersand(String)"})
  public void testEscapeAmpersand_when244242_thenReturnAmp244242() {
    // Arrange, Act and Assert
    assertEquals("&amp;(?!.{2,4};)4242", SafeStringUtils.escapeAmpersand("&(?!.{2,4};)4242"));
  }

  /**
   * Test {@link SafeStringUtils#escapeAmpersand(String)}.
   *
   * <ul>
   *   <li>When {@code 42&(?!.{2,4};)&(?!.{2,4};)}.
   *   <li>Then return {@code 42&amp;(?!.{2,4};)&amp;(?!.{2,4};)}.
   * </ul>
   *
   * <p>Method under test: {@link SafeStringUtils#escapeAmpersand(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String SafeStringUtils.escapeAmpersand(String)"})
  public void testEscapeAmpersand_when422424_thenReturn42Amp24Amp24() {
    // Arrange, Act and Assert
    assertEquals(
        "42&amp;(?!.{2,4};)&amp;(?!.{2,4};)",
        SafeStringUtils.escapeAmpersand("42&(?!.{2,4};)&(?!.{2,4};)"));
  }

  /**
   * Test {@link SafeStringUtils#escapeAmpersand(String)}.
   *
   * <ul>
   *   <li>When {@code 42&(?!.{2,4};)42}.
   *   <li>Then return {@code 42&amp;(?!.{2,4};)42}.
   * </ul>
   *
   * <p>Method under test: {@link SafeStringUtils#escapeAmpersand(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String SafeStringUtils.escapeAmpersand(String)"})
  public void testEscapeAmpersand_when422442_thenReturn42Amp2442() {
    // Arrange, Act and Assert
    assertEquals("42&amp;(?!.{2,4};)42", SafeStringUtils.escapeAmpersand("42&(?!.{2,4};)42"));
  }

  /**
   * Test {@link SafeStringUtils#escapeAmpersand(String)}.
   *
   * <ul>
   *   <li>When {@code 4242&(?!.{2,4};)}.
   *   <li>Then return {@code 4242&amp;(?!.{2,4};)}.
   * </ul>
   *
   * <p>Method under test: {@link SafeStringUtils#escapeAmpersand(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String SafeStringUtils.escapeAmpersand(String)"})
  public void testEscapeAmpersand_when424224_thenReturn4242Amp24() {
    // Arrange, Act and Assert
    assertEquals("4242&amp;(?!.{2,4};)", SafeStringUtils.escapeAmpersand("4242&(?!.{2,4};)"));
  }

  /**
   * Test {@link SafeStringUtils#escapeAmpersand(String)}.
   *
   * <ul>
   *   <li>When {@code &amp;&(?!.{2,4};)&amp;}.
   *   <li>Then return {@code &amp;&amp;(?!.{2,4};)&amp;}.
   * </ul>
   *
   * <p>Method under test: {@link SafeStringUtils#escapeAmpersand(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String SafeStringUtils.escapeAmpersand(String)"})
  public void testEscapeAmpersand_whenAmp24Amp_thenReturnAmpAmp24Amp() {
    // Arrange, Act and Assert
    assertEquals(
        "&amp;&amp;(?!.{2,4};)&amp;", SafeStringUtils.escapeAmpersand("&amp;&(?!.{2,4};)&amp;"));
  }

  /**
   * Test {@link SafeStringUtils#escapeAmpersand(String)}.
   *
   * <ul>
   *   <li>When {@code &amp;&(?!.{2,4};)String}.
   *   <li>Then return {@code &amp;&amp;(?!.{2,4};)String}.
   * </ul>
   *
   * <p>Method under test: {@link SafeStringUtils#escapeAmpersand(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String SafeStringUtils.escapeAmpersand(String)"})
  public void testEscapeAmpersand_whenAmp24String_thenReturnAmpAmp24String() {
    // Arrange, Act and Assert
    assertEquals(
        "&amp;&amp;(?!.{2,4};)String", SafeStringUtils.escapeAmpersand("&amp;&(?!.{2,4};)String"));
  }

  /**
   * Test {@link SafeStringUtils#escapeAmpersand(String)}.
   *
   * <ul>
   *   <li>When {@code &amp;&(?!.{2,4};)}.
   *   <li>Then return {@code &amp;&amp;(?!.{2,4};)}.
   * </ul>
   *
   * <p>Method under test: {@link SafeStringUtils#escapeAmpersand(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String SafeStringUtils.escapeAmpersand(String)"})
  public void testEscapeAmpersand_whenAmp24_thenReturnAmpAmp24() {
    // Arrange, Act and Assert
    assertEquals("&amp;&amp;(?!.{2,4};)", SafeStringUtils.escapeAmpersand("&amp;&(?!.{2,4};)"));
  }

  /**
   * Test {@link SafeStringUtils#escapeAmpersand(String)}.
   *
   * <ul>
   *   <li>When {@code &amp;&(?!.{2,4};)&}.
   *   <li>Then return {@code &amp;&amp;(?!.{2,4};)&amp;}.
   * </ul>
   *
   * <p>Method under test: {@link SafeStringUtils#escapeAmpersand(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String SafeStringUtils.escapeAmpersand(String)"})
  public void testEscapeAmpersand_whenAmp24_thenReturnAmpAmp24Amp() {
    // Arrange, Act and Assert
    assertEquals(
        "&amp;&amp;(?!.{2,4};)&amp;", SafeStringUtils.escapeAmpersand("&amp;&(?!.{2,4};)&"));
  }

  /**
   * Test {@link SafeStringUtils#escapeAmpersand(String)}.
   *
   * <ul>
   *   <li>When {@code &&amp;&(?!.{2,4};)}.
   *   <li>Then return {@code &&amp;&amp;(?!.{2,4};)}.
   * </ul>
   *
   * <p>Method under test: {@link SafeStringUtils#escapeAmpersand(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String SafeStringUtils.escapeAmpersand(String)"})
  public void testEscapeAmpersand_whenAmp24_thenReturnAmpAmp242() {
    // Arrange, Act and Assert
    assertEquals("&&amp;&amp;(?!.{2,4};)", SafeStringUtils.escapeAmpersand("&&amp;&(?!.{2,4};)"));
  }

  /**
   * Test {@link SafeStringUtils#escapeAmpersand(String)}.
   *
   * <ul>
   *   <li>When {@code &amp;&&(?!.{2,4};)}.
   *   <li>Then return {@code &amp;&amp;&amp;(?!.{2,4};)}.
   * </ul>
   *
   * <p>Method under test: {@link SafeStringUtils#escapeAmpersand(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String SafeStringUtils.escapeAmpersand(String)"})
  public void testEscapeAmpersand_whenAmp24_thenReturnAmpAmpAmp24() {
    // Arrange, Act and Assert
    assertEquals(
        "&amp;&amp;&amp;(?!.{2,4};)", SafeStringUtils.escapeAmpersand("&amp;&&(?!.{2,4};)"));
  }

  /**
   * Test {@link SafeStringUtils#escapeAmpersand(String)}.
   *
   * <ul>
   *   <li>When {@code &amp;42&}.
   *   <li>Then return {@code &amp;42&amp;}.
   * </ul>
   *
   * <p>Method under test: {@link SafeStringUtils#escapeAmpersand(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String SafeStringUtils.escapeAmpersand(String)"})
  public void testEscapeAmpersand_whenAmp42_thenReturnAmp42Amp() {
    // Arrange, Act and Assert
    assertEquals("&amp;42&amp;", SafeStringUtils.escapeAmpersand("&amp;42&"));
  }

  /**
   * Test {@link SafeStringUtils#escapeAmpersand(String)}.
   *
   * <ul>
   *   <li>When {@code &amp;&42}.
   *   <li>Then return {@code &amp;&amp;42}.
   * </ul>
   *
   * <p>Method under test: {@link SafeStringUtils#escapeAmpersand(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String SafeStringUtils.escapeAmpersand(String)"})
  public void testEscapeAmpersand_whenAmp42_thenReturnAmpAmp42() {
    // Arrange, Act and Assert
    assertEquals("&amp;&amp;42", SafeStringUtils.escapeAmpersand("&amp;&42"));
  }

  /**
   * Test {@link SafeStringUtils#escapeAmpersand(String)}.
   *
   * <ul>
   *   <li>When {@code &amp;&(?!.{2,4};)&(?!.{2,4};)}.
   *   <li>Then return {@code &amp;&amp;(?!.{2,4};)&amp;(?!.{2,4};)}.
   * </ul>
   *
   * <p>Method under test: {@link SafeStringUtils#escapeAmpersand(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String SafeStringUtils.escapeAmpersand(String)"})
  public void testEscapeAmpersand_whenAmp2424_thenReturnAmpAmp24Amp24() {
    // Arrange, Act and Assert
    assertEquals(
        "&amp;&amp;(?!.{2,4};)&amp;(?!.{2,4};)",
        SafeStringUtils.escapeAmpersand("&amp;&(?!.{2,4};)&(?!.{2,4};)"));
  }

  /**
   * Test {@link SafeStringUtils#escapeAmpersand(String)}.
   *
   * <ul>
   *   <li>When {@code &amp;&(?!.{2,4};)42}.
   *   <li>Then return {@code &amp;&amp;(?!.{2,4};)42}.
   * </ul>
   *
   * <p>Method under test: {@link SafeStringUtils#escapeAmpersand(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String SafeStringUtils.escapeAmpersand(String)"})
  public void testEscapeAmpersand_whenAmp2442_thenReturnAmpAmp2442() {
    // Arrange, Act and Assert
    assertEquals("&amp;&amp;(?!.{2,4};)42", SafeStringUtils.escapeAmpersand("&amp;&(?!.{2,4};)42"));
  }

  /**
   * Test {@link SafeStringUtils#escapeAmpersand(String)}.
   *
   * <ul>
   *   <li>When {@code &amp;42&(?!.{2,4};)}.
   *   <li>Then return {@code &amp;42&amp;(?!.{2,4};)}.
   * </ul>
   *
   * <p>Method under test: {@link SafeStringUtils#escapeAmpersand(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String SafeStringUtils.escapeAmpersand(String)"})
  public void testEscapeAmpersand_whenAmp4224_thenReturnAmp42Amp24() {
    // Arrange, Act and Assert
    assertEquals("&amp;42&amp;(?!.{2,4};)", SafeStringUtils.escapeAmpersand("&amp;42&(?!.{2,4};)"));
  }

  /**
   * Test {@link SafeStringUtils#escapeAmpersand(String)}.
   *
   * <ul>
   *   <li>When {@code &amp;&amp;&(?!.{2,4};)}.
   *   <li>Then return {@code &amp;&amp;&amp;(?!.{2,4};)}.
   * </ul>
   *
   * <p>Method under test: {@link SafeStringUtils#escapeAmpersand(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String SafeStringUtils.escapeAmpersand(String)"})
  public void testEscapeAmpersand_whenAmpAmp24_thenReturnAmpAmpAmp24() {
    // Arrange, Act and Assert
    assertEquals(
        "&amp;&amp;&amp;(?!.{2,4};)", SafeStringUtils.escapeAmpersand("&amp;&amp;&(?!.{2,4};)"));
  }

  /**
   * Test {@link SafeStringUtils#escapeAmpersand(String)}.
   *
   * <ul>
   *   <li>When {@code &amp;&amp;&}.
   *   <li>Then return {@code &amp;&amp;&amp;}.
   * </ul>
   *
   * <p>Method under test: {@link SafeStringUtils#escapeAmpersand(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String SafeStringUtils.escapeAmpersand(String)"})
  public void testEscapeAmpersand_whenAmpAmp_thenReturnAmpAmpAmp() {
    // Arrange, Act and Assert
    assertEquals("&amp;&amp;&amp;", SafeStringUtils.escapeAmpersand("&amp;&amp;&"));
  }

  /**
   * Test {@link SafeStringUtils#escapeAmpersand(String)}.
   *
   * <ul>
   *   <li>When {@code &amp;String&(?!.{2,4};)}.
   *   <li>Then return {@code &amp;String&amp;(?!.{2,4};)}.
   * </ul>
   *
   * <p>Method under test: {@link SafeStringUtils#escapeAmpersand(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String SafeStringUtils.escapeAmpersand(String)"})
  public void testEscapeAmpersand_whenAmpString24_thenReturnAmpStringAmp24() {
    // Arrange, Act and Assert
    assertEquals(
        "&amp;String&amp;(?!.{2,4};)", SafeStringUtils.escapeAmpersand("&amp;String&(?!.{2,4};)"));
  }

  /**
   * Test {@link SafeStringUtils#escapeAmpersand(String)}.
   *
   * <ul>
   *   <li>When {@code &amp;&String}.
   *   <li>Then return {@code &amp;&amp;String}.
   * </ul>
   *
   * <p>Method under test: {@link SafeStringUtils#escapeAmpersand(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String SafeStringUtils.escapeAmpersand(String)"})
  public void testEscapeAmpersand_whenAmpString_thenReturnAmpAmpString() {
    // Arrange, Act and Assert
    assertEquals("&amp;&amp;String", SafeStringUtils.escapeAmpersand("&amp;&String"));
  }

  /**
   * Test {@link SafeStringUtils#escapeAmpersand(String)}.
   *
   * <ul>
   *   <li>When {@code &amp;String&}.
   *   <li>Then return {@code &amp;String&amp;}.
   * </ul>
   *
   * <p>Method under test: {@link SafeStringUtils#escapeAmpersand(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String SafeStringUtils.escapeAmpersand(String)"})
  public void testEscapeAmpersand_whenAmpString_thenReturnAmpStringAmp() {
    // Arrange, Act and Assert
    assertEquals("&amp;String&amp;", SafeStringUtils.escapeAmpersand("&amp;String&"));
  }

  /**
   * Test {@link SafeStringUtils#escapeAmpersand(String)}.
   *
   * <ul>
   *   <li>When {@code &amp;&}.
   *   <li>Then return {@code &amp;&amp;}.
   * </ul>
   *
   * <p>Method under test: {@link SafeStringUtils#escapeAmpersand(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String SafeStringUtils.escapeAmpersand(String)"})
  public void testEscapeAmpersand_whenAmp_thenReturnAmpAmp() {
    // Arrange, Act and Assert
    assertEquals("&amp;&amp;", SafeStringUtils.escapeAmpersand("&amp;&"));
  }

  /**
   * Test {@link SafeStringUtils#escapeAmpersand(String)}.
   *
   * <ul>
   *   <li>When {@code &&&amp;}.
   *   <li>Then return {@code &amp;&&amp;}.
   * </ul>
   *
   * <p>Method under test: {@link SafeStringUtils#escapeAmpersand(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String SafeStringUtils.escapeAmpersand(String)"})
  public void testEscapeAmpersand_whenAmp_thenReturnAmpAmp2() {
    // Arrange, Act and Assert
    assertEquals("&amp;&&amp;", SafeStringUtils.escapeAmpersand("&&&amp;"));
  }

  /**
   * Test {@link SafeStringUtils#escapeAmpersand(String)}.
   *
   * <ul>
   *   <li>When {@code &&amp;&}.
   *   <li>Then return {@code &&amp;&amp;}.
   * </ul>
   *
   * <p>Method under test: {@link SafeStringUtils#escapeAmpersand(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String SafeStringUtils.escapeAmpersand(String)"})
  public void testEscapeAmpersand_whenAmp_thenReturnAmpAmp3() {
    // Arrange, Act and Assert
    assertEquals("&&amp;&amp;", SafeStringUtils.escapeAmpersand("&&amp;&"));
  }

  /**
   * Test {@link SafeStringUtils#escapeAmpersand(String)}.
   *
   * <ul>
   *   <li>When {@code &amp;&&}.
   *   <li>Then return {@code &amp;&amp;&amp;}.
   * </ul>
   *
   * <p>Method under test: {@link SafeStringUtils#escapeAmpersand(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String SafeStringUtils.escapeAmpersand(String)"})
  public void testEscapeAmpersand_whenAmp_thenReturnAmpAmpAmp() {
    // Arrange, Act and Assert
    assertEquals("&amp;&amp;&amp;", SafeStringUtils.escapeAmpersand("&amp;&&"));
  }

  /**
   * Test {@link SafeStringUtils#escapeAmpersand(String)}.
   *
   * <ul>
   *   <li>When {@code &&&}.
   *   <li>Then return {@code &amp;&amp;&amp;}.
   * </ul>
   *
   * <p>Method under test: {@link SafeStringUtils#escapeAmpersand(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String SafeStringUtils.escapeAmpersand(String)"})
  public void testEscapeAmpersand_whenAmpersandAmpersandAmpersand_thenReturnAmpAmpAmp() {
    // Arrange, Act and Assert
    assertEquals("&amp;&amp;&amp;", SafeStringUtils.escapeAmpersand("&&&"));
  }

  /**
   * Test {@link SafeStringUtils#escapeAmpersand(String)}.
   *
   * <ul>
   *   <li>When {@code &&}.
   *   <li>Then return {@code &amp;&amp;}.
   * </ul>
   *
   * <p>Method under test: {@link SafeStringUtils#escapeAmpersand(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String SafeStringUtils.escapeAmpersand(String)"})
  public void testEscapeAmpersand_whenAmpersandAmpersand_thenReturnAmpAmp() {
    // Arrange, Act and Assert
    assertEquals("&amp;&amp;", SafeStringUtils.escapeAmpersand("&&"));
  }

  /**
   * Test {@link SafeStringUtils#escapeAmpersand(String)}.
   *
   * <ul>
   *   <li>When {@code &}.
   *   <li>Then return {@code &amp;}.
   * </ul>
   *
   * <p>Method under test: {@link SafeStringUtils#escapeAmpersand(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String SafeStringUtils.escapeAmpersand(String)"})
  public void testEscapeAmpersand_whenAmpersand_thenReturnAmp() {
    // Arrange, Act and Assert
    assertEquals("&amp;", SafeStringUtils.escapeAmpersand("&"));
  }

  /**
   * Test {@link SafeStringUtils#escapeAmpersand(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SafeStringUtils#escapeAmpersand(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String SafeStringUtils.escapeAmpersand(String)"})
  public void testEscapeAmpersand_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(SafeStringUtils.escapeAmpersand(null));
  }

  /**
   * Test {@link SafeStringUtils#escapeAmpersand(String)}.
   *
   * <ul>
   *   <li>When {@code String&(?!.{2,4};)&amp;}.
   *   <li>Then return {@code String&amp;(?!.{2,4};)&amp;}.
   * </ul>
   *
   * <p>Method under test: {@link SafeStringUtils#escapeAmpersand(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String SafeStringUtils.escapeAmpersand(String)"})
  public void testEscapeAmpersand_whenString24Amp_thenReturnStringAmp24Amp() {
    // Arrange, Act and Assert
    assertEquals(
        "String&amp;(?!.{2,4};)&amp;", SafeStringUtils.escapeAmpersand("String&(?!.{2,4};)&amp;"));
  }

  /**
   * Test {@link SafeStringUtils#escapeAmpersand(String)}.
   *
   * <ul>
   *   <li>When {@code String&(?!.{2,4};)String}.
   *   <li>Then return {@code String&amp;(?!.{2,4};)String}.
   * </ul>
   *
   * <p>Method under test: {@link SafeStringUtils#escapeAmpersand(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String SafeStringUtils.escapeAmpersand(String)"})
  public void testEscapeAmpersand_whenString24String_thenReturnStringAmp24String() {
    // Arrange, Act and Assert
    assertEquals(
        "String&amp;(?!.{2,4};)String",
        SafeStringUtils.escapeAmpersand("String&(?!.{2,4};)String"));
  }

  /**
   * Test {@link SafeStringUtils#escapeAmpersand(String)}.
   *
   * <ul>
   *   <li>When {@code &String&(?!.{2,4};)}.
   *   <li>Then return {@code &amp;String&amp;(?!.{2,4};)}.
   * </ul>
   *
   * <p>Method under test: {@link SafeStringUtils#escapeAmpersand(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String SafeStringUtils.escapeAmpersand(String)"})
  public void testEscapeAmpersand_whenString24_thenReturnAmpStringAmp24() {
    // Arrange, Act and Assert
    assertEquals(
        "&amp;String&amp;(?!.{2,4};)", SafeStringUtils.escapeAmpersand("&String&(?!.{2,4};)"));
  }

  /**
   * Test {@link SafeStringUtils#escapeAmpersand(String)}.
   *
   * <ul>
   *   <li>When {@code String&(?!.{2,4};)}.
   *   <li>Then return {@code String&amp;(?!.{2,4};)}.
   * </ul>
   *
   * <p>Method under test: {@link SafeStringUtils#escapeAmpersand(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String SafeStringUtils.escapeAmpersand(String)"})
  public void testEscapeAmpersand_whenString24_thenReturnStringAmp24() {
    // Arrange, Act and Assert
    assertEquals("String&amp;(?!.{2,4};)", SafeStringUtils.escapeAmpersand("String&(?!.{2,4};)"));
  }

  /**
   * Test {@link SafeStringUtils#escapeAmpersand(String)}.
   *
   * <ul>
   *   <li>When {@code String&(?!.{2,4};)&}.
   *   <li>Then return {@code String&amp;(?!.{2,4};)&amp;}.
   * </ul>
   *
   * <p>Method under test: {@link SafeStringUtils#escapeAmpersand(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String SafeStringUtils.escapeAmpersand(String)"})
  public void testEscapeAmpersand_whenString24_thenReturnStringAmp24Amp() {
    // Arrange, Act and Assert
    assertEquals(
        "String&amp;(?!.{2,4};)&amp;", SafeStringUtils.escapeAmpersand("String&(?!.{2,4};)&"));
  }

  /**
   * Test {@link SafeStringUtils#escapeAmpersand(String)}.
   *
   * <ul>
   *   <li>When {@code String&&(?!.{2,4};)}.
   *   <li>Then return {@code String&amp;&amp;(?!.{2,4};)}.
   * </ul>
   *
   * <p>Method under test: {@link SafeStringUtils#escapeAmpersand(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String SafeStringUtils.escapeAmpersand(String)"})
  public void testEscapeAmpersand_whenString24_thenReturnStringAmpAmp24() {
    // Arrange, Act and Assert
    assertEquals(
        "String&amp;&amp;(?!.{2,4};)", SafeStringUtils.escapeAmpersand("String&&(?!.{2,4};)"));
  }

  /**
   * Test {@link SafeStringUtils#escapeAmpersand(String)}.
   *
   * <ul>
   *   <li>When {@code &String42}.
   *   <li>Then return {@code &amp;String42}.
   * </ul>
   *
   * <p>Method under test: {@link SafeStringUtils#escapeAmpersand(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String SafeStringUtils.escapeAmpersand(String)"})
  public void testEscapeAmpersand_whenString42_thenReturnAmpString42() {
    // Arrange, Act and Assert
    assertEquals("&amp;String42", SafeStringUtils.escapeAmpersand("&String42"));
  }

  /**
   * Test {@link SafeStringUtils#escapeAmpersand(String)}.
   *
   * <ul>
   *   <li>When {@code String42&}.
   *   <li>Then return {@code String42&amp;}.
   * </ul>
   *
   * <p>Method under test: {@link SafeStringUtils#escapeAmpersand(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String SafeStringUtils.escapeAmpersand(String)"})
  public void testEscapeAmpersand_whenString42_thenReturnString42Amp() {
    // Arrange, Act and Assert
    assertEquals("String42&amp;", SafeStringUtils.escapeAmpersand("String42&"));
  }

  /**
   * Test {@link SafeStringUtils#escapeAmpersand(String)}.
   *
   * <ul>
   *   <li>When {@code String&42}.
   *   <li>Then return {@code String&amp;42}.
   * </ul>
   *
   * <p>Method under test: {@link SafeStringUtils#escapeAmpersand(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String SafeStringUtils.escapeAmpersand(String)"})
  public void testEscapeAmpersand_whenString42_thenReturnStringAmp42() {
    // Arrange, Act and Assert
    assertEquals("String&amp;42", SafeStringUtils.escapeAmpersand("String&42"));
  }

  /**
   * Test {@link SafeStringUtils#escapeAmpersand(String)}.
   *
   * <ul>
   *   <li>When {@code String&(?!.{2,4};)&(?!.{2,4};)}.
   *   <li>Then return {@code String&amp;(?!.{2,4};)&amp;(?!.{2,4};)}.
   * </ul>
   *
   * <p>Method under test: {@link SafeStringUtils#escapeAmpersand(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String SafeStringUtils.escapeAmpersand(String)"})
  public void testEscapeAmpersand_whenString2424_thenReturnStringAmp24Amp24() {
    // Arrange, Act and Assert
    assertEquals(
        "String&amp;(?!.{2,4};)&amp;(?!.{2,4};)",
        SafeStringUtils.escapeAmpersand("String&(?!.{2,4};)&(?!.{2,4};)"));
  }

  /**
   * Test {@link SafeStringUtils#escapeAmpersand(String)}.
   *
   * <ul>
   *   <li>When {@code String&(?!.{2,4};)42}.
   *   <li>Then return {@code String&amp;(?!.{2,4};)42}.
   * </ul>
   *
   * <p>Method under test: {@link SafeStringUtils#escapeAmpersand(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String SafeStringUtils.escapeAmpersand(String)"})
  public void testEscapeAmpersand_whenString2442_thenReturnStringAmp2442() {
    // Arrange, Act and Assert
    assertEquals(
        "String&amp;(?!.{2,4};)42", SafeStringUtils.escapeAmpersand("String&(?!.{2,4};)42"));
  }

  /**
   * Test {@link SafeStringUtils#escapeAmpersand(String)}.
   *
   * <ul>
   *   <li>When {@code String42&(?!.{2,4};)}.
   *   <li>Then return {@code String42&amp;(?!.{2,4};)}.
   * </ul>
   *
   * <p>Method under test: {@link SafeStringUtils#escapeAmpersand(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String SafeStringUtils.escapeAmpersand(String)"})
  public void testEscapeAmpersand_whenString4224_thenReturnString42Amp24() {
    // Arrange, Act and Assert
    assertEquals(
        "String42&amp;(?!.{2,4};)", SafeStringUtils.escapeAmpersand("String42&(?!.{2,4};)"));
  }

  /**
   * Test {@link SafeStringUtils#escapeAmpersand(String)}.
   *
   * <ul>
   *   <li>When {@code String&amp;&(?!.{2,4};)}.
   *   <li>Then return {@code String&amp;&amp;(?!.{2,4};)}.
   * </ul>
   *
   * <p>Method under test: {@link SafeStringUtils#escapeAmpersand(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String SafeStringUtils.escapeAmpersand(String)"})
  public void testEscapeAmpersand_whenStringAmp24_thenReturnStringAmpAmp24() {
    // Arrange, Act and Assert
    assertEquals(
        "String&amp;&amp;(?!.{2,4};)", SafeStringUtils.escapeAmpersand("String&amp;&(?!.{2,4};)"));
  }

  /**
   * Test {@link SafeStringUtils#escapeAmpersand(String)}.
   *
   * <ul>
   *   <li>When {@code &String&amp;}.
   *   <li>Then return {@code &amp;String&amp;}.
   * </ul>
   *
   * <p>Method under test: {@link SafeStringUtils#escapeAmpersand(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String SafeStringUtils.escapeAmpersand(String)"})
  public void testEscapeAmpersand_whenStringAmp_thenReturnAmpStringAmp() {
    // Arrange, Act and Assert
    assertEquals("&amp;String&amp;", SafeStringUtils.escapeAmpersand("&String&amp;"));
  }

  /**
   * Test {@link SafeStringUtils#escapeAmpersand(String)}.
   *
   * <ul>
   *   <li>When {@code String&amp;&}.
   *   <li>Then return {@code String&amp;&amp;}.
   * </ul>
   *
   * <p>Method under test: {@link SafeStringUtils#escapeAmpersand(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String SafeStringUtils.escapeAmpersand(String)"})
  public void testEscapeAmpersand_whenStringAmp_thenReturnStringAmpAmp() {
    // Arrange, Act and Assert
    assertEquals("String&amp;&amp;", SafeStringUtils.escapeAmpersand("String&amp;&"));
  }

  /**
   * Test {@link SafeStringUtils#escapeAmpersand(String)}.
   *
   * <ul>
   *   <li>When {@code StringString&(?!.{2,4};)}.
   *   <li>Then return {@code StringString&amp;(?!.{2,4};)}.
   * </ul>
   *
   * <p>Method under test: {@link SafeStringUtils#escapeAmpersand(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String SafeStringUtils.escapeAmpersand(String)"})
  public void testEscapeAmpersand_whenStringString24_thenReturnStringStringAmp24() {
    // Arrange, Act and Assert
    assertEquals(
        "StringString&amp;(?!.{2,4};)",
        SafeStringUtils.escapeAmpersand("StringString&(?!.{2,4};)"));
  }

  /**
   * Test {@link SafeStringUtils#escapeAmpersand(String)}.
   *
   * <ul>
   *   <li>When {@code &StringString}.
   *   <li>Then return {@code &amp;StringString}.
   * </ul>
   *
   * <p>Method under test: {@link SafeStringUtils#escapeAmpersand(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String SafeStringUtils.escapeAmpersand(String)"})
  public void testEscapeAmpersand_whenStringString_thenReturnAmpStringString() {
    // Arrange, Act and Assert
    assertEquals("&amp;StringString", SafeStringUtils.escapeAmpersand("&StringString"));
  }

  /**
   * Test {@link SafeStringUtils#escapeAmpersand(String)}.
   *
   * <ul>
   *   <li>When {@code String&String}.
   *   <li>Then return {@code String&amp;String}.
   * </ul>
   *
   * <p>Method under test: {@link SafeStringUtils#escapeAmpersand(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String SafeStringUtils.escapeAmpersand(String)"})
  public void testEscapeAmpersand_whenStringString_thenReturnStringAmpString() {
    // Arrange, Act and Assert
    assertEquals("String&amp;String", SafeStringUtils.escapeAmpersand("String&String"));
  }

  /**
   * Test {@link SafeStringUtils#escapeAmpersand(String)}.
   *
   * <ul>
   *   <li>When {@code StringString&}.
   *   <li>Then return {@code StringString&amp;}.
   * </ul>
   *
   * <p>Method under test: {@link SafeStringUtils#escapeAmpersand(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String SafeStringUtils.escapeAmpersand(String)"})
  public void testEscapeAmpersand_whenStringString_thenReturnStringStringAmp() {
    // Arrange, Act and Assert
    assertEquals("StringString&amp;", SafeStringUtils.escapeAmpersand("StringString&"));
  }

  /**
   * Test {@link SafeStringUtils#escapeAmpersand(String)}.
   *
   * <ul>
   *   <li>When {@code &&String}.
   *   <li>Then return {@code &amp;&amp;String}.
   * </ul>
   *
   * <p>Method under test: {@link SafeStringUtils#escapeAmpersand(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String SafeStringUtils.escapeAmpersand(String)"})
  public void testEscapeAmpersand_whenString_thenReturnAmpAmpString() {
    // Arrange, Act and Assert
    assertEquals("&amp;&amp;String", SafeStringUtils.escapeAmpersand("&&String"));
  }

  /**
   * Test {@link SafeStringUtils#escapeAmpersand(String)}.
   *
   * <ul>
   *   <li>When {@code &String}.
   *   <li>Then return {@code &amp;String}.
   * </ul>
   *
   * <p>Method under test: {@link SafeStringUtils#escapeAmpersand(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String SafeStringUtils.escapeAmpersand(String)"})
  public void testEscapeAmpersand_whenString_thenReturnAmpString() {
    // Arrange, Act and Assert
    assertEquals("&amp;String", SafeStringUtils.escapeAmpersand("&String"));
  }

  /**
   * Test {@link SafeStringUtils#escapeAmpersand(String)}.
   *
   * <ul>
   *   <li>When {@code &String&}.
   *   <li>Then return {@code &amp;String&amp;}.
   * </ul>
   *
   * <p>Method under test: {@link SafeStringUtils#escapeAmpersand(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String SafeStringUtils.escapeAmpersand(String)"})
  public void testEscapeAmpersand_whenString_thenReturnAmpStringAmp() {
    // Arrange, Act and Assert
    assertEquals("&amp;String&amp;", SafeStringUtils.escapeAmpersand("&String&"));
  }

  /**
   * Test {@link SafeStringUtils#escapeAmpersand(String)}.
   *
   * <ul>
   *   <li>When {@code String}.
   *   <li>Then return {@code String}.
   * </ul>
   *
   * <p>Method under test: {@link SafeStringUtils#escapeAmpersand(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String SafeStringUtils.escapeAmpersand(String)"})
  public void testEscapeAmpersand_whenString_thenReturnString() {
    // Arrange, Act and Assert
    assertEquals("String", SafeStringUtils.escapeAmpersand("String"));
  }

  /**
   * Test {@link SafeStringUtils#escapeAmpersand(String)}.
   *
   * <ul>
   *   <li>When {@code String&}.
   *   <li>Then return {@code String&amp;}.
   * </ul>
   *
   * <p>Method under test: {@link SafeStringUtils#escapeAmpersand(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String SafeStringUtils.escapeAmpersand(String)"})
  public void testEscapeAmpersand_whenString_thenReturnStringAmp() {
    // Arrange, Act and Assert
    assertEquals("String&amp;", SafeStringUtils.escapeAmpersand("String&"));
  }

  /**
   * Test {@link SafeStringUtils#escapeAmpersand(String)}.
   *
   * <ul>
   *   <li>When {@code String&&}.
   *   <li>Then return {@code String&amp;&amp;}.
   * </ul>
   *
   * <p>Method under test: {@link SafeStringUtils#escapeAmpersand(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String SafeStringUtils.escapeAmpersand(String)"})
  public void testEscapeAmpersand_whenString_thenReturnStringAmpAmp() {
    // Arrange, Act and Assert
    assertEquals("String&amp;&amp;", SafeStringUtils.escapeAmpersand("String&&"));
  }

  /**
   * Test {@link SafeStringUtils#stringValueOf(SafeString)}.
   *
   * <ul>
   *   <li>When {@link SafeString#EMPTY_SAFE_STRING}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link SafeStringUtils#stringValueOf(SafeString)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String SafeStringUtils.stringValueOf(SafeString)"})
  public void testStringValueOf_whenEmpty_safe_string_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", SafeStringUtils.stringValueOf(SafeString.EMPTY_SAFE_STRING));
  }

  /**
   * Test {@link SafeStringUtils#stringValueOf(SafeString)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SafeStringUtils#stringValueOf(SafeString)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String SafeStringUtils.stringValueOf(SafeString)"})
  public void testStringValueOf_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(SafeStringUtils.stringValueOf(null));
  }

  /**
   * Test {@link SafeStringUtils#isEmpty(SafeString)}.
   *
   * <ul>
   *   <li>When {@link SafeString#EMPTY_SAFE_STRING}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link SafeStringUtils#isEmpty(SafeString)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Boolean SafeStringUtils.isEmpty(SafeString)"})
  public void testIsEmpty_whenEmpty_safe_string_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(SafeStringUtils.isEmpty(SafeString.EMPTY_SAFE_STRING));
  }

  /**
   * Test {@link SafeStringUtils#isEmpty(SafeString)}.
   *
   * <ul>
   *   <li>When escapeAndAddLineBreaks {@code String}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SafeStringUtils#isEmpty(SafeString)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Boolean SafeStringUtils.isEmpty(SafeString)"})
  public void testIsEmpty_whenEscapeAndAddLineBreaksString_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(SafeStringUtils.isEmpty(ParserUtils.escapeAndAddLineBreaks("String")));
  }

  /**
   * Test {@link SafeStringUtils#isEmpty(SafeString)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link SafeStringUtils#isEmpty(SafeString)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Boolean SafeStringUtils.isEmpty(SafeString)"})
  public void testIsEmpty_whenNull_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(SafeStringUtils.isEmpty(null));
  }

  /**
   * Test {@link SafeStringUtils#isBlank(SafeString)}.
   *
   * <ul>
   *   <li>When {@link SafeString#EMPTY_SAFE_STRING}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link SafeStringUtils#isBlank(SafeString)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Boolean SafeStringUtils.isBlank(SafeString)"})
  public void testIsBlank_whenEmpty_safe_string_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(SafeStringUtils.isBlank(SafeString.EMPTY_SAFE_STRING));
  }

  /**
   * Test {@link SafeStringUtils#isBlank(SafeString)}.
   *
   * <ul>
   *   <li>When escapeAndAddLineBreaks {@code String}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SafeStringUtils#isBlank(SafeString)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Boolean SafeStringUtils.isBlank(SafeString)"})
  public void testIsBlank_whenEscapeAndAddLineBreaksString_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(SafeStringUtils.isBlank(ParserUtils.escapeAndAddLineBreaks("String")));
  }

  /**
   * Test {@link SafeStringUtils#isBlank(SafeString)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link SafeStringUtils#isBlank(SafeString)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Boolean SafeStringUtils.isBlank(SafeString)"})
  public void testIsBlank_whenNull_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(SafeStringUtils.isBlank(null));
  }

  /**
   * Test {@link SafeStringUtils#isAnyBlank(SafeString[])}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link SafeStringUtils#isAnyBlank(SafeString[])}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Boolean SafeStringUtils.isAnyBlank(SafeString[])"})
  public void testIsAnyBlank_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(SafeStringUtils.isAnyBlank());
  }

  /**
   * Test {@link SafeStringUtils#isAnyBlank(SafeString[])}.
   *
   * <ul>
   *   <li>When {@link SafeString#EMPTY_SAFE_STRING}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link SafeStringUtils#isAnyBlank(SafeString[])}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Boolean SafeStringUtils.isAnyBlank(SafeString[])"})
  public void testIsAnyBlank_whenEmpty_safe_string_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(SafeStringUtils.isAnyBlank(SafeString.EMPTY_SAFE_STRING));
  }

  /**
   * Test {@link SafeStringUtils#isAnyBlank(SafeString[])}.
   *
   * <ul>
   *   <li>When escapeAndAddLineBreaks {@code String}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SafeStringUtils#isAnyBlank(SafeString[])}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Boolean SafeStringUtils.isAnyBlank(SafeString[])"})
  public void testIsAnyBlank_whenEscapeAndAddLineBreaksString_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(SafeStringUtils.isAnyBlank(ParserUtils.escapeAndAddLineBreaks("String")));
  }

  /**
   * Test {@link SafeStringUtils#isAnyBlank(SafeString[])}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link SafeStringUtils#isAnyBlank(SafeString[])}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Boolean SafeStringUtils.isAnyBlank(SafeString[])"})
  public void testIsAnyBlank_whenNull_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(SafeStringUtils.isAnyBlank(null));
  }

  /**
   * Test {@link SafeStringUtils#isAnyBlank(SafeString[])}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link SafeStringUtils#isAnyBlank(SafeString[])}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Boolean SafeStringUtils.isAnyBlank(SafeString[])"})
  public void testIsAnyBlank_whenNull_thenReturnTrue2() {
    // Arrange, Act and Assert
    assertTrue(SafeStringUtils.isAnyBlank(null));
  }

  /**
   * Test {@link SafeStringUtils#concat(SafeString[])}.
   *
   * <ul>
   *   <li>When {@link SafeString#EMPTY_SAFE_STRING}.
   *   <li>Then first element is {@link SafeString#EMPTY_SAFE_STRING}.
   * </ul>
   *
   * <p>Method under test: {@link SafeStringUtils#concat(SafeString[])}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString SafeStringUtils.concat(SafeString[])"})
  public void testConcat_whenEmpty_safe_string_thenFirstElementIsEmpty_safe_string() {
    // Arrange
    SafeString[] safeStrings = new SafeString[] {SafeString.EMPTY_SAFE_STRING};

    // Act and Assert
    assertEquals("", SafeStringUtils.concat(safeStrings).toString());
    assertEquals(1, safeStrings.length);
    assertSame(SafeString.EMPTY_SAFE_STRING, safeStrings[0]);
  }

  /**
   * Test {@link SafeStringUtils#concat(SafeString[])}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SafeStringUtils#concat(SafeString[])}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString SafeStringUtils.concat(SafeString[])"})
  public void testConcat_whenNull() {
    // Arrange and Act
    SafeString actualConcatResult = SafeStringUtils.concat(null);

    // Assert
    assertEquals("", actualConcatResult.toString());
  }

  /**
   * Test {@link SafeStringUtils#concat(SafeString[])}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then first element is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SafeStringUtils#concat(SafeString[])}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"SafeString SafeStringUtils.concat(SafeString[])"})
  public void testConcat_whenNull_thenFirstElementIsNull() {
    // Arrange
    SafeString[] safeStrings = new SafeString[] {null};

    // Act and Assert
    assertEquals("", SafeStringUtils.concat(safeStrings).toString());
    assertNull(safeStrings[0]);
    assertEquals(1, safeStrings.length);
  }
}
