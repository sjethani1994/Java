public class ArrayStack {
    private Object[] arr;
    private int size;
    private int capacity;

    public ArrayStack(int capacity) {
        this.capacity = capacity;
        this.arr = new Object[capacity];
        this.size = 0;
    }

    public void push(Object element) {
        if (size == capacity) {
            throw new IllegalStateException("Stack is full. Cannot push more elements.");
        }

        arr[size] = element;
        size++;
    }

    public Object pop() {
        if (size == 0) {
            throw new IllegalStateException("Stack is empty. Cannot pop elements.");
        }

        Object element = arr[size - 1];
        arr[size - 1] = null;
        size--;
        return element;
    }

    public void printStack() {
        for (int i = size - 1; i >= 0; i--) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(5);

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Printing the stack");
        stack.printStack();

        System.out.println();
        System.out.println("Popping elements from the stack:");
        System.out.println(stack.pop());

        System.out.println();
        stack.printStack();
    }
}
