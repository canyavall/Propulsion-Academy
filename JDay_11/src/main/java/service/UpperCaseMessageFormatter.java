package service;

class UpperCaseMessageFormatter implements MessageFormatter {

	@Override
	public String format(String message) {
		return message.toUpperCase();
	}

}