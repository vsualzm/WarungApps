package barrans.devel.api.api.dto;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

public class LoginDTO {
    @Schema(required = true, example = "johndoe@gmail.com")
    public String email;

    @Schema(required = true, hidden = true)
    public String password;

}
