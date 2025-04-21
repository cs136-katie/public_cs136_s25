public class HashCodePlay{

	// Pick a "large" prime
	public static int M=97; 

	//  Since our goal is an array index, not a 32-bit integer, we
	//  combine hashCode() with modular hashing in our implementations to produce integers between 0 and M-1 as follows
	public static int hash(String key) {
	   return (key.hashCode() & 0x7fffffff) % M;
	}

	// Method that replicates how Java makes a hashCode for a String
	public static int ourStringHash(String s){
		int R = 31; // Java chooses R as this small prime 

		int hash = 0;
		for (int i = 0; i < s.length(); i++)
		    hash = R * hash + s.charAt(i);
		return hash; 
	}

	public static void main(String[] args){
		String string1 = "Blah";
		System.out.println(string1);  
		System.out.println(string1.charAt(0)); 
		System.out.println(string1.charAt(0)+0); // The ASCII decimal, see https://www.cs.cmu.edu/~pattis/15-1XX/common/handouts/ascii.html 
		System.out.println("Built-in Java hash code of "+string1+" ="+string1.hashCode()); 
		System.out.println("Our hash code of "+string1+" ="+ourStringHash(string1)); 
		System.out.println("Converts to "+hash(string1)+" when M="+M);
		System.out.println("");


		String b = "dogs!";
		System.out.println(b);  
		System.out.println("Built-in Java hash code of "+b+" ="+b.hashCode()); 
		System.out.println("Our hash code of "+b+" ="+ourStringHash(b)); 
		System.out.println("Converts to "+hash(b)+" when M="+M);
		System.out.println(""); 
	}

}