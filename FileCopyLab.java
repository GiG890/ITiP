import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.File;

public class FileCopyLab {

    public static void main(String[] args) {
        String sourceFile = "original.txt";
        String destinationFile = "copy.txt";
        
        createTestFileIfNeeded(sourceFile);
        
        copyFile(sourceFile, destinationFile);
    }
    
    
    public static void createTestFileIfNeeded(String filename) {
        File file = new File(filename);
        
        if (file.exists()) {
            System.out.println("File " + filename + " already exists");
            return;
        }
        
        System.out.println("File " + filename + " not found. You need Creating test file");
        
        try (FileOutputStream fos = new FileOutputStream(filename)) {
            StringBuilder content = new StringBuilder();
            content.append("This is a test file for my second Java laboratory work.\n");
            content.append("Topic: Working with files and exception handling.\n");
            content.append("This file content will be copied to another file.\n");
            content.append("Creation date: ").append(new java.util.Date()).append("\n");
            content.append("Line 5: Studying FileInputStream and FileOutputStream.\n");
            content.append("Line 6: Handling FileNotFoundException and IOException.\n");
            content.append("Line 7: Using try-catch-finally blocks.\n");
            content.append("Line 8: Copying is done in chunks via buffer.\n");
            content.append("Line 9: Also i can use try-with-resources for this.\n");
            content.append("Line 10: End of test file.\n");
            
            byte[] bytes = content.toString().getBytes();
            fos.write(bytes);
            
            System.out.println("Test file created: " + filename);
            
            
        } catch (IOException e) {
            System.out.println("Error creating test file: " + e.getMessage());
        }
    }
    
    
    public static void copyFile(String sourceFile, String destinationFile) {
        FileInputStream inputStream = null;
        FileOutputStream outputStream = null;
        
        try {
            System.out.println("\nStarting copy process");
            System.out.println("Attempting to open source file: " + sourceFile);
            inputStream = new FileInputStream(sourceFile);
            System.out.println("Source file opened");
            
            System.out.println("Attempting to open destination file: " + destinationFile);
            outputStream = new FileOutputStream(destinationFile);
            System.out.println("Destination file opened successfully");

            // IOException
            //inputStream.close(); 
            //inputStream.read();  
            
            System.out.println("Starting data copying...");
            
            byte[] buffer = new byte[1024]; 
            int bytesRead;
            int totalBytes = 0;
            int operationsCount = 0;
            
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
                totalBytes += bytesRead;
                operationsCount++;
                
                if (operationsCount % 5 == 0) {
                    System.out.println("Progress: copied " + totalBytes + " bytes");
                }
            }
            
            System.out.println("\nCopying completed successfully!");
            System.out.println("Final results:");
            System.out.println("  - Bytes copied: " + totalBytes);
            System.out.println("  - Operations performed: " + operationsCount);
            System.out.println("  - Source file: " + sourceFile);
            System.out.println("  - Destination file: " + destinationFile);
            
        } 
        
        catch (java.io.FileNotFoundException e) {
            System.out.println("ERROR: File not found - " + e.getMessage());
            System.out.println("  Please check if file exists: " + sourceFile);
        } 

        catch (java.io.IOException e) {
            System.out.println("INPUT/OUTPUT ERROR: " + e.getMessage());
            System.out.println("  Possible reasons: file corrupted or no access rights");
        } 

        finally {
            System.out.println("\nClosing resources");
            
            try {
                if (inputStream != null) {
                    inputStream.close();
                    System.out.println("Source file closed");
                }
            } catch (IOException e) {
                System.out.println("Error closing source file: " + e.getMessage());
            }
            
            try {
                if (outputStream != null) {
                    outputStream.close();
                    System.out.println("Destination file closed");
                }
            } catch (IOException e) {
                System.out.println("Error closing destination file: " + e.getMessage());
            }
            
            System.out.println("Program finished work");
        }
    }
}