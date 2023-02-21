package barrans.devel.api.api.oas;


import barrans.devel.api.model.Product;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.util.List;

public class GetListProductOAS {
    @Schema(name = "GetListProductOAS.Response")
    public class Response {
        List<Product> dataProduct;
    }

    @Schema(name = "GetListProductOAS.BadRequest")
    public class BadRequest {
        @Schema(example = "Bad Request", enumeration = {"BAD_REQUEST"})
        public String message;
    }
}
