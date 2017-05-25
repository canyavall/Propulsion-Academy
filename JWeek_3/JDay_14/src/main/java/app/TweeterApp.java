package app;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.TweeterAppConfig;
import domain.Tweet;
import domain.User;
import service.TweetService;
import service.UserService;

public class TweeterApp {
	

	private static TweetService tweetService;
	private static UserService userService;	
	private static final Scanner reader = new Scanner(System.in);

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		ApplicationContext context = new AnnotationConfigApplicationContext(TweeterAppConfig.class);

		userService = context.getBean(UserService.class);
		tweetService = context.getBean(TweetService.class);
		
		
		System.out.println("Welcome to Tweeter");
		@SuppressWarnings("resource")
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
		User author = userService.findUserById(tweet.getAuthor()) ;
		System.out.printf("%s%n\tOn %s, @%s tweeted: %s%n", tweet.getId(), author.getUsername(),
			tweet.getText());
	}

	private static void printUser(User user) {
		System.out.println("@" + user.getUsername());
		System.out.println("  ID:            " + user.getId());
		System.out.println("  Name:          " + user.getName() + " " + user.getSurname());
		System.out.println("  Tweets:        ");
		List<Tweet> tweets = tweetService.findAllTweetsByUserId(user.getId());
		tweets.forEach(TweeterApp::printTweet);
	}

	private static void findAllUsers() {
		banner("Users");
		System.out.println();

		List<User> users = userService.findAllUsers();
		if (users.isEmpty()) {
			System.out.println("No Tweeters!");
		}
		else {
			users.forEach(TweeterApp::printUser);
		}
	}

	private static void registerNewUser() {
		banner("Register New User");

		prompt("First Name");
		String firstName = reader.nextLine();

		prompt("Last Name");
		String lastName = reader.nextLine();

		prompt("Email Address");
		String email = reader.nextLine();

		prompt("Username");
		String username = reader.nextLine();

		prompt("Password");
		String password = reader.nextLine();

		User user = new User(firstName, lastName, email, username, password);
		userService.registerNewUser(user);
	}

	private static void findUserById() {
		banner("Find User By ID");

		prompt("User ID");
		int id = reader.nextInt();

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
		String username = reader.nextLine();

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
		int id = reader.nextInt();

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
		int id = reader.nextInt();
		User author = userService.findUserById(id);

		if (author == null) {
			System.err.println("Could not find user with ID: " + id);
		}
		else {
			prompt("Tweet");
			String text = reader.nextLine();
			Tweet tweet = new Tweet(author.getId(), text);
			tweetService.saveTweet(tweet);

			printUser(author);
		}
	}

	private static void deleteTweet() {
		banner("Delete Tweet");

		prompt("Tweet ID");
		int id = reader.nextInt();

		tweetService.deleteTweet(id);

		System.out.println("Deleted tweet with ID: " + id);
	}

	private static void findTweet() {
		banner("Find Tweet");

		prompt("Tweet ID");
		int id = reader.nextInt();

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
			tweets.forEach(TweeterApp::printTweet);
		}
	}

	private static void findAllTweetsByUserId() {
		banner("Tweets by User ID");
		System.out.println();

		prompt("User ID");
		int id = reader.nextInt();

		List<Tweet> tweets = tweetService.findAllTweetsByUserId(id);
		if (tweets.isEmpty()) {
			System.out.println("No tweets for user with ID: " + id);
		}
		else {
			tweets.forEach(TweeterApp::printTweet);
		}
	}

	private static void findAllTweetsByUsername() {
		banner("Tweets by Username");
		System.out.println();

		prompt("Username");
		String username = reader.nextLine();
		User user = userService.findUserByUsername(username);

		List<Tweet> tweets = tweetService.findAllTweetsByUserId(user.getId());
		if (tweets.isEmpty()) {
			System.out.println("No tweets for @" + username);
		}
		else {
			tweets.forEach(TweeterApp::printTweet);
		}
	}
	
	private static void prompt(String label) {
		System.out.printf("%nEnter %s: ", label);
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
