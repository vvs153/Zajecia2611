package hibernate.demo;

import jakarta.persistence.TypedQuery;
import org.hibernate.Session;

import java.util.List;
import java.util.Scanner;

public class READ_SELECT {

    public static void main(String[] args) {
        try (Session session = HibernateUtil.INSTANCE.getSessionFactory().openSession()){
            Scanner scanner = new Scanner(System.in);

            String input;
            do {
                System.out.println("List or Search");
                input = scanner.nextLine();


                if (input.toLowerCase().equals("list")||input.toLowerCase().equals("lista")) {
                    TypedQuery<Student> zapytanie = session.createQuery("from Student", Student.class);
                    List<Student> studentList = zapytanie.getResultList();
                    for (Student student : studentList) {
                        System.out.println(student);
                    }
                    break;
                } else if (input.toLowerCase().equals("search")||input.toLowerCase().equals("szukaj")) {
                    System.out.println("Podaj id");
                    int id = scanner.nextInt();
                    Student student = session.get(Student.class, id);
                    if (student == null){
                        System.err.println("Nie znaleziono studenta");}
                    else {
                        System.out.println("znalezlismy studenta: " + student);
                    }
                    break;
                }
            } while (!input.toLowerCase().equals("list")||!input.toLowerCase().equals("search")||!input.toLowerCase().equals("lista")||!input.toLowerCase().equals("szukaj"));




        } catch (Exception ioe) {
            // jeśli złapiemy błąd, to wywoła się catch
            System.err.println( "blad baza: " + ioe);
        }
    }
}
