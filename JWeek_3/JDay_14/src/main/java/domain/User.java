package domain;

import lombok.Data;

@Data
public class User {
	private int id;
	private String name;
	private String surname;
	private String email;
	private String username;
	private String password;
	
	public User(String name, String surname, String email, String username, String password) {
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.username = username;
		this.password = password;
	}

	public User(int id, String name, String surname, String email, String username, String password) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.username = username;
		this.password = password;
	}
	
	
	
}
