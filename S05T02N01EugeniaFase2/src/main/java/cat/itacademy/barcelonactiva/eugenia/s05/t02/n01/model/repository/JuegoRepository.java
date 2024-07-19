package cat.itacademy.barcelonactiva.eugenia.s05.t02.n01.model.repository;
import cat.itacademy.barcelonactiva.eugenia.s05.t02.n01.model.domain.JuegoEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JuegoRepository extends MongoRepository<JuegoEntity, String> {
}