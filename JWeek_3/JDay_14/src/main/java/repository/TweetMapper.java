package repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import domain.Tweet;

class TweetMapper implements RowMapper<Tweet> {

	@Override
	public Tweet mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Tweet(
			rs.getInt("id"),
			rs.getInt("author"),
			rs.getString("text")
		);
	}
}
