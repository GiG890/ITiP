public class Stack<T> {
    private T[] data; 
    private int size; 
    
    @SuppressWarnings("unchecked")
    public Stack(int capacity) {
        data = (T[]) new Object[capacity]; 
        size = 0; 
    }
    
    public void push(T element) {
        if (size == data.length) {  
            throw new StackOverflowError("Stack is full!");
        }
        data[size] = element;
        size++;
    }
    
    public T pop() {
        if (size == 0) {
            throw new RuntimeException("Stack is empty!");
        }
        size--;
        T element = data[size];
        data[size] = null;
        return element;
    }
    
    public T peek() {
        if (size == 0) {
            throw new RuntimeException("Stack is empty!");
        }
        return data[size - 1];
    }
    
    // Optional methods
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == data.length;
    }
    
    public int getSize() {
        return size;
    }
}