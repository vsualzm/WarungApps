package barrans.devel.api.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;

@Entity
@Table(name = "table_transaction", indexes = {
        @Index(name = "idx_transaction",columnList = "total_price,discount,cash,change")
})
public class Transaction extends PanacheEntityBase {
    @Id
    @SequenceGenerator(
            name = "transactionsequence",
            sequenceName = "transaction_id_sequence",
            allocationSize = 1,
            initialValue = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "transactionSequence")
    @Column(name = "id",nullable = false)
    public Long id;


}
