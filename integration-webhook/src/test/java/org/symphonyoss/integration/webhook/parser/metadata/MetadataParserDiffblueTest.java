package org.symphonyoss.integration.webhook.parser.metadata;

import static org.junit.Assert.assertNull;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import org.junit.Test;

public class MetadataParserDiffblueTest {
  /**
   * Method under test: {@link MetadataParser#parse(JsonNode)}
   */
  @Test
  public void testParse() {
    // Arrange
    MockMetadataParser mockMetadataParser = new MockMetadataParser("Template File", "Metadata File");

    // Act and Assert
    assertNull(mockMetadataParser.parse(DoubleNode.valueOf(10.0d)));
  }
}
