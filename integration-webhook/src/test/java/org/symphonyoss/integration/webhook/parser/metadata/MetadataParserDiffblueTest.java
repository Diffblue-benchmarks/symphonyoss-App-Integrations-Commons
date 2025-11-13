package org.symphonyoss.integration.webhook.parser.metadata;

import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import org.junit.Test;

public class MetadataParserDiffblueTest {
  /**
   * Test {@link MetadataParser#parse(JsonNode)}.
   *
   * <p>Method under test: {@link MetadataParser#parse(JsonNode)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.symphonyoss.integration.model.message.Message MetadataParser.parse(JsonNode)"
  })
  public void testParse() {
    // Arrange, Act and Assert
    assertNull(
        new MockMetadataParser("Template File", "Metadata File").parse(DoubleNode.valueOf(10.0d)));
  }
}
