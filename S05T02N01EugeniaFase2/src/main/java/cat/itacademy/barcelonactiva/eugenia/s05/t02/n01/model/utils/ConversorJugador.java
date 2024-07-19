package cat.itacademy.barcelonactiva.eugenia.s05.t02.n01.model.utils;

import cat.itacademy.barcelonactiva.eugenia.s05.t02.n01.model.domain.JugadorEntity;
import cat.itacademy.barcelonactiva.eugenia.s05.t02.n01.model.dto.JugadorDTO;

public class ConversorJugador {
    public static JugadorDTO convertirDesdeJugadorEntity(JugadorEntity jugadorEntity) {
        JugadorDTO jugadorDTO = new JugadorDTO();

        jugadorDTO.setId(jugadorEntity.getId());
        jugadorDTO.setNombreJugador(jugadorEntity.getNombreJugador());
        jugadorDTO.setPorcentaje(jugadorEntity.porcentaje());

        return jugadorDTO;
    }

    public static JugadorEntity convertirParaJugadorEntity(JugadorDTO jugadorDTO) {
        JugadorEntity jugadorEntity = new JugadorEntity();

        jugadorEntity.setId(jugadorDTO.getId());
        jugadorEntity.setNombreJugador(jugadorDTO.getNombreJugador());

        return jugadorEntity;
    }
}