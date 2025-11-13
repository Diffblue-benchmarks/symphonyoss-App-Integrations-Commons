package org.symphonyoss.integration.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;

public class IntegrationUnavailableExceptionDiffblueTest {
  /**
   * Test {@link IntegrationUnavailableException#IntegrationUnavailableException(String)}.
   *
   * <p>Method under test: {@link
   * IntegrationUnavailableException#IntegrationUnavailableException(String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"void IntegrationUnavailableException.<init>(String)"})
  public void testNewIntegrationUnavailableException() {
    // Arrange and Act
    IntegrationUnavailableException actualIntegrationUnavailableException =
        new IntegrationUnavailableException("Configuration Type");

    // Assert
    assertEquals(
        "\n"
            + "Component: Webhook Dispatcher\n"
            + "Message: Configuration Configuration Type unavailable\n"
            + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualIntegrationUnavailableException.getLocalizedMessage());
    assertEquals(
        "\n"
            + "Component: Webhook Dispatcher\n"
            + "Message: Configuration Configuration Type unavailable\n"
            + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualIntegrationUnavailableException.getMessage());
    assertNull(actualIntegrationUnavailableException.getCause());
    assertEquals(0, actualIntegrationUnavailableException.getSuppressed().length);
  }

  /**
   * Test {@link IntegrationUnavailableException#IntegrationUnavailableException(String, String,
   * String[])}.
   *
   * <p>Method under test: {@link
   * IntegrationUnavailableException#IntegrationUnavailableException(String, String, String[])}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"void IntegrationUnavailableException.<init>(String, String, String[])"})
  public void testNewIntegrationUnavailableException2() {
    // Arrange and Act
    IntegrationUnavailableException actualIntegrationUnavailableException =
        new IntegrationUnavailableException("Component", "An error occurred", "Solutions");

    // Assert
    assertEquals(
        "\nComponent: Component\nMessage: An error occurred\nSolutions: \nSolutions\n",
        actualIntegrationUnavailableException.getLocalizedMessage());
    assertEquals(
        "\nComponent: Component\nMessage: An error occurred\nSolutions: \nSolutions\n",
        actualIntegrationUnavailableException.getMessage());
    assertNull(actualIntegrationUnavailableException.getCause());
    assertEquals(0, actualIntegrationUnavailableException.getSuppressed().length);
  }

  /**
   * Test {@link IntegrationUnavailableException#IntegrationUnavailableException(String, String,
   * String[])}.
   *
   * <p>Method under test: {@link
   * IntegrationUnavailableException#IntegrationUnavailableException(String, String, String[])}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"void IntegrationUnavailableException.<init>(String, String, String[])"})
  public void testNewIntegrationUnavailableException3() {
    // Arrange and Act
    IntegrationUnavailableException actualIntegrationUnavailableException =
        new IntegrationUnavailableException("", "An error occurred", "Solutions");

    // Assert
    assertEquals(
        "\nComponent: Unknown\nMessage: An error occurred\nSolutions: \nSolutions\n",
        actualIntegrationUnavailableException.getLocalizedMessage());
    assertEquals(
        "\nComponent: Unknown\nMessage: An error occurred\nSolutions: \nSolutions\n",
        actualIntegrationUnavailableException.getMessage());
    assertNull(actualIntegrationUnavailableException.getCause());
    assertEquals(0, actualIntegrationUnavailableException.getSuppressed().length);
  }

  /**
   * Test {@link IntegrationUnavailableException#IntegrationUnavailableException(String, String,
   * String[])}.
   *
   * <p>Method under test: {@link
   * IntegrationUnavailableException#IntegrationUnavailableException(String, String, String[])}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"void IntegrationUnavailableException.<init>(String, String, String[])"})
  public void testNewIntegrationUnavailableException4() {
    // Arrange and Act
    IntegrationUnavailableException actualIntegrationUnavailableException =
        new IntegrationUnavailableException("Component", "", "Solutions");

    // Assert
    assertEquals(
        "\nComponent: Component\nMessage: None\nSolutions: \nSolutions\n",
        actualIntegrationUnavailableException.getLocalizedMessage());
    assertEquals(
        "\nComponent: Component\nMessage: None\nSolutions: \nSolutions\n",
        actualIntegrationUnavailableException.getMessage());
    assertNull(actualIntegrationUnavailableException.getCause());
    assertEquals(0, actualIntegrationUnavailableException.getSuppressed().length);
  }

  /**
   * Test {@link IntegrationUnavailableException#IntegrationUnavailableException(String, String,
   * String[])}.
   *
   * <ul>
   *   <li>Then return LocalizedMessage is a string.
   * </ul>
   *
   * <p>Method under test: {@link
   * IntegrationUnavailableException#IntegrationUnavailableException(String, String, String[])}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"void IntegrationUnavailableException.<init>(String, String, String[])"})
  public void testNewIntegrationUnavailableException_thenReturnLocalizedMessageIsAString() {
    // Arrange and Act
    IntegrationUnavailableException actualIntegrationUnavailableException =
        new IntegrationUnavailableException("Component", "An error occurred");

    // Assert
    assertEquals(
        "\n"
            + "Component: Component\n"
            + "Message: An error occurred\n"
            + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualIntegrationUnavailableException.getLocalizedMessage());
    assertEquals(
        "\n"
            + "Component: Component\n"
            + "Message: An error occurred\n"
            + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualIntegrationUnavailableException.getMessage());
    assertNull(actualIntegrationUnavailableException.getCause());
    assertEquals(0, actualIntegrationUnavailableException.getSuppressed().length);
  }
}
