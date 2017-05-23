package linkedListExercise;

import stackExercise.Node;

public class LinkedList<T> {

	private Node<T> head;
	private Node<T> last;
	private int size = 0;
	
	/**
	 * Add a new object into the linked list ater the last position
	 * @param obj
	 */
	public void add(T obj){
		Node<T> node = new Node<>(obj);
		if (this.head == null){
			this.head = node;
		}else{
			this.last.setNext(node);			
		}
		this.last = node;
		this.size++;
	}
	
	/**
	 * Add in front of the list
	 * @param obj
	 */
	public void addToFront(T obj){
		Node<T> nextNode = this.head;
		this.head = new Node<>(obj);
		this.head.setNext(nextNode);
	}
	
	/**
	 * Remove the first object of the list
	 * @return
	 */
	public T remove(){
		if (this.head == null)return null;
		Node<T> returnNode = this.head;		
		this.head = this.head.getNext();
		return returnNode.getData();
	}
	
	/**
	 * Remove the last one I'M HERE!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	 * @return
	 */
	public T removeLast(){
		if (this.last == null)return null;
		
		return this.last.getData();		
	}
	
	/**
	 * Get the head
	 * @return
	 */
	public T getFirst(){
		return (this.head == null) ? null : this.head.getData();		
	}
	
	
	/**
	 * Get the last
	 * @return
	 */
	public T getLast(){
		return (this.head == null) ? null : this.last.getData();		
	}
	
	/**
	 * Check if any object in the list contains the data requested
	 * @param obj
	 * @return
	 */
	public boolean contains(T obj){
		Node<T> nodeCheck = this.head;
		while(nodeCheck != null){			
			if (nodeCheck.getData().equals(obj)) return true;
			nodeCheck = nodeCheck.getNext();
		}
		return false;		
	}
	
	/**
	 * Return the size of the list
	 * @return
	 */
	public int size(){
			return this.size;
	}
	
	/**
	 * Check if it is empty
	 * @return
	 */
	public boolean isEmpty(){
		if (size() == 0) return true;
		return false;
		
	}
	
	/**
	 * Return the list of objects
	 */
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
