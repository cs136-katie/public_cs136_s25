package zoostuff; 

class FastCat extends Animal{

	public double maxSpeed; //MPH

	public FastCat(String name, String species, double maxSpeed){
		super(name, species); 
		this.maxSpeed = maxSpeed; 
	}

	@Override
	public String toString(){
		return this.name + " the "+ this.species + " is super fast, "+ this.maxSpeed +"max MPH!"; 
	}

	public static void main(String[] args){
		FastCat cheetah = new FastCat("Claire", "Cheetah", 70.0); 
		System.out.println(cheetah); 

	}


}