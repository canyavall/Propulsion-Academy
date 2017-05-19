package service;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import domain.User;
import repository.UserRepository;

public class DefaultUserService implements UserService{
	private static final Logger logger = LogManager.getLogger(DefaultUserService.class);
	private final UserRepository userRep;
	public int size;
	
	public DefaultUserService(UserRepository userRep) {
		logger.info("Initiate UserService");
		this.userRep = userRep;
	}

	@Override
	public boolean registerNewUser(User user){
		
		if (checkPassword(user.getPassword())){
			logger.info("Registered user with id " + user.getId());
			userRep.save(user, user.getId());
			size++;
			return true;
		}
		logger.info("Registered user with id " + user.getId() + " FAILED!");
		return false;			
	}
	
	@Override
	public void deleteUser(String id){
		logger.info("Deleted user with id " + id);
		userRep.deleteById(id);
		size--;
	}
	
	@Override
	public User findUserById(String id){
		logger.info("Requested find user by id: " + id);
		return userRep.findById(id);
	}
	
	@Override
	public List<User> findAllUsers(){
		logger.info("Requested find all users");
		return userRep.findAll();
	}

	@Override
	public Optional<User> findUserByUsername(String username){
		logger.info("Requested find user by username" + username);
		return findAllUsers().stream().filter(u -> u.getUsername().equals(username)).findFirst();
	}

	@Override
	public int getSize() {
		return size;
	}	
	
	//Java bean validation
	public boolean checkPassword(String str){
		Predicate<String> checkSpaces = pswd -> pswd.length() == pswd.trim().length();
		Predicate<String> checkLength = pswd -> pswd.trim().length() > 8;
		Predicate<String> containsNumber = pswd -> pswd.matches(".*\\d+.*");
		Predicate<String> containsLetter = pswd -> pswd.matches(".*[A-Za-z]+.*");
		Predicate<String> isvalid = checkSpaces.and(checkLength.and(containsNumber).and(containsLetter));
		return isvalid.test(str);		
	}
}
