public class TestClass {
  public static void main(String[] args) {
    // Here are some objects we can store in our lists...
        
    ReadThis r1 = new ReadThis("http://www.bustle.com/articles/" +
                                "63466-im-brianna-wu-and-im-risking-" +
                                "my-life-standing-up-to-gamergate");
        
    ReadThis r2 = new ReadThis("http://i.imgur.com/4NjBQzn.jpg");
        
    ReadThis r3 = new ReadThis("http://imgur.com/zhppgSx");
    ReadThis r4 = new ReadThis("http://gnuu.org/2009/09/18/writing-" +
                               "your-own-toy-compiler/all/1/");
    ReadThis r5 = new ReadThis("https://gigaom.com/2015/02/10/samsung-" +
                              "tvs-start-inserting-ads-into-your-movies/");

    LinkedList list = new LinkedList(r2);
    list.addDataToBeginning(r1);
    list.addDataToEnd(r4);
    list.printNumItems();
    list.printList();
    list.printFromHere(2);

    list.addDataToPosition(r3, 2);
    list.addDataToPosition(r5, 4);
    list.printList();

    list.removeFirstItem();
    list.removeLastItem();
    list.printList();
      
    list.removeItemFromPosition(1);
    list.printList();
    list.printNumItems();
  }  
}