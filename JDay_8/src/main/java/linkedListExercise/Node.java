package linkedListExercise;

public class Node {
	private String data;
	private int next;
	
	public Node (String data, int next){
		this.data = data;
		this.next = next;
	}

	public String getData() {
		return data;
	}

	public int getNext() {
		return next;
	}
	
}
