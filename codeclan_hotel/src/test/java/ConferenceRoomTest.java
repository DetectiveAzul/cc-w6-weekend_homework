import org.junit.Before;
import org.junit.Test;
import rooms.Type;
import rooms.chargeable.ConferenceRoom;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ConferenceRoomTest {
    private ConferenceRoom conference00;
    private ConferenceRoom conference01;
    private ConferenceRoom conference02;

    @Before
    public void before() {
        conference00 = new ConferenceRoom(Type.CONFERENCE_ROOM, 40, "Edinburgh Room");
        conference01 = new ConferenceRoom(Type.CONFERENCE_ROOM, 60, "French Room");
        conference02 = new ConferenceRoom(Type.CONFERENCE_ROOM, 75, "Spanish Room");
    }
    @Test
    public void hasType() {
        assertEquals("Conference Room", conference00.getTypeName());
    }
    @Test
    public void hasSize() {
        assertEquals(50, conference01.getRoomSize());
    }
    @Test
    public void isChargeable() {
        assertTrue(conference02.isChargeable());
    }
    @Test
    public void hasRate() {
        assertEquals(40, conference00.getRate(),0);
    }
    @Test
    public void hasName() {
        assertEquals("French Room", conference01.getName());
    }
}
