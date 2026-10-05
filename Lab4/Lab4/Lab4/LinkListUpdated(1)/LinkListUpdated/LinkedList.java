// LinkedList.java
public class LinkedList {
    // head isa reference variable (i.e. class variable) to the first node of the
    // list

    private LLnode head;

    // CONSTRUCTORS
    public LinkedList() {
        head = null;
    }

    public boolean isEmpty() {
        return head == null; // If head is null, it returns true otherwise false
    }

    public int countNodes() {
        return countNodes(head);
    }

    private int countNodes(LLnode head) {
        LLnode helpPtr = head;
        int count = 0;
        while (helpPtr != null) {
            count++;
            helpPtr = helpPtr.getNext();
        }

        return count;
    }

    public void PrintEvenNodes() {
        PrintEvenNodes(head);
    }

    private void PrintEvenNodes(LLnode head) {
        LLnode helpPtr = head;
        while (helpPtr != null) {
            if (helpPtr.getData() % 2 == 0)
                System.out.print(helpPtr.getData() + ", ");
            helpPtr = helpPtr.getNext();
        }
        System.out.println();
    }

    public boolean search(int data) { // Gets only the data to be searched, from calling method
        return search(head, data); // Sends reference to the first node and the data to be searched,
                                   // to another overloaded ‘Search’ method, which will return
                                   // ‘true’ if that data is found, otherwise it will return false
    }
    //
    // boolean | search(LLnode, int)
    //

    private boolean search(LLnode p, int data) { // Gets reference of first node and data to be
                                                 // searched, from calling method(Previous
                                                 // Search method) and returns Boolean value
        LLnode helpPtr = p; // Assigns received reference to another reference variable ‘helpPtr’
        while (helpPtr != null) {
            if (helpPtr.getData() == data) { // If data is found
                return true;
            }
            helpPtr = helpPtr.getNext(); // Goes to next node in the list
        }
        return false; // If data is not found after traversing the entire link list
    }

    //
    // boolean | findNode(int)
    //
    public LLnode findNode(int data) { // Gets the ‘data’ to be searched
        return findNode(head, data); // Calls another method findNode() by passing it the
                                     // reference variable ‘head’ and the data to be found
    }
    //
    // boolean | findNode(LLnode, int) //Used for finding the required data
    // This method has not been used in this program

    private LLnode findNode(LLnode p, int data) { // Receives reference variable for traversing
                                                  // the entire link list and the data to be found
        LLnode helpPtr = p; // Assigns received reference to another reference variable ‘helpPtr’
        while (helpPtr != null) { // Traverses the entire link list
            if (helpPtr.getData() == data) { // If the required data is found
                return helpPtr; // Returns reference i.e. pointer to that node
            }
            helpPtr = helpPtr.getNext(); // For moving to next node
        }
        return null; // If required data is not found
    }

    //
    // void | PrintList()
    //

    public void PrintList() {
        PrintList(head); // Calling another method PrintList() by passing it reference variable
                         // ‘head’ for traversing the entire link list
    }
    //
    // void | PrintList(LLnode)
    //

    private void PrintList(LLnode head) { // Receives reference variable for traversing
        // We need to traverse...so we need a help pointer
        LLnode helpPtr = head;

        while (helpPtr != null) {
            // Print the data value of the node
            System.out.print(helpPtr.getData() + ", ");
            // Moving to next node
            helpPtr = helpPtr.getNext();
        }
        System.out.println();
    }

    //
    // void | ModifyAllNodes()
    //
    public void ModifyAllNodes() {
        ModifyAllNodes(head); // Passing reference variable to another method
    }
    //
    // void | ModifyAllNodes(LLnode)
    //

