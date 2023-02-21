package barrans.devel.api.controller;

import barrans.devel.api.service.UsersService;
import io.vertx.core.json.JsonObject;
import org.jboss.resteasy.reactive.RestPath;

import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Map;

@Path("/v1/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsersController {

    @Inject
    UsersService userService;

    @POST
    public Response addUser(JsonObject params) {
        userService.addUser(params);
        return Response.status(Response.Status.OK).build();
    }

    @GET
    public Response getUserAll(@QueryParam("status")
                               @NotNull Integer status,
                               @QueryParam("page")
                               @NotNull Integer page,
                               @QueryParam("size")
                               @NotNull Integer size) {
        JsonObject result = new JsonObject();
        Map<String, Object> data = userService.getUserAll(status, page, size);
        boolean dataStatus = !((Map) data.get("meta")).get("total").equals(0);
        result.put("status", dataStatus ? "success" : "failed");
        result.put("data", dataStatus ? data : "Not Found");
        return Response.status(dataStatus ? Response.Status.OK : Response.Status.NOT_FOUND)
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

    @PUT
    @Path("/{id}")
    public Response editUser(@RestPath Long id, JsonObject params){
        userService.updateUser(id, params);
        return Response.status(Response.Status.OK).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteVillain(@RestPath Long id) {
        userService.deleteUser(id);
        return Response.status(Response.Status.OK).build();
    }
}
