package hibernate.demo;

import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.time.LocalDate;
import java.util.List;

public class MainSelect {

    public static void main(String[] args) {
        // wywołaj try-with-resources który zamknie sesję automatycznie po opuszczeniu try
        try (Session session = HibernateUtil.INSTANCE.getSessionFactory().openSession()){
            //towrzymy obiekt "zapytanie o typ" gdzie tworzymy na obiekcie sesji zapytanie select
            TypedQuery<Student> zapytanie = session.createQuery("from Student",Student.class);
            //                                                  student tutaj to KLASA
           //wywolujemy motode getResultList kora oznacza select * from student
            List<Student> studentList = zapytanie.getResultList();
            //wypisz wyniki
            for (Student student:studentList) {
                System.out.println(student);
            }



        } catch (Exception ioe) {
            // jeśli złapiemy błąd, to wywoła się catch
            System.err.println( "blad baza: " + ioe);
        }
    }
}
