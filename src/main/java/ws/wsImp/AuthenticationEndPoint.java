package ws.wsImp;

public class AuthenticationEndPoint {
	public boolean authenticate(String username, String password) {
		// Authenticate against a database, LDAP, file or whatever
		// Throw an Exception if the credentials are invalid
		System.out.println(username + "," + password);
		boolean result = false;
		if (username.equals("josh") && password.equals("test")) {
			result = true;
		}
		System.out.println("result:" + result);
		return result;
	}

	public String issueToken(String username) {
		// Issue a token (can be a random String persisted to a database or a
		// JWT token)
		// The issued token must be associated to a user
		// Return the issued token
		JWTImpl jwt = new JWTImpl();
		return jwt.createJWT("id", "josh", "test url", 60000);
	}
}
