package hibernate.demo;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // wywołaj try-with-resources który zamknie sesję automatycznie po opuszczeniu try
        try (Session session = HibernateUtil.INSTANCE.getSessionFactory().openSession()){
       Transaction transaction = session.beginTransaction();
       //tworzymy studenta
       Student student = new Student();
       student.setImie("pawel");
       student.setDataUrodzenia(LocalDate.of(1990,1,3));
       student.setKierunekNauczania("infromatyka");
       student.setIndeks("124354");
       //zapisujemy studenta
       session.persist(student);
       //potwierdzamy trasakcje
            transaction.commit();
        } catch (Exception ioe) {
            // jeśli złapiemy błąd, to wywoła się catch

        }
    }
}
