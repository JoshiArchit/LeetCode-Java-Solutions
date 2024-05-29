package Design.prb622_Design_Circular_Queue;
/**
  * MyCircularQueue.java
  * Author : Archit Joshi
  * Version :
  * Revisions :
  */

class MyCircularQueue {
    public class Node{
        int val;
        Node next;

        public Node(int val){
            this.val = val;
            this.next = null;
        }
    }

    int size;
    Node head;
    Node tail;
    int currentsize;

    public MyCircularQueue(int k) {
        this.size = k;
        this.head = null;
        this.tail = null;
        this.currentsize = 0;
    }

    public boolean enQueue(int value) {
        // is full
        if(this.isFull()) {
            return false;
        } else if (this.isEmpty()) {
            this.head = new Node(value);
            this.tail = this.head;
        } else {
            Node node = new Node(value);
            this.tail.next = node;
            this.tail = node;
        }
        this.currentsize++;
        return true;
    }

    public boolean deQueue() {
        // is empty
        if(isEmpty()){
            return false;
        } else {
            this.head = this.head.next;
            this.currentsize--;
            return true;
        }
    }

    public int Front() {
        if(isEmpty()){
            return -1;
        } else {
            return this.head.val;
        }
    }

    public int Rear() {
        if(isEmpty()) {
            return -1;
        } else {
            return this.tail.val;
        }
    }

    public boolean isEmpty() {
        return this.currentsize == 0;
    }

    public boolean isFull() {
        return this.currentsize == this.size;
    }

    public static void main( String[] args ) {
        MyCircularQueue myCircularQueue = new MyCircularQueue(3);
        myCircularQueue.enQueue(1); // return True
        myCircularQueue.enQueue(2); // return True
        myCircularQueue.enQueue(3); // return True
        myCircularQueue.enQueue(4); // return False
        myCircularQueue.Rear();     // return 3
        myCircularQueue.isFull();   // return True
        myCircularQueue.deQueue();  // return True
        myCircularQueue.enQueue(4); // return True
        myCircularQueue.Rear();     // return 4
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */