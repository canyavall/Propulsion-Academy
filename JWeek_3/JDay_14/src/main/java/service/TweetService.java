package service;

import java.util.List;

import domain.Tweet;

public interface TweetService {
	
	public void saveTweet(Tweet tweet);
	
	public void deleteTweet(int id);
	
	public Tweet findTweet(int id);
	
	public List<Tweet> findAllTweets();
	
	public List<Tweet> findAllTweetsByUserId(int userId);
	
	public List<Tweet> findByHashtag(String hashtag);
	
	public List<Tweet> findAllMentioningUsername(String username);
}
