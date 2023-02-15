package barrans.devel.api.controller;


import barrans.devel.api.api.dto.UserDTO;
import barrans.devel.api.api.oas.*;
import barrans.devel.api.model.User;
import barrans.devel.api.service.UserService;
import io.quarkus.logging.Log;
import io.vertx.core.json.JsonObject;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.jboss.resteasy.reactive.RestPath;

import javax.inject.Inject;
import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Map;

@Path("/v1/user")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserController {

    @Inject
    UserService userService;

    @POST
    public Response addUser(JsonObject params) {
//        JsonObject result = new JsonObject();
        User user = new User();
        user.email = params.getString("email");
        userService.persistUser(user);
        return Response.noContent().build();
    }

    @PUT
    @Path("/{id}")
    public Response updateUser(@RestPath Long id, JsonObject params) {
        userService.updateUser(id, params);
        return Response.noContent().build();
    }

    @GET
    public Response getUserAll(@QueryParam("status")
                               @NotNull Integer id,
                               @QueryParam("page")
                               @NotNull Integer page,
                               @QueryParam("size")
                               @NotNull Integer size) {
        JsonObject result = new JsonObject();
        Map<String, Object> data = userService.getUserAll(id, page, size);
        boolean status = !((Map) data.get("meta")).get("total").equals(0);
        result.put("status", status ? "success" : "failed");
        result.put("data", status ? data : "Not Found");
        return Response.status(status ? Response.Status.OK : Response.Status.NOT_FOUND)
                .entity(result)
                .build();
    }


    @GET
    @Path("/{id}")
    public Response getUserById(@RestPath Long id) {
        JsonObject result = new JsonObject();
        result.put("data", userService.findUserById(id));
        return Response.ok().entity(result).build();
    }


    @DELETE
    @Path("/{id}")
    public Response deleteVillain(@RestPath Long id) {
        userService.deleteUser(id);
        return Response.noContent().build();
    }
}
