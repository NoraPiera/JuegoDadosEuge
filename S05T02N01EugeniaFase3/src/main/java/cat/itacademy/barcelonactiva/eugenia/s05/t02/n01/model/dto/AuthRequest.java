package cat.itacademy.barcelonactiva.eugenia.s05.t02.n01.model.dto;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthRequest {
    private String email;
    private String password;
}