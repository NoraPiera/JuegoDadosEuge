package cat.itacademy.barcelonactiva.eugenia.s05.t02.n01.model.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;





public class JugadorDTO {
    private int pk_IdJugador;
    private String nombreJugador;
    private float porcentaje;

    public JugadorDTO(){

    }
    public JugadorDTO(String nombreJugador, float porcentaje){
        this.nombreJugador = nombreJugador;
        this.porcentaje = porcentaje;
    }
    public String getNombreJugador() {
        return nombreJugador;
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    public float getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(float porcentaje) {
        this.porcentaje = porcentaje;
    }

    public int getPk_IdJugador() {
        return pk_IdJugador;
    }

    public void setPk_IdJugador(int pk_IdJugador) {
        this.pk_IdJugador = pk_IdJugador;
    }
}