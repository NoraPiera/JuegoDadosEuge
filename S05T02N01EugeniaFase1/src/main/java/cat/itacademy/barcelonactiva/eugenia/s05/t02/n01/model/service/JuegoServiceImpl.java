package cat.itacademy.barcelonactiva.eugenia.s05.t02.n01.model.service;

import cat.itacademy.barcelonactiva.eugenia.s05.t02.n01.exceptions.JugadorNoExiste;
import cat.itacademy.barcelonactiva.eugenia.s05.t02.n01.exceptions.PartidasNoEncontradas;
import cat.itacademy.barcelonactiva.eugenia.s05.t02.n01.model.domain.JuegoEntity;
import cat.itacademy.barcelonactiva.eugenia.s05.t02.n01.model.domain.JugadorEntity;
import cat.itacademy.barcelonactiva.eugenia.s05.t02.n01.model.dto.JuegoDTO;
import cat.itacademy.barcelonactiva.eugenia.s05.t02.n01.model.repository.JuegoRepository;
import cat.itacademy.barcelonactiva.eugenia.s05.t02.n01.model.repository.JugadorRepository;
import cat.itacademy.barcelonactiva.eugenia.s05.t02.n01.model.service.interfaces.JuegoService;
import cat.itacademy.barcelonactiva.eugenia.s05.t02.n01.model.utils.ConversorJuego;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class JuegoServiceImpl implements JuegoService {
    @Autowired
    private JuegoRepository juegoRepository;
    @Autowired
    private JugadorRepository jugadorRepository;

    @Override
    public JuegoDTO jugarJuego(int id) {
        Optional<JugadorEntity> optionalJugadorEntity = jugadorRepository.findById(id);
        if(optionalJugadorEntity.isPresent()){
            JugadorEntity jugadorEntity = optionalJugadorEntity.get();
            JuegoEntity juegoEntity= new JuegoEntity();
            partida(juegoEntity);
            juegoEntity.setJugadorEntity(jugadorEntity);
            jugadorEntity.agregarPartida(juegoEntity);
            juegoRepository.save(juegoEntity);
            return ConversorJuego.convertirDesdeJuegoEntity(juegoEntity);
        }else{
            throw new JugadorNoExiste("No se ha econtrado al jugador con ID " + id);
        }

    }

    @Override
    @Transactional
    public String borrarJuegos(int id) {
        Optional<JugadorEntity> optionalJugadorEntity = jugadorRepository.findById(id);

        if (optionalJugadorEntity.isPresent()) {
            JugadorEntity jugador = optionalJugadorEntity.get();
            List<JuegoEntity> listaJuegos = jugador.getListaPartidas();
            if (!listaJuegos.isEmpty()) {
                listaJuegos.clear();
                juegoRepository.deleteAll(listaJuegos);
                return "Se han eliminado las partidas del jugador con el ID " + id;
            } else {
                throw new PartidasNoEncontradas("No se han encontrado partidas para el jugador con ID " + id);
            }
        }else{
            throw new JugadorNoExiste("No se ha encontrado el jugador con el ID " + id);
        }
    }



    @Override
    public List<JuegoDTO> listaJugadasByJugador(int id) {
        Optional<JugadorEntity>optionalJugadorEntity = jugadorRepository.findById(id);
        List<JuegoEntity> listaPartidas = optionalJugadorEntity.get().getListaPartidas();
        if(optionalJugadorEntity.isPresent() && !listaPartidas.isEmpty()){

            return listaPartidas.stream().map(ConversorJuego::convertirDesdeJuegoEntity).collect(Collectors.toList());
        }else if(listaPartidas.isEmpty()){
            throw new PartidasNoEncontradas("No se han encontrado partidas para el jugador con ID " + id);
        }else{
            throw new JugadorNoExiste("No se ha encontrado el jugador con el ID " + id);
        }
    }
    public void partida(JuegoEntity juegoEntity){
        Random random = new Random();
        int dado1 = random.nextInt(6)+1;
        int dado2 = random.nextInt(6)+1;
        juegoEntity.setDado1(dado1);
        juegoEntity.setDado2(dado2);
        juegoEntity.setGanada(juegoEntity.partidaGanada());

    }
}
