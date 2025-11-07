package org.symphonyoss.integration.exception.authentication;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ConnectivityExceptionDiffblueTest {
  /**
   * Test {@link ConnectivityException#ConnectivityException(String, String)}.
   * <ul>
   *   <li>When {@code Component}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConnectivityException#ConnectivityException(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConnectivityException.<init>(String, String)"})
  public void testNewConnectivityException_whenComponent() {
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
   * Test {@link ConnectivityException#ConnectivityException(String, String, String[])}.
   * <ul>
   *   <li>When {@code Component}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConnectivityException#ConnectivityException(String, String, String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConnectivityException.<init>(String, String, String[])"})
  public void testNewConnectivityException_whenComponent2() {
    // Arrange and Act
    ConnectivityException actualConnectivityException = new ConnectivityException("Component", "Service Name",
        new String[]{});

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
   * Test {@link ConnectivityException#ConnectivityException(String, String, Throwable)}.
   * <ul>
   *   <li>When {@code Component}.</li>
   *   <li>Then return Cause is {@link Throwable#Throwable()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConnectivityException#ConnectivityException(String, String, Throwable)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConnectivityException.<init>(String, String, Throwable)"})
  public void testNewConnectivityException_whenComponent_thenReturnCauseIsThrowable() {
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
    assertSame(cause, actualConnectivityException.getCause());
  }

  /**
   * Test {@link ConnectivityException#ConnectivityException(String, String, Throwable, String[])}.
   * <ul>
   *   <li>When {@code Component}.</li>
   *   <li>Then return Cause is {@link Throwable#Throwable()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConnectivityException#ConnectivityException(String, String, Throwable, String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConnectivityException.<init>(String, String, Throwable, String[])"})
  public void testNewConnectivityException_whenComponent_thenReturnCauseIsThrowable2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    ConnectivityException actualConnectivityException = new ConnectivityException("Component", "Service Name", cause,
        new String[]{});

    // Assert
    assertEquals("\n" + "Component: Component\n" + "Message: Integration Bridge can't reach Service Name service!\n"
        + "Solutions: \n" + "No solution has been cataloged for troubleshooting this problem.\n" + "Stack trace: \n",
        actualConnectivityException.getLocalizedMessage());
    assertEquals("\n" + "Component: Component\n" + "Message: Integration Bridge can't reach Service Name service!\n"
        + "Solutions: \n" + "No solution has been cataloged for troubleshooting this problem.\n" + "Stack trace: \n",
        actualConnectivityException.getMessage());
    assertSame(cause, actualConnectivityException.getCause());
  }

  /**
   * Test {@link ConnectivityException#ConnectivityException(String, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConnectivityException#ConnectivityException(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConnectivityException.<init>(String, String)"})
  public void testNewConnectivityException_whenNull() {
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
   * Test {@link ConnectivityException#ConnectivityException(String, String, String[])}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConnectivityException#ConnectivityException(String, String, String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConnectivityException.<init>(String, String, String[])"})
  public void testNewConnectivityException_whenNull2() {
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
   * Test {@link ConnectivityException#ConnectivityException(String, String, Throwable)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return Cause is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConnectivityException#ConnectivityException(String, String, Throwable)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConnectivityException.<init>(String, String, Throwable)"})
  public void testNewConnectivityException_whenNull_thenReturnCauseIsNull() {
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
   * Test {@link ConnectivityException#ConnectivityException(String, String, Throwable, String[])}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return Cause is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConnectivityException#ConnectivityException(String, String, Throwable, String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConnectivityException.<init>(String, String, Throwable, String[])"})
  public void testNewConnectivityException_whenNull_thenReturnCauseIsNull2() {
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
   * Test {@link ConnectivityException#ConnectivityException(String, String, String[])}.
   * <ul>
   *   <li>When {@code Solutions}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConnectivityException#ConnectivityException(String, String, String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConnectivityException.<init>(String, String, String[])"})
  public void testNewConnectivityException_whenSolutions() {
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
   * Test {@link ConnectivityException#ConnectivityException(String, String, Throwable, String[])}.
   * <ul>
   *   <li>When {@code Solutions}.</li>
   *   <li>Then return Cause is {@link Throwable#Throwable()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConnectivityException#ConnectivityException(String, String, Throwable, String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConnectivityException.<init>(String, String, Throwable, String[])"})
  public void testNewConnectivityException_whenSolutions_thenReturnCauseIsThrowable() {
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
    assertSame(cause, actualConnectivityException.getCause());
  }
}
