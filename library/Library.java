import java.util.ArrayList;

class Library {
  public ArrayList<Book> books = new ArrayList<Book>();
  public ArrayList<Member> members = new ArrayList<Member>();

  public Library() {
    this.books = new ArrayList<>();
    this.members = new ArrayList<>();
  }
  protected int getMemberIndex(Member member) {
    return this.members.indexOf(member);
  }

  protected Member getMemberById(String id) throws Exception {
    for (Member member : this.members) {
      if (member.getId().equals(id)) {
        return member;
      }
    }
    throw new Exception("Member " + id + " tidak ada");
  }

  protected Book getBookById(String id) throws Exception {
    for (Book book : this.books) {
      if (book.id.equals(id)) {
        return book;
      }
    }
    throw new Exception("Buku  " + id + " tidak ada");
  }

  public void addMember(Member member) {
    if (!isMemberIdExist(member.getId())) {
      this.members.add(member);
      System.out.println("Menambah Member Berhasil");
    } else {
      System.out.println("Member ID " + member.getId() + " sudah terpakai");
    }
  }

  public Boolean isMemberIdExist(String id) {
    for (Member member : this.members) {
      if (member.getId().equals(id)) {
        return true;
      }
    }
    return false;
  }

  // Menambahkan buku
  public void addBook(Book book) {
    if (!isBookIdExist(book.id)) {
      this.books.add(book);
      System.out.println(" Menambah Buku Berhasil.");
    } else {
      System.out.println("Buku ID " + book.id + " Sudah Ada");
    }
  }


  public Boolean isBookIdExist(String id) {
    for (Book book : this.books) {
      if (book.id.equals(id)) {
        return true;
      }
    }
    return false;
  }


  public void giveBook(String bookId, String memberId) {
    try {
      Book book = this.getBookById(bookId);
      Member member = this.getMemberById(memberId);
      int memberIndex = this.getMemberIndex(member);

      this.books.remove(book);
      this.members.get(memberIndex).getborrowedBooks().add(book);

      System.out.println("Buku dengan ID " + book.id + " telah berhasil dipinjam oleh member dengan ID " + member.getId());
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  public void receiveBook(String bookId, String memberId) {
    try {
      Member member = this.getMemberById(memberId);
      int memberIndex = this.getMemberIndex(member);

      Book book = this.members.get(memberIndex).getBookById(bookId);

      this.books.add(book);
      this.members.get(memberIndex).borrowedBooks.remove(book);

      System.out.println("Buku " + book.id + " berhasil dikembalikan oleh member " + member.getId());
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
}
