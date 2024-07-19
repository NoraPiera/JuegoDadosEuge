package cat.itacademy.barcelonactiva.eugenia.s05.t02.n01.model.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;




@Entity
@Table(name="Jugador")
public class JugadorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pk_IdJugador;
    @Column(name="NombreJugador")
    private String nombreJugador;
    @Column(name="FechaRegistro")
    private LocalDateTime fechaRegistro = LocalDateTime.now();

    @OneToMany(mappedBy = "jugadorEntity", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<JuegoEntity> listaPartidas = new ArrayList<>();

    public JugadorEntity(){

    }
    public JugadorEntity(String nombreJugador){
        this.nombreJugador = nombreJugador;
    }

    public int getPk_IdJugador() {
        return pk_IdJugador;
    }

    public void setPk_IdJugador(int pk_IdJugador) {
        this.pk_IdJugador = pk_IdJugador;
    }

    public String getNombreJugador() {
        return nombreJugador;
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public List<JuegoEntity> getListaPartidas() {
        return listaPartidas;
    }

    public void setListaPartidas(List<JuegoEntity> listaPartidas) {
        this.listaPartidas = listaPartidas;
    }

    public void agregarPartida(JuegoEntity juego){
        if(listaPartidas.isEmpty()){
            listaPartidas = new ArrayList<>();
        }
        listaPartidas.add(juego);
    }
    public float porcentaje(){
        float porcentajeExito = 0.0f;
        if(listaPartidas != null & !listaPartidas.isEmpty()){
            long totalPartidas = listaPartidas.size();
            long partidasGanadas = listaPartidas.stream().filter(JuegoEntity::partidaGanada).count();
            porcentajeExito = (float) partidasGanadas/totalPartidas * 100;
        }
        return porcentajeExito;
    }
}