package com.javaacademy.details;

import com.javaacademy.exceptions.LimitFuelException;
import com.javaacademy.exceptions.NotEnoughFuelException;

/**
 * Двигатель космического корабля
 */
public class Engine {
    //Минимальное количество топливо для старта
    private static final double MINIMUM_FUEL_FOR_START = 60_000;
    //Максимальное количество топлива внутри двигателя
    private static final double MAX_FUEL = 100_000;
    //Текущее количество топлива в двигателе
    private double currentFuel;

    public Engine(double currentFuel) throws LimitFuelException {
        if (currentFuel > 100_000) {
            throw new LimitFuelException("Первышено кол-во топлива");
        }
        this.currentFuel = currentFuel;
    }

    /**
     * Запуск двигателя
     */
    public void start() throws NotEnoughFuelException {
        if (currentFuel < 60000){
            throw new NotEnoughFuelException("Нехватает топлива");
        }
        currentFuel = 0;
    }

    public void setCurrentFuel(double currentFuel) {
        this.currentFuel = currentFuel;
    }

    public double getCurrentFuel() {
        return currentFuel;
    }
}
