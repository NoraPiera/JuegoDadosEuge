package cat.itacademy.barcelonactiva.eugenia.s05.t02.n01.utils;
import cat.itacademy.barcelonactiva.eugenia.s05.t02.n01.model.domain.PlayerEntity;
import cat.itacademy.barcelonactiva.eugenia.s05.t02.n01.model.dto.PlayerDTO;
import org.springframework.stereotype.Component;

@Component
public class ConversorPlayer {
    public static PlayerDTO convertirDesdeJugadorEntity(PlayerEntity jugadorEntity) {
        PlayerDTO jugadorDTO = new PlayerDTO();

        jugadorDTO.setIdPlayer(jugadorEntity.getIdPlayer());
        jugadorDTO.setName(jugadorEntity.getName());
        jugadorDTO.setPorcentaje(jugadorEntity.porcentaje());
        jugadorDTO.setFechaRegistro(jugadorEntity.getFechaRegistro()); // Asegurarse de esto

        return jugadorDTO;
    }

    public static PlayerEntity convertirParaJugadorEntity(PlayerDTO jugadorDTO) {
        PlayerEntity jugadorEntity = new PlayerEntity();

        jugadorEntity.setIdPlayer(jugadorDTO.getIdPlayer());
        jugadorEntity.setName(jugadorDTO.getName());
        jugadorEntity.setFechaRegistro(jugadorDTO.getFechaRegistro()); // Asegurarse de esto

        return jugadorEntity;
    }
}
