package barrans.devel.api.api.oas;

import barrans.devel.api.api.dto.ProductUnitDTO;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

public class AddProductUnitOAS {

    @Schema(name = "AddProductUnitOAS.Request")
    public class Request extends ProductUnitDTO {
    }

    @Schema(name = "AddProductUnitOAS.Response")
    public class Response {
    }

    @Schema(name = "AddProductUnitOAS.BadRequest")
    public class BadRequest {
        @Schema(example = "Bad Request", enumeration = {"BAD_REQUEST"})
        public String message;
    }
}
