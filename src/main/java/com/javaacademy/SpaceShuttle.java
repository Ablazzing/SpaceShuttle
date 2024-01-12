package com.javaacademy;

import com.javaacademy.details.Rocket;
import com.javaacademy.details.Capsule;
import com.javaacademy.exceptions.CosmonautIsNotReadyException;
import com.javaacademy.exceptions.NotEnoughFuelException;

/**
 * Космический корабль
 */
public class SpaceShuttle {
    //Имя корабля
    private final String name;
    //Ракета носитель
    private final Rocket rocket;
    //Космический аппарат
    private final Capsule capsule;

    public SpaceShuttle(String name, Rocket rocket, Capsule capsule) {
        this.name = name;
        this.rocket = rocket;
        this.capsule = capsule;
    }

    /**
     * Посадка космонавта на борт
     */
    public void setCosmonaut(Cosmonaut cosmonaut) {
        capsule.setCosmonaut(cosmonaut);
    }

    /**
     * Запуск шаттла
     */
    public void run() throws CosmonautIsNotReadyException, NotEnoughFuelException {
        if (capsule.getCosmonaut().isHealthy()) {
            rocket.run();
            capsule.getCosmonaut().phrase();
            return;
        }
        throw new CosmonautIsNotReadyException();
    }

    public Rocket getRocket() {
        return rocket;
    }

    public Capsule getSpacecraft() {
        return capsule;
    }

    public String getName() {
        return name;
    }
}
