package rooms.chargeable;

import rooms.Type;
import rooms.chargeable.ChargeableRoom;

public class Bedroom extends ChargeableRoom {
    private int roomNumber;

    public Bedroom(Type type, double rate, int roomNumber) {
        super(type, rate);
        this.roomNumber = roomNumber;
    }

    public int getRoomNumber() {
        return roomNumber;
    }
}
