package Tweeter;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;

public class tweetTest {
	
	@Test
	public void checkTweet() {
		Tweet t1 = new Tweet("I like chocolate");
		Tweet t2 = new Tweet("I like strawberry");
		Tweet t3 = new Tweet("You have to come");
		Tweet t4 = new Tweet("She is like me");
		Tweet t5 = new Tweet("I want to learn more");
		Tweet t6 = new Tweet("Where are you");
		
		TweetService tweetsv = new TweetService();
		tweetsv.save(t1);
		tweetsv.save(t2);
		tweetsv.save(t3);
		tweetsv.save(t4);
		tweetsv.save(t5);
		tweetsv.save(t6);
		//tweetsv.printAll();
		List<Tweet> tweetList = tweetsv.findAll();
		//Check number of tweets
		assertEquals(6, tweetList.size());
		
		//Delete 1 and check number of tweets
		tweetsv.delete(t6.getId());
		tweetList = tweetsv.findAll();
		assertEquals(5, tweetList.size());
		
		//Check text by id
		assertEquals("I want to learn more", tweetsv.findById(t5.getId()).getText());
		
		
	}
}
