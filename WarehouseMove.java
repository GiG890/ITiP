import java.util.*;
import java.util.concurrent.*;

public class WarehouseMove {

    public static void main(String[] args) throws Exception {
        
        List<Integer> products = Arrays.asList(25, 40, 35, 20, 45, 30, 50, 15, 25, 40);
        
        System.out.println("Products: " + products);
        
        List<Integer> worker1Products = Arrays.asList(25, 40, 35);    
        List<Integer> worker2Products = Arrays.asList(20, 45, 30);    
        List<Integer> worker3Products = Arrays.asList(50, 15, 25, 40); 
        
        
        CompletableFuture<Void> worker1 = CompletableFuture.runAsync(() -> {
            processWorker(1, worker1Products);
        });
        
        CompletableFuture<Void> worker2 = CompletableFuture.runAsync(() -> {
            processWorker(2, worker2Products);
        });
        
        CompletableFuture<Void> worker3 = CompletableFuture.runAsync(() -> {
            processWorker(3, worker3Products);
        });
        
        
        CompletableFuture<Void> allWorkers = CompletableFuture.allOf(worker1, worker2, worker3);
        allWorkers.get(); 
        
        System.out.println("\nAll products moved!");
    }
    
    
    static void processWorker(int workerId, List<Integer> products) {
        int currentWeight = 0;
        int trips = 0;
        
        for (int weight : products) {
            if (currentWeight + weight > 150) {
                
                trips++;
                System.out.println("Worker " + workerId + ": Trip " + trips + " - " + currentWeight + "kg");
                currentWeight = 0;
            }
            currentWeight += weight;
        }
        
        
        if (currentWeight > 0) {
            trips++;
            System.out.println("Worker " + workerId + ": Trip " + trips + " - " + currentWeight + "kg");
        }
        
        System.out.println("Worker " + workerId + " finished. Total trips: " + trips);
    }
}
