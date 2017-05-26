package repository;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import config.DataAccessConfig;
import config.RepositoryConfig;
import domain.Document;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes={RepositoryConfig.class, DataAccessConfig.class})
public class RepositoryTest {

	@Autowired
	DocumentRepository docRep;
	
	Document doc1 = new Document("How to kill the evil", "Deadpool");
	Document doc2 = new Document("How to regenerate by yourself", "Deadpool");
	Document doc3 = new Document("Living in the sky", "Spiderman");
	Document doc4 = new Document("I hate bats!", "Batman");
	Document doc5 = new Document("Villains defeated 2016", "Spiderman");
	
	@Before
	public void before(){
		//Check cleaning the db
		docRep.deleteAll();
	}
	
	public void TestInsert(){
		
	}
	
}
