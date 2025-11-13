package org.symphonyoss.integration.exception;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;

public class ExceptionMessageFormatterDiffblueTest {
  /**
   * Test {@link ExceptionMessageFormatter#format(String, String, String[])} with {@code component},
   * {@code message}, {@code solutions}.
   *
   * <p>Method under test: {@link ExceptionMessageFormatter#format(String, String, String[])}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ExceptionMessageFormatter.format(String, String, String[])"})
  public void testFormatWithComponentMessageSolutions() {
    // Arrange and Act
    String actualFormatResult =
        ExceptionMessageFormatter.format("Component", "An error occurred", "Solutions");

    // Assert
    assertEquals(
        "\nComponent: Component\nMessage: An error occurred\nSolutions: \nSolutions\n",
        actualFormatResult);
  }

  /**
   * Test {@link ExceptionMessageFormatter#format(String, String, String[])} with {@code component},
   * {@code message}, {@code solutions}.
   *
   * <p>Method under test: {@link ExceptionMessageFormatter#format(String, String, String[])}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ExceptionMessageFormatter.format(String, String, String[])"})
  public void testFormatWithComponentMessageSolutions2() {
    // Arrange and Act
    String actualFormatResult =
        ExceptionMessageFormatter.format("Component", "An error occurred", "\n", "Component: ");

    // Assert
    assertEquals(
        "\nComponent: Component\nMessage: An error occurred\nSolutions: \n\n\nComponent: \n",
        actualFormatResult);
  }

  /**
   * Test {@link ExceptionMessageFormatter#format(String, String, String[])} with {@code component},
   * {@code message}, {@code solutions}.
   *
   * <p>Method under test: {@link ExceptionMessageFormatter#format(String, String, String[])}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ExceptionMessageFormatter.format(String, String, String[])"})
  public void testFormatWithComponentMessageSolutions3() {
    // Arrange and Act
    String actualFormatResult =
        ExceptionMessageFormatter.format(null, "An error occurred", "Solutions");

    // Assert
    assertEquals(
        "\nComponent: Unknown\nMessage: An error occurred\nSolutions: \nSolutions\n",
        actualFormatResult);
  }

  /**
   * Test {@link ExceptionMessageFormatter#format(String, String, String[])} with {@code component},
   * {@code message}, {@code solutions}.
   *
   * <p>Method under test: {@link ExceptionMessageFormatter#format(String, String, String[])}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ExceptionMessageFormatter.format(String, String, String[])"})
  public void testFormatWithComponentMessageSolutions4() {
    // Arrange and Act
    String actualFormatResult =
        ExceptionMessageFormatter.format("", "An error occurred", "Solutions");

    // Assert
    assertEquals(
        "\nComponent: Unknown\nMessage: An error occurred\nSolutions: \nSolutions\n",
        actualFormatResult);
  }

  /**
   * Test {@link ExceptionMessageFormatter#format(String, String, String[])} with {@code component},
   * {@code message}, {@code solutions}.
   *
   * <p>Method under test: {@link ExceptionMessageFormatter#format(String, String, String[])}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ExceptionMessageFormatter.format(String, String, String[])"})
  public void testFormatWithComponentMessageSolutions5() {
    // Arrange and Act
    String actualFormatResult = ExceptionMessageFormatter.format("Component", null, "Solutions");

    // Assert
    assertEquals(
        "\nComponent: Component\nMessage: None\nSolutions: \nSolutions\n", actualFormatResult);
  }

  /**
   * Test {@link ExceptionMessageFormatter#format(String, String, String[])} with {@code component},
   * {@code message}, {@code solutions}.
   *
   * <p>Method under test: {@link ExceptionMessageFormatter#format(String, String, String[])}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ExceptionMessageFormatter.format(String, String, String[])"})
  public void testFormatWithComponentMessageSolutions6() {
    // Arrange and Act
    String actualFormatResult =
        ExceptionMessageFormatter.format("Component", "An error occurred", (String) null);

    // Assert
    assertEquals(
        "\nComponent: Component\nMessage: An error occurred\nSolutions: \n\n", actualFormatResult);
  }

  /**
   * Test {@link ExceptionMessageFormatter#format(String, String, String[])} with {@code component},
   * {@code message}, {@code solutions}.
   *
   * <p>Method under test: {@link ExceptionMessageFormatter#format(String, String, String[])}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ExceptionMessageFormatter.format(String, String, String[])"})
  public void testFormatWithComponentMessageSolutions7() {
    // Arrange and Act
    String actualFormatResult =
        ExceptionMessageFormatter.format("Component", "An error occurred", "");

    // Assert
    assertEquals(
        "\nComponent: Component\nMessage: An error occurred\nSolutions: \n\n", actualFormatResult);
  }

  /**
   * Test {@link ExceptionMessageFormatter#format(String, String, String[])} with {@code component},
   * {@code message}, {@code solutions}.
   *
   * <ul>
   *   <li>When {@code Component}.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link ExceptionMessageFormatter#format(String, String, String[])}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ExceptionMessageFormatter.format(String, String, String[])"})
  public void testFormatWithComponentMessageSolutions_whenComponent_thenReturnAString() {
    // Arrange, Act and Assert
    assertEquals(
        "\n"
            + "Component: Component\n"
            + "Message: An error occurred\n"
            + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        ExceptionMessageFormatter.format("Component", "An error occurred", new String[] {}));
  }

  /**
   * Test {@link ExceptionMessageFormatter#format(String, String, String[])} with {@code component},
   * {@code message}, {@code solutions}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link ExceptionMessageFormatter#format(String, String, String[])}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ExceptionMessageFormatter.format(String, String, String[])"})
  public void testFormatWithComponentMessageSolutions_whenNull_thenReturnAString() {
    // Arrange and Act
    String actualFormatResult =
        ExceptionMessageFormatter.format("Component", "An error occurred", (String[]) null);

    // Assert
    assertEquals(
        "\n"
            + "Component: Component\n"
            + "Message: An error occurred\n"
            + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualFormatResult);
  }

  /**
   * Test {@link ExceptionMessageFormatter#format(String, String, Throwable, String[])} with {@code
   * component}, {@code message}, {@code t}, {@code solutions}.
   *
   * <p>Method under test: {@link ExceptionMessageFormatter#format(String, String, Throwable,
   * String[])}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ExceptionMessageFormatter.format(String, String, Throwable, String[])"
  })
  public void testFormatWithComponentMessageTSolutions() {
    // Arrange and Act
    String actualFormatResult =
        ExceptionMessageFormatter.format(
            "Component", "An error occurred", new Throwable(), "Solutions");

    // Assert
    assertEquals(
        "\nComponent: Component\nMessage: An error occurred\nSolutions: \nSolutions\nStack trace: \n",
        actualFormatResult);
  }

  /**
   * Test {@link ExceptionMessageFormatter#format(String, String, Throwable, String[])} with {@code
   * component}, {@code message}, {@code t}, {@code solutions}.
   *
   * <p>Method under test: {@link ExceptionMessageFormatter#format(String, String, Throwable,
   * String[])}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ExceptionMessageFormatter.format(String, String, Throwable, String[])"
  })
  public void testFormatWithComponentMessageTSolutions2() {
    // Arrange and Act
    String actualFormatResult =
        ExceptionMessageFormatter.format(
            "Component", "An error occurred", new Throwable(), "\n", "Component: ");

    // Assert
    assertEquals(
        "\nComponent: Component\nMessage: An error occurred\nSolutions: \n\n\nComponent: \nStack trace: \n",
        actualFormatResult);
  }

  /**
   * Test {@link ExceptionMessageFormatter#format(String, String, Throwable, String[])} with {@code
   * component}, {@code message}, {@code t}, {@code solutions}.
   *
   * <p>Method under test: {@link ExceptionMessageFormatter#format(String, String, Throwable,
   * String[])}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ExceptionMessageFormatter.format(String, String, Throwable, String[])"
  })
  public void testFormatWithComponentMessageTSolutions3() {
    // Arrange and Act
    String actualFormatResult =
        ExceptionMessageFormatter.format(null, "An error occurred", new Throwable(), "Solutions");

    // Assert
    assertEquals(
        "\nComponent: Unknown\nMessage: An error occurred\nSolutions: \nSolutions\nStack trace: \n",
        actualFormatResult);
  }

  /**
   * Test {@link ExceptionMessageFormatter#format(String, String, Throwable, String[])} with {@code
   * component}, {@code message}, {@code t}, {@code solutions}.
   *
   * <p>Method under test: {@link ExceptionMessageFormatter#format(String, String, Throwable,
   * String[])}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ExceptionMessageFormatter.format(String, String, Throwable, String[])"
  })
  public void testFormatWithComponentMessageTSolutions4() {
    // Arrange and Act
    String actualFormatResult =
        ExceptionMessageFormatter.format("", "An error occurred", new Throwable(), "Solutions");

    // Assert
    assertEquals(
        "\nComponent: Unknown\nMessage: An error occurred\nSolutions: \nSolutions\nStack trace: \n",
        actualFormatResult);
  }

  /**
   * Test {@link ExceptionMessageFormatter#format(String, String, Throwable, String[])} with {@code
   * component}, {@code message}, {@code t}, {@code solutions}.
   *
   * <p>Method under test: {@link ExceptionMessageFormatter#format(String, String, Throwable,
   * String[])}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ExceptionMessageFormatter.format(String, String, Throwable, String[])"
  })
  public void testFormatWithComponentMessageTSolutions5() {
    // Arrange and Act
    String actualFormatResult =
        ExceptionMessageFormatter.format("Component", null, new Throwable(), "Solutions");

    // Assert
    assertEquals(
        "\nComponent: Component\nMessage: None\nSolutions: \nSolutions\nStack trace: \n",
        actualFormatResult);
  }

  /**
   * Test {@link ExceptionMessageFormatter#format(String, String, Throwable, String[])} with {@code
   * component}, {@code message}, {@code t}, {@code solutions}.
   *
   * <p>Method under test: {@link ExceptionMessageFormatter#format(String, String, Throwable,
   * String[])}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ExceptionMessageFormatter.format(String, String, Throwable, String[])"
  })
  public void testFormatWithComponentMessageTSolutions6() {
    // Arrange and Act
    String actualFormatResult =
        ExceptionMessageFormatter.format("Component", "An error occurred", new Throwable(), "");

    // Assert
    assertEquals(
        "\nComponent: Component\nMessage: An error occurred\nSolutions: \n\nStack trace: \n",
        actualFormatResult);
  }

  /**
   * Test {@link ExceptionMessageFormatter#format(String, String, Throwable, String[])} with {@code
   * component}, {@code message}, {@code t}, {@code solutions}.
   *
   * <ul>
   *   <li>When {@code Component}.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link ExceptionMessageFormatter#format(String, String, Throwable,
   * String[])}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ExceptionMessageFormatter.format(String, String, Throwable, String[])"
  })
  public void testFormatWithComponentMessageTSolutions_whenComponent_thenReturnAString() {
    // Arrange and Act
    String actualFormatResult =
        ExceptionMessageFormatter.format(
            "Component", "An error occurred", new Throwable(), new String[] {});

    // Assert
    assertEquals(
        "\n"
            + "Component: Component\n"
            + "Message: An error occurred\n"
            + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n"
            + "Stack trace: \n",
        actualFormatResult);
  }

  /**
   * Test {@link ExceptionMessageFormatter#format(String, String, Throwable, String[])} with {@code
   * component}, {@code message}, {@code t}, {@code solutions}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link ExceptionMessageFormatter#format(String, String, Throwable,
   * String[])}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ExceptionMessageFormatter.format(String, String, Throwable, String[])"
  })
  public void testFormatWithComponentMessageTSolutions_whenNull_thenReturnAString() {
    // Arrange and Act
    String actualFormatResult =
        ExceptionMessageFormatter.format("Component", "An error occurred", new Throwable(), null);

    // Assert
    assertEquals(
        "\n"
            + "Component: Component\n"
            + "Message: An error occurred\n"
            + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n"
            + "Stack trace: \n",
        actualFormatResult);
  }

  /**
   * Test {@link ExceptionMessageFormatter#format(String, String, Throwable)} with {@code
   * component}, {@code message}, {@code t}.
   *
   * <ul>
   *   <li>When {@code Component}.
   * </ul>
   *
   * <p>Method under test: {@link ExceptionMessageFormatter#format(String, String, Throwable)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ExceptionMessageFormatter.format(String, String, Throwable)"})
  public void testFormatWithComponentMessageT_whenComponent() {
    // Arrange and Act
    String actualFormatResult =
        ExceptionMessageFormatter.format("Component", "An error occurred", new Throwable());

    // Assert
    assertEquals(
        "\n"
            + "Component: Component\n"
            + "Message: An error occurred\n"
            + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n"
            + "Stack trace: \n",
        actualFormatResult);
  }

  /**
   * Test {@link ExceptionMessageFormatter#format(String, String, Throwable)} with {@code
   * component}, {@code message}, {@code t}.
   *
   * <ul>
   *   <li>When {@code Component}.
   * </ul>
   *
   * <p>Method under test: {@link ExceptionMessageFormatter#format(String, String, Throwable)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ExceptionMessageFormatter.format(String, String, Throwable)"})
  public void testFormatWithComponentMessageT_whenComponent2() {
    // Arrange and Act
    String actualFormatResult =
        ExceptionMessageFormatter.format("Component", null, new Throwable());

    // Assert
    assertEquals(
        "\n"
            + "Component: Component\n"
            + "Message: None\n"
            + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n"
            + "Stack trace: \n",
        actualFormatResult);
  }

  /**
   * Test {@link ExceptionMessageFormatter#format(String, String, Throwable)} with {@code
   * component}, {@code message}, {@code t}.
   *
   * <ul>
   *   <li>When {@code Component}.
   * </ul>
   *
   * <p>Method under test: {@link ExceptionMessageFormatter#format(String, String, Throwable)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ExceptionMessageFormatter.format(String, String, Throwable)"})
  public void testFormatWithComponentMessageT_whenComponent3() {
    // Arrange and Act
    String actualFormatResult =
        ExceptionMessageFormatter.format("Component", "An error occurred", (Throwable) null);

    // Assert
    assertEquals(
        "\n"
            + "Component: Component\n"
            + "Message: An error occurred\n"
            + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualFormatResult);
  }

  /**
   * Test {@link ExceptionMessageFormatter#format(String, String, Throwable)} with {@code
   * component}, {@code message}, {@code t}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link ExceptionMessageFormatter#format(String, String, Throwable)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ExceptionMessageFormatter.format(String, String, Throwable)"})
  public void testFormatWithComponentMessageT_whenEmptyString() {
    // Arrange and Act
    String actualFormatResult =
        ExceptionMessageFormatter.format("", "An error occurred", new Throwable());

    // Assert
    assertEquals(
        "\n"
            + "Component: Unknown\n"
            + "Message: An error occurred\n"
            + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n"
            + "Stack trace: \n",
        actualFormatResult);
  }

  /**
   * Test {@link ExceptionMessageFormatter#format(String, String, Throwable)} with {@code
   * component}, {@code message}, {@code t}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ExceptionMessageFormatter#format(String, String, Throwable)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ExceptionMessageFormatter.format(String, String, Throwable)"})
  public void testFormatWithComponentMessageT_whenNull() {
    // Arrange and Act
    String actualFormatResult =
        ExceptionMessageFormatter.format(null, "An error occurred", new Throwable());

    // Assert
    assertEquals(
        "\n"
            + "Component: Unknown\n"
            + "Message: An error occurred\n"
            + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n"
            + "Stack trace: \n",
        actualFormatResult);
  }

  /**
   * Test {@link ExceptionMessageFormatter#format(String, String)} with {@code component}, {@code
   * message}.
   *
   * <ul>
   *   <li>When {@code Component}.
   * </ul>
   *
   * <p>Method under test: {@link ExceptionMessageFormatter#format(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ExceptionMessageFormatter.format(String, String)"})
  public void testFormatWithComponentMessage_whenComponent() {
    // Arrange, Act and Assert
    assertEquals(
        "\n"
            + "Component: Component\n"
            + "Message: An error occurred\n"
            + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        ExceptionMessageFormatter.format("Component", "An error occurred"));
  }

  /**
   * Test {@link ExceptionMessageFormatter#format(String, String)} with {@code component}, {@code
   * message}.
   *
   * <ul>
   *   <li>When {@code Component}.
   * </ul>
   *
   * <p>Method under test: {@link ExceptionMessageFormatter#format(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ExceptionMessageFormatter.format(String, String)"})
  public void testFormatWithComponentMessage_whenComponent2() {
    // Arrange, Act and Assert
    assertEquals(
        "\n"
            + "Component: Component\n"
            + "Message: None\n"
            + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        ExceptionMessageFormatter.format("Component", null));
  }

  /**
   * Test {@link ExceptionMessageFormatter#format(String, String)} with {@code component}, {@code
   * message}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link ExceptionMessageFormatter#format(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ExceptionMessageFormatter.format(String, String)"})
  public void testFormatWithComponentMessage_whenEmptyString() {
    // Arrange, Act and Assert
    assertEquals(
        "\n"
            + "Component: Unknown\n"
            + "Message: An error occurred\n"
            + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        ExceptionMessageFormatter.format("", "An error occurred"));
  }

  /**
   * Test {@link ExceptionMessageFormatter#format(String, String)} with {@code component}, {@code
   * message}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ExceptionMessageFormatter#format(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"String ExceptionMessageFormatter.format(String, String)"})
  public void testFormatWithComponentMessage_whenNull() {
    // Arrange, Act and Assert
    assertEquals(
        "\n"
            + "Component: Unknown\n"
            + "Message: An error occurred\n"
            + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        ExceptionMessageFormatter.format(null, "An error occurred"));
  }
}
