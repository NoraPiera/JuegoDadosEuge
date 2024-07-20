package cat.itacademy.barcelonactiva.eugenia.s05.t02.n01.model.dto;
import lombok.*;


import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PlayerDTO {

    private int idPlayer;
    private String name;
    private LocalDateTime fechaRegistro;
    private float porcentaje;

}