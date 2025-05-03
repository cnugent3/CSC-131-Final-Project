package payrollsystem;
import java.util.Scanner;

public class Main {
 	public static void main(String[] args) {
 	/*	 MOVED TO DATALIST
 		Employee emp1 = new Employee("Colin", "Nugent", 7999, 30f, 0f, 17f, "Colin1!", 0f, true);
 		System.out.println(emp1.getId() + " " + emp1.getFirstName() + " " + emp1.getLastName() + " " + emp1.getHoursWorked() + " " + emp1.getOvertimeWorked() + " " + emp1.getHourlyWage() + " " + emp1.getPassword() + " " + emp1.getCheck());
 		
		Employee emp2 = new Employee("Jimson", "Sou", 8000, 35f, 2f, 25f, "Jimson1!", 3f, false);
 		System.out.println(emp2.getId() + " " + emp2.getFirstName() + " " + emp2.getLastName() + " " + emp2.getHoursWorked() + " " + emp2.getOvertimeWorked() + " " + emp2.getHourlyWage() + " " + emp2.getPassword() + " " + emp2.getCheck());
 
 		Employee emp3 = new Employee("Evan", "Zheng", 8001, 40f, 4f, 30f, "Evan1!", 0f, false);
 		System.out.println(emp3.getId() + " " + emp3.getFirstName() + " " + emp3.getLastName() + " " + emp3.getHoursWorked() + " " + emp3.getOvertimeWorked() + " " + emp3.getHourlyWage() + " " + emp3.getPassword() + " " + emp3.getCheck());
 		
		Employee emp4 = new Employee("Jumana", "Abdullah", 7000, 42f, 1f, 23f, "Jumana3!", 4f, false);
		System.out.println(emp4.getId() + " " + emp4.getFirstName() + " " + emp4.getLastName() + " " + emp4.getHoursWorked() + " " + emp4.getOvertimeWorked() + " " + emp4.getHourlyWage() + " " + emp4.getPassword() + " " + emp4.getCheck());

		Employee emp5 = new Employee("Christian", "Ishikawa", 8002, 44f, 6f, 33f, "Christian1!", 0f, false);
		System.out.println(emp5.getId() + " " + emp5.getFirstName() + " " + emp5.getLastName() + " " + emp5.getHoursWorked() + " " + emp5.getOvertimeWorked() + " " + emp5.getHourlyWage() + " " + emp5.getPassword() + " " + emp5.getCheck());

		Employee emp6 = new Employee("Noor", "Eissa", 8004, 34f, 7f, 44f, "Noor1!", 0f, false);
		System.out.println(emp6.getId() + " " + emp6.getFirstName() + " " + emp6.getLastName() + " " + emp6.getHoursWorked() + " " + emp6.getOvertimeWorked() + " " + emp6.getHourlyWage() + " " + emp6.getPassword() + " " + emp6.getCheck());

		Employee emp7 = new Employee("Maitri", "Amin", 9000, 38f, 2f, 28f, "Maitri1!", 1f, false);
        System.out.println(emp7.getId() + " " + emp7.getFirstName() + " " + emp7.getLastName() + " " + emp7.getHoursWorked() + " " + emp7.getOvertimeWorked() + " " + emp7.getHourlyWage() + " " + emp7.getPassword() + " " + emp7.getCheck());
        
      */  
        //need to implement login function here then move onto menu
   

        Scanner scanner = new Scanner(System.in);
        DataList data = new DataList();
        
        Employee current = null;
        
        do {
        	 System.out.print("UserID: ");
             int userID = scanner.nextInt();
             scanner.nextLine();
             System.out.print("Password: ");
             String userPassword = scanner.nextLine();
             
             current = data.auth(userID, userPassword); //no validation check yet curent == currently logged in
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
