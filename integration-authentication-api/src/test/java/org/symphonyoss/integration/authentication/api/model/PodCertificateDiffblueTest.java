package org.symphonyoss.integration.authentication.api.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;

public class PodCertificateDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PodCertificate#PodCertificate()}
   *   <li>{@link PodCertificate#setCertificate(String)}
   *   <li>{@link PodCertificate#getCertificate()}
   * </ul>
   */
  @Test
  @MethodsUnderTest({"void PodCertificate.<init>()", "void PodCertificate.<init>(String)",
      "String PodCertificate.getCertificate()", "void PodCertificate.setCertificate(String)"})
  public void testGettersAndSetters() {
    // Arrange and Act
    PodCertificate actualPodCertificate = new PodCertificate();
    actualPodCertificate.setCertificate("Certificate");

    // Assert
    assertEquals("Certificate", actualPodCertificate.getCertificate());
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@code Certificate}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PodCertificate#PodCertificate(String)}
   *   <li>{@link PodCertificate#setCertificate(String)}
   *   <li>{@link PodCertificate#getCertificate()}
   * </ul>
   */
  @Test
  @MethodsUnderTest({"void PodCertificate.<init>()", "void PodCertificate.<init>(String)",
      "String PodCertificate.getCertificate()", "void PodCertificate.setCertificate(String)"})
  public void testGettersAndSetters_whenCertificate() {
    // Arrange and Act
    PodCertificate actualPodCertificate = new PodCertificate("Certificate");
    actualPodCertificate.setCertificate("Certificate");

    // Assert
    assertEquals("Certificate", actualPodCertificate.getCertificate());
  }

  /**
   * Test {@link PodCertificate#equals(Object)}, and {@link PodCertificate#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PodCertificate#equals(Object)}
   *   <li>{@link PodCertificate#hashCode()}
   * </ul>
   */
  @Test
  @MethodsUnderTest({"boolean PodCertificate.equals(Object)", "int PodCertificate.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    PodCertificate podCertificate = new PodCertificate("Certificate");
    PodCertificate podCertificate2 = new PodCertificate("Certificate");

    // Act and Assert
    assertEquals(podCertificate, podCertificate2);
    int expectedHashCodeResult = podCertificate.hashCode();
    assertEquals(expectedHashCodeResult, podCertificate2.hashCode());
  }

  /**
   * Test {@link PodCertificate#equals(Object)}, and {@link PodCertificate#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PodCertificate#equals(Object)}
   *   <li>{@link PodCertificate#hashCode()}
   * </ul>
   */
  @Test
  @MethodsUnderTest({"boolean PodCertificate.equals(Object)", "int PodCertificate.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    PodCertificate podCertificate = new PodCertificate("Certificate");

    // Act and Assert
    assertEquals(podCertificate, podCertificate);
    int expectedHashCodeResult = podCertificate.hashCode();
    assertEquals(expectedHashCodeResult, podCertificate.hashCode());
  }

  /**
   * Test {@link PodCertificate#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PodCertificate#equals(Object)}
   */
  @Test
  @MethodsUnderTest({"boolean PodCertificate.equals(Object)", "int PodCertificate.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    PodCertificate podCertificate = new PodCertificate(null);

    // Act and Assert
    assertNotEquals(podCertificate, new PodCertificate("Certificate"));
  }

  /**
   * Test {@link PodCertificate#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PodCertificate#equals(Object)}
   */
  @Test
  @MethodsUnderTest({"boolean PodCertificate.equals(Object)", "int PodCertificate.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new PodCertificate("Certificate"), null);
  }

  /**
   * Test {@link PodCertificate#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PodCertificate#equals(Object)}
   */
  @Test
  @MethodsUnderTest({"boolean PodCertificate.equals(Object)", "int PodCertificate.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new PodCertificate("Certificate"), "Different type to PodCertificate");
  }
}
