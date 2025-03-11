package org.symphonyoss.integration.exception;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;

public class ExceptionMessageFormatterDiffblueTest {
  /**
   * Test {@link ExceptionMessageFormatter#format(String, String, String[])} with {@code component}, {@code message}, {@code solutions}.
   * <p>
   * Method under test: {@link ExceptionMessageFormatter#format(String, String, String[])}
   */
  @Test
  @MethodsUnderTest({"String ExceptionMessageFormatter.format(String, String, String[])"})
  public void testFormatWithComponentMessageSolutions() {
    // Arrange, Act and Assert
    assertEquals("\nComponent: Component\nMessage: An error occurred\nSolutions: \nSolutions\n",
        ExceptionMessageFormatter.format("Component", "An error occurred", "Solutions"));
  }

  /**
   * Test {@link ExceptionMessageFormatter#format(String, String, String[])} with {@code component}, {@code message}, {@code solutions}.
   * <p>
   * Method under test: {@link ExceptionMessageFormatter#format(String, String, String[])}
   */
  @Test
  @MethodsUnderTest({"String ExceptionMessageFormatter.format(String, String, String[])"})
  public void testFormatWithComponentMessageSolutions2() {
    // Arrange, Act and Assert
    assertEquals("\nComponent: Unknown\nMessage: An error occurred\nSolutions: \nSolutions\n",
        ExceptionMessageFormatter.format("", "An error occurred", "Solutions"));
  }

  /**
   * Test {@link ExceptionMessageFormatter#format(String, String, String[])} with {@code component}, {@code message}, {@code solutions}.
   * <p>
   * Method under test: {@link ExceptionMessageFormatter#format(String, String, String[])}
   */
  @Test
  @MethodsUnderTest({"String ExceptionMessageFormatter.format(String, String, String[])"})
  public void testFormatWithComponentMessageSolutions3() {
    // Arrange, Act and Assert
    assertEquals("\nComponent: Component\nMessage: An error occurred\nSolutions: \n\n",
        ExceptionMessageFormatter.format("Component", "An error occurred", ""));
  }

  /**
   * Test {@link ExceptionMessageFormatter#format(String, String, String[])} with {@code component}, {@code message}, {@code solutions}.
   * <p>
   * Method under test: {@link ExceptionMessageFormatter#format(String, String, String[])}
   */
  @Test
  @MethodsUnderTest({"String ExceptionMessageFormatter.format(String, String, String[])"})
  public void testFormatWithComponentMessageSolutions4() {
    // Arrange, Act and Assert
    assertEquals("\nComponent: Component\nMessage: An error occurred\nSolutions: \n\n\nComponent: \n",
        ExceptionMessageFormatter.format("Component", "An error occurred", "\n", "Component: "));
  }

