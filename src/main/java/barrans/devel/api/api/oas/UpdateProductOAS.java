package barrans.devel.api.api.oas;

import barrans.devel.api.api.dto.ProductDTO;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

public class UpdateProductOAS {

    @Schema(name = "UpdateProducttOAS.Request")
    public class Request extends ProductDTO {
    }

    @Schema(name = "UpdateProductOAS.Response")
    public class Response {
    }

    @Schema(name = "UpdateProductOAS.BadRequest")
    public class BadRequest {
        @Schema(example = "Bad Request", enumeration = {"BAD_REQUEST", "DATA_NOT_FOUND"})
        public String message;
    }
}
