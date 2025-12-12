public class ArrayAverage {
    public static void main(String[] args) {
        //String[] stringArray = {"1", "2", "3", "4", "5", "abc"};
        String[] stringArray = {"1", "2", "3", "4", "5",};
        int[] arr = new int[stringArray.length];
        int sum = 0;
        double average = 0;
        int validCount = 0; 

        try {
            System.out.println("Converting strings to numbers");
            
            for (int i = 0; i < stringArray.length; i++) {
                arr[i] = Integer.parseInt(stringArray[i]);
                validCount++;
            }
            
            
            
            if (validCount > 0) {
                average = (double) sum / validCount;
                
                System.out.println("Successfully converted numbers: " + validCount);
                System.out.println("Sum of elements: " + sum);
                System.out.println("Average: " + average);
            } else {
                System.out.println("No valid numbers");
            }

        } catch (NumberFormatException e) {
            
            for (int i = 0; i < validCount; i++) {
                sum += arr[i];
            }
            
            System.out.println("Error: Array element is not a number!");
            System.out.println("Processed " + validCount + " valid numbers");
            System.out.println("Sum of processed numbers: " + sum);
            
            if (validCount > 0) {
                average = (double) sum / validCount;
                System.out.println("Arithmetic average for valid numbers: " + average);
            }
            
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Array index out of bounds!");
            System.out.println("Error message: " + e.getMessage());
            
        } catch (ArithmeticException e) {
            System.out.println("Error: Arithmetic error (division by zero)!");
            System.out.println("Error message: " + e.getMessage());
            
        } catch (NullPointerException e) {  
            System.out.println("Error: Null pointer exception!");
            System.out.println("Error message: " + e.getMessage());
        } finally {
            System.out.println("DONE");
        }
    }
}