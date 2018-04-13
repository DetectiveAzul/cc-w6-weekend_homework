import org.junit.Before;
import org.junit.Test;
import persons.Department;
import persons.Employee;
import persons.PersonType;

import static org.junit.Assert.assertEquals;

public class EmployeeTest {
    private Employee employee00;
    private Employee employee01;

    @Before
    public void before() {
        employee00 = new Employee(PersonType.PARTTIME_WORKER, "Jaime López", 29, Department.DINING, 24000);
        employee01 = new Employee(PersonType.FULLTIME_WORKER, "Sara García", 26, Department.LINEN_PORTER, 28000);
    }

    @Test
    public void canChangeDepartment() {
        employee00.setDepartment(Department.HOUSEKEEPING);
        assertEquals(Department.HOUSEKEEPING, employee00.getDepartment());
    }

    @Test
    public void canChangeSalary() {
        employee01.setSalary(40000);
        assertEquals(40000,employee01.getSalary(), 0);
    }
}
