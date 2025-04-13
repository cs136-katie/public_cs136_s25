package tables; 

import java.util.Comparator;

public class LinkedListST<Key, Value> implements SymbolTable<Key, Value>{
	
	private int numPairs;      // number of key-value pairs
    private Node first;        // first node in linked list 

    // Node with both keys and values 
    private class Node {
        private Key key;
        private Value val;
        private Node next;

        private Node()  {
            this.key  = null;
            this.val  = null;
            this.next = null;
        }
    }

    // Constructor 
    public LinkedListST() {
    	this.numPairs = 0; 
    	this.first = null; 
    }

    public int size() {
        return numPairs;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    /* Inserts the key-value pair into the table
     * The comparator is used to compare keys 
     * Convention: If key already exists, overwrites with new val */
    public void put(Key key, Value val, Comparator<Key> comparator){
        if (key == null){
            System.out.println("Bad key"); 
            return;
        }

        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                x.val = val;
                return;
            }
        }
        Node oldFirst = first; 
        first = new Node();
        first.key = key; 
        first.val = val; 
        first.next = oldFirst; 
        numPairs++;
    }


    /* “Search”!
     * Returns the value paired with the key
     * Returns null if the key is not in the table  */
    public Value get(Key key, Comparator<Key> comparator){
        // Keys cannot be null 
        if (key == null){
            System.out.println("ERROR! Key cannot be null"); 
            return null; 
        }

        // Traverse to find the key (if it exists)
        for (Node x = first; x != null; x = x.next) {
            if (comparator.compare(key, x.key) == 0){
                return x.val;
            }
        }
        // If the key doesn not exist, return null; 
        return null;
    }

    public static void main(String[] args){
        LinkedListST<String, Integer> goldMedals = new  LinkedListST<String, Integer>(); 
        
        // Test put 
        StringComparator comp = new StringComparator();
        goldMedals.put("USA", 40, comp); 
        goldMedals.put("China", 40, comp); 
        goldMedals.put("Japan", 20, comp); 
        goldMedals.put("Saint Lucia", 1, comp); 

        // Test get 
        System.out.println("USA won "+goldMedals.get("USA", comp)+ " gold medals in 2024"); 

        // Test put overriding a key 
        System.out.println("Saint Lucia won another medal!"); 
        int prevMedals = goldMedals.get("Saint Lucia", comp); 
        goldMedals.put("Saint Lucia", prevMedals +1, comp);
    }

}

class StringComparator implements Comparator<String> {

    public int compare(String s1, String s2) {
        return s1.compareTo(s2);
    }
}