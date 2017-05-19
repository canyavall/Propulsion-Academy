package lastExercise;

import org.apache.logging.log4j.Logger;

public class LazyLoggingDemo {

		private static Logger log;
		public static void main(String[] args) {
			int x = 2;
			log.trace("This is a tracer");
			log.debug("I am logging that {} happened.", () -> x == 0);
		}
}
