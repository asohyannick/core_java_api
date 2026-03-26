package org.asohyannick;

public class Circle extends  Shape implements  Drawable{

 double radius;
 
 Circle (double r){
	 this.radius = r;
 }
 
 @Override
 public double area(){
	 return Math.PI*radius*radius;
 }
 
 @Override
 public  void draw(){
	 System.out.println ("Drawing Circle");
 }
 
 @Override
 public  void describe(){
	 System.out.println ("Describing Circle");
 }
 
 public String toString(){
	 return "Circle{" +
			        "radius=" + radius +
					"area=" + area() +
			        "}";
 }
}
