package messNested;

public class MessageFormatterFactory {

	public static final DefaultMessageFormatter MSGCONSOLEFACTORY = new DefaultMessageFormatter();
	private static final MessageFormatterFactory fac = new MessageFormatterFactory();
	public static final MessageFormatterFactory.HtmlMessageFormatter MSGHTMLFACTORY = fac.new HtmlMessageFormatter();
	
	public static DefaultMessageFormatter createConsoleFormatter(){
		return MSGCONSOLEFACTORY;		
	}
	
	public static HtmlMessageFormatter createHtmlFormatter(){
		return MSGHTMLFACTORY;		
	}
	
	static class DefaultMessageFormatter {
		public String format(String str) {
			return str + "!";
		}
	}
	
	class HtmlMessageFormatter {
		public String format(String str) {		
			return "<strong>" + str + "</strong>";
		}	
	}


}
