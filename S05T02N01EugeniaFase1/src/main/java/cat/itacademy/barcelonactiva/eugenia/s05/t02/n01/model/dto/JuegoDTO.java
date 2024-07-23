package cat.itacademy.barcelonactiva.eugenia.s05.t02.n01.model.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(builderMethodName = "crearJuegoDTO")
@NoArgsConstructor
@AllArgsConstructor
public class JuegoDTO {

    private int idJuego;
    private int dado1;
    private int dado2;
    private boolean ganada;
}
