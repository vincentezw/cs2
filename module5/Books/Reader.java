public class Reader {
  private String name;
  private Book currentlyReading;
    
  public Reader(String newName) {
    this(newName, null);
  }

  public Reader(String newName, Book newBook) {
    name = newName;
    currentlyReading = newBook;
    // flag that the book is with a reader
    if (newBook != null) newBook.reader = this;
  }

  public boolean takeBook(Book toTake, Bookcase fromBookcase, int shelf) {
    if (this.currentlyReading != null) return false;

    Book taken = fromBookcase.takeBook(toTake, shelf);
    if (taken != null) {
      taken.reader = this;
      this.currentlyReading = taken;
      return true;
    } else { return false; }
  }

  public boolean putBookBack(Bookcase bookcase, int shelf) {
    if (this.currentlyReading == null ||
      (shelf < 0 || shelf > 4)) { return false; }

    this.currentlyReading.reader = null;
    if (bookcase.addBook(this.currentlyReading, shelf)) {
      this.currentlyReading = null;
      return true;
    } else {
      // couldn't put it back for some reason, own the book again
      this.currentlyReading.reader = this;
      return false;
    }
  }
    
  public String toString() {
    String toReturn = "Reader: " + name;
    if (currentlyReading != null) {
      toReturn += " is currently reading " + currentlyReading;
    }
    return toReturn;
  }
}