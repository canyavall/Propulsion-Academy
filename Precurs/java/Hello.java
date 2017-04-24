//We need to pass the arguments, if we don't pass them, we show the user unknown
public class Hello {
	public static void main(String[] args) {
		int argsLength = args.length;
		if (argsLength > 0){
			for (int i = 0; i < argsLength; i++) {
				System.out.println("Hello," + args[i] +"!");
			}
		}else{
			System.out.println("Hello, Unknown!");
		}
	}
}