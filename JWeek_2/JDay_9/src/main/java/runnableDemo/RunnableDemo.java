package runnableDemo;

public class RunnableDemo {
	
	
	public static void main(String[] args) {
		
		new Thread( new Runnable(){
			@Override
			public void run(){
				System.out.println("po1");
			}
		}).start();
		
		new Thread(()-> {
			System.out.println("po2");
		}).start();
		
		
		new Thread(()-> System.out.println("po3")).start();
		
		
	}

}
