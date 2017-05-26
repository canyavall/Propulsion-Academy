package repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import domain.Document;

public class DocumentRepositoryDefault implements DocumentRepository{

	private final JdbcTemplate db;
	
	private final DocumentMapper docMapper = new DocumentMapper();
	
	@Autowired
	public DocumentRepositoryDefault(JdbcTemplate db) {
		this.db = db;
	}

	@Override
	public int count() {
		return db.queryForObject("Select count(*) from document", Integer.class);
	}

	@Override
	public void save(Document doc) {
		db.update("Insert into document (name, author) values (?,?)", doc.getName(), doc.getAuthor());
		
	}

	@Override
	public Document findById(Integer id) {
		return db.queryForObject("Select * from document where id = ?", docMapper, id);
	}

	@Override
	public List<Document> findAll() {
		return db.query("Select * from document", docMapper);
	}

	@Override
	public List<Document> findAllByAuthor(String author) {
		return db.query("Select * from document where author = ?", docMapper, author);
	}

	@Override
	public void deleteAll() {
		db.update("Delete from document");		
	}

	@Override
	public void deleteById(Integer id) {
		db.update("Delete from document where id = ?", id);
		
	}

	@Override
	public List<Document> findByDate(Timestamp date) {
		return db.query("Select * from document where creationdate = ?", docMapper, date);
	}
	

	private class DocumentMapper implements RowMapper<Document>{
	
		@Override
		public Document mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new Document(
				rs.getInt("id"),
				rs.getString("name"),
				rs.getTimestamp("creationDate"),
				rs.getString("author")
			);
		}
	}

}
