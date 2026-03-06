package org.asohyannick;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 The while Loop — Condition-Based Iteration
 The while loop is used when you don't know in advance how many iterations you'll need — you loop as long as a condition remains true.
 */
public class WhileLoop {
    public static void main(String[] args) {
        // ─────────────────────────────────────────────────
        // BASIC while LOOP
        // Checks condition BEFORE executing body
        // If condition is false initially, body never executes
        // ─────────────────────────────────────────────────
        var count = 0;
        while (count < 5) {
            System.out.println(count + " ");
            count++; // CRITICAL — must update condition variable or infinite loop!
        }
        System.out.println();

        // Execution flow:
        // count=0: 0 < 5 → true  → print 0, count becomes 1
        // count=1: 1 < 5 → true  → print 1, count becomes 2
        // count=2: 2 < 5 → true  → print 2, count becomes 3
        // count=3: 3 < 5 → true  → print 3, count becomes 4
        // count=4: 4 < 5 → true  → print 4, count becomes 5
        // count=5: 5 < 5 → false → loop ends

        // ─────────────────────────────────────────────────
        // CONDITION FALSE FROM THE START — body never runs
        // ─────────────────────────────────────────────────
        int x = 10;
        while (x < 5) { // 10 < 5 is false immediately
            System.out.println("This never prints");
        }
        System.out.println("while loop with false condition skipped entirely");
        // ─────────────────────────────────────────────────
        // READING UNTIL A SENTINEL VALUE
        // Classic use case — process data until a stop signal
        // ─────────────────────────────────────────────────

        // Simulating processing a queue until empty
        Queue<String> taskQueue = new LinkedList<>();
        taskQueue.offer("Send welcome  email");
        taskQueue.offer("Update user cache");
        taskQueue.offer("Sync with external API");
        taskQueue.offer("Generate Request");

        System.out.println("\nProcessing task queue:");
        while (!taskQueue.isEmpty()) {
            String task = taskQueue.poll();
            System.out.println("Processing" + task);
        }
        System.out.println("Queue empty — all tasks processed");

        // ─────────────────────────────────────────────────
        // WHILE WITH COMPLEX CONDITION
        // ─────────────────────────────────────────────────

        int retries = 0;
        int maxRetries = 3;
        boolean success = false;

        while (retries < maxRetries && !success) {
            retries++;
            System.out.println("Attempt " + retries + " of " + maxRetries);

            // Simulate success on third attempt
            if (retries == 3) {
                success = true;
                System.out.println("Operation succeeded on attempt " + retries);
            } else {
                System.out.println("Attempt " + retries + " failed, retrying...");
            }
        }

        if (!success) {
            System.out.println("All attempts exhausted — operation failed");
        }

        // ─────────────────────────────────────────────────
        // INPUT VALIDATION LOOP
        // Keep asking until valid input received
        // ─────────────────────────────────────────────────

        String[] simulatedInputs = {"", "ab", "validUsername123"};
        int inputIndex = 0;

        String validUsername = null;
        while (validUsername == null) {
            String input = simulatedInputs[inputIndex++]; // simulate getting input

            if (input == null || input.isBlank()) {
                System.out.println("Username cannot be empty. Try again.");
            } else if (input.length() < 3) {
                System.out.println("Username too short (min 3 chars). Try again.");
            } else if (input.length() > 20) {
                System.out.println("Username too long (max 20 chars). Try again.");
            } else {
                validUsername = input; // valid — exits the while loop
            }
        }
        System.out.println("Valid username accepted: " + validUsername);

        // ─────────────────────────────────────────────────
        // WHILE TRUE with break — explicit infinite loop
        // Used in event loops, server listeners, game loops
        // ─────────────────────────────────────────────────

        int requestsProcessed = 0;
        int maxRequests = 5; // simulating server shutdown condition

        System.out.println("\nSimulated server event loop:");
        while (true) {
            requestsProcessed++;
            System.out.println("Handling request #" + requestsProcessed);

            // Check shutdown condition
            if (requestsProcessed >= maxRequests) {
                System.out.println("Server shutting down gracefully");
                break;
            }
        }

        // ─────────────────────────────────────────────────
        // REAL BACKEND SCENARIOS
        // ─────────────────────────────────────────────────

        // 1. Polling for job completion


        // 1. Polling for job completion
        int jobProgress = 0;
        System.out.println("\nPolling job status:");
        while (jobProgress < 100) {
            jobProgress += 25; // simulate progress
            System.out.println("Job progress: " + jobProgress + "%");
        }
        System.out.println("Job completed!");

        Iterator<String> logEntries = getLogEntries();
        while (logEntries.hasNext()) {
            String logEntry = logEntries.next();
            if (logEntry.contains("ERROR")) {
                System.out.println("ALERT: " + logEntries);
            }
        }

        // 3. Binary search implementation using while
        int[] sortedArray = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};
        int target = 23;
        int index = binarySearch(sortedArray, target);
        System.out.println("\nBinary search for " + target + ": index " + index);

    }

    static  Iterator<String> getLogEntries() {
       return List.of(
                "INFO: Server started",
                "INFO: Request received",
                "ERROR: Database timeout",
                "INFO: Retry successful",
                "ERROR: Invalid token"
        ).iterator();
    }
    static int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (array[mid] == target) {
                return mid;
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
