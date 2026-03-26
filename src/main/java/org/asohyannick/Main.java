package org.asohyannick;
public class Main {
public static void main ( String[] args ) {
  Chef chef = new Chef("Rice", "beans");
  chef.cooking("Eru");
	System.out.println (chef);
	chef.setFood ("kati-kati");
	chef.setDrink ( "Fruit juice" );
	System.out.println (chef);
	ElectricCar electricCar = new ElectricCar ( "BNW", "Toyota", "White", 20, "Green-mark");
	ElectricCar electricCar1 = new ElectricCar ("Asoh", "Java developer", "black", 22, "White");
	electricCar.fuelType ();
	electricCar.drinkType ();
	System.out.println (electricCar);
	System.out.println (electricCar1);
}
}