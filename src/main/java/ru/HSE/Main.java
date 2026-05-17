package ru.HSE;

import ru.HSE.aircraft.Aircraft;
import ru.HSE.aircraft.EngineType;
import ru.HSE.aircraft.Inspectable;
import ru.HSE.aircraft.models.Airplane;
import ru.HSE.aircraft.models.FighterClass;
import ru.HSE.aircraft.models.FighterJet;
import ru.HSE.aircraft.models.Helicopter;
import ru.HSE.aircraft.queries.AircraftQueries;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Aircraft[] fleet = createFleet();

        System.out.println("Fleet:");
        for (Aircraft aircraft : fleet) {
            System.out.println(aircraft);
        }

        FighterClass requestedClass = FighterClass.MULTIROLE;
        int totalCrew = AircraftQueries.totalFighterCrewByClass(fleet, requestedClass);
        System.out.println();
        System.out.println("Total fighter crew for class " + requestedClass + ": " + totalCrew);

        System.out.println();
        System.out.println("Aircraft produced since 2020:");
        for (Aircraft aircraft : AircraftQueries.aircraftProducedSince(fleet, 2020)) {
            System.out.println(aircraft.getShortInfo());
        }

        System.out.println();
        System.out.println("Airplane model(s) with maximum flight range:");
        for (String model : AircraftQueries.airplaneModelsWithMaxRange(fleet)) {
            System.out.println(model);
        }

        List<Inspectable> inspectableObjects = List.of(fleet[0], fleet[4], fleet[8], fleet[12]);
        System.out.println();
        System.out.println("Objects stored through the Inspectable interface:");
        for (Inspectable inspectable : inspectableObjects) {
            System.out.println(inspectable.getShortInfo());
        }
    }

    private static Aircraft[] createFleet() {
        return new Aircraft[]{
                new Airplane("Airbus A320neo", 2021, EngineType.TURBOFAN, 2, 194, 6300),
                new Airplane("Boeing 737 MAX 8", 2019, EngineType.TURBOFAN, 2, 210, 6570),
                new Airplane("Boeing 787-9", 2022, EngineType.TURBOFAN, 4, 296, 14140),
                new Airplane("Airbus A350-900", 2020, EngineType.TURBOFAN, 4, 325, 15000),
                new Airplane("Embraer E195-E2", 2023, EngineType.TURBOFAN, 2, 146, 4815),
                new Airplane("Cessna 172", 2016, EngineType.PISTON, 1, 3, 1289),
                new Helicopter("Mil Mi-8AMT", 2018, EngineType.TURBOPROP, 3, 5),
                new Helicopter("Robinson R44", 2020, EngineType.PISTON, 1, 2),
                new Helicopter("Airbus H145", 2022, EngineType.TURBOPROP, 2, 4),
                new Helicopter("Bell 407GXi", 2021, EngineType.TURBOPROP, 1, 4),
                new Helicopter("Sikorsky S-92", 2017, EngineType.TURBOPROP, 2, 4),
                new Helicopter("Kamov Ka-32", 2019, EngineType.TURBOPROP, 2, 6),
                new FighterJet("Su-57", 2021, EngineType.TURBOJET, 1, 3500, FighterClass.MULTIROLE),
                new FighterJet("MiG-31BM", 2014, EngineType.TURBOJET, 2, 3300, FighterClass.INTERCEPTOR),
                new FighterJet("F/A-18E Super Hornet", 2020, EngineType.TURBOJET, 1, 2346, FighterClass.CARRIER_BASED),
                new FighterJet("F-35A Lightning II", 2022, EngineType.TURBOJET, 1, 2200, FighterClass.MULTIROLE),
                new FighterJet("Eurofighter Typhoon", 2018, EngineType.TURBOJET, 1, 2900, FighterClass.FRONTLINE),
                new FighterJet("Dassault Rafale M", 2023, EngineType.TURBOJET, 1, 3700, FighterClass.CARRIER_BASED),
                new FighterJet("F-16V Viper", 2021, EngineType.TURBOJET, 1, 4220, FighterClass.TACTICAL),
                new FighterJet("JAS 39 Gripen E", 2024, EngineType.TURBOJET, 1, 4000, FighterClass.MULTIROLE)
        };
    }
}
