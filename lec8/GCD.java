public class GCD{

	// Euclid's algorithm, recursively
	public static int recursiveGcd(int p, int q){

		if (q == 0){
			return p; 
		}

		return recursiveGcd(q, p%q); 

	}

	public static void main(String[] args){
		// Testing 
		int p = 1071; 
		int q = 462;

		// // GCD of two primes should be 1 
		// int p = 17; 
		// int q = 7;

		System.out.println(recursiveGcd(p, q)); 
	}

}