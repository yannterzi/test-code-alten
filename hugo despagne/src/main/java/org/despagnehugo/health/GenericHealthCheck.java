package org.despagnehugo.health;

import com.codahale.metrics.health.HealthCheck;

public class GenericHealthCheck extends HealthCheck
{

    @Override
    protected Result check() {
        return Result.healthy();
    }
}
