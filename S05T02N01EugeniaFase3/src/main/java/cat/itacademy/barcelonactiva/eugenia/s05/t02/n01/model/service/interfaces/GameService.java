package cat.itacademy.barcelonactiva.eugenia.s05.t02.n01.model.service.interfaces;



import cat.itacademy.barcelonactiva.eugenia.s05.t02.n01.model.domain.GameEntity;
import cat.itacademy.barcelonactiva.eugenia.s05.t02.n01.model.dto.GameDTO;

import java.util.List;

public interface GameService {

    GameDTO jugarJuego(int id, String userEmail);
    String borrarJuegos(int id, String userEmail);
    List<GameDTO> listaJugadasByJugador(int id);
    void partida(GameEntity juegoEntity);
}