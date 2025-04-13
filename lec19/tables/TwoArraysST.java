package tables; 

import java.util.Comparator;

public class TwoArraysST<Key, Value> implements SymbolTable<Key, Value>{

	private static final int INIT_CAPACITY = 8;
    private Key[] keys;
    private Value[] vals;
    private int numPairs = 0;

    public TwoArraysST() {
        keys = (Key[]) new Object[INIT_CAPACITY];
        vals = (Value[]) new Object[INIT_CAPACITY];
    }

    /* Returns the number of keys */
    public int size(){
        return numPairs;
    }

    /* Returns true if the table is empty */
    public boolean isEmpty(){
    	return size() == 0;
    }


    private void resize(int capacity) {
        Key[]   tempk = (Key[])   new Object[capacity];
        Value[] tempv = (Value[]) new Object[capacity];
        for (int i = 0; i < numPairs; i++) {
            tempk[i] = keys[i];
            tempv[i] = vals[i];
        }
        vals = tempv;
        keys = tempk;
    }

    /* “Search”!
     * Returns the value paired with the key
     * Returns null if the key is not in the table  */
    public Value get(Key key, Comparator<Key> comparator){
        if (key == null){
            System.out.println("ERROR! Key cannot be null"); 
            return null; 
        }
        if (isEmpty()) return null;

        int i = rank(key, comparator);
        if (i < numPairs && comparator.compare(keys[i], key) == 0){
            return vals[i];
        }
        return null;
    }

    // Returns the num. of keys strictly less than target
	private int rank(Key target, Comparator<Key> comp) {
	    if (target == null){ return -1;} // invalid target

	    int lo = 0, hi = numPairs-1;
	    while (lo <= hi) {
	        int mid = lo + (hi - lo) / 2;
	        int cmp = comp.compare(target, keys[mid]);
	        if      (cmp < 0) hi = mid - 1;
	        else if (cmp > 0) lo = mid + 1;
	        else return mid;
	    }
	    return lo;
	}

    /* Inserts the key-value pair into the table
     * The comparator is used to compare keys 
     * Convention: If key already exists, overwrites with new val */
    public void put(Key key, Value val, Comparator<Key> comparator){
    	if (key == null){System.out.println("Bad key"); return;}

    	int i = rank(key, comparator);

    	// key is already in table
        if (i < numPairs && comparator.compare(keys[i], key) == 0) {
            vals[i] = val;
            return;
        }

        // else, insert new key-value pair
        
        // resize if need be 
        if (numPairs == keys.length){
        	resize(2*keys.length);
        }

        // make room for new pair by shifting larger items 
        for (int j = numPairs; j > i; j--)  {
            keys[j] = keys[j-1];
            vals[j] = vals[j-1];
        }
        keys[i] = key;
        vals[i] = val;
        numPairs++;
    }

    public static void main(String[] args){
        TwoArraysST<String, Integer> goldMedals = new  TwoArraysST<String, Integer>(); 
        
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