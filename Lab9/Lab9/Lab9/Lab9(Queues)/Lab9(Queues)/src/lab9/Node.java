// Node.java
// Class from which we can create  node objects

package lab9;

public class Node {
    private int data;
    private Node next;
    
    // CONSTRUCTORS
    public Node() {
        data = 0;
        next = null;
    }
    
    public Node(int data) {
        this.data = data;
        next = null;
    }
    
    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    // ACCESSORS
    public int getData() {
        return data;
    }

    public Node getNext() {
        return next;
    }


    // MUTATORS
    public void setData(int data) {
        this.data = data;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
