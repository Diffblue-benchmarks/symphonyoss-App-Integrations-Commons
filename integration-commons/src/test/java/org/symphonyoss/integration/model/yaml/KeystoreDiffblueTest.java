package org.symphonyoss.integration.model.yaml;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;

public class KeystoreDiffblueTest {
  /**
   * Test {@link Keystore#getPassword()}.
   * <ul>
   *   <li>Given {@link Keystore} (default constructor) File is {@code File}.</li>
   *   <li>Then return {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Keystore#getPassword()}
   */
  @Test
  @MethodsUnderTest({"String Keystore.getPassword()"})
  public void testGetPassword_givenKeystoreFileIsFile_thenReturnFoo() {
    // Arrange
    Keystore keystore = new Keystore();
    keystore.setFile("File");
    keystore.setType("Type");
    keystore.setPassword("foo");

    // Act and Assert
    assertEquals("foo", keystore.getPassword());
  }

  /**
   * Test {@link Keystore#getPassword()}.
   * <ul>
   *   <li>Given {@link Keystore} (default constructor).</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link Keystore#getPassword()}
   */
  @Test
  @MethodsUnderTest({"String Keystore.getPassword()"})
  public void testGetPassword_givenKeystore_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", (new Keystore()).getPassword());
  }

  /**
   * Test {@link Keystore#getType()}.
   * <ul>
   *   <li>Given {@link Keystore} (default constructor) File is {@code File}.</li>
   *   <li>Then return {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Keystore#getType()}
   */
  @Test
  @MethodsUnderTest({"String Keystore.getType()"})
  public void testGetType_givenKeystoreFileIsFile_thenReturnFoo() {
    // Arrange
    Keystore keystore = new Keystore();
    keystore.setFile("File");
    keystore.setPassword("iloveyou");
    keystore.setType("foo");

    // Act and Assert
    assertEquals("foo", keystore.getType());
  }

  /**
   * Test {@link Keystore#getType()}.
   * <ul>
   *   <li>Given {@link Keystore} (default constructor).</li>
   *   <li>Then return {@link Keystore#DEFAULT_KEYSTORE_TYPE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Keystore#getType()}
   */
  @Test
  @MethodsUnderTest({"String Keystore.getType()"})
  public void testGetType_givenKeystore_thenReturnDefault_keystore_type() {
    // Arrange, Act and Assert
    assertEquals(Keystore.DEFAULT_KEYSTORE_TYPE, (new Keystore()).getType());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Keystore}
   *   <li>{@link Keystore#setFile(String)}
   *   <li>{@link Keystore#setPassword(String)}
   *   <li>{@link Keystore#setType(String)}
   *   <li>{@link Keystore#getFile()}
   * </ul>
   */
  @Test
  @MethodsUnderTest({"void Keystore.<init>()", "String Keystore.getFile()", "void Keystore.setFile(String)",
      "void Keystore.setPassword(String)", "void Keystore.setType(String)"})
  public void testGettersAndSetters() {
    // Arrange and Act
    Keystore actualKeystore = new Keystore();
    actualKeystore.setFile("File");
    actualKeystore.setPassword("iloveyou");
    actualKeystore.setType("Type");

    // Assert
    assertEquals("File", actualKeystore.getFile());
  }
}
