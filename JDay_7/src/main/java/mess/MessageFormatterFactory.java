package mess;

public class MessageFormatterFactory {

	public static MessageFormatter createConsoleFormatter(){
		return new ConsoleMessageFormatter();		
	}
	
	public static MessageFormatter createHtmlFormatter(){
		return new HtmlMessageFormatter();		
	}
}
