import com.javaacademy.Cosmonaut;
import com.javaacademy.details.Capsule;
import com.javaacademy.details.LifeCycleItems.JamTube;
import com.javaacademy.details.LifeCycleItems.OxygenBalloon;
import com.javaacademy.details.LifeCycleItems.Water;
import com.javaacademy.details.Rocket;
import com.javaacademy.exceptions.LimitFuelException;
import com.javaacademy.exceptions.NotEnoughFuelException;
import com.opencsv.CSVReader;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;
import org.mockito.Mock;

import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;

@Suite
@SuiteDisplayName("Проверка работоспосбности группы модулей")
public class FunctionalityGroupModulesTest {
    @Mock
    Water water;
    @Mock
    JamTube jamTube;


    @Test
    @DisplayName("Проверяем наличие кислорода в корабле")
    void newCreateCapsuleWithOxygenBalloon() {
        OxygenBalloon oxygenBalloon = new OxygenBalloon();
        Capsule capsule = new Capsule(water, jamTube, oxygenBalloon);
        assertNotNull(capsule.getLifeCycleSystem().getOxygenBalloon());
    }

    @Test
    @DisplayName("Проверяем здоровье космонавта после посадки")
    void cosmonautShouldHealthy() {
        OxygenBalloon oxygenBalloon = new OxygenBalloon();
        Capsule capsule = new Capsule(water, jamTube, oxygenBalloon);
        Cosmonaut cosmonaut = new Cosmonaut("Юрий");
        capsule.setCosmonaut(cosmonaut);
        assertTrue(capsule.getCosmonaut().isHealthy());
    }

    @Test
    @DisplayName("Проверяем чтобы у всех двигателей после запуска не осталось топлива")
    void currentFuelAfterStartShouldBeZero() throws LimitFuelException, NotEnoughFuelException, NoSuchFieldException, IllegalAccessException {
        Rocket rocket = new Rocket(100_000, 100_000, 100_000);
        rocket.run();
        Field field1 = rocket.getFirstStage().getClass().getDeclaredField("currentFuel");
        field1.setAccessible(true);
        double currentFuel1 = (double) field1.get(rocket.getFirstStage());
        Field field2 = rocket.getFirstStage().getClass().getDeclaredField("currentFuel");
        field2.setAccessible(true);
        double currentFuel2 = (double) field2.get(rocket.getFirstStage());
        Field field3 = rocket.getFirstStage().getClass().getDeclaredField("currentFuel");
        field3.setAccessible(true);
        double currentFuel3 = (double) field3.get(rocket.getFirstStage());
        assertEquals(0.00, currentFuel1, 1e-9);
        assertEquals(0.00, currentFuel2, 1e-9);
        assertEquals(0.00, currentFuel3, 1e-9);
    }

    @Test
    @Disabled
    @DisplayName("Проверяем что ракета запустилась")
    void rocketShouldRun() throws LimitFuelException, NotEnoughFuelException {
        Rocket rocket = new Rocket(100_000, 100_000, 100_000);
        assertDoesNotThrow( () -> rocket.run());
    }

    @Test
    @DisplayName("Проверяем ракету из парамметров файла")
    void rocketShouldWorkParametersFile() {
        URL resource = getClass().getClassLoader().getResource("rocket_data.csv");
        CSVReader csvReader;
        try {
            csvReader = new CSVReader(new FileReader(new File(resource.toURI())));
            String[] linesData;
            int i = 1;
            while ((linesData = csvReader.readNext()) != null) {
                String[] str = linesData[0].split(";");
                if (str[0].equals(String.valueOf(i))) {
                    i++;
                    Rocket rocket = new Rocket(Double.parseDouble(str[1]), Double.parseDouble(str[2]), Double.parseDouble(str[3]));
                    if (Boolean.valueOf(str[4]).equals(true)) {
                        assertDoesNotThrow(() -> rocket.run());
                    } else if (Boolean.valueOf(str[4]).equals(false)) {
                        assertThrows(Exception.class, () -> rocket.run());
                    }
                }
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
