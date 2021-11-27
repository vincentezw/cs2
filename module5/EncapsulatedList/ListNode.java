public class ListNode {
  private ReadThis data;    
  private ListNode next;
    
  public ListNode(ReadThis newData) {
    this(newData, null);
  }

  public ListNode(ReadThis newData, ListNode nextNode) {
    this.data = newData;
    this.next = nextNode;
  }

  public ListNode getNext() {
    return this.next;
  }
  public void setNext(ListNode next) {
    this.next = next;
  }

  public String toString() {
    return this.data.toString();
  }
}