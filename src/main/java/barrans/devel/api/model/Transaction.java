package barrans.devel.api.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "transaction")
public class Transaction extends PanacheEntityBase {
    @Id
    @SequenceGenerator(
            name = "transactionsequence",
            sequenceName = "transaction_id_sequence",
            allocationSize = 1,
            initialValue = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transactionSequence")
    @Column(name = "transaction_id", nullable = false)
    public Long id;

    @CreationTimestamp
    @Column(name = "transaction_date", nullable = false)
    public Date transaction_date;

    @Column(name = "total_price")
    public Integer total_price;

    @Column(name = "discount")
    public Integer discount;

    @Column(name = "cash", nullable = false)
    public Integer cash;

    @Column(name = "change")
    public Integer change;

    @Column(name = "status", nullable = false)
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
