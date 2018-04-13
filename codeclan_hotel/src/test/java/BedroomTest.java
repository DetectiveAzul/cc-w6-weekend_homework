import org.junit.Before;
import org.junit.Test;
import persons.Guest;
import persons.PersonType;
import rooms.Type;
import rooms.chargeable.Bedroom;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BedroomTest {
    private Bedroom bedroom00;
    private Bedroom bedroom01;
    private Bedroom bedroom02;

    private Guest guest00;
    private Guest guest01;
    private Guest guest02;

    @Before
    public void before() {
        bedroom00 = new Bedroom(Type.SINGLE_BEDROOM, 40, 101);
        bedroom01 = new Bedroom(Type.DOUBLE_BEDROOM, 60, 201);
        bedroom02 = new Bedroom(Type.FAMILY_BEDROOM, 75, 301);

        guest00 = new Guest(PersonType.GUEST, "Jaime Lopez", 29, 2 );
        guest01 = new Guest(PersonType.GUEST, "Sara García", 26, 2);
        guest02 = new Guest(PersonType.GUEST, "Rubén Franco", 31, 5);

    }
    @Test
    public void hasType() {
        assertEquals("Single Bedroom", bedroom00.getTypeName());
    }
    @Test
    public void hasSize() {
        assertEquals(2, bedroom01.getRoomSize());
    }
    @Test
    public void isChargeable() {
        assertTrue(bedroom02.isChargeable());
    }
    @Test
    public void hasRate() {
        assertEquals(40, bedroom00.getRate(),0);
    }
    @Test
    public void hasNumber() {
        assertEquals(201, bedroom01.getRoomNumber());
    }
    @Test
    public void checkAvailability() {
        assertTrue(bedroom00.isAvailable());
    }
    @Test
    public void isFull() {
        assertFalse(bedroom00.isFull());
    }

    @Test
    public void canAdd() {
        bedroom00.addGuest(guest00);
        assertEquals(1, bedroom00.getNumberOfGuests());
        assertTrue(bedroom00.isFull());
        assertFalse(bedroom00.isAvailable());
    }

    @Test
    public void notOverpopulatingRoom() {
        bedroom00.addGuest(guest00);
        bedroom01.addGuest(guest01);
        assertEquals(1, bedroom00.getNumberOfGuests());
        assertTrue(bedroom00.isFull());
        assertFalse(bedroom00.isAvailable());
    }

    @Test
    public void canRemove() {
        bedroom00.addGuest(guest00);
        assertEquals(1, bedroom00.getNumberOfGuests());
        assertTrue(bedroom00.isFull());
        assertFalse(bedroom00.isAvailable());
        bedroom00.removeGuest(guest00);
        assertEquals(0, bedroom00.getNumberOfGuests());
        assertFalse(bedroom00.isFull());
        assertTrue(bedroom00.isAvailable());
    }

    @Test
    public void notRemovingWrongGuest() {
        bedroom00.addGuest(guest00);
        assertEquals(1, bedroom00.getNumberOfGuests());
        assertTrue(bedroom00.isFull());
        assertFalse(bedroom00.isAvailable());
        bedroom00.removeGuest(guest01);
        assertEquals(1, bedroom00.getNumberOfGuests());
        assertTrue(bedroom00.isFull());
        assertFalse(bedroom00.isAvailable());
    }

    @Test
    public void canClearRoom() {
        bedroom02.addGuest(guest00);
        bedroom02.addGuest(guest01);
        bedroom02.addGuest(guest02);
        assertEquals(3, bedroom02.getNumberOfGuests());
        bedroom02.clearRoom();
        assertEquals(0,bedroom02.getNumberOfGuests());
    }

}
