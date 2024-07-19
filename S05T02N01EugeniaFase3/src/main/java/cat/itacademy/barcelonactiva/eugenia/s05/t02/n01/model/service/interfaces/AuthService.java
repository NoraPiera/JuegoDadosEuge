package cat.itacademy.barcelonactiva.eugenia.s05.t02.n01.model.service.interfaces;

import cat.itacademy.barcelonactiva.eugenia.s05.t02.n01.model.dto.AuthRequest;
import cat.itacademy.barcelonactiva.eugenia.s05.t02.n01.model.dto.AuthResponse;
import cat.itacademy.barcelonactiva.eugenia.s05.t02.n01.model.dto.UserDTO;

public interface AuthService {
    AuthResponse register(UserDTO userDTO);
    AuthResponse authenticate(AuthRequest authRequest);
}