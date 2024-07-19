package cat.itacademy.barcelonactiva.eugenia.s05.t02.n01.exceptions;


public class PartidasNoEncontradas extends RuntimeException {
    public PartidasNoEncontradas(String mensaje){
        super(mensaje);
    }
}