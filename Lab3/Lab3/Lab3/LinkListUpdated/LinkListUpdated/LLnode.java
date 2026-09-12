// LLnode.java for creating a node
package LinkListUpdated;

public class LLnode {
    private int data; // Data element of the node
    private LLnode next; // Reference variable of type LLnode which
                         // stores a reference to the next node in
                         // the list i.e to establish a link to the
                         // next node. So it is a class variable

    // CONSTRUCTORS
    public LLnode() { // Initializes the data and link to the next
                      // node
        data = 0;
        next = null; // Initially every node will contain 0 and its
                     // next field will point to null
    }

    // Used for inserting new node at the end of existing linked list
    public LLnode(int data) {
        this.data = data; // Assigns new data to the newly created
                          // node
        next = null;
    }

    // Used for inserting new node at the front or anywhere in the existing //linked
    // list
    public LLnode(int data, LLnode next) {
        this.data = data; // Puts whatever is in data to the data
                          // field of newly created node
        this.next = next; // Puts whatever is in next to the next
                          // field of newly created data i.e. links
                          // the newly created node with the existing one
    }

    // ACCESSORS for getting the data of the currentnode
    public int getData() {
        return data;
    }

    public LLnode getNext() {
        return next; // Returns reference of the next field of
                     // currentnode. It may be null or containing
                     // reference (i.e. link to next node) in list
    }

    // MUTATORS for changing the data of the current node
    public void setData(int data) {
        this.data = data; // Sets the data field of current node
                          // with new data
    }

    public void setNext(LLnode next) {
        this.next = next; // Sets the next field of current node
                          // with the new reference
    }
}
