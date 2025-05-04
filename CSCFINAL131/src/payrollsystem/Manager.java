package payrollsystem;

import java.util.List;
import java.util.Scanner;

public class Manager {
	private List<Employee> employees;
	
	// Constructor that will accept the list of employees
	public Manager(List<Employee> employees) {
		this.employees = employees;
	}

    public void viewAllEmployees() {
    	String headerFormat = "%-12s %-12s %-6s %-14s %-17s %-13s %-10s%n";
    	String rowFormat = "%-12s %-12s %-6d %-14.2f %-17.2f $%-13.2f %-10s%n";
    	
    	// Print the header
        System.out.printf(
        	headerFormat,
        	"First Name", "Last Name", "ID", "Hours Worked",
        	"Overtime Worked", "Hourly Wage", "Is Manager"
        );
        System.out.println("------------------------------------------------------------------------------------------");
        
        // Loop through and print each employee's data
        for (Employee e : employees) {
        	System.out.printf(
        		rowFormat,
        		e.getFirstName(),
        		e.getLastName(),
        		e.getId(),
        		e.getHoursWorked(),
        		e.getOvertimeWorked(),
        		e.getHourlyWage(),
        		e.managerStatus() ? "Yes" : "No"
        	);
        }
        System.out.println();
    }

    public void editEmployeeHours(Scanner scanner) {
    	System.out.println();
    	System.out.print("Enter employee ID: ");
    	int id = scanner.nextInt();
    	
    	// Find the employee by ID
    	Employee selectedEmployee = null;
    	for (Employee e : employees) {
    		if (e.getId() == id) {
    			selectedEmployee = e;
    			break;
    		}
    	}
    	
    	if (selectedEmployee == null) {
    		System.out.println("Invalid employee ID.");
    		return;
    	}
    	
    	// Display current hours
    	System.out.println("Employee: " + selectedEmployee.getFirstName() + " " + selectedEmployee.getLastName());
    	System.out.printf("Current hours worked: %.2f%n", selectedEmployee.getHoursWorked());
    	
    	// Prompt for new hours
    	System.out.print("Enter new hours worked (0-80 hours): ");
    	float newHours = scanner.nextFloat();
    	if (newHours < 0 || newHours > 80) {
    		System.out.println("Invalid hours.");
    		return;
    	}
    	
    	// Update hours
    	selectedEmployee.setHoursWorked(newHours);
    	System.out.println("Hours updated successfully. New hours: " + newHours);
    	System.out.println();
    }
}