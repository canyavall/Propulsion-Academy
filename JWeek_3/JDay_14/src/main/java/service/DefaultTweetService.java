package service;

import java.util.List;

import javax.mail.internet.MimeMessage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import domain.Tweet;
import repository.TweetRepository;

@Service
public class DefaultTweetService implements TweetService{
	private static final Logger logger = LogManager.getLogger(DefaultTweetService.class);
	private final TweetRepository tweetRep;
	private final JavaMailSender mailSender;

	@Autowired
	public DefaultTweetService(TweetRepository tweetRep, JavaMailSender mailSender){
		logger.trace("Initiate Tweet Service");
		this.tweetRep = tweetRep;
		this.mailSender = mailSender;
	}
	
	@Override
	public void saveTweet(Tweet tweet){

		logger.trace("Created tweet" + tweet.getId());
		tweetRep.save(tweet);
		sendNotificationEmail("Your tweet has been published!");
	}
	
	@Override
	public void deleteTweet(int id){
		logger.trace("Deleted tweet" + id);
		tweetRep.deleteById(id);
	}
	
	@Override
	public Tweet findTweet(int id){
		logger.trace("Requested fin tweet with id: " + id);
		return tweetRep.findById(id);
	}
	
	@Override
	public List<Tweet> findAllTweets(){
		logger.trace("Requested find all tweets");
		return tweetRep.findAll();
	}
	
	@Override
	public List<Tweet> findAllTweetsByUserId(int userId){
		logger.trace("Requested find tweet by username" + userId);		
		return tweetRep.findAllByUserId(userId);
	}
	
	@Override
	public List<Tweet> findByHashtag(String hashtag) {
		logger.trace("Requested find tweet by hashtag" + hashtag);
		return tweetRep.findAllContaining("#"+hashtag);
	}

	@Override
	public List<Tweet> findAllMentioningUsername(String username) {
		logger.trace("Requested find tweet by username" + username);
		if (username.indexOf('@') != 0) username = "@" + username;
		return tweetRep.findAllContaining(username);
	}
	
	private void sendNotificationEmail(String formattedMessage) {
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);

		try {
			helper.setFrom("username@example.org");
			helper.setTo("test@example.com");
			helper.setSubject("Tweeter activity");
			// helper.setText("mail body");
			helper.setText(formattedMessage);
			mailSender.send(mimeMessage);
		}
		catch (Exception ex) {
			ex.printStackTrace(System.err);
		}
	}
}
