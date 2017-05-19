package service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import domain.User;
import repository.InMemoryUserRepository;

public class UserService {

	private InMemoryUserRepository userRep = new InMemoryUserRepository();
	private int size;

	public void registerNewUser(User user){
		userRep.save(user, user.getId());
		size++;
	}
	
	public void deleteUser(String id){
		userRep.deleteById(id);
		size--;
	}
	
	public User findUserById(String id){
		return userRep.findById(id);
	}
	
	public List<User> findAllUsers(){
		return userRep.findAll();
	}

	public Optional<User> findUserByUsername(String username){
		return findAllUsers().stream().filter(u -> u.getUsername().equals(username)).findFirst();
	}

	public int getSize() {
		return size;
	}	
	
}
