package payrollsystem;
import java.util.Scanner;
import org.apache.pdfbox.pdmodel.PDDocument;

public class Main {
 	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DataList data = new DataList();
        
        Employee current = null;
        
        do {
        	 System.out.print("UserID: ");
             int userID = scanner.nextInt();
             scanner.nextLine();
             System.out.print("Password: ");
             String userPassword = scanner.nextLine();
             
             current = data.auth(userID, userPassword);
             //no validation check yet curent == currently logged in
             if (current == null) {
                 System.out.println("Login failed. Do you want to create a new employee with this ID? (yes/no)");
                 String response = scanner.nextLine().trim().toLowerCase();

                 if (response.equals("yes")) {
                     System.out.print("First Name: ");
                     String firstName = scanner.nextLine();

                     System.out.print("Last Name: ");
                     String lastName = scanner.nextLine();

                     System.out.print("Hourly Wage: ");
                     float hourlyWage = scanner.nextFloat();

                     System.out.print("Password: ");
                     scanner.nextLine(); // consume leftover newline
                     String newPassword = scanner.nextLine();

                     System.out.print("Is this employee a manager? (yes/no): ");
                     String isManagerStr = scanner.nextLine().trim().toLowerCase();
                     boolean isManager = isManagerStr.equals("yes");

                     Employee newEmp = new Employee(firstName, lastName, userID, 0f, 0f, hourlyWage, newPassword, 0f, isManager);
                     data.getEmployees().add(newEmp);
                     current = newEmp;

                     System.out.println("New employee created and logged in.\n");
                 } else {
                     System.out.println("Please try again.\n");
                 }
             }
        } while (current == null);
        
        Manager manager = new Manager(data.getEmployees());
        
        boolean isManager = current.managerStatus();
        int choice;
 
 		if (isManager == true) {
 			do {
 				menuManager();
 				choice = scanner.nextInt();
 				switch (choice) {
 					case 1:
 						manager.viewAllEmployees();		// Not yet implemented
 						break;
 					case 2:
 						manager.approvePayroll();	// Add spaces/new lines
 						break;
 					case 3: 
 						manager.editEmployeeHours();	// Make it so that menu goes back
 						break;
 					case 4:
 						System.out.println("Exiting...");
 						System.exit(0);
 						break;
 					default:
 						System.out.println("Invalid choice. Please try again.");
 				}
 			} while (choice != 3); // edit to fit need
 		}
 		
 		else {
 			do {
 				menuReg();
 				choice = scanner.nextInt();
 				switch (choice) {
 					case 1:
 						System.out.println("Your paycheck: $" + current.getCheck());
 						PaycheckPDF.generate(current);
 						break;
 					case 2:
 						 System.out.print("Enter hours worked: ");
 					    float hours = scanner.nextFloat();
 					    System.out.print("Enter overtime hours: ");
 					    float overtime = scanner.nextFloat();
 					    current.setHoursWorked(hours);
 					    current.setOvertimeWorked(overtime);
 					    System.out.println("Hours updated.");
 						break;
 					case 3: 
 						System.out.println("Exiting...");
 						System.exit(0); 						
 						break;
 					default:
 						System.out.println("Invalid choice. Please try again.");
 				}
 			} while (choice != 3); // edit to fit need
 		}
 		
 		scanner.close();
 	}
 	
 	static void menuManager() { //edit to fit need
 		System.out.println("  Enter Choice: ");
 		System.out.println("      Menu      ");
 		System.out.println("1. View All Employees");
 		System.out.println("2. Approve Payroll For An Employee");
 		System.out.println("3. Edit Employee Hours ");
 		System.out.println("4. Terminate Run");

 	}
 	
 	static void menuReg() { //edit to fit need
 		System.out.println("  Enter Choice: ");
 		System.out.println("       Menu      ");
 		System.out.println("1. Calculate Pay ");
 		System.out.println("2. Enter Hours ");
 		System.out.println("3. xxxxxxxxxx ");

 	}
}	

//may remove bottom

		/*
                //adding code for input
                // Add employees to a list
                   List<Employee> employees = Arrays.asList(emp1, emp2, emp3);
                   
                   // Load into login system
                   loginSystem.loadEmployees(employees);

                   // Ask for login
                   System.out.println("Welcome to the Payroll System");
                   System.out.print("Enter your employee ID: ");
                   String inputId = scanner.nextLine();

                   System.out.print("Enter your password: ");
                   String inputPassword = scanner.nextLine();
                   
                   if (loginSystem.authenticate(inputId, inputPassword)) {
                       System.out.println("Login successful!");

                       // Find the matching employee
                       for (Employee e : employees) {
                           if (String.valueOf(e.getId()).equals(inputId)) {
                               System.out.println("Employee Info:");
                               System.out.println("Name: " + e.getFirstName() + " " + e.getLastName());
                               System.out.println("Hours Worked: " + e.getHoursWorked());
                               System.out.println("Overtime: " + e.getOvertimeWorked());
                               System.out.println("Hourly Wage: $" + e.getHourlyWage());
                               System.out.println("Gross Pay: $" + e.getCheck());
                           }
                       }
                   } else {
                       System.out.println("Invalid ID or password.");
                   }

                   scanner.close(); */
		 	
        
        
        //need to implement login function here then move onto menu
