package org.symphonyoss.integration.utils;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.symphonyoss.integration.exception.bootstrap.CertificateNotFoundException;

public class IntegrationUtilsDiffblueTest {
  @Rule
  public ExpectedException thrown = ExpectedException.none();

  /**
   * Method under test: {@link IntegrationUtils#getCertsDirectory()}
   */
  @Test
  public void testGetCertsDirectory() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    thrown.expect(CertificateNotFoundException.class);
    (new IntegrationUtils("")).getCertsDirectory();
  }
}
