package persons;

public enum Department {
    KITCHEN("Kitchen"),
    DINING("Dining"),
    LINEN_PORTER("Linen Porter"),
    ROOM_ATENDANT("Room Atentant"),
    HOUSEKEEPING("Housekeeping"),
    RECEPTION("Reception");

    private final String prettyName;

    Department(String prettyName) {
        this.prettyName = prettyName;
    }
}
