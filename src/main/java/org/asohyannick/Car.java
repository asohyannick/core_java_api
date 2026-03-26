package org.asohyannick;

public final  class Car {
 
	private String make;
	
	private  String model;
	
	private String brand;
	
	private double price;
	
	 public Car(String make, String model, String brand, double price) {
		 this.make = make;
		 this.model = model;
		 this.brand = brand;
		 this.price = price;
	 }
	 
	 public String  getMake() {
		 return make;
	 }
	 
	 public void setMake(String make) {
		 if ( make == null || make.isEmpty() ) {
			 throw new IllegalArgumentException("Make cannot be null or empty");
		 }
		 this.make = make;
	 }
	 
	 public String getModel() {
		 return model;
	 }
	 
	 public  void setModel(String model) {
		 if ( model == null || model.isEmpty() ) {
			 throw new IllegalArgumentException("Model cannot be null or empty");
		 }
		 this.model = model;
	 }
	 
	 public String getBrand() {
		 return brand;
	 }
	 
	 public  void setBrand(String brand) {
		 if ( brand == null || brand.isEmpty() ) {
			 throw new IllegalArgumentException("Brand cannot be null or empty");
		 }
		 this.brand = brand;
	 }
	 
	 public  double getPrice() {
		 return price;
	 }
	 
	 public  void setPrice(double price) {
		 this.price = price;
	 }
	 
	 public void start() {
		 System.out.println ("Vroom" );
	 }
	 
	 @Override
	 public String toString() {
		 return "Car{" +
						"make='" + make + '\'' + "," +
				        "model='" + model + '\'' + "," +
						"brand='" + brand + '\'' + "," +
						"price=" + price + '\'' + ", " +
				        "}";
	 }
	 
 public static void main(String[] args) {
	 Car c1 = new Car ("Toyota", "2025", "First class", 20.00);
	 c1.setMake("BMW");
	 c1.setModel("2026");
	 c1.setBrand("Top class");
	 c1.setPrice ( 100.00);
	 c1.start();
	 System.out.println (c1);
 }
}
