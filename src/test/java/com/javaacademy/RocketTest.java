package com.javaacademy;

import com.javaacademy.details.Engine;
import com.javaacademy.details.Rocket;
import com.javaacademy.exceptions.LimitFuelException;
import com.javaacademy.exceptions.NotEnoughFuelException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.mockito.Mockito;

public class RocketTest {

    @Test
    @DisplayName("Проверка наличия двигателей у ракеты")
    public void tesPresenceEngine() throws LimitFuelException {
        Rocket rocket = new Rocket(10000, 20000, 30000);
        Assertions.assertNotNull(rocket.getFirstStage());
        Assertions.assertNotNull(rocket.getSecondStage());
        Assertions.assertNotNull(rocket.getThirdStage());
    }

    @Test
    public void testRocketRun() {
        Engine mockFirstStage = Mockito.mock(Engine.class);
        Engine mockSecondStage = Mockito.mock(Engine.class);
        Engine mockThirdStage = Mockito.mock(Engine.class);
        Rocket rocket = new Rocket(mockFirstStage, mockSecondStage, mockThirdStage);
        Assertions.assertDoesNotThrow(rocket::run);
    }

    // Не знаю что я тут намудрил, было бы проще если run() возвращал boolean
    // Можно написать если false, то ожидаем ошибку, закоментил код ниже (что бы было понятно что я имею ввиду)
    @ParameterizedTest
    @CsvFileSource(resources = "/rocket_data.csv", delimiter = ';', numLinesToSkip = 1)
    public void testCreateRocket(String numberExperiment,
                                 Double fuelStageOne,
                                 Double fuelStageTwo,
                                 Double fuelStageThree,
                                 Boolean result) throws LimitFuelException, NotEnoughFuelException {
       /* if (!result){
            Assertions.assertThrows(Exception.class,
                    () -> new Rocket(fuelStageOne, fuelStageTwo, fuelStageThree).run());
        }*/

        try {
            Rocket rocket = new Rocket(fuelStageOne, fuelStageTwo, fuelStageThree);
            rocket.run();
            Assertions.assertEquals(true, result);
        } catch (Exception e) {
            Assertions.assertThrows(Exception.class,
                    () -> new Rocket(fuelStageOne, fuelStageTwo, fuelStageThree).run());
        }
    }
}
