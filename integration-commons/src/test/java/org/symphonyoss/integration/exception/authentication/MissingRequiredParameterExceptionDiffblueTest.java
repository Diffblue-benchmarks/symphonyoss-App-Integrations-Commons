package org.symphonyoss.integration.exception.authentication;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class MissingRequiredParameterExceptionDiffblueTest {
  /**
   * Test {@link MissingRequiredParameterException#MissingRequiredParameterException(String, String[])}.
   * <p>
   * Method under test: {@link MissingRequiredParameterException#MissingRequiredParameterException(String, String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MissingRequiredParameterException.<init>(String, String[])"})
  public void testNewMissingRequiredParameterException() {
    // Arrange and Act
    MissingRequiredParameterException actualMissingRequiredParameterException = new MissingRequiredParameterException(
        "An error occurred", "Solutions");

    // Assert
    assertEquals("\nComponent: Authentication Proxy\nMessage: An error occurred\nSolutions: \nSolutions\n",
        actualMissingRequiredParameterException.getLocalizedMessage());
    assertEquals("\nComponent: Authentication Proxy\nMessage: An error occurred\nSolutions: \nSolutions\n",
        actualMissingRequiredParameterException.getMessage());
    assertNull(actualMissingRequiredParameterException.getCause());
    assertEquals(0, actualMissingRequiredParameterException.getSuppressed().length);
  }
}
