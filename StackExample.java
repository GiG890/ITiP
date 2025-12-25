public class StackExample {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>(10);
        
        stack.push(1);
        stack.push(2);
        stack.push(3);
        
        System.out.println("Pop: " + stack.pop()); // 3
        System.out.println("Peek: " + stack.peek()); // 2
        
        stack.push(4);
        System.out.println("Pop: " + stack.pop()); // 4
        
        
        Stack<String> stringStack = new Stack<>(5);
        stringStack.push("Hello");
        stringStack.push("World");
        
        System.out.println("String stack peek: " + stringStack.peek()); 
        System.out.println("String stack pop: " + stringStack.pop()); 
    }
}