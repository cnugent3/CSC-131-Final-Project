package payrollsystem;

public class Employee {
	private String firstName;
    private String lastName;
    private int id;
    private float hoursWorked;
    private float overtimeWorked;
    private float hourlyWage;
    private String password;
    private float check; //if we remove check then use this instead

    public Employee(String firstName, String lastName, int id, float hoursWorked, float overtimeWorked, float hourlyWage) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.hoursWorked = hoursWorked;
        this.overtimeWorked = overtimeWorked;
        this.hourlyWage = hourlyWage;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(float hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public float getOvertimeWorked() {
        return overtimeWorked;
    }

    public void setOvertimeWorked(float overtimeWorked) {
        this.overtimeWorked = overtimeWorked;
    }

    public float getHourlyWage() {
        return hourlyWage;
    }

    public void setHourlyWage(float hourlyWage) {
        this.hourlyWage = hourlyWage;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password=password;
    }

    public float calculatePay(float hours, float overHours, float wage) { //might move
    	check = (hours*wage) + ((wage*1.5f)*overHours);
    	
        return check; 
    }

}
