package payrollsystem;

public class Paycheck {
	private Employee employeeInfo;
    private float checkAmount;

    public Paycheck(Employee employeeInfo, float checkAmount) {
        this.employeeInfo = employeeInfo;
        this.checkAmount = checkAmount;
    }

    public Employee getEmployeeInfo() {
        return employeeInfo;
    }

    public void setEmployeeInfo(Employee employeeInfo) {
        this.employeeInfo = employeeInfo;
    }

    public float getCheckAmount() {
        return checkAmount;
    }

    public void setCheckAmount(float checkAmount) {
        this.checkAmount = checkAmount;
    }

    public float calculateCheckAmount() { //same as calculate pay so maybe remove? or remove calculate pay and keep this function
        return 0; // Placeholder
    }
}
