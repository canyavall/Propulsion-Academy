package service;

import java.util.List;
import java.util.Optional;

import domain.User;

public interface UserService {
	
	public boolean registerNewUser(User user);
	
	public void deleteUser(String id);
	
	public User findUserById(String id);
	
	public List<User> findAllUsers();

	public Optional<User> findUserByUsername(String username);

	public int getSize();
	
}
