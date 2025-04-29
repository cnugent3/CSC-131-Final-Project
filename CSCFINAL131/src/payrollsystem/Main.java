package payrollsystem;


public class Main {
	public static void main(String[] args) {

		Employee emp1 = new Employee("Colin", "Nugent", 7999, 30f,0f, 17f);

		System.out.println(emp1.getFirstName());
		Employee emp1 = new Employee("Colin", "Nugent", 7999, 30f, 0f, 17f, "Colin1!", 0f, 0f);
		
		System.out.println(emp1.getId() + " " + emp1.getFirstName() + " " + emp1.getLastName()
	    + " " + emp1.getHoursWorked() + " " + emp1.getOvertimeWorked()
	    + " " + emp1.getHourlyWage() + " " + emp1.getPassword() + " " + emp1.getCheck());
		
		Employee emp2 = new Employee("Jimson", "Sou", 8000, 35f, 2f, 25f, "Jimson1!", 3f, 0f);
		System.out.println(emp2.getId() + " " + emp2.getFirstName() + " " + emp2.getLastName()
	    + " " + emp2.getHoursWorked() + " " + emp2.getOvertimeWorked()
	    + " " + emp2.getHourlyWage() + " " + emp2.getPassword() + " " + emp2.getCheck());
		
		Employee emp3 = new Employee("Evan", "Zheng", 8001, 40f, 4f, 30f, "Evan1!", 0f, 0f);
		System.out.println(emp3.getId() + " " + emp3.getFirstName() + " " + emp3.getLastName()
	    + " " + emp3.getHoursWorked() + " " + emp3.getOvertimeWorked()
	    + " " + emp3.getHourlyWage() + " " + emp3.getPassword() + " " + emp3.getCheck());
	
		Employee emp4 = new Employee("Jumana", "Abdullah", 7000, 42f, 1f, 23f, "Jumana3!", 4f, 7f);
		System.out.println(emp4.getId() + " " + emp4.getFirstName() + " " + emp4.getLastName()
		+ " " + emp4.getHoursWorked() + " " + emp4.getOvertimeWorked()
		+ " " + emp4.getHourlyWage() + " " + emp4.getPassword() + " " + emp4.getCheck());

		Employee emp5 = new Employee("Christian", "Ishikawa", 8002, 44f, 6f, 33f, "Christian1!", 0f, 3f);
		System.out.println(emp5.getId() + " " + emp5.getFirstName() + " " + emp5.getLastName()
		+ " " + emp5.getHoursWorked() + " " + emp5.getOvertimeWorked()
		+ " " + emp5.getHourlyWage() + " " + emp5.getPassword() + " " + emp5.getCheck());
	}

}
