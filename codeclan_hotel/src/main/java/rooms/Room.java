package rooms;

import persons.Guest;

import java.util.ArrayList;

public abstract class Room {
    private Type type;
    private ArrayList<Guest> guests;

    public Room(Type type){
        this.type = type;
        this.guests = new ArrayList<>();
    }

    private Type getType() {
        return type;
    }

    public String getTypeName() {
        return getType().getPrettyName();
    }

    public boolean isChargeable() {
        return getType().isChargeable();
    }

    //Methods to check guests and check occupancy
    public int getRoomSize() {
        return getType().getCapacity();
    }

    public ArrayList<Guest> getGuests() {
        return guests;
    }

    public int getNumberOfGuests() {
        return getGuests().size();
    }

    public boolean isAvailable() {
        return !(getNumberOfGuests() > 0);
    }

    public boolean isFull() {
        return (getNumberOfGuests() >= getRoomSize());
    }

    public void addGuest(Guest guest) {
        if (!isFull()) this.guests.add(guest);
    }

    public void removeGuest(Guest guest) {
        this.guests.remove(guest);
    }

    public void clearRoom() {
        this.guests.clear();
    }







}
