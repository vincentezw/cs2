public class BookcaseTest{
  public static void main(String args[]) {

    Bookcase bookcase = new Bookcase();

    Book book1 = new Book("Beartown", "Fredrik Backman", 1234);
    Book book2 = new Book("The Dice Man", "George Cockcroft", 43435);
    Book book3 = new Book("The Great Shark Hunt", "Hunter S Thompson", 89232);
    Book book4 = new Book("Call of the Wild", "Jack London", 89232);
    Book book5 = new Book("The Great Gatsby", "Scott F FitzGerald", 89232);

    Reader reader1 = new Reader("Vincent", book1);
    Reader reader2 = new Reader("Zoe");

    if (!bookcase.addBook(book1, 0)) System.out.println("Error: book 1 is being read by someone");
    if (bookcase.addBook(book2, 0)) System.out.println("book 2 added");
    if (bookcase.addBook(book3, 0)) System.out.println("book 3 added");
    if (bookcase.addBook(book4, 1)) System.out.println("book 4 added");
    if (bookcase.addBook(book5, 1)) System.out.println("book 5 added");
    // this will not work, because the book is already in a bookcase
    if (!bookcase.addBook(book1, 1)) System.out.println("Error: book 1 is already in a bookcase");

    // this will throw an error, because reader is already reading book1
    if (! reader1.takeBook(book3, bookcase, 1)) System.out.println("Reader 1 already has a book");
    
    if (reader2.takeBook(book3, bookcase, 0)) System.out.println("Reader 2 now has a book");

    if (reader1.putBookBack(bookcase, 2)) System.out.println("The book is put back");
    reader1.takeBook(book4, bookcase, 1);

    // print our stuff
    System.out.println(reader1);
    System.out.println(reader2);
    System.out.println(bookcase);
  }
}