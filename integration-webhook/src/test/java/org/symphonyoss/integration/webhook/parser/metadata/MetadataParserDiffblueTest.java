package org.symphonyoss.integration.webhook.parser.metadata;

import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class MetadataParserDiffblueTest {
  /**
   * Test {@link MetadataParser#parse(JsonNode)}.
   * <p>
   * Method under test: {@link MetadataParser#parse(JsonNode)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"org.symphonyoss.integration.model.message.Message MetadataParser.parse(JsonNode)"})
  public void testParse() {
    // Arrange
    MockMetadataParser mockMetadataParser = new MockMetadataParser("Template File", "Metadata File");

    // Act and Assert
    assertNull(mockMetadataParser.parse(DoubleNode.valueOf(10.0d)));
  }
}
