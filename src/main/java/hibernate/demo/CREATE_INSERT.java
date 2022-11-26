package hibernate.demo;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.time.LocalDate;
import java.util.Scanner;

public class CREATE_INSERT {
    public static void main(String[] args) {
        try (Session session = HibernateUtil.INSTANCE.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            Scanner scanner= new Scanner(System.in);
            System.out.println("Podaj imie");
            String name = scanner.nextLine();
            System.out.println("Podaj kierunek");
            String kierunek = scanner.nextLine();
            System.out.println("Podaj indeks");
            String indeks = "";
            do{
               indeks = scanner.nextLine();
            } while (indeks.length()!=6);
            System.out.println("Podaj date");
            int year = scanner.nextInt();
            System.out.println("Podaj miesiac");
            int month = scanner.nextInt();
            System.out.println("Podaj dzien");
            int day = scanner.nextInt();

            Student student = Student.builder()
                    .dataUrodzenia(LocalDate.of(year,month,day))
                    .kierunekNauczania(kierunek)
                    .indeks(indeks)
                    .imie(name)
                    .build();


            session.persist(student);

            transaction.commit();
        } catch (Exception ioe) {
            System.err.println( "blad baza: " + ioe);

        }
    }
}
