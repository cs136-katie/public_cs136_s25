package tables; 

import java.util.Comparator;

public interface SymbolTable<Key, Value>{

    /* Returns true if the table is empty */
    public abstract boolean isEmpty();

    /* Returns the number of keys */
    public abstract int size();

    /* Inserts the key-value pair into the table
     * The comparator is used to compare keys 
     * Convention: If key already exists, overwrites with new val */
    public abstract void put(Key key, Value val, Comparator<Key> comparator);

    /* “Search”!
     * Returns the value paired with the key
     * Returns null if the key is not in the table  */
    public abstract Value get(Key key, Comparator<Key> comparator);
}
