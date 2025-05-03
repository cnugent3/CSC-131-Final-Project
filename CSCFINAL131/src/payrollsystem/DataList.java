package payrollsystem;
import java.util.ArrayList;
import java.util.List;

public class DataList {
	private List<Employee> employees;  //NEED TO MAKE DYNAMIC
	
	public DataList() {
		employees = new ArrayList<>(); //need to change check value to something realistic
		employees.add(new Employee("Colin", "Nugent", 7999, 30f, 0f, 17f, "Colin1!", 0f, true));
		employees.add(new Employee("Jimson", "Sou", 8000, 35f, 2f, 25f, "Jimson1!", 3f, false));
		employees.add(new Employee("Evan", "Zheng", 8001, 40f, 4f, 30f, "Evan1!", 0f, false));
		employees.add(new Employee("Jumana", "Abdullah", 7000, 42f, 1f, 23f, "Jumana3!", 4f, false));
		employees.add(new Employee("Christian", "Ishikawa", 8002, 44f, 6f, 33f, "Christian1!", 0f, false));
		employees.add(new Employee("Noor", "Eissa", 8004, 34f, 7f, 44f, "Noor1!", 0f, false));
		employees.add(new Employee("Maitri", "Amin", 9000, 38f, 2f, 28f, "Maitri1!", 1f, false));

	}
	
	public Employee auth(int userID, String userPassword) {
        for (Employee emp : employees) {
            if (emp.auth(userID, userPassword)) {
                return emp;
            }
        }
    	System.out.println("Not a Valid Login \n");
    	
    	
        return null;
    }
	
	public List<Employee> getEmployees() {
		return employees;
	}
}
