package cat.itacademy.barcelonactiva.eugenia.s05.t02.n01.exceptions;
public class JugadoresNoEncontrados extends RuntimeException {
    public JugadoresNoEncontrados(String mensaje){
        super(mensaje);
    }
}