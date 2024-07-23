package cat.itacademy.barcelonactiva.eugenia.s05.t02.n01.model.service;
import cat.itacademy.barcelonactiva.eugenia.s05.t02.n01.exceptions.JugadorExistente;
import cat.itacademy.barcelonactiva.eugenia.s05.t02.n01.exceptions.JugadorNoExiste;
import cat.itacademy.barcelonactiva.eugenia.s05.t02.n01.exceptions.JugadoresNoEncontrados;
import cat.itacademy.barcelonactiva.eugenia.s05.t02.n01.model.domain.JugadorEntity;
import cat.itacademy.barcelonactiva.eugenia.s05.t02.n01.model.dto.JugadorDTO;
import cat.itacademy.barcelonactiva.eugenia.s05.t02.n01.model.repository.JugadorRepository;
import cat.itacademy.barcelonactiva.eugenia.s05.t02.n01.model.service.interfaces.JugadorService;
import cat.itacademy.barcelonactiva.eugenia.s05.t02.n01.model.utils.ConversorJugador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JugadorServiceImpl implements JugadorService {
    @Autowired
    JugadorRepository jugadorRepository;
    @Override
    public JugadorDTO crear(JugadorDTO jugadorDTO) {

        if(jugadorDTO.getNombreJugador().isBlank() || jugadorDTO.getNombreJugador().equalsIgnoreCase("ANONIMO")){
            jugadorDTO.setNombreJugador("Anonimo");
        }else if(jugadorRepository.existeNombreJugador(jugadorDTO.getNombreJugador())){
            throw new JugadorExistente("Existe un jugador con ese nombre.");
        }

        return ConversorJugador.convertirDesdeJugadorEntity(jugadorRepository.save(ConversorJugador.convertirParaJugadorEntity(jugadorDTO)));
    }

    @Override
    public JugadorDTO actualizar(int id, JugadorDTO jugadorDTO) {
        Optional<JugadorEntity> optionalJugadorEntity = jugadorRepository.findById(id);
        JugadorDTO jugadorActualizado = null;

        if(optionalJugadorEntity.isPresent()){
            JugadorEntity jugadorEntity = optionalJugadorEntity.get();
            jugadorEntity.setNombreJugador(jugadorDTO.getNombreJugador());
            jugadorRepository.save(jugadorEntity);
            jugadorActualizado = ConversorJugador.convertirDesdeJugadorEntity(jugadorEntity);
            return jugadorActualizado;
        }else{
            throw new JugadorNoExiste("No se encuentra el jugador con ID " + id);
        }

    }

    @Override
    public String borrar(int id) {
        Optional<JugadorEntity> optionalJugadorEntity = jugadorRepository.findById(id);
        if(optionalJugadorEntity.isPresent()){
            jugadorRepository.deleteById(id);
            return "Se ha borrado el jugador con ID " + id;
        }else{
            throw new JugadorNoExiste("No se encuentra el jugador con ID " + id);
        }
    }

    @Override
    public List<JugadorDTO> getAll() {
        List<JugadorEntity> listaJugadoresEntity = jugadorRepository.findAll();

        return listaJugadoresEntity.stream().map(ConversorJugador::convertirDesdeJugadorEntity).collect(Collectors.toList());
    }
    public List<JugadorDTO> getAllconPorcentajePorJugador(){
        List<JugadorEntity> listaJugadoresEntity = jugadorRepository.findAll();
        List<JugadorDTO> listaJugadoresDTO = new ArrayList<>();
        for(JugadorEntity jugadorEntity : listaJugadoresEntity){
            JugadorDTO jugadorDTO = ConversorJugador.convertirDesdeJugadorEntity(jugadorEntity);
            jugadorDTO.setPorcentaje(jugadorEntity.porcentaje());
            listaJugadoresDTO.add(jugadorDTO);
        }
        return listaJugadoresDTO;
    }

    @Override
    public JugadorDTO findById(int id) {
        Optional<JugadorEntity> optionalJugadorEntity = jugadorRepository.findById(id);
        if(optionalJugadorEntity.isPresent()){
            return ConversorJugador.convertirDesdeJugadorEntity(optionalJugadorEntity.get());
        }else{
            throw new JugadorNoExiste("No se ha encontrado el jugador con ID " + id);
        }
    }

    @Override
    public double porcentajeMedioExito() {
        List<JugadorEntity> listaJugadorEntity = jugadorRepository.findAll();
        if(!listaJugadorEntity.isEmpty()){
            double tasaExito = listaJugadorEntity.stream().mapToDouble(JugadorEntity::porcentaje).sum();
            return Math.round(tasaExito/listaJugadorEntity.size());
        } else{
            throw new JugadoresNoEncontrados("No existe ninguna lista de jugadores para hacer el cálculo medio de éxito");
        }
    }

    @Override
    public JugadorDTO mejorPorcentajeExito() {
        List<JugadorEntity> listaJugadorEntity = jugadorRepository.findAll();
        if(!listaJugadorEntity.isEmpty()) {
            JugadorEntity jugadorGanador = listaJugadorEntity.stream().max(Comparator.comparingDouble(JugadorEntity::porcentaje))
                    .orElseThrow(() -> new JugadoresNoEncontrados("No hay jugadores en la lista"));

            return ConversorJugador.convertirDesdeJugadorEntity(jugadorGanador);
        }else {
            throw new JugadoresNoEncontrados("No se han encontrado jugadores para hacer el cálculo");
        }
    }

    @Override
    public JugadorDTO peorPorcentajeExito() {
        List<JugadorEntity> listaJugadorEntity = jugadorRepository.findAll();
        if(!listaJugadorEntity.isEmpty()) {
            JugadorEntity jugadorGanador = listaJugadorEntity.stream().min(Comparator.comparingDouble(JugadorEntity::porcentaje))
                    .orElseThrow(() -> new JugadoresNoEncontrados("No hay jugadores en la lista"));

            return ConversorJugador.convertirDesdeJugadorEntity(jugadorGanador);
        } else{
            throw new JugadoresNoEncontrados("No se han encontrado jugadores para hacer el cálculo");
        }
    }
}