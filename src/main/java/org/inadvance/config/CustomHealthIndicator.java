package org.inadvance.config;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class CustomHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        boolean isHealthy = checkCustomHealthIndicator();
        if (isHealthy) {
            return Health.up().withDetail("customHealth", "All systems go!").build();
        }
        return Health.down().withDetail("customHealth", "Something is wrong!").build();
    }

    private boolean checkCustomHealthIndicator() {
        return true;
    }
}