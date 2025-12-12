import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindWord {

    
    public static List<String> findWordsStartingWith(String text, String letter) {
        // invalid
        if (text == null || text.isEmpty()) {
            return new ArrayList<>();
        }
        if (letter == null || letter.length() != 1 || !Character.isLetter(letter.charAt(0))) {
            throw new IllegalArgumentException("Starting letter must be a single alphabetic character.");
        }

        
        String escapedLetter = letter;
        
        String regex = "\\b" + escapedLetter + "[a-zA-Z]*";

        
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);

        List<String> result = new ArrayList<>();
        while (matcher.find()) {
            result.add(matcher.group());
        }

        return result;
    }

    public static void main(String[] args) {
        String text = "Hello, how are you? Hope everything is fine. Have a great day!";
        String startLetter = "h";

        try {
            List<String> words = findWordsStartingWith(text, startLetter);
            if (words.isEmpty()) {
                System.out.println("No words found starting with '" + startLetter + "'.");
            } else {
                System.out.println("Words starting with '" + startLetter + "':");
                for (String word : words) {
                    System.out.println("- " + word);
                }
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
