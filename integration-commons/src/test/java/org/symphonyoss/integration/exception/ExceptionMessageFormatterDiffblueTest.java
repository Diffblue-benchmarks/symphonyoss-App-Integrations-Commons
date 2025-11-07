package org.symphonyoss.integration.exception;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ExceptionMessageFormatterDiffblueTest {
  /**
   * Method under test: {@link ExceptionMessageFormatter#format(String, String)}
   */
  @Test
  public void testFormat() {
    // Arrange, Act and Assert
    assertEquals(
        "\n" + "Component: Component\n" + "Message: An error occurred\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        ExceptionMessageFormatter.format("Component", "An error occurred"));
    assertEquals(
        "\n" + "Component: Unknown\n" + "Message: None\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        ExceptionMessageFormatter.format(null, null));
    assertEquals(
        "\n" + "Component: Unknown\n" + "Message: An error occurred\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        ExceptionMessageFormatter.format("", "An error occurred"));
    assertEquals(
        "\n" + "Component: Component\n" + "Message: An error occurred\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n" + "Stack trace: \n",
        ExceptionMessageFormatter.format("Component", "An error occurred", new Throwable()));
    assertEquals(
        "\n" + "Component: Unknown\n" + "Message: None\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        ExceptionMessageFormatter.format(null, null, (Throwable) null));
    assertEquals(
        "\n" + "Component: Unknown\n" + "Message: An error occurred\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n" + "Stack trace: \n",
        ExceptionMessageFormatter.format("", "An error occurred", new Throwable()));
    assertEquals("\nComponent: Component\nMessage: An error occurred\nSolutions: \nSolutions\nStack trace: \n",
        ExceptionMessageFormatter.format("Component", "An error occurred", new Throwable(), "Solutions"));
    assertEquals(
        "\n" + "Component: Unknown\n" + "Message: None\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        ExceptionMessageFormatter.format(null, null, null, null));
    assertEquals("\nComponent: Unknown\nMessage: An error occurred\nSolutions: \nSolutions\nStack trace: \n",
        ExceptionMessageFormatter.format("", "An error occurred", new Throwable(), "Solutions"));
    assertEquals("\nComponent: Component\nMessage: An error occurred\nSolutions: \n\nStack trace: \n",
        ExceptionMessageFormatter.format("Component", "An error occurred", new Throwable(), ""));
    assertEquals(
        "\n" + "Component: Component\n" + "Message: An error occurred\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n" + "Stack trace: \n",
        ExceptionMessageFormatter.format("Component", "An error occurred", new Throwable()));
    assertEquals("\nComponent: Component\nMessage: An error occurred\nSolutions: \n\n\nComponent: \nStack trace: \n",
        ExceptionMessageFormatter.format("Component", "An error occurred", new Throwable(), "\n", "Component: "));
    assertEquals("\nComponent: Component\nMessage: An error occurred\nSolutions: \nSolutions\n",
        ExceptionMessageFormatter.format("Component", "An error occurred", "Solutions"));
    assertEquals(
        "\n" + "Component: Unknown\n" + "Message: None\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        ExceptionMessageFormatter.format(null, null, (String[]) null));
    assertEquals("\nComponent: Unknown\nMessage: An error occurred\nSolutions: \nSolutions\n",
        ExceptionMessageFormatter.format("", "An error occurred", "Solutions"));
    assertEquals("\nComponent: Component\nMessage: An error occurred\nSolutions: \n\n",
        ExceptionMessageFormatter.format("Component", "An error occurred", ""));
    assertEquals(
        "\n" + "Component: Component\n" + "Message: An error occurred\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        ExceptionMessageFormatter.format("Component", "An error occurred"));
    assertEquals("\nComponent: Component\nMessage: An error occurred\nSolutions: \n\n\nComponent: \n",
        ExceptionMessageFormatter.format("Component", "An error occurred", "\n", "Component: "));
  }
}
