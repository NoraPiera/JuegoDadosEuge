package cat.itacademy.barcelonactiva.eugenia.s05.t02.n01.exceptions;
public class UserNotFound extends RuntimeException{
    public UserNotFound(String mensaje){
        super(mensaje);
    }
}