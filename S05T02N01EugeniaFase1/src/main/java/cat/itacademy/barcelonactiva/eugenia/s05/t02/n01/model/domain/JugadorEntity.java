package cat.itacademy.barcelonactiva.eugenia.s05.t02.n01.model.domain;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Jugador")
public class JugadorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pk_IdJugador;

    @Column(name = "NombreJugador", nullable = false)
    private String nombreJugador;

    @Column(name = "FechaRegistro", updatable = false, nullable = false)
    private LocalDateTime fechaRegistro = LocalDateTime.now();

    @OneToMany(mappedBy = "jugadorEntity", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<JuegoEntity> listaPartidas = new ArrayList<>();


    public void agregarPartida(JuegoEntity juego) {
        if (juego != null) {
            listaPartidas.add(juego);
            juego.setJugadorEntity(this);
        }
    }


    public float porcentaje() {
        if (listaPartidas.isEmpty()) {
            return 0.0f;
        }
        long totalPartidas = listaPartidas.size();
        long partidasGanadas = listaPartidas.stream().filter(JuegoEntity::partidaGanada).count();
        return (float) partidasGanadas / totalPartidas * 100;
    }
}
