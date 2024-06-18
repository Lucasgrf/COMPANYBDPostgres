import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Principal {
    public static class PostgreSQLJDBC {
        private final String url = "jdbc:postgresql://localhost:5432/postgres";
        private final String user = "postgres";
        private final String password = "postgres";

        public Connection connect() {
            Connection conn = null;
            try {
                conn = DriverManager.getConnection(url, user, password);
                System.out.println("Conectado ao PostgreSQL com sucesso!");

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

            return conn;
        }
    }

    public static void main(String[] args) {
        PostgreSQLJDBC app = new PostgreSQLJDBC();
        app.connect();
    }
}
