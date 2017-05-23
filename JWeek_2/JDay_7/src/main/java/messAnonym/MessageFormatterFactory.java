package messAnonym;

public class MessageFormatterFactory {

	public static final MessageFormatter MSGCONSOLEFACTORY = new MessageFormatter(){
		public String format(String str) {
			return str + "!";
		}
	};
	private static final MessageFormatterFactory fac = new MessageFormatterFactory();
	public static final MessageFormatterFactory.HtmlMessageFormatter MSGHTMLFACTORY = fac.new HtmlMessageFormatter();
	
	public static MessageFormatter createConsoleFormatter(){
		return MSGCONSOLEFACTORY;		
	}
	
	public static HtmlMessageFormatter createHtmlFormatter(){
		return MSGHTMLFACTORY;		
	}
	

	
	class HtmlMessageFormatter {
		public String format(String str) {		
			return "<strong>" + str + "</strong>";
		}	
	}


}
