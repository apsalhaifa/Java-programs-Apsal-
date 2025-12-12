package Library;

import java.sql.*;
import java.util.*;

public class BookDAO {

    public void addBook(Book book) {
        try (Connection con = DBconnect.getConnection()) {
            String sql = "INSERT INTO books(title, author, price) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, book.title);
            ps.setString(2, book.author);
            ps.setDouble(3, book.price);
            ps.executeUpdate();
            System.out.println("✅ Book added successfully!");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void viewBooks() {
        try (Connection con = DBconnect.getConnection()) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM books");
            System.out.println("📚 Book List:");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " | " +
                                   rs.getString("title") + " | " +
                                   rs.getString("author") + " | ₹" +
                                   rs.getDouble("price"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void updateBook(int id, Book book) {
        try (Connection con = DBconnect.getConnection()) {
            String sql = "UPDATE books SET title=?, author=?, price=? WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, book.title);
            ps.setString(2, book.author);
            ps.setDouble(3, book.price);
            ps.setInt(4, id);
            int rows = ps.executeUpdate();
            System.out.println(rows > 0 ? "✏️ Book updated." : "❌ Book not found.");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void deleteBook(int id) {
        try (Connection con = DBconnect.getConnection()) {
            String sql = "DELETE FROM books WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            System.out.println(rows > 0 ? "🗑️ Book deleted." : "❌ Book not found.");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
