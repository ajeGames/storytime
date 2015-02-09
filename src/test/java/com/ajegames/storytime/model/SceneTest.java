package com.ajegames.storytime.model;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * For testing <code>Scene</code>.
 */
public class SceneTest {

    @Test
    public void testCreateEmptyScene() {
        Scene result = Scene.createEmptyScene();

        Assert.assertNull(result.getKey());
        Assert.assertNull(result.getSummary());
        Assert.assertNull(result.getContent());
        Assert.assertTrue(result.getChoices().isEmpty());
    }

    @Test
    public void testLoadScene() {
        String key = "12345";
        String summary = "Take the garden path.";
        String content = "Peter decides to hop along the garden path.";

        Scene result = Scene.loadScene(key, summary, content);

        Assert.assertEquals(result.getKey(), key);
        Assert.assertEquals(result.getSummary(), summary);
        Assert.assertEquals(result.getContent(), content);
        Assert.assertTrue(result.getChoices().isEmpty());
    }
}
