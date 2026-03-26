package org.asohyannick;
import java.util.Optional;
public class StringDeepDive {
    public static void main(String[] args) {

        String json = """
               {
                "name": "Alice",
                "age" : 30,
                "role" : "Backend Java Developer" 
               }
                """;
        System.out.println(json);

        String personName = "Bob";
        int personAge = 28;
        String message = "Name: %s, Age: %d".formatted(personName, personAge);
        System.out.println(message);

        String name = null;
        String age = null;
       if (name != null) {
           System.out.println(name.length());
       }
       String userInput = getUserInput();
       if (userInput != null && !userInput.isEmpty()) {
           System.out.println("Processing: " + userInput);
       }
        String displayName = (name != null) ? name : "Anonymous";
        System.out.println(displayName);

        Optional<String> optionalName = Optional.ofNullable(name);
        String safeName = optionalName.orElse("Default Name");
        System.out.println("Safe name: " + safeName);
    }

    static String getUserInput() {
        return  null;
    }

}

