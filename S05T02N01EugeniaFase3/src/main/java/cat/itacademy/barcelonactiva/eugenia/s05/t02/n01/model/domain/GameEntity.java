package cat.itacademy.barcelonactiva.eugenia.s05.t02.n01.model.domain;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name="Game")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GameEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int gameID;
    @Column(name="Fecha_ocurrencia")
    private LocalDate fechaOcurrencia = LocalDate.now();
    @Column(name="Dado_1")
    private int dado1;
    @Column(name="Dado_2")
    private int dado2;
    @Column(name="Resultado")
    private boolean ganada;

    @ManyToOne
    @JoinColumn(name="jugador_id")
    private PlayerEntity jugadorEntity;

    public boolean partidaGanada(){

        return dado1 + dado2 == 7;
    }

}