import java.util.*;

public class StoreSales {
    private Map<String, Integer> sales; 
    
    
    public StoreSales() {
        sales = new HashMap<>();
    }
    
    public void addSale(String product) {
        sales.put(product, sales.getOrDefault(product, 0) + 1);
    }
    
    public void printAllSales() {
        System.out.println("SALES");
        if (sales.isEmpty()) {
            System.out.println("No sales yet.");
            return;
        }
        
        for (Map.Entry<String, Integer> entry : sales.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " sold");
        }
    }
    
    public int getTotalSales() {
        int total = 0;
        for (int quantity : sales.values()) {
            total += quantity;
        }
        return total;
    }
    
    public String getMostPopular() {
        if (sales.isEmpty()) {
            return "No sales yet";
        }
        
        String mostPopular = null;
        int maxSales = 0;
        
        for (Map.Entry<String, Integer> entry : sales.entrySet()) {
            if (entry.getValue() > maxSales) {
                maxSales = entry.getValue();
                mostPopular = entry.getKey();
            }
        }
        
        return mostPopular + " (" + maxSales + " sales)";
    }
    
    
    public int getProductSales(String product) {
        return sales.getOrDefault(product, 0);
    }
}
