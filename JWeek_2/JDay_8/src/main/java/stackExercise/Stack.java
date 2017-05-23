package stackExercise;

public class Stack<T> {
	private Node<T> head;
	private int size = 0;
	
	public void push(T obj){
		Node<T> node = new Node<>(obj);
		if (this.head != null) node.setNext(this.head);
		this.head = node;
		this.size++;
	}
	
	public T pop(){
		Node<T> nodeReturn = this.head;
		this.head = nodeReturn.getNext();
		return nodeReturn.getData();
	}
	
	public T peek(){
		return (this.head == null) ? null : this.head.getData();
	}
	
	public boolean contains(T obj){
		Node<T> nodeCheck = this.head;
		while(nodeCheck != null){			
			if (nodeCheck.getData().equals(obj)) return true;
			nodeCheck = nodeCheck.getNext();
		}
		return false;
		
	}
	
	public void flip(){
		if (this.head == null)	return;

		int controller = 0;
		Node<T> newNode = null;
		Node<T> nextNode = this.head.getNext();
		while(controller < this.size){
			this.head.setNext(newNode);			
			newNode = this.head;
			this.head = nextNode;
			if (this.head.getNext() != null) nextNode = this.head.getNext();
			controller++;
		}
	}
	
	public int size(){		
		return size;		
	}
	
	public boolean isEmpty(){
		if (size() == 0) return true;
		return false;
		
	}
	
	public String toString(){
		String str = "";
		Node<T> nodeCheck = this.head;
		while(nodeCheck != null){
			str += nodeCheck.getData();
			if (nodeCheck.getNext() != null) str += ", ";
			nodeCheck = nodeCheck.getNext();
		}
		return str;		
	}
	
}
