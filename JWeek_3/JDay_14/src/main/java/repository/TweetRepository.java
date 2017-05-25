package repository;

import java.util.List;

import domain.Tweet;

public interface TweetRepository {

	int count();
	void save(Tweet tweet);
	void deleteById(Integer id);
	void deleteAll();
	Tweet findById(Integer id);
	List<Tweet> findAll();
	List<Tweet> findAllByUserId(int userId);
	List<Tweet> findAllContaining(String searchText);
	List<Integer> findAllUsernames();
}
