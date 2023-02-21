package barrans.devel.api.api.oas;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

public class DeleteProductOAS {

    @Schema(name = "DeleteProductOAS.Response")
    public class Response {
    }

    @Schema(name = "DeleteProductOAS.BadRequest")
    public class BadRequest {
        @Schema(example = "Bad Request", enumeration = {"BAD_REQUEST","DATA_NOT_FOUND"})
        public String message;
    }
}
