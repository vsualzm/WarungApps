package barrans.devel.api.api.oas;


import barrans.devel.api.api.dto.UserDTO;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

public class AddUserOAS {
    @Schema(name = "AddUserOAS.Request")
    public class Request extends UserDTO {
    }

    @Schema(name = "AddUserOAS.Response")
    public class Response {
    }

    @Schema(name = "AddUserOAS.BadRequest")
    public class BadRequest {
        @Schema(example = "Bad Request", enumeration = {"BAD_REQUEST"})
        public String message;
    }

}
