package model;

public class LoginLogic {
	private final String pass = "1234";

	public boolean check(User user) {
		if(user.getPass().equals(pass)) {
			return true;
		}
		else {
			return false;
		}
	}
}