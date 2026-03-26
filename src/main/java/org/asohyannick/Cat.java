package org.asohyannick;

public final class Cat extends Animal{

public  Cat(String name, int age)
{
	super(name,age);
	// must called the parent constructor first
}

@Override
   public void speak()
   {
     System.out.println ("Moew..." );
	   System.out.println ("This is method overriding in action..." );
   }
   
   @Override
   public  String toString()
   {
	   return "Cat{" +
			          "name='" + getName () + '\'' + "," +
	                  "age='" +  getAge () +
			          "}";
   }
}
