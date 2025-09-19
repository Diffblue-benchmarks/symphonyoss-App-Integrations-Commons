package org.symphonyoss.integration.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import org.junit.Test;

public class RemoteApiExceptionDiffblueTest {
  /**
   * Test {@link RemoteApiException#RemoteApiException(int, Exception, String[])}.
   *
   * <p>Method under test: {@link RemoteApiException#RemoteApiException(int, Exception, String[])}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"void RemoteApiException.<init>(int, Exception, String[])"})
  public void testNewRemoteApiException() {
    // Arrange
    Exception e = new Exception();

    // Act
    RemoteApiException actualRemoteApiException = new RemoteApiException(1, e, "Solutions");

    // Assert
    assertEquals(
        "\nComponent: Commons\nMessage: None\nSolutions: \nSolutions\nStack trace: \n",
        actualRemoteApiException.getLocalizedMessage());
    assertEquals(
        "\nComponent: Commons\nMessage: None\nSolutions: \nSolutions\nStack trace: \n",
        actualRemoteApiException.getMessage());
    assertSame(e, actualRemoteApiException.getCause());
  }

  /**
   * Test {@link RemoteApiException#RemoteApiException(int, Exception, String[])}.
   *
   * <p>Method under test: {@link RemoteApiException#RemoteApiException(int, Exception, String[])}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"void RemoteApiException.<init>(int, Exception, String[])"})
  public void testNewRemoteApiException2() {
    // Arrange
    IOException e = new IOException(RemoteApiException.COMPONENT);

    // Act
    RemoteApiException actualRemoteApiException = new RemoteApiException(1, e, "Solutions");

    // Assert
    assertEquals(
        "\nComponent: Commons\nMessage: Commons\nSolutions: \nSolutions\nStack trace: Commons\n",
        actualRemoteApiException.getLocalizedMessage());
    assertEquals(
        "\nComponent: Commons\nMessage: Commons\nSolutions: \nSolutions\nStack trace: Commons\n",
        actualRemoteApiException.getMessage());
    assertSame(e, actualRemoteApiException.getCause());
  }

  /**
   * Test {@link RemoteApiException#RemoteApiException(int, String, Exception, String[])}.
   *
   * <p>Method under test: {@link RemoteApiException#RemoteApiException(int, String, Exception,
   * String[])}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"void RemoteApiException.<init>(int, String, Exception, String[])"})
  public void testNewRemoteApiException3() {
    // Arrange
    Exception e = new Exception();

    // Act
    RemoteApiException actualRemoteApiException =
        new RemoteApiException(1, "An error occurred", e, "Solutions");

    // Assert
    assertEquals(
        "\nComponent: Commons\nMessage: An error occurred\nSolutions: \nSolutions\nStack trace: \n",
        actualRemoteApiException.getLocalizedMessage());
    assertEquals(
        "\nComponent: Commons\nMessage: An error occurred\nSolutions: \nSolutions\nStack trace: \n",
        actualRemoteApiException.getMessage());
    assertSame(e, actualRemoteApiException.getCause());
  }

  /**
   * Test {@link RemoteApiException#RemoteApiException(int, String, String[])}.
   *
   * <p>Method under test: {@link RemoteApiException#RemoteApiException(int, String, String[])}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"void RemoteApiException.<init>(int, String, String[])"})
  public void testNewRemoteApiException4() {
    // Arrange and Act
    RemoteApiException actualRemoteApiException =
        new RemoteApiException(1, "An error occurred", "Solutions");

    // Assert
    assertEquals("An error occurred", actualRemoteApiException.getResponseMessage());
    assertEquals(
        "\nComponent: Commons\nMessage: An error occurred\nSolutions: \nSolutions\n",
        actualRemoteApiException.getLocalizedMessage());
    assertEquals(
        "\nComponent: Commons\nMessage: An error occurred\nSolutions: \nSolutions\n",
        actualRemoteApiException.getMessage());
    assertNull(actualRemoteApiException.getCause());
    assertEquals(0, actualRemoteApiException.getSuppressed().length);
    assertEquals(1, actualRemoteApiException.getCode());
  }

  /**
   * Test {@link RemoteApiException#RemoteApiException(int, Exception)}.
   *
   * <ul>
   *   <li>Then return Cause is {@link IOException#IOException(String)} with {@link
   *       RemoteApiException#COMPONENT}.
   * </ul>
   *
   * <p>Method under test: {@link RemoteApiException#RemoteApiException(int, Exception)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"void RemoteApiException.<init>(int, Exception)"})
  public void testNewRemoteApiException_thenReturnCauseIsIOExceptionWithComponent() {
    // Arrange
    IOException e = new IOException(RemoteApiException.COMPONENT);

    // Act
    RemoteApiException actualRemoteApiException = new RemoteApiException(1, e);

    // Assert
    assertEquals(
        "\n"
            + "Component: Commons\n"
            + "Message: Commons\n"
            + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n"
            + "Stack trace: Commons\n",
        actualRemoteApiException.getLocalizedMessage());
    assertEquals(
        "\n"
            + "Component: Commons\n"
            + "Message: Commons\n"
            + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n"
            + "Stack trace: Commons\n",
        actualRemoteApiException.getMessage());
    assertSame(e, actualRemoteApiException.getCause());
  }

  /**
   * Test {@link RemoteApiException#RemoteApiException(int, String, Exception, String[])}.
   *
   * <ul>
   *   <li>Then return LocalizedMessage is a string.
   * </ul>
   *
   * <p>Method under test: {@link RemoteApiException#RemoteApiException(int, String, Exception,
   * String[])}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"void RemoteApiException.<init>(int, String, Exception, String[])"})
  public void testNewRemoteApiException_thenReturnLocalizedMessageIsAString() {
    // Arrange
    Exception e = new Exception();

    // Act
    RemoteApiException actualRemoteApiException =
        new RemoteApiException(1, "An error occurred", e, new String[] {});

    // Assert
    assertEquals(
        "\n"
            + "Component: Commons\n"
            + "Message: An error occurred\n"
            + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n"
            + "Stack trace: \n",
        actualRemoteApiException.getLocalizedMessage());
    assertEquals(
        "\n"
            + "Component: Commons\n"
            + "Message: An error occurred\n"
            + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n"
            + "Stack trace: \n",
        actualRemoteApiException.getMessage());
    assertSame(e, actualRemoteApiException.getCause());
  }

  /**
   * Test {@link RemoteApiException#RemoteApiException(int, String, String[])}.
   *
   * <ul>
   *   <li>Then return LocalizedMessage is a string.
   * </ul>
   *
   * <p>Method under test: {@link RemoteApiException#RemoteApiException(int, String, String[])}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"void RemoteApiException.<init>(int, String, String[])"})
  public void testNewRemoteApiException_thenReturnLocalizedMessageIsAString2() {
    // Arrange and Act
    RemoteApiException actualRemoteApiException =
        new RemoteApiException(1, "An error occurred", new String[] {});

    // Assert
    assertEquals("An error occurred", actualRemoteApiException.getResponseMessage());
    assertEquals(
        "\n"
            + "Component: Commons\n"
            + "Message: An error occurred\n"
            + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualRemoteApiException.getLocalizedMessage());
    assertEquals(
        "\n"
            + "Component: Commons\n"
            + "Message: An error occurred\n"
            + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualRemoteApiException.getMessage());
    assertNull(actualRemoteApiException.getCause());
    assertEquals(0, actualRemoteApiException.getSuppressed().length);
    assertEquals(1, actualRemoteApiException.getCode());
  }

  /**
   * Test {@link RemoteApiException#RemoteApiException(int, String)}.
   *
   * <ul>
   *   <li>Then return ResponseMessage is {@code An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link RemoteApiException#RemoteApiException(int, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"void RemoteApiException.<init>(int, String)"})
  public void testNewRemoteApiException_thenReturnResponseMessageIsAnErrorOccurred() {
    // Arrange and Act
    RemoteApiException actualRemoteApiException = new RemoteApiException(1, "An error occurred");

    // Assert
    assertEquals("An error occurred", actualRemoteApiException.getResponseMessage());
    assertEquals(
        "\n"
            + "Component: Commons\n"
            + "Message: An error occurred\n"
            + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualRemoteApiException.getLocalizedMessage());
    assertEquals(
        "\n"
            + "Component: Commons\n"
            + "Message: An error occurred\n"
            + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualRemoteApiException.getMessage());
    assertNull(actualRemoteApiException.getCause());
    assertEquals(0, actualRemoteApiException.getSuppressed().length);
    assertEquals(1, actualRemoteApiException.getCode());
  }

  /**
   * Test {@link RemoteApiException#RemoteApiException(int, String, Exception)}.
   *
   * <ul>
   *   <li>When {@code An error occurred}.
   *   <li>Then return Cause is {@link Exception#Exception()}.
   * </ul>
   *
   * <p>Method under test: {@link RemoteApiException#RemoteApiException(int, String, Exception)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"void RemoteApiException.<init>(int, String, Exception)"})
  public void testNewRemoteApiException_whenAnErrorOccurred_thenReturnCauseIsException() {
    // Arrange
    Exception e = new Exception();

    // Act
    RemoteApiException actualRemoteApiException = new RemoteApiException(1, "An error occurred", e);

    // Assert
    assertEquals(
        "\n"
            + "Component: Commons\n"
            + "Message: An error occurred\n"
            + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n"
            + "Stack trace: \n",
        actualRemoteApiException.getLocalizedMessage());
    assertEquals(
        "\n"
            + "Component: Commons\n"
            + "Message: An error occurred\n"
            + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n"
            + "Stack trace: \n",
        actualRemoteApiException.getMessage());
    assertSame(e, actualRemoteApiException.getCause());
  }

  /**
   * Test {@link RemoteApiException#RemoteApiException(int, String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return ResponseMessage is empty string.
   * </ul>
   *
   * <p>Method under test: {@link RemoteApiException#RemoteApiException(int, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"void RemoteApiException.<init>(int, String)"})
  public void testNewRemoteApiException_whenEmptyString_thenReturnResponseMessageIsEmptyString() {
    // Arrange and Act
    RemoteApiException actualRemoteApiException = new RemoteApiException(1, "");

    // Assert
    assertEquals("", actualRemoteApiException.getResponseMessage());
    assertEquals(
        "\n"
            + "Component: Commons\n"
            + "Message: None\n"
            + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualRemoteApiException.getLocalizedMessage());
    assertEquals(
        "\n"
            + "Component: Commons\n"
            + "Message: None\n"
            + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualRemoteApiException.getMessage());
    assertNull(actualRemoteApiException.getCause());
    assertEquals(0, actualRemoteApiException.getSuppressed().length);
    assertEquals(1, actualRemoteApiException.getCode());
  }

  /**
   * Test {@link RemoteApiException#RemoteApiException(int, String, Exception)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return ResponseMessage is empty string.
   * </ul>
   *
   * <p>Method under test: {@link RemoteApiException#RemoteApiException(int, String, Exception)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"void RemoteApiException.<init>(int, String, Exception)"})
  public void testNewRemoteApiException_whenEmptyString_thenReturnResponseMessageIsEmptyString2() {
    // Arrange and Act
    RemoteApiException actualRemoteApiException = new RemoteApiException(1, "", new Exception());

    // Assert
    assertEquals("", actualRemoteApiException.getResponseMessage());
    assertEquals(
        "\n"
            + "Component: Commons\n"
            + "Message: None\n"
            + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n"
            + "Stack trace: \n",
        actualRemoteApiException.getLocalizedMessage());
    assertEquals(
        "\n"
            + "Component: Commons\n"
            + "Message: None\n"
            + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n"
            + "Stack trace: \n",
        actualRemoteApiException.getMessage());
  }

  /**
   * Test {@link RemoteApiException#RemoteApiException(int, String, Exception, String[])}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return ResponseMessage is empty string.
   * </ul>
   *
   * <p>Method under test: {@link RemoteApiException#RemoteApiException(int, String, Exception,
   * String[])}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"void RemoteApiException.<init>(int, String, Exception, String[])"})
  public void testNewRemoteApiException_whenEmptyString_thenReturnResponseMessageIsEmptyString3() {
    // Arrange and Act
    RemoteApiException actualRemoteApiException =
        new RemoteApiException(1, "", new Exception(), "Solutions");

    // Assert
    assertEquals("", actualRemoteApiException.getResponseMessage());
    assertEquals(
        "\nComponent: Commons\nMessage: None\nSolutions: \nSolutions\nStack trace: \n",
        actualRemoteApiException.getLocalizedMessage());
    assertEquals(
        "\nComponent: Commons\nMessage: None\nSolutions: \nSolutions\nStack trace: \n",
        actualRemoteApiException.getMessage());
  }

  /**
   * Test {@link RemoteApiException#RemoteApiException(int, String, String[])}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return ResponseMessage is empty string.
   * </ul>
   *
   * <p>Method under test: {@link RemoteApiException#RemoteApiException(int, String, String[])}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"void RemoteApiException.<init>(int, String, String[])"})
  public void testNewRemoteApiException_whenEmptyString_thenReturnResponseMessageIsEmptyString4() {
    // Arrange and Act
    RemoteApiException actualRemoteApiException = new RemoteApiException(1, "", "Solutions");

    // Assert
    assertEquals("", actualRemoteApiException.getResponseMessage());
    assertEquals(
        "\nComponent: Commons\nMessage: None\nSolutions: \nSolutions\n",
        actualRemoteApiException.getLocalizedMessage());
    assertEquals(
        "\nComponent: Commons\nMessage: None\nSolutions: \nSolutions\n",
        actualRemoteApiException.getMessage());
    assertNull(actualRemoteApiException.getCause());
    assertEquals(0, actualRemoteApiException.getSuppressed().length);
    assertEquals(1, actualRemoteApiException.getCode());
  }

  /**
   * Test {@link RemoteApiException#RemoteApiException(int, Exception)}.
   *
   * <ul>
   *   <li>When {@link Exception#Exception()}.
   *   <li>Then return Cause is {@link Exception#Exception()}.
   * </ul>
   *
   * <p>Method under test: {@link RemoteApiException#RemoteApiException(int, Exception)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"void RemoteApiException.<init>(int, Exception)"})
  public void testNewRemoteApiException_whenException_thenReturnCauseIsException() {
    // Arrange
    Exception e = new Exception();

    // Act
    RemoteApiException actualRemoteApiException = new RemoteApiException(1, e);

    // Assert
    assertEquals(
        "\n"
            + "Component: Commons\n"
            + "Message: None\n"
            + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n"
            + "Stack trace: \n",
        actualRemoteApiException.getLocalizedMessage());
    assertEquals(
        "\n"
            + "Component: Commons\n"
            + "Message: None\n"
            + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n"
            + "Stack trace: \n",
        actualRemoteApiException.getMessage());
    assertSame(e, actualRemoteApiException.getCause());
  }

  /**
   * Test {@link RemoteApiException#RemoteApiException(int, Exception, String[])}.
   *
   * <ul>
   *   <li>When {@link Exception#Exception()}.
   *   <li>Then return LocalizedMessage is a string.
   * </ul>
   *
   * <p>Method under test: {@link RemoteApiException#RemoteApiException(int, Exception, String[])}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"void RemoteApiException.<init>(int, Exception, String[])"})
  public void testNewRemoteApiException_whenException_thenReturnLocalizedMessageIsAString() {
    // Arrange
    Exception e = new Exception();

    // Act
    RemoteApiException actualRemoteApiException = new RemoteApiException(1, e, new String[] {});

    // Assert
    assertEquals(
        "\n"
            + "Component: Commons\n"
            + "Message: None\n"
            + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n"
            + "Stack trace: \n",
        actualRemoteApiException.getLocalizedMessage());
    assertEquals(
        "\n"
            + "Component: Commons\n"
            + "Message: None\n"
            + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n"
            + "Stack trace: \n",
        actualRemoteApiException.getMessage());
    assertSame(e, actualRemoteApiException.getCause());
  }

  /**
   * Test {@link RemoteApiException#RemoteApiException(int, String, Exception)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return ResponseMessage is {@code An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link RemoteApiException#RemoteApiException(int, String, Exception)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"void RemoteApiException.<init>(int, String, Exception)"})
  public void testNewRemoteApiException_whenNull_thenReturnResponseMessageIsAnErrorOccurred() {
    // Arrange and Act
    RemoteApiException actualRemoteApiException =
        new RemoteApiException(1, "An error occurred", (Exception) null);

    // Assert
    assertEquals("An error occurred", actualRemoteApiException.getResponseMessage());
    assertEquals(
        "\n"
            + "Component: Commons\n"
            + "Message: An error occurred\n"
            + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualRemoteApiException.getLocalizedMessage());
    assertEquals(
        "\n"
            + "Component: Commons\n"
            + "Message: An error occurred\n"
            + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualRemoteApiException.getMessage());
    assertNull(actualRemoteApiException.getCause());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RemoteApiException#getCode()}
   *   <li>{@link RemoteApiException#getResponseMessage()}
   * </ul>
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int RemoteApiException.getCode()",
    "String RemoteApiException.getResponseMessage()"
  })
  public void testGettersAndSetters() {
    // Arrange
    RemoteApiException remoteApiException = new RemoteApiException(1, "An error occurred");

    // Act
    int actualCode = remoteApiException.getCode();

    // Assert
    assertEquals("An error occurred", remoteApiException.getResponseMessage());
    assertEquals(1, actualCode);
  }
}
