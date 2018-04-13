package persons;

public class Employee extends Person {
    private Department department;
    private double salary;
    public Employee(PersonType type, String name, int age, Department department, double salary) {
        super(type, name, age);
        this.department = department;
        this.salary = salary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
