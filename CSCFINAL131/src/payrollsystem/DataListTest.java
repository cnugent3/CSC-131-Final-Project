package payrollsystem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DataListTest {

    private DataList dataList;

    @BeforeEach
    public void setUp() {
        dataList = new DataList();
    }

    @Test
    public void testAuth_validCredentials_returnsEmployee() {
        Employee emp = dataList.auth(7999, "Colin1!");
        assertNotNull(emp, "Valid credentials should return an Employee object.");
        assertEquals("Colin", emp.getFirstName());
        assertEquals("Nugent", emp.getLastName());
    }

    @Test
    public void testAuth_invalidCredentials_returnsNull() {
        Employee empWrongId = dataList.auth(9999, "Colin1!");
        assertNull(empWrongId, "Invalid userID should return null.");

        Employee empWrongPassword = dataList.auth(7999, "WrongPassword!");
        assertNull(empWrongPassword, "Invalid password should return null.");
    }

    @Test
    public void testGetEmployees_returnsCorrectList() {
        List<Employee> employees = dataList.getEmployees();
        assertNotNull(employees, "getEmployees should not return null.");
        assertEquals(7, employees.size(), "There should be 7 employees in the list.");

        Employee first = employees.get(0);
        assertEquals("Colin", first.getFirstName());
        assertEquals(7999, first.getId());
    }
}