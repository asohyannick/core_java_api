package org.asohyannick;

public abstract class Shape {
    abstract  double area();
	public void describe() {
		System.out.println ("I am a shape with area: " + area());
	}
}
