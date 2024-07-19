package cat.itacademy.barcelonactiva.eugenia.s05.t02.n01.exceptions;
public class GameNotFound extends RuntimeException{
    public GameNotFound(String mensaje){
        super(mensaje);
    }
}