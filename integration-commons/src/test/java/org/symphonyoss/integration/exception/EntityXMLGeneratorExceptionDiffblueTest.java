package org.symphonyoss.integration.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;

public class EntityXMLGeneratorExceptionDiffblueTest {
  /**
   * Test {@link EntityXMLGeneratorException#EntityXMLGeneratorException(Exception)}.
   * <ul>
   *   <li>Then return Cause is {@link Exception#Exception(String)} with empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityXMLGeneratorException#EntityXMLGeneratorException(Exception)}
   */
  @Test
  @MethodsUnderTest({"void EntityXMLGeneratorException.<init>(Exception)"})
  public void testNewEntityXMLGeneratorException_thenReturnCauseIsExceptionWithEmptyString() {
    // Arrange
    Exception e = new Exception("");

    // Act
    EntityXMLGeneratorException actualEntityXMLGeneratorException = new EntityXMLGeneratorException(e);

    // Assert
    assertEquals(
        "\n" + "Component: Commons\n" + "Message: None\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n" + "Stack trace: \n",
        actualEntityXMLGeneratorException.getLocalizedMessage());
    assertEquals(
        "\n" + "Component: Commons\n" + "Message: None\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n" + "Stack trace: \n",
        actualEntityXMLGeneratorException.getMessage());
    assertSame(e, actualEntityXMLGeneratorException.getCause());
  }

  /**
   * Test {@link EntityXMLGeneratorException#EntityXMLGeneratorException(Exception)}.
   * <ul>
   *   <li>Then return Cause is {@link Exception#Exception(String)} with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityXMLGeneratorException#EntityXMLGeneratorException(Exception)}
   */
  @Test
  @MethodsUnderTest({"void EntityXMLGeneratorException.<init>(Exception)"})
  public void testNewEntityXMLGeneratorException_thenReturnCauseIsExceptionWithFoo() {
    // Arrange
    Exception e = new Exception("foo");

    // Act
    EntityXMLGeneratorException actualEntityXMLGeneratorException = new EntityXMLGeneratorException(e);

    // Assert
    assertEquals(
        "\n" + "Component: Commons\n" + "Message: foo\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n" + "Stack trace: foo\n",
        actualEntityXMLGeneratorException.getLocalizedMessage());
    assertEquals(
        "\n" + "Component: Commons\n" + "Message: foo\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n" + "Stack trace: foo\n",
        actualEntityXMLGeneratorException.getMessage());
    assertSame(e, actualEntityXMLGeneratorException.getCause());
  }
}
