package com.example;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Random;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;

public class MatrixEl {

    private static final Logger logger = LogManager.getLogger(MatrixEl.class);
    private static final Random RANDOM = new Random();
    
    private static int[][] matrix;
    private static int[] rowMaxValues; 
    
    public static void main(String[] args) {
        
        int rows = 5;
        int cols = 5;
        matrix = new int[rows][cols];
        rowMaxValues = new int[rows];
        
        
        
        System.out.println("Matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = RANDOM.nextInt(100);
                System.out.printf("%3d ", matrix[i][j]);
            }
            logger.info("");
        }
        logger.info("");
        
        
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
                logger.info("Thread for row " + rowIndex + 
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
        
        logger.info("\nRow maximums: ");
        for (int i = 0; i < rows; i++) {
            logger.info("Row " + i + ": " + rowMaxValues[i]);
        }
        
        logger.info("\nMax maximum found by main thread: " + globalMax);
        
        
        int verificationMax = matrix[0][0];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] > verificationMax) {
                    verificationMax = matrix[i][j];
                }
            }
        }
        logger.info("Single-thread verification: " + verificationMax);
        logger.info("Result is " + (globalMax == verificationMax ? "CORRECT" : "WRONG"));

        
        MatrixResult result = new MatrixResult(matrix, rowMaxValues, globalMax);
        
        
        ObjectMapper mapper = new ObjectMapper();
        try {
            String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(result);
            logger.info("Результат в формате JSON:");
            logger.info(json);
        } catch (JsonProcessingException e) {
            logger.error("Ошибка при создании JSON", e);
        }
    }
}
