import java.util.regex.*;

public class NumberFinder {
    public static void main(String[] args) {
        
        String text = "The price of product is 19.99 dollars and 25 items cost 100,50 dollars. Temperature is -5.3 degrees.";
        
        try {
        
            Pattern pattern = Pattern.compile("-?\\d+([\\.|\\,]\\d+)?");
            
            
            Matcher matcher = pattern.matcher(text);
            
            
            System.out.println("Found numbers:");
            
            
            while (matcher.find()) {
                System.out.println(matcher.group());
            }
            
        } catch (PatternSyntaxException e) {
            
            System.err.println("Error in regular expression: " + e.getMessage());
        }
    }
}