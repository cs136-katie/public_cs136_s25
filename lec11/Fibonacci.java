public class Fibonacci{	

	// Dynamic programming versin of Fibonacci stores 
	// intermediate compuations
	private static int[] fibCache = new int[100]; 	

	// O(n)
	public static int topDownFibonacci(int n){
		if(n <=1){
			return n; 
		}

		// Second base case 
		if(fibCache[n] > 0){
			return fibCache[n]; 
		}

		// Recursive 
		fibCache[n] = topDownFibonacci(n-1) + topDownFibonacci(n-2); 
		return fibCache[n]; 
	}

	// O(2^n)
	public static int fibonacci(int n) {
	    if (n <= 1) {
	        return n;
	    } else {
	        return fibonacci(n - 1) + fibonacci(n - 2);
	    }
	}

	public static void main(String[] args){

		int n = 5; 
		// int nthNumber = fibonacci(n); 
		int nthNumber = topDownFibonacci(n);

		System.out.println("The "+n+"th number is: "+nthNumber);  
	}

}