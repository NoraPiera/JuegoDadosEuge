package cat.itacademy.barcelonactiva.eugenia.s05.t02.n01.model.dto;
import lombok.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GameDTO {
    private int gameId;
    private int dado1;
    private int dado2;
    private boolean ganada;
}