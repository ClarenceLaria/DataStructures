//This program implements a stack using an array
//The stack is a data structure that follows the LIFO (Last In First Out) principle
//The contributors of this code are:
//Clarence Laria: SIT/B/01-02287/2021
//Byrone Kingsly: SIT/B/01-02287/2021
//Valencia Nabiswa: SIT/B/01-02287/2021
//Elon Ogonji: SIT/B/01-02287/2021
public class StackArray {
    int[] stack;
    int top;
    int capacity;

    public StackArray(int capacity) {
        this.capacity = capacity;
        stack = new int[capacity];
        top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == capacity - 1;
    }

    public void push(int item) {
        if (isFull()) {
            System.out.println("Stack Overflow");
            return;
        }
        stack[++top] = item;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return -1;
        }
        return stack[top--];
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return stack[top];
    }

    public static void main(String[] args) {
        StackArray stack = new StackArray(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Stack contents:");
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
