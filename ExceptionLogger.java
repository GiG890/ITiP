import java.io.FileWriter;
import java.io.PrintWriter;

public class ExceptionLogger {
    public static void logException(Exception e) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("exceptions.log", true))) {
            writer.println("Exception: " + e.getClass().getSimpleName());
            writer.println("Message: " + e.getMessage());
            writer.println("---");
        } catch (Exception ex) {
            System.out.println("Log error: " + ex.getMessage());
        }
    }
}
