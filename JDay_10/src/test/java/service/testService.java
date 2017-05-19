package service;

import static org.junit.Assert.*;

import java.util.Optional;

import org.junit.Test;

import domain.Tweet;
import domain.User;
import repository.InMemoryTweetRepository;
import repository.InMemoryUserRepository;

public class testService {
	User user1 = new User("Dead Pool", "deadpool@gmail.com", "deadpool", "IloveHelloKitty1");
	User user2 = new User("Bruce Wayne", "batseverywhere@gmail.com", "batman", "callMeBaby7");
	User user3 = new User("Peter Parker", "aracnofobiaftw@gmail.com", "spiderman", "cleanTheCityAfterMe3");
	User user4 = new User("Steven Grant Rogers", "americaftw@gmail.com", "captain_america", "shields");
	
	Tweet tweet1 = new Tweet("I hate spiders! #HateSpiders", user1);
	Tweet tweet2 = new Tweet("I love Bats! #LoveBats", user2);
	Tweet tweet3 = new Tweet("I hate Bats! #HateBats", user1);
	Tweet tweet4 = new Tweet("I hate All you! #HateBats #HateSpiders", user3);
	
	InMemoryTweetRepository tweetRep = new InMemoryTweetRepository();
	InMemoryUserRepository userRep = new InMemoryUserRepository();
	
	@Test
	public void userTesting(){
		UserService userserv = new DefaultUserService(userRep);
		assertNotNull(userserv.registerNewUser(user1));
		assertNotNull(userserv.registerNewUser(user2));
		assertNotNull(userserv.registerNewUser(user3));
		assertNull(userserv.registerNewUser(user4));
		
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
		Optional <User> optuser = userserv.findUserByUsername(user1.getUsername());
		assertEquals(optuser.get(), userserv.findUserById(user1.getId()));		
	}
	
	
	@Test
	public void testTweet(){
		
		TweetService tweetserv = new DefaultTweetService(tweetRep);
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
		
		tweetserv.saveTweet(tweet2); // add again for testing purposes
		
		//Check that findUserByUsername = findUserId
		assertEquals(tweetserv.findAllTweetsByUsername(user1.getUsername()), tweetserv.findAllTweetsByUserId(user1.getId()));

		//Check to get a List of Hashtags
		assertEquals(2,tweetserv.findByHashtag("#HateBats").size());
		assertEquals(1,tweetserv.findByHashtag("#LoveBats").size());
		
	}
}
