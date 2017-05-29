/*
 * Copyright 2016-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package twitter.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import twitter.domain.Tweet;

/**
 * JDBC-based implementation of the {@link TweetRepository} API.
 */
@Repository
public class JdbcTweetRepository implements TweetRepository {

	private final TweetMapper tweetMapper = new TweetMapper();

	private final JdbcTemplate jdbcTemplate;
	private final SimpleJdbcInsert insertTweet;

	@Autowired
	public JdbcTweetRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
		// @formatter:off
		this.insertTweet = new SimpleJdbcInsert(jdbcTemplate)
				.withTableName("tweet")
				.usingGeneratedKeyColumns("id");
		// @formatter:on
	}

	@Override
	public int count() {
		return jdbcTemplate.queryForObject("select count(*) from tweet", Integer.class);
	}

	@Override
	public void save(Tweet tweet) {
		// String sql = "insert into tweet(author, text) values(?,?)";
		// jdbcTemplate.update(sql, tweet.getAuthor(), tweet.getText());

		Map<String, Object> parameters = new HashMap<>(2);
		parameters.put("author", tweet.getAuthor());
		parameters.put("text", tweet.getText());
		Number newId = insertTweet.executeAndReturnKey(parameters);

		tweet.setId(newId.intValue());
	}

	@Override
	public void deleteById(Integer id) {
		jdbcTemplate.update("delete from tweet where id=?", id);
	}

	@Override
	public void deleteAll() {
		jdbcTemplate.update("delete from tweet");
	}

	@Override
	public Tweet findById(Integer id) {
		String sql = "select * from tweet where id=?";
		return jdbcTemplate.queryForObject(sql, tweetMapper, id);
	}

	@Override
	public List<Tweet> findAll() {
		return jdbcTemplate.query("select * from tweet", tweetMapper);
	}

	@Override
	public List<Tweet> findAllByUsername(String username) {
		// String sql = "select * from tweet where author=?";
		String sql = "select * from tweet where lower(author) = lower(?)";
		return jdbcTemplate.query(sql, tweetMapper, username);
	}

	@Override
	public List<Tweet> findAllContaining(String searchText) {
		// String sql = "select * from tweet where text like ?";
		String sql = "select * from tweet where lower(text) like lower(?)";
		return jdbcTemplate.query(sql, tweetMapper, "%" + searchText + "%");
	}

	@Override
	public List<String> findAllUsernames() {
		// String sql = "select author from tweet";
		String sql = "select distinct lower(author) from tweet";
		return jdbcTemplate.queryForList(sql, String.class);
	}

}
