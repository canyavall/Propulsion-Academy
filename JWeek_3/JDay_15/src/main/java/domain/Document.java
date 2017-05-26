package domain;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class Document {
	
	private int id;
	private String name;
	private Timestamp creationDate;
	private String author;
	
	public Document(int id, String name, Timestamp creationDate, String author) {
		this.id = id;
		this.name = name;
		this.creationDate = creationDate;
		this.author = author;
	}
	
	public Document(String name, String author) {
		this.name = name;
		this.author = author;
	}
	
	
	
}
