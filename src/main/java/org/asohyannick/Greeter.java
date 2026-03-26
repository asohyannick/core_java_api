package org.asohyannick;

public interface Greeter {
	void greet(String name);
	// abstract — must be implemented

    // default method — optional to override
	default  void greetAll(String[] names) {
		for (String name : names) {
			greet (name);
		}
	}

    // static method — belongs to the interface itself
	static Greeter formal() {
		return  name -> System.out.println ("Good evening" + name);
	}
}
