package cat.itacademy.barcelonactiva.eugenia.s05.t02.n01.model.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Builder(builderMethodName = "crearJuego")


@Entity
@Table(name="Juego")
public class JuegoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idJuego;
    @Column(name="Fecha_ocurrencia")
    private LocalDate fechaOcurrencia = LocalDate.now();
    @Column(name="Dado_1")
    private int dado1;
    @Column(name="Dado_2")
    private int dado2;
    @Column(name="Resultado")
    private boolean ganada;

    @ManyToOne
    @JoinColumn(name="jugador_id")
    private JugadorEntity jugadorEntity;

    public JuegoEntity(){}
    public JuegoEntity(int idJuego, LocalDate fechaOcurrencia, int dado1, int dado2, boolean ganada, JugadorEntity jugadorEntity) {
        this.idJuego = idJuego;
        this.fechaOcurrencia = fechaOcurrencia;
        this.dado1 = dado1;
        this.dado2 = dado2;
        this.ganada = ganada;
        this.jugadorEntity = jugadorEntity;
    }

    public int getIdJuego() {
        return idJuego;
    }

    public void setIdJuego(int idJuego) {
        this.idJuego = idJuego;
    }

    public LocalDate getFechaOcurrencia() {
        return fechaOcurrencia;
    }

    public void setFechaOcurrencia(LocalDate fechaOcurrencia) {
        this.fechaOcurrencia = fechaOcurrencia;
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

    public JugadorEntity getJugadorEntity() {
        return jugadorEntity;
    }

    public void setJugadorEntity(JugadorEntity jugadorEntity) {
        this.jugadorEntity = jugadorEntity;
    }

    public boolean partidaGanada(){
        return dado1 + dado2 == 7;
    }




}