package org.symphonyoss.integration.exception.authentication;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import org.junit.Test;

public class ConnectivityExceptionDiffblueTest {
  /**
   * Method under test:
   * {@link ConnectivityException#ConnectivityException(String, String)}
   */
  @Test
  public void testNewConnectivityException() {
    // Arrange and Act
    ConnectivityException actualConnectivityException = new ConnectivityException("Component", "Service Name");

    // Assert
    assertEquals(
        "\n" + "Component: Component\n" + "Message: Integration Bridge can't reach Service Name service!\n"
            + "Solutions: \n" + "No solution has been cataloged for troubleshooting this problem.\n",
        actualConnectivityException.getLocalizedMessage());
    assertEquals(
        "\n" + "Component: Component\n" + "Message: Integration Bridge can't reach Service Name service!\n"
            + "Solutions: \n" + "No solution has been cataloged for troubleshooting this problem.\n",
        actualConnectivityException.getMessage());
    assertNull(actualConnectivityException.getCause());
    assertEquals(0, actualConnectivityException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link ConnectivityException#ConnectivityException(String, String)}
   */
  @Test
  public void testNewConnectivityException2() {
    // Arrange and Act
    ConnectivityException actualConnectivityException = new ConnectivityException(null, "Service Name");

    // Assert
    assertEquals(
        "\n" + "Component: Unknown\n" + "Message: Integration Bridge can't reach Service Name service!\n"
            + "Solutions: \n" + "No solution has been cataloged for troubleshooting this problem.\n",
        actualConnectivityException.getLocalizedMessage());
    assertEquals(
        "\n" + "Component: Unknown\n" + "Message: Integration Bridge can't reach Service Name service!\n"
            + "Solutions: \n" + "No solution has been cataloged for troubleshooting this problem.\n",
        actualConnectivityException.getMessage());
    assertNull(actualConnectivityException.getCause());
    assertEquals(0, actualConnectivityException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link ConnectivityException#ConnectivityException(String, String, Throwable)}
   */
  @Test
  public void testNewConnectivityException3() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    ConnectivityException actualConnectivityException = new ConnectivityException("Component", "Service Name", cause);

    // Assert
    assertEquals("\n" + "Component: Component\n" + "Message: Integration Bridge can't reach Service Name service!\n"
        + "Solutions: \n" + "No solution has been cataloged for troubleshooting this problem.\n" + "Stack trace: \n",
        actualConnectivityException.getLocalizedMessage());
    assertEquals("\n" + "Component: Component\n" + "Message: Integration Bridge can't reach Service Name service!\n"
        + "Solutions: \n" + "No solution has been cataloged for troubleshooting this problem.\n" + "Stack trace: \n",
        actualConnectivityException.getMessage());
    assertEquals(0, actualConnectivityException.getSuppressed().length);
    assertSame(cause, actualConnectivityException.getCause());
  }

  /**
   * Method under test:
   * {@link ConnectivityException#ConnectivityException(String, String, Throwable)}
   */
  @Test
  public void testNewConnectivityException4() {
    // Arrange and Act
    ConnectivityException actualConnectivityException = new ConnectivityException(null, "Service Name",
        (Throwable) null);

    // Assert
    assertEquals(
        "\n" + "Component: Unknown\n" + "Message: Integration Bridge can't reach Service Name service!\n"
            + "Solutions: \n" + "No solution has been cataloged for troubleshooting this problem.\n",
        actualConnectivityException.getLocalizedMessage());
    assertEquals(
        "\n" + "Component: Unknown\n" + "Message: Integration Bridge can't reach Service Name service!\n"
            + "Solutions: \n" + "No solution has been cataloged for troubleshooting this problem.\n",
        actualConnectivityException.getMessage());
    assertNull(actualConnectivityException.getCause());
    assertEquals(0, actualConnectivityException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link ConnectivityException#ConnectivityException(String, String, Throwable, String[])}
   */
  @Test
  public void testNewConnectivityException5() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    ConnectivityException actualConnectivityException = new ConnectivityException("Component", "Service Name", cause,
        "Solutions");

    // Assert
    assertEquals("\n" + "Component: Component\n" + "Message: Integration Bridge can't reach Service Name service!\n"
        + "Solutions: \n" + "Solutions\n" + "Stack trace: \n", actualConnectivityException.getLocalizedMessage());
    assertEquals("\n" + "Component: Component\n" + "Message: Integration Bridge can't reach Service Name service!\n"
        + "Solutions: \n" + "Solutions\n" + "Stack trace: \n", actualConnectivityException.getMessage());
    assertEquals(0, actualConnectivityException.getSuppressed().length);
    assertSame(cause, actualConnectivityException.getCause());
  }

  /**
   * Method under test:
   * {@link ConnectivityException#ConnectivityException(String, String, Throwable, String[])}
   */
  @Test
  public void testNewConnectivityException6() {
    // Arrange and Act
    ConnectivityException actualConnectivityException = new ConnectivityException(null, "Service Name", null, null);

    // Assert
    assertEquals(
        "\n" + "Component: Unknown\n" + "Message: Integration Bridge can't reach Service Name service!\n"
            + "Solutions: \n" + "No solution has been cataloged for troubleshooting this problem.\n",
        actualConnectivityException.getLocalizedMessage());
    assertEquals(
        "\n" + "Component: Unknown\n" + "Message: Integration Bridge can't reach Service Name service!\n"
            + "Solutions: \n" + "No solution has been cataloged for troubleshooting this problem.\n",
        actualConnectivityException.getMessage());
    assertNull(actualConnectivityException.getCause());
    assertEquals(0, actualConnectivityException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link ConnectivityException#ConnectivityException(String, String, Throwable, String[])}
   */
  @Test
  public void testNewConnectivityException7() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    ConnectivityException actualConnectivityException = new ConnectivityException("Component", "Service Name", cause);

    // Assert
    assertEquals("\n" + "Component: Component\n" + "Message: Integration Bridge can't reach Service Name service!\n"
        + "Solutions: \n" + "No solution has been cataloged for troubleshooting this problem.\n" + "Stack trace: \n",
        actualConnectivityException.getLocalizedMessage());
    assertEquals("\n" + "Component: Component\n" + "Message: Integration Bridge can't reach Service Name service!\n"
        + "Solutions: \n" + "No solution has been cataloged for troubleshooting this problem.\n" + "Stack trace: \n",
        actualConnectivityException.getMessage());
    assertEquals(0, actualConnectivityException.getSuppressed().length);
    assertSame(cause, actualConnectivityException.getCause());
  }

  /**
   * Method under test:
   * {@link ConnectivityException#ConnectivityException(String, String, String[])}
   */
  @Test
  public void testNewConnectivityException8() {
    // Arrange and Act
    ConnectivityException actualConnectivityException = new ConnectivityException("Component", "Service Name",
        "Solutions");

    // Assert
    assertEquals("\n" + "Component: Component\n" + "Message: Integration Bridge can't reach Service Name service!\n"
        + "Solutions: \n" + "Solutions\n", actualConnectivityException.getLocalizedMessage());
    assertEquals("\n" + "Component: Component\n" + "Message: Integration Bridge can't reach Service Name service!\n"
        + "Solutions: \n" + "Solutions\n", actualConnectivityException.getMessage());
    assertNull(actualConnectivityException.getCause());
    assertEquals(0, actualConnectivityException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link ConnectivityException#ConnectivityException(String, String, String[])}
   */
  @Test
  public void testNewConnectivityException9() {
    // Arrange and Act
    ConnectivityException actualConnectivityException = new ConnectivityException(null, "Service Name",
        (String[]) null);

    // Assert
    assertEquals(
        "\n" + "Component: Unknown\n" + "Message: Integration Bridge can't reach Service Name service!\n"
            + "Solutions: \n" + "No solution has been cataloged for troubleshooting this problem.\n",
        actualConnectivityException.getLocalizedMessage());
    assertEquals(
        "\n" + "Component: Unknown\n" + "Message: Integration Bridge can't reach Service Name service!\n"
            + "Solutions: \n" + "No solution has been cataloged for troubleshooting this problem.\n",
        actualConnectivityException.getMessage());
    assertNull(actualConnectivityException.getCause());
    assertEquals(0, actualConnectivityException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link ConnectivityException#ConnectivityException(String, String, String[])}
   */
  @Test
  public void testNewConnectivityException10() {
    // Arrange and Act
    ConnectivityException actualConnectivityException = new ConnectivityException("Component", "Service Name");

    // Assert
    assertEquals(
        "\n" + "Component: Component\n" + "Message: Integration Bridge can't reach Service Name service!\n"
            + "Solutions: \n" + "No solution has been cataloged for troubleshooting this problem.\n",
        actualConnectivityException.getLocalizedMessage());
    assertEquals(
        "\n" + "Component: Component\n" + "Message: Integration Bridge can't reach Service Name service!\n"
            + "Solutions: \n" + "No solution has been cataloged for troubleshooting this problem.\n",
        actualConnectivityException.getMessage());
    assertNull(actualConnectivityException.getCause());
    assertEquals(0, actualConnectivityException.getSuppressed().length);
  }
}
