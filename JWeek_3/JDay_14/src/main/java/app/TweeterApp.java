package app;

import java.util.Scanner;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import config.DataAccessConfig;
import config.RepositoryConfig;
import config.ServiceConfig;
import domain.Tweet;
import domain.User;
import repository.JdbcUserRepository;
import repository.TweetRepository;
import repository.UserRepository;
import service.TweetService;
import service.UserService;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes={ServiceConfig.class, DataAccessConfig.class})
public class TweeterApp {
	
	@Autowired
	TweetService tweetService;
	
	@Autowired
	UserService userService;
	
	private static final Scanner reader = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Welcome to Tweeter");
		Scanner reader = new Scanner(System.in);
		System.out.println("PLease, select an option");
		
		while (true) {
			printAll();
			int option = reader.nextInt();
			reader.nextLine();
			
			switch (option) {
				case 0: {
					banner("Exiting... 👋");
					System.exit(0);
				}
				case 1: {
					registerNewUser();
					break;
				}
				case 2: {
					deleteUser();
					break;
				}
				case 3: {
					findUserById();
					break;
				}
				case 4: {
					findUserByUsername();
					break;
				}
				case 5: {
					findAllUsers();
					break;
				}
				case 6: {
					createNewTweet();
					break;
				}
				case 7: {
					deleteTweet();
					break;
				}
				case 8: {
					findTweet();
					break;
				}
				case 9: {
					findAllTweets();
					break;
				}
				case 10: {
					findAllTweetsByUserId();
					break;
				}
				case 11: {
					findAllTweetsByUsername();
					break;
				}
				default:
					System.err.printf("Unsupported operation: %s%n%n");
					break;
			}
		}
	}

	// =========================================================================

	private static void printTweet(Tweet tweet) {
		User author = userService.find ;
		System.out.printf("%s%n\tOn %s, @%s tweeted: %s%n", tweet.getId(), author.getUsername(),
			tweet.getText());
	}

	private static void printUser(User user) {
		System.out.println("@" + user.getUsername());
		System.out.println("  ID:            " + user.getId());
		System.out.println("  Name:          " + user.getFirstName() + " " + user.getLastName());
		System.out.println("  Member since:  " + user.getDateCreated().toLocalDate());
		System.out.println("  Tweets:        ");
		user.getTweets().forEach(TwitterApp::printTweet);
	}

	private static void findAllUsers() {
		banner("Users");
		System.out.println();

		List<User> users = userService.findAllUsers();
		if (users.isEmpty()) {
			System.out.println("No Tweeters!");
		}
		else {
			users.forEach(TwitterApp::printUser);
		}
	}

	private static void registerNewUser() {
		banner("Register New User");

		prompt("First Name");
		String firstName = scanner.nextLine();

		prompt("Last Name");
		String lastName = scanner.nextLine();

		prompt("Email Address");
		String email = scanner.nextLine();

		prompt("Username");
		String username = scanner.nextLine();

		prompt("Password");
		String password = scanner.nextLine();

		User user = new User(firstName, lastName, email, username, password);
		userService.registerNewUser(user);
	}

	private static void findUserById() {
		banner("Find User By ID");

		prompt("User ID");
		String id = scanner.nextLine();

		System.out.println();
		User user = userService.findUserById(id);
		if (user == null) {
			System.err.println("Could not find user with ID: " + id);
		}
		else {
			printUser(user);
		}
	}

	private static void findUserByUsername() {
		banner("Find User By Username");

		prompt("User Username");
		String username = scanner.nextLine();

		System.out.println();
		User user = userService.findUserByUsername(username);
		if (user == null) {
			System.err.println("Could not find user with username: " + username);
		}
		else {
			printUser(user);
		}
	}

	private static void deleteUser() {
		banner("Delete User");

		prompt("User ID");
		String id = scanner.nextLine();

		userService.deleteUser(id);

		// We assume the user got deleted, but we don't
		// actually know if the operation succeeded.
		// For example, if there is no such user, the
		// UserService doesn't inform us of that. :(
		System.out.println("Deleted user with ID: " + id);
	}

	private static void createNewTweet() {
		banner("New Tweet");

		prompt("User ID");
		String id = scanner.nextLine();
		User author = userService.findUserById(id);

		if (author == null) {
			System.err.println("Could not find user with ID: " + id);
		}
		else {
			prompt("Tweet");
			String text = scanner.nextLine();
			Tweet tweet = new Tweet(author, text);
			author.addTweet(tweet);
			tweetService.saveTweet(tweet);

			printUser(author);
		}
	}

	private static void deleteTweet() {
		banner("Delete Tweet");

		prompt("Tweet ID");
		String id = scanner.nextLine();

		tweetService.deleteTweet(id);

		// We assume the tweet got deleted, but we don't
		// actually know if the operation succeeded.
		// For example, if there is no such tweet, the
		// TweetService doesn't inform us of that. :(
		System.out.println("Deleted tweet with ID: " + id);
	}

	private static void findTweet() {
		banner("Find Tweet");

		prompt("Tweet ID");
		String id = scanner.nextLine();

		System.out.println();
		Tweet tweet = tweetService.findTweet(id);
		if (tweet == null) {
			System.err.println("Could not find tweet with ID: " + id);
		}
		else {
			printTweet(tweet);
		}
	}

	private static void findAllTweets() {
		banner("Tweets");
		System.out.println();

		List<Tweet> tweets = tweetService.findAllTweets();
		if (tweets.isEmpty()) {
			System.out.println("No Tweets!");
		}
		else {
			tweets.forEach(TwitterApp::printTweet);
		}
	}

	private static void findAllTweetsByUserId() {
		banner("Tweets by User ID");
		System.out.println();

		prompt("User ID");
		String id = scanner.nextLine();

		List<Tweet> tweets = tweetService.findAllTweetsByUserId(id);
		if (tweets.isEmpty()) {
			System.out.println("No tweets for user with ID: " + id);
		}
		else {
			tweets.forEach(TwitterApp::printTweet);
		}
	}

	private static void findAllTweetsByUsername() {
		banner("Tweets by Username");
		System.out.println();

		prompt("Username");
		String username = scanner.nextLine();

		List<Tweet> tweets = tweetService.findAllTweetsByUsername(username);
		if (tweets.isEmpty()) {
			System.out.println("No tweets for @" + username);
		}
		else {
			tweets.forEach(TwitterApp::printTweet);
		}
	}

	private static void printAll (){
		System.out.println("0- Exit");
		System.out.println("1- Create a new user");
		System.out.println("2- Delete user");
		System.out.println("3- Find user by id");
		System.out.println("4- Find user by username");
		System.out.println("5- Find all users");
		System.out.println("6- Create a new Tweet");
		System.out.println("7- Delete one tweet");
		System.out.println("8- Find one tweet");
		System.out.println("9- Find all tweets");
		System.out.println("10- Find all tweets by user id");
		System.out.println("11- Find all tweets by username");		
	}
	private static void banner(String header) {
		System.out.println();
		System.out.println("=================================================");
		System.out.println("=== " + header);
		System.out.println("=================================================");
	}

}
