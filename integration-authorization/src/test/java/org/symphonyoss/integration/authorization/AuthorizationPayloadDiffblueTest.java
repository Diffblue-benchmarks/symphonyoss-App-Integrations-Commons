package org.symphonyoss.integration.authorization;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class AuthorizationPayloadDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AuthorizationPayload#AuthorizationPayload(Map, Map, String)}
   *   <li>{@link AuthorizationPayload#getBody()}
   *   <li>{@link AuthorizationPayload#getHeaders()}
   *   <li>{@link AuthorizationPayload#getParameters()}
   * </ul>
   */
  @Test
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AuthorizationPayload.<init>(Map, Map, String)",
    "String AuthorizationPayload.getBody()",
    "Map AuthorizationPayload.getHeaders()",
    "Map AuthorizationPayload.getParameters()"
  })
  public void testGettersAndSetters() {
    // Arrange
    HashMap<String, String> parameters = new HashMap<>();

    HashMap<String, String> headers = new HashMap<>();
    headers.put("Delivered-To", "alice.liddell@example.org");

    // Act
    AuthorizationPayload actualAuthorizationPayload =
        new AuthorizationPayload(parameters, headers, "Not all who wander are lost");
    String actualBody = actualAuthorizationPayload.getBody();
    Map<String, String> actualHeaders = actualAuthorizationPayload.getHeaders();
    Map<String, String> actualParameters = actualAuthorizationPayload.getParameters();

    // Assert
    assertEquals("Not all who wander are lost", actualBody);
    assertEquals(1, actualHeaders.size());
    assertEquals("alice.liddell@example.org", actualHeaders.get("Delivered-To"));
    assertTrue(actualParameters.isEmpty());
    assertSame(headers, actualHeaders);
    assertSame(parameters, actualParameters);
  }
}
