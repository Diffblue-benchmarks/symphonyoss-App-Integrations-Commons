package org.symphonyoss.integration.exception.authentication;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;

public class ConnectivityExceptionDiffblueTest {
  /**
   * Test {@link ConnectivityException#ConnectivityException(String, String)}.
   *
   * <ul>
   *   <li>When {@code Component}.
   * </ul>
   *
   * <p>Method under test: {@link ConnectivityException#ConnectivityException(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConnectivityException.<init>(String, String)"})
  public void testNewConnectivityException_whenComponent() {
    // Arrange and Act
    ConnectivityException actualConnectivityException =
        new ConnectivityException("Component", "Service Name");

    // Assert
    assertEquals(
        "\n"
            + "Component: Component\n"
            + "Message: Integration Bridge can't reach Service Name service!\n"
            + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualConnectivityException.getLocalizedMessage());
    assertEquals(
        "\n"
            + "Component: Component\n"
            + "Message: Integration Bridge can't reach Service Name service!\n"
            + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualConnectivityException.getMessage());
    assertNull(actualConnectivityException.getCause());
    assertEquals(0, actualConnectivityException.getSuppressed().length);
  }

  /**
   * Test {@link ConnectivityException#ConnectivityException(String, String, String[])}.
   *
   * <ul>
   *   <li>When {@code Component}.
   * </ul>
   *
   * <p>Method under test: {@link ConnectivityException#ConnectivityException(String, String,
   * String[])}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConnectivityException.<init>(String, String, String[])"})
  public void testNewConnectivityException_whenComponent2() {
    // Arrange and Act
    ConnectivityException actualConnectivityException =
        new ConnectivityException("Component", "Service Name", "Solutions");

    // Assert
    assertEquals(
        "\n"
            + "Component: Component\n"
            + "Message: Integration Bridge can't reach Service Name service!\n"
            + "Solutions: \n"
            + "Solutions\n",
        actualConnectivityException.getLocalizedMessage());
    assertEquals(
        "\n"
            + "Component: Component\n"
            + "Message: Integration Bridge can't reach Service Name service!\n"
            + "Solutions: \n"
            + "Solutions\n",
        actualConnectivityException.getMessage());
    assertNull(actualConnectivityException.getCause());
    assertEquals(0, actualConnectivityException.getSuppressed().length);
  }

  /**
   * Test {@link ConnectivityException#ConnectivityException(String, String, String[])}.
   *
   * <ul>
   *   <li>When {@code Component}.
   * </ul>
   *
   * <p>Method under test: {@link ConnectivityException#ConnectivityException(String, String,
   * String[])}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConnectivityException.<init>(String, String, String[])"})
  public void testNewConnectivityException_whenComponent3() {
    // Arrange and Act
    ConnectivityException actualConnectivityException =
        new ConnectivityException("Component", "Service Name", new String[] {});

    // Assert
    assertEquals(
        "\n"
            + "Component: Component\n"
            + "Message: Integration Bridge can't reach Service Name service!\n"
            + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualConnectivityException.getLocalizedMessage());
    assertEquals(
        "\n"
            + "Component: Component\n"
            + "Message: Integration Bridge can't reach Service Name service!\n"
            + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualConnectivityException.getMessage());
    assertNull(actualConnectivityException.getCause());
    assertEquals(0, actualConnectivityException.getSuppressed().length);
  }

  /**
   * Test {@link ConnectivityException#ConnectivityException(String, String, Throwable)}.
   *
   * <ul>
   *   <li>When {@code Component}.
   *   <li>Then return Cause is {@link Throwable#Throwable()}.
   * </ul>
   *
   * <p>Method under test: {@link ConnectivityException#ConnectivityException(String, String,
   * Throwable)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConnectivityException.<init>(String, String, Throwable)"})
  public void testNewConnectivityException_whenComponent_thenReturnCauseIsThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    ConnectivityException actualConnectivityException =
        new ConnectivityException("Component", "Service Name", cause);

    // Assert
    assertEquals(
        "\n"
            + "Component: Component\n"
            + "Message: Integration Bridge can't reach Service Name service!\n"
            + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n"
            + "Stack trace: \n",
        actualConnectivityException.getLocalizedMessage());
    assertEquals(
        "\n"
            + "Component: Component\n"
            + "Message: Integration Bridge can't reach Service Name service!\n"
            + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n"
            + "Stack trace: \n",
        actualConnectivityException.getMessage());
    assertSame(cause, actualConnectivityException.getCause());
  }

  /**
   * Test {@link ConnectivityException#ConnectivityException(String, String, Throwable, String[])}.
   *
   * <ul>
   *   <li>When {@code Component}.
   *   <li>Then return Cause is {@link Throwable#Throwable()}.
   * </ul>
   *
   * <p>Method under test: {@link ConnectivityException#ConnectivityException(String, String,
   * Throwable, String[])}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConnectivityException.<init>(String, String, Throwable, String[])"})
  public void testNewConnectivityException_whenComponent_thenReturnCauseIsThrowable2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    ConnectivityException actualConnectivityException =
        new ConnectivityException("Component", "Service Name", cause, "Solutions");

    // Assert
    assertEquals(
        "\n"
            + "Component: Component\n"
            + "Message: Integration Bridge can't reach Service Name service!\n"
            + "Solutions: \n"
            + "Solutions\n"
            + "Stack trace: \n",
        actualConnectivityException.getLocalizedMessage());
    assertEquals(
        "\n"
            + "Component: Component\n"
            + "Message: Integration Bridge can't reach Service Name service!\n"
            + "Solutions: \n"
            + "Solutions\n"
            + "Stack trace: \n",
        actualConnectivityException.getMessage());
    assertSame(cause, actualConnectivityException.getCause());
  }

  /**
   * Test {@link ConnectivityException#ConnectivityException(String, String, Throwable, String[])}.
   *
   * <ul>
   *   <li>When {@code Component}.
   *   <li>Then return Cause is {@link Throwable#Throwable()}.
   * </ul>
   *
   * <p>Method under test: {@link ConnectivityException#ConnectivityException(String, String,
   * Throwable, String[])}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConnectivityException.<init>(String, String, Throwable, String[])"})
  public void testNewConnectivityException_whenComponent_thenReturnCauseIsThrowable3() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    ConnectivityException actualConnectivityException =
        new ConnectivityException("Component", "Service Name", cause, new String[] {});

    // Assert
    assertEquals(
        "\n"
            + "Component: Component\n"
            + "Message: Integration Bridge can't reach Service Name service!\n"
            + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n"
            + "Stack trace: \n",
        actualConnectivityException.getLocalizedMessage());
    assertEquals(
        "\n"
            + "Component: Component\n"
            + "Message: Integration Bridge can't reach Service Name service!\n"
            + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n"
            + "Stack trace: \n",
        actualConnectivityException.getMessage());
    assertSame(cause, actualConnectivityException.getCause());
  }

  /**
   * Test {@link ConnectivityException#ConnectivityException(String, String)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link ConnectivityException#ConnectivityException(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConnectivityException.<init>(String, String)"})
  public void testNewConnectivityException_whenEmptyString() {
    // Arrange and Act
    ConnectivityException actualConnectivityException =
        new ConnectivityException("", "Service Name");

    // Assert
    assertEquals(
        "\n"
            + "Component: Unknown\n"
            + "Message: Integration Bridge can't reach Service Name service!\n"
            + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualConnectivityException.getLocalizedMessage());
    assertEquals(
        "\n"
            + "Component: Unknown\n"
            + "Message: Integration Bridge can't reach Service Name service!\n"
            + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualConnectivityException.getMessage());
    assertNull(actualConnectivityException.getCause());
    assertEquals(0, actualConnectivityException.getSuppressed().length);
  }

  /**
   * Test {@link ConnectivityException#ConnectivityException(String, String, String[])}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link ConnectivityException#ConnectivityException(String, String,
   * String[])}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConnectivityException.<init>(String, String, String[])"})
  public void testNewConnectivityException_whenEmptyString2() {
    // Arrange and Act
    ConnectivityException actualConnectivityException =
        new ConnectivityException("", "Service Name", "Solutions");

    // Assert
    assertEquals(
        "\n"
            + "Component: Unknown\n"
            + "Message: Integration Bridge can't reach Service Name service!\n"
            + "Solutions: \n"
            + "Solutions\n",
        actualConnectivityException.getLocalizedMessage());
    assertEquals(
        "\n"
            + "Component: Unknown\n"
            + "Message: Integration Bridge can't reach Service Name service!\n"
            + "Solutions: \n"
            + "Solutions\n",
        actualConnectivityException.getMessage());
    assertNull(actualConnectivityException.getCause());
    assertEquals(0, actualConnectivityException.getSuppressed().length);
  }

  /**
   * Test {@link ConnectivityException#ConnectivityException(String, String, Throwable)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return Cause is {@link Throwable#Throwable()}.
   * </ul>
   *
   * <p>Method under test: {@link ConnectivityException#ConnectivityException(String, String,
   * Throwable)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConnectivityException.<init>(String, String, Throwable)"})
  public void testNewConnectivityException_whenEmptyString_thenReturnCauseIsThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    ConnectivityException actualConnectivityException =
        new ConnectivityException("", "Service Name", cause);

    // Assert
    assertEquals(
        "\n"
            + "Component: Unknown\n"
            + "Message: Integration Bridge can't reach Service Name service!\n"
            + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n"
            + "Stack trace: \n",
        actualConnectivityException.getLocalizedMessage());
    assertEquals(
        "\n"
            + "Component: Unknown\n"
            + "Message: Integration Bridge can't reach Service Name service!\n"
            + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n"
            + "Stack trace: \n",
        actualConnectivityException.getMessage());
    assertSame(cause, actualConnectivityException.getCause());
  }

  /**
   * Test {@link ConnectivityException#ConnectivityException(String, String, Throwable, String[])}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return Cause is {@link Throwable#Throwable()}.
   * </ul>
   *
   * <p>Method under test: {@link ConnectivityException#ConnectivityException(String, String,
   * Throwable, String[])}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConnectivityException.<init>(String, String, Throwable, String[])"})
  public void testNewConnectivityException_whenEmptyString_thenReturnCauseIsThrowable2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    ConnectivityException actualConnectivityException =
        new ConnectivityException("", "Service Name", cause, "Solutions");

    // Assert
    assertEquals(
        "\n"
            + "Component: Unknown\n"
            + "Message: Integration Bridge can't reach Service Name service!\n"
            + "Solutions: \n"
            + "Solutions\n"
            + "Stack trace: \n",
        actualConnectivityException.getLocalizedMessage());
    assertEquals(
        "\n"
            + "Component: Unknown\n"
            + "Message: Integration Bridge can't reach Service Name service!\n"
            + "Solutions: \n"
            + "Solutions\n"
            + "Stack trace: \n",
        actualConnectivityException.getMessage());
    assertSame(cause, actualConnectivityException.getCause());
  }

  /**
   * Test {@link ConnectivityException#ConnectivityException(String, String, Throwable)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return Cause is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ConnectivityException#ConnectivityException(String, String,
   * Throwable)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConnectivityException.<init>(String, String, Throwable)"})
  public void testNewConnectivityException_whenNull_thenReturnCauseIsNull() {
    // Arrange and Act
    ConnectivityException actualConnectivityException =
        new ConnectivityException("Component", "Service Name", (Throwable) null);

    // Assert
    assertEquals(
        "\n"
            + "Component: Component\n"
            + "Message: Integration Bridge can't reach Service Name service!\n"
            + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualConnectivityException.getLocalizedMessage());
    assertEquals(
        "\n"
            + "Component: Component\n"
            + "Message: Integration Bridge can't reach Service Name service!\n"
            + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualConnectivityException.getMessage());
    assertNull(actualConnectivityException.getCause());
    assertEquals(0, actualConnectivityException.getSuppressed().length);
  }
}
