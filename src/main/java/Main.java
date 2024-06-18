import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static String url = "jdbc:postgresql://localhost:5432/postgres";
    private static String user = "postgres";
    private static String password = "postgres";

    public static void main(String[] args) {
        List<User> users = new ArrayList<User>();
        //System.out.println("Usuários deletado: " + deleteUser(1));
        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement ps = con.prepareStatement("select * from users")){
            System.out.println("Conectado com sucesso!");
            insertUser(new User("New User", "user@gmail.com"));
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                users.add(new User(rs.getString("name"), rs.getString("email")));
            }
        } catch (Exception e) {
            System.out.println("Falha ao conectar ao banco de dados");
        }
        users.forEach(System.out::println);
    }

    public static int insertUser(User u){
        String query = "insert into users (Name, Email) values (?, ?)";
        try (Connection con = DriverManager.getConnection(url, user, password);
        PreparedStatement ps = con.prepareStatement(query)){
            System.out.println("Conectado com sucesso!");
            ps.setString(1, u.getName());
            ps.setString(2, u.getEmail());
            return ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Falha ao conectar ao banco de dados");
        }
        return 0;
    }

    public static int deleteUser(int id) {
        String query = "DELETE FROM Users WHERE UserID = ?;";
        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, id);
            return ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static int updateUser(User u) {
        String query = "UPDATE User SET Name = ?, Email=? WHERE UserID = ?;";
        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, u.getName());
            ps.setString(2, u.getEmail());
            ps.setInt(3, u.getUserID());
            return ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
