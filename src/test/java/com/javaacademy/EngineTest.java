package com.javaacademy;

import com.javaacademy.details.Engine;
import com.javaacademy.exceptions.LimitFuelException;
import com.javaacademy.exceptions.NotEnoughFuelException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class EngineTest {


    @Test
    @DisplayName("Проверка наличия ошибки, если топливо превышено")
    public void testLimitFuel() {
        Assertions.assertThrows(LimitFuelException.class, () -> new Engine(200_000));
    }

    @Test
    @DisplayName("Проверка наличия ошибки, если топлива не хватает")
    public void testThresholdFuel() throws LimitFuelException {
        Engine engine = new Engine(10000);
        Assertions.assertThrows(NotEnoughFuelException.class, engine::start);
    }
}
