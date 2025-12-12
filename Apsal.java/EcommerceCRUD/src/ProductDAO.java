import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    public static void addProduct(Product p) {
        try {
            Connection con = DBConnect.connect();
            String sql = "INSERT INTO products(name, price, quantity) VALUES (?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, p.getName());
            ps.setDouble(2, p.getPrice());
            ps.setInt(3, p.getQuantity());
            ps.executeUpdate();
            System.out.println("Product added successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Product> getProducts() {
        List<Product> list = new ArrayList<>();
        try {
            Connection con = DBConnect.connect();
            String sql = "SELECT * FROM products";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                Product p = new Product();
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setPrice(rs.getDouble("price"));
                p.setQuantity(rs.getInt("quantity"));
                list.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void deleteProduct(int id) {
        try {
            Connection con = DBConnect.connect();
            String sql = "DELETE FROM products WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Product deleted!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
