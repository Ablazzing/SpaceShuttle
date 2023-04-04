package com.javaacademy;

import com.javaacademy.details.Rocket;
import com.javaacademy.exceptions.LimitFuelException;
import com.javaacademy.exceptions.NotEnoughFuelException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RocketIT {

    @Test
    @DisplayName("Проверка топлива после старта")
    public void testFuel() throws LimitFuelException, NotEnoughFuelException {
        Rocket rocket = new Rocket(70000, 80000, 90000);
        rocket.run();
        Assertions.assertEquals(0, rocket.getFirstStage().getCurrentFuel());
        Assertions.assertEquals(0, rocket.getSecondStage().getCurrentFuel());
        Assertions.assertEquals(0, rocket.getThirdStage().getCurrentFuel());
    }
}
