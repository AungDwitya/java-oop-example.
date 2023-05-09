import java.util.Scanner;

public class main {
    static Scanner scan = new Scanner(System.in);
    static Library library = new Library();

    public static void main(String[] args) {
        initLibraryData();

        String isContinue = "y";

        while (isContinue.equals("y")) {
            showMenu();
            int selectedMenu = chooseMenu();

            if (selectedMenu == 1) {
                showBooks();
            } else if (selectedMenu == 2) {
                showMembers();
            } else if (selectedMenu == 3) {
                addMember();
            } else if (selectedMenu == 4) {
                borrowBook();
            } else if (selectedMenu == 5) {
                returnBook();
            } else if (selectedMenu == 6) {
                addBook();
            } else {
                System.out.println("Wrong input");
            }

            System.out.print("Continue? (y/n): ");
            isContinue = scan.next();
        }
    }

    public static void showMenu() {
        System.out.println("================================");
        System.out.println("1. Show book list");
        System.out.println("2. Show member list");
        System.out.println("3. Add member");
        System.out.println("4. Borrow book");
        System.out.println("5. Return book");
        System.out.println("6. Add book");
        System.out.println("================================");
    }

    public static void initLibraryData() {
        Book book1 = new Book("1", "Pemrograman Java");
        Book book2 = new Book("2", "Pemrograman OOP");
        Book book3 = new Book("3", "Pemrograman Android");

        Member member1 = new Member("1", "Aka");
        Member member2 = new Member("2", "Budi");
        Member member3 = new Member("3", "Tono");

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        library.addMember(member1);
        library.addMember(member2);
        library.addMember(member3);
    }

    public static int chooseMenu() {
        System.out.print("Choose menu: ");
        int pilihan = scan.nextInt();
        return pilihan;
    }

    public static void showBooks() {
        System.out.println("Books List:");
        for (Book book : library.getBooks()) {
            System.out.println(book.getId() + " " + book.getTitle());
        }
    }

    public static void showMembers() {
        System.out.println("Members List:");
        for (Member member : library.getMembers()) {
            System.out.println(member.getId() + " " + member.getName());
        }
    }

    public static void addMember() {
        System.out.print("Enter member ID: ");
        String memberId = scan.next();

        System.out.print("Enter member name: ");
        String memberName = scan.next();

        Member member = new Member(memberId, memberName);
        library.addMember(member);
    }

    public static void borrowBook() {
        System.out.print("Enter member ID: ");
        String memberId = scan.next();

        System.out.print("Enter book ID: ");
        String bookId = scan.next();

        library.giveBook(bookId, memberId);
    }

    public static void returnBook() {
        System.out.print("Enter member ID: ");
        String memberId = scan.next();

        System.out.print("Enter book ID: ");
        String bookId = scan.next();

        library.receiveBook(bookId, memberId);
    }

    public static void addBook() {
        System.out.print("Enter book ID: ");
        String bookId = scan.next();

        System.out.print("Enter book title: ");
        String bookTitle = scan.next();

        Book book = new Book(bookId, bookTitle);
        library.addBook(book);
    }
}