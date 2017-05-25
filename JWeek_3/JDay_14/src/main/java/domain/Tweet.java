package domain;

import lombok.Data;


@Data
public class Tweet {
	private int id;
	private String text;
	private int author;
	
	public Tweet(int id, int author, String text) {
		this.id = id;
		this.text = text;
		this.author = author;
	}
	
	public Tweet(int author, String text) {
		this.text = text;
		this.author = author;
	}

	
}
