package org.asohyannick;
/**
 The switch Statement and Switch Expression
 switch is where Java has undergone the most dramatic evolution in recent versions. There are two completely different generations of switch in Java and understanding both is essential — you'll encounter both in production codebases.
 Traditional switch Statement (Java 1 through Java 13)
 */
public class TraditionalSwitch {
    public static void main(String[] args) {
        // ─
        // ────────────────────────────────────────────────
        // TRADITIONAL switch — the classic form
        // ─────────────────────────────────────────────────

        var dayNumber = 3;
        String dayName;
        switch (dayNumber) {
            case 1:
                dayName = "Monday";
                break; // CRITICAL — without break, falls through to next case!
            case 2:
                dayName = "Tuesday";
                break;
            case 3:
                dayName = "Wednesday";
                break;
            case 4:
                dayName = "Thursday";
                break;
            case 5:
                dayName = "Friday";
                break;
            case 6:
                dayName = "Saturday";
            case 7:
                dayName = "Sunday";
            default:
                dayName = "Invalid day";
                break;
        }
        System.out.println("Day: " + dayName);

        // ─────────────────────────────────────────────────
        // FALL-THROUGH BEHAVIOR — Java's most infamous switch "feature"
        // If you forget break, execution CONTINUES into the next case
        // This is usually a bug, but can be intentionally useful
        // ─────────────────────────────────────────────────

        int month = 4; // April
        String season;

        switch (month) {
            case 12:
            case 1:
            case 2:
                season = "Winter";
                break;
            case 3:
            case 4:   // April falls here, no break, falls through to case 5
            case 5:
                season = "Spring";
                break; // April AND May reach this break
            case 6:
            case 7:
            case 8:
                season = "Summer";
                break;
            case 9:
            case 10:
            case 11:
                season = "Autumn";
                break;
            default:
                season = "Unknown";
        }

        System.out.println("Season: " + season); // Spring

        // ─────────────────────────────────────────────────
        // ACCIDENTAL FALL-THROUGH — a classic bug
        // ─────────────────────────────────────────────────

        String userRole = "EDITOR";
        switch(userRole) {
            case  "ADMIN":
                System.out.println("Can  manage users");
                break;
            case "EDITOR":
                System.out.println("Can edit content");
                break;
            case "VIEWER":
                System.out.println("Can view content");
                break;
            default:
                System.out.println("No Permissions");

        }

        // ─────────────────────────────────────────────────
        // Traditional switch with String (Java 7+)
        // ─────────────────────────────────────────────────

        String httpMethod = "POST";
        String action;
        switch (httpMethod) {
            case "GET":
                action = "Reading  resource";
                break;
            case "POST":
                action = "Creating  resource";
                break;
            case "PUT":
                action = "Updating  resource";
            case "PATCH":
                action = "Patching  resource";
                case  "DELETE":
                action = "Deleting  resource";
            default:
                action = "Unknown method";
        }
        System.out.println("Action: " + action); // Creating resource

    }
}
