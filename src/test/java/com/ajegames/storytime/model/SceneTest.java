package com.ajegames.storytime.model;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SceneTest {

    @Test
    public void testNewSceneCreation() {
        Scene myScene = Scene.createNew("Test teaser", "Test heading", "Test prose");
        Assert.assertEquals(myScene.getTeaser(), "Test teaser");
        Assert.assertEquals(myScene.getHeading(), "Test heading");
        Assert.assertEquals(myScene.getProse(), "Test prose");
    }

    @Test
    public void testExistingSceneCreation() {
        Scene myScene = Scene.createExisting("01234567", "Test teaser", "Test heading", "Test prose");
        Assert.assertEquals(myScene.getKey(), "01234567");
        Assert.assertEquals(myScene.getTeaser(), "Test teaser");
        Assert.assertEquals(myScene.getHeading(), "Test heading");
        Assert.assertEquals(myScene.getProse(), "Test prose");
    }
}
