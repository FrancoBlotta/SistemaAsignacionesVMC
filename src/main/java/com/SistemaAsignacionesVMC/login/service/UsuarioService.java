
package com.SistemaAsignacionesVMC.login.service;

import com.SistemaAsignacionesVMC.login.dto.request.LoginRequestDTO;
import com.SistemaAsignacionesVMC.login.dto.request.RegistroRequestDTO;

public interface UsuarioService {
    public void registrar(RegistroRequestDTO registroDTO);
    public boolean autenticar(LoginRequestDTO loginDTO);
    public void restablecerPassword(String email);
}
