package domain;

import java.time.LocalDateTime;
import java.util.UUID;

public class User {
	private final String id = UUID.randomUUID().toString();
	private String fullName;
	private LocalDateTime created = LocalDateTime.now();
	private String email;
	private String username;
	private String password;
	
	public User(String fullName, String email, String username, String password) {
		this.fullName = fullName;
		this.email = email;
		this.username = username;
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public String getFullName() {
		return fullName;
	}

	public LocalDateTime getCreated() {
		return created;
	}

	public String getEmail() {
		return email;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", fullName=" + fullName + ", created=" + created + ", email=" + email + ", username="
				+ username + "]";
	}
	

}
