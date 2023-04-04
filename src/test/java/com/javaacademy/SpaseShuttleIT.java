package com.javaacademy;

import com.javaacademy.details.Capsule;
import com.javaacademy.details.LifeCycleItems.JamTube;
import com.javaacademy.details.LifeCycleItems.OxygenBalloon;
import com.javaacademy.details.LifeCycleItems.Water;
import com.javaacademy.details.Rocket;
import com.javaacademy.exceptions.CosmonautIsNotReadyException;
import com.javaacademy.exceptions.LimitFuelException;
import com.javaacademy.exceptions.NotEnoughFuelException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SpaseShuttleIT {

    @Test
    @DisplayName("Проверка, что при посадке космонавт не заболел")
    public void testHealthCosmonaut() throws LimitFuelException, CosmonautIsNotReadyException {
        SpaceShuttle spaceShuttle = new SpaceShuttle("Test",
                new Rocket(80000,90000,100000),
                new Capsule(new Water(),new JamTube(),new OxygenBalloon()));
        Cosmonaut cosmonaut = new Cosmonaut("Алексей");
        spaceShuttle.setCosmonaut(cosmonaut);
        Assertions.assertTrue(cosmonaut.isHealthy());
    }

    @Test
    @DisplayName("Проверка запуска ракеты, при запуске корабля")
    @Disabled("Слишком дорогой тест")
    public void testRunRocket() throws LimitFuelException, CosmonautIsNotReadyException, NotEnoughFuelException {
        SpaceShuttle spaceShuttle = new SpaceShuttle("Test",
                new Rocket(80000,90000,100000),
                new Capsule(new Water(),new JamTube(),new OxygenBalloon()));
        Cosmonaut cosmonaut = new Cosmonaut("Алексей");
        spaceShuttle.setCosmonaut(cosmonaut);
        spaceShuttle.run();
        Assertions.assertEquals(0,spaceShuttle.getRocket().getFirstStage().getCurrentFuel());
        Assertions.assertEquals(0,spaceShuttle.getRocket().getSecondStage().getCurrentFuel());
        Assertions.assertEquals(0,spaceShuttle.getRocket().getThirdStage().getCurrentFuel());
    }
}
