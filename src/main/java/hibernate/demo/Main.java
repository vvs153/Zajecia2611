package hibernate.demo;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;
import java.time.LocalDate;

public class Main {

    //Atomicity
    //All changes to data are performed as if they are a single operation. That is, all the changes are performed, or none of them are.
    //For example, in an application that transfers funds from one account to another, the atomicity property ensures that, if a debit is made successfully from one account, the corresponding credit is made to the other account.
    //Consistency
    //Data is in a consistent state when a transaction starts and when it ends.
    //For example, in an application that transfers funds from one account to another, the consistency property ensures that the total value of funds in both the accounts is the same at the start and end of each transaction.
    //Isolation
    //The intermediate state of a transaction is invisible to other transactions. As a result, transactions that run concurrently appear to be serialized.
    //For example, in an application that transfers funds from one account to another, the isolation property ensures that another transaction sees the transferred funds in one account or the other, but not in both, nor in neither.
    //Durability
    //After a transaction successfully completes, changes to data persist and are not undone, even in the event of a system failure.
    //For example, in an application that transfers funds from one account to another, the durability property ensures that the changes made to each account will not be reversed.
    public static void main(String[] args) {
        // wywołaj try-with-resources który zamknie sesję automatycznie po opuszczeniu try
        try (Session session = HibernateUtil.INSTANCE.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            //tworzymy studenta
            //Student student = new Student();
            // student.setImie("pawel");
            // student.setDataUrodzenia(LocalDate.of(1990,1,3));
            //student.setKierunekNauczania("infromatyka");
            // student.setIndeks("124354");
            Student student = Student.builder()
                    .dataUrodzenia(LocalDate.of(1990,1,3))
                    .kierunekNauczania("infromatyka")
                    .indeks("23546")
                    .imie("kekus")
                    .build();

            //zapisujemy studenta
            session.persist(student);
            //potwierdzamy trasakcje
            transaction.commit();
        } catch (Exception ioe) {
            // jeśli złapiemy błąd, to wywoła się catch

        }
    }
}
