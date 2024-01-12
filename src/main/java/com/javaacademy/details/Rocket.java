package com.javaacademy.details;

import com.javaacademy.exceptions.LimitFuelException;
import com.javaacademy.exceptions.NotEnoughFuelException;

/**
 * Ракета носитель
 */
public class Rocket {
    //Двигатель первой стадии
    private Engine firstStage;
    //Двигатель второй стадии
    private Engine secondStage;
    //Двигатель третьей стадии
    private Engine thirdStage;

    public Rocket(double fuelStageOne, double fuelStageTwo, double fuelStageThree) throws LimitFuelException {
        this.firstStage = new Engine(fuelStageOne);
        this.secondStage = new Engine(fuelStageTwo);
        this.thirdStage = new Engine(fuelStageThree);
    }

    /**
     * Запуск ракеты носителя
     */
    public void run() throws NotEnoughFuelException {
        firstStage.start();
        secondStage.start();
        thirdStage.start();
    }

    public Engine getFirstStage() {
        return firstStage;
    }

    public Engine getSecondStage() {
        return secondStage;
    }

    public Engine getThirdStage() {
        return thirdStage;
    }
}
