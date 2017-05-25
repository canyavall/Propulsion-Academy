package service;

import java.util.List;
import java.util.function.Predicate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.User;
import repository.UserRepository;

@Service
public class DefaultUserService implements UserService{

	private static final Logger logger = LogManager.getLogger(DefaultUserService.class);
	private final UserRepository userRep;

	@Autowired
	public DefaultUserService(UserRepository userRep) {
		logger.trace("Initiate UserService");
		this.userRep = userRep;
	}

	@Override
	public boolean registerNewUser(User user){		
//		if (checkPassword(user.getPassword()) && checkUsernameDuplicate(user.getUsername())){
			logger.trace("Registered user with id " + user.getId());
			userRep.save(user);
			return true;
//		}
//		logger.trace("Registered user with username " + user.getUsername() + " FAILED!");
//		return false;			
	}
	
	@Override
	public void deleteUser(int id){
		logger.trace("Deleted user with id " + id);
		userRep.deleteById(id);
	}
	
	@Override
	public User findUserById(int id){
		logger.trace("Requested find user by id: " + id);
		return userRep.findById(id);
	}
	
	@Override
	public List<User> findAllUsers(){
		logger.trace("Requested find all users");
		return userRep.findAll();
	}

	@Override
	public User findUserByUsername(String username){
		logger.trace("Requested find user by username" + username);
		return userRep.findByUsername(username);
	}

	public boolean checkPassword(String str){
		Predicate<String> checkSpaces = pswd -> pswd.length() == pswd.trim().length();
		Predicate<String> checkLength = pswd -> pswd.trim().length() > 8;
		Predicate<String> containsNumber = pswd -> pswd.matches(".*\\d+.*");
		Predicate<String> containsLetter = pswd -> pswd.matches(".*[A-Za-z]+.*");
		Predicate<String> isvalid = checkSpaces.and(checkLength.and(containsNumber).and(containsLetter));
		return isvalid.test(str);		
	}
	
	public boolean checkUsernameDuplicate(String username){
		if (findUserByUsername(username) == null) return true;		
		return false;
	}


}
