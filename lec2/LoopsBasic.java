public class LoopsBasic{

	//Print n successive powers of 2 
	public static void forPowers2(int n){

		int power = 1; 

		for(int i =0; i<n; i++){
			System.out.println("2^"+i+": "+power); 
			power = 2*power; 
		}

	}  

	public static void main(String[] args){
		forPowers2(100); 
	}
}