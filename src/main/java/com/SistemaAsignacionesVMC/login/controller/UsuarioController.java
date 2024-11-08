
package com.SistemaAsignacionesVMC.login.controller;

import com.SistemaAsignacionesVMC.login.dto.request.LoginRequestDTO;
import com.SistemaAsignacionesVMC.login.dto.request.RegistroRequestDTO;
import com.SistemaAsignacionesVMC.login.dto.response.RegistroResponseDTO;
import com.SistemaAsignacionesVMC.login.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/usuario")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class UsuarioController {
    
    private final UsuarioService usuarioService;
    
    @GetMapping("/registro")
    public ResponseEntity<String> handleGet() {
        return ResponseEntity.ok("Endpoint de usuario alcanzado correctamente.");
    }
    
    @PostMapping("/registro")
    public ResponseEntity<?> registro(@RequestBody @Valid RegistroRequestDTO registroDTO) {
        try {
            usuarioService.registrar(registroDTO);
            RegistroResponseDTO registroResponseDTO = new RegistroResponseDTO("Usuario creado");

            return ResponseEntity.status(HttpStatus.CREATED).body(registroResponseDTO);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
    
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid LoginRequestDTO loginDTO) {
        if (usuarioService.autenticar(loginDTO)) {
            return ResponseEntity.ok(new RegistroResponseDTO("Inicio de sesión exitoso"));
        } else {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Usuario/password incorrectos");
        }
    }

    @PostMapping("/restablecer-password")
    public ResponseEntity<String> restablecerPassword(@RequestParam String email) {
        try {
            usuarioService.restablecerPassword(email);
            return ResponseEntity.ok("Se ha generado una nueva clave para tu usuario. Podrás visualizarla en tu mail registrado.");
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
}
