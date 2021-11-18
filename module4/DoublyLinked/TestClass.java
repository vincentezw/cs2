public class TestClass {
  public static void main(String[] args) {
    ListNode listNode;
    String string = "Alpha";
    String string2 = "Beta";
    String string3 = "Charly";
    String string4 = "Delta";
    String string5 = "Eagle";

    ListNode listNode2 = new ListNode(string3);
    ListNode listHead = new ListNode(string2, listNode2);
    listNode2.previous = listHead;
    listNode2 = null;
    listHead.printListFromHere();

    System.out.println("** add Alpha to the start, add Delta to the end **");
    listHead = listHead.addNodeToBeginning(new ListNode(string));
    listHead.addNodeToEnd(new ListNode(string4));
    System.out.println(listHead.concatenate());

    System.out.println("** add Eagle after Beta, remove the last node **");
    listHead.addNodeAfterNode(new ListNode(string5), listHead.next);
    listHead = listHead.removeLastNode();
    System.out.println(listHead.concatenate());

    System.out.println("** reverse the list **");
    listHead = listHead.reverse();
    System.out.println(listHead.concatenate());

    System.out.println("** remove first and last node **");
    listHead = listHead.removeFirstNode();
    listHead = listHead.removeLastNode();
    System.out.println(listHead.concatenate());

    System.out.println("** add Alpha and Delta to the end, the remove the second (Beta) **");
    listHead.addNodeToEnd(new ListNode(string));
    listHead.addNodeToEnd(new ListNode(string4));
    listHead = listHead.removeNode(listHead.next);

    System.out.println(listHead.concatenate());
    listHead = listHead.removeNode(listHead);
    listHead = listHead.removeNode(listHead);
    listHead = listHead.reverse();
    System.out.println(listHead); //<- should be null!
  }
}