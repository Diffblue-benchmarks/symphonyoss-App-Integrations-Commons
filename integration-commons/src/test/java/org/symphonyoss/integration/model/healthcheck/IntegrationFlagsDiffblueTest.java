package org.symphonyoss.integration.model.healthcheck;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.symphonyoss.integration.model.healthcheck.IntegrationFlags.ValueEnum;

public class IntegrationFlagsDiffblueTest {
  /**
   * Test {@link IntegrationFlags#isUp()}.
   *
   * <ul>
   *   <li>Given {@link IntegrationFlags} (default constructor) AppCertificateInstalled is {@code
   *       NOK}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link IntegrationFlags#isUp()}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean IntegrationFlags.isUp()"})
  public void testIsUp_givenIntegrationFlagsAppCertificateInstalledIsNok_thenReturnFalse() {
    // Arrange
    IntegrationFlags integrationFlags = new IntegrationFlags();
    integrationFlags.setParserInstalled(ValueEnum.OK);
    integrationFlags.setUserCertificateInstalled(ValueEnum.OK);
    integrationFlags.setUserAuthenticated(ValueEnum.OK);
    integrationFlags.setAppCertificateInstalled(ValueEnum.NOK);

    // Act and Assert
    assertFalse(integrationFlags.isUp());
  }

  /**
   * Test {@link IntegrationFlags#isUp()}.
   *
   * <ul>
   *   <li>Given {@link IntegrationFlags} (default constructor) AppCertificateInstalled is {@link
   *       ValueEnum#NOT_APPLICABLE}.
   * </ul>
   *
   * <p>Method under test: {@link IntegrationFlags#isUp()}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean IntegrationFlags.isUp()"})
  public void testIsUp_givenIntegrationFlagsAppCertificateInstalledIsNot_applicable() {
    // Arrange
    IntegrationFlags integrationFlags = new IntegrationFlags();
    integrationFlags.setParserInstalled(ValueEnum.OK);
    integrationFlags.setUserCertificateInstalled(ValueEnum.OK);
    integrationFlags.setUserAuthenticated(ValueEnum.OK);
    integrationFlags.setAppCertificateInstalled(ValueEnum.NOT_APPLICABLE);

    // Act and Assert
    assertTrue(integrationFlags.isUp());
  }

  /**
   * Test {@link IntegrationFlags#isUp()}.
   *
   * <ul>
   *   <li>Given {@link IntegrationFlags} (default constructor) AppCertificateInstalled is {@link
   *       ValueEnum#OK}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link IntegrationFlags#isUp()}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean IntegrationFlags.isUp()"})
  public void testIsUp_givenIntegrationFlagsAppCertificateInstalledIsOk_thenReturnTrue() {
    // Arrange
    IntegrationFlags integrationFlags = new IntegrationFlags();
    integrationFlags.setParserInstalled(ValueEnum.OK);
    integrationFlags.setUserCertificateInstalled(ValueEnum.OK);
    integrationFlags.setUserAuthenticated(ValueEnum.OK);
    integrationFlags.setAppCertificateInstalled(ValueEnum.OK);

    // Act and Assert
    assertTrue(integrationFlags.isUp());
  }

  /**
   * Test {@link IntegrationFlags#isUp()}.
   *
   * <ul>
   *   <li>Given {@link IntegrationFlags} (default constructor) ParserInstalled is {@code OK}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link IntegrationFlags#isUp()}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean IntegrationFlags.isUp()"})
  public void testIsUp_givenIntegrationFlagsParserInstalledIsOk_thenReturnFalse() {
    // Arrange
    IntegrationFlags integrationFlags = new IntegrationFlags();
    integrationFlags.setParserInstalled(ValueEnum.OK);

    // Act and Assert
    assertFalse(integrationFlags.isUp());
  }

  /**
   * Test {@link IntegrationFlags#isUp()}.
   *
   * <ul>
   *   <li>Given {@link IntegrationFlags} (default constructor) UserAuthenticated is {@code NOK}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link IntegrationFlags#isUp()}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean IntegrationFlags.isUp()"})
  public void testIsUp_givenIntegrationFlagsUserAuthenticatedIsNok_thenReturnFalse() {
    // Arrange
    IntegrationFlags integrationFlags = new IntegrationFlags();
    integrationFlags.setParserInstalled(ValueEnum.OK);
    integrationFlags.setUserCertificateInstalled(ValueEnum.OK);
    integrationFlags.setUserAuthenticated(ValueEnum.NOK);
    integrationFlags.setAppCertificateInstalled(ValueEnum.OK);

    // Act and Assert
    assertFalse(integrationFlags.isUp());
  }

  /**
   * Test {@link IntegrationFlags#isUp()}.
   *
   * <ul>
   *   <li>Given {@link IntegrationFlags} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link IntegrationFlags#isUp()}
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean IntegrationFlags.isUp()"})
  public void testIsUp_givenIntegrationFlags_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new IntegrationFlags().isUp());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link IntegrationFlags}
   *   <li>{@link IntegrationFlags#setAppCertificateInstalled(ValueEnum)}
   *   <li>{@link IntegrationFlags#setParserInstalled(ValueEnum)}
   *   <li>{@link IntegrationFlags#setUserAuthenticated(ValueEnum)}
   *   <li>{@link IntegrationFlags#setUserCertificateInstalled(ValueEnum)}
   *   <li>{@link IntegrationFlags#getAppCertificateInstalled()}
   *   <li>{@link IntegrationFlags#getParserInstalled()}
   *   <li>{@link IntegrationFlags#getUserAuthenticated()}
   *   <li>{@link IntegrationFlags#getUserCertificateInstalled()}
   * </ul>
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void IntegrationFlags.<init>()",
    "ValueEnum IntegrationFlags.getAppCertificateInstalled()",
    "ValueEnum IntegrationFlags.getParserInstalled()",
    "ValueEnum IntegrationFlags.getUserAuthenticated()",
    "ValueEnum IntegrationFlags.getUserCertificateInstalled()",
    "void IntegrationFlags.setAppCertificateInstalled(ValueEnum)",
    "void IntegrationFlags.setParserInstalled(ValueEnum)",
    "void IntegrationFlags.setUserAuthenticated(ValueEnum)",
    "void IntegrationFlags.setUserCertificateInstalled(ValueEnum)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    IntegrationFlags actualIntegrationFlags = new IntegrationFlags();
    actualIntegrationFlags.setAppCertificateInstalled(ValueEnum.OK);
    actualIntegrationFlags.setParserInstalled(ValueEnum.OK);
    actualIntegrationFlags.setUserAuthenticated(ValueEnum.OK);
    actualIntegrationFlags.setUserCertificateInstalled(ValueEnum.OK);
    ValueEnum actualAppCertificateInstalled = actualIntegrationFlags.getAppCertificateInstalled();
    ValueEnum actualParserInstalled = actualIntegrationFlags.getParserInstalled();
    ValueEnum actualUserAuthenticated = actualIntegrationFlags.getUserAuthenticated();

    // Assert
    assertEquals(ValueEnum.OK, actualAppCertificateInstalled);
    assertEquals(ValueEnum.OK, actualParserInstalled);
    assertEquals(ValueEnum.OK, actualUserAuthenticated);
    assertEquals(ValueEnum.OK, actualIntegrationFlags.getUserCertificateInstalled());
  }
}
