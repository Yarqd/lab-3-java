package ru.HSE.aircraft.models;

import ru.HSE.aircraft.Aircraft;
import ru.HSE.aircraft.EngineType;

import java.util.Objects;

public class Helicopter extends Aircraft {
    private int rotorBladeCount;

    public Helicopter() {
        this("Unknown helicopter", 2020, EngineType.TURBOPROP, 1, 4);
    }

    public Helicopter(String model, int productionYear, int rotorBladeCount) {
        this(model, productionYear, EngineType.TURBOPROP, 1, rotorBladeCount);
    }

    public Helicopter(String model, int productionYear, EngineType engineType, int crewCount,
                      int rotorBladeCount) {
        super(model, productionYear, engineType, crewCount);
        setRotorBladeCount(rotorBladeCount);
    }

    public int getRotorBladeCount() {
        return rotorBladeCount;
    }

    public void setRotorBladeCount(int rotorBladeCount) {
        if (rotorBladeCount <= 0) {
            throw new IllegalArgumentException("Rotor blade count must be positive");
        }
        this.rotorBladeCount = rotorBladeCount;
    }

    @Override
    public String getShortInfo() {
        return super.getShortInfo() + ", blades " + rotorBladeCount;
    }

    @Override
    public String toString() {
        return "Helicopter{"
                + "model='" + getModel() + '\''
                + ", productionYear=" + getProductionYear()
                + ", engineType=" + getEngineType()
                + ", crewCount=" + getCrewCount()
                + ", rotorBladeCount=" + rotorBladeCount
                + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        Helicopter that = (Helicopter) obj;
        return rotorBladeCount == that.rotorBladeCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), rotorBladeCount);
    }
}
