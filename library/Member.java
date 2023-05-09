
import java.util.ArrayList;

class Member {
  private String id;
  private String name;
  private ArrayList<Book> borrowedBooks;

  public Member(String id, String name) {
    this.id = id;
    this.name = name;
    this.borrowedBooks = new ArrayList<>();
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void receiveBook(Book book) {
    borrowedBooks.add(book);
  }

  public void giveBook(Book book) {
    borrowedBooks.remove(book);
  }
}
