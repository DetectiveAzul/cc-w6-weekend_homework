package persons;

public abstract class Person {
    private PersonType personType;
    private String name;
    private int age;

    public Person(PersonType personType, String name, int age) {
        this.personType = personType;
        this.name = name;
        this.age = age;
    }

    private PersonType getPersonType() {
        return personType;
    }

    public String getType() {
        return getPersonType().getPrettyName();
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
