import java.util.Random;

public class SumTwoThread {
    
    private static int[] array;
    private static long sum1 = 0; 
    private static long sum2 = 0; 
    
    public static void main(String[] args) {
        
        array = new int[100];
        Random rand = new Random();
        
        
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(10) + 1;
        }
        
        
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < array.length / 2; i++) {
                sum1 += array[i];
            }
            System.out.println("Thread 1 sum: " + sum1);
        });
        
        
        Thread thread2 = new Thread(() -> {
            for (int i = array.length / 2; i < array.length; i++) {
                sum2 += array[i];
            }
            System.out.println("Thread 2 sum: " + sum2);
        });
        
        
        thread1.start();
        thread2.start();
        
        
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        
        long totalSum = sum1 + sum2;
        System.out.println("\nFinal result: " + totalSum);
        
       
        long checkSum = 0;
        for (int num : array) {
            checkSum += num;
        }
        System.out.println("Single-thread check: " + checkSum);
        System.out.println("Correct: " + (totalSum == checkSum));
    }
}