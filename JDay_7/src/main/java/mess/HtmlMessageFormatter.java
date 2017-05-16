package mess;

class HtmlMessageFormatter implements MessageFormatter {

	@Override
	public String format(String str) {		
		return "<strong>" + str + "</strong>";
	}

}
