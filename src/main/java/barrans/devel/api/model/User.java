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
@Table(name = "users", indexes = {
        @Index(name = "user_id", columnList = "email, mobile_phone_number")},
        uniqueConstraints = {
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
    @Column(name = "user_id", nullable = false)
    public Integer id;

    @NotNull
    @Size(min = 3)
    @Column(length = 50)
    public String name;

    @NotNull
    @Size(min = 3)
    @Column(name = "birth_place", length = 30)
    public String birthPlace;

    @NotNull
    @Column(name = "birth_date")
    public Date birthDate;

    @NotNull
    @Email
    @Size(min = 3)
    @Column(length = 50)
    public String email;

    @NotNull
    @Column(length = 50, columnDefinition = "varchar(50) default 'rahasia345'")
    public String password;

    @NotNull
    @Column(length = 1)
    public Integer role_id;

    @NotNull
    @Column(length = 1, name = "status")
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
