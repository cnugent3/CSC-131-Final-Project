package payrollsystem;

public class Login {
//new thing
	package payrollsystem;

	import java.util.HashMap;
	import java.util.Map;
	import java.util.List;

	public class Login {
	    private Map<String, User> userCredentials;

	    private static class User {
	        String password;
	        boolean isManager;

	        User(String password, boolean isManager) {
	            this.password = password;
	            this.isManager = isManager;
	        }
	    }

	    public Login() {
	        userCredentials = new HashMap<>();
	    }

	    // Load employee data from a list
	    public void loadEmployees(List<Employee> employees) {
	        for (Employee e : employees) {
	            userCredentials.put(String.valueOf(e.getId()), new User(e.getPassword(), false));
	        }
	    }

	    public boolean authenticate(String username, String password) {
	        User user = userCredentials.get(username);
	        return user != null && user.password.equals(password);
	    }

	    public boolean isManager(String username) {
	        User user = userCredentials.get(username);
	        return user != null && user.isManager;
	    }

	    public void addEmployee(String username, String password) {
	        userCredentials.put(username, new User(password, false));
	    }

	    public void addManager(String username, String password) {
	        userCredentials.put(username, new User(password, true));
	    }
	} 
}
