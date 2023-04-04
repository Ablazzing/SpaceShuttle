package com.javaacademy;

import com.javaacademy.details.LifeCycleItems.JamTube;
import com.javaacademy.details.LifeCycleItems.OxygenBalloon;
import com.javaacademy.details.LifeCycleItems.Water;
import com.javaacademy.details.Rocket;
import com.javaacademy.details.Capsule;
import com.javaacademy.exceptions.CosmonautIsNotReadyException;
import com.javaacademy.exceptions.LimitFuelException;
import com.javaacademy.exceptions.NotEnoughFuelException;

/**
 * Космодром "Байконур"
 */
public class SpaceShuttleLauncher {
    public static void main(String[] args) throws InterruptedException, LimitFuelException, CosmonautIsNotReadyException, NotEnoughFuelException {
        SpaceShuttleLauncher launcher = new SpaceShuttleLauncher();
        SpaceShuttle shuttle = launcher.createShuttle();
        launcher.startFly(shuttle);
    }

    public void startFly(SpaceShuttle spaceShuttle) throws InterruptedException, CosmonautIsNotReadyException, NotEnoughFuelException {
        System.out.println("Обратный отсчет пошел!");
        Thread.sleep(1000);
        for (int i = 3; i > 0; i--) {
            System.out.println(i);
            Thread.sleep(1000);
        }
        System.out.printf("Космический корабль %s начал полет!\n", spaceShuttle.getName());
        spaceShuttle.run();
        System.out.println("* На заднем фоне играет Эдуард Артемьев - Поход (https://www.youtube.com/watch?v=xVNy38B0Eqg) *");
    }

    public SpaceShuttle createShuttle() throws LimitFuelException, CosmonautIsNotReadyException {
        Rocket rocket = new Rocket(300_000, 70_000, 100_000);

        Water water = new Water();
        JamTube jamTube = new JamTube();
        OxygenBalloon oxygenBalloon = new OxygenBalloon();
        Capsule capsule = new Capsule(water, jamTube, oxygenBalloon);
        SpaceShuttle spaceShuttle = new SpaceShuttle("Восток", rocket, capsule);
        Cosmonaut cosmonaut = new Cosmonaut("Юрий Гагарин");
        spaceShuttle.setCosmonaut(cosmonaut);
        return spaceShuttle;
    }
}
