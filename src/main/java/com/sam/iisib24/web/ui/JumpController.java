// JumpController.java
package com.sam.iisib24.web.ui;

import com.sam.iisib24.model.JumpPhysics;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
public class JumpController {
    @GetMapping("/jump")
    public String showJumpPage() {
        return "jump";
    }

    @PostMapping("/jump")
    @ResponseBody
    public Map<String, Object> calculateJump(
            @RequestParam String planet,
            @RequestParam double velocity) {

        JumpPhysics jumpPhysics = new JumpPhysics();
        double planetGravity = getPlanetGravity(planet);

        jumpPhysics.setPlanetGravity(planetGravity);
        jumpPhysics.setInitialVelocity(velocity);

        Map<String, Object> response = new HashMap<>();
        response.put("maxHeight", jumpPhysics.calculateMaxHeight());
        response.put("jumpTime", jumpPhysics.calculateJumpTime());
        response.put("gravity", planetGravity);

        return response;
    }

    private double getPlanetGravity(String planet) {
        return switch (planet.toLowerCase()) {
            case "mercury" -> 3.7;
            case "venus" -> 8.87;
            case "earth" -> 9.81;
            case "mars" -> 3.71;
            case "jupiter" -> 24.79;
            case "sun" -> 244;
            case "moon" -> 1.625;
            default -> 9.81;
        };
    }
}