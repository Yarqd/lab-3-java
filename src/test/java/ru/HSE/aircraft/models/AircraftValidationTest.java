package ru.HSE.aircraft.models;

import org.junit.jupiter.api.Test;
import ru.HSE.aircraft.EngineType;

import static org.junit.jupiter.api.Assertions.assertThrows;

class AircraftValidationTest {
    @Test
    void airplaneRejectsBlankModel() {
        assertThrows(IllegalArgumentException.class,
                () -> new Airplane(" ", 2022, EngineType.TURBOFAN, 2, 180, 6000));
    }

    @Test
    void helicopterRejectsInvalidRotorBladeCount() {
        assertThrows(IllegalArgumentException.class,
                () -> new Helicopter("Broken helicopter", 2022, EngineType.TURBOPROP, 1, 0));
    }
}
