package ru.HSE.aircraft.queries;

import org.junit.jupiter.api.Test;
import ru.HSE.aircraft.Aircraft;
import ru.HSE.aircraft.EngineType;
import ru.HSE.aircraft.models.Airplane;
import ru.HSE.aircraft.models.FighterClass;
import ru.HSE.aircraft.models.FighterJet;
import ru.HSE.aircraft.models.Helicopter;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AircraftQueriesTest {
    @Test
    void totalFighterCrewByClassSumsOnlyRequestedClass() {
        Aircraft[] fleet = {
                new FighterJet("Su-57", 2021, EngineType.TURBOJET, 1, 3500, FighterClass.MULTIROLE),
                new FighterJet("F-35A", 2022, EngineType.TURBOJET, 1, 2200, FighterClass.MULTIROLE),
                new FighterJet("MiG-31BM", 2014, EngineType.TURBOJET, 2, 3300, FighterClass.INTERCEPTOR),
                new Airplane("Airbus A320neo", 2021, EngineType.TURBOFAN, 2, 194, 6300)
        };

        int totalCrew = AircraftQueries.totalFighterCrewByClass(fleet, FighterClass.MULTIROLE);

        assertEquals(2, totalCrew);
    }

    @Test
    void aircraftProducedSinceIncludesBoundaryYear() {
        Aircraft[] fleet = {
                new Airplane("Cessna 172", 2016, EngineType.PISTON, 1, 3, 1289),
                new Helicopter("Robinson R44", 2020, EngineType.PISTON, 1, 2),
                new FighterJet("Su-57", 2021, EngineType.TURBOJET, 1, 3500, FighterClass.MULTIROLE)
        };

        List<Aircraft> result = AircraftQueries.aircraftProducedSince(fleet, 2020);

        assertEquals(List.of(fleet[1], fleet[2]), result);
    }

    @Test
    void airplaneModelsWithMaxRangeReturnsAllLeaders() {
        Aircraft[] fleet = {
                new Airplane("Short range", 2020, EngineType.TURBOFAN, 2, 100, 1000),
                new Airplane("Long range A", 2021, EngineType.TURBOFAN, 2, 200, 5000),
                new Airplane("Long range B", 2022, EngineType.TURBOFAN, 2, 220, 5000),
                new Helicopter("Airbus H145", 2022, EngineType.TURBOPROP, 2, 4)
        };

        List<String> result = AircraftQueries.airplaneModelsWithMaxRange(fleet);

        assertEquals(List.of("Long range A", "Long range B"), result);
    }
}
