

import java.util.ArrayList;

class Library {
  private ArrayList<Book> books;
  private ArrayList<Member> members;

  public Library() {
    this.books = new ArrayList<>();
    this.members = new ArrayList<>();
  }

  public ArrayList<Book> getBooks() {
    return books;
  }

  public ArrayList<Member> getMembers() {
    return members;
  }

  public void addMember(Member member) {
    if (!isMemberIdExist(member.getId())) {
      members.add(member);
      System.out.println("Member added successfully.");
    } else {
      System.out.println("Member with the same ID already exists.");
    }
  }

  public void addMember(String memberId, String memberName) {
    Member member = new Member(memberId, memberName);
    addMember(member);
  }

  public boolean isMemberIdExist(String id) {
    for (Member member : members) {
      if (member.getId().equals(id)) {
        return true;
      }
    }
    return false;
  }

  public void addBook(Book book) {
    if (!isBookIdExist(book.getId())) {
      books.add(book);
      System.out.println("Book added successfully.");
    } else {
      System.out.println("Book with the same ID already exists.");
    }
  }

  public void addBook(String bookId, String bookTitle) {
    Book book = new Book(bookId, bookTitle);
    addBook(book);
  }

  public boolean isBookIdExist(String id) {
    for (Book book : books) {
      if (book.getId().equals(id)) {
        return true;
      }
    }
    return false;
  }

  public void giveBook(String bookId, String memberId) {
    try {
      Book book = getBookById(bookId);
      books.remove(book);

      Member member = getMemberById(memberId);
      if (member != null) {
        member.receiveBook(book);
        System.out.println("Book borrowed successfully.");
      } else {
        System.out.println("Invalid memberId. Please try again.");
      }
    } catch (NullPointerException e) {
      System.out.println("Invalid bookId. Please try again.");
    }
  }

  public void receiveBook(String bookId, String memberId) {
    try {
      Book book = getBookById(bookId);
      books.add(book);

      Member member = getMemberById(memberId);
      if (member != null) {
        member.giveBook(book);
        System.out.println("Book returned successfully.");
      } else {
        System.out.println("Invalid memberId. Please try again.");
      }
    } catch (NullPointerException e) {
      System.out.println("Invalid bookId. Please try again.");
    }
  }

  private Member getMemberById(String id) {
    for (Member member : members) {
      if (member.getId().equals(id)) {
        return member;
      }
    }
    return null;
  }

  private Book getBookById(String id) {
    for (Book book : books) {
      if (book.getId().equals(id)) {
        return book;
      }
    }
    return null;
  }
}