package barrans.devel.api.api.oas;

import barrans.devel.api.model.User;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.util.List;

public class GetListUserOAS {

    @Schema(name = "GetListUserOAS.Response")
    public class Response {
        List<User> data;
    }

    @Schema(name = "GetListUserOAS.BadRequest")
    public class BadRequest {
        @Schema(example = "Bad Request", enumeration = {"BAD_REQUEST"})
        public String message;
    }
}
