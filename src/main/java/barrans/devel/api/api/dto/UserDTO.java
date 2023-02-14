package barrans.devel.api.api.dto;

import io.quarkus.runtime.annotations.RegisterForReflection;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;


@RegisterForReflection
public class UserDTO {
    private final Integer id;

    private final String name;

    private final Date birthDate;

    private final String email;

    public UserDTO(Integer id, String name, Date birthDate, String email) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public String getEmail() {
        return email;
    }
}
