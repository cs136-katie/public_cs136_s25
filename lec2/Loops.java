public class Loops{

	// Prints n successive powers of 2 
	public static void forPowers2(int n){
		int power=1; 
		for (int i = 0; i <n; i++){
			System.out.println(i + " "+ power); 
			power = 2 * power; 
		}
	}

	// Prints a factorial 
	public static void factorial(int n){
		int product = 1;
		for (int i =1; i <= n; i++){
		    product *= i;
		}
		System.out.println(product);
	}

	// Print powers of 2 that are less than n 
	public static void whilePowers2(int n){
		int power = 1; 
		while (power <= n/2){
			power = 2*power; 
			System.out.println(power); 
		}
	}

	// Prints powers of 2 less than 10 
	public static void breakExample(){
		int power = 1;
		while(power <= 1000000){
			power = 2*power; 

			if(power > 10){
				break; 
			}
			System.out.println(power); 
		}
		System.out.println("Final="+power);
	}

	/*
		"Wonky" factorial 
		Only increment for every other integer
		Example 1*3*5 or 1*3*5*7
	*/
	public static void continueExample(){
		int n = 10; 
		int product = 1; 
		for(int i=0; i <= n; i++){
			if(i%2 == 0){
				continue; 
			}
			product *= i; 
			System.out.println(product); 
		}
	}

	public static void main(String[] args){
		//forPowers2(5); 
		//factorial(4);
		//System.out.println();  
		//whilePowers2(10); 
		//breakExample(); 
		continueExample(); 
	}
}