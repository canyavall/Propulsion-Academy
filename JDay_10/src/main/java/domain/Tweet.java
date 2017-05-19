package domain;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;


public class Tweet {
	private final String id = UUID.randomUUID().toString();
	private LocalDateTime created = LocalDateTime.now();
	private String text;
	private User author;
	private List<Tweet> listTweets;
	private Tweet replyTo;
	private Tweet retweetOf;
	
	public Tweet(String text, User author) {
		this.text = text;
		this.author = author;
	}

	public String getId() {
		return id;
	}

	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public Tweet getReplyTo() {
		return replyTo;
	}

	public void setReplyTo(Tweet replyTo) {
		this.replyTo = replyTo;
	}

	public Tweet getRetweetOf() {
		return retweetOf;
	}

	public void setRetweetOf(Tweet retweetOf) {
		this.retweetOf = retweetOf;
	}

	public List<Tweet> getListTweets() {
		return listTweets;
	}

	public void setTweetInList(Tweet tweet) {
		this.listTweets.add(tweet);
	}

	@Override
	public String toString() {
		return "Tweet [id=" + id + ", created=" + created + ", text=" + text + ", author=" + author.getFullName() + ", listTweets="
				+ listTweets + ", replyTo=" + replyTo + ", retweetOf=" + retweetOf + "]";
	}
	
	
}
