package fibonacci;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

class Fibonacci {
	
	private static final Logger logger = LogManager.getLogger(Fibonacci.class);
	
	//We need to use a recursive function
	static int fibonacci(int n) {

			if (n == 0){
				return 0;
			}else if (n == 1){
				return 1;
			}else{
				return fibonacci(n-1) + fibonacci(n-2);
			}


	}

	public static void main(String[] args) {
		logger.info("My first log message!");
		//check the number of parameters parsed
		int argsLength = args.length;
		if (argsLength > 0){
			for (int i = 0; i < argsLength; i++) {
				int fibonacciNumber = Integer.parseInt(args[i]);
				System.out.println(fibonacci(fibonacciNumber));
			}
		}else{
			logger.warn("Something went wrong in position 2");
		}
	}
}