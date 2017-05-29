package repository;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import config.DataAccessEmbedConfig;
import config.RepositoryConfig;
import domain.Document;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes={RepositoryConfig.class, DataAccessEmbedConfig.class})
@ActiveProfiles("dev")
public class RepositoryTest {

	@Autowired
	DocumentRepository docRep;
	
	Document doc1 = new Document("How to kill the evil", "Deadpool");
	Document doc2 = new Document("How to regenerate by yourself", "Deadpool");
	Document doc3 = new Document("Living in the sky", "Spiderman");
	Document doc4 = new Document("I hate bats!", "Batman");
	Document doc5 = new Document("Villains defeated 2016", "Spiderman");
	
//	@Before
//	public void before(){
//		//Check cleaning the db
//		docRep.deleteAll();
//	}
	
	@Test
	@Sql(statements = "delete from document")
	public void TestInsert(){
		assertEquals(0, docRep.count());
		docRep.save(doc1);
		docRep.save(doc2);
		docRep.save(doc3);
		assertEquals(3, docRep.count());
	}
	
	@Test
	@Sql(statements = "delete from document")
	public void TestFindBy(){
		docRep.save(doc1);
		docRep.save(doc2);
		docRep.save(doc3);
		docRep.save(doc4);
		docRep.save(doc5);
		assertEquals(doc1, docRep.findById(doc1.getId()));		
	}
	
	@Test
	@Sql(statements = "delete from document")
	public void TestFindByDate(){
		docRep.save(doc1);
		docRep.save(doc2);
		assertEquals(Arrays.asList(doc2), docRep.findByDate(doc2.getCreationDate()));		
	}
	
	@Test
	@Sql(statements = "delete from document")
	public void findAll(){
		docRep.save(doc1);
		docRep.save(doc2);
		docRep.save(doc3);
		docRep.save(doc4);
		docRep.save(doc5);
		assertEquals(Arrays.asList(doc1, doc2, doc3, doc4, doc5), docRep.findAll());
	}
	
	@Test
	@Sql(statements = "delete from document")
	public void findallByAuthor(){
		docRep.save(doc1);
		docRep.save(doc2);
		docRep.save(doc3);
		docRep.save(doc4);
		docRep.save(doc5);
		assertEquals(Arrays.asList(doc1, doc2), docRep.findAllByAuthor("Deadpool"));
	}
}
