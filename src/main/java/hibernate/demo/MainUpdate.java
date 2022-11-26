package hibernate.demo;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.time.LocalDate;

public class MainUpdate {
// Update

    public static void main(String[] args) {
        // wywołaj try-with-resources który zamknie sesję automatycznie po opuszczeniu try
        try (Session session = HibernateUtil.INSTANCE.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();

            Student student = Student.builder()
                    .id(2L)
                    .dataUrodzenia(LocalDate.of(1990,1,3))
                    .kierunekNauczania("meth")
                    .indeks("23546")
                    .imie("kekkonen")
                    .build();

            //updateujemy studenta
            //merge do updatowania, musi byc id
            //persist do dodwaania, id samo sie dodaje
            session.merge(student);
            //potwierdzamy trasakcje
            transaction.commit();
        } catch (Exception ioe) {
            // jeśli złapiemy błąd, to wywoła się catch

        }
    }
}
