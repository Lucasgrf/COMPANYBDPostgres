import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Database.getConnection();
        //Database.getAllPersons();
        int lines;

        //lines = Database.updatePerson(4,"Prima","Primadoe@gmail.com"); update
        //lines = Database.deletePerson(4); delete
        lines = Database.insertPerson("Primo Doe", "primodoe@gmail.com"); //create
        System.out.println("Lines changed: " + lines);
        Database.getAllPersons();
        Database.disconnect();
    }
}
