package cat.itacademy.barcelonactiva.eugenia.s05.t02.n01.exceptions;
public class PlayersNotFound extends RuntimeException{
    public PlayersNotFound(String mensaje){
        super(mensaje);
    }
}