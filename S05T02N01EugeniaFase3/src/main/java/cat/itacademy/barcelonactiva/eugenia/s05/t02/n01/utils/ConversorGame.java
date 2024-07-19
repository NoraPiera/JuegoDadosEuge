package cat.itacademy.barcelonactiva.eugenia.s05.t02.n01.utils;
import cat.itacademy.barcelonactiva.eugenia.s05.t02.n01.model.domain.GameEntity;
import cat.itacademy.barcelonactiva.eugenia.s05.t02.n01.model.dto.GameDTO;
import org.springframework.stereotype.Component;

@Component
public class ConversorGame {
    public static GameDTO convertirDesdeGameEntity(GameEntity gameEntity){
        GameDTO gameDTO = new GameDTO();

        gameDTO.setGameId(gameEntity.getGameID());
        gameDTO.setDado1(gameEntity.getDado1());
        gameDTO.setDado2(gameEntity.getDado2());
        gameDTO.setGanada(gameEntity.isGanada());

        return gameDTO;
    }
    public static GameEntity convertirDesdeGameDTO(GameDTO gameDTO){
        GameEntity gameEntity = new GameEntity();

        gameEntity.setGameID(gameDTO.getGameId());
        gameEntity.setDado1(gameDTO.getDado1());
        gameEntity.setDado2(gameDTO.getDado2());
        gameEntity.setGanada(gameDTO.isGanada());

        return gameEntity;
    }
}