package barrans.devel.api.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "product", indexes = {
        @Index(name = "idx_product", columnList = "barcode")
}, uniqueConstraints = {
        @UniqueConstraint(name = "unique_barcode", columnNames = {"barcode"})

})
public class Product {
    @Id
    @SequenceGenerator(
            name = "productSequence",
            sequenceName = "product_id_sequence",
            allocationSize = 1,
            initialValue = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "productSequence"
    )
    @Column(name = "id", nullable = false)
    public Long id;


    @NotNull
    @Size(min = 3,max = 50)
    @Column(name = "barcode")
    public Integer barcode;


    @NotNull
    @Size(min = 3,max = 50)
    @Column(name = "product_name")
    public String productName;

    @NotNull
    @Size(min = 3,max = 50)
    @Column(name = "description")
    public String description;


    @NotNull
    @Column(name = "price")
    public Integer price;

    @OneToOne
    ProductUnit productUnit;

    @NotNull
    @Size(min = 3,max = 50)
    @Column(name = "image")
    public String image;



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
