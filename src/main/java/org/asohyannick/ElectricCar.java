package org.asohyannick;

public final class ElectricCar extends Vehicle{
  
  private String mark;
 public ElectricCar(String brand, String model, String color, int speed, String mark) {
	 super(brand,model,color,speed);
	 this.mark=mark;
 }
 public  String getMark() {
	 return mark;
 }
 public void setMark(String mark) {
	 this.mark = mark;
 }
 
 @Override
 public void fuelType() {
	 System.out.println ("The fuel type is gasoline");
 }
 
 @Override
 public  void drinkType() {
	 System.out.println ("The drink type is juice");
 }
 
 @Override
 public String toString() {
  return "ElectricCar{" +
		          "mark='" + mark + '\'' +
				 "brand='" + getBrand () + '\'' +
				 "model='" + getModel () + '\'' +
				 "color='" + getColor () + '\'' +
				 "speed='" + getSpeed () + '\'' +
		         "}";
 }
}
