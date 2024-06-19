import java.sql.*;

public class Database {
    private static String url = "jdbc:postgresql://localhost:5432/postgres";
    private static String user = "postgres";
    private static String password = "postgres";
    private static Connection con;

    public static Connection getConnection() {
        try {
            if(con == null || con.isClosed()) {
                con = DriverManager.getConnection(url, user, password);
                System.out.println("Connected to PostgreSQL database");
            }
        } catch (SQLException e) {
            System.out.println("Database connection failed");
            throw new RuntimeException(e);
        }
        return con;
    }

    public static void getAllPersons(){
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement("select * from person order by personid");
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                System.out.println(rs.getString("personid")
                        + " " + rs.getString("name") + " " + rs.getString("email"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static int insertPerson(String name, String email){
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement("insert into person (name, email) values (?,?)");
            ps.setString(1, name);
            ps.setString(2, email);
            return ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static int updatePerson(int personid, String name, String email){
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement("UPDATE person SET name = ?, email = ? WHERE personid = ?");
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setInt(3, personid);
            return ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static int deletePerson(int personid){
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement("Delete from person where personid = ?");
            ps.setInt(1, personid);
            return ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void disconnect(){
        try {
            if(con != null || !con.isClosed()) {
                con.close();
                System.out.println("Disconnected from PostgreSQL database");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
