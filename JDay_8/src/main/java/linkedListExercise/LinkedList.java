package linkedListExercise;

import stackExercise.Node;

public class LinkedList {

	private Node head;
	private Node last;
	
	public void push(String str){
		Node node = new Node(str);
		if (this.head == null){
			this.head = node;
			this.last = node;
		}else{
			this.last.setNext(node);
			this.last = node;
		}		
	}
	
//	public String pop(){
//		Node nodeCheck = this.head;
//		Node nodereturn = this.last;
//		boolean controller = true;
//		while (controller){
//			if (nodeCheck.getNext() == this.last){
//				nodeCheck.setNext(null);
//			}else{
//				controller = false;
//			}
//		}
//		return nodereturn.getData();
//	}
//	
//	public String peek(){
//		return this.last.getData();		
//	}
	
	public boolean contains(){
		return false;
		
	}
	
	public void flip(){
		
	}
	
	public int size(){
		boolean controller = true;
		int counter = 0;
		Node nodeCheck = this.head;
		while(controller){
			if (nodeCheck.getNext() != null){
				nodeCheck = nodeCheck.getNext();
			}else{
				controller = false;
			}
			counter++;
		}
		return counter;		
	}
	
	public boolean isEmpty(){
		if (size() == 0) return true;
		return false;
		
	}
	
	public String toString(){
		return null;
		
	}
}
