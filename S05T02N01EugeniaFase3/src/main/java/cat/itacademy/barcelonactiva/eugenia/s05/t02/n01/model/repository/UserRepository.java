package cat.itacademy.barcelonactiva.eugenia.s05.t02.n01.model.repository;
import cat.itacademy.barcelonactiva.eugenia.s05.t02.n01.model.domain.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository <UserEntity, Integer> {
    Optional<UserEntity> findUserEntityByEmail(String email);
    boolean existsByNameIgnoreCase (String name);
}