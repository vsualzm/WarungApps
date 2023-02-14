package barrans.devel.api.controller;


import barrans.devel.api.api.oas.*;
import barrans.devel.api.model.ProductUnit;
import barrans.devel.api.service.ProductUnitService;
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

@Path("/tambah/v1/productunit")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductUnitController {

    @Inject
    ProductUnitService productUnitService;

    @POST
    @Operation(summary = "Add New ProductUnit")
    @RequestBody(content = {
            @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = AddProductUnitOAS.Request.class))
    })
    @APIResponses(value = {
            @APIResponse(responseCode = "200",description = "OK", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = AddProductUnitOAS.Response.class))),
            @APIResponse(responseCode = "400",description = "Bad Request", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = AddProductUnitOAS.BadRequest.class)))
    })
    public Response addProductUnit(JsonObject params){
        ProductUnit productUnit = new ProductUnit();
        productUnit.description = params.getString("description");
        productUnitService.persistProductUnit(productUnit);
        return Response.noContent().build();
    }

    @PUT
    @Path("/{id}")
    @Operation(summary = "Update ProductUnit")
    @RequestBody(content = {
            @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = UpdateProductUnitOAS.Request.class))
    })
    @APIResponses(value = {
            @APIResponse(responseCode = "200",description = "OK", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = UpdateProductUnitOAS.Response.class))),
            @APIResponse(responseCode = "400",description = "Bad Request", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = UpdateProductUnitOAS.BadRequest.class)))
    })
    public Response updateProductUnit(@RestPath Long id, JsonObject params){
        productUnitService.updateProductUnit(id,params);
        return Response.noContent().build();
    }

    @Operation(summary = "Deletes an exiting villain")
    @DELETE
    @Path("/{id}")
    @APIResponses(value = {
            @APIResponse(responseCode = "200",description = "OK", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = DeleteProductUnitOAS.Response.class))),
            @APIResponse(responseCode = "400",description = "Bad Request", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = DeleteProductUnitOAS.BadRequest.class)))
    })
    public Response deleteVillain(@RestPath Long id) {
        productUnitService.deleteProductUnit(id);
        return Response.noContent().build();
    }



}
