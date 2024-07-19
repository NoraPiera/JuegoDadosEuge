package cat.itacademy.barcelonactiva.eugenia.s05.t02.n01.model.service.Interfaces;
import cat.itacademy.barcelonactiva.eugenia.s05.t02.n01.model.domain.JuegoEntity;
import cat.itacademy.barcelonactiva.eugenia.s05.t02.n01.model.dto.JuegoDTO;

import java.util.List;

public interface JuegoService {

    JuegoDTO jugarJuego(String id);
    String borrarJuegos(String id);
    List<JuegoDTO> listaJugadasByJugador(String id);
    void partida(JuegoEntity juegoEntity);
}