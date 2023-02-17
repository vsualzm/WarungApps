package barrans.devel.api.service;

import barrans.devel.api.model.User;
import barrans.devel.api.repository.UserRepository;
import io.smallrye.jwt.build.Jwt;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class AuthService {

    @Inject
    UserRepository repository;

    public String generateToken(User user) {
        return Jwt.issuer("kawahedukasi")
                .subject("kawahedukasi")
                .groups(user.role.name())
                .expiresIn(3600)
                .sign();
    }

    public boolean validateUser(String email, String password) {
        return repository.count("email", email) > 0;
    }
}
