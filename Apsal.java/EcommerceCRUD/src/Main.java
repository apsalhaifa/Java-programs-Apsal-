import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== E-Commerce Product Management ===");
            System.out.println("1. Add Product");
            System.out.println("2. View Products");
            System.out.println("3. Delete Product");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter price: ");
                    double price = Double.parseDouble(sc.nextLine());
                    System.out.print("Enter quantity: ");
                    int quantity = Integer.parseInt(sc.nextLine());

                    Product p = new Product(name, price, quantity);
                    ProductDAO.addProduct(p);
                    break;

                case 2:
                    List<Product> products = ProductDAO.getProducts();
                    System.out.println("\n--- Product List ---");
                    for (Product prod : products) {
                        System.out.println(prod);
                    }
                    break;

                case 3:
                    System.out.print("Enter product ID to delete: ");
                    int id = Integer.parseInt(sc.nextLine());
                    ProductDAO.deleteProduct(id);
                    break;

                case 4:
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
