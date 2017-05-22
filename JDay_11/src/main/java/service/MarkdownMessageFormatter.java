package service;

class MarkdownMessageFormatter implements MessageFormatter {

	@Override
	public String format(String message) {
		return "**" + message + "**";
	}

}