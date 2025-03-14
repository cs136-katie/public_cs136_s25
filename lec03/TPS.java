public class TPS{

	public static int negate(int diffentA){
		diffentA = -1 * diffentA;
		return diffentA;  
	}

	public static void main(String[] args){
		int a = 17; 
		System.out.println(a); 
		negate(a); 
		System.out.println(a); 
	}

}