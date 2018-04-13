import persons.Guest;
import rooms.Room;
import rooms.Type;

import java.util.ArrayList;

public class Hotel {
    private String name;
    private ArrayList<Room> rooms;

    public Hotel(String name) {
        this.name = name;
        this.rooms = new ArrayList<>();
    }

    //Basic Hotel methods

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public Room getRoom(int index) {
        return rooms.get(index);
    }

    public void addRoom(Room room) {
        this.rooms.add(room);
    }

    public void removeRoom(Room room) {
        this.rooms.remove(room);
    }

    public void removeRoom(int index) {
        this.rooms.remove(index);
    }

    public int getSize() {
        return rooms.size();
    }

    //Managing guests

    public ArrayList<Guest> getAllGuests() {
        ArrayList<Guest> guests = new ArrayList<>();
        for (Room room:
             rooms) {
            guests.addAll(room.getGuests());
        }
        return guests;
    }

    public int getTotalNumberOfGuest() {
        return getAllGuests().size();
    }

    public ArrayList<Guest> getRoomGuests(Room room) {
        return room.getGuests();
    }

    public void checkInGuest(Guest guest, Room room) {
        room.addGuest(guest);
    }

    public void checkOutGuest(Guest guest) {
        for (Room room:
             this.rooms) {
            room.removeGuest(guest);
        }
    }

    public void checkOutRoom(Room room) {
        room.clearRoom();
    }

    // Searching rooms

    public ArrayList<Room> getAll(Type roomType) {
        ArrayList<Room> allRooms = new ArrayList<>();
        for (Room room:
                this.rooms) {
            if (room.getType() == roomType) allRooms.add(room);
        }
        return allRooms;
    }

    public ArrayList<Room> getAllVacant(Type roomType) {
        ArrayList<Room> vacantRooms = new ArrayList<>();
        for (Room room:
             this.rooms) {
            if ((room.getType() == roomType) && (room.isAvailable())) vacantRooms.add(room);
        }
        return vacantRooms;
    }


    public int getNumberOfRooms(Type roomType) {
        return getAll(roomType).size();
    }

    public int getNumberOfVacantRooms(Type roomType) {
        return getAllVacant(roomType).size();
    }

    // Modifying guest and room time

    public void setTimeForGuest(int daysBooked, Guest guest) {
        guest.setDaysBooked(daysBooked);
    }

    public void setTimeForWholeRoom(int daysBooked, Room room) {
        for (Guest guest:
             room.getGuests()) {
            setTimeForGuest(daysBooked, guest);
        }
    }


}
