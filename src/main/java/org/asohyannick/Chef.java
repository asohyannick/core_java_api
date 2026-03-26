package org.asohyannick;

public final class Chef implements  Cook{
	 private String food;
	 private String drink;
	 
	 public  Chef(String food, String drink){
		 this.food = food;
	  
		 this.drink = drink;
	 }
	 
	 public String getFood() {
		 return food;
	 }
	 
	 public  void setFood(String food) {
		 this.food = food;
	 }
	 
	 public String getDrink() {
		 return drink;
	 }
	 
	 public  void setDrink(String drink) {
		 this.drink = drink;
	 }
	 
	 @Override
	  public  void cooking(String name) {
		 System.out.println ("I am cooking  fufu and : " + name);
	 }
	 
	 @Override
	public String toString() {
		 return "Chef{"
				         +
						"food='" + food + '\'' + "," +
						"drink='" + drink + '\'' +
				        "}";
	 }
 
}
