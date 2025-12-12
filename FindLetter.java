public class FindLetter {
    public static String tip(String text) {
        return text.replaceAll("([a-z])([A-Z])", "!$1$2!");
    }

    public static void main(String[] args) {
        String input = "helloWorld exampleTest aBc";
        System.out.println(tip(input));
    }
}