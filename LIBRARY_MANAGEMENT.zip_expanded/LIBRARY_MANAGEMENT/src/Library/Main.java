package Library;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BookDAO dao = new BookDAO();

        while (true) {
            System.out.println("\n📚 LIBRARY MANAGEMENT SYSTEM");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Update Book");
            System.out.println("4. Delete Book");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();
            sc.nextLine();  // Consume newline

            switch (ch) {
                case 1:
                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();
                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();
                    dao.addBook(new Book(0, title, author, price));
                    break;
                case 2:
                    dao.viewBooks();
                    break;
                case 3:
                    System.out.print("Enter Book ID to Update: ");
                    int uid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("New Title: ");
                    String utitle = sc.nextLine();
                    System.out.print("New Author: ");
                    String uauthor = sc.nextLine();
                    System.out.print("New Price: ");
                    double uprice = sc.nextDouble();
                    dao.updateBook(uid, new Book(uid, utitle, uauthor, uprice));
                    break;
                case 4:
                    System.out.print("Enter Book ID to Delete: ");
                    int did = sc.nextInt();
                    dao.deleteBook(did);
                    break;
                case 5:
                    System.out.println("👋 Exiting...");
                    System.exit(0);
                default:
                    System.out.println("❌ Invalid choice.");
            }
        }
    }
}