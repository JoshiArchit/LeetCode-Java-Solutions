package Design.prb1472_Design_Browser_History;
/**
  * BrowserHistory.java
  * Author : Archit Joshi
  * Version :
  * Revisions :
  */

class BrowserHistory {
    public static class Node {
        String url;
        Node next;
        Node prev;

        public Node(String url, Node next, Node prev) {
            this.url = url;
            this.next = next;
            this.prev = prev;
        }
    }

    Node head;
    Node latest;

    public BrowserHistory(String homepage) {
        // head node to start traversal
        this.head = new Node( homepage, null, head );
        this.latest = head;
    }

    public void visit(String url) {
        // New node for visited url
        Node newnode = new Node(url, null, null);
        // Traverse to end of
        this.latest.next = newnode;
        newnode.prev = this.latest;
        this.latest = newnode;
    }

    public String back(int steps) {
        // use latest node and step back using prev pointers
        Node current = this.latest;
        while(steps > 0 && current.prev!=null) {
            current = current.prev;
            steps--;
        }

        this.latest = current;
        return current.url;
    }

    public String forward(int steps) {
        Node current = this.latest;
        while(steps > 0 && current.next!=null){
            current = current.next;
            steps --;
        }
        this.latest = current;
        return current.url;
    }

    public static void main( String[] args ) {
        BrowserHistory browserHistory = new BrowserHistory("leetcode.com");
        browserHistory.visit("google.com");       // You are in "leetcode.com". Visit "google.com"
        browserHistory.visit("facebook.com");     // You are in "google.com". Visit "facebook.com"
        browserHistory.visit("youtube.com");      // You are in "facebook.com". Visit "youtube.com"
        String result;
        result = browserHistory.back(1);                   // You are in "youtube.com", move back to "facebook.com" return "facebook.com"
        result = browserHistory.back(1);                   // You are in "facebook.com", move back to "google.com" return "google.com"
        result = browserHistory.forward(1);                // You are in "google.com", move forward to "facebook.com" return "facebook.com"
        browserHistory.visit("linkedin.com");     // You are in "facebook.com". Visit "linkedin.com"
        result = browserHistory.forward(2);                // You are in "linkedin.com", you cannot move forward any steps.
        result = browserHistory.back(2);                   // You are in "linkedin.com", move back two steps to "facebook.com" then to "google.com". return "google.com"
        result = browserHistory.back(7);                   // You are in "google.com", you can move back only one step to "leetcode.com". return "leetcode.com"
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */