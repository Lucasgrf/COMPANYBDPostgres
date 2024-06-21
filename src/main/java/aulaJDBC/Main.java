package aulaJDBC;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Database.getConnection();
        /*List<aulaJDBC.Person> listPerson = new ArrayList<>(); //lista de personagens
        listPerson = aulaJDBC.Database.getAllPersons();
        listPerson.forEach(System.out::println);*/

        /*int lines;
        lines = aulaJDBC.Database.updatePerson(4,"Prima","Primadoe@gmail.com"); update antigo
        lines = aulaJDBC.Database.deletePerson(4); delete
        lines = aulaJDBC.Database.insertPerson("Primo Doe", "primodoe@gmail.com"); //create antigo
        System.out.println("Lines changed: " + lines);
        aulaJDBC.Database.getAllPersons();*/

        //aulaJDBC.Database.insertPerson(new aulaJDBC.Person("Lucas", "lucas@gmail.com")); create
        /*List<aulaJDBC.Person> listPerson = new ArrayList<>(); //lista de personagens
        listPerson = aulaJDBC.Database.getAllPersons();
        listPerson.forEach(System.out::println);*/

        //aulaJDBC.Database.updatePerson(new aulaJDBC.Person(9, "lucas@doe.com","lucasdoe@gmail.com")); update
        /*List<aulaJDBC.Person> listPerson = new ArrayList<>(); //lista de personagens
        listPerson = aulaJDBC.Database.getAllPersons();
        listPerson.forEach(System.out::println);*/

        //aulaJDBC.Database.deletePerson(new aulaJDBC.Person(9)); delete
        /*List<Person> listPerson = new ArrayList<>();
        listPerson = Database.getAllPersons();
        listPerson.forEach(System.out::println);*/
        Database.getPerson(new Person(1));

        Database.disconnect();
    }
}
