package barrans.devel.api.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "transdetail")
public class TransactionDetail extends PanacheEntityBase {
    @Id
    @SequenceGenerator(
            name = "transdetailsequence",
            sequenceName = "transdetail_id_sequence",
            allocationSize = 1,
            initialValue = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "transdetailSequence")
    @Column(name = "id", nullable = false)
    public Long id;

    @ManyToOne
    public Product product;

    @Column(name = "product_name",nullable = false)
    public Character product_name;

    @Column(name = "price",nullable = false)
    public Integer price;

    @OneToOne
    public Transaction transaction_id;

    @Column(name = "status")
    public Integer status;

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
