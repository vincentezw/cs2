public class Book {
  public Reader reader; 
  public Bookcase bookcase;

  private String title;
  private String author;
  private int isbn;
    
  public Book(String title, String author, int isbn) {
    this.title = title;
    this.author = author;
    this.isbn = isbn;
  }

  public String toString() {
    return this.title + " by " + this.author + " (ISBN: " + this.isbn + ")";
  }
}