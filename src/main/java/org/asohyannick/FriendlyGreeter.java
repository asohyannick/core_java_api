package org.asohyannick;

public class FriendlyGreeter implements Greeter{

public void greet(String name){
	System.out.println ("Hey " + name + "!");
}
// greetAll() is inherited for free from the interface

}
