package web.service;

/**
 * Business logic to handle login functions.
 * 
 * @author Aneeta.
 */
public class LoginService {

	/**
	 * Static method returns true for successful login, false otherwise.
	 * @param username
	 * @param password
	 * @return
	 */
	public static boolean login(String username, String password, String dob) {

		// Check null or empty inputs
		//
		if (username == null || password == null || dob == null) {
			return false;
		}

		if (username.isEmpty() || password.isEmpty() || dob.isEmpty()) {
			return false;
		}

		// Match a fixed user name, password and dob.
		//
		if ("aneeta".equals(username)
				&& "1234".equals(password)
				&& "2001-03-19".equals(dob)) {

			return true;
		}

		return false;
	}
}