package list; 

public class LinkedList<T> implements OurListInterface<T>{

	public Node first; // Instance variable of the outer class 
					   // stores a reference to the first node in the LinkedList 

	// Constructor 
	public LinkedList(){
		this.first = null; 
	}

	// Inner Class: Node 
	private class Node{
		private T data;    // Stores the data
		private Node next; // Reference to the next node in the linked list 

		// Constructor for the inner node 
		private Node(){
			this.data = null; 
			this.next = null; 
		}
	}

	/**
	 * @param item The string to be inserted at the beginning of the linked list 
	 */
	private void insertBeginning(T item){
		Node oldFirst = first; 
		first = new Node(); 
		first.data = item;
		first.next = oldFirst;  
	}

	/**
	 * Removes the first node of the linked list 
	 */
	private void removeFirst(){
		first = first.next; 
	}

	/**
	 * @param item is the item to be added to the very end of the linked list 
	 */
	private void addToEnd(T item){
		if(first == null){
			first = new Node(); 
			first.data = item; 
		}
		else{
		// 1. Traverse through the LinkedList to get the last node 
			Node x = first;
			while (x.next != null) {
			    x = x.next;
			}

		// 2. Add the new node at the very end of the LinkedList
			Node newNode = new Node(); 
			newNode.data = item; 
			x.next = newNode; 
		} 
	}

	/**
	 * Traverse through the LinkedList and gather the strings at each
	 * node in order 
	 */
	public String toString(){
		String out = ""; 
		for(Node x = first; x!=null; x = x.next){
    		out += x.data.toString() + " "; 
		}
		return out;
	}

	// Our choice: we're putting it at the beginning
	public void add(T element){
		this.insertBeginning(element); 
	}


	// Main for testing 
	public static void main(String[] args){
		LinkedList<String> ll = new LinkedList<String>(); 

		ll.add("be"); 
		ll.add("to"); 
		System.out.println(ll.toString()); 
	}
}