package cat.itacademy.barcelonactiva.eugenia.s05.t02.n01.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(GameNotFound.class)
    public ResponseEntity<String> handleGameNotFound(GameNotFound ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
    @ExceptionHandler(PlayerAlreadyExists.class)
    public ResponseEntity<String> handlePlayerAlreadyExists(PlayerAlreadyExists ex, WebRequest request) {

        String message = ex.getMessage() + " " + request.getDescription(false);

        return new ResponseEntity<String>(message, HttpStatus.CONFLICT);

    }
    @ExceptionHandler(PlayerNotExists.class)
    public ResponseEntity<String> handlePlayerNotExists (PlayerNotExists ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
    @ExceptionHandler(PlayersNotFound.class)
    public ResponseEntity<String> handlePlayersNotFound(PlayersNotFound ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
    @ExceptionHandler(UserAlreadyExists.class)
    public ResponseEntity<String> handleUserAlreadyExists(UserAlreadyExists ex){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
    }
    @ExceptionHandler(UserNotFound.class)
    public ResponseEntity<String> handleUserNotFound(UserNotFound ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

}