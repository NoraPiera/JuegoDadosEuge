package cat.itacademy.barcelonactiva.eugenia.s05.t02.n01.model.repository;
import cat.itacademy.barcelonactiva.eugenia.s05.t02.n01.model.domain.GameEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository extends JpaRepository<GameEntity, Integer> {
    List<GameEntity> findByJugadorEntity_IdPlayer(int playerId);
}