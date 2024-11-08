
package com.SistemaAsignacionesVMC.login.serviceImpl;

import com.SistemaAsignacionesVMC.login.dto.request.LoginRequestDTO;
import com.SistemaAsignacionesVMC.login.dto.request.RegistroRequestDTO;
import com.SistemaAsignacionesVMC.login.entity.Usuario;
import com.SistemaAsignacionesVMC.login.repository.UsuarioRepository;
import com.SistemaAsignacionesVMC.login.service.UsuarioService;
import jakarta.transaction.Transactional;
import java.util.Optional;
import java.util.Random;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {
    
    private final UsuarioRepository usuarioRepository;

    private final JavaMailSender emailSender;

    @Override
    @Transactional
    public void registrar(RegistroRequestDTO registroDTO) {
        // Verificar si ya existe un usuario con el email proporcionado
        if (usuarioRepository.findByemail(registroDTO.getEmail()).isPresent()) {
            throw new RuntimeException("Ya existe un usuario con ese email");
        }

        // Crear un nuevo usuario
        Usuario usuario = new Usuario();
        usuario.setNombre(registroDTO.getNombre());
        usuario.setApellido(registroDTO.getApellido());
        usuario.setEmail(registroDTO.getEmail());
        usuario.setPassword(registroDTO.getPassword());

        // Guardar el usuario en la base de datos
        usuarioRepository.save(usuario);
    }

    @Override
    public boolean autenticar(LoginRequestDTO loginDTO) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findByemail(loginDTO.getEmail());
        return usuarioOptional.isPresent() && usuarioOptional.get().getPassword().equals(loginDTO.getPassword());
    }

    @Override
    public void restablecerPassword(String email) {
        // Generar una nueva password aleatoria
        String nuevaPassword = generarPasswordAleatoria();

        // Buscar el usuario por su email
        Usuario usuario = usuarioRepository.findByemail(email)
                .orElseThrow(() -> new RuntimeException("No se encontró un usuario con el email proporcionado."));

        // Actualizar la password del usuario en la base de datos
        usuario.setPassword(nuevaPassword);
        usuarioRepository.save(usuario);

        // Enviar la nueva password por correo
        enviarCorreo(usuario.getEmail(), nuevaPassword);
    }
    
    private String generarPasswordAleatoria() {

        int longitud = 8;
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789@$%&*!";
        Random random = new Random();
        StringBuilder password = new StringBuilder();

        boolean tieneLetraMayuscula = false;
        boolean tieneLetraMinuscula = false;
        boolean tieneNumero = false;
        boolean tieneCaracterEspecial = false;

        for (int i = 0; i < longitud; i++) {
            int indice = random.nextInt(caracteres.length());
            char caracter = caracteres.charAt(indice);
            password.append(caracter);

            if (Character.isUpperCase(caracter)) {
                tieneLetraMayuscula = true;
            } else if (Character.isLowerCase(caracter)) {
                tieneLetraMinuscula = true;
            } else if (Character.isDigit(caracter)) {
                tieneNumero = true;
            } else if ("@#$%&*!".indexOf(caracter) != -1) {
                tieneCaracterEspecial = true;
            }
        }
        
        // Verificar que la password contenga al menos un carácter de cada tipo requerido
        if (!tieneLetraMayuscula || !tieneLetraMinuscula || !tieneNumero || !tieneCaracterEspecial) {
            // Llamar recursivamente si no cumple con los requisitos
            return generarPasswordAleatoria();
        }
        
        return password.toString();
    }

    private void enviarCorreo(String email, String nuevaPasswrod) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Nueva password");
        message.setText("Tu nueva password es: " + nuevaPasswrod);
        emailSender.send(message);
    }
}
