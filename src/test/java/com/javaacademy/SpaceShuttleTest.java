package com.javaacademy;

import com.javaacademy.details.Capsule;
import com.javaacademy.details.Rocket;
import com.javaacademy.exceptions.CosmonautIsNotReadyException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class SpaceShuttleTest {

    @Mock
    private Capsule capsule;

    @Mock
    private Rocket rocket;

    @Mock
    private Cosmonaut cosmonaut;

    @Test
    @DisplayName("Проверка метода, если космонавт здоров")
    public void testShuttleFly() throws CosmonautIsNotReadyException {
        Mockito.when(capsule.getCosmonaut()).thenReturn(cosmonaut);
        SpaceShuttle spaceShuttle = new SpaceShuttle("Test", rocket, capsule);
        Assertions.assertDoesNotThrow(spaceShuttle::run);
    }

    @Test
    @DisplayName("Ожидание ошибки, если космонавт болен")
    public void testExceptionCosmonaut() throws CosmonautIsNotReadyException {
        Mockito.when(capsule.getCosmonaut()).thenThrow(CosmonautIsNotReadyException.class);
        SpaceShuttle spaceShuttle = new SpaceShuttle("Test", rocket, capsule);
        Assertions.assertThrows(CosmonautIsNotReadyException.class, spaceShuttle::run);
    }
}
