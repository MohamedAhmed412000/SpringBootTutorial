package spring.boot.tutorial.demo.Card;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import spring.boot.tutorial.demo.customer.Customer;

@Entity(name = "CustomerIdCard")
@Table(
    name = "cutomer_id_card",
    uniqueConstraints = {
        @UniqueConstraint(
            columnNames = "card_number", 
            name = "customer_card_id_unique"
        )
    }
)
public class CustomerIdCard {
    @Id
    @SequenceGenerator(
        name = "customer_card_sequence", 
        sequenceName = "customer_card_sequence",
        allocationSize = 1,
        initialValue = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE, 
        generator = "customer_card_sequence"
    )
    @Column(name = "id", updatable = false)
    private Long id;
    
    @Column(
        name = "card_number",
        nullable = true,
        length = 15
    )
    private String cardNumber;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(
        name = "customer_id",
        referencedColumnName = "id"
    )
    private Customer customer;

    public CustomerIdCard() {
    }

    public CustomerIdCard(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Long getId() {
        return id;
    }

    public String getCardNumber() {
        return cardNumber;
    }


    
}
