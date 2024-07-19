package cat.itacademy.barcelonactiva.eugenia.s05.t02.n01.model.domain;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Builder

@Entity
@Table(name="Jugador")

public class PlayerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPlayer;
    @Column(name = "NombreJugador")
    private String name;
    @Column(name = "FechaRegistro")
    private LocalDateTime fechaRegistro = LocalDateTime.now();

    @OneToMany(mappedBy = "jugadorEntity", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<GameEntity> listaPartidas = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "id_User", referencedColumnName = "userID")
    private UserEntity userEntity;
    public PlayerEntity() {
    }
    public PlayerEntity(String name, UserEntity userEntity) {
        this.name = name;
        this.userEntity = userEntity;
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

    public List<GameEntity> getListaPartidas() {
        return listaPartidas;
    }

    public void setListaPartidas(List<GameEntity> listaPartidas) {
        this.listaPartidas = listaPartidas;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public void agregarPartida(GameEntity juego){
        listaPartidas.add(juego);
    }
    public float porcentaje(){
        float porcentajeExito = 0.0f;
        if(listaPartidas != null & !listaPartidas.isEmpty()){
            long totalPartidas = listaPartidas.size();
            long partidasGanadas = listaPartidas.stream().filter(GameEntity::partidaGanada).count();
            porcentajeExito = (float) partidasGanadas/totalPartidas * 100;
        }
        return porcentajeExito;
    }

}