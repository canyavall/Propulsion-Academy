package linkedListExercise;

import stackExercise.Node;

public class LinkedList<T> {

	private Node<T> head;
	private Node<T> last;
	private int size = 0;
	
	public void add(T obj){
		Node<T> node = new Node<>(obj);
		if (this.head == null){
			this.head = node;
			this.last = node;
		}else{
			this.last.setNext(node);
			this.last = node;
		}	
		this.size++;
	}
	
	public T getFirst(){
		return (this.head == null) ? null : this.head.getData();		
	}
	
	public T pop(){
		Node<T> nodeCheck = this.head;
		Node<T> nodereturn = this.last;
		boolean controller = true;
		while (controller){
			if (nodeCheck.getNext() == this.last){
				nodeCheck.setNext(null);
			}else{
				controller = false;
			}
		}
		return nodereturn.getData();
	}
	
	public T peek(){
		return this.last.getData();		
	}
	
	public boolean contains(){
		return false;
		
	}
	
	public void flip(){
		
	}
	
	public int size(){
			return this.size;
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
