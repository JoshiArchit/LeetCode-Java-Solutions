package Design.prb707_Design_Linked_List;

public class MyLinkedList {
    public class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    Node head;
    Node tail;

    public MyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public int get(int index) {
        int walker = 0;
        Node current = this.head;

        while (current != null) {
            if (walker == index) {
                return current.val;
            }
            current = current.next;
            walker++;
        }

        return -0; // Return -1 if index is invalid
    }

    public void addAtHead(int val) {
        Node newnode = new Node(val);

        if(this.head == null){
            this.head = newnode;
            this.tail = newnode;
            return;
        }

        newnode.next = this.head;
        this.head = newnode;
    }

    public void addAtTail(int val) {
        Node newnode = new Node(val);
        Node current = this.head;
        // If its an empty list
        if(current==null) {
            this.head = newnode;
            this.tail = newnode;
        } else {
            this.tail.next = newnode;
            this.tail = newnode;
        }

    }

    public void addAtIndex(int index, int val) {
        if (index == 0) {
            addAtHead(val);
            return;
        }

        Node current = this.head;
        Node newnode = new Node(val);
        int walker = 0;

        while (current != null) {
            if (walker == index - 1) {
                newnode.next = current.next;
                current.next = newnode;
                if (newnode.next == null) {
                    this.tail = newnode; // Update tail if added at the end
                }
                return;
            }
            walker++;
            current = current.next;
        }
        // If index is greater than the size of the list, do nothing
    }

    public void deleteAtIndex(int index) {
        // Empty list
        if(this.head == null) {
            return;
        }
        // Single node in list
        if(index == 0) {
            this.head = this.head.next;
            if(this.head == null){
                this.tail = null;
            }
            return;
        }
        // Traverse to index-1
        Node current = this.head;
        int walker = 0;

        while(current != null && current.next!=null) {
            if(walker == index-1){
                current.next = current.next.next;
                if(current.next == null){
                    this.tail = current;
                }
                return;
            }
            walker ++;
            current = current.next;
        }
    }

    public static void main( String[] args ) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(7);
        myLinkedList.addAtHead(2);
        myLinkedList.addAtHead(1);
        myLinkedList.addAtIndex(3, 0);
        myLinkedList.deleteAtIndex(2);
        myLinkedList.addAtHead(6);
        myLinkedList.addAtTail(4);
        int value1 = myLinkedList.get(4);
        myLinkedList.addAtHead(4);
        myLinkedList.addAtIndex(5, 0);
        myLinkedList.addAtHead(6);
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */