package cat.itacademy.barcelonactiva.eugenia.s05.t02.n01.model.service.interfaces;
import cat.itacademy.barcelonactiva.eugenia.s05.t02.n01.model.dto.PlayerDTO;

import java.util.List;

public interface PlayerService {
    PlayerDTO agregarPlayer(PlayerDTO playerDTO, String userEmail);
    //PlayerDTO crearPlayer(PlayerDTO playerDTO, UserEntity userEntity);
    PlayerDTO actualizar(int id, PlayerDTO jugadorDTO, String userEmail);
    String borrarPlayer(int id, String userEmail);
    int findUserById(String userEmail);
    List<PlayerDTO> getAll(String userEmail);
    List<PlayerDTO> getAllconPorcentajePorJugador(String userEmail);
    PlayerDTO findById(int id);
    double porcentajeMedioExito();
    PlayerDTO mejorPorcentajeExito();
    PlayerDTO peorPorcentajeExito();
}