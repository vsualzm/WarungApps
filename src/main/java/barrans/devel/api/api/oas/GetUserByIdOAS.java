package barrans.devel.api.api.oas;

import barrans.devel.api.model.User;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.util.List;

public class GetUserByIdOAS {
    @Schema(name = "GetUserByIdOAS.Response")
    public class Response {
        public User data;
    }

    @Schema(name = "GetUserByIdOAS.BadRequest")
    public class BadRequest {
        @Schema(example = "Bad Request", enumeration = {"BAD_REQUEST"})
        public String message;
    }
}
