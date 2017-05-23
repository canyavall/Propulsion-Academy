package mess;

public class MessageFormatterFactory {

	public static final MessageFormatter MSGCONSOLEFACTORY = new ConsoleMessageFormatter();
	public static final MessageFormatter MSGHTMLFACTORY = new HtmlMessageFormatter();
	
	public static MessageFormatter createConsoleFormatter(){
		return MSGCONSOLEFACTORY;		
	}
	
	public static MessageFormatter createHtmlFormatter(){
		return MSGHTMLFACTORY;		
	}
}
