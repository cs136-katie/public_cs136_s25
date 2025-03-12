package ourqueue; 

public class QueueWithArrays<Item> implements Queue<Item>{

	private static final int INIT_CAPACITY = 8;
    private static final int GROWTH_FACTOR = 2; 

	private Item[] q;       // queue elements
    private int n;          // number of elements on queue
    private int head;      // index of head element of queue
    private int tail;       // index of next available slot

    public QueueWithArrays() {
        q = (Item[]) new Object[INIT_CAPACITY];
        n = 0;
        head = 0;
        tail = 0;
    }

    /**
     * Is this queue empty?
     * @return true if this queue is empty; false otherwise
     */
    public boolean isEmpty() {
        return n == 0;
    }

    /**
     * Returns the number of items in this queue.
     * @return the number of items in this queue
     */
    public int size() {
        return n;
    }

  	// resize the underlying array
    private void resize(int capacity) {
        Item[] copy = (Item[]) new Object[capacity];
        for (int i = 0; i < n; i++) {
            copy[i] = q[(head + i) % q.length];
        }
        q = copy;
        head = 0;
        tail  = n;
    }

    /**
     * Adds the item to this queue.
     * @param item the item to add
     */
    public void enqueue(Item item) {
        // double size of array if necessary and recopy to front of array
        if (n == q.length){
            resize(2*q.length); // double size of array if necessary
        }   
        q[tail++] = item;                        // add item
        if (tail == q.length) tail = 0;
        n++;
    }

    /**
     * Removes and returns the item on this queue that was least recently added.
     * @return the item on this queue that was least recently added
     */
    public Item dequeue() {
        Item item = q[head];
        n--;
        head++;
        if (head == q.length){
            head = 0;           // wrap-around
        }
        // shrink size of array if necessary
        if (n > 0 && n == q.length/4){
            resize(q.length/2);
        }
        return item;
    }

    /**
     * Returns the item least recently added to this queue.
     * @return the item least recently added to this queue
     */
    public Item peek() {
        if (isEmpty()){
        	System.out.println("No element!"); 
        	return null; 
        }
        return q[head];
    }

	public static void main(String[] args){
        // The TPS 
        int n = 5; 
        QueueWithArrays<Integer> q = new QueueWithArrays<Integer>(); 
        q.enqueue(0);
        q.enqueue(1);
        for (int i =0; i<=n; i++){
            int a = q.dequeue();
            int b = q.dequeue();
            q.enqueue(b);
            q.enqueue(a + b);
            System.out.println(a);
        }
    }
}