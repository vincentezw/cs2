public class LinkedList {
  private int totalNodes = 1;
  private ListNode firstNode;

  public LinkedList(ReadThis data) {
    this.firstNode = new ListNode(data);
  }

  private boolean checkPosition(int position) {
    if (position < 0 || position > totalNodes) {
      System.out.println("Error: invalid position");
      return false;
    }
    return true;
  }

  public void addDataToBeginning(ReadThis data) {
    ListNode newNode = new ListNode(data, firstNode);
    firstNode = newNode;
    totalNodes++;
  }

  public void addDataToEnd(ReadThis data) {
    ListNode newNode = new ListNode(data);
    ListNode currNode = this.firstNode;
    while (currNode.getNext() != null) {
      currNode = currNode.getNext();
    }
    currNode.setNext(newNode);
    totalNodes++;
  }

  public void addDataToPosition(ReadThis data, int position) {
    if (!this.checkPosition(position)) { return; }
    ListNode currNode = this.firstNode;
    int i = 0;
    while (currNode != null && i != position-1) {
      currNode = currNode.getNext();
      i++;
    }
    if (currNode != null) {
      ListNode newNode = new ListNode(data);
      newNode.setNext(currNode.getNext());
      currNode.setNext(newNode);
      totalNodes++;
    }
  }

  public void removeFirstItem() {
    if (this.firstNode != null) {
      this.firstNode = this.firstNode.getNext();
      totalNodes--;
    }
  }

  public void removeLastItem() {
    if (this.firstNode.getNext() == null) { this.removeFirstItem(); }
    else {
      ListNode prevNode = null;
      ListNode currNode = this.firstNode;
      while (currNode.getNext() != null) {
        prevNode = currNode;
        currNode = currNode.getNext();
      }
      prevNode.setNext(null);
      totalNodes--;
    }
  }

  public void removeItemFromPosition(int position) {
    if (!this.checkPosition(position)) { return; }

    if (this.firstNode.getNext() == null) { this.removeFirstItem(); }
    else {
      ListNode prevNode = null;
      ListNode currNode = this.firstNode;
      int i = 0;
      while (currNode.getNext() != null && i != position) {
        prevNode = currNode;
        currNode = currNode.getNext();
        i++;
      }
      prevNode.setNext(currNode.getNext());
      totalNodes--;
    }
  }

  public void printNumItems() {
    System.out.println(totalNodes + " nodes have been created so far.");
  }

  public void printList() {
    this.printFromHere(0);
  }

  public void printFromHere(int position) {
    if (!this.checkPosition(position)) { return; }

    System.out.println("----------\nStart List from " + position + "\n----------");
    ListNode currNode = this.firstNode;
    int i = 0;
    while (currNode != null) {
      if (i >= position) { System.out.println("\t" + currNode); }
      currNode = currNode.getNext();
      i++;
    }
    System.out.println("----------\nEnd List\n----------");
  }
}