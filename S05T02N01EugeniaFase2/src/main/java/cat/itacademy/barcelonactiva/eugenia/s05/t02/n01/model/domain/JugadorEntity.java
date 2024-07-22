package cat.itacademy.barcelonactiva.eugenia.s05.t02.n01.model.domain;



import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor
@Document(collection = "Jugador")
public class JugadorEntity {
    @Id
    private String id;
    @Field(name = "Fecha_Ocurrencia")
    private LocalDateTime fechaRegistro;
    @Field(name = "Nombre_Jugador")
    private String nombreJugador;
    @DBRef
    private List<JuegoEntity> listaPartidas;

    public JugadorEntity(){
        this.listaPartidas = new ArrayList<>();

    }

    public void agregarPartida(JuegoEntity juego){
        listaPartidas.add(juego);

    }
    public float porcentaje(){
        float porcentajeExito = 0.0f;
        if(listaPartidas != null && !listaPartidas.isEmpty()){
            long totalPartidas = listaPartidas.size();
            long partidasGanadas = listaPartidas.stream().filter(JuegoEntity::calcularPartidaGanada).count();
            porcentajeExito = (float) partidasGanadas/totalPartidas * 100;
        }
        return porcentajeExito;
    }
}