package org.asohyannick;

public class VariableScope {
    // CLASS-LEVEL SCOPE (Instance Variables / Fields)
    // These belong to an instance of the class
    // They get default values if not initialized
    // Accessible throughout the entire class

    String instanceName; // default to null
    int instanceAge; // default to 0
    boolean instanceActive = true;
    double instanceSalary = 200_000;

    // CLASS-LEVEL SCOPE (Static Variables / Class Variables)
    // These belong to the CLASS itself, not any instance
    // Shared across all instances
    static  int instanceCount = 0;
    static  final  String COMPANY_NAME = "TechCorp"; // // constant — all caps by convention

    public  void demonstrateScope() {
        // METHOD-LEVEL SCOPE (Local Variables)
        // Only accessible within this method
        // MUST be initialized before use
        // Created when method is called, destroyed when method returns
        int localVariable = 100;
        String localName = "Local John";
        System.out.println("Local variable: " + localVariable);
        System.out.println("Instance variable: " + instanceAge); // accessible here
        System.out.println("Static variable: " + instanceCount); // accessible here

        if (true) {
            int blockVariable = 20;
            System.out.println("Block variable inside block: " + blockVariable); // works
            System.out.println("Local variable in block: " + localVariable); //
        }
        System.out.println(localName);
        for(int i = 0; i < 3; i++) {
            System.out.println("Loop iteration: " + i);
        }
    }

}
