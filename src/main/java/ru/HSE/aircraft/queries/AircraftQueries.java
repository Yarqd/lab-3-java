package ru.HSE.aircraft.queries;

import ru.HSE.aircraft.Aircraft;
import ru.HSE.aircraft.models.Airplane;
import ru.HSE.aircraft.models.FighterClass;
import ru.HSE.aircraft.models.FighterJet;

import java.util.ArrayList;
import java.util.List;

public final class AircraftQueries {
    private AircraftQueries() {
    }

    public static int totalFighterCrewByClass(Aircraft[] aircraft, FighterClass fighterClass) {
        int totalCrew = 0;
        for (Aircraft item : aircraft) {
            if (item instanceof FighterJet fighterJet && fighterJet.getFighterClass() == fighterClass) {
                totalCrew += fighterJet.getCrewCount();
            }
        }
        return totalCrew;
    }

    public static List<Aircraft> aircraftProducedSince(Aircraft[] aircraft, int year) {
        List<Aircraft> result = new ArrayList<>();
        for (Aircraft item : aircraft) {
            if (item.isProducedAfter(year, true)) {
                result.add(item);
            }
        }
        return result;
    }

    public static List<String> airplaneModelsWithMaxRange(Aircraft[] aircraft) {
        int maxRange = 0;
        for (Aircraft item : aircraft) {
            if (item instanceof Airplane airplane && airplane.getMaxFlightRangeKm() > maxRange) {
                maxRange = airplane.getMaxFlightRangeKm();
            }
        }

        List<String> result = new ArrayList<>();
        for (Aircraft item : aircraft) {
            if (item instanceof Airplane airplane && airplane.getMaxFlightRangeKm() == maxRange) {
                result.add(airplane.getModel());
            }
        }
        return result;
    }
}
