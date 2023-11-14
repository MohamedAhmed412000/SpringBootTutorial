package spring.boot.tutorial.demo.customer;

// import java.util.Collections;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    public default List<Customer> getCustomers() {
        return this.findAll();
    }
        
}