    private void ModifyAllNodes(LLnode head) { // Takes reference variable
        // We need to traverse...so we need a help pointer
        LLnode helpPtr = head; // Assigns reference of first node to some other reference
                               // variable ‘helpPtr’ which will be used to traverse the link list
        // Traverse to correct insertion point
        while (helpPtr != null) {
            // We add 10 to the data value of each node
            helpPtr.setData(helpPtr.getData() + 10); // Adding 10 to the data field of each node
            // Step one node over
            helpPtr = helpPtr.getNext();
        }
    }

    //
    // int | sumNodes()
    //

    public int sumNodes() { // It will be used to find the sum of all data elements of all nodes
        return sumNodes(head); // Passing reference variable to another method
    }
    //
    // int | sumNodes(LLnode) //For finding the sum of all nodes.
    // This method has not been used here

    private int sumNodes(LLnode head) {
        // We need to traverse...so we need a help ptr
        LLnode helpPtr = head; // Assigns reference of first node to some other reference
                               // variable ‘helpPtr’ which will be used to traverse the link list

        int sum = 0; // Variable for holding the sum of all data elements
        // Traverse to correct insertion point
        while (helpPtr != null) {
            // Increase sum
            sum += helpPtr.getData();
            // Step one node over
            helpPtr = helpPtr.getNext(); // Moves to next node
        }
        return sum;
    }

    //
    // void | insert(int)
    //
    public void insert(int data) { // Takes only data to be inserted
        head = insert(head, data); // Calls another insert() method by passing it the reference
                                   // variable ‘head’ (pointing to first node) for traversing the link
                                   // list and the data to be inserted at the proper location
    }
    //
    // LLnode | insert(LLnode, value)
    //

    private LLnode insert(LLnode head, int data) { // Receives reference variable and data
        // IF there is no list, newNode will be the first node, so just return it
        if (head == null || head.getData() > data) {// If head is null i.e. there is no node or if there
                                                    // is only one node whose data is greater than
                                                    // the data we want to insert (as we want an
                                                    // ascending ordered data)
            head = new LLnode(data, head); // Creates new node with data and reference variable
                                           // head which was previously null (if there was no
                                           // node) or pointing to the previously existing
            // only node and then assigns its address to the reference variable ‘head’ so
            // that
            // head will be pointing to this newly created node which has now become the
            // first node in the list i.e. it will always add new node to the front of link
            // list
            return head;
        } // ELSE, we have a list. Insert the new node at the correct location

        else {
            // We need to traverse to the correct insertion location...so we need a help ptr
            LLnode helpPtr = head;

            // Traverse to correct insertion point
            while (helpPtr.getNext() != null) { // Traversing the entire link list
                if (helpPtr.getNext().getData() > data) { // if data of next (i.e. successor) node is
                    // greater than the data we want to insert after the current node
                    break; // we found our spot and should break out of the while loop
                }
                helpPtr = helpPtr.getNext();
            }
            // Now make the new node. Set its next to point to the successor node.
            // And then make the predecessor node point to the new node
            LLnode newNode = new LLnode(data, helpPtr.getNext()); // Creates a newNode and
                                                                  // sets its ‘next’ field to point to the successor
                                                                  // node
            helpPtr.setNext(newNode); // Making predecessor node (which helpPtr points to) point
                                      // to the newly created node
        }
        // Return head
        return head;
    }

    //
    // void | delete(int)
    //
    public void delete(int data) { // Takes data to be deleted
        head = delete(head, data);// Passes the reference variable ‘head’ for traversing the entire
                                  // link list and data to be deleted. It will return the reference of
                                  // the next node
    }
    //
    // LLnode | delete(LLnode, value)
    //

