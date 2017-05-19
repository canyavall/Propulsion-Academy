package service;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import domain.Tweet;
import repository.TweetRepository;

public class DefaultTweetService implements TweetService{
	private static final Logger logger = LogManager.getLogger(DefaultTweetService.class);
	private final TweetRepository tweetRep;
	private int size;

	public DefaultTweetService(TweetRepository tweetRep){
		logger.info("Initiate Tweet Service");
		this.tweetRep = tweetRep;
	}
	
	@Override
	public void saveTweet(Tweet tweet){
		logger.info("Created tweet" + tweet.getId());
		tweetRep.save(tweet, tweet.getId());
		size++;
	}
	
	@Override
	public void deleteTweet(String id){
		logger.info("Deleted tweet" + id);
		tweetRep.deleteById(id);
		size--;
	}
	
	@Override
	public Tweet findTweet(String id){
		logger.info("Requested fin tweet with id: " + id);
		return tweetRep.findById(id);
	}
	
	@Override
	public List<Tweet> findAllTweets(){
		logger.info("Requested find all tweets");
		return tweetRep.findAll();
	}
	
	@Override
	public List<Tweet> findAllTweetsByUsername(String username){
		logger.info("Requested find tweet by username" + username);
		List <Tweet> tweets = findAllTweets();
		return tweets.stream().filter(t -> t.getAuthor().getUsername().equals(username)).collect(Collectors.toList());
	}
	
	@Override
	public List<Tweet> findAllTweetsByUserId(String userId){
		logger.info("Requested find all tweets by user id" + userId);
		return findAllTweets().stream().filter(t -> t.getAuthor().getId().equals(userId)).collect(Collectors.toList());		
	}
	
	@Override
	public List<Tweet> findByHashtag(String hashtag) {
		return findAllTweets().stream().filter(t -> t.getText().toLowerCase().contains(hashtag.toLowerCase())).collect(Collectors.toList());
	}

	public int getSize() {
		return size;
	}


	
	
}
