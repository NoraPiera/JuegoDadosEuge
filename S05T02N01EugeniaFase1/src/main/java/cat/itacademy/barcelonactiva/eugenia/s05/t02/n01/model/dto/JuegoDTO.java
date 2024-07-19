package cat.itacademy.barcelonactiva.eugenia.s05.t02.n01.model.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder(builderMethodName = "crearJuegoDTO")

public class JuegoDTO {
    private int idJuego;
    private int dado1;
    private int dado2;
    private boolean ganada;

    public JuegoDTO(){}
    public JuegoDTO(int idJuego, int dado1, int dado2, boolean ganada){
        this.idJuego = idJuego;
        this.dado1 = dado1;
        this.dado2 = dado2;
        this.ganada = ganada;
    }

    public int getIdJuego() {
        return idJuego;
    }

    public void setIdJuego(int idJuego) {
        this.idJuego = idJuego;
    }

    public int getDado1() {
        return dado1;
    }

    public void setDado1(int dado1) {
        this.dado1 = dado1;
    }

    public int getDado2() {
        return dado2;
    }

    public void setDado2(int dado2) {
        this.dado2 = dado2;
    }

    public boolean isGanada() {
        return ganada;
    }

    public void setGanada(boolean ganada) {
        this.ganada = ganada;
    }
}