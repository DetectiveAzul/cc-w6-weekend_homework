package rooms.chargeable;

import rooms.Type;

public class ConferenceRoom extends ChargeableRoom {
    private String name;

    public ConferenceRoom(Type type, double rate, String name) {
        super(type, rate);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
