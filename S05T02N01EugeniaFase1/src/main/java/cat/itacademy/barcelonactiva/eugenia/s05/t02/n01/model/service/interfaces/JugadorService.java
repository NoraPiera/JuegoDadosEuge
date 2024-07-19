package cat.itacademy.barcelonactiva.eugenia.s05.t02.n01.model.service.interfaces;



import cat.itacademy.barcelonactiva.eugenia.s05.t02.n01.model.dto.JugadorDTO;

import java.util.List;

public interface JugadorService {
    JugadorDTO crear(JugadorDTO jugadorDTO);
    JugadorDTO actualizar(int id, JugadorDTO jugadorDTO);
    String borrar(int id);
    List<JugadorDTO> getAll();
    List<JugadorDTO> getAllconPorcentajePorJugador();
    JugadorDTO findById(int id);
    double porcentajeMedioExito();
    JugadorDTO mejorPorcentajeExito();
    JugadorDTO peorPorcentajeExito();

}