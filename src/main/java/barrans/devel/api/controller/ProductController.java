package barrans.devel.api.controller;

import barrans.devel.api.api.oas.*;
import barrans.devel.api.model.Product;
import barrans.devel.api.service.ProductService;
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


@Path("/v1/product")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductController {

    @Inject
    ProductService productService;

    @POST
    @Operation(summary = "Add New Product")
    @RequestBody(content = {
            @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = AddProductOAS.Request.class))
    })
    @APIResponses(value = {
            @APIResponse(responseCode = "200",description = "OK", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = AddProductOAS.Response.class))),
            @APIResponse(responseCode = "400",description = "Bad Request", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = AddProductOAS.BadRequest.class)))
    })
    public Response addProduct(JsonObject params){
        Product product = new Product();
        product.barcode = params.getLong("barcode");
        product.productName = params.getString("productName");
        product.description = params.getString("description");
        product.price = params.getDouble("price");
        product.image = params.getString("image");
        productService.persistProduct(product);
        return Response.noContent().build();
    }

    @PUT
    @Path("/{id}")
    @Operation(summary = "Update Product")
    @RequestBody(content = {
            @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = UpdateProductOAS.Request.class))
    })
    @APIResponses(value = {
            @APIResponse(responseCode = "200",description = "OK", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = UpdateProductOAS.Response.class))),
            @APIResponse(responseCode = "400",description = "Bad Request", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = UpdateProductOAS.BadRequest.class)))
    })
    public Response updateProduct(@RestPath Long id, JsonObject params){
        productService.updateProduct(id,params);
        return Response.noContent().build();
    }

    @GET
    @Operation(summary = "Get All Product")
    @APIResponses(value = {
            @APIResponse(responseCode = "200",description = "OK", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = GetListProductOAS.Response.class))),
            @APIResponse(responseCode = "400",description = "Bad Request", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = GetListProductOAS.BadRequest.class)))
    })
    public Response getProductAllProduct(){
        JsonObject result = new JsonObject();
        result.put("dataProduct", productService.getListAllProduct());
        return Response.ok().entity(result).build();
    }

    @Operation(summary = "Deletes an exiting villain")
    @DELETE
    @Path("/{id}")
    @APIResponses(value = {
            @APIResponse(responseCode = "200",description = "OK", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = DeleteProductOAS.Response.class))),
            @APIResponse(responseCode = "400",description = "Bad Request", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = DeleteProductOAS.BadRequest.class)))
    })
    public Response deleteVillain(@RestPath Long id) {
        productService.deleteProduct(id);
        return Response.noContent().build();
    }
    @GET
    @Path("/{id}")
    @Operation(summary = "Get Product By Id")
    @APIResponses(value = {
            @APIResponse(responseCode = "200",description = "OK", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = GetProductByIdOAS.Response.class))),
            @APIResponse(responseCode = "400",description = "Bad Request", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = GetProductByIdOAS.BadRequest.class)))
    })
    public Response getProductById(@RestPath Long id){
        JsonObject result = new JsonObject();
        result.put("dataProduct", productService.findProductById(id));
        return Response.ok().entity(result).build();
    }



//        @POST
//        @Consumes(MediaType.MULTIPART_FORM_DATA)
//        public Response addProduct(
//                @FormDataParam("barcode") Long barcode,
//                @FormDataParam("productName") String productName,
//                @FormDataParam("description") String description,
//                @FormDataParam("price") Double price,
//                @FormDataParam("image") MultipartFile image
//        ) throws IOException {
//
//            Product product = new Product();
//            product.barcode = barcode;
//            product.productName = productName;
//            product.description = description;
//            product.price = price;
//            if (image != null) {
//                product.image = image.getBytes();
//            }
//
//            productService.persistProduct(product);
//            return Response.noContent().build();
//        }
//    }

}
