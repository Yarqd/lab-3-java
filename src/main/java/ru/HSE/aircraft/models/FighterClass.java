package ru.HSE.aircraft.models;

public enum FighterClass {
    FRONTLINE("frontline"),
    INTERCEPTOR("interceptor"),
    CARRIER_BASED("carrier-based"),
    MULTIROLE("multirole"),
    TACTICAL("tactical");

    private final String displayName;

    FighterClass(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
