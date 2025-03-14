// To use ArrayLists, we must import them 

import java.util.ArrayList; 

public class AnimalsArrayList{

	// Incorrect version 

	// public static ArrayList<String> compareRemove(ArrayList<String> animalNames){
	// 	for (String name : animalNames){
	// 	    if ( name.charAt(0) > 'M'){
	// 			animalNames.remove(name); 
	// 		} 
	// 	}
	// 	return animalNames;
	// }

	// Correct version 
	public static ArrayList<String> compareRemove(ArrayList<String> animalNames){

		// Make a new copy of all the data 
		ArrayList<String> newList = new ArrayList<String>(); 
		for (String element: animalNames){
			newList.add(element); 
		}

		// Now we can iterate through 
		for (String name : animalNames){
		    if ( name.charAt(0) > 'M'){
				newList.remove(name); 
			} 
		}
		return newList;
	}

	public static void main(String[] args){

		// Declare and create an ArrayList object with capacity 5 
		ArrayList<String> animalNames = new ArrayList<String>(5); 

		// Add elements to the array list 
		animalNames.add("Leo");
		animalNames.add("Moo Deng");
		animalNames.add("Stripes"); 
		animalNames.add("Mark");
		animalNames.add("Stripes");  

		ArrayList<String> out = compareRemove(animalNames);
		System.out.println(out); 

	}
}