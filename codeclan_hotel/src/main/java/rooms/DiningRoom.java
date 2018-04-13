package rooms;

public class DiningRoom extends Room {

    public DiningRoom(Type type) {
        super(type);
    }

    public boolean isAvailable() {
        return !isFull();
    }
}
