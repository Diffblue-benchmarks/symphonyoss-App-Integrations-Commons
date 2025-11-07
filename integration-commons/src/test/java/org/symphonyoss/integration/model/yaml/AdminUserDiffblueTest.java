package org.symphonyoss.integration.model.yaml;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class AdminUserDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link AdminUser}
   *   <li>{@link AdminUser#setKeystoreFile(String)}
   *   <li>{@link AdminUser#setKeystorePassword(String)}
   *   <li>{@link AdminUser#getKeystoreFile()}
   *   <li>{@link AdminUser#getKeystorePassword()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    AdminUser actualAdminUser = new AdminUser();
    actualAdminUser.setKeystoreFile("Keystore File");
    actualAdminUser.setKeystorePassword("iloveyou");
    String actualKeystoreFile = actualAdminUser.getKeystoreFile();

    // Assert that nothing has changed
    assertEquals("Keystore File", actualKeystoreFile);
    assertEquals("iloveyou", actualAdminUser.getKeystorePassword());
  }
}
