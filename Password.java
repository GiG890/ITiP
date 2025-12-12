import java.util.regex.*;
import java.util.Scanner;

public class Password {
    public static void main(String[] args) {
        // input
        Scanner scanner = new Scanner(System.in);
        
        
        System.out.println("PASSWORD CHECK");
        System.out.println("Password requirements:");
        System.out.println("1. Only Latin letters and digits");
        System.out.println("2. Length from 8 to 16 characters");
        System.out.println("3. one uppercase letter");
        System.out.println("4. one digit");
        System.out.println("\n password:");
        
        
        String password = scanner.nextLine();
        
        try {
            
            String regex = "^(?=.*[A-Z])(?=.*\\d)(?=.*\\?)[A-Za-z\\d\\?]{8,16}$";
            
            
            Pattern pattern = Pattern.compile(regex);
            
            
            Matcher matcher = pattern.matcher(password);
            
            
            if (matcher.matches()) {
                System.out.println("\n Password PASSED the check!");
                System.out.println("Password: \"" + password + "\"");
                
            } else {
                System.out.println("\n Password FAILED the check!");
                System.out.println("Reason:");
                
                
                checkRequirements(password);
            }
            
        } catch (PatternSyntaxException e) {
            System.err.println("Error in regular expression: " + e.getMessage());
        } finally {
            
            scanner.close();
        }
    }
    
    
    private static void checkRequirements(String password) {
        boolean hasError = false;
        
        
        if (password.length() < 8 || password.length() > 16) {
            System.out.println("  - Incorrect length: " + password.length() + 
                             " characters (required 8-16)");
            hasError = true;
        }
        
        
        if (!password.matches("[A-Za-z\\d\\?]*")) {
            System.out.println("  - Contains invalid characters");
            System.out.println("    Only allowed: A-Z, a-z, 0-9");
            hasError = true;
        }
        
        //Check uppercase letter
        if (!password.matches(".*[A-Z].*")) {
            System.out.println("  - No uppercase letters");
            hasError = true;
        }
        
        // Check digit
        if (!password.matches(".*\\d.*")) {
            System.out.println("  - No digits");
            hasError = true;
        }
        
        if (!hasError) {
            System.out.println("  - Unknown error");
        }
        
        
    }
}