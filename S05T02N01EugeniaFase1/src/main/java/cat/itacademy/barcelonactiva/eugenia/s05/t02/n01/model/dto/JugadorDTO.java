package cat.itacademy.barcelonactiva.eugenia.s05.t02.n01.model.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder(builderMethodName = "crearJugadorDTO")
@NoArgsConstructor
@AllArgsConstructor
public class JugadorDTO {

    private int pk_IdJugador;
    private String nombreJugador;
    private float porcentaje;
}
