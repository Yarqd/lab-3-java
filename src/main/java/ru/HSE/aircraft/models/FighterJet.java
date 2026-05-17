package ru.HSE.aircraft.models;

import ru.HSE.aircraft.EngineType;

import java.util.Objects;

public class FighterJet extends Airplane {
    private FighterClass fighterClass;

    public FighterJet() {
        this("Unknown fighter jet", 2020, EngineType.TURBOJET, 1, 2000, FighterClass.MULTIROLE);
    }

    public FighterJet(String model, int productionYear, int crewCount, int maxFlightRangeKm,
                      FighterClass fighterClass) {
        this(model, productionYear, EngineType.TURBOJET, crewCount, maxFlightRangeKm, fighterClass);
    }

    public FighterJet(String model, int productionYear, EngineType engineType, int crewCount,
                      int maxFlightRangeKm, FighterClass fighterClass) {
        super(model, productionYear, engineType, crewCount, 0, maxFlightRangeKm);
        setFighterClass(fighterClass);
    }

    public FighterClass getFighterClass() {
        return fighterClass;
    }

    public void setFighterClass(FighterClass fighterClass) {
        this.fighterClass = Objects.requireNonNull(fighterClass, "Fighter class must not be null");
    }

    @Override
    public String getShortInfo() {
        return super.getShortInfo() + ", " + fighterClass.getDisplayName();
    }

    @Override
    public String toString() {
        return "FighterJet{"
                + "model='" + getModel() + '\''
                + ", productionYear=" + getProductionYear()
                + ", engineType=" + getEngineType()
                + ", crewCount=" + getCrewCount()
                + ", maxFlightRangeKm=" + getMaxFlightRangeKm()
                + ", fighterClass=" + fighterClass
                + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        FighterJet that = (FighterJet) obj;
        return fighterClass == that.fighterClass;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), fighterClass);
    }
}
