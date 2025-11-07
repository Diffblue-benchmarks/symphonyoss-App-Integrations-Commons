package org.symphonyoss.integration.webhook.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class MetadataParserExceptionDiffblueTest {
  /**
   * Test {@link MetadataParserException#MetadataParserException(String, String)}.
   * <ul>
   *   <li>When {@code Component}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetadataParserException#MetadataParserException(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MetadataParserException.<init>(String, String)"})
  public void testNewMetadataParserException_whenComponent() {
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
   * Test {@link MetadataParserException#MetadataParserException(String, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetadataParserException#MetadataParserException(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MetadataParserException.<init>(String, String)"})
  public void testNewMetadataParserException_whenNull() {
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
