package org.symphonyoss.integration.webhook.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class MetadataParserExceptionDiffblueTest {
  /**
   * Method under test:
   * {@link MetadataParserException#MetadataParserException(String, String)}
   */
  @Test
  public void testNewMetadataParserException() {
    // Arrange and Act
    MetadataParserException actualMetadataParserException = new MetadataParserException("Component",
        "An error occurred");

    // Assert
    assertEquals(
        "\n" + "Component: Component\n" + "Message: An error occurred\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualMetadataParserException.getLocalizedMessage());
    assertEquals(
        "\n" + "Component: Component\n" + "Message: An error occurred\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualMetadataParserException.getMessage());
    assertNull(actualMetadataParserException.getCause());
    assertEquals(0, actualMetadataParserException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link MetadataParserException#MetadataParserException(String, String)}
   */
  @Test
  public void testNewMetadataParserException2() {
    // Arrange and Act
    MetadataParserException actualMetadataParserException = new MetadataParserException(null, null);

    // Assert
    assertEquals(
        "\n" + "Component: Unknown\n" + "Message: None\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualMetadataParserException.getLocalizedMessage());
    assertEquals(
        "\n" + "Component: Unknown\n" + "Message: None\n" + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualMetadataParserException.getMessage());
    assertNull(actualMetadataParserException.getCause());
    assertEquals(0, actualMetadataParserException.getSuppressed().length);
  }
}
