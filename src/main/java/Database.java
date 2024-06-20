import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    public static List<Person> getAllPersons(){
        PreparedStatement ps = null;
        Person person = new Person();
        List<Person> persons = new ArrayList<Person>();
        try {
            ps = con.prepareStatement("select * from person order by personid");
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                person = new Person();
                person.setPersonID(rs.getInt("personid"));
                person.setName(rs.getString("name"));
                person.setEmail(rs.getString("email"));

                persons.add(person);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return persons;
    }

    public static Person getPerson(Person person){
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement("select * from person where personid = ?");
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                person = new Person();
                person.setPersonID(rs.getInt("personid"));
                person.setName(rs.getString("name"));
                person.setEmail(rs.getString("email"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return person;
    }

    public static int insertPerson(Person person){
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement("insert into person (name, email) values (?,?)");
            ps.setString(1, person.getName());
            ps.setString(2, person.getEmail());
            return ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static int updatePerson(Person person){
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement("UPDATE person SET name = ?, email = ? WHERE personid = ?");
            ps.setString(1, person.getName());
            ps.setString(2, person.getEmail());
            ps.setInt(3, person.GetPersonID());
            return ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static int deletePerson(Person person){
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement("Delete from person where personid = ?");
            ps.setInt(1, person.GetPersonID());
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
