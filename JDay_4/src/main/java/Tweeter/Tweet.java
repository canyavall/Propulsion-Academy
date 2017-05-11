package Tweeter;

public class Tweet {
	private final String id = java.util.UUID.randomUUID().toString();
	private String text;
	
	public Tweet(String text) {
		this.text = text;
	}
	
	public String getId() {
		return id;
	}

	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	
	
}
