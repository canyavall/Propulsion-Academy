package repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import domain.User;

class UserMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new User(
			rs.getInt("id"),
			rs.getString("name"),
			rs.getString("surname"),
			rs.getString("email"),
			rs.getString("username"),
			rs.getString("password")
		);
	}
}