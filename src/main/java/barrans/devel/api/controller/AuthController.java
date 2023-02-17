package barrans.devel.api.controller;

import barrans.devel.api.model.User;
import barrans.devel.api.repository.UserRepository;
import barrans.devel.api.service.AuthService;
import io.vertx.core.json.JsonObject;

import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/v1/auth")
@PermitAll
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AuthController {

    @Inject
    AuthService service;

    @Inject
    UserRepository repository;

    @POST
    @Path("login")
    public Response login(JsonObject params) {
        String email = params.getString("email");
        String password = params.getString("password");

        System.out.println(email);
        System.out.println(repository.findById(1L).email);
        System.out.println(repository.count("email", email));

        if (!service.validateUser(email, password)) {
            return Response.status(400).entity("Email atau password salah!").build();
        }

        User user = repository.find("email", email).singleResult();

        String token = service.generateToken(user);

        return Response.ok(token).build();
    }
}
