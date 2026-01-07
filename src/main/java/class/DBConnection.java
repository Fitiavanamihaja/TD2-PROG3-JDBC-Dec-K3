import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static Connection connection;

    private DBConnection() {
    }

    public static Connection getDBConnection() throws SQLException {

        if (connection == null || connection.isClosed()) {

            String jdbcUrl = System.getenv("JDBC_URL");
            String username = System.getenv("USERNAME");
            String password = System.getenv("PASSWORD");

            if (jdbcUrl == null || username == null || password == null) {
                throw new RuntimeException("Variables JDBC_URL, USERNAME ou PASSWORD non définies !");
            }

            connection = DriverManager.getConnection(jdbcUrl, username, password);
            System.out.println("Connexion PostgreSQL établie avec succès");
        }

        return connection;
    }

    public static void closeConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
            System.out.println("Connexion fermée");
        }
    }
}
