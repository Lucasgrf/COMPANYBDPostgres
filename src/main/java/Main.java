import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Database.getConnection();
        /*List<Person> listPerson = new ArrayList<>(); //lista de personagens
        listPerson = Database.getAllPersons();
        listPerson.forEach(System.out::println);*/

        /*int lines;
        lines = Database.updatePerson(4,"Prima","Primadoe@gmail.com"); update antigo
        lines = Database.deletePerson(4); delete
        lines = Database.insertPerson("Primo Doe", "primodoe@gmail.com"); //create antigo
        System.out.println("Lines changed: " + lines);
        Database.getAllPersons();*/

        //Database.insertPerson(new Person("Lucas", "lucas@gmail.com")); create
        /*List<Person> listPerson = new ArrayList<>(); //lista de personagens
        listPerson = Database.getAllPersons();
        listPerson.forEach(System.out::println);*/

        //Database.updatePerson(new Person(9, "lucas@doe.com","lucasdoe@gmail.com")); update
        /*List<Person> listPerson = new ArrayList<>(); //lista de personagens
        listPerson = Database.getAllPersons();
        listPerson.forEach(System.out::println);*/

        //Database.deletePerson(new Person(9)); delete
        List<Person> listPerson = new ArrayList<>();
        listPerson = Database.getAllPersons();
        listPerson.forEach(System.out::println);

        Database.disconnect();
    }
}
