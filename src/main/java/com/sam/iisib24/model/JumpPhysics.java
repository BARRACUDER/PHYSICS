// JumpPhysics.java
package com.sam.iisib24.model;

import org.springframework.stereotype.Component;

@Component
public class JumpPhysics {
    private double initialVelocity;
    private double planetGravity;

    public void setInitialVelocity(double initialVelocity) {
        this.initialVelocity = initialVelocity;
    }

    public void setPlanetGravity(double planetGravity) {
        this.planetGravity = planetGravity;
    }

    public double calculateMaxHeight() {
        return (initialVelocity * initialVelocity) / (2 * planetGravity);
    }

    public double calculateJumpTime() {
        return 2 * (initialVelocity / planetGravity);
    }
}