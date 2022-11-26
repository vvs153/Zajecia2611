package hibernate.demo;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
//wzorzec projektowy builder:
//Kiedy uzywac:
// - kiedy chcemy miec wieksza kontrole nad tworzeniem obiektow - mamy  na mysli ilosc i kolejnosc parametrow
// - kiedy chcemy zredukowac ilosc konstruktorow (konstruktory o roznych kombinacjach parametrow;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id // PRIMARY KEY
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT
    private Long id;                                                        // `id`                     INT PRIMARY KEY AUTO_INCREMENT,

    @Column(nullable = false)
    private String imie;                                                    // `imie`                   VARCHAR(255) NOT NULL,
    private LocalDate dataUrodzenia;                                        // `data_urodzenia`         DATE,
    private String kierunekNauczania;                                       // `kierunek_nauczania`     VARCHAR(255),
    private String indeks; // index jest słowem zabronionym przez mysql     // `indeks`                 VARCHAR(255)

    //zamiast pisac kontrkutory robimy builder

//    private int wiek;                                                       // `wiek`                   INT NOT NULL,
//    private Integer wiek;                                                   // `wiek`                   INT,
}
