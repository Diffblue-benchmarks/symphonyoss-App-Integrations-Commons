package org.symphonyoss.integration.logging;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class MessageUtilsDiffblueTest {
  /**
   * Test {@link MessageUtils#MessageUtils(String)}.
   * <ul>
   *   <li>Then return Message {@code 42} is {@code null} is {@code Message not found for resource 42.}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MessageUtils#MessageUtils(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MessageUtils.<init>(String)"})
  public void testNewMessageUtils_thenReturnMessage42IsNullIsMessageNotFoundForResource42() {
    // Arrange, Act and Assert
    assertEquals("Message not found for resource 42.", (new MessageUtils("foo.txt")).getMessage("42", null));
  }

  /**
   * Test {@link MessageUtils#getMessage(String, String[])}.
   * <p>
   * Method under test: {@link MessageUtils#getMessage(String, String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String MessageUtils.getMessage(String, String[])"})
  public void testGetMessage() {
    // Arrange, Act and Assert
    assertEquals("Message not found for resource 42.", (new MessageUtils("foo.txt")).getMessage("42", "Args"));
  }
}
