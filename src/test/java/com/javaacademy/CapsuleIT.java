package com.javaacademy;

import com.javaacademy.details.Capsule;
import com.javaacademy.details.LifeCycleItems.JamTube;
import com.javaacademy.details.LifeCycleItems.OxygenBalloon;
import com.javaacademy.details.LifeCycleItems.Water;
import com.javaacademy.details.LifeCycleSystem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CapsuleIT {

    @Test
    @DisplayName("Проверка системы жизнеобеспечения")
    public void testLifeCycleSystem() {
        Capsule capsule = new Capsule(new Water(), new JamTube(), new OxygenBalloon());
        LifeCycleSystem lifeCycleSystem = capsule.getLifeCycleSystem();
        Assertions.assertNotNull(lifeCycleSystem.getOxygenBalloon());
    }
}
