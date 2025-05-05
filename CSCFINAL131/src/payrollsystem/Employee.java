package payrollsystem;

public class Employee {
	private String firstName;
    private String lastName;
    private int id;
    private float hoursWorked;
    private float overtimeWorked;
    private float hourlyWage;
    private String password;
    private float check;
    private boolean isManager;
    
    public static float taxRate = .0725f;

    public Employee(String firstName, String lastName, int id, float hoursWorked, float overtimeWorked, float hourlyWage,String password, float check, boolean isManager) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.hoursWorked = hoursWorked;
        this.overtimeWorked = overtimeWorked;
        this.hourlyWage = hourlyWage;
        this.password=password;
        this.check= check;    
        this.isManager = isManager;
    }
    
    public boolean auth(int userID, String userPassword) {
    	return this.id == userID && password.equals(userPassword);
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
        this.password = password;
    }

    public float updateCheck() {
        return this.check = calculatePay(this.hoursWorked, this.overtimeWorked, this.hourlyWage);
    }

    public float getCheck() {
        return updateCheck();
    }
    
    public boolean managerStatus() {
    	return isManager;
    }
    
    public float calculatePay(float hours, float overHours, float wage) {
    	check = (hours*wage) + ((wage*1.5f)*overHours);
    	
    	check = check - (check*taxRate);
 
        return check; 
        }   
    
    public void printPayStub() {  // display all info for paystubs 
        float grossPay = (hoursWorked * hourlyWage) + (overtimeWorked * hourlyWage * 1.5f);
        float taxDeducted = grossPay * taxRate;
        float netPay = grossPay - taxDeducted;
        
        System.out.println("----- PAY STUB -----");
        System.out.println("Employee Name: " + firstName + " " + lastName);
        System.out.println("Employee ID: " + id);
        System.out.println("Hours Worked: " + hoursWorked);
        System.out.println("Overtime Hours: " + overtimeWorked);
        System.out.println("Hourly Wage: $" + hourlyWage);
        System.out.println("Gross Pay: $" + grossPay);
        System.out.println("Tax Deducted (7.25%): $" + taxDeducted);
        System.out.println("Net Pay: $" + netPay);
        System.out.println("---------------------");
        }
     

        
    }
    


