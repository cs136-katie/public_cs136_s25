package zoostuff; 

import java.util.Arrays; 

public class Animal{

	public String name; 
	public final String species; 

	public Animal(String name, String species){
		this.name = name; 
		this.species = species; 
	}

	public String toString(){
		return this.name +" the "+ this.species + "!"; 
	}

	public static void main(String[] args){

		Animal leo = new Animal("Leo", "Lion");
		//System.out.println(leo); 

		Animal[] animalTracker = new Animal[3];

		animalTracker[0] = new Animal("Leo", "Lion");
		animalTracker[1] = new Animal("Manny", "Elephant");
		animalTracker[2] = new Animal("Stripes", "Zebra");

		System.out.println(Arrays.toString(animalTracker)); 

	}

}