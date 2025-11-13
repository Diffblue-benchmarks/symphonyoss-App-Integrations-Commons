package org.symphonyoss.integration.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import org.junit.Test;

public class EntityXMLGeneratorExceptionDiffblueTest {
  /**
   * Test {@link EntityXMLGeneratorException#EntityXMLGeneratorException(Exception)}.
   *
   * <ul>
   *   <li>Then return Cause is {@link IOException#IOException(String)} with {@link
   *       RemoteApiException#COMPONENT}.
   * </ul>
   *
   * <p>Method under test: {@link
   * EntityXMLGeneratorException#EntityXMLGeneratorException(Exception)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityXMLGeneratorException.<init>(Exception)"})
  public void testNewEntityXMLGeneratorException_thenReturnCauseIsIOExceptionWithComponent() {
    // Arrange
    IOException e = new IOException(RemoteApiException.COMPONENT);

    // Act
    EntityXMLGeneratorException actualEntityXMLGeneratorException =
        new EntityXMLGeneratorException(e);

    // Assert
    assertEquals(
        "\n"
            + "Component: Commons\n"
            + "Message: Commons\n"
            + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n"
            + "Stack trace: Commons\n",
        actualEntityXMLGeneratorException.getLocalizedMessage());
    assertEquals(
        "\n"
            + "Component: Commons\n"
            + "Message: Commons\n"
            + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n"
            + "Stack trace: Commons\n",
        actualEntityXMLGeneratorException.getMessage());
    assertSame(e, actualEntityXMLGeneratorException.getCause());
  }

  /**
   * Test {@link EntityXMLGeneratorException#EntityXMLGeneratorException(Exception)}.
   *
   * <ul>
   *   <li>When {@link Exception#Exception()}.
   *   <li>Then return Cause is {@link Exception#Exception()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * EntityXMLGeneratorException#EntityXMLGeneratorException(Exception)}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityXMLGeneratorException.<init>(Exception)"})
  public void testNewEntityXMLGeneratorException_whenException_thenReturnCauseIsException() {
    // Arrange
    Exception e = new Exception();

    // Act
    EntityXMLGeneratorException actualEntityXMLGeneratorException =
        new EntityXMLGeneratorException(e);

    // Assert
    assertEquals(
        "\n"
            + "Component: Commons\n"
            + "Message: None\n"
            + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n"
            + "Stack trace: \n",
        actualEntityXMLGeneratorException.getLocalizedMessage());
    assertEquals(
        "\n"
            + "Component: Commons\n"
            + "Message: None\n"
            + "Solutions: \n"
            + "No solution has been cataloged for troubleshooting this problem.\n"
            + "Stack trace: \n",
        actualEntityXMLGeneratorException.getMessage());
    assertSame(e, actualEntityXMLGeneratorException.getCause());
  }
}
