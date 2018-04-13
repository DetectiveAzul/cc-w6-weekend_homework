package rooms;

public enum Type {
    SINGLE_BEDROOM("Single Bedroom", 1, true),
    DOUBLE_BEDROOM("Double Bedroom", 2, true),
    FAMILY_BEDROOM("Family Bedroom", 5, true),
    CONFERENCE_ROOM("Conference Room", 50, true),
    DINING_ROOM("Dining Room", 100, false);

    private final String prettyName;
    private final int capacity;
    private final boolean chargeable;

    Type(String prettyName, int capacity, boolean chargeable) {
        this.prettyName = prettyName;
        this.capacity = capacity;
        this.chargeable = chargeable;
    }

    public String getPrettyName() {
        return prettyName;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean isChargeable() {
        return chargeable;
    }
}
