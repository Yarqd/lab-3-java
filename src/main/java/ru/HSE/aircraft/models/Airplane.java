package ru.HSE.aircraft.models;

import ru.HSE.aircraft.Aircraft;
import ru.HSE.aircraft.EngineType;

import java.util.Objects;

public class Airplane extends Aircraft {
    private int passengerCount;
    private int maxFlightRangeKm;

    public Airplane() {
        this("Unknown airplane", 2020, EngineType.TURBOFAN, 2, 100, 1000);
    }

    public Airplane(String model, int productionYear, int passengerCount, int maxFlightRangeKm) {
        this(model, productionYear, EngineType.TURBOFAN, 2, passengerCount, maxFlightRangeKm);
    }

    public Airplane(String model, int productionYear, EngineType engineType, int crewCount,
                    int passengerCount, int maxFlightRangeKm) {
        super(model, productionYear, engineType, crewCount);
        setPassengerCount(passengerCount);
        setMaxFlightRangeKm(maxFlightRangeKm);
    }

    public int getPassengerCount() {
        return passengerCount;
    }

    public void setPassengerCount(int passengerCount) {
        if (passengerCount < 0) {
            throw new IllegalArgumentException("Passenger count must be non-negative");
        }
        this.passengerCount = passengerCount;
    }

    public int getMaxFlightRangeKm() {
        return maxFlightRangeKm;
    }

    public void setMaxFlightRangeKm(int maxFlightRangeKm) {
        if (maxFlightRangeKm <= 0) {
            throw new IllegalArgumentException("Maximum flight range must be positive");
        }
        this.maxFlightRangeKm = maxFlightRangeKm;
    }

    @Override
    public String getShortInfo() {
        return super.getShortInfo() + ", range " + maxFlightRangeKm + " km";
    }

    @Override
    public String toString() {
        return "Airplane{"
                + "model='" + getModel() + '\''
                + ", productionYear=" + getProductionYear()
                + ", engineType=" + getEngineType()
                + ", crewCount=" + getCrewCount()
                + ", passengerCount=" + passengerCount
                + ", maxFlightRangeKm=" + maxFlightRangeKm
                + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        Airplane airplane = (Airplane) obj;
        return passengerCount == airplane.passengerCount
                && maxFlightRangeKm == airplane.maxFlightRangeKm;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), passengerCount, maxFlightRangeKm);
    }
}
