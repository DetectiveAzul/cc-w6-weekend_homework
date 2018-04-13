package rooms.chargeable;

import rooms.Room;
import rooms.Type;

public abstract class ChargeableRoom extends Room {
    private double rate;

    public ChargeableRoom(Type type, double rate) {
        super(type);
        this.rate = rate;
    }

    public double getRate() {
        return rate;
    }
}
