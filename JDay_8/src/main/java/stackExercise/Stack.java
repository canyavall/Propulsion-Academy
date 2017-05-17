package stackExercise;

public class Stack<T> {
	private Node<T> head;
	private int size = 0;
	
	public void push(T obj){
		Node<T> node = new Node<>(obj);
		if (this.head == null){
			this.head = node;
		}else{
			node.setNext(this.head);
			this.head = node;
		}
		this.size++;
	}
	
	public T pop(){
		Node<T> nodeReturn = this.head;
		this.head = nodeReturn.getNext();
		return nodeReturn.getData();
	}
	
	public T peek(){
		return this.head.getData();		
	}
	
	public boolean contains(String str){
		int controller = 1;
		Node<T> nodeCheck = this.head;
		while(controller <= this.size){			
			if (nodeCheck.getData().equals(str)) return true;
			nodeCheck = nodeCheck.getNext();
			controller++;
		}
		return false;
		
	}
	
	public void flip(){
		int controller = 1;
		Node<T> previousNode = null;
		Node<T> nextNode = null;
		Node<T> nodeCheck = this.head;
		while(controller <= this.size){
			nextNode = nodeCheck.getNext();
			nodeCheck.setNext(previousNode);
			previousNode = nodeCheck;
			nodeCheck = nextNode;			
			controller++;
		}
		this.head = nodeCheck;
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
		int controller = 1;
		Node<T> nodeCheck = this.head;
		while(controller <= this.size){
			str += nodeCheck.getData();
			if (controller < this.size) str += ", ";
			nodeCheck = nodeCheck.getNext();
			controller++;
		}
		return str;
		
	}
	
}
