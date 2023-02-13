package barrans.devel.api.api.oas;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

public class DeleteUserOAS {
    @Schema(name = "DeleteUserOAS.Response")
    public class Response {
    }

    @Schema(name = "DeleteUserOAS.BadRequest")
    public class BadRequest {
        @Schema(example = "Bad Request", enumeration = {"BAD_REQUEST","DATA_NOT_FOUND"})
        public String message;
    }
}
