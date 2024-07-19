package cat.itacademy.barcelonactiva.eugenia.s05.t02.n01.model.repository;
import cat.itacademy.barcelonactiva.eugenia.s05.t02.n01.model.domain.JuegoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JuegoRepository extends JpaRepository<JuegoEntity, Integer> {

}