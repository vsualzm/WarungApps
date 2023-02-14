package barrans.devel.api.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "inventory")
public class Inventory {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "inventorySequence")
    @SequenceGenerator(
            name = "inventorySequence",
            sequenceName = "inventory_sequence",
            initialValue = 1,
            allocationSize = 1
    )
    public Long inventoryId;

    @NotNull
    @Column(name = "product_id")
    public Long productId;

    @Column(name = "product_stock")
    public Long productStock;

    @NotNull
    @Column(name = "product_quantity")
    public Long productQuantity;

    @Column(name = "product_stock")
    public Long totalProductStock;

    @NotNull
    @Column(name = "purchase_date")
    public Date purchaseDate;

    @NotNull
    @Column(name = "purchase_price")
    public Long purchasePrice;

    @NotNull
    public int status;

    @NotNull
    @Column(name = "created_by")
    public int createdBy;

    @CreationTimestamp
    @Column(name = "created_date", nullable = false)
    public Date createdDate;

    @NotNull
    @Column(name = "update_by")
    public int updateBy;

    @UpdateTimestamp
    @Column(name = "update_date", nullable = false)
    public Date updateDate;

}
