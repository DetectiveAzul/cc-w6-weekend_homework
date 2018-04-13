package rooms;

public enum Available {
    AVAILABLE("Available",true),
    NOT_AVAILABLE("Not available",false);

    private final String prettyName;
    private final boolean isAvailable;

    Available(String prettyName, boolean isAvailable) {
        this.prettyName = prettyName;
        this.isAvailable = isAvailable;
    }

    public String getPrettyName() {
        return prettyName;
    }

    public boolean isAvailable() {
        return isAvailable;
    }
}
