package cat.itacademy.barcelonactiva.eugenia.s05.t02.n01.controllers;


import cat.itacademy.barcelonactiva.eugenia.s05.t02.n01.model.dto.JuegoDTO;
import cat.itacademy.barcelonactiva.eugenia.s05.t02.n01.model.dto.JugadorDTO;
import cat.itacademy.barcelonactiva.eugenia.s05.t02.n01.model.service.JuegoServiceImpl;
import cat.itacademy.barcelonactiva.eugenia.s05.t02.n01.model.service.JugadorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RestController
    @RequestMapping("/players")
    public class JugadorController {
        @Autowired
        JugadorServiceImpl jugadorService;
        @Autowired
        JuegoServiceImpl juegoService;

        @PostMapping("/crear")
        ResponseEntity<JugadorDTO> crearJugador(@RequestBody JugadorDTO jugadorDTO){
            JugadorDTO jugadorDTO1 = jugadorService.crear(jugadorDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(jugadorDTO1);
        }
        @PutMapping("/actualizar/{id}")
        ResponseEntity<JugadorDTO> actualzarJugador(@PathVariable int id, @RequestBody JugadorDTO jugadorDTO) {
            JugadorDTO jugadorDTO1 = jugadorService.actualizar(id, jugadorDTO);
            return ResponseEntity.ok(jugadorDTO1);
        }
        @PostMapping("/{id}/partidas")
        public ResponseEntity<JuegoDTO> jugarPartida(@PathVariable int id){
            JuegoDTO juegoDTO = juegoService.jugarJuego(id);
            return ResponseEntity.status(HttpStatus.CREATED).body(juegoDTO);
        }
        @DeleteMapping("/{id}/eliminarPartidas")
        public ResponseEntity<String> eliminarPartidas(@PathVariable int id){
            String mensaje = juegoService.borrarJuegos(id);
            return ResponseEntity.ok(mensaje);
        }
        @DeleteMapping("/{id}/borrarJugador")
        public ResponseEntity<String> eliminarJugador(@PathVariable int id){
            String mensaje = jugadorService.borrar(id);
            return ResponseEntity.ok(mensaje);
        }
        @GetMapping("/mostrarListadoPorcentajeJugador")
        public ResponseEntity<List<JugadorDTO>> mostrarListadoPorcentajeMedio(){
            List<JugadorDTO>listaJugadores = jugadorService.getAllconPorcentajePorJugador();
            return ResponseEntity.ok(listaJugadores);
        }
        @GetMapping("/{id}/mostrarJugadasPorJugador")
        public ResponseEntity<List<JuegoDTO>>partidasPorJugador(@PathVariable int id){
            List<JuegoDTO>listaJuegos = juegoService.listaJugadasByJugador(id);
            return ResponseEntity.ok(listaJuegos);
        }
        @GetMapping("/ranking")
        public ResponseEntity<Double> porcentajeMedioTodosJugadores(){
            double porcentajeMedioExito = jugadorService.porcentajeMedioExito();
            return ResponseEntity.ok(porcentajeMedioExito);
        }
        @GetMapping("/ranking/loser")
        public ResponseEntity<JugadorDTO> peorPorcentaje(){
            JugadorDTO jugadorDTO = jugadorService.peorPorcentajeExito();
            return ResponseEntity.ok(jugadorDTO);
        }
        @GetMapping("/ranking/winner")
        public ResponseEntity<JugadorDTO> mejorPorcentaje(){
            JugadorDTO jugadorDTO = jugadorService.mejorPorcentajeExito();
            return ResponseEntity.ok(jugadorDTO);
        }




    }
