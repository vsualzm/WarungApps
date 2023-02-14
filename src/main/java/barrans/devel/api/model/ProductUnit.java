package barrans.devel.api.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;


@Entity
@Table(name = "product_unit")
public class ProductUnit extends PanacheEntityBase {

    @Id
    @SequenceGenerator(
            name = "product_unitSequence",
            sequenceName = "product_unit_id_sequence",
            allocationSize = 1,
            initialValue = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_unitSequence"
    )
    @Column(name = "id", nullable = false)
    public Long id;

    @NotNull
    @Size(min = 2,max = 10)
    @Column(name = "description")
    public String description;


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
