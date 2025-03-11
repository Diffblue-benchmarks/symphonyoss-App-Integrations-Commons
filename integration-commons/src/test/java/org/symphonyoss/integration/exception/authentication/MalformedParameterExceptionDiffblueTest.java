package org.symphonyoss.integration.exception.authentication;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;

public class MalformedParameterExceptionDiffblueTest {
  /**
   * Test {@link MalformedParameterException#MalformedParameterException(String, Throwable, String[])}.
   * <p>
   * Method under test: {@link MalformedParameterException#MalformedParameterException(String, Throwable, String[])}
   */
  @Test
  @MethodsUnderTest({"void MalformedParameterException.<init>(String, Throwable, String[])"})
  public void testNewMalformedParameterException() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    MalformedParameterException actualMalformedParameterException = new MalformedParameterException("An error occurred",
        cause, "Solutions");

    // Assert
    assertEquals(
        "\nComponent: Authentication Proxy\nMessage: An error occurred\nSolutions: \nSolutions\nStack trace: \n",
        actualMalformedParameterException.getLocalizedMessage());
    assertEquals(
        "\nComponent: Authentication Proxy\nMessage: An error occurred\nSolutions: \nSolutions\nStack trace: \n",
        actualMalformedParameterException.getMessage());
    assertEquals(0, actualMalformedParameterException.getSuppressed().length);
    assertSame(cause, actualMalformedParameterException.getCause());
  }

  /**
   * Test {@link MalformedParameterException#MalformedParameterException(String, String[])}.
   * <p>
   * Method under test: {@link MalformedParameterException#MalformedParameterException(String, String[])}
   */
  @Test
  @MethodsUnderTest({"void MalformedParameterException.<init>(String, String[])"})
  public void testNewMalformedParameterException2() {
    // Arrange and Act
    MalformedParameterException actualMalformedParameterException = new MalformedParameterException("An error occurred",
        "Solutions");

    // Assert
    assertEquals("\nComponent: Authentication Proxy\nMessage: An error occurred\nSolutions: \nSolutions\n",
        actualMalformedParameterException.getLocalizedMessage());
    assertEquals("\nComponent: Authentication Proxy\nMessage: An error occurred\nSolutions: \nSolutions\n",
        actualMalformedParameterException.getMessage());
    assertNull(actualMalformedParameterException.getCause());
    assertEquals(0, actualMalformedParameterException.getSuppressed().length);
  }
}
