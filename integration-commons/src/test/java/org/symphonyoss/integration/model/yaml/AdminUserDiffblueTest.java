package org.symphonyoss.integration.model.yaml;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class AdminUserDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdminUser.<init>()", "String AdminUser.getKeystoreFile()",
      "String AdminUser.getKeystorePassword()", "void AdminUser.setKeystoreFile(String)",
      "void AdminUser.setKeystorePassword(String)"})
  public void testGettersAndSetters() {
    // Arrange and Act
    AdminUser actualAdminUser = new AdminUser();
    actualAdminUser.setKeystoreFile("Keystore File");
    actualAdminUser.setKeystorePassword("iloveyou");
    String actualKeystoreFile = actualAdminUser.getKeystoreFile();

    // Assert
    assertEquals("Keystore File", actualKeystoreFile);
    assertEquals("iloveyou", actualAdminUser.getKeystorePassword());
  }
}
