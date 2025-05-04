package payrollsystem;
import java.util.*;

// Main class fr managing the employee directory
public class EmployeeDirectory {
    static Scanner scanner = new Scanner(System.in);
    
      static HashMap<Integer, Employee> employees = new HashMap<>();

    public static void main(String[] args) {
        int choice;

        // Loop until th user quits
         do {
            showMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // eat leftover newline

            switch (choice) {
              case 1:
                    addEmployee();
                    break;
                case 2:
                    updateEmployee();
                    break;
                case 3:
                    viewEmployee();
                    break;
                case 4:
                    removeEmployee();
                    break;
                case 5:
                      listAllEmployees();
                    break;
                case 6:
                    sendToManager();
                    break;
                case 0:
                      System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. PLease Try again.");
            }
        } while (choice != 0);
    }

    static void showMenu() {
        System.out.println("\nPayroll System - Employee Directory");
        System.out.println("1. Add Employee");
        System.out.println("2. Update Employee Info");
        System.out.println("3. View Employee Info");
         System.out.println("4. Remove Employee");
        System.out.println("5. List All Employees");
        System.out.println("6. Send Data to Manager View");
         System.out.println("0. Quit");
        System.out.print("Choose an option: ");
    }

    static void addEmployee() {
        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter last name: ");
          String lastName = scanner.nextLine();
         System.out.print("Enter ID: ");
        int id = scanner.nextInt();
        System.out.print("Enter hourly rate: ");
        float rate = scanner.nextFloat();
          System.out.print("Enter hours worked: ");
        float hours = scanner.nextFloat();
        System.out.print("Enter overtime hours: ");
        float overtime = scanner.nextFloat();
        System.out.print("Is Manager (true/false): ");
        boolean isManager = scanner.nextBoolean();
        System.out.println("Please enter a password");
        String password = scanner.nextLine();

        Employee emp = new Employee(firstName, lastName, id,hours, overtime,rate,password, 0,  isManager);
       
       employees.put(id, emp);
        System.out.println("Employee has been added!");
    }

    static void updateEmployee() {
        System.out.print("Enter employee ID to update: ");
        
         int id = scanner.nextInt();

        if (employees.containsKey(id)) {
            Employee emp = employees.get(id);
            System.out.print("Enter new hourly rate: ");
            emp.setHourlyWage(scanner.nextFloat());
             System.out.print("Enter new hours worked: ");
            emp.setHoursWorked(scanner.nextFloat());
            System.out.println("Employee info updated!");
        } else {
            System.out.println("Employee not found.");
        }
    }

    static void viewEmployee() {
        System.out.print("Enter employee ID to view: ");
        int id = scanner.nextInt();

        if (employees.containsKey(id)) {
            System.out.println(employees.get(id));
       
          } else {
            System.out.println("Employee not found.");
        }
    }

    static void removeEmployee() {
        System.out.print("Enter employee ID to remove: ");
        int id = scanner.nextInt();

        if (employees.containsKey(id)) {
            employees.remove(id);
            System.out.println("Employee removed.");
       
        } else {
               System.out.println("Employee not found.");
        }
    }

    static void listAllEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
        
        } else {
            
           System.out.println("\nAll Employees:");
            for (Employee emp : employees.values()) {
                System.out.println(emp);
            }
        }
    }

    static void sendToManager() {
        List<Employee> empList = new ArrayList<>(employees.values());
          Manager mgr = new Manager(empList);
          mgr.viewAllEmployees();
    }
}
