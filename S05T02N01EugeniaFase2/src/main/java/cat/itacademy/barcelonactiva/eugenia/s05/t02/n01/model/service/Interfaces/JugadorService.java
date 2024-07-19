package cat.itacademy.barcelonactiva.eugenia.s05.t02.n01.model.service.Interfaces;

import cat.itacademy.barcelonactiva.eugenia.s05.t02.n01.model.dto.JugadorDTO;

import java.util.List;

public interface JugadorService {
    JugadorDTO crear(JugadorDTO jugadorDTO);

    JugadorDTO actualizar(String id, JugadorDTO jugadorDTO);

    String borrar(String id);

    List<JugadorDTO> getAll();

    List<JugadorDTO> getAllconPorcentajePorJugador();

    JugadorDTO findById(String id);

    double porcentajeMedioExito();

    JugadorDTO mejorPorcentajeExito();

    JugadorDTO peorPorcentajeExito();
}