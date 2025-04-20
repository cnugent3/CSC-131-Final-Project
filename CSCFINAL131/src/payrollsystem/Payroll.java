package payrollsystem;
import java.util.ArrayList;

public class Payroll {
	private ArrayList<Employee> employees;
    private String managerName;

    public Payroll(String managerName) {
        this.managerName = managerName;
        this.employees = new ArrayList<>();
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public Employee findEmployee(String id) {
        return null; // Placeholder
    }

    public float getHoursWorked(Employee employee) {
        return 0; // Placeholder
    }

    public Paycheck issueCheck(Employee employee) {
        return null; // Placeholder
    }
}
