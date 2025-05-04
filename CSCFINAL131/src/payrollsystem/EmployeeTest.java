package payrollsystem;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class EmployeeTest {

    private Employee emp;

    @Before
    public void setUp() {
        emp = new Employee("Test", "User", 123, 40f, 5f, 20f, "pass123", 0f, false);
    }

    @Test
    public void testAuthSuccess() {
        assertTrue(emp.auth(123, "pass123"));
    }

    @Test
    public void testAuthFailWrongPassword() {
        assertFalse(emp.auth(123, "wrong"));
    }

    @Test
    public void testAuthFailWrongID() {
        assertFalse(emp.auth(999, "pass123"));
    }

    @Test
    public void testCalculatePay() {
        float expectedGross = (40f * 20f) + (5f * 30f); // regular + overtime
        float expectedNet = expectedGross - (expectedGross * Employee.taxRate);
        float actual = emp.calculatePay(40f, 5f, 20f);
        assertEquals(expectedNet, actual, 0.001);
    }

    @Test
    public void testUpdateCheckAndGetCheck() {
        emp.setHoursWorked(35f);
        emp.setOvertimeWorked(2f);
        emp.setHourlyWage(25f);
        float expected = emp.calculatePay(35f, 2f, 25f); // same logic as updateCheck()
        float check = emp.getCheck();
        assertEquals(expected, check, 0.001);
    }

    @Test
    public void testManagerStatus() {
        assertFalse(emp.managerStatus());

        Employee mgr = new Employee("New", "Manager", 456, 40f, 0f, 30f, "admin", 0f, true);
        assertTrue(mgr.managerStatus());
    }

    @Test
    public void testGettersAndSetters() {
        emp.setFirstName("Get");
        emp.setLastName("Set");
        emp.setId(999);
        emp.setHoursWorked(20f);
        emp.setOvertimeWorked(1f);
        emp.setHourlyWage(22f);
        emp.setPassword("newpass");

        assertEquals("Get", emp.getFirstName());
        assertEquals("Set", emp.getLastName());
        assertEquals(999, emp.getId());
        assertEquals(20f, emp.getHoursWorked(), 0.001);
        assertEquals(1f, emp.getOvertimeWorked(), 0.001);
        assertEquals(22f, emp.getHourlyWage(), 0.001);
        assertEquals("newpass", emp.getPassword());
    }
}