  /**
   * Test {@link ExceptionMessageFormatter#format(String, String, String[])} with {@code component}, {@code message}, {@code solutions}.
   * <ul>
   *   <li>When {@code Component}.</li>
   *   <li>Then return a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExceptionMessageFormatter#format(String, String, String[])}
   */
  @Test
  @MethodsUnderTest({"String ExceptionMessageFormatter.format(String, String, String[])"})
  public void testFormatWithComponentMessageSolutions_whenComponent_thenReturnAString() {
    // Arrange, Act and Assert
    assertEquals(
        "\n" + "Component: Component\n" + "Message: An error occurred\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        ExceptionMessageFormatter.format("Component", "An error occurred", new String[]{}));
  }

  /**
   * Test {@link ExceptionMessageFormatter#format(String, String, String[])} with {@code component}, {@code message}, {@code solutions}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExceptionMessageFormatter#format(String, String, String[])}
   */
  @Test
  @MethodsUnderTest({"String ExceptionMessageFormatter.format(String, String, String[])"})
  public void testFormatWithComponentMessageSolutions_whenNull_thenReturnAString() {
    // Arrange, Act and Assert
    assertEquals(
        "\n" + "Component: Unknown\n" + "Message: None\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        ExceptionMessageFormatter.format(null, null, (String[]) null));
  }

  /**
   * Test {@link ExceptionMessageFormatter#format(String, String, Throwable, String[])} with {@code component}, {@code message}, {@code t}, {@code solutions}.
   * <p>
   * Method under test: {@link ExceptionMessageFormatter#format(String, String, Throwable, String[])}
   */
  @Test
  @MethodsUnderTest({"String ExceptionMessageFormatter.format(String, String, Throwable, String[])"})
  public void testFormatWithComponentMessageTSolutions() {
    // Arrange, Act and Assert
    assertEquals("\nComponent: Component\nMessage: An error occurred\nSolutions: \nSolutions\nStack trace: \n",
        ExceptionMessageFormatter.format("Component", "An error occurred", new Throwable(), "Solutions"));
  }

  /**
   * Test {@link ExceptionMessageFormatter#format(String, String, Throwable, String[])} with {@code component}, {@code message}, {@code t}, {@code solutions}.
   * <p>
   * Method under test: {@link ExceptionMessageFormatter#format(String, String, Throwable, String[])}
   */
  @Test
  @MethodsUnderTest({"String ExceptionMessageFormatter.format(String, String, Throwable, String[])"})
  public void testFormatWithComponentMessageTSolutions2() {
    // Arrange, Act and Assert
    assertEquals("\nComponent: Unknown\nMessage: An error occurred\nSolutions: \nSolutions\nStack trace: \n",
        ExceptionMessageFormatter.format("", "An error occurred", new Throwable(), "Solutions"));
  }

  /**
   * Test {@link ExceptionMessageFormatter#format(String, String, Throwable, String[])} with {@code component}, {@code message}, {@code t}, {@code solutions}.
   * <p>
   * Method under test: {@link ExceptionMessageFormatter#format(String, String, Throwable, String[])}
   */
  @Test
  @MethodsUnderTest({"String ExceptionMessageFormatter.format(String, String, Throwable, String[])"})
  public void testFormatWithComponentMessageTSolutions3() {
    // Arrange, Act and Assert
    assertEquals("\nComponent: Component\nMessage: An error occurred\nSolutions: \n\nStack trace: \n",
        ExceptionMessageFormatter.format("Component", "An error occurred", new Throwable(), ""));
  }

  /**
   * Test {@link ExceptionMessageFormatter#format(String, String, Throwable, String[])} with {@code component}, {@code message}, {@code t}, {@code solutions}.
   * <p>
   * Method under test: {@link ExceptionMessageFormatter#format(String, String, Throwable, String[])}
   */
  @Test
  @MethodsUnderTest({"String ExceptionMessageFormatter.format(String, String, Throwable, String[])"})
  public void testFormatWithComponentMessageTSolutions4() {
    // Arrange, Act and Assert
    assertEquals("\nComponent: Component\nMessage: An error occurred\nSolutions: \n\n\nComponent: \nStack trace: \n",
        ExceptionMessageFormatter.format("Component", "An error occurred", new Throwable(), "\n", "Component: "));
  }

  /**
   * Test {@link ExceptionMessageFormatter#format(String, String, Throwable, String[])} with {@code component}, {@code message}, {@code t}, {@code solutions}.
   * <ul>
   *   <li>When {@code Component}.</li>
   *   <li>Then return a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExceptionMessageFormatter#format(String, String, Throwable, String[])}
   */
  @Test
  @MethodsUnderTest({"String ExceptionMessageFormatter.format(String, String, Throwable, String[])"})
  public void testFormatWithComponentMessageTSolutions_whenComponent_thenReturnAString() {
    // Arrange, Act and Assert
    assertEquals(
        "\n" + "Component: Component\n" + "Message: An error occurred\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n" + "Stack trace: \n",
        ExceptionMessageFormatter.format("Component", "An error occurred", new Throwable(), new String[]{}));
  }

  /**
   * Test {@link ExceptionMessageFormatter#format(String, String, Throwable, String[])} with {@code component}, {@code message}, {@code t}, {@code solutions}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExceptionMessageFormatter#format(String, String, Throwable, String[])}
   */
  @Test
  @MethodsUnderTest({"String ExceptionMessageFormatter.format(String, String, Throwable, String[])"})
  public void testFormatWithComponentMessageTSolutions_whenNull_thenReturnAString() {
    // Arrange, Act and Assert
    assertEquals(
        "\n" + "Component: Unknown\n" + "Message: None\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        ExceptionMessageFormatter.format(null, null, null, null));
  }

  /**
   * Test {@link ExceptionMessageFormatter#format(String, String, Throwable)} with {@code component}, {@code message}, {@code t}.
   * <ul>
   *   <li>When {@code Component}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExceptionMessageFormatter#format(String, String, Throwable)}
   */
  @Test
  @MethodsUnderTest({"String ExceptionMessageFormatter.format(String, String, Throwable)"})
  public void testFormatWithComponentMessageT_whenComponent() {
    // Arrange, Act and Assert
    assertEquals(
        "\n" + "Component: Component\n" + "Message: An error occurred\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n" + "Stack trace: \n",
        ExceptionMessageFormatter.format("Component", "An error occurred", new Throwable()));
  }

  /**
   * Test {@link ExceptionMessageFormatter#format(String, String, Throwable)} with {@code component}, {@code message}, {@code t}.
   * <ul>
   *   <li>When empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExceptionMessageFormatter#format(String, String, Throwable)}
   */
  @Test
  @MethodsUnderTest({"String ExceptionMessageFormatter.format(String, String, Throwable)"})
  public void testFormatWithComponentMessageT_whenEmptyString() {
    // Arrange, Act and Assert
    assertEquals(
        "\n" + "Component: Unknown\n" + "Message: An error occurred\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n" + "Stack trace: \n",
        ExceptionMessageFormatter.format("", "An error occurred", new Throwable()));
  }

  /**
   * Test {@link ExceptionMessageFormatter#format(String, String, Throwable)} with {@code component}, {@code message}, {@code t}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExceptionMessageFormatter#format(String, String, Throwable)}
   */
  @Test
  @MethodsUnderTest({"String ExceptionMessageFormatter.format(String, String, Throwable)"})
  public void testFormatWithComponentMessageT_whenNull() {
    // Arrange, Act and Assert
    assertEquals(
        "\n" + "Component: Unknown\n" + "Message: None\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        ExceptionMessageFormatter.format(null, null, (Throwable) null));
  }

  /**
   * Test {@link ExceptionMessageFormatter#format(String, String)} with {@code component}, {@code message}.
   * <ul>
   *   <li>When {@code Component}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExceptionMessageFormatter#format(String, String)}
   */
  @Test
  @MethodsUnderTest({"String ExceptionMessageFormatter.format(String, String)"})
  public void testFormatWithComponentMessage_whenComponent() {
    // Arrange, Act and Assert
    assertEquals(
        "\n" + "Component: Component\n" + "Message: An error occurred\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        ExceptionMessageFormatter.format("Component", "An error occurred"));
  }

  /**
   * Test {@link ExceptionMessageFormatter#format(String, String)} with {@code component}, {@code message}.
   * <ul>
   *   <li>When empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExceptionMessageFormatter#format(String, String)}
   */
  @Test
  @MethodsUnderTest({"String ExceptionMessageFormatter.format(String, String)"})
  public void testFormatWithComponentMessage_whenEmptyString() {
    // Arrange, Act and Assert
    assertEquals(
        "\n" + "Component: Unknown\n" + "Message: An error occurred\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        ExceptionMessageFormatter.format("", "An error occurred"));
  }

  /**
   * Test {@link ExceptionMessageFormatter#format(String, String)} with {@code component}, {@code message}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExceptionMessageFormatter#format(String, String)}
   */
  @Test
  @MethodsUnderTest({"String ExceptionMessageFormatter.format(String, String)"})
  public void testFormatWithComponentMessage_whenNull() {
    // Arrange, Act and Assert
    assertEquals(
        "\n" + "Component: Unknown\n" + "Message: None\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        ExceptionMessageFormatter.format(null, null));
  }
}
