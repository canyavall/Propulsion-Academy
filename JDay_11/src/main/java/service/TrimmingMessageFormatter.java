package service;

class TrimmingMessageFormatter implements MessageFormatter {

	@Override
	public String format(String message) {
		return message.trim();
	}

}