package org.symphonyoss.integration.model.message;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class MessageDiffblueTest {
  /**
   * Method under test: {@link Message.FormatEnum#toString()}
   */
  @Test
  public void testFormatEnumToString() {
    // Arrange, Act and Assert
    assertEquals("TEXT", Message.FormatEnum.valueOf("TEXT").toString());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Message}
   *   <li>{@link Message#setData(String)}
   *   <li>{@link Message#setFormat(Message.FormatEnum)}
   *   <li>{@link Message#setMessage(String)}
   *   <li>{@link Message#setTimestamp(Long)}
   *   <li>{@link Message#setVersion(MessageMLVersion)}
   *   <li>{@link Message#toString()}
   *   <li>{@link Message#getData()}
   *   <li>{@link Message#getFormat()}
   *   <li>{@link Message#getMessage()}
   *   <li>{@link Message#getTimestamp()}
   *   <li>{@link Message#getVersion()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    Message actualMessage = new Message();
    actualMessage.setData("Data");
    actualMessage.setFormat(Message.FormatEnum.TEXT);
    actualMessage.setMessage("Not all who wander are lost");
    actualMessage.setTimestamp(10L);
    actualMessage.setVersion(MessageMLVersion.V1);
    String actualToStringResult = actualMessage.toString();
    String actualData = actualMessage.getData();
    Message.FormatEnum actualFormat = actualMessage.getFormat();
    String actualMessage2 = actualMessage.getMessage();
    Long actualTimestamp = actualMessage.getTimestamp();
    MessageMLVersion actualVersion = actualMessage.getVersion();

    // Assert that nothing has changed
    assertEquals("Data", actualData);
    assertEquals("Message{timestamp=10, message='Not all who wander are lost', format=TEXT, data='Data', version=V1}",
        actualToStringResult);
    assertEquals("Not all who wander are lost", actualMessage2);
    assertEquals(10L, actualTimestamp.longValue());
    assertEquals(Message.FormatEnum.TEXT, actualFormat);
    assertEquals(MessageMLVersion.V1, actualVersion);
  }
}
