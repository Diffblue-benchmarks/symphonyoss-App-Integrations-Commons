package org.symphonyoss.integration.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class RemoteApiExceptionDiffblueTest {
  /**
   * Test {@link RemoteApiException#RemoteApiException(int, Exception, String[])}.
   * <p>
   * Method under test: {@link RemoteApiException#RemoteApiException(int, Exception, String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RemoteApiException.<init>(int, Exception, String[])"})
  public void testNewRemoteApiException() {
    // Arrange
    Exception e = new Exception("foo");

    // Act
    RemoteApiException actualRemoteApiException = new RemoteApiException(1, e, "Solutions");

    // Assert
    assertEquals("\nComponent: Commons\nMessage: foo\nSolutions: \nSolutions\nStack trace: foo\n",
        actualRemoteApiException.getLocalizedMessage());
    assertEquals("\nComponent: Commons\nMessage: foo\nSolutions: \nSolutions\nStack trace: foo\n",
        actualRemoteApiException.getMessage());
    assertSame(e, actualRemoteApiException.getCause());
  }

  /**
   * Test {@link RemoteApiException#RemoteApiException(int, Exception, String[])}.
   * <p>
   * Method under test: {@link RemoteApiException#RemoteApiException(int, Exception, String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RemoteApiException.<init>(int, Exception, String[])"})
  public void testNewRemoteApiException2() {
    // Arrange
    Exception e = new Exception("");

    // Act
    RemoteApiException actualRemoteApiException = new RemoteApiException(1, e, "Solutions");

    // Assert
    assertEquals("\nComponent: Commons\nMessage: None\nSolutions: \nSolutions\nStack trace: \n",
        actualRemoteApiException.getLocalizedMessage());
    assertEquals("\nComponent: Commons\nMessage: None\nSolutions: \nSolutions\nStack trace: \n",
        actualRemoteApiException.getMessage());
    assertSame(e, actualRemoteApiException.getCause());
  }

  /**
   * Test {@link RemoteApiException#RemoteApiException(int, String, Exception, String[])}.
   * <p>
   * Method under test: {@link RemoteApiException#RemoteApiException(int, String, Exception, String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RemoteApiException.<init>(int, String, Exception, String[])"})
  public void testNewRemoteApiException3() {
    // Arrange
    Exception e = new Exception("foo");

    // Act
    RemoteApiException actualRemoteApiException = new RemoteApiException(1, "An error occurred", e, "Solutions");

    // Assert
    assertEquals("An error occurred", actualRemoteApiException.getResponseMessage());
    assertEquals("\nComponent: Commons\nMessage: An error occurred\nSolutions: \nSolutions\nStack trace: foo\n",
        actualRemoteApiException.getLocalizedMessage());
    assertEquals("\nComponent: Commons\nMessage: An error occurred\nSolutions: \nSolutions\nStack trace: foo\n",
        actualRemoteApiException.getMessage());
    assertSame(e, actualRemoteApiException.getCause());
  }

  /**
   * Test {@link RemoteApiException#RemoteApiException(int, String, String[])}.
   * <p>
   * Method under test: {@link RemoteApiException#RemoteApiException(int, String, String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RemoteApiException.<init>(int, String, String[])"})
  public void testNewRemoteApiException4() {
    // Arrange and Act
    RemoteApiException actualRemoteApiException = new RemoteApiException(1, "An error occurred", "Solutions");

    // Assert
    assertEquals("An error occurred", actualRemoteApiException.getResponseMessage());
    assertEquals("\nComponent: Commons\nMessage: An error occurred\nSolutions: \nSolutions\n",
        actualRemoteApiException.getLocalizedMessage());
    assertEquals("\nComponent: Commons\nMessage: An error occurred\nSolutions: \nSolutions\n",
        actualRemoteApiException.getMessage());
    assertNull(actualRemoteApiException.getCause());
    assertEquals(0, actualRemoteApiException.getSuppressed().length);
    assertEquals(1, actualRemoteApiException.getCode());
  }

  /**
   * Test {@link RemoteApiException#RemoteApiException(int, Exception)}.
   * <ul>
   *   <li>Then return Cause is {@link Exception#Exception(String)} with empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link RemoteApiException#RemoteApiException(int, Exception)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RemoteApiException.<init>(int, Exception)"})
  public void testNewRemoteApiException_thenReturnCauseIsExceptionWithEmptyString() {
    // Arrange
    Exception e = new Exception("");

    // Act
    RemoteApiException actualRemoteApiException = new RemoteApiException(1, e);

    // Assert
    assertEquals(
        "\n" + "Component: Commons\n" + "Message: None\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n" + "Stack trace: \n",
        actualRemoteApiException.getLocalizedMessage());
    assertEquals(
        "\n" + "Component: Commons\n" + "Message: None\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n" + "Stack trace: \n",
        actualRemoteApiException.getMessage());
    assertSame(e, actualRemoteApiException.getCause());
  }

  /**
   * Test {@link RemoteApiException#RemoteApiException(int, Exception, String[])}.
   * <ul>
   *   <li>Then return LocalizedMessage is a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link RemoteApiException#RemoteApiException(int, Exception, String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RemoteApiException.<init>(int, Exception, String[])"})
  public void testNewRemoteApiException_thenReturnLocalizedMessageIsAString() {
    // Arrange
    Exception e = new Exception("foo");

    // Act
    RemoteApiException actualRemoteApiException = new RemoteApiException(1, e, new String[]{});

    // Assert
    assertEquals(
        "\n" + "Component: Commons\n" + "Message: foo\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n" + "Stack trace: foo\n",
        actualRemoteApiException.getLocalizedMessage());
    assertEquals(
        "\n" + "Component: Commons\n" + "Message: foo\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n" + "Stack trace: foo\n",
        actualRemoteApiException.getMessage());
    assertSame(e, actualRemoteApiException.getCause());
  }

  /**
   * Test {@link RemoteApiException#RemoteApiException(int, String)}.
   * <ul>
   *   <li>Then return ResponseMessage is {@code An error occurred}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RemoteApiException#RemoteApiException(int, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RemoteApiException.<init>(int, String)"})
  public void testNewRemoteApiException_thenReturnResponseMessageIsAnErrorOccurred() {
    // Arrange and Act
    RemoteApiException actualRemoteApiException = new RemoteApiException(1, "An error occurred");

    // Assert
    assertEquals("An error occurred", actualRemoteApiException.getResponseMessage());
    assertEquals(
        "\n" + "Component: Commons\n" + "Message: An error occurred\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualRemoteApiException.getLocalizedMessage());
    assertEquals(
        "\n" + "Component: Commons\n" + "Message: An error occurred\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualRemoteApiException.getMessage());
    assertNull(actualRemoteApiException.getCause());
    assertEquals(0, actualRemoteApiException.getSuppressed().length);
    assertEquals(1, actualRemoteApiException.getCode());
  }

  /**
   * Test {@link RemoteApiException#RemoteApiException(int, String, Exception)}.
   * <ul>
   *   <li>Then return ResponseMessage is {@code An error occurred}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RemoteApiException#RemoteApiException(int, String, Exception)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RemoteApiException.<init>(int, String, Exception)"})
  public void testNewRemoteApiException_thenReturnResponseMessageIsAnErrorOccurred2() {
    // Arrange
    Exception e = new Exception("foo");

    // Act
    RemoteApiException actualRemoteApiException = new RemoteApiException(1, "An error occurred", e);

    // Assert
    assertEquals("An error occurred", actualRemoteApiException.getResponseMessage());
    assertEquals(
        "\n" + "Component: Commons\n" + "Message: An error occurred\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n" + "Stack trace: foo\n",
        actualRemoteApiException.getLocalizedMessage());
    assertEquals(
        "\n" + "Component: Commons\n" + "Message: An error occurred\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n" + "Stack trace: foo\n",
        actualRemoteApiException.getMessage());
    assertSame(e, actualRemoteApiException.getCause());
  }

  /**
   * Test {@link RemoteApiException#RemoteApiException(int, String, Exception, String[])}.
   * <ul>
   *   <li>Then return ResponseMessage is {@code An error occurred}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RemoteApiException#RemoteApiException(int, String, Exception, String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RemoteApiException.<init>(int, String, Exception, String[])"})
  public void testNewRemoteApiException_thenReturnResponseMessageIsAnErrorOccurred3() {
    // Arrange
    Exception e = new Exception("foo");

    // Act
    RemoteApiException actualRemoteApiException = new RemoteApiException(1, "An error occurred", e, new String[]{});

    // Assert
    assertEquals("An error occurred", actualRemoteApiException.getResponseMessage());
    assertEquals(
        "\n" + "Component: Commons\n" + "Message: An error occurred\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n" + "Stack trace: foo\n",
        actualRemoteApiException.getLocalizedMessage());
    assertEquals(
        "\n" + "Component: Commons\n" + "Message: An error occurred\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n" + "Stack trace: foo\n",
        actualRemoteApiException.getMessage());
    assertSame(e, actualRemoteApiException.getCause());
  }

  /**
   * Test {@link RemoteApiException#RemoteApiException(int, String, String[])}.
   * <ul>
   *   <li>Then return ResponseMessage is {@code An error occurred}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RemoteApiException#RemoteApiException(int, String, String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RemoteApiException.<init>(int, String, String[])"})
  public void testNewRemoteApiException_thenReturnResponseMessageIsAnErrorOccurred4() {
    // Arrange and Act
    RemoteApiException actualRemoteApiException = new RemoteApiException(1, "An error occurred", new String[]{});

    // Assert
    assertEquals("An error occurred", actualRemoteApiException.getResponseMessage());
    assertEquals(
        "\n" + "Component: Commons\n" + "Message: An error occurred\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualRemoteApiException.getLocalizedMessage());
    assertEquals(
        "\n" + "Component: Commons\n" + "Message: An error occurred\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualRemoteApiException.getMessage());
    assertNull(actualRemoteApiException.getCause());
    assertEquals(0, actualRemoteApiException.getSuppressed().length);
    assertEquals(1, actualRemoteApiException.getCode());
  }

  /**
   * Test {@link RemoteApiException#RemoteApiException(int, Exception)}.
   * <ul>
   *   <li>When {@link Exception#Exception(String)} with {@code foo}.</li>
   *   <li>Then return Cause is {@link Exception#Exception(String)} with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RemoteApiException#RemoteApiException(int, Exception)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RemoteApiException.<init>(int, Exception)"})
  public void testNewRemoteApiException_whenExceptionWithFoo_thenReturnCauseIsExceptionWithFoo() {
    // Arrange
    Exception e = new Exception("foo");

    // Act
    RemoteApiException actualRemoteApiException = new RemoteApiException(1, e);

    // Assert
    assertEquals(
        "\n" + "Component: Commons\n" + "Message: foo\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n" + "Stack trace: foo\n",
        actualRemoteApiException.getLocalizedMessage());
    assertEquals(
        "\n" + "Component: Commons\n" + "Message: foo\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n" + "Stack trace: foo\n",
        actualRemoteApiException.getMessage());
    assertSame(e, actualRemoteApiException.getCause());
  }

  /**
   * Test {@link RemoteApiException#RemoteApiException(int, Exception, String[])}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return LocalizedMessage is a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link RemoteApiException#RemoteApiException(int, Exception, String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RemoteApiException.<init>(int, Exception, String[])"})
  public void testNewRemoteApiException_whenNull_thenReturnLocalizedMessageIsAString() {
    // Arrange
    Exception e = new Exception("foo");

    // Act
    RemoteApiException actualRemoteApiException = new RemoteApiException(1, e, null);

    // Assert
    assertEquals(
        "\n" + "Component: Commons\n" + "Message: foo\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n" + "Stack trace: foo\n",
        actualRemoteApiException.getLocalizedMessage());
    assertEquals(
        "\n" + "Component: Commons\n" + "Message: foo\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n" + "Stack trace: foo\n",
        actualRemoteApiException.getMessage());
    assertSame(e, actualRemoteApiException.getCause());
  }

  /**
   * Test {@link RemoteApiException#RemoteApiException(int, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return ResponseMessage is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RemoteApiException#RemoteApiException(int, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RemoteApiException.<init>(int, String)"})
  public void testNewRemoteApiException_whenNull_thenReturnResponseMessageIsNull() {
    // Arrange and Act
    RemoteApiException actualRemoteApiException = new RemoteApiException(1, (String) null);

    // Assert
    assertEquals(
        "\n" + "Component: Commons\n" + "Message: None\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualRemoteApiException.getLocalizedMessage());
    assertEquals(
        "\n" + "Component: Commons\n" + "Message: None\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualRemoteApiException.getMessage());
    assertNull(actualRemoteApiException.getResponseMessage());
    assertNull(actualRemoteApiException.getCause());
    assertEquals(0, actualRemoteApiException.getSuppressed().length);
    assertEquals(1, actualRemoteApiException.getCode());
  }

  /**
   * Test {@link RemoteApiException#RemoteApiException(int, String, Exception)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return ResponseMessage is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RemoteApiException#RemoteApiException(int, String, Exception)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RemoteApiException.<init>(int, String, Exception)"})
  public void testNewRemoteApiException_whenNull_thenReturnResponseMessageIsNull2() {
    // Arrange and Act
    RemoteApiException actualRemoteApiException = new RemoteApiException(1, (String) null, (Exception) null);

    // Assert
    assertEquals(
        "\n" + "Component: Commons\n" + "Message: None\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualRemoteApiException.getLocalizedMessage());
    assertEquals(
        "\n" + "Component: Commons\n" + "Message: None\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualRemoteApiException.getMessage());
    assertNull(actualRemoteApiException.getResponseMessage());
    assertNull(actualRemoteApiException.getCause());
  }

  /**
   * Test {@link RemoteApiException#RemoteApiException(int, String, Exception, String[])}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return ResponseMessage is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RemoteApiException#RemoteApiException(int, String, Exception, String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RemoteApiException.<init>(int, String, Exception, String[])"})
  public void testNewRemoteApiException_whenNull_thenReturnResponseMessageIsNull3() {
    // Arrange and Act
    RemoteApiException actualRemoteApiException = new RemoteApiException(1, null, null, null);

    // Assert
    assertEquals(
        "\n" + "Component: Commons\n" + "Message: None\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualRemoteApiException.getLocalizedMessage());
    assertEquals(
        "\n" + "Component: Commons\n" + "Message: None\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualRemoteApiException.getMessage());
    assertNull(actualRemoteApiException.getResponseMessage());
    assertNull(actualRemoteApiException.getCause());
  }

  /**
   * Test {@link RemoteApiException#RemoteApiException(int, String, String[])}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return ResponseMessage is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RemoteApiException#RemoteApiException(int, String, String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RemoteApiException.<init>(int, String, String[])"})
  public void testNewRemoteApiException_whenNull_thenReturnResponseMessageIsNull4() {
    // Arrange and Act
    RemoteApiException actualRemoteApiException = new RemoteApiException(1, (String) null, (String[]) null);

    // Assert
    assertEquals(
        "\n" + "Component: Commons\n" + "Message: None\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualRemoteApiException.getLocalizedMessage());
    assertEquals(
        "\n" + "Component: Commons\n" + "Message: None\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualRemoteApiException.getMessage());
    assertNull(actualRemoteApiException.getResponseMessage());
    assertNull(actualRemoteApiException.getCause());
    assertEquals(0, actualRemoteApiException.getSuppressed().length);
    assertEquals(1, actualRemoteApiException.getCode());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RemoteApiException#getCode()}
   *   <li>{@link RemoteApiException#getResponseMessage()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int RemoteApiException.getCode()", "String RemoteApiException.getResponseMessage()"})
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
