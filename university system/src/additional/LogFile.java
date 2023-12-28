package additional;

import java.util.ArrayList;
import java.util.List;

public class LogFile {

    private static List<String> logs = new ArrayList<>();

    public static void log(String action, String userId) {
        String logEntry = action + " by user " + userId;
        logs.add(logEntry);
        System.out.println("Logged: " + logEntry);
    }

    public static void viewLogs() {
        System.out.println("Log Entries:");
        logs.forEach(System.out::println);
    }
}
