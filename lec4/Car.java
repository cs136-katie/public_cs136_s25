public class Car{
	// 1. Instance variables

	// Variables with `final` keyword will not change 
	public final double horsePower;
	public final String make, model, vinNumber;

	// Here, we have (non-final) variables that might change 
	public String color; 
	public boolean isBlackWhite;

	// A static variable (so this is not an instance variable)
	// and thus belong to the entire class 
	public static int totalCars = 0;  

	// 2. Constructor
	public Car(String make, String model, String color_input, double horsePower){
		// We don't need `this` to refer to the instance variable `color` 
		color = color_input;
		// Alternatively: this.color = color_input 

		// `this` is helpful when constructer parameters are the same as
		// the field variables 
		this.make = make; 
		this.model = model; 
		this.horsePower = horsePower; 
		
		// We can call another instance method within the constructor 
		this.setBlackWhite();

		// This will increase for every time we make a new Car object 
		totalCars += 1; 

		// Contrived VIN number example 
		vinNumber = "A"+totalCars; 
	}

	
	// 3. Instance methods
	public void setBlackWhite(){
		if(this.color == "black" || this.color == "white"){
			this.isBlackWhite = true; 
		}
		else{
			this.isBlackWhite = false; 
		}
	}

	public void repaint(String newColor){
		this.color = newColor; 
	}

	// 4. Static methods

	// Converts Miles Per Gallon (MPG) to Liters per 100KM
	public static double convertMPG(double mpg) {
        return 235.214 / mpg;
    } 

	// 5. Main
	public static void main(String[] args){
		// Testing our constructor
		Car car1 = new Car("Ford", "F150", "red", 700.0); 
		Car car2 = new Car("Honda", "Fit", "white", 130.0);
		System.out.println("Car1 is black or white="+car1.isBlackWhite);
		System.out.println("Car2 is black or white="+car2.isBlackWhite);  

		// Instance method 
		System.out.println("Car 1 color: "+ car1.color); 
		car1.repaint("blue"); 
		System.out.println("Car 1 color: "+ car1.color);


		// Static method 
		double mpg = 32.0;
		double litersPer100K = convertMPG(32.0);
		System.out.println("MGP="+mpg+" is litersPer100K="+litersPer100K);
	}
}