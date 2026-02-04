package uce.edu.web.api.auth.infraestructure;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import uce.edu.web.api.auth.domain.Auth;

@ApplicationScoped
public class AuthRepository implements PanacheRepository<Auth> {

    public Auth findByUsername(String usuario) {
        return find("usuario", usuario).firstResult();
    }
}
