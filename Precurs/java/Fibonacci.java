//Create class
class Fibonacci {
	//We need to use a recursive function
	static int fibonacci(int n) {
		if (n == 0){
			return 0;
		}else if (n ==1){
			return 1;
		}else{
			return fibonacci(n-1) + fibonacci(n-2);
		}
	}

	public static void main(String[] args) {
		//check the number of parameters parsed
		int argsLength = args.length;
		if (argsLength > 0){
			for (int i = 0; i < argsLength; i++) {
				//Change string to int and apply function
				int fibonacciNumber = Integer.parseInt(args[i]);
				System.out.println(fibonacci(fibonacciNumber));
			}
		}else{
			//The bonus question
			//The system.out is buffered, it means can be reused from memory
			//but the system.error can be saved in a file if we want it
			//to check the errors on execution
			System.out.println("Error: you must supply which Fibonacci number to compute");
			System.exit(1);
		}

	}
}