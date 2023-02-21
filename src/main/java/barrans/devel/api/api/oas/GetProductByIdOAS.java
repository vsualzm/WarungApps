package barrans.devel.api.api.oas;

import barrans.devel.api.model.Product;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

public class GetProductByIdOAS {
    @Schema(name = "GetProductByIdOAS.Response")
    public class Response {
        public Product dataProduct;
    }

    @Schema(name = "GetProductByIdOAS.BadRequest")
    public class BadRequest {
        @Schema(example = "Bad Request", enumeration = {"BAD_REQUEST"})
        public String message;
    }

}
