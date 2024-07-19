package cat.itacademy.barcelonactiva.eugenia.s05.t02.n01.exceptions;
public class PlayerNotExists extends RuntimeException {
    public PlayerNotExists(String mensaje){
        super(mensaje);
    }
}