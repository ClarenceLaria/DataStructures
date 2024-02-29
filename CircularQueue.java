public class CircularQueue {
    int[] queue;
    int front; // Front pointer
    int rear; // Rear pointer
    int size; // Current size of the queue
    int capacity; // Maximum capacity of the queue

    // Constructor to initialize the circular queue with a given capacity
    public CircularQueue(int capacity) {
        this.capacity = capacity;
        this.queue = new int[capacity];
        this.front = 0;
        this.rear = -1; // Rear pointer starts from -1 as the queue is initially empty
        this.size = 0; // Initially, the size of the queue is 0
    }

    // Method to enqueue an element into the circular queue
    public void enqueue(int data) {
        // Check if the queue is full
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue " + data);
            return;
        }
        // Calculate the next rear index in a circular manner
        rear = (rear + 1) % capacity;
        // Insert the element at the rear position
        queue[rear] = data;
        // Increment the size of the queue
        size++;
        System.out.println("Enqueued element: " + data);
    }

    // Method to dequeue an element from the circular queue
    public int dequeue() {
        // Check if the queue is empty
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return -1; // Return -1 to indicate an empty queue
        }
        // Retrieve the element at the front position
        int data = queue[front];
        // Move the front pointer to the next position in a circular manner
        front = (front + 1) % capacity;
        // Decrement the size of the queue
        size--;
        System.out.println("Dequeued element: " + data);
        return data;
    }

    // Method to check if the circular queue is full
    public boolean isFull() {
        return size == capacity;
    }

    // Method to check if the circular queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Method to display the elements of the circular queue
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.print("Circular Queue: ");
        int count = size;
        int i = front;
        while (count > 0) {
            System.out.print(queue[i] + " ");
            i = (i + 1) % capacity;
            count--;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Create a circular queue with capacity 5
        CircularQueue queue = new CircularQueue(5);
        // Enqueue elements
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        // Try to enqueue when the queue is full
        queue.enqueue(6);
        // Display elements
        queue.display();
        // Dequeue elements
        queue.dequeue();
        queue.dequeue();
        // Display elements after dequeue
        queue.display();
        // Enqueue elements again
        queue.enqueue(6);
        queue.enqueue(7);
        // Display elements
        queue.display();
    }
}
