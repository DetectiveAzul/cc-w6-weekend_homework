import org.junit.Before;
import org.junit.Test;
import rooms.DiningRoom;
import rooms.Type;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

public class DiningRoomTest {
    private DiningRoom dining;

    @Before
    public void before() {
        dining = new DiningRoom(Type.DINING_ROOM);
    }

    @Test
    public void hasType() {
        assertEquals("Dining Room", dining.getTypeName());
    }

    @Test
    public void hasSize() {
        assertEquals(100, dining.getRoomSize());
    }

    @Test
    public void isChargeable() {
        assertFalse(dining.isChargeable());
    }

}
