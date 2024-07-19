package cat.itacademy.barcelonactiva.eugenia.s05.t02.n01.controllers;
import cat.itacademy.barcelonactiva.eugenia.s05.t02.n01.model.dto.AuthRequest;
import cat.itacademy.barcelonactiva.eugenia.s05.t02.n01.model.dto.AuthResponse;
import cat.itacademy.barcelonactiva.eugenia.s05.t02.n01.model.dto.UserDTO;
import cat.itacademy.barcelonactiva.eugenia.s05.t02.n01.model.service.interfaces.AuthService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/auth")
@RequiredArgsConstructor
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody UserDTO userDTO){
        return ResponseEntity.ok(authService.register(userDTO));
    }
    @PostMapping("/authenticate")
    public ResponseEntity<AuthResponse> authenticate (@RequestBody AuthRequest authRequest){
        return ResponseEntity.ok(authService.authenticate(authRequest));
    }
}