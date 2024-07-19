package cat.itacademy.barcelonactiva.eugenia.s05.t02.n01.model.repository;

import cat.itacademy.barcelonactiva.eugenia.s05.t02.n01.model.domain.JugadorEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JugadorRepository extends MongoRepository<JugadorEntity, String> {
    boolean existsByNombreJugador(String nombreJugador);
}