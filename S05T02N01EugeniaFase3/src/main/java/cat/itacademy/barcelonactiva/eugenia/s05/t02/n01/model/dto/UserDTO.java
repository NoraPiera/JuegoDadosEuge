package cat.itacademy.barcelonactiva.eugenia.s05.t02.n01.model.dto;


import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private String name;
    private String secondName;
    private String email;
    private String password;
}