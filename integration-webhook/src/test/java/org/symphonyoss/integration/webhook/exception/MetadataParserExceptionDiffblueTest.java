package org.symphonyoss.integration.webhook.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;

public class MetadataParserExceptionDiffblueTest {
  /**
   * Test {@link MetadataParserException#MetadataParserException(String, String)}.
   *
   * <ul>
   *   <li>When {@code Component}.
   * </ul>
   *
   * <p>Method under test: {@link MetadataParserException#MetadataParserException(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"void MetadataParserException.<init>(String, String)"})
  public void testNewMetadataParserException_whenComponent() {
    // Arrange and Act
    MetadataParserException actualMetadataParserException =
        new MetadataParserException("Component", "An error occurred");

    // Assert
    assertEquals(
        "\n"
            + "Component: Component\n"
            + "Message: An error occurred\n"
            + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualMetadataParserException.getLocalizedMessage());
    assertEquals(
        "\n"
            + "Component: Component\n"
            + "Message: An error occurred\n"
            + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualMetadataParserException.getMessage());
    assertNull(actualMetadataParserException.getCause());
    assertEquals(0, actualMetadataParserException.getSuppressed().length);
  }

  /**
   * Test {@link MetadataParserException#MetadataParserException(String, String)}.
   *
   * <ul>
   *   <li>When {@code Component}.
   * </ul>
   *
   * <p>Method under test: {@link MetadataParserException#MetadataParserException(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"void MetadataParserException.<init>(String, String)"})
  public void testNewMetadataParserException_whenComponent2() {
    // Arrange and Act
    MetadataParserException actualMetadataParserException =
        new MetadataParserException("Component", "");

    // Assert
    assertEquals(
        "\n"
            + "Component: Component\n"
            + "Message: None\n"
            + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualMetadataParserException.getLocalizedMessage());
    assertEquals(
        "\n"
            + "Component: Component\n"
            + "Message: None\n"
            + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualMetadataParserException.getMessage());
    assertNull(actualMetadataParserException.getCause());
    assertEquals(0, actualMetadataParserException.getSuppressed().length);
  }

  /**
   * Test {@link MetadataParserException#MetadataParserException(String, String)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link MetadataParserException#MetadataParserException(String, String)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"void MetadataParserException.<init>(String, String)"})
  public void testNewMetadataParserException_whenEmptyString() {
    // Arrange and Act
    MetadataParserException actualMetadataParserException =
        new MetadataParserException("", "An error occurred");

    // Assert
    assertEquals(
        "\n"
            + "Component: Unknown\n"
            + "Message: An error occurred\n"
            + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualMetadataParserException.getLocalizedMessage());
    assertEquals(
        "\n"
            + "Component: Unknown\n"
            + "Message: An error occurred\n"
            + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n",
        actualMetadataParserException.getMessage());
    assertNull(actualMetadataParserException.getCause());
    assertEquals(0, actualMetadataParserException.getSuppressed().length);
  }
}