    private LLnode delete(LLnode head, int data) {
        // We can only delete if the list has nodes (is not empty)
        if (!isEmpty()) {
            // IF the first node (at the head) has the data value we are wanting to delete
            // we found it. Delete by skipping the node and making head point to the next
            // node.
            if (head.getData() == data) {
                head = head.getNext(); // Head will now point to the next node in the list
            } // ELSE, the data is perhaps somewhere else in the list...so we must traverse
              // and
              // look for it
            else {
                // We need to traverse to find the data we want to delete...so we need a help
                // ptr
                LLnode helpPtr = head; // reference variable helpPtr will be used to traverse and
                                       // delete the required node
                // Traverse to correct deletion point

                while (helpPtr.getNext() != null) {
                    if (helpPtr.getNext().getData() == data) {// Comparing the data of next node
                                                              // (successor of current node) with the
                                                              // data to be deleted
                        helpPtr.setNext(helpPtr.getNext().getNext()); // Skipping the deleted node
                        break; // we deleted the value and should break out of the while loop
                    }
                    helpPtr = helpPtr.getNext();
                } // End of while
            } // End of else part
              // return the possibly updated head of the list
            return head; // Returns reference of the first node
        } // End of outer most if
        return head; // If list becomes empty, it returns null as the value of reference variable
                     // ‘head’
    }

    // Method to check whether there is only one node in the list

    public boolean OneNode() {
        return OneNode(head);
    }

    private static boolean OneNode(LLnode head) {
        return (head.getNext() == null);
    }

    public boolean LastNode(int data) {
        return LastNode(head, data);
    }

    private static boolean LastNode(LLnode head, int data) {
        LLnode helpPtr = head;
        while (helpPtr.getNext() != null) {
            helpPtr = helpPtr.getNext();
        }
        if (helpPtr.getData() == data) {
            return true;
        } else {
            return false;
        }
    }

    // Write code in the following method to swap first and last node in the linked
    // list

    public void swapFirstLast() {
        swapFirstLast(head);
    }

    private void swapFirstLast(LLnode head) {

        LLnode first = head; // Reference to the first node
        LLnode helpPtr = head; // helpPtr will be used to reach the last node

        // Save the data of the first node BEFORE overwriting it
        int firstData = first.getData();

        // Traverse to the last node (the node whose next is null)
        while (helpPtr.getNext() != null) {
            helpPtr = helpPtr.getNext();
        }

        // Swap the data values of the first node and the last node
        first.setData(helpPtr.getData());
        helpPtr.setData(firstData);
    }

    // Write code in the following method to count even and odd nodes in the linked
    // list
    public void countEvenOddNodes() {
        countEvenOddNodes(head);
    }

    private void countEvenOddNodes(LLnode head) {
        int EvenNodes = 0;
        int OddNodes = 0;

        LLnode helpPtr = head;

        while (helpPtr != null) {
            if (helpPtr.getData() % 2 == 0) {
                EvenNodes++;
            } else {
                OddNodes++;
            }
            helpPtr = helpPtr.getNext();
        }

        System.out.println("Number of even nodes in the list is " + EvenNodes);
        System.out.println("Number of odd nodes in the list is " + OddNodes);
    }

    // Write code in the following method to insert a node after some specific node
    // in the linked list
    public void addNodeAfter(int data, int addvalue) {
        addNodeAfter(head, data, addvalue);
    }

    private void addNodeAfter(LLnode head, int data, int addvalue) {
        LLnode helpPtr = head;

        int index = 1;
        LLnode newNode = new LLnode(addvalue);
        while (helpPtr != null) {
            if (index == data) {
                newNode.setNext(helpPtr.getNext());
                helpPtr.setNext(newNode);
            }
            helpPtr = helpPtr.getNext();
            index++;
        }
    }

    // Write code in the following method to delete a node after some specific node
    // in the linked list
    public void deleteNodeAfter(int data) {
        deleteNodeAfter(head, data);
    }

    private void deleteNodeAfter(LLnode head, int data) {
        LLnode helpPtr = head;

        int index = 1;
        while (helpPtr != null) {
            if (index == data) {
                helpPtr.setNext(helpPtr.getNext().getNext());
            }
            helpPtr = helpPtr.getNext();
            index++;
        }
    }

}
