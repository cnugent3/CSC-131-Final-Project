package payrollsystem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
public class ManagerTest {

    private List<Employee> employees;
    private Manager manager;

    @BeforeEach
    public void setUp() {
        employees = new ArrayList<>();
        employees.add(new Employee("New", "Employee", 3789, 40.0f, 5, 20.0f, "pass123", 0.0f, false));
        employees.add(new Employee("New", "Manager", 4700, 38f, 2, 22.5f, "admin456", 0.0f, true));
        manager = new Manager(employees);
    }

    @Test
    public void testViewAllEmployees_printsCorrectly() {
        // Redirect output stream
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(out));

        manager.viewAllEmployees();

        String output = out.toString();
        assertTrue(output.contains("New"));
        assertTrue(output.contains("New"));
        assertTrue(output.contains("Hourly Wage"));
        assertTrue(output.contains("$"));  // check formatting

        // Reset System.out
        System.setOut(originalOut);
    }

    @Test
    public void testEditEmployeeHours_validIdAndHours() {
        String simulatedInput = "3789\n45.5\n"; // ID = 1, hours = 45.5
        Scanner scanner = new Scanner(new ByteArrayInputStream(simulatedInput.getBytes()));

        manager.editEmployeeHours(scanner);

        assertEquals(45.5f, employees.get(0).getHoursWorked());
    }

    @Test
    public void testEditEmployeeHours_invalidId() {
        String simulatedInput = "999\n"; // Invalid ID
        Scanner scanner = new Scanner(new ByteArrayInputStream(simulatedInput.getBytes()));

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(out));

        manager.editEmployeeHours(scanner);
        String output = out.toString();

        assertTrue(output.contains("Invalid employee ID"));

        System.setOut(originalOut);
    }

    @Test
    public void testEditEmployeeHours_invalidHours() {
        String simulatedInput = "3789\n100\n"; // Valid ID, invalid hours
        Scanner scanner = new Scanner(new ByteArrayInputStream(simulatedInput.getBytes()));

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(out));

        manager.editEmployeeHours(scanner);
        String output = out.toString();

        assertTrue(output.contains("Invalid hours."));

        assertEquals(40.0f, employees.get(0).getHoursWorked());

        System.setOut(originalOut);
    }
}
