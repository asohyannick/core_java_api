package org.asohyannick;

public final  class Person {
   private String name;
   private int age;
   private boolean status;
   
   public Person(String name, int age, boolean status) {
	   this.name = name;
	   this.age = age;
	   this.status = status;
   }
   
   public String getName() {
	   return name;
   }
   
   public int getAge() {
	   return age;
   }
   
   public boolean isStatus() {
	   return status;
   }
   
   public  Person setName(String name) {
	   if ( name == null  ||  name.length() == 0  || name.isBlank ()) {
		   throw new IllegalArgumentException ("name is null or blank");
	   }
	   this.name = name;
	   return  this;
   }
   
   public  Person setAge(int age) {
	   if ( age < 0  || age > 100 ) {
		   throw new IllegalArgumentException ("age is out of range");
	   }
	   this.age = age;
	   return this;
   }
   
   public Person setStatus(boolean status) {
	   if ( status == false ) {
		   throw new IllegalArgumentException ("status is false");
	   }
	   this.status = status;
	   return this;
   }
   
   @Override
   public String toString() {
	   return "Person{" +
			           "name='" + name + '\'' + ", age=" + age + ", status=" + status +
			          "}";
   }
}
