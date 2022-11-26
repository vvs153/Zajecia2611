package hibernate.demo;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.time.LocalDate;
import java.util.Scanner;

public class Update_Delete {
// Update

    public static void main(String[] args) {
        // wywołaj try-with-resources który zamknie sesję automatycznie po opuszczeniu try
        try (Session session = HibernateUtil.INSTANCE.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            Scanner scanner = new Scanner(System.in);
            String input;
            do {
                System.out.println("Update or Delete");
                input = scanner.nextLine();
                if (input.toLowerCase().equals("update")) {
                    System.out.println("podaj id");
                    Long id = scanner.nextLong();
                    String temp = scanner.nextLine();
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
                            .id(id)
                            .dataUrodzenia(LocalDate.of(year, month, day))
                            .kierunekNauczania(kierunek)
                            .indeks(indeks)
                            .imie(name)
                            .build();
                    if (student.getId() == null){
                        System.err.println("Nie znaleziono studenta");
                    } else {
                        session.merge(student);  //potwierdzamy trasakcje
                        transaction.commit();
                    }
                    break;
                } else if (input.toLowerCase().equals("delete")) {
                    System.out.println("Podaj id");
                    Long id = scanner.nextLong();
                    Student student = session.get(Student.class, id);
                    if (student != null){
                        session.remove(student);
                        transaction.commit();
                    } else{
                        System.err.println("Nie ma takiego studenta");
                    }
                    break;
                }
            }
                while (!input.toLowerCase().equals("update")||!input.toLowerCase().equals("delete"));
        } catch (Exception ioe) {
            // jeśli złapiemy błąd, to wywoła się catch

        }
    }
}
