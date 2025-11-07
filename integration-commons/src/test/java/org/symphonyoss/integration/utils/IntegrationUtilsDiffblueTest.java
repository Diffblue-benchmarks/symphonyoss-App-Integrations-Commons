package org.symphonyoss.integration.utils;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;
import org.symphonyoss.integration.exception.bootstrap.CertificateNotFoundException;

@RunWith(MockitoJUnitRunner.class)
public class IntegrationUtilsDiffblueTest {
  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @InjectMocks
  private IntegrationUtils integrationUtils;

  @InjectMocks
  private String string;

  /**
   * Test {@link IntegrationUtils#getCertsDirectory()}.
   * <p>
   * Method under test: {@link IntegrationUtils#getCertsDirectory()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String IntegrationUtils.getCertsDirectory()"})
  public void testGetCertsDirectory() {
    // Arrange, Act and Assert
    thrown.expect(CertificateNotFoundException.class);
    integrationUtils.getCertsDirectory();
  }
}
