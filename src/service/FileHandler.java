package service;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileHandler {
    private static final String LOG_FILE = "payroll_log.txt";

    public static void log(String action, String employeeId, String details) {
        try (FileWriter fw = new FileWriter(LOG_FILE, true)) {
            String timestamp = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            fw.write("[" + timestamp + "] " + action +
                     " | EMP_ID: " + employeeId +
                     " | " + details + "\n");
        } catch (IOException e) {
            System.out.println("Warning: Could not write to log file.");
        }
    }
}