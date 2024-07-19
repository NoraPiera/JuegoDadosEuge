package cat.itacademy.barcelonactiva.eugenia.s05.t02.n01.model.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder

public class UserDTO {
    private String name;
    private String secondName;
    private String email;
    private String password;
    public UserDTO() {
    }
    public UserDTO(String name, String secondName, String email, String password) {
        this.name = name;
        this.secondName = secondName;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}