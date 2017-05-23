import java.util.Random;
import java.util.Scanner;

public class numberGuess {

	public static void main(String[] args) {
		Random randomGenerator = new Random(System.currentTimeMillis());
		int randomNumber = randomGenerator.nextInt(10) + 1;
		System.out.println("I'm thinking of a random number from 1 to 10.");
		Scanner reader = new Scanner(System.in);
		System.out.println("Guess what it is: ");
		int counter = 0;
		while(true){	        
			int userNumber = reader.nextInt();
			reader.nextLine();
			counter++;
			if (userNumber > randomNumber){
				System.out.println("Nope. It's lower than that. Try again.");
			}
			if (userNumber < randomNumber){
				System.out.println("Nope. It's higher than that. Try again.");
			}
			if (userNumber == randomNumber){
				break;			
			}
		}
		System.out.println("Congratulations, You guessed it in " + counter +" tries.");		
	}

}
