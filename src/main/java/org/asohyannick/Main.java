package org.asohyannick;
import java.util.ArrayList;

import static org.asohyannick.Constants.*;
import static org.asohyannick.VariableScope.COMPANY_NAME;
import static org.asohyannick.VariableScope.instanceCount;

public class Main {
    public static void main(String[] args) {
       VariableScope obj = new VariableScope();
       obj.demonstrateScope();


        // Can access static variable directly
        System.out.println("Company: " + COMPANY_NAME);
        System.out.println("Instance count: " + instanceCount);

        // Cannot access instance variables without an object
        // System.out.println(instanceAge); // COMPILATION ERROR!
        System.out.println("Instance age: " + obj.instanceAge); // This works

        final int MAX_SIZE = 100;
        final String USER_ROLE = "ADMIN";
        System.out.println("PI: " + PI);
        System.out.println("Max retries: " + MAX_ENTRY_COUNT);
        System.out.println("Max size: " + MAX_SIZE);
        System.out.println("Base Url: " + BASE_URL);
        System.out.println("Days in the week: " + DAYS_IN_WEEK);
        System.out.println("User Role: " + USER_ROLE);
        final ArrayList<String> ROLES =  new ArrayList<>();
        ROLES.add("SUPER_ADMIN");
        ROLES.add("CUSTOMER");
        ROLES.add("EMPLOYEE");
        System.out.println("All roles include: " + ROLES);

    }
}

