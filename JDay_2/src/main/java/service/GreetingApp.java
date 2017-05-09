package service;

import java.util.Scanner;

public class GreetingApp {

	public static void main(String[] args) {
		MessageService msg = new EnglishMessageService();
		
		@SuppressWarnings("resource")
		Scanner reader = new Scanner(System.in);
		System.out.println("what's your name?");
		String name = reader.nextLine();
		System.out.print(msg.generateMessage(name));
	}

}
