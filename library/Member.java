import java.util.ArrayList;

interface reading {
  void receiveBook(Book book);

  void giveBook(Book book);

}
interface reading1 {
  Book getBookById(String id);
}

class Member implements reading,reading1 {
  String id;
  String name;
  ArrayList<Book> borrowedBooks;

  public Member() {
    this.id = id;
    this.name = name;
    this.borrowedBooks = new ArrayList<Book>();
  }

  public String getId() {
    return id;
  }


  public ArrayList<Book> getborrowedBooks() {
    return borrowedBooks;
  }

  public void receiveBook(Book book) {
    this.borrowedBooks.add(book);
  }

  public void giveBook(Book book) {
    this.borrowedBooks.remove(book);
  }

  public Book getBookById(String id) {
    for (Book book : this.borrowedBooks) {
      if (book.id.equals(id)) {
        return book;
      }
    }
    return null;
  }
}