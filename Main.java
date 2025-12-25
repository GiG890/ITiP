import java.util.*;

class Product {
    private String name;
    private int price;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "продукт: " + name + " цена: " + price;
    }
    @Override 
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Product product = (Product) obj;
        return name.equals(product.name);
    }
    @Override
    public int hashCode(){
        return name.hashCode();
    }
}

class SalesCount {
    private List<Product> sales = new ArrayList<>();
    public void addSale(Product product) {
        sales.add(product);
    }
    public void showAllSales() {
        if (sales.isEmpty()) {
            System.out.println("Продаж пока нет.");
        }
        System.out.println("Проданные товары:");
        for (Product p: sales) {
            System.out.println(p);
        }
    }
    public int getTotalRavenue() {
        int total = 0;
        for (Product p: sales) {
            total += p.getPrice();
        }
        return total;
    }
    public Product getMostPopulaProduct() {
        Map<Product, Integer> counts = new HashMap<>();
        for (Product p: sales) {
            counts.put(p, counts.getOrDefault(p, 0) + 1);
        }

        Product mostPopular = null;
        int maxCount = 0;
        for (Map.Entry<Product, Integer> entry : counts.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostPopular = entry.getKey();
            }
        }
        return mostPopular;
    }
}

public class Main {
    public static void main(String[] args) {
        SalesCount register = new SalesCount();
        register.addSale(new Product("Лабубу", 900));
        register.addSale(new Product("Подсвечник в виде зелья из Майнкрафта", 500));
        register.addSale(new Product("Творог", 300));
        register.addSale(new Product("Молочный коктейль", 200));
        register.addSale(new Product("Мультиварка", 4500));
        register.addSale(new Product("Холодильник", 80000));
        register.addSale(new Product("Лабубу", 900));
        register.addSale(new Product("Лабубу", 900));
        register.addSale(new Product("Холодильник", 80000));
        
        register.showAllSales();

        System.out.println("" + register.getTotalRavenue());

        Product popular = register.getMostPopulaProduct();
        if (popular != null) {
            System.out.println("" + popular.getName());
        }
    }
}







