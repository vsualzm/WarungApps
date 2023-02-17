package barrans.devel.api.controller;


import barrans.devel.api.api.oas.*;
import barrans.devel.api.model.User;
import barrans.devel.api.service.UserService;
import barrans.devel.api.type.RoleType;
import io.quarkus.security.Authenticated;
import io.vertx.core.json.JsonObject;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.jboss.resteasy.reactive.RestPath;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/v1/user")
@Authenticated
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserController {

    @Inject
    UserService userService;

    @POST
    @Operation(summary = "Add New User")
    @RequestBody(content = {
            @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = AddUserOAS.Request.class))
    })
    @APIResponses(value = {
            @APIResponse(responseCode = "200",description = "OK", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = AddUserOAS.Response.class))),
            @APIResponse(responseCode = "400",description = "Bad Request", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = AddUserOAS.BadRequest.class)))
    })
    public Response addUser(JsonObject params){
//        JsonObject result = new JsonObject();
        User user = new User();
        user.email = params.getString("email");
        user.username = params.getString("username");
        user.mobile_phone_number = params.getString("mobile_phone_number");

        if (params.getString("role").toUpperCase().equals("ADMIN")) {
            user.role = RoleType.ADMIN;
        } else {
            user.role = RoleType.USER;
        }

        userService.persistUser(user);
        return Response.noContent().build();
    }

    @PUT
    @Path("/{id}")
    @Operation(summary = "Update User")
    @RequestBody(content = {
            @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = UpdateUserOAS.Request.class))
    })
    @APIResponses(value = {
            @APIResponse(responseCode = "200",description = "OK", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = UpdateUserOAS.Response.class))),
            @APIResponse(responseCode = "400",description = "Bad Request", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = UpdateUserOAS.BadRequest.class)))
    })
    public Response updateUser(@RestPath Long id, JsonObject params){
        userService.updateUser(id,params);
        return Response.noContent().build();
    }

    @GET
    @Operation(summary = "Get All User")
    @APIResponses(value = {
            @APIResponse(responseCode = "200",description = "OK", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = GetListUserOAS.Response.class))),
            @APIResponse(responseCode = "400",description = "Bad Request", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = GetListUserOAS.BadRequest.class)))
    })
    public Response getUserAll(){
        JsonObject result = new JsonObject();
        result.put("data", userService.getListAll());
        return Response.ok().entity(result).build();
    }


    @GET
    @Path("/{id}")
    @Operation(summary = "Get User By Id")
    @APIResponses(value = {
            @APIResponse(responseCode = "200",description = "OK", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = GetUserByIdOAS.Response.class))),
            @APIResponse(responseCode = "400",description = "Bad Request", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = GetUserByIdOAS.BadRequest.class)))
    })
    public Response getUserById(@RestPath Long id){
        JsonObject result = new JsonObject();
        result.put("data", userService.findUserById(id));
        return Response.ok().entity(result).build();
    }

    @Operation(summary = "Deletes an exiting villain")
    @DELETE
    @Path("/{id}")
    @APIResponses(value = {
            @APIResponse(responseCode = "200",description = "OK", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = DeleteUserOAS.Response.class))),
            @APIResponse(responseCode = "400",description = "Bad Request", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = DeleteUserOAS.BadRequest.class)))
    })
    public Response deleteVillain(@RestPath Long id) {
        userService.deleteUser(id);
        return Response.noContent().build();
    }
}
