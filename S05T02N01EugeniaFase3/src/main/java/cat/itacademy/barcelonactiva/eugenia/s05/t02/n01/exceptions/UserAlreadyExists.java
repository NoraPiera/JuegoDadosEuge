package cat.itacademy.barcelonactiva.eugenia.s05.t02.n01.exceptions;
public class UserAlreadyExists extends RuntimeException{
    public UserAlreadyExists(String mensaje){
        super(mensaje);
    }
}