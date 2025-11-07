package org.symphonyoss.integration.model.yaml;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class KeystoreDiffblueTest {
  /**
   * Method under test: {@link Keystore#getPassword()}
   */
  @Test
  public void testGetPassword() {
    // Arrange, Act and Assert
    assertEquals("", (new Keystore()).getPassword());
  }

  /**
   * Method under test: {@link Keystore#getPassword()}
   */
  @Test
  public void testGetPassword2() {
    // Arrange
    Keystore keystore = new Keystore();
    keystore.setFile("File");
    keystore.setType("Type");
    keystore.setPassword("foo");

    // Act and Assert
    assertEquals("foo", keystore.getPassword());
  }

  /**
   * Method under test: {@link Keystore#getType()}
   */
  @Test
  public void testGetType() {
    // Arrange, Act and Assert
    assertEquals(Keystore.DEFAULT_KEYSTORE_TYPE, (new Keystore()).getType());
  }

  /**
   * Method under test: {@link Keystore#getType()}
   */
  @Test
  public void testGetType2() {
    // Arrange
    Keystore keystore = new Keystore();
    keystore.setFile("File");
    keystore.setPassword("iloveyou");
    keystore.setType("foo");

    // Act and Assert
    assertEquals("foo", keystore.getType());
  }

  /**
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
  public void testGettersAndSetters() {
    // Arrange and Act
    Keystore actualKeystore = new Keystore();
    actualKeystore.setFile("File");
    actualKeystore.setPassword("iloveyou");
    actualKeystore.setType("Type");

    // Assert that nothing has changed
    assertEquals("File", actualKeystore.getFile());
  }
}
