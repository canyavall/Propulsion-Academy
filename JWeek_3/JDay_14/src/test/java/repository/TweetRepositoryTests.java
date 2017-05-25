package repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import config.DataAccessConfig;
import config.RepositoryConfig;
import domain.Tweet;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes={RepositoryConfig.class, DataAccessConfig.class})
public class TweetRepositoryTests {
	
	@Autowired
	TweetRepository tweetRep;
	
	Tweet tweet1 = new Tweet (1, "Today is a beautiful day");
	Tweet tweet2 = new Tweet (1, "I love ducks");
	Tweet tweet3 = new Tweet (2, "One spider!!!");
	Tweet tweet4 = new Tweet (3, "In my cave everything is dark and sad...");
	Tweet tweet5 = new Tweet (3, "And there's one spider...");
	
	@Before
	public void before(){
		//Check cleaning the db
		tweetRep.deleteAll();
	}
	
	@Test
	public void testTweet(){		
		//Check count
		assertEquals(0, tweetRep.count());
		
		//Check insert
		tweetRep.save(tweet1);
		tweetRep.save(tweet2);
		tweetRep.save(tweet3);
		tweetRep.save(tweet4);
		tweetRep.save(tweet5);		
		assertEquals(5, tweetRep.count());
		
		//Check delete by id
		tweetRep.deleteById(2);		
		assertEquals(4, tweetRep.count());
		
		//Get by id
		assertNull(tweetRep.findById(2));
		assertEquals("Spiderman", tweetRep.findById(3).getAuthor());
		
		//Get all
		assertEquals("Spiderman", tweetRep.findAll().get(1).getAuthor());
		assertEquals(tweetRep.count(), tweetRep.findAll().size());
		
		//Findallbyusername
		assertEquals(2, tweetRep.findAllByUserId(3).size());
		assertEquals(1, tweetRep.findAllByUserId(2).size());
		assertEquals(1, tweetRep.findAllByUserId(1).size());

		
		//Find All Containing
		assertEquals(2, tweetRep.findAllContaining("spider").size());
		assertEquals(2, tweetRep.findAllContaining("SpIdEr").size());
		
		//Find all usernames
		assertEquals(3, tweetRep.findAllUsernames().size());
		assertEquals("Spiderman", tweetRep.findAllUsernames().get(0));
	}
}
