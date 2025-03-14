package zoostuff;

public class Zoo{

	public Animal[] animals; 
	public int count; 


	public Zoo(int capacity){
		this.count = 0; 
		this.animals = new Animal[capacity]; 
	}

	public void addAnimal(Animal animal){

		if(this.count < animals.length){
			animals[count] = animal;
			count ++ ;
			System.out.println(animal.toString()+" added to the zoo.");
		}

		else{
			System.out.println("Zoo full!!"); 
		}

	}
}