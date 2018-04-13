import org.junit.Before;
import org.junit.Test;
import persons.Guest;
import persons.PersonType;
import rooms.DiningRoom;
import rooms.Type;
import rooms.chargeable.Bedroom;
import rooms.chargeable.ConferenceRoom;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class HotelTest {
    private Hotel hotel;

    private Bedroom bedroom00;
    private Bedroom bedroom01;
    private Bedroom bedroom02;

    private ConferenceRoom conference00;
    private DiningRoom dining00;

    private Guest guest00;
    private Guest guest01;
    private Guest guest02;

    @Before
    public void before() {
        hotel = new Hotel("CodeClan Towers");

        bedroom00 = new Bedroom(Type.SINGLE_BEDROOM, 40, 101);
        bedroom01 = new Bedroom(Type.DOUBLE_BEDROOM, 60, 201);
        bedroom02 = new Bedroom(Type.FAMILY_BEDROOM, 75, 301);

        conference00 = new ConferenceRoom(Type.CONFERENCE_ROOM, 40, "Edinburgh Room");
        dining00 = new DiningRoom(Type.DINING_ROOM);

        guest00 = new Guest(PersonType.GUEST, "Jaime Lopez", 29, 2 );
        guest01 = new Guest(PersonType.GUEST, "Sara García", 26, 2);
        guest02 = new Guest(PersonType.GUEST, "Rubén Franco", 31, 5);

        bedroom00.addGuest(guest00);
        dining00.addGuest(guest01);

        hotel.addRoom(bedroom00);
        hotel.addRoom(bedroom01);
        hotel.addRoom(bedroom02);
        hotel.addRoom(conference00);
        hotel.addRoom(dining00);
        
    }


}
