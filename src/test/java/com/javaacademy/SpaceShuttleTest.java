package com.javaacademy;

import com.javaacademy.details.Capsule;
import com.javaacademy.details.Rocket;
import com.javaacademy.exceptions.CosmonautIsNotReadyException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class SpaceShuttleTest {
    @InjectMocks
    SpaceShuttle spaceShuttle;
    @Mock
    Capsule capsule;
    @Mock
    Rocket rocket;
    @Mock
    Cosmonaut cosmonaut;

    @Test
    @DisplayName("Проверяем наличие Exception если Космонавт не здоров")
    void runShouldThrowCosmonautIsNotReadyException() {
        Mockito.when(capsule.getCosmonaut()).thenReturn(cosmonaut);
        Mockito.when(cosmonaut.isHealthy()).thenReturn(false);
        assertThrows(CosmonautIsNotReadyException.class, () -> spaceShuttle.run(), "Отсутствует Exception");
    }

    @Test
    @DisplayName("Проверяем отсутствие ошибок, если все в норме")
    void runShouldWork() {
        Mockito.when(capsule.getCosmonaut()).thenReturn(cosmonaut);
        Mockito.when(cosmonaut.isHealthy()).thenReturn(true);
        assertDoesNotThrow(() -> spaceShuttle.run());
    }

}