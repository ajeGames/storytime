package com.ajegames.storytime.resource;

import io.dropwizard.testing.junit.ResourceTestRule;
import org.junit.ClassRule;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.ws.rs.core.Response;

/**
 * Test as a resource.
 */
public class StoryTimeResourceTest {

    @ClassRule
    public static final ResourceTestRule resources = ResourceTestRule.builder()
            .addResource(new StoryTimeResource()).build();

    @Test
    public void testPing() {
        Response response = resources.client().target("api/storytime").request().get();
        Assert.assertNotNull(response);
    }
}
