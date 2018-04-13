import org.junit.Before;
import org.junit.Test;
import persons.Guest;
import persons.PersonType;

import static org.junit.Assert.assertEquals;

public class GuestTest {
    private Guest guest00;
    private Guest guest01;
    private Guest guest02;

    @Before
    public void before() {
        guest00 = new Guest(PersonType.GUEST, "Jaime Lopez", 29, 2 );
        guest01 = new Guest(PersonType.GUEST, "Sara García", 26, 2);
        guest02 = new Guest(PersonType.GUEST, "Rubén Franco", 31, 5);
    }

    @Test
    public void hasType() {
        assertEquals("Guest", guest00.getType());
    }

    @Test
    public void hasName() {
        assertEquals("Sara García", guest01.getName());
    }

    @Test
    public void hasAge() {
        assertEquals(31, guest02.getAge());
    }

    @Test
    public void hasDaysBooked() {
        assertEquals(2, guest00.getDaysBooked());
    }
}
