import java.util.List;

import controller.UserHelper;
import model.User;


public class UserTester {
public static void main(String[] args) {
		
		User daniel = new User("Daniel");
		User john = new User("John");
		UserHelper sh = new UserHelper();
		
		sh.insertUser(daniel);
		sh.insertUser(john);
		
		List<User> allUsers = sh.showAllUsers();
		
		for(User a: allUsers) {
			System.out.println(a.toString());
		}
	}
}
