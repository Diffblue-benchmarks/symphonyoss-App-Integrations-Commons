package org.symphonyoss.integration.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import org.junit.Test;

public class EntityXMLGeneratorExceptionDiffblueTest {
  /**
   * Method under test:
   * {@link EntityXMLGeneratorException#EntityXMLGeneratorException(Exception)}
   */
  @Test
  public void testNewEntityXMLGeneratorException() {
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
    assertEquals(0, actualEntityXMLGeneratorException.getSuppressed().length);
    assertSame(e, actualEntityXMLGeneratorException.getCause());
  }

  /**
   * Method under test:
   * {@link EntityXMLGeneratorException#EntityXMLGeneratorException(Exception)}
   */
  @Test
  public void testNewEntityXMLGeneratorException2() {
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
    assertEquals(0, actualEntityXMLGeneratorException.getSuppressed().length);
    assertSame(e, actualEntityXMLGeneratorException.getCause());
  }
}
