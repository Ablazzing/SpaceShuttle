package com.javaacademy.details;

import com.javaacademy.exceptions.LimitFuelException;
import com.javaacademy.exceptions.NotEnoughFuelException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class RocketTest {
    @Mock
    Engine firstStage;
    @Mock
    Engine secondStage;
    @Mock
    Engine thirdStage;
    @InjectMocks
    Rocket rocket2;

    RocketTest() throws LimitFuelException {
        //Приходится вызывать самостоятельно конструктор, потому что примитивные парамметры
        rocket2 = new Rocket(10_000, 10_000, 10_000);
    }

    @Test
    @DisplayName("Проверяем наличие трех двигателей у ракеты")
    void newRocketShouldHaveThreeEngines() throws LimitFuelException {
        Rocket rocket = new Rocket(100_000, 100_000, 100_000);
        assertNotNull(rocket.getFirstStage());
        assertNotNull(rocket.getSecondStage());
        assertNotNull(rocket.getThirdStage());
    }

    @Test
    @DisplayName("Проверяем Exception при превышении предела топлива")
    void newEngineShouldThrowLimitFuelException() {
        assertThrows(LimitFuelException.class, () -> new Rocket(200_000,
                200_000, 200_000), "Отсутствует Exception");
    }

    @Test
    @DisplayName("Проверяем Exception при низком уровне топлива")
    void startShouldThrowNotEnoughFuelException() {
        assertThrows(NotEnoughFuelException.class, () -> new Rocket(59_999,
                59_999, 59_999).getFirstStage().start(), "Отсутствует Exception");
    }

    @Test
    @DisplayName("Проверяем отсутствие Exception при исправных Двигателях")
    void runShouldNotThrowExceptionEnginesWork() throws NotEnoughFuelException {
        Mockito.doNothing().when(firstStage).start();
        Mockito.doNothing().when(secondStage).start();
        Mockito.doNothing().when(thirdStage).start();
        assertDoesNotThrow(() -> rocket2.run());
    }

}