package service;

import java.util.List;
import java.util.stream.Collectors;

import domain.Tweet;
import repository.InMemoryTweetRepository;

public class TweetService {
	
	private InMemoryTweetRepository tweetRep = new InMemoryTweetRepository();
	private int size;

	public void saveTweet(Tweet tweet){
		tweetRep.save(tweet, tweet.getId());
		size++;
	}
	
	public void deleteTweet(String id){
		tweetRep.deleteById(id);
		size--;
	}
	
	public Tweet findTweet(String id){
		return tweetRep.findById(id);
	}
	
	public List<Tweet> findAllTweets(){
		return tweetRep.findAll();
	}
	
	public List<Tweet> findAllTweetsByUsername(String username){
		List <Tweet> tweets = findAllTweets();
		return tweets.stream().filter(t -> t.getAuthor().getUsername().equals(username)).collect(Collectors.toList());
	}
	
	public List<Tweet> findAllTweetsByUserId(String userId){
		return findAllTweets().stream().filter(t -> t.getAuthor().getId().equals(userId)).collect(Collectors.toList());		
	}

	public int getSize() {
		return size;
	}
	
	
}
