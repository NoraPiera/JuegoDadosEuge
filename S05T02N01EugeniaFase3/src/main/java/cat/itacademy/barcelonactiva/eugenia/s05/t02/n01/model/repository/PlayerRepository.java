package cat.itacademy.barcelonactiva.eugenia.s05.t02.n01.model.repository;
import cat.itacademy.barcelonactiva.eugenia.s05.t02.n01.model.domain.PlayerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<PlayerEntity, Integer> {
    boolean existsByNameIgnoreCase(String name);
    PlayerEntity findByUserEntity_UserIDAndIdPlayer(int userId, int playerId);
    List<PlayerEntity> findByUserEntity_UserID(int userId);
}