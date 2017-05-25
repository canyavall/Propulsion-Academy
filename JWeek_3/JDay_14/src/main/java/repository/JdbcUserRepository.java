package repository;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import domain.User;

@Repository
public class JdbcUserRepository implements UserRepository{

	private final JdbcTemplate db;
	private final UserMapper userMapper = new UserMapper();	
	
	@Autowired
	public JdbcUserRepository(JdbcTemplate db) {
		this.db = db;
	}

	@Override
	public int count() {
		String sql = "Select count(*) from user";
		Integer totalUsers = db.queryForObject(sql, Integer.class);
		return totalUsers;
	}

	@Override
	public void save(User user) {
		String sql =" Insert into user (name, surname, email, username, password) values (?,?,?,?,?)";
		db.update(sql, user.getName(), user.getSurname(), user.getEmail(), user.getUsername(), user.getPassword());
	}

	@Override
	public void deleteById(Integer id) {
		String sql = "Delete from user where id = ?";
		db.update(sql, id);			
	}

	@Override
	public User findById(Integer id) {
		String sql = "Select * from user where id = ?";
		List<User> userResult = db.query(sql, userMapper, id);
		return (userResult.size() > 0) ? userResult.get(0) : null;
	}
	
	@Override
	public User findByUsername(String username) {
		String sql = "Select * from user where low(id) = low(?)";
		List<User> userResult = db.query(sql, userMapper, username);
		return (userResult.size() > 0) ? userResult.get(0) : null;
	}

	@Override
	public List<User> findAll() {
		String sql = "Select * from user";
		List<User> userResult = db.query(sql, userMapper);
		return userResult;
	}

	@Override
	public void deleteAll() {
		String sql = "Delete from user";
		db.update(sql);	
		sql = "ALTER TABLE user ALTER COLUMN id RESTART WITH 1";
		db.update(sql);		
	}

}
