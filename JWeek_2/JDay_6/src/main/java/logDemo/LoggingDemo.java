package logDemo;

// import java.util.logging.Level;
// import java.util.logging.Logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggingDemo {

	// JUL:
	// private static final Logger logger = Logger.getLogger(LoggingDemo.class.getName());

	// Log4J:
	private static final Logger logger = LogManager.getLogger(LoggingDemo.class);

	public static void main(String[] args) {
		logger.info("My first log message!");

		try {
			logger.debug("Trying before blowing up...");
			blowUp();
		}
		catch (Exception ex) {
			logger.warn("Something went wrong", ex);
		}

	}

	private static void blowUp() {
		throw new RuntimeException("Boom!");
	}

}