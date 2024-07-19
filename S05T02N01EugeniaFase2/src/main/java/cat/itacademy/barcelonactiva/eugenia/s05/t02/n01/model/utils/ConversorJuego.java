package cat.itacademy.barcelonactiva.eugenia.s05.t02.n01.model.utils;

import cat.itacademy.barcelonactiva.eugenia.s05.t02.n01.model.domain.JuegoEntity;
import cat.itacademy.barcelonactiva.eugenia.s05.t02.n01.model.dto.JuegoDTO;
import org.springframework.stereotype.Component;

@Component
public class ConversorJuego {
    public static JuegoDTO convertirDesdeJuegoEntity(JuegoEntity juegoEntity){
        JuegoDTO juegoDTO = new JuegoDTO();

        juegoDTO.setId(juegoEntity.getId());
        juegoDTO.setDado1(juegoEntity.getDado1());
        juegoDTO.setDado2(juegoEntity.getDado2());
        juegoDTO.setGanada(juegoEntity.isPartidaGanada());

        return juegoDTO;
    }
    public static JuegoEntity convertirParaJuegoEntity(JuegoDTO juegoDTO){
        JuegoEntity juegoEntity = new JuegoEntity();

        juegoEntity.setId(juegoDTO.getId());
        juegoEntity.setDado1(juegoDTO.getDado1());
        juegoEntity.setDado2(juegoDTO.getDado2());
        juegoEntity.setPartidaGanada(juegoDTO.isGanada());

        return juegoEntity;
    }
}