package cat.itacademy.barcelonactiva.eugenia.s05.t02.n01.model.utils;

import cat.itacademy.barcelonactiva.eugenia.s05.t02.n01.model.domain.JugadorEntity;
import cat.itacademy.barcelonactiva.eugenia.s05.t02.n01.model.dto.JugadorDTO;
import org.springframework.stereotype.Component;

@Component
public class ConversorJugador {

    public static JugadorDTO convertirDesdeJugadorEntity(JugadorEntity jugadorEntity){
        JugadorDTO jugadorDTO = new JugadorDTO();

        jugadorDTO.setPk_IdJugador(jugadorEntity.getPk_IdJugador());
        jugadorDTO.setNombreJugador(jugadorEntity.getNombreJugador());
        jugadorDTO.setPorcentaje(jugadorEntity.porcentaje());

        return jugadorDTO;
    }
    public static JugadorEntity convertirParaJugadorEntity(JugadorDTO jugadorDTO){
        JugadorEntity jugadorEntity = new JugadorEntity();

        jugadorEntity.setPk_IdJugador(jugadorDTO.getPk_IdJugador());
        jugadorEntity.setNombreJugador(jugadorDTO.getNombreJugador());

        return jugadorEntity;
    }
}