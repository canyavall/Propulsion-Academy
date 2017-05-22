package service;

public interface MessageFormatter {

	/**
	 * Formats the supplied message and returns it.
	 *
	 * <p>The default implementation returns the supplied message unmodified.
	 */
	default String format(String message) {
		return message;
	}

}