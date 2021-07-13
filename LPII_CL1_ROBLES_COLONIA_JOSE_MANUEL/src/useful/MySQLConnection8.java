package useful;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection8 {
    public static Connection getConnection() {
        Connection connection = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String URL = "jdbc:mysql://localhost:3306/bd_hayta?useSSL=false&useTimezone=true&serverTimezone=UTC";
            String USER = "root";
            String PASSWORD = "mysql";

            connection = DriverManager.getConnection(URL, USER, PASSWORD);

        } catch (ClassNotFoundException ex) {
            System.out.println("Error >> Driver no Instalado CNFE : " + ex);
        } catch (SQLException ex) {
            System.out.println("Error >> Driver no Instalado SQLE : " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("Error >> general : " + ex.getMessage());
        }

        return connection;

    }

    public static void closeConnection(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println("Problemas al cerrar la conexion");
        }
    }
}
