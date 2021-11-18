public class ListNode {
  public String data;
  public ListNode next;
  public ListNode previous;
  public static int totalNodes = 0;

  public ListNode(String string) {
    this(string, null);
  }

  public ListNode(String string, ListNode listNode) {
    this.data = string;
    this.next = listNode;
    totalNodes++;
  }

  public static void printNumNodes() {
    System.out.println(totalNodes + " have been created so far.");
  }

  public void printListFromHere() {
    System.out.println("----------\nStart List\n----------");
    ListNode currNode = this;
    while (currNode != null) {
      System.out.println("\t" + currNode.data);
      currNode = currNode.next;
    }
    System.out.println("----------\nEnd List\n----------");
  }

  public ListNode addNodeToBeginning(ListNode newNode) {
    this.previous = newNode;
    newNode.next = this;
    return newNode;
  }

  public void addNodeToEnd(ListNode newNode) {
    ListNode currNode = this;
    while (currNode.next != null) {
      currNode = currNode.next;
    }
    currNode.next = newNode;
    newNode.previous = currNode;
  }

  public void addNodeAfterNode(ListNode newNode, ListNode addAfter) {
    ListNode currNode = this;
    while (currNode != null && !currNode.data.equals(addAfter.data)) {
      currNode = currNode.next;
    }
    if (currNode != null) {
      newNode.next = currNode.next;
      newNode.previous = currNode;
      currNode.next.previous = newNode;
      currNode.next = newNode;
    }
  }

  public ListNode removeFirstNode() {
    if (this.next != null) this.next.previous = null;
    return this.next;
  }

  public ListNode removeLastNode() {
    if (this.next == null) return null;
    
    ListNode currNode = this;
    while (currNode.next != null) {
      currNode = currNode.next;
    }
    currNode.previous.next = null;
    return this;
  }

  public ListNode removeNode(ListNode toRemove) {
    if (this.data.equals(toRemove.data)) {
      if (this.next != null) this.next.previous = null;
      return this.next;
    }
    ListNode currNode = this;
    while (currNode.next != null && !currNode.next.data.equals(toRemove.data)) {
      currNode = currNode.next;
    }
    if (currNode.next != null) {
      currNode.next = currNode.next.next;
      currNode.next.previous = currNode;
    }
    return this;
  }

  public int getLength() {
    int length = 0;
    ListNode currNode = this;
    while (currNode != null) {
      length++;
      currNode = currNode.next;
    }
    return length;
  }

  public String concatenate() {
    ListNode currNode = this;
    String concatenated = "";
    while (currNode.next != null) {
      concatenated += currNode.data;
      concatenated += ", ";
      currNode = currNode.next;
    }
    concatenated += currNode.data;
    return concatenated;
  }

  public ListNode reverse() {
    ListNode currNode = this;
    while (currNode.next != null) {
      ListNode tempNode = currNode.next;
      currNode.next = currNode.previous;
      currNode = currNode.previous = tempNode;
    }
    currNode.next = currNode.previous;
    currNode.previous = null;
    return currNode;
  }
}