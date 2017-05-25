package repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import domain.Tweet;

@Repository
public class JdbcTweetRepository implements TweetRepository{

	private final JdbcTemplate db;
	private final TweetMapper tweetMapper = new TweetMapper();
//	private SimpleJdbcInsert insertTweet;
	
	
	@Autowired
	public JdbcTweetRepository(JdbcTemplate jdbcTemplate) {
		this.db = jdbcTemplate;
	}

	@Override
	public int count() {
		String sql = "Select count(*) from tweet";
		Integer totalTweets = db.queryForObject(sql, Integer.class);
		return totalTweets;
	}

	@Override
	public void save(Tweet tweet) {
//		Map<String, Object> parameters = new HashMap<String, Object>(2);
//        parameters.put("author", tweet.getAuthor());
//        parameters.put("text", tweet.getText());
//        Number newId = insertTweet.executeAndReturnKey(parameters);
//        tweet.setId(newId.intValue());
		String sql =" Insert into tweet (author_id, text) values (?,?)";
		db.update(sql, tweet.getAuthor(), tweet.getText());		
	}

	@Override
	public void deleteById(Integer id) {
		String sql = "Delete from tweet where id = ?";
		db.update(sql, id);	
	}

	@Override
	public Tweet findById(Integer id) {
		String sql = "Select * from tweet where id = ?";
		List<Tweet> tweetResult = db.query(sql, tweetMapper, id);
		return (tweetResult.size() > 0) ? tweetResult.get(0) : null;
	}

	@Override
	public List<Tweet> findAll() {
		String sql = "Select * from tweet";
		List<Tweet> tweetResult = db.query(sql, tweetMapper);
		return tweetResult;
	}

	@Override
	public List<Tweet> findAllByUserId(int userId) {
		String sql = "Select * from tweet where author_id = ?";
		List<Tweet> tweetResult = db.query(sql, tweetMapper, userId);
		return tweetResult;
	}

	@Override
	public List<Tweet> findAllContaining(String searchText) {
		String sql = "Select * from tweet where lower(text) like lower(?)";
		List<Tweet> tweetResult = db.query(sql, tweetMapper, "%"+searchText+"%");
		return tweetResult;
	}

	@Override
	public List<Integer> findAllUsernames() {
		String sql = "Select author_id from tweet group by author_id";
		List<Integer> list = db.queryForList(sql, Integer.class);
		return list;
	}

	@Override
	public void deleteAll() {
		String sql = "Delete from tweet";
		db.update(sql);	
		sql = "ALTER TABLE tweet ALTER COLUMN id RESTART WITH 1";
		db.update(sql);
	}	
}
