package runnableExercise;

public class RunnableDemo {
	
	
	public static void main(String[] args) {
		
		//External runnable thread
		new Thread(new MyRunnable()).start();
		
		//Inner class runnable thread
		new Thread(new InnerRun()).start();
		
		//Lambda expression
		new Thread(()-> System.out.println("I’m running in a different thread: " + Thread.currentThread().getName())).start();
		
		//Block lambda expression
		new Thread(()-> {
			System.out.println("I’m running in a different thread: " + Thread.currentThread().getName());
			}).start();
		
	}

	public static class InnerRun implements Runnable{

		@Override
		public void run() {
			System.out.println("I’m running in a different thread: " + Thread.currentThread().getName());		
		}

	}
}

