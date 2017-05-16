package mess;

class ConsoleMessageFormatter implements MessageFormatter {

	@Override
	public String format(String str) {
		return str + "!";
	}

}
