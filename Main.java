import java.util.LinkedList;
import java.util.HashMap;
import java.util.Map;

class HashTable<K, V> {
    private static class Entry<K, V> {
        K key;
        V value;

        
        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() { return key; }
        public V getValue() { return value; }
        public void setValue(V value) { this.value = value; }
    }

    private LinkedList<Entry<K, V>>[] table;
    private int size;
    private static final int DEFAULT_SIZE = 10;

    @SuppressWarnings("unchecked")
    public HashTable() {
        table = new LinkedList[DEFAULT_SIZE];
        size = 0;
    }

    private int hash(K key) {
        return Math.abs(key.hashCode()) % table.length;
    }

    public void put(K key, V value) {
        int index = hash(key);
        if (table[index] == null) {
            table[index] = new LinkedList<Entry<K, V>>();
        }
        for (Entry<K, V> entry : table[index]) {
            if (entry.getKey().equals(key)) {
                entry.setValue(value);
                return;
            }
        }
        table[index].add(new Entry<K, V>(key, value));
        size++;
    }
    
    public V get(K key) {
        int index = hash(key);
        if (table[index] == null) return null;
        for (Entry<K, V> entry : table[index]) {
            if (entry.getKey().equals(key)) return entry.getValue();
        }
        return null;
    }
    
    public V remove(K key) {
        int index = hash(key);
        if (table[index] == null) return null;
        for (Entry<K, V> entry : table[index]) {
            if (entry.getKey().equals(key)) {
                V value = entry.getValue();
                table[index].remove(entry);
                size--;
                if (table[index].isEmpty()) table[index] = null;
                return value;
            }
        }
        return null;
    }
    
    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }
}

//2задание

class Product {
    private String name;
    private double price;
    private int quantity;
    
    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    
    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
    
    public void setQuantity(int quantity) {
        if (quantity >= 0) {
            this.quantity = quantity;
        }
    }
}

class Warehouse {
    private Map<String, Product> products;
    
    public Warehouse() { products = new HashMap<>(); }
    
    public void addProduct(String barcode, String name, double price, int quantity) {
        products.put(barcode, new Product(name, price, quantity));
        System.out.println("Product added: " + name);
    }
    
    public Product findProduct(String barcode) {
        Product product = products.get(barcode);
        if (product != null) {
            System.out.println("Found: " + product.getName());
        } else {
            System.out.println("Product not found");
        }
        return product;
    }
    
    public boolean removeProduct(String barcode) {
        Product removed = products.remove(barcode);
        if (removed != null) {
            System.out.println("Deleted: " + removed.getName());
            return true;
        }
        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("HASH TABLE TEST");
        HashTable<String, Integer> table = new HashTable<>();
        
        table.put("Alina", 25);
        table.put("Bell", 30);
        
        System.out.println("Alina: " + table.get("Alina"));  
        System.out.println("Anna: " + table.get("Anna"));    // Не добавляли
        System.out.println("Size: " + table.size());
        
        System.out.println("\nWAREHOUSE TEST");
        Warehouse warehouse = new Warehouse();
        warehouse.addProduct("123456789012", "Notebook", 50000, 18);
        warehouse.addProduct("234567890123", "Pen", 1500, 25);
        
        warehouse.findProduct("123456789012");      
        warehouse.findProduct("999999999999");      // Не добавляли
        
        warehouse.removeProduct("123456789012");    // Удалит
        warehouse.removeProduct("000000000000");    // не существует
    }
}   
