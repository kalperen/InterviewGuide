class LinkedList {
  Node<E> head;

  public LinkedList(Node<E> head) {
    this.head = head;
  }

  public inserAtBeggining(E element){
    // create new node
    Node<E> newNode = new Node<E>();
    //make the new node point to the current first node
    newNode.setNext(head);
    //make the head reference point to the new first node
    head = newNode;
    //update the size variable (if it exists)
    size++;
  }
  public insertAtEnd(E element){
    // create new node
    Node<E> newNode = new Node<E> ( );
    //create the current reference and point it to the last node
    Node<E> current = head;
    while (current.next != null )
      current = current.next;
    //make the new node point to null
    newNode.next = null;
    //make the last node point to the new last node
      current.next = newNode;
    //update the size variable (if it exists) size++;
  }
  public insertInMiddle(E element){
    // create new node
    Node<E> newNode = new Node<E> ( );
    //create the current reference and advance it to //the node after which we want to insert
    Node<E> current = head;
    ... //depends on specifics of the problem
    //make the new node point to its successor
    newNode.next = current.next;
    //make the current node point to the new node
    current.next = newNode;
  }

  public removeFromBeginning() {
    //point the head reference to the second node if ( head != null )
    head = head.next;
    size--;
  }

  public removeFromEnd() {
    //create a current reference and advance it to the one // before the last node
    Node<E> current;
    current = head;
    //assume that there are at least two nodes in the list
    //(otherwise we are deleting the first node) while ( current.next.next != null )
    current = current.next;
    //disconnect the last node by pointing the one // before it to null
    current.setNext(null); size--;
  }

  public removeFromMiddle() {
    //create a current reference and advance it to the one // before the node to be deleted
    Node<E> current;
    current = head;
    ... //depends on specifics of the problem
    //connect the node pointed to by current with the node
    //pointed to be the node being deleted current.setNext(current.getNext().getNext() );
    size--;
  }

}
