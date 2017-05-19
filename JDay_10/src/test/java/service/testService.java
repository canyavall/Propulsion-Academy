package service;

import static org.junit.Assert.*;

import org.junit.Test;

import domain.Tweet;
import domain.User;

public class testService {
	User user1 = new User("Dead Pool", "deadpool@gmail.com", "deadpool", "IloveHelloKitty");
	User user2 = new User("Bruce Wayne", "batseverywhere@gmail.com", "batman", "callMeBaby");
	User user3 = new User("Pert Parker", "aracnofobiaftw@gmail.com", "spiderman", "cleanTheCityAfterMe");
	
	Tweet tweet1 = new Tweet("I hate spiders!", user1);
	Tweet tweet2 = new Tweet("I love Bats!", user2);
	Tweet tweet3 = new Tweet("I hate Bats!", user1);
	Tweet tweet4 = new Tweet("I hate All you!", user3);
	
	@Test
	public void userTesting(){
		UserService userserv = new UserService();
		userserv.registerNewUser(user1);
		userserv.registerNewUser(user2);
		userserv.registerNewUser(user3);
		
		//Check size
		assertEquals(3, userserv.getSize());
		
		//Check findUserById
		assertEquals(user2, userserv.findUserById(user2.getId()));
		
		//Delete user and check size
		userserv.deleteUser(user3.getId());
		assertEquals(2, userserv.getSize());
		
		//Check user id that doesn't exist
		assertNull(userserv.findUserById(user3.getId()));
		
		//Check that findUserByUsername = findUseryId
		assertEquals(userserv.findUserByUsername(user1.getUsername()), userserv.findUserById(user1.getId()));
//		assertSame(userserv.findUserByUsername(user1.getUsername()), userserv.findUserById(user1.getId()));
		
	}
	
	
	@Test
	public void testTweet(){
		
		TweetService tweetserv = new TweetService();
		tweetserv.saveTweet(tweet1);
		tweetserv.saveTweet(tweet2);
		tweetserv.saveTweet(tweet3);
		tweetserv.saveTweet(tweet4);
		
		//Check size
		assertEquals(4, tweetserv.getSize());
		
		//Check findTweetById
		assertEquals(tweet2, tweetserv.findTweet(tweet2.getId()));
		
		//Delete Tweet and check size
		tweetserv.deleteTweet(tweet2.getId());
		assertEquals(3, tweetserv.getSize());
		
		//Check tweet id that doesn't exist
		assertNull(tweetserv.findTweet(tweet2.getId()));
		
		//Check that findUserByUsername = findUserId
		assertEquals(tweetserv.findAllTweetsByUsername(user1.getUsername()), tweetserv.findAllTweetsByUserId(user1.getId()));

		
	}
}
