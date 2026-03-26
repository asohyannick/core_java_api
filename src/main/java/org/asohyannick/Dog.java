package org.asohyannick;

public class Dog extends Animal {

private  String breed;

 public Dog(String name, int age, String breed) {
	 super (name, age); // Must call parent  constructor first
	 this.breed = breed;
 }
 
 public String getBreed() {
	 return breed;
 }
 
 public void setBreed(String breed) {
	 this.breed = breed;
 }
 
 // method parent method
 @Override
 public void makeSound() {
	 System.out.println (getName () + "says: Woof!" );
	 super.makeSound ();  // super.makeSound();  // could also call parent version
 }
 
 public void fetch() {
	 System.out.println (getName () + "fetches the ball" );
 }
 
 @Override
public String toString() {
	 return "Dog{" +
			        "name='" + getName() + '\'' + "," +
			        "age=" + getAge() + ", " +
					"breed='" + breed + '\'' +
			        "}";
 }
}
