package persons;

public class Guest extends Person {
    private int daysBooked;

    public Guest(PersonType personType, String name, int age, int daysBooked) {
        super(personType, name, age);
        this.daysBooked = daysBooked;
    }

    public int getDaysBooked() {
        return daysBooked;
    }

    public void setDaysBooked(int daysBooked) {
        this.daysBooked = daysBooked;
    }
}
