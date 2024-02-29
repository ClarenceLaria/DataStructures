//This is a code that implements a queue using an array. 
//The queue is a data structure that follows the FIFO (First In First Out) principle. The queue is implemented using an array. 
//The queue is initialized with a capacity, and the queue is empty when the front is equal to the rear plus one. 
//The queue is full when the rear is equal to the capacity minus one. 
//The enqueue operation adds an item to the rear of the queue, and the dequeue operation removes an item from the front of the queue. 
//The main method creates a queue with a capacity of 3, enqueues three items, and then dequeues and prints the items until the queue is empty.
public class QueueArray {
    private int[] queue;
    private int front;
    private int rear;
    private int capacity;

    public QueueArray(int capacity) {
        this.capacity = capacity;
        queue = new int[capacity];
        front = 0;
        rear = -1;
    }

    public boolean isEmpty() {
        return front == rear + 1;
    }

    public boolean isFull() {
        return rear == capacity - 1;
    }

    public void enqueue(int item) {
        if (isFull()) {
            System.out.println("Queue Overflow");
            return;
        }
        queue[++rear] = item;
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow");
            return -1;
        }
        return queue[front++];
    }

    public static void main(String[] args) {
        QueueArray queue = new QueueArray(3);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println("Queue contents:");
        while (!queue.isEmpty()) {
            System.out.println(queue.dequeue());
        }
    }
}
