import java.util.Scanner;

class Main {

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
                System.out.println("wrong input");
            }

            System.out.print("continue ? (y/n) ");
            isContinue = scan.next();
        }
    }

    public static void showMenu() {
        System.out.println("================================");
        System.out.println("1. show books list");
        System.out.println("2. show members list");
        System.out.println("3. add member");
        System.out.println("4. borrow book");
        System.out.println("5. return book");
        System.out.println("6. add book");
        System.out.println("================================");
    }

    public static void initLibraryData() {
        Book book1 = new Book();
        book1.id = "1";
        book1.title = "pemrograman java";

        Book book2 = new Book();
        book2.id = "2";
        book2.title = "pemrograman oop";

        Book book3 = new Book();
        book3.id = "3";
        book3.title = "pemrograman android";

        Member member1 = new ConcreteMember("1", "ada");


        Member member2 = new ConcreteMember("2", "adu");


        Member member3 = new ConcreteMember("3", "ade");


        library.books.add(book1);
        library.books.add(book2);
        library.books.add(book3);

        library.members.add(member1);
        library.members.add(member2);
        library.members.add(member3);
    }

    public static int chooseMenu() {
        System.out.print("choose menu : ");
        int pilihan = scan.nextInt();
        return pilihan;
    }

    public static void showBooks() {
        for (Book book : library.books) {
            System.out.println(book.id + " " + book.title);
        }
    }

    public static void showMembers() {
        for (Member member : library.members) {
            System.out.println(member.id + " " + member.name);
        }
    }

    public static void addMember() {
        Scanner scan = new Scanner(System.in);

        System.out.print("id: ");
        String memberId = scan.next();

        System.out.print("name: ");
        String memberName = scan.next();

        Member member = new ConcreteMember(memberId, memberName);
        library.addMember(member);
    }
    public static void addBook() {
        Book book = new Book();

        System.out.print("id : ");
        book.id = scan.next();

        System.out.print("Title : ");
        scan.nextLine();
        book.title = scan.nextLine();

        library.addBook(book);
    }

    public static void borrowBook() {
        System.out.print("id member : ");
        String memberId = scan.next();

        System.out.print("id book : ");
        String bookId = scan.next();

        library.giveBook( memberId,bookId);
    }

    public static void returnBook() {
        System.out.print("id member : ");
        String memberId = scan.next();

        System.out.print("id book : ");
        String bookId = scan.next();

        library.receiveBook( memberId,bookId );
    }
}