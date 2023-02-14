package barrans.devel.api.api.oas;

import barrans.devel.api.api.dto.UserDTO;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

public class UpdateProductUnitOAS {
    @Schema(name = "UpdateProductUnitOAS.Request")
    public class Request extends UserDTO {
    }

    @Schema(name = "UpdateProductUnitOAS.Response")
    public class Response {
    }

    @Schema(name = "UpdateProductUnitOAS.BadRequest")
    public class BadRequest {
        @Schema(example = "Bad Request", enumeration = {"BAD_REQUEST", "DATA_NOT_FOUND"})
        public String message;
    }
}
