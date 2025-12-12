public class Product {
    private int id;
    private String name;
    private double price;
    private int quantity;

    // No-argument constructor
    public Product() {}

    // Constructor with all fields
    public Product(int id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    // Constructor without ID (for new products)
    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }

    // Setters
    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setPrice(double price) { this.price = price; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    // toString method for clean output
    @Override
    public String toString() {
        return id + " | " + name + " | " + price + " | " + quantity;
    }
}
