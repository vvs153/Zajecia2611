package hibernate.demo;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.time.LocalDate;

public class MainDelete {
// Update

    public static void main(String[] args) {
        // wywołaj try-with-resources który zamknie sesję automatycznie po opuszczeniu try
        try (Session session = HibernateUtil.INSTANCE.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();

        //najpierw select * from student where id =2L
            Student student = session.get(Student.class, 2L);
            //jesli udalo sie znalezc
            if (student != null){
                //Delete from student where id =2
                session.remove(student);
            }
            //zatwierdzamy transakcje
            transaction.commit();
        } catch (Exception ioe) {
            // jeśli złapiemy błąd, to wywoła się catch

        }
    }
}
