package Design.prb706_Design_Hashmap;

/**
  * MyHashMap.java
  * Author : Archit Joshi
  * Version :
  * Revisions :
  */

class MyHashMap {

    // Iteration 2 - Using LinkedLists for faster travel
    class Node {
        public int key;
        public int val;
        public Node next;

        public Node( int key, int val) {
            this.key = key;
            this.val = val;
            this.next = null;
        }

        public Node(int key, int val, Node next){
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    // Create a list of Nodes
    public Node[] map;
    public MyHashMap() {
        this.map = new Node[10];
    }

    // Hashfunction
    public int getIndex(int key){
        return key%1000;
    }

    // Put method. Check if node with key exists, else create one
    public void put(int key, int value){
        // Get hash key
        int index = getIndex(key);

        // Traverse to requested node
        Node current = map[index];

        // Null position
        if(current == null){
            map[index] = new Node(key, value);
            return;
        }
        while(current!=null) {
            if(current.key==key){
                current.val = value;
                return;
            }
            current = current.next;
        }

        // Key doesnt exist, create Node and set as head
        Node newnode = new Node(key, value, map[index]);
        map[index] = newnode;
    }

    public int get(int key){
        // Get hashed index
        int index = getIndex( key );

        // Traverse list till index
        Node current = map[index];      // Start at head
        while(current != null){
            if(current.key == key){
                return current.val;
            }
            current = current.next;
        }

        // No value for associated key
        return -1;
    }

    public void remove(int key){
        // Get hashed index
        int index = getIndex( key );

        // Traverse to key, keep note previous
        Node current = map[index];
        Node previous = null;

        while(current!=null){
            if(current.key == key){
                // Set previous to point to current.next and set current.next = null
                // First node
                if(previous == null){
                    // remove head
                    map[index] = current.next;
                } else {
                    // Skip current and set previous to point to next
                    previous.next = current.next;
                }
                return;
            }

            previous = current;
            current = current.next;
        }
    }

    public static void main( String[] args ) {
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put(1, 1); // The map is now [[1,1]]
        myHashMap.put(2, 2); // The map is now [[1,1], [2,2]]
        myHashMap.get(1);    // return 1, The map is now [[1,1], [2,2]]
        myHashMap.get(3);    // return -1 (i.e., not found), The map is now [[1,1], [2,2]]
        myHashMap.put(2, 1); // The map is now [[1,1], [2,1]] (i.e., update the existing value)
        myHashMap.get(2);    // return 1, The map is now [[1,1], [2,1]]
        myHashMap.remove(2); // remove the mapping for 2, The map is now [[1,1]]
        myHashMap.get(2);    // return -1 (i.e., not found), The map is now [[1,1]]
    }
}