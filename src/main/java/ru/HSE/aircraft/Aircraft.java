package ru.HSE.aircraft;

import java.time.Year;
import java.util.Objects;

public class Aircraft implements Inspectable {
    private static final int FIRST_POWERED_FLIGHT_YEAR = 1903;
    private static int createdCount;

    private int inventoryNumber;
    private String model;
    private int productionYear;
    private EngineType engineType;
    private int crewCount;

    {
        inventoryNumber = ++createdCount;
    }

    public Aircraft() {
        this("Unknown aircraft", Year.now().getValue(), EngineType.TURBOFAN, 1);
    }

    public Aircraft(String model, int productionYear) {
        this(model, productionYear, EngineType.TURBOFAN, 1);
    }

    public Aircraft(String model, int productionYear, EngineType engineType, int crewCount) {
        setModel(model);
        setProductionYear(productionYear);
        setEngineType(engineType);
        setCrewCount(crewCount);
    }

    public int getInventoryNumber() {
        return inventoryNumber;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        if (model == null || model.isBlank()) {
            throw new IllegalArgumentException("Model must not be blank");
        }
        this.model = model;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(int productionYear) {
        int currentYear = Year.now().getValue();
        if (productionYear < FIRST_POWERED_FLIGHT_YEAR || productionYear > currentYear) {
            throw new IllegalArgumentException("Production year must be between "
                    + FIRST_POWERED_FLIGHT_YEAR + " and " + currentYear);
        }
        this.productionYear = productionYear;
    }

    public EngineType getEngineType() {
        return engineType;
    }

    public void setEngineType(EngineType engineType) {
        this.engineType = Objects.requireNonNull(engineType, "Engine type must not be null");
    }

    public int getCrewCount() {
        return crewCount;
    }

    public void setCrewCount(int crewCount) {
        if (crewCount < 0) {
            throw new IllegalArgumentException("Crew count must be non-negative");
        }
        this.crewCount = crewCount;
    }

    public boolean isProducedAfter(int year) {
        return isProducedAfter(year, false);
    }

    public boolean isProducedAfter(int year, boolean inclusive) {
        return inclusive ? productionYear >= year : productionYear > year;
    }

    @Override
    public String getShortInfo() {
        return model + " (" + productionYear + ")";
    }

    @Override
    public String toString() {
        return "Aircraft{"
                + "inventoryNumber=" + inventoryNumber
                + ", model='" + model + '\''
                + ", productionYear=" + productionYear
                + ", engineType=" + engineType
                + ", crewCount=" + crewCount
                + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Aircraft aircraft = (Aircraft) obj;
        return productionYear == aircraft.productionYear
                && crewCount == aircraft.crewCount
                && Objects.equals(model, aircraft.model)
                && engineType == aircraft.engineType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, productionYear, engineType, crewCount);
    }
}
