package org.asohyannick;
/**
 instanceof checks whether an object is an instance of a specific type.
 You'll use this constantly when working with inheritance and polymorphism in Spring Boot.
 */
public class InstanceofOperator {
    static class Animal {
        String name;
        Animal(String name) {
            this.name = name;
        }
    }
    static class Dog extends  Animal {
        Dog(String name) {
            super(name);
        }
        void bark() {
            System.out.println(name + " says: Woof!");
        }
    }
    static class Cat extends  Animal {
        Cat(String name) {
            super(name);
        }
        void moew() {
            System.out.println(name + " says: Meow!");
        }
    }

    public static void main(String[] args) {
        // ─────────────────────────────────────────
        // TRADITIONAL instanceof
        // ─────────────────────────────────────────

        Animal animal1 = new Dog("Rex");
        Animal animal2 = new Cat("Whisker");
        var text = "Hello";
        Object number = 42;
        System.out.println(animal1 instanceof  Dog);
        System.out.println(animal2 instanceof  Cat);
        System.out.println(text instanceof String);
        System.out.println(number instanceof Integer);

        String nullStr = null;
        System.out.println(nullStr instanceof String);

        // Traditional pattern — check type then cast
        makeAnimalSound(animal1);
        makeAnimalSound(animal2);

        // ─────────────────────────────────────────
        // PATTERN MATCHING instanceof (Java 16+)
        // This is modern Java — cleaner and safer
        // ─────────────────────────────────────────

        // Old way — verbose and error-prone

        if (animal2 instanceof Dog) {
            Dog dog = (Dog) animal2;
            dog.bark();
        }

        // New way — pattern matching combines check AND cast in one
        if (animal1 instanceof Dog dog) { // 'dog' is declared and cast automatically
            dog.bark(); // 'dog' is available here as type Dog — no manual cast
        }

        if (animal2 instanceof Cat cat) {
            cat.moew();
        }

        // Pattern variable scope

        Object obj = "Hello Java";
        if (obj instanceof String str && str.length() >= 5) {
            System.out.println("Long string: " + str.toUpperCase());
        }

        // ─────────────────────────────────────────
        // REAL BACKEND USE CASE
        // Exception handling with instanceof
        // ─────────────────────────────────────────

        processException(new IllegalArgumentException("Invalid Input"));
        processException(new NullPointerException("Null value"));
        processException(new RuntimeException("Generic error"));

    }

    static void makeAnimalSound(Animal animal) {
        if (animal instanceof Dog) {
            ((Dog) animal).bark();
        } else if (animal instanceof Cat) {
            ((Cat) animal).moew();
        }
    }

    static void processException(Exception e) {
        // Pattern matching with instanceof — clean exception type routing
        if (e instanceof IllegalArgumentException iae) {
            System.out.println("400 Bad Request: " + iae.getMessage());
        } else if (e instanceof NullPointerException npe) {
            System.out.println("500 Internal Error — null: " + npe.getMessage());
        } else if (e instanceof RuntimeException re) {
            System.out.println("500 Internal Error: " + re.getMessage());
        }
    }

}
