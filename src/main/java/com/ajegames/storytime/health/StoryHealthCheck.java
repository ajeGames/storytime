package com.ajegames.storytime.health;

import com.codahale.metrics.health.HealthCheck;

/**
 * Created by dmount on 2/22/15.
 */
public class StoryHealthCheck extends HealthCheck {

    @Override
    protected Result check() throws Exception {
        return Result.healthy();
    }
}
