package Tweeter;


import java.util.Scanner;

public class TweetApp {

	public static void main(String[] args) {
		TweetService database = new TweetService();
		@SuppressWarnings("resource")
		Scanner reader = new Scanner(System.in);
		System.out.println("Welcome to Tweeter.");
		while(true){	
			System.out.println("Choose one option.");
			System.out.println("1- Create Tweet.");
			System.out.println("2- Print Tweets.");
			System.out.println("0- FInish.");
			//Check it-s a number
			if (!reader.hasNextInt()) {
		        System.out.println("That's not a number!");
		        reader.next(); // this is important!
		    }
			int Option = reader.nextInt();
			reader.nextLine();
			if (Option == 0) {
				System.out.println("Thank you for using Tweeter!");
				break;
			}else if (Option == 1){
				System.out.println("Please, write the text for the tweet");
				String text = reader.next();
				reader.nextLine();
				Tweet tweet = new Tweet(text);
				database.save(tweet);
				System.out.println("Tweet created!");
			}else if (Option == 2){
				System.out.println("This is the tweeter list!");
				database.printAll();
			}else{
				System.out.println("The option selected doesn't exist");
			}
			

			
		}
	}
}
