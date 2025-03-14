public class LinkedList{

	public Node first;
	private int size;  

	public LinkedList(){
		this.first = null; 
	}

	private class Node{
		private String data;    // Dropping generics, just Strings
		private Node next;    
		
		private Node(){
			this.data = null; 
			this.next = null; 
		}
	}

	private void insertBeginning(String item){
		Node oldFirst = first; 
		first = new Node(); 
		first.data = item;
		first.next = oldFirst;
		size ++;   
	}

	public void add(String item){
		insertBeginning(item); 
	}

	
	public String toString(){
		String out = ""; 
		for(Node x = first; x!=null; x = x.next){
    		out += x.data + " "; 
		}
		return out;
	}

	// Method to find the nth node from the last of a linked list
    public String findNthFromLast(int n) {
    	if(size < n){
    		return null; 
    	}
    	Node current = first; 
    	for(int i=0; i < size-n; i++){
    		current = current.next; 
    	}
    	return current.data; 
    }

    // Method to reverse a list (in place)
	public void reverseList(){
       Node prev = null; 
       Node current = first; 
       Node next = null; 
       while(current != null){
       	next = current.next; 
       	current.next = prev; 

       	prev = current; 
       	current = next; 
       }
       this.first = prev; 
    }

	// Main for testing 
	public static void main(String[] args){
		LinkedList ll = new LinkedList(); 

		ll.add("A"); 
		ll.add("B"); 
		ll.add("C"); 
		ll.add("D"); 
		System.out.println(ll.toString());


		//Nth
		String nthBack = ll.findNthFromLast(1); 
		System.out.println(); 
		System.out.println(nthBack);

		System.out.println(); 
		ll.reverseList();
		System.out.println(ll.toString());
	}
}