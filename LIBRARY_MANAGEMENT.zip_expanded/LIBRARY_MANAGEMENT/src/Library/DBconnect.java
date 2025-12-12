package Library;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBconnect {
    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/librarydb", "root", ""); // your user/pass
        } catch (Exception e) {
            System.out.println(e);
        }
        return con;
    }
}