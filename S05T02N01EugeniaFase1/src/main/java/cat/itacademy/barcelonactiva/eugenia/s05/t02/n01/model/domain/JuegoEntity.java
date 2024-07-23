package cat.itacademy.barcelonactiva.eugenia.s05.t02.n01.model.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder(builderMethodName = "crearJuego")
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Juego")
public class JuegoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idJuego;

    @Column(name = "Fecha_ocurrencia", nullable = false)
    private LocalDate fechaOcurrencia = LocalDate.now();

    @Column(name = "Dado_1", nullable = false)
    private int dado1;

    @Column(name = "Dado_2", nullable = false)
    private int dado2;

    @Column(name = "Resultado", nullable = false)
    private boolean ganada;

    @ManyToOne
    @JoinColumn(name = "jugador_id", nullable = false)
    private JugadorEntity jugadorEntity;

    // Método para verificar si la partida fue ganada
    public boolean partidaGanada() {
        return dado1 + dado2 == 7;
    }
}
