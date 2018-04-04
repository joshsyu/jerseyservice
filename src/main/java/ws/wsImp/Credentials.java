package ws.wsImp;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Credentials implements Serializable {

	// valid class version
	private static final long serialVersionUID = 1L;
	@JsonProperty("username")
	private String username;
	@JsonProperty("password")
	private String password;

	// Getters and setters
	String getUsername() {
		return this.username;
	}

	String getPassword() {
		return this.password;
	}
	public void setUsername(String username) {
        this.username = username;
    }
	public void setPassword(String password) {
        this.password = password;
    }
}
