package cat.itacademy.barcelonactiva.eugenia.s05.t02.n01.model.service.interfaces;
import cat.itacademy.barcelonactiva.eugenia.s05.t02.n01.model.domain.JuegoEntity;
import cat.itacademy.barcelonactiva.eugenia.s05.t02.n01.model.dto.JuegoDTO;

import java.util.List;

public interface JuegoService {

    JuegoDTO jugarJuego(int id);
    String borrarJuegos(int id);
    List<JuegoDTO> listaJugadasByJugador(int id);
    void partida(JuegoEntity juegoEntity);

}