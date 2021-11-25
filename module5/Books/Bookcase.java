public class Bookcase {
  private static int bookCapacity = 50;
    
  private Book[] books;
    
  public Bookcase() {
    this.books = new Book[bookCapacity];
  }
    
  public boolean addBook(Book newBook, int shelf) {
    // validate shelf, and if book isn't already in a bookcase or being read
    if (shelf < 0 || shelf > 4
      || newBook.bookcase != null
      || newBook.reader != null) { return false; }

    int arrayPosition = shelf * 10;

    // there's 10 potential places on the shelf for the book, let's see if we can find a vacant spot
    for (int i = 0; i < 9; i++) {
      if (this.books[arrayPosition] == null) break;
      arrayPosition++;
    }

    if (this.books[arrayPosition] == null) {
      this.books[arrayPosition] = newBook;
      newBook.bookcase = this;
      return true;
    } else {
      return false;
    }
  }

  public Book takeBook(Book toTake, int shelf) {
    if (shelf < 0 || shelf > 4) { return null; }
    Book found = null;
    int arrayPosition = shelf * 10;

    for (int i = 0; i < 9; i++) {
      if (books[arrayPosition] != null && books[arrayPosition] == toTake) {
        found = books[arrayPosition];
        books[arrayPosition] = null;
        break;
      }
      arrayPosition++;
    }
    return found;
  }

  public String toString() {
    String toReturn = new String();
    for (int i = 0; i <= 4; i++) {
      if (i != 0) toReturn += "\n";
      toReturn += "Shelf " + i + " contains: ";
      String shelfContents = "";
      int arrayPosition = i * 10;
      int endArrayPosition = arrayPosition + 9;

      for (int i2 = arrayPosition; i2 <= endArrayPosition; i2++) {
        if (this.books[i2] != null) shelfContents += "\n - " + this.books[i2];
      }
      if (shelfContents == "") shelfContents = "no books"; 
      toReturn += shelfContents;
    }
    return toReturn;
  }
}