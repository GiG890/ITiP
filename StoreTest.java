public class StoreTest {
    public static void main(String[] args) {
        StoreSales store = new StoreSales();
        
        System.out.println("=== Adding sales ===");
        store.addSale("nuggets");
        store.addSale("juice");
        store.addSale("nuggets");
        store.addSale("pasta");
        store.addSale("nuggets");
        store.addSale("juice");
        store.addSale("nuggets");
        store.addSale("milk");
        
        System.out.println("\n=== Printing all sales ===");
        store.printAllSales();
        
        System.out.println("\n=== Total sales ===");
        System.out.println("Total items sold: " + store.getTotalSales());
        
        System.out.println("\n=== Most popular product ===");
        System.out.println("Most popular: " + store.getMostPopular());
        
        System.out.println("\n=== Checking specific product ===");
        System.out.println("nuggets sold: " + store.getProductSales("nuggets"));
        System.out.println("Bread sold: " + store.getProductSales("bread")); // 0

        
        System.out.println("\nAdding more sales");
        store.addSale("nuggets"); 
        store.addSale("yogurt");  
        store.addSale("yogurt");  

        store.printAllSales();
        System.out.println("Most popular now: " + store.getMostPopular());
        System.out.println("Total now: " + store.getTotalSales());
    }
}