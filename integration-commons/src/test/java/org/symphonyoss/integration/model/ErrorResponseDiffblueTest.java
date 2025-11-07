package org.symphonyoss.integration.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ErrorResponseDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ErrorResponse#ErrorResponse()}
   *   <li>{@link ErrorResponse#setMessage(String)}
   *   <li>{@link ErrorResponse#setProperties(Object)}
   *   <li>{@link ErrorResponse#setStatus(int)}
   *   <li>{@link ErrorResponse#getMessage()}
   *   <li>{@link ErrorResponse#getProperties()}
   *   <li>{@link ErrorResponse#getStatus()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ErrorResponse.<init>()", "void ErrorResponse.<init>(int, String)",
      "String ErrorResponse.getMessage()", "Object ErrorResponse.getProperties()", "int ErrorResponse.getStatus()",
      "void ErrorResponse.setMessage(String)", "void ErrorResponse.setProperties(Object)",
      "void ErrorResponse.setStatus(int)"})
  public void testGettersAndSetters() {
    // Arrange and Act
    ErrorResponse actualErrorResponse = new ErrorResponse();
    actualErrorResponse.setMessage("Not all who wander are lost");
    actualErrorResponse.setProperties("Properties");
    actualErrorResponse.setStatus(1);
    String actualMessage = actualErrorResponse.getMessage();
    Object actualProperties = actualErrorResponse.getProperties();

    // Assert
    assertEquals("Not all who wander are lost", actualMessage);
    assertEquals("Properties", actualProperties);
    assertEquals(1, actualErrorResponse.getStatus());
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When one.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ErrorResponse#ErrorResponse(int, String)}
   *   <li>{@link ErrorResponse#setMessage(String)}
   *   <li>{@link ErrorResponse#setProperties(Object)}
   *   <li>{@link ErrorResponse#setStatus(int)}
   *   <li>{@link ErrorResponse#getMessage()}
   *   <li>{@link ErrorResponse#getProperties()}
   *   <li>{@link ErrorResponse#getStatus()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ErrorResponse.<init>()", "void ErrorResponse.<init>(int, String)",
      "String ErrorResponse.getMessage()", "Object ErrorResponse.getProperties()", "int ErrorResponse.getStatus()",
      "void ErrorResponse.setMessage(String)", "void ErrorResponse.setProperties(Object)",
      "void ErrorResponse.setStatus(int)"})
  public void testGettersAndSetters_whenOne() {
    // Arrange and Act
    ErrorResponse actualErrorResponse = new ErrorResponse(1, "Not all who wander are lost");
    actualErrorResponse.setMessage("Not all who wander are lost");
    actualErrorResponse.setProperties("Properties");
    actualErrorResponse.setStatus(1);
    String actualMessage = actualErrorResponse.getMessage();
    Object actualProperties = actualErrorResponse.getProperties();

    // Assert
    assertEquals("Not all who wander are lost", actualMessage);
    assertEquals("Properties", actualProperties);
    assertEquals(1, actualErrorResponse.getStatus());
  }

  /**
   * Test {@link ErrorResponse#equals(Object)}, and {@link ErrorResponse#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ErrorResponse#equals(Object)}
   *   <li>{@link ErrorResponse#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ErrorResponse.equals(Object)", "int ErrorResponse.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ErrorResponse errorResponse = new ErrorResponse(1, "Not all who wander are lost");
    ErrorResponse errorResponse2 = new ErrorResponse(1, "Not all who wander are lost");

    // Act and Assert
    assertEquals(errorResponse, errorResponse2);
    int expectedHashCodeResult = errorResponse.hashCode();
    assertEquals(expectedHashCodeResult, errorResponse2.hashCode());
  }

  /**
   * Test {@link ErrorResponse#equals(Object)}, and {@link ErrorResponse#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ErrorResponse#equals(Object)}
   *   <li>{@link ErrorResponse#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ErrorResponse.equals(Object)", "int ErrorResponse.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    ErrorResponse errorResponse = new ErrorResponse(1, null);
    ErrorResponse errorResponse2 = new ErrorResponse(1, null);

    // Act and Assert
    assertEquals(errorResponse, errorResponse2);
    int expectedHashCodeResult = errorResponse.hashCode();
    assertEquals(expectedHashCodeResult, errorResponse2.hashCode());
  }

  /**
   * Test {@link ErrorResponse#equals(Object)}, and {@link ErrorResponse#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ErrorResponse#equals(Object)}
   *   <li>{@link ErrorResponse#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ErrorResponse.equals(Object)", "int ErrorResponse.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ErrorResponse errorResponse = new ErrorResponse(1, "Not all who wander are lost");

    // Act and Assert
    assertEquals(errorResponse, errorResponse);
    int expectedHashCodeResult = errorResponse.hashCode();
    assertEquals(expectedHashCodeResult, errorResponse.hashCode());
  }

  /**
   * Test {@link ErrorResponse#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ErrorResponse#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ErrorResponse.equals(Object)", "int ErrorResponse.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ErrorResponse errorResponse = new ErrorResponse(0, "Not all who wander are lost");

    // Act and Assert
    assertNotEquals(errorResponse, new ErrorResponse(1, "Not all who wander are lost"));
  }

  /**
   * Test {@link ErrorResponse#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ErrorResponse#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ErrorResponse.equals(Object)", "int ErrorResponse.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ErrorResponse errorResponse = new ErrorResponse(1, "Message");

    // Act and Assert
    assertNotEquals(errorResponse, new ErrorResponse(1, "Not all who wander are lost"));
  }

  /**
   * Test {@link ErrorResponse#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ErrorResponse#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ErrorResponse.equals(Object)", "int ErrorResponse.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ErrorResponse errorResponse = new ErrorResponse(1, null);

    // Act and Assert
    assertNotEquals(errorResponse, new ErrorResponse(1, "Not all who wander are lost"));
  }

  /**
   * Test {@link ErrorResponse#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ErrorResponse#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ErrorResponse.equals(Object)", "int ErrorResponse.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ErrorResponse errorResponse = new ErrorResponse(1, "Not all who wander are lost");
    errorResponse.setProperties("Properties");

    // Act and Assert
    assertNotEquals(errorResponse, new ErrorResponse(1, "Not all who wander are lost"));
  }

  /**
   * Test {@link ErrorResponse#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ErrorResponse#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ErrorResponse.equals(Object)", "int ErrorResponse.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ErrorResponse errorResponse = new ErrorResponse(1, "Not all who wander are lost");

    ErrorResponse errorResponse2 = new ErrorResponse(1, "Not all who wander are lost");
    errorResponse2.setProperties("Properties");

    // Act and Assert
    assertNotEquals(errorResponse, errorResponse2);
  }

  /**
   * Test {@link ErrorResponse#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ErrorResponse#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ErrorResponse.equals(Object)", "int ErrorResponse.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    ErrorResponse errorResponse = new ErrorResponse(1, "Not all who wander are lost");
    errorResponse.setProperties(new ErrorResponse(1, "Not all who wander are lost"));

    // Act and Assert
    assertNotEquals(errorResponse, new ErrorResponse(1, "Not all who wander are lost"));
  }

  /**
   * Test {@link ErrorResponse#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ErrorResponse#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ErrorResponse.equals(Object)", "int ErrorResponse.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ErrorResponse(1, "Not all who wander are lost"), null);
  }

  /**
   * Test {@link ErrorResponse#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ErrorResponse#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ErrorResponse.equals(Object)", "int ErrorResponse.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ErrorResponse(1, "Not all who wander are lost"), "Different type to ErrorResponse");
  }
}
