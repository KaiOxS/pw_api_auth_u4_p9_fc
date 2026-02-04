package uce.edu.web.api.auth.application;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import uce.edu.web.api.auth.domain.Auth;
import uce.edu.web.api.auth.infraestructure.AuthRepository;

@ApplicationScoped
public class AuthService {

    @Inject
    private AuthRepository authRepository;

    public String autenticar(String usuario, String password) {

        Auth usuarioEncontrado = authRepository.findByUsername(usuario);

        if (usuarioEncontrado != null && usuarioEncontrado.getPassword().equals(password)) {
            return usuarioEncontrado.getRole();
        }

        return null;
    }
}
