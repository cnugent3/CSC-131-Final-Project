package payrollsystem;

public class Main {
	public static void main(String[] args) {
		Employee emp1 = new Employee("Colin", "Nugent", 7999, 30f,0f, 17f);
		System.out.println(emp1.getFirstName());
		
		Employee emp2 = new Employee("Jimson", "Sou", 8000, 35f,2f, 25f);
		System.out.println(emp2.getFirstName());
		
	}

}
