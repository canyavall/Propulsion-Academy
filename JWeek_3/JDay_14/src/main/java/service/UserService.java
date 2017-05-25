package service;

import java.util.List;
import java.util.Optional;

import domain.User;

public interface UserService {
	
	public boolean registerNewUser(User user);
	
	public void deleteUser(int id);
	
	public User findUserById(int id);
	
	public List<User> findAllUsers();

	public User findUserByUsername(String username);
	
}
