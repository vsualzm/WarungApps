package barrans.devel.api.model;



import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "table_user", indexes = {
        @Index(name = "idx_user", columnList = "email, mobile_phone_number")
}, uniqueConstraints = {
        @UniqueConstraint(name = "unique_mobile_phone_number", columnNames = {"mobile_phone_number"}),
        @UniqueConstraint(name = "unique_email", columnNames = {"email"})

})
public class User extends PanacheEntityBase {

    @Id
    @SequenceGenerator(
            name = "userSequence",
            sequenceName = "user_id_sequence",
            allocationSize = 1,
            initialValue = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "userSequence"
    )
    @Column(name = "id", nullable = false)
    public Long id;

    @NotNull
    @Size(min = 3,max = 100)
    public String username;

    @NotNull
    @Size(min = 3,max = 100)
    @Email
    public String email;

    @NotNull
    public String mobile_phone_number;

    @Column(name = "status")
    public int status;

    @CreationTimestamp
    @Column(name = "created_date", nullable = false)
    public Date createdDate;

    @Column(name = "created_by")
    public String createdBy;

    @Column(name = "updated_by")
    public String updatedBy;

    @UpdateTimestamp
    @Column(name = "updated_date")
    public Date updatedDate;
}
