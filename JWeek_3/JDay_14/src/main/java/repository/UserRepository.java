package repository;

import java.util.List;

import domain.User;

public interface UserRepository {
	int count();
	void save(User user);
	void deleteById(Integer id);
	void deleteAll();
	User findById(Integer id);
	User findByUsername(String username);
	List<User> findAll();
}
