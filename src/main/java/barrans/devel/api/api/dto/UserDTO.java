package barrans.devel.api.api.dto;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class UserDTO {

    @Schema(required = true, example = "john doe")
    public String username;

    @Schema(required = true, example = "johndoe@gmail.com")
    public String email;

    @Schema(required = true, example = "082115294399")
    public String mobile_phone_number;

}
