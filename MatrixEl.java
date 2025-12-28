import java.util.Random;

public class MatrixEl {
    
    private static int[][] matrix;
    private static int[] rowMaxValues; 
    
    public static void main(String[] args) {
        
        int rows = 5;
        int cols = 5;
        matrix = new int[rows][cols];
        rowMaxValues = new int[rows];
        
        Random random = new Random();
        
        
        System.out.println("Matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = random.nextInt(100);
                System.out.printf("%3d ", matrix[i][j]);
            }
            System.out.println();
        }
        System.out.println();
        
        
        Thread[] threads = new Thread[rows];
        
        
        for (int i = 0; i < rows; i++) {
            final int rowIndex = i; 
            threads[i] = new Thread(() -> {
                int maxInRow = matrix[rowIndex][0];
                
                for (int j = 1; j < cols; j++) {
                    if (matrix[rowIndex][j] > maxInRow) {
                        maxInRow = matrix[rowIndex][j];
                    }
                }
                rowMaxValues[rowIndex] = maxInRow;
                System.out.println("Thread for row " + rowIndex + 
                                 " this max: " + maxInRow);
            });
            threads[i].start();
        }
        
        
        for (int i = 0; i < rows; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        
        int globalMax = rowMaxValues[0];
        for (int i = 1; i < rows; i++) {
            if (rowMaxValues[i] > globalMax) {
                globalMax = rowMaxValues[i];
            }
        }
        
        System.out.println("\nRow maximums: ");
        for (int i = 0; i < rows; i++) {
            System.out.println("Row " + i + ": " + rowMaxValues[i]);
        }
        
        System.out.println("\nMax maximum found by main thread: " + globalMax);
        
        
        int verificationMax = matrix[0][0];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] > verificationMax) {
                    verificationMax = matrix[i][j];
                }
            }
        }
        System.out.println("Single-thread verification: " + verificationMax);
        System.out.println("Result is " + (globalMax == verificationMax ? "CORRECT" : "WRONG"));
    }
}
