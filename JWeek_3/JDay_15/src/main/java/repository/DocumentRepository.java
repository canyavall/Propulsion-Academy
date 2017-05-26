package repository;

import java.sql.Timestamp;
import java.util.List;

import domain.Document;

public interface DocumentRepository {

	int count();
	
	void save(Document doc);
	
	Document findById(Integer id);
	
	List<Document> findByDate(Timestamp date);
	
	List<Document> findAll();
	
	List<Document> findAllByAuthor(String author);
	
	void deleteAll();
	
	void deleteById(Integer id);
}
