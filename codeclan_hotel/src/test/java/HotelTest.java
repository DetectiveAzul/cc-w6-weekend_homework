import org.junit.Before;
import org.junit.Test;
import persons.Department;
import persons.Employee;
import persons.Guest;
import persons.PersonType;
import rooms.DiningRoom;
import rooms.Room;
import rooms.Type;
import rooms.chargeable.Bedroom;
import rooms.chargeable.ConferenceRoom;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;


public class HotelTest {
    private Hotel hotel;

    private Bedroom bedroom00;
    private Bedroom bedroom01;
    private Bedroom bedroom02;

    private ConferenceRoom conference00;
    private ConferenceRoom conference01;
    private DiningRoom dining00;

    private Guest guest00;
    private Guest guest01;
    private Guest guest02;

    private Employee employee00;
    private Employee employee01;
    private Employee employee02;
    private Employee employee03;


    @Before
    public void before() {
        hotel = new Hotel("CodeClan Towers");

        bedroom00 = new Bedroom(Type.SINGLE_BEDROOM, 40, 101);
        bedroom01 = new Bedroom(Type.DOUBLE_BEDROOM, 60, 201);
        bedroom02 = new Bedroom(Type.FAMILY_BEDROOM, 75, 301);

        conference00 = new ConferenceRoom(Type.CONFERENCE_ROOM, 40, "Edinburgh Room");
        conference01 = new ConferenceRoom(Type.CONFERENCE_ROOM, 40, "French Room");
        dining00 = new DiningRoom(Type.DINING_ROOM);

        guest00 = new Guest(PersonType.GUEST, "Jaime Lopez", 29, 2 );
        guest01 = new Guest(PersonType.GUEST, "Sara García", 26, 2);
        guest02 = new Guest(PersonType.GUEST, "Rubén Franco", 31, 5);

        employee00 = new Employee(PersonType.PARTTIME_WORKER, "Jaime López", 29, Department.DINING, 24000);
        employee01 = new Employee(PersonType.PARTTIME_WORKER, "Javier Martínez", 32, Department.DINING, 24000);
        employee02 = new Employee(PersonType.FULLTIME_WORKER, "Sara García", 26, Department.LINEN_PORTER, 28000);
        employee03 = new Employee(PersonType.FULLTIME_WORKER, "María García", 26, Department.LINEN_PORTER, 28000);

        hotel.addEmployee(employee00);
        hotel.addEmployee(employee01);
        hotel.addEmployee(employee02);

        bedroom00.addGuest(guest00);
        dining00.addGuest(guest01);

        hotel.addRoom(bedroom00);
        hotel.addRoom(bedroom01);
        hotel.addRoom(bedroom02);
        hotel.addRoom(conference00);
        hotel.addRoom(dining00);


    }

    @Test
    public void canGetName() {
        assertEquals("CodeClan Towers", hotel.getName());
    }
    @Test
    public void canGetRoomsAndNumberOfRooms() {
        ArrayList<Room> result = hotel.getRooms();
        assertEquals(5, hotel.getSize());
    }

    @Test
    public void canRemoveRoom() {
        hotel.removeRoom(0);
        hotel.removeRoom(bedroom01);
        assertEquals(3, hotel.getSize());
    }

    @Test
    public void canGetRoom() {
        assertEquals(bedroom00.getClass(),hotel.getRoom(1).getClass());
    }

    @Test
    public void canGetTotalNumberOfGuest() {
        assertEquals(2, hotel.getTotalNumberOfGuest());
    }

    @Test
    public void canGetGuestFromARoom() {
        ArrayList<Guest> result = hotel.getRoomGuests(hotel.getRoom(0));
        assertEquals(1, result.size());
    }

    @Test
    public void canCheckInGuest()
    {
        hotel.checkInGuest(guest02, bedroom02);
        assertEquals(1, hotel.getRoom(2).getNumberOfGuests());
    }

    @Test
    public void canCheckOutGuest() {
        hotel.checkOutGuest(guest00);
        hotel.checkOutGuest(guest01);
        assertEquals(0, hotel.getTotalNumberOfGuest());
    }

    @Test
    public void canCountRoomsByType() {
        assertEquals(1, hotel.getNumberOfRooms(Type.DINING_ROOM));
        assertEquals(1, hotel.getNumberOfRooms(Type.SINGLE_BEDROOM));
    }

    @Test
    public void canCountVacantRooms() {
        assertEquals(0, hotel.getNumberOfVacantRooms(Type.SINGLE_BEDROOM));
    }

    @Test
    public void canSetTimeForGuests() {
        hotel.checkOutGuest(guest00);
        hotel.checkInGuest(guest00, bedroom02);
        hotel.checkInGuest(guest02, bedroom02);
        hotel.setTimeForWholeRoom(10, bedroom02);
        assertEquals(10, guest00.getDaysBooked());
        assertEquals(10, guest02.getDaysBooked());
    }

    @Test
    public void canCheckOutRoom() {
        hotel.checkOutRoom(bedroom00);
        assertEquals(0, hotel.getRoom(0).getNumberOfGuests());
    }

    @Test
    public void canRemoveEmployee() {
        hotel.removeEmployee(employee02);
        ArrayList<Employee> result = hotel.getEmployeeList();
        assertEquals(2, result.size());
    }

    @Test
    public void canGetEmployeeListSize() {
        assertEquals(3, hotel.getEmployeeSize());
    }

    @Test
    public void canGetEmployee() {
        assertEquals(employee02.getClass(), hotel.getEmployee(0).getClass());
    }

    @Test
    public void canUpdateAndCheckEmployeeNumber() {
        assertEquals(1, hotel.getNumberEmployeeType(Department.LINEN_PORTER));
        hotel.addEmployee(employee03);
        assertEquals(2, hotel.getNumberEmployeeType(Department.LINEN_PORTER));
        hotel.removeEmployee(employee03);
        assertEquals(1, hotel.getNumberEmployeeType(Department.LINEN_PORTER));
    }

}
