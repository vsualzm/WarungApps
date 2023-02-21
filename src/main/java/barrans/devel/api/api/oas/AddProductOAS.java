package barrans.devel.api.api.oas;

import barrans.devel.api.api.dto.ProductDTO;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

public class AddProductOAS {
    @Schema(name = "AddProductOAS.Request")
    public class Request extends ProductDTO {
    }

    @Schema(name = "AddProductOAS.Response")
    public class Response {
    }

    @Schema(name = "AddProductOAS.BadRequest")
    public class BadRequest {
        @Schema(example = "Bad Request", enumeration = {"BAD_REQUEST"})
        public String message;
    }
}
