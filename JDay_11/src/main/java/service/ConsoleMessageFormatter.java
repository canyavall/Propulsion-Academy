package service;

class ConsoleMessageFormatter implements MessageFormatter {

	// Singleton: only one instance in the application.
	// public static final MessageFormatter INSTANCE = new ConsoleMessageFormatter();

	// private to enforce the Singleton pattern.
	// private ConsoleMessageFormatter() {
	// }

	@Override
	public String format(String message) {
		return message + "!";
	}

}
