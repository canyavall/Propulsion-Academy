package service;

import java.util.List;

import domain.Tweet;

public interface TweetService {
	
	public void saveTweet(Tweet tweet);
	
	public void deleteTweet(String id);
	
	public Tweet findTweet(String id);
	
	public List<Tweet> findAllTweets();
	
	public List<Tweet> findAllTweetsByUsername(String username);
	
	public List<Tweet> findAllTweetsByUserId(String userId);
	
	public List<Tweet> findByHashtag(String hashtag);
	
	public int getSize();
}
