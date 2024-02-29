// This is a java code that implements a queue using a linked list.
//The queue is a data structure that follows the FIFO (First In First Out) principle.
public class QueueLinkedList {
    private static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node front;
    private Node rear;

    public boolean isEmpty() {
        return front == null;
    }

    public void enqueue(int item) {
        Node newNode = new Node(item);
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow");
            return -1;
        }
        int dequeued = front.data;
        if (front == rear) {
            front = null;
            rear = null;
        } else {
            front = front.next;
        }
        return dequeued;
    }

    public static void main(String[] args) {
        QueueLinkedList queue = new QueueLinkedList();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println("Queue contents:");
        while (!queue.isEmpty()) {
            System.out.println(queue.dequeue());
        }
    }
}
