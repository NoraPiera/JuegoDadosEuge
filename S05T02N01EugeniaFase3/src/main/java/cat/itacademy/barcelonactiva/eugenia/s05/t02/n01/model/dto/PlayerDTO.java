package cat.itacademy.barcelonactiva.eugenia.s05.t02.n01.model.dto;
import lombok.*;


import java.time.LocalDateTime;


@Builder

public class PlayerDTO {
    private int idPlayer;
    private String name;
    private LocalDateTime fechaRegistro;
    private float porcentaje;
    public PlayerDTO() {
    }
    public PlayerDTO(int idPlayer, String name, LocalDateTime fechaRegistro, float porcentaje) {
        this.idPlayer = idPlayer;
        this.name = name;
        this.fechaRegistro = fechaRegistro;
        this.porcentaje = porcentaje;
    }

    public int getIdPlayer() {
        return idPlayer;
    }

    public void setIdPlayer(int idPlayer) {
        this.idPlayer = idPlayer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public float getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(float porcentaje) {
        this.porcentaje = porcentaje;
    }
}