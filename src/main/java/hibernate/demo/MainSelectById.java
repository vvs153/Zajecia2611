package hibernate.demo;

import jakarta.persistence.TypedQuery;
import org.hibernate.Session;

import java.util.List;

public class MainSelectById {
//SELECT
    public static void main(String[] args) {
        // wywołaj try-with-resources który zamknie sesję automatycznie po opuszczeniu try
        try (Session session = HibernateUtil.INSTANCE.getSessionFactory().openSession()){
            //Select from student where id =x
        Student student = session.get(Student.class, 1L);
            System.out.println("znalezlismy studenta: " + student);


        } catch (Exception ioe) {
            // jeśli złapiemy błąd, to wywoła się catch
            System.err.println( "blad baza: " + ioe);
        }
    }
}
