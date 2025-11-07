package org.symphonyoss.integration.model.message;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.symphonyoss.integration.model.message.Message.FormatEnum;

public class MessageDiffblueTest {
  /**
   * Test FormatEnum {@link FormatEnum#toString()}.
   * <p>
   * Method under test: {@link FormatEnum#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String FormatEnum.toString()"})
  public void testFormatEnumToString() {
    // Arrange, Act and Assert
    assertEquals("TEXT", FormatEnum.valueOf("TEXT").toString());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Message}
   *   <li>{@link Message#setData(String)}
   *   <li>{@link Message#setFormat(FormatEnum)}
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Message.<init>()", "String Message.getData()", "FormatEnum Message.getFormat()",
      "String Message.getMessage()", "Long Message.getTimestamp()", "MessageMLVersion Message.getVersion()",
      "void Message.setData(String)", "void Message.setFormat(FormatEnum)", "void Message.setMessage(String)",
      "void Message.setTimestamp(Long)", "void Message.setVersion(MessageMLVersion)", "String Message.toString()"})
  public void testGettersAndSetters() {
    // Arrange and Act
    Message actualMessage = new Message();
    actualMessage.setData("Data");
    actualMessage.setFormat(FormatEnum.TEXT);
    actualMessage.setMessage("Not all who wander are lost");
    actualMessage.setTimestamp(10L);
    actualMessage.setVersion(MessageMLVersion.V1);
    String actualToStringResult = actualMessage.toString();
    String actualData = actualMessage.getData();
    FormatEnum actualFormat = actualMessage.getFormat();
    String actualMessage2 = actualMessage.getMessage();
    Long actualTimestamp = actualMessage.getTimestamp();
    MessageMLVersion actualVersion = actualMessage.getVersion();

    // Assert
    assertEquals("Data", actualData);
    assertEquals("Message{timestamp=10, message='Not all who wander are lost', format=TEXT, data='Data', version=V1}",
        actualToStringResult);
    assertEquals("Not all who wander are lost", actualMessage2);
    assertEquals(10L, actualTimestamp.longValue());
    assertEquals(FormatEnum.TEXT, actualFormat);
    assertEquals(MessageMLVersion.V1, actualVersion);
  }
}